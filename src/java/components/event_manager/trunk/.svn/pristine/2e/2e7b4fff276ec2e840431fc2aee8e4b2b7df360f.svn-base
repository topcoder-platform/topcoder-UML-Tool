/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager.accuracytests;

import com.topcoder.util.eventmanager.ActionEvent;
import com.topcoder.util.eventmanager.ActionEventValidator;
import com.topcoder.util.eventmanager.EventValidation;

/**
 * Dummy implementation of <code>ActionEventValidator</code>.
 *
 * @author daiwb
 * @version 1.0
 */
public class DummyActionEventValidator implements ActionEventValidator {

    /**
     * N/A.
     */
    private String name;

    /**
     * N/A.
     */
    private EventValidation result;

    /**
     * N/A.
     *
     * @param name
     *            N/A.
     * @param result
     *            N/A.
     */
    DummyActionEventValidator(String name, EventValidation result) {
        this.name = name;
        this.result = result;
    }

    /**
     * N/A.
     *
     * @param event
     *            N/A.
     * @return N/A.
     */
    public EventValidation validateEvent(ActionEvent event) {
        return result;
    }

    /**
     * N/A.
     *
     * @return N/A.
     */
    public String getName() {
        return name;
    }

}
