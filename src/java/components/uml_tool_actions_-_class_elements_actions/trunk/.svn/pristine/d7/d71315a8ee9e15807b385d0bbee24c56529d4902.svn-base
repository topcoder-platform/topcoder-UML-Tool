/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.ClassElementsTransfer;
import com.topcoder.uml.actions.model.classifiers.MockAbstractionUtil;
import com.topcoder.uml.actions.model.classifiers.MockCutAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;

/**
 * Accuracy tests for CutAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CutActionTest extends TestCase {
	/**
	 * Load logging configuration.
	 * 
	 * @throws Exception
	 *             Exception to JUnit.
	 */
	protected void setUp() throws Exception {
		TestUtil.loadConfiguration();

		modelElement = new AbstractionImpl();
		classToolUtil = new MockAbstractionUtil();
		clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	}

	/**
	 * Unload logging configuration.
	 * 
	 * @throws Exception
	 *             Exception to JUnit.
	 */
	protected void tearDown() throws Exception {
		Thread.sleep(100);
		TestUtil.unloadConfiguration();
	}

	/**
	 * ModelElement instance for test.
	 */
	private ModelElement modelElement;

	/**
	 * ClassToolUtil instance for test.
	 */
	private MockAbstractionUtil classToolUtil;

	/**
	 * Clipboard instance for test.
	 */
	private Clipboard clipboard;

	/**
	 * Test CutAction#CutAction(ModelElement, ClassToolUtil, Clipboard)
	 */
	public void testConstructor() {
		new MockCutAction(modelElement, classToolUtil, clipboard);
	}

	/**
	 * Test CutAction#execute() with non-null namespace.
	 * 
	 * @throws Exception
	 *             Exception to JUnit.
	 */
	public void testExecute() throws Exception {
		Namespace namespace = TestUtil.getInstance().getNamespace();

		namespace.addOwnedElement(modelElement);
		modelElement.setNamespace(namespace);

		MockCutAction cutAction = new MockCutAction(modelElement,
				classToolUtil, clipboard);
		cutAction.execute();

		assertNotNull("ModelElement should have been moved to Clipboard.",
				clipboard.getContents(new Object()).getTransferData(
						ClassElementsTransfer.ABSTRACTION_FLAVOR));

		assertFalse(
				"The modelElement should have been removed from its orginial namespace.",
				namespace.containsOwnedElement(modelElement));
	}

	/**
	 * Test CutAction#undo().
	 * 
	 * @throws Exception
	 *             Exception to JUnit.
	 */
	public void testUndo() throws Exception {
		Namespace namespace = TestUtil.getInstance().getNamespace();
		namespace.addOwnedElement(modelElement);
		modelElement.setNamespace(namespace);

		MockCutAction cutAction = new MockCutAction(modelElement,
				classToolUtil, clipboard);
		cutAction.execute();

		assertFalse(
				"ModelElement should have been removed from its orginial namespace.",
				namespace.containsOwnedElement(modelElement));

		cutAction.undo();
		assertTrue("ModelElement should have been restored to namespace.",
				namespace.containsOwnedElement(modelElement));
	}

	/**
	 * Test CutAction#redo().
	 * 
	 * @throws Exception
	 *             Exception to JUnit.
	 */
	public void testRedo() throws Exception {
		Namespace namespace = TestUtil.getInstance().getNamespace();
		namespace.addOwnedElement(modelElement);
		modelElement.setNamespace(namespace);

		MockCutAction cutAction = new MockCutAction(modelElement,
				classToolUtil, clipboard);

		cutAction.execute();
		cutAction.undo();
		assertTrue("ModelElement should have been restored to namespace.",
				namespace.containsOwnedElement(modelElement));

		cutAction.redo();
		assertFalse(
				"ModelElement should have been removed from its orginial namespace.",
				namespace.containsOwnedElement(modelElement));
	}
}