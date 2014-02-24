/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.failuretests;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * The mocked class for TransientAction interface. It is created only for testing.
 *
 * @author Chenhong
 * @version 1.0
 *
 */
public class MyTransientAction implements TransientAction {

	/**
	 * Defined a default constructor.
	 *
	 */
	public MyTransientAction() {
       // Empty.
	}

	/**
	 * Method execute.
	 *
	 * @throws ActionExecutionException if failed to execute.
	 */
	public void execute() throws ActionExecutionException {
		throw new ActionExecutionException("Failure");
	}
}
