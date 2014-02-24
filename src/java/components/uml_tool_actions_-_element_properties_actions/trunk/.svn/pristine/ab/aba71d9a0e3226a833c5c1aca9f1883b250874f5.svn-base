/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.uml.actions.general.ChangeDocumentationAction;
import com.topcoder.uml.actions.general.ChangeEntityNameAction;
import com.topcoder.uml.actions.general.ChangeEntityVisibilityAction;
import com.topcoder.uml.actions.general.ChangePositionAction;
import com.topcoder.uml.actions.general.ChangeRelationshipPathAction;
import com.topcoder.uml.actions.general.ChangeSizeAction;
import com.topcoder.uml.actions.general.ChangeStyleAction;
import com.topcoder.uml.actions.general.ChangeZOrderAction;
import com.topcoder.uml.actions.general.SetEntityStereotypesAction;
import com.topcoder.uml.actions.general.UpdateDocumentationTagsAction;
import com.topcoder.uml.actions.general.operationtypes.ChangeZOrderOperationType;
import com.topcoder.uml.actions.general.operationtypes.SetEntityStereotypesOperationType;
import com.topcoder.uml.actions.general.operationtypes.UpdateDocumentationTagsOperationType;
import com.topcoder.uml.actions.model.classifiers.feature.AddAttributeAction;
import com.topcoder.uml.actions.model.classifiers.feature.AddOperationAction;
import com.topcoder.uml.actions.model.classifiers.feature.UpdateAttributeAction;
import com.topcoder.uml.actions.model.classifiers.feature.UpdateAttributeOrderAction;
import com.topcoder.uml.actions.model.classifiers.feature.UpdateOperationAction;
import com.topcoder.uml.actions.model.classifiers.feature.UpdateOperationOrderAction;
import com.topcoder.uml.actions.model.custom.MarkClassifierAbstractAction;
import com.topcoder.uml.actions.model.custom.MarkClassifierFinalAction;
import com.topcoder.uml.actions.model.custom.MarkNestedClassifierStaticAction;
import com.topcoder.uml.actions.model.custom.SetTransitionGuardAction;
import com.topcoder.uml.actions.model.custom.UpdateAssociationEndAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

import junit.framework.TestCase;

/**
 * <p>
 * The Element Properties Actions component provides general and specialized Actions related to the
 * model elements. The actions are strategy implementations of the action interfaces in the Action
 * Manager component. The provided actions are general actions that apply to any element, classifier
 * feature actions and a few custom actions. This design provides an UndoableAbstractAction to
 * provide general undoable functionalities. All the undoable actions are the subclasses of this
 * abstract class. And a log function for undoable actions is provided by this design.
 * </p>
 * <p>
 * This class provides the demo usage of this component.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class DemeUnitTests extends TestCase {

    /**
     * Represents the ModelElement used for demo.
     */
    private ModelElement element;

    /**
     * Represents the GraphNode used for demo.
     */
    private GraphNode node;

    /**
     * Represents the newSize used for demo.
     */
    private Dimension newSize;

    /**
     * Represents the newPosition used for demo.
     */
    private Point newPosition;

    /**
     * Represents the GraphEdge used for demo.
     */
    private GraphEdge edge;

    /**
     * Represents the diagram used for demo.
     */
    private DiagramElement diagram;

    /**
     * Represents the diagram used for demo.
     */
    private List<Point> newWaypoints;

    /**
     * Represents the newVisibility used for demo.
     */
    private VisibilityKind newVisibility;

    /**
     * Represents the new documentations used for demo.
     */
    private Map<TaggedValue, String> documentations;

    /**
     * Represents the stereotypes used for demo.
     */
    private Set<Stereotype> stereotypes;

    /**
     * Represents the Classifier used for demo.
     */
    private Classifier classifier;

    /**
     * Represents the Transition used for demo.
     */
    private Transition transition;

    /**
     * Represents the Guard used for demo.
     */
    private Guard newGuard;

    /**
     * Represents the Attribute used for demo.
     */
    private Attribute newAttribute;

    /**
     * Represents the Operation used for demo.
     */
    private Operation newOperation;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new AttributeImpl();
        node = new GraphNode();
        GraphElement tGraph = new GraphNode();
        node.setContainer(tGraph);
        tGraph.addContained(node);
        newSize = new Dimension();
        diagram = new GraphNode();
        newWaypoints = new ArrayList<Point>();
        newWaypoints.add(new Point());
        newVisibility = VisibilityKind.PACKAGE;
        documentations = new HashMap<TaggedValue, String>();
        stereotypes = new HashSet<Stereotype>();
        classifier = new ClassImpl();
        transition = new TransitionImpl();
        newGuard = new GuardImpl();
        newAttribute = new AttributeImpl();
        classifier.addFeature(newAttribute);
        newOperation = new OperationImpl();
        classifier.addFeature(newOperation);
        newPosition = new Point();
        edge = new GraphEdge();
    }

    /**
     * Simple Demo: Create Undoable Actions.
     */
    public void testCreateActions() {
        // If an action is triggered by the user of UML Model Tool, it will be created to be handled
        // add ChangeEntityNameAction to the actions queue, which will change the name of the
        // element to "New Name"
        UndoableAction action1 = new ChangeEntityNameAction(element, "New Name");

        // Create a ChangeSizeActionto, which will change the size of node to newSize
        UndoableAction action2 = new ChangeSizeAction(node, newSize);

        // Create a ChangePositionAction, which will change the position of element to newPosition
        UndoableAction action3 = new ChangePositionAction(node, newPosition);

        // Create a ChangeStyleAction, which will change the style of diagram which named the name
        // to newValue
        UndoableAction action4 = new ChangeStyleAction(diagram, "name", "newValue");

        // Create a ChangeDocumentationAction, which will change the documentation of
        // element to newDocumentation
        UndoableAction action5 = new ChangeDocumentationAction(element, "newDocumentation");

        // Create a ChangeRelationshipPathAction, which will change the relationship path of edge to
        // newWaypoints
        UndoableAction action6 = new ChangeRelationshipPathAction(edge, newWaypoints);

        // Create a ChangeEntityVisibilityAction, which will change the visibility of element to
        // newVisibility
        UndoableAction action7 = new ChangeEntityVisibilityAction(element, newVisibility);

        // Create a UpdateDocumentationTagsAction, which will modify the documentations
        // of element according to the operationType.
        UndoableAction action8 = new UpdateDocumentationTagsAction(element, documentations,
                UpdateDocumentationTagsOperationType.UPDATE);

        // Create a SetEntityStereotypesAction, which will modify the stereotypes
        // of element according to the operationType.
        UndoableAction action9 = new SetEntityStereotypesAction(element, stereotypes,
                SetEntityStereotypesOperationType.UPDATE);

        // Create a ChangeZOrderAction, which will change z-order of element according to the
        // operationType.
        UndoableAction action10 = new ChangeZOrderAction(node, ChangeZOrderOperationType.FORWARD);

        // Create a ChangeZOrderAction, which will change abstract property of classifier according
        // to true.
        UndoableAction action11 = new MarkClassifierAbstractAction(classifier, true);

        // Create a MarkClassifierFinalAction, which will change final property of classifier
        // according to isLeaf.
        boolean isLeaf = true;
        UndoableAction action12 = new MarkClassifierFinalAction(classifier, isLeaf);

        // Create a SetTransitionGuardAction, which will set the guard of transition to newGuard.
        UndoableAction action13 = new SetTransitionGuardAction(transition, newGuard);

        // Create a MarkNestedClassifierStaticAction, which will set the guard of transition to
        // newGuard.
        boolean isStatic = false;
        UndoableAction action14 = new MarkNestedClassifierStaticAction(classifier, isStatic);

        // Create a UpdateAssociationEndAction, which will update the properties
        // of associationEnd according the given arguments.
        AssociationEnd associationEnd = new AssociationEndImpl();

        String newName = "newName";
        ChangeableKind newChangeability = ChangeableKind.FROZEN;
        Multiplicity newMultiplicity = new MultiplicityImpl();
        OrderingKind newOrdering = OrderingKind.UNORDERED;
        ScopeKind newTargetKind = ScopeKind.INSTANCE;
        AggregationKind newAggregationKind = AggregationKind.COMPOSITE;
        boolean newNavigable = true;
        UndoableAction action15 = new UpdateAssociationEndAction(associationEnd, newVisibility, newName,
                newChangeability, newMultiplicity, newOrdering, newAggregationKind, newTargetKind, newNavigable);

        // Create a AddAttributeAction, which will add newAttribute to the classifier.
        UndoableAction action16 = new AddAttributeAction(classifier, newAttribute);

        // Create a UpdateAttributeOrderAction, which will change the order of attribute
        // to position 0 in the attributes of classifier .
        UndoableAction action17 = new UpdateAttributeOrderAction(classifier, newAttribute, 0);

        // Create a AddAttributeAction, which will add newOperation to the classifier.
        UndoableAction action18 = new AddOperationAction(classifier, newOperation);

        // Create a UpdateOperationOrderAction, which will change the order
        // of operation to position 0 in the operations of classifier .
        UndoableAction action19 = new UpdateOperationOrderAction(classifier, newOperation, 0);

        // Create a UpdateAttributeAction, which will update the properties of attribute according
        // the given arguments.
        Expression newInitialValue = new ExpressionImpl();
        Classifier newType = new InterfaceImpl();
        ScopeKind newOwnerKind = ScopeKind.CLASSIFIER;
        boolean newIsTransient = false;
        UndoableAction action20 = new UpdateAttributeAction(newAttribute, newVisibility, newName, newType,
                newInitialValue, newChangeability, newMultiplicity, newOwnerKind, newIsTransient);

        // Create a UpdateAttributeAction, which will update the properties of operation according
        // the given arguments.
        CallConcurrencyKind newConcurrency = CallConcurrencyKind.GUARDED;
        boolean isAbstract = true;
        Classifier newReturnType = new InterfaceImpl();
        HashMap<String, Classifier> newParameters = new HashMap<String, Classifier>();
        UndoableAction action21 = new UpdateOperationAction(newOperation, newVisibility, newName, newParameters,
                newReturnType, newConcurrency, isAbstract, newOwnerKind);
    }

    /**
     * <p>Simple Demo: Create Undoable Actions. The log should be:</p>
     * <pre>
     * Change entity name to New Name Undo Change entity name to New Name Redo
     * Change entity name to New Name Can't Redo Change entity name to New Name, current state is
     * UNDOABLE.
     * </pre>
     */
    public void testHandleAction() {
        // If an action is triggered by the user of UML Model Tool, it will be created to be handled
        // add ChangeEntityNameAction to the actions queue, which will change the name of the
        // element to "New Name"
        UndoableAction action = new ChangeEntityNameAction(element, "New Name");
        // If execute an action is triggered by the user of UML Model Tool, it will be executed
        // after created. Execute the action
        try {
            action.execute();
        } catch (ActionExecutionException e) {
            // ...
        }
        // If undo an action is triggered by the user of UML Model Tool, it will be undone
        action.undo();
        // If redo an action is triggered by the user of UML Model Tool, it will be redone
        action.redo();
        // If redo an action when it is already redone, it is invalid
        action.redo();
    }
}
