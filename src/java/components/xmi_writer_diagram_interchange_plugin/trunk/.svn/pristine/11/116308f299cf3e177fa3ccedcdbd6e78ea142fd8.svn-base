/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.stresstests;

import java.io.PrintStream;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.xmi.writer.AbstractXMITransformer;

/**
 * <p>
 * Mock implementation of the <code>{@link XMITransformer}</code> interface. Just used for testing purpose.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockXMITransformer extends AbstractXMITransformer {

    /**
     * <p>
     * Transforms the given element object and write the transformation result into the out
     * <code>{@link PrintStream}</code> object.
     * </p>
     *
     * @param element
     *            the element object to transform.
     * @param out
     *            the <code>PrintStream</code> object to write the transformation data.
     */
    public void transform(Object element, PrintStream out) {
        if (element instanceof Model) {
            out.print("<tc>Model</tc>");
        } else if (element instanceof ActivityGraph) {
            out.print("<tc>ActivityGraph</tc>");
        } else if (element instanceof Diagram) {
            out.print("<tc>Diagram</tc>");
        }
    }

}
