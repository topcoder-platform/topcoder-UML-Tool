/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Package;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;
import com.topcoder.util.log.Level;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * <p>
 * This abstract class implements the <code>Generator</code> interface and provides
 * common functionality for all other <code>Generator</code> implementations.
 * </p>
 * <p>
 * <b>Thread safety:</b> This class is not thread safe.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public abstract class AbstractGenerator implements Generator {
    /**
     * The 'documentation' configuration entry.
     */
    private static final String DOCUMENTATION = "documentation";

    /**
     * The 'tagsDocumentation' configuration entry.
     */
    private static final String TAGS_DOCUMENTATION = "tagsDocumentation";

    /**
     * The stereotypes configuration entries.
     */
    private static final String[] STEREOTYPES = new String[] {
        "new", "readonly", "virtual", "override", "sealed", "extern", "delegate", "explicit", "implicit", "struct", "event",
        "property_get", "property_set", "property", "destructor", "protected internal"
    };

    /**
     * <p>
     * This attribute represent a map of stereotypes names and corresponding
     * languages key words or needed parameters like destructor.
     * </p>
     * <p>
     * Elements can not be <code>null</code> and they are set by constructor.
     * </p>
     * <p>
     * For the other classes it is accessible through the protected getter
     * </p>
     * <p>
     * For example language key word - &quot;virtual&quot; , stereotype name-
     * &quot;virtual method&quot;
     * </p>
     */
    private final Map<String, String> stereotypes = new HashMap<String, String>();

    /**
     * <p>
     * This attribute represents the name of {@link TagDefinition} which
     * contains documentation for ModelElement instances.
     * </p>
     * <p>
     * This is configurable and set by ConfigurationManager in class
     * constructor.
     * <p>
     * Immutable, <code>null</code> or empty string impossible.
     * </p>
     * <p>
     * For the other classes it is accessible through the protected getter
     * </p>
     */
    private final String documentation;

    /**
     * <p>
     * This attribute represent name of {@link TagDefinition} which contains
     * documentation for tags of {@link ModelElement} instances.
     * </p>
     * <p>
     * Tags names may be defined by user.
     * </p>
     * <p>
     * Immutable, sets by constructor, <code>null</code> or empty string
     * impossible.
     * </p>
     * <p>
     * For the other classes it is accessible through the protected getter.
     * </p>
     */
    private final String tagsDocumentation;

    /**
     * <p>
     * Represent logger instance for current generator. This attribute is used
     * by JavaGenerator and CSharpGenerator to log problems with generated code.
     * </p>
     * <p>
     * Immutable, default and only possible value is a Log created from this
     * object's class name.
     * </p>
     * <p>
     * For the other classes it is accessible through the protected getter
     * </p>
     */
    private final Log log = LogFactory.getLog(this.getClass().getName());

    /**
     * <p>
     * Represent set of imported packages (using name-spaces) names. New
     * elements are added to set by JavaGenerator's and CSharpGenerator's
     * methods.
     * </p>
     * <p>
     * May be empty, immutable, default and only possible value new
     * HashSet&lt;String&gt;(); Element can not be <code>null</code>.
     * </p>
     * <p>
     * For the other classes it is accessible through the protected getter
     * </p>
     */
    private final Set<String> imports = new HashSet<String>();

    /**
     * <p>
     * Represent set of imported types (using name-spaces) names. New
     * elements are added to set by JavaGenerator's and CSharpGenerator's
     * methods.
     * </p>
     * <p>
     * May be empty, immutable, default and only possible value new
     * HashSet&lt;String&gt;(); Element can not be <code>null</code>.
     * </p>
     * <p>
     * For the other classes it is accessible through the protected getter
     * </p>
     */
    private final Set<String> importTypes = new HashSet<String>();

    /**
     * <p>
     * This constructor uses {@link ConfigManager} to set stereotypes,
     * documentation and tagsDocumentation.
     * </p>
     *
     * @param namespace
     *            String with name-space of configuration file
     * @throws IllegalArgumentException
     *             if namespace is <code>null</code> or empty
     * @throws GeneratorConfigurationException
     *             if an error occurs while reading configuration
     */
    protected AbstractGenerator(String namespace) throws GeneratorConfigurationException {
        if (namespace == null) {
            throw new IllegalArgumentException("Name space must not be null");
        }

        if (namespace.trim().length() == 0) {
            throw new IllegalArgumentException("Name space must not be empty");
        }

        this.documentation = this.getConfigEntry(namespace, DOCUMENTATION);
        this.tagsDocumentation = this.getConfigEntry(namespace, TAGS_DOCUMENTATION);

        for (String stereotype : STEREOTYPES) {
            this.stereotypes.put(stereotype, this.getConfigEntry(namespace, stereotype));
        }
    }

    /**
     * <p>
     * Gets an entry form the configuration.
     * </p>
     *
     * @param namesapce
     *            name space to be used
     * @param entry
     *            name of the configuration entry
     * @return the value of the configuration entry
     * @throws GeneratorConfigurationException
     *             if the entry could not be found
     */
    private String getConfigEntry(String namesapce, String entry)
        throws GeneratorConfigurationException {
        try {
            String value = ConfigManager.getInstance().getString(namesapce, entry);

            if ((value == null) || (value.trim().length() == 0)) {
                throw new GeneratorConfigurationException("Could not get " + entry);
            }

            return value;
        } catch (UnknownNamespaceException e) {
            throw new GeneratorConfigurationException("Could not get " + entry, e);
        }
    }

    /**
     * <p>
     * Returns the full package name for given {@link Package}. The full
     * package name consists of the name of the given {@link Package} combined
     * with all parent packages it may be contained in.
     * </p>
     *
     * @param pack
     *            {@link Package} instance
     * @return full name of package
     * @throws IllegalArgumentException
     *             if pack is <code>null</code>
     */
    public String getPackage(Package pack) {
        if (pack == null) {
            throw new IllegalArgumentException("Package must not be null");
        }

        if (pack instanceof Model) {
            return "";
        }

        ModelElement nextPack = pack;
        StringBuilder builder = new StringBuilder();
        boolean first = true;

        do {
            String name = nextPack.getName();

            if ((nextPack instanceof Package) && (name != null) && (name.trim().length() != 0)) {
                if (!first) {
                    builder.insert(0, '.');
                } else {
                    first = false;
                }

                builder.insert(0, name);
            }

            nextPack = nextPack.getNamespace();
        } while ((nextPack != null) && (nextPack.getNamespace() != null));

        return builder.toString();
    }

    /**
     * <p>
     * Returns the full package name for given {@link Classifier}. The full
     * package name consists of the name of the {@link Package} containing the
     * given {@link Classifier} combined with all parent packages it may be
     * contained in.
     * </p>
     *
     * @param classifier
     *            the {@link Classifier} to get the package for
     * @return the package name in which the {@link Classifier} is contained in
     * @throws IllegalArgumentException
     *             if classifier is <code>null</code>
     */
    public String getPackage(Classifier classifier) {
        if (classifier == null) {
            throw new IllegalArgumentException("Classifier must not be null");
        }

        ModelElement outer = classifier.getNamespace();

        if (outer instanceof Package) {
            // get the package's name
            return this.getPackage((Package) outer);
        }

        return "";
    }

    /**
     * <p>
     * Checks if it is possible to generate code for the given
     * {@link Classifier}. It is possible only for {@link Classifier}s of
     * type:
     * <ul>
     * <li> {@link Class}
     * <li> {@link Interface}
     * <li> {@link Enumeration}
     * </ul>
     * </p>
     *
     * @param classifier
     *            {@link Classifier} to be checked
     * @return <code>true</code> if given {@link Classifier} is of type
     *         {@link Class}, {@link Interface} or {@link Enumeration},
     *         otherwise <code>false</code>
     * @throws IllegalArgumentException
     *             if classifier is <code>null</code>
     */
    public boolean checkClassifier(Classifier classifier) {
        if (classifier == null) {
            throw new IllegalArgumentException("Classifier must not be null");
        }

        return (classifier instanceof Class) || (classifier instanceof Interface) ||
            (classifier instanceof Enumeration);
    }

    /**
     * <p>
     * Returns the general documentation for the given {@link ModelElement}
     * instance (operations, classes, attributes, etc...).Each
     * {@link TagDefinition} with a type that equals <code>documentation</code>
     * (from configuration) is taken into account.
     * </p>
     *
     * @param modelElement
     *            the {@link ModelElement} to get the documentation for
     * @return the documentation for the given {@link ModelElement}. May be
     *         <code>null</code> or empty.
     * @throws IllegalArgumentException
     *             if modelElement is <code>null</code>
     */
    protected String getGeneralDocumentation(ModelElement modelElement) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Model element must not be null");
        }

        for (TaggedValue value : modelElement.getTaggedValues()) {
            TagDefinition tagDefinition = value.getType();

            if ((tagDefinition != null) && this.documentation.equals(tagDefinition.getTagType())) {
                String dataValue = value.getDataValue();
                return dataValue != null ? dataValue.replaceAll("\n", System.getProperty("line.separator")) : null;
            }
        }

        log.log(Level.WARN, "There is no documentation for " + modelElement.getName());

        // no documentation found
        return null;
    }

    /**
     * <p>
     * Returns a {@link Map} of documentation tags for the given
     * {@link ModelElement} instance. For each tag found there is a {@link List}
     * returned which contains data for each occurrence of the specified tag.
     * Each {@link TagDefinition} with a type that starts with
     * <code>tagsDocumentation</code> (from configuration) is taken into
     * account.
     * </p>
     *
     * @param modelElement
     *            the {@link ModelElement} to get the documentation for
     * @return a map containing a {@link List} of data for each tag found
     * @throws IllegalArgumentException
     *             if modelElement is <code>null</code>
     */
    protected Map<String, List<String>> getTagDocumentation(ModelElement modelElement) {
        if (modelElement == null) {
            throw new IllegalArgumentException("Model element must not be null");
        }

        Map<String, List<String>> result = new LinkedHashMap<String, List<String>>();

        for (TaggedValue value : modelElement.getTaggedValues()) {
            TagDefinition tagDefinition = value.getType();

            if ((tagDefinition != null) && (tagDefinition.getTagType() != null) &&
                    tagDefinition.getTagType().startsWith(this.tagsDocumentation)) {
                String key = tagDefinition.getTagType().substring(this.tagsDocumentation.length());

                if (key.trim().length() == 0) {
                    // ignore empty keys
                    continue;
                }

                if (result.containsKey(key)) {
                    // tag has been found before, add new value to its list
                    result.get(key).add(value.getDataValue());
                } else {
                    // tag has not been found before, create a new list
                    List<String> list = new ArrayList<String>();
                    list.add(value.getDataValue());
                    result.put(key, list);
                }
            }
        }

        return result;
    }

    /**
     * <p>
     * Returns a {@link Map} of documentation tags for the given
     * {@link Operation} instance. For each {@link Parameter} of the
     * {@link Operation} the documentation is added to the resulting {@link Map}.
     * </p>
     * <p>
     * There may be more than one {@link Parameter} with the same name in the
     * {@link Operation} therefore the documentation for each {@link Parameter}
     * is saved as a {@link List}.
     * </p>
     *
     * @param operation
     *            the {@link Operation} to get the documentation from
     * @return a {@link Map} containing the documentation for each
     *         {@link Parameter}.
     * @throws IllegalArgumentException
     *             if operation is <code>null</code>
     */
    protected Map<String, List<String>> getParametersDocumentation(Operation operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation must not be null");
        }

        Map<String, List<String>> result = new HashMap<String, List<String>>();

        // process each of operation's parameter
        for (Parameter param : operation.getParameters()) {
            if (param.getKind() == ParameterDirectionKind.RETURN) {
                continue;
            }
            String name = param.getName();

            // no name found, go to next parameter
            if (name == null) {
                continue;
            }

            String doc = this.getGeneralDocumentation(param);
            if (doc == null) {
                doc = "";
            }

            if (result.containsKey(name)) {
                // parameter has already docs, add the new doc
                result.get(name).add(doc);
            } else {
                // parameter has no docs so far, create a list and add the new doc
                List<String> list = new ArrayList<String>();
                list.add(doc);
                result.put(name, list);
            }
        }

        return result;
    }

    /**
     * <p>
     * Returns the mapping from language keywords to stereotypes.
     * </p>
     *
     * @return return the mapping from language keywords to stereotypes.
     */
    protected Map<String, String> getStereotypes() {
        return Collections.unmodifiableMap(this.stereotypes);
    }

    /**
     * <p>
     * Returns the <code>documentation</code> attribute from the
     * configuration.
     * </p>
     *
     * @return the <code>documentation</code> attribute from the
     *         configuration.
     */
    protected String getDocumentation() {
        return this.documentation;
    }

    /**
     * <p>
     * Returns the <code>tagsDocumentation</code> attribute from the
     * configuration.
     * </p>
     *
     * @return Returns the <code>tagsDocumentation</code> attribute from the
     */
    protected String getTagsDocumentation() {
        return this.tagsDocumentation;
    }

    /**
     * <p>
     * Returns the {@link AbstractGenerator}'s {@link Log}.
     * </p>
     *
     * @return the {@link AbstractGenerator}'s {@link Log}.
     */
    protected Log getLog() {
        return this.log;
    }

    /**
     * <p>
     * Returns the imports.
     * </p>
     *
     * @return the imports.
     */
    protected Set<String> getImports() {
        return this.imports;
    }

    /**
     * <p>
     * Returns the import types.
     * </p>
     *
     * @return the import types.
     */
    protected Set<String> getImportTypes() {
        return this.importTypes;
    }
}
