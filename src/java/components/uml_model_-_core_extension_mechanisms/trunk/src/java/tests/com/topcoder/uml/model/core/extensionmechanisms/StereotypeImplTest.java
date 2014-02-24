/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.ModelElement;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class StereotypeImpl.
 * </p>
 *
 * @author BLE
 * @version 1.0
 */
public class StereotypeImplTest extends TestCase {

    /**
     * <p>
     * This instance is used in the test.
     * </p>
     */
    private StereotypeImpl stereotypeImpl = null;

    /**
     * <p>
     * The TagDefinition instance used in the test.
     * </p>
     */
    private TagDefinition tagDefinition = new TagDefinitionImpl();

    /**
     * <p>
     * The ModelElement instance used in the test.
     * </p>
     */
    private ModelElement model = new MethodImpl();

    /**
     * <p>
     * The collection with TagDefinition.
     * </p>
     */
    private Collection<TagDefinition> tagDefinitions = new ArrayList<TagDefinition>();

    /**
     * <p>
     * The collection with ModelElement.
     * </p>
     */
    private Collection<ModelElement> modelElements = new ArrayList<ModelElement>();

    /**
     * <p>
     * The baseClass of the StereotypeImpl instance.
     * </p>
     */
    private String baseClass = "baseClass";

    /**
     * <p>
     * An empty string used as the baseClass of the StereotypeImpl instance.
     * </p>
     */
    private String emptyBaseClass = "  ";

    /**
     * <p>
     * Another string used as the baseClass of the StereotypeImpl instance.
     * </p>
     */
    private String baseClass2 = "baseClass2";

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     */
    protected void setUp() {
        stereotypeImpl = new StereotypeImpl(baseClass, tagDefinitions, modelElements);
    }

    /**
     * <p>
     * Accuracy test of the <code>StereotypeImpl()</code>. The instance is
     * created.
     * </p>
     */
    public void testStereotypeImpl() {
        assertNotNull("The instance should be created.", new StereotypeImpl());
    }

    /**
     * <p>
     * Failure test of
     * <code>StereotypeImpl(String baseClass, Collection&lt;TagDefinition&gt; definedTags,
     * Collection&lt;ModelElement&gt; extendedElements)</code>.
     * </p>
     * <p>
     * definedTags is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testStereotypeImpl2FaliureNullTagDefinitionCollection() {
        try {
            new StereotypeImpl(baseClass, null, modelElements);
            fail("StereotypeImpl(String, Collection<TagDefinition>, Collection<ModelElement>) is incorrect");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>StereotypeImpl(String baseClass, Collection&lt;TagDefinition&gt; definedTags,
     * Collection&lt;ModelElement&gt; extendedElements)</code>.
     * </p>
     * <p>
     * definedTags contains null entries.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testStereotypeImpl2FaliureNullTagDefinitionEntries() {
        try {
            tagDefinitions.add(null);
            new StereotypeImpl(baseClass, tagDefinitions, modelElements);
            fail("StereotypeImpl(String, Collection<TagDefinition>, Collection<ModelElement>) is incorrect");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>StereotypeImpl(String baseClass, Collection&lt;TagDefinition&gt; definedTags,
     * Collection&lt;ModelElement&gt; extendedElements)</code>.
     * </p>
     * <p>
     * extendedElements is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testStereotypeImpl2FaliureNullModelElementCollection() {
        try {
            new StereotypeImpl(baseClass, tagDefinitions, null);
            fail("StereotypeImpl(String, Collection<TagDefinition>, Collection<ModelElement>) is incorrect");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>StereotypeImpl(String baseClass, Collection&lt;TagDefinition&gt; definedTags,
     * Collection&lt;ModelElement&gt; extendedElements)</code>.
     * </p>
     * <p>
     * extendedElements contains null entries.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testStereotypeImpl2FaliureNullModelElementEntries() {
        try {
            modelElements.add(null);
            new StereotypeImpl(baseClass, tagDefinitions, modelElements);
            fail("StereotypeImpl(String, Collection<TagDefinition>, Collection<ModelElement>) is incorrect");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of the
     * <code>StereotypeImpl(String baseClass, Collection&lt;TagDefinition&gt; definedTags,
     * Collection&lt;ModelElement&gt; extendedElements)</code>.
     * The instance is created.
     * </p>
     */
    public void testStereotypeImpl2AccuracyA() {
        assertNotNull("The instance should be created.", stereotypeImpl);
    }

    /**
     * <p>
     * Accuracy test of the
     * <code>StereotypeImpl(String baseClass, Collection&lt;TagDefinition&gt; definedTags,
     * Collection&lt;ModelElement&gt; extendedElements)</code>.
     * The instance is created.
     * </p>
     */
    public void testStereotypeImpl2AccuracyB() {
        assertNotNull("The instance should be created.", new StereotypeImpl(null, tagDefinitions, modelElements));
    }

    /**
     * <p>
     * Accuracy test of the
     * <code>StereotypeImpl(String baseClass, Collection&lt;TagDefinition&gt; definedTags,
     * Collection&lt;ModelElement&gt; extendedElements)</code>.
     * The instance is created.
     * </p>
     */
    public void testStereotypeImpl2AccuracyC() {
        assertNotNull("The instance should be created.", new StereotypeImpl(emptyBaseClass, tagDefinitions,
                modelElements));
    }

    /**
     * <p>
     * Accuracy test of the <code>getBaseClass()</code>.
     * </p>
     */
    public void testGetBaseClass() {
        assertEquals("getBaseClass is incorrect", baseClass, stereotypeImpl.getBaseClass());
    }

    /**
     * <p>
     * Accuracy test of the <code>setBaseClass(String baseClass)</code>. The
     * baseClass is set to be null.
     * </p>
     */
    public void testSetBaseClassAcuracyA() {
        stereotypeImpl.setBaseClass(null);
        assertNull("setBaseClass is incorrect", stereotypeImpl.getBaseClass());
    }

    /**
     * <p>
     * Accuracy test of the <code>setBaseClass(String baseClass)</code>. The
     * baseClass is set to be empty.
     * </p>
     */
    public void testSetBaseClassAcuracyB() {
        stereotypeImpl.setBaseClass(emptyBaseClass);
        assertEquals("setBaseClass is incorrect", emptyBaseClass, stereotypeImpl.getBaseClass());
    }

    /**
     * <p>
     * Accuracy test of the <code>setBaseClass(String baseClass)</code>.
     * </p>
     */
    public void testSetBaseClassAcuracyC() {
        stereotypeImpl.setBaseClass(baseClass2);
        assertEquals("setBaseClass is incorrect", baseClass2, stereotypeImpl.getBaseClass());
    }

    /**
     * <p>
     * Failure test of <code>addDefinedTag(TagDefinition tagDef)</code>.
     * </p>
     * <p>
     * tagDef is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testAddDefinedTagFailure() {
        try {
            stereotypeImpl.addDefinedTag(null);
            fail("addDefinedTag is incorrect");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of the <code>addDefinedTag(TagDefinition tagDef)</code>.
     * </p>
     */
    public void testAddDefinedTagAccuracy() {
        assertFalse("containsDefinedTag is incorrect", stereotypeImpl.containsDefinedTag(tagDefinition));
        stereotypeImpl.addDefinedTag(tagDefinition);
        assertEquals("addDefinedTag is incorrect", stereotypeImpl, tagDefinition.getOwner());
        assertTrue("addDefinedTag is incorrect", stereotypeImpl.containsDefinedTag(tagDefinition));
    }

    /**
     * <p>
     * Failure test of <code>removeDefinedTag(TagDefinition tagDef)</code>.
     * </p>
     * <p>
     * tagDef is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testRemoveDefinedTagFailure() {
        try {
            stereotypeImpl.removeDefinedTag(null);
            fail("removeDefinedTag is incorrect");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of the <code>removeDefinedTag(TagDefinition tagDef)</code>.
     * </p>
     */
    public void testRemoveDefinedTagAccuracyA() {
        assertFalse("containsDefinedTag is incorrect", stereotypeImpl.containsDefinedTag(tagDefinition));
        stereotypeImpl.addDefinedTag(tagDefinition);
        assertTrue("addDefinedTag is incorrect", stereotypeImpl.containsDefinedTag(tagDefinition));
        assertTrue("addDefinedTag is incorrect", stereotypeImpl.removeDefinedTag(tagDefinition));
        assertFalse("removeDefinedTag is incorrect", stereotypeImpl.containsDefinedTag(tagDefinition));
        assertNull("removeDefinedTag is incorrect", tagDefinition.getOwner());
    }

    /**
     * <p>
     * Accuracy test of the <code>removeDefinedTag(TagDefinition tagDef)</code>.
     * </p>
     */
    public void testRemoveDefinedTagAccuracyB() {
        // Construct a new StereotypeImpl instance and TagDefinition instance
        StereotypeImpl stereotypeImpl2 = new StereotypeImpl();
        TagDefinition tagDefinition2 = new TagDefinitionImpl();

        // Add the tagDefinition2 to stereotypeImpl2
        stereotypeImpl2.addDefinedTag(tagDefinition2);

        assertFalse("removeDefinedTag is incorrect", stereotypeImpl.removeDefinedTag(tagDefinition2));
    }

    /**
     * <p>
     * Accuracy test of the <code>removeDefinedTag(TagDefinition tagDef)</code>.
     * </p>
     */
    public void testRemoveDefinedTagAccuracyC() {
        // Construct a new TagDefinition instance
        TagDefinition tagDefinition2 = new TagDefinitionImpl();

        assertFalse("removeDefinedTag is incorrect", stereotypeImpl.removeDefinedTag(tagDefinition2));
    }

    /**
     * <p>
     * Accuracy test of the <code>clearDefinedTags()</code>.
     * </p>
     */
    public void testClearDefinedTags() {
        stereotypeImpl.addDefinedTag(tagDefinition);
        stereotypeImpl.addDefinedTag(tagDefinition);
        assertEquals("addDefinedTag is incorrect", 2, stereotypeImpl.countDefinedTags());
        stereotypeImpl.clearDefinedTags();

        // All elements are removed
        assertEquals("clearDefinedTags is incorrect", 0, stereotypeImpl.countDefinedTags());

        // The owner is set to be null
        assertNull("clearDefinedTags is incorrect", tagDefinition.getOwner());
    }

    /**
     * <p>
     * Accuracy test of the <code>getDefinedTags()</code>.
     * </p>
     */
    public void testGetDefinedTagsAccuracyA() {
        assertEquals("getDefinedTags is incorrect", 0, stereotypeImpl.getDefinedTags().size());
    }

    /**
     * <p>
     * Accuracy test of the <code>getDefinedTags()</code>.
     * </p>
     */
    public void testGetDefinedTagsAccuracyB() {
        stereotypeImpl.addDefinedTag(tagDefinition);
        stereotypeImpl.addDefinedTag(tagDefinition);
        assertEquals("getDefinedTags is incorrect", 2, stereotypeImpl.getDefinedTags().size());
        assertTrue("getDefinedTags is incorrect", stereotypeImpl.getDefinedTags().contains(tagDefinition));
    }

    /**
     * <p>
     * Failure test of the <code>getDefinedTags()</code>. The modifictaion of
     * the returned Collection will result in UnsupportedOperationException.
     * </p>
     */
    public void testGetDefinedTagsFailure() {
        stereotypeImpl.addDefinedTag(tagDefinition);
        stereotypeImpl.addDefinedTag(tagDefinition);
        try {
            stereotypeImpl.getDefinedTags().clear();
            fail("getDefinedTags is incorrect");
        } catch (UnsupportedOperationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of the
     * <code>containsDefinedTag(TagDefinition tagDef)</code>.
     * </p>
     */
    public void testContainsDefinedTag() {
        assertFalse("containsDefinedTag is incorrect", stereotypeImpl.containsDefinedTag(tagDefinition));
        stereotypeImpl.addDefinedTag(tagDefinition);
        assertTrue("addDefinedTag is incorrect", stereotypeImpl.containsDefinedTag(tagDefinition));
    }

    /**
     * <p>
     * Accuracy test of the <code>countDefinedTags()</code>.
     * </p>
     */
    public void testCountDefinedTags() {
        stereotypeImpl.addDefinedTag(tagDefinition);
        stereotypeImpl.addDefinedTag(tagDefinition);
        assertEquals("countDefinedTags is incorrect", 2, stereotypeImpl.countDefinedTags());
        stereotypeImpl.clearDefinedTags();
        assertEquals("countDefinedTags is incorrect", 0, stereotypeImpl.countDefinedTags());
    }

    /**
     * <p>
     * Failure test of the <code>addExtendedElement(ModelElement element)</code>.
     * </p>
     * <p>
     * element is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testAddExtendedElementFaliure() {
        try {
            stereotypeImpl.addExtendedElement(null);
            fail("addExtendedElement is incorrect");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of the <code>addExtendedElement(ModelElement)</code>.
     * </p>
     */
    public void testAddExtendedElementAccuracy() {
        assertEquals("countExtendedElements is incorrect", 0, stereotypeImpl.countExtendedElements());
        stereotypeImpl.addExtendedElement(model);
        assertEquals("countExtendedElements is incorrect", 1, stereotypeImpl.countExtendedElements());
    }

    /**
     * <p>
     * Failure test of the
     * <code>removeExtendedElement(ModelElement element)</code>.
     * </p>
     * <p>
     * element is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testRemoveExtendedElementFailure() {
        try {
            stereotypeImpl.removeExtendedElement(null);
            fail("removeExtendedElement is incorrect");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of the <code>removeDefinedTag(ModelElement element)</code>.
     * </p>
     */
    public void testRemoveExtendedElementAccuracy() {
        stereotypeImpl.addExtendedElement(model);
        assertEquals("countExtendedElements is incorrect", 1, stereotypeImpl.countExtendedElements());
        stereotypeImpl.removeExtendedElement(model);
        assertEquals("removeExtendedElement is incorrect", 0, stereotypeImpl.countExtendedElements());
    }

    /**
     * <p>
     * Accuracy test of the <code>clearExtendedElements()</code>.
     * </p>
     */
    public void testClearExtendedElements() {
        stereotypeImpl.addExtendedElement(model);
        stereotypeImpl.addExtendedElement(model);
        assertEquals("countExtendedElements is incorrect", 2, stereotypeImpl.countExtendedElements());
        stereotypeImpl.clearExtendedElements();
        assertEquals("clearExtendedElements is incorrect", 0, stereotypeImpl.countExtendedElements());
    }

    /**
     * <p>
     * Accuracy test of the <code>getExtendedElements()</code>.
     * </p>
     */
    public void testGetExtendedElementsAccuracyA() {
        assertEquals("getExtendedElements is incorrect", 0, stereotypeImpl.getExtendedElements().size());
    }

    /**
     * <p>
     * Accuracy test of the <code>getExtendedElements()</code>.
     * </p>
     */
    public void testGetExtendedElementsAccuracy() {
        stereotypeImpl.addExtendedElement(model);
        stereotypeImpl.addExtendedElement(model);
        assertEquals("getExtendedElements is incorrect", 2, stereotypeImpl.getExtendedElements().size());
        assertTrue("getExtendedElements is incorrect", stereotypeImpl.getExtendedElements().contains(model));
    }

    /**
     * <p>
     * Failure test of the <code>getExtendedElements()</code>. The
     * modifictaion of the returned Collection will result in
     * UnsupportedOperationException.
     * </p>
     */
    public void testGetExtendedElementsFailure() {
        stereotypeImpl.addExtendedElement(model);
        stereotypeImpl.addExtendedElement(model);
        try {
            stereotypeImpl.getExtendedElements().clear();
        } catch (UnsupportedOperationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of the <code>countExtendedElements()</code>.
     * </p>
     */
    public void testContainsExtendedElementAccuracy() {
        assertFalse("containsExtendedElement is incorrect", stereotypeImpl.containsExtendedElement(model));
        stereotypeImpl.addExtendedElement(model);
        assertTrue("containsExtendedElement is incorrect", stereotypeImpl.containsExtendedElement(model));
    }

    /**
     * <p>
     * Failure test of
     * <code>containsExtendedElement(ModelElement element)</code>.
     * </p>
     * <p>
     * element is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testContainsExtendedElementFailure() {
        try {
            stereotypeImpl.containsExtendedElement(null);
            fail("Expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of the <code>countExtendedElements()</code>.
     * </p>
     */
    public void testCountExtendedElements() {
        assertEquals("countExtendedElements is incorrect", 0, stereotypeImpl.countExtendedElements());
        stereotypeImpl.addExtendedElement(model);
        assertEquals("countExtendedElements is incorrect", 1, stereotypeImpl.countExtendedElements());
        stereotypeImpl.removeExtendedElement(model);
        assertEquals("countExtendedElements is incorrect", 0, stereotypeImpl.countExtendedElements());
    }
}
