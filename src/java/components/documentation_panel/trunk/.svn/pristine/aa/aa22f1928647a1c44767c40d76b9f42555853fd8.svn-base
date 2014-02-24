/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.event;

import javax.swing.JOptionPane;

/**
 * <p>
 * Demo class which implements <code>TagListener</code>.
 * Only used in demo.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class DemoTagListener implements TagListener {

    /**
     * <p>
     * Demo implementation of <code>tagCreated()</code>.
     * </p>
     *
     * @param event <code>TagEvent</code>
     */
    public void tagCreated(TagEvent event) {
        JOptionPane.showMessageDialog(null,
                event.getTagName() + " : " + event.getCurrentDocumentation(),
                "Tag event : created", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * <p>
     * Demo implementation of <code>tagDeleted()</code>.
     * </p>
     *
     * @param event <code>TagEvent</code>
     */
    public void tagDeleted(TagEvent event) {
        JOptionPane.showMessageDialog(null,
                event.getTagName() + " : " + event.getPreviousDocumentation(),
                "Tag event : deleted", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * <p>
     * Demo implementation of <code>tagUpdated()</code>.
     * </p>
     *
     * @param event <code>TagEvent</code>
     */
    public void tagUpdated(TagEvent event) {
        JOptionPane.showMessageDialog(null,
                event.getTagName() + " : " + event.getCurrentDocumentation(),
                "Tag event : updated", JOptionPane.INFORMATION_MESSAGE);
    }
}
