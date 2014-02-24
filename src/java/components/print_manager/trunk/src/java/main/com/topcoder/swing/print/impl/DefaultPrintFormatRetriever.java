/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.impl;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;

import javax.swing.ButtonGroup;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.topcoder.swing.print.PrintFormatRetriever;


/**
 * <p>This is class extends from JDialog and implements PrintFormatRetriever interface. It is used for prompting
 * user with a dialog where user can set Page Format, Print Choice (fitting given component to single page or scaling
 * given component and splitting it into simple grids).</p>
 * <p>This class is not thread-safe since it is muttalbe.</p>
 *
 * @author Xuchen, TCSDEVELOPER
 * @version 1.0
 */
public class DefaultPrintFormatRetriever extends JDialog implements PrintFormatRetriever {
    /**
     * <p>Represents PageFormat specified in prompting dialog.</p>
     */
    private PageFormat pageFormat;

    /**
     * <p>This is a flag representing whether print given component into single page.</p>
     */
    private boolean fitSinglePage = true;

    /**
     * <p>Represents how much the given component should be scaled before being split into simple grids.</p>
     */
    private double scaleFactor = 1.0;

    /**
     * <p>This field indicates whether user has been set preference for print format and scaling type.</p>
     */
    private boolean isPrintFormatSet = false;

    /** Represents whether the user's input is valid. */
    private boolean isInputValid = true;

    /**
     * <p>
     * Creates a new <code>DefaultPrintFormatRetriever</code> instance.
     * </p>
     */
    public DefaultPrintFormatRetriever() {
        super((JFrame) null, "Specify Print Format", true);
        initDialog();
    }

    /**
     * <p>If isPrintFormatSet is false, return IllegalStateException; otherwise it will return PageFormat
     * instance which represents user's preference for page format.</p>
     *
     * @return the pageFormat user prefers
     *
     * @throws IllegalStateException if printing preference is not set
     */
    public PageFormat getPageFormat() {
        if (!isPrintFormatSet) {
            throw new IllegalStateException("print format is not set");
        }

        return pageFormat;
    }

    /**
     * <p>Returns the flag representing whether print given component into single page which maybe required to
     * make component small or large enough to fit in single page if it is true. Otherwise if it is false, then it
     * means that it prints given component scaled by scaling factor (returned from getScaleFactor() method), and
     * split it into simple grid before print into several pages. If isPrintFormatSet is false, return
     * IllegalStateException; otherwise simply return fitSinglePage.</p>
     *
     * @return the value of fitSinglePage user prefers
     *
     * @throws IllegalStateException if printing preference is not set
     */
    public boolean isFitSinglePage() {
        if (!isPrintFormatSet) {
            throw new IllegalStateException("print format is not set");
        }

        return fitSinglePage;
    }

    /**
     * <p>If isFitSinglePage() return false, it will return the scale factor user prefers to scale. Otherwise,
     * the result returned from this method is meaningless. If isPrintFormatSet is false, return
     * IllegalStateException; otherwise simply return scaleFactor value.</p>
     *
     * @return the scale factor user prefers when fitSinglePage is false
     *
     * @throws IllegalStateException if printing preference is not set
     */
    public double getScaleFactor() {
        if (!isPrintFormatSet) {
            throw new IllegalStateException("print format is not set");
        }

        return scaleFactor;
    }

    /**
     * <p>It should retrieve user's preference of print page format and print scaling type. It will prompt user
     * with dialog where user can specify page format and print choice. It will update pageFormat, fitSinglePage,
     * scaleFactor value according user's selection.</p>
     */
    public void retrievePrintFormat() {
        setVisible(true);
    }

    /**
     * Create a "Page Format Setting" button.
     *
     * @return JButton
     */
    private JButton createPageFormatButton() {
        final PrinterJob job = PrinterJob.getPrinterJob();
        pageFormat = job.defaultPage();

        //Page Format Setting Button
        JButton pageFormatButton = new JButton("Page Format Setting");
        pageFormatButton.setName("PageFormatSettingButton");

        //add listener to this button to pop up printing dialog
        pageFormatButton.addActionListener(new ActionListener() {
                //pop up printing dialog
                public void actionPerformed(ActionEvent event) {
                    pageFormat = job.pageDialog(pageFormat);
                }
            });

        return pageFormatButton;
    }

    /**
     * Create a JTextField for scale factor input.
     *
     * @return JTextField
     */
    private JTextField createScaleTextField() {
        //Scaling Factor text field
        JTextField textField = new JTextField("1.00");
        textField.setName("ScalingFactorTextField");

        //create input verifier for this text field
        textField.setInputVerifier(new InputVerifier() {
                //validate and read the user's input
                public boolean verify(JComponent input) {
                    //if the text field is disable, skip the verify
                    if (!input.isEnabled()) {
                        return true;
                    }

                    JTextField textField = (JTextField) input;
                    isInputValid = false;

                    try {
                        double scale = Double.parseDouble(textField.getText());
                        //if scale is positive, validation success
                        if (scale > 0) {
                            isInputValid = true;
                            scaleFactor = scale;
                        }
                    } catch (NumberFormatException e) {
                        //invalid input
                    }
                    return isInputValid;
                }
            });

        return textField;
    }

    /**
     * Create a JPanel contains the option radios and scale text field.
     *
     * @return JPanel
     */
    private JPanel createPrintChoicePanel() {
        final JPanel factorPanel = new JPanel(new FlowLayout());

        final JLabel label = new JLabel("Scaling Factor:");
        factorPanel.add(label);

        final JTextField textField = createScaleTextField();
        factorPanel.add(textField);

        //Create fit in page radio and set it to default
        JRadioButton fitInPageRadio = new JRadioButton("Fit In Single Page", true);
        fitInPageRadio.setName("FitInPageRadio");

        //add listener to this radio, if it's selected,  fitSinglePage will be set to true
        fitInPageRadio.addActionListener(new ActionListener() {
                //set config and appearance to fit in print mode
                public void actionPerformed(ActionEvent event) {
                    fitSinglePage = true;
                    textField.setEnabled(false);
                    label.setEnabled(false);
                }
            });

        label.setEnabled(false);
        textField.setEnabled(false);

        //create split in grid radio
        JRadioButton splitInGridRadio = new JRadioButton("Split In Simple Grid");
        splitInGridRadio.setName("SplitInGridRadio");

        //add listener to this radio, if it's selected,  fitSinglePage will be set to false
        splitInGridRadio.addActionListener(new ActionListener() {
                //set config and appearance to scale print mode
                public void actionPerformed(ActionEvent event) {
                    fitSinglePage = false;
                    textField.getInputVerifier().verify(textField);
                    textField.setEnabled(true);
                    label.setEnabled(true);
                }
            });

        ButtonGroup group = new ButtonGroup();
        group.add(fitInPageRadio);
        group.add(splitInGridRadio);

        //create choice panel
        JPanel printChoicePanel = new JPanel();
        printChoicePanel.setLayout(new FlowLayout());
        printChoicePanel.add(fitInPageRadio);
        printChoicePanel.add(splitInGridRadio);
        printChoicePanel.add(factorPanel);

        return printChoicePanel;
    }

    /**
     * Create a OK button.
     *
     * @return JButton
     */
    private JButton createOkButton() {
        JButton okButton = new JButton("OK");
        okButton.setName("OkButton");

        //add listener to the button, to make confirm of the input validation and close the dialog
        okButton.addActionListener(new ActionListener() {
                //confirm the input and close the dialog
                public void actionPerformed(ActionEvent event) {
                    if (!fitSinglePage && !isInputValid) {
                        return;
                    }
                    //if input is valid, close this dialog
                    isPrintFormatSet = true;
                    setVisible(false);
                }
            });

        return okButton;
    }

    /**
     * Initializes the dialog.
     */
    private void initDialog() {
        this.setLayout(new FlowLayout());

        this.add(createPageFormatButton());

        this.add(createPrintChoicePanel());

        this.add(createOkButton());

        this.pack();
    }
}
