/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.stresstests;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * This is a simple implementation of interface <code>TransientAction</code>
 * used for stress test purpose.
 * @author fuyun
 * @version 1.0
 */
public class MyTransientAction implements TransientAction {

    /**
     * <p>
     * Simple implementation of method <code>execute()</code>.
     * </p>
     * <p>
     * It does nothing.
     * </p>
     * @throws ActionExecutionException if error happens.
     */
    public void execute() throws ActionExecutionException {
    }

}
