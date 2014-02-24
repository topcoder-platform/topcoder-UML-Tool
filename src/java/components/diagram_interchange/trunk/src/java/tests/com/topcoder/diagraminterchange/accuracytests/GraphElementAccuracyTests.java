/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ GraphElementAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.DiagramLink;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Collection;
import java.util.List;


/**
 * <p>
 * The <code>GraphElement</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>GraphElement</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class GraphElementAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>GraphElement</code> used for tests.
     * </p>
     */
    private GraphElement test = null;

    /**
     * <p>
     * Test suite of <code>GraphElementAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>GraphElementAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(GraphElementAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats a new instance of <code>GraphElement</code>.
     * </p>
     */
    protected void setUp() {
        test = new GraphElementDefaultImpl();
    }

    /**
     * <p>
     * Accuracy Test of the <code>GraphElement()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.",
            new GraphElementDefaultImpl());

        // get the original value of position to check the constructor
        assertNull("The position expected to be null", test.getPosition());

        // get the original value of semanticModel to check the constructor
        assertNull("The semanticModel expected to be null",
            test.getSemanticModel());

        // get the original value of links to check the constructor
        assertEquals("The links expected to be empty", 0, test.countLinks());

        // get the original value of anchorages to check the constructor
        assertEquals("The anchorages expected to be empty", 0,
            test.countAnchorages());

        // get the original value of containeds to check the constructor
        assertEquals("The containeds expected to be empty", 0,
            test.countContaineds());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setPosition(Point)</code> method and
     * <code>getPosition()</code>.
     * </p>
     */
    public void testPosition_Operation() {
        // creat a new point.
        Point point = new Point();

        // set the position.
        test.setPosition(point);

        // get the position.
        assertEquals("The position expected to be equal", point,
            test.getPosition());

        // set the position to null.
        test.setPosition(null);
        assertNull("The position expected to be null", test.getPosition());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setSemanticModel(SemanticModelBridge)</code> method and
     * <code>getSemanticModel()</code>.
     * </p>
     */
    public void testSemanticModel_Operation() {
        // creat a new point.
        SemanticModelBridge semanticModel = new Uml1SemanticModelBridge();

        // set the semanticModel.
        test.setSemanticModel(semanticModel);

        // get the semanticModel.
        assertEquals("The semanticModel expected to be equal", semanticModel,
            test.getSemanticModel());

        // set the semanticModel to null.
        test.setSemanticModel(null);
        assertNull("The semanticModel expected to be null",
            test.getSemanticModel());
    }

    /**
     * <p>
     * Accuracy Test of the containeds correlative method, such like :
     * <code>addContained(GraphConnector)</code> method, <code>getContaineds()</code> and also other method.
     * </p>
     */
    public void testContaineds_Operation() {
        // creat some containeds.
        DiagramElement contained1 = new GraphEdge();
        DiagramElement contained2 = new GraphEdge();
        DiagramElement contained3 = new GraphEdge();

        // add the containeds to the list.
        test.addContained(contained1);
        test.addContained(1, contained2);

        // get the index of the contained.
        assertEquals("The contained1 expected to at index 0", 0,
            test.indexOfContained(contained1));

        // check for contain.
        assertTrue("The contained2 expected to be in the list",
            test.containsContained(contained2));

        // set the contained to the list.
        test.setContained(0, contained3);

        // get the index of the contained.
        assertEquals("The contained3 expected to at index 0", 0,
            test.indexOfContained(contained3));

        // get a copy of the containeds list.
        List<DiagramElement> newContaineds = test.getContaineds();

        // get the elements of containeds list to test.
        assertEquals("The containeds list expected to be 2 element", 2,
            newContaineds.size());
        assertTrue("The contained3 expected to be in the list",
            newContaineds.contains(contained3));

        // clear the new list.
        newContaineds.clear();

        // still two elements in containeds list.
        assertEquals("The containeds list expected to be 2 element", 2,
            test.countContaineds());

        // check the removed contained.
        assertEquals("The two containeds expected to be equal", contained2,
            test.removeContained(1));
        assertTrue("The contained3 expected to be removed",
            test.removeContained(contained3));

        // non exist element can not be removed.
        assertFalse("The contained2 can not be removed again",
            test.removeContained(contained2));

        // add the containeds to the list.
        test.addContained(contained1);
        test.clearContaineds();
        assertEquals("The containeds list expected to be empty", 0,
            test.countContaineds());
    }

    /**
     * <p>
     * Accuracy Test of the wayanchorages correlative method, such like :
     * <code>addAnchorage(GraphConnector)</code> method, <code>getAnchorages()</code> and also other method.
     * </p>
     */
    public void testAnchorages_Operation() {
        // creat some anchorages.
        GraphConnector anchorage1 = new GraphConnector();
        GraphConnector anchorage2 = new GraphConnector();
        GraphConnector anchorage3 = new GraphConnector();

        // add the anchorages to the list.
        test.addAnchorage(anchorage1);
        test.addAnchorage(1, anchorage2);

        // get the index of the anchorage.
        assertEquals("The anchorage1 expected to at index 0", 0,
            test.indexOfAnchorage(anchorage1));

        // check for contain.
        assertTrue("The anchorage2 expected to be in the list",
            test.containsAnchorage(anchorage2));

        // set the anchorage to the list.
        test.setAnchorage(0, anchorage3);

        // get the index of the anchorage.
        assertEquals("The anchorage3 expected to at index 0", 0,
            test.indexOfAnchorage(anchorage3));

        // get a copy of the anchorages list.
        List<GraphConnector> newAnchorages = test.getAnchorages();

        // get the elements of anchorages list to test.
        assertEquals("The anchorages list expected to be 2 element", 2,
            newAnchorages.size());
        assertTrue("The anchorage3 expected to be in the list",
            newAnchorages.contains(anchorage3));

        // clear the new list.
        newAnchorages.clear();

        // still two elements in anchorages list.
        assertEquals("The anchorages list expected to be 2 element", 2,
            test.countAnchorages());

        // check the removed anchorage.
        assertEquals("The two anchorages expected to be equal", anchorage2,
            test.removeAnchorage(1));
        assertTrue("The anchorage3 expected to be removed",
            test.removeAnchorage(anchorage3));

        // non exist element can not be removed.
        assertFalse("The anchorage2 can not be removed again",
            test.removeAnchorage(anchorage2));

        // add the anchorages to the list.
        test.addAnchorage(anchorage1);
        test.clearAnchorages();
        assertEquals("The anchorages list expected to be empty", 0,
            test.countAnchorages());
    }

    /**
     * <p>
     * Accuracy Test of the links correlative method, such like :
     * <code>addLink(Link)</code> method, <code>getLinks()</code> and also other method.
     * </p>
     */
    public void testLinks_Operation() {
        // creat some new Links.
        DiagramLink link = new DiagramLink();
        DiagramLink link2 = new DiagramLink();

        // add the link.
        test.addLink(link);

        // get the elements of links collection to test.
        assertEquals("The links collection expected to be 1 element", 1,
            test.countLinks());
        assertTrue("The links expected to be in the collection",
            test.containsLink(link));

        // get a copy of the collection.
        Collection<DiagramLink> newLinks = test.getLinks();

        // get the elements of links collection to test.
        assertEquals("The links collection expected to be 1 element", 1,
            newLinks.size());
        assertTrue("The link expected to be in the collection",
            newLinks.contains(link));

        // clear the new collection.
        newLinks.clear();

        // still one element in links collection.
        assertEquals("The links collection expected to be 1 element", 1,
            test.countLinks());

        // non exist eiement can not be removed.
        assertFalse("The links can not be removed", test.removeLink(link2));
        assertTrue("The links expected to be removed", test.removeLink(link));

        // add the link then clear it.
        test.addLink(link);
        test.clearLinks();

        // get the elements of links collection to test.
        assertEquals("The links collection expected to be empty", 0,
            test.countLinks());
    }

    /**
     * <p>
     * A inner class which extends the <code>GraphElement</code> class, used for
     * accuracy test only.
     * </p>
     */
    class GraphElementDefaultImpl extends GraphElement {
        // use default constructor.
    }
}
