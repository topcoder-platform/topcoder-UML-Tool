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
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.uml.projectconfiguration.modelelementformatters.CSharpExceptionElementFormatter;
import com.topcoder.uml.projectconfiguration.modelelementformatters.JavaExceptionElementFormatter;

import junit.framework.TestCase;

/**
 * Unit test for CSharpExceptionElementFormatter.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestCSharpExceptionElementFormatter extends TestCase {
    /**
     * Value for textual tests
     */
    private final String someText = "just_a_value";

    /**
     * Represents the default namespace used to test.
     */
    private static final String testNamespace =
        "com.topcoder.uml.projectconfiguration.modelelementformatters.CSharpExceptionElementFormatter";

    /**
     * Represents the default language used to test.
     */
    private static final String testLanguage = "CSharp";

    /**
     * The CSharpExceptionElementFormatter instance for testing.
     */
    private CSharpExceptionElementFormatter testObject = null;

    /**
     * Represents a uml model manager used to test.
     */
    private final UMLModelManager umlModelManager = new UMLModelManager();

    /**
     * Create the test instance.
     *
     * @throws Exception exception to JUnit.
     */
    public void setUp() throws Exception {
        Helper.loadConfigFile("accuracy/config.xml");
        testObject = new CSharpExceptionElementFormatter(testNamespace, umlModelManager, testLanguage);
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
    }

    /**
     * Tear down the test instance.
     *
     * @throws Exception exception to JUnit.
     */
    public void tearDown() throws Exception {
        testObject = null;
        Helper.clearConfig();
    }

    /**
     * Makes sure the constructor returns a proper object.
     */
    public void testCtor1_1() {
        JavaExceptionElementFormatter testObject =
            new JavaExceptionElementFormatter(umlModelManager, testLanguage);
        assertNotNull("Constructor failed.", testObject);
    }

    /**
     * Makes sure the constructor sets the attributes properly.
     */
    public void testCtor1_2() {
        JavaExceptionElementFormatter testObject =
            new JavaExceptionElementFormatter(umlModelManager, testLanguage);

        assertEquals("umlModelManager attribute was incorrectly set", umlModelManager, testObject.getUMLModelManager());
        assertEquals("default language attribute was incorrectly set", testLanguage, testObject.getLanguage());
    }

    /**
     * Makes sure the constructor returns a proper object.
     */
    public void testCtor2_1() {
        JavaExceptionElementFormatter testObject =
            new JavaExceptionElementFormatter(testNamespace, umlModelManager, testLanguage);
        assertNotNull("Constructor failed.", testObject);
    }

    /**
     * Makes sure the constructor sets the attributes properly.
     */
    public void testCtor2_2() {
        JavaExceptionElementFormatter testObject =
            new JavaExceptionElementFormatter(testNamespace, umlModelManager, testLanguage);
        assertEquals("namespace attribute was incorrectly set", testNamespace, testObject.getNamespace());
        assertEquals("umlModelManager attribute was incorrectly set", umlModelManager, testObject.getUMLModelManager());
        assertEquals("default language attribute was incorrectly set", testLanguage, testObject.getLanguage());
    }

    private ModelElement getPreppedElement()  {
        ModelElement element = new ClassImpl();
        element.setName("testElementName");
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("exception");
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
     * It should add four methods.
     *
     * @throws Exception exception to JUnit.
     */
    public void testformat_GeneralCorrectness() throws Exception {
        ModelElement element = getPreppedElement();
        testObject.format(element);

        assertEquals("Wrong number of methods added.", 4, ((Class) element).getFeatures().size());
    }

    /**
     * Makes sure format(ModelElement) does the proper job.
     * We try to format an element with the proper stereotype.
     * The first operation added should be a constructor with
     * a String parameter.
     *
     * @throws Exception exception to JUnit.
     */
    public void testformat_FirstOperationCorrectness() throws Exception {
        ModelElement element = getPreppedElement();
        testObject.format(element);

        Operation operation = (Operation) ((Class) element).getFeatures().get(0);
        assertEquals("The first method should be a constructor.",
            element.getName(), operation.getName());
        assertEquals("The first method should have no parameters.",
            0, operation.getParameters().size());
    }

    /**
     * Makes sure format(ModelElement) does the proper job.
     * We try to format an element with the proper stereotype.
     * The second operation added should be a constructor with
     * a String parameter.
     *
     * @throws Exception exception to JUnit.
     */
    public void testformat_SecondOperationCorrectness() throws Exception {
        ModelElement element = getPreppedElement();
        testObject.format(element);

        Operation operation = (Operation) ((Class) element).getFeatures().get(1);
        assertEquals("The second method should be a constructor.",
            element.getName(), operation.getName());
        assertEquals("The second method should have one parameter.",
            1, operation.getParameters().size());
        Parameter param = operation.getParameters().get(0);
        assertEquals("The second method's sole parameter should be a String",
            "String", param.getType().getName());
    }

    /**
     * Makes sure format(ModelElement) does the proper job.
     * We try to format an element with the proper stereotype.
     * The third operation added should be a constructor with
     * a String parameter and an Exception parameter.
     *
     * @throws Exception exception to JUnit.
     */
    public void testformat_ThirdOperationCorrectness() throws Exception {
        ModelElement element = getPreppedElement();
        testObject.format(element);

        Operation operation = (Operation) ((Class) element).getFeatures().get(2);
        assertEquals("The third method should be a constructor.",
            element.getName(), operation.getName());
        assertEquals("The third method should have two parameters.",
            2, operation.getParameters().size());

        Parameter param1 = operation.getParameters().get(0);
        assertEquals("The third method's first parameter should be a String",
            "String", param1.getType().getName());

        Parameter param2 = operation.getParameters().get(1);
        assertEquals("The third method's second parameter should be a Exception",
            "Exception", param2.getType().getName());
    }

    /**
     * Makes sure format(ModelElement) does the proper job.
     * We try to format an element with the proper stereotype.
     * The fourth operation added should be a constructor with
     * a String parameter and an Exception parameter.
     *
     * @throws Exception exception to JUnit.
     */
    public void testformat_FourthOperationCorrectness() throws Exception {
        ModelElement element = getPreppedElement();
        testObject.format(element);

        Operation operation = (Operation) ((Class) element).getFeatures().get(3);
        assertEquals("The fourth method should be a constructor.",
            element.getName(), operation.getName());
        assertEquals("The fourth method should have two parameters.",
            2, operation.getParameters().size());

        Parameter param1 = operation.getParameters().get(0);
        assertEquals("The fourth method's first parameter should be a SerializationInfo",
            "SerializationInfo", param1.getType().getName());

        Parameter param2 = operation.getParameters().get(1);
        assertEquals("The fourth method's second parameter should be a StreamingContext",
            "StreamingContext", param2.getType().getName());
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
}