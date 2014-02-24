/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model;

import com.topcoder.uml.model.core.ModelElement;


/**
 * <p>
 * This interface defines the method to transform the implementation UML2 model classes to
 * corresponding UML1.4(TCUML) model classes. And the TCUML classes must extend ModelElement
 * class. The implementation should ensure that the returned instance must be the same (same
 * reference). It recommends the implementation store the transformed instance as variable,
 * if the variable is already set, it will be returned immediately.
 * </p>
 *
 * @param <T> a type extends from ModelElement
 *
 * <p>
 * <strong>Thread safety:</strong>
 * The implementation is not required to be thread-safe.
 * </p>
 *
 * @author telly12, zhengjuyu
 * @version 1.0
 */
public interface ZUML2TCUMLTransformer<T extends ModelElement> {
    /**
     * <p>
     * Transform the implementation class(ZUML model class) instance to the TCUML model class instance.
     * The returned model instance is instance of subclass of ModelElement. The returned instance must
     * always the same for every call of this method. For example:
     * </p>
     * <p>T instance1 = this.toTCUMLElement();</p>
     * <p>T instance2 = this.toTCUMLElement();</p>
     * <p>instance1 == instance2 is true.</p>
     * <p></p>
     *
     * @return the transformed TCUML model instance
     */
    public T toTCUMLElement();
}
