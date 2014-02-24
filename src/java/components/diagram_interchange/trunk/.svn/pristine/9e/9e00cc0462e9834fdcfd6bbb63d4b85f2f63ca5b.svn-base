/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ DiagramAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramLink;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Collection;


/**
 * <p>
 * The <code>Diagram</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>Diagram</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class DiagramAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>Diagram</code> used for tests.
     * </p>
     */
    private Diagram test = null;

    /**
     * <p>
     * Test suite of <code>DiagramAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>DiagramAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(DiagramAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new Diagram();
    }

    /**
     * <p>
     * Accuracy Test of the <code>Diagram()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new Diagram());

        // get the original value of scale factor to check the constructor
        assertEquals("The scale factor expected to be 0.0", 0.0, test.getZoom());

        // get the original value of name to check the constructor
        assertNull("The name expected to be null", test.getName());

        // get the original value of viewport to check the constructor
        assertNull("The viewport expected to be null", test.getViewport());

        // get the original value of owner to check the constructor
        assertNull("The owner expected to be null", test.getOwner());

        // get the original value of links collection to check the constructor
        assertEquals("The links collection expected to be empty", 0,
            test.countDiagramLinks());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setZoom(double)</code> method and
     * <code>getZoom()</code>.
     * </p>
     */
    public void testZoom_Operation() {
        // set the scale factor.
        test.setZoom(5.67);

        // get the scale factor.
        assertEquals("The height expected to be equal", 5.67, test.getZoom());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setName(String)</code> method and
     * <code>getName()</code>.
     * </p>
     */
    public void testName_Operation() {
        // set the name.
        test.setName("Top Coder");

        // get the name.
        assertEquals("The name expected to be equal", "Top Coder",
            test.getName());

        // set the name to null.
        test.setName(null);
        assertNull("The name expected to be null", test.getName());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setViewport(Point)</code> method and
     * <code>getViewport()</code>.
     * </p>
     */
    public void testViewport_Operation() {
        // creat a new point.
        Point point = new Point();

        // set the viewport.
        test.setViewport(point);

        // get the viewport.
        assertEquals("The viewport expected to be equal", point,
            test.getViewport());

        // set the viewport to null.
        test.setViewport(null);
        assertNull("The viewport expected to be null", test.getViewport());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setOwner(SemanticModelBridge)</code> method and
     * <code>getOwner()</code>.
     * </p>
     */
    public void testOwner_Operation() {
        // creat a new SemanticModelBridge.
        SemanticModelBridge owner = new Uml1SemanticModelBridge();

        // set the owner.
        test.setOwner(owner);

        // get the owner.
        assertEquals("The owner expected to be equal", owner, test.getOwner());

        // set the owner to null.
        test.setOwner(null);
        assertNull("The owner expected to be null", test.getOwner());
    }

    /**
     * <p>
     * Accuracy Test of the diagramLinks correlative method, such like :
     * <code>addDiagramLink(DiagramLink)</code> method, <code>getDiagramLinks()</code> and also other method.
     * </p>
     */
    public void testDiagramLinks_Operation() {
        // creat some new DiagramLinks.
        DiagramLink link = new DiagramLink();
        DiagramLink link2 = new DiagramLink();

        // add the link.
        test.addDiagramLink(link);

        // get the elements of links collection to test.
        assertEquals("The links collection expected to be 1 element", 1,
            test.countDiagramLinks());
        assertTrue("The links expected to be in the collection",
            test.containsDiagramLink(link));

        // get a copy of the collection.
        Collection<DiagramLink> newLinks = test.getDiagramLinks();

        // get the elements of links collection to test.
        assertEquals("The links collection expected to be 1 element", 1,
            newLinks.size());
        assertTrue("The link expected to be in the collection",
            newLinks.contains(link));

        // clear the new collection.
        newLinks.clear();

        // still one element in links collection.
        assertEquals("The links collection expected to be 1 element", 1,
            test.countDiagramLinks());

        // non exist eiement can not be removed.
        assertFalse("The links can not be removed",
            test.removeDiagramLink(link2));
        assertTrue("The links expected to be removed",
            test.removeDiagramLink(link));

        // add the link then clear it.
        test.addDiagramLink(link);
        test.clearDiagramLinks();

        // get the elements of links collection to test.
        assertEquals("The links collection expected to be empty", 0,
            test.countDiagramLinks());
    }
}
