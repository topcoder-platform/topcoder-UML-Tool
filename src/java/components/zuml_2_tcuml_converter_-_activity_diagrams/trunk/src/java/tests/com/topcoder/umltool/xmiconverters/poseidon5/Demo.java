/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import java.io.File;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityDiagramImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLPinNodeImpl;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.diagraminterchange.DiagramInterchangeXMIHandler;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;
import com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler;
import com.topcoder.xmi.reader.handlers.uml.model.XMI2ModelHandler;


/**
 * <p>
 * Demo of this component.
 * </p>
 *
 * <p>
 * <strong>Change note: </strong>In version 1.1, the <code>convertModel</code> will return a
 * activity graphs list, and a public method <code>convertDiagrams</code> is added. We change
 * this demo to show these features.
 * </p>
 *
 * @author Rica, zhengjuyu
 * @version 1.0
 * @author flytoj2ee, TCSDEVELOPER
 * @version 1.1
 */
public class Demo extends TestCase {
    /**
     * <p>The XMIReader instance for test.</p>
     */
    private XMIReader reader;

    /**
     * <p>Set up the environment.</p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestHelper.resetConfig();

        //Add configuration for XMIConvertersUtil
        ConfigManager.getInstance().add("XMIConvertersUtil.xml");

        //Add configuration for XMIReader
        TestHelper.loadSingleXMLConfig(XMIReader.class.getName(),
            "test_files" + File.separator + "reader_config.xml");
        TestHelper.loadSingleXMLConfig(ModelElementFactory.class.getName(),
            "test_files" + File.separator + "factory_config.xml");

        reader = new XMIReader();

        //Set up ModelElementFactory for UML:Diagram
        DiagramInterchangeXMIHandler handler = (DiagramInterchangeXMIHandler) reader.getHandler(
                "UML:Diagram");
        handler.setModelElementFactory(new ModelElementFactory(
                ModelElementFactory.class.getName()));

        //Set up ModelElementFactory for UML:Model
        XMI2ModelHandler xhandler = (XMI2ModelHandler) reader.getHandler(
                "UML:Model");
        xhandler.setModelElementFactory(new ModelElementFactory(
                ModelElementFactory.class.getName()));

        //Set up ModelElementFactory for UML:Activity
        ActivityGraphXMIHandler ahandler = (ActivityGraphXMIHandler) reader.getHandler(
                "UML2:Activity");
        ahandler.setModelElementFactory(new ModelElementFactory(
                ModelElementFactory.class.getName()));

        XMIConvertersUtil.config(reader);
    }

    /**
     * <p>Destroy the environment.</p>
     */
    protected void tearDown() {
        TestHelper.resetConfig();
    }

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(Demo.class);
    }

    /**
     * <p>
     * Shows how to read zuml file.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testDemo1() throws Exception {
        //Read the zuml file
        reader.parseZipFile("test_files" + File.separator + "activity.zuml");
    }

    /**
     * <p>
     * Shows how to convert the Model.
     * </p>
     *
     * <p>
     * <strong>Change note:</strong> Shows a list of activity graph is returned.
     * </p>
     *
     * @since 1.1
     *
     * @throws Exception to JUnit.
     */
    public void testDemo2() throws Exception {
        //Read the zuml file
        reader.parseZipFile("test_files" + File.separator + "activity.zuml");

        XMI2ModelHandler xhandler = (XMI2ModelHandler) reader.getHandler(
                "UML:Model");

        UMLModelManager manager = xhandler.getUmlModelManager();

        //Get the built Model
        Model model = manager.getModel();

        //Convert the Model
        List<ActivityGraph> activityGraphs = ActivityDiagramConversionFacade.convertModel(model);

        //Diplay the activity graphs list's size
        System.out.println("There are " + activityGraphs.size() + " activity graphs.");
    }

    /**
     * <p>
     * Shows we can do adjustments before doing the conversion.
     * </p>
     */
    public void testDemo3() {
        ZUMLActivityDiagramImpl activityDiagram = new ZUMLActivityDiagramImpl();

        ZUMLPinNodeImpl node = new ZUMLPinNodeImpl();

        activityDiagram.addNode(node);

        activityDiagram.removeNode(node);

        activityDiagram.convertToTCUML();
    }

    /**
     * <p>
     * Shows how to convert diagrams.
     * </p>
     *
     * <p>
     * <strong>Change note: </strong>This is added in version 1.1
     * </p>
     *
     * @since 1.1
     *
     * @throws Exception to JUnit.
     */
    public void testDemo4() throws Exception {
        //Read the zuml file
        reader.parseZipFile("test_files" + File.separator + "activity.zuml");

        XMI2ModelHandler xhandler = (XMI2ModelHandler) reader.getHandler(
                "UML:Model");

        UMLModelManager manager = xhandler.getUmlModelManager();

        List<Diagram> diagrams = manager.getDiagrams();
        //Display the number of diagrams in the zuml file.
        System.out.println("There are " + diagrams.size() + " diagrams.");

        //convert diagrams to tcuml graph node structure
        ActivityDiagramConversionFacade.convertDiagrams(diagrams);
    }
}
