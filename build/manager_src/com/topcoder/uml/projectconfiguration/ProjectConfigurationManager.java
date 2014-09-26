/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.modelmanager.UMLModelManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.standardclassloader.ClassDataLoaderConfigurationException;
import com.topcoder.uml.standardclassloader.StandardClassDataLoader;
import com.topcoder.uml.standardclassloader.UnknownLanguageException;
import com.topcoder.util.objectfactory.InvalidClassSpecificationException;
import com.topcoder.util.objectfactory.ObjectFactory;
import com.topcoder.util.objectfactory.impl.ConfigManagerSpecificationFactory;
import com.topcoder.util.objectfactory.impl.IllegalReferenceException;
import com.topcoder.util.objectfactory.impl.SpecificationConfigurationException;

/**
 * <p>
 * This class is main class of this component, it acts as a facade of the component.
 * </p>
 *
 * <p>
 * It provides methods to retrieve the standard stereotypes for an element type
 * and the standard namespaces, according to the language. It also provides a
 * method to apply initial formatting to a model element and a method to apply
 * initial formatting to a diagram element.
 * </p>
 *
 * <p>
 * Sample Configuration :
 * &lt;Property name=&quot;stereotypes&quot;&gt;
 *    &lt;Property name=&quot;Java&quot;&gt;
 *         &lt;Property name=&quot;Class&quot;&gt;
 *             &lt;Value&gt;exception&lt;/Value&gt;
 *             &lt;Value&gt;abstract&lt;/Value&gt;
 *         &lt;/Property&gt;
 *         &lt;Property name=&quot;Operation&quot;&gt;
 *             &lt;Value&gt;final&lt;/Value&gt;
 *             &lt;Value&gt;abstract&lt;/Value&gt;
 *         &lt;/Property&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name=&quot;CSharp&quot;&gt;
 *         &lt;Property name=&quot;Class&quot;&gt;
 *             &lt;Value&gt;exception&lt;/Value&gt;
 *             &lt;Value&gt;abstract&lt;/Value&gt;
 *         &lt;/Property&gt;
 *     &lt;/Property&gt;
 * &lt;/Property&gt;

 * &lt;Property name=&quot;defaultProjectLanguage&quot;&gt;
 *     &lt;Value&gt;Java&lt;/Value&gt;
 * &lt;/Property&gt;
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread-safe as the Map used in this class.
 * This class considered to be used in single thread environment.
 * If the ProjectConfigurationManager is used in the multi-thread,
 * the user should ensure that don't change the map concurrently
 * or change the map while apply formatting.
 * </p>
 *
 * @author kinzz, biotrail
 * @version 1.0
 */
public class ProjectConfigurationManager {
    /**
     * <p>
     * This constant represents the configuration key name for default project language.
     * </p>
     */
    private static final String DEFAULT_PROJECTLANGUAGE = "defaultProjectLanguage";

    /**
     * <p>
     * Represents the namespace used by this project configuration manager.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable (the reference)
     * and will never be null.
     * </p>
     *
     * <p>
     * This variable is referenced in the getStandardStereotypes and
     * getDefaultProjectLanguage methods.
     * </p>
     *
     */
    private final String namespace;

    /**
     * <p>
     * Represents the uml model manager used by this project configuration manager.
     * </p>
     *
     * <P>
     * This variable is set in the constructor, is immutable (the reference) and
     * will never be null.
     * </p>
     */
    private final UMLModelManager umlModelManager;

    /**
     * <p>
     * Represents the standard class data loader used by this project configuration manager.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable (the reference) and will
     * never be null.
     * </p>
     *
     * <p>
     * This variable is referenced in the getStandardNamespaces method.
     * </p>
     *
     */
    private final StandardClassDataLoader classDataLoader;

    /**
     * <p>
     * Represents the standard stereotype loader used by this project configuration manager.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable (the reference) and will
     * never be null.
     * </p>
     *
     * <p>
     * This variable is referenced in the getStandardStereotypes method.
     * </p>
     *
     */
    private final StandardStereotypeLoader stereotypeLoader;

    /**
     * <p>
     * Represents the registered initial element formatter.
     * </p>
     *
     * <p>
     * This variable will initially set to new HashMap&lt;String, Set&gt;,
     * is immutable (the reference) and will never be null.
     * </p>
     *
     * <p>
     * This variable is referenced in the applyInitialFormatting
     * and its add/remove methods.
     * </p>
     *
     */
    private final Map<String, Set<InitialElementFormatter>> elementFormatters = new HashMap<String, Set<InitialElementFormatter>>();

    /**
     * <p>
     * Represents the registered initial diagram formatter.
     * </p>
     *
     * <p>
     * This variable will initially set to new HashMap&lt;String, Set&gt;,
     * is immutable (the reference) and will never be null.
     * </p>
     *
     * <p>
     * This variable is referenced in the applyInitialFormatting
     * and its add/remove methods.
     * </p>
     *
     */
    private final Map<String, Set<InitialDiagramElementFormatter>> diagramFormatters =
        new HashMap<String, Set<InitialDiagramElementFormatter>>();

    /**
     * <p>
     * Constructs the project configuration manager with the given
     * UML model manager and standard class data loader.
     * </p>
     *
     * @param umlModelManager the non null uml model manager
     * @param classDataLoader the non null standard class data loader
     * @param stereotypeLoader the non null stereotype loader
     * @param namespace the non null, non empty namespace
     *
     * @throws IllegalArgumentException if the argument is null or the namespace is empty
     */
    public ProjectConfigurationManager(UMLModelManager umlModelManager, StandardClassDataLoader classDataLoader,
        StandardStereotypeLoader stereotypeLoader, String namespace) {
        Util.checkNull(umlModelManager, "umlModelManager");
        Util.checkNull(classDataLoader, "classDataLoader");
        Util.checkNull(stereotypeLoader, "stereotypeLoader");
        Util.checkString(namespace, "namespace");

        this.umlModelManager = umlModelManager;
        this.classDataLoader = classDataLoader;
        this.stereotypeLoader = stereotypeLoader;
        this.namespace = namespace;
    }

    /**
     * <p>
     * Constructs the project configuration manager.
     * </p>
     *
     * <p>
     * Actually, there are two namespaces to be used in this class.
     * <ul>
     * <li>The given namespace given as a parameter - used to read the stereotypes according
     * to the language and element type.</li>
     * <li>The given namespace given as a parameter with ".objectfactory" appended - used to
     * create the standard class data loader and stereo type loader from object factory.</li>
     * </ul>
     * </p>
     *
     * @param umlModelManager the non null uml model manager
     * @param namespace the non null, non empty namespace
     *
     * @throws IllegalArgumentException if the argument is null or the namespace is empty
     * @throws ProjectConfigurationException if exception occurs trying to create the class
     * data loader and stereotype loader from the configuration file
     */
    public ProjectConfigurationManager(UMLModelManager umlModelManager, String namespace)
        throws ProjectConfigurationException {
        Util.checkNull(umlModelManager, "umlModelManager");
        Util.checkString(namespace, "namespace");

        try {
            ObjectFactory factory = new ObjectFactory(new ConfigManagerSpecificationFactory(namespace
                + ".objectfactory"));

            // create the classDataLoader from object factory
            Object object = factory.createObject("standardClassDataLoader");
            if (!(object instanceof StandardClassDataLoader)) {
                throw new ProjectConfigurationException(
                    "The object for standardClassDataLoader should be of StandardClassDataLoader type.");
            }
            this.classDataLoader = (StandardClassDataLoader) object;

            // create the stereotypeLoader from object factory
            object = factory.createObject("stereotypeLoader");
            if (!(object instanceof StandardStereotypeLoader)) {
                throw new ProjectConfigurationException(
                    "The object for StandardStereotypeLoader should be of StandardStereotypeLoader type.");
            }
            this.stereotypeLoader = (StandardStereotypeLoader) object;

            this.umlModelManager = umlModelManager;
            this.namespace = namespace;
        } catch (SpecificationConfigurationException e) {
            throw new ProjectConfigurationException(
                "SpecificationConfigurationException occurs while creating object from object factory.", e);
        } catch (IllegalReferenceException e) {
            throw new ProjectConfigurationException(
                "IllegalReferenceException occurs while creating object from object factory.", e);
        } catch (InvalidClassSpecificationException e) {
            throw new ProjectConfigurationException(
                "InvalidClassSpecificationException occurs while creating object from object factory.", e);
        }
    }

    /**
     * <p>
     * Constructs the project configuration manager with the given
     * UML model manager and the name of this class as namespace.
     * </p>
     *
     * @param umlModelManager the non null uml model manager
     *
     * @throws IllegalArgumentException if the argument is null
     * @throws ProjectConfigurationException if exception occurs trying to create the class data loader
     * and stereotype loader from the configuration file.
     */
    public ProjectConfigurationManager(UMLModelManager umlModelManager) throws ProjectConfigurationException {
        this(umlModelManager, ProjectConfigurationManager.class.getName());
    }

    /**
     * <p>
     * Retrieve the standard stereotypes for an element type according to the language.
     * </p>
     *
     * @param language the non null, non empty(trim'd) language
     * @param elementType the non null, non empty(trim'd) type of the element
     * @return the non null standard stereotypes for an element type according to the language
     *
     * @throws IllegalArgumentException if any argument is null, or empty
     * @throws ProjectConfigurationException if exception occurs trying to get the configuration
     */
    public List<Stereotype> getStandardStereotypes(String language, String elementType)
        throws ProjectConfigurationException {
        Util.checkString(language, "language");
        Util.checkString(elementType, "elementType");

        return stereotypeLoader.getStereotypes(language, elementType);
    }

    /**
     * <p>
     * Retrieve the standard namespaces according to the language.
     * </p>
     *
     * @param language the non null, non empty(trim'd) language
     * @return the non null standard namespaces according to the language.
     *
     * @throws IllegalArgumentException if the argument is null, or empty.
     */
    public List<Namespace> getStandardNamespaces(String language) {
        Util.checkString(language, "language");

        try {
            return classDataLoader.getNamespaces(language);
        } catch (UnknownLanguageException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        } catch (ClassDataLoaderConfigurationException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    /**
     * <p>
     * Apply initial formatting to a model element according to the language.
     * </p>
     *
     * <p>
     * Note, all the registered formatters are used for formatting.
     * </p>
     *
     * @param language the non null, non empty(trim'd) language
     * @param element the non null element to be formatted
     * @return true if the passed in object was modified, otherwise false.
     *
     * @throws IllegalArgumentException if any argument is null or the language is empty
     * @throws ProjectConfigurationManager if it is thrown by the formatter
     */
    public boolean applyInitialFormatting(String language, ModelElement element) throws ProjectConfigurationException {
        Util.checkString(language, "language");
        Util.checkNull(element, "element");

        boolean isModified = false;

        // Iterator each formatter to apply formatting
        // If one of the formatter modifies the model element, then this method will return true
        Set<InitialElementFormatter> formatters = elementFormatters.get(language);
        if (formatters != null) {
            for (InitialElementFormatter format : formatters) {
                if (format.format(element)) {
                    isModified = true;
                }
            }
        }

        return isModified;
    }

    /**
     * <p>
     * Apply initial formatting to a diagram element according to the language.
     * </p>
     *
     * <p>
     * Note, all the registered formatters are used for formatting.
     * </p>
     *
     * @param language the non null, non empty(trim'd) language
     * @param element the non null element to be formatted
     * @return true if the passed in object was modified, otherwise false.
     *
     * @throws IllegalArgumentException if any argument is null or the language is empty
     * @throws ProjectConfigurationManager if it is thrown by the formatter
     */
    public boolean applyInitialFormatting(String language, DiagramElement element) throws ProjectConfigurationException {
        Util.checkString(language, "language");
        Util.checkNull(element, "element");

        boolean isModified = false;

        // Iterator each formatter to apply formatting
        // If one of the formatter modifies the diagram element, then this method will return true
        Set<InitialDiagramElementFormatter> formatters = diagramFormatters.get(language);
        if (formatters != null) {
            for (InitialDiagramElementFormatter format : formatters) {
                if (format.format(element)) {
                    isModified = true;
                }
            }
        }

        return isModified;
    }

    /**
     * <p>
     * Get the default project language.
     * </p>
     *
     * @return the non null default project language
     *
     * @throws ProjectConfigurationException if exception occurs trying to
     * get the default project language from the configuration file.
     */
    public String getDefaultProjectLanguage() throws ProjectConfigurationException {
        return Util.getString(namespace, DEFAULT_PROJECTLANGUAGE);
    }

    /**
     * <p>
     * Register the initial element formatter for the language.
     * </p>
     *
     * @param language the non null, non empty language of the formatter
     * @param formatter the non null formatter
     *
     * @throws IllegalArgumentException if any argument is null or the language is empty
     */
    public void addInitialElementFormatter(String language, InitialElementFormatter formatter) {
        Util.checkString(language, "language");
        Util.checkNull(formatter, "formatter");

        Set<InitialElementFormatter> formatters = elementFormatters.get(language);
        // if no formatters for the given language is available, then create an empty set and
        // set up the mapping in elementFormatters
        if (formatters == null) {
            formatters = new HashSet<InitialElementFormatter>();
            elementFormatters.put(language, formatters);
        }

        formatters.add(formatter);
    }

    /**
     * <p>
     * Register the initial diagram formatter for the language.
     * </p>
     *
     * @param language the non null, non empty language of the formatter
     * @param formatter the non null formatter
     *
     * @throws IllegalArgumentException if any argument is null
     * or the language is empty.
     */
    public void addInitialDiagramFormatter(String language, InitialDiagramElementFormatter formatter) {
        Util.checkString(language, "language");
        Util.checkNull(formatter, "formatter");

        Set<InitialDiagramElementFormatter> formatters = diagramFormatters.get(language);
        // if no formatters for the given language is available, then create an empty set and
        // set up the mapping in diagramFormatters
        if (formatters == null) {
            formatters = new HashSet<InitialDiagramElementFormatter>();
            diagramFormatters.put(language, formatters);
        }

        formatters.add(formatter);
    }

    /**
     * <p>
     * Un-Register the initial diagram formatter for the language.
     * </p>
     *
     * @param language the non null, non empty language of the formatter
     * @param formatter the non null formatter
     *
     * @throws IllegalArgumentException if any argument is null or the language is empty.
     */
    public void removeInitialDiagramFormatter(String language, InitialDiagramElementFormatter formatter) {
        Util.checkString(language, "language");
        Util.checkNull(formatter, "formatter");

        Set<InitialDiagramElementFormatter> formatters = diagramFormatters.get(language);
        if (formatters != null) {
            formatters.remove(formatter);
        }
    }

    /**
     * <p>
     * Un-Register the initial element formatter for the language.
     * </p>
     *
     * @param language the non null, non empty language of the formatter
     * @param formatter the non null formatter
     *
     * @throws IllegalArgumentException if any argument is null or the language is empty
     */
    public void removeInitialElementFormatter(String language, InitialElementFormatter formatter) {
        Util.checkString(language, "language");
        Util.checkNull(formatter, "formatter");

        Set<InitialElementFormatter> formatters = elementFormatters.get(language);
        if (formatters != null) {
            formatters.remove(formatter);
        }
    }

}
