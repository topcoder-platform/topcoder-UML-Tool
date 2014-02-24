/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.ActivityDiagramConversionFacade;

import junit.framework.TestCase;

/**
 * <p>
 * Failure Tests for ActivityDiagramConversionFacade.
 * </p>
 *
 * <p>
 * Change Note : Add some failure tests for additional methods.
 * </p>
 *
 * @author iRabbit
 * @version 1.1
 * @since 1.0
 */
public class ActivityDiagramConversionFacadeFailureTest extends TestCase {

    /**
     * Failure Test for
     * {@link ActivityDiagramConversionFacade#convertModel(com.topcoder.uml.model.modelmanagement.Model)}. model is
     * null and IAE is expected.
     */
    public void testConvertModel_Failure() {
        try {
            ActivityDiagramConversionFacade.convertModel(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for {@link ActivityDiagramConversionFacade#convertDiagrams(java.util.List)}. list is null and IAE
     * is expected.
     *
     * @since 1.1
     */
    public void testConvertDiagrams_Failure1() {
        try {
            ActivityDiagramConversionFacade.convertDiagrams(null);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for {@link ActivityDiagramConversionFacade#convertDiagrams(java.util.List)}. list contains null
     * element and IAE is expected.
     *
     * @since 1.1
     */
    public void testConvertDiagrams_Failure2() {
        try {
            List<Diagram> list = new ArrayList<Diagram>();
            list.add(null);
            ActivityDiagramConversionFacade.convertDiagrams(list);
            fail("IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for {@link ActivityDiagramConversionFacade#convertNamespace(Namespace, Model, List<ActivityGraph>)}.
     * activityGraphs is null and IAE is expected.
     *
     * @throws Exception to junit
     * @since 1.1
     */
    public void testConvertNamespace_Failure() throws Exception {
        try {
            Method method;
            method = ActivityDiagramConversionFacade.class.getDeclaredMethod("convertNamespace", Namespace.class,
                    Model.class, List.class);
            method.setAccessible(true);
            method.invoke(null, new CollaborationImpl(), new ModelImpl(), null);
            fail("IAE is expected");
        } catch (InvocationTargetException e) {
            assertEquals("IAE is expected", IllegalArgumentException.class, e.getTargetException().getClass());
        }
    }
}
