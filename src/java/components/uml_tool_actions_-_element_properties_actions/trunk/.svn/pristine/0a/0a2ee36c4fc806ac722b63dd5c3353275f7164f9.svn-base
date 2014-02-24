/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifier.feature;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


import com.topcoder.uml.actions.UnitTestsHelper;
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

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the UpdateOperationAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class UpdateOperationActionUnitTests extends TestCase {
    /**
     * Represents the ChangeSizeAction instance used for tests.
     */
    private UpdateOperationAction testUpdateOperationAction;

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
     * Represents the old owner kind (INSTANCE is for non-static, CLASSIFIER is for static) of
     * the operation before this action performed.
     */
    private ScopeKind oldOwnerKind;

    /**
     * Represents the new owner kind (INSTANCE is for non-static, CLASSIFIER is for static) of
     * the operation after this action performed.
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

        testUpdateOperationAction = new UpdateOperationAction(operation, newVisibility, newName,
                newParameters, newReturnType, newConcurrency, newIsAbstract, newOwnerKind);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. Each field value will be set to old|field| value.
     */
    public void testUndoAction() {
        testUpdateOperationAction.undoAction();
        assertEquals("UpdateOperationAction undoAction incorrectly", oldVisibility, operation.getVisibility());
        assertEquals("UpdateOperationAction undoAction incorrectly", oldName, operation.getName());
        assertEquals("UpdateOperationAction undoAction incorrectly", oldConcurrency, operation.getConcurrency());
        assertEquals("UpdateOperationAction undoAction incorrectly", oldIsAbstract, operation.isAbstract());
        assertEquals("UpdateOperationAction undoAction incorrectly", oldOwnerKind, operation.getOwnerScope());
        Iterator<Parameter> iter = operation.getParameters().iterator();
        while (iter.hasNext()) {
            Parameter parameter = iter.next();
            if (parameter.getKind() == ParameterDirectionKind.RETURN) {
                assertEquals("UpdateOperationAction undoAction incorrectly",
                        oldReturnType, parameter.getType());
            }
            if (parameter.getName().equals("input")) {
                assertEquals("UpdateOperationAction undoAction incorrectly",
                        oldParameters.get("input"), parameter.getType());
            }
        }
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. Each field value will be set to new|field| value.
     */
    public void testRedoAction() {
        testUpdateOperationAction.redoAction();
        assertEquals("UpdateOperationAction redoAction incorrectly", newVisibility, operation.getVisibility());
        assertEquals("UpdateOperationAction redoAction incorrectly", newName, operation.getName());
        assertEquals("UpdateOperationAction redoAction incorrectly", newConcurrency, operation.getConcurrency());
        assertEquals("UpdateOperationAction redoAction incorrectly", newIsAbstract, operation.isAbstract());
        assertEquals("UpdateOperationAction redoAction incorrectly", newOwnerKind, operation.getOwnerScope());
        Iterator<Parameter> iter = operation.getParameters().iterator();
        while (iter.hasNext()) {
            Parameter parameter = iter.next();
            if (parameter.getKind() == ParameterDirectionKind.RETURN) {
                assertEquals("UpdateOperationAction redoAction incorrectly",
                        newReturnType, parameter.getType());
            }
            if (parameter.getName().equals("input")) {
                assertEquals("UpdateOperationAction redoAction incorrectly",
                        newParameters.get("input"), parameter.getType());
            }
        }
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. Each field value will be set to new|field| value.
     */
    public void testExecuteAction() {
        testUpdateOperationAction.redoAction();
        assertEquals("UpdateOperationAction redoAction incorrectly", newVisibility, operation.getVisibility());
        assertEquals("UpdateOperationAction redoAction incorrectly", newName, operation.getName());
        assertEquals("UpdateOperationAction redoAction incorrectly", newConcurrency, operation.getConcurrency());
        assertEquals("UpdateOperationAction redoAction incorrectly", newIsAbstract, operation.isAbstract());
        assertEquals("UpdateOperationAction redoAction incorrectly", newOwnerKind, operation.getOwnerScope());
        Iterator<Parameter> iter = operation.getParameters().iterator();
        while (iter.hasNext()) {
            Parameter parameter = iter.next();
            if (parameter.getKind() == ParameterDirectionKind.RETURN) {
                assertEquals("UpdateOperationAction redoAction incorrectly",
                        newReturnType, parameter.getType());
            }
            if (parameter.getName().equals("input")) {
                assertEquals("UpdateOperationAction redoAction incorrectly",
                        newParameters.get("input"), parameter.getType());
            }
        }
    }

    /**
     * Test UpdateOperationAction constructor.
     */
    public void testUpdateOperationAction() {
        assertNotNull("Create UpdateOperationAction incorrectly.", testUpdateOperationAction);
        assertEquals("UpdateOperationAction redoAction incorrectly", newVisibility,
                UnitTestsHelper.getObjectFieldValue(testUpdateOperationAction, "newVisibility"));
        assertEquals("UpdateOperationAction redoAction incorrectly", newName,
                UnitTestsHelper.getObjectFieldValue(testUpdateOperationAction, "newName"));
        assertEquals("UpdateOperationAction redoAction incorrectly", newConcurrency,
                UnitTestsHelper.getObjectFieldValue(testUpdateOperationAction, "newConcurrency"));
        assertEquals("UpdateOperationAction redoAction incorrectly", newIsAbstract,
                UnitTestsHelper.getObjectFieldValue(testUpdateOperationAction, "newIsAbstract"));
        assertEquals("UpdateOperationAction redoAction incorrectly", newOwnerKind,
                UnitTestsHelper.getObjectFieldValue(testUpdateOperationAction, "newOwnerKind"));
        assertEquals("UpdateOperationAction redoAction incorrectly", newReturnType,
                UnitTestsHelper.getObjectFieldValue(testUpdateOperationAction, "newReturnType"));
        assertEquals("UpdateOperationAction redoAction incorrectly", newParameters,
                UnitTestsHelper.getObjectFieldValue(testUpdateOperationAction, "newParameters"));
    }

    /**
     * Test UpdateOperationAction constructor with null operation.
     * Should throw IllegalArgumentException.
     */
    public void testUpdateOperationActionNullOperation() {
        try {
            new UpdateOperationAction(null, newVisibility, newName, newParameters,
                    newReturnType, newConcurrency, newIsAbstract, newOwnerKind);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test UpdateOperationAction constructor with null name.
     * Should throw IllegalArgumentException.
     */
    public void testUpdateOperationActionNullName() {
        try {
            new UpdateOperationAction(operation, newVisibility, null, newParameters,
                    newReturnType, newConcurrency, newIsAbstract, newOwnerKind);
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test UpdateOperationAction constructor with null newParameters.
     * Should throw IllegalArgumentException.
     */
    public void testUpdateOperationActionNullNewParameters() {
        try {
            new UpdateOperationAction(operation, null, newName, newParameters,
                    newReturnType, newConcurrency, newIsAbstract, newOwnerKind);
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
