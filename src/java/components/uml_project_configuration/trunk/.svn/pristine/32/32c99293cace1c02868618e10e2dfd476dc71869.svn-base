/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.stresstests;

import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.uml.projectconfiguration.modelelementformatters.Java14EnumElementFormatter;

import junit.framework.TestCase;

/**
 * Stress test for <code>Java14EnumElementFormatter</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class Java14EnumElementFormatterStressTests extends TestCase {

    /**
     * The <code>Java14EnumElementFormatter</code> instance used to test against.
     */
    private Java14EnumElementFormatter formatter = null;

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
        formatter = new Java14EnumElementFormatter(umlModelManager, "Java");
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
     * Stress test for the method <code>Java14EnumElementFormatter#format(ModelElement)</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testFormat() throws Exception {
        TestHelper.startTimer();
        for (int i = 0; i < TestHelper.NUMBER; i++) {
            ModelElement element = new ClassImpl();
            element.setName("CustomEnum");
            Stereotype stereotype = new StereotypeImpl();
            stereotype.setName("enum");
            element.addStereotype(stereotype);

            assertTrue("True should be returned.", formatter.format(element));
            // validate
            if (i == 0) {
                assertTrue("One operation have been added.", ((Class) element).getFeatures().size() == 1);

                Operation operation = (Operation) ((Class) element).getFeatures().get(0);
                assertEquals("The operation name is not correct.", element.getName(), operation.getName());
                assertEquals("The visibility kind is not correct.", VisibilityKind.PRIVATE, operation.getVisibility());
                assertEquals("The parameter number is not correct.", 0, operation.getParameters().size());

                Collection<Generalization> generalizations = ((Class) element).getGeneralizations();
                assertEquals("One generalization have been added.", 1, generalizations.size());
                Generalization generalization = (Generalization) generalizations.toArray()[0];
                assertEquals("The child is not correct.", element, generalization.getChild());
                assertEquals("The parent is not correct.", "Enum", generalization.getParent().getName());
            }
        }
        TestHelper.printResultMulTimes("Java14EnumElementFormatter#format(ModelElement)");
    }
}
