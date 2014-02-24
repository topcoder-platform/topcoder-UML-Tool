/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgument;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.modelmanagement.ElementImport;
import com.topcoder.uml.model.statemachines.StateMachine;

/**
 * This class has all the static variables and repeated codes that can be used across.
 * <p>
 * <Strong>Thread Safety :</Strong> This class has all final variables hence it is immutable.
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
final class Helper {

    /**
     * Represents the "Return Message" value to be used while calling the
     * {@linkplain #checkMessage(MessageUtil, Stimulus, String)} function.
     */
    public static final String RETURN_MESSAGE = "Return Message";

    /**
     * Represents the "Asynchronous Message" value to be used while calling the
     * {@linkplain #checkMessage(MessageUtil, Stimulus, String)} function.
     */
    public static final String ASYNCHRONOUS_MESSAGE = "Asynchronous Message";

    /**
     * Represents the "Create Message" value to be used while calling the
     * {@linkplain #checkMessage(MessageUtil, Stimulus, String)} function.
     */
    public static final String CREATE_MESSAGE = "Create Message";

    /**
     * Represents the "Send Signal Message" value to be used while calling the
     * {@linkplain #checkMessage(MessageUtil, Stimulus, String)} function.
     */
    public static final String SEND_SIGNAL_MESSAGE = "Send Signal Message";

    /**
     * Represents the "Synchronous Message" value to be used while calling the
     * {@linkplain #checkMessage(MessageUtil, Stimulus, String)} function.
     */
    public static final String SYNCHRONOUS_MESSAGE = "Synchronous Message";

    /**
     * Private empty constructor.
     */
    private Helper() {
        // empty constructor.
    }

    /**
     * Check if the object is <code>null</code>.
     *
     * @param obj
     *            the object to check.
     * @param name
     *            the object name
     * @throws IllegalArgumentException
     *             if the object is <code>null</code>.
     */
    public static void checkObjectNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>
     * Checks whether the <code>stimulus</code> is of the <code>messageType</code> using the
     * <code>messageUtil</code> passed. If the <code>stimulus</code> is not of the expected type
     * {@linkplain SequenceConfigurationException} is thrown.
     * </p>
     *
     * @param messageUtil
     *            the message utility that is used to check the message type of the <code>stimulus</code>.
     * @param stimulus
     *            which need to be checked for the correct message type.
     * @param messageType
     *            this should be one of the five message type declared in this class.
     * @throws SequenceConfigurationException
     *             when instance of stimulus is incorrect for this action
     */
    public static void checkMessage(MessageUtil messageUtil, Stimulus stimulus, String messageType)
        throws SequenceConfigurationException {
        boolean valid = false;
        if (messageType.equals(ASYNCHRONOUS_MESSAGE)) {
            valid = messageUtil.checkAsynchronousMessage(stimulus);
        } else if (messageType.equals(CREATE_MESSAGE)) {
            valid = messageUtil.checkCreateMessage(stimulus);
        } else if (messageType.equals(RETURN_MESSAGE)) {
            valid = messageUtil.checkReturnMessage(stimulus);
        } else if (messageType.equals(SEND_SIGNAL_MESSAGE)) {
            valid = messageUtil.checkSendSignalMessage(stimulus);
        } else if (messageType.equals(SYNCHRONOUS_MESSAGE)) {
            valid = messageUtil.checkSynchronousMessage(stimulus);
        }
        if (!valid) {
            throw new SequenceConfigurationException("Stimulus passed should be of message type '" + messageType
                    + "'");
        }
    }

    /**
     * <p>
     * Copies the following attributes from the source to the destination.
     * <ul>
     * <li>Behaviors</li>
     * <li>DefaultParameters</li>
     * <li>ElementImports</li>
     * <li>Name</li>
     * <li>ParameterTemplate</li>
     * <li>ReferenceTags</li>
     * <li>StereoTypes</li>
     * <li>TaggedValues</li>
     * <li>TemplateArguments</li>
     * <li>TemplateParameters</li>
     * <li>Visibility</li>
     * <li>Specification</li>
     * </ul>
     * </p>
     * <p>
     * This method is used in {@linkplain ObjectUtil#copyObject(Object)} and
     * {@linkplain MessageUtil#copyStimulus(Stimulus)}.
     * </p>
     *
     * @param source
     *            the source from which the attributes will be taken.
     * @param destination
     *            the destination to which the attributes are copied to.
     */
    public static void copyBasicAttributes(ModelElement source, ModelElement destination) {
        // Behaviors
        for (StateMachine stateMachine : source.getBehaviors()) {
            destination.addBehavior(stateMachine);
        }

        // add new instance of the templateParameter.
        for (TemplateParameter templateParameter : source.getDefaultParameters()) {
            destination.addDefaultParameter(copyTemplateParameter(templateParameter));
        }

        // elementImport's
        for (ElementImport elementImport : source.getElementImports()) {
            destination.addElementImport(elementImport);
        }

        // name
        destination.setName(source.getName());

        // add new instance of the templateParameter if it is present
        if (source.getParameterTemplate() != null) {
            destination.setParameterTemplate(copyTemplateParameter(source.getParameterTemplate()));
        }

        // add new instance of the tagged values.
        for (TaggedValue taggedValue : source.getReferenceTags()) {
            destination.addReferenceTag(copyTaggedValue(taggedValue));
        }

        // Bi-directional aggregation
        // stereotype
        for (Stereotype stereotype : source.getStereotypes()) {
            destination.addStereotype(stereotype);
            stereotype.addExtendedElement(destination);
        }

        // add new instance of the tagged values.
        for (TaggedValue taggedValue : source.getTaggedValues()) {
            destination.addTaggedValue(copyTaggedValue(taggedValue));
        }

        // add new instance of the templateArgument
        for (TemplateArgument templateArgument : source.getTemplateArguments()) {
            destination.addTemplateArgument(templateArgument);
        }

        // add new instance of the templateParameter.
        for (TemplateParameter templateParameter : source.getTemplateParameters()) {
            destination.addTemplateParameter(copyTemplateParameter(templateParameter));
        }
        // visibility
        destination.setVisibility(source.getVisibility());

        // specification
        destination.setSpecification(source.isSpecification());
    }

    /**
     * <p>
     * Creates a new instance of {@linkplain TaggedValue} and copies all the attributes of the given element
     * to it.
     * </p>
     *
     * @param taggedValue
     *            the element to be copied.
     * @return the new instance of the created element.
     */
    public static TaggedValue copyTaggedValue(TaggedValue taggedValue) {
        // create a new taggedValue with the contents of the old tagged value.
        TaggedValue copyTaggedValue = new TaggedValueImpl(taggedValue.getDataValue(), taggedValue.getType(),
            taggedValue.getModelElement(), taggedValue.getReferenceValues());
        // copy all the Basic Attributes.
        copyBasicAttributes(taggedValue, copyTaggedValue);
        return copyTaggedValue;
    }

    /**
     * <p>
     * Creates a new instance of {@linkplain TemplateParameter} and copies all the attributes of the given
     * element to it.
     * </p>
     *
     * @param templateParameter
     *            the element to be copied.
     * @return the new instance of the created element.
     */
    public static TemplateParameter copyTemplateParameter(TemplateParameter templateParameter) {
        TemplateParameter copyTemplateParameter = new TemplateParameterImpl();
        // copy all the attributes.
        copyTemplateParameter.setDefaultElement(templateParameter.getDefaultElement());
        copyTemplateParameter.setParameter(templateParameter.getParameter());
        copyTemplateParameter.setTemplate(templateParameter.getTemplate());
        return copyTemplateParameter;
    }
}
