/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model.accuracytests;

import java.lang.reflect.Field;
import java.util.Iterator;

import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.util.config.ConfigManager;

/**
 * Helper class used for providing utility method for the tests.
 * 
 * @author catcher
 * @version 1.0
 */
public final class TestsHelper {

    /**
     * the config file ot the GameOperationLogicUtility
     */
    public static final String GameOperationLogicUtility = "stress/GameOperationLogicUtility.xml";

    /**
     * This is a utility class, so it shouldn't be instantiated.
     */
    private TestsHelper() {
    }

    /**
     * Method that removes all namespaces from ConfigManager component.
     * 
     * @throws Exception
     *         propagated to JUnit
     */
    public static void removeAllCMNamespaces() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator it = cm.getAllNamespaces();
        while (it.hasNext()) {
            cm.removeNamespace(it.next().toString());
        }
    }
    
    /**
     * Gets the value of a private field in the given class. The field has the given name. The value is retrieved from
     * the given instance. If the instance is null, the field is a static field. If any error occurs, null is returned.
     *
     * @param type
     *            the class which the private field belongs to
     * @param instance
     *            the instance which the private field belongs to
     * @param name
     *            the name of the private field to be retrieved
     * @return the value of the private field
     */
    public static Object getPrivateField(Class type, Object instance, String name) {
        Field field = null;
        Object obj = null;
        try {
            // get the reflection of the field
            field = type.getDeclaredField(name);

            // set the field accessible.
            field.setAccessible(true);

            // get the value
            obj = field.get(instance);
        } catch (NoSuchFieldException e) {
            // ignore
        } catch (IllegalAccessException e) {
            // ignore
        } finally {
            if (field != null) {
                // reset the accessibility
                field.setAccessible(false);
            }
        }
        return obj;
    }
    
    /**
     * <p>
     * Create a simple <code>Model</code> instance used for testing.
     * This model consist of a single package.
     * </p>
     *
     * @return the created <tt>Model</tt> instance
     */
    public static Model createSimpleModelInstance() {
        //create a Package element
        Package aPackage = new PackageImpl();
        aPackage.setName("accuracyPakage");
        aPackage.setVisibility(VisibilityKind.PUBLIC);
        aPackage.setSpecification(false);
        aPackage.setRoot(false);
        aPackage.setLeaf(false);
        aPackage.setAbstract(false);

        //create a simple Model element
        Model model = new ModelImpl();
        model.setName("accuracyModel");
        model.setSpecification(false);
        model.setRoot(false);
        model.setLeaf(false);
        model.setAbstract(false);
        model.addOwnedElement(aPackage);

        return model;
    }
}
