/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This class is the main class that enable writing the xmi data retrieved from the the <b>UML Model Manager</b>
 * component to a file, an output stream, or a zip file.
 * </p>
 * <p>
 * Currently this writer only supports 4 types of transformers, and they would write the <b>xmi header</b>,
 * <b>model</b>, <b>activity graphs</b> and <b>diagrams</b> respectively. The <b>model</b>, <b>activity graphs</b>
 * and <b>diagrams</b> data are all retrieved from <b>the UML Model Manager component</b>. This writer also supports
 * configurable xmi root attributes, and it won't write the diagrams data if the <code>withDiagramData</code> flag
 * is <code>false</code>.
 * <p>
 * <strong>Thread-safety</strong>: This class is mutable, and it is not thread-safe.
 * </p>
 *
 * @author Standlove, FireIce
 * @version 1.0
 * @see XMITransformer
 * @see UMLModelManager
 */
public class XMIWriter {

    /**
     * <p>
     * Represents the <code>{@link UMLModelManager}</code> object to retrieve the <b>model</b>, <b>activity graphs</b>
     * and <b>diagrams</b> data to transform, used in transform methods.
     * </p>
     * <p>
     * Initialized in constructor, and its reference is never changed afterwards. Must be non-null.
     * </p>
     */
    private final UMLModelManager manager;

    /**
     * <p>
     * Represents a map from the <code>{@link TransformerType}</code> objects to the corresponding
     * <code>{@link XMITransformer}</code> objects.
     * </p>
     * <p>
     * The key must be one of the value defined in <code>{@link TransformerType}</code> enumeration class(null key is
     * ignored), and the value must be non-null <code>{@link XMITransformer}</code> object.
     * </p>
     * <p>
     * The field never be null. Initialized to an empty <code>EnumMap</code> object when it is declared, and its
     * reference is never changed, it is populated in the constructor. It should contains at least 3 entries, whose keys
     * are <code>TransformerType.Model</code>, <code>TransformerType.ActivityGraph</code>,
     * <code>TransformerType.Diagram</code>; the entry with <code>TransformerType.Header</code> as the key is
     * optional.
     * </p>
     */
    private final Map<TransformerType, XMITransformer> transformers;

    /**
     * <p>
     * Represents a map from element objects (of <code>Object</code> type) to their corresponding xmiId (of
     * <code>String</code> type).
     * </p>
     * <p>
     * The keys must be non-null objects, and the values must be non-null, non-empty strings.
     * </p>
     * <p>
     * The field never null. Initialized to an empty <code>HashMap</code> when it is declared, and its reference is
     * never changed. It is populated by the registered <code>{@link XMITransformer}</code> objects.
     * </p>
     */
    private final Map<Object, String> elementIds = new HashMap<Object, String>();

    /**
     * <p>
     * Represents a map from xmi root attribute keys (of <code>String</code> type) to corresponding xmi root attribute
     * values (of <code>String</code> type).
     * </p>
     * <p>
     * The keys and values must be both non-null, non-empty string.
     * </p>
     * <p>
     * The field never null. Initialized to an empty <code>HashMap</code> object when it is declared, and its
     * reference is never changed afterwards. Its content is populated in the constructor, and could be accessed or
     * updated through its corresponding <code>add</code>/<code>remove</code>/<code>clear</code>/<code>get</code>
     * methods.
     * </p>
     */
    private final Map<String, String> xmiRootAttributes = new HashMap<String, String>();

    /**
     * <p>
     * Constructs an instance of <code>{@link XMIWriter}</code> with all the fields initialized.
     * </p>
     *
     * @param manager
     *            the <code>UMLModelManager</code> object to retrieve the model, activity graphs and diagrams data
     * @param transformers
     *            a map from the <code>{@link TransformerType}</code> objects to the corresponding
     *            <code>{@link XMITransformer}</code> objects.
     * @throws IllegalArgumentException
     *             <ul>
     *             <li>If <code>manager</code> is <code>null</code>.</li>
     *             <li>If <code>transformers</code> is <code>null</code>, or transformers argument doesn't
     *             contains keys for <code>TransformerType.Model</code>, <code>TransformerType.ActivityGraph</code>,
     *             and <code>TransformerType.Diagram</code>, or transformers argument contains <code>null</code>
     *             values.</li>
     *             </ul>
     */
    public XMIWriter(UMLModelManager manager, Map<TransformerType, XMITransformer> transformers) {
        this(manager, transformers, getDefaultXMIRootAttributes());
    }

    /**
     * <p>
     * Constructs an instance of<code>{@link XMIWriter}</code> with all the fields initialized.
     * </p>
     *
     * @param manager
     *            the <code>UMLModelManager</code> object to retrieve the Model, ActivityGraphs and Diagrams data
     * @param transformers
     *            a map from the <code>{@link TransformerType}</code> objects to the corresponding
     *            <code>{@link XMITransformer}</code> objects.
     * @param xmiRootAttributes
     *            a map from xmi root attribute keys to corresponding xmi root attribute.
     * @throws IllegalArgumentException
     *             <ul>
     *             <li>If <code>manager</code> is <code>null</code></li>
     *             <li>If <code>transformers</code> is <code>null</code>, or transformers argument doesn't
     *             contains keys for <code>TransformerType.Model</code>, <code>TransformerType.ActivityGraph</code>,
     *             and <code>TransformerType.Diagram</code>, or transformers argument contains <code>null</code>
     *             values</li>
     *             <li> If <code>xmiRootAttributes</code> argument is <code>null</code>, or its key or value is
     *             <code>null</code> or <code>empty</code>. </li>
     *             </ul>
     */
    public XMIWriter(UMLModelManager manager, Map<TransformerType, XMITransformer> transformers,
            Map<String, String> xmiRootAttributes) {
        Helper.validateObject(manager, "uml model manager");
        validateTransformers(transformers, "transformers");
        validateXMIRootAttributes(xmiRootAttributes, "xmiRootAttributes");

        this.manager = manager;
        this.transformers = new EnumMap<TransformerType, XMITransformer>(transformers);
        // set this instance to all the transformers
        for (XMITransformer transformer : transformers.values()) {
            transformer.setXMIWriter(this);
        }
        this.xmiRootAttributes.putAll(xmiRootAttributes);
    }

    /**
     * <p>
     * Gets the default xmi root attributes.
     * </p>
     *
     * @return the default xmi root attributes.
     */
    private static Map<String, String> getDefaultXMIRootAttributes() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("xmlns:UML", "org.omg.xmi.namespace.UML");
        map.put("xmlns:UML2", "org.omg.xmi.namespace.UML2");
        map.put("xmi.version", "1.5");
        return map;
    }

    /**
     * <p>
     * Validates the xmi root attributes.
     * </p>
     *
     * @param xmiRootAttributes
     *            the xmi root attributes map.
     * @param name
     *            the variable name
     * @throws IllegalArgumentException
     *             If <code>xmiRootAttributes</code> argument is <code>null</code>, or its key or value is
     *             <code>null</code> or empty.
     */
    private static void validateXMIRootAttributes(Map<String, String> xmiRootAttributes, String name) {
        Helper.validateObject(xmiRootAttributes, name);
        for (Entry<String, String> entry : xmiRootAttributes.entrySet()) {
            Helper.validateString(entry.getKey(), "xmiRootAttributes key");
            Helper.validateString(entry.getValue(), "xmiRootAttributes value");
        }
    }

    /**
     * <p>
     * Validates the transformers map.
     * </p>
     *
     * @param transformers
     *            the transformers map.
     * @param name
     *            the variable name
     * @throws IllegalArgumentException
     *             If <code>transformers</code> is <code>null</code>, or transformers argument doesn't contains
     *             keys for <code>TransformerType.Model</code>, <code>TransformerType.ActivityGraph</code>, and
     *             <code>TransformerType.Diagram</code>, or transformers argument contains <code>null</code> values
     */
    private static void validateTransformers(Map<TransformerType, XMITransformer> transformers, String name) {
        Helper.validateObject(transformers, name);
        if (transformers.containsValue(null)) {
            throw new IllegalArgumentException("the [" + name + "] map contains null value.");
        }
        TransformerType[] mandatoryTypes =
            new TransformerType[] {TransformerType.Model, TransformerType.ActivityGraph, TransformerType.Diagram};
        for (TransformerType transformerType : mandatoryTypes) {
            if (!transformers.containsKey(transformerType)) {
                throw new IllegalArgumentException("the [" + name + "] map should contains " + transformerType
                        + " key.");
            }
        }
    }

    /**
     * <p>
     * Gets the corresponding xmi id with the given element object.
     * </p>
     *
     * @param element
     *            the element to find the corresponding xmi id.
     * @return the corresponding xmi id.
     * @throws IllegalArgumentException
     *             if the element argument is <code>null</code>.
     * @throws UnknownElementException
     *             if there is no xmi id for the given element.
     * @see HashMap#get(Object)
     */
    public String getElementId(Object element) throws UnknownElementException {
        Helper.validateObject(element, "element");

        if (!elementIds.containsKey(element)) {
            throw new UnknownElementException("there is no xmiId for the given element.", element);
        }

        return elementIds.get(element);
    }

    /**
     * <p>
     * Adds the element object and its corresponding xmi id to the element ids map.
     * </p>
     *
     * @param element
     *            the element to find the corresponding xmi id.
     * @param xmiId
     *            the corresponding xmi id.
     * @throws IllegalArgumentException
     *             <ul>
     *             <li>If <code>element</code> is <code>null</code></li>
     *             <li>If <code>xmiId</code> is <code>null</code> or <code>empty</code>.</li>
     *             </ul>
     * @throws ElementAlreadyExistsException
     *             if the element argument already exists in element ids map.
     * @see HashMap#put(Object, Object)
     */
    public void putElementId(Object element, String xmiId) throws ElementAlreadyExistsException {
        Helper.validateObject(element, "element");
        Helper.validateString(xmiId, "xmiId");

        if (elementIds.containsKey(element)) {
            throw new ElementAlreadyExistsException("the element argument already exists.", element);
        }

        elementIds.put(element, xmiId);
    }

    /**
     * <p>
     * Adds the xmi root attribute. Overwrite the old value if the attribute key already exists.
     * </p>
     *
     * @param attrKey
     *            the xmi root attribute key.
     * @param attrValue
     *            the xmi root attribute value.
     * @throws IllegalArgumentException
     *             if <code>attrKey</code> or <code>attrValue</code> is <code>null</code> or <code>empty</code>
     *             string.
     * @see HashMap#put(Object, Object)
     */
    public void putXMIRootAttribute(String attrKey, String attrValue) {
        Helper.validateString(attrKey, "attrKey");
        Helper.validateString(attrValue, "attrValue");

        // put the key-value pair
        xmiRootAttributes.put(attrKey, attrValue);
    }

    /**
     * <p>
     * Gets the xmi root attribute value by its key.
     * </p>
     *
     * @param attrKey
     *            the xmi root attribute key.
     * @return the corresponding xmi root attribute value. or null if the key doesn't exist.
     * @throws IllegalArgumentException
     *             if the <code>attrKey</code> argument is <code>null</code> or <code>empty</code> string.
     * @see HashMap#get(Object)
     */
    public String getXMIRootAttribute(String attrKey) {
        Helper.validateString(attrKey, "attrKey");

        // get the value corresponding to the key.
        return xmiRootAttributes.get(attrKey);
    }

    /**
     * <p>
     * Removes the xmi root attribute identified by the given key.
     * </p>
     *
     * @param attrKey
     *            the xmi root attribute key.
     * @throws IllegalArgumentException
     *             if the <code>attrKey</code> argument is <code>null</code> or empty string.
     * @see HashMap#remove(Object)
     */
    public void removeXMIRootAttribute(String attrKey) {
        Helper.validateString(attrKey, "attrKey");

        // remove the entry with the key
        xmiRootAttributes.remove(attrKey);
    }

    /**
     * <p>
     * Gets all xmi root attribute keys as a string array.
     * </p>
     *
     * @return an array of xmi root attribute keys.
     */
    public String[] getXMIRootAttributeKeys() {
        // return the attribute key array
        return xmiRootAttributes.keySet().toArray(new String[xmiRootAttributes.keySet().size()]);
    }

    /**
     * <p>
     * Clear all xmi root attributes.
     * </p>
     * @see HashMap#clear()
     */
    public void clearXMIRootAttributes() {
        xmiRootAttributes.clear();
    }

    /**
     * <p>
     * Gets the <code>{@link UMLModelManager}</code> object written by this <code>{@link XMIWriter}</code>.
     * </p>
     *
     * @return the <code>UMLModelManager</code> object written by this <code>XMIWriter</code>.
     */
    public UMLModelManager getUMLModelManager() {
        return manager;
    }

    /**
     * <p>
     * Writes the xmi data retrieved from <code>{@link UMLModelManager}</code> object into a file.
     * </p>
     * <p>
     * If the <code>withDiagramData</code> flag is <code>true</code>, all the model, activity graphs and diagrams
     * data from <code>{@link UMLModelManager}</code> object will be written to the output file; if it is
     * <code>false</code>, only the model and activity graphs data from <code>{@link UMLModelManager}</code> will
     * be written to the output file. This method will also write the xmi root attributes and the header data if they
     * are present. If the file doesn't exist, a new file is created, and if it already exists, the old content will be
     * overwritten.
     * </p>
     *
     * @param outputFile
     *            the output file to write the xmi data.
     * @param withDiagramData
     *            a flag indicating the diagrams data should be written or not.
     * @throws IllegalArgumentException
     *             if the outputFile is <code>null</code>.
     * @throws UnknownElementException
     *             if the xmiId for a specific element to get is not defined.
     * @throws ElementAlreadyExistsException
     *             if the xmiId for a specific element to add already exists.
     * @throws IOException
     *             if any i/o error occurs.
     * @throws XMITransformException
     *             if any error occurs during the transform, this exception is mainly used to wrap the underlying
     *             exceptions.
     * @see #transform(OutputStream, boolean)
     */
    public void transform(File outputFile, boolean withDiagramData) throws IOException, UnknownElementException,
            ElementAlreadyExistsException, XMITransformException {
        Helper.validateObject(outputFile, "outputFile");

        // create nonexistent parent directories
        if (outputFile.getParentFile() != null) {
            outputFile.getParentFile().mkdirs();
        }
        OutputStream outputStream = new FileOutputStream(outputFile);
        try {
            // delegate to other transform method.
            transform(outputStream, withDiagramData);
        } finally {
            closeStream(outputStream);
        }
    }

    /**
     * <p>
     * Close the output stream.
     * </p>
     *
     * @param outputStream
     *            the output stream need to be closed.
     */
    private void closeStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                // ignore
            }
        }
    }

    /**
     * <p>
     * Writes the xmi data retrieved from <code>{@link UMLModelManager}</code> object into the output stream.
     * </p>
     * <p>
     * If the <code>withDiagramData</code> flag is <code>true</code>, all the model, activity graphs and diagrams
     * data from <code>{@link UMLModelManager}</code> object will be written to the output stream; if it is
     * <code>false</code>, only the model and activity graphs data from <code>{@link UMLModelManager}</code> will
     * be written to the output stream. This method will also write the xmi root attributes and the header data if they
     * are present. If the file doesn't exist, a new file is created, and if it already exists, the old content will be
     * overwritten.
     * </p>
     *
     * @param outputStream
     *            the output stream to write the xmi data.
     * @param withDiagramData
     *            a flag indicating the diagrams data should be written or not.
     * @throws IllegalArgumentException
     *             if the outputStream is <code>null</code>.
     * @throws UnknownElementException
     *             if the xmiId for a specific element to get is not defined.
     * @throws ElementAlreadyExistsException
     *             if the xmiId for a specific element to add already exists.
     * @throws IOException
     *             if any i/o error occurs.
     * @throws XMITransformException
     *             if any error occurs during the transform, this exception is mainly used to wrap the underlying
     *             exceptions.
     */
    public void transform(OutputStream outputStream, boolean withDiagramData) throws IOException,
            UnknownElementException, ElementAlreadyExistsException, XMITransformException {
        Helper.validateObject(outputStream, "outputStream");

        // create an PrintStream object
        PrintStream printStream = new PrintStream(outputStream);
        // print xml head.
        printStream.println("<?xml version='1.0' encoding='UTF-8'?>");
        // print the starting XMI root node.
        printStream.print("<XMI");
        // attributes
        for (Entry<String, String> entry : xmiRootAttributes.entrySet()) {
            printStream.print(" ");
            printStream.print(entry.getKey() + "=\'" + entry.getValue() + "\'");
        }
        printStream.println(">");

        // print the xmi header info.
        XMITransformer transformer = transformers.get(TransformerType.Header);
        if (transformer != null) {
            transformer.transform(null, printStream);
        }

        // print the starting the <XMI.content> node.
        printStream.println("<XMI.content>");
        // transform the model.
        transformers.get(TransformerType.Model).transform(manager.getModel(), printStream);

        // transform all the activity graphs
        transformer = transformers.get(TransformerType.ActivityGraph);
        for (ActivityGraph activityGraph : manager.getActivityGraphs()) {
            transformer.transform(activityGraph, printStream);
        }

        // transform all the diagrams if needed.
        if (withDiagramData) {
            transformer = transformers.get(TransformerType.Diagram);
            for (Diagram diagram : manager.getDiagrams()) {
                transformer.transform(diagram, printStream);
            }
        }
        // print the ending <XMI.content> node.
        printStream.println("</XMI.content>");
        // print the ending XMI root node
        printStream.println("</XMI>");

        // flush the stream and check error
        if (printStream.checkError()) {
            throw new IOException("an I/O error occurs while printing out data.");
        }
    }

    /**
     * <p>
     * Writes the xmi data retrieved from <code>{@link UMLModelManager}</code> object into a zip file, the data written
     * to the file will be compressed.
     * </p>
     * <p>
     * If the <code>withDiagramData</code> flag is <code>true</code>, all the model, activity graphs and diagrams
     * data from <code>{@link UMLModelManager}</code> object will be written to the zip file; if it is
     * <code>false</code>, only the model and activity graphs data from <code>{@link UMLModelManager}</code> will
     * be written to the zip file. This method will also write the xmi root attributes and the header data if they are
     * present. If the file doesn't exist, a new file is created, and if it already exists, the old content will be
     * overwritten.
     * </p>
     *
     * @param zipFile
     *            the zip file to write the compressed xmi data.
     * @param withDiagramData
     *            a flag indicating the Diagrams data should be written or not.
     * @throws IllegalArgumentException
     *             if the zipFile is <code>null</code>.
     * @throws UnknownElementException
     *             if the xmiId for a specific element to get is not defined.
     * @throws ElementAlreadyExistsException
     *             if the xmiId for a specific element to add already exists.
     * @throws IOException
     *             if any i/o error occurs.
     * @throws XMITransformException
     *             if any error occurs during the transform, this exception is mainly used to wrap the underlying
     *             exceptions.
     * @see #transform(OutputStream, boolean)
     */
    public void transformToZipFile(File zipFile, boolean withDiagramData) throws IOException, UnknownElementException,
            ElementAlreadyExistsException, XMITransformException {
        Helper.validateObject(zipFile, "zipFile");

        // create nonexistent parent directories
        if (zipFile.getParentFile() != null) {
            zipFile.getParentFile().mkdirs();
        }
        // create output stream
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));

        // remove the extension if found
        String baseName = zipFile.getName();
        int period = baseName.lastIndexOf('.');
        if (period > -1) {
            baseName = baseName.substring(0, period);
        }
        // put new entry in the zip file
        zipOut.putNextEntry(new ZipEntry(baseName + ".xmi"));

        try {
            transform(zipOut, withDiagramData);
        } finally {
            closeStream(zipOut);
        }
    }
}
