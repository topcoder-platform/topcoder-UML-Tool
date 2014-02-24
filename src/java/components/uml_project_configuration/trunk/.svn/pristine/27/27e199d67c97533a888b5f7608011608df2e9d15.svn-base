/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.stereotypeloader;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.projectconfiguration.StandardStereotypeLoader;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.Util;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * This loader will load stereotypes from the XML file.
 * </p>
 *
 * <p>
 * Note, it will be created by the client application directly or created by
 * the project configuration manager via object factory. The project configuration
 * manager will use it to load stereotype from the XML configuration file.
 * </p>
 *
 * <p>
 * Sample Configuration :
 * &lt;Property name=&quot;stereotypes&quot;&gt;
 *     &lt;Property name=&quot;Java&quot;&gt;
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
 * </p>
 *
 * <p>
 * Thread Safety : This class is immutable and so is thread safe.
 * </p>
 *
 * @author kinzz, biotrail
 * @version 1.0
 */
public class XMLStereotypeLoader implements StandardStereotypeLoader {
    /**
     * <p>
     * This constant represents the configuration key name for stereotypes.
     * </p>
     */
    private static final String STEREOTYPES = "stereotypes";

    /**
     * <p>
     * Represents the namespace used by this XML stereotype loader.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable (the reference) and
     * will never be null.
     * </p>
     *
     * <p>
     * This variable is referenced in the getStereotypes methods.
     * </p>
     *
     */
    private final String namespace;

    /**
     * <p>
     * Constructs the XMLStereotypeLoader with the given namespace.
     * </p>
     *
     * @param namespace the non null, non empty namespace.
     *
     * @throws IllegalArgumentException if the namespace is null or empty.
     */
    public XMLStereotypeLoader(String namespace) {
        Util.checkString(namespace, "namespace");

        this.namespace = namespace;
    }

    /**
     * <p>
     * Retrieve the standard stereotypes for an element type according to the language from the XML file.
     * </p>
     *
     * @param language the non null, non empty language.
     * @param elementType the non null, non empty type of the element.
     * @return the non null standard stereotypes for an element type according to the language.
     *
     * @throws IllegalArgumentException if any argument is null or empty.
     * @throws ProjectConfigurationException if exception occurs trying to get the configuration.
     */
    public List<Stereotype> getStereotypes(String language, String elementType) throws ProjectConfigurationException {
        Util.checkString(language, "language");
        Util.checkString(elementType, "elementType");

        List<Stereotype> stereotypeList = new ArrayList<Stereotype>();

        StringBuffer sb = new StringBuffer();
        sb.append(STEREOTYPES);
        sb.append(".");
        sb.append(language);
        sb.append(".");
        sb.append(elementType);

        String[] stereotypeNames = getStringArray(namespace, sb.toString());
        for (String stereotypeName : stereotypeNames) {
            // create Stereotype
            Stereotype stereotype = new StereotypeImpl();

            // set name and baseClass attribute
            stereotype.setName(stereotypeName);
            stereotype.setBaseClass(elementType);

            //add to the list
            stereotypeList.add(stereotype);
        }

        return stereotypeList;
    }

    /**
     * <p>
     * Gets the property values specified under the given property argument with the given property name.
     * </p>
     *
     * @param namespace the namespace to get the property value from.
     * @param propertyName a property name to retrieve.
     *
     * @return the property value in string array representation.
     *
     * @throws ProjectConfigurationException if fail to load the config values
     */
    private String[] getStringArray(String namespace, String propertyName) throws ProjectConfigurationException {
        try {
            Property property = ConfigManager.getInstance().getPropertyObject(namespace, propertyName);

            // Property is missing
            if (property == null) {
                throw new ProjectConfigurationException("Missing property: " + propertyName);
            }

            String[] values = property.getValues();

            // values is missing
            if (values == null) {
                throw new ProjectConfigurationException("Missing property: " + propertyName);
            }

            // values exists but contains empty value
            for (int i = 0; i < values.length; i++) {
                if (values[i].trim().length() == 0) {
                    throw new ProjectConfigurationException(propertyName + " contains empty string value.");
                }
            }

            return values;
        } catch (UnknownNamespaceException e) {
            throw new ProjectConfigurationException("Unknown namespace: " + namespace, e);
        }

    }
}
