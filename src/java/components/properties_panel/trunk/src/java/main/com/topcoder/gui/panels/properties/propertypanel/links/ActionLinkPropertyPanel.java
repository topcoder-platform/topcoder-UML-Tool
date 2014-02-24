/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.propertypanel.links;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This class provides a GUI to display the action link property.
 * </p>
 *
 * <p>
 * The GUI is a <code>JPanel</code> consisting of a <code>JLabel</code> <b>Action</b> and
 * a link to the action's <code>ModelElement</code>.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as its super class is not thread-safe.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
public class ActionLinkPropertyPanel extends AbstractLinkPropertyPanel {
    /**
     * <p>
     * Creates a new <code>ActionLinkPropertyPanel</code>.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @throws IllegalArgumentException if the given argument is null
     */
    public ActionLinkPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.ACTION_LINK), propertiesPanel, "Action");
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list of configured
     * <code>ModelElement</code>.
     * </p>
     *
     * <p>
     * If the action link of all the configured <code>ModelElement</code> is the same, a link to the
     * properties of the action link will be displayed, otherwise no link will be provided.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<Action> actions = new HashSet<Action>();

        // get all the action model elements
        for (ModelElement element : getConfiguredModelElements()) {
            Procedure procedure = ((Stimulus) element).getDispatchAction();
            if (procedure == null) {
                actions.add(null);
            } else {
                actions.add(procedure.getAction());
            }
        }

        if (actions.size() == 1) {
            setLinkedModelElement(actions.iterator().next());
        } else {
            setLinkedModelElement(null);
        }
    }
}
