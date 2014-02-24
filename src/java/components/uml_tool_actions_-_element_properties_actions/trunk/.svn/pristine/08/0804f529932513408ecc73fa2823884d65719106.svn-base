/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.feature.UpdateOperationAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;

/**
 * Accuracy test cases for UpdateOperationAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class UpdateOperationActionAccuracyTest extends TestCase {
    /**
     * Represents the ChangeSizeAction instance used for tests.
     */
    private UpdateOperationAction instance;

    /**
     * Represents the old name of the operation before this action performed.
     */
    private String oldName;

    /**
     * Represents the new visibility of the operation after this action performed.
     */
    private VisibilityKind newVisibility;

    /**
     * Represents the new name of the operation after this action performed.
     */
    private String newName;

    /**
     * Represents the old visibility of the operation before this action performed.
     */
    private VisibilityKind oldVisibility;

    /**
     * Represents the new concurrency of the operation after this action performed.
     */
    private CallConcurrencyKind newConcurrency;

    /**
     * Represents the old concurrency of the operation before this action performed.
     */
    private CallConcurrencyKind oldConcurrency;

    /**
     * Represents the old owner kind (INSTANCE is for non-static, CLASSIFIER is for static) of the
     * operation before this action performed.
     */
    private ScopeKind oldOwnerKind;

    /**
     * Represents the new owner kind (INSTANCE is for non-static, CLASSIFIER is for static) of the
     * operation after this action performed.
     */
    private ScopeKind newOwnerKind;

    /**
     * Represents the new isAbstract of the operation after this action performed.
     */
    private boolean newIsAbstract;

    /**
     * Represents the old isAbstract of the operation before this action performed.
     */
    private boolean oldIsAbstract;

    /**
     * Represents the old return type of the operation before this action performed.
     */
    private Classifier oldReturnType;

    /**
     * Represents the new return type of the operation after this action performed.
     */
    private Classifier newReturnType;

    /**
     * Represents the old parameters of the operation before this action performed.
     */
    private Map<String, Classifier> oldParameters;

    /**
     * Represents the new parameters of the operation after this action performed.
     */
    private Map<String, Classifier> newParameters;

    /**
     * Represents the operation to be updated.
     */
    private Operation operation;

    /**
     * Represents the return parameter to be updated.
     */
    private Parameter returnParameter;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        AccuracyHelper.loadDefaultConfig();
        operation = new OperationImpl();

        oldName = "oldName";
        newName = "newName";
        operation.setName(oldName);

        oldVisibility = VisibilityKind.PACKAGE;
        newVisibility = VisibilityKind.PUBLIC;
        operation.setVisibility(oldVisibility);

        oldConcurrency = CallConcurrencyKind.CONCURRENT;
        newConcurrency = CallConcurrencyKind.GUARDED;
        operation.setConcurrency(oldConcurrency);

        oldOwnerKind = ScopeKind.CLASSIFIER;
        newOwnerKind = ScopeKind.INSTANCE;
        operation.setOwnerScope(oldOwnerKind);

        oldIsAbstract = false;
        newIsAbstract = true;
        operation.setAbstract(oldIsAbstract);

        oldReturnType = new ClassImpl();
        newReturnType = new InterfaceImpl();

        returnParameter = new ParameterImpl();
        returnParameter.setName("return");
        returnParameter.setKind(ParameterDirectionKind.RETURN);
        returnParameter.setType(oldReturnType);
        operation.addParameter(returnParameter);

        oldParameters = new HashMap<String, Classifier>();
        oldParameters.put("input", new InterfaceImpl());

        newParameters = new HashMap<String, Classifier>();
        newParameters.put("input", new ClassImpl());

        Parameter parameter = new ParameterImpl();
        parameter.setName("input");
        parameter.setType(oldParameters.get("input"));
        operation.addParameter(parameter);

        instance = new UpdateOperationAction(operation, newVisibility, newName, newParameters,
            newReturnType, newConcurrency, newIsAbstract, newOwnerKind);
    }

    /**
     * Clear the environment.
     */
    protected void tearDown() {
        AccuracyHelper.unloadConfig();
    }

    /**
     * Test undoAction().
     */
    public void testUndoAction() {
        instance.redoAction();
        instance.undoAction();
        assertEquals("undoAction() is incorrect.", oldVisibility, operation.getVisibility());
        assertEquals("undoAction() is incorrect.", oldName, operation.getName());
        assertEquals("undoAction() is incorrect.", oldConcurrency, operation.getConcurrency());
        assertEquals("undoAction() is incorrect.", oldIsAbstract, operation.isAbstract());
        assertEquals("undoAction() is incorrect.", oldOwnerKind, operation.getOwnerScope());
        Iterator<Parameter> iter = operation.getParameters().iterator();
        while (iter.hasNext()) {
            Parameter parameter = iter.next();
            if (parameter.getKind() == ParameterDirectionKind.RETURN) {
                assertEquals("undoAction() is incorrect.", oldReturnType, parameter.getType());
            }
            if (parameter.getName().equals("input")) {
                assertEquals("undoAction() is incorrect.", oldParameters.get("input"), parameter
                    .getType());
            }
        }
    }

    /**
     * Test redoAction().
     */
    public void testRedoAction() {
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", newVisibility, operation.getVisibility());
        assertEquals("redoAction() is incorrect.", newName, operation.getName());
        assertEquals("redoAction() is incorrect.", newConcurrency, operation.getConcurrency());
        assertEquals("redoAction() is incorrect.", newIsAbstract, operation.isAbstract());
        assertEquals("redoAction() is incorrect.", newOwnerKind, operation.getOwnerScope());
        Iterator<Parameter> iter = operation.getParameters().iterator();
        while (iter.hasNext()) {
            Parameter parameter = iter.next();
            if (parameter.getKind() == ParameterDirectionKind.RETURN) {
                assertEquals("redoAction() is incorrect.", newReturnType, parameter.getType());
            }
            if (parameter.getName().equals("input")) {
                assertEquals("redoAction() is incorrect.", newParameters.get("input"), parameter
                    .getType());
            }
        }
    }

    /**
     * Test executeAction().
     */
    public void testExecuteAction() {
        instance.redoAction();
        assertEquals("executeAction() is incorrect.", newVisibility, operation.getVisibility());
        assertEquals("executeAction() is incorrect.", newName, operation.getName());
        assertEquals("executeAction() is incorrect.", newConcurrency, operation.getConcurrency());
        assertEquals("executeAction() is incorrect.", newIsAbstract, operation.isAbstract());
        assertEquals("executeAction() is incorrect.", newOwnerKind, operation.getOwnerScope());
        Iterator<Parameter> iter = operation.getParameters().iterator();
        while (iter.hasNext()) {
            Parameter parameter = iter.next();
            if (parameter.getKind() == ParameterDirectionKind.RETURN) {
                assertEquals("executeAction() is incorrect.", newReturnType, parameter.getType());
            }
            if (parameter.getName().equals("input")) {
                assertEquals("executeAction() is incorrect.", newParameters.get("input"), parameter
                    .getType());
            }
        }
    }

    /**
     * Test UpdateOperationAction constructor.
     */
    public void UpdateOperationAction() {
        assertEquals("operation is incorrect.", operation, AccuracyHelper.getObjectFieldValue(
            instance, "operation"));
        assertEquals("oldVisibility is incorrect.", oldVisibility, AccuracyHelper
            .getObjectFieldValue(instance, "oldVisibility"));
        assertEquals("newVisibility is incorrect.", newVisibility, AccuracyHelper
            .getObjectFieldValue(instance, "newVisibility"));
        assertEquals("oldName is incorrect.", oldName, AccuracyHelper.getObjectFieldValue(instance,
            "oldName"));
        assertEquals("newName is incorrect.", newName, AccuracyHelper.getObjectFieldValue(instance,
            "newName"));
        assertEquals("newParameters is incorrect.", newParameters, AccuracyHelper
            .getObjectFieldValue(instance, "newParameters"));
        assertEquals("returnParameter is incorrect.", returnParameter, AccuracyHelper
            .getObjectFieldValue(instance, "returnParameter"));
        assertEquals("oldReturnType is incorrect.", oldReturnType, AccuracyHelper
            .getObjectFieldValue(instance, "oldReturnType"));
        assertEquals("newReturnType is incorrect.", newReturnType, AccuracyHelper
            .getObjectFieldValue(instance, "newReturnType"));
        assertEquals("oldConcurrency is incorrect.", oldConcurrency, AccuracyHelper
            .getObjectFieldValue(instance, "oldConcurrency"));
        assertEquals("newConcurrency is incorrect.", newConcurrency, AccuracyHelper
            .getObjectFieldValue(instance, "newConcurrency"));
        assertEquals("oldIsAbstract is incorrect.", oldIsAbstract, AccuracyHelper
            .getObjectFieldValue(instance, "oldIsAbstract"));
        assertEquals("newIsAbstract is incorrect.", newIsAbstract, AccuracyHelper
            .getObjectFieldValue(instance, "newIsAbstract"));
        assertEquals("oldOwnerKind is incorrect.", oldOwnerKind, AccuracyHelper
            .getObjectFieldValue(instance, "oldOwnerKind"));
        assertEquals("newOwnerKind is incorrect.", newOwnerKind, AccuracyHelper
            .getObjectFieldValue(instance, "newOwnerKind"));
    }
}