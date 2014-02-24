/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.gui.panels.properties.propertypanel.links;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;

/**
 * <p>
 * This class provides a GUI to display the namespace link property.
 * </p>
 *
 * <p>
 * The GUI is a JPanel consisting of a JLabel "Namespace" and a link
 * to the namespace's ModelElement.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as its super class is not thread-safe.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
public class NamespaceLinkPropertyPanel extends AbstractLinkPropertyPanel {

    /**
     * <p>
     * Creates a new NamespaceLinkPropertyPanel.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @throws IllegalArgumentException if the given argument is null
     */
    public NamespaceLinkPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.NAMESPACE_LINK), propertiesPanel, "Namespace");
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list
     * of configured ModelElement.
     * </p>
     *
     * <p>
     * If the namespace link of all the configured ModelElement is the same, a link to the
     * properties of the namespace link will be displayed, otherwise no link will be provided.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<Namespace> namespaces = new HashSet<Namespace>();

        // get all the namespace model elements
        for (ModelElement element : getConfiguredModelElements()) {
            namespaces.add(element.getNamespace());
        }

        if (namespaces.size() == 1) {
            setLinkedModelElement(namespaces.iterator().next());
        } else {
            setLinkedModelElement(null);
        }
    }
}
