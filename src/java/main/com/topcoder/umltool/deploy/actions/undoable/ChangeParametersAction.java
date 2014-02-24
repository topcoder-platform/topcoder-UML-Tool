/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the parameters of a model element.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the action, undo
 * to undo the action and execute to execute the action.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeParametersAction extends UndoableAbstractAction implements ReturningAction {
    /**
     * <p>
     * Represents the model element to update the parameters. This variable is set in the constructor, is immutable
     * (the reference). This variable is referenced in the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the operation type of the action. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction
     * methods.
     * </p>
     */
    private final ChangeParametersOperationType operationType;

    /**
     * <p>
     * Represents the index to add parameter. -1 means the end.
     * </p>
     */
    private int index;

    /**
     * <p>
     * Represents the new parameters of the elements after this action performed. This variable is set in the
     * constructor, is immutable (the reference). It won't contain null element. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final Parameter newParameter;

    private final Classifier parameterType;

    private List<UpdateModelElementAction> actions;

    /**
     * <p>
     * Creates an instance of the ChangeParametersAction.
     * </p>
     *
     * @param element
     *            the non null model element to change the parameters
     * @param parameter
     *            the new parameters of the model element
     * @param operationType
     *            the parameters change kind
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeParametersAction(ModelElement element, Parameter parameter,
        ChangeParametersOperationType operationType, boolean autoGenerate) {
        this(element, parameter, -1, operationType, autoGenerate);
    }

    /**
     * <p>
     * Creates an instance of the ChangeParametersAction. This action will be used to add a parameter at a
     * specified index.
     * </p>
     *
     * @param element
     *            the non null model element to change the parameters
     * @param parameter
     *            the new parameters of the model element
     * @param index
     *            the specified index
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeParametersAction(ModelElement element, Parameter parameter, int index, boolean autoGenerate) {
        this(element, parameter, index, ChangeParametersOperationType.ADD, autoGenerate);
    }

    private ChangeParametersAction(ModelElement element, Parameter parameter, int index,
        ChangeParametersOperationType operationType, boolean autoGenerate) {
        super("Set entity stereotypes");
        DeployHelper.checkNotNull(element, "element");
        DeployHelper.checkNotNull(parameter, "parameter");
        DeployHelper.checkNotNull(operationType, "operationType");
        this.element = element;
        newParameter = parameter;
        parameterType = parameter.getType();
        if (operationType != ChangeParametersOperationType.REMOVE) {
            ParameterImpl.setType(newParameter, null);
        }
        this.index = index;
        this.operationType = operationType;

        if (autoGenerate) {
            actions = new ArrayList<UpdateModelElementAction>();

            Operation operation = (Operation) element;

            List<Operation> childOps = DeployHelper.getAllExtensions(operation);

            for (Operation childOperation : childOps) {
                Parameter dupl = copyParameter(parameter);
                dupl.setType(parameterType);
                Classifier owner = childOperation.getOwner();
                if (operationType == ChangeParametersOperationType.ADD) {
                    UpdateModelElementAction action = new UpdateModelElementAction(owner);
                    action.put(new ChangeParametersAction(childOperation, dupl, index, false));
                    actions.add(action);
                } else {
                    if (operationType == ChangeParametersOperationType.REMOVE) {
                        for (Parameter param : childOperation.getParameters()) {
                            if (param.getName().equals(newParameter.getName())) {
                                dupl = param;
                                break;
                            }
                        }
                    }
                    UpdateModelElementAction action = new UpdateModelElementAction(owner);
                    action.put(new ChangeParametersAction(childOperation, dupl, operationType, false));
                    actions.add(action);
                }
            }
        }

    }

    /**
     * <p>
     * Execute the set entity parameters action.
     * </p>
     */
    public void executeAction() {
        redoAction();
    }

    /**
     * <p>
     * Undo the set entity parameters action.
     * </p>
     */
    public void undoAction() {
        if (operationType == ChangeParametersOperationType.REMOVE) {
            if (index != -1) {
                ((Operation) element).addParameter(index, newParameter);
            } else {
                ((Operation) element).addParameter(newParameter);
            }
            ParameterImpl.setType(newParameter, parameterType);
        } else if (operationType == ChangeParametersOperationType.ADD) {
            index = ((Operation) element).getParameters().indexOf(newParameter);
            ((Operation) element).removeParameter(newParameter);
            newParameter.setBehavioralFeature(null);
            ParameterImpl.setType(newParameter, null);
        }
    }

    /**
     * <p>
     * Redo the set entity parameters action.
     * </p>
     */
    public void redoAction() {
        if (operationType == ChangeParametersOperationType.ADD) {
            if (index != -1) {
                ((Operation) element).addParameter(index, newParameter);
            } else {
                ((Operation) element).addParameter(newParameter);
            }
            ParameterImpl.setType(newParameter, parameterType);
        } else if (operationType == ChangeParametersOperationType.REMOVE) {
            index = ((Operation) element).getParameters().indexOf(newParameter);
            ((Operation) element).removeParameter(newParameter);
            ParameterImpl.setType(newParameter, null);
        }

    }

    private Parameter copyParameter(Parameter param) {
        Parameter dupl = new ParameterImpl();
        dupl.setName(param.getName());
        dupl.setType(param.getType());
        dupl.setKind(param.getKind());
        return dupl;
    }

    public List<UpdateModelElementAction> getActions() {
        return actions;
    }

}
