/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

/**
 * <p>
 * This class is the base for all GraphicPrimitives and extends LeafElement. This specification defines the
 * Polyline and the Ellipse, but other custom classes can extend this class in an extra-package.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is abstract but has no abstract methods. This class is thread-safe
 * because it has no attributes, but subclasses extending this one are not required to be thread-safe.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public abstract class GraphicPrimitive extends LeafElement {

    /**
     * <p>
     * Creates an instance of GraphicPrimitive.
     * </p>
     */
    protected GraphicPrimitive() {
        super();
    }
}