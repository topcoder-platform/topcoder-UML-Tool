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
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;

/**
 * <p>
 * This class provides a GUI to display the association link property.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> consisting of a <code>JLabel</code> <b>Association</b>
 * and a link to the association's <code>ModelElement</code>.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as its super class is not thread-safe.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
public class AssociationLinkPropertyPanel extends AbstractLinkPropertyPanel {
    /**
     * <p>
     * Creates a new <code>AssociationLinkPropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @throws IllegalArgumentException if the given argument is null
     */
    public AssociationLinkPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.ASSOCIATION_LINK), propertiesPanel, "Association");
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list
     * of configured ModelElement.
     * </p>
     *
     * <p>
     * If the association link of all the configured <code>ModelElement</code> is the same,
     * a link to the properties of the association link will be displayed, otherwise no link
     * will be provided.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        // get all the association model elements
        Set<Association> associations = new HashSet<Association>();
        for (ModelElement element : getConfiguredModelElements()) {
            associations.add(((AssociationEnd) element).getAssociation());
        }

        if (associations.size() == 1) {
            setLinkedModelElement(associations.iterator().next());
        } else {
            setLinkedModelElement(null);
        }
    }
}
