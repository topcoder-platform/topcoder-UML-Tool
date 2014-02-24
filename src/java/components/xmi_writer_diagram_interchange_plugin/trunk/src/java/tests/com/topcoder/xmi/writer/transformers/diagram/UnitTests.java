/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram;

import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.BezierPointTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.CoreSemanticModelBridgeTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramElementTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramLinkTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DimensionTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.EllipseTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphConnectorTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphEdgeTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphElementTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphNodeTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphicPrimitiveTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.HelperTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.ImageTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.LeafElementTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PointTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PolylineTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PropertyTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.ReferenceTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.SemanticModelBridgeTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.SimpleSemanticModelElementTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.StructureXMLNodeTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.TextElementTransformerTest;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.Uml1SemanticModelBridgeTransformerTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {

    /**
     * <p>
     * This test case aggregates all Unit test cases.
     * </p>
     *
     * @return all Unit test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        // tests for package com.topcoder.xmi.writer.transformers.diagram.elementtransformers
        suite.addTest(BezierPointTransformerTest.suite());
        suite.addTest(CoreSemanticModelBridgeTransformerTest.suite());
        suite.addTest(DiagramElementTransformerTest.suite());
        suite.addTest(DiagramLinkTransformerTest.suite());
        suite.addTest(DiagramTransformerTest.suite());
        suite.addTest(DimensionTransformerTest.suite());
        suite.addTest(EllipseTransformerTest.suite());
        suite.addTest(GraphConnectorTransformerTest.suite());
        suite.addTest(GraphEdgeTransformerTest.suite());
        suite.addTest(GraphElementTransformerTest.suite());
        suite.addTest(GraphNodeTransformerTest.suite());
        suite.addTest(GraphicPrimitiveTransformerTest.suite());
        suite.addTest(HelperTest.suite());
        suite.addTest(ImageTransformerTest.suite());
        suite.addTest(LeafElementTransformerTest.suite());
        suite.addTest(PointTransformerTest.suite());
        suite.addTest(PolylineTransformerTest.suite());
        suite.addTest(PropertyTransformerTest.suite());
        suite.addTest(ReferenceTransformerTest.suite());
        suite.addTest(SemanticModelBridgeTransformerTest.suite());
        suite.addTest(SimpleSemanticModelElementTransformerTest.suite());
        suite.addTest(StructureXMLNodeTest.suite());
        suite.addTest(TextElementTransformerTest.suite());
        suite.addTest(Uml1SemanticModelBridgeTransformerTest.suite());

        // tests for package com.topcoder.xmi.writer.transformers.diagram
        suite.addTest(Diagram2XMITransformerTest.suite());

        suite.addTest(DemoTests.suite());
        return suite;
    }

}
