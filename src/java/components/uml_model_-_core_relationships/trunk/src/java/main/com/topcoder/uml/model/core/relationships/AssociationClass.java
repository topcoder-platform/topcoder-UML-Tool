/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import com.topcoder.uml.model.core.classifiers.Class;


/**
 * This interface defines the contract for a association class. An association class is an association that is also a
 * class. It not only connects a set of classifiers but also defines a set of features that belong to the relationship
 * itself and not any of the classifiers. This interface extends Association and Class interfaces and add no other
 * methods. Implementations are not required to be thread safe.
 *
 * @author DanLazar, fanse
 * @version 1.0
 */
public interface AssociationClass extends Association, Class {
}
