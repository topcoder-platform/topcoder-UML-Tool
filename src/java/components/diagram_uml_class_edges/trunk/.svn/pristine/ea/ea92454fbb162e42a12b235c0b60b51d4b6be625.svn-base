/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import javax.swing.JFrame;
import java.awt.Point;
import java.util.Collection;
import java.util.ArrayList;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.MultiplicityRangeImpl;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test case for <code>Utils</code>.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class UtilsUnitTests extends TestCase {

    /**
     * <p>
     * Failure test of method <code>checkObjectNotNull(Object, String)</code>.
     * With null object to check.
     * Should throw IllegalArgumentException.
     * </p>
     */
    public void testCheckObjectNotNull_Failure() {
        try {
            Utils.checkObjectNotNull(null, "some name");
            fail("Should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Accuracy test of method <code>checkObjectNotNull(Object, String)</code>.
     * With valid object to check.
     * Should pass the check.
     * </p>
     */
    public void testCheckObjectNotNull_Accuracy() {
        Utils.checkObjectNotNull(new Object(), "some name");
        // pass
    }

    /**
     * <p>
     * Accuracy test of method <code>retrieveStereotypeText(Collection)</code>.
     * With null collection.
     * Should return empty string.
     * </p>
     */
    public void testRetrieveStereotypeText_Null() {
        assertEquals("Should return empty string.", "", Utils.retrieveStereotypeText(null));
    }

    /**
     * <p>
     * Accuracy test of method <code>retrieveStereotypeText(Collection)</code>.
     * With empty collection.
     * Should return empty string.
     * </p>
     */
    public void testRetrieveStereotypeText_Empty() {
        Collection<Stereotype> collections = new ArrayList<Stereotype>();
        assertEquals("Should return empty string.", "", Utils.retrieveStereotypeText(collections));
    }

    /**
     * <p>
     * Accuracy test of method <code>retrieveStereotypeText(Collection)</code>.
     * With not empty collection.
     * Should return the proper string.
     * </p>
     */
    public void testRetrieveStereotypeText_Accuracy_1() {
        String expected = "<<create>>";
        Collection<Stereotype> collections = new ArrayList<Stereotype>();
        Stereotype item1 = new StereotypeImpl();
        item1.setName("create");
        collections.add(item1);

        assertEquals("Should return the proper string.", expected, Utils.retrieveStereotypeText(collections));
    }

    /**
     * <p>
     * Accuracy test of method <code>retrieveStereotypeText(Collection)</code>.
     * With not empty collection.
     * Should return the proper string.
     * </p>
     */
    public void testRetrieveStereotypeText_Accuracy_2() {
        String expected = "<<create, use>>";
        Collection<Stereotype> collections = new ArrayList<Stereotype>();
        Stereotype item1 = new StereotypeImpl();
        item1.setName("create");
        collections.add(item1);
        Stereotype item2 = new StereotypeImpl();
        item2.setName("use");
        collections.add(item2);

        assertEquals("Should return the proper string.", expected, Utils.retrieveStereotypeText(collections));
    }

    /**
     * <p>
     * Accuracy test of method <code>updateActiveEdgeEnding(ActiveEdgeEnding, AssociationEnd)</code>.
     * Should update the name/multiplicity text of ActiveEdgeEnding compartments.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testUpdateActiveEdgeEnding_Accuracy() throws Exception {
        GraphEdge graphEdge = UnitTestsHelper.createGraphEdgeForAssociationEdge();
        AssociationEdge edge = new AssociationEdge(graphEdge);

        ActiveEdgeEnding edgeEnding = (ActiveEdgeEnding) edge.getLeftEnding();
        String nameText = "association end";
        String multiplicityText = "1..10";

        //Create a AssociationEnd
        AssociationEnd associationEnd = new AssociationEndImpl();
        associationEnd.setName(nameText);
        MultiplicityRange range = new MultiplicityRangeImpl();
        range.setLower(1);
        range.setUpper(10);
        Multiplicity multiplicity = new MultiplicityImpl();
        multiplicity.addRange(range);
        associationEnd.setMultiplicity(multiplicity);

        //Update
        Utils.updateActiveEdgeEnding(edgeEnding, associationEnd);

        //Check
        assertEquals(nameText, edgeEnding.getNameCompartment().getText());
        assertEquals(multiplicityText, edgeEnding.getMultiplicityCompartment().getText());
    }

    /**
     * <p>
     * Accuracy test of method <code>containsInArrow(int, int, double, Point, int, int)</code>.
     * With the three vertex of triangle.
     * Should return true.
     * </p>
     */
    public void testContainsInArrow_Vertex() {
        double angle = Math.toRadians(90);
        Point endingPoint = new Point(20, 20);
        int arrowLength = 10;
        int k = 0;

        assertTrue("Should return true.", Utils.containsInArrow(20, 20, angle, endingPoint, arrowLength, k));
        assertTrue("Should return true.", Utils.containsInArrow(10, 10, angle, endingPoint, arrowLength, k));
        assertTrue("Should return true.", Utils.containsInArrow(30, 10, angle, endingPoint, arrowLength, k));
    }

    /**
     * <p>
     * Accuracy test of method <code>containsInArrow(int, int, double, Point, int, int)</code>.
     * With points in bound.
     * Should return true.
     * </p>
     */
    public void testContainsInArrow_InBound() {
        double angle = Math.toRadians(90);
        Point endingPoint = new Point(20, 20);
        int arrowLength = 10;
        int k = 0;

        assertTrue("Should return true.", Utils.containsInArrow(20, 10, angle, endingPoint, arrowLength, k));
        assertTrue("Should return true.", Utils.containsInArrow(15, 15, angle, endingPoint, arrowLength, k));
        assertTrue("Should return true.", Utils.containsInArrow(25, 15, angle, endingPoint, arrowLength, k));
    }

    /**
     * <p>
     * Accuracy test of method <code>containsInArrow(int, int, double, Point, int, int)</code>.
     * With points in side.
     * Should return true.
     * </p>
     */
    public void testContainsInArrow_InSide() {
        double angle = Math.toRadians(90);
        Point endingPoint = new Point(20, 20);
        int arrowLength = 10;
        int k = 0;

        assertTrue("Should return true.", Utils.containsInArrow(20, 15, angle, endingPoint, arrowLength, k));
    }

    /**
     * <p>
     * Accuracy test of method <code>containsInArrow(int, int, double, Point, int, int)</code>.
     * With point not contains in.
     * Should return false.
     * </p>
     */
    public void testContainsInArrow_Out() {
        double angle = Math.toRadians(90);
        Point endingPoint = new Point(20, 20);
        int arrowLength = 10;
        int k = 0;

        assertFalse("Should return false.", Utils.containsInArrow(15, 16, angle, endingPoint, arrowLength, k));
        assertFalse("Should return false.", Utils.containsInArrow(20, 22, angle, endingPoint, arrowLength, k));
        assertFalse("Should return false.", Utils.containsInArrow(18, 8, angle, endingPoint, arrowLength, k));
        assertFalse("Should return false.", Utils.containsInArrow(25, 18, angle, endingPoint, arrowLength, k));
    }

    /**
     * <p>
     * Accuracy test of method <code>containsInDiamond(int, int, double, Point, int)</code>.
     * With the three vertex of triangle.
     * Should return true.
     * </p>
     */
    public void testContainsInDiamond_Vertex() {
        double angle = 0;
        Point endingPoint = new Point(20, 20);
        int arrowLength = 10;

        assertTrue("Should return true.", Utils.containsInDiamond(20, 20, angle, endingPoint, arrowLength));
        assertTrue("Should return true.", Utils.containsInDiamond(10, 30, angle, endingPoint, arrowLength));
        assertTrue("Should return true.", Utils.containsInDiamond(0, 20, angle, endingPoint, arrowLength));
        assertTrue("Should return true.", Utils.containsInDiamond(10, 10, angle, endingPoint, arrowLength));
    }

    /**
     * <p>
     * Accuracy test of method <code>containsInDiamond(int, int, double, Point, int)</code>.
     * With points in bound.
     * Should return true.
     * </p>
     */
    public void testContainsInDiamond_InBound() {
        double angle = 0;
        Point endingPoint = new Point(20, 20);
        int arrowLength = 10;

        assertTrue("Should return true.", Utils.containsInDiamond(5, 15, angle, endingPoint, arrowLength));
        assertTrue("Should return true.", Utils.containsInDiamond(5, 25, angle, endingPoint, arrowLength));
        assertTrue("Should return true.", Utils.containsInDiamond(15, 15, angle, endingPoint, arrowLength));
        assertTrue("Should return true.", Utils.containsInDiamond(15, 25, angle, endingPoint, arrowLength));
    }

    /**
     * <p>
     * Accuracy test of method <code>containsInDiamond(int, int, double, Point, int)</code>.
     * With points in side.
     * Should return true.
     * </p>
     */
    public void testContainsInDiamond_InSide() {
        double angle = 0;
        Point endingPoint = new Point(20, 20);
        int arrowLength = 10;

        assertTrue("Should return true.", Utils.containsInDiamond(10, 20, angle, endingPoint, arrowLength));
    }

    /**
     * <p>
     * Accuracy test of method <code>containsInDiamond(int, int, double, Point, int)</code>.
     * With point not contains in.
     * Should return false.
     * </p>
     */
    public void testContainsInDiamond_Out() {
        double angle = 0;
        Point endingPoint = new Point(20, 20);
        int arrowLength = 10;

        assertFalse("Should return false.", Utils.containsInDiamond(0, 18, angle, endingPoint, arrowLength));
        assertFalse("Should return false.", Utils.containsInDiamond(0, 22, angle, endingPoint, arrowLength));
        assertFalse("Should return false.", Utils.containsInDiamond(18, 28, angle, endingPoint, arrowLength));
        assertFalse("Should return false.", Utils.containsInDiamond(15, 12, angle, endingPoint, arrowLength));
    }

}
