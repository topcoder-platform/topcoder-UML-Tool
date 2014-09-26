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
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.Util;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.datatypes.VisibilityKind;

/**
 * <p>
 * This formatter will apply formatting to model elements of Class
 * type that have the &quot;Exception&quot; stereotype.
 * </p>
 *
 * <p>
 * This class will be registered to the configuration manager to
 * perform formatting for the C# language.
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
public class CSharpExceptionElementFormatter extends AbstractElementFormatter implements InitialElementFormatter {
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
    private static final String EXCEPTION_CLASSNAME = "exceptionClassName";

    /**
     * <p>
     * This constant represents the configuration key name for serialization info class name.
     * </p>
     */
    private static final String SERIALIZATIONINFO_CLASSNAME = "serializationInfoClassName";

    /**
     * <p>
     * This constant represents the configuration key name for stream context class name.
     * </p>
     */
    private static final String STREAMINGCONTEXT_CLASSNAME = "streamingContextClassName";

    /**
     * <p>
     * This constant represents the name for the string parameter.
     * </p>
     */
    private static final String MESSAGE_PARAMETER = "message";

    /**
     * <p>
     * This constant represents the name for exception parameter.
     * </p>
     */
    private static final String INNEREXCEPTION_PARAMETER = "innerException";

    /**
     * <p>
     * This constant represents the name for serialization info parameter.
     * </p>
     */
    private static final String INFO_PARAMETER = "info";

    /**
     * <p>
     * This constant represents the name for stream context parameter.
     * </p>
     */
    private static final String CONTEXT_PARAMETER = "context";

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
    public CSharpExceptionElementFormatter(UMLModelManager umlModelManager, String language) {
        this(CSharpExceptionElementFormatter.class.getName(), umlModelManager, language);
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
    public CSharpExceptionElementFormatter(String namespace, UMLModelManager umlModelManager, String language) {
        super(namespace, umlModelManager, language);
    }

    /**
     * <p>
     * This formatter will apply formatting to model elements of
     * Class type that have the &quot;Exception&quot; stereotype.
     * </p>
     *
     * <p>
     * It will add four constructors:
     * <ul>
     * <li>+ExceptionName()</li>
     * <li>+ExceptionName(message:string)</li>
     * <li>+ExceptionName(message:string,innerException:Exception)</li>
     * <li>#ExceptionName(info:SerializationInfo,context:StreamingContext)</li>
     * </ul>
     * </p>
     *
     * <p>
     * Note, The added constructors will have the &lt;&lt;create&gt;&gt; stereotype.
     * </p>
     *
     * @param element the non null element to be formatted
     * @return true if the passed in object was modified, otherwise false.
     *
     * @throws IllegalArgumentException if the element is null
     * @throws ProjectConfigurationException if any exception
     * is thrown by the methods called
     */
    public boolean format(ModelElement element) throws ProjectConfigurationException {
        Util.checkNull(element, "element");

        //The element is not a Class, return false.
        if (!(element instanceof Class)) {
            return false;
        }

        Class classElement = (Class) element;

        //Validate the element with the configuration key name as "exceptionStereotypeName".
        if (!validateClassByStereotypeName(EXCEPTION_STEREOTYPE_NAME, classElement)) {
            return false;
        }

        //Get the create stereotype with the configuration key name as "createStereotypeName".
        Stereotype stereotype = getOperationStereotypeByName(CREATE_STEREOTYPE_NAME);
        Set<Stereotype> stereotypes = new HashSet<Stereotype>();
        stereotypes.add(stereotype);

        //Get the String/Exception/SerializationInfo/StreamingContext class with the configuration
        //key name as "stringClassName", "exceptionClassName", "serializationInfoClassName" and
        //"streamingContextClassName".
        Class string = getClassByName(STRING_CLASSNAME);
        Class exception = getClassByName(EXCEPTION_CLASSNAME);
        Class serializationInfo = getClassByName(SERIALIZATIONINFO_CLASSNAME);
        Class StreamingContext = getClassByName(STREAMINGCONTEXT_CLASSNAME);

        //Get the name of the element.
        String name = element.getName();

        //Identify the element is modified or not.
        boolean isModified = false;

        //Add an operation with no parameter.
        if (addOperation(name, VisibilityKind.PUBLIC, stereotypes, null, classElement)) {
            isModified = true;
        }

        //Add an operation with parameter named "message".
        Parameter message = createParameter(MESSAGE_PARAMETER, string);
        List<Parameter> parameters = new ArrayList<Parameter>();
        parameters.add(message);
        if (addOperation(name, VisibilityKind.PUBLIC, stereotypes, parameters, classElement)) {
            isModified = true;
        }

        //Add an operation with two parameters named "message" and "innerException".
        message = createParameter(INNEREXCEPTION_PARAMETER, exception);
        parameters.add(message);
        if (addOperation(name, VisibilityKind.PUBLIC, stereotypes, parameters, classElement)) {
            isModified = true;
        }

        //Add an operation with two parameters named "info" and "context".
        message = createParameter(INFO_PARAMETER, serializationInfo);
        parameters.clear();
        parameters.add(message);
        message = createParameter(CONTEXT_PARAMETER, StreamingContext);
        parameters.add(message);
        if (addOperation(name, VisibilityKind.PROTECTED, stereotypes, parameters, classElement)) {
            isModified = true;
        }

        return isModified;
    }
}
