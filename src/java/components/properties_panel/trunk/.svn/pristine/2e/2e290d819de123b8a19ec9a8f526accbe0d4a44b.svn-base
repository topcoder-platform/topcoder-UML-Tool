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
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.UseCase;

/**
 * <p>
 * This class provides a GUI to display the extension link property.
 * </p>
 *
 * <p>
 * The GUI is a JPanel consisting of a JLabel "Extension" and a link
 * to the extension's ModelElement.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as its super class is not thread-safe.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
public class ExtensionLinkPropertyPanel extends AbstractLinkPropertyPanel {

    /**
     * <p>
     * Creates a new ExtensionLinkPropertyPanel.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @throws IllegalArgumentException if the given argument is null
     */
    public ExtensionLinkPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.EXTENSION_LINK), propertiesPanel, "Extension");
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list of
     * configured ModelElement.
     * </p>
     *
     * <p>
     * If the extension link of all the configured ModelElement is the same, a link to the
     * properties of the extension link will be displayed, otherwise no link will be provided.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<UseCase> extensions = new HashSet<UseCase>();

        // get all the extension model elements
        for (ModelElement element : getConfiguredModelElements()) {
            extensions.add(((Extend) element).getExtension());
        }

        if (extensions.size() == 1) {
            setLinkedModelElement(extensions.iterator().next());
        } else {
            setLinkedModelElement(null);
        }
    }
}
