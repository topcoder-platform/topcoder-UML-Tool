/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.util.objectfactory.InvalidClassSpecificationException;
import com.topcoder.util.objectfactory.ObjectFactory;
import com.topcoder.util.objectfactory.impl.ConfigManagerSpecificationFactory;
import com.topcoder.util.objectfactory.impl.IllegalReferenceException;
import com.topcoder.util.objectfactory.impl.SpecificationConfigurationException;
import com.topcoder.xmi.writer.AbstractXMITransformer;
import com.topcoder.xmi.writer.ElementAlreadyExistsException;
import com.topcoder.xmi.writer.UnknownElementException;
import com.topcoder.xmi.writer.XMITransformException;
import com.topcoder.xmi.writer.XMIWriter;

/**
 * <p>
 * It is the main class of this component. It can be used to transform
 * {@link Model} element to its XMI representation.
 * </p>
 *
 * <p>
 * This class holds an XMIDescription instance, from which it can retrieve
 * XMIElementDescription for specific model element. Because of the
 * XMIElementDescription, the transforming process is rather straightforward. We
 * just get the xmi element name, all the attributes and child elements from the
 * description, and print it one by one. All the simple values are printed
 * directly, like Boolean, Enum, String. For single model element value, and
 * model element value contained in Collection, we directly print the id
 * reference if it is contained as an attribute. And if it is contained as a
 * child element, we just call the transform method recursively.
 * </p>
 * <p>
 * Besides that, ignoreUnknownElementType flag is defined in this class. It is
 * used to indicate whether unknown element type should be ignored. If it is
 * true, unknown element type will be ignored, otherwise, exception would occur.
 * </p>
 * <p>
 * This class is mutable, thus not thread safe. One reason is this is only a
 * plugin to XMIWriter component, and is not expected to be used in a
 * multi-thread environment. Another reason is transforming is usually a
 * time-consuming process. Synchronization is not very acceptable. The other
 * reason is this class is light weight, and creating an instance is cheap.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class Model2XMITransformer extends AbstractXMITransformer {

    /**
     * The property name used to get the namespace of the ObjectFactory.
     */
    private static final String OBJECTFACTORY_NS_PROPERTY = "objectFactory";
    /**
     * The property name used to get the namespace of the ignoreUnknownElementType.
     */
    private static final String IGNORE_UNKNOWN_TYPE = "ignoreUnknownElementType";
    /**
     * The property name used to get the namespace of the xmiDescription name.
     */
    private static final String XMI_DES = "xmiDescription";
    /**
     * Represents the flag to indicate whether unknown element type should be
     * ignored. if it is true, the unknown element type would be silently
     * ignored. Or else, UnknownElementTypeException would be thrown.
     * <p>
     * It would be initialized in constructor. And can be accessed by
     * corresponding getter and setter.
     * </p>
     *
     */
    private boolean ignoreUnknownElementType;

    /**
     * Represents the XMIDescription used to retrieve XMIElementDescription in
     * this transformer.
     * <p>
     * It will be initialized in the constructor, and never changed later. It
     * can never be null. And can be accessed by its getter.
     * </p>
     *
     */
    private final XMIDescription xmiDescription;

    /**
     * Constructor with the <code>XMIDescription</code> instance and
     * ignoreUnknownElementType.
     *
     * @param xmiDescription
     *            an XMIDescription used in this class(See field doc)
     * @param ignoreUnknownElementType
     *            the igoreUnknonElementType flag.(See field doc)
     * @throws IllegalArgumentException
     *             if xmiDescription is null.
     */
    public Model2XMITransformer(XMIDescription xmiDescription, boolean ignoreUnknownElementType) {
        Helper.checkNull(xmiDescription, "xmiDescription");
        this.ignoreUnknownElementType = ignoreUnknownElementType;
        this.xmiDescription = xmiDescription;
    }

    /**
     * <p>
     * Constructor with the given configuration namespace.
     * </p>
     *
     * <p>
     * The following is the sample configuration:
     * &lt;Property name=&quot;ignoreUnknownElementType&quot;&gt;
     *    &lt;Value&gt;true&lt;/Value&gt;
     * &lt;/Property&gt;
     * &lt;Property name=&quot;objectFactory&quot;&gt;
     *     &lt;Value&gt;com.topcoder.uml.xmi.writer.transformers.model.ObjectFactory&lt;/Value&gt;
     * &lt;/Property&gt;
     * &lt;Property name=&quot;xmiDescription&quot;&gt;
     *   &lt;Value&gt;xmiDescriptionObject&lt;/Value&gt;
     * &lt;/Property&gt;
     * </p>
     *
     * @param namespace
     *            the namespace to load configurations.
     * @throws ConfigurationException
     *             if any other error occurs.
     * @throws IllegalArgumentException
     *             if namespace is null or empty
     */
    public Model2XMITransformer(String namespace) throws ConfigurationException {
        Helper.checkEmptyAndNullString(namespace, "namespace");
        String objectFactoryNS = Helper.getRequiredConfigProperty(namespace, OBJECTFACTORY_NS_PROPERTY);
        this.ignoreUnknownElementType = Boolean.parseBoolean(Helper.getRequiredConfigProperty(namespace,
                IGNORE_UNKNOWN_TYPE));
        String xmiPropertyDes = Helper.getRequiredConfigProperty(namespace, XMI_DES);
        try {
            ObjectFactory objectFactory = new ObjectFactory(new ConfigManagerSpecificationFactory(objectFactoryNS));
            this.xmiDescription = (XMIDescription) objectFactory.createObject(xmiPropertyDes);
        } catch (SpecificationConfigurationException e) {
            // wrap the SpecificationConfigurationException by
            // ConfigurationException
            throw new ConfigurationException(
                    "SpecificationConfigurationException occurs when create the ObjectFactory.", e);
        } catch (IllegalReferenceException e) {
            // wrap the IllegalReferenceException by ConfigurationException
            throw new ConfigurationException("IllegalReferenceException occurs when create the ObjectFactory.", e);
        } catch (InvalidClassSpecificationException e) {
            // wrap the InvalidClassSpecificationException by
            // ConfigurationException
            throw new ConfigurationException(
                    "InvalidClassSpecificationException occurs when get the instances from ObjectFactory.", e);
        } catch (ClassCastException e) {
            throw new ConfigurationException("ClassCastException when create the XMIDescription.", e);
        }
    }

    /**
     * Getter of ignoreUnknownElementType field.
     *
     * <p>
     * Simply return the field
     * </p>
     *
     * @return the ignoreUnknownElementType flag
     */
    public boolean isIgnoreUnknownElementType() {
        return ignoreUnknownElementType;
    }

    /**
     * Setter of ignoreUnknownElementType field. (See field doc for
     * explanation).
     * <p>
     * Simply assign the field
     * </p>
     *
     * @param ignoreUnknownElementType
     *            the new flag value
     */
    public void setIgnoreUnknownElementType(boolean ignoreUnknownElementType) {
        this.ignoreUnknownElementType = ignoreUnknownElementType;
    }

    /**
     * Getter of xmiDescription field. See field doc for explanation.
     * <p>
     * Simply return the field.
     * </p>
     *
     * @return the xmiDescription used in this transformer.
     */
    public XMIDescription getXMIDescription() {
        return xmiDescription;
    }

    /**
     * <p>
     * Transform the given element object and write the transformation result
     * into the out PrintStream object.
     * </p>
     *
     * <p>
     * There is no type restriction on the <code>element</code> parameter, it
     * can be any kind of UML element, as long as it is supported by the
     * xmiDescription. This means if there is a XMIElementDescription
     * corresponding to this element, it could be transformed.
     * </p>
     *
     * @param element
     *            the element to transform.
     * @param out
     *            the PrintStream object to write the transformation data.
     * @throws IllegalArgumentException
     *             if any parameter is null
     * @throws DuplicateElementException
     *             if any element is logically written more than once. (But it
     *             can be referenced more than once.)
     * @throws UnknownElementTypeException
     *             if ignoreUnknownElementType is false, and some element type
     *             is unknown.
     * @throws XMITransformException
     *             if any other occurs (including NodeValueRetrieveException,
     *             DescriptionRetrieveException)
     */
    public void transform(Object element, PrintStream out) throws XMITransformException {
        Helper.checkNull(element, "element");
        Helper.checkNull(out, "PrintStream");

        Set<Object> writtenElements = new HashSet<Object>();
        String xmiString = recursivelyTransformElement(element, false, null, writtenElements);
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.write(xmiString);
            writer.flush();
        } catch (UnsupportedEncodingException e1) {
        } catch (IOException e) {
        }
    }

    /**
     * A mapping from tags which need a special type of child tag if the child
     * tag contains a idref to their expected child tags.
     */
    private static final Map<String, String> CHILD_TAGS = new HashMap<String, String>();
    static {
        CHILD_TAGS.put("UML:ModelElement.namespace", "UML:Namespace");
        CHILD_TAGS.put("UML:Parameter.type", "UML:Classifier");
        CHILD_TAGS.put("UML:StructuralFeature.type", "UML:Classifier");
    }

    /**
     * <p>
     * Transform an element to its according XMI element, this method may
     * invoked recursively, since the element may contain element child.
     * </p>
     *
     * @param element
     *            the element to be transformed.
     * @param isReference
     *            when it is a reference or not.
     * @param refidTag
     *            tag to be used if element is of type REFID
     * @param writtenElements
     *            a set used to store the elements that have been written.
     * @return the value of transformed XMI
     * @throws DuplicateElementException
     *             if any element is logically written more than once. (But it
     *             can be referenced more than once.)
     * @throws UnknownElementTypeException
     *             if ignoreUnknownElementType is false, and some element type
     *             is unknown.
     * @throws XMITransformException
     *             if any other occurs
     */
    private String recursivelyTransformElement(Object element, boolean isReference, String refidTag,
            Set<Object> writtenElements) throws XMITransformException {
        if (element instanceof String) {
            return "<Value>" + element.toString() + "</Value>" + "\n";
        }

        XMIElementDescription elementDesc = null;
        try {
            elementDesc = xmiDescription.getXMIElementDescription(element.getClass());
        } catch (DescriptionRetrievalException e) {
            throw new XMITransformException("can not retrieved the XMI Element Description.", e);
        }
        if (elementDesc == null) {
            if (!ignoreUnknownElementType) {
                throw new UnknownElementTypeException("The type of the element is unknown for the XMIDescription.",
                        element.getClass());
            }
            return "";
        }

        // if the element is not a reference one, check whether it is in the
        // written elements set
        if (!isReference) {
            if (writtenElements.contains(element)) {
                throw new DuplicateElementException("The element is already written to the print Stream.", element);
            }
            writtenElements.add(element);
        }
        // if the element is a reference one, just write it as a reference
        if (isReference) {
            String tag;
            if (refidTag != null) {
                tag = refidTag;
            } else {
                tag = elementDesc.getElementName();
            }
            return "<" + tag + " xmi.idref='" + retrieveId(element) + "'/>" + "\n";
        }

        StringBuilder buffer = new StringBuilder();
        // if it is not a reference one, start the element
        buffer.append("<" + elementDesc.getElementName());
        buffer.append(" xmi.id='" + retrieveId(element) + "'");

        // write the attributes of the element
        List<AttributeDescription> attributes = elementDesc.getAttributes();
        for (AttributeDescription attribute : attributes) {
            // get the value of the attribute
            Object value = attribute.getValue(element);
            if (value == null) {
                continue;
            }

            // fetch the string value according different type
            String stringValue = null;
            if (value instanceof String) {
                stringValue = normalizeString((String) value);
            } else if (value instanceof Enum) {
                stringValue = normalizeEnum((Enum) value);
            } else if (value instanceof Collection) {
                stringValue = buildIDREFS((Collection) value);
            } else if (value instanceof Boolean) {
                stringValue = value.toString();
            } else if (value instanceof Number) {
                stringValue = value.toString();
            } else if (value instanceof Character) {
                stringValue = value.toString();
            } else {
                stringValue = retrieveId(value);
            }
            if (stringValue.trim().length() != 0) {
                // print the string that denote the attribute in the target XMI
                buffer.append(" " + attribute.getName() + "='" + stringValue + "'");
            }
        }
        buffer.append(">" + "\n");

        // write the children elements
        List<ChildDescription> children = elementDesc.getChildren();

        // print each child as an element
        for (ChildDescription child : children) {
            // retrieve the child value in model element
            Object value = child.getValue(element);

            if (value == null) {
                continue;
            }

            String childName = child.getName();
            if (value instanceof String) {
                buffer.append("<" + childName + ">" + normalizeString((String) value) + "</" + childName + ">" + "\n");
            } else if (value instanceof Enum) {
                buffer.append("<" + childName + " xmi.value='" + normalizeEnum((Enum) value) + "'/>" + "\n");
            } else if (value instanceof Boolean) {
                buffer.append("<" + childName + " xmi.value='" + value.toString() + "'/>" + "\n");
            } else if (value instanceof Collection) {
                if (((Collection) value).size() != 0) {
                    buffer.append("<" + childName + ">" + "\n");
                    // recursively writer the instances in the collection
                    for (Object obj : (Collection) value) {
                        buffer.append(recursivelyTransformElement(obj, child.isReference(), CHILD_TAGS
                            .get(elementDesc.getElementName()), writtenElements));
                    }
                    buffer.append("</" + childName + ">" + "\n");
                }
            } else {
                // for the other type, recursively generate the XMI
                buffer.append("<" + childName + ">" + "\n");
                buffer.append(recursivelyTransformElement(value, child.isReference(), CHILD_TAGS.get(childName),
                    writtenElements));
                buffer.append("</" + childName + ">" + "\n");
            }
        }

        // at last close the whole XMI tag
        buffer.append("</" + elementDesc.getElementName() + ">" + "\n");
        return buffer.toString();
    }

    /**
     * Retrieve the id of given element.
     *
     * <p>
     * We first try to retrieve id from parent writer, if there is an id for
     * such element, return the id directly otherwise, generate an id, put
     * element and id pair to writer, and return the id.
     * </p>
     *
     * @return the element id.
     * @param element
     *            the element to retrieve id for
     */
    private String retrieveId(Object element) {
        XMIWriter writer = getXMIWriter();
        String id = null;
        try {
            id = writer.getElementId(element);
        } catch (UnknownElementException e) {
            // let the finally block to generate a new id, and put to the XMIWriter
        } finally {
            // if the id not put into the XMIWriter yet, just generate one and
            // put it to the XMIWriter
            if (id == null) {
                id = "TC_UML_" + UUID.randomUUID().toString();
                try {
                    writer.putElementId(element, id);
                } catch (ElementAlreadyExistsException e) {
                    // ignore the ElementAlreadyExistsException
                }
            }
        }
        return id;
    }

    /**
     * <p>
     * Build a IDREFS value in DTD. An IDREFS is list of id separated by a
     * whitespace. See http://www.w3.org/TR/REC-xml/#idref.
     * </p>
     *
     * <p>
     * No validation on parameter. Because it is a private method, we can guarantee the
     * validity of parameter.
     * </p>
     *
     * @return an IDREFS value containing ids of all the elements.
     * @param elements
     *            a collection of elements
     */
    private String buildIDREFS(Collection elements) {
        StringBuilder idrefs = new StringBuilder();
        for (Object element : elements) {
            if (idrefs.length() > 0) {
                idrefs.append(" ");
            }
            idrefs.append(retrieveId(element));
        }
        return idrefs.toString();
    }

    /**
     * <p>
     * Replace all the escape characters by entity references. See
     * http://www.w3.org/TR/REC-xml/#dt-escape.
     * </p>
     *
     * @return the normalized string value which can be used in XMI correctly.
     * @param value
     *            the string value to be normalized
     */
    private String normalizeString(String value) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == '&') {
                buffer.append("&amp;");
            } else if (c == '>') {
                buffer.append("&gt;");
            } else if (c == '<') {
                buffer.append("&lt;");
            } else if (c == '\'') {
                buffer.append("&apos;");
            } else if (c == '"') {
                buffer.append("&quot;");
            } else {
                // if it is not a special character, just buffer it
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    /**
     * <p>
     * Normalize an Enum value to a String.
     * Just make the first character to be a low case one.
     * </p>
     *
     * <p>
     * No validation on parameter. Because it is a private method, we can guarantee the
     * validity of parameter.
     * </p>
     *
     * @return the normalized enum string.
     * @param value the enum value to be normalized
     */
    private String normalizeEnum(Enum value) {
        StringBuilder buffer = new StringBuilder();
        boolean toCaps = false;
        for (char a : value.toString().toCharArray()) {
            if (a == '_') {
                toCaps = true;
            } else if (toCaps) {
                buffer.append(Character.toUpperCase(a));
                toCaps = false;
            } else {
                buffer.append(Character.toLowerCase(a));
            }
        }
        return buffer.toString();
    }
}
