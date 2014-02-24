/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;
import com.topcoder.xmi.writer.XMITransformException;

/**
 * <p>
 * This exception is used to indicate some model element is logically contained more than once.
 * Actually we just consider the elements that are not the reference, reference are allowed to be
 * contained more than once in the component.
 * </p>
 *
 * <p>
 * This exception can be thrown from {@link Model2XMITransformer#transform(Object, java.io.PrintStream)}
 * method as kind of XMITranformException.
 * </p>
 *
 * <p>
 * This class is immutable, thus it is thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class DuplicateElementException extends XMITransformException {

    /**
     * Represents the element that is duplicated.
     * It means that the element is logically contained by more than one element.
     * <p>
     * It is intialized in the constructor and never changed later.
     * Maybe null. Because we don't want to validate arg in Exception constructor.
     * </p>
     *
     */
    private final Object element;

    /**
     * <p>Constructor, simply call super(message), and then assign the element to this.element. </p>
     *
     * @param message the error message.
     * @param element the element Object that is duplicated
     */
    public  DuplicateElementException(String message, Object element) {
        super(message);
        this.element = element;
    }

    /**
     * Getter the duplicated element which causes this Exception.
     *
     * @return the element the duplicated element
     */
    public Object getElement() {
        return element;
    }
}
