/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;
/**
 * Test class for IncludeImpl.
 * @author radium
 * @version 1.0
 */
public class IncludeImplTestAccuracy extends TestCase {
	/**
	 * Sample IncludeImpl for testing.
	 */
	private IncludeImpl ii;
	/**
	 * Sample UseCase base for testing.
	 */
	private UseCase base;

	/**
	 * Sample UseCase addition for testing.
	 */
	private UseCase addition;
	/**
	 * Set up the environment for testing.
	 */
	protected void setUp() throws Exception {
		ii = new IncludeImpl();
		base = new UseCaseImpl();
		addition = new UseCaseImpl();
	}

	/**
	 * Test method for IncludeImpl().
	 */
	public void testIncludeImpl() {
		ii = new IncludeImpl();
		assertNotNull("Should not be null.", ii);
	}

	/**
	 * Test method for IncludeImpl(UseCase, UseCase).
	 */
	public void testIncludeImplUseCaseUseCase() {
		ii = new IncludeImpl(null, null);

		ii = new IncludeImpl(base, addition);
		assertEquals("Should be equal.", base, ii.getBase());
		assertEquals("Should be equal.", addition, ii.getAddition());
	}

	/**
	 * Test method for setAddition(UseCase).
	 */
	public void testSetAddition() {
		ii.setAddition(null);
		assertEquals("Should be equal.", null, ii.getAddition());

		ii.setAddition(addition);
		assertEquals("Should be equal.", addition, ii.getAddition());
	}

	/**
	 * Test method for IncludeImpl.getAddition().
	 */
	public void testGetAddition() {
		ii.setAddition(null);
		assertEquals("Should be equal.", null, ii.getAddition());

		ii.setAddition(addition);
		assertEquals("Should be equal.", addition, ii.getAddition());
	}

}
