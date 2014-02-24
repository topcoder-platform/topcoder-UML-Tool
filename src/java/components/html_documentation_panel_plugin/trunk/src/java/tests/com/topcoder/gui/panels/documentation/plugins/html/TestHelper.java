/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * TestHelper.java
 */
package com.topcoder.gui.panels.documentation.plugins.html;

import com.topcoder.configuration.ConfigurationAccessException;
import com.topcoder.configuration.ConfigurationObject;
import com.topcoder.configuration.persistence.ConfigurationFileManager;
import com.topcoder.configuration.persistence.ConfigurationParserException;
import com.topcoder.configuration.persistence.NamespaceConflictException;
import com.topcoder.configuration.persistence.UnrecognizedFileTypeException;
import com.topcoder.configuration.persistence.UnrecognizedNamespaceException;

import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;
import com.topcoder.gui.panels.documentation.plugins.html.toolbars.DefaultHTMLDocumentationEditorToolBar;

import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import java.awt.Component;

import java.io.IOException;


/**
 * <p>Provide some utilities methods for unit tests.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public final class TestHelper {
    /**
     * <p>Default namespace for configuration file.</p>
     */
    public static final String DEFAULT_NS = "html_documentation_editor";

/**
     * <p>Private constructor.</p>
     */
    private TestHelper() {
    }

    /**
     * <p>Get the configuration object with the given namespace.</p>
     *
     * @param namespace the namespace
     *
     * @return the configuration object
     */
    public static ConfigurationObject getConfig(String namespace) {
        ConfigurationObject config = null;

        try {
            ConfigurationFileManager configManager = new ConfigurationFileManager();
            config = configManager.getConfiguration(namespace);
        } catch (ConfigurationParserException e) {
            //ignore
        } catch (UnrecognizedFileTypeException e) {
            //ignore
        } catch (NamespaceConflictException e) {
            //ignore
        } catch (IOException e) {
            //ignore
        } catch (UnrecognizedNamespaceException e) {
            //ignore
        }

        return config;
    }

    /**
     * <p>Get the default configuration object with the given namespace.</p>
     *
     * @param namespace the namespace
     *
     * @return the default configuration object
     */
    public static ConfigurationObject getDefaultConfig(String namespace) {
        ConfigurationObject config = null;

        try {
            config = getConfig(namespace);
            config = config.getChild("default");
        } catch (ConfigurationAccessException e) {
            //ignore
        }

        return config;
    }

    /**
     * <p>Get the toolBar configuration object with the given namespace.</p>
     *
     * @param namespace the namespace
     *
     * @return the toolBar configuration object
     */
    public static ConfigurationObject getToolBarConfig(String namespace) {
        ConfigurationObject config = null;

        try {
            config = getConfig(namespace);
            config = config.getChild("toolBarConfig");
        } catch (ConfigurationAccessException e) {
            //ignore
        }

        return config;
    }

    /**
     * <p>Generate HTML document editor.</p>
     *
     * @param namespace the namespace
     *
     * @return editor
     */
    public static HTMLDocumentationEditor genEditor(String namespace) {
        HTMLDocumentationEditor editor = null;

        try {
            editor = new HTMLDocumentationEditor(namespace);
        } catch (HTMLDocumentationEditorException e) {
            //ignore
        } catch (DocumentationPanelConfigurationException e) {
            //ignore
        }

        return editor;
    }

    /**
     * <p>Generate HTML document editor toolBar.</p>
     *
     * @param namespace the namespace
     *
     * @return toolBar
     */
    public static HTMLDocumentationEditorToolBar genToolBar(String namespace) {
        ConfigurationObject config = getToolBarConfig(namespace);
        HTMLDocumentationEditor editor = genEditor(namespace);
        DefaultHTMLDocumentationEditorToolBar toolBar = null;

        try {
            toolBar = new DefaultHTMLDocumentationEditorToolBar(config, editor);
        } catch (HTMLDocumentationEditorException e) {
            //ignore
        }

        return toolBar;
    }

    /**
     * <p>Generate model element.</p>
     *
     * @return model element
     */
    public static ModelElement genModelElement() {
        ModelElement modelElement = new AttributeImpl();

        TaggedValue tv = new TaggedValueImpl();
        TagDefinition tg = new TagDefinitionImpl();
        tv.setType(tg);
        modelElement.addTaggedValue(tv);

        return modelElement;
    }

    /**
     * <p>Generate model element without tagged value.</p>
     *
     * @return model element
     */
    public static ModelElement genModelElementWithoutTaggedValue() {
        ModelElement modelElement = new AttributeImpl();

        return modelElement;
    }

    /**
     * <p>Returns if the Component array contains the component object passed in.</p>
     *
     * @param components the Component array
     * @param component which is to be checked whether it is in the array
     *
     * @return boolean whether the component is in the array
     */
    public static boolean containComponent(Component[] components, Component component) {
        boolean ret = false;

        for (Component c : components) {
            if (c.equals(component)) {
                ret = true;

                break;
            }
        }

        return ret;
    }
}
