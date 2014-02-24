/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import junit.framework.TestCase;

/**
 * Unit test for GeneralizationImpl.
 *
 * @author fanse
 * @version 1.0
 */
public class GeneralizationImplUnitTest extends TestCase {
    /**
     * The GeneralizationImpl instance for test.
     */
    private GeneralizationImpl genImpl = null;

    /**
     * Create the test instance.
     */
    public void setUp() {
        genImpl = new GeneralizationImpl();
    }

    /**
     * Tear down the test instance.
     */
    public void tearDown() {
        genImpl = null;
    }

    /**
     * Test constructor accuracy. No exception will be thrown.
     */
    public void testConstructorAccuracy() {
        GeneralizationImpl ctorImpl = new GeneralizationImpl();

        assertNotNull("The ctorImpl should not be null.", ctorImpl);
        // Check default fields.
        assertNull("initialized field wrong.", ctorImpl.getChild());
        assertNull("initialized field wrong.", ctorImpl.getDiscriminator());
        assertNull("initialized field wrong.", ctorImpl.getParent());
        assertNull("initialized field wrong.", ctorImpl.getPowertype());
    }

    /**
     * Test inheritance of <c>GeneralizationImpl</c>.
     * <c>GeneralizationImpl</c> should inherit from <c>RelationshipAbstractImpl</c>.
     */
    public void testGeneralizationImplAccuracyInheritRelationshipAbstractImpl() {
        assertTrue("GeneralizationImpl should inherit from RelationshipAbstractImpl.",
                ((Object) new GeneralizationImpl()) instanceof RelationshipAbstractImpl);
    }

    /**
     * Test inheritance of <c>GeneralizationImpl</c>.
     * <c>GeneralizationImpl</c> should inherit from <c>Generalization</c>.
     */
    public void testGeneralizationImplAccuracyInheritGeneralization() {
        assertTrue("GeneralizationImpl should inherit from Generalization.",
                ((Object) new GeneralizationImpl()) instanceof Generalization);
    }

    /**
     * Tests setDiscriminator. Value should be set correctly.
     */
    public void testSetDiscriminatorAccuracy() {
        String test = "test";
        genImpl.setDiscriminator(test);
        assertEquals("Value should be set correctly.", test, genImpl.getDiscriminator());
    }

    /**
     * Tests getDiscriminator. Value should be gotten correctly.
     */
    public void testGetDiscriminatorAccuracy() {
        String test = "test";
        genImpl.setDiscriminator(test);
        assertEquals("Value should be getton correctly.", test, genImpl.getDiscriminator());
    }

    /**
     * Tests setDiscriminator with null. Value should be set correctly.
     */
    public void testSetDiscriminatorAccuracyWithNull() {
        String test = null;
        genImpl.setDiscriminator(test);
        assertEquals("Value should be set correctly.", test, genImpl.getDiscriminator());
    }

    /**
     * Tests getDiscriminator with null. Value should be gotten correctly.
     */
    public void testGetDiscriminatorAccuracyWithNull() {
        String test = null;
        genImpl.setDiscriminator(test);
        assertEquals("Value should be getton correctly.", test, genImpl.getDiscriminator());
    }

    /**
     * Tests setDiscriminator with empty. Value should be set correctly.
     */
    public void testSetDiscriminatorAccuracyWithEmpty() {
        String test = " ";
        genImpl.setDiscriminator(test);
        assertEquals("Value should be set correctly.", test, genImpl.getDiscriminator());
    }

    /**
     * Tests getDiscriminator with empty. Value should be gotten correctly.
     */
    public void testGetDiscriminatorAccuracyWithEmpty() {
        String test = " ";
        genImpl.setDiscriminator(test);
        assertEquals("Value should be getton correctly.", test, genImpl.getDiscriminator());
    }

    /**
     * Tests setChild. Value should be set correctly.
     */
    public void testSetChildAccuracy() {
        StereotypeImpl test = new StereotypeImpl();
        genImpl.setChild(test);
        assertEquals("Value should be set correctly.", test, genImpl.getChild());
    }

    /**
     * Tests getChild. Value should be gotten correctly.
     */
    public void testGetChildAccuracy() {
        StereotypeImpl test = new StereotypeImpl();
        genImpl.setChild(test);
        assertEquals("Value should be getton correctly.", test, genImpl.getChild());
    }

    /**
     * Tests setChild with null. Value should be set correctly.
     */
    public void testSetChildAccuracyWithNull() {
        StereotypeImpl test = null;
        genImpl.setChild(test);
        assertEquals("Value should be set correctly.", test, genImpl.getChild());
    }

    /**
     * Tests getChild with null. Value should be gotten correctly.
     */
    public void testGetChildAccuracyWithNull() {
        StereotypeImpl test = null;
        genImpl.setChild(test);
        assertEquals("Value should be getton correctly.", test, genImpl.getChild());
    }

    /**
     * Tests setParent. Value should be set correctly.
     */
    public void testSetParentAccuracy() {
        StereotypeImpl test = new StereotypeImpl();
        genImpl.setParent(test);
        assertEquals("Value should be set correctly.", test, genImpl.getParent());
    }

    /**
     * Tests getParent. Value should be gotten correctly.
     */
    public void testGetParentAccuracy() {
        StereotypeImpl test = new StereotypeImpl();
        genImpl.setParent(test);
        assertEquals("Value should be getton correctly.", test, genImpl.getParent());
    }

    /**
     * Tests setParent with null. Value should be set correctly.
     */
    public void testSetParentAccuracyWithNull() {
        StereotypeImpl test = null;
        genImpl.setParent(test);
        assertEquals("Value should be set correctly.", test, genImpl.getParent());
    }

    /**
     * Tests getParent with null. Value should be gotten correctly.
     */
    public void testGetParentAccuracyWithNull() {
        StereotypeImpl test = null;
        genImpl.setParent(test);
        assertEquals("Value should be getton correctly.", test, genImpl.getParent());
    }

    /**
     * Tests setPowertype. Value should be set correctly.
     */
    public void testSetPowertypeAccuracy() {
        ClassImpl test = new ClassImpl();
        genImpl.setPowertype(test);
        assertEquals("Value should be set correctly.", test, genImpl.getPowertype());
    }

    /**
     * Tests getPowertype. Value should be gotten correctly.
     */
    public void testGetPowertypeAccuracy() {
        ClassImpl test = new ClassImpl();
        genImpl.setPowertype(test);
        assertEquals("Value should be getton correctly.", test, genImpl.getPowertype());
    }

    /**
     * Tests setPowertype with null. Value should be set correctly.
     */
    public void testSetPowertypeAccuracyWithNull() {
        ClassImpl test = null;
        genImpl.setPowertype(test);
        assertEquals("Value should be set correctly.", test, genImpl.getPowertype());
    }

    /**
     * Tests getPowertype with null. Value should be gotten correctly.
     */
    public void testGetPowertypeAccuracyWithNull() {
        ClassImpl test = null;
        genImpl.setPowertype(test);
        assertEquals("Value should be getton correctly.", test, genImpl.getPowertype());
    }
}
