/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships.accuracytests;

import org.easymock.EasyMock;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.GeneralizableElement;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.core.relationships.RelationshipAbstractImpl;


/**
 * Accuracy test case of <code>GeneralizationImpl</code> class.
 * This class tests <code>GeneralizationImpl</code> for proper behavior. It covers
 * GeneralizationImpl(), setDiscriminator(String), getDiscriminator(), setChild(GeneralizableElement),
 * getChild(), setParent(GeneralizableElement), getParent(), setPowertype(Classifier), getPowertype().
 *
 * @author still
 * @version 1.0
 */
public class GeneralizationImplAccuracyTest extends TestCase {
    /**
     * <p>
     * Different discriminators for testing setDiscriminator,those follows should all be acceptable in setDiscriminator.
     * </p>
     */
    private static final String[] TEST_DISCRIMINATORS =
    {"this", "is", "blah", "GeneralizationImpl", "accuracy", "test", "", "  ", "\t\t  ", null, "", "end"};

    /** GeneralizationImpl instance for accuracy test. */
    private GeneralizationImpl instance;

    /**
     * Test suite of GeneralizationImpl.
     *
     * @return Test suite of GeneralizationImpl.
     */
    public static Test suite() {
        return new TestSuite(GeneralizationImplAccuracyTest.class);
    }

    /**
     * Initialization for all tests here.
     */
    protected void setUp() {
        // set up for test
        instance = new GeneralizationImpl();
        GeneralizableElement mockChild = EasyMock.createMock(GeneralizableElement.class);
        GeneralizableElement mockParent = EasyMock.createMock(GeneralizableElement.class);
        Classifier mockPowertype = EasyMock.createMock(Classifier.class);
        instance.setChild(mockChild);
        instance.setDiscriminator(TEST_DISCRIMINATORS[0]);
        instance.setParent(mockParent);
        instance.setPowertype(mockPowertype);

    }


    /**
     * Test accuracy of GeneralizationImpl() method.
     */
    public void testGeneralizationImpl() {
        instance = new GeneralizationImpl();
        assertNotNull("create failed.", instance);
        assertNull("null expected.", instance.getDiscriminator());
        assertNull("null expected.", instance.getChild());
        assertNull("null expected.", instance.getParent());
        assertNull("null expected.", instance.getPowertype());
    }

    /**
     * Test class GeneralizationImpl for correct type.
     */
    public void testGeneralizationImpl_CorrectType() {
        assertEquals("equal value expected.",
                GeneralizationImpl.class.getSuperclass(), RelationshipAbstractImpl.class);
        assertTrue("true value expected.",
                Generalization.class.isAssignableFrom(GeneralizationImpl.class));
    }

    /**
     * Test accuracy of setDiscriminator(String) method.
     */
    public void testSetDiscriminator() {
        for (String discriminator : TEST_DISCRIMINATORS) {
            instance.setDiscriminator(discriminator);
            assertEquals("equal value expected.", discriminator, instance.getDiscriminator());
        }
    }

    /**
     * Test accuracy of getDiscriminator() method.
     */
    public void testGetDiscriminator() {
        String discriminator = "test";
        instance.setDiscriminator(discriminator);
        assertSame("same value expected.", discriminator, instance.getDiscriminator());
    }

    /**
     * Test accuracy of setChild(GeneralizableElement) method.
     */
    public void testSetChild() {
        GeneralizableElement mockChild = EasyMock.createMock(GeneralizableElement.class);
        instance.setChild(mockChild);
        assertSame("same value expected.", mockChild, instance.getChild());

        mockChild = EasyMock.createMock(GeneralizableElement.class);
        instance.setChild(mockChild);
        assertSame("same value expected.", mockChild, instance.getChild());
    }

    /**
     * Test accuracy of setChild(GeneralizableElement) method.
     */
    public void testSetChild_NullChild() {
        instance.setChild(null);
        assertNull("null expected.", instance.getChild());
    }

    /**
     * Test accuracy of getChild() method.
     */
    public void testGetChild() {

        GeneralizableElement mockChild = EasyMock.createMock(GeneralizableElement.class);
        instance.setChild(mockChild);
        assertSame("same value expected.", mockChild, instance.getChild());
        assertSame("same value expected.", mockChild, instance.getChild());
        instance.setChild(null);
        assertNull("null expected.", instance.getChild());
        assertNull("null expected.", instance.getChild());
    }

    /**
     * Test accuracy of setParent(GeneralizableElement) method.
     */
    public void testSetParent() {
        GeneralizableElement mockParent = EasyMock.createMock(GeneralizableElement.class);
        instance.setParent(mockParent);
        assertSame("same value expected.", mockParent, instance.getParent());

        mockParent = EasyMock.createMock(GeneralizableElement.class);
        instance.setParent(mockParent);
        assertSame("same value expected.", mockParent, instance.getParent());
    }

    /**
     * Test accuracy of setParent(GeneralizableElement) method.
     */
    public void testSetParent_NullParent() {
        instance.setParent(null);
        assertNull("null expected.", instance.getParent());
    }

    /**
     * Test accuracy of getParent() method.
     */
    public void testGetParent() {
        GeneralizableElement mockParent = EasyMock.createMock(GeneralizableElement.class);
        instance.setParent(mockParent);
        assertSame("same value expected.", mockParent, instance.getParent());
        assertSame("same value expected.", mockParent, instance.getParent());
        instance.setParent(null);
        assertNull("null expected.", instance.getParent());
        assertNull("null expected.", instance.getParent());
    }

    /**
     * Test accuracy of setPowertype(Classifier) method.
     */
    public void testSetPowertype() {
        Classifier mock = EasyMock.createMock(Classifier.class);
        instance.setPowertype(mock);
        assertSame("same value expected.", mock, instance.getPowertype());

        mock = EasyMock.createMock(Classifier.class);
        instance.setPowertype(mock);
        assertSame("same value expected.", mock, instance.getPowertype());
    }

    /**
     * Test accuracy of setPowertype(Classifier) method.
     */
    public void testSetPowertype_NullClassifier() {
        instance.setPowertype(null);
        assertNull("null expected.", instance.getPowertype());
    }


    /**
     * Test accuracy of getPowertype() method.
     */
    public void testGetPowertype() {
        Classifier mock = EasyMock.createMock(Classifier.class);
        instance.setPowertype(mock);
        assertSame("same value expected.", mock, instance.getPowertype());
        assertSame("same value expected.", mock, instance.getPowertype());

        instance.setPowertype(null);
        assertNull("null expected.", instance.getPowertype());
        assertNull("null expected.", instance.getPowertype());
    }

}
