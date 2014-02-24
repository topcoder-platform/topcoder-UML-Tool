/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.modelelementformatters;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.Util;

/**
 * <p>
 * This formatter will provide general function for its subclass,
 * <ul>
 * <li>creating parameter</li>
 * <li>validate class</li>
 * <li>add operation to class</li>
 * <li>get operation and class</li>
 * </ul>
 * </p>
 *
 * <p>
 * Note, in the current implementation, it will be extend by JavaExceptionElementFormatter,
 * CSharpExceptionElementFormatter and Java14EnumElementFormatter.
 * </p>
 *
 * <p>
 * Sample Configuration :
 * &lt;Property name=&quot;exceptionStereotypeName&quot;&gt;
 *     &lt;Value&gt;exception&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;enumStereotypeName&quot;&gt;
 *     &lt;Value&gt;enum&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;createStereotypeName&quot;&gt;
 *     &lt;Value&gt;create&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;stringClassName&quot;&gt;
 *     &lt;Value&gt;String&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;enumClassName&quot;&gt;
 *     &lt;Value&gt;Enum&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;throwableClassName&quot;&gt;
 *     &lt;Value&gt;Throwable&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;exceptionClassName&quot;&gt;
 *     &lt;Value&gt;Exception&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;serializationInfoClassName&quot;&gt;
 *     &lt;Value&gt;SerializationInfo&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;streamingContextClassName&quot;&gt;
 *     &lt;Value&gt;StreamingContext&lt;/Value&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;operationStereotypeBaseClass&quot;&gt;
 *     &lt;Value&gt;Operation&lt;/Value&gt;
 * &lt;/Property&gt;
 *
 * &lt;Property name=&quot;standardClassDataLoader&quot;&gt;
 *     &lt;Property name=&quot;type&quot;&gt;
 *         &lt;Value&gt;com.topcoder.uml.projectconfiguration.MockStandardClassDataLoader&lt;/Value&gt;
 *     &lt;/Property&gt;
 * &lt;/Property&gt;
 * &lt;Property name=&quot;stereotypeLoader&quot;&gt;
 *     &lt;Property name=&quot;type&quot;&gt;
 *         &lt;Value&gt;com.topcoder.uml.projectconfiguration.stereotypeloader.XMLStereotypeLoader&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name=&quot;params&quot;&gt;
 *         &lt;Property name=&quot;param1&quot;&gt;
 *             &lt;Property name=&quot;type&quot;&gt;
 *                 &lt;Value&gt;String&lt;/Value&gt;
 *             &lt;/Property&gt;
 *             &lt;Property name=&quot;value&quot;&gt;
 *                 &lt;Value&gt;namespace&lt;/Value&gt;
 *             &lt;/Property&gt;
 *         &lt;/Property&gt;
 *     &lt;/Property&gt;
 * &lt;/Property&gt;
 * </p>
 *
 * <p>
 * Thread Safety: this class is immutable and so is thread safe.
 * </p>
 *
 * @author kinzz, biotrail
 * @version 1.0
 */
abstract class AbstractElementFormatter {
    /**
     * <p>
     * This constant represents the configuration key name for operation stereotype base class.
     * </p>
     */
    private static final String OPERATION_STEREOTYPE_BASECLASS = "operationStereotypeBaseClass";

    /**
     * <p>
     * Represents the language used by this formatter.
     * </p>
     *
     * <p>
     * Note, it will be set in the constructor, is immutable (the reference) and
     * will never be null/empty.
     * </p>
     *
     * <p>
     * It is referenced in the format method.
     * </p>
     */
    private final String language;

    /**
     * <p>
     * Represents the namespace used by this formatter.
     * </p>
     *
     * <p>
     * Note, it will be set in the constructor, is immutable (the reference) and will
     * never be null/empty.
     * </p>
     *
     * <p>
     * It is referenced in the format method.
     * </p>
     */
    private final String namespace;

    /**
     * <p>
     * Represents the UML model manager used by this formatter.
     * </p>
     *
     * <p>
     * Note, it will be set in the constructor, is immutable (the reference) and will
     * never be null/empty.
     * </p>
     *
     * <p>
     * It is referenced in the format() method.
     * </p>
     */
    private final UMLModelManager umlModelManager;

    /**
     * <p>
     * Constructs the formatter with the given namespace.
     * </p>
     *
     * @param namespace the non null, non empty namespace used by this formatter
     * @param umlModelManager the non null uml model manager
     * @param language the non null, non empty language
     *
     * @throws IllegalArgumentException if the uml model manager is null or the namespace/language is null/empty
     */
    protected AbstractElementFormatter(String namespace, UMLModelManager umlModelManager, String language) {
        Util.checkString(namespace, "namespace");
        Util.checkString(language, "language");
        Util.checkNull(umlModelManager, "umlModelManager");

        this.namespace = namespace;
        this.umlModelManager = umlModelManager;
        this.language = language;
    }

    /**
     * <p>
     * Get the UML model manager used by this formatter.
     * </p>
     *
     * @return the non null UML model manager used by this formatter
     */
    public UMLModelManager getUMLModelManager() {
        return umlModelManager;
    }

    /**
     * <p>
     * Get the language of this formatter.
     * </p>
     *
     * @return the non null language of this formatter.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * <p>
     * Get the namespace of this formatter.
     * </p>
     *
     * @return the non null namespace of this formatter.
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * <p>
     * Validate the given class by the given stereotype key name.
     * </p>
     *
     * <p>
     * It will get the actual stereotype name from the configuration file.
     * And check whether there is a name of the stereotypes of the class is
     * equal to the configured name.
     * </p>
     *
     * @param keyOfStereotypeName the non null, non empty key of the stereotype,
     * used to get the name from the configuration file.
     * @param classType the non null class to be validated.
     * @return true if the class is valid, otherwise false.
     *
     * @throws IllegalArgumentException if the class is null or the name is null/empty
     * @throws ProjectConfigurationException if any exception occurs trying to
     * get the configuration information
     */
    protected boolean validateClassByStereotypeName(String keyOfStereotypeName, Class classType)
        throws ProjectConfigurationException {
        Util.checkString(keyOfStereotypeName, "keyOfStereotypeName");
        Util.checkNull(classType, "classType");

        // Get the stereotype name
        String stereotypeName = Util.getString(namespace, keyOfStereotypeName);

        // Check there is a name of the stereotypes of the class is equal to the
        // stereotypeName, if one then return true.
        Collection<Stereotype> stereotypes = classType.getStereotypes();
        return getStereotype(stereotypeName, stereotypes) != null;
    }

    /**
     * <p>
     * Get the stereotype instance with the given stereotype key name.
     * </p>
     *
     * <p>
     * It will get the actual stereotype name from the configuration file.
     * And check whether there is a name of the stereotypes in
     * the element is equal to the configured name. If no, then a new
     * stereotype will be created and returned.
     * </p>
     *
     * @param keyOfStereotypeName the non null, non empty key of the stereotype,
     * used to get the name from the configuration file.
     * @return the non null stereotype.
     *
     * @throws IllegalArgumentException if the name is null/empty.
     * @throws ProjectConfigurationException if any exception occurs trying to
     * get the configuration information.
     * @throws IllegalStateException if fails to get the project configuration
     * manager from the model manager.
     */
    protected Stereotype getOperationStereotypeByName(String keyOfStereotypeName) throws ProjectConfigurationException {
        Util.checkString(keyOfStereotypeName, "keyOfStereotypeName");

        // Get the stereotype name from the configuration file
        String stereotypeName = Util.getString(namespace, keyOfStereotypeName);

        Collection<Stereotype> stereotypes = umlModelManager.getModel().getStereotypes();

        // if the stereotype is found, then use it directly, otherwise a new stereotype will be created
        Stereotype stereotype = getStereotype(stereotypeName, stereotypes);
        if (stereotype == null) {
            // create Stereotype
            stereotype = new StereotypeImpl();

            // set name, baseClass attribute and apply initial formatting
            stereotype.setName(stereotypeName);
            stereotype.setBaseClass(Util.getString(namespace, OPERATION_STEREOTYPE_BASECLASS));

            umlModelManager.getProjectConfigurationManager().applyInitialFormatting(language, stereotype);
        }

        return stereotype;
    }

    /**
     * <p>
     * Get the class with the given class key name.
     * </p>
     *
     * <p>
     * It will get the actual class name from the configuration file.
     * And check whether there is a name of the classes in the element
     * is equal to the configured name. If no, then a new Class will
     * be created and returned.
     * </p>
     *
     * @param keyOfClassName the non null, non empty key of the class,
     * used to get the name from the configuration file.
     * @return the non null class.
     *
     * @throws IllegalArgumentException if the name is null/empty.
     * @throws ProjectConfigurationException if any exception occurs
     * trying to get the configuration information.
     * @throws IllegalStateException if fails to get the project configuration
     * manager from the model manager.
     */
    protected Class getClassByName(String keyOfClassName) throws ProjectConfigurationException {
        Util.checkString(keyOfClassName, "keyOfClassName");

        //Get the class name
        String className = Util.getString(namespace, keyOfClassName);

        Model model = umlModelManager.getModel();
        Collection<ModelElement> elements = model.getOwnedElements();

        //Check whether there is a name of the elements is equal to the className,
        //if one is equal return the model element.
        for (ModelElement modelElement : elements) {
            if (modelElement instanceof Class && className.equals(modelElement.getName())) {
                return (Class) modelElement;
            }
        }

        //create class, set name attribute and apply initial formatting
        Class classType = new ClassImpl();
        classType.setName(className);

        umlModelManager.getProjectConfigurationManager().applyInitialFormatting(language, classType);

        return classType;
    }

    /**
     * <p>
     * Add the operation with the given properties to the class.
     * </p>
     *
     * <p>
     * Note, this method will always return true because the operation will
     * always be added and no comparison is done.
     * </p>
     *
     * @param name the non null, non empty name of the operation.
     * @param visibility the non null visibility of the operation.
     * @param stereotypes the possible null stereotypes of the operation.
     * @param parameters the possible null parameters of the operation.
     * @param classType the non null class to add the operation.
     *
     * @return true since the operation will always be added and no comparison
     * is done.

     * @throws IllegalArgumentException if the name is null/empty or
     * the class/visibility is null, or the stereotypes or parameters contains
     * null element
     * @throws ProjectConfigurationException if any exception occurs
     * trying to get the configuration information.
     * @throws IllegalStateException if fails to get the project configuration
     * manager from the model manager.
     */
    protected boolean addOperation(String name, VisibilityKind visibility, Set<Stereotype> stereotypes,
        List<Parameter> parameters, Class classType) throws ProjectConfigurationException {
        Util.checkString(name, "name");
        Util.checkNull(visibility, "visibility");
        Util.checkNull(classType, "classType");

        // stereotypes can be null but can not contain null element
        if (stereotypes != null) {
            if (stereotypes.contains(null)) {
                throw new IllegalArgumentException("Stereotypes contains null element.");
            }
        }

        // parameters can be null but can not contain null element
        if (parameters != null) {
            if (parameters.contains(null)) {
                throw new IllegalArgumentException("Parameters contains null element.");
            }
        }

        //create an operation, set the name and the visibility.
        Operation operation = new OperationImpl();
        operation.setName(name);
        operation.setVisibility(visibility);

        //add the stereotypes to the operation.
        if (stereotypes != null) {
            for (Stereotype stereotype : stereotypes) {
                operation.addStereotype(stereotype);
            }
        }

        //add the parameters to the operation.
        if (parameters != null) {
            for (Parameter parameter : parameters) {
                operation.addParameter(parameter);
            }
        }

        //Apply initial formatting for the operation
        umlModelManager.getProjectConfigurationManager().applyInitialFormatting(language, operation);

        //Add the operation to the class
        classType.addFeature(operation);

        return true;
    }

    /**
     * <p>
     * Create a parameter with the given name and type.
     * <p>
     *
     * @param name the non null, non empty name of the parameter.
     * @param type the non null type of the parameter.
     * @return the non null parameter.
     *
     * @throws IllegalArgumentException if the name is null/empty or
     * the class is null.
     * @throws ProjectConfigurationException if any exception occurs
     * trying to get the configuration information.
     * @throws IllegalStateException if fails to get the project configuration
     * manager from the model manager.
     */
    protected Parameter createParameter(String name, Class type) throws ProjectConfigurationException {
        Util.checkString(name, "name");
        Util.checkNull(type, "type");

        //create an parameter, set the name and the type.
        Parameter parameter = new ParameterImpl();
        parameter.setName(name);
        parameter.setType(type);

        //Apply initial formatting for the parameter
        umlModelManager.getProjectConfigurationManager().applyInitialFormatting(language, parameter);

        return parameter;
    }

    /**
     * <p>
     * Return the stereotype in the given stereotype collection with the given stereotype name.
     * </p>
     *
     * <p>
     * Note, null will be returned if the stereotype name is not found in all the stereotypes in
     * the given collection.
     * </p>
     *
     * @param stereotypeName the name of the stereotype
     * @param stereotypes a collection of stereotype
     *
     * @return the stereotype in the given collection with the given stereotype name, if not found,
     * null will be returned.
     */
    private Stereotype getStereotype(String stereotypeName, Collection<Stereotype> stereotypes) {
        // iterator all the stereotypes to searching the stereotype
        for (Stereotype stereotype : stereotypes) {
            if (stereotypeName.equals(stereotype.getName())) {
                return stereotype;
            }
        }

        // not found, null will be returned
        return null;
    }
}
