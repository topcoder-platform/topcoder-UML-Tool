/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout;

/**
 * <p>
 * It is the listener to listen the <code>Section</code> instance to know when it is expanded or contracted.
 * </p>
 *
 * <p>
 * <strong>Thread-safe</strong>:
 * The implementation is not required to be thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public interface SectionExpandContractListener {

    /**
     * <p>
     * This method will be invoked when section is expanded.
     * </p>
     *
     * @param section
     *        the section associated with event
     */
    public void expanded(Section section);

    /**
     * <p>
     * This method will be invoked when section is contracted.
     * </p>
     *
     * @param section
     *        the section associated with event
     */
    public void contracted(Section section);
}
