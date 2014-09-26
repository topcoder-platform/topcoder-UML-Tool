/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */

package com.topcoder.uml.model.activitygraphs;

import com.topcoder.uml.model.statemachines.StateMachineImpl;

/**
 * <p>
 * This is a simple concrete implementation of ActivityGraph interface and
 * extends StateMachineImpl from the State Machines component. As such, all
 * methods in ActivityGraph and StateMachineImpl are supported.
 * </p>
 *
 * <p>
 * <b>Thread Safety: </b><br/>This class is not thread-safe because its
 * superclass implementation are not thread-safe. Thread safety will be
 * provided by the application using it if desired.
 * </p>
 *
 * @author dplass, TCSDEVELOPER
 * @version 1.0
 */
public class ActivityGraphImpl extends StateMachineImpl implements
        ActivityGraph {
    /**
     * <p>
     * Creates a new instance of <code>ActivityGraphImpl</code>.
     * </p>
     */
    public ActivityGraphImpl() {
    }
}
