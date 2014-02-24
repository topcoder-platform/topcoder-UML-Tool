/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.xmi.reader.handlers.ClassHandler;
import com.topcoder.xmi.reader.handlers.OperationHandler;
import com.topcoder.xmi.reader.handlers.PackageHandler;
import com.topcoder.xmi.reader.handlers.StereotypeHandler;

import junit.framework.TestCase;

/**
 * <p>
 * Demonstrates the usage of this component. It will be split to 5 parts: <br>
 * 1) Creating XMIReaders; <br>
 * 2) Managing handlers; <br>
 * 3) Parsing XMI files and data; <br>
 * 4) Managing elements; <br>
 * 5) Managing element properties.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {
    /**
     * XMIReader instance used for demo. Created in setUp method.
     */
    private XMIReader reader;

    /**
     * Sets up demo environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        UnitTestsHelper.unloadConfig();
        reader = new XMIReader();
    }

    /**
     * Clears the demo environment.
     *
     * @throws Exception when error occurs
     */
    protected void tearDown() throws Exception {
        UnitTestsHelper.unloadConfig();
    }

    /**
     * <p>
     * This is the first part of this component demo. It will demonstrate creating XMIReaders.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testDemoForCreatingXMIReaders() throws Exception {
        // There are three ways to create an XMIReader:
        // empty, using the default namespace, and using a named namespace.
        // 1) creates an empty reader; empty the namespace first
        ConfigManager cm = ConfigManager.getInstance();

        if (cm.existsNamespace(XMIReader.DEFAULT_NAMESPACE)) {
            cm.removeNamespace(XMIReader.DEFAULT_NAMESPACE);
        }

        XMIReader reader = new XMIReader();

        // loads the file config.xml.
        // it contains two namespace: XMIReader.DEFAULT_NAMESPACE and "mynamespace"
        cm.add("config.xml");

        // 2) creates XMIReader from default namespace
        XMIReader preconfigDefault = new XMIReader();

        // 3) creates XMIReader from the given namespace
        XMIReader preconfig = new XMIReader("mynamespace");
    }

    /**
     * <p>
     * This is the second part of this component demo. It will demonstrate managing handlers.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testDemoForManagingHandlers() throws Exception {
        // this fictional class extends DefaultXMIHandler
        XMIHandler classHandler = new ClassHandler();
        reader.addHandler("UML:Class", classHandler);
        // can be used to handle more than one type
        reader.addHandler("UML:Interface", classHandler);

        XMIHandler packageHandler = new PackageHandler();
        reader.addHandler("UML:Package", packageHandler);

        XMIHandler stereotypeHandler = new StereotypeHandler();
        reader.addHandler("UML:Stereotype", stereotypeHandler);

        XMIHandler operationHandler = new OperationHandler();
        reader.addHandler("UML:Operation", operationHandler);

        // retrieves a handler; should be ClassHandler.
        System.out.println(reader.getHandler("UML:Class").getClass());

        // should be InterfaceHandler
        System.out.println(reader.getHandler("UML:Interface").getClass());

        // removes a handler
        reader.removeHandler("UML:Interface");
        // should be null
        System.out.println(reader.getHandler("UML:Interface"));

        // The output in console:
        // class com.topcoder.xmi.reader.handlers.ClassHandler
        // class com.topcoder.xmi.reader.handlers.ClassHandler
        // null

    }

    /**
     * <p>
     * This is the third part of this component demo. It will demonstrate parsing XMI files and
     * data.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testDemoForParsingXMIFilesAndData() throws Exception {
        // calls testDemoForManagingHandlers to configure handlers
        testDemoForManagingHandlers();

        File xmiFile = new File("test_files" + File.separator + "sample.xmi");
        // Should parse the file, and only process class, package and
        // stereotype nodes (since we configured handlers for those in testDemoForManagingHandlers),
        // and any child nodes to those nodes. But, any other nodes
        // (e.g., UML:Interface) will be ignored.
        reader.parse(xmiFile);

        // Suppose the PackageHandler processed this and inserted an element with this ID
        // we can get the element and print it out
        Object element = reader.getElement("I3fc39a51m10e2acac631mm7f49");
        System.out.println(element);

        // Should parse the XMI at the given URI.
        reader.parse("file:///" + xmiFile.getAbsolutePath());

        // Suppose the PackageHandler processed this and inserted an element with this ID
        // we can get the element and print it out
        element = reader.getElement("I3fc39a51m10e2acac631mm7f49");
        System.out.println(element);

        // does the same thing, but as an input stream.
        InputStream is = new FileInputStream(xmiFile);
        reader.parse(is);
        is.close();

        // Suppose the ClassHandler processed this and inserted an element with this ID
        // we can get the element and print it out
        element = reader.getElement("I3fc39a51m10e2acac631mm7d42");
        System.out.println(element);

        // Unzips the .zuml then parses it.
        reader.parseZipFile("test_files" + File.separator + "sample.zuml");
        // Suppose the ClassHandler processed this and inserted an element with this ID
        // we can get the element and print it out
        element = reader.getElement("I3fc39a51m10e2acac631mm7d42");
        System.out.println(element);
    }

    /**
     * <p>
     * This is the fourth part of this component demo. It will demonstrate managing elements.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testDemoForManagingElements() throws Exception {
        reader.parseZipFile("test_files" + File.separator + "sample.zuml");
        Object element = reader.getElement("I3fc39a51m10e2acac631mm7d41");
        // changes the element at this id
        reader.putElement("I3fc39a51m10e2acac631mm7d41", new Object());

        // removes the object at this id
        reader.removeElement("I3fc39a51m10e2acac631mm7d41");
    }

    /**
     * <p>
     * This is the fifth part of this component demo. It will demonstrate managing element
     * properties.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testDemoForManagingElementProperties() throws Exception {
        Object operationObject = new Object();
        Object stereotypeObject = new Object();
        /*
         * During parsing, "forward references" will likely be encountered. XMIHandler
         * implementations can still capture properties about elements that have not been fully
         * defined. Specifically, the XMIReader can keep track of which defined elements are
         * "waiting on" forward references. In this XMI fragment, the referenced Stereotype might
         * not have been defined yet, but the XMIHandler for Stereotypes can capture the forward
         * reference:
         * <UML:Operation xmi.id = 'I3d057933m10e2fd324d0mm7242'
         *                name ='XMIReaderConfigException'
         *                visibility = 'public'
         *                isSpecification = 'false'
         *                ownerScope = 'instance'
         *                isQuery = 'false'
         *                concurrency = 'sequential'
         *                isRoot = 'false'
         *                isLeaf = 'false'
         *                 isAbstract = 'false'>
         * <UML:ModelElement.stereotype>
         *             <UML:Stereotype xmi.idref = 'I3fc39a51m10e2acac631mm7e57'/>
         * </UML:ModelElement.stereotype>
         */
        // To capture this, the XMIHandler for Stereotypes would execute:
        reader.putElementProperty("I3fc39a51m10e2acac631mm7e57", "UML:Stereotype", operationObject);

        /*
         * This connects the operationObject with the as-yet-undefined UML:Stereotype object whose
         * id is "I3fc39a51m10e2acac631mm7e57", indicating that the UML:Stereotype property is the
         * property that should be used to connect the two. Later, when the Stereotype is actually
         * found, its XMI fragment might look like this:
         * <UML:Stereotype xmi.id = 'I3fc39a51m10e2acac631mm7e57'
         *                 name = 'create'
         *                 isSpecification = 'false'
         *                 isRoot = 'false'
         *                 isLeaf = 'false'
         *                 isAbstract = 'false'>
         *      <UML:Stereotype.baseClass>BehavioralFeature</UML:Stereotype.baseClass>
         * </UML:Stereotype>
         */

        /*
         * The Stereotype handler could then instantiate a StereotypeObject with all its properties,
         * and then tell all the "waiting" objects about the newly created StereotypeObject.
         */
        Map<String, List> waiting;
        waiting = reader.getElementProperties("I3fc39a51m10e2acac631mm7e57");

        /*
         * Then for each property, and each object on the list of that property, they can be told
         * what the Stereotype object is. Finally, the fictional StereotypeHandler would actually
         * define the Stereotype object in the reader:
         */
        reader.putElement("I3fc39a51m10e2acac631mm7e57", stereotypeObject);
        // which will remove the corresponding entry in the forwardReferences map.
    }
}
