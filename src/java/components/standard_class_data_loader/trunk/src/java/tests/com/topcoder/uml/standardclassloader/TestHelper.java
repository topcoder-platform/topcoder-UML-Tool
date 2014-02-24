/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.standardclassloader;

import java.io.File;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * A helper class to perform those common operations which are helpful for the test.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestHelper {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private TestHelper() {
    }

    /**
     * <p>
     * Use the given file to config the configuration manager.
     * </p>
     *
     * @param fileName config file to set up environment
     *
     * @throws Exception when any exception occurs
     */
    public static void loadXMLConfig(String fileName) throws Exception {
        clearConfig();

        //set up environment
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(fileName);

        config.add(file.getCanonicalPath());
    }

    /**
     * <p>
     * Clear all the namespaces from the configuration manager.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public static void clearConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator i = cm.getAllNamespaces(); i.hasNext();) {
            cm.removeNamespace((String) i.next());
        }
    }

    /**
     * <p>
     * Parsing the given xml file and returns a DOM Document using DOM Parser.
     * </p>
     *
     * @param xmlFile the given xml file to parse
     * @return the root Element which represents the given xml file
     *
     * @throws Exception when fails to parsing the given xml file
     */
    public static Element parseDOMDocument(String xmlFile) throws Exception {
        // Parse the stream using DOM API
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(false);

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            // parse the stream
            return builder.parse(new File(xmlFile)).getDocumentElement();
        } catch (ParserConfigurationException e) {
            throw new ClassDataLoaderConfigurationException(
                "ParserConfigurationException occurs when parsing stream using DOM.", e);
        } catch (SAXException e) {
            throw new ClassDataLoaderConfigurationException("SAXException occurs when parsing stream using DOM.", e);
        }
    }
}
