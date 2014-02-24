/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.Assert;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.ConfigManagerException;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * Helper class to simplify the test process.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class UnitTestHelper {
    /**
     * <p>
     * Represents the configuration file.
     * </p>
     */
    public static final String CONFIG_FILE = "test_files/Configuration.xml";
    /**
     * <p>
     * Private constructor to avoid creation.
     * </p>
     */
    private UnitTestHelper() {
    }

    /**
     * <p>
     * Load the given configuration file into the Configuration Manager.
     * </p>
     * @param file
     *            configuration file
     */
    public static void loadConfig(String file) {
        try {
            ConfigManager.getInstance().add(new File(file).getAbsolutePath());
        } catch (ConfigManagerException e) {
            // ignore
        }
    }

    /**
     * <p>
     * Clear all namespaces in the Configuration Manager.
     * </p>
     */
    public static void clearConfig() {
        ConfigManager mgr = ConfigManager.getInstance();
        Iterator itr = mgr.getAllNamespaces();
        while (itr.hasNext()) {
            String ns = (String) itr.next();
            try {
                mgr.removeNamespace(ns);
            } catch (UnknownNamespaceException e) {
                // ignore
            }
        }
    }
    /**
     * <p>
     * Assert two comments are equal.
     * </p>
     * @param expected the expected
     * @param actual the actual
     * @param message the message
     */
    public static void assertEquals(Comment expected, Comment actual, String message) {
        assertEquals((ModelElement) expected, (ModelElement) actual, message);
        Assert.assertEquals(message, expected.getBody(), actual.getBody());
    }
    /**
     * <p>
     * Assert two ModelElements are equal.
     * </p>
     * @param expected the expected
     * @param actual the actual
     * @param message the message
     */
    public static void assertEquals(ModelElement expected, ModelElement actual, String message) {
        Assert.assertEquals(message, expected.getName(), actual.getName());
        assertEquals(expected.getDefaultParameters(), actual.getDefaultParameters(), message);
        assertEquals(expected.getElementImports(), actual.getElementImports(), message);
        assertEquals(expected.getStereotypes(), actual.getStereotypes(), message);
        assertEquals(expected.getTemplateArguments(), actual.getTemplateArguments(), message);
        assertEquals(expected.getTemplateParameters(), actual.getTemplateParameters(), message);
        Assert.assertEquals(message, expected.getVisibility(), actual.getVisibility());
        Assert.assertEquals(message, expected.isSpecification(), actual.isSpecification());
        Assert.assertEquals(message, expected.getNamespace(), actual.getNamespace());
    }
    /**
     * <p>
     * Assert two Collections are equal.
     * </p>
     * @param expected the expected
     * @param actual the actual
     * @param message the message
     */
    public static void assertEquals(Collection<?> expected, Collection<?> actual, String message) {
        Assert.assertEquals(message, expected.size(), actual.size());
        for (Object o : expected) {
            Assert.assertTrue(actual.contains(o));
        }
    }
    /**
     * <p>
     * Assert two GraphNodes are equal.
     * </p>
     * @param expected the expected
     * @param actual the actual
     * @param message the message
     */
    public static void assertEquals(GraphNode expected, GraphNode actual, String message) {
        assertEquals((GraphElement) expected, (GraphElement) actual, message);
        Assert.assertEquals(message, expected.getSize(), actual.getSize());
    }
    /**
     * <p>
     * Assert two GraphEdges are equal.
     * </p>
     * @param expected the expected
     * @param actual the actual
     * @param message the message
     */
    public static void assertEquals(GraphEdge expected, GraphEdge actual, String message) {
        assertEquals((GraphElement) expected, (GraphElement) actual, message);
        assertEquals(expected.getAnchors(), actual.getAnchors(), message);
        assertEquals(expected.getWaypoints(), actual.getWaypoints(), message);
    }
    /**
     * <p>
     * Assert two GraphElements are equal.
     * </p>
     * @param expected the expected
     * @param actual the actual
     * @param message the message
     */
    public static void assertEquals(GraphElement expected, GraphElement actual, String message) {
        if (expected == null) {
            Assert.assertNull(message, actual);
        } else {
            assertEquals(expected.getAnchorages(), actual.getAnchorages(), message);
            assertEquals(expected.getContaineds(), actual.getContaineds(), message);
            assertEquals(expected.getLinks(), actual.getLinks(), message);
            assertEquals(expected.getProperties(), actual.getProperties(), message);
            assertEquals(expected.getReferences(), actual.getReferences(), message);
            Assert.assertEquals(message, expected.getPosition(), actual.getPosition());
            Assert.assertEquals(message, expected.getSemanticModel(), actual.getSemanticModel());
            Assert.assertEquals(message, expected.isVisible(), actual.isVisible());
        }
    }
}
