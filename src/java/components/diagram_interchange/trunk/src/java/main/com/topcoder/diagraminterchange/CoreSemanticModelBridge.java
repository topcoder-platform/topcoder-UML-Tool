/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

/**
 * <p>
 * CoreSemanticModelBridge is the semantic model used by elements that have a corresponding semantic model
 * element in UML 2.0. In this version of Diagram Interchange, this class is empty, but it is here to provide
 * future compatibility by implementing a class that extends this one in another package.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is thread-safe because it has no attributes, but subclasses extending
 * this one are not required to be thread-safe.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public class CoreSemanticModelBridge extends SemanticModelBridge {

    /**
     * <p>
     * Creates an instance of CoreSemanticModelBridge.
     * </p>
     */
    public CoreSemanticModelBridge() {
        super();
    }
}