/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model.xmidescription;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.Property;
import com.topcoder.util.config.UnknownNamespaceException;
import com.topcoder.xmi.writer.transformers.model.AttributeDescription;
import com.topcoder.xmi.writer.transformers.model.ChildDescription;
import com.topcoder.xmi.writer.transformers.model.ConfigurationException;
import com.topcoder.xmi.writer.transformers.model.DescriptionRetrievalException;
import com.topcoder.xmi.writer.transformers.model.Helper;
import com.topcoder.xmi.writer.transformers.model.XMIDescription;
import com.topcoder.xmi.writer.transformers.model.XMIElementDescription;


/**
 * An implementation of XMIDescription interface. It uses reflection to retrieve
 * XMI descriptions for given TC UML element type. This implementation assumes
 * TC UML Model is well fitted into OMG DTD.
 * <p>
 * It uses the "getXXX" methods to determine the element attributes and children
 * name. The methods which return Boolean or Enum will be mapped to an
 * attribute. The methods which return String, Collection or other objects will
 * be mapped to a child element. Please see CS for details.
 * </p>
 * <p>
 * Because some additional methods are defined in TC UML Model, which are not
 * defined in OMG DTD, we would exclude such methods via configuration. And some
 * children are stored by references, the configuration is also used to indicate
 * whether some child is logically contained or not. Please see CS and sample
 * configuration file for details.
 * </p>
 * <p>
 * The XMIElementDescription is retrieved lazily, and also cached.
 * </p>
 * <p>
 * This class not thread-safe, since it is mutable. All the relationships associated with
 * XMIDescription are implicitly applicable to this class.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public class ReflectedXMIDescription implements XMIDescription {

    /**
     * Represents the known package name. Only classes or interfaces from this
     * package or its sub-package, we will deal with. It is a constant.
     *
     */
    public static final String KNOWN_PACKAGE = "com.topcoder.uml";
    /**
     * The property name used to get the excluded methods.
     */
    private static final String EXCLUDED_METHODS = "excludedMethods";
    /**
     * The property name used to get the containedNodes.
     */
    private static final String CONTAINED_NODES = "containedNodes";
    /**
     * The prefix of the element name of the XMIElementDescription.
     */
    private static final String DES_NAME_PREFIX = "UML:";
    /**
     * Represents of all the cached Class/XMIElement map. The key is non-null
     * Class instance(an interface actually), representing a TC UML model
     * element type. The value is non-null XMIElement instance, representing
     * corresponding XMIElement of the type.
     * <p>
     * It will be instantiated in constructor and itself never changed later. It
     * will be empty initially, and will be filled in getXMIElement method. It
     * acts as a cache to hold type/element match.
     * </p>
     *
     */
    private final Map<Class, XMIElementDescription> xmiElements = new HashMap <Class, XMIElementDescription>();

    /**
     * Represents of the excludedMethods for specific classes or interfaces. The
     * key is non-null and non-empty string, representing interface full name in
     * UML Model, like UMLElement. The key is a set, containing non-null and
     * non-empty string, Element of set represents method name in interface. It
     * means that the returned value of the methods shouldn't written to XMI.
     * <p>
     * It will be instantiated and filled in constructor. Both itself and its
     * content will never be changed later. This field will be used in
     * getXMIElement method to exclude some nodes.
     * </p>
     *
     */
    private final Map<String, Set<String>> excludedMethods = new HashMap <String, Set<String>>();

    /**
     * Represents of the logically contained nodes for specific classes or
     * interfaces. The key is non-null and non-empty string, representing
     * interface name in UML Model, like com.topcoder.uml.Model.UMLElement. The
     * key is a set, containing non-null and non-empty string, Element of set
     * represents node names in interface. It means that the specified node
     * should logically contained in the element. All others not listed here
     * will be considered references.
     * <p>
     * It will be instantiated and filled in constructor. Both itself and its
     * content will never be changed later. This field will be used in
     * getXMIElement method to determine whether some node is logically
     * contained.
     * </p>
     *
     */
    private final Map<String, Set<String>> containedNodes = new HashMap <String, Set<String>>();

    /**
     * Constructor with the configuration namespace.
     * This constructor will fill the excludedMethods and containedNodes map.
     *
     * <p>
     * The following is the sample configuration:
     * &lt;Property name=&quot;Interface1&quot;&gt;
     *     &lt;Property name=&quot;excludedMethods&quot;&gt;
     *       &lt;Value&gt;getExcluded&lt;/Value&gt;
     *     &lt;/Property&gt;
     *      &lt;Property name=&quot;containedNodes&quot;&gt;
     *        &lt;Value&gt;innerBean&lt;/Value&gt;
     *      &lt;/Property&gt;
     * &lt;/Property&gt;
     * </p>
     * @param namespace
     *            the namespace to load configurations
     * @throws IllegalArgumentException
     *             if given namespace is a null or empty string(trimmed).
     * @throws ConfigurationException
     *             if any other error occurs
     */
    public ReflectedXMIDescription(String namespace) throws ConfigurationException {
        Helper.checkEmptyAndNullString(namespace, "namespace");
        ConfigManager cm = ConfigManager.getInstance();

        try {
            //get all the first level properties of the namespace
            Enumeration interfaces = cm.getPropertyNames(namespace);

            //for each interface property create its excludedMethods and containedNodes
            while (interfaces.hasMoreElements()) {
                String interfaceName = (String) interfaces.nextElement();
                Property property = cm.getPropertyObject(namespace, interfaceName);
                //get the excluded method property and create its excluded methods element set
                String [] excludedMethodElements = property.getValues(EXCLUDED_METHODS);
                //if excluded methods exists, put is to the excludedMethods map
                if (excludedMethodElements != null) {
                    excludedMethods.put(interfaceName, new HashSet <String>(Arrays.asList(excludedMethodElements)));
                }
                //get the contained node elements
                String [] containedNodeElements = property.getValues(CONTAINED_NODES);
                if (containedNodeElements != null) {
                    containedNodes.put(interfaceName, new HashSet <String>(Arrays.asList(containedNodeElements)));
                }
            }
        } catch (UnknownNamespaceException e) {
            throw new ConfigurationException("The namespace " + namespace + " is unknown.", e);
        }
    }

    /**
     * Get XMIElement for specified type from TC UML Model.
     *
     *
     * @return corresponding XMIElement for the type, or null if the type cann't
     *         be supported.
     * @param type
     *            the uml model element type
     * @throws IllegalArgumentException
     *             if given type is null
     * @throws DescriptionRetrievalException
     *             if any error occurs while retrieving the description.
     */
    public XMIElementDescription getXMIElementDescription(Class type) throws DescriptionRetrievalException {
        Helper.checkNull(type, "type");
        Class targetInterface = null;

        if (!type.isInterface()) {
            Class [] interfaces = type.getInterfaces();
            //select a interface that under the package 'com.topcoder.uml'
            for (int i = 0; i < interfaces.length; i++) {
                if (interfaces[i].getPackage().getName().startsWith(KNOWN_PACKAGE)) {
                    targetInterface = interfaces[i];
                    break;
                }
            }
        }
        if(targetInterface == null) {
            targetInterface = type;
        }
        //check type
        if (!targetInterface.getPackage().getName().startsWith(KNOWN_PACKAGE)) {
            return null;
        }
        //check whether it is in the cache
        if (xmiElements.containsKey(targetInterface)) {
            return xmiElements.get(targetInterface);
        }

        String interfaceSimpleName = targetInterface.getSimpleName();
        //create the XMIElementDescription instance
        XMIElementDescription elementDescription
            = new XMIElementDescription(DES_NAME_PREFIX + interfaceSimpleName, targetInterface);
        //get all the method of the interface
        Method [] methods = targetInterface.getMethods();
        for(Method currentMethod: methods) {
            //if the method contains any parameter, just ignore
            if (currentMethod.getParameterTypes().length != 0) {
                continue;
            }
            String methodName = currentMethod.getName();
            Set <String> methodSet = excludedMethods.get(currentMethod.getDeclaringClass().getSimpleName());

            //if the method is configured as excluded methods, just ignore it
            if (methodSet != null && methodSet.contains(methodName)) {
                continue;
            }
            //method start 'is', we consider it as a Boolean Attribute
            if (methodName.startsWith("is")) {
                elementDescription.addAttribute(new AttributeDescription(methodName, currentMethod));
                continue;
            }
            //otherwise the method must be a get method, if it is not a get method, simple return
            if (!methodName.startsWith("get")) {
                continue;
            }

            Class returnType = currentMethod.getReturnType();

            String childName = null;
            //if the return type is an instance of enum or primitive
            if (returnType.isEnum() || returnType.isPrimitive()) {
                elementDescription.addAttribute(new AttributeDescription(Helper.firstLetterToLowCase(methodName
                    .substring(3)), currentMethod));
                continue;
            }
            if (String.class.isAssignableFrom(returnType)
                    || returnType.getPackage().getName().startsWith(KNOWN_PACKAGE)) {
                // if the type is String, or the returnType is a type in the Known package, considered as
                // a normal getter
                childName = Helper.firstLetterToLowCase(methodName.substring(3));
            } else if (Collection.class.isAssignableFrom(returnType)) {
                // if the method name is too short for a getter method, just skip(6 means 'get'.length
                // + remove last 3 letter)
                if (methodName.length() <= 6) {
                    continue;
                }
                String newMethodName = "add" + methodName.substring(3, methodName.length() - 3);
                Method newMethod = null;
                // find the method start with the new method name,
                // if the initial getter is getNamespaces, then the new method is addNamespa(remove the
                // last three letter)
                // and the method should be contains only one parameter
                for (Method addMethod : methods) {
                    if (addMethod.getName().startsWith(newMethodName)
                            && addMethod.getParameterTypes().length == 1
                            && (addMethod.getParameterTypes()[0].getPackage().getName().startsWith(KNOWN_PACKAGE)
                                    || String.class.isAssignableFrom(addMethod.getParameterTypes()[0]))) {
                        //find one, stop finding, the parameter must be
                        newMethod = addMethod;
                        break;
                    }
                }
                //no method is found, just continue;
                if (newMethod == null) {
                    continue;
                }
                //remove the add, and let the first let of the method to be low case
                childName = Helper.firstLetterToLowCase(newMethod.getName().substring(3));
            } else {
                continue;
            }
            String childDesName = DES_NAME_PREFIX + currentMethod.getDeclaringClass().getSimpleName() + "." + childName;
            boolean referenceFlag = false;
            String ownerName = currentMethod.getDeclaringClass().getSimpleName();
            //if the type is not a String, check the reference flag in containedNodeElement map
            if (!String.class.isAssignableFrom(returnType)) {
                Set <String> elements = containedNodes.get(ownerName);
                //the reference flag mean the set not contains this childName
                referenceFlag = (elements == null || (!elements.contains(childName)));
            }
            elementDescription.addChild(new ChildDescription(childDesName, currentMethod, referenceFlag));
        }

        //put it to the cache
        xmiElements.put(targetInterface, elementDescription);
        return elementDescription;
    }
}
