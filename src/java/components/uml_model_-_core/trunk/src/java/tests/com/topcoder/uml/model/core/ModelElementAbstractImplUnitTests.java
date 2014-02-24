/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.LinkedList;

/**
 * <p>
 * Unit test for <code>ModelElementAbstractImpl</code> class.
 * </p>
 *
 * @author vividmxx
 * @version 1.0
 */
public class ModelElementAbstractImplUnitTests extends TestCase {
    /**
     * This class extends <code>ModelElementAbstractImpl</code>. It is only used in unit test.
     */
    private class ModelElementImpl extends ModelElementAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public ModelElementImpl() {
        }
    }

    /**
     * This class extends <code>NamespaceAbstractImpl</code>. It is only used in unit test.
     */
    private class NamespaceImpl extends NamespaceAbstractImpl {
        /**
         * <p>
         * The default constructor.
         * <p>
         */
        public NamespaceImpl() {
        }
    }

    /**
     * <p>
     * Represents the <code>ModelElementAbstractImpl</code> instance used for tests.
     * </p>
     */
    private ModelElementAbstractImpl testModelElementAbstractImpl;

    /**
     * <p>
     * Set up the test environment.
     * </p>
     */
    protected void setUp() {
        testModelElementAbstractImpl = new ModelElementImpl();
    }

    /**
     * <p>
     * Accuracy test the <code>ModelElementAbstractImpl()</code> constructor. ModelElementAbstractImpl instance should
     * be created.
     * </p>
     */
    public void testModelElementAbstractImplConstructor() {
        assertNotNull("Create ModelElementAbstractImpl object incorrectly.", new ModelElementImpl());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setName(String)</code>, the <code>Name</code> field should be set.
     * </p>
     */
    public void testSetName() {
        String name = "newName";
        testModelElementAbstractImpl.setName(name);
        assertEquals("The Name field should be set.", name, testModelElementAbstractImpl.getName());

        testModelElementAbstractImpl.setName(null);
        assertNull("The Name field should be null.", testModelElementAbstractImpl.getName());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getName()</code>, the <code>Name</code> field should be returned.
     * </p>
     */
    public void testGetName() {
        String name = "newName";
        testModelElementAbstractImpl.setName(name);
        assertEquals("The Name field should be get.", name, testModelElementAbstractImpl.getName());

        testModelElementAbstractImpl.setName(null);
        assertNull("The Name field should be null.", testModelElementAbstractImpl.getName());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setVisibility(VisibilityKind)</code>, the <code>Visibility</code>
     * field should be set.
     * </p>
     */
    public void testSetVisibility() {
        VisibilityKind visibility = VisibilityKind.PACKAGE;
        testModelElementAbstractImpl.setVisibility(visibility);
        assertEquals("The Visibility field should be set.", visibility, testModelElementAbstractImpl.getVisibility());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getVisibility()</code>, the <code>Visibility</code> field should be
     * returned.
     * </p>
     */
    public void testGetVisibility() {
        VisibilityKind visibility = VisibilityKind.PUBLIC;
        testModelElementAbstractImpl.setVisibility(visibility);
        assertEquals("The Visibility field should be get.", visibility, testModelElementAbstractImpl.getVisibility());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setSpecification(boolean)</code>, the <code>Specification</code> field
     * should be set.
     * </p>
     */
    public void testSetSpecification() {
        testModelElementAbstractImpl.setSpecification(true);
        assertTrue("The Specification field should be set.", testModelElementAbstractImpl.isSpecification());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>isSpecification()</code>, the <code>Specification</code> field should
     * be returned.
     * </p>
     */
    public void testIsSpecification() {
        testModelElementAbstractImpl.setSpecification(false);
        assertFalse("The Specification field should be get.", testModelElementAbstractImpl.isSpecification());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addStereotype(Stereotype)</code>.
     * </p>
     */
    public void testAddStereotype() {
        Stereotype stereotype = new StereotypeImpl();
        testModelElementAbstractImpl.addStereotype(stereotype);
        assertTrue("Add stereoType incorrectly.", testModelElementAbstractImpl.containsStereotype(stereotype));
    }

    /**
     * <p>
     * Test the method of <code>addStereotype(Stereotype)</code> with null stereoType. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddStereotypeNullStereotype() {
        try {
            testModelElementAbstractImpl.addStereotype(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeStereotype(Stereotype)</code>.
     * </p>
     */
    public void testRemoveStereotype() {
        Stereotype stereotype = new StereotypeImpl();
        testModelElementAbstractImpl.addStereotype(stereotype);
        assertTrue("Remove stereoType incorrectly.", testModelElementAbstractImpl.removeStereotype(stereotype));
    }

    /**
     * <p>
     * Test the method of <code>removeStereotype(Stereotype)</code> with null stereoType. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveStereoTypeNullStereoType() {
        try {
            testModelElementAbstractImpl.removeStereotype(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearStereotypes()</code>.
     * <p>
     */
    public void testClearStereotypes() {
        testModelElementAbstractImpl.clearStereotypes();
        assertEquals("The count of stereoType should be 0.", 0, testModelElementAbstractImpl.countStereotypes());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getStereotypes()</code>.
     * </p>
     */
    public void testGetStereotypes() {
        testModelElementAbstractImpl.clearStereotypes();
        Collection<Stereotype> stereotypes = new ArrayList<Stereotype>();
        for (int i = 0; i < 3; ++i) {
            Stereotype stereoType = new StereotypeImpl();
            stereotypes.add(stereoType);
            testModelElementAbstractImpl.addStereotype(stereoType);
        }
        assertEquals("Get stereoTypes incorrectly.", stereotypes, testModelElementAbstractImpl.getStereotypes());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsStereotype(Stereotype)</code>.
     * </p>
     */
    public void testContainsStereotype() {
        Stereotype stereoType = new StereotypeImpl();
        testModelElementAbstractImpl.addStereotype(stereoType);
        assertTrue("Contains stereoType incorrectly.", testModelElementAbstractImpl.containsStereotype(stereoType));

        assertFalse("Contains stereoType incorrectly.", testModelElementAbstractImpl
                .containsStereotype(new StereotypeImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsStereotype(Stereotype)</code> with null stereotype. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsStereotypeNullStereotype() {
        try {
            testModelElementAbstractImpl.containsStereotype(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countStereotypes()</code>.
     * </p>
     */
    public void testCountStereotypes() {
        testModelElementAbstractImpl.clearStereotypes();
        assertEquals("The count of stereoTypes should be 0.", 0, testModelElementAbstractImpl.countStereotypes());

        testModelElementAbstractImpl.addStereotype(new StereotypeImpl());
        assertEquals("The count of stereoTypes should be 1.", 1, testModelElementAbstractImpl.countStereotypes());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addTaggedValue(TaggedValue)</code>.
     * </p>
     */
    public void testAddTaggedValue() {
        TaggedValue taggedValue = new TaggedValueImpl();
        testModelElementAbstractImpl.addTaggedValue(taggedValue);
        assertTrue("Add taggedValue incorrectly.", testModelElementAbstractImpl.removeTaggedValue(taggedValue));
    }

    /**
     * <p>
     * Test the method of <code>addTaggedValue(TaggedValue)</code> with null taggedValue. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddTaggedValueNullTaggedValue() {
        try {
            testModelElementAbstractImpl.addTaggedValue(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeTaggedValue(TaggedValue)</code>.
     * </p>
     */
    public void testRemoveTaggedValue() {
        TaggedValue taggedValue = new TaggedValueImpl();
        testModelElementAbstractImpl.addTaggedValue(taggedValue);
        assertTrue("Remove taggedValue incorrectly.", testModelElementAbstractImpl.removeTaggedValue(taggedValue));
    }

    /**
     * <p>
     * Test the method of <code>removeTaggedValue(TaggedValue)</code> with null taggedValue. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveTaggedValueNullTaggedValue() {
        try {
            testModelElementAbstractImpl.removeTaggedValue(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearTaggedValues()</code>.
     * <p>
     */
    public void testClearTaggedValues() {
        testModelElementAbstractImpl.clearTaggedValues();
        assertEquals("The count of taggedValue should be 0.", 0, testModelElementAbstractImpl.countTaggedValues());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getTaggedValues()</code>.
     * </p>
     */
    public void testGetTaggedValues() {
        testModelElementAbstractImpl.clearTaggedValues();
        Collection<TaggedValue> taggedValues = new ArrayList<TaggedValue>();
        for (int i = 0; i < 3; ++i) {
            TaggedValue taggedValue = new TaggedValueImpl();
            taggedValues.add(taggedValue);
            testModelElementAbstractImpl.addTaggedValue(taggedValue);
        }
        assertEquals("Get taggedValues incorrectly.", taggedValues, testModelElementAbstractImpl.getTaggedValues());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsTaggedValue(TaggedValue)</code>.
     * </p>
     */
    public void testContainsTaggedValue() {
        TaggedValue taggedValue = new TaggedValueImpl();
        testModelElementAbstractImpl.addTaggedValue(taggedValue);
        assertTrue("Contains taggedValue incorrectly.", testModelElementAbstractImpl.containsTaggedValue(taggedValue));

        assertFalse("Contains taggedValue incorrectly.", testModelElementAbstractImpl
                .containsTaggedValue(new TaggedValueImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsTaggedValue(TaggedValue)</code> with null taggedValue. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsTaggedValueNullTaggedValue() {
        try {
            testModelElementAbstractImpl.containsTaggedValue(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countTaggedValues()</code>.
     * </p>
     */
    public void testCountTaggedValues() {
        testModelElementAbstractImpl.clearTaggedValues();
        assertEquals("The count of taggedValues should be 0.", 0, testModelElementAbstractImpl.countTaggedValues());

        testModelElementAbstractImpl.addTaggedValue(new TaggedValueImpl());
        assertEquals("The count of taggedValues should be 1.", 1, testModelElementAbstractImpl.countTaggedValues());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addReferenceTag(TaggedValue)</code>.
     * </p>
     */
    public void testAddReferenceTag() {
        TaggedValue referenceTag = new TaggedValueImpl();
        testModelElementAbstractImpl.addReferenceTag(referenceTag);
        assertTrue("Add referenceTag incorrectly.", testModelElementAbstractImpl.removeReferenceTag(referenceTag));
    }

    /**
     * <p>
     * Test the method of <code>addReferenceTag(TaggedValue)</code> with null referenceTag. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddReferenceTagNullTaggedValue() {
        try {
            testModelElementAbstractImpl.addReferenceTag(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeReferenceTag(TaggedValue)</code>.
     * </p>
     */
    public void testRemoveReferenceTag() {
        TaggedValue referenceTag = new TaggedValueImpl();
        testModelElementAbstractImpl.addReferenceTag(referenceTag);
        assertTrue("Remove referenceTag incorrectly.", testModelElementAbstractImpl.removeReferenceTag(referenceTag));
    }

    /**
     * <p>
     * Test the method of <code>removeReferenceTag(TaggedValue)</code> with null referenceTag. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveReferenceTagNullTaggedValue() {
        try {
            testModelElementAbstractImpl.removeReferenceTag(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearReferenceTags()</code>.
     * <p>
     */
    public void testClearReferenceTags() {
        testModelElementAbstractImpl.clearReferenceTags();
        assertEquals("The count of referenceTag should be 0.", 0, testModelElementAbstractImpl.countReferenceTags());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getReferenceTags()</code>.
     * </p>
     */
    public void testGetReferenceTags() {
        testModelElementAbstractImpl.clearReferenceTags();
        Collection<TaggedValue> referenceTags = new ArrayList<TaggedValue>();
        for (int i = 0; i < 3; ++i) {
            TaggedValue referenceTag = new TaggedValueImpl();
            referenceTags.add(referenceTag);
            testModelElementAbstractImpl.addReferenceTag(referenceTag);
        }
        assertEquals("Get referenceTags incorrectly.", referenceTags, testModelElementAbstractImpl.getReferenceTags());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsReferenceTag(ReferenceTag)</code>.
     * </p>
     */
    public void testContainsReferenceTag() {
        TaggedValue referenceTag = new TaggedValueImpl();
        testModelElementAbstractImpl.addReferenceTag(referenceTag);
        assertTrue("Contains referenceTag incorrectly.", testModelElementAbstractImpl
                .containsReferenceTag(referenceTag));

        assertFalse("Contains ReferenceTag incorrectly.", testModelElementAbstractImpl
                .containsReferenceTag(new TaggedValueImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsReferenceTag(ReferenceTag)</code> with null referenceTag. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsReferenceTagNullReferenceTag() {
        try {
            testModelElementAbstractImpl.containsReferenceTag(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countReferenceTags()</code>.
     * </p>
     */
    public void testCountReferenceTags() {
        testModelElementAbstractImpl.clearReferenceTags();
        assertEquals("The count of referenceTags should be 0.", 0, testModelElementAbstractImpl.countReferenceTags());

        testModelElementAbstractImpl.addReferenceTag(new TaggedValueImpl());
        assertEquals("The count of referenceTags should be 1.", 1, testModelElementAbstractImpl.countReferenceTags());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setNamespace(Namespace)</code>, the <code>Namespace</code> field
     * should be set.
     * </p>
     */
    public void testSetNamespace() {
        Namespace namespace = new NamespaceImpl();
        testModelElementAbstractImpl.setNamespace(namespace);
        assertEquals("The Namespace field should be set.", namespace, testModelElementAbstractImpl.getNamespace());

        testModelElementAbstractImpl.setNamespace(null);
        assertNull("The Namespace field should be null.", testModelElementAbstractImpl.getNamespace());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getNamespace()</code>, the <code>Namespace</code> field should be
     * returned.
     * </p>
     */
    public void testGetNamespace() {
        Namespace namespace = new NamespaceImpl();
        testModelElementAbstractImpl.setNamespace(namespace);
        assertEquals("The Namespace field should be get.", namespace, testModelElementAbstractImpl.getNamespace());

        testModelElementAbstractImpl.setNamespace(null);
        assertNull("The Namespace field should be null.", testModelElementAbstractImpl.getNamespace());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addSupplierDependency(Dependency)</code>.
     * </p>
     */
    public void testAddSupplierDependency() {
        Dependency supplierDependency = new DependencyImpl();
        testModelElementAbstractImpl.addSupplierDependency(supplierDependency);
        assertTrue("Add supplierDependency incorrectly.", testModelElementAbstractImpl
                .removeSupplierDependency(supplierDependency));
    }

    /**
     * <p>
     * Test the method of <code>addSupplierDependency(Dependency)</code> with null supplierDependency. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddSupplierDependencyNullDependency() {
        try {
            testModelElementAbstractImpl.addSupplierDependency(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeSupplierDependency(Dependency)</code>.
     * </p>
     */
    public void testRemoveSupplierDependency() {
        Dependency supplierDependency = new DependencyImpl();
        testModelElementAbstractImpl.addSupplierDependency(supplierDependency);
        assertTrue("Remove supplierDependency incorrectly.", testModelElementAbstractImpl
                .removeSupplierDependency(supplierDependency));
    }

    /**
     * <p>
     * Test the method of <code>removeSupplierDependency(Dependency)</code> with null supplierDependency. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveSupplierDependencyNullDependency() {
        try {
            testModelElementAbstractImpl.removeSupplierDependency(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearSupplierDependencies()</code>.
     * <p>
     */
    public void testClearSupplierDependencies() {
        testModelElementAbstractImpl.clearSupplierDependencies();
        assertEquals("The count of supplierDependency should be 0.", 0, testModelElementAbstractImpl
                .countSupplierDependencies());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getSupplierDependencies()</code>.
     * </p>
     */
    public void testGetSupplierDependencies() {
        testModelElementAbstractImpl.clearSupplierDependencies();
        Collection<Dependency> supplierDependencies = new ArrayList<Dependency>();
        for (int i = 0; i < 3; ++i) {
            Dependency supplierDependency = new DependencyImpl();
            supplierDependencies.add(supplierDependency);
            testModelElementAbstractImpl.addSupplierDependency(supplierDependency);
        }
        assertEquals("Get supplierDependencys incorrectly.", supplierDependencies, testModelElementAbstractImpl
                .getSupplierDependencies());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsSupplierDependency(Dependency)</code>.
     * </p>
     */
    public void testContainsSupplierDependency() {
        Dependency supplierDependency = new DependencyImpl();
        testModelElementAbstractImpl.addSupplierDependency(supplierDependency);
        assertTrue("Contains supplierDependency incorrectly.", testModelElementAbstractImpl
                .containsSupplierDependency(supplierDependency));

        assertFalse("Contains supplierDependency incorrectly.", testModelElementAbstractImpl
                .containsSupplierDependency(new DependencyImpl()));
    }

    /**
     * <p>
     * Test the method of
     * <code>containsSupplierDependency(SupplierDependency)</code> with null supplierDependency. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsSupplierDependencyNullSupplierDependency() {
        try {
            testModelElementAbstractImpl.containsSupplierDependency(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countSupplierDependencies()</code>.
     * </p>
     */
    public void testCountSupplierDependencies() {
        testModelElementAbstractImpl.clearSupplierDependencies();
        assertEquals("The count of supplierDependencys should be 0.", 0, testModelElementAbstractImpl
                .countSupplierDependencies());

        testModelElementAbstractImpl.addSupplierDependency(new DependencyImpl());
        assertEquals("The count of supplierDependencys should be 1.", 1, testModelElementAbstractImpl
                .countSupplierDependencies());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addClientDependency(Dependency)</code>.
     * </p>
     */
    public void testAddClientDependency() {
        Dependency clientDependency = new DependencyImpl();
        testModelElementAbstractImpl.addClientDependency(clientDependency);
        assertTrue("Add clientDependency incorrectly.", testModelElementAbstractImpl
                .removeClientDependency(clientDependency));
    }

    /**
     * <p>
     * Test the method of <code>addClientDependency(Dependency)</code> with null clientDependency. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddClientDependencyNullClientDependency() {
        try {
            testModelElementAbstractImpl.addClientDependency(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeClientDependency(Dependency)</code>.
     * </p>
     */
    public void testRemoveClientDependency() {
        Dependency clientDependency = new DependencyImpl();
        testModelElementAbstractImpl.addClientDependency(clientDependency);
        assertTrue("Remove clientDependency incorrectly.", testModelElementAbstractImpl
                .removeClientDependency(clientDependency));
    }

    /**
     * <p>
     * Test the method of <code>removeClientDependency(Dependency)</code> with null clientDependency. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveClientDependencyNullDependency() {
        try {
            testModelElementAbstractImpl.removeClientDependency(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearClientDependencies()</code>.
     * <p>
     */
    public void testClearClientDependencies() {
        testModelElementAbstractImpl.clearClientDependencies();
        assertEquals("The count of clientDependency should be 0.", 0, testModelElementAbstractImpl
                .countClientDependencies());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getClientDependencies()</code>.
     * </p>
     */
    public void testGetClientDependencies() {
        testModelElementAbstractImpl.clearClientDependencies();
        Collection<Dependency> clientDependencies = new ArrayList<Dependency>();
        for (int i = 0; i < 3; ++i) {
            Dependency clientDependency = new DependencyImpl();
            clientDependencies.add(clientDependency);
            testModelElementAbstractImpl.addClientDependency(clientDependency);
        }
        assertEquals("Get clientDependencys incorrectly.", clientDependencies, testModelElementAbstractImpl
                .getClientDependencies());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsClientDependency(Dependency)</code>.
     * </p>
     */
    public void testContainsClientDependency() {
        Dependency clientDependency = new DependencyImpl();
        testModelElementAbstractImpl.addClientDependency(clientDependency);
        assertTrue("Contains clientDependency incorrectly.", testModelElementAbstractImpl
                .containsClientDependency(clientDependency));

        assertFalse("Contains ClientDependency incorrectly.", testModelElementAbstractImpl
                .containsClientDependency(new DependencyImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsClientDependency(Dependency)</code>.) with null clientDependency. Should
     * throw IllegalArgumentException.
     * </p>
     */
    public void testContainsClientDependencyNullClientDependency() {
        try {
            testModelElementAbstractImpl.containsClientDependency(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countClientDependencies()</code>.
     * </p>
     */
    public void testCountClientDependencies() {
        testModelElementAbstractImpl.clearClientDependencies();
        assertEquals("The count of clientDependencys should be 0.", 0, testModelElementAbstractImpl
                .countClientDependencies());

        testModelElementAbstractImpl.addClientDependency(new DependencyImpl());
        assertEquals("The count of clientDependencys should be 1.", 1, testModelElementAbstractImpl
                .countClientDependencies());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addComment(Comment)</code>.
     * </p>
     */
    public void testAddComment() {
        Comment comment = new CommentImpl();
        testModelElementAbstractImpl.addComment(comment);
        assertTrue("Add comment incorrectly.", testModelElementAbstractImpl.removeComment(comment));
    }

    /**
     * <p>
     * Test the method of <code>addComment(Comment)</code> with null comment. Should throw IllegalArgumentException.
     * </p>
     */
    public void testAddCommentNullComment() {
        try {
            testModelElementAbstractImpl.addComment(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeComment(Comment)</code>.
     * </p>
     */
    public void testRemoveComment() {
        Comment comment = new CommentImpl();
        testModelElementAbstractImpl.addComment(comment);
        assertTrue("Remove comment incorrectly.", testModelElementAbstractImpl.removeComment(comment));
    }

    /**
     * <p>
     * Test the method of <code>removeComment(Comment)</code> with null comment. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveCommentNullComment() {
        try {
            testModelElementAbstractImpl.removeComment(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearComments()</code>.
     * <p>
     */
    public void testClearComments() {
        testModelElementAbstractImpl.clearComments();
        assertEquals("The count of comment should be 0.", 0, testModelElementAbstractImpl.countComments());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getComments()</code>.
     * </p>
     */
    public void testGetComments() {
        testModelElementAbstractImpl.clearComments();
        Collection<Comment> comments = new ArrayList<Comment>();
        for (int i = 0; i < 3; ++i) {
            Comment comment = new CommentImpl();
            comments.add(comment);
            testModelElementAbstractImpl.addComment(comment);
        }
        assertEquals("Get comments incorrectly.", comments, testModelElementAbstractImpl.getComments());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsComment(Comment)</code>.
     * </p>
     */
    public void testContainsComment() {
        Comment comment = new CommentImpl();
        testModelElementAbstractImpl.addComment(comment);
        assertTrue("Contains comment incorrectly.", testModelElementAbstractImpl.containsComment(comment));

        assertFalse("Contains Comment incorrectly.", testModelElementAbstractImpl.containsComment(new CommentImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsComment(Comment)</code> with null comment. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsCommentNullComment() {
        try {
            testModelElementAbstractImpl.containsComment(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countComments()</code>.
     * </p>
     */
    public void testCountComments() {
        testModelElementAbstractImpl.clearComments();
        assertEquals("The count of comments should be 0.", 0, testModelElementAbstractImpl.countComments());

        testModelElementAbstractImpl.addComment(new CommentImpl());
        assertEquals("The count of comments should be 1.", 1, testModelElementAbstractImpl.countComments());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>setParameterTemplate(TemplateParameter)</code>, the
     * <code>ParameterTemplate</code> field should be set.
     * </p>
     */
    public void testSetParameterTemplate() {
        TemplateParameter parameterTemplate = new TemplateParameterImpl();
        testModelElementAbstractImpl.setParameterTemplate(parameterTemplate);
        assertEquals("The ParameterTemplate field should be set.", parameterTemplate, testModelElementAbstractImpl
                .getParameterTemplate());

        testModelElementAbstractImpl.setParameterTemplate(null);
        assertNull("The ParameterTemplate field should be null.", testModelElementAbstractImpl.getParameterTemplate());
    }

    /**
     * <p>
     * Accuracy test for the method of <code>getParameterTemplate()</code>, the <code>ParameterTemplate</code>
     * field should be returned.
     * </p>
     */
    public void testGetParameterTemplate() {
        TemplateParameter parameterTemplate = new TemplateParameterImpl();
        testModelElementAbstractImpl.setParameterTemplate(parameterTemplate);
        assertEquals("The ParameterTemplate field should be get.", parameterTemplate, testModelElementAbstractImpl
                .getParameterTemplate());

        testModelElementAbstractImpl.setParameterTemplate(null);
        assertNull("The ParameterTemplate field should be null.", testModelElementAbstractImpl.getParameterTemplate());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addDefaultParameter(TemplateParameter)</code>.
     * </p>
     */
    public void testAddDefaultParameter() {
        TemplateParameter defaultParameter = new TemplateParameterImpl();
        testModelElementAbstractImpl.addDefaultParameter(defaultParameter);
        assertTrue("Add defaultParameter incorrectly.", testModelElementAbstractImpl
                .removeDefaultParameter(defaultParameter));
    }

    /**
     * <p>
     * Test the method of <code>addDefaultParameter(TemplateParameter)</code> with null defaultParameter. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddDefaultParameterNullTemplateParameter() {
        try {
            testModelElementAbstractImpl.addDefaultParameter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeDefaultParameter(TemplateParameter)</code>.
     * </p>
     */
    public void testRemoveDefaultParameter() {
        TemplateParameter defaultParameter = new TemplateParameterImpl();
        testModelElementAbstractImpl.addDefaultParameter(defaultParameter);
        assertTrue("Remove defaultParameter incorrectly.", testModelElementAbstractImpl
                .removeDefaultParameter(defaultParameter));
    }

    /**
     * <p>
     * Test the method of <code>removeDefaultParameter(TemplateParameter)</code> with null defaultParameter. Should
     * throw IllegalArgumentException.
     * </p>
     */
    public void testRemoveDefaultParameterNullTemplateParameter() {
        try {
            testModelElementAbstractImpl.removeDefaultParameter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearDefaultParameters()</code>.
     * <p>
     */
    public void testClearDefaultParameters() {
        testModelElementAbstractImpl.clearDefaultParameters();
        assertEquals("The count of defaultParameter should be 0.", 0, testModelElementAbstractImpl
                .countDefaultParameters());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getDefaultParameters()</code>.
     * </p>
     */
    public void testGetDefaultParameters() {
        testModelElementAbstractImpl.clearDefaultParameters();
        Collection<TemplateParameter> defaultParameters = new ArrayList<TemplateParameter>();
        for (int i = 0; i < 3; ++i) {
            TemplateParameter defaultParameter = new TemplateParameterImpl();
            defaultParameters.add(defaultParameter);
            testModelElementAbstractImpl.addDefaultParameter(defaultParameter);
        }
        assertEquals("Get defaultParameters incorrectly.", defaultParameters, testModelElementAbstractImpl
                .getDefaultParameters());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsDefaultParameter(TemplateParameter)</code>.
     * </p>
     */
    public void testContainsDefaultParameter() {
        TemplateParameter defaultParameter = new TemplateParameterImpl();
        testModelElementAbstractImpl.addDefaultParameter(defaultParameter);
        assertTrue("Contains defaultParameter incorrectly.", testModelElementAbstractImpl
                .containsDefaultParameter(defaultParameter));

        assertFalse("Contains DefaultParameter incorrectly.", testModelElementAbstractImpl
                .containsDefaultParameter(new TemplateParameterImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsDefaultParameter(TemplateParameter)</code> with null templateParameter. Should
     * throw IllegalArgumentException.
     * </p>
     */
    public void testContainsDefaultParameterNullTemplateParameter() {
        try {
            testModelElementAbstractImpl.containsDefaultParameter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countDefaultParameters()</code>.
     * </p>
     */
    public void testCountDefaultParameters() {
        testModelElementAbstractImpl.clearDefaultParameters();
        assertEquals("The count of defaultParameters should be 0.", 0, testModelElementAbstractImpl
                .countDefaultParameters());

        testModelElementAbstractImpl.addDefaultParameter(new TemplateParameterImpl());
        assertEquals("The count of defaultParameters should be 1.", 1, testModelElementAbstractImpl
                .countDefaultParameters());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addTemplateParameter(TemplateParameter)</code>.
     * </p>
     */
    public void testAddTemplateParameterTemplateParameter() {
        TemplateParameter templateParameter = new TemplateParameterImpl();
        testModelElementAbstractImpl.addTemplateParameter(templateParameter);
        assertTrue("Add templateParameter incorrectly.", testModelElementAbstractImpl
                .removeTemplateParameter(templateParameter));
    }

    /**
     * <p>
     * Test the method of <code>addTemplateParameter(TemplateParameter)</code> with null templateParameter. Should
     * throw IllegalArgumentException.
     * </p>
     */
    public void testAddTemplateParameterTemplateParameterNullTemplateParameter() {
        try {
            testModelElementAbstractImpl.addTemplateParameter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>addTemplateParameter(int, TemplateParameter)</code>.
     * <p>
     */
    public void testAddTemplateParameterIntTemplateParameter() {
        TemplateParameter templateParameter = new TemplateParameterImpl();
        testModelElementAbstractImpl.addTemplateParameter(0, templateParameter);
        assertEquals("Add templateParameter incorrectly.", templateParameter, testModelElementAbstractImpl
                .removeTemplateParameter(0));
    }

    /**
     * <p>
     * Test the method of <code>addTemplateParameter(int, TemplateParameter)</code> with negative index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testAddTemplateParameterNegativeIntTemplateParameter() {
        try {
            testModelElementAbstractImpl.addTemplateParameter(-1, new TemplateParameterImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>addTemplateParameter(int, TemplateParameter)</code> with too large index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testAddTemplateParameterTooLargeIntTemplateParameter() {
        try {
            testModelElementAbstractImpl.addTemplateParameter(100000, new TemplateParameterImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>addTemplateParameter(int, TemplateParameter)</code> with null TemplateParameter.
     * Should throw IllegalArgumentException.
     * </p>
     */
    public void testAddTemplateParameterIntNullTemplateParameter() {
        try {
            testModelElementAbstractImpl.addTemplateParameter(0, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>setTemplateParameter(int, TemplateParameter)</code>.
     * </p>
     */
    public void testSetTemplateParameter() {
        TemplateParameter templateParameter1 = new TemplateParameterImpl();
        testModelElementAbstractImpl.addTemplateParameter(0, templateParameter1);

        // replace the templateParameter1 with templateParameter2.
        TemplateParameter templateParameter2 = new TemplateParameterImpl();
        testModelElementAbstractImpl.setTemplateParameter(0, templateParameter2);
        assertEquals("Set templateParameter incorrectly.", templateParameter2, testModelElementAbstractImpl
                .removeTemplateParameter(0));
    }

    /**
     * <p>
     * Test the method of <code>setTemplateParameter(int, TemplateParameter)</code> with negative index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testSetTemplateParameterNegativeInt() {
        try {
            testModelElementAbstractImpl.setTemplateParameter(-1, new TemplateParameterImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>setTemplateParameter(int, TemplateParameter)</code> with too large index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testSetTemplateParameterTooLargeInt() {
        try {
            testModelElementAbstractImpl.setTemplateParameter(10000, new TemplateParameterImpl());
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>setTemplateParameter(int, TemplateParameter)</code> with null templateParameter.
     * Should throw IllegalArgumentException.
     * </p>
     */
    public void testSetTemplateParameterNullTemplateParameter() {
        try {
            testModelElementAbstractImpl.addTemplateParameter(new TemplateParameterImpl());
            testModelElementAbstractImpl.setTemplateParameter(0, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeTemplateParameter(int)</code>.
     * </p>
     */
    public void testRemoveTemplateParameterInt() {
        TemplateParameter templateParameter = new TemplateParameterImpl();
        testModelElementAbstractImpl.addTemplateParameter(0, templateParameter);
        assertEquals("Remove templateParameter incorrectly.", templateParameter, testModelElementAbstractImpl
                .removeTemplateParameter(0));
    }

    /**
     * <p>
     * Test the method of <code>addTemplateParameter(int)</code> with negative index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testRemoveTemplateParameterNegativeInt() {
        try {
            testModelElementAbstractImpl.removeTemplateParameter(-1);
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Test the method of <code>addTemplateParameter(int)</code> with too large index. Should throw
     * IndexOutOfBoundsException.
     * </p>
     */
    public void testRemoveTemplateParameterTooLargeInt() {
        try {
            testModelElementAbstractImpl.removeTemplateParameter(9999);
            fail("IllegalArgumentException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeTemplateParameter(TemplateParameter)</code>.
     * </p>
     */
    public void testRemoveTemplateParameterTemplateParameter() {
        TemplateParameter templateParameter = new TemplateParameterImpl();
        testModelElementAbstractImpl.addTemplateParameter(templateParameter);
        assertTrue("Remove templateParameter incorrectly.", testModelElementAbstractImpl
                .removeTemplateParameter(templateParameter));
    }

    /**
     * <p>
     * Test the method of <code>removeTemplateParameter(TemplateParameter)</code> with null templateParameter. Should
     * throw IllegalArgumentException.
     * </p>
     */
    public void testRemoveTemplateParameterNullTemplateParameter() {
        try {
            testModelElementAbstractImpl.removeTemplateParameter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearTemplateParameters()</code>.
     * </p>
     */
    public void testClearTemplateParameters() {
        testModelElementAbstractImpl.clearTemplateParameters();
        assertEquals("The count of templateParameter should be 0.", 0, testModelElementAbstractImpl
                .countTemplateParameters());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getTemplateParameters()</code>.
     * </p>
     */
    public void testGetTemplateParameters() {
        testModelElementAbstractImpl.clearTemplateParameters();
        List<TemplateParameter> templateParameters = new LinkedList<TemplateParameter>();
        for (int i = 0; i < 5; ++i) {
            TemplateParameter templateParameter = new TemplateParameterImpl();
            templateParameters.add(templateParameter);
            testModelElementAbstractImpl.addTemplateParameter(templateParameter);
        }
        assertEquals("Get templateParameters incorrectly.", templateParameters, testModelElementAbstractImpl
                .getTemplateParameters());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsTemplateParameter(TemplateParameter)</code>.
     * </p>
     */
    public void testContainsTemplateParameter() {
        TemplateParameter templateParameter = new TemplateParameterImpl();
        testModelElementAbstractImpl.addTemplateParameter(templateParameter);
        assertTrue("Contains templateParameter incorrectly.", testModelElementAbstractImpl
                .containsTemplateParameter(templateParameter));

        assertFalse("Contains templateParameter incorrectly.", testModelElementAbstractImpl
                .containsTemplateParameter(new TemplateParameterImpl()));
    }

    /**
     * <p>
     * Test the method of <code>ContainsTemplateParameter(TemplateParameter)</code> with null templateParameter.
     * Should throw IllegalArgumentException.
     * </p>
     */
    public void testContainsTemplateParameterNullTemplateParameter() {
        try {
            testModelElementAbstractImpl.containsTemplateParameter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>indexOfTemplateParameter(TemplateParameter)</code>.
     * </p>
     */
    public void testIndexOfTemplateParameter() {
        TemplateParameter templateParameter = new TemplateParameterImpl();
        testModelElementAbstractImpl.addTemplateParameter(0, templateParameter);
        assertEquals("Index of templateParameter incorrectly.", 0, testModelElementAbstractImpl
                .indexOfTemplateParameter(templateParameter));

        assertEquals("Index of templateParameter incorrectly.", -1, testModelElementAbstractImpl
                .indexOfTemplateParameter(new TemplateParameterImpl()));
    }

    /**
     * <p>
     * Test the method of <code>indexOfTemplateParameter(TemplateParameter)</code> with null templateParameter. Should
     * throw IllegalArgumentException.
     * </p>
     */
    public void testIndexOfTemplateParameterNullTemplateParameter() {
        try {
            testModelElementAbstractImpl.indexOfTemplateParameter(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countTemplateParameters()</code>.
     * </p>
     */
    public void testCountTemplateParameters() {
        testModelElementAbstractImpl.clearTemplateParameters();
        assertEquals("The count of templateParameters should be 0.", 0, testModelElementAbstractImpl
                .countTemplateParameters());

        testModelElementAbstractImpl.addTemplateParameter(new TemplateParameterImpl());
        assertEquals("The count of templateParameters should be 1.", 1, testModelElementAbstractImpl
                .countTemplateParameters());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addTemplateArgument(TemplateArgument)</code>.
     * </p>
     */
    public void testAddTemplateArgument() {
        TemplateArgument templateArgument = new TemplateArgumentImpl();
        testModelElementAbstractImpl.addTemplateArgument(templateArgument);
        assertTrue("Add templateArgument incorrectly.", testModelElementAbstractImpl
                .removeTemplateArgument(templateArgument));
    }

    /**
     * <p>
     * Test the method of <code>addTemplateArgument(TemplateArgument)</code> with null templateArgument. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddTemplateArgumentNullTemplateArgument() {
        try {
            testModelElementAbstractImpl.addTemplateArgument(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeTemplateArgument(TemplateArgument)</code>.
     * </p>
     */
    public void testRemoveTemplateArgument() {
        TemplateArgument templateArgument = new TemplateArgumentImpl();
        testModelElementAbstractImpl.addTemplateArgument(templateArgument);
        assertTrue("Remove templateArgument incorrectly.", testModelElementAbstractImpl
                .removeTemplateArgument(templateArgument));
    }

    /**
     * <p>
     * Test the method of <code>removeTemplateArgument(TemplateArgument)</code> with null templateArgument. Should
     * throw IllegalArgumentException.
     * </p>
     */
    public void testRemoveTemplateArgumentNullTemplateArgument() {
        try {
            testModelElementAbstractImpl.removeTemplateArgument(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearTemplateArguments()</code>.
     * <p>
     */
    public void testClearTemplateArguments() {
        testModelElementAbstractImpl.clearTemplateArguments();
        assertEquals("The count of templateArgument should be 0.", 0, testModelElementAbstractImpl
                .countTemplateArguments());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getTemplateArguments()</code>.
     * </p>
     */
    public void testGetTemplateArguments() {
        testModelElementAbstractImpl.clearTemplateArguments();
        Collection<TemplateArgument> templateArguments = new ArrayList<TemplateArgument>();
        for (int i = 0; i < 3; ++i) {
            TemplateArgument templateArgument = new TemplateArgumentImpl();
            templateArguments.add(templateArgument);
            testModelElementAbstractImpl.addTemplateArgument(templateArgument);
        }
        assertEquals("Get templateArguments incorrectly.", templateArguments, testModelElementAbstractImpl
                .getTemplateArguments());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsTemplateArgument(TemplateArgument)</code>.
     * </p>
     */
    public void testContainsTemplateArgument() {
        TemplateArgument templateArgument = new TemplateArgumentImpl();
        testModelElementAbstractImpl.addTemplateArgument(templateArgument);
        assertTrue("Contains templateArgument incorrectly.", testModelElementAbstractImpl
                .containsTemplateArgument(templateArgument));

        assertFalse("Contains TemplateArgument incorrectly.", testModelElementAbstractImpl
                .containsTemplateArgument(new TemplateArgumentImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsTemplateArgument(TemplateArgument)</code> with null templateArgument. Should
     * throw IllegalArgumentException.
     * </p>
     */
    public void testContainsTemplateArgumentNullTemplateArgument() {
        try {
            testModelElementAbstractImpl.containsTemplateArgument(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countTemplateArguments()</code>.
     * </p>
     */
    public void testCountTemplateArguments() {
        testModelElementAbstractImpl.clearTemplateArguments();
        assertEquals("The count of templateArguments should be 0.", 0, testModelElementAbstractImpl
                .countTemplateArguments());

        testModelElementAbstractImpl.addTemplateArgument(new TemplateArgumentImpl());
        assertEquals("The count of templateArguments should be 1.", 1, testModelElementAbstractImpl
                .countTemplateArguments());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addElementImport(ElementImport)</code>.
     * </p>
     */
    public void testAddElementImport() {
        ElementImport elementImport = new ElementImportImpl();
        testModelElementAbstractImpl.addElementImport(elementImport);
        assertTrue("Add elementImport incorrectly.", testModelElementAbstractImpl.removeElementImport(elementImport));
    }

    /**
     * <p>
     * Test the method of <code>addElementImport(ElementImport)</code> with null elementImport. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddElementImportNullElementImport() {
        try {
            testModelElementAbstractImpl.addElementImport(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeElementImport(ElementImport)</code>.
     * </p>
     */
    public void testRemoveElementImport() {
        ElementImport elementImport = new ElementImportImpl();
        testModelElementAbstractImpl.addElementImport(elementImport);
        assertTrue("Remove elementImport incorrectly.",
            testModelElementAbstractImpl.removeElementImport(elementImport));
    }

    /**
     * <p>
     * Test the method of <code>removeElementImport(ElementImport)</code> with null elementImport. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveElementImportNullElementImport() {
        try {
            testModelElementAbstractImpl.removeElementImport(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearElementImports()</code>.
     * <p>
     */
    public void testClearElementImports() {
        testModelElementAbstractImpl.clearElementImports();
        assertEquals("The count of elementImport should be 0.", 0, testModelElementAbstractImpl.countElementImports());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getElementImports()</code>.
     * </p>
     */
    public void testGetElementImports() {
        testModelElementAbstractImpl.clearElementImports();
        Collection<ElementImport> elementImports = new ArrayList<ElementImport>();
        for (int i = 0; i < 3; ++i) {
            ElementImport elementImport = new ElementImportImpl();
            elementImports.add(elementImport);
            testModelElementAbstractImpl.addElementImport(elementImport);
        }
        assertEquals("Get elementImports incorrectly.", elementImports, testModelElementAbstractImpl
                .getElementImports());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsElementImport(ElementImport)</code>.
     * </p>
     */
    public void testContainsElementImport() {
        ElementImport elementImport = new ElementImportImpl();
        testModelElementAbstractImpl.addElementImport(elementImport);
        assertTrue("Contains elementImport incorrectly.", testModelElementAbstractImpl
                .containsElementImport(elementImport));

        assertFalse("Contains ElementImport incorrectly.", testModelElementAbstractImpl
                .containsElementImport(new ElementImportImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsElementImport(ElementImport)</code> with null elementImport. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsElementImportNullElementImport() {
        try {
            testModelElementAbstractImpl.containsElementImport(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countElementImports()</code>.
     * </p>
     */
    public void testCountElementImports() {
        testModelElementAbstractImpl.clearElementImports();
        assertEquals("The count of elementImports should be 0.", 0, testModelElementAbstractImpl.countElementImports());

        testModelElementAbstractImpl.addElementImport(new ElementImportImpl());
        assertEquals("The count of elementImports should be 1.", 1, testModelElementAbstractImpl.countElementImports());
    }

    /**
     * <p>
     * Accuracy test the method of <code>addBehavior(StateMachine)</code>.
     * </p>
     */
    public void testAddBehavior() {
        StateMachine behavior = new StateMachineImpl();
        testModelElementAbstractImpl.addBehavior(behavior);
        assertTrue("Add behavior incorrectly.", testModelElementAbstractImpl.removeBehavior(behavior));
    }

    /**
     * <p>
     * Test the method of <code>addBehavior(StateMachine)</code> with null behavior. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testAddBehaviorNullStateMachine() {
        try {
            testModelElementAbstractImpl.addBehavior(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>removeBehavior(StateMachine)</code>.
     * </p>
     */
    public void testRemoveBehavior() {
        StateMachine behavior = new StateMachineImpl();
        testModelElementAbstractImpl.addBehavior(behavior);
        assertTrue("Remove behavior incorrectly.", testModelElementAbstractImpl.removeBehavior(behavior));
    }

    /**
     * <p>
     * Test the method of <code>removeBehavior(StateMachine)</code> with null behavior. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testRemoveBehaviorNullStateMachine() {
        try {
            testModelElementAbstractImpl.removeBehavior(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>clearBehaviors()</code>.
     * <p>
     */
    public void testClearBehaviors() {
        testModelElementAbstractImpl.clearBehaviors();
        assertEquals("The count of behavior should be 0.", 0, testModelElementAbstractImpl.countBehaviors());
    }

    /**
     * <p>
     * Accuracy test the method of <code>getBehaviors()</code>.
     * </p>
     */
    public void testGetBehaviors() {
        testModelElementAbstractImpl.clearBehaviors();
        Collection<StateMachine> behaviors = new ArrayList<StateMachine>();
        for (int i = 0; i < 3; ++i) {
            StateMachine behavior = new StateMachineImpl();
            behaviors.add(behavior);
            testModelElementAbstractImpl.addBehavior(behavior);
        }
        assertEquals("Get behaviors incorrectly.", behaviors, testModelElementAbstractImpl.getBehaviors());
    }

    /**
     * <p>
     * Accuracy test the method of <code>containsBehavior(StateMachine)</code>.
     * </p>
     */
    public void testContainsBehavior() {
        StateMachine behavior = new StateMachineImpl();
        testModelElementAbstractImpl.addBehavior(behavior);
        assertTrue("Contains behavior incorrectly.", testModelElementAbstractImpl.containsBehavior(behavior));

        assertFalse("Contains Behavior incorrectly.", testModelElementAbstractImpl
                .containsBehavior(new StateMachineImpl()));
    }

    /**
     * <p>
     * Test the method of <code>containsBehavior(StateMachine)</code> with null behavior. Should throw
     * IllegalArgumentException.
     * </p>
     */
    public void testContainsBehaviorNullBehavior() {
        try {
            testModelElementAbstractImpl.containsBehavior(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Accuracy test the method of <code>countBehaviors()</code>.
     * </p>
     */
    public void testCountBehaviors() {
        testModelElementAbstractImpl.clearBehaviors();
        assertEquals("The count of behaviors should be 0.", 0, testModelElementAbstractImpl.countBehaviors());

        testModelElementAbstractImpl.addBehavior(new StateMachineImpl());
        assertEquals("The count of behaviors should be 1.", 1, testModelElementAbstractImpl.countBehaviors());
    }
}
