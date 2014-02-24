/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.accuracytests;

import java.io.File;

import com.topcoder.uml.actions.project.ExportToXMIFileAction;
import com.topcoder.uml.modelmanager.UMLModelManager;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test for <code>{@link ExportToXMIFileAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ExportToXMIFileActionAccuracyTests extends TestCase {

    /**
     * <p>
     * Unit test for <code>{@link ExportToXMIFileAction#ExportToXMIFileAction(File, boolean, UMLModelManager)}</code>
     * constructor.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_Accuracy() throws Exception {
        File xmiFile = new File("test_files/out.xmi");
        boolean withDiagramData = true;
        UMLModelManager manager = new UMLModelManager();
        ExportToXMIFileAction exportToXMIFileAction = new ExportToXMIFileAction(xmiFile, withDiagramData, manager);

        // verify
        assertSame("xmiFile field not set.", xmiFile, AccuracyTestHelper
            .getFieldValue(exportToXMIFileAction, "xmiFile"));
        assertSame("modelManager field not set.", manager, AccuracyTestHelper.getFieldValue(exportToXMIFileAction,
            "modelManager"));
        assertTrue("withDiagramData field not set.", ((Boolean) AccuracyTestHelper.getFieldValue(exportToXMIFileAction,
            "withDiagramData")).booleanValue());
    }
}
