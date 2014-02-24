/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_UML_Class_Edges Version 1.0 StressTest.
 *
 * @ StressTestHelper.java
 */
package com.topcoder.gui.diagramviewer.uml.classedges.stresstests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;

import java.awt.geom.AffineTransform;


/**
 * <p>Helper class to simplify the stress testing.</p>
 *
 * @author icyriver
 * @version 1.0
 */
final class StressTestHelper {
    /**
    * <p>The int number represents the length of the diamond.</p>
    */
    private static final double LENGTH = 10.0 * Math.sqrt(2.0);

    /**
     * <p>
     * The private constructor to avoid creating instance of this class.
     * </p>
     */
    private StressTestHelper() {
    }

    /**
     * <p>
     * Gets an instance of <code>Uml1SemanticModelBridge</code> with the given element.
     * </p>
     *
     * @param element the Element used to set the <code>Uml1SemanticModelBridge</code>.
     *
     * @return an instance of <code>Uml1SemanticModelBridge</code> that contains the
     *         given element.
     */
    static Uml1SemanticModelBridge getBridge(Element element) {
        // creat the Uml1SemanticModelBridge.
        Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        bridge.setElement(element);

        return bridge;
    }

    /**
     * <p>
     * Sets the given <code>ModelElement</code> with some required values.
     * </p>
     *
     * @param element the Element used to set the <code>Uml1SemanticModelBridge</code>.
     *
     * @return an instance of <code>Element</code>.
     */
    static ModelElement setEdgeElement(ModelElement element) {
        element.setName("topcoderSoft");

        Stereotype stereotype1 = new StereotypeImpl();
        stereotype1.setName("type1");

        Stereotype stereotype2 = new StereotypeImpl();
        stereotype2.setName("type2");

        element.addStereotype(stereotype1);
        element.addStereotype(stereotype2);

        return element;
    }

    /**
     * <p>Create the instance of <code>Dimension</code>.</p>
     *
     * @param width the width of the<code>Dimension</code>.
     * @param height the height of the<code>Dimension</code>.
     *
     * @return the created instance of the <code>Dimension</code>.
     */
    static Dimension createDimension(double width, double height) {
        Dimension dimension = new Dimension();

        // set the width and height here.
        dimension.setWidth(width);
        dimension.setHeight(height);

        return dimension;
    }

    /**
     * <p>Create the instance of <code>Point</code>.</p>
     *
     * @param x the width of the<code>Point</code>.
     * @param y the height of the<code>Point</code>.
     *
     * @return the created instance of the <code>Point</code>.
     */
    static Point createPoint(double x, double y) {
        Point point = new Point();

        // set the x and y here.
        point.setX(x);
        point.setY(y);

        return point;
    }

    /**
     * <p>
     * Helper method used to check the given point cintains in the arrow or not.
     * </p>
     *
     * @param x the x coordinate value.
     * @param y the y coordinate value.
     * @param endingX the x coordinate value of the ending point.
     * @param endingY the y coordinate value of the ending point.
     * @param angle the specified angle of the arrow.
     * @param excursion the excursion of the arrow.
     *
     * @return true if the point is contained, false otherwise.
     *
     * @throws Exception if if any exception occurs when testing.
     */
    static boolean arrowContains(int x, int y, int endingX, int endingY,
        double angle, int excursion) throws Exception {
        // translate the point
        AffineTransform tx = AffineTransform.getRotateInstance(angle, endingX,
                endingY);
        java.awt.Point ptSrc = new java.awt.Point(x, y);
        java.awt.Point ptDst = new java.awt.Point();
        tx.inverseTransform(ptSrc, ptDst);
        endingX -= excursion;

        if (ptDst.x == endingX) {
            if (ptDst.y == endingY) {
                return true;
            }
        } else if (((endingX - ptDst.x) <= 10) && ((endingX - ptDst.x) >= 0) &&
                (Math.abs(((ptDst.y - endingY) * 1.0) / (ptDst.x - endingX)) <= 1)) {
            return true;
        }

        return false;
    }

    /**
     * <p>
     * Helper method used to check the given point cintains in the diamond or not.
     * </p>
     *
     * @param x the x coordinate value.
     * @param y the y coordinate value.
     * @param endingX the x coordinate value of the ending point.
     * @param endingY the y coordinate value of the ending point.
     * @param angle the specified angle of the arrow.
     *
     * @return true if the point is contained, false otherwise.
     *
     * @throws Exception if if any exception occurs when testing.
     */
    static boolean diamondContains(int x, int y, int endingX, int endingY,
        double angle) throws Exception {
        // rotate the angle.
        angle -= Math.toRadians(45);

        // translate the point
        AffineTransform tx = AffineTransform.getRotateInstance(angle, endingX,
                endingY);
        java.awt.Point ptSrc = new java.awt.Point(x, y);
        java.awt.Point ptDst = new java.awt.Point();
        tx.inverseTransform(ptSrc, ptDst);

        int lengthX = endingX - ptDst.x;
        int lengthY = endingY - ptDst.y;

        if ((lengthX > LENGTH) || (lengthX < 0) || (lengthY > LENGTH) ||
                (lengthY < 0)) {
            return false;
        }

        return true;
    }

    /**
     * <p>
     * Helper method used to check the given boolean for equal.
     * </p>
     *
     * @param a the boolean value will be compared with the other one.
     * @param b the boolean value will be compared with the other one.
     *
     * @return true if both boolean values are equal (both true or false), false otherwise.
     */
    static boolean checkForEqual(boolean a, boolean b) {
        if ((a && b) || (!a && !b)) {
            return true;
        }

        return false;
    }
}
