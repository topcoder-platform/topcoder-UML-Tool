/*
 * Copyright (C) 2014 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.topcoder.macosx.MacOSXAdapter;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * Terms and Conditions frame of the uml tool.
 * </p>
 *
 * @author duxiaoyang
 * @version 1.0
 */
public class TermsAndConditionsFrame extends JFrame {

    /**
     * The serial version uid of this class.
     */
    private static final long serialVersionUID = -6528904504695692820L;

    /**
     * <p>
     * Represents the title of the frame.
     * </p>
     */
    private static final String FRAME_TITLE = "TopCoder UML Tool";

    /**
     * <p>
     * Icon file name for frame.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/UmlTool_16.png";

    /**
     * <p>
     * Represents the command line arguments.
     * </p>
     */
    private String[] args;

    /**
     * Creates an instance of this frame.
     */
    public TermsAndConditionsFrame(String[] args) throws DeployConfigException {
        super();
        this.args = args;
        setTitle(FRAME_TITLE);
        Image image = new ImageIcon(getClass().getResource(ICON_FILE_NAME)).getImage();
        this.setIconImage(image);
        init();
    }

    /**
     * Initializes the frame.
     * @throws DeployConfigException if any required configuration is missing.
     */
    private void init() throws DeployConfigException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        
        JTextArea textArea = new JTextArea();
        String tacFile = DeployHelper.getProperty("com.topcoder.umltool.deploy", "TermsAndConditionsFileLocation");
        InputStream stream = getClass().getClassLoader().getResourceAsStream(tacFile);
        if (stream == null) {
            throw new DeployConfigException("Terms and Conditions config error.");
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();
        try {
            String line = reader.readLine();
            while (line != null) {
                sb.append(line).append("\n");
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new DeployConfigException("Terms and Conditions config error.", e);
        }
        textArea.setText(sb.toString());
        textArea.setEditable(false);
        this.add(textArea, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        JButton acceptButton = new JButton("Accept");
        acceptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                accept();
            }});
        JButton declineButton = new JButton("Decline");
        declineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        System.exit(0);
                    }});
            }});
        buttonPanel.add(acceptButton);
        buttonPanel.add(declineButton);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Handles the event when terms and conditions are accepted.
     */
    private void accept() {
        try {
            ConfigManager.getInstance().createTemporaryProperties("com.topcoder.umltool.deploy");
            ConfigManager.getInstance().setProperty("com.topcoder.umltool.deploy", "TermsAndConditionsAccepted",
                "true");
            ConfigManager.getInstance().commit("com.topcoder.umltool.deploy", "");
            
            setVisible(false);
            UMLToolDeploy.showMainFrame(args, null);
        } catch (Exception e) {
            DeployHelper.logException(e);
        }
    }
}