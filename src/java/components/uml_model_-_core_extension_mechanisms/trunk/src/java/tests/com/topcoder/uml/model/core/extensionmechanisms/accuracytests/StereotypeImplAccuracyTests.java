/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms.accuracytests;

import java.util.ArrayList;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;
/**
 * Accuracy test of the class StereotypeImpl.
 *
 * @author haozhangr
 * @version 1.0
 */
public class StereotypeImplAccuracyTests extends TestCase {
    /**
     * The TagDefinition instance used to test.
     *
     */
    private TagDefinition tag;

    /**
     * The ModelElement instance used in tests.
     *
     */
    private ModelElement element;

    /**
     * The target instnace for accuracy testing.
     */
    private StereotypeImpl instance = null;
    /**
     * The setUp, which create the instance for test.
     */
    protected void setUp() {
        tag = new TagDefinitionImpl();
        element = new TaggedValueImpl();
        instance = new StereotypeImpl();
    }
    /**
     * The accuracy test of the implements ship.
     *
     */
    public void test_implements() {
        assertTrue("StereotypeImpl should implements Stereotype.", instance instanceof Stereotype);
    }
    /**
     * The accuracy test of the default constructor.
     *
     */
    public void test_ctor_accuracy1() {
        assertNotNull("Can not constrct the StereotypeImpl.", instance);
    }
    /**
     * The accuracy test of the constructor with parameters.
     *
     */
    public void testConstructor_accuracy2() {
        assertNotNull("Can not constrct the StereotypeImpl with parameters.",
                new StereotypeImpl("name", new ArrayList<TagDefinition>(), new ArrayList<ModelElement>()));
    }
    /**
     * The unit test of the setter and getter of BaseClass.
     *
     */
    public void test_setBaseClassAndgetBaseClass() {
        instance.setBaseClass("new name");
        assertEquals("The base class is not set properly.", "new name", instance.getBaseClass());
    }
    /**
     * The accuracy test of the method addDefinedTag.
     *
     */
    public void test_addDefinedTag_accuracy() {
        instance.addDefinedTag(tag);
        assertTrue("The tag is not added properly.", instance.containsDefinedTag(tag));
        assertTrue("The tag is not added properly.", instance == tag.getOwner());
    }
    /**
     * The accuracy test of the method removeDefinedTag.
     *
     */
    public void test_removeDefinedTag_accuracy() {
        instance.addDefinedTag(tag);
        assertTrue("The tag is not added properly.", instance.containsDefinedTag(tag));
        assertTrue("The tag is not added properly.", instance == tag.getOwner());
        
        instance.removeDefinedTag(tag);
        assertFalse("The tag is not removed properly.", instance.containsDefinedTag(tag));
        assertFalse("The tag is not removed properly.", instance == tag.getOwner());
    }
    /**
     * The accuracy test of the method clearDefinedTags.
     *
     */
    public void test_clearDefinedTags_accuracy() {
        instance.addDefinedTag(tag);
        assertTrue("The tag is not added properly.", instance.containsDefinedTag(tag));
        assertTrue("The tag is not added properly.", instance == tag.getOwner());
        //clear all the tags
        instance.clearDefinedTags();
        assertFalse("The tag is not removed properly.", instance.containsDefinedTag(tag));
        assertFalse("The tag is not removed properly.", instance == tag.getOwner());
    }
    /**
     * The accuracy test of the method getDefinedTags.
     *
     */
    public void test_getDefinedTags_1_accuracy() {
        instance.addDefinedTag(tag);
        assertEquals("DefinedTag got incorrectly", 1, instance.getDefinedTags().size());
    }
    /**
     * The accuracy test of the method containsDefinedTag.
     *
     */
    public void test_containsDefinedTag_accuracy() {
        instance.addDefinedTag(tag);
        assertTrue("The tag is not added properly.", instance.containsDefinedTag(tag));
    }
    /**
     * The accuracy test of the method countDefinedTags.
     *
     */
    public void test_countDefinedTags_accuracy() {
        instance.addDefinedTag(tag);
        assertEquals("The tag is not added properly.", 1, instance.countDefinedTags());
    }
    /**
     * The accuracy test of the method addExtendedElement.
     *
     */
    public void test_addExtendedElement_accuracy() {
        instance.addExtendedElement(element);
        assertTrue("The element is not added properly.", instance.containsExtendedElement(element));
    }
    /**
     * The accuracy test of the method removeExtendedElement.
     *
     */
    public void test_removeExtendedElement_accuracy() {
        instance.addExtendedElement(element);
        assertTrue("The element is not added properly.", instance.containsExtendedElement(element));
        
        instance.removeExtendedElement(element);
        assertFalse("The element is not removed properly.", instance.containsDefinedTag(tag));
    }
    /**
     * The accuracy test of the method clearExtendedElements.
     *
     */
    public void test_clearExtendedElements_accuracy() {
        instance.addExtendedElement(element);
        assertTrue("The element is not added properly.", instance.containsExtendedElement(element));

        instance.clearExtendedElements();
        assertFalse("The element is not removed properly.", instance.containsExtendedElement(element));
    }
    /**
     * The accuracy test of the method getExtendedElements.
     *
     */
    public void test_getExtendedElements_accuracy() {
        instance.addExtendedElement(element);
        assertEquals("ExtendedElement got incorrectly", 1, instance.getExtendedElements().size());
    }
    /**
     * The accuracy test of the method containsExtendedElement.
     *
     */
    public void test_containsExtendedElement_accuracy() {
        instance.addExtendedElement(element);
        assertTrue("The element is not added properly.", instance.containsExtendedElement(element));
    }
    /**
     * The accuracy test of the method countExtendedElements.
     *
     */
    public void test_countExtendedElements_accuracy() {
        instance.addExtendedElement(element);
        assertEquals("The element is not added properly.", 1, instance.countExtendedElements());
    }
}
