/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

/**
 * This interface specifies the contract for implementation of an action event validator. It represents the validator
 * invoked by the manager in order to validate an action event.
 *
 * <p>
 * <b>Thread Safety:</b>
 * </p>
 *
 * <p>
 * The implementation of this interface is typically thread-safe.
 * </p>
 *
 * @author kinzz, TCSDEVELOPER
 * @version 1.0
 */
public interface ActionEventValidator {
    /**
     * <p>
     * This method will validate the given action event. It will return EventValidation.SUCCESSFULL if the validation
     * succeeded with no change, will return EventValidation.EVENT_MODIFIED if the validation succeeded, but the
     * action was modified and will return EventValidation.DENIED if the action is not valid.
     * </p>
     *
     * @param event the non null event to be validated
     *
     * @return the non null validation result
     *
     * @throws IllegalArgumentException if the event is null
     */
    public EventValidation validateEvent(ActionEvent event);
}
