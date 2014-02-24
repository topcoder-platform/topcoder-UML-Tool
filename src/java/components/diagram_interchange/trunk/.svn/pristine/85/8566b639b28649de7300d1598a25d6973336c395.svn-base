/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ SemanticModelBridgeAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.SemanticModelBridge;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>SemanticModelBridge</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>SemanticModelBridge</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class SemanticModelBridgeAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>SemanticModelBridge</code> used for tests.
     * </p>
     */
    private SemanticModelBridge test = null;

    /**
     * <p>
     * Test suite of <code>SemanticModelBridgeAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>SemanticModelBridgeAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(SemanticModelBridgeAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new SemanticModelBridgeDefaultImpl();
    }

    /**
     * <p>
     * Accuracy Test of the <code>SemanticModelBridge()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new SemanticModelBridgeDefaultImpl());

        // get the original value of presentation to check the constructor
        assertNull("The presentation expected to be null", test.getPresentation());
        // get the original value of diagram to check the constructor
        assertNull("The diagram expected to be null", test.getDiagram());
        // get the original value of graphElement to check the constructor
        assertNull("The graphElement expected to be null", test.getGraphElement());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setDiagram(Diagram)</code> method and
     * <code>getDiagram()</code>.
     * </p>
     */
    public void testDiagram_Operation() {
        // creat a Diagram.
        Diagram diagram = new Diagram();
        // set the diagram.
        test.setDiagram(diagram);
        // get the diagram.
        assertEquals("The diagram expected to be equal", diagram,
                test.getDiagram());
        // set the diagram to null.
        test.setDiagram(null);
        // get the diagram.
        assertNull("The diagram expected to be null", test.getDiagram());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setGraphElement(GraphElement)</code> method and
     * <code>getGraphElement()</code>.
     * </p>
     */
    public void testGraphElement_Operation() {
        // creat a GraphElement.
        GraphElement graphElement = new GraphEdge();
        // set the graphElement.
        test.setGraphElement(graphElement);
            // get the graphElement.
        assertEquals("The graphElement expected to be equal", graphElement,
                test.getGraphElement());
         // set the graphElement to null.
        test.setGraphElement(null);
         // get the graphElement.
        assertNull("The graphElement expected to be null", test.getGraphElement());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setPresentation(String)</code> method and
     * <code>getPresentation()</code>.
     * </p>
     */
    public void testPresentation_Operation() {
      // creat a string array.
        String [] presentations = new String [] {"Top", "Coder", "Dev", "Des"};
        for (String presentation : presentations) {
            // set the presentation.
            test.setPresentation(presentation);
            // get the presentation.
            assertEquals("The presentation expected to be equal", presentation,
                test.getPresentation());
        }
       // set the presentation to null.
        test.setPresentation(null);
         // get the presentation.
        assertNull("The presentation expected to be null", test.getPresentation());
    }

    /**
     * <p>
     * A inner class which extends the <code>SemanticModelBridge</code> class, used for
     * accuracy test only.
     * </p>
     */
    class SemanticModelBridgeDefaultImpl extends SemanticModelBridge {
        // use default constructor.
    }
}
