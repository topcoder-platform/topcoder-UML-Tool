/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.Transition;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.Collection;


/**
 * <p>
 * Unit tests for <code>Helper</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class HelperUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(HelperUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for <code>checkNull(Object, String)</code>.
     * If the object is non-null, it should process successfully.
     * </p>
     */
    public void testCheckNull_Accuracy() {
        Helper.checkNull(new Object(), "object");
    }

    /**
     * <p>
     * Failure test for <code>checkNull(Object, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the object is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckNull_Failure() {
        try {
            Helper.checkNull(null, "null");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>checkString(String, String)</code>.
     * If the string is non-null and non-empty, it should process successfully.
     * </p>
     */
    public void testCheckString() {
        Helper.checkString("param", "param");
    }

    /**
     * <p>
     * Failure test for <code>checkString(String, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the string to be checked is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckString_Failure1() {
        try {
            Helper.checkString(null, "null");

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>checkString(String, String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the string to be checked is empty, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckString_Failure2() {
        try {
            Helper.checkString("   ", "empty");

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>checkObjectArray(Object[], String)</code>.
     * </p>
     * <p>
     * If the array is non-null or doesn't contain null element, it should process successfully.
     * </p>
     */
    public void testCheckObjectArray() {
        Helper.checkObjectArray(new Object[0], "empty");
    }

    /**
     * <p>
     * Failure test for <code>checkObjectArray(Object[], String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the array to be checked is null, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckObjectArray_Failure1() {
        try {
            Helper.checkObjectArray(null, "null");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Failure test for <code>checkObjectArray(Object[], String)</code>.
     * </p>
     *
     * <p>
     * Failure cause: If the array to be checked contains null element, IllegalArgumentException is expected.
     * </p>
     */
    public void testCheckObjectArray_Failure2() {
        try {
            Object[] array = new Object[2];
            array[0] = new Object();
            array[1] = null;

            Helper.checkObjectArray(array, "null");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Accuracy test for <code>copyAttributes(ModelElement, ModelElement)</code>.
     * </p>
     *
     * <p>
     * Verify that attributes are copied from source to the destination.
     * </p>
     */
    public void testCopyAttributes() {
        AbstractZUMLActivityNode node = new ZUMLSendSignalActionImpl();

        node.addStereotype(new StereotypeImpl());

        //Verify that these taggedValues won't be copied.
        node.addTaggedValue(new TaggedValueImpl());
        node.addTaggedValue(new TaggedValueImpl());

        node.addReferenceTag(new TaggedValueImpl());
        node.addSupplierDependency(new DependencyImpl());
        node.addClientDependency(new DependencyImpl());
        node.addComment(new CommentImpl());

        TemplateParameter tp = new TemplateParameterImpl();
        node.setParameterTemplate(tp);

        node.addDefaultParameter(new TemplateParameterImpl());
        node.addTemplateParameter(new TemplateParameterImpl());
        node.addTemplateArgument(new TemplateArgumentImpl());
        node.addElementImport(new ElementImportImpl());
        node.addBehavior(new StateMachineImpl());

        ModelElement element = node.convertToTCUML();

        assertEquals("There should be 1 stereotype.", 1,
            element.getStereotypes().size());

        //The taggedValues won't be copied, and this taggedValue is a new one.
        assertEquals("There should be 1 taggedValue.", 1,
            element.getTaggedValues().size());

        assertEquals("There should be 1 referenceTag.", 1,
            element.getReferenceTags().size());
        assertEquals("There should be 1 supplierDependency.", 1,
            element.getSupplierDependencies().size());
        assertEquals("There should be 1 clientDependency.", 1,
            element.getClientDependencies().size());
        assertEquals("There should be 1 comment.", 1,
            element.getComments().size());
        assertEquals("The parameterTemplate should match.", tp,
            element.getParameterTemplate());
        assertEquals("There should be 1 defaultParameter.", 1,
            element.getDefaultParameters().size());
        assertEquals("There should be 1 templateParameter.", 1,
            element.getTemplateParameters().size());
        assertEquals("There should be 1 templateArgument.", 1,
            element.getTemplateArguments().size());
        assertEquals("There should be 1 elementImport.", 1,
            element.getElementImports().size());
        assertEquals("There should be 1 behavior.", 1,
            element.getBehaviors().size());
    }

    /**
     * <p>
     * Accuracy test for <code>getTagDefinition(String)</code>.
     * </p>
     *
     * <p>
     * Verify that the same TagDefinition is returned when the tagType is the same.
     * </p>
     */
    public void testGetTagDefinition() {
        TagDefinition def1 = Helper.getTagDefinition("definition");
        TagDefinition def2 = Helper.getTagDefinition("definition");

        assertEquals("The TagDefinition for the same tagType should match.",
            def1, def2);

        assertEquals("The tagType should be definition.", "definition",
            def1.getTagType());
    }

    /**
     * <p>
     * Accuracy test for <code>convertEdgeToTCUML()</code>.
     * </p>
     *
     * <p>
     * Verify that the edge is converted successfully.
     * </p>
     */
    public void testConvertEdgeToTCUML1() {
        AbstractZUMLActivityEdge edge = new ZUMLActivityEdgeImpl();

        //Set its source, target, guard
        edge.setSource(new ZUMLInitialNodeImpl());
        edge.setTarget(new ZUMLFlowFinalNodeImpl());
        edge.setGuard(new ZUMLOpaqueExpressionImpl());

        //Set its simple attributes
        edge.setName("edge");

        Namespace namespace = new CollaborationImpl();
        edge.setNamespace(namespace);

        edge.setVisibility(null);
        edge.setSpecification(true);

        ModelElement element = edge.convertToTCUML();

        assertTrue("The ZUMLActivityEdgeImpl should be converted to Transition class.",
            element instanceof Transition);

        Transition transition = (Transition) element;

        assertNotNull("It should have a source vertex.", transition.getSource());
        assertNotNull("It should have a target vertex.", transition.getTarget());
        assertNotNull("It should have a guard.", transition.getGuard());

        assertEquals("The name should match.", "edge", element.getName());
        assertEquals("The namespace should match.", namespace,
            element.getNamespace());
        assertNull("The visibility is set to null.", element.getVisibility());
        assertTrue("The specification is set to true.",
            element.isSpecification());
    }

    /**
     * <p>
     * Accuracy test for <code>convertEdgeToTCUML()</code>.
     * </p>
     *
     * <p>
     * Verify that the edge without source, target and guard is converted successfully.
     * </p>
     */
    public void testConvertEdgeToTCUML2() {
        AbstractZUMLActivityEdge edge = new ZUMLActivityEdgeImpl();

        //Set its simple attributes
        edge.setName("edge");

        Namespace namespace = new CollaborationImpl();
        edge.setNamespace(namespace);

        edge.setVisibility(null);
        edge.setSpecification(true);

        ModelElement element = edge.convertToTCUML();

        assertTrue("The ZUMLActivityEdgeImpl should be converted to Transition class.",
            element instanceof Transition);

        assertEquals("The name should match.", "edge", element.getName());
        assertEquals("The namespace should match.", namespace,
            element.getNamespace());
        assertNull("The visibility is set to null.", element.getVisibility());
        assertTrue("The specification is set to true.",
            element.isSpecification());
    }

    /**
     * <p>
     * Accuracy test for <code>clearUsedTagDefinitions()</code>.
     * </p>
     */
    public void testClearUsedTagDefinitions() {
        Helper.getTagDefinition("test");
        Helper.getTagDefinition("test2");

        Helper.clearUsedTagDefinitions();
        assertTrue("The usedTags is cleared.",
            Helper.getUsedTagDefinitions().isEmpty());
    }

    /**
     * <p>
     * Accuracy test for <code>getUsedTagDefinitions()</code>.
     * </p>
     *
     * <p>
     * The used TagDefinitions should be returned.
     * </p>
     */
    public void testGetUsedTagDefinitions() {
        Helper.getTagDefinition("test");

        Collection<TagDefinition> list = Helper.getUsedTagDefinitions();

        boolean existed = false;

        for (TagDefinition def : list) {
            if (def.getTagType().equals("test")) {
                existed = true;
            }
        }

        assertTrue("The test TagDefinition should be included.", existed);
    }
}
