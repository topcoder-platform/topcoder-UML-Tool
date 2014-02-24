/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model.accuracytests;

import java.lang.reflect.Method;
import java.util.List;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.xmi.writer.transformers.model.AttributeDescription;
import com.topcoder.xmi.writer.transformers.model.ChildDescription;
import com.topcoder.xmi.writer.transformers.model.XMIElementDescription;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>XMIElementDescription</c>.
 * </p>
 * 
 * @author catcher
 * @version 1.0
 */
public class XMIElementDescriptionAccuracyTests extends TestCase {

    /**
     * Represent the instance of <c>XMIElementDescription</c> used for test
     */
    private XMIElementDescription description;

    /**
     * Represent the instance of <c>elementName</c> used for test
     */
    private String testElementName = "testElementName";

    /**
     * Represent the instance of <c>Class</c> used for test
     */
    private final Class testType = String.class;

    /**
     * Represents the <c>AttributeDescription</c> instance used for testing.
     */
    private AttributeDescription attribute;

    /**
     * Represents the <c>ChildDescription</c> instance used for testing.
     */
    private ChildDescription child;

    /**
     * Represent the name used for test.
     */
    private String testName = "testName";

    /**
     * Represent the name used for test.
     */
    private Method testMethod;

    /**
     * <p>
     * Set up test environment.
     * </p>
     * 
     * @throws Exception
     *         if any error occurs when set up
     */
    protected void setUp() throws Exception {
        description = new XMIElementDescription(testElementName, testType);
        testMethod = String.class.getMethod("length", new Class[] {});
        attribute = new AttributeDescription(testName, testMethod);
        child = new ChildDescription(testName, testMethod, true);
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>XMIElementDescription</code>. The instance of
     * <code>XMIElementDescription</code> should be created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        description = new XMIElementDescription(testElementName, testType);
        assertNotNull("instance of XMIElementDescription should be created", description);
        assertEquals(testElementName, description.getElementName());
        assertEquals(testType, description.getElementType());
    }

    /**
     * Accuracy test of method <code>getElementName()</code>.
     */
    public void testGetElementNameAccuacy() {
        assertEquals(testElementName, description.getElementName());
    }

    /**
     * Accuracy test of method <code>getElementType()</code>.
     */
    public void testGetElementTypeAccuacy() {
        assertEquals(testType, description.getElementType());
    }

    /**
     * Accuracy test of method <code>addAttribute(AttributeDescription)</code>.
     */
    public void testAddAttributeAccuracy1() {
        assertEquals(0, description.getAttributes().size());
        description.addAttribute(attribute);
        assertEquals(1, description.getAttributes().size());
        assertEquals(attribute, description.getAttributes().get(0));
    }

    /**
     * Accuracy test of method <code>addAttribute(AttributeDescription)</code>.
     */
    public void testAddAttributeAccuracy2() {
        assertEquals(0, description.getAttributes().size());
        description.addAttribute(attribute);
        assertEquals(1, description.getAttributes().size());
        assertEquals(attribute, description.getAttributes().get(0));

        description.addAttribute(0, new AttributeDescription(testName, testMethod));

        assertEquals(2, description.getAttributes().size());
        assertEquals(attribute, description.getAttributes().get(1));
    }

    /**
     * <p>
     * Accuracy test for the method <code>RemoveAttribute</code> The attribute should be returned.
     * </p>
     */
    public void testRemoveAttributeAccuracy() {
        try {
            description.addAttribute(attribute);
            description.removeAttribute(attribute);
            assertEquals(0, description.getAttributes().size());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>RemoveAttribute</code> The attribute should be returned.
     * </p>
     */
    public void testRemoveAttributeAccuracy2() {
        try {
            description.addAttribute(attribute);
            description.removeAttribute(0);
            assertEquals(0, description.getAttributes().size());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getAttributes()</code> The Attributes should be returned.
     * </p>
     */
    public void testGetAttributesAccuracy() {
        try {
            description.addAttribute(attribute);
            List<AttributeDescription> list = description.getAttributes();
            assertEquals(1, list.size());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>clearAttributes()</code> The Attributes should be cleared.
     * </p>
     */
    public void testClearAttributesAccuracy() {
        try {
            description.addAttribute(attribute);
            description.clearAttributes();
            assertEquals(0, description.getAttributes().size());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Accuracy test of method <code>addChild(ChildDescription)</code>.
     */
    public void testAddChildAccuracy1() {
        assertEquals(0, description.getChildren().size());
        description.addChild(child);
        assertEquals(1, description.getChildren().size());
        assertEquals(child, description.getChildren().get(0));
    }

    /**
     * Accuracy test of method <code>addChild(ChildDescription)</code>.
     */
    public void testAddChildAccuracy2() {
        assertEquals(0, description.getChildren().size());
        description.addChild(child);
        assertEquals(1, description.getChildren().size());
        assertEquals(child, description.getChildren().get(0));

        description.addChild(0, new ChildDescription(testName, testMethod, true));

        assertEquals(2, description.getChildren().size());
        assertEquals(child, description.getChildren().get(1));
    }

    /**
     * <p>
     * Accuracy test for the method <code>RemoveChild</code> The child should be returned.
     * </p>
     */
    public void testRemoveChildAccuracy() {
        try {
            description.addChild(child);
            description.removeChild(child);
            assertEquals(0, description.getChildren().size());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>RemoveChild</code> The child should be returned.
     * </p>
     */
    public void testRemoveChildAccuracy2() {
        try {
            description.addChild(child);
            description.removeChild(0);
            assertEquals(0, description.getChildren().size());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>getChildren()</code> The Children should be returned.
     * </p>
     */
    public void testGetChildrenAccuracy() {
        try {
            description.addChild(child);
            List<ChildDescription> list = description.getChildren();
            assertEquals(1, list.size());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * <p>
     * Accuracy test for the method <code>clearChildren()</code> The Children should be cleared.
     * </p>
     */
    public void testClearChildrenAccuracy() {
        try {
            description.addChild(child);
            description.clearChildren();
            assertEquals(0, description.getChildren().size());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
