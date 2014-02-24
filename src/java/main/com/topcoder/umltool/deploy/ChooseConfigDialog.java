/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.topcoder.umltool.deploy.actions.ExtensionFileFilter;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * This class provides a modal <code>JDialog</code> to generate code.
 * </p>
 * <p>
 * The <code>JDialog</code> will provide a GUI for user to choose config file .
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChooseConfigDialog extends JDialog {
    /**
     * <p>
     * The JTextField used to choose the output path.
     * </p>
     */
    private final JTextField configFile;

    /**
     * <p>
     * Stores the old config file name.
     * </p>
     */
    private String oldConfigFile;

    /**
     * <p>
     * Creates a new generate code dialog.
     * </p>
     */
    public ChooseConfigDialog() {
        setModal(true);
        setTitle("Choose configuration file:");
        setPreferredSize(new Dimension(400, 300));
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        Point location = new Point(screen.width / 2 - 400 / 2, screen.height / 2 - 300 / 2);
        this.setLocation(location);
        setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.CENTER;
        add(new JLabel("The config file is invalid."), constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.CENTER;
        add(new JLabel("Please select a new config file!!!"), constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(new JLabel("Configuration File:"), constraints);

        // the JTextField to let user to enter the directory
        configFile = new JTextField();
        try {
            oldConfigFile = DeployHelper.getProperty("com.topcoder.umltool.deploy", "SettingFile");
        } catch (DeployConfigException e) {
            DeployHelper.logException(e);
        }
        configFile.setText(new File(oldConfigFile).getAbsolutePath());
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 3;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(configFile, constraints);

        // the JButton to let user to choose directory
        JButton buttonChooseFile = createChooseFileButton();
        constraints.gridx = 3;
        constraints.gridy = 3;
        constraints.gridwidth = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        add(buttonChooseFile, constraints);

        // Add Cancel and Accept buttons.
        JButton buttonCancel = createCancleButton();
        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.LINE_END;
        add(buttonCancel, constraints);

        JButton buttonAccept = createAcceptButton();
        constraints.gridx = 3;
        constraints.gridy = 4;
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
     * @return the <b>Accept</b> button for this <code>JDialog</code>.
     */
    private JButton createAcceptButton() {
        JButton buttonAccept = new JButton("Accept");

        // Creates an ActionListener instance and assign it to the button
        buttonAccept.addActionListener(new ActionListener() {
            /**
             * <p>
             * Invoked when an action occurs.
             * </p>
             * <p>
             * When the button is clicked, this method will be invoked.
             * </p>
             * @param event
             *            a semantic event which indicates that a component-defined action occurred.
             */
            public void actionPerformed(ActionEvent e) {
                File config = new File(ConfigManager.class.getClassLoader().getResource(
                        "com/topcoder/util/config/ConfigManager.properties").getFile());
                File newConfig = new File(configFile.getText());

                try {
                    CopyFile(newConfig, config);
                    ModifySettingConfig();
                } catch (Exception e1) {
                    DeployHelper.logException(e1);
                }
                // hide the dialog
                setVisible(false);
                dispose();

            }

            private void CopyFile(File in, File out) throws Exception {
                FileInputStream fis = new FileInputStream(in);
                FileOutputStream fos = new FileOutputStream(out);
                byte[] buf = new byte[1024];
                int i = 0;
                while ((i = fis.read(buf)) != -1) {
                    fos.write(buf, 0, i);
                }
                fis.close();
                fos.close();
            }

            private void ModifySettingConfig() throws Exception {
                String setting = ConfigManager.getInstance().getConfigFilename("com.topcoder.umltool.deploy");
                File settingConfig = new File(setting);

                FileInputStream fis = new FileInputStream(settingConfig);
                String oldFile = "";
                byte buffer[] = new byte[1024];
                String str;
                int bytes;
                while ((bytes = fis.read(buffer, 0, 1024)) != -1) {
                    str = new String(buffer, 0, bytes, "Default");
                    oldFile = oldFile + str;
                }
                fis.close();
                FileOutputStream fos = new FileOutputStream(settingConfig);
                String fileName = configFile.getText();
                oldFile = oldFile.replace(oldConfigFile.replace('\\', '/'), fileName.replace('\\', '/'));
                int intSOFNum;
                intSOFNum = oldFile.length();
                byte btOutput[] = new byte[intSOFNum];
                btOutput = oldFile.getBytes();
                fos.write(btOutput);
                fos.close();
            }

        });

        return buttonAccept;
    }

    /**
     * <p>
     * This method creates the <b>Cancel</b> button for this <code>JDialog</code>.
     * </p>
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

    /**
     * <p>
     * This method creates the <b>Choose</b> button for this <code>JDialog</code>.
     * </p>
     * @return the <b>Choose</b> button for this <code>JDialog</code>.
     */
    private JButton createChooseFileButton() {
        JButton buttonChooseFile = new JButton("...");

        // Creates an ActionListener instance and assign it to the button
        buttonChooseFile.addActionListener(new ActionListener() {
            /**
             * <p>
             * Invoked when an action occurs.
             * </p>
             * <p>
             * When the button is clicked, this method will be invoked.
             * </p>
             * @param event
             *            a semantic event which indicates that a component-defined action occurred.
             */
            public void actionPerformed(ActionEvent e) {
                JFileChooser f = new JFileChooser();
                f.setCurrentDirectory(new File("."));
                f.setFileSelectionMode(JFileChooser.FILES_ONLY);
                f.setFileFilter(new ExtensionFileFilter("Configuration file", "properties"));
                int returnValue = f.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = f.getSelectedFile();
                    configFile.setText(file.getAbsolutePath());
                }
            }
        });
        return buttonChooseFile;
    }
}
