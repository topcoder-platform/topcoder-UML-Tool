/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import com.topcoder.gui.configurationmanager.ConfigurationManagerEditorPanel;
import com.topcoder.gui.configurationmanager.PropertyDefinition;
import com.topcoder.gui.configurationmanager.ValidationResultSet;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Action to change settings.
 * </p>
 *
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class SettingsAction extends AbstractAction {
    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = -2873752707169317598L;

    /**
     * <p>
     * Action name.
     * <p>
     */
    private static final String ACTION_NAME = "Settings";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Settings.";

    /**
     * <p>
     * Icon file name for menu.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/Settings_16.png";

    /**
     * <p>
     * Icon file for tool bar.
     * <p>
     */
    private static final String TOOLBAR_ICON_FILE_NAME = "/images/Settings_16.png";

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * The setting dialog.
     * </p>
     */
    private SettingDialog dialog;

    /**
     * <p>
     * Constructs an instance of change settings.
     * <p>
     *
     * @param mainFrame
     *            main frame of uml tool
     */
    public SettingsAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(SettingsAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(SettingsAction.class
            .getResource(TOOLBAR_ICON_FILE_NAME)));

        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Performing the action.
     * <p>
     *
     * @param actionEvent
     *            the action event
     */
    public void actionPerformed(ActionEvent actionEvent) {
        dialog = new SettingDialog();
        dialog.setModal(false);
        dialog.setLocationRelativeTo(mainFrame);
        dialog.setVisible(true);
    }

    /**
     * <p>
     * This class provides a modal <code>JDialog</code> to generate code.
     * </p>
     * <p>
     * The <code>JDialog</code> will provide a GUI for user to choose setting file .
     * </p>
     *
     * @author ly, FireIce, ylouis
     * @version 1.0
     */
    private class SettingDialog extends JDialog {

        /**
         * <p>
         * Creates a new generate code dialog.
         * </p>
         */
        public SettingDialog() {
            super(mainFrame, "Setting");
            setModal(true);
            setTitle("Choose configuration file:");
            setPreferredSize(new Dimension(550, 430));
            setLayout(new GridBagLayout());

            GridBagConstraints constraints = new GridBagConstraints();
            JButton buttonAccept = createAcceptButton();

            try {
                constraints.gridx = 0;
                constraints.gridy = 0;
                constraints.gridwidth = 4;
                constraints.gridheight = 1;
                constraints.weightx = 0;
                constraints.weighty = 0;
                constraints.fill = GridBagConstraints.HORIZONTAL;
                JLabel label = new JLabel("The UML Tool will need to be restarted before changes to the settings takes effect");
                add(label, constraints);

                constraints.gridx = 0;
                constraints.gridy = 1;
                constraints.gridwidth = 4;
                constraints.gridheight = 1;
                constraints.weightx = 0;
                constraints.weighty = 0;
                constraints.fill = GridBagConstraints.HORIZONTAL;
                final ConfigurationManagerEditorPanel panel =
                    new ConfigurationManagerEditorPanel("ConfigurationManagerEditorPanel");
                add(panel, constraints);

                buttonAccept.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            // validate the properties
                            ValidationResultSet resultSet = panel.validateProperties();
                            // check the validation
                            if (resultSet.isSuccess()) {
                                panel.saveProperties();
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        for (PropertyDefinition propertyDefinition : panel.getPropertyDefinitions().keySet()) {
                            if ("AutoSave".equals(propertyDefinition.getPropertyName())) {
                                mainFrame.setAutoSave(propertyDefinition.getPropertyValue().equals("true"));
                            } else if ("BackupDirectory".equals(propertyDefinition.getPropertyName())) {
                                mainFrame.setBackupDirectory(propertyDefinition.getPropertyValue());
                            } else if ("AddOperationAutomatic".equals(propertyDefinition.getPropertyName())) {
                                mainFrame
                                    .setAutoAddOperation(propertyDefinition.getPropertyValue().equals("true"));
                            }
                        }
                        SettingDialog.this.setVisible(false);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Add Cancel and Accept buttons.
            JButton buttonCancel = createCancleButton();
            constraints.gridx = 2;
            constraints.gridy = 2;
            constraints.gridwidth = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.NONE;
            constraints.anchor = GridBagConstraints.LINE_END;
            add(buttonCancel, constraints);

            constraints.gridx = 3;
            constraints.gridy = 2;
            constraints.gridwidth = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.NONE;
            add(buttonAccept, constraints);

            pack();
        }

        /**
         * <p>
         * This method creates the <b>Accept</b> button for this <code>JDialog</code>.
         * </p>
         *
         * @return the <b>Accept</b> button for this <code>JDialog</code>.
         */
        private JButton createAcceptButton() {
            JButton buttonAccept = new JButton("Accept");

            return buttonAccept;
        }

        /**
         * <p>
         * This method creates the <b>Cancel</b> button for this <code>JDialog</code>.
         * </p>
         *
         * @return the <b>Cancel</b> button for this <code>JDialog</code>.
         */
        private JButton createCancleButton() {
            JButton buttonCancel = new JButton("Cancel");
            // Creates an ActionListener instance and assign it to the button
            buttonCancel.addActionListener(new ActionListener() {
                /**
                 * <p>
                 * Invoked when an action occurs.
                 * </p>
                 * <p>
                 * When the button is clicked, this method will be invoked.
                 * </p>
                 *
                 * @param event
                 *            a semantic event which indicates that a component-defined action occurred.
                 */
                public void actionPerformed(ActionEvent e) {
                    // hide the dialog
                    setVisible(false);
                    dispose();
                }
            });

            return buttonCancel;
        }
    }
}
