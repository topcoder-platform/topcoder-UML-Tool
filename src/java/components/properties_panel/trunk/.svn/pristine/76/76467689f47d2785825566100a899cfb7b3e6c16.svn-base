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
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.UseCase;

/**
 * <p>
 * This class provides a GUI to display the addition link property.
 * </p>
 *
 * <p>
 * The GUI is a JPanel consisting of a <code>JLabel</code> <b>Addition</b> and a link to the addition's
 * <code>ModelElement</code>.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as its super class is not thread-safe.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
public class AdditionLinkPropertyPanel extends AbstractLinkPropertyPanel {
    /**
     * <p>
     * Creates a new <code>AdditionLinkPropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @throws IllegalArgumentException if the given argument is null
     */
    public AdditionLinkPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.ADDITION_LINK), propertiesPanel, "Addition");
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list of configured
     * <code>ModelElement</code>.
     * </p>
     *
     * <p>
     * If the addition link of all the configured <code>ModelElement</code> is the same, a link to
     * the properties of the addition link will be displayed, otherwise no link will be provided.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<UseCase> additions = new HashSet<UseCase>();

        // get all the addition model elements
        for (ModelElement element : getConfiguredModelElements()) {
            additions.add(((Include) element).getAddition());
        }

        if (additions.size() == 1) {
            setLinkedModelElement(additions.iterator().next());
        } else {
            setLinkedModelElement(null);
        }
    }
}
