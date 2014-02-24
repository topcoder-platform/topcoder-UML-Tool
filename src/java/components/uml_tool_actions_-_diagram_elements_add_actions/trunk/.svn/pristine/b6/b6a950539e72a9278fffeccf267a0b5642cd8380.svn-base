/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.standardclassloader.StandardClassDataLoader;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * A mocked class for testing.
 * @author Chenhong
 * @version 1.0
 */
public class MyStandardClassDataLoader implements StandardClassDataLoader {
    /**
     * <p>
     * A mapping for storing the language to its namespace list.
     * </p>
     */
    private final Map<String, List<Namespace>> mapping = new HashMap<String, List<Namespace>>();

    /**
     * <p>
     * Implements the getNamesspaces() method.
     * </p>
     *
     * @param language the language
     * @return all the namespace instances for the language
     */
    public List<Namespace> getNamespaces(String language) {
        return mapping.get(language);
    }

    /**
     * <p>
     * Add a namespace instance for the given language.
     * </p>
     *
     * @param language the language
     * @param namespace the namespace
     *
     */
    public void addNamespace(String language, Namespace namespace) {
        List<Namespace> namespaces = null;

        if (mapping.containsKey(language)) {
            namespaces = mapping.get(language);
        } else {
            namespaces = new ArrayList<Namespace>();
            mapping.put(language, namespaces);
        }

        namespaces.add(namespace);
    }
}
