/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel;

import com.topcoder.gui.panels.properties.Util;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.Model;

/**
 * <p>
 * This class provides a representation for <code>Namespace</code> object in a <code>JComboBox</code>.
 * </p>
 *
 * <p>
 * The representation will display the namespace (e.g. com.topcoder.util) when used with <code>JComboBox</code>.
 * </p>
 *
 * <p>
 * Additionally it also stores the corresponding <code>Namespace</code> object for easy retrieval and usage.
 * </p>
 *
 * <p>
 * Thread-safety: this class is thread-safe since it is immutable.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 */
class NamespaceItem {
    /**
     * <p>
     * This is a text representation for the <code>Namespace</code> to be inserted in the <code>JComboBox</code>.
     * </p>
     *
     * <p>
     * Set in the constructor and will not be modified afterwards. Will never be null.
     * </p>
     */
    private final String presentationName;

    /**
     * <p>
     * The namespace object representing this namespace.
     * </p>
     *
     * <p>
     * Set in the constructor and will not be modified afterwards. Will not be null.
     * </p>
     */
    private final Namespace namespace;

    /**
     * <p>
     * Creates a new <code>NamespaceItem</code> with the given namespace.
     * </p>
     *
     * @param namespace the <code>Namespace</code> object corresponding to this namespace
     * @throws IllegalArgumentException if the namespace argument is null
     */
    NamespaceItem(Namespace namespace) {
        Util.checkNull(namespace, "namespace");

        this.namespace = namespace;
        this.presentationName = getNamespaceText(namespace);
    }

    /**
     * <p>Gets the namespace text for given namespace.</p>
     * @param namespace the namespace to get text
     * @return the text
     */
    private String getNamespaceText(Namespace namespace) {
        String text = namespace.getName();

        Namespace owner = namespace.getNamespace();
        while (owner != null && !(owner instanceof Model)) {
            text = owner.getName() + "." + text;
            owner = owner.getNamespace();
        }

        return text;
    }

    /**
     * <p>
     * Retrieves the <code>Namespace</code> object corresponding to this instance.
     * </p>
     *
     * @return the <code>Namespace</code> object corresponding to this instance
     */
    Namespace getNamespace() {
        return namespace;
    }

    /**
     * <p>
     * Retrieves the <code>String</code> representation of the stored namespace.
     * </p>
     *
     * @return the <code>String</code> representation of the stored namespace
     */
    public String toString() {
        return presentationName;
    }
}