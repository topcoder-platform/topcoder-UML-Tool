/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.sectionlayout.accuracytests;

import com.topcoder.gui.sectionlayout.Section;
import com.topcoder.gui.sectionlayout.SectionHeader;
import com.topcoder.gui.sectionlayout.model.DefaultSectionModel;
import com.topcoder.gui.sectionlayout.model.SectionModel;
import com.topcoder.gui.sectionlayout.ui.DefaultSectionHeaderUI;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * GUI test for DefaultSectionHeaderUI.
 * 
 * <p>
 * This class can be running as an application.
 * </p>
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestDefaultSectionHeaderUI {
    /**
     * <p>
     * The DefaultSectionHeaderUI instance for helping testing.
     * </p>
     */
    private static DefaultSectionHeaderUI ui;

    /**
     * <p>
     * The SectionModel instance for helping testing.
     * </p>
     */
    private static SectionModel model;

    /**
     * <p>
     * The Section instance for helping testing.
     * </p>
     */
    private static Section section;

    /**
     * <p>
     * The SectionHeader instance for helping testing.
     * </p>
     */
    private static SectionHeader header;

    /**
     * The main entry.
     *
     * @param args the args.
     *
     * @throws Exception to console
     */
    public static void main(String[] args) throws Exception {
        AccUtil.configUIManager();

        ui = new DefaultSectionHeaderUI();
        model = new DefaultSectionModel();
        section = new Section(new JPanel());
        section.setDragInitListener(new MyDragInitListener());
        header = new SectionHeader(section, model);

        JFrame frame = new JFrame();

        ui.installUI(header);

        Dimension d = new Dimension(100, 1000);
        frame.getContentPane().add(header);
        frame.getContentPane().setSize(1000, 1000);
        frame.setName("test");

        frame.setSize(d);

        frame.setSize(1000, 1000);
        frame.setBounds(100, 100, 640, 480);
        frame.setLocation(new Point(100, 50));

        frame.pack();
        frame.setVisible(true);

        // hold on for 10 seconds.
        Thread.sleep(10000);

        frame.setVisible(false);
        frame.dispose();
    }
}
