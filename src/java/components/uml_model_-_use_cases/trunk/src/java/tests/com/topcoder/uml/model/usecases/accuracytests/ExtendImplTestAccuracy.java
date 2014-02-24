/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;
import com.topcoder.uml.model.usecases.ExtendImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

/**
 * Test class for ExtendImpl Class.
 *
 * @author radium
 * @version 1.0
 */
public class ExtendImplTestAccuracy extends TestCase {
	/**
	 * Sample ExtendImpl for testing.
	 */
	private ExtendImpl exp;

	/**
	 * Sample UseCase base for testing.
	 */
	private UseCase base;

	/**
	 * Sample UseCase extension for testing.
	 */
	private UseCase extension;

	/**
	 * Setup the environment for testing.
	 */
	protected void setUp() throws Exception {
		exp = new ExtendImpl();
		base = new UseCaseImpl();
		extension = new UseCaseImpl();
	}

	/**
	 * Test method for ExtendImpl().
	 */
	public void testExtendImpl() {
		exp = new ExtendImpl();
		assertNotNull("Should not be null.", exp);
	}

	/**
	 * Test method for ExtendImpl(UseCase, UseCase).
	 */
	public void testExtendImplUseCaseUseCase() {
		exp = new ExtendImpl(null, null);
		exp = new ExtendImpl(base, extension);
		assertEquals("Should be equal.", base, exp.getBase());
		assertEquals("Should be equal.", extension, exp.getExtension());
	}

	/**
	 * Test method for setExtension(UseCase).
	 */
	public void testSetExtension() {
		exp.setExtension(null);
		assertEquals("Should be equal.", null, exp.getExtension());

		exp.setExtension(extension);
		assertEquals("Should be equal.", extension, exp.getExtension());
	}

	/**
	 * Test method for getExtension().
	 */
	public void testGetExtension() {
		exp.setExtension(null);
		assertEquals("Should be equal.", null, exp.getExtension());

		exp.setExtension(extension);
		assertEquals("Should be equal.", extension, exp.getExtension());
	}

	/**
	 * Test method for setCondition(BooleanExpression).
	 */
	public void testSetCondition() {
		BooleanExpression be = new MockBooleanExpressionAccuracy();

		exp.setCondition(null);
		assertEquals("Should be equal.", null, exp.getCondition());

		exp.setCondition(be);
		assertEquals("Should be equal.", be, exp.getCondition());
	}

	/**
	 * Test method for getCondition().
	 */
	public void testGetCondition() {
		BooleanExpression be = new MockBooleanExpressionAccuracy();

		exp.setCondition(null);
		assertEquals("Should be equal.", null, exp.getCondition());

		exp.setCondition(be);
		assertEquals("Should be equal.", be, exp.getCondition());
	}

}
