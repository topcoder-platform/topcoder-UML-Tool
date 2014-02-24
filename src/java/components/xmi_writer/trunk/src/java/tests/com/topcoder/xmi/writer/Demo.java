/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.transformers.xmiheader.XMIHeaderTransformer;

import junit.framework.TestCase;

/**
 * <p>
 * This class demonstrates the common usage of this component.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class Demo extends TestCase {

    /**
     * <p>
     * Dummy implementation of the <code>{@link XMITransformer}</code> interface, which extends
     * <code>{@link AbstractXMITransformer}</code> abstract class for convenience. to demonstrate how to implement
     * <code>{@link XMITransformer}</code>.
     * </p>
     */
    private class DummyXMITransformer extends AbstractXMITransformer {
        /**
         * <p>
         * Transforms the element and output the result to the out stream.
         * </p>
         *
         * @param element
         *            the element object to transform.
         * @param out
         *            the <code>PrintStream</code> object to write the transformation data.
         */
        public void transform(Object element, PrintStream out) {
            // get the xmi writer.
            XMIWriter writer = getXMIWriter();
            // then you can manage the element-xmiId map and xmi root attributes.
        }
    }

    /**
     * <p>
     * Represents the output file name used in this demo.
     * </p>
     */
    private static final String FILENAME = "test_files" + File.separator + "demo.xmi";

    /**
     * <p>
     * Represents the zip file name used in this demo.
     * </p>
     */
    private static final String ZIP_FILENAME = "test_files" + File.separator + "demo.zip";

    /**
     * <p>
     * Represents the <code>{@link UMLModelManager}</code> used in this demo.
     * </p>
     */
    private UMLModelManager umlModelManager;

    /**
     * <p>
     * Represents the <code>{@link XMITransformer}</code> instance to transform the model.
     * </p>
     */
    private XMITransformer modelTransformer;

    /**
     * <p>
     * Represents the <code>{@link XMITransformer}</code> instance to transform the activity graph.
     * </p>
     */
    private XMITransformer activityGraphTransformer;

    /**
     * <p>
     * Represents the <code>{@link XMITransformer}</code> instance to transform the diagram.
     * </p>
     */
    private XMITransformer diagramTransformer;

    /**
     * <p>
     * Represents the <code>{@link XMITransformer}</code> instance to transform the header.
     * </p>
     */
    private XMITransformer headerTransformer;

    /**
     * <p>
     * Represents the <code>{@link XMIWriter}</code> instance to write XMI files.
     * </p>
     */
    private XMIWriter xmiWriter;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    protected void setUp() throws Exception {
        super.setUp();

        umlModelManager = new UMLModelManager();
        modelTransformer = new DummyXMITransformer();
        activityGraphTransformer = new DummyXMITransformer();
        diagramTransformer = new DummyXMITransformer();
        headerTransformer = new XMIHeaderTransformer("TCUML", "1.0", "1.2");

        // create a Map to hold all transformers
        Map<TransformerType, XMITransformer> transformers = new HashMap<TransformerType, XMITransformer>();
        transformers.put(TransformerType.Model, modelTransformer);
        transformers.put(TransformerType.ActivityGraph, activityGraphTransformer);
        transformers.put(TransformerType.Diagram, diagramTransformer);
        transformers.put(TransformerType.Header, headerTransformer);

        // create XMIWriter by the XMIWriter(UMLModelManager, Map<TransformerType, XMITransformer>) constructor.
        xmiWriter = new XMIWriter(umlModelManager, transformers);
    }

    /**
     * <p>
     * tear down the testing environment.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        // delete the temporary files.
        new File(FILENAME).delete();
        new File(ZIP_FILENAME).delete();
    }

    /**
     * <p>
     * Demonstrates how to create <code>{@link XMIWriter}</code> to transform.
     * </p>
     */
    public void testCreateXMIWriter() {
        // create a Map to hold all transformers
        Map<TransformerType, XMITransformer> transformers = new HashMap<TransformerType, XMITransformer>();
        transformers.put(TransformerType.Model, modelTransformer);
        transformers.put(TransformerType.ActivityGraph, activityGraphTransformer);
        transformers.put(TransformerType.Diagram, diagramTransformer);
        transformers.put(TransformerType.Header, headerTransformer);

        // create an XMIWriter with custom xmi root attributes
        Map<String, String> xmiRootAttrs = new HashMap<String, String>();
        xmiRootAttrs.put("xmlns:UML", "org.omg.xmi.namespace.UML");
        xmiRootAttrs.put("xmlns:UML2", "org.omg.xmi.namespace.UML2");
        xmiRootAttrs.put("xmi.version", "1.2");

        // create XMIWriter by the XMIWriter(UMLModelManager, Map<TransformerType, XMITransformer>) constructor.
        xmiWriter = new XMIWriter(umlModelManager, transformers);

        // create XMIWriter by the
        // XMIWriter(UMLModelManager, Map<TransformerType, XMITransformer>, Map<String, String>) constructor.
        xmiWriter = new XMIWriter(umlModelManager, transformers, xmiRootAttrs);
    }

    /**
     * <p>
     * Demonstrates the transform methods that transform the result to different sources.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransforms() throws Exception {
        // ---------------------transform(File, boolean)--------------------------
        // transform to a file, without diagram data
        xmiWriter.transform(new File(FILENAME), false);

        // transform to a file, with diagram data
        xmiWriter.transform(new File(FILENAME), true);

        // -----------------transform(OuputputStream, boolean)----------------------
        // you can use FileOutputStream to output the transform result.
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // transform to output stream, without diagram data
        xmiWriter.transform(outputStream, false);

        // transform to output stream, with diagram data
        xmiWriter.transform(outputStream, true);

        // -----------------transformToZipFile(File, boolean)-----------------------
        // transform to a zip file, without diagram data
        xmiWriter.transformToZipFile(new File(ZIP_FILENAME), false);

        // transform to a zip file, with diagram data
        xmiWriter.transformToZipFile(new File(ZIP_FILENAME), true);
    }

    /**
     * <p>
     * Demonstrates the management of xmi root attributes.
     * </p>
     */
    public void testManageXMIRootAttributes() {
        // clear all xmi root attributes
        xmiWriter.clearXMIRootAttributes();

        // add xmi root attributes
        xmiWriter.putXMIRootAttribute("xmi.version", "1.2");
        xmiWriter.putXMIRootAttribute("timestamp", "Mon Jan 30 16:36:02 CST 2006");

        // remove xmi root attribute
        xmiWriter.removeXMIRootAttribute("timestamp");

        // get xmi root attribute
        String attrValue = xmiWriter.getXMIRootAttribute("xmi.version");

        // get all xmi root attribute keys
        String[] keys = xmiWriter.getXMIRootAttributeKeys();
    }

    /**
     * <p>
     * Demonstrates the management of the element id.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testmanageElementIds() throws Exception {
        Object element = new Object();

        // put the element-xmiId pair
        xmiWriter.putElementId(element, "TC");

        // get the xmiId by element.
        String xmiId = xmiWriter.getElementId(element);
    }
}
