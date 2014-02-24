/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence.accuracytests;

import com.topcoder.util.log.Level;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;

/**
 * <p>
 * Log implementation class used for accuracy testing.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class AccuracyLog implements Log {
    /**
     * Constant for the property name specifying the log target (can be either
     * System.out or System.err).
     */
    private static final String LOG_TARGET = "basic.log.target";

    /**
     * Constant for the System.out log target.
     */
    private static final String SYSTEM_OUT = "System.out";

    /**
     * Constant for the System.err log target.
     */
    private static final String SYSTEM_ERR = "System.err";

    /**
     * <p>
     * Constructor. This constructor is required for all Log implementations. No
     * exceptions are thrown from this constructor. This Basic console log
     * ignores the name parameter.
     * </p>
     * <p>
     * <b>Valid args:</b> any String instance, including null <br />
     * <b>Invalid args:</b> N/A <br />
     * </p>
     *
     * @param name the name of this instance
     */
    public AccuracyLog(String name) {
    }

    /**
     * <p>
     * This method calls the <tt>toString</tt> method on the <tt>message</tt>
     * argument and outputs its value to System.err. The level is ignored.
     * </p>
     * <p>
     * No exceptions are thrown from this method. If the message is null then
     * the method should simply return.
     * </p>
     * <p>
     * <b>Valid args:</b> any Level and Object instance, including nulls <br />
     * <b>Invalid args:</b> N/A <br />
     * </p>
     *
     * @param level ignored
     * @param message the message to log
     */
    public final void log(Level level, Object message) {

        String logTarget;
        try {
            logTarget = LogFactory.getAttribute(LOG_TARGET);
        } catch (Exception e) {
            logTarget = SYSTEM_ERR;
            e.printStackTrace();
        }

        if (SYSTEM_OUT.equals(logTarget)) {
            System.out.println("[" + level.toString() + "] - " + message.toString());
        } else { // output to System.err by default
            System.err.println("[" + level.toString() + "] - " + message.toString());
        }
    }

    /**
     * <p>
     * This method should return true, because levels are meaningless for the
     * basic logger.
     * </p>
     * <p>
     * No exceptions are thrown from this method. If the argument is null, false
     * should be returned, instead of true.
     * </p>
     * <p>
     * <b>Valid args:</b> any Level instance, including null <br />
     * <b>Invalid args:</b> N/A <br />
     * </p>
     *
     * @param level ignored
     * @return false if the argument is null, true otherwise
     */
    public boolean isEnabled(Level level) {
        if (level == null) {
            return false;
        }
        return true;
    }

}
