/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements.stresstests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.easymock.EasyMock.createMock;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;

import junit.framework.TestCase;

/**
 * Stress tests for CommentImpl class.
 *
 * @author still
 * @version 1.0
 */
public class CommentImplStressTest extends TestCase {
    /** instance of CommentImpl used in this test.*/
    private CommentImpl instance;

    /**
     * Sets up the test environment.
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        instance = new CommentImpl();
    }

    /**
     * Tests for <code>CommentImpl()</code> method.
     */
    public void testCreateCommentImpl() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            CommentImpl object = new CommentImpl();
            assertNotNull("failed to create a CommentImpl instance.", object);
            assertTrue("class CommentImpl should implement Comment interface.", object instanceof Comment);
            assertTrue("class CommentImpl should extend ModelElementAbstractImpl abstract class.",
                object instanceof ModelElementAbstractImpl);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Creating " + (StressTestHelper.RUN_TIMES)
            + " CommentImpl objects takes " + (endTime - startTime) + " ms.");
    }

    /**
     * Tests for <code>getBody()</code> and <code>setBody(String)</code> methods.
     */
    public void testBodyOperation() {
        Random rand = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            String randomBody = "   " + rand.nextInt(1000);
            instance.setBody(randomBody);
            assertEquals("should be equal.", randomBody, instance.getBody());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Do 'setBody' and 'getBody' operations of CommentImpl " + (StressTestHelper.RUN_TIMES)
                + " times takes " + (endTime - startTime) + " ms.");
    }



    /**
     * Tests for
     * <code>addAnnotatedElement(ModelElement)</code>
     * <code>addAnnotatedElements(Collection&lt;ModelElement&gt;)</code>
     * <code>removeAnnotatedElement(ModelElement)</code>
     * <code>removeAnnotatedElements(Collection&lt;ModelElement&gt;)</code>
     * methods.
     *
     */
    public void testAnnotatedElementOperation1() {
        List<ModelElement> testMockElements = new ArrayList<ModelElement>();
        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            testMockElements.add(createMock(ModelElement.class));
        }
        List<ModelElement> subListOfTestMockElements = testMockElements.subList(0, StressTestHelper.SMALL_NUMBER);
        long startTime = System.currentTimeMillis();
        for (ModelElement eachMockElement : testMockElements) {
            instance.addAnnotatedElement(eachMockElement);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Adding " + (StressTestHelper.RUN_TIMES)
            + " annotated elements takes " + (endTime - startTime) + " ms.");

        assertEquals("should be equal.", StressTestHelper.RUN_TIMES, instance.countAnnotatedElements());

        // test remove
        startTime = System.currentTimeMillis();
        for (int i = StressTestHelper.SMALL_NUMBER - 1; i >= 0; i--) {
            instance.removeAnnotatedElement(testMockElements.get(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("Removing " + (StressTestHelper.SMALL_NUMBER)
            + " annotated elements takes " + (endTime - startTime) + " ms.");

        assertEquals("should be equal.",
            StressTestHelper.RUN_TIMES - StressTestHelper.SMALL_NUMBER, instance.countAnnotatedElements());

        instance.clearAnnotatedElements();

        // test add collection
        startTime = System.currentTimeMillis();
        for (int i = 0; i < StressTestHelper.SMALL_NUMBER; i++) {
            instance.addAnnotatedElements(subListOfTestMockElements);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Adding a group of " + (StressTestHelper.SMALL_NUMBER)
                + " annotated elements for " + StressTestHelper.SMALL_NUMBER
                + " times takes " + (endTime - startTime) + " ms.");
        assertEquals("should be equal.", StressTestHelper.SMALL_NUMBER * StressTestHelper.SMALL_NUMBER
                , instance.countAnnotatedElements());

        // test remove collection
        startTime = System.currentTimeMillis();
        for (int i = 0; i < StressTestHelper.SMALL_NUMBER; i++) {
            assertTrue("true value expected.", instance.removeAnnotatedElements(subListOfTestMockElements));
        }
        endTime = System.currentTimeMillis();
        System.out.println("Removing a group of " + (StressTestHelper.SMALL_NUMBER)
                + " annotated elements for " + StressTestHelper.SMALL_NUMBER
                + " times takes " + (endTime - startTime) + " ms.");

        assertEquals("should be equal.",
            0, instance.countAnnotatedElements());

    }

    /**
     * Tests for <code>containsAnnotatedElement(ModelElement)</code> method.
     */
    public void testAnnotatedElementOperation2() {
        List<ModelElement> testMockElements = new ArrayList<ModelElement>();
        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            testMockElements.add(createMock(ModelElement.class));
        }
        for (ModelElement eachMockElement : testMockElements) {
            instance.addAnnotatedElement(eachMockElement);
        }
        // test contain
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            assertFalse("should return false.", instance.containsAnnotatedElement(createMock(ModelElement.class)));
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Test CommentImpl#containsAnnotatedElement for " + StressTestHelper.RUN_TIMES
             + " times takes " + (endTime - startTime) + " ms.");
    }

    /**
     * Tests for <code>countAnnotatedElements()</code> method.
     */
    public void testAnnotatedElementOperation3() {
        List<ModelElement> testMockElements = new ArrayList<ModelElement>();
        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            testMockElements.add(createMock(ModelElement.class));
        }
        for (ModelElement eachMockElement : testMockElements) {
            instance.addAnnotatedElement(eachMockElement);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            assertEquals("should be equal.", StressTestHelper.RUN_TIMES, instance.countAnnotatedElements());
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Test CommentImpl#countAnnotatedElements for " + StressTestHelper.RUN_TIMES
            + " times takes " + (endTime - startTime) + " ms.");
    }

    /**
     * Tests for <code>getAnnotatedElements()</code> method.
     */
    public void testAnnotatedElementOperation4() {
        List<ModelElement> testMockElements = new ArrayList<ModelElement>();
        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            testMockElements.add(createMock(ModelElement.class));
        }
        for (ModelElement eachMockElement : testMockElements) {
            instance.addAnnotatedElement(eachMockElement);
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < StressTestHelper.RUN_TIMES; i++) {
            instance.getAnnotatedElements();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Test CommentImpl#getAnnotatedElements for " + StressTestHelper.RUN_TIMES
            + " times takes " + (endTime - startTime) + " ms.");
    }

}
