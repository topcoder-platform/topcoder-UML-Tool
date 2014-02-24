/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.failuretests;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.standardclassloader.StandardClassDataLoader;

/**
 * <p>
 * This class is the mock implementation of StandardClassDataLoader used for testing.
 * </p>
 *
 * @author stylecheck
 * @version 1.0
 */
public class MockStandardClassDataLoader implements StandardClassDataLoader {

    /**
     * <p>
     * Mock Stub.Returns a list of namespaces. Always returns one namespace with name "newNamespace";
     * </p>
     *
     * @param language
     *            language value
     * @return list of namespaces.
     * @throws IllegalArgumentException
     *             if the language is "exception". This is for simulation of exception.
     */
    public List<Namespace> getNamespaces(String language) {
        if (language.equals("exception")) {
            throw new IllegalArgumentException("Mock simulation");
        }
        List<Namespace> list = new ArrayList<Namespace>();
        Namespace namespace = new CollaborationImpl();
        namespace.setName("newNamespace");
        list.add(namespace);
        return list;
    }

}
