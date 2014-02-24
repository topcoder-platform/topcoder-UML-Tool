/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.core.ModelElementAbstractImpl;


/**
 * <p>This is a simple concrete implementation of EnumerationLiteral interface and extends
 * ModelElementAbstractImpl from the Core Requirements component.
 * An EnumerationLiteral defines an element of the run-time extension of
 * an Enumeration data type. It has no relevant substructure, that is, it is atomic. The
 * enumeration literals of a particular Enumeration datatype are ordered. It has a name
 * (inherited from ModelElement) that can be used to identify it within its enumeration dataype</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public class EnumerationLiteralImpl extends ModelElementAbstractImpl implements EnumerationLiteral {
    /**
     * <p>Represents The enumeration classifier of which this enumeration literal is an instance.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private Enumeration enumeration;

    /**
     * <p>Empty constructor.</p>
     * <p>Initializes member variable as default value.</p>
     *
     */
    public EnumerationLiteralImpl() {
        // empty
    }

    /**
     * Gets the enumeration field value. Could be null.
     *
     *
     * @return enumeration field value
     */
    public Enumeration getEnumeration() {
        return enumeration;
    }

    /**
     * Sets the enumeration field value. Null is allowed.
     *
     *
     * @param enumeration enumeration field value
     */
    public void setEnumeration(Enumeration enumeration) {
        this.enumeration = enumeration;
    }
}
