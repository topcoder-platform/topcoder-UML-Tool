/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader.accuracytests;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.DataType;
import com.topcoder.uml.model.core.classifiers.DataTypeImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.standardclassloader.LanguageClassDataLoader;

/**
 * <p>
 * Mock implementation of <code>{@link LanguageClassDataLoader}</code> interface.
 * </p>
 * <p>
 * Only for testing purpose.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class JavaLanguageClassDataLoader implements LanguageClassDataLoader {

    /**
     * <p>
     * Return a list of namespaces for the language this is representing.
     * </p>
     * <p>
     * Note, the return value is possible empty if no namespaces are stored. It should never return null, or throw an
     * exception.
     * </p>
     * @return a List of namespaces for the language this is representing
     */
    public List<Namespace> getNamespaces() {
        List<Namespace> list = new ArrayList<Namespace>();
        Package pack = new PackageImpl();
        pack.setName("java");
        list.add(pack);
        DataType dataType = new DataTypeImpl();
        dataType.setName("int");
        list.add(dataType);
        return list;
    }

}
