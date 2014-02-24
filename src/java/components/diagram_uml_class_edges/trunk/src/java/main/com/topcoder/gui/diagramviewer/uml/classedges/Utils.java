/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.Collection;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.VisibilityKind;

/**
 * <p>
 * Helper class for the whole component.
 * </p>
 *
 * <p>
 * <b>Thread safety:</b> this class is immutable so is thread safe.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public final class Utils {

    /** Represent the middle of multiplicity text. */
    private static final String MULTIPLICITY_TEXT_MIDDLE = "  ";

    /** Represent the range characters of multiplicity text. */
    private static final String MULTIPLICITY_TEXT_RANGE = "..";

    /** Represent the prefix of stereotype. */
    private static final String STEREOTYPE_PREFIX = "<<";

    /** Represent the middle of stereotype. */
    private static final String STEREOTYPE_MIDDLE = ", ";

    /** Represent the post-fix of stereotype. */
    private static final String STEREOTYPE_POSTFIX = ">>";
   
    /**
     * <p>
     * Visibility token for public item.
     * </p>
     */
    private static final String VB_PUBLIC = "+";

    /**
     * <p>
     * Visibility token for protected item.
     * </p>
     */
    private static final String VB_PROTECTED = "#";

    /**
     * <p>
     * Visibility token for private item.
     * </p>
     */
    private static final String VB_PRIVATE = "-";

    /**
     * <p>
     * Visibility token for package item.
     * </p>
     */
    private static final String VB_PACKAGE = "~";

    /**
     * <p>
     * Private constructor to prevent instantiation.
     * </p>
     */
    private Utils() {
    }

    /**
     * <p>
     * Check if the object is null.
     * </p>
     *
     * @param obj
     *            the object to check
     * @param name
     *            the object name
     *
     * @throws IllegalArgumentException
     *             if <tt>obj</tt> is null
     */
    public static void checkObjectNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException(name + " is null.");
        }
    }

    /**
     * <p>
     * Updates the <code>TextField</code>'s size, location and visibility according to its <code>GraphNode</code>.
     * </p>
     *
     * @param textField
     *            the <tt>TextField</tt> needs to be updated
     *
     * @throws IllegalGraphElementException
     *             if the <tt>GraphNode</tt> related to this <tt>TextField</tt> is incorrect
     */
    public static void updateTextFieldSizeLocationVisibility(TextField textField) throws IllegalGraphElementException {
        GraphNode graphNode = textField.getGraphNode();

        //Update visibility
        textField.setVisible(graphNode.isVisible());

        if (textField.isVisible()) {
            try {
                Dimension preferredSize = textField.getPreferredSize();
                if (textField.getWidth() < preferredSize.width) {
                    textField.setSize(preferredSize);
                }

            } catch (NullPointerException e) {
                throw new IllegalGraphElementException(graphNode, "The GraphNode of textField is incorrect", e);
            }
        }
    }


    /**
     * <p>
     * Gets the visibility token for given association end.
     * </p>
     */
    private static String getVisibilityToken(AssociationEnd element) {
        VisibilityKind kind = element.getVisibility();
        if (kind == VisibilityKind.PUBLIC) {
            return VB_PUBLIC;
        }
        if (kind == VisibilityKind.PROTECTED) {
            return VB_PROTECTED;
        }
        if (kind == VisibilityKind.PACKAGE) {
            return VB_PACKAGE;
        }
        return VB_PRIVATE;
    }

    /**
     * <p>
     * Update the name and multiplicity compartments' text/visibility/size/location
     * of <code>ActiveEdgeEnding</code> object according to <code>AssociationEnd</code> object.
     * </p>
     *
     * @param edgeEnding
     *            the ActiveEdgeEnding object
     * @param associationEnd
     *            the AssociationEnd object
     *
     * @throws IllegalGraphElementException
     *             if the <tt>GraphNode</tt> related to this <tt>TextField</tt> is incorrect
     */
    public static void updateActiveEdgeEnding(ActiveEdgeEnding edgeEnding, AssociationEnd associationEnd)
        throws IllegalGraphElementException {
        //update name compartment

        /* 
         * BugFix: BUGR-64 
         * Display visibility kind on association ends.
         */
    	 /* 
         * BugFix: BUGR-143
         * Hide visibility if name is empty.
         */
        // old code
        // edgeEnding.getNameCompartment().setText(associationEnd.getName());
	    StringBuffer edgeEndingText = new StringBuffer();
	    if ( associationEnd.getName() != null && associationEnd.getName().trim().length() > 0) {
             edgeEndingText.append(getVisibilityToken(associationEnd));
	         edgeEndingText.append(associationEnd.getName());
  	    }   
        edgeEnding.getNameCompartment().setText(edgeEndingText.toString());
	
        // Bug Fix:
        updateTextFieldSizeLocationVisibility(edgeEnding.getNameCompartment());

        //update multiplicity compartment
        if (associationEnd.getMultiplicity() != null) {
            StringBuffer multiplicityText = new StringBuffer();
            for (MultiplicityRange range : associationEnd.getMultiplicity().getRanges()) {
		
                /* 
                 * BugFix: BUGR-66 
                 * Multiplicities with names of "1..1" should not be shown.
                 */
                if (range.getLower() == 1 && range.getUpper() == 1) {
                    continue;
                }

                /*
                 * BugFix: UML-10094
                 * Replace Integer.MAX_VALUE with '*'
                 */
                // old code
//                multiplicityText.append(range.getLower());
                int lowerBound = range.getLower();
                if (lowerBound != Integer.MAX_VALUE) {
                    multiplicityText.append(lowerBound);
                } else {
                    multiplicityText.append('*');
                }
                multiplicityText.append(MULTIPLICITY_TEXT_RANGE);
                /*
                 * BugFix: UML-10094
                 * Replace Integer.MAX_VALUE with '*'
                 */
                // old code
//                multiplicityText.append(range.getUpper());
                int upperBound = range.getUpper();
                if (upperBound != Integer.MAX_VALUE) {
                    multiplicityText.append(upperBound);
                } else {
                    multiplicityText.append('*');
                }

                multiplicityText.append(MULTIPLICITY_TEXT_MIDDLE);
            }
            if (multiplicityText.length() > 0) {
                multiplicityText.setLength(multiplicityText.length() - 2);
            }
            edgeEnding.getMultiplicityCompartment().setText(multiplicityText.toString());
        }

        // Bug Fix:
        updateTextFieldSizeLocationVisibility(edgeEnding.getMultiplicityCompartment());

    }

    /**
     * <p>
     * Generates a stereotype string according to the given stereotypes. If <code>stereotypes</code> is null or empty,
     * it will be ignored.
     * </p>
     *
     * @param stereotypes
     *            the collection of stereotype
     *
     * @return the stereotype string
     */
    public static String retrieveStereotypeText(Collection<Stereotype> stereotypes) {
        StringBuffer stereotypeText = new StringBuffer(STEREOTYPE_PREFIX);

        if (stereotypes != null) {
            for (Stereotype stereotype : stereotypes) {
                stereotypeText.append(stereotype.getName());
                stereotypeText.append(STEREOTYPE_MIDDLE);
            }
        }

        stereotypeText.setLength(stereotypeText.length() - 2);
        if (stereotypeText.length() > 0) {
            stereotypeText.append(STEREOTYPE_POSTFIX);
        }

        return stereotypeText.toString();
    }

    /**
     * <p>
     * Determine whether the point (x, y) is contains in the triangle arrow specified by angle, ending point and length.
     * </p>
     *
     * @param x
     *            the x-coordinate value
     * @param y
     *            the y-coordinate value
     * @param angle
     *            the angle
     * @param endingPoint
     *            the ending point
     * @param arrowLength
     *            the length
     * @param k
     *            determine the virtual original point
     *
     * @return whether the point is contained.
     */
    public static boolean containsInArrow(int x, int y, double angle, Point endingPoint, int arrowLength, int k) {
        //Compute the new point through transform
        AffineTransform transform = AffineTransform.getRotateInstance(-angle,
                endingPoint.getX(), endingPoint.getY());
        Point ptSrc = new Point(x, y);
        Point ptDst = new Point();
        transform.transform(ptSrc, ptDst);

        //Determine whether the new point is in triangle
        int endX = (int) endingPoint.getX() - k * arrowLength;
        int endY = (int) endingPoint.getY();
        if (ptDst.x == endX) {
            if (ptDst.y == endY) {
                return true;
            }
        } else if ((endX - ptDst.x) <= arrowLength && (endX - ptDst.x) >= 0
                && Math.abs((ptDst.y - endY) * 1.0 / (ptDst.x - endX)) <= 1) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Determine whether the point (x, y) is contains in the diamond specified by angle, ending point and length.
     * </p>
     *
     * @param x
     *            the x-coordinate value
     * @param y
     *            the y-coordinate value
     * @param angle
     *            the angle
     * @param endingPoint
     *            the ending point
     * @param arrowLength
     *            the length
     *
     * @return whether the point is contained.
     */
    public static boolean containsInDiamond(int x, int y, double angle, Point endingPoint, int arrowLength) {
        //Compute the new point through transform
        angle -= Math.toRadians(45);
        AffineTransform transform = AffineTransform.getRotateInstance(-angle,
                endingPoint.getX(), endingPoint.getY());
        Point ptSrc = new Point(x, y);
        Point ptDst = new Point();
        transform.transform(ptSrc, ptDst);

        //Determine whether the new point is in diamond
        double length = arrowLength * Math.sqrt(2.0);
        double lengthX = endingPoint.getX() - ptDst.getX();
        double lengthY = endingPoint.getY() - ptDst.getY();
        if (lengthX > length || lengthX < 0 || lengthY > length || lengthY < 0) {
            return false;
        }
        return true;
    }
}
