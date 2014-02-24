/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.stresstests;

import java.util.List;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.standardclassloader.StandardClassDataLoader;

/**
 * <p>
 * This is a mock implementation of StandardClassDataLoader interface.
 * It is only used for stress testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockStandardClassDataLoader implements StandardClassDataLoader {

    /**
     * Implements the getNamesspaces() method.
     *
     * @param language the language
     * @return all the namespace instances for the language
     */
    public List<Namespace> getNamespaces(String language) {
        return null;
    }
}
