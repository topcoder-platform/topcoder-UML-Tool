package com.topcoder.uml.projectconfiguration.accuracytests;

import com.topcoder.util.config.ConfigManager;

import java.io.File;
import java.util.Iterator;

/**
 *
 * Contains methods used as utilities for the Accuracy tests
 */
public class Helper {

    /**
     * Loads a config file to ConfigManager.
     *
     * @param file the file to load
     * @throws Exception
     */
    public static void loadConfigFile(String file) throws Exception {
        clearConfig();
        ConfigManager.getInstance().add(new File("test_files/" + file).getAbsolutePath());
    }

    /**
     * Clears all the configuration namespaces
     *
     * @throws Exception exception to the caller.
     */
    public static void clearConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        Iterator it = cm.getAllNamespaces();
        while (it.hasNext()) {
            String s = (String) it.next();
            cm.removeNamespace(s);
        }
    }
}
