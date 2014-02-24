/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.verticallabel.accuracytests;

import com.topcoder.gui.verticallabel.JVerticalLabel;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import junit.framework.TestCase;

/**
 * <p>
 * This is functional accuracy tests by comparing the output displayed by the submitter's code
 * and the standard output displayed image which are prepared before.
 * </p>
 *
 * <b>NOTE</b>: This All the test cases in this class are tested by human's judging by comparing two
 * image's layout is similar or not.
 *
 * @author Littleken
 * @version 1.0
 */
public class FunctionalAccuracyTests extends TestCase {

    /**
     * <p>
     * Represents the path of logo image which is will be loaded in testing running for accuracy
     * functional tests.
     * </p>
     */
    private static final String IMAGE_PATH = "test_files/accuracy/logo.PNG";

    /**
     * <p>
     * Represents the path prefix of answer images used for comparing the output of user's programme
     * for accuracy functional tests.
     * </p>
     */
    private static final String ANS_IMAGE_PATH_PREFIX = "test_files/accuracy/";

    /**
     * <p>
     * Represents the JFrame width used for accuracy functional tests.
     * </p>
     */
    private static final int WIDTH = 150;

    /**
     * <p>
     * Represents the JFrame height used for accuracy functional tests.
     * </p>
     */
    private static final int HEIGHT = 500;

    /**
     * <p>
     * Represents the sleep time for displaying the answers.
     * </p>
     */
    private static final int SLEEPT_TIME = 1500;

    /**
     * <p>
     * Represents the text to be shown for displaying the answers.
     * </p>
     */
    private static final String TEXT = "Accuracy test by Littleken";

    /**
     * <p>
     * Represents the <code>JLabel</code> instance used for representing the correct output
     * display for accuracy functional Tests.
     * </p>
     */
    private JLabel standarLabel;

    /**
     * <p>
     * Represents the <code>JFrame</code> instance used for accuracy functional Tests.
     * </p>
     */
    private JFrame frame;

    /**
     * <p>
     * Setup the testing environment.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();

        standarLabel = new JLabel();

        frame = new JFrame("user VS standard");
    }

    /**
     * <p>
     * Tear down the testing environment.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        standarLabel = null;

        frame.dispose();
        frame = null;
    }

    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay1() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.LEFT, false);
        label.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        label.setVerticalAlignment(SwingConstants.TOP);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo1.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }


    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay2() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.RIGHT, false);
        label.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        label.setVerticalAlignment(SwingConstants.TOP);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo2.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }

    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay3() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.LEFT, true);
        label.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        label.setVerticalAlignment(SwingConstants.TOP);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo3.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }

    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay4() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.LEFT, false);
        label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        label.setVerticalAlignment(SwingConstants.TOP);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo4.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }

    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay5() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.LEFT, false);
        label.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        label.setVerticalAlignment(SwingConstants.BOTTOM);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo5.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }

    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay6() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.LEFT, false);
        label.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        label.setVerticalAlignment(SwingConstants.CENTER);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo6.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }

    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay7() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.LEFT, false);
        label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        label.setVerticalAlignment(SwingConstants.CENTER);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo7.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }

    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay8() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.LEFT, true);
        label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        label.setVerticalAlignment(SwingConstants.CENTER);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo8.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }

    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay9() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.RIGHT, true);
        label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        label.setVerticalAlignment(SwingConstants.CENTER);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo9.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }

    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay10() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.LEFT, true);
        label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        label.setVerticalAlignment(SwingConstants.BOTTOM);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo10.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }

    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay11() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.LEFT, false);
        label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        label.setVerticalAlignment(SwingConstants.BOTTOM);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo11.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }

    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay12() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.LEFT);
        label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        label.setVerticalAlignment(SwingConstants.BOTTOM);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo11.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }

    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay13() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.RIGHT);
        label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        label.setVerticalAlignment(SwingConstants.BOTTOM);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo13.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }

    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay14() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.RIGHT);
        label.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        label.setVerticalAlignment(SwingConstants.BOTTOM);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo14.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }

    /**
     * <p>
     * Testing the functional by comparing the output of user's demo and the standard's output
     * manually.
     * </p>
     *
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testDemoDisplay15() throws Exception {
        ImageIcon icon = new ImageIcon(IMAGE_PATH);

        JPanel panel = new JPanel(new GridLayout(1, 2));

        JVerticalLabel label = new JVerticalLabel(TEXT, icon, SwingConstants.RIGHT);
        label.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        label.setVerticalAlignment(SwingConstants.TOP);

        label.setOpaque(true);
        label.setForeground(Color.BLUE);
        label.setBorder(new EtchedBorder());

        ImageIcon icon2 = new ImageIcon(ANS_IMAGE_PATH_PREFIX + "demo15.png");
        standarLabel.setIcon(icon2);

        panel.add(label);
        panel.add(standarLabel);

        panel.setSize(WIDTH << 1, HEIGHT);

        panel.setVisible(true);

        answerDisplay(panel);
    }

    /**
     * <p>
     * Display the frame with two label, the left one is the output for user and the right one is
     * standard output according to design.
     * </p>
     *
     * @param label
     *            the label
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    private void answerDisplay(JPanel panel) throws Exception {

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH << 1, HEIGHT);
        frame.setVisible(true);

        Thread.sleep(SLEEPT_TIME);
    }
}
