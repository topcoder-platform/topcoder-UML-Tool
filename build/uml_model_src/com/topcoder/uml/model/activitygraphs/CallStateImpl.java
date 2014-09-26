/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */

package com.topcoder.uml.model.activitygraphs;

/**
 * <p>
 * This is a simple concrete implementation of CallState interface and extends
 * ActionStateImpl. As such, all methods in CallState and ActionStateImpl are
 * supported.
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
public class CallStateImpl extends ActionStateImpl implements CallState {
    /**
     * <p>
     * Creates a new instance of <code>CallStateImpl</code>.
     * </p>
     */
    public CallStateImpl() {
    }
}
