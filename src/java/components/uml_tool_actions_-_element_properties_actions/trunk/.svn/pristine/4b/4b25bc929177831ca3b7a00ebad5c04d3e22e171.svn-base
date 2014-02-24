/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.feature;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.topcoder.uml.actions.general.Helper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will update the given operation. The received
 * parameters should be complete. This action will simply update the all the attributes according to the given
 * parameters.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the action, undo to
 * undo the action and execute to execute the action. If any exception prevents redo/undo methods from completing
 * successfully, it should be log with logError.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 * @author kinzz, rainday
 * @version 1.0
 */
public class UpdateOperationAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the old name of the operation before this action performed. This variable is set in the constructor,
     * is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final String oldName;

    /**
     * <p>
     * Represents the new visibility of the operation after this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final VisibilityKind newVisibility;

    /**
     * <p>
     * Represents the new name of the operation after this action performed. This variable is set in the constructor, is
     * immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final String newName;

    /**
     * <p>
     * Represents the old visibility of the operation before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final VisibilityKind oldVisibility;

    /**
     * <p>
     * Represents the new concurrency of the operation after this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final CallConcurrencyKind newConcurrency;

    /**
     * <p>
     * Represents the old concurrency of the operation before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final CallConcurrencyKind oldConcurrency;

    /**
     * <p>
     * Represents the old owner kind (INSTANCE is for non-static, CLASSIFIER is for static) of the operation before this
     * action performed. This variable is set in the constructor, is immutable. This variable is referenced in the
     * doAction method.
     * </p>
     */
    private final ScopeKind oldOwnerKind;

    /**
     * <p>
     * Represents the new owner kind (INSTANCE is for non-static, CLASSIFIER is for static) of the operation after this
     * action performed. This variable is set in the constructor, is immutable. This variable is referenced in the
     * doAction method.
     * </p>
     */
    private final ScopeKind newOwnerKind;

    /**
     * <p>
     * Represents the new isAbstract of the operation after this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final boolean newIsAbstract;

    /**
     * <p>
     * Represents the old isAbstract of the operation before this action performed. This variable is set in the
     * constructor, is immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final boolean oldIsAbstract;

    /**
     * <p>
     * Represents the old return type of the operation before this action performed. The return type is a parameter with
     * &quot;kind&quot; attribute set to ParameterDirectionKind.RETURN. This variable is set in the constructor, is
     * immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final Classifier oldReturnType;

    /**
     * <p>
     * Represents the new return type of the operation after this action performed. The return type is a parameter with
     * &quot;kind&quot; attribute set to ParameterDirectionKind.RETURN. This variable is set in the constructor, is
     * immutable. This variable is referenced in the doAction method.
     * </p>
     */
    private final Classifier newReturnType;

    /**
     * <p>
     * Represents the old parameters of the operation before this action performed. This variable is set in the
     * constructor, is immutable. The key is the name of the parameters, which never be null and possible empty. The
     * value is the parameter which never be null. This variable is referenced in the doAction method.
     * </p>
     */
    private final Map<String, Classifier> oldParameters;

    /**
     * <p>
     * Represents the new parameters of the operation after this action performed. This variable is set in the
     * constructor, is immutable. The key is the name of the parameters, which never be null and possible empty. The
     * value is the parameter which never be null. This variable is referenced in the doAction method.
     * </p>
     */
    private final Map<String, Classifier> newParameters;

    /**
     * <p>
     * Represents the operation to be updated. This variable is set in the constructor, is immutable (the reference) and
     * never be null. This variable is referenced in the redoAction and executeAction methods.
     * </p>
     */
    private final Operation operation;

    /**
     * <p>
     * Represents the return parameter to be updated. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction and executeAction methods.
     * </p>
     */
    private final Parameter returnParameter;

    /**
     * <p>
     * Constructor of the update operation action. The parameters should be complete given by the caller.
     * </p>
     * @param operation
     *            the non null operation to be updated
     * @param visibility
     *            the new visibility of the operation
     * @param name
     *            the non null name of the operation
     * @param parameters
     *            the new parameters of the operation
     * @param returnType
     *            the new return type of the operation
     * @param concurrency
     *            the new concurrency of the operation
     * @param isAbstract
     *            the new isAbstract of the operation
     * @param ownerKind
     *            the new owner kind of the operation
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public UpdateOperationAction(Operation operation, VisibilityKind visibility, String name,
        Map<String, Classifier> parameters, Classifier returnType, CallConcurrencyKind concurrency, boolean isAbstract,
        ScopeKind ownerKind) {
        super("Update operation");
        Helper.checkNotNull(operation, "operation");
        Helper.checkNotNull(name, "name");
        Helper.checkNotNull(parameters, "parameters");

        this.operation = operation;
        oldVisibility = operation.getVisibility();
        newVisibility = visibility;

        oldName = operation.getName();
        newName = name;

        oldParameters = new HashMap<String, Classifier>();
        Iterator<Parameter> iter = operation.getParameters().iterator();
        Parameter parameter = null, theReturnParameter = null;
        while (iter.hasNext()) {
            parameter = iter.next();
            if (parameters.containsKey(parameter.getName())) {
                oldParameters.put(parameter.getName(), parameter.getType());
            }
            if (parameter.getKind() == ParameterDirectionKind.RETURN) {
                theReturnParameter = parameter;
            }
        }
        newParameters = parameters;

        // if the return type parameter is not found, create a new one.
        if (theReturnParameter == null && returnType != null) {
            returnParameter = new ParameterImpl();
            returnParameter.setKind(ParameterDirectionKind.RETURN);
            operation.addParameter(returnParameter);
        } else {
            returnParameter = theReturnParameter;
        }
        oldReturnType = returnParameter.getType();
        newReturnType = returnType;

        oldConcurrency = operation.getConcurrency();
        newConcurrency = concurrency;

        oldIsAbstract = operation.isAbstract();
        newIsAbstract = isAbstract;

        oldOwnerKind = operation.getOwnerScope();
        newOwnerKind = ownerKind;
    }

    /**
     * <p>
     * Execute the update operation action.
     * </p>
     */
    public void executeAction() {
        redoAction();
    }

    /**
     * <p>
     * Redo the update operation action.
     * </p>
     */
    public void redoAction() {
        updateOperationValues(newVisibility, newName, newParameters, newReturnType, newConcurrency, newIsAbstract,
                newOwnerKind);
    }

    /**
     * <p>
     * Undo the update operation action.
     * </p>
     */
    public void undoAction() {
        updateOperationValues(oldVisibility, oldName, oldParameters, oldReturnType, oldConcurrency, oldIsAbstract,
                oldOwnerKind);
    }

    /**
     * <p>
     * Update the fields of the operation.
     * </p>
     * @param visibility
     *            the new visibility of the operation
     * @param name
     *            the non null name of the operation
     * @param parameters
     *            the new parameters of the operation
     * @param returnType
     *            the new return type of the operation
     * @param concurrency
     *            the new concurrency of the operation
     * @param isAbstract
     *            the new isAbstract of the operation
     * @param ownerKind
     *            the new owner kind of the operation
     */
    private void updateOperationValues(VisibilityKind visibility, String name, Map<String, Classifier> parameters,
            Classifier returnType, CallConcurrencyKind concurrency, boolean isAbstract, ScopeKind ownerKind) {
        operation.setVisibility(visibility);
        operation.setName(name);

        Iterator<Parameter> iter = operation.getParameters().iterator();
        Parameter parameter = null;
        while (iter.hasNext()) {
            parameter = iter.next();
            if (parameters.containsKey(parameter.getName())) {
                parameter.setType(parameters.get(parameter.getName()));
            }
        }

        returnParameter.setType(returnType);
        operation.setConcurrency(concurrency);
        operation.setAbstract(isAbstract);
        operation.setOwnerScope(ownerKind);
    }
}
