/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.util.log.Level;
import com.topcoder.util.log.Log;

/**
 * <p>
 * This class implements the Log interface and used for testing only.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class MyLogger implements Log {
    /**
     * <p>
     * This List is used for storing the log messages in ERROR level.
     * </p>
     */
    private List<String> errorMsgs = new ArrayList<String>();

    /**
     * <p>
     * This List is used for storing the log messages in WARN level.
     * </p>
     */
    private List<String> warnMsgs = new ArrayList<String>();

    /**
     * <p>
     * This List is used for storing the log messages in INFO level.
     * </p>
     */
    private List<String> infoMsgs = new ArrayList<String>();

    /**
     * <p>
     * This List is used for storing the log messages in DEBUG level.
     * </p>
     */
    private List<String> debugMsgs = new ArrayList<String>();

    /**
     * <p>
     * Creates a MyLogger instance with logger name specified.
     * </p>
     *
     * @param name the logger name
     */
    public MyLogger(String name) {
        // empty
    }

    /**
     * <p>
     * This method implements the log() method defined in the Log interface.
     * </p>
     *
     * @param level the logging level
     * @param obj the object to be logged
     */
    public void log(Level level, Object obj) {
        if (level == Level.ERROR) {
            errorMsgs.add(obj.toString());
        } else if (level == Level.WARN) {
            warnMsgs.add(obj.toString());
        } else if (level == Level.INFO) {
            infoMsgs.add(obj.toString());
        } else if (level == Level.DEBUG) {
            debugMsgs.add(obj.toString());
        }
    }

    /**
     * <p>
     * This method implements the isEnabled() method defined in the Log interface.
     * </p>
     *
     * @param level the logging level
     * @return true
     */
    public boolean isEnabled(Level level) {
        return true;
    }

    /**
     * <p>
     * Returns all the messages logged in DEBUG level.
     * </p>
     *
     * @return all the messages logged in DEBUG level.
     */
    public List<String> getDebugMsgs() {
        return new ArrayList<String>(debugMsgs);
    }

    /**
     * <p>
     * Returns all the messages logged in ERROR level.
     * </p>
     *
     * @return all the messages logged in ERROR level.
     */
    public List<String> getErrorMsgs() {
        return new ArrayList<String>(errorMsgs);
    }

    /**
     * <p>
     * Returns all the messages logged in INFO level.
     * </p>
     *
     * @return all the messages logged in INFO level.
     */
    public List<String> getInfoMsgs() {
        return new ArrayList<String>(infoMsgs);
    }

    /**
     * <p>
     * Returns all the messages logged in WARN level.
     * </p>
     *
     * @return all the messages logged in WARN level.
     */
    public List<String> getWarnMsgs() {
        return new ArrayList<String>(warnMsgs);
    }

    /**
     * <p>
     * Clears all the logging messages.
     * </p>
     */
    public void clear() {
        debugMsgs.clear();
        errorMsgs.clear();
        infoMsgs.clear();
        warnMsgs.clear();
    }

    /**
     * <p>
     * Returns the logging messages in String representation.
     * </p>
     *
     * @return the logging messages in String representation.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Error Messages : \r\n");
        append(sb, errorMsgs);
        sb.append("Warn Messages : \r\n");
        append(sb, warnMsgs);
        sb.append("Info Messages : \r\n");
        append(sb, infoMsgs);
        sb.append("Debug Messages : \r\n");
        append(sb, debugMsgs);
        return sb.toString();
    }

    /**
     * <p>
     * Appends all the messages in the given msgs to the given StringBuffer instance.
     * </p>
     *
     * @param sb the StringBuffer to append the message in msgs
     * @param msgs the message list to be added to the given sb
     */
    private void append(StringBuffer sb, List<String> msgs) {
        if (msgs.isEmpty()) {
            sb.append("Empty. \r\n");
        } else {
            for (String str : msgs) {
                sb.append(str);
                sb.append("\r\n");
            }
        }
    }

}
