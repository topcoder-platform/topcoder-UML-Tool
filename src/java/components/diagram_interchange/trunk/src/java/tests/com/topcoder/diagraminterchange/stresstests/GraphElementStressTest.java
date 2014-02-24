/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.stresstests;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.DiagramLink;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Reference;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * <p>This class tests the <code>GraphElement</code> class for stress. This stress tests
 * addresses the functionality provided by the <code>GraphElement</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class GraphElementStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The instance of <code>GraphElement</code> for test.</p>
     */
    private GraphElement element = null;

    /**
     * <p>Return test suite of <code>GraphElementStressTest</code>.</p>
     *
     * @return Test suite of <code>GraphElementStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(GraphElementStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        element = new GraphElement() { };
    }

    /**
     * <p>Basic stress test of <code>addContained()</code>, <code>setContained()</code>,
     * <code>removeContained()</code>, <code>clearContaineds()</code>,
     * <code>getContaineds()</code>, <code>containsContained()</code>,
     * <code>indexOfContained()</code>, <code>countContaineds()</code> methods.</p>
     */
    public void testMethod_Contained() {
        List<DiagramElement> containeds = new ArrayList<DiagramElement>();

        for (int i = 0; i < LOOPTIMES; i++) {
            DiagramElement contained = new GraphNode();
            element.addContained(contained);

            // check the result here.
            assertTrue("The containsContained method is incorrect.",
                element.containsContained(contained));
            assertEquals("The indexOfContained method is incorrect.", i,
                element.indexOfContained(contained));
            assertEquals("The countContaineds method is incorrect.", i + 1,
                element.countContaineds());

            // set a new contained.
            DiagramElement newContained = new Reference();

            element.setContained(i, newContained);
            containeds.add(newContained);

            // check the result here.
            assertFalse("The setContained method is incorrect.",
                element.containsContained(contained));
            assertTrue("The setContained method is incorrect.",
                element.containsContained(newContained));
            assertEquals("The indexOfContained method is incorrect.", i,
                element.indexOfContained(newContained));
            assertEquals("The setContained method is incorrect.", i + 1, element.countContaineds());

            // get all containeds and test it.
            List<DiagramElement> getContaineds = element.getContaineds();
            assertEquals("The getContaineds method is incorrect.", i + 1, getContaineds.size());
            assertTrue("The getContaineds method is incorrect.",
                containeds.containsAll(getContaineds));
        }

        for (int i = 0; i < (LOOPTIMES / 2); i++) {
            DiagramElement removed = element.removeContained(i);
            assertEquals("The removeContained method is incorrect.", LOOPTIMES - i - 1,
                element.countContaineds());
            assertFalse("The removeContained method is incorrect.",
                element.containsContained(removed));
        }

        element.clearContaineds();
        assertEquals("The clearContaineds method is incorrect.", 0, element.countContaineds());
    }

    /**
     * <p>Basic stress test of <code>addAnchorage()</code>, <code>setAnchorage()</code>,
     * <code>removeAnchorage()</code>, <code>clearAnchorages()</code>,
     * <code>getAnchorages()</code>, <code>containsAnchorage()</code>,
     * <code>indexOfAnchorage()</code>, <code>countAnchorages()</code> methods.</p>
     */
    public void testMethod_Anchorage() {
        List<GraphConnector> anchorages = new ArrayList<GraphConnector>();

        for (int i = 0; i < LOOPTIMES; i++) {
            GraphConnector anchorage = new GraphConnector();
            element.addAnchorage(anchorage);

            // check the result here.
            assertTrue("The containsAnchorage method is incorrect.",
                element.containsAnchorage(anchorage));
            assertEquals("The indexOfAnchorage method is incorrect.", i,
                element.indexOfAnchorage(anchorage));
            assertEquals("The countAnchorages method is incorrect.", i + 1,
                element.countAnchorages());

            // set a new contained.
            GraphConnector newAnchorage = new GraphConnector();

            element.setAnchorage(i, newAnchorage);
            anchorages.add(newAnchorage);

            // check the result here.
            assertFalse("The setAnchorage method is incorrect.",
                element.containsAnchorage(anchorage));
            assertTrue("The setAnchorage method is incorrect.",
                element.containsAnchorage(newAnchorage));
            assertEquals("The indexOfAnchorage method is incorrect.", i,
                element.indexOfAnchorage(newAnchorage));
            assertEquals("The countAnchorages method is incorrect.", i + 1,
                element.countAnchorages());

            // get all anchorages  and test it.
            List<GraphConnector> getAnchorages = element.getAnchorages();
            assertEquals("The getAnchorages method is incorrect.", i + 1, getAnchorages.size());
            assertTrue("The getAnchorages method is incorrect.",
                anchorages.containsAll(getAnchorages));
        }

        for (int i = 0; i < (LOOPTIMES / 2); i++) {
            GraphConnector removed = element.removeAnchorage(i);
            assertEquals("The removeAnchorage method is incorrect.", LOOPTIMES - i - 1,
                element.countAnchorages());
            assertFalse("The removeAnchorage method is incorrect.",
                element.containsAnchorage(removed));
        }

        element.clearAnchorages();
        assertEquals("The clearAnchorages method is incorrect.", 0, element.countAnchorages());
    }

    /**
     * <p>Basic stress test of <code>addLink()</code>, <code>removeLink()</code>,
     * <code>clearLinks()</code>, <code>getLinks()</code>, <code>containsLink()</code>,
     * <code>countLinks()</code> methods.</p>
     */
    public void testMethod_Link() {
        List<DiagramLink> links = new ArrayList<DiagramLink>();

        for (int i = 0; i < LOOPTIMES; i++) {
            DiagramLink link = new DiagramLink();
            element.addLink(link);
            links.add(link);

            // check the control.
            assertTrue("The containsLink method is incorrect.", element.containsLink(link));
            assertEquals("The countLinks method is incorrect.", i + 1, element.countLinks());

            Collection<DiagramLink> getLinks = element.getLinks();
            assertEquals("The getLinks method is incorrect.", i + 1, getLinks.size());
            assertTrue("The getLinks method is incorrect.", links.containsAll(getLinks));
        }

        for (int i = 0; i < (LOOPTIMES / 2); i++) {
            assertTrue("The removeLink method is incorrect.", element.removeLink(links.get(i)));
            assertEquals("The removeLink method is incorrect.", LOOPTIMES - i - 1,
                element.countLinks());
            assertFalse("The removeLink method is incorrect.", element.containsLink(links.get(i)));
        }

        // clear all links and test it.
        element.clearLinks();
        assertEquals("The clearLinks method is incorrect.", 0, element.countLinks());
    }
}
