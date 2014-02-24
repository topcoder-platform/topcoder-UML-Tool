/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins;

import com.topcoder.gui.panels.documentation.DocumentPanelHelper;
import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;
import com.topcoder.gui.panels.documentation.UnknownElementTypeException;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * <p>
 * A <code>TagOptionManager</code> is responsible for handling the
 * customization of tag options for each registered class type.
 * Each different <code>ModelElement</code> within the model may have
 * its own set of appropriate tags (e.g. "author", "see", "throws", ...)
 * .These lists are customizable through configuration, and it is up to
 * this manager to organize parsing the configuration into option lists
 * for each identifiers given.
 * </p>
 *
 * <p>
 *  <strong>Sample Configuration:</strong>
 *  The "TYPES" property defines the "known types" for model elements,
 *  may also define some "global" type. Any element type not defined in
 *  "TYPES" property will be ignored:<br/>
 *  <pre>
 *  &lt;Config name="plugins_defaultTagOptions"&gt;
 *       &lt;Property name="TYPES"&gt;
 *          &lt;Value&gt;GLOBAL&lt;/Value&gt;
 *          &lt;Value&gt;com.topcoder.model.uml.core.OperationImpl&lt;/Value&gt;
 *          &lt;Value&gt;com.topcoder.model.uml.core.classifiers.ClassImpl&lt;/Value&gt;
 *      &lt;/Property&gt;
 *
 *      &lt;!-- global options --&gt;
 *       &lt;Property name="GLOBAL"&gt;
 *           &lt;!-- some common javadocs options --&gt;
 *           &lt;Property name="options"&gt;
 *               &lt;Value&gt;see&lt;/Value&gt;
 *               &lt;Value&gt;since&lt;/Value&gt;
 *               &lt;Value&gt;deprecated&lt;/Value&gt;
 *           &lt;/Property&gt;
 *       &lt;/Property&gt;
 *
 *       &lt;!-- method options, adding two to global --&gt;
 *       &lt;Property name="com.topcoder.model.uml.core.OperationImpl"&gt;
 *           &lt;!-- add two operation options --&gt;
 *           &lt;Property name="options"&gt;
 *               &lt;Value&gt;throws&lt;/Value&gt;
 *               &lt;Value&gt;exception&lt;/Value&gt;
 *           &lt;/Property&gt;
 *           &lt;!-- inherit the global set --&gt;
 *           &lt;Property name="links"&gt;
 *               &lt;Value&gt;GLOBAL&lt;/Value&gt;
 *           &lt;/Property&gt;
 *        &lt;/Property&gt;
 *
 *       &lt;!-- class options, adding two to global --&gt;
 *        &lt;Property name="com.topcoder.model.uml.core.classifiers.ClassImpl"&gt;
 *            &lt;!-- add two class options --&gt;
 *            &lt;Property name="options"&gt;
 *                &lt;Value&gt;author&lt;/Value&gt;
 *                &lt;Value&gt;version&lt;/Value&gt;
 *            &lt;/Property&gt;
 *            &lt;!-- inherit the global set --&gt;
 *            &lt;Property name="links"&gt;
 *                &lt;Value&gt;GLOBAL&lt;/Value&gt;
 *            &lt;/Property&gt;
 *        &lt;/Property&gt;
 *    &lt;/Config&gt;
 *  </pre>
 *  There should not be any empty value. That is, "&lt;Value&gt;&lt;/Value&gt;" is
 *  not allowed.
 * </p>
 *
 * <p>
 *  <strong>Any value of "links" property must be also defined in "TYPES" property:</strong>
 *  For example, within below configuration, "com.topcoder.model.uml.core.OperationImpl"
 *  type links to "GLOBAL" type, but "GLOBAL" type is not defined in "TYPES" property,
 *  this is not allowed:<br/>
 *  <pre>
 *  &lt;Config name="plugins_defaultTagOptions"&gt;
 *      &lt;Property name="TYPES"&gt;
 *          &lt;Value&gt;com.topcoder.model.uml.core.OperationImpl&lt;/Value&gt;
 *      &lt;/Property&gt;
 *
 *      &lt;!-- global options --&gt;
 *       &lt;Property name="GLOBAL"&gt;
 *           &lt;!-- some common javadocs options --&gt;
 *           &lt;Property name="options"&gt;
 *               &lt;Value&gt;see&lt;/Value&gt;
 *               &lt;Value&gt;since&lt;/Value&gt;
 *               &lt;Value&gt;deprecated&lt;/Value&gt;
 *           &lt;/Property&gt;
 *       &lt;/Property&gt;
 *
 *       &lt;!-- method options, adding two to global --&gt;
 *       &lt;Property name="com.topcoder.model.uml.core.OperationImpl"&gt;
 *           &lt;!-- add two operation options --&gt;
 *           &lt;Property name="options"&gt;
 *               &lt;Value&gt;throws&lt;/Value&gt;
 *               &lt;Value&gt;exception&lt;/Value&gt;
 *           &lt;/Property&gt;
 *           &lt;!-- inherit the global set --&gt;
 *           &lt;Property name="links"&gt;
 *               &lt;Value&gt;GLOBAL&lt;/Value&gt;
 *           &lt;/Property&gt;
 *        &lt;/Property&gt;
 *    &lt;/Config&gt;
 *    </pre>
 * </p>
 *
 * <p>
 *  <strong>Any type listed in "TYPES" property must exist and be configured:</Strong>
 *  For example, within below configuration, "com.topcoder.model.uml.core.classifiers.ClassImpl"
 *  is listed in "TYPES", but does not exist as a property; "com.topcoder.uml.model.core.ParameterImpl"
 *  is listed in "TYPES", but contains nothing though it exists. These both are not allowed:
 *  <pre>
 *  &lt;Config name="plugins_defaultTagOptions"&gt;
 *      &lt;Property name="TYPES"&gt;
 *          &lt;Value&gt;com.topcoder.model.uml.core.OperationImpl&lt;/Value&gt;
 *          &lt;Value&gt;com.topcoder.model.uml.core.classifiers.ClassImpl&lt;/Value&gt;
 *          &lt;Value&gt;com.topcoder.uml.model.core.ParameterImpl&lt;/Value&gt;
 *      &lt;/Property&gt;
 *
 *       &lt;!-- method options, adding two to global --&gt;
 *       &lt;Property name="com.topcoder.model.uml.core.OperationImpl"&gt;
 *           &lt;!-- add two operation options --&gt;
 *           &lt;Property name="options"&gt;
 *               &lt;Value&gt;throws&lt;/Value&gt;
 *               &lt;Value&gt;exception&lt;/Value&gt;
 *           &lt;/Property&gt;
 *       &lt;/Property&gt;
 *
 *       &lt;Property name="com.topcoder.uml.model.core.ParameterImpl"&gt;
 *       &lt;/Property&gt;
 *    &lt;/Config&gt;
 *  </pre>
 * </p>
 *
 * <p>
 *  <strong>Circular reference of links is not allowed:</strong>
 *  The circular reference of links is not allowed, as this will lead to infinite loops.
 *  For example, within below configuration, "type1" links to "type2", "type2" links to
 *  "type1", it is a loop and not allowed:<br/>
 *  <pre>
 *   &lt;Property name="type1"&gt;
 *     &lt;Property name="links"&gt;
 *          &lt;Value&gt;type2&lt;/Value&gt;
 *     &lt;/Property&gt;
 *   &lt;/Property&gt;
 *   &lt;Property name="type2"&gt;
 *     &lt;Property name="links"&gt;
 *          &lt;Value&gt;type1&lt;/Value&gt;
 *     &lt;/Property&gt;
 *   &lt;/Property&gt;
 *  </pre>
 * </p>
 *
 * <p>
 *  <strong>Thread Safety:</strong>
 *  This class is thread safe - after construction, the contents are only read, never modified.
 * </p>
 *
 * @author sql_lall, liuliquan
 * @version 1.0
 */
public class TagOptionManager {

    /**
     * <p>
     * Property name of the known model element type. May include some "global" types.
     * </p>
     */
    private static final String TYPES = "TYPES";

    /**
     * <p>
     * Property name of the set of tag options for a given model element.
     * </p>
     */
    private static final String OPTIONS = "options";

    /**
     * <p>
     * Property name of the set of linked options for a given model element.
     * </p>
     */
    private static final String LINKS = "links";

    /**
     * <p>
     * Contains the defined element types in "TYPES" property.
     * Any value within <code>links</code> must also be contained
     * in this list.
     * </p>
     *
     * <p>
     * The underlying list object does not change after construction,
     * and is initially a new <code>ArrayList</code>.
     * </p>
     */

    private final List < String > types = new ArrayList < String >();
    /**
     * <p>
     * The [identifier, options] mappings store which tag names are to be
     * provided for a given object identifier.
     *  <ul>
     *   <li>Key: any String, non-null and non-empty(trimmed).</li>
     *   <li>Value: list of Strings, non-null list and contains
     *       non-null element, duplicates allowed.</li>
     *  </ul>
     *  When the options for the Key are obtained, the set of options is
     *  initially seeded with the strings inside its mapped value, before
     *  links are processed.
     * </p>
     *
     * <p>
     * The underlying map object does not change after construction,
     * and is initially a new <code>HashMap</code>.
     * </p>
     */
    private final Map < String, List < String > > options =
        new HashMap < String, List < String > >();

    /**
     * <p>
     * The [identifier, identifiers] mappings allow one type of
     * identifier to inherit all the options provided others.
     *  <ul>
     *   <li>Key: any String, non-null and non-empty(trimmed).</li>
     *   <li>Value: list of Strings, non-null list and contains
     *       non-null element, duplicates allowed.</li>
     *  </ul>
     *  When the options for the Key are obtained, the options for all
     *  the strings inside the value list (if any) are also found and
     *  added to the set of options.
     * </p>
     *
     * <p>
     *  <strong>Note:</strong>
     *  It is recommended that circular references are not used, as this
     *  will lead to infinite loops.
     * </p>
     *
     * <p>
     * The underlying map object does not change after construction, and is
     * initially a new <code>HashMap</code>.
     * </p>
     */
    private final Map < String, List < String > > links =
        new HashMap < String, List < String > >();

/**
 * <p>
 * Constructs a new <code>TagOptionManager</code>, reading in options and links
 * information from configuration.
 * </p>
 *
 * <p>
 * For each defined "known element type" of the given namespace, the name of the
 * the type is mapped to the list of values of property "options" and property
 * "links".
 * </p>
 *
 * @param namespace Namespace within the configuration manager to read options from.
 * @throws DocumentationPanelConfigurationException if there are problems reading
 *         from configuration, or configuration contains empty value, or any link
 *         value is not defined in "TYPES" property, or some defined type listed in
 *         "TYPES" is not an exist property(that is, not configured), or circular
 *         reference of links is detected.
 */
    public TagOptionManager(String namespace)
        throws DocumentationPanelConfigurationException {
        List < String > optionList = null;
        List < String > linkList = null;
        try {
            ConfigManager configManager = ConfigManager.getInstance();
            String[] definedTypes = configManager.getStringArray(namespace, TYPES);

            //If types property is not configured, do nothing,
            //leave the options and links empty.
            if (definedTypes == null) {
                return;
            }

            for (int i = 0; i < definedTypes.length; i++) {
                String definedType = definedTypes[i];
                //Type must not be empty
                DocumentPanelHelper.validateString(definedType,
                        "Element type of tag options");
                //Type listed must exist and be configured
                //Please note, if some property like:
                //<property name="someProperty"/>
                //getPropertyObject() returns null also.
                if (configManager.getPropertyObject(namespace, definedType) == null) {
                    throw new DocumentationPanelConfigurationException(
                            "Defined type [" + definedType + "] is not configured.");
                }
                types.add(definedType);
            }

            //For each type, get options and links
            for (String type : types) {
                optionList =
                    this.getOptionOrLinkList(configManager, namespace, type + "." + OPTIONS);

                this.options.put(type, optionList);

                linkList =
                    this.getOptionOrLinkList(configManager, namespace, type + "." + LINKS);

                this.links.put(type, linkList);
            }

            //Detect Loop
            for (Iterator it = this.links.keySet().iterator(); it.hasNext();) {
                String originalLinkID = (String) it.next();
                List < String > originalLinkIDs = new ArrayList < String >();
                originalLinkIDs.add(originalLinkID);
                detectLoop(originalLinkIDs, null);
            }
        } catch (NullPointerException e) {
            throw new DocumentationPanelConfigurationException(
                    "The given namespace is null", e);
        } catch (UnknownNamespaceException e) {
            throw new DocumentationPanelConfigurationException(
                  "The given namespace is unknown", e);
        } catch (IllegalArgumentException e) {
            throw new DocumentationPanelConfigurationException(
                    "The given namespace contains empty(trimmed) value", e);
        }
    }

    /**
     * <p>
     * Detect whether there is a cycle loop in the link list.
     * </p>
     *
     * <p>
     * For each link id, it may link to another link id, and so on.
     * While the "link" going forward, if it links back to the original
     * link id, that is the "loop" scenario which is not allowed.
     * This method starts from the original link id, use a list to track
     * its sub-link ids recursively, if any sub-link id is found to be
     * already contained in the list, a loop is detected.
     * </p>
     *
     * <p>
     * If future developers think this is not much inefficient, feel free
     * to improve it.
     * </p>
     *
     * <p>
     *  <strong>Called by:</strong>
     *   <ul>
     *    <li><code>TagOptionManager()</code></li>
     *   </ul>
     * </p>
     *
     * @param linkedIDs list used to track already linked ids
     * @param linkedID sub-linked id
     *
     * @throws DocumentationPanelConfigurationException If linkedID
     *         is contained in linkedIDs.
     */
    private void detectLoop(List < String > linkedIDs, String linkedID)
        throws DocumentationPanelConfigurationException {
        //If linkedID is already contained in linked ID list, loop detected
        if (linkedIDs.contains(linkedID)) {
            throw new DocumentationPanelConfigurationException(
                    "Loop detected for link name : " + linkedID);
        }
        String subID = null;
        if (linkedID == null) {
            //Enter here only when first called.
            subID = linkedIDs.get(linkedIDs.size() - 1);
        } else {
            //Push the sub-linked ID to the tracking list
            subID = linkedID;
            linkedIDs.add(subID);
        }
        List < String > linkList = links.get(subID);

        //detect loop for each sub-linked id
        if (linkList != null) {
            for (String link : linkList) {
                detectLoop(linkedIDs, link);
            }
        }
    }
    /**
     * <p>
     * Read options or links list from configuration.
     * </p>
     *
     * <p>
     *  <strong>Called by:</strong>
     *   <ul>
     *    <li><code>TagOptionManager()</code></li>
     *   </ul>
     * </p>
     *
     * @param configManager instance of <code>ConfigManager</code>
     * @param propertyName name of property to to retrieve from
     * @param nestKey name of nested property to retrieve values.
     *        Either be <code>OPTIONS</code> or <code>LINKS</code>.
     *
     * @return non-null list of options or links. Possibly empty
     *         if given property does not contain any value.
     *
     * @throws UnknownNamespaceException if the namespace has not
     *         been added to the Configuration Manager.
     * @throws IllegalArgumentException if any tag option read from
     *         configuration is null or empty(trimmed).
     * @throws DocumentationPanelConfigurationException If any link
     *         value is not defined in "TYPES" property.
     */
    private List < String > getOptionOrLinkList(ConfigManager configManager,
            String propertyName, String nestKey)
        throws UnknownNamespaceException, DocumentationPanelConfigurationException {

        String[] values = configManager.getStringArray(propertyName, nestKey);
        List < String > list = new ArrayList < String >();
        if (values != null) {
            for (int index = 0; index < values.length; index++) {
                String value = values[index];
                //option and link value must not be empty
                DocumentPanelHelper.validateString(value, "Tag option or link");
                //link value must be defined in types
                if (nestKey.indexOf(LINKS) != -1 && !types.contains(value)) {
                    throw new DocumentationPanelConfigurationException(
                             "Link value [" + value + "] is not defined in TYPES property");
                }
                list.add(value);
            }
        }
        return list;
    }
    /**
     * <p>
     * Returns a list of tag options that can be added to the given ID.
     * This is built up recursively, firstly with direct options, then
     * any inherited from the id's links.
     * </p>
     *
     * <p>
     * The list returned will not contain duplicates. It may be empty,
     * if the ID is known but not connected to anything. If the given
     * objectID is not configured then an <code>UnknownElementTypeException</code>
     * is thrown.
     * </p>
     *
     * @param objectID Name identifier of object whose options are to be
     *        retrieved. Null is permitted, as it is a valid key in a hash map,
     *        though will result in an <code>UnknownElementTypeException</code>
     *        being raised.
     *
     * @return A non-null list contains the names of tag options for the given
     *         object ID.
     *
     * @throws UnknownElementTypeException if the type of element passed has no
     *         tag options
     */
    public List < String > getTagOptions(String objectID)
        throws UnknownElementTypeException {

        //unknown ModelElement type
        if (!types.contains(objectID)) {
            throw new UnknownElementTypeException(
                    "Element type [" + objectID + "] is unknown.");
        }
        List < String > optionList = options.get(objectID);
        if (optionList == null) {
            optionList = new ArrayList < String >();
        }

        //use HashSet to remove duplicate options
        HashSet < String > ret = new HashSet < String >(optionList);

        //get linked options
        List < String > linkList = links.get(objectID);
        if (linkList != null) {
            for (String linkID : linkList) {
                List < String > linkOpts = getTagOptions(linkID);
                for (String linkOpt : linkOpts) {
                    ret.add(linkOpt);
                }
            }
        }
        return new ArrayList < String >(ret);
    }
}
