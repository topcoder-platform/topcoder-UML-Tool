/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import junit.framework.TestCase;

import java.lang.reflect.Method;

import com.topcoder.uml.xmi.writer.transformers.model.Implement1;
import com.topcoder.xmi.writer.transformers.model.AttributeDescription;
import com.topcoder.xmi.writer.transformers.model.ChildDescription;
import com.topcoder.xmi.writer.transformers.model.XMIElementDescription;


/**
 * <p>
 * Unit test cases for XMIElementDescription.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class XMIElementDescriptionTests extends TestCase {
    /**
     * The name of the XMIElementDescription.
     */
    private static final String NAME = "name";

    /**
     * The XMIElementDescription instance for test.
     */
    private XMIElementDescription elementDescription = null;

    /**
     * The method instance for test.
     */
    private Method method = null;

    /**
     * The setUp of the unit test.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        method = Implement1.class.getMethod("getNamespace", new Class[] {});
        elementDescription = new XMIElementDescription(NAME, String.class);
    }

    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_constructor_accuracy() {
        assertNotNull("can not create the XMIElementDescription instance.",
            elementDescription);
    }

    /**
     * The accuracy test of the method <code>getElementName</code>.
     *
     */
    public void test_getElementName_accuracy() {
        assertEquals("The element name is not retrieved successfully.", NAME,
            elementDescription.getElementName());
    }

    /**
     * The accuracy test of the method <code>getElementType</code>.
     *
     */
    public void test_getElementType_accuracy() {
        assertEquals("The element type is not retrieved successfully.",
            String.class, elementDescription.getElementType());
    }

    /**
     * The failure test of the method <code>addAttribute</code>,
     * fail for the AttributeDescription is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_addAttribute_failure() {
        try {
            elementDescription.addAttribute(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * The accuracy test of the method <code>addAttribute</code>.
     *
     */
    public void test_addAttribute_accuracy() {
        elementDescription.addAttribute(new AttributeDescription("n1", method));
        assertEquals("The attribute is not added successfully.", 1,
            elementDescription.getAttributes().size());
    }

    /**
     * The failure test of the method <code>addAttribute</code> with index,
     * fail for the AttributeDescription is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_addAttributeWithIndex_failure1() {
        try {
            elementDescription.addAttribute(0, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * The failure test of the method <code>addAttribute</code> with index,
     * fail for the index is greater than size,
     * IndexOutOfBoundsException should be thrown.
     *
     */
    public void test_addAttributeWithIndex_failure2() {
        try {
            elementDescription.addAttribute(1,
                new AttributeDescription("n1", method));
            fail("IndexOutOfBoundsException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * The failure test of the method <code>addAttribute</code> with index,
     * fail for the index is less than 0,
     * IndexOutOfBoundsException should be thrown.
     *
     */
    public void test_addAttributeWithIndex_failure3() {
        try {
            elementDescription.addAttribute(-1,
                new AttributeDescription("n1", method));
            fail("IndexOutOfBoundsException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * The accuracy test of the method <code>addAttribute</code> with Index.
     *
     */
    public void test_addAttributeWithIndex_accuracy() {
        elementDescription.addAttribute(0,
            new AttributeDescription("n1", method));
        elementDescription.addAttribute(0,
            new AttributeDescription("n2", method));
        assertEquals("The attributes are not added successfully.", 2,
            elementDescription.getAttributes().size());
        assertEquals("The index is not set properly.", "n2",
            elementDescription.getAttributes().get(0).getName());
    }

    /**
     * The accuracy test of the method <code>removeAttribute</code>.
     *
     */
    public void test_removeAttribute_accuracy() {
        AttributeDescription attr = new AttributeDescription("n1", method);
        elementDescription.addAttribute(attr);

        //remove the attribute here
        elementDescription.removeAttribute(attr);
        assertEquals("The attribute is not removed successfully.", 0,
            elementDescription.getAttributes().size());
    }

    /**
     * The failure test of the method <code>removeAttribute</code>,
     * fail for the AttributeDescription is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_removeAttribute_failure() {
        try {
            elementDescription.removeAttribute(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * The failure test of the method <code>removeAttribute</code> with index,
     * fail for the index is less than 0,
     * IndexOutOfBoundsException should be thrown.
     *
     */
    public void test_removeAttributeWithIndex_failure1() {
        try {
            elementDescription.removeAttribute(-1);
            fail("IndexOutOfBoundsException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * The failure test of the method <code>removeAttribute</code> with index,
     * fail for the index is greater or equals to the size,
     * IndexOutOfBoundsException should be thrown.
     *
     */
    public void test_removeAttributeWithIndex_failure2() {
        try {
            elementDescription.removeAttribute(0);
            fail("IndexOutOfBoundsException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * The accuracy test of the method <code>removeAttribute</code> with Index.
     *
     */
    public void test_removeAttributeWithIndex_accuracy() {
        AttributeDescription attr = new AttributeDescription("n1", method);
        elementDescription.addAttribute(attr);

        //remove the attribute here
        elementDescription.removeAttribute(0);
        assertEquals("The attribute is not removed successfully.", 0,
            elementDescription.getAttributes().size());
    }

    /**
     * The accuracy test of the method <code>getAttributes</code>.
     *
     */
    public void test_getAttributes_accuracy() {
        elementDescription.addAttribute(0,
            new AttributeDescription("n1", method));
        elementDescription.addAttribute(0,
            new AttributeDescription("n2", method));
        elementDescription.addAttribute(0,
            new AttributeDescription("n3", method));
        assertEquals("The attributes are not retrieved successfully.", 3,
            elementDescription.getAttributes().size());
    }

    /**
     * The accuracy test of the method <code>clearAttributes</code>.
     *
     */
    public void test_clearAttributes_accuracy() {
        elementDescription.addAttribute(0,
            new AttributeDescription("n1", method));
        elementDescription.addAttribute(0,
            new AttributeDescription("n2", method));
        elementDescription.addAttribute(0,
            new AttributeDescription("n3", method));

        //clear the attributes
        elementDescription.clearAttributes();
        assertEquals("The attributes are not cleared successfully.", 0,
            elementDescription.getAttributes().size());
    }

    /**
     * The failure test of the method <code>addChild</code>,
     * fail for the ChildDescription is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_addChild_failure() {
        try {
            elementDescription.addChild(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * The accuracy test of the method <code>addChild</code>.
     *
     */
    public void test_addChild_accuracy() {
        elementDescription.addChild(new ChildDescription("n1", method, false));
        assertEquals("The child is not added successfully.", 1,
            elementDescription.getChildren().size());
    }

    /**
     * The failure test of the method <code>addChild</code> with index,
     * fail for the ChildDescription is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_addChildWithIndex_failure1() {
        try {
            elementDescription.addChild(0, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * The failure test of the method <code>addChild</code> with index,
     * fail for the index is greater than size,
     * IndexOutOfBoundsException should be thrown.
     *
     */
    public void test_addChildWithIndex_failure2() {
        try {
            elementDescription.addChild(1,
                new ChildDescription("n1", method, true));
            fail("IndexOutOfBoundsException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * The failure test of the method <code>addChild</code> with index,
     * fail for the index is less than 0,
     * IndexOutOfBoundsException should be thrown.
     *
     */
    public void test_addChildWithIndex_failure3() {
        try {
            elementDescription.addChild(-1,
                new ChildDescription("n1", method, true));
            fail("IndexOutOfBoundsException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * The accuracy test of the method <code>addChild</code> with Index.
     *
     */
    public void test_addChildWithIndex_accuracy() {
        elementDescription.addChild(0, new ChildDescription("c1", method, true));
        elementDescription.addChild(0, new ChildDescription("c2", method, true));
        assertEquals("The children are not added successfully.", 2,
            elementDescription.getChildren().size());
        assertEquals("The index is not set properly.", "c2",
            elementDescription.getChildren().get(0).getName());
    }

    /**
     * The accuracy test of the method <code>removeChild</code>.
     *
     */
    public void test_removeChild_accuracy() {
        ChildDescription child = new ChildDescription("n1", method, false);
        elementDescription.addChild(child);

        //remove the child here
        elementDescription.removeChild(child);
        assertEquals("The child is not removed successfully.", 0,
            elementDescription.getChildren().size());
    }

    /**
     * The failure test of the method <code>removeChild</code>,
     * fail for the ChildDescription is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_removeChild_failure() {
        try {
            elementDescription.removeChild(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    /**
     * The failure test of the method <code>removeChild</code> with index,
     * fail for the index is less than 0,
     * IndexOutOfBoundsException should be thrown.
     *
     */
    public void test_removeChildWithIndex_failure1() {
        try {
            elementDescription.removeChild(-1);
            fail("IndexOutOfBoundsException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * The failure test of the method <code>removeChild</code> with index,
     * fail for the index is greater or equals to the size,
     * IndexOutOfBoundsException should be thrown.
     *
     */
    public void test_removeChildWithIndex_failure2() {
        try {
            elementDescription.removeChild(0);
            fail("IndexOutOfBoundsException should be thrown.");
        } catch (IndexOutOfBoundsException e) {
            //ok
        }
    }

    /**
     * The accuracy test of the method <code>removeChild</code> with Index.
     *
     */
    public void test_removeChildWithIndex_accuracy() {
        ChildDescription child = new ChildDescription("n1", method, true);
        elementDescription.addChild(child);

        //remove the child here
        elementDescription.removeChild(0);
        assertEquals("The child is not removed successfully.", 0,
            elementDescription.getChildren().size());
    }

    /**
     * The accuracy test of the method <code>getChildren</code>.
     *
     */
    public void test_getChildren_accuracy() {
        elementDescription.addChild(0, new ChildDescription("n1", method, true));
        elementDescription.addChild(0, new ChildDescription("n2", method, true));
        elementDescription.addChild(0, new ChildDescription("n3", method, false));
        assertEquals("The children are not retrieved successfully.", 3,
            elementDescription.getChildren().size());
    }

    /**
     * The accuracy test of the method <code>clearChildren</code>.
     *
     */
    public void test_clearChildren_accuracy() {
        elementDescription.addAttribute(0,
            new AttributeDescription("n1", method));
        elementDescription.addAttribute(0,
            new AttributeDescription("n2", method));
        elementDescription.addAttribute(0,
            new AttributeDescription("n3", method));

        //clear the attributes
        elementDescription.clearAttributes();
        assertEquals("The attributes are not cleared successfully.", 0,
            elementDescription.getAttributes().size());
    }
}
