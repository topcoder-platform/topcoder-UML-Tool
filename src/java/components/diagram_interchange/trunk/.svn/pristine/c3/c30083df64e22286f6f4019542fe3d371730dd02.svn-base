/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.stresstests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramLink;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * <p>This class tests the <code>Diagram</code> class for stress. This stress tests addresses
 * the functionality provided by the <code>Diagram</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class DiagramStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The instance of <code>Diagram</code> for test.</p>
     */
    private Diagram diagram = null;

    /**
     * <p>Return test suite of <code>DiagramStressTest</code>.</p>
     *
     * @return Test suite of <code>DiagramStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(DiagramStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        diagram = new Diagram();
    }

    /**
     * <p>Basic stress test of <code>getXXX()</code> and <code>setXXX()</code> methods.</p>
     */
    public void testMethod_getset() {
        for (int i = 0; i < LOOPTIMES; i++) {
            // test getName and setName methods
            diagram.setName("diagram" + i);
            assertEquals("The getName and setName methods is incorrect.", "diagram" + i,
                diagram.getName());

            // test getZoom and setZoom methods
            diagram.setZoom(0.01 + i);
            assertEquals("The getZoom and setZoom methods is incorrect.", 0.01 + i,
                diagram.getZoom());

            // test getViewport and setViewport methods
            Point viewport = new Point();
            diagram.setViewport(viewport);
            assertEquals("The getViewport and setViewport methods is incorrect.", viewport,
                diagram.getViewport());

            // test getOwner and setOwner methods
            SemanticModelBridge owner = new SimpleSemanticModelElement();
            diagram.setOwner(owner);
            assertEquals("The getOwner and setOwner methods is incorrect.", owner,
                diagram.getOwner());
        }
    }

    /**
     * <p>Basic stress test of <code>addDiagramLink()</code>,
     * <code>removeDiagramLink()</code>, <code>clearDiagramLinks()</code>,
     * <code>getDiagramLinks()</code>, <code>containsDiagramLink()</code>,
     * <code>countDiagramLinks()</code> methods.</p>
     */
    public void testMethod_DiagramLink() {
        List<DiagramLink> diagramLinks = new ArrayList<DiagramLink>();

        for (int i = 0; i < LOOPTIMES; i++) {
            DiagramLink diagramLink = new DiagramLink();
            diagram.addDiagramLink(diagramLink);
            diagramLinks.add(diagramLink);

            // check the result here.
            assertTrue("The containsDiagramLink method is incorrect.",
                diagram.containsDiagramLink(diagramLink));
            assertEquals("The countDiagramLinks method is incorrect.", i + 1,
                diagram.countDiagramLinks());

            Collection<DiagramLink> getDiagramLinks = diagram.getDiagramLinks();
            assertEquals("The getDiagramLinks method is incorrect.", i + 1, getDiagramLinks.size());
            assertTrue("The getDiagramLinks method is incorrect.",
                diagramLinks.containsAll(getDiagramLinks));
        }

        for (int i = 0; i < (LOOPTIMES / 2); i++) {
            assertTrue("The removeLink method is incorrect." + i,
                diagram.removeDiagramLink(diagramLinks.get(i)));
            assertEquals("The removeLink method is incorrect.", LOOPTIMES - i - 1,
                diagram.countDiagramLinks());
            assertFalse("The removeLink method is incorrect.",
                diagram.containsDiagramLink(diagramLinks.get(i)));
        }

        // clear all diagram links and test it.
        diagram.clearDiagramLinks();
        assertEquals("The clearDiagramLinks method is incorrect.", 0, diagram.countDiagramLinks());
    }
}
