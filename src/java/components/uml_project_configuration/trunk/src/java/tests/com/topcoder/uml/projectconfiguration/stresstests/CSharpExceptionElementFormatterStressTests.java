/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.stresstests;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.uml.projectconfiguration.modelelementformatters.CSharpExceptionElementFormatter;

import junit.framework.TestCase;

/**
 * Stress test for <code>CSharpExceptionElementFormatter</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class CSharpExceptionElementFormatterStressTests extends TestCase {

    /**
     * The <code>CSharpExceptionElementFormatter</code> instance used to test against.
     */
    private CSharpExceptionElementFormatter formatter = null;

    /**
     * The <code>UMLModelManager</code> instance used for test.
     */
    private UMLModelManager umlModelManager = new UMLModelManager();

    /**
     * Set up the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.setUpConfigManager();
        formatter = new CSharpExceptionElementFormatter(umlModelManager, "CSharp");
        umlModelManager.setProjectConfigurationManager(new ProjectConfigurationManager(umlModelManager));
    }

    /**
     * Tear down the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.tearDownConfigManager();
    }

    /**
     * Stress test for the method <code>CSharpExceptionElementFormatter#format(ModelElement)</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testFormat() throws Exception {
        TestHelper.startTimer();
        for (int i = 0; i < TestHelper.NUMBER; i++) {
            ModelElement element = new ClassImpl();
            element.setName("CustomException");
            Stereotype stereotype = new StereotypeImpl();
            stereotype.setName("exception");
            element.addStereotype(stereotype);

            assertTrue("True should be returned.", formatter.format(element));
            // validate
            if (i == 0) {
                assertTrue("Four operations have been added.", ((Class) element).getFeatures().size() == 4);

                Operation operation1 = (Operation) ((Class) element).getFeatures().get(0);
                assertEquals("The operation name is not correct.", element.getName(), operation1.getName());
                assertEquals("The visibility kind is not correct.", VisibilityKind.PUBLIC, operation1.getVisibility());
                assertEquals("The parameter number is not correct.", 0, operation1.getParameters().size());

                Operation operation2 = (Operation) ((Class) element).getFeatures().get(1);
                assertEquals("The operation name is not correct.", element.getName(), operation2.getName());
                assertEquals("The visibility kind is not correct.", VisibilityKind.PUBLIC, operation2.getVisibility());
                assertEquals("The parameter number is not correct.", 1, operation2.getParameters().size());
                Parameter param1 = operation2.getParameters().get(0);
                assertEquals("The name of the first parameter is not correct.", "message", param1.getName());
                assertEquals("The type of the first parameter is not correct.", "String", param1.getType().getName());

                Operation operation3 = (Operation) ((Class) element).getFeatures().get(2);
                assertEquals("The operation name is not correct.", element.getName(), operation3.getName());
                assertEquals("The visibility kind is not correct.", VisibilityKind.PUBLIC, operation3.getVisibility());
                assertEquals("The parameter number is not correct.", 2, operation3.getParameters().size());
                param1 = operation3.getParameters().get(0);
                assertEquals("The name of the first parameter is not correct.", "message", param1.getName());
                assertEquals("The type of the first parameter is not correct.", "String", param1.getType().getName());
                Parameter param2 = operation3.getParameters().get(1);
                assertEquals("The name of the second parameter is not correct.", "innerException", param2.getName());
                assertEquals("The type of the second parameter is not correct.", "Exception",
                    param2.getType().getName());

                Operation operation4 = (Operation) ((Class) element).getFeatures().get(3);
                assertEquals("The operation name is not correct.", element.getName(), operation4.getName());
                assertEquals("The visibility kind is not correct.", VisibilityKind.PROTECTED,
                    operation4.getVisibility());
                assertEquals("The parameter number is not correct.", 2, operation4.getParameters().size());
                param1 = operation4.getParameters().get(0);
                assertEquals("The name of the first parameter is not correct.", "info", param1.getName());
                assertEquals("The type of the first parameter is not correct.", "SerializationInfo",
                    param1.getType().getName());
                param2 = operation4.getParameters().get(1);
                assertEquals("The name of the second parameter is not correct.", "context", param2.getName());
                assertEquals("The type of the second parameter is not correct.", "StreamingContext",
                    param2.getType().getName());
            }
        }
        TestHelper.printResultMulTimes("CSharpExceptionElementFormatter#format(ModelElement)");
    }
}
