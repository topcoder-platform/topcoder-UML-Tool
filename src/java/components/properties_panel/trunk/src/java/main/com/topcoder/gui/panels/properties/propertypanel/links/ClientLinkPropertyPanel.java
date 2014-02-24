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
import com.topcoder.uml.model.core.dependencies.Dependency;

/**
 * <p>
 * This class provides a GUI to display the client link property.
 * </p>
 *
 * <p>
 * The GUI is a JPanel consisting of a JLabel "Client" and a link to the client's ModelElement.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as its super class is not thread-safe.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
public class ClientLinkPropertyPanel extends AbstractLinkPropertyPanel {

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list of
     * configured ModelElement.
     * </p>
     *
     * <p>
     * If the client link of all the configured ModelElement is the same, a link to the properties
     * of the client link will be displayed, otherwise no link will be provided.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @throws IllegalArgumentException if the given argument is null
     */
    public ClientLinkPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.CLIENT_LINK), propertiesPanel, "Client");
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list
     * of configured ModelElement.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<ModelElement> modelElements = new HashSet<ModelElement>();

        // get all the client model elements
        for (ModelElement element : getConfiguredModelElements()) {
            modelElements.addAll(((Dependency) element).getClients());
        }

        if (modelElements.size() == 1) {
            setLinkedModelElement(modelElements.iterator().next());
        } else {
            setLinkedModelElement(null);
        }
    }
}
