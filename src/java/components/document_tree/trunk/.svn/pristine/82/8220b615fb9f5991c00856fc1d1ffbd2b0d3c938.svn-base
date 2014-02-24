/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.impl;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.Util;
import com.topcoder.util.config.Property;

/**
 * <p>
 * This class extends the DefaultTreeCellRenderer class to provide custom icons for each tree node.
 * </p>
 *
 * <p>
 * Sample configuration: &lt;Property name=&quot;icons&quot;&gt; &lt;Property
 * name=&quot;com.topcoder.uml.model.core.Namespace&quot;&gt;
 * &lt;Value&gt;test_files/icons/namespace.gif&lt;/Value&gt; &lt;/Property&gt; &lt;Property
 * name=&quot;com.topcoder.uml.model.core.Classifier&quot;&gt;
 * &lt;Value&gt;test_files/icons/classifier.gif&lt;/Value&gt; &lt;/Property&gt; &lt;/Property&gt;
 * </p>
 *
 * <p>
 * Thread Safety: This class is not thread safe as its base class is not thread safe.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public class IconTreeCellRenderer extends DefaultTreeCellRenderer {
    /**
     * <p>
     * Represents the <b>icons</b> property name.
     * </p>
     */
    private static final String ICONS = "icons";

    /**
     * <p>
     * This variable maps the class names to icons.
     * </p>
     *
     * <p>
     * The keys are fully qualified class names and values are Icon objects. Keys must be non-null and non-empty.
     * </p>
     *
     * <p>
     * Values must be non-null. This variable is set by the constructor and referenced by the
     * getTreeCellRendererComponent method.
     * </p>
     */
    private final Map<String, Map<String, Icon>> icons;

    /**
     * <p>
     * Constructs this object with the given namespace specified.
     * </p>
     *
     * @param namespace
     *            The namespace containing the class name - to icon mapping. Must not be null or empty.
     *
     * @throws IllegalArgumentException
     *             if namespace is null or empty
     * @throws DocumentTreeConfigurationException
     *             To indicate an error during configuration.
     */
    public IconTreeCellRenderer(String namespace) {
        Util.checkString(namespace, "namespace");

        this.icons = getIconsMapping(namespace);
    }

    private Map<String, Map<String, Icon>> getIconsMapping(String namespace) {
        Map<String, Map<String, Icon>> mappings = new HashMap<String, Map<String, Icon>>();
        Property iconsProperty = DocumentTreeViewHelper.getRequiredProperty(namespace, ICONS);

        Map<String, Property> nameToPropertyMapping = new HashMap<String, Property>();
        for (Object obj : iconsProperty.list()) {
            Property prop = (Property) obj;

            nameToPropertyMapping.put(prop.getName(), prop);
        }

        for (Entry<String, Property> entry : nameToPropertyMapping.entrySet()) {
            mappings.put(entry.getKey(), getMappingInternal(entry.getValue()));
        }

        return mappings;
    }

    /**
     * <p>
     * This method return the component to be rendered.
     * </p>
     *
     * @param tree
     *            The JTree whose node is being rendered.
     * @param value
     *            The tree node object, Must not be null.
     * @param sel
     *            Is the node selected.
     * @param expanded
     *            Is the node expanded.
     * @param leaf
     *            Is the node leaf.
     * @param row
     *            The row of the node.
     * @param hasFocus
     *            Is the node having focus.
     * @return The JComponent to render this node.
     *
     * @throws IllegalArgumentException
     *             If the value is null.
     */
    public JComponent getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
        boolean leaf, int row, boolean hasFocus) {
        Util.checkNull(value, "value");

        JLabel label =
            (JLabel) super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) value;
        Object userObject = (treeNode.getUserObject());

        if (userObject instanceof DocumentTreeNode) {
            DocumentTreeNode node = (DocumentTreeNode) userObject;

            Icon icon = searchIcon(node.getNodeObject());
            if (icon != null) {
                label.setIcon(icon);
            }
        }

        return label;
    }

    private Icon searchIcon(Class type) {

        // Calculate indent and proper class label
        Icon icon = icons.get("class#name").get(type.getName());
        if (icon != null) {
            return icon;
        }

        // search the super classes
        if (type.getSuperclass() != null) {
            // true for all except java.lang.Object
            icon = searchIcon(type.getSuperclass());
            if (icon != null) {
                return icon;
            }
        }

        // search the interfaces this class implements.
        for (Class interfaceType : type.getInterfaces()) {
            icon = searchIcon(interfaceType);
            if (icon != null) {
                return icon;
            }
        }

        return null;
    }

    /**
     * <p>
     * This method searches the <code>Icon</code> configured for the given class type recursively.
     * </p>
     *
     * <p>
     * If the <code>Icon</code> is configured for the given type, then the <code>Icon</code> instance will be
     * returned directly. Otherwise all the super class of the given type will be searched, if not found, then all
     * the interface it implements will be searched.
     * </p>
     *
     * <p>
     * Note, if no <code>Icon</code> can be found, then this method will return null.
     * </p>
     *
     * @param object
     *            the given object
     *
     * @return the <code>Icon</code> configured for the given class type, null if not found
     */
    private Icon searchIcon(Object obj) {

        Class<?> type = obj.getClass();

        Icon icon = searchIcon(type);
        if (icon != null) {
            return icon;
        }

        try {
            for (Entry<String, Map<String, Icon>> elEntry : icons.entrySet()) {
                String elString = elEntry.getKey();
                if (elString.equals("class#name")) {
                    continue;
                }
                String[] elSplit = elString.split("#");

                BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());

                for (String el : elSplit) {
                    for (PropertyDescriptor propDescriptor : beanInfo.getPropertyDescriptors()) {
                        if (propDescriptor.getName().equals(el)) {
                            obj = propDescriptor.getReadMethod().invoke(obj);
                            beanInfo = Introspector.getBeanInfo(obj.getClass());
                            break;
                        }
                    }
                }

                if (elEntry.getValue().containsKey(obj.toString())) {
                    return elEntry.getValue().get(obj.toString());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    private Map<String, Icon> getMappingInternal(Property iconsProperty) {
        Map<String, Icon> mappings = new HashMap<String, Icon>();

        Map<String, Property> nameToPropertyMapping = new HashMap<String, Property>();
        for (Object obj : iconsProperty.list()) {
            Property prop = (Property) obj;

            nameToPropertyMapping.put(prop.getName(), prop);
        }

        loadPropertyValues(nameToPropertyMapping);

        for (Entry<String, Property> entry : nameToPropertyMapping.entrySet()) {
            mappings.put(entry.getKey(), new ImageIcon(entry.getValue().getValue()));
        }

        return mappings;
    }

    /**
     * <p>
     * This method loads all the child properties in the values of the given <code>mapping</code>.
     * </p>
     *
     * <p>
     * Once all the Property instances in the given mapping doesn't have the child properties, the search stops.
     * </p>
     *
     * @param mapping
     *            the mapping from String to Property, the key is the prefix property name and the value is the
     *            Property instance.
     */
    private void loadPropertyValues(Map<String, Property> mapping) {
        List<String> names = new ArrayList<String>();
        Set<Entry<String, Property>> entrys = new HashSet<Entry<String, Property>>(mapping.entrySet());
        for (Entry<String, Property> entry : entrys) {
            Property prop = entry.getValue();

            List subProps = prop.list();

            // loads all the child properties
            if (subProps.size() != 0) {
                String prefix = entry.getKey();
                names.add(prefix);
                for (Iterator it = subProps.iterator(); it.hasNext();) {
                    Property subProp = (Property) it.next();
                    mapping.put(entry.getKey() + "." + subProp.getName(), subProp);
                }
            }
        }

        if (names.size() == 0) {
            // stop searching when all the properties don't have child properties
            return;
        } else {
            // remove all the old prefix names, the new ones have been added previously
            for (String name : names) {
                mapping.remove(name);
            }

            // search recursively
            loadPropertyValues(mapping);
        }
    }
}
