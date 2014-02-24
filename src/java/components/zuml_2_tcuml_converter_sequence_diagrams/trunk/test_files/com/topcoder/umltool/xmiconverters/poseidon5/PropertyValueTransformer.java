/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;


/**
 * <p>
 * This interface is used to transform the value of matched property. It defines two methods,
 * match and transform.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * The implementations are not required to be thread-safe.
 * </p>
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public interface PropertyValueTransformer {
    /**
     * <p>Transform the value of property to new value.</p>
     *
     *
     * @param value the old value of property
     * @return the new value of property
     */
    public String transform(String value);

    /**
     * <p>
     * Check whether the key of property is matched by this transformer.
     * Return true if matched, otherwise, return false.
     * </p>
     *
     *
     * @param key the key of property
     * @return whether the key of property is matched
     */
    public boolean match(String key);
}
