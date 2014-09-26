/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.core.ModelElement;


/**
 * <p>This interface extends ModelElement interface. The ModelElement interface comes form the
 * Core Requirements component. An EnumerationLiteral defines an element of the run-time extension o
 * f an Enumeration data type. It has no relevant substructure, that is, it is atomic. The
 * enumeration literals of a particular Enumeration datatype are ordered. It has a name
 * (inherited from ModelElement) that can be used to identify it within its enumeration dataype.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public interface EnumerationLiteral extends ModelElement {
    /**
     * Gets the enumeration field value. Could be null.
     *
     *
     * @return enumeration field value
     */
    Enumeration getEnumeration();

    /**
     * Sets the enumeration field value. Null is allowed.
     *
     *
     * @param enumeration enumeration field value
     */
    void setEnumeration(Enumeration enumeration);
}
