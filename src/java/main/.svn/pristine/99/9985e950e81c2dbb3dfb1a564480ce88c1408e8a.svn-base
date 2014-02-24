/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.CommentNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.FreeTextNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.TextChangeEvent;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.TextChangeListener;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.TextNode;
import com.topcoder.uml.actions.auxiliary.comment.model.ChangeCommentTextAction;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This implementation class listens to text change event of Auxiliary component's nodes.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class AuxiliaryTextChangedHandler implements TextChangeListener {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>AuxiliaryTextChangedHandler</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public AuxiliaryTextChangedHandler(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Performs the text changed event and set the new text to the node.
     * </p>
     * @param e
     *            the new value of the text compartment
     */
    public void textChanged(TextChangeEvent e) {
        if (e == null || e.getNewText().equals(e.getOldText())) {
            return;
        }
        TextNode node = (TextNode) e.getSource();
        if (node instanceof CommentNode) {
            Comment comment = (Comment) DeployHelper.getElement(node.getGraphNode());
            ChangeCommentTextAction action = new ChangeCommentTextAction(comment, e.getNewText());
            mainFrame.handleActionEvent(action, DeployHelper.getComponent(comment, mainFrame), "Comment text changed");
        } else if (node instanceof FreeTextNode) {
            TextElement textElement = (TextElement) node.getGraphNode().getContaineds().get(0);
            textElement.setText(e.getNewText());
            node.notifyUpdate();
        }
    }
}
