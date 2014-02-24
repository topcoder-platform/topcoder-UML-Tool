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
import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This class provides a GUI to display the stimulus link property.
 * </p>
 *
 * <p>
 * The GUI is a JPanel consisting of a JLabel "Stimulus" and a link
 * to the stimulus's ModelElement.
 * </p>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as its super class is not thread-safe.
 * </p>
 *
 * @author ch_music, TCSDEVELOPER
 * @version 1.0
 */
public class StimulusLinkPropertyPanel extends AbstractLinkPropertyPanel {

    /**
     * <p>
     * Creates a new StimulusLinkPropertyPanel.
     * </p>
     *
     * @param propertiesPanel the PropertiesPanel instance that owns this panel
     * @throws IllegalArgumentException if the given argument is null
     */
    public StimulusLinkPropertyPanel(PropertiesPanel propertiesPanel) {
        super(Collections.singletonList(PropertyKind.STIMULUS_LINK), propertiesPanel, "Stimulus");
    }

    /**
     * <p>
     * Refreshes the panel information to the most up-to-date information from the list
     * of configured ModelElement.
     * </p>
     *
     * <p>
     * If the stimulus link of all the configured ModelElement is the same, a link to the
     * properties of the stimulus link will be displayed, otherwise no link will be provided.
     * </p>
     */
    public void refreshPanel() {
        // only when the panel is visible then the panel information will be updated
        if (!isVisible()) {
            return;
        }

        Set<Stimulus> stimuluses = new HashSet<Stimulus>();

        // get all the stimulus model elements
        for (ModelElement element : getConfiguredModelElements()) {
            stimuluses.add(getStimulus((Action) element));
        }

        if (stimuluses.size() == 1) {
            setLinkedModelElement(stimuluses.iterator().next());
        } else {
            setLinkedModelElement(null);
        }
    }

    /**
     * <p>
     * Gets the stimulus from the given action instance.
     * </p>
     *
     * @param action the given action to be get.
     * @return the stimulus from the given action instance.
     */
    private Stimulus getStimulus(Action action) {
        Procedure procedure = action.getProcedure();
        if (procedure != null) {
            Collection<Stimulus> stimuli = procedure.getStimuli();
            if (stimuli.size() > 0) {
                return stimuli.iterator().next();
            }
        }

        return null;
    }
}
