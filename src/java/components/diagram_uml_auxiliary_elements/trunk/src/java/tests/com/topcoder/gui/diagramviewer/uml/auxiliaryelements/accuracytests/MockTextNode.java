/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import java.awt.Dimension;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.IllegalGraphNodeException;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PropertyMapping;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.TextChangeEvent;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.TextNode;

/**
 * <p>
 * Accuracy test of <code>TextNode</code>.
 * </p>
 * 
 * @author Achilles_2005
 * @version 1.0
 */
public class MockTextNode extends TextNode {

    /**
     * constructor.
     */
	protected MockTextNode(GraphNode graphNode, PropertyMapping properties) throws IllegalGraphNodeException {
		super(graphNode, properties);
	}

    /**
     * return emtpy dimension.
     */
	@Override
	public Dimension getPreferredSize(String text) {
		return new Dimension();
	}

    /**
     * return null.
     */
	@Override
	public String getText() {
		return null;
	}

    /**
     * does nothing.
     */
	@Override
	public void notifyUpdate() throws IllegalGraphNodeException {
		// does nothing.
	}

    /**
     * public method used for test purpose.
     */
	public Dimension measureText(String text) {
		return super.measureText(text);
	}
	
    /**
     * public method used for test purpose.
     */
	public void fireTextChange(TextChangeEvent event) {
		super.fireTextChange(event);
	}
}
