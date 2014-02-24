/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.accuracytests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.ElementAlreadyExistsException;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.UnknownElementException;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy Test for <code>XMIWriter</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class XMIWriterAccuracyTest extends TestCase {

    /**
     * <p>
     * The path of the output file.
     * </p>
     */
    private String path = "test_files/temp/temp.xml";

    /**
     * <p>
     * The XMIWriter instance created for testing.
     * </p>
     */
    private XMIWriter writer = null;

    /**
     * <p>
     * The UMLModelManager instance created for testing.
     * </p>
     */
    private UMLModelManager manager = new UMLModelManager();

    /**
     * <p>
     * The Map<TransformerType, XMITransformer> instance created for testing.
     * </p>
     */
    private Map<TransformerType, XMITransformer> transformers = new HashMap<TransformerType, XMITransformer>();

    /**
     * <p>
     * The Map<String, String> instance created for testing.
     * </p>
     */
    private Map<String, String> xmiRootAttributes = new HashMap<String, String>();

    /**
     * <p>
     * <code>XMITransformer</code> instance created for testing.
     * </p>
     */
    private XMITransformer trans1 = new MockedXMITransformer();

    /**
     * <p>
     * <code>XMITransformer</code> instance created for testing.
     * </p>
     */
    private XMITransformer trans2 = new MockedXMITransformer();

    /**
     * <p>
     * <code>XMITransformer</code> instance created for testing.
     * </p>
     */
    private XMITransformer trans3 = new MockedXMITransformer();

    /**
     * <p>
     * The suffix string of the xml file. There can be whitespaces before or
     * after the '='; also, the "'" can be "\"". So you may need to modify this
     * string to make it fit your program.
     * </p>
     */
    private String prefix = "<?xml version='1.0' encoding='UTF-8'?>";

    /**
     * <p>
     * The expected string without Diagrams data.
     * </p>
     */
    private String contentWithoutDiagram = "<XMI key = 'value' ><XMI.content>"
            + "<Model>this is a model 0</Model><ActivityGraph>this is a ActivityGraph 1</ActivityGraph>"
            + "<ActivityGraph>this is a ActivityGraph 2</ActivityGraph>"
            + "<ActivityGraph>this is a ActivityGraph 3</ActivityGraph></XMI.content></XMI>";

    /**
     * <p>
     * The expected string without Diagrams data. Header is included.
     * </p>
     */
    private String contentWithoutDiagramHeader = "<XMI key = 'value' >null<XMI.content>"
            + "<Model>this is a model 0</Model><ActivityGraph>this is a ActivityGraph 1</ActivityGraph>"
            + "<ActivityGraph>this is a ActivityGraph 2</ActivityGraph>"
            + "<ActivityGraph>this is a ActivityGraph 3</ActivityGraph></XMI.content></XMI>";

    /**
     * <p>
     * The expected string with Diagrams data.
     * </p>
     */
    private String contentWithDiagram = "<XMI key = 'value' ><XMI.content>"
            + "<Model>this is a model 0</Model><ActivityGraph>this is a ActivityGraph 1</ActivityGraph>"
            + "<ActivityGraph>this is a ActivityGraph 2</ActivityGraph>"
            + "<ActivityGraph>this is a ActivityGraph 3</ActivityGraph>"
            + "<Diagram>this is a MockedDiagram 4</Diagram><Diagram>this is a MockedDiagram 5</Diagram>"
            + "<Diagram>this is a MockedDiagram 8</Diagram></XMI.content></XMI>";

    /**
     * <p>
     * The expected string with Diagrams data. Header is included.
     * </p>
     */
    private String contentWithDiagramHeader = "<XMI key = 'value' >null<XMI.content>"
            + "<Model>this is a model 0</Model><ActivityGraph>this is a ActivityGraph 1</ActivityGraph>"
            + "<ActivityGraph>this is a ActivityGraph 2</ActivityGraph>"
            + "<ActivityGraph>this is a ActivityGraph 3</ActivityGraph>"
            + "<Diagram>this is a MockedDiagram 4</Diagram><Diagram>this is a MockedDiagram 5</Diagram>"
            + "<Diagram>this is a MockedDiagram 8</Diagram></XMI.content></XMI>";

    /**
     * <p>
     * Deletes all the spaces in the string.
     * </p>
     *
     * @param value the String to process
     * @return the processed String
     */
    private String deleteSpace(String value) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isWhitespace(value.charAt(i))) {
                buffer.append(value.charAt(i));
            }
        }
        return buffer.toString();
    }

    /**
     * <p>
     * Checks whether the output file is expected in content.
     * </p>
     *
     * @param withDiagramData a flag indicating the Diagrams data should be
     *            written or not
     * @param withHeader a flag indicating the Header is included or not
     * @return true if the output file is expected, otherwise false
     * @throws Exception to JUnit
     */
    private boolean check(boolean withHeader, boolean withDiagramData) throws Exception {
        File file = new File(path);

        // Read the output file
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        StringBuffer buffer = new StringBuffer();
        String temp = null;
        while ((temp = reader.readLine()) != null) {
            buffer.append(temp);
        }
        reader.close();

        String result = buffer.toString();
        if (!result.startsWith(prefix)) {
            return false;
        }

        if (withHeader && withDiagramData) {
            return deleteSpace(result.substring(prefix.length())).equals(deleteSpace(contentWithDiagramHeader));
        } else if (withHeader && !withDiagramData) {
            return deleteSpace(result.substring(prefix.length())).equals(deleteSpace(contentWithoutDiagramHeader));
        } else if (!withHeader && withDiagramData) {
            return deleteSpace(result.substring(prefix.length())).equals(deleteSpace(contentWithDiagram));
        } else if (!withHeader && !withDiagramData) {
            return deleteSpace(result.substring(prefix.length())).equals(deleteSpace(contentWithoutDiagram));
        }

        // Never reached
        return false;
    }

    /**
     * <p>
     * Checks whether the output zip file is expected in content.
     * </p>
     *
     * @param withDiagramData a flag indicating the Header is included or not
     * @return true if the output file is expected, otherwise false
     * @throws Exception to JUnit
     */
    private boolean checkZip(boolean withDiagramData) throws Exception {
        ZipFile file = new ZipFile(path);
        ZipEntry zip = file.getEntry("temp.xmi");

        // The file should contains only one zip entry with name "temp.xmi"
        if (file.size() != 1 || zip == null) {
            return false;
        }

        // Read the zip file
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(zip)));
        String temp = null;
        while ((temp = reader.readLine()) != null) {
            buffer.append(temp);
        }
        reader.close();
        String result = buffer.toString();

        if (!result.startsWith(prefix)) {
            return false;
        }
        if (withDiagramData) {
            return deleteSpace(result.substring(prefix.length())).equals(deleteSpace(contentWithDiagram));
        } else {
            return deleteSpace(result.substring(prefix.length())).equals(deleteSpace(contentWithoutDiagram));
        }
    }

    /**
     * <p>
     * Set up the enviroment.
     * </p>
     */
    protected void setUp() {
        transformers.put(TransformerType.Model, trans1);
        transformers.put(TransformerType.ActivityGraph, trans2);
        transformers.put(TransformerType.Diagram, trans3);
        xmiRootAttributes.put("key", "value");
        manager.setModel(new MockedModel(0));
        manager.addActivityGraph(new MockedActivityGraph(1));
        manager.addActivityGraph(new MockedActivityGraph(2));
        manager.addActivityGraph(new MockedActivityGraph(3));
        manager.addDiagram(new MockedDiagram(4));
        manager.addDiagram(new MockedDiagram(5));
        manager.addDiagram(new MockedDiagram(8));
        writer = new XMIWriter(manager, transformers, xmiRootAttributes);
    }

    /**
     * <p>
     * Clear the enviroment.
     * </p>
     */
    protected void tearDown() {
        new File(path).delete();
    }

    /**
     * <p>
     * Accuracy Test for
     * <code>XMIWriter(UMLModelManager manager, Map<TransformerType, XMITransformer> transformers)</code>.
     * </p>
     */
    public void testXMIWriter1() {
        XMIWriter xmlWriter = new XMIWriter(manager, transformers);
        assertEquals("XMIWriter creation failed.", 3, xmlWriter.getXMIRootAttributeKeys().length);
        assertEquals("XMIWriter creation failed.", "org.omg.xmi.namespace.UML", xmlWriter
                .getXMIRootAttribute("xmlns:UML"));
        assertEquals("XMIWriter creation failed.", "org.omg.xmi.namespace.UML2", xmlWriter
                .getXMIRootAttribute("xmlns:UML2"));
        assertEquals("XMIWriter creation failed.", "1.5", xmlWriter.getXMIRootAttribute("xmi.version"));
        assertTrue("XMIWriter creation failed.", xmlWriter == trans1.getXMIWriter());
        assertTrue("XMIWriter creation failed.", xmlWriter == trans2.getXMIWriter());
        assertTrue("XMIWriter creation failed.", xmlWriter == trans3.getXMIWriter());
    }

    /**
     * <p>
     * Accuracy Test for
     * <code>XMIWriter(UMLModelManager manager, Map<TransformerType, XMITransformer> transformers,
     * Map<String, String> xmiRootAttributes)</code>.
     * </p>
     */
    public void testXMIWriter2() {
        assertEquals("XMIWriter creation failed.", 1, writer.getXMIRootAttributeKeys().length);
        assertEquals("XMIWriter creation failed.", "value", writer.getXMIRootAttribute("key"));
        assertTrue("XMIWriter creation failed.", writer == trans1.getXMIWriter());
        assertTrue("XMIWriter creation failed.", writer == trans2.getXMIWriter());
        assertTrue("XMIWriter creation failed.", writer == trans3.getXMIWriter());
    }

    /**
     * <p>
     * Accuracy Test for <code>getElementId(Object element)</code>.
     * </p>
     *
     * @throws ElementAlreadyExistsException to JUnit
     * @throws UnknownElementException to JUnit
     */
    public void testGetElementId() throws ElementAlreadyExistsException, UnknownElementException {
        Object element = new Object();
        String id = "id";
        writer.putElementId(element, id);
        assertEquals("getElementId failed.", id, writer.getElementId(element));
    }

    /**
     * <p>
     * Accuracy Test for <code>putElementId(Object element, String xmiId)</code>.
     * </p>
     *
     * @throws ElementAlreadyExistsException to JUnit
     * @throws UnknownElementException to JUnit
     */
    public void testPutElementId() throws ElementAlreadyExistsException, UnknownElementException {
        Object element = new Object();
        String id = "id";
        writer.putElementId(element, id);
        assertEquals("putElementId failed.", id, writer.getElementId(element));
    }

    /**
     * <p>
     * Accuracy Test for <code>removeXMIRootAttribute</code>.
     * </p>
     */
    public void testPutXMIRootAttribute() {
        writer.putXMIRootAttribute("key", "value");
        assertEquals("putXMIRootAttribute failed.", "value", writer.getXMIRootAttribute("key"));
    }

    /**
     * <p>
     * Accuracy Test for <code>removeXMIRootAttribute</code>.
     * </p>
     */
    public void testGetXMIRootAttribute() {
        XMIWriter xmlWriter = new XMIWriter(manager, transformers);
        assertEquals("removeXMIRootAttribute failed.", 3, xmlWriter.getXMIRootAttributeKeys().length);
        assertEquals("removeXMIRootAttribute failed.", "org.omg.xmi.namespace.UML", xmlWriter
                .getXMIRootAttribute("xmlns:UML"));
        assertEquals("removeXMIRootAttribute failed.", "org.omg.xmi.namespace.UML2", xmlWriter
                .getXMIRootAttribute("xmlns:UML2"));
        assertEquals("XMIWriter creation failed.", "1.5", xmlWriter.getXMIRootAttribute("xmi.version"));
    }

    /**
     * <p>
     * Accuracy Test for <code>removeXMIRootAttribute</code>.
     * </p>
     */
    public void testRemoveXMIRootAttribute() {
        XMIWriter xmlWriter = new XMIWriter(manager, transformers);
        xmlWriter.removeXMIRootAttribute("xmlns:UML");
        String[] keys = xmlWriter.getXMIRootAttributeKeys();
        assertEquals("removeXMIRootAttribute failed.", 2, keys.length);
        for (int i = 0; i < keys.length; i++) {
            assertTrue("removeXMIRootAttribute failed.", keys[i].equals("xmlns:UML2") || keys[i].equals("xmi.version"));
        }

        xmlWriter.removeXMIRootAttribute("xmlns:UML2");
        keys = xmlWriter.getXMIRootAttributeKeys();
        assertEquals("removeXMIRootAttribute failed.", 1, keys.length);
        assertTrue("removeXMIRootAttribute failed.", keys[0].equals("xmi.version"));

        // Nothing happens while removing non-existing attribute
        xmlWriter.removeXMIRootAttribute("xmlns:UML2");
        keys = xmlWriter.getXMIRootAttributeKeys();
        assertEquals("removeXMIRootAttribute failed.", 1, keys.length);
        assertTrue("removeXMIRootAttribute failed.", keys[0].equals("xmi.version"));

        // Remove the last attribute
        xmlWriter.removeXMIRootAttribute("xmi.version");
        keys = xmlWriter.getXMIRootAttributeKeys();
        assertEquals("removeXMIRootAttribute failed.", 0, keys.length);
    }

    /**
     * <p>
     * Accuracy Test for <code>getXMIRootAttributeKeys</code>.
     * </p>
     */
    public void testGetXMIRootAttributeKeys() {
        XMIWriter xmlWriter = new XMIWriter(manager, transformers);
        String[] keys = xmlWriter.getXMIRootAttributeKeys();
        assertEquals("getXMIRootAttributeKeys failed.", 3, keys.length);
        for (int i = 0; i < keys.length; i++) {
            assertTrue("getXMIRootAttributeKeys failed.", keys[i].equals("xmlns:UML") || keys[i].equals("xmlns:UML2")
                    || keys[i].equals("xmi.version"));
        }

    }

    /**
     * <p>
     * Accuracy Test for <code>getXMIRootAttributeKeys</code>.
     * </p>
     * <p>
     * The returned array could be empty if there are no attributes in that
     * variable.
     * </p>
     */
    public void testGetXMIRootAttributeKeysEmpty() {
        XMIWriter xmlWriter = new XMIWriter(manager, transformers, new HashMap<String, String>());
        assertEquals("getXMIRootAttributeKeys failed.", 0, xmlWriter.getXMIRootAttributeKeys().length);
    }

    /**
     * <p>
     * Accuracy Test for <code>clearXMIRootAttributes</code>.
     * </p>
     */
    public void testClearXMIRootAttributes() {
        writer.clearXMIRootAttributes();
        assertEquals("clearXMIRootAttributes failed.", 0, writer.getXMIRootAttributeKeys().length);
    }

    /**
     * <p>
     * Accuracy Test for <code>getUMLModelManager</code>.
     * </p>
     */
    public void testGetUMLModelManager() {
        assertEquals("getUMLModelManager failed.", manager, writer.getUMLModelManager());
    }

    /**
     * <p>
     * Accuracy Test for
     * <code>transform(File outputFile, boolean withDiagramData)</code>.
     * </p>
     * <p>
     * withDiagramData is true.
     * </p>
     *
     * @throws Exception to JUnit if any error occurs
     */
    public void testTransformTrue() throws Exception {
        File file = new File(path);
        writer.transform(file, true);
        assertTrue("transform(File outputFile, boolean withDiagramData) failed.", check(false, true));
        file.delete();
    }

    /**
     * <p>
     * Accuracy Test for
     * <code>transform(File outputFile, boolean withDiagramData)</code>.
     * </p>
     * <p>
     * withDiagramData is false.
     * </p>
     *
     * @throws Exception to JUnit if any error occurs
     */
    public void testTransformFalse() throws Exception {
        File file = new File(path);
        writer.transform(file, false);
        assertTrue("transform(File outputFile, boolean withDiagramData) failed.", check(false, false));
        file.delete();
    }

    /**
     * <p>
     * Accuracy Test for
     * <code>transform(OutputStream outputStream, boolean withDiagramData)</code>.
     * </p>
     * <p>
     * withDiagramData is true.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTransformOutputStreamTrue() throws Exception {
        File file = new File(path);
        writer.transform(new FileOutputStream(file), true);
        assertTrue("transform(File outputFile, boolean withDiagramData) failed.", check(false, true));
        file.delete();
    }

    /**
     * <p>
     * Accuracy Test for
     * <code>transform(OutputStream outputStream, boolean withDiagramData)</code>.
     * </p>
     * <p>
     * withDiagramData is false.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTransformOutputStreamFalse() throws Exception {
        File file = new File(path);
        writer.transform(new FileOutputStream(file), false);
        assertTrue("transform(File outputFile, boolean withDiagramData) failed.", check(false, false));
        file.delete();
    }

    /**
     * <p>
     * Accuracy Test for
     * <code>transform(OutputStream outputStream, boolean withDiagramData)</code>.
     * </p>
     * <p>
     * withDiagramData is true, and Header is included.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTransformOutputStreamTrueWithHead() throws Exception {
        transformers.put(TransformerType.Model, trans1);
        transformers.put(TransformerType.ActivityGraph, trans2);
        transformers.put(TransformerType.Diagram, trans3);
        transformers.put(TransformerType.Header, new MockedXMITransformer());
        XMIWriter xmlWriter = new XMIWriter(manager, transformers, xmiRootAttributes);
        File file = new File(path);
        xmlWriter.transform(new FileOutputStream(file), true);
        assertTrue("transform(File outputFile, boolean withDiagramData) failed.", check(true, true));
        file.delete();
    }

    /**
     * <p>
     * Accuracy Test for
     * <code>transform(OutputStream outputStream, boolean withDiagramData)</code>.
     * </p>
     * <p>
     * withDiagramData is false, and Header is included.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTransformOutputStreamFalseWithHead() throws Exception {
        transformers.put(TransformerType.Model, trans1);
        transformers.put(TransformerType.ActivityGraph, trans2);
        transformers.put(TransformerType.Diagram, trans3);
        transformers.put(TransformerType.Header, new MockedXMITransformer());
        XMIWriter xmlWriter = new XMIWriter(manager, transformers, xmiRootAttributes);
        File file = new File(path);
        xmlWriter.transform(new FileOutputStream(file), false);
        assertTrue("transform(File outputFile, boolean withDiagramData) failed.", check(true, false));
        file.delete();
    }

    /**
     * <p>
     * Accuracy Test for
     * <code>transformToZipFile(File zipFile, boolean withDiagramData)</code>.
     * </p>
     * <p>
     * withDiagramData is true.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTransformToZipFileTrue() throws Exception {
        File file = new File(path);
        writer.transformToZipFile(file, true);
        assertTrue("transform(File outputFile, boolean withDiagramData) failed.", checkZip(true));
        file.delete();
    }

    /**
     * <p>
     * Accuracy Test for
     * <code>transformToZipFile(File zipFile, boolean withDiagramData)</code>.
     * </p>
     * <p>
     * withDiagramData is false.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTransformToZipFile() throws Exception {
        File file = new File(path);
        writer.transformToZipFile(file, false);
        assertTrue("transform(File outputFile, boolean withDiagramData) failed.", checkZip(false));
        file.delete();
    }

    /**
     * <p>
     * Accuracy Test for
     * <code>transformToZipFile(File zipFile, boolean withDiagramData)</code>.
     * </p>
     * <p>
     * There is no dot in the fileName.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testTransformToZipFileNoDot() throws Exception {
        File file = new File("test_files/fileName");
        writer.transformToZipFile(file, false);
        file.delete();
    }
}
