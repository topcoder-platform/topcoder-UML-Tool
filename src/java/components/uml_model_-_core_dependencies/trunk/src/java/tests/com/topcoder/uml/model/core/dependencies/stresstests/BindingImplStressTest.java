/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.dependencies.stresstests;

import java.util.ArrayList;

import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.dependencies.BindingImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test for the BindingImpl class.
 * </p>
 *
 * @author coolzhao
 * @version 1.0
 */
public class BindingImplStressTest extends TestCase {
    /**
     * <p>
     * MappingExpression for test.
     * </p>
     */
    private static final int OPERATIONS = 1000;

   /**
     * <p>
     * TemplateArgument for test.
     * </p>
     */
    private TemplateArgument templateArgument;

    /**
     * <p>
     * Collection for test.
     * </p>
     */
    private ArrayList<TemplateArgument> arrayList;

    /**
     * <p>
     * BindingImpl for test.
     * </p>
     */
    private BindingImpl bindingImpl;

    /**
     * <p>
     * Prepares the environment for each test.
     * </p>
     */
    protected void setUp() {
        templateArgument = new TemplateArgumentImpl();
        arrayList = new ArrayList<TemplateArgument>();
        bindingImpl = new BindingImpl();
    }

    /**
     * <p>
     * Test addArgument() and removeArgument().
     * </p>
     */
    public void testAddAndRemoveArgumentManyTimes() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < OPERATIONS; ++i) {
            bindingImpl.addArgument(templateArgument);
        }
        for (int i = 0; i < OPERATIONS; ++i) {
            bindingImpl.addArgument(i, templateArgument);
        }
        for (int i = 0; i < OPERATIONS; ++i) {
            bindingImpl.removeArgument(templateArgument);
            assertEquals("testAddAndRemoveArgumentsManyTimes failed.",
                    OPERATIONS * 2 - i - 1, bindingImpl.countArguments());
        }
        for (int i = 0; i < OPERATIONS; ++i) {
            bindingImpl.removeArgument(OPERATIONS - i - 1);
            assertEquals("testAddAndRemoveArgumentsManyTimes failed.",
                    OPERATIONS - i - 1, bindingImpl.countArguments());
        }

        long endTime = System.currentTimeMillis();

        System.out.println("testAddAndRemoveArgumentManyTimes");
        System.out.println("It took " + (int) (endTime - startTime) + " ms "
                + "to operate " + OPERATIONS + " times.");
        System.out.println();
    }

    /**
     * <p>
     * Test addArguments() and removeArguments().
     * </p>
     */
    public void testAddAndRemoveArgumentsManyTimes() {
        long startTime = System.currentTimeMillis();

        TemplateArgument templateArgument1 = new TemplateArgumentImpl();
        arrayList.add(templateArgument);
        arrayList.add(templateArgument1);

        for (int i = 0; i < OPERATIONS; ++i) {
            bindingImpl.addArguments(arrayList);
            assertEquals("testAddAndRemoveArgumentsManyTimes failed.",
                    (i + 1) * 2, bindingImpl.countArguments());
        }
        for (int i = 0; i < OPERATIONS; ++i) {
            bindingImpl.addArguments(i, arrayList);
            assertEquals("testAddAndRemoveArgumentsManyTimes failed.",
                    OPERATIONS * 2 + (i + 1) * 2, bindingImpl.countArguments());
        }
        for (int i = 0; i < OPERATIONS; ++i) {
            bindingImpl.removeArguments(arrayList);
            assertEquals("testAddAndRemoveArgumentsManyTimes failed.",
                    (OPERATIONS * 2 - i - 1) * 2, bindingImpl.countArguments());
        }

        long endTime = System.currentTimeMillis();

        System.out.println("testAddAndRemoveArgumentsManyTimes");
        System.out.println("It took " + (int) (endTime - startTime) + " ms "
                + "to operate " + OPERATIONS + " times.");
        System.out.println();
    }

    /**
     * <p>
     * Test operate arguments.
     * </p>
     */
    public void testOperateArguments() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < OPERATIONS; ++i) {
            arrayList.add(new TemplateArgumentImpl());
        }
        bindingImpl.addArguments(arrayList);
        for (int i = 0; i < OPERATIONS; ++i) {
            assertTrue("testOperateArguments failed.",
                    bindingImpl.containsArgument(arrayList.get(i)));
            assertEquals("testOperateArguments failed.",
                    i, bindingImpl.indexOfArgument(arrayList.get(i)));
            assertEquals("testOperateArguments failed.",
                    arrayList.get(i), bindingImpl.getArguments().get(i));
            bindingImpl.setArgument(i, templateArgument);
            assertEquals("testOperateArguments failed.",
                    templateArgument, bindingImpl.getArguments().get(i));
        }

        long endTime = System.currentTimeMillis();

        System.out.println("testOperateArguments");
        System.out.println("It took " + (int) (endTime - startTime) + " ms "
                + "to operate " + OPERATIONS + " times.");
        System.out.println();
    }
}
