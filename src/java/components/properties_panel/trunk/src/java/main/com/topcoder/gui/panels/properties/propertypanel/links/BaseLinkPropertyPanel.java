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
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.UseCase;

/**
 * <p>
 * This class provides a GUI to display the base link property.
 * </p>
 *
 * <p>
 * The GUI is a JPanel consisting of a JLabel "Base" and a link to the base's ModelElement.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as its super class is not thread-safe.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
public class BaseLinkPropertyPanel extends AbstractLinkPropertyPanel {

    /**
     * <p>
     * Creates a new BaseLinkPropertyPanel.
     * </p>
     *
     * @param propertiespanel the PropertiesPanel instance that owns this panel
     * @throws IllegalArgumentException if the given argument is null
     */
    public BaseLinkPropertyPanel(PropertiesPanel propertiespanel) {
        super(Collections.singletonList(PropertyKind.BASE_LINK), propertiespanel, "Base");
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list
     * of configured ModelElement.
     * </p>
     *
     * <p>
     * If the base link of all the configured ModelElement is the same, a link to the
     * properties of the base link will be displayed, otherwise no link will be provided.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<UseCase> bases = new HashSet<UseCase>();

        // get all the base model elements
        for (ModelElement element : getConfiguredModelElements()) {
            if (element instanceof Include) {
                bases.add(((Include) element).getBase());
            } else {
                bases.add(((Extend) element).getBase());
            }

        }

        if (bases.size() == 1) {
            setLinkedModelElement(bases.iterator().next());
        } else {
            setLinkedModelElement(null);
        }
    }
}
