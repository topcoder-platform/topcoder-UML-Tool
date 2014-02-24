/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;

import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.uml.actions.project.CreateNewProjectAction;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.ProjectUtility;

/**
 * <p>
 * Action to new a project.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class NewProjectAction extends AbstractAction {
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
    private static final String ACTION_NAME = "New";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "New project.";

    /**
     * <p>
     * Icon file name for menu.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/New_16.png";

    /**
     * <p>
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY = KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit()
            .getMenuShortcutKeyMask());

    /**
     * <p>
     * Icon file for tool bar.
     * <p>
     */
    private static final String TOOLBAR_ICON_FILE_NAME = "/images/New.png";

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Project language.
     * </p>
     */
    private String language = null;

    /**
     * <p>
     * Constructs an instance of new project action.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public NewProjectAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(NewProjectAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(NewProjectAction.class
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
        if (!mainFrame.querySave()) {
            return;
        }

        LanguageDialog dialog = new LanguageDialog();
        dialog.setModal(false);
        dialog.setLocationRelativeTo(mainFrame);
        dialog.setVisible(true);
    }

    /**
     * <p>
     * This class provides a modal <code>JDialog</code> to select project language.
     * </p>
     * <p>
     * The <code>JDialog</code> will provide a GUI for user to choose language .
     * </p>
     * @author ly, FireIce, ylouis
     * @version 1.0
     */
    private class LanguageDialog extends JDialog {
        /**
         * <p>
         * The JRadioButton used to choose java language.
         * </p>
         */
        private final JRadioButton javaButton;

        /**
         * <p>
         * The JRadioButton used to choose c# language.
         * </p>
         */
        private final JRadioButton cButton;

        /**
         * <p>
         * Creates a new project language selection dialog.
         * </p>
         */
        public LanguageDialog() {
            super(mainFrame, "Choose language");
            setModal(true);
            setLayout(new GridBagLayout());

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 4;
            constraints.weightx = 1;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.insets = new Insets(5, 5, 5, 5);
            add(new JLabel("Choose Project Language:"), constraints);

            javaButton = new JRadioButton("Java", true);
            constraints.gridx = 1;
            constraints.gridy = 1;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            add(javaButton, constraints);

            cButton = new JRadioButton("C#");
            constraints.gridx = 2;
            constraints.gridy = 1;
            constraints.gridwidth = 1;
            constraints.gridheight = 1;
            constraints.weightx = 0;
            constraints.weighty = 0;
            constraints.fill = GridBagConstraints.HORIZONTAL;
            add(cButton, constraints);

            ButtonGroup buttonGroup = new ButtonGroup();
            buttonGroup.add(javaButton);
            buttonGroup.add(cButton);

            // Add Cancel and Accept buttons.
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
                    if (javaButton.isSelected()) {
                        language = "Java";
                    } else {
                        language = "CSharp";
                    }
                    mainFrame.getUmlModelManager().setProjectLanguage(language);

                    CreateNewProjectAction createNewProjectAction = new CreateNewProjectAction(language, mainFrame
                            .getUmlModelManager());

                    createNewProjectAction.execute();
                    try{
                    mainFrame.initPJManager();
                  }catch(Exception ex){
                  	 mainFrame.dispose();
                  	 ex.printStackTrace();
                  }
                    mainFrame.setTitle(MainFrame.MAIN_FRAME_TITLE + " - Unsaved");

                    // get the created model
                    Model model = mainFrame.getUmlModelManager().getModel();
                    model.clearTaggedValues();

                    // create a new tag definition with ProjectLanguage as type
                    TagDefinition tagDefinition = DeployHelper.getTagDefinition("ProjectLanguage");
                    // create a tagged value with the project language as data and type as tag definition.
                    TaggedValue taggedValue = new TaggedValueImpl();
                    taggedValue.setDataValue(language);
                    taggedValue.setType(tagDefinition);
                    // add the tagged value to the model manager
                    model.addTaggedValue(taggedValue);

                    // clean the DiagramViewer
                    ProjectUtility.getInstance().setProjectFile(null);
                    DocumentTreeTabbedPane treePane = mainFrame.getDocumentTree();
                    treePane.updateTree();
                    mainFrame.getDiagramViewer().clear();

                    ((DocumentTreeTabbedPaneImpl) treePane).initializePanel();

                    for (int i = treePane.getTabbedPane().getTabCount() - 4; i >= 0; --i) {
                        treePane.getTabbedPane().remove(i);
                    }


                    mainFrame.repaint();
                    mainFrame.setIsDirty(false);
                    // hide the dialog
                    setVisible(false);
                    dispose();
                }
            });
            return buttonAccept;
        }
    }
}
