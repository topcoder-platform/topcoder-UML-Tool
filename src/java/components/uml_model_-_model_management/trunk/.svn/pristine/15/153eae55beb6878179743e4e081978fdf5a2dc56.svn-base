/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement;

import com.topcoder.uml.model.core.Classifier;

/**
 * <p>
 * This interface extends Package and Classifier interfaces. The Classifier
 * interface comes form the Core Requirements component. A subsystem is a
 * grouping of model elements that represents a behavioral unit in a physical
 * system. A subsystem offers interfaces and has operations. In addition, the
 * model elements of a subsystem are partitioned into specification and
 * realization elements, where the former, together with the operations of the
 * subsystem, are realized by the latter. In the metamodel, Subsystem is a
 * subclass of both Package and Classifier. As such it may have a set of
 * Features, which are constrained to be Operations and Receptions, and
 * Associations.
 * </p>
 * <p>
 * <strong>Thread Safety</strong>
 * </p>
 * <p>
 * Implementations do not have to be thread-safe. In fact, method
 * synchronization is discouraged. Thread safety will be provided by the
 * application using these implementations.
 * </p>
 * @author argolite, vilain
 * @version 1.0
 */
public interface Subsystem extends Package, Classifier {
    /**
     * Gets the boolean instantiable field value.
     * @return instantiable field value
     */
    public boolean isInstantiable();

    /**
     * Sets the boolean instantiable field value.
     * @param instantiable instantiable field value
     */
    public void setInstantiable(boolean instantiable);
}