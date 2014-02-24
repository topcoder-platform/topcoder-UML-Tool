/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.HashSet;
import java.util.Set;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.TextField;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedListener;
import com.topcoder.uml.actions.general.ChangeEntityVisibilityAction;
import com.topcoder.uml.actions.general.SetEntityStereotypesAction;
import com.topcoder.uml.actions.general.operationtypes.SetEntityStereotypesOperationType;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.ChangeEntityNameAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeParametersAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeParametersOperationType;
import com.topcoder.umltool.deploy.actions.undoable.ChangeTypeAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;

/**
 * <p>
 * This implementation class listens to text change event from operations of Class component's nodes.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 *
 * @author ly
 * @version 1.0
 */
public class OperationTextChangedHandler implements TextChangedListener {

    /**
     * <p>
     * Default parameter type.
     * </p>
     */
    private static final String DEFAULT_PARAMETER_TYPE = "int";

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>OperationTextChangedHandler</code>.
     * </p>
     *
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public OperationTextChangedHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Handles the text changed event.
     * </p>
     * <p>
     * The event parameter could tell which TextField text is changed, and what is the old text and new text value.
     * </p>
     *
     * @param e
     *            the text changed event
     * @throws IllegalArgumentException
     *             if e is null
     */
    public void textChanged(TextChangedEvent e) {
        DeployHelper.checkNotNull(e, "event");
        String text = e.getNewText().trim();
        if (text.length() == 0 || text.equals(e.getOldText())) {
            return;
        }

        // Retrieve the TextField, and node
        TextField textField = (TextField) e.getSource();
        ClassNode node = (ClassNode) textField.getParent().getParent();
        ModelElement modelElement = DeployHelper.getElement(node);

        // Get the model element
        GraphNode graphNode = textField.getGraphNode();
        Operation operation = (Operation) DeployHelper.getElement(graphNode);
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(node, "Operation text changed.");
        // Parse the new text and change operation
        // Change visibility
        VisibilityKind visibilityKind = DeployHelper.parseVisibilityKind(text);
        if (visibilityKind != null) {
            text = text.substring(1);
        } else {
            visibilityKind = operation.getVisibility();
        }
        if (operation.getVisibility() != visibilityKind) {
            ChangeEntityVisibilityAction changeVisibilityAction =
                new ChangeEntityVisibilityAction(operation, visibilityKind);
            compositeAction.put(changeVisibilityAction, DeployHelper.getComponent(modelElement, mainFrame));
        }

        // Change name
        boolean isConstructor = false;
        if (text.length() != 0) {
            String name = parseName(text);
            text = text.substring(name.length());
            if (!operation.getName().equals(name)) {
                ChangeEntityNameAction changeNameAction =
                    new ChangeEntityNameAction(operation, name, mainFrame.isAutoGenerateMethods());
                compositeAction.put(changeNameAction, DeployHelper.getComponent(modelElement, mainFrame));
            }
            if (name.equals(node.getNameCompartment().getText())) {
                isConstructor = true;
                // Add "create" stereotype if this stereotype is still not added
                if (findStereotype(operation, "create") == null) {
                    Stereotype stereotype = DeployHelper.getStereotype(mainFrame, "create", OperationImpl.class);
                    Model model = mainFrame.getUmlModelManager().getModel();
                    if (!model.containsOwnedElement(stereotype)) {
                        model.addOwnedElement(stereotype);
                    }
                    addStereotype(node, operation, compositeAction, stereotype);
                }
            }
            text = trimFirstCharacter(text);
        }

        // Change parameters
        if (text.length() != 0) {
            String parameterList = parseParameterList(text);
            text = text.substring(parameterList.length());

            changeParameters(node, operation, compositeAction, parameterList);

            text = trimFirstCharacter(text).trim();
            text = trimFirstCharacter(text).trim();
        }

        Parameter returnParameter = getReturnParameter(operation);
        if (isConstructor) {
            // Remove return type
            if (returnParameter != null) {
                removeParameter(node, operation, compositeAction, returnParameter);
            }
        } else if (text.length() != 0) {
            // Change return type
            if (returnParameter == null) {
                Parameter newParameter = new ParameterImpl();
                newParameter.setKind(ParameterDirectionKind.RETURN);
                newParameter.setName("Return");
                newParameter.setType(DeployHelper.findType(text, mainFrame));
                ChangeParametersAction addNewParamterAction =
                    new ChangeParametersAction(operation, newParameter, ChangeParametersOperationType.ADD,
                        mainFrame.isAutoGenerateMethods());
                compositeAction.put(addNewParamterAction, node);
            } else if (returnParameter.getType() == null || !returnParameter.getType().getName().equals(text)) {
                ChangeTypeAction changeTypeAction =
                    new ChangeTypeAction(returnParameter, DeployHelper.findType(text, mainFrame), mainFrame
                        .isAutoGenerateMethods());
                compositeAction.put(changeTypeAction, node);
            }
        }
        mainFrame.handleActionEvent(compositeAction, node, "Operation changed");
    }

    /**
     * <p>
     * Finds the stereotype from model element with specified name.
     * </p>
     *
     * @param modelElement
     *            the model element to find stereotype
     * @param name
     *            the stereotype name
     * @return the found stereotype, null if not found
     */
    private Stereotype findStereotype(ModelElement modelElement, String name) {
        for (Stereotype stereotype : modelElement.getStereotypes()) {
            if (stereotype.getName().equals("create")) {
                return stereotype;
            }
        }
        return null;
    }

    /**
     * <p>
     * Adds stereotype to given model element.
     * </p>
     *
     * @param node
     *            the node containing specified model element
     * @param modelElement
     *            the model element to add stereotype
     * @param compositeAction
     *            the composite action which will contain the add stereotype action
     * @param stereotype
     *            the stereotype to be added
     */
    private void addStereotype(Node node, ModelElement modelElement, UpdateNodeContainerAction compositeAction,
        Stereotype stereotype) {
        Set<Stereotype> newStereotypes = new HashSet<Stereotype>();
        newStereotypes.add(stereotype);
        SetEntityStereotypesAction setEndtityStereotypesAction =
            new SetEntityStereotypesAction(modelElement, newStereotypes, SetEntityStereotypesOperationType.UPDATE);
        compositeAction.put(setEndtityStereotypesAction, DeployHelper.getComponent(DeployHelper.getElement(node),
            mainFrame));
    }

    /**
     * <p>
     * Gets the return parameter of given operation.
     * </p>
     *
     * @param operation
     *            the operation to get return parameter
     * @return the found return parameter
     */
    private Parameter getReturnParameter(Operation operation) {
        for (Parameter parameter : operation.getParameters()) {
            if (parameter.getKind() == ParameterDirectionKind.RETURN) {
                return parameter;
            }
        }
        return null;
    }

    /**
     * <p>
     * Changes the parameter list of specified operation according to given new parameter list string.
     * </p>
     *
     * @param node
     *            the node which contains the operation
     * @param operation
     *            the operation which contains the parameter
     * @param compositeAction
     *            the composite action which will contain the change parameter action
     * @param parameterList
     *            text for parameter list
     */
    private void changeParameters(Node node, Operation operation, UpdateNodeContainerAction compositeAction,
        String parameterList) {
        int oldParametersCount = operation.getParameters().size();
        Parameter returnParameter = getReturnParameter(operation);
        if (returnParameter != null) {
            --oldParametersCount;
            // Move return parameter to the end
            operation.removeParameter(returnParameter);
            operation.addParameter(returnParameter);
        }
        int i = 0;
        while (parameterList.length() != 0) {
            String parameter = parseParameter(parameterList);
            parameterList = parameterList.substring(parameter.length());

            parameter = parameter.trim();
            String parameterName = parseParameterName(parameter).trim();
            String parameterType = parameter.substring(parameterName.length()).trim();
            parameterType = trimFirstCharacter(parameterType).trim();
            if (parameterType.length() == 0) {
                parameterType = DEFAULT_PARAMETER_TYPE;
            }

            if (i < oldParametersCount) {
                Parameter oldParamter = operation.getParameters().get(i);

                // BUG-1374 Make sure the behavioral feature is set.
                oldParamter.setBehavioralFeature(operation);

                if (!oldParamter.getName().equals(parameterName)) {
                    ChangeEntityNameAction changeNameAction =
                        new ChangeEntityNameAction(oldParamter, parameterName, mainFrame.isAutoGenerateMethods());
                    compositeAction.put(changeNameAction, node);
                }
                if (oldParamter.getType() == null || !oldParamter.getType().getName().equals(parameterType)) {
                    ChangeTypeAction changeTypeAction =
                        new ChangeTypeAction(oldParamter, DeployHelper.findType(parameterType, mainFrame),
                            mainFrame.isAutoGenerateMethods());
                    compositeAction.put(changeTypeAction, node);
                }
            } else {
                Parameter newParameter = new ParameterImpl();
                newParameter.setName(parameterName);
                newParameter.setType(DeployHelper.findType(parameterType, mainFrame));

                // BUG-1374 The behavioral feature needs to be added.
                newParameter.setKind(ParameterDirectionKind.IN);
                newParameter.setBehavioralFeature(operation);

                ChangeParametersAction addNewParamterAction =
                    new ChangeParametersAction(operation, newParameter, i, mainFrame.isAutoGenerateMethods());
                compositeAction.put(addNewParamterAction, node);
            }

            parameterList = trimFirstCharacter(parameterList);
            ++i;
        }

        // Remove left old parameters
        for (int j = oldParametersCount - 1; j >= i; --j) {
            Parameter oldParamter = operation.getParameters().get(j);
            removeParameter(node, operation, compositeAction, oldParamter);
        }

    }

    /**
     * <p>
     * Removes parameter from operation's parameter list.
     * </p>
     *
     * @param node
     *            the node which contains the operation
     * @param operation
     *            the operation which contains the parameter
     * @param compositeAction
     *            the composite action which will contain the remove parameter action
     * @param oldParamter
     *            the old parameter to be removed
     */
    private void removeParameter(Node node, Operation operation, UpdateNodeContainerAction compositeAction,
        Parameter oldParamter) {
        ModelElement modelElement = DeployHelper.getElement(node);
        ChangeParametersAction removeOldParamterAction =
            new ChangeParametersAction(operation, oldParamter, ChangeParametersOperationType.REMOVE, mainFrame
                .isAutoGenerateMethods());
        compositeAction.put(removeOldParamterAction, DeployHelper.getComponent(modelElement, mainFrame));
    }

    /**
     * <p>
     * Trims the first character for given string.
     * </p>
     *
     * @param text
     *            the string to be trimmed
     * @return the trimmed string
     */
    private String trimFirstCharacter(String text) {
        if (text.length() != 0) {
            text = text.substring(1);
        }
        return text;
    }

    /**
     * <p>
     * Parses operation name from given text.
     * </p>
     *
     * @param text
     *            text for an operation
     * @return parsed name
     */
    private String parseName(String text) {
        int index = text.indexOf('(');
        if (index == -1) {
            index = text.length();
        }
        String name = text.substring(0, index);
        return name;
    }

    /**
     * <p>
     * Parses operation's parameter list from given text.
     * </p>
     *
     * @param text
     *            text for an operation
     * @return parsed parameter list
     */
    private String parseParameterList(String text) {
        int index = text.indexOf(')');
        if (index == -1) {
            index = text.length();
        }
        String parameterList = text.substring(0, index);
        return parameterList;
    }

    /**
     * <p>
     * Parses a parameter from given parameter list text.
     * </p>
     *
     * @param parameterList
     *            text for parameter list
     * @return parsed parameter
     */
    private String parseParameter(String parameterList) {
        // UML-563: Generic method signature parsing

        int index = 0;
        int indexEndGeneric = 0;
        int start = 0;
        do {
            indexEndGeneric = parameterList.indexOf('>', start);
            index = parameterList.indexOf(',', start);
            if (index != -1 && indexEndGeneric != -1 && index < indexEndGeneric) {
                start = index + 1;
            }
        } while (index != -1 && indexEndGeneric != -1
                && index < indexEndGeneric);

        if (index == -1) {
            index = parameterList.length();
        }
        String parameter = parameterList.substring(0, index);
        return parameter;
    }

    /**
     * <p>
     * Parses the parameter name from given parameter string.
     * </p>
     *
     * @param parameter
     *            text for parameter list
     * @return parsed parameter name
     */
    private String parseParameterName(String parameter) {
        int index = parameter.indexOf(':');
        if (index == -1) {
            index = parameter.length();
        }
        String name = parameter.substring(0, index);
        return name;
    }
}
