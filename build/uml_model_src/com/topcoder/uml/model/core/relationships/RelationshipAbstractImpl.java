/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import com.topcoder.uml.model.core.ModelElementAbstractImpl;


/**
 * This abstract class represent an abstract implementation of the Relationship interface. A relationship is a
 * connection among model elements. It extends the abstract ModelElementAbstractImpl which has all the methods
 * from ModelElement implemented (no code is necessary in this class as everything is implemented in
 * ModelElementAbstractImpl abstract class). This class is abstract as it makes no sense for it to be concrete.
 * Concrete implementations are not required to be thread safe.
 *
 * @author DanLazar, fanse
 * @version 1.0
 */
public abstract class RelationshipAbstractImpl extends ModelElementAbstractImpl
    implements Relationship {
    /**
     * Empty constructor.
     */
    protected RelationshipAbstractImpl() {
    }
}
