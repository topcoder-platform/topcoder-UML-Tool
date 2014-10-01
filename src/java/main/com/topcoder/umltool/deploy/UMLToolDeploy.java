/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import java.io.File;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;

import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import com.topcoder.umltool.deploy.actions.ExportAllDiagramsAction;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;
import com.topcoder.macosx.MacOSXAdapter;

/**
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class UMLToolDeploy {
    public static final Log logger = LogFactory.getLog("UMLToolDeploy");

    // Check that we are on Mac OS X. This is crucial to loading and using the MacOSXAdapter class.
    public static boolean MAC_OS_X = (System.getProperty("os.name").toLowerCase().startsWith("mac os x"));

    /**
     * Private constructor.
     */
    private UMLToolDeploy() {
    }

    /**
     * TC UML Tool's starting point.
     *
     * @param args
     *            command line arguments
     */
    public static void main(final String[] args) {
        UncaughtExceptionHandler handler = new LoggingThreadGroup("Logger");
        Thread.setDefaultUncaughtExceptionHandler(handler);

        System.setProperty("apple.laf.useScreenMenuBar", "true");

        // The setting of the look and feel should be placed into the scripts,
        // allowing the user to specify the look and feel
        // String lookAndFeel = null;
        // String vers = System.getProperty("os.name").toLowerCase();
        // if (vers.indexOf("mac") != -1) {
        // lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        // } else {
        // lookAndFeel = UIManager.getCrossPlatformLookAndFeelClassName();
        // }
        //
        // try {
        // UIManager.setLookAndFeel(lookAndFeel);
        // } catch (Exception e) {
        // DeployHelper.logException(e);
        // }

        System.setProperty("swing.aatext", "true");
        try {

            if (MAC_OS_X) {
                UIManager.setLookAndFeel("com.topcoder.umltool.deploy.UMLToolMacLookAndFeel");
            } else {
                UIManager.setLookAndFeel("com.topcoder.umltool.deploy.UMLToolLookAndFeel");
            }
        } catch (Exception e) {
            DeployHelper.logException(e);
        }
        // Change font size
        try {
            int fontSize = Integer.parseInt(DeployHelper.getProperty("com.topcoder.umltool.deploy", "FontSize"));
            UIDefaults defaults = UIManager.getDefaults();
            java.util.Enumeration<Object> keys = defaults.keys();

            while (keys.hasMoreElements()) {
                Object key = keys.nextElement();
                Object value = UIManager.get(key);

                if (value instanceof FontUIResource) {
                    FontUIResource oldFont = (FontUIResource) value;
                    FontUIResource newFont = new FontUIResource(oldFont.getName(), oldFont.getStyle(), fontSize);
                    UIManager.put(key, newFont);
                }
            }

        } catch (Exception e2) {
            DeployHelper.logException(e2);
        }
        /*
         * BUGR-107 The addition of the checking for options part. Untill now, we have one option "-convert" to
         * convert from.zuml file to.tcuml file or open a specified file.
         */
        if (args.length > 0) {
            if (args[0].equals("-convert")) {
                try {

                    MainFrame mainFrame = new MainFrame();
                    File oldFile = new File(args[1]);
                    mainFrame.loadProject(oldFile, MainFrame.OPEN_PROJECT_ZUML);
                    File newFile = new File(args[2]);
                    // we have to create if it is not created
                    newFile.createNewFile();
                    mainFrame.saveDataInFile(newFile, null);
                    return;
                } catch (IOException ioe) {
                    return;
                } catch (DeployConfigException e1) {
                    DeployHelper.logException(e1);
                }
            } else if (args[0].equals("-exportImages")) {
                try {
                    if (args.length < 3) {
                        System.out
                            .println("Usage: UMLToolDeploy -exportImages [zuml/tcumlFile path] [target directory]");
                    }

                    MainFrame mainFrame = new MainFrame();
                    File oldFile = new File(args[1]);

                    if (!oldFile.exists()) {
                        System.out.println("The given input file, for image export, does not exist");
                        return;
                    }
                    if (oldFile.isDirectory()) {
                        System.out.println("The given input path must not be a directory");
                        return;
                    }

                    String ext = oldFile.getName().substring(oldFile.getName().lastIndexOf('.') + 1);
                    if (ext.equals("tcuml")) {
                        mainFrame.loadProject(oldFile, MainFrame.OPEN_PROJECT_TCUML);
                    } else if (ext.equals("zuml")) {
                        mainFrame.loadProject(oldFile, MainFrame.OPEN_PROJECT_ZUML);
                    } else {
                        System.out.println("The given input file is of an unrecognized type");
                        return;
                    }
                    File newFile = new File(args[2]);
                    // we have to create if it is not created
                    newFile.mkdir();

                    ExportAllDiagramsAction exportAllDiagramsAction = new ExportAllDiagramsAction(mainFrame);
                    exportAllDiagramsAction.exportAllImages("gif", args[2], true);
                    return;
                } catch (DeployConfigException e1) {
                    DeployHelper.logException(e1);
                }
            }
        }

        showMainFrame(args, new SplashScreen());
    }

    /**
     * Shows the main frame. It could be terms and conditions frame of the actual main frame.
     * @param args the command line arguments.
     * @param splashScreen the splash screen if it needs to be shown first.
     */
    public static void showMainFrame(final String[] args, final SplashScreen splashScreen) {
        if (splashScreen != null) {
            // To be replaced with a custom class loader.
            splashScreen.setVisible(true);
    
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                DeployHelper.logException(e);
            }
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                String fileToLoad = null;
                JFrame mainFrame = null;
                boolean tacAccepted = Boolean.parseBoolean(DeployHelper.getProperty("com.topcoder.umltool.deploy",
                    "TermsAndConditionsAccepted", "false"));
                if (args.length > 0) {
                    fileToLoad = args[0];
                }
                try {
                    if (tacAccepted) {
                        mainFrame = new MainFrame();
                    } else {
                        mainFrame = new TermsAndConditionsFrame(args);
                    }
                    try {
                        int width =
                            Integer.parseInt(DeployHelper.getProperty("com.topcoder.umltool.deploy", "Width"));
                        int height =
                            Integer.parseInt(DeployHelper.getProperty("com.topcoder.umltool.deploy", "Height"));
                        mainFrame.setSize(width, height);
                    } catch (Exception e) {
                        mainFrame.setSize(mainFrame.getMaximumSize());
                    }
                } catch (DeployConfigException e1) {
                    DeployHelper.logException(e1);
                    splashScreen.close();
                    ChooseConfigDialog dialog = new ChooseConfigDialog();
                    dialog.setVisible(true);
                    return;
                }
                // register Mac OS X specific event handlers; this is done here rather than inside MainFrame
                // as the appropriate menu item is added by os automatically; thus no changes to add extra
                // menu items in MainFrame are necessary; also handling Mac OS X events is done a bit
                // differently (not through Actions) - MacOSXAdapter uses reflections to avoid directly
                // referencing OS X specific API; this makes it possible to build on any plaform
                if (MAC_OS_X) {
                    // registration with the Mac OS X application menu; checks the platform, then attempts to
                    // register with the Apple EAWT; it is done through reflections without directly
                    // referencing any Apple APIs
                    try {
                        // register quit handler for handling the cmd+q and "TopCoder UML Tool -> Quit"
                        MacOSXAdapter.setQuitHandler(mainFrame, mainFrame.getClass().getDeclaredMethod("quit",
                            (Class[]) null));
                        // register the file handler for opening files double-clicked in finder or drag and dropped
                        // onto the application icon
                        if (tacAccepted) {
                            MacOSXAdapter.setFileHandler(mainFrame, mainFrame.getClass().getDeclaredMethod(
                                "loadProject", new Class[] {String.class}));
                        }
                    } catch (Exception e) {
                        DeployHelper.logException(new DeployConfigException(
                            "Error while loading the MacOSXAdapter", e));
                    }

                    // change keyboard action keybindings to be more Mac OS X like
                    if (System.getProperty("os.name").toLowerCase().startsWith("mac os x")) {
                        com.topcoder.macosx.MacInputMap.setDefaultInputMap(javax.swing.UIManager.getDefaults());
                    }
                }
                if (fileToLoad != null) {
                    // load
                    File file = new File(fileToLoad);
                    String extension = DeployHelper.getExtension(file);

                    int openType = MainFrame.OPEN_PROJECT_TCUML;
                    if ("tcuml".equals(extension)) {
                        openType = MainFrame.OPEN_PROJECT_TCUML;
                    } else if ("zuml".equals(extension)) {
                        openType = MainFrame.OPEN_PROJECT_ZUML;
                    } else if ("xmi".equals(extension)) {
                        openType = MainFrame.OPEN_PROJECT_XMI_TC;
                    }
                    if (tacAccepted) {
                        ((MainFrame) mainFrame).loadProject(file, openType);
                    }
                }

                mainFrame.setVisible(true);
                
                if (splashScreen != null) {
                    splashScreen.close();
                }
            }
        });
    }
}
