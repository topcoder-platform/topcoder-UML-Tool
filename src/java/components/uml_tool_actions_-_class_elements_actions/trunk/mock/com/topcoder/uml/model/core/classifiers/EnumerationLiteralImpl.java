/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.core.*;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class EnumerationLiteralImpl extends ModelElementAbstractImpl implements EnumerationLiteral {

    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    public EnumerationLiteralImpl() {
    }

    /**
     * <p>
     * Represents The enumeration classifier of which this enumeration literal
     * is an instance.
     * </p>
     */
    private com.topcoder.uml.model.core.classifiers.Enumeration enumeration;

    /**
     * Gets the Enumeration enumeration field value. Could be null.
     *
     * @return enumeration field value
     */
    public Enumeration getEnumeration() {
        return this.enumeration;
    }

    /**
     * Sets the Enumeration enumeration field value. Null is allowed.
     *
     * @poseidon-object-id [Im14fd930dm10e5f429af4m4ca1]
     * @param enumeration
     *            enumeration field value
     */
    public void setEnumeration(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    public int countBehaviors() {
        return 0;
    }
}