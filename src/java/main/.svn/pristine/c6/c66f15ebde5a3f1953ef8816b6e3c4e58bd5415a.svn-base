package com.topcoder.umltool.deploy;

import javax.swing.JPanel;
import javax.swing.JDialog;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import com.topcoder.uml.importer.jarimporter.JarImporter;
import com.topcoder.uml.importer.jarimporter.impl.DefaultJarImporter;
import com.topcoder.uml.modelmanager.UMLModelManager;

import java.awt.Insets;
import java.io.File;
import java.io.FilenameFilter;

public class JarImporterDialog extends JDialog {

    private static final long serialVersionUID = 1L;

    private JPanel jContentPane = null;

    private JPanel mainPanel = null;

    private JPanel buttonPanel = null;

    private JButton okButton = null;

    private JButton cancelButton = null;

    private JLabel jarLocationLabel = null;

    private JLabel diagramNameLabel = null;

    private JPanel emptyPanel = null;

    private JTextField jarLocationTextField = null;

    private JTextField diagramNameField = null;

    private JButton browseButton = null;

    private JPanel inPanel = null;

    private JRadioButton currentDiagramButton = null;

    private JRadioButton newDiagramButton = null;

    private final UMLModelManager modelManager;

    private final MainFrame mainFrame;

    /**
     * @param owner
     */
    public JarImporterDialog(MainFrame owner, UMLModelManager modelManager) {
        super(owner);
        mainFrame = owner;
        this.modelManager = modelManager;
        initialize();
    }

    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
        this.setSize(489, 203);
        this.setContentPane(getJContentPane());
    }

    /**
     * This method initializes jContentPane
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
            gridBagConstraints1.gridx = 0;
            gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints1.anchor = GridBagConstraints.SOUTH;
            gridBagConstraints1.weightx = 1.0D;
            gridBagConstraints1.gridy = 1;
            gridBagConstraints1.insets = new Insets(10, 15, 15, 15);
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.fill = GridBagConstraints.BOTH;
            gridBagConstraints.gridheight = 1;
            gridBagConstraints.gridwidth = 1;
            gridBagConstraints.anchor = GridBagConstraints.NORTH;
            gridBagConstraints.weightx = 1.0D;
            gridBagConstraints.weighty = 1.0D;
            gridBagConstraints.insets = new Insets(15, 15, 0, 15);
            gridBagConstraints.gridy = 0;
            jContentPane = new JPanel();
            jContentPane.setLayout(new GridBagLayout());
            jContentPane.setPreferredSize(new Dimension(440, 200));
            jContentPane.add(getMainPanel(), gridBagConstraints);
            jContentPane.add(getButtonPanel(), gridBagConstraints1);
        }
        return jContentPane;
    }

    /**
     * This method initializes mainPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getMainPanel() {
        if (mainPanel == null) {
            GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
            gridBagConstraints10.gridx = 0;
            gridBagConstraints10.fill = GridBagConstraints.BOTH;
            gridBagConstraints10.weightx = 1.0D;
            gridBagConstraints10.weighty = 1.0D;
            gridBagConstraints10.gridwidth = 3;
            gridBagConstraints10.gridy = 1;
            GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
            gridBagConstraints9.gridx = 2;
            gridBagConstraints9.gridy = 0;
            GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
            gridBagConstraints8.fill = GridBagConstraints.BOTH;
            gridBagConstraints8.gridy = 2;
            gridBagConstraints8.weightx = 1.0;
            gridBagConstraints8.gridx = 1;
            GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
            gridBagConstraints7.fill = GridBagConstraints.BOTH;
            gridBagConstraints7.gridy = 0;
            gridBagConstraints7.weightx = 1.0;
            gridBagConstraints7.gridx = 1;
            GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
            gridBagConstraints3.gridx = 0;
            gridBagConstraints3.gridy = 2;
            GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
            gridBagConstraints2.gridx = 0;
            gridBagConstraints2.gridy = 0;
            diagramNameLabel = new JLabel();
            diagramNameLabel.setText("Diagram name:");
            jarLocationLabel = new JLabel();
            jarLocationLabel.setText("JAR file location:");
            mainPanel = new JPanel();
            mainPanel.setLayout(new GridBagLayout());
            mainPanel.add(jarLocationLabel, gridBagConstraints2);
            mainPanel.add(diagramNameLabel, gridBagConstraints3);
            mainPanel.add(getJarLocationTextField(), gridBagConstraints7);
            mainPanel.add(getDiagramNameField(), gridBagConstraints8);
            mainPanel.add(getBrowseButton(), gridBagConstraints9);
            mainPanel.add(getInPanel(), gridBagConstraints10);
        }
        return mainPanel;
    }

    /**
     * This method initializes buttonPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getButtonPanel() {
        if (buttonPanel == null) {
            GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
            gridBagConstraints6.gridx = 2;
            gridBagConstraints6.weightx = 1.0D;
            gridBagConstraints6.weighty = 1.0D;
            gridBagConstraints6.gridy = 0;
            GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
            gridBagConstraints5.anchor = GridBagConstraints.WEST;
            gridBagConstraints5.gridy = 0;
            gridBagConstraints5.gridx = 1;
            GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
            gridBagConstraints4.anchor = GridBagConstraints.WEST;
            gridBagConstraints4.gridy = 0;
            gridBagConstraints4.gridx = 0;
            buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridBagLayout());
            buttonPanel.add(getOkButton(), gridBagConstraints4);
            buttonPanel.add(getCancelButton(), gridBagConstraints5);
            buttonPanel.add(getEmptyPanel(), gridBagConstraints6);
        }
        return buttonPanel;
    }

    /**
     * This method initializes okButton
     *
     * @return javax.swing.JButton
     */
    private JButton getOkButton() {
        if (okButton == null) {
            okButton = new JButton("OK");
            okButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    String importDependencyLocation = null;
                    try {
                        importDependencyLocation =
                            DeployHelper.getProperty("com.topcoder.umltool.deploy", "ImportDependencyLocation");
                    } catch (DeployConfigException e2) {
                    }

                    File[] list = new File[0];
                    if (importDependencyLocation != null) {
                        File dir = new File(importDependencyLocation);
                        if (dir.isDirectory()) {
                            list = dir.listFiles(new FilenameFilter() {

                                public boolean accept(File f, String name) {
                                    return name.toLowerCase().endsWith(".jar");
                                }

                            });
                        }
                    }

                    String[] listString = new String[list.length];
                    for (int i = 0; i < list.length; i++) {
                        listString[i] = list[i].getAbsolutePath();
                    }

                    JarImporter importer = new DefaultJarImporter(modelManager, listString);

                    try {
                        importer.importJar(jarLocationTextField.getText());

                        mainFrame.getDocumentTree().updateTree();
                        // importer
                        // .importJarsToDiagram(
                        // new String[]
                        // {"/Users/nanda/TopCoder/library/tcs/base_exception/2.0.0/base_exception.jar"},
                        // diagramName);

                        // Find the diagram with the given name. if not found, throw IllegalArgumentException
                        // Diagram diagram = null;

                        // get the diagram
                        // for (Diagram d : modelManager.getDiagrams()) {
                        // // Not sure d.getName() will be null or not.
                        // if (diagramName.equals(d.getName())) {
                        // diagram = d;

                        // the loop should break.
                        // break;
                        // }

                        // mainFrame.recoverDiagramViews(false);
                    } catch (Throwable e1) {
                        DeployHelper.handleException(mainFrame, e1,
                            "Error importing the Java classes from the JAR. "
                                + "Please check that all dependencies are in the configurable location.");
                    }
                    JarImporterDialog.this.setVisible(false);
                }
            });
        }
        return okButton;
    }

    /**
     * This method initializes cancelButton
     *
     * @return javax.swing.JButton
     */
    private JButton getCancelButton() {
        if (cancelButton == null) {
            cancelButton = new JButton("Cancel");
            cancelButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JarImporterDialog.this.setVisible(false);
                }
            });
        }
        return cancelButton;
    }

    /**
     * This method initializes emptyPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getEmptyPanel() {
        if (emptyPanel == null) {
            emptyPanel = new JPanel();
            emptyPanel.setLayout(new GridBagLayout());
        }
        return emptyPanel;
    }

    /**
     * This method initializes jarLocationTextField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getJarLocationTextField() {
        if (jarLocationTextField == null) {
            jarLocationTextField = new JTextField();
            jarLocationTextField.setPreferredSize(new Dimension(200, 28));
        }
        return jarLocationTextField;
    }

    /**
     * This method initializes diagramNameField
     *
     * @return javax.swing.JTextField
     */
    private JTextField getDiagramNameField() {
        if (diagramNameField == null) {
            diagramNameField = new JTextField();
            diagramNameField.setPreferredSize(new Dimension(200, 28));
        }
        return diagramNameField;
    }

    /**
     * This method initializes browseButton
     *
     * @return javax.swing.JButton
     */
    private JButton getBrowseButton() {
        if (browseButton == null) {
            browseButton = new JButton("Browse...");
            browseButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    JFileChooser f = new JFileChooser();

                    int returnVal = f.showOpenDialog(mainFrame);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File selectedFile = f.getSelectedFile();

                        jarLocationTextField.setText(selectedFile.getAbsolutePath());
                    }
                }
            });
        }
        return browseButton;
    }

    /**
     * This method initializes inPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getInPanel() {
        if (inPanel == null) {
            GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
            gridBagConstraints12.gridx = 0;
            gridBagConstraints12.anchor = GridBagConstraints.WEST;
            gridBagConstraints12.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints12.gridy = 1;
            GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
            gridBagConstraints11.gridx = 0;
            gridBagConstraints11.anchor = GridBagConstraints.WEST;
            gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints11.weightx = 1.0D;
            gridBagConstraints11.gridy = 0;
            inPanel = new JPanel();
            inPanel.setLayout(new GridBagLayout());
            inPanel.add(getCurrentDiagramButton(), gridBagConstraints11);
            inPanel.add(getNewDiagramButton(), gridBagConstraints12);
        }
        return inPanel;
    }

    /**
     * This method initializes currentDiagramButton
     *
     * @return javax.swing.JRadioButton
     */
    private JRadioButton getCurrentDiagramButton() {
        if (currentDiagramButton == null) {
            currentDiagramButton = new JRadioButton();
            currentDiagramButton.setText("Import into current diagram");
            currentDiagramButton.setHorizontalAlignment(SwingConstants.LEFT);
        }
        return currentDiagramButton;
    }

    /**
     * This method initializes newDiagramButton
     *
     * @return javax.swing.JRadioButton
     */
    private JRadioButton getNewDiagramButton() {
        if (newDiagramButton == null) {
            newDiagramButton = new JRadioButton();
            newDiagramButton.setText("Import into new diagram");
        }
        return newDiagramButton;
    }

} // @jve:decl-index=0:visual-constraint="10,10"
