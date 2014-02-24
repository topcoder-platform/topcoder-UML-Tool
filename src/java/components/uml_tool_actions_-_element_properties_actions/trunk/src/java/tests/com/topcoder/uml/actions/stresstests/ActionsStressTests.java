/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.stresstests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
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
import com.topcoder.uml.model.core.classifiers.DataTypeImpl;
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
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <p>
 * The stress test of element properties actions component.
 * </P>
 *
 * @author biotrail
 * @version 1.0
 */
public class ActionsStressTests extends TestCase {

    /**
     * <p>
     * This constant represents the current time used for testing.
     * </p>
     */
    private static long current = -1;

    /**
     * <p>
     * This constant represents the test count used for testing.
     * </p>
     */
    private static final int NUMBER = 2000;

    /**
     * <p>
     * ModelElement instance for helping testing.
     * </p>
     */
    private ModelElement modelElement;

    /**
     * <p>
     * GraphElement instance for helping testing.
     * </p>
     */
    private GraphElement graphelement;

    /**
     * <p>
     * Classifier instance for helping testing.
     * </p>
     */
    private Classifier classifier;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        classifier = new ClassImpl();
        graphelement = new GraphNode();
        modelElement = new DataTypeImpl();
        StressTestHelper.loadSingleXMLConfig(StressTestHelper.LOG_NAMESPACE, StressTestHelper.LOG_CONFIGFILE);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        modelElement = null;
        graphelement = null;
        classifier = null;
        StressTestHelper.clearConfigFile(StressTestHelper.LOG_NAMESPACE);
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ActionsStressTests.class);
    }

    /**
     * <p>
     * Test of Method of ChangeDocumentationAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testChangeDocumentationAction() throws ActionExecutionException {
        //set up environment and create a new instance
        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType("documentation");
        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setType(tagDefinition);
        taggedValue.setDataValue("OldDocumentation");
        modelElement.addTaggedValue(taggedValue);

        UndoableAction action = new ChangeDocumentationAction(modelElement, "NewDocumentation");
        start();

        action.execute();
        assertEquals("Failed to change documentation.", "NewDocumentation", taggedValue.getDataValue());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", "OldDocumentation", taggedValue.getDataValue());

            action.redo();
            assertEquals("Failed to execute redo action.", "NewDocumentation", taggedValue.getDataValue());
        }

        printResult("ChangeDocumentationAction");

    }

    /**
     * <p>
     * Test of Method of ChangeEntityNameAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testChangeEntityNameAction() throws ActionExecutionException {
        //set up environment and create a new instance
        modelElement.setName("OldName");
        UndoableAction action = new ChangeEntityNameAction(modelElement, "NewName");
        start();

        action.execute();
        assertEquals("Failed to change name.", "NewName", modelElement.getName());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", "OldName", modelElement.getName());

            action.redo();
            assertEquals("Failed to execute redo action.", "NewName", modelElement.getName());
        }

        printResult("ChangeEntityNameAction");

    }

    /**
     * <p>
     * Test of Method of ChangeEntityVisibilityAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testChangeEntityVisibilityAction() throws ActionExecutionException {
        //set up environment and create a new instance
        modelElement.setVisibility(VisibilityKind.PUBLIC);
        UndoableAction action = new ChangeEntityVisibilityAction(modelElement, VisibilityKind.PRIVATE);
        start();

        action.execute();
        assertEquals("Failed to change entity visibility.", VisibilityKind.PRIVATE, modelElement.getVisibility());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", VisibilityKind.PUBLIC, modelElement.getVisibility());

            action.redo();
            assertEquals("Failed to execute redo action.", VisibilityKind.PRIVATE, modelElement.getVisibility());
        }

        printResult("ChangeEntityVisibilityAction");

    }

    /**
     * <p>
     * Test of Method of ChangePositionAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testChangePositionAction() throws ActionExecutionException {
        //set up environment and create a new instance
        Point oldPoint = new Point();
        oldPoint.setX(5.0);
        oldPoint.setY(5.0);
        graphelement.setPosition(oldPoint);
        Point newPoint = new Point();
        newPoint.setX(8.0);
        newPoint.setY(8.0);
        UndoableAction action = new ChangePositionAction(graphelement, newPoint);
        start();

        action.execute();
        assertEquals("Failed to change position.", newPoint, graphelement.getPosition());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", oldPoint, graphelement.getPosition());

            action.redo();
            assertEquals("Failed to execute redo action.", newPoint, graphelement.getPosition());
        }

        printResult("ChangePositionAction");

    }

    /**
     * <p>
     * Test of Method of ChangeRelationshipPathAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testChangeRelationshipPathAction() throws ActionExecutionException {
        //set up environment and create a new instance
        GraphEdge edge = new GraphEdge();
        List<Point> oldWaypoints = new ArrayList<Point>();
        List<Point> newWaypoints = new ArrayList<Point>();
        for (int i = 0; i < NUMBER; i++) {
            Point point = new Point();
            edge.addWaypoint(point);
            oldWaypoints.add(point);
            newWaypoints.add(new Point());
        }

        UndoableAction action = new ChangeRelationshipPathAction(edge, newWaypoints);
        start();

        action.execute();
        assertEquals("Failed to change relationship path.", newWaypoints, edge.getWaypoints());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", oldWaypoints, edge.getWaypoints());

            action.redo();
            assertEquals("Failed to execute redo action.", newWaypoints, edge.getWaypoints());
        }

        printResult("ChangeRelationshipPathAction");

    }

    /**
     * <p>
     * Test of Method of ChangeSizeAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testChangeSizeAction() throws ActionExecutionException {
        //set up environment and create a new instance
        Dimension oldSize = new Dimension();
        oldSize.setHeight(5.0);
        oldSize.setWidth(5.0);
        Dimension newSize = new Dimension();
        newSize.setHeight(8.0);
        newSize.setWidth(8.0);
        GraphNode node = new GraphNode();
        node.setSize(oldSize);

        UndoableAction action = new ChangeSizeAction(node, newSize);
        start();

        action.execute();
        assertEquals("Failed to change Size.", newSize, node.getSize());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", oldSize, node.getSize());

            action.redo();
            assertEquals("Failed to execute redo action.", newSize, node.getSize());
        }

        printResult("ChangeSizeAction");

    }

    /**
     * <p>
     * Test of Method of ChangeStyleAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testChangeStyleAction() throws ActionExecutionException {
        //set up environment and create a new instance
        Property property = new Property();
        property.setKey("Property");
        property.setValue("oldValue");
        DiagramElement diagram = new GraphEdge();
        diagram.addProperty(property);

        UndoableAction action = new ChangeStyleAction(diagram, "Property", "newValue");
        start();

        action.execute();
        assertEquals("Failed to change style.", "newValue", property.getValue());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", "oldValue", property.getValue());

            action.redo();
            assertEquals("Failed to execute redo action.", "newValue", property.getValue());
        }

        printResult("ChangeStyleAction");

    }

    /**
     * <p>
     * Test of Method of ChangeZOrderAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testChangeZOrderAction() throws ActionExecutionException {
        //set up environment and create a new instance
        int oldZOrder = 0;
        int newZOrder = 1;
        GraphElement subGraph = new GraphNode();
        graphelement.setContainer(subGraph);
        subGraph.addContained(graphelement);
        subGraph.addContained(new GraphNode());

        UndoableAction action = new ChangeZOrderAction(graphelement, ChangeZOrderOperationType.FORWARD);
        start();

        action.execute();
        assertEquals("Failed to change z-order.", newZOrder, graphelement.getContainer().getContaineds().indexOf(
            graphelement));

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", oldZOrder,
                graphelement.getContainer().getContaineds().indexOf(graphelement));

            action.redo();
            assertEquals("Failed to execute redo action.", newZOrder,
                graphelement.getContainer().getContaineds().indexOf(graphelement));
        }

        printResult("ChangeZOrderAction");

    }

    /**
     * <p>
     * Test of Method of SetEntityStereotypesAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testSetEntityStereotypesAction() throws ActionExecutionException {
        //set up environment and create a new instance
        Stereotype oldStereotype = new StereotypeImpl();
        Set<Stereotype> newStereotypes = new HashSet<Stereotype>();
        Stereotype newStereotype = new StereotypeImpl();
        newStereotypes.add(newStereotype);
        modelElement.addStereotype(oldStereotype);

        UndoableAction action = new SetEntityStereotypesAction(modelElement, newStereotypes,
            SetEntityStereotypesOperationType.UPDATE);
        start();

        action.execute();
        assertEquals("Failed to set entity stereotype.", newStereotype,
            modelElement.getStereotypes().iterator().next());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", oldStereotype,
                modelElement.getStereotypes().iterator().next());

            action.redo();
            assertEquals("Failed to execute redo action.", newStereotype,
                modelElement.getStereotypes().iterator().next());
        }

        printResult("SetEntityStereotypesAction");

    }

    /**
     * <p>
     * Test of Method of UpdateDocumentationTagsAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testUpdateDocumentationTagsAction() throws ActionExecutionException {
        //set up environment and create a new instance
        Map<TaggedValue, String> newDocumentations = new HashMap<TaggedValue, String>();
        TaggedValue newTaggedValue = new TaggedValueImpl();
        newDocumentations.put(newTaggedValue, "newValue");
        TaggedValue oldTaggedValue = new TaggedValueImpl();
        modelElement.addTaggedValue(oldTaggedValue);

        UndoableAction action = new UpdateDocumentationTagsAction(modelElement, newDocumentations,
            UpdateDocumentationTagsOperationType.ADD);
        start();

        action.execute();
        assertTrue("Failed to update documentation tags.", modelElement.getTaggedValues().contains(newTaggedValue));
        assertEquals("Expect only two element.", 2, modelElement.getTaggedValues().size());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", oldTaggedValue,
                modelElement.getTaggedValues().iterator().next());

            action.redo();
            assertTrue("Failed to execute redo action.", modelElement.getTaggedValues().contains(newTaggedValue));
            assertEquals("Expect only two element.", 2, modelElement.getTaggedValues().size());
        }

        printResult("UpdateDocumentationTagsAction");

    }

    /**
     * <p>
     * Test of Method of AddAttributeAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testAddAttributeAction() throws ActionExecutionException {
        //set up environment and create a new instance
        Attribute attribute = new AttributeImpl();

        UndoableAction action = new AddAttributeAction(classifier, attribute);
        start();

        action.execute();
        assertTrue("Failed to add attribute.", classifier.getFeatures().contains(attribute));

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertFalse("Failed to execute undo action.", classifier.getFeatures().contains(attribute));

            action.redo();
            assertTrue("Failed to execute redo action.", classifier.getFeatures().contains(attribute));
        }

        printResult("AddAttributeAction");

    }

    /**
     * <p>
     * Test of Method of AddOperationAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testAddOperationAction() throws ActionExecutionException {
        //set up environment and create a new instance
        Operation operation = new OperationImpl();

        UndoableAction action = new AddOperationAction(classifier, operation);
        start();

        action.execute();
        assertTrue("Failed to add operation.", classifier.getFeatures().contains(operation));

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertFalse("Failed to execute undo action.", classifier.getFeatures().contains(operation));

            action.redo();
            assertTrue("Failed to execute redo action.", classifier.getFeatures().contains(operation));
        }

        printResult("AddOperationAction");

    }

    /**
     * <p>
     * Test of Method of UpdateAttributeAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testUpdateAttributeAction() throws ActionExecutionException {
        //set up environment and create a new instance
        Attribute attribute = new AttributeImpl();
        attribute.setName("oldName");
        Classifier newClassifier = new ClassImpl();
        Expression newInitialValue = new ExpressionImpl();
        Multiplicity newMultiplicity = new MultiplicityImpl();
        boolean newIsTransient = true;

        UndoableAction action = new UpdateAttributeAction(attribute, VisibilityKind.PRIVATE, "newName", newClassifier,
            newInitialValue, ChangeableKind.CHANGEABLE, newMultiplicity, ScopeKind.INSTANCE, newIsTransient);
        start();

        action.execute();
        assertEquals("Failed to add operation.", "newName", attribute.getName());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", "oldName", attribute.getName());

            action.redo();
            assertEquals("Failed to execute redo action.", "newName", attribute.getName());
        }

        printResult("UpdateAttributeAction");

    }

    /**
     * <p>
     * Test of Method of UpdateAttributeOrderAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testUpdateAttributeOrderAction() throws ActionExecutionException {
        //set up environment and create a new instance
        Attribute attribute = new AttributeImpl();
        classifier.addFeature(new OperationImpl());
        classifier.addFeature(attribute);
        classifier.addFeature(new OperationImpl());
        classifier.addFeature(new AttributeImpl());

        UndoableAction action = new UpdateAttributeOrderAction(classifier, attribute, 1);
        start();

        action.execute();
        assertEquals("Failed to update attribute order.", 3, classifier.getFeatures().indexOf(attribute));

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", 1, classifier.getFeatures().indexOf(attribute));

            action.redo();
            assertEquals("Failed to execute redo action.", 3, classifier.getFeatures().indexOf(attribute));
        }

        printResult("UpdateAttributeOrderAction");

    }

    /**
     * <p>
     * Test of Method of UpdateOperationAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testUpdateOperationAction() throws ActionExecutionException {
        //set up environment and create a new instance
        Operation operation = new OperationImpl();
        Map<String, Classifier> newParameters = new HashMap<String, Classifier>();
        boolean newIsAbstract = true;
        operation.setName("oldName");

        UndoableAction action = new UpdateOperationAction(operation, VisibilityKind.PACKAGE, "newName", newParameters,
            classifier, CallConcurrencyKind.GUARDED, newIsAbstract, ScopeKind.CLASSIFIER);
        start();

        action.execute();
        assertEquals("Failed to update operation.", "newName", operation.getName());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", "oldName", operation.getName());

            action.redo();
            assertEquals("Failed to execute redo action.", "newName", operation.getName());
        }

        printResult("UpdateOperationAction");

    }

    /**
     * <p>
     * Test of Method of UpdateOperationOrderAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testUpdateOperationOrderAction() throws ActionExecutionException {
        //set up environment and create a new instance
        Operation operation = new OperationImpl();
        classifier.addFeature(new AttributeImpl());
        classifier.addFeature(operation);
        classifier.addFeature(new AttributeImpl());
        classifier.addFeature(new OperationImpl());

        UndoableAction action = new UpdateOperationOrderAction(classifier, operation, 1);
        start();

        action.execute();
        assertEquals("Failed to update operation order.", 3, classifier.getFeatures().indexOf(operation));

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", 1, classifier.getFeatures().indexOf(operation));

            action.redo();
            assertEquals("Failed to execute redo action.", 3, classifier.getFeatures().indexOf(operation));
        }

        printResult("UpdateOperationOrderAction");

    }

    /**
     * <p>
     * Test of Method of MarkClassifierAbstractAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testMarkClassifierAbstractAction() throws ActionExecutionException {
        //set up environment and create a new instance
        classifier.setAbstract(false);

        UndoableAction action = new MarkClassifierAbstractAction(classifier, true);
        start();

        action.execute();
        assertTrue("Failed to mark classifier abstract.", classifier.isAbstract());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertFalse("Failed to execute undo action.", classifier.isAbstract());

            action.redo();
            assertTrue("Failed to execute redo action.", classifier.isAbstract());
        }

        printResult("MarkClassifierAbstractAction");

    }

    /**
     * <p>
     * Test of Method of MarkClassifierFinalAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testMarkClassifierFinalAction() throws ActionExecutionException {
        //set up environment and create a new instance
        classifier.setLeaf(false);

        UndoableAction action = new MarkClassifierFinalAction(classifier, true);
        start();

        action.execute();
        assertTrue("Failed to mark classifier final.", classifier.isLeaf());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertFalse("Failed to execute undo action.", classifier.isLeaf());

            action.redo();
            assertTrue("Failed to execute redo action.", classifier.isLeaf());
        }

        printResult("MarkClassifierFinalAction");

    }

    /**
     * <p>
     * Test of Method of MarkNestedClassifierStaticAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testMarkNestedClassifierStaticAction() throws ActionExecutionException {
        //set up environment and create a new instance
        TaggedValue taggedValue = new TaggedValueImpl();
        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType("static");
        taggedValue.setType(tagDefinition);
        taggedValue.setDataValue(Boolean.toString(false));
        classifier.addTaggedValue(taggedValue);

        UndoableAction action = new MarkNestedClassifierStaticAction(classifier, true);
        start();

        action.execute();
        assertEquals("Failed to mark nested classifier static.", "true", taggedValue.getDataValue());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", "false", taggedValue.getDataValue());

            action.redo();
            assertEquals("Failed to execute redo action.", "true", taggedValue.getDataValue());
        }

        printResult("MarkNestedClassifierStaticAction");

    }

    /**
     * <p>
     * Test of Method of SetTransitionGuardAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testSetTransitionGuardAction() throws ActionExecutionException {
        //set up environment and create a new instance
        Transition transition = new TransitionImpl();
        Guard oldGuard = new GuardImpl();
        Guard newGuard = new GuardImpl();
        transition.setGuard(oldGuard);

        UndoableAction action = new SetTransitionGuardAction(transition, newGuard);
        start();

        action.execute();
        assertEquals("Failed to set transition guard.", newGuard, transition.getGuard());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", oldGuard, transition.getGuard());

            action.redo();
            assertEquals("Failed to execute redo action.", newGuard, transition.getGuard());
        }

        printResult("SetTransitionGuardAction");

    }

    /**
     * <p>
     * Test of Method of UpdateAssociationEndAction.
     * </p>
     *
     * @throws ActionExecutionException to JUnit.
     */
    public void testUpdateAssociationEndAction() throws ActionExecutionException {
        //set up environment and create a new instance
        AssociationEnd associationEnd = new AssociationEndImpl();
        associationEnd.setName("oldName");
        Multiplicity multiplicity = new MultiplicityImpl();

        UndoableAction action = new UpdateAssociationEndAction(associationEnd, VisibilityKind.PACKAGE, "newName",
            ChangeableKind.ADD_ONLY, multiplicity, OrderingKind.ORDERED, AggregationKind.AGGREGATE,
            ScopeKind.CLASSIFIER, true);
        start();

        action.execute();
        assertEquals("Failed to update association end.", "newName", associationEnd.getName());

        //Verify the method of undo and redo can work well
        for (int i = 0; i < NUMBER; i++) {
            action.undo();
            assertEquals("Failed to execute undo action.", "oldName", associationEnd.getName());

            action.redo();
            assertEquals("Failed to execute redo action.", "newName", associationEnd.getName());
        }

        printResult("UpdateAssociationEndAction");

    }

    /**
     * Start to count time.
     */
    private static void start() {
        current = System.currentTimeMillis();
    }

    /**
     * Print test result.
     *
     * @param name the test name
     */
    private static void printResult(String name) {
        System.out.println("The test " + name + " running " + NUMBER + " times, took time: "
            + (System.currentTimeMillis() - current) + " ms");
    }

}
