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
import com.topcoder.uml.model.core.Parameter;

/**
 * <p>
 * This class provides a GUI to display the owner link property.
 * </p>
 *
 * <p>
 * The GUI is a JPanel consisting of a JLabel "Owner" and a link
 * to the owner's ModelElement.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as its super class is not thread-safe.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
public class OwnerLinkPropertyPanel extends AbstractLinkPropertyPanel {

    /**
     * <p>
     * Creates a new OwnerLinkPropertyPanel.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @throws IllegalArgumentException if the given argument is null
     */
    public OwnerLinkPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.OWNER_LINK), propertiesPanel, "Owner");
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list
     * of configured ModelElement.
     * </p>
     *
     * <p>
     * If the owner link of all the configured ModelElement is the same, a link to the
     * properties of the owner link will be displayed, otherwise no link will be provided.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<ModelElement> owners = new HashSet<ModelElement>();

        // get all the owner model elements
        for (ModelElement element : getConfiguredModelElements()) {
            owners.add(((Parameter) element).getBehavioralFeature());
        }

        if (owners.size() == 1) {
            setLinkedModelElement(owners.iterator().next());
        } else {
            setLinkedModelElement(null);
        }
    }
}
