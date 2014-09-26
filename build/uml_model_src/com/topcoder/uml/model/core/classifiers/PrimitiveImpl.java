/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;


/**
 * <p>This is a simple concrete implementation of Primitive interface and extends DataTypeImpl.
 * A Primitive defines a predefined DataType,
 * without any relevant UML substructure (i.e., it has no UML parts). A primitive datatype
 * may have an algebra and operations defined outside of UML, for example, mathematically.
 * Primitive datatypes used in UML itself include Integer, and String.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public class PrimitiveImpl extends DataTypeImpl implements Primitive {
    /**
     * <p>Empty constructor.</p>
     *
     */
    public PrimitiveImpl() {
        // empty
    }
}
