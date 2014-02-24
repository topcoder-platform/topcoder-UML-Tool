package com.topcoder.gui.panels.style.accuracytests;

import java.io.File;
import java.util.Iterator;

import com.topcoder.diagraminterchange.Property;
import com.topcoder.util.config.ConfigManager;

public final class TestHelper {
    public static Property createProp(String key, String value) {
        Property prop = new Property();
        prop.setKey(key);
        prop.setValue(value);
        return prop;
    }

    public static final String CONFIG_FILE = "test_files/accuracy/config.xml";

    public static final String NAMESPACE = "com.topcoder.gui.panels.style";

    /**
     * Load a config file to ConfigManager.
     * 
     * @throws Exception
     *             exception to the caller.
     */
    public static void loadSingleConfigFile() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator it = cm.getAllNamespaces();

        while (it.hasNext()) {
            cm.removeNamespace((String) it.next());
        }

        File f = new File(CONFIG_FILE);
        String pth = f.getCanonicalPath();

        cm.add(pth);
    }
}
