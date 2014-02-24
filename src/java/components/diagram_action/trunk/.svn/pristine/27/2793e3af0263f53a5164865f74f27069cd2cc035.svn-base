/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.stresstests;

import java.util.Iterator;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.util.config.ConfigManager;


/**
 * <p>Helper class to simplify the stress testing.</p>
 *
 * @author zmg
 * @version 1.0
 */
final class StressTestHelper {
/**
     * <p>
     * The private constructor to avoid creating instance of this class.
     * </p>
     */
    private StressTestHelper() {
    }

    /**
     * <p>Clear all namespaces in ConfigManager.</p>
     *
     * @throws Exception if configuration could not be clear.
     */
    public static void clearNamespace() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator it = cm.getAllNamespaces();

        while (it.hasNext()) {
            cm.removeNamespace((String) it.next());
        }
    }

//    /**
//     * <p>Find the value of type property in diagram.</p>
//     *
//     * @param diagram the diagram to find type property.
//     *
//     * @return the value of tyep property.
//     */
//    public static String findTypePropertyValue(Diagram diagram) {
//        Collection<Property> properties = diagram.getProperties();
//
//        // find the type diagram here.
//        for (Property property : properties) {
//            if (property.getKey().equals("typeInfo")) {
//                return property.getValue();
//            }
//        }
//
//        return null;
//    }

    /**
     * <p>Find the value of type property in diagram.</p>
     *
     * @param diagram the diagram to find type property.
     *
     * @return the value of tyep property.
     */
    public static String getTypeInfo(Diagram diagram) {
        SimpleSemanticModelElement seamanticModel =
            (SimpleSemanticModelElement) diagram.getSemanticModel();
        return seamanticModel.getTypeInfo();
    }
}
