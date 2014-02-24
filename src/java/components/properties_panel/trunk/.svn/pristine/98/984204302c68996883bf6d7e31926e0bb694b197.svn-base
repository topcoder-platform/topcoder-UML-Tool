/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.gui.panels.properties.propertypanel.links;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.relationships.Generalization;

/**
 * <p>
 * This class provides a GUI to display the parent link property.
 * </p>
 *
 * <p>
 * The GUI is a JPanel consisting of a JLabel "Parent" and a link
 * to the parent's ModelElement.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as its super class is not thread-safe.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
public class ParentLinkPropertyPanel extends AbstractLinkPropertyPanel {

    /**
     * <p>
     * Creates a new ParentLinkPropertyPanel.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @throws IllegalArgumentException if the given argument is null
     */
    public ParentLinkPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.PARENT_LINK), propertiesPanel, "Parent");
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list
     * of configured ModelElement.
     * </p>
     *
     * <p>
     * If the parent link of all the configured ModelElement is the same, a link to the
     * properties of the parent link will be displayed, otherwise no link will be provided.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<ModelElement> parents = new HashSet<ModelElement>();

        // get all the parent model elements
        for (ModelElement element : getConfiguredModelElements()) {
            if (element instanceof Generalization) {
                parents.add(((Generalization) element).getParent());
            } else {
                Collection<ModelElement> suppliers = ((Abstraction) element).getSuppliers();
                parents.add(suppliers.size() == 0 ? null : suppliers.iterator().next());
            }
        }

        if (parents.size() == 1) {
            setLinkedModelElement(parents.iterator().next());
        } else {
            setLinkedModelElement(null);
        }
    }
}
