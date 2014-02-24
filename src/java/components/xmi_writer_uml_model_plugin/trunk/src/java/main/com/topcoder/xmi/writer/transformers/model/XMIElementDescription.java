/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This class describes an XMI element. It contains two simple attributes, the
 * element type in TC UML Model, and the element name in OMG DTD. It also
 * contains a list of AttributeDescriptions, which contains information for the
 * attributes this element, and a list of ChildDescriptions, which contains
 * information for the child elements of this element.
 * </p>
 *
 * <p>
 * Typically, the XMIElementDescription instances will be created by
 * XMIDescription implementations, and be used by Model2XMITransformer to help
 * transform the UML Model to XMI.
 * </p>
 *
 * <p>
 * This class is mutable, so it is not thread-safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class XMIElementDescription {

    /**
     * The element name in xmi document, including namespace prefix. It could
     * look like <code>UML:Namespace</code>.
     * <p>
     * It is initialized in constructor, and never changed later. It can be
     * accessed by getter. It can be any non-null or non-empty string. The
     * validity should be guaranteed by user.
     * </p>
     *
     */
    private final String elementName;

    /**
     * The model element type corresponding to this XMIElement. e.g.
     * com.topcoder.uml.model.modelmanagement.Package should be matched with
     * UML:Package element.
     * <p>
     * It is intialized in constructor, and never changed later. It can be
     * accessed by getter. It can be any non-null Class instance.
     * </p>
     *
     */
    private final Class elementType;

    /**
     * Represents all the attributes belonging to this element.
     * <p>
     * The list contains non-null AttributeDescription instances.
     * </p>
     * <p>
     * It will be instantiated in the constructor, and itself is never changed
     * later. But the contenct can be changed by some operations similar to List
     * operation.
     * </p>
     *
     */
    private final List<AttributeDescription> attributes = new ArrayList<AttributeDescription>();

    /**
     * Represents all the children belonging to this element.
     * <p>
     * The list contains non-null ChildDescription instances.
     * </p>
     * <p>
     * It will be instantiated in the constructor, and itself is never changed
     * later. But the contenct can be changed by some operations similar to List
     * operation.
     * </p>
     *
     */
    private final List<ChildDescription> children = new ArrayList<ChildDescription>();

    /**
     * Constructor.
     * <p>
     * Impl Notes: this.elementName = elementName; this.elementType =
     * elementType; Initialize attributes and children to an empty list.
     * </p>
     *
     * @param elementName
     *            the name of this XMI element
     * @param elementType
     *            the corresponding model type this element.
     * @throws IllegalArgumentException
     *             if any arg is null, or elementName is empty(after trimmed)
     */
    public XMIElementDescription(String elementName, Class elementType) {
        Helper.checkEmptyAndNullString(elementName, "elementName");
        Helper.checkNull(elementType, "elementType");
        this.elementName = elementName;
        this.elementType = elementType;
    }

    /**
     * Get the elementName of the element description.
     *
     * @return the elementName of this XMIElement
     */
    public String getElementName() {
        return elementName;
    }

    /**
     * Get the elementType of the element description.
     *
     * @return the elementType of this XMIElement
     */
    public Class getElementType() {
        return elementType;
    }

    /**
     * Add an attribute description to the end of the attributes list.
     *
     * @param attribute
     *            the AttributeDescription to be added.
     * @throws IllegalArgumentException
     *             if any parameter is null.
     */
    public void addAttribute(AttributeDescription attribute) {
        Helper.checkNull(attribute, "attribute");
        attributes.add(attribute);
    }

    /**
     * Insert an attribute description to the specified index position.
     *
     *
     * @param index
     *            the position to insert attribute to.
     * @param attribute
     *            the AttributeDescription to be added.
     * @throws IllegalArgumentException
     *             if any arg is null.
     * @throws IndexOutOfBoundsException
     *             if index is not in the range of [0, attributes.size()]
     */
    public void addAttribute(int index, AttributeDescription attribute) {
        Helper.checkNull(attribute, "attribute");
        if (index < 0 || index > attributes.size()) {
            throw new IndexOutOfBoundsException("The index is out of bound, " + "should be in [0, " + attributes.size()
                    + "]");
        }
        attributes.add(index, attribute);
    }

    /**
     * Remove the first occurrence of the attribute description in attributes list.
     *
     * @return boolean value indicating whether the attribute is removed.
     * @param attribute
     *            the AttributeDescription to be removed.
     * @throws IllegalArgumentException
     *             if any arg is null.
     */
    public boolean removeAttribute(AttributeDescription attribute) {
        Helper.checkNull(attribute, "attribute");
        return attributes.remove(attribute);
    }

    /**
     * Remove an attribute description from the specified index position.
     *
     * @return the removed attribute instance
     * @param index
     *            the attribute position to be removed.
     * @throws IndexOutOfBoundsException
     *             if index is not in the range of [0, attributes.size() - 1]
     */
    public AttributeDescription removeAttribute(int index) {
        if (index < 0 || index > attributes.size() - 1) {
            throw new IndexOutOfBoundsException("The index is out of bound, " + "should be in [0, "
                    + (attributes.size() - 1) + "]");
        }
        return attributes.remove(index);
    }

    /**
     * Get all the attributes of this ModelElement.
     *
     * @return all the attributes belonging to this element.
     */
    public List<AttributeDescription> getAttributes() {
        return new ArrayList<AttributeDescription>(attributes);
    }

    /**
     * Clear all the attributes of this element.
     */
    public void clearAttributes() {
        attributes.clear();
    }

    /**
     * Add a child description to the end of the children list.
     *
     * @param child
     *            the ChildDescription to be added.
     * @throws IllegalArgumentException
     *             if any arg is null.
     */
    public void addChild(ChildDescription child) {
        Helper.checkNull(child, "child");
        children.add(child);
    }

    /**
     * Insert an child description to the specified index position.
     *
     * @param child
     *            the ChildDescription to be added.
     *
     * @param index
     *            the position to insert child to.
     * @throws IllegalArgumentException
     *             if any arg is null.
     * @throws IndexOutOfBoundsException
     *             if index is not in the range of [0, children.size()]
     */
    public void addChild(int index, ChildDescription child) {
        Helper.checkNull(child, "child");
        if (index < 0 || index > children.size()) {
            throw new IndexOutOfBoundsException("The index is out of bound, " + "should be in [0, " + children.size()
                    + "]");
        }
        children.add(index, child);
    }

    /**
     * Remove the first occurrence of the child description in children list.
     *
     * @return boolean value indicating whether the child is removed.
     * @param child
     *            the ChildDescription to be removed.
     * @throws IllegalArgumentException
     *             if any arg is null.
     */
    public boolean removeChild(ChildDescription child) {
        Helper.checkNull(child, "child");
        return children.remove(child);
    }

    /**
     * Remove a child description from the specified index position.
     *
     * @return the removed child instance
     * @param index
     *            the child position to be removed.
     * @throws IndexOutOfBoundsException
     *             if index is not in the range of [0, children.size() - 1]
     */
    public ChildDescription removeChild(int index) {
        if (index < 0 || index > children.size() - 1) {
            throw new IndexOutOfBoundsException("The index is out of bound, " + "should be in [0, "
                    + (children.size() - 1) + "]");
        }
        return children.remove(index);
    }

    /**
     * Get all the children of this ModelElement.
     *
     * @return all the chilren belonging to this element.
     */
    public List<ChildDescription> getChildren() {
        return new ArrayList<ChildDescription>(children);
    }

    /**
     * Clear all the children of this element.
     *
     */
    public void clearChildren() {
        children.clear();
    }
}
