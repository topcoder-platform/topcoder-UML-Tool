/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import junit.framework.TestCase;

import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;
/**
 * Test class for UseCaseRelationShipAbstracImpl.
 * @author radium
 * @version 1.0
 */
public class UseCaseRelationshipAbstractImplTestAccuracy extends TestCase {
	/**
	 * Inner class which extends UseCaseRelationShipAbstractImpl.
	 */
	class UseCaseRelationShipImpl extends UseCaseRelationshipAbstractImpl {
		/**
		 * Default constructor.
		 */
		public UseCaseRelationShipImpl() {
			super();
		}
		/**
		 * Construct this object with the given base and target use cases. Copy each
		 * parameter to the corresponding property. Note: null arguments are
		 * accepted here.
		 *
		 * @param base
		 *            the base UseCase in this relationship (i.e., the one that
		 *            includes the target, or the one that is extended by the
		 *            target)
		 * @param target
		 *            the "target" UseCase in this relationship (i.e., the one that
		 *            is being included by the base, or the one that extends the
		 *            base)
		 */
		public UseCaseRelationShipImpl(UseCase base, UseCase target) {
			super(base, target);
		}
		/**
		 * Set the value of the 'target' property to the given argument.
		 *
		 * @param target
		 *            the new value of the 'target' property. May be null.
		 */
		public void setTarget(UseCase target) {
			super.setTarget(target);
		}

		/**
		 * Retrieve the value of the 'target' property as set in the constructor or
		 * setTarget.
		 *
		 * @return the value of the 'target' property. May be null.
		 */
		public UseCase getTarget() {
			return super.getTarget();
		}
	}
	/**
	 * Sample UseCaseRelationShipImpl for testing.
	 */
	private UseCaseRelationShipImpl ucr;
	/**
	 * Sample UseCase base for testing.
	 */
	private UseCase base;
	/**
	 * Sample UseCase target for testing.
	 */
	private UseCase target;

	/**
	 * Setup the environment for testing.
	 */
	protected void setUp() throws Exception {
		base = new UseCaseImpl();
		target = new UseCaseImpl();
		ucr = new UseCaseRelationShipImpl();
	}

	/**
	 * Test method for 'com.topcoder.uml.model.usecases.UseCaseRelationshipAbstractImpl.UseCaseRelationshipAbstractImpl()'
	 */
	public void testUseCaseRelationshipAbstractImpl() {
		ucr = new UseCaseRelationShipImpl();
		assertNotNull("Should not be null.", ucr);
	}

	/**
	 * Test method for 'com.topcoder.uml.model.usecases.UseCaseRelationshipAbstractImpl.UseCaseRelationshipAbstractImpl(UseCase, UseCase)'
	 */
	public void testUseCaseRelationshipAbstractImplUseCaseUseCase() {
		ucr = new UseCaseRelationShipImpl(null, null);
		ucr = new UseCaseRelationShipImpl(base, target);
		assertEquals("Should be equal.", base, ucr.getBase());
		assertEquals("Should be equal.", target, ucr.getTarget());
	}

	/**
	 * Test method for 'com.topcoder.uml.model.usecases.UseCaseRelationshipAbstractImpl.setBase(UseCase)'
	 */
	public void testSetBase() {
		ucr.setBase(null);
		assertEquals("Should be equal.", null, ucr.getBase());

		ucr.setBase(base);
		assertEquals("Should be equal.", base, ucr.getBase());
	}

	/**
	 * Test method for 'com.topcoder.uml.model.usecases.UseCaseRelationshipAbstractImpl.setTarget(UseCase)'
	 */
	public void testSetTarget() {
		ucr.setTarget(null);
		assertEquals("Should be equal.", null, ucr.getTarget());

		ucr.setTarget(target);
		assertEquals("Should be equal.", target, ucr.getTarget());
	}

	/**
	 * Test method for 'com.topcoder.uml.model.usecases.UseCaseRelationshipAbstractImpl.getBase()'
	 */
	public void testGetBase() {
		ucr.setBase(null);
		assertEquals("Should be equal.", null, ucr.getBase());

		ucr.setBase(base);
		assertEquals("Should be equal.", base, ucr.getBase());
	}

	/**
	 * Test method for 'com.topcoder.uml.model.usecases.UseCaseRelationshipAbstractImpl.getTarget()'
	 */
	public void testGetTarget() {
		ucr.setTarget(null);
		assertEquals("Should be equal.", null, ucr.getTarget());

		ucr.setTarget(target);
		assertEquals("Should be equal.", target, ucr.getTarget());
	}

}
