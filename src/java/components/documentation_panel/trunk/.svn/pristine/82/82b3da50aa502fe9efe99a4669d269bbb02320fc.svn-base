/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.event;

import javax.swing.JOptionPane;

/**
 * <p>
 * Demo class which implements <code>DocumentationListener</code>.
 * Only used in demo.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class DemoDocumentationListener implements DocumentationListener {

    /**
     * <p>
     * Demo implementation of <code>documentationCreated()</code>.
     * </p>
     *
     * @param event <code>DocumentationEvent</code>
     */
    public void documentationCreated(DocumentationEvent event) {
        JOptionPane.showMessageDialog(null,
                "Current : " + event.getCurrentDocumentation(),
                "Document event : created", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * <p>
     * Demo implementation of <code>documentationDeleted()</code>.
     * </p>
     *
     * @param event <code>DocumentationEvent</code>
     */
    public void documentationDeleted(DocumentationEvent event) {
        JOptionPane.showMessageDialog(null,
                "Previous : " + event.getPreviousDocumentation(),
                "Document event : deleted", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * <p>
     * Demo implementation of <code>documentationUpdated()</code>.
     * </p>
     *
     * @param event <code>DocumentationEvent</code>
     */
    public void documentationUpdated(DocumentationEvent event) {
        JOptionPane.showMessageDialog(null,
                "Current : " + event.getCurrentDocumentation(),
                "Document event : updated", JOptionPane.INFORMATION_MESSAGE);
    }
}
