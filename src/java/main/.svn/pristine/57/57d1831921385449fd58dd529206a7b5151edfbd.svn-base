/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.stubclassgenerator.CodeGenerationException;
import com.topcoder.uml.stubclassgenerator.CodeGenerator;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Action to generate code.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class GenerateCodeAction extends AbstractAction {
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
    private static final String ACTION_NAME = "Generate Code";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Generate code.";

    /**
     * <p>
     * Icon file name for menu.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/GenerateCode_16.png";

    /**
     * <p>
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY = KeyStroke.getKeyStroke('G', Toolkit.getDefaultToolkit()
            .getMenuShortcutKeyMask());

    /**
     * <p>
     * Icon file for tool bar.
     * <p>
     */
    private static final String TOOLBAR_ICON_FILE_NAME = "/images/GenerateCode_16.png";

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * The generate dialog.
     * </p>
     */
    private GenerateCodeDialog dialog;

    /**
     * <p>
     * Constructs an instance of generate code action.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public GenerateCodeAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(GenerateCodeAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(GenerateCodeAction.class
                .getResource(TOOLBAR_ICON_FILE_NAME)));

        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Performing the action.
     * <p>
     * @param actionEvent
     *            the action event
     */
    public void actionPerformed(ActionEvent actionEvent) {
        dialog = new GenerateCodeDialog();
        dialog.setModal(false);
        dialog.setLocationRelativeTo(mainFrame);
        dialog.setVisible(true);
    }

    /**
     * <p>
     * This class provides a modal <code>JDialog</code> to generate code.
     * </p>
     * <p>
     * The <code>JDialog</code> will provide a GUI for user to choose elements and output path .
     * </p>
     * @author ly, FireIce, ylouis
     * @version 1.0
     */
    private class GenerateCodeDialog extends JDialog {
        /**
         * <p>
         * The JTree used to choose the elements whose code should be generated.
         * </p>
         */
        private final JTree classTree;

        /**
         * <p>
         * The JTextField used to choose the output path.
         * </p>
         */
        private final JTextField outputPath;

        /**
         * <p>
         * The JRadioButton used to choose java code.
         * </p>
         */
        private final JRadioButton javaButton;

        /**
         * <p>
         * The JRadioButton used to choose c# code.
         * </p>
         */
        private final JRadioButton cButton;

        /**
         * <p>
         * Creates a new generate code dialog.
         * </p>
         */
        public GenerateCodeDialog() {
            super(mainFrame, "Generate code");
            setModal(true);
            setLayout(new GridBagLayout());

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 4;
            constraints.weightx = 1;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.insets = new Insets(5, 5, 5, 5);
            add(new JLabel("Choose Model Elements:"), constraints);

            CheckNode rootNode = createClassTree();
            classTree = new JTree(rootNode);
            classTree.setShowsRootHandles(true);
            classTree.setCellRenderer(new CheckRenderer());
            classTree.putClientProperty("JTree.lineStyle", "Angled");
            classTree.addMouseListener(new NodeSelectionListener(classTree));

            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.gridwidth = 4;
            constraints.gridheight = 4;
            constraints.weightx = 1;
            constraints.weighty = 1;
            constraints.fill = GridBagConstraints.BOTH;
            // wrap the JTree in a JScrollPane and add it to this JDialog.
            add(new JScrollPane(classTree), constraints);

            constraints.gridx = 0;
            constraints.gridy = 5;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            add(new JLabel("Output Directory:"), constraints);

            // the JTextField to let user to enter the directory
            outputPath = new JTextField();
            constraints.gridx = 1;
            constraints.gridy = 5;
            constraints.gridwidth = 2;
            constraints.weightx = 1;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            add(outputPath, constraints);

            // the JButton to let user to choose directory
            JButton buttonChoosePath = createChoosePathButton();
            constraints.gridx = 3;
            constraints.gridy = 5;
            constraints.gridwidth = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.NONE;
            add(buttonChoosePath, constraints);

            constraints.gridx = 0;
            constraints.gridy = 6;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            add(new JLabel("Code Language:"), constraints);

            javaButton = new JRadioButton("Java");
            constraints.gridx = 1;
            constraints.gridy = 6;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            add(javaButton, constraints);

            cButton = new JRadioButton("C#");
            constraints.gridx = 2;
            constraints.gridy = 6;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            add(cButton, constraints);

            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(javaButton);
            buttonGroup.add(cButton);
            if (mainFrame.getUmlModelManager().getProjectLanguage().equals("Java")) {
                javaButton.setSelected(true);
            } else {
                cButton.setSelected(true);
            }

            // Add Cancel and Accept buttons.
            JButton buttonCancel = createCancleButton();
            constraints.gridx = 2;
            constraints.gridy = 7;
            constraints.gridwidth = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.NONE;
            constraints.anchor = GridBagConstraints.LINE_END;
            add(buttonCancel, constraints);

            JButton buttonAccept = createAcceptButton();
            constraints.gridx = 3;
            constraints.gridy = 7;
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
                    File file = new File(outputPath.getText() + "/src");
                    if (!file.isDirectory()) {
                        boolean dir = file.mkdirs();
                        if (!dir) {
                            DeployHelper.handleException(mainFrame, null, "Create directory " + file.getAbsolutePath()
                                    + " fail.");
                            return;
                        }
                    }

                    String location = file.getAbsolutePath();
                    String codeLang;
                    String suffix;
                    if (javaButton.isSelected()) {
                        codeLang = "Java";
                        suffix = ".java";
                    } else {
                        codeLang = "C#";
                        suffix = ".cs";
                    }

                    CodeGenerator generator = mainFrame.getCodeGenerator();
                    // the selected element is used to generate code
                    CheckNode rootNode = (CheckNode) classTree.getModel().getRoot();
                    Enumeration<?> df = rootNode.breadthFirstEnumeration();
                    List<com.topcoder.uml.model.modelmanagement.Package> addPackages = new ArrayList<com.topcoder.uml.model.modelmanagement.Package>();
                    List<com.topcoder.uml.model.modelmanagement.Package> delPackages = new ArrayList<com.topcoder.uml.model.modelmanagement.Package>();
                    List<Classifier> addClassifiers = new ArrayList<Classifier>();
                    List<Classifier> delClassifiers = new ArrayList<Classifier>();
                    CheckNode node;

                    while (df.hasMoreElements()) {
                        node = ((CheckNode) df.nextElement());
                        if (!(node.getUserObject() instanceof Model)) {
                            Namespace namespace = (Namespace) node.getUserObject();
                            Namespace parent = namespace.getNamespace();
                            if (parent instanceof Model) {
                                if (node.isSelected()) {
                                    if (namespace instanceof com.topcoder.uml.model.modelmanagement.Package) {
                                        addPackages.add((com.topcoder.uml.model.modelmanagement.Package) namespace);
                                    } else {
                                        addClassifiers.add((Classifier) namespace);
                                    }
                                }
                            } else {
                                if (!node.isSelected()) {
                                    if (namespace instanceof com.topcoder.uml.model.modelmanagement.Package) {
                                        delPackages.add((com.topcoder.uml.model.modelmanagement.Package) namespace);
                                    } else {
                                        delClassifiers.add((Classifier) namespace);
                                    }
                                }
                            }
                        }
                    }
                    try {
                        generator.generateCodeForClassifiers(codeLang, location, addClassifiers);
                        generator.generateCodeForPackages(codeLang, location, addPackages);
                    } catch (CodeGenerationException exception) {
                        DeployHelper.handleException(mainFrame, exception, "Generate code fail: "
                                + exception.getMessage());
                    }
                    for (Classifier classifier : delClassifiers) {
                        deleteClassifier(location, classifier, suffix);
                    }
                    for (com.topcoder.uml.model.modelmanagement.Package pack : delPackages) {
                        deletePackage(location, pack);
                    }
                    // hide the dialog
                    setVisible(false);
                    dispose();
                }

                /**
                 * <p>
                 * Deletes the package''s code.
                 * </p>
                 * @param location
                 *            the location
                 * @param pack
                 *            the package
                 */
                private void deletePackage(String location, com.topcoder.uml.model.modelmanagement.Package pack) {
                    String path = location + getPackagePath(pack);
                    File newFile = new File(path);
                    if (newFile.exists()) {
                        deleteDirectoryRec(newFile);
                        newFile.delete();
                    }
                }

                /**
                 * <p>
                 * Deletes the classifier's code.
                 * </p>
                 * @param location
                 *            the location
                 * @param classifier
                 *            the classifier
                 */
                private void deleteClassifier(String location, Classifier classifier, String suffix) {
                    String path = location + getPackagePath(classifier.getNamespace()) + "/" + classifier.getName()
                            + suffix;
                    File newFile = new File(path);
                    if (newFile.exists()) {
                        newFile.delete();
                    }
                }

                /**
                 * <p>
                 * Gets the package's path.
                 * </p>
                 * @param pack
                 *            the package
                 * @return the package's path
                 */
                private String getPackagePath(Namespace pack) {
                    String path = "";
                    while (!(pack instanceof Model) && (pack != null)) {
                        path = "/" + pack.getName().replace(".", "/") + path;
                        pack = pack.getNamespace();
                    }
                    return path;
                }

                /**
                 * <p>
                 * Deletes the dir.
                 * </p>
                 * @param dir
                 *            the dir
                 */
                private void deleteDirectoryRec(File dir) {
                    for (File file : dir.listFiles()) {
                        if (file.isDirectory()) {
                            this.deleteDirectoryRec(file);
                            file.delete();
                        } else {
                            file.delete();
                        }
                    }
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
        private JButton createChoosePathButton() {
            JButton buttonChoosePath = new JButton("...");

            // Creates an ActionListener instance and assign it to the button
            buttonChoosePath.addActionListener(new ActionListener() {
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
                    f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int returnValue = f.showOpenDialog(dialog);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File file = f.getSelectedFile();
                        outputPath.setText(file.getAbsolutePath());
                    }
                }
            });

            return buttonChoosePath;
        }

        /**
         * <p>
         * Creates the class tree.
         * </p>
         * @return the root node
         */
        private CheckNode createClassTree() {
            Model root = UMLModelManager.getInstance().getModel();
            CheckNode rootTreeNode = new CheckNode(root);

            // traverse all the model elements owned by the root model
            for (ModelElement modelElement : root.getOwnedElements()) {
                traverse(rootTreeNode, modelElement);
            }
            return rootTreeNode;
        }

        /**
         * <p>
         * Traverses the model element to generate the tree node.
         * </p>
         * @param parentNode
         *            the parent tree node
         * @param element
         *            the model element
         */
        private void traverse(CheckNode parentNode, ModelElement element) {
            CheckNode childTreeNode = null;

            // we only adds tree node for PackageImpl and ClassImpl types
            if ((element instanceof PackageImpl) || (element instanceof ClassImpl)
                    || (element instanceof InterfaceImpl)) {
                childTreeNode = new CheckNode(element);
                parentNode.add(childTreeNode);
            }

            // If it is a PackageImpl element, traverses all its owned elements
            if (element instanceof PackageImpl) {
                for (ModelElement owned : ((Namespace) element).getOwnedElements()) {
                    traverse(childTreeNode, owned);
                }
            }
        }

    }

    /**
     * <p>
     * This is an inner class and it extends TreeCellRenderer class to be used for the JTree.
     * </p>
     * @author ly, FireIce, ylouis
     * @version 1.0
     */
    private class CheckRenderer extends JPanel implements TreeCellRenderer {
        /**
         * <p>
         * The JCheckBox used to indicate the node's selection.
         * </p>
         */
        private JCheckBox check;

        /**
         * <p>
         * The TreeLabel used to display the node's name.
         * </p>
         */
        private TreeLabel label;

        /**
         * <p>
         * Creates a new CheckRenderer.
         * </p>
         */
        public CheckRenderer() {
            setLayout(null);
            check = new JCheckBox();
            label = new TreeLabel();
            add(check);
            add(label);
            check.setBackground(UIManager.getColor("Tree.textBackground"));
            label.setForeground(UIManager.getColor("Tree.textForeground"));
        }

        /**
         * <p>
         * Sets the value of the current tree cell to <code>value</code>. If <code>selected</code> is true, the
         * cell will be drawn as if selected. If <code>expanded</code> is true the node is currently expanded and if
         * <code>leaf</code> is true the node represents a leaf and if <code>hasFocus</code> is true the node
         * currently has focus. <code>tree</code> is the <code>JTree</code> the receiver is being configured for.
         * Returns the <code>Component</code> that the renderer uses to draw the value.
         * </p>
         * @param tree
         *            tree to get renerer component
         * @param value
         *            specified value to get cell renderer
         * @param isSelected
         *            whether the cell will be drawn as if selected.
         * @param expanded
         *            whether the node is currently expanded
         * @param leaf
         *            whether the node represents a leaf
         * @param row
         *            the row of node
         * @param hasFocus
         *            whether the node currently has focus
         * @return the <code>Component</code> that the renderer uses to draw the value
         */
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
                boolean leaf, int row, boolean hasFocus) {
            String stringValue = tree.convertValueToText(value, isSelected, expanded, leaf, row, hasFocus);
            setEnabled(tree.isEnabled());
            check.setSelected(((CheckNode) value).isSelected());
            label.setFont(tree.getFont());
            label.setText(stringValue);
            label.setSelected(isSelected);
            label.setFocus(hasFocus);
            if (leaf) {
                label.setIcon(UIManager.getIcon("Tree.leafIcon"));
            } else if (expanded) {
                label.setIcon(UIManager.getIcon("Tree.openIcon"));
            } else {
                label.setIcon(UIManager.getIcon("Tree.closedIcon"));
            }
            return this;
        }

        /**
         * <p>
         * Gets the preferred size.
         * </p>
         * @return the preferred size
         */
        public Dimension getPreferredSize() {
            Dimension d_check = check.getPreferredSize();
            Dimension d_label = label.getPreferredSize();
            return new Dimension(d_check.width + d_label.width, (d_check.height < d_label.height ? d_label.height
                    : d_check.height));
        }

        /**
         * <p>
         * Does the layout.
         * </p>
         */
        public void doLayout() {
            Dimension dCheck = check.getPreferredSize();
            Dimension dLabel = label.getPreferredSize();
            int yCheck = 0;
            int yLabel = 0;
            if (dCheck.height < dLabel.height) {
                yCheck = (dLabel.height - dCheck.height) / 2;
            } else {
                yLabel = (dCheck.height - dLabel.height) / 2;
            }
            check.setLocation(0, yCheck);
            check.setBounds(0, yCheck, dCheck.width, dCheck.height);
            label.setLocation(dCheck.width, yLabel);
            label.setBounds(dCheck.width, yLabel, dLabel.width, dLabel.height);
        }

        /**
         * <p>
         * Sets the background color.
         * </p>
         * @param color
         *            the color
         */
        public void setBackground(Color color) {
            if (color instanceof ColorUIResource) {
                color = null;
            }
            super.setBackground(color);
        }

        /**
         * <p>
         * This is an inner class and it extends JLabel class to be used for the JTree.
         * </p>
         * @author ly, FireIce, ylouis
         * @version 1.0
         */
        private class TreeLabel extends JLabel {
            /**
             * <p>
             * Stores the selection status.
             * </p>
             */
            private boolean isSelected;

            /**
             * <p>
             * Stores whether it is focused.
             * </p>
             */
            private boolean hasFocus;

            /**
             * <p>
             * Default constructor.
             * </p>
             */
            public TreeLabel() {
            }

            /**
             * <p>
             * Sets the background color.
             * </p>
             * @param color
             *            the color
             */
            public void setBackground(Color color) {
                if (color instanceof ColorUIResource) {
                    color = null;
                }
                super.setBackground(color);
            }

            /**
             * <p>
             * Paints with the graphics.
             * </p>
             * @param g
             *            the graphics
             */
            public void paint(Graphics g) {
                String str = getText();
                if (str != null) {
                    if (0 < str.length()) {
                        if (isSelected) {
                            g.setColor(UIManager.getColor("Tree.selectionBackground"));
                        } else {
                            g.setColor(UIManager.getColor("Tree.textBackground"));
                        }
                        Dimension d = getPreferredSize();
                        int imageOffset = 0;
                        Icon currentI = getIcon();
                        if (currentI != null) {
                            imageOffset = currentI.getIconWidth() + Math.max(0, getIconTextGap() - 1);
                        }
                        g.fillRect(imageOffset, 0, d.width - 1 - imageOffset, d.height);
                        if (hasFocus) {
                            g.setColor(UIManager.getColor("Tree.selectionBorderColor"));
                            g.drawRect(imageOffset, 0, d.width - 1 - imageOffset, d.height - 1);
                        }
                    }
                }
                super.paint(g);
            }

            /**
             * <p>
             * Gets the preferred size.
             * </p>
             * @return the preferred size
             */
            public Dimension getPreferredSize() {
                Dimension retDimension = super.getPreferredSize();
                if (retDimension != null) {
                    retDimension = new Dimension(retDimension.width + 3, retDimension.height);
                }
                return retDimension;
            }

            /**
             * <p>
             * Sets the selected status.
             * </p>
             * @param isSelected
             *            the selected flag
             */
            public void setSelected(boolean isSelected) {
                this.isSelected = isSelected;
            }

            /**
             * <p>
             * Sets the focused status.
             * </p>
             * @param hasFocus
             *            the focused flag
             */
            public void setFocus(boolean hasFocus) {
                this.hasFocus = hasFocus;
            }
        }
    }

    /**
     * <p>
     * This is an inner class and it extends MouseAdapter class to be used for the JTree.
     * </p>
     * @author ly, FireIce, ylouis
     * @version 1.0
     */
    private class NodeSelectionListener extends MouseAdapter {
        /**
         * <p>
         * Stores the JTree.
         * </p>
         */
        private JTree tree;

        /**
         * <p>
         * Constructor with the JTree.
         * </p>
         * @param tree
         *            the JTree
         */
        public NodeSelectionListener(JTree tree) {
            this.tree = tree;
        }

        /**
         * <p>
         * Updates the node.
         * </p>
         * @param e
         *            the mouse event
         */
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            int row = tree.getRowForLocation(x, y);
            TreePath path = tree.getPathForRow(row);
            if (path != null) {
                CheckNode node = (CheckNode) path.getLastPathComponent();
                boolean isSelected = !(node.isSelected());
                node.setSelected(isSelected);
                if (isSelected) {
                    tree.expandPath(path);
                } else {
                    tree.collapsePath(path);
                }
                ((DefaultTreeModel) tree.getModel()).nodeChanged(node);
            }
            if (row == 0) {
                tree.revalidate();
                tree.repaint();
            }
        }
    }

    /**
     * <p>
     * This is an inner class and it extends DefaultMutableTreeNode class to be used for the JTree.
     * </p>
     * @author ly, FireIce, ylouis
     * @version 1.0
     */
    private class CheckNode extends DefaultMutableTreeNode {
        /**
         * <p>
         * Stores the selection status.
         * </p>
         */
        protected boolean isSelected;

        /**
         * <p>
         * Stores the expanded flag.
         * </p>
         */
        protected boolean expanded;

        /**
         * <p>
         * Defalut constructor.
         * </p>
         */
        public CheckNode() {
            this(null);
        }

        /**
         * <p>
         * Constructs a node with the user object.
         * </p>
         * @param userObject
         *            the user object
         */
        public CheckNode(Object userObject) {
            this(userObject, true, false);
        }

        /**
         * <p>
         * Constructs a node with the user object, allowsChildren flag and isSelected status.
         * </p>
         * @param userObject
         *            the user object
         * @param allowsChildren
         *            the allowsChildren flag
         * @param isSelected
         *            the isSelelcted status
         */
        public CheckNode(Object userObject, boolean allowsChildren, boolean isSelected) {
            super(userObject, allowsChildren);
            this.isSelected = isSelected;
            this.expanded = true;
        }

        /**
         * <p>
         * Sets the selected status.
         * </p>
         * @param isSelected
         *            the selected flag
         */
        public void setSelected(boolean isSelected) {
            this.isSelected = isSelected;

            if (expanded) {
                if (children != null) {
                    Enumeration<?> e = children.elements();
                    while (e.hasMoreElements()) {
                        CheckNode node = (CheckNode) e.nextElement();
                        node.setSelected(isSelected);
                    }
                }
            }
            if (isSelected) {
                CheckNode pNode = (CheckNode) this.parent;
                while ((pNode != null) && (pNode.parent != null)) {
                    pNode.expanded = false;
                    pNode.isSelected = true;
                    pNode.expanded = true;
                    pNode = (CheckNode) pNode.parent;
                }
            }
        }

        /**
         * <p>
         * Sets the expanded flag.
         * </p>
         * @param isExpanded
         *            the expanded flag
         */
        public void setExpanded(boolean isExpanded) {
            this.expanded = isExpanded;

            if (expanded) {
                if (children != null) {
                    Enumeration<?> e = children.elements();
                    while (e.hasMoreElements()) {
                        CheckNode node = (CheckNode) e.nextElement();
                        node.setExpanded(isExpanded);
                    }
                }
            }
        }

        /**
         * <p>
         * Gets the expanded flag.
         * </p>
         * @return the expanded flag
         */
        public boolean isExpanded() {
            return expanded;
        }

        /**
         * <p>
         * Gets the selected flag.
         * </p>
         * @return the selected flag
         */
        public boolean isSelected() {
            return isSelected;
        }

        /**
         * <p>
         * Transfers the node to a string.
         * </p>
         * @return the result string
         */
        public String toString() {
            if (userObject instanceof Model) {
                return "Model";
            } else {
                return ((Namespace) userObject).getName();
            }
        }
    }
}
