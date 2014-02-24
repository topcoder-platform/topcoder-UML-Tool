/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.accuracytests;

import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.uml.projectconfiguration.modelelementformatters.Java14EnumElementFormatter;

import java.util.Collection;
import junit.framework.TestCase;

/**
 * Contains accuracy tests for the Java14EnumElementFormatter class.
 *
 * @author TheCois
 */
public class TestJava14EnumElementFormatter extends TestCase {
    /**
     * Value for textual tests
     */
    private final String someText = "just_a_value";

    /**
     * Represents the default namespace used to test.
     */
    private static final String testNamespace =
        "com.topcoder.uml.projectconfiguration.modelelementformatters.Java14EnumElementFormatter";

    /**
     * Represents the default language used to test.
     */
    private static final String testLanguage = "Java";

    /**
     * The Java14EnumElementFormatter instance for testing.
     */
    private Java14EnumElementFormatter testObject = null;

    /**
     * Represents a uml model manager used to test.
     */
    private final UMLModelManager umlModelManager = new UMLModelManager();

    /**
     * Create the test instance.
     *
     * @throws Exception
     */
    public void setUp() throws Exception {
        Helper.loadConfigFile("accuracy/config.xml");
        testObject = new Java14EnumElementFormatter(testNamespace, umlModelManager, testLanguage);
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
    }

    /**
     * Tear down the test instance.
     *
     * @throws Exception
     */
    public void tearDown() throws Exception {
        testObject = null;
        Helper.clearConfig();
    }

    /**
     * Makes sure the constructor returns a proper object.
     */
    public void testCtor1_1() {
        Java14EnumElementFormatter testObject =
            new Java14EnumElementFormatter(umlModelManager, testLanguage);
        assertNotNull("Constructor failed.", testObject);
    }

    /**
     * Makes sure the constructor sets the attributes properly.
     */
    public void testCtor1_2() {
        Java14EnumElementFormatter testObject =
            new Java14EnumElementFormatter(umlModelManager, testLanguage);

        assertEquals("umlModelManager attribute was incorrectly set", umlModelManager, testObject.getUMLModelManager());
        assertEquals("default language attribute was incorrectly set", testLanguage, testObject.getLanguage());
    }

    /**
     * Makes sure the constructor returns a proper object.
     */
    public void testCtor2_1() {
        Java14EnumElementFormatter testObject =
            new Java14EnumElementFormatter(testNamespace, umlModelManager, testLanguage);
        assertNotNull("Constructor failed.", testObject);
    }

    /**
     * Makes sure the constructor sets the attributes properly.
     */
    public void testCtor2_2() {
        Java14EnumElementFormatter testObject =
            new Java14EnumElementFormatter(testNamespace, umlModelManager, testLanguage);
        assertEquals("namespace attribute was incorrectly set", testNamespace, testObject.getNamespace());
        assertEquals("umlModelManager attribute was incorrectly set", umlModelManager, testObject.getUMLModelManager());
        assertEquals("default language attribute was incorrectly set", testLanguage, testObject.getLanguage());
    }

    /**
     * Test the method format(ModelElement).
     * The model element does not contain an 'exception' stereotype.
     * No modification should be performed.
     *
     * @throws Exception
     */
    public void testformatWhenModificationIsNotRequired() throws Exception {
        ModelElement element = new ClassImpl();
        element.setName(someText);
        assertFalse("Format failed.", testObject.format(element));
    }

    private ModelElement getPreppedElement()  {
        ModelElement element = new ClassImpl();
        element.setName("testElementName");
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("enum");
        element.addStereotype(stereotype);

        return element;
    }

    /**
     * Makes sure format(ModelElement) returns the proper result.
     * We try to format an element with the proper stereotype.
     * It should work.
     *
     * @throws Exception exception to JUnit.
     */
    public void testformat_Effect() throws Exception {
        ModelElement element = getPreppedElement();
        assertTrue("Format failed.", testObject.format(element));
    }

    /**
     * Makes sure format(ModelElement) does the proper job.
     * We try to format an element with the proper stereotype.
     * It should add one method.
     *
     * @throws Exception exception to JUnit.
     */
    public void testformat_GeneralCorrectness() throws Exception {
        ModelElement element = getPreppedElement();
        testObject.format(element);

        assertEquals("Wrong number of methods added.", 1, ((Class) element).getFeatures().size());
    }

    /**
     * Makes sure format(ModelElement) does the proper job.
     * We try to format an element with the proper stereotype.
     * The first operation added should be a private constructor with
     * no parameter.
     *
     * @throws Exception exception to JUnit.
     */
    public void testformat_FirstOperationCorrectness() throws Exception {
        ModelElement element = getPreppedElement();
        testObject.format(element);

        Operation operation = (Operation) ((Class) element).getFeatures().get(0);
        assertEquals("The first method should be a constructor.",
            element.getName(), operation.getName());
        assertEquals("The first method should have no parameter.",
            0, operation.getParameters().size());
        assertEquals("Format failed, the visibility should be private.",
            VisibilityKind.PRIVATE, operation.getVisibility());
    }
    /**
     * Makes sure format(ModelElement) does the proper job.
     * We try to format an element with the proper stereotype.
     *
     * A generalization should be added to the element
     * @throws Exception
     */
    public void testformat_ClassAccuracy() throws Exception {
        ModelElement element = getPreppedElement();
        testObject.format(element);

        Collection<Generalization> generalizations = ((Class) element).getGeneralizations();
        assertEquals("There should be a generalization.", 1, generalizations.size());
    }
}