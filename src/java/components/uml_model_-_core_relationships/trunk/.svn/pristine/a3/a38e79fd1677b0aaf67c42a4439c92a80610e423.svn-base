/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships.stresstests;

import java.util.Collection;
import java.util.List;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;

import com.topcoder.uml.model.core.relationships.AssociationEndImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test case for AssociationClassImpl.
 * </p>
 * 
 * @author catcher
 * @version 1.0
 */
public class AssociationEndImplStressTest extends TestCase {
    /**
     * Represents the number of requests to process, used in stress tests.
     */
    private static final int MAX_COUNT = 10000;

    /**
     * Represents the number of association, used in stress tests.
     */
    private static final int MAX_NUM = 1000;

    /**
     * Keep the instance of the <c>AssociationEndImpl</c> for test.
     */
    private AssociationEndImpl end;

    /**
     * create <c>AssociationClassImpl</c> instance.
     * 
     * @throws Exception
     *         into Junit
     */
    protected void setUp() throws Exception {
        end = new AssociationEndImpl();
        for (int i = 0; i < MAX_NUM; i++) {
            end.addQualifier(new AttributeImpl());
            end.addSpecification(new MockClassifierImpl());
        }
    }

    /**
     * Stree test for <c>addQualifier</c>.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testAddQualifier() throws Exception {
        // the copy of the aqualifiers should be return.
        List<Attribute> qualifiers = end.getQualifiers();
        for (int i = 1; i <= MAX_COUNT; i++) {
            // create the new Attribute
            Attribute newAttribute = new AttributeImpl();
            // add the new item to the old end
            end.addQualifier(qualifiers.size(), newAttribute);

            // the new copy of theQualifiers should be return.
            List<Attribute> newQualifiers = end.getQualifiers();
            assertFalse("the old copy should not contain the new item.", qualifiers.contains(newAttribute));
            assertTrue("the new copy should contain the new item.", newQualifiers.contains(newAttribute));
        }
    }

    /**
     * Stree test for <c>indexOfQualifier</c>.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testIndexOfQualifier() throws Exception {
        // the copy of the aqualifiers should be return.
        List<Attribute> qualifiers = end.getQualifiers();
        for (int i = 1; i <= MAX_COUNT; i++) {
            // create the new Attribute
            Attribute newAttribute = new AttributeImpl();
            // add the new item to the old end
            end.addQualifier(qualifiers.size(), newAttribute);
            assertEquals("the index should be just the old copy end", qualifiers.size(), end
                            .indexOfQualifier(newAttribute));
        }
    }

    /**
     * Stree test for <c>removeQualifier</c>.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testRemoveQualifier() throws Exception {
        // the copy of the aqualifiers should be return.
        List<Attribute> qualifiers = end.getQualifiers();
        for (int i = 1; i <= MAX_COUNT; i++) {
            // create the new Attribute
            Attribute newAttribute = new AttributeImpl();
            // add the new item to the old end
            end.addQualifier(qualifiers.size(), newAttribute);
            assertTrue("the new end should be removed", end.removeQualifier(newAttribute));
        }
    }

    /**
     * Stree test for <c>addSpecification</c>.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testAddSpecification() throws Exception {
        // the old copy of the Specifications should be return.
        Collection<Classifier> oldSpecifications = end.getSpecifications();
        for (int i = 1; i <= MAX_COUNT; i++) {
            // create the new specification
            Classifier specification = new MockClassifierImpl();
            // add the new item to the end
            end.addSpecification(specification);

            // the new copy of theQualifiers should be return.
            Collection<Classifier> newSpecifications = end.getSpecifications();
            assertFalse("the old copy should not contain the new item.", oldSpecifications.contains(specification));
            assertTrue("the new copy should contain the new item.", newSpecifications.contains(specification));
        }
    }

    /**
     * Stree test for <c>removeSpecification</c>.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testRemoveSpecification() throws Exception {

        for (int i = 1; i <= MAX_COUNT; i++) {
            // create the new specification
            Classifier specification = new MockClassifierImpl();
            // add the new item to the end
            end.addSpecification(specification);

            assertTrue("the new end should be removed", end.removeSpecification(specification));
        }
    }

}