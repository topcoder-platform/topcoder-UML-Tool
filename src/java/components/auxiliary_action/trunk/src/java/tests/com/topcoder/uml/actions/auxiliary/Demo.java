/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.auxiliary.comment.diagram.AddCommentGraphNodeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.AddCommentRelationshipGraphEdgeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CopyCommentGraphNodeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CopyCommentRelationshipGraphEdgeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CutCommentGraphNodeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.CutCommentRelationshipGraphEdgeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.PasteCommentGraphNodeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.PasteCommentRelationshipGraphEdgeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.RemoveCommentGraphNodeAction;
import com.topcoder.uml.actions.auxiliary.comment.diagram.RemoveCommentRelationshipGraphEdgeAction;
import com.topcoder.uml.actions.auxiliary.comment.model.AddCommentAction;
import com.topcoder.uml.actions.auxiliary.comment.model.AddNoteRelationshipAction;
import com.topcoder.uml.actions.auxiliary.comment.model.ChangeCommentTextAction;
import com.topcoder.uml.actions.auxiliary.comment.model.CopyCommentAction;
import com.topcoder.uml.actions.auxiliary.comment.model.CopyNoteRelationshipAction;
import com.topcoder.uml.actions.auxiliary.comment.model.CutCommentAction;
import com.topcoder.uml.actions.auxiliary.comment.model.CutNoteRelationshipAction;
import com.topcoder.uml.actions.auxiliary.comment.model.PasteCommentAction;
import com.topcoder.uml.actions.auxiliary.comment.model.PasteNoteRelationshipAction;
import com.topcoder.uml.actions.auxiliary.comment.model.RemoveCommentAction;
import com.topcoder.uml.actions.auxiliary.comment.model.RemoveNoteRelationshipAction;
import com.topcoder.uml.actions.auxiliary.diagram.AddFreeTextAction;
import com.topcoder.uml.actions.auxiliary.diagram.AddPolylineAction;
import com.topcoder.uml.actions.auxiliary.diagram.CopyFreeTextAction;
import com.topcoder.uml.actions.auxiliary.diagram.CopyPolylineAction;
import com.topcoder.uml.actions.auxiliary.diagram.CutFreeTextAction;
import com.topcoder.uml.actions.auxiliary.diagram.CutPolylineAction;
import com.topcoder.uml.actions.auxiliary.diagram.PasteFreeTextAction;
import com.topcoder.uml.actions.auxiliary.diagram.PastePolylineAction;
import com.topcoder.uml.actions.auxiliary.diagram.RemoveFreeTextAction;
import com.topcoder.uml.actions.auxiliary.diagram.RemovePolylineAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * <p>
 * Demonstration of this component.
 * </p>
 *
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class Demo extends TestCase {

    /**
     * <p>
     * Set up environment.
     * </p>
     */
    public void setUp() {
        UnitTestHelper.loadConfig(UnitTestHelper.CONFIG_FILE);
    }

    /**
     * <p>
     * Clear the environment.
     * </p>
     */
    public void tearDown() {
        UnitTestHelper.clearConfig();
    }

    /**
     * <p>
     * Demonstration on <code>Comment</code> related actions.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testCommentRelatedActionsDemo() throws Exception {
        Comment comment = new CommentImpl();
        UMLModelManager manager = UMLModelManager.getInstance();
        manager.getModel().setNamespace(new PackageImpl());
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        manager.setProjectLanguage("Java");
        // Create an add action
        AddCommentAction action1 = new AddCommentAction(comment, manager);
        // execute the action to add the comment to the Model.
        action1.execute();
        // execute action to add the comment to the given namespace
        action1 = new AddCommentAction(comment, manager.getModel().getNamespace(), manager);
        action1.execute();
        // undo the action
        action1.undo();
        // redo the action
        action1.redo();

        // create a remove action
        RemoveCommentAction action2 = new RemoveCommentAction(comment);
        // execute the action to remove the comment from its namespace
        action2.execute();
        // undo the action
        action2.undo();
        // redo the action
        action2.redo();

        action2.undo();

        // create a copy action
        Clipboard clipboard = new Clipboard("Demo");
        CopyCommentAction action3 = new CopyCommentAction(comment, clipboard);
        // copy to the given clipboard
        action3.execute();
        // copy to system clipboard
        action3 = new CopyCommentAction(comment, null);
        action3.execute();

        // create a cut action
        CutCommentAction action4 = new CutCommentAction(comment, clipboard);

        // remove from its namespace and copy to the given clipboard
        action4.execute();
        // undo the action
        action4.undo();
        // redo the action
        action4.redo();

        // create a paste action
        PasteCommentAction action5 = new PasteCommentAction(comment, manager);
        // paste to the Model
        action5.execute();
        // paste to the given namespace
        action5 = new PasteCommentAction(comment, manager.getModel().getNamespace(), manager);
        action5.execute();
        // undo the action
        action5.undo();
        // redo the action
        action5.redo();
    }

    /**
     * <p>
     * Demonstration on <code>NoteRelationship</code> related actions.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testNoteRelationshipRelatedActionsDemo() throws Exception {
        Comment comment = new CommentImpl();
        ModelElement parent = new ModelElementAbstractImpl() {
        };
        UMLModelManager manager = UMLModelManager.getInstance();
        manager.getModel().setNamespace(new PackageImpl());
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        manager.setProjectLanguage("Java");

        // create an add action to add the note to the given modelElement
        AddNoteRelationshipAction action1 = new AddNoteRelationshipAction(comment, parent, manager);
        action1.execute();
        // undo the action
        action1.undo();
        // redo the action
        action1.redo();

        // create a remove action
        RemoveNoteRelationshipAction action2 = new RemoveNoteRelationshipAction(comment);
        // execute the action to remove the note from its annotated elements
        action2.execute();
        // undo the action
        action2.undo();
        // redo the action
        action2.redo();
        action2.undo();

        // create a copy action
        Clipboard clipboard = new Clipboard("Demo");
        CopyNoteRelationshipAction action3 = new CopyNoteRelationshipAction(comment, clipboard);
        // copy to the given clipboard
        action3.execute();
        // copy to system clipboard
        action3 = new CopyNoteRelationshipAction(comment, null);
        action3.execute();

        // create a cut action
        CutNoteRelationshipAction action4 = new CutNoteRelationshipAction(comment, clipboard);
        // remove from its annotated elements and copy to the given clipboard
        action4.execute();
        // undo the action
        action4.undo();
        // redo the action
        action4.redo();

        // create a paste action to add the note to the given modelElement
        PasteNoteRelationshipAction action5 = new PasteNoteRelationshipAction(comment, parent);
        action5.execute();
        // undo the action
        action5.undo();
        // redo the action
        action5.redo();
    }

    /**
     * <p>
     * Demonstration on <code>CommentGraphNode</code> related actions.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testCommentGraphNodeRelatedActionsDemo() throws Exception {
        GraphNode commentGraphNode = new GraphNode();
        Uml1SemanticModelBridge usmb = new Uml1SemanticModelBridge();
        usmb.setElement(new CommentImpl());
        commentGraphNode.setSemanticModel(usmb);
        Diagram diagram = new Diagram();
        UMLModelManager manager = UMLModelManager.getInstance();
        manager.getModel().setNamespace(new PackageImpl());
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        manager.setProjectLanguage("Java");

        // create an add action to add the node to the given diagram
        AddCommentGraphNodeAction action1 = new AddCommentGraphNodeAction(commentGraphNode, diagram, manager);
        action1.execute();
        // undo the action
        action1.undo();
        // redo the action
        action1.redo();

        // create a remove action
        RemoveCommentGraphNodeAction action2 = new RemoveCommentGraphNodeAction(commentGraphNode);
        // execute the action to remove the node from the diagram
        action2.execute();
        // undo the action
        action2.undo();
        // redo the action
        action2.redo();
        action2.undo();

        // create a copy action
        Clipboard clipboard = new Clipboard("Demo");
        CopyCommentGraphNodeAction action3 = new CopyCommentGraphNodeAction(commentGraphNode, clipboard);
        // copy to the given clipboard
        action3.execute();
        // copy to system clipboard
        action3 = new CopyCommentGraphNodeAction(commentGraphNode, null);
        action3.execute();

        // create a cut action
        CutCommentGraphNodeAction action4 = new CutCommentGraphNodeAction(commentGraphNode, clipboard);
        // remove from the diagram and copy to the given clipboard
        action4.execute();
        // undo the action
        action4.undo();
        // redo the action
        action4.redo();

        // create a paste action to add the node to the given diagram
        PasteCommentGraphNodeAction action5 = new PasteCommentGraphNodeAction(commentGraphNode, diagram);
        action5.execute();
        // undo the action
        action5.undo();
        // redo the action
        action5.redo();
    }

    /**
     * <p>
     * Demonstration on <code>CommentRelationshipGraphEdge</code> related
     * actions.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testCommentRelationshipGraphEdgeRelatedActionsDemo() throws Exception {
        GraphEdge commentGraphEdge = new GraphEdge();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("CommentLink");
        commentGraphEdge.setSemanticModel(ssme);
        Diagram diagram = new Diagram();
        UMLModelManager manager = UMLModelManager.getInstance();
        manager.getModel().setNamespace(new PackageImpl());
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        manager.setProjectLanguage("Java");
        // create an add action to add the edge to the given diagram
        AddCommentRelationshipGraphEdgeAction action1 = new AddCommentRelationshipGraphEdgeAction(commentGraphEdge,
                diagram, manager);
        action1.execute();
        // undo the action
        action1.undo();
        // redo the action
        action1.redo();

        // create a remove action
        RemoveCommentRelationshipGraphEdgeAction action2 = new RemoveCommentRelationshipGraphEdgeAction(
                commentGraphEdge);
        // execute the action to remove the edge from its diagram
        action2.execute();
        // undo the action
        action2.undo();
        // redo the action
        action2.redo();
        action2.undo();

        // create a copy action
        Clipboard clipboard = new Clipboard("Demo");
        CopyCommentRelationshipGraphEdgeAction action3 = new CopyCommentRelationshipGraphEdgeAction(commentGraphEdge,
                clipboard);
        // copy to the given clipboard
        action3.execute();
        // copy to system clipboard
        action3 = new CopyCommentRelationshipGraphEdgeAction(commentGraphEdge, null);
        action3.execute();

        // create a cut action
        CutCommentRelationshipGraphEdgeAction action4 = new CutCommentRelationshipGraphEdgeAction(commentGraphEdge,
                clipboard);
        // remove from its diagram and copy to the given clipboard
        action4.execute();
        // undo the action
        action4.undo();
        // redo the action
        action4.redo();

        // create a paste action to add the edge to the given diagram
        PasteCommentRelationshipGraphEdgeAction action5 = new PasteCommentRelationshipGraphEdgeAction(commentGraphEdge,
                diagram);
        action5.execute();
        // undo the action
        action5.undo();
        // redo the action
        action5.redo();
    }

    /**
     * <p>
     * Demonstration on <code>FreeTextGraphNode</code> related actions.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testFreeTextGraphNodeRelatedActionsDemo() throws Exception {
        GraphNode freeTextGraphNode = new GraphNode();
        SimpleSemanticModelElement ssme = new SimpleSemanticModelElement();
        ssme.setTypeInfo("FreeText");
        freeTextGraphNode.setSemanticModel(ssme);
        freeTextGraphNode.addContained(new TextElement());
        Diagram diagram = new Diagram();
        UMLModelManager manager = UMLModelManager.getInstance();
        manager.getModel().setNamespace(new PackageImpl());
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        manager.setProjectLanguage("Java");
        // create an add action to add the node to the given diagram
        AddFreeTextAction action1 = new AddFreeTextAction(freeTextGraphNode, diagram, manager);
        action1.execute();
        // undo the action
        action1.undo();
        // redo the action
        action1.redo();

        // create a remove action
        RemoveFreeTextAction action2 = new RemoveFreeTextAction(freeTextGraphNode);

        // execute the action to remove the node from its diagram
        action2.execute();
        // undo the action
        action2.undo();
        // redo the action
        action2.redo();
        action2.undo();

        // create a copy action
        Clipboard clipboard = new Clipboard("Demo");
        CopyFreeTextAction action3 = new CopyFreeTextAction(freeTextGraphNode, clipboard);
        // copy to the given clipboard
        action3.execute();
        // copy to system clipboard
        action3 = new CopyFreeTextAction(freeTextGraphNode, null);
        action3.execute();

        // create a cut action
        CutFreeTextAction action4 = new CutFreeTextAction(freeTextGraphNode, clipboard);
        // remove from its diagram and copy to the given clipboard
        action4.execute();
        // undo the action
        action4.undo();
        // redo the action
        action4.redo();

        // create a paste action to add the node to the given diagram
        PasteFreeTextAction action5 = new PasteFreeTextAction(freeTextGraphNode, diagram);
        action5.execute();
        // undo the action
        action5.undo();
        // redo the action
        action5.redo();
    }

    /**
     * <p>
     * Demonstration on <code>PolylineGraphNode</code> related actions.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testPolylineGraphNodeRelatedActionsDemo() throws Exception {
        GraphEdge polylineGraphEdge = new GraphEdge();
        polylineGraphEdge.addContained(new Polyline());
        Diagram diagram = new Diagram();
        UMLModelManager manager = UMLModelManager.getInstance();
        manager.getModel().setNamespace(new PackageImpl());
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        manager.setProjectLanguage("Java");
        // create an add action to add the edge to the given diagram
        AddPolylineAction action1 = new AddPolylineAction(polylineGraphEdge, diagram, manager);
        action1.execute();
        // undo the action
        action1.undo();
        // redo the action
        action1.redo();

        // create a remove action
        RemovePolylineAction action2 = new RemovePolylineAction(polylineGraphEdge);
        // execute the action to remove the edge from its diagram
        action2.execute();
        // undo the action
        action2.undo();
        // redo the action
        action2.redo();
        action2.undo();

        // create a copy action
        Clipboard clipboard = new Clipboard("Demo");
        CopyPolylineAction action3 = new CopyPolylineAction(polylineGraphEdge, clipboard);
        // copy to the given clipboard
        action3.execute();

        // copy to system clipboard
        action3 = new CopyPolylineAction(polylineGraphEdge, null);
        action3.execute();

        // create a cut action
        CutPolylineAction action4 = new CutPolylineAction(polylineGraphEdge, clipboard);
        // remove from its diagram and copy to the given clipboard
        action4.execute();
        // undo the action
        action4.undo();
        // redo the action
        action4.redo();

        // create a paste action to add the edge to the given diagram
        PastePolylineAction action5 = new PastePolylineAction(polylineGraphEdge, diagram);
        action5.execute();
        // undo the action
        action5.undo();
        // redo the action
        action5.redo();
    }

    /**
     * <p>
     * Demonstration on <code>ChangeCommentTextAction</code>.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testChangeCommentTextActionDemo() throws Exception {
        Comment comment = new CommentImpl();
        comment.setBody("Text");
        // create action to change comment¡¯s text
        ChangeCommentTextAction action = new ChangeCommentTextAction(comment, "new-text");
        action.execute();
        // undo to change the text back
        action.undo();
        // redo to make the change
        action.redo();
    }

    /**
     * <p>
     * Demonstration on how to select proper paste action by the application.
     * </p>
     *
     * @throws Exception
     *             to JUnit
     */
    public void testSelectProperPasteActionByApplicationDemo() throws Exception {
        // After the cut/copy action, when we click the paste button on the tool
        // bar,
        // the application should be able to select proper paste action to paste
        // the object correctly.
        UMLModelManager manager = UMLModelManager.getInstance();
        manager.getModel().setNamespace(new PackageImpl());
        manager.setProjectConfigurationManager(new ProjectConfigurationManager(manager));
        manager.setProjectLanguage("Java");
        Clipboard clipboard = new Clipboard("Demo");
        // Get the contents
        Transferable contents = clipboard.getContents(null);
        if (contents != null) {
            if (contents.isDataFlavorSupported(AuxiliaryElementDataFlavor.COMMENT)) {
                // get the pasted object
                Object data = contents.getTransferData(AuxiliaryElementDataFlavor.COMMENT);
                PasteCommentAction action1 = new PasteCommentAction(data, manager);

                // execute the action to add data into the Model
                action1.execute();
            } else if (contents.isDataFlavorSupported(AuxiliaryElementDataFlavor.NOTE_RELATIONSHIP)) {
                Object data = contents.getTransferData(AuxiliaryElementDataFlavor.NOTE_RELATIONSHIP);
                PasteNoteRelationshipAction action2 = new PasteNoteRelationshipAction(data,
                            new NamespaceAbstractImpl() {
                });
                action2.execute();

            } else if (contents.isDataFlavorSupported(AuxiliaryElementDataFlavor.COMMENT_GRAPH_NODE)) {
                Object data = contents.getTransferData(AuxiliaryElementDataFlavor.NOTE_RELATIONSHIP);
                PasteNoteRelationshipAction action2 = new PasteNoteRelationshipAction(data,
                            new NamespaceAbstractImpl() {
                });
                action2.execute();
            } else if (contents.isDataFlavorSupported(AuxiliaryElementDataFlavor.COMMENT_RELATIONSHIP_GRAPH_EDGE)) {
                Object data = contents.getTransferData(AuxiliaryElementDataFlavor.COMMENT_RELATIONSHIP_GRAPH_EDGE);
                PasteCommentRelationshipGraphEdgeAction action2 = new PasteCommentRelationshipGraphEdgeAction(data,
                        new Diagram());
                action2.execute();
            } else if (contents.isDataFlavorSupported(AuxiliaryElementDataFlavor.FREE_TEXT)) {
                Object data = contents.getTransferData(AuxiliaryElementDataFlavor.FREE_TEXT);
                PasteFreeTextAction action2 = new PasteFreeTextAction(data, new Diagram());
                action2.execute();
            } else if (contents.isDataFlavorSupported(AuxiliaryElementDataFlavor.POLYLINE)) {
                Object data = contents.getTransferData(AuxiliaryElementDataFlavor.POLYLINE);
                PastePolylineAction action2 = new PastePolylineAction(data, new Diagram());
                action2.execute();
            }
        }
    }

}
