/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers;

import com.topcoder.xmi.reader.DefaultXMIHandler;
import com.topcoder.xmi.reader.XMIReader;

/**
 * <p>
 * This is the mock class of DefaultXMIHandler. No constructor can be accessed.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CanNotAccessedCtorHandler extends DefaultXMIHandler {
    /**
     * <p>
     * This constructor will never be used.
     * </p>
     */
    private CanNotAccessedCtorHandler() {
        // does nothing
    }

    /**
     * <p>
     * Constructs this handler with the given XMIReader.
     * </p>
     *
     * @param reader the XMIReader instance to attach to this handler
     */
    private CanNotAccessedCtorHandler(XMIReader reader) {
        // does nothing
    }
}
