/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.modelelementformatters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.projectconfiguration.InitialElementFormatter;
import com.topcoder.uml.projectconfiguration.Util;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;

/**
 * <p>
 * This formatter will apply formatting to model elements of
 * Class type that have the &quot;exception&quot; stereotype.
 * </p>
 *
 * <p>
 * This class will be registered to the configuration manager
 * to perform formatting for the Java language.
 * The configuration manager will call format() to perform formatting.
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
public class JavaExceptionElementFormatter extends AbstractElementFormatter implements InitialElementFormatter {
    /**
     * <p>
     * This constant represents the configuration key name for exception stereotype name.
     * </p>
     */
    private static final String EXCEPTION_STEREOTYPE_NAME = "exceptionStereotypeName";

    /**
     * <p>
     * This constant represents the configuration key name for create stereotype name.
     * </p>
     */
    private static final String CREATE_STEREOTYPE_NAME = "createStereotypeName";

    /**
     * <p>
     * This constant represents the configuration key name for string class name.
     * </p>
     */
    private static final String STRING_CLASSNAME = "stringClassName";

    /**
     * <p>
     * This constant represents the configuration key name for throwable class name.
     * </p>
     */
    private static final String THROWABLE_CLASSNAME = "throwableClassName";

    /**
     * <p>
     * This constant represents the name for the string parameter.
     * </p>
     */
    private static final String MESSAGE_PARAMETER = "message";

    /**
     * <p>
     * This constant represents the name for throwable parameter.
     * </p>
     */
    private static final String CAUSE_PARAMETER = "cause";

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
    public JavaExceptionElementFormatter(UMLModelManager umlModelManager, String language) {
        this(JavaExceptionElementFormatter.class.getName(), umlModelManager, language);
    }

    /**
     * <p>Constructs the formatter with the given namespace.</p>
     *
     * @param namespace the non null, non empty(trim'd) namespace used by this formatter
     * @param umlModelManager the non null uml model manager
     * @param language the non null, non empty(trim'd) language
     *
     * @throws IllegalArgumentException if the uml model manager is null or the namespace/language
     * is null/empty(trim'd)
     */
    public JavaExceptionElementFormatter(String namespace, UMLModelManager umlModelManager, String language) {
        super(namespace, umlModelManager, language);
    }

    /**
     * <p>
     * This formatter will apply formatting to model elements of
     * Class type that have the &quot;exception&quot; stereotype.
     * </p>
     *
     * <p>
     * It will add two constructors:
     * <ul>
     * <li>+ExceptionName(message:String)</li>
     * <li>+ExceptionName(message:String,cause:Throwable)</li>
     * </ul>
     * </p>
     *
     * <p>
     * Note, the added constructors will have the &lt;&lt;create&gt;&gt; stereotype.
     * </p>
     *
     * @param element the non null element to be formatted.
     * @return true if the passed in model element was modified, otherwise false.
     *
     * @throws IllegalArgumentException if the element is null.
     * @throws ProjectConfigurationException if any exception
     * is thrown by the methods called.
     */
    public boolean format(ModelElement element) throws ProjectConfigurationException {
        Util.checkNull(element, "element");

        //The element is not a Class, return false.
        if (!(element instanceof Class)) {
            return false;
        }

        Class classElement = (Class) element;

        //Validate the element with the configuration name as "exceptionStereotypeName".
        if (!validateClassByStereotypeName(EXCEPTION_STEREOTYPE_NAME, classElement)) {
            return false;
        }

        //Get the create stereotype with the configuration name as "createStereotypeName".
        Stereotype stereotype = getOperationStereotypeByName(CREATE_STEREOTYPE_NAME);
        Set<Stereotype> stereotypes = new HashSet<Stereotype>();
        stereotypes.add(stereotype);

        //Get the String/Throwable class with the configuration key name as "stringClassName",
        //"throwableClassName"
        Class string = getClassByName(STRING_CLASSNAME);
        Class throwable = getClassByName(THROWABLE_CLASSNAME);

        //Get the name of the element.
        String name = element.getName();

        //Identify the element is modified or not.
        boolean isModified = false;

        //Add an operation with parameter named "message".
        Parameter message = createParameter(MESSAGE_PARAMETER, string);
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameters.add(message);
        if (addOperation(name, VisibilityKind.PUBLIC, stereotypes, parameters, classElement)) {
            isModified = true;
        }

        //Add an operation with two parameters named "message" and "cause".
        message = createParameter(CAUSE_PARAMETER, throwable);
        parameters.add(message);
        if (addOperation(name, VisibilityKind.PUBLIC, stereotypes, parameters, classElement)) {
            isModified = true;
        }

        return isModified;
    }
}
