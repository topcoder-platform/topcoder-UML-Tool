/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.modelelementformatters;

import java.util.HashSet;
import java.util.Set;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.projectconfiguration.InitialElementFormatter;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.Util;

/**
 * <p>
 * This formatter will apply formatting to model elements of
 * Class type that have the &quot;enumeration&quot; stereotype.
 * </p>
 *
 * <p>
 * This class will be registered to the configuration manager to perform
 * formatting for the Java1.4 language.
 * The project configuration manager will call format() to perform
 * formatting.
 * </p>
 *
 * <p>
 * Note, it will be created by the client application directly.
 * </p>
 *
 * <p>
 * Thread Safety: This class is thread-safe by be immutable.
 * </p>
 *
 * @author kinzz, biotrail
 * @version 1.0
 */
public class Java14EnumElementFormatter extends AbstractElementFormatter implements InitialElementFormatter {
    /**
     * <p>
     * This constant represents the configuration key name for enum stereotype name.
     * </p>
     */
    private static final String ENUM_STEREOTYPE_NAME = "enumStereotypeName";

    /**
     * <p>
     * This constant represents the configuration key name for create stereotype name.
     * </p>
     */
    private static final String CREATE_STEREOTYPE_NAME = "createStereotypeName";

    /**
     * <p>
     * This constant represents the configuration key name for enum class name.
     * </p>
     */
    private static final String ENUM_CLASSNAME = "enumClassName";

    /**
     * <p>
     * Constructs the formatter with the class name as the namespace.
     * </p>
     *
     * @param umlModelManager the non null uml model manager.
     * @param language the non null, non empty language.
     *
     * @throws IllegalArgumentException if the uml model manager
     * is null or the language is null/empty.
     */
    public Java14EnumElementFormatter(UMLModelManager umlModelManager, String language) {
        this(Java14EnumElementFormatter.class.getName(), umlModelManager, language);
    }

    /**
     * <p>
     * Constructs the formatter with the given namespace.
     * </p>
     *
     * @param namespace the non null, non empty namespace used by this formatter.
     * @param umlModelManager the non null uml model manager.
     * @param language the non null, non empty language.
     *
     * @throws IllegalArgumentException if the uml model manager
     * is null or the namespace/language is null/empty.
     */
    public Java14EnumElementFormatter(String namespace, UMLModelManager umlModelManager, String language) {
        super(namespace, umlModelManager, language);
    }

    /**
     * <p>
     * This formatter will apply formatting to model elements of Class type
     * that have the &quot;enumeration&quot; stereotype.
     * </p>
     *
     * <p>
     * Note, it will add a private constructor with no arguments and will add a
     * Generalization relationship towards Enum class from type Safe Enum component.
     * The constructors will have the &lt;&lt;create&gt;&gt; stereotype.
     * </p>
     *
     * @param element the non null element to be formatted.
     * @return true if the passed in object was modified, otherwise false.
     *
     * @throws IllegalArgumentException if the element is null.
     * @throws ProjectConfigurationException if any exception is
     * thrown by the methods called.
     */
    public boolean format(ModelElement element) throws ProjectConfigurationException {
        Util.checkNull(element, "element");

        //The element is not a Class, return false.
        if (!(element instanceof Class)) {
            return false;
        }

        Class classElement = (Class) element;

        //Validate the element with the configuration name as "enumStereotypeName".
        if (!validateClassByStereotypeName(ENUM_STEREOTYPE_NAME, classElement)) {
            return false;
        }

        //Get the create stereotype with the configuration name as "createStereotypeName".
        Stereotype stereotype = getOperationStereotypeByName(CREATE_STEREOTYPE_NAME);
        Set<Stereotype> stereotypes = new HashSet<Stereotype>();
        stereotypes.add(stereotype);

        Class enumClass = getClassByName(ENUM_CLASSNAME);

        //Get the name of the element.
        String name = element.getName();

        //Identify the element is modified or not.
        boolean isModified = false;

        //Add an operation with no parameter.
        if (addOperation(name, VisibilityKind.PRIVATE, stereotypes, null, classElement)) {
            isModified = true;
        }

        //Create a Generalization,set the child to classElement
        //and set the parent to the enumClass.
        Generalization relationship = new GeneralizationImpl();
        relationship.setChild(classElement);
        relationship.setParent(enumClass);

        //If the relationship is not contained, add it to the element.
        if (!classElement.containsGeneralization(relationship)) {
            classElement.addGeneralization(relationship);
            isModified = true;
        }

        return isModified;
    }
}
