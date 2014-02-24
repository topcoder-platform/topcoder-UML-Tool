/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import com.topcoder.xmi.writer.XMITransformException;


/**
 * This exception is used to indicate some model element type is unknown by the tranformer.
 * <p>
 * This exception can be thrown from {@link Model2XMITransformer#transform(Object, java.io.PrintStream)}
 * method as kind of XMITranformException.
 * </p>
 * This class is immutable, thus it is thread-safe.
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class UnknownElementTypeException extends XMITransformException {
    /**
     * Represents the unknown element type.
     * <p>
     * It is intialized in the constructor and never changed later.
     * Maybe null. Because we don't want to validate arg in Exception constructor.
     * </p>
     *
     */
    private final Class elementType;

    /**
     * <p>Constructor with error message with the unknown elementType.</p>
     *
     * @param message the error message.
     * @param elementType the unknown elementType
     */
    public UnknownElementTypeException(String message, Class elementType) {
        super(message);
        this.elementType = elementType;
    }

    /**
     * Getter of elementType in this Exception, which is also the unknown type cause this Exception.
     *
     * @return this.elementType
     */
    public Class getElementType() {
        return elementType;
    }
}
