/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */

package com.topcoder.uml.model.activitygraphs;

import com.topcoder.uml.model.statemachines.SimpleStateImpl;

/**
 * <p>
 * This is a simple concrete implementation of ActionState interface and extends
 * SimpleStateImpl from the State Machines component. As such, all methods in
 * ActionState and SimpleStateImpl are supported.
 * </p>
 *
 * <p>
 * <b>Thread Safety: </b><br/>This class is not thread-safe because its
 * superclass implementations are not thread-safe. Thread safety will be
 * provided by the application using it if desired.
 * </p>
 *
 * @author dplass, TCSDEVELOPER
 * @version 1.0
 */
public class ActionStateImpl extends SimpleStateImpl implements ActionState {
    /**
     * <p>
     * Creates a new instance of <code>ActionStateImpl</code>.
     * </p>
     */
    public ActionStateImpl() {
    }
}
