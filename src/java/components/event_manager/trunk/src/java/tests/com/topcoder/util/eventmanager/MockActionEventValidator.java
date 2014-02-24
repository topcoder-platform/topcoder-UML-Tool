/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

/**
 * <p>
 * The mock implementation of <code>ActionEventValidator</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockActionEventValidator implements ActionEventValidator {
    /** A name used to identify the instance. */
    private String name = null;

    /** Represents the validation result. */
    private EventValidation result = null;

    /**
     * Creates a new MockActionEventValidator object.
     *
     * @param name the name used to identify the instance
     * @param result the the validation result return by this instance
     */
    public MockActionEventValidator(String name, EventValidation result) {
        this.name = name;
        this.result = result;
    }

    /**
     * Always return the specified validation result set in the constructor.
     *
     * @param event the action event to be validated
     *
     * @return the validation result
     */
    public EventValidation validateEvent(ActionEvent event) {
        return result;
    }

    /**
     * Get the instance name.
     *
     * @return the name of the instance
     */
    public String getName() {
        return name;
    }
}
