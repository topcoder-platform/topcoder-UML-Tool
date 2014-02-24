/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.accuracytests;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.InitialDiagramElementFormatter;
import com.topcoder.uml.projectconfiguration.InitialElementFormatter;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.uml.projectconfiguration.StandardStereotypeLoader;
import com.topcoder.uml.standardclassloader.StandardClassDataLoader;

/**
 * This class extends ProjectConfigurationManager and acts as a mock class.
 *
 * @author ch_music
 * @version 1.0
 */
public final class MockProjectConfigurationManager extends ProjectConfigurationManager {

    /**
     * An indicator whether applyInitialFormatting has been called with proper parameters.
     */
    private boolean initialFormatted = false;

    /**
     * <p>
     * Constructs an instance of this class
     * </p>
     *
     * @param umlModelManager the UML Model Manager instance
     * @throws IllegalArgumentException if umlModelManager is null
     */
    public MockProjectConfigurationManager(UMLModelManager umlModelManager) {
        super(umlModelManager, new MockStandardClassDataLoader(), new MockStandardStereotypeLoader(),
                "com.topcoder.uml.actions.model.activity.accuracytests");
    }

    /**
     * <p>
     * Indicates whether applyInitialFormatting was called with proper parameters.
     * </p>
     *
     * @return true if applyInitialFormatting was called, false otherwise
     */
    public boolean wasInitialFormatted() {
        return initialFormatted;
    }

    /**
     * <p>
     * Retrieves the standard stereotypes for an element type according to the language.
     * </p>
     * <p>
     * NOTE: This implementation returns an empty List<Stereotype>.
     * </p>
     *
     * @param language the language
     * @param elementType the type of the element
     * @return an empty List<Stereotype>
     * @throws IllegalArgumentException if any argument is null or empty
     * @throws ProjectConfigurationException if any other exception occurs
     */
    public List<Stereotype> getStandardStereotypes(String language, String elementType)
        throws ProjectConfigurationException {
        return new ArrayList<Stereotype>();
    }

    /**
     * <p>
     * Retrieves the standard namespaces according to the language.
     * </p>
     * <p>
     * NOTE: This implementation returns an empty List<Namespace>.
     * </p>
     *
     * @param language the language
     * @return an empty List<Namespace>
     * @throws IllegalArgumentException if the argument is null or empty
     */
    public List<Namespace> getStandardNamespaces(String language) {
        return new ArrayList<Namespace>();
    }

    /**
     * <p>
     * Apply initial formatting to a model element according to the language.
     * </p>
     * <p>
     * NOTE: This implementation does nothing to the element and always return true.
     * </p>
     *
     * @param language the language
     * @param element the element to be formatted
     * @return true if the passed object was modified, otherwise false (this implementation always returns true)
     * @throws IllegalArgumentException if any argument is null or the language is empty
     * @throws ProjectConfigurationException if it is thrown by the formatter
     */
    public boolean applyInitialFormatting(String language, ModelElement element)
        throws ProjectConfigurationException {
        if ("Java".equals(language) && element != null) {
            initialFormatted = true;
        }
        return true;
    }

    /**
     * <p>
     * Apply initial formatting to a diagram element according to the language.
     * </p>
     * <p>
     * NOTE: This implementation does nothing to the element and always return true.
     * </p>
     *
     * @param language the language
     * @param element the element to be formatted
     * @return true if the passed in object was modified, otherwise false (this implementation always returns true)
     * @throws IllegalArgumentException if any argument is null or the language is empty
     * @throws ProjectConfigurationException if it is thrown by the formatter
     */
    public boolean applyInitialFormatting(String language, DiagramElement element)
        throws ProjectConfigurationException {
        return true;
    }

    /**
     * <p>
     * Get the default project language.
     * </p>
     * <p>
     * NOTE: This implementation always returns "Java".
     * </p>
     *
     * @return the project language (always "Java" for this implementation)
     * @throws ProjectConfigurationException if exception occurs trying to get the default project language from
     *             the configuration file
     */
    public String getDefaultProjectLanguage() throws ProjectConfigurationException {
        return "Java";
    }

    /**
     * <p>
     * Registers the initial element formatter for the language.
     * </p>
     * <p>
     * NOTE: This implementation does nothing.
     * </p>
     *
     * @param language the language of the formatter
     * @param formatter the formatter
     * @throws IllegalArgumentException if any argument is null or the language is empty
     */
    public void addInitialElementFormatter(String language, InitialElementFormatter formatter) {
        // do nothing.
    }

    /**
     * <p>
     * Registers the initial diagram formatter for the language.
     * </p>
     * <p>
     * NOTE: This implementation does nothing.
     * </p>
     *
     * @param language the language of the formatter
     * @param formatter the formatter
     * @throws IllegalArgumentException if any argument is null or the language is empty
     */
    public void addInitialDiagramFormatter(String language, InitialDiagramElementFormatter formatter) {
        // do nothing.
    }

    /**
     * <p>
     * Unregisters the initial diagram formatter for the language.
     * </p>
     * <p>
     * NOTE: This implementation does nothing.
     * </p>
     *
     * @param language the language of the formatter
     * @param formatter the formatter
     * @throws IllegalArgumentException if any argument is null or the language is empty
     */
    public void removeInitialDiagramFormatter(String language, InitialDiagramElementFormatter formatter) {
        // do nothing.
    }

    /**
     * <p>
     * Unregisters the initial element formatter for the language.
     * </p>
     * <p>
     * NOTE: This implementation does nothing.
     * </p>
     *
     * @param language the language of the formatter
     * @param formatter the formatter
     * @throws IllegalArgumentException if any argument is null or the language is empty
     */
    public void removeInitialElementFormatter(String language, InitialElementFormatter formatter) {
        // do nothing.
    }

    /**
     * A mock concrete implementation of StandardClassDataLoader interface.
     *
     * @author ch_music
     * @version 1.0
     */
    public static class MockStandardClassDataLoader implements StandardClassDataLoader {

        /**
         * <p>
         * Implements the getNamesspaces() method.
         * </p>
         * <p>
         * NOTE: This implementation always returns null.
         * </p>
         *
         * @param language the language
         * @return always null
         */
        public List<Namespace> getNamespaces(String language) {
            return null;
        }

        /**
         * <p>
         * Adds a namespace instance for the given language.
         * </p>
         * <p>
         * NOTE: This implementation does nothing.
         * </p>
         *
         * @param language the language
         * @param namespace the namespace
         * @throws IllegalArgumentException if language or namespace is null
         */
        public void addNamespace(String language, Namespace namespace) {
            // do nothing.
        }
    }

    /**
     * A mock implementation of StandardStereotypeLoader interface.
     *
     * @author ch_music
     * @version 1.0
     */
    public static class MockStandardStereotypeLoader implements StandardStereotypeLoader {
        /**
         * <p>
         * Retrieves the standard stereotypes for an element type according to the language.
         * </p>
         * <p>
         * NOTE: This implementation always returns null.
         * </p>
         *
         * @param language the language
         * @param elementType the type of the element
         * @return always null
         * @throws IllegalArgumentException if any argument is null, or empty
         * @throws ProjectConfigurationException if exception occurs trying to get the configuration
         */
        public List<Stereotype> getStereotypes(String language, String elementType)
            throws ProjectConfigurationException {
            return null;
        }
    }
}
