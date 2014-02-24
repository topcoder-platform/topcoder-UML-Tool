/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;
import com.topcoder.gui.panels.properties.ModelElementChangeListener;
import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyOperation;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreeView;
import com.topcoder.uml.actions.general.ChangeEntityVisibilityAction;
import com.topcoder.uml.actions.general.SetEntityStereotypesAction;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.actions.general.operationtypes.SetEntityStereotypesOperationType;
import com.topcoder.uml.actions.model.custom.SetTransitionGuardAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpressionImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.umltool.deploy.AttributeAddAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.OperationAddAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeAbstractAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeActiveAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeAggregationAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeAsynchronousAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeChangeabilityAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeConcurrencyAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeEntityNameAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeFinalAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeInitialValueAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeKindAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeMultiplicityAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeNamespaceAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeNavigableAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeOrderingAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeParametersAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeParametersOperationType;
import com.topcoder.umltool.deploy.actions.undoable.ChangeRootAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeStaticAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeTransientAction;
import com.topcoder.umltool.deploy.actions.undoable.ChangeTypeAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This implementation of ModelElementChangeListener will check which model element is changed, and update diagram
 * viewer, document tree panel in the main frame.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ModelElementChangeHandler implements ModelElementChangeListener {
    /**
     * <p>
     * Represents the attribute compartment's graph node index in the graph node structure.
     * </p>
     */
    private static final int ATTRIBUTE_INDEX = 2;

    /**
     * <p>
     * Represents the operation compartment's graph node index in the graph node structure.
     * </p>
     */
    private static final int OPERATION_INDEX = 4;

    /**
     * <p>
     * The mainframe associated with this handler.
     * </p>
     */
    private MainFrame mainFrame = null;

    /**
     * <p>
     * Creates an instance of ModelElementChangeHandler with the mainframe.
     * </p>
     *
     * @param mainFrame
     *            the mainFrame
     */
    public ModelElementChangeHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Changes a property for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param kind
     *            the modified property name
     * @param operation
     *            the kind of operation to be done on the property
     * @param object
     *            the object that will be added/removed or modify the property
     * @throws IllegalArgumentException
     *             if modelElement, kind or operation is null
     */
    public void stateChanged(ModelElement modelElement, PropertyKind kind, PropertyOperation operation,
        java.lang.Object object) {
        DeployHelper.checkNotNull(modelElement, "modelelement");
        DeployHelper.checkNotNull(kind, "kind");
        DeployHelper.checkNotNull(operation, "operation");
        if (kind == PropertyKind.NAME) {
            changeName(modelElement, operation, (String) object);
        } else if (kind == PropertyKind.NAMESPACE) {
            changeNamespace(modelElement, operation, (Namespace) object);
        } else if (kind == PropertyKind.TYPE) {
            changeType(modelElement, operation, (Classifier) object);
        } else if (kind == PropertyKind.VISIBILITY) {
            changeVisibility(modelElement, operation, (VisibilityKind) object);
        } else if (kind == PropertyKind.CHANGEABILITY) {
            changeChangeability(modelElement, operation, (ChangeableKind) object);
        } else if (kind == PropertyKind.INITIAL_VALUE) {
            changeInitialValue(modelElement, operation, (String) object);
        } else if (kind == PropertyKind.GUARD) {
            changeGuard(modelElement, operation, (String) object);
        } else if (kind == PropertyKind.AGGREGATION) {
            changeAggregation(modelElement, operation, (AggregationKind) object);
        } else if (kind == PropertyKind.MULTIPLICITY) {
            changeMultiplicity(modelElement, operation, (Multiplicity) object);
        } else if (kind == PropertyKind.KIND) {
            changeKind(modelElement, operation, (ParameterDirectionKind) object);
        } else if (kind == PropertyKind.CONCURRENCY) {
            changeConcurrency(modelElement, operation, (CallConcurrencyKind) object);
        } else if (kind == PropertyKind.ORDERING) {
            changeOrdering(modelElement, operation, (OrderingKind) object);
        } else if (kind == PropertyKind.PARAMETERS) {
            changeParameter(modelElement, operation, (Parameter) object);
        } else if (kind == PropertyKind.STEREOTYPES) {
            changeStereotype(modelElement, operation, object);
        } else if (kind == PropertyKind.ABSTRACT) {
            changeAbstract(modelElement, operation, ((Boolean) object).booleanValue());
        } else if (kind == PropertyKind.FINAL) {
            changeFinal(modelElement, operation, ((Boolean) object).booleanValue());
        } else if (kind == PropertyKind.ROOT) {
            changeRoot(modelElement, operation, ((Boolean) object).booleanValue());
        } else if (kind == PropertyKind.STATIC) {
            changeStatic(modelElement, operation, ((Boolean) object).booleanValue());
        } else if (kind == PropertyKind.ACTIVE) {
            changeActive(modelElement, operation, ((Boolean) object).booleanValue());
        } else if (kind == PropertyKind.TRANSIENT) {
            changeTransient(modelElement, operation, ((Boolean) object).booleanValue());
        } else if (kind == PropertyKind.NAVIGABLE) {
            changeNavigable(modelElement, operation, ((Boolean) object).booleanValue());
        } else if (kind == PropertyKind.ASYNCHRONOUS) {
            changeAsynchronous(modelElement, operation, ((Boolean) object).booleanValue());
        } else if (kind == PropertyKind.OPERATION) {
            changeOperation(modelElement, operation);
        } else if (kind == PropertyKind.ATTRIBUTE) {
            changeAttribute(modelElement, operation);
        }
        mainFrame.updateDiagramView();
    }

    /**
     * <p>
     * Changes name for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param string
     *            the new name
     */
    private void changeName(ModelElement modelElement, PropertyOperation operation, String string) {
        if (operation == PropertyOperation.MODIFY) {
            if (modelElement instanceof ClassImpl) {
                DeployHelper.changeConstructors(mainFrame, (ClassImpl) modelElement, string, DeployHelper
                    .getComponent(modelElement, mainFrame));
            } else {
                ChangeEntityNameAction changeEntityNameAction =
                    new ChangeEntityNameAction(modelElement, string, mainFrame.isAutoGenerateMethods());
                handleActionEvent(changeEntityNameAction, modelElement, "change name");
            }
        }
    }

    /**
     * <p>
     * Changes namespace for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param namespace
     *            the new namespace
     */
    private void changeNamespace(ModelElement modelElement, PropertyOperation operation, Namespace namespace) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeNamespaceAction changeNamespaceAction = new ChangeNamespaceAction(modelElement, namespace);
            handleActionEvent(changeNamespaceAction, modelElement, "change namespace");
        }
    }

    /**
     * <p>
     * Changes type for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param classifier
     *            the new type
     */
    private void changeType(ModelElement modelElement, PropertyOperation operation, Classifier classifier) {
        if (operation == PropertyOperation.MODIFY) {
            UMLModelManager manager = UMLModelManager.getInstance();
            Model root = manager.getModel();
            if (!modelContainClassifier(root, classifier)) {
                DeployHelper.modelAddClassifier(classifier);
            }
            ChangeTypeAction changeTypeAction =
                new ChangeTypeAction(modelElement, classifier, mainFrame.isAutoGenerateMethods());
            handleActionEvent(changeTypeAction, modelElement, "change type");
            List<JComponent> selected =
                new ArrayList<JComponent>(mainFrame.getDiagramViewer().getAllSelectedElements());
            mainFrame.getDocumentTree().updateTree();
            for (JComponent jComponent : selected) {
                mainFrame.getDiagramViewer().addSelectedElement(jComponent);
            }
            DeployHelper.notifySelectionChanged(mainFrame, mainFrame.getDiagramViewer());
        }
    }

    /**
     * <p>
     * Checks whether the namespace contains the classifier.
     * </p>
     *
     * @param namespace
     *            the namespace
     * @param classifier
     *            the classifier
     * @return whether the namespace contains the classifier
     */
    private boolean modelContainClassifier(Namespace namespace, Classifier classifier) {
        for (ModelElement element : namespace.getOwnedElements()) {
            if ((element.equals(classifier))
                || ((element instanceof Namespace) && modelContainClassifier((Namespace) element, classifier))) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Changes visibility for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param visibilityKind
     *            the new visibility kind
     */
    private void changeVisibility(ModelElement modelElement, PropertyOperation operation,
        VisibilityKind visibilityKind) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeEntityVisibilityAction changeEntityVisibilityAction =
                new ChangeEntityVisibilityAction(modelElement, visibilityKind);
            handleActionEvent(changeEntityVisibilityAction, modelElement, "change visibility");
        }
    }

    /**
     * <p>
     * Changes changeability for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param changeableKind
     *            the new changeable kind
     */
    private void changeChangeability(ModelElement modelElement, PropertyOperation operation,
        ChangeableKind changeableKind) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeChangeabilityAction changeChangeabilityAction =
                new ChangeChangeabilityAction(modelElement, changeableKind);
            handleActionEvent(changeChangeabilityAction, modelElement, "change changeability");
        }
    }

    /**
     * <p>
     * Changes initial value for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param value
     *            the new initial value
     */
    private void changeInitialValue(ModelElement modelElement, PropertyOperation operation, String value) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeInitialValueAction changeInitialValueAction = new ChangeInitialValueAction(modelElement, value);
            handleActionEvent(changeInitialValueAction, modelElement, "change initialvalue");
        }
    }

    /**
     * <p>
     * Changes Guard for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param string
     *            the new guard
     */
    private void changeGuard(ModelElement modelElement, PropertyOperation operation, String string) {
        if (operation == PropertyOperation.MODIFY) {
            BooleanExpression expression = new BooleanExpressionImpl();
            expression.setBody(string);
            Guard guard = new GuardImpl(expression, (Transition) modelElement);
            SetTransitionGuardAction setTransitionGuardAction =
                new SetTransitionGuardAction((Transition) modelElement, guard);
            handleActionEvent(setTransitionGuardAction, modelElement, "change guard");
        }
    }

    /**
     * <p>
     * Changes aggregation for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param kind
     *            the new aggregation kind
     */
    private void changeAggregation(ModelElement modelElement, PropertyOperation operation, AggregationKind kind) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeAggregationAction changeAggregationAction = new ChangeAggregationAction(modelElement, kind);
            handleActionEvent(changeAggregationAction, modelElement, "change aggregation");
        }
    }

    /**
     * <p>
     * Changes multiplicity for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param multiplicity
     *            the new multiplicity
     */
    private void changeMultiplicity(ModelElement modelElement, PropertyOperation operation,
        Multiplicity multiplicity) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeMultiplicityAction changeMultiplicityAction =
                new ChangeMultiplicityAction(modelElement, multiplicity);
            handleActionEvent(changeMultiplicityAction, modelElement, "change multiplicity");
        }
    }

    /**
     * <p>
     * Changes kind for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param kind
     *            the new parameter direction kind
     */
    private void changeKind(ModelElement modelElement, PropertyOperation operation, ParameterDirectionKind kind) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeKindAction changeKindAction = new ChangeKindAction(modelElement, kind);
            handleActionEvent(changeKindAction, modelElement, "change kind");
        }
    }

    /**
     * <p>
     * Changes concurrency for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param concurrency
     *            the new call concurrency kind
     */
    private void changeConcurrency(ModelElement modelElement, PropertyOperation operation,
        CallConcurrencyKind concurrency) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeConcurrencyAction changeConcurrencyAction =
                new ChangeConcurrencyAction(modelElement, concurrency);
            handleActionEvent(changeConcurrencyAction, modelElement, "change concurrency");
        }
    }

    /**
     * <p>
     * Changes ordering for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param ordering
     *            the new ordering kind
     */
    private void changeOrdering(ModelElement modelElement, PropertyOperation operation, OrderingKind ordering) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeOrderingAction changeOrderingAction = new ChangeOrderingAction(modelElement, ordering);
            handleActionEvent(changeOrderingAction, modelElement, "change ordering");
        }
    }

    /**
     * <p>
     * Changes parameter for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param parameter
     *            the changed parameter
     */
    private void changeParameter(ModelElement modelElement, PropertyOperation operation, Parameter parameter) {
        ChangeParametersAction changeParametersAction = null;
        if (operation == PropertyOperation.ADD) {
            changeParametersAction =
                new ChangeParametersAction(modelElement, parameter, ChangeParametersOperationType.ADD, mainFrame
                    .isAutoGenerateMethods());
        } else if (operation == PropertyOperation.REMOVE) {
            changeParametersAction =
                new ChangeParametersAction(modelElement, parameter, ChangeParametersOperationType.REMOVE,
                    mainFrame.isAutoGenerateMethods());
        }
        if (changeParametersAction != null) {
            handleActionEvent(changeParametersAction, modelElement, "change parameter");
        }
    }

    /**
     * <p>
     * Changes stereotype for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param object
     *            the changed stereotype
     */
    @SuppressWarnings("unchecked")
    private void changeStereotype(ModelElement modelElement, PropertyOperation operation, Object object) {
        SetEntityStereotypesAction setEntityStereotypesAction = null;
        if (operation == PropertyOperation.MODIFY) {
            setEntityStereotypesAction =
                new SetEntityStereotypesAction(modelElement, (Set<Stereotype>) object,
                    SetEntityStereotypesOperationType.UPDATE);
        } else if (operation == PropertyOperation.REMOVE) {
            Set<Stereotype> stereotypes = new HashSet<Stereotype>();
            stereotypes.add((Stereotype) object);
            setEntityStereotypesAction =
                new SetEntityStereotypesAction(modelElement, stereotypes, SetEntityStereotypesOperationType.REMOVE);
        }
        if (setEntityStereotypesAction != null) {
            handleActionEvent(setEntityStereotypesAction, modelElement, "change stereotype");
        }
    }

    /**
     * <p>
     * Changes abstract for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param isAbstract
     *            the new abstract value
     */
    private void changeAbstract(ModelElement modelElement, PropertyOperation operation, boolean isAbstract) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeAbstractAction changeAbstractAction = new ChangeAbstractAction(modelElement, isAbstract);
            handleActionEvent(changeAbstractAction, modelElement, "change abstract");
        }
    }

    /**
     * <p>
     * Changes final for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param isFinal
     *            the new final value
     */
    private void changeFinal(ModelElement modelElement, PropertyOperation operation, boolean isFinal) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeFinalAction changeFinalAction = new ChangeFinalAction(modelElement, isFinal);
            handleActionEvent(changeFinalAction, modelElement, "change final");
        }
    }

    /**
     * <p>
     * Changes root for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param isRoot
     *            the new root value
     */
    private void changeRoot(ModelElement modelElement, PropertyOperation operation, boolean isRoot) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeRootAction changeRootAction = new ChangeRootAction(modelElement, isRoot);
            handleActionEvent(changeRootAction, modelElement, "change root");
        }
    }

    /**
     * <p>
     * Changes static for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param isStatic
     *            the new static value
     */
    private void changeStatic(ModelElement modelElement, PropertyOperation operation, boolean isStatic) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeStaticAction changeStaticAction = new ChangeStaticAction(modelElement, isStatic);
            handleActionEvent(changeStaticAction, modelElement, "change static");
        }
    }

    /**
     * <p>
     * Changes active for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param isActive
     *            the new active value
     */
    private void changeActive(ModelElement modelElement, PropertyOperation operation, boolean isActive) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeActiveAction changeActiveAction = new ChangeActiveAction(modelElement, isActive);
            handleActionEvent(changeActiveAction, modelElement, "change active");
        }
    }

    /**
     * <p>
     * Changes transient for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param isTransient
     *            the new transient value
     */
    private void changeTransient(ModelElement modelElement, PropertyOperation operation, boolean isTransient) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeTransientAction changeTransientAction = new ChangeTransientAction(modelElement, isTransient);
            handleActionEvent(changeTransientAction, modelElement, "change transient");
        }
    }

    /**
     * <p>
     * Changes abstract for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param isNavigable
     *            the new navigable value
     */
    private void changeNavigable(ModelElement modelElement, PropertyOperation operation, boolean isNavigable) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeNavigableAction changeNavigableAction = new ChangeNavigableAction(modelElement, isNavigable);
            handleActionEvent(changeNavigableAction, modelElement, "change navigable");
        }
    }

    /**
     * <p>
     * Changes asynchronous for a model element.
     * </p>
     *
     * @param modelElement
     *            the model elementt whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     * @param isAsynchronous
     *            the new asynchronous value
     */
    private void changeAsynchronous(ModelElement modelElement, PropertyOperation operation, boolean isAsynchronous) {
        if (operation == PropertyOperation.MODIFY) {
            ChangeAsynchronousAction changeAsynchronousAction =
                new ChangeAsynchronousAction(modelElement, isAsynchronous);
            handleActionEvent(changeAsynchronousAction, modelElement, "change Asynchronous");
        }
    }

    /**
     * <p>
     * Changes operation for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     */
    private void changeOperation(ModelElement modelElement, PropertyOperation operation) {
        if (operation == PropertyOperation.ADD) {
            ClassNode classNode = (ClassNode) DeployHelper.getComponent(modelElement, mainFrame).get(0);
            classNode.getGraphNode().getContaineds().get(OPERATION_INDEX).setVisible(true);
            OperationAddAction operationAddAction = new OperationAddAction(mainFrame);
            operationAddAction.setClassNode(classNode);
            operationAddAction.actionPerformed(null);
        }
        selectNewFeature((Classifier) modelElement);
    }

    /**
     * <p>
     * Changes attribute for a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose properties were asked to be modified
     * @param operation
     *            the kind of operation to be done on the property
     */
    private void changeAttribute(ModelElement modelElement, PropertyOperation operation) {
        if (operation == PropertyOperation.ADD) {
            ClassNode classNode = (ClassNode) DeployHelper.getComponent(modelElement, mainFrame).get(0);
            classNode.getGraphNode().getContaineds().get(ATTRIBUTE_INDEX).setVisible(true);
            AttributeAddAction attributeAddAction = new AttributeAddAction(mainFrame);
            attributeAddAction.setClassNode(classNode);
            attributeAddAction.actionPerformed(null);
        }
        selectNewFeature((Classifier) modelElement);
    }

    /**
     * <p>
     * Selects the new feature.
     * </p>
     *
     * @param classifier
     *            the classifier
     */
    private void selectNewFeature(Classifier classifier) {
        int featureNum = classifier.countFeatures();
        mainFrame.getPropertiesPanel().fireSelectionChangeEvent(classifier.getFeatures().get(featureNum - 1));
    }

    /**
     * <p>
     * Handles action event.
     * </p>
     *
     * @param action
     *            the UndoableAbstractAction
     * @param modelElement
     *            the model element
     * @param string
     *            the message about the action
     */
    private void handleActionEvent(UndoableAbstractAction action, ModelElement modelElement, String string) {
        if (modelElement instanceof Parameter) {
            modelElement = ((Parameter) modelElement).getBehavioralFeature();
        }
        if (modelElement instanceof AssociationEnd) {
            modelElement = ((AssociationEnd) modelElement).getAssociation();
        }
        List<JComponent> jComponents = DeployHelper.getComponent(modelElement, mainFrame);
        if (jComponents.size() == 0) {
            if (modelElement instanceof Collaboration || modelElement instanceof ActivityGraph) {
                try {
                    action.execute();
                } catch (ActionExecutionException e) {
                    DeployHelper.handleException(mainFrame, e, string + "failed");
                }
                if (action instanceof ChangeEntityNameAction) {
                    updateName(modelElement);
                }
            }
            PropertiesPanel panel = mainFrame.getPropertiesPanel();
            panel.configurePanel(panel.getConfiguredModelElements());
            mainFrame.handleActionEvent(action, jComponents, string);
        } else {
            if (jComponents.get(0) instanceof Node || jComponents.get(0) instanceof StereotypeTextField) {
                Node node = null;
                for (int i = 0; i < jComponents.size(); ++i) {
                    JComponent component = jComponents.get(i);
                    if (component instanceof Node) {
                        node = (Node) component;
                    } else {
                        node = (Node) ((StereotypeTextField) component).getParent().getParent();
                        jComponents.set(i, node);
                    }
                    if (component instanceof StereotypeTextField) {
                        StereotypeTextField field =
                            (StereotypeTextField) DeployHelper.getComponent(((StereotypeTextField) component)
                                .getGraphNode(), (ClassNode) node);
                        field.setOpaque(true);
                        field.repaint();
                    }
                }
                if (node != null) {
                    UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(node, string);
                    compositeAction.put(action, jComponents);
                    mainFrame.handleActionEvent(compositeAction, node, string);
                } else {
                    mainFrame.handleActionEvent(action, jComponents, string);
                }
            } else {
                mainFrame.handleActionEvent(action, jComponents, string);
            }
        }
    }

    /**
     * <p>
     * Updates the name of a model element.
     * </p>
     *
     * @param modelElement
     *            the model element whose name is to be changed
     */
    private void updateName(ModelElement modelElement) {
        for (DocumentTreeView documentTreeView : mainFrame.getDocumentTree().getCurrentPanel().getAllViews()) {
            for (DocumentTreeNode documentTreeNode : DeployHelper.getDocumentTreeNode(modelElement,
                documentTreeView)) {
                documentTreeView.updateTreeNode(documentTreeNode);
            }
        }
    }
}
