/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.failuretests;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Reference;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.InitialDiagramElementFormatter;
import com.topcoder.uml.projectconfiguration.InitialElementFormatter;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.uml.projectconfiguration.diagramelementformatters.PropertyTemplateDiagramElementFormatter;
import com.topcoder.uml.projectconfiguration.modelelementformatters.JavaExceptionElementFormatter;
import com.topcoder.uml.projectconfiguration.stereotypeloader.XMLStereotypeLoader;
import com.topcoder.uml.standardclassloader.StandardClassDataLoader;

import junit.framework.TestCase;


/**
 * Unit tests for ProjectConfigurationManager class.
 * @author crackme
 * @version 1.0
 */
public class TestProjectConfigurationManager extends TestCase {
    /** A XMLStereotypeLoader used to test. */
    private XMLStereotypeLoader sLoader;

    /**
     * A UMLModelManager used to test.
     */
    private UMLModelManager m = new UMLModelManager();
    private InitialElementFormatter formatter;
    private InitialDiagramElementFormatter df;

    /**
     * A ProjectConfigurationManager used to test.
     */
    private ProjectConfigurationManager manager;

    /**
     * a StandardClassDataLoader used to test.
     */
    private final StandardClassDataLoader cLoader = new MockStandardClassDataLoader();

    /**
     * Setup the environment for each testcase.
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfigFile("test_files/failure/conf.xml");
        sLoader = new XMLStereotypeLoader("XMLStereotypeLoader.acc");

        formatter = new JavaExceptionElementFormatter(m, "Java");
        df = new PropertyTemplateDiagramElementFormatter();
        manager = new ProjectConfigurationManager(m, cLoader, sLoader,
                "ProjectConfigurationManager.acc");
    }

    /**
     * Setup the environment for each testcase.
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        TestHelper.clearConfig();
    }

    /**
     * Tests ProjectConfigurationManager(UMLModelManager umlModelManager, String namespace) method with null UMLModelManager umlModelManager,
     * Expected IllegalArgumentException.
     */
    public void testProjectConfigurationManager1_NullUmlModelManager() {
        try {
            new ProjectConfigurationManager(null,
                "com.topcoder.uml.projectconfiguration.ProjectConfigurationManager");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests ProjectConfigurationManager(UMLModelManager umlModelManager, String namespace) method with null String namespace,
     * Expected IllegalArgumentException.
     */
    public void testProjectConfigurationManager_NullNamespace() {
        try {
            new ProjectConfigurationManager(m, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests ProjectConfigurationManager(UMLModelManager umlModelManager, String namespace) method with empty String namespace,
     * Expected IllegalArgumentException.
     */
    public void testProjectConfigurationManager_EmptyNamespace() {
        try {
            new ProjectConfigurationManager(m, " ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests ProjectConfigurationManager(UMLModelManager umlModelManager) method with null UMLModelManager umlModelManager,
     * Expected IllegalArgumentException.
     */
    public void testProjectConfigurationManager_NullUmlModelManager() {
        try {
            new ProjectConfigurationManager(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getStandardStereotypes(String language, String elementType) method with null String language,
     * Expected IllegalArgumentException.
     */
    public void testGetStandardStereotypes_NullLanguage() {
        try {
            manager.getStandardStereotypes(null, "Class");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getStandardStereotypes(String language, String elementType) method with empty String language,
     * Expected IllegalArgumentException.
     */
    public void testGetStandardStereotypes_EmptyLanguage() {
        try {
            manager.getStandardStereotypes(" ", "Class");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getStandardStereotypes(String language, String elementType) method with null String elementType,
     * Expected IllegalArgumentException.
     */
    public void testGetStandardStereotypes_NullElementType() {
        try {
            manager.getStandardStereotypes("Java", null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getStandardStereotypes(String language, String elementType) method with empty String elementType,
     * Expected IllegalArgumentException.
     */
    public void testGetStandardStereotypes_EmptyElementType() {
        try {
            manager.getStandardStereotypes("Java", " ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getStandardNamespaces(String language) method with null String language,
     * Expected IllegalArgumentException.
     */
    public void testGetStandardNamespaces_NullLanguage() {
        try {
            manager.getStandardNamespaces(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getStandardNamespaces(String language) method with empty String language,
     * Expected IllegalArgumentException.
     */
    public void testGetStandardNamespaces_EmptyLanguage() {
        try {
            manager.getStandardNamespaces(" ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getDefaultProjectLanguage method with invalid configurable file,
     * Expected ProjectConfigurationException.
     * @throws ProjectConfigurationException to Junit.
     */
    public void testGetDefaultProjectLanguage_Invalid1()
        throws ProjectConfigurationException {
        ProjectConfigurationManager pcm = new ProjectConfigurationManager(m,
                cLoader, sLoader, "getDefaultProjectLanguage.fail1");

        try {
            pcm.getDefaultProjectLanguage();
            fail("ProjectConfigurationException should be thrown.");
        } catch (ProjectConfigurationException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests getDefaultProjectLanguage method with invalid configurable file,
     * Expected ProjectConfigurationException.
     * @throws ProjectConfigurationException to Junit.
     */
    public void testGetDefaultProjectLanguage_Invalid2()
        throws ProjectConfigurationException {
        ProjectConfigurationManager pcm = new ProjectConfigurationManager(m,
                cLoader, sLoader, "getDefaultProjectLanguage.fail2");

        try {
            pcm.getDefaultProjectLanguage();
            fail("ProjectConfigurationException should be thrown.");
        } catch (ProjectConfigurationException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests applyInitialFormatting(String language, ModelElement element) method with null String language,
     * Expected IllegalArgumentException.
     */
    public void testApplyInitialFormatting1_NullLanguage() {
        try {
            manager.applyInitialFormatting(null, new GraphNode());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests applyInitialFormatting(String language, ModelElement element) method with empty String language,
     * Expected IllegalArgumentException.
     */
    public void testApplyInitialFormatting1_EmptyLanguage() {
        try {
            manager.applyInitialFormatting(" ", new GraphNode());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests applyInitialFormatting(String language, ModelElement element) method with null ModelElement element,
     * Expected IllegalArgumentException.
     */
    public void testApplyInitialFormatting1_NullElement() {
        try {
            manager.applyInitialFormatting("Java", (ModelElement) null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests applyInitialFormatting(String language, DiagramElement element) method with null String language,
     * Expected IllegalArgumentException.
     */
    public void testApplyInitialFormatting_NullLanguage() {
        try {
            manager.applyInitialFormatting(null, new Reference());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests applyInitialFormatting(String language, DiagramElement element) method with empty String language,
     * Expected IllegalArgumentException.
     */
    public void testApplyInitialFormatting_EmptyLanguage() {
        try {
            manager.applyInitialFormatting(" ", new Reference());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests applyInitialFormatting(String language, DiagramElement element) method with null DiagramElement element,
     * Expected IllegalArgumentException.
     */
    public void testApplyInitialFormatting_NullElement() {
        try {
            manager.applyInitialFormatting("Java", (DiagramElement) null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests addInitialElementFormatter(String language, InitialElementFormatter formatter) method with null String language,
     * Expected IllegalArgumentException.
     */
    public void testAddInitialElementFormatter_NullLanguage() {
        try {
            manager.addInitialElementFormatter(null, formatter);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests addInitialElementFormatter(String language, InitialElementFormatter formatter) method with empty String language,
     * Expected IllegalArgumentException.
     */
    public void testAddInitialElementFormatter_EmptyLanguage() {
        try {
            manager.addInitialElementFormatter(" ", formatter);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests addInitialElementFormatter(String language, InitialElementFormatter formatter) method with null InitialElementFormatter formatter,
     * Expected IllegalArgumentException.
     */
    public void testAddInitialElementFormatter_NullFormatter() {
        try {
            manager.addInitialElementFormatter("Java", null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests addInitialDiagramFormatter(String language, InitialDiagramElementFormatter formatter) method with null String language,
     * Expected IllegalArgumentException.
     */
    public void testAddInitialDiagramFormatter_NullLanguage() {
        try {
            manager.addInitialDiagramFormatter(null, df);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests addInitialDiagramFormatter(String language, InitialDiagramElementFormatter formatter) method with empty String language,
     * Expected IllegalArgumentException.
     */
    public void testAddInitialDiagramFormatter_EmptyLanguage() {
        try {
            manager.addInitialDiagramFormatter(" ", df);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests addInitialDiagramFormatter(String language, InitialDiagramElementFormatter formatter) method with null InitialDiagramElementFormatter formatter,
     * Expected IllegalArgumentException.
     */
    public void testAddInitialDiagramFormatter_NullFormatter() {
        try {
            manager.addInitialDiagramFormatter("Java", null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests removeInitialDiagramFormatter(String language, InitialDiagramElementFormatter formatter) method with null String language,
     * Expected IllegalArgumentException.
     */
    public void testRemoveInitialDiagramFormatter_NullLanguage() {
        try {
            manager.removeInitialDiagramFormatter(null, df);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests removeInitialDiagramFormatter(String language, InitialDiagramElementFormatter formatter) method with empty String language,
     * Expected IllegalArgumentException.
     */
    public void testRemoveInitialDiagramFormatter_EmptyLanguage() {
        try {
            manager.removeInitialDiagramFormatter(" ", df);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests removeInitialDiagramFormatter(String language, InitialDiagramElementFormatter formatter) method with null InitialDiagramElementFormatter formatter,
     * Expected IllegalArgumentException.
     */
    public void testRemoveInitialDiagramFormatter_NullFormatter() {
        try {
            manager.removeInitialDiagramFormatter("Java", null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests removeInitialElementFormatter(String language, InitialElementFormatter formatter) method with null String language,
     * Expected IllegalArgumentException.
     */
    public void testRemoveInitialElementFormatter_NullLanguage() {
        try {
            manager.removeInitialElementFormatter(null, formatter);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests removeInitialElementFormatter(String language, InitialElementFormatter formatter) method with empty String language,
     * Expected IllegalArgumentException.
     */
    public void testRemoveInitialElementFormatter_EmptyLanguage() {
        try {
            manager.removeInitialElementFormatter(" ", formatter);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }

    /**
     * Tests removeInitialElementFormatter(String language, InitialElementFormatter formatter) method with null InitialElementFormatter formatter,
     * Expected IllegalArgumentException.
     */
    public void testRemoveInitialElementFormatter_NullFormatter() {
        try {
            manager.removeInitialElementFormatter("Java", null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // ok
        } catch (Exception e) {
            fail("unexpected exception throws.");
        }
    }
}
