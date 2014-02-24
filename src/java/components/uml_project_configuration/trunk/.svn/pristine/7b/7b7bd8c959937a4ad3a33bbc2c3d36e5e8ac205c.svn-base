/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.accuracytests.MockObjects;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.standardclassloader.StandardClassDataLoader;

/**
 * Mock implementation of StandardClassDataLoader used for testing.
 *
 * @author TheCois
 */
public class MockClassLoader implements StandardClassDataLoader {

    List<Namespace> list = new ArrayList<Namespace>();


    /**
     * Mock Stub for [Add a namespace.]
     *
     * @param language  not used
     * @param ns   a Namespace object
     */
    public void addNamespace(String language, Namespace ns)  {
        list.add(ns);
    }

    /**
     * Mock Stub for [Returns a list of namespaces.]
     *
     * @param language   language value
     * @return a single-element list with one namespace of name "newNamespace".
     * @throws IllegalArgumentException
     *             if the language is "exception".
     */
    public List<Namespace> getNamespace(String language) {
        if (language.equals("exception")) {
            throw new IllegalArgumentException();
        }
        return list;
    }

	public List<Namespace> getNamespaces(String arg0) {
		return list;
	}
}
