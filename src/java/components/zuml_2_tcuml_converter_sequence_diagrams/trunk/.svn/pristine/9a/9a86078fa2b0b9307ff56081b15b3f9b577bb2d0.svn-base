/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import com.topcoder.diagraminterchange.Diagram;

import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.modelmanager.UMLModelManager;

import com.topcoder.util.config.ConfigManager;

import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.diagraminterchange.DiagramInterchangeXMIHandler;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;
import com.topcoder.xmi.reader.handlers.uml.model.XMI2ModelHandler;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;

import java.util.List;


/**
 * <p>
 * Demo of this component.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class Demo extends TestCase {
    /**
     * <p>XMIReader instance for testing.</p>
     */
    private XMIReader reader;

    /**
     * <p>Set up the environment.</p>
     * @throws Exception if any error occurs
     */
    protected void setUp() throws Exception {
        //Add configuration for XMIConvertersUtil
        ConfigManager.getInstance()
                     .add("test_files" + File.separator + "XMIConvertersUtil.xml");

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
     * Demo1 of this component. It shows how to setup the component.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testDemo1() throws Exception {
        //Configure the RenameConverter and XMIReader
        XMIConvertersUtil.config(reader);

        //It should process successfully
        reader.parse(new File("test_files/zuml_1.xml"));
    }

    /**
     * <p>
     * Demo2 of this component. This demo shows how to convert model to Collaboration.
     * </p>
     * @throws Exception if any error occurs
     */
    public void testDemo2() throws Exception {
        //Configure the RenameConverter and XMIReader
        XMIConvertersUtil.config(reader);

        reader.parse(new File("test_files/zuml_1.xml"));

        XMI2ModelHandler handler = (XMI2ModelHandler) reader.getHandler(
                "UML:Model");
        UMLModelManager manager = handler.getUmlModelManager();
        Model model = manager.getModel();

        assertNotNull("Unable to get the model.", model);

        //Before converted to Collaboration, there is only 2 ownedElement in model
        assertEquals("There should be only 2 ownedElements.", 2,
            model.getOwnedElements().size());

        //It should process successfully
        XMISequenceDiagramConverterUtil.convertCollaborationInModel(model);

        //There is one Interaction in model's first Collaboration, so it should be converted to
        //Collaboration, and added to model. So there is 3 ownedElements in model.
        assertEquals("There should be 3 ownedElements now.", 3,
            model.getOwnedElements().size());
    }

    /**
     * <p>
     * Demo3 of the component. This demo show how to convert a list of SequenceDiagrams from
     * zuml to tcuml.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testDemo3() throws Exception {
        //Configure the RenameConverter and XMIReader
        XMIConvertersUtil.config(reader);

        reader.parse(new File("test_files/zuml_1.xml"));

        DiagramInterchangeXMIHandler handler = (DiagramInterchangeXMIHandler) reader.getHandler(
                "UML:Diagram");
        UMLModelManager manager = handler.getUmlModelManager();

        List<Diagram> diagrams = manager.getDiagrams();

        assertFalse("There are diagrams in the zuml1_1.xml, they should be parsed correctly.",
            diagrams.isEmpty());

        //It should process successfully
        XMISequenceDiagramConverterUtil.convertSequenceDiagrams(diagrams);
    }

    /**
     * <p>
     * Demo4 of the component. This demo show how to convert a SequenceDiagrams from
     * zuml to tcuml.
     * </p>
     *
     * @throws Exception if any error occurs
     */
    public void testDemo4() throws Exception {
        //Configure the RenameConverter and XMIReader
        XMIConvertersUtil.config(reader);

        reader.parse(new File("test_files/zuml_1.xml"));

        DiagramInterchangeXMIHandler handler = (DiagramInterchangeXMIHandler) reader.getHandler(
                "UML:Diagram");
        UMLModelManager manager = handler.getUmlModelManager();

        List<Diagram> diagrams = manager.getDiagrams();

        assertFalse("There are diagrams in the zuml1_1.xml, they should be parsed correctly.",
            diagrams.isEmpty());

        Diagram diagram = (Diagram) diagrams.get(0);

        //It should process successfully
        XMISequenceDiagramConverterUtil.convertSequenceDiagram(diagram);
    }
}
