/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.stresstests;

import java.io.File;
import java.util.List;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.xmiconverters.poseidon5.XMISequenceDiagramConverterUtil;
import com.topcoder.xmi.reader.XMIReader;

/**
 * <p>
 * Stress tests for class XMISequenceDiagramConverterUtil.
 * </p>
 *
 * @author extra
 * @version 1.0
 */
public class XMISequenceDiagramConverterUtilStressTests extends BaseStressTests {

    /**
     * Sets up the environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        clearConfig();
        addConfig("XMIReaderAndConverter.xml");
        XMIReader reader = new XMIReader();
        File xmiFile = getFile("Sample.xmi");
        reader.parse(xmiFile);
    }

    /**
     * Tears down the test environment.
     *
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        clearConfig();
    }

    /**
     * <p>
     * Tests method convertCollaborationInModel for stress, it runs 1 times.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testConvertCollaborationInModel() throws Exception {
        begin();
        XMISequenceDiagramConverterUtil.convertCollaborationInModel(UMLModelManager.getInstance().getModel());
        printResult("convertCollaborationInModel", 1);
    }

    /**
     * <p>
     * Tests method convertSequenceDiagrams for stress, it runs 1 times.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testConvertSequenceDiagrams() throws Exception {
        List<Diagram> diagrams = UMLModelManager.getInstance().getDiagrams();
        begin();
        XMISequenceDiagramConverterUtil.convertSequenceDiagrams(diagrams);
        printResult("convertSequenceDiagrams", 1);
    }

    /**
     * <p>
     * Tests method convertSequenceDiagram for stress, it runs 101 times.
     * </p>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testConvertSequenceDiagram() throws Exception {
        List<Diagram> diagrams = UMLModelManager.getInstance().getDiagrams();
        begin();
        int count = diagrams.size();
        for (Diagram diagram : diagrams) {
            XMISequenceDiagramConverterUtil.convertSequenceDiagram(diagram);
        }
        printResult("convertSequenceDiagram", count);
    }
}
