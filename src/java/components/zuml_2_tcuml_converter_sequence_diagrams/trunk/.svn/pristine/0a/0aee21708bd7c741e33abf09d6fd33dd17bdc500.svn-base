/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model.impl;

import com.topcoder.uml.model.actions.messagingactions.CallOperationAction;
import com.topcoder.uml.model.actions.messagingactions.CallOperationActionImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkEnd;
import com.topcoder.uml.model.commonbehavior.links.LinkEndImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;

import com.topcoder.umltool.xmiconverters.poseidon5.model.EventOccurrence;
import com.topcoder.umltool.xmiconverters.poseidon5.model.Message;


/**
 * <p>
 * This class extends ModelElementAbstractImpl and implements Message interface, it represents
 * &lt;UML2:Message&gt; element in ZUML file. It also provides the functionality to transform
 * it to the Link and Stimulus instances. the transformed instances will be stored to
 * transformedLink and transformedStimulus variable, so that if that variables are not null,
 * the variables are returned directly in toTCUMLElement/toTCUMLStimulus method. This class
 * will be configured to XMI Reader Model Plugin component so that the XML2ModelHandler can
 * read the corresponding elements from file into the model.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is mutable.
 * </p>
 *
 * @author telly12, zhengjuyu
 * @version 1.0
 */
public class MessageImpl extends ModelElementAbstractImpl implements Message {
    /**
     * <p>Serial version uid for the Serializable class.</p>
     */
    private static final long serialVersionUID = 2666893510370905346L;

    /**
     * <p>The messageSort of asynchronous message.</p>
     */
    private static final String ASYNC = "asynchCall";

    /**
     * <p>The messageSort of any message except asynchronous message.</p>
     */
    private static final String SYNC = "synchCall";

    /**
     * <p>
     * The messageSort property of the message. The messargeSort of asynchronous message
     * is "asynchCall", for other messages, the messageSort is "synchCall". It is initially
     * null, mutable. It can be null, "synchCall" or "asynchCall". It can be accessed by
     * the setter and getter.
     * </p>
     */
    private String messageSort;

    /**
     * <p>
     * The receiveEvent property of the message, receiveEvent is the event of the end
     * point of the message in the lifeline in the view. It is initially null, mutable
     * It can be null. It can be accessed by the setter and getter.
     * </p>
     */
    private EventOccurrence receiveEvent;

    /**
     * <p>
     * The sendEvent property of the message, sendEvent is the event of the start point
     * of the message in the lifeline in the view. It is initially null, mutable. It can
     * be null. It can be accessed by the setter and getter.
     * </p>
     */
    private EventOccurrence sendEvent;

    /**
     * <p>
     * The transformed link instance, if this message is never transformed, this variable
     * is null, if it is not null, it will be returned directly in toTCUMLElement method.
     * It is initially null, is used in toTCUMLElement method. It can be null.
     * </p>
     */
    private Link transformedLink;

    /**
     * <p>
     * The transformed stimulus instance, if this message is never transformed, this variable
     * is null, if it is not null, it will be returned directly in toTCUMLStimulus method. It
     * is initially null, is used in toTCUMLStimulus method. It can be null.
     * </p>
     */
    private Stimulus transformedStimulus;

    /**
     * <p>Empty constructor as a placeholder for future use.</p>
     */
    public MessageImpl() {
    }

    /**
     * <p>
     * Transform this message to TCUML Link instance. The name of the message will be the name
     * of link, the stereotypes will be the stereotypes of the link.
     * </p>
     *
     * @return transformed TCUML Link instance
     */
    public Link toTCUMLElement() {
        if (transformedLink == null) {
            transformedLink = new LinkImpl();

            LinkEnd linkEnd = new LinkEndImpl();
            linkEnd.setLink(transformedLink);

            transformedLink.addConnection(linkEnd);
            transformedLink.addStimulus(toTCUMLStimulus());
            transformedLink.setName(this.getName());

            for (Stereotype type : getStereotypes()) {
                transformedLink.addStereotype(type);
            }
        }

        return transformedLink;
    }

    /**
     * <p>
     * Transform this message to TCUML Stimulus instance. The communicationLink will be the
     * transformed link, the dispatchAction will be the procedure with the call operation
     * action determined by whether this message is asynchronous or synchronous or return message.
     * </p>
     *
     * @return the transformed Stimulus instance
     */
    public Stimulus toTCUMLStimulus() {
        if (transformedStimulus == null) {
            transformedStimulus = new StimulusImpl();

            Procedure procedure = new ProcedureImpl();
            transformedStimulus.setDispatchAction(procedure);

            if (ASYNC.equals(messageSort) || (SYNC.equals(messageSort)
                    && (receiveEvent != null) && (receiveEvent.getStartExec() != null))) {
                CallOperationAction action = new CallOperationActionImpl();

                if (messageSort.equals(ASYNC)) {
                    action.setAsynchronous(true);
                }

                procedure.setAction(action);
            }

            transformedStimulus.setCommunicationLink(toTCUMLElement());
        }

        return transformedStimulus;
    }

    /**
     * <p>
     * Set the receiveEvent property of the message. receiveEvent is the event of the end
     * point of the message in the lifeline in the view.
     * </p>
     *
     * @param receiveEvent the receiveEvent property to set
     */
    public void setReceiveEvent(EventOccurrence receiveEvent) {
        this.receiveEvent = receiveEvent;
    }

    /**
     * <p>
     * Get the receiveEvent property of the message, receiveEvent is the event of the end
     * point of the message in the lifeline in the view.
     * </p>
     *
     * @return the receiveEvent property of the message
     */
    public EventOccurrence getReceiveEvent() {
        return receiveEvent;
    }

    /**
     * <p>
     * Get the messageSort property of this message. The messargeSort of asynchronous message
     * is "asynchCall", for other messages, the messageSort is "synchCall".
     * </p>
     *
     * @return the messageSort property
     */
    public String getMessageSort() {
        return messageSort;
    }

    /**
     * <p>
     * Set the messageSort property of message. The messargeSort of asynchronous message is
     * "asynchCall", for other messages, the messageSort is "synchCall".
     * </p>
     *
     * @param messageSort the messageSort property to set
     * @throws IllegalArgumentException if the argument is null or not "asynchCall" and not "synchCall"
     */
    public void setMessageSort(String messageSort) {
        Helper.checkNull(messageSort, "messageSort");

        if (!messageSort.equals(ASYNC) && !messageSort.equals(SYNC)) {
            throw new IllegalArgumentException(
                "The messageSort should be asychCall or sychCall.");
        }

        this.messageSort = messageSort;
    }

    /**
     * <p>
     * Get the sendEvent property of the message, sendEvent is the event of the start point
     * of the message in the lifeline in the view.
     * </p>
     *
     * @return  the sendEvent property of message
     */
    public EventOccurrence getSendEvent() {
        return sendEvent;
    }

    /**
     * <p>
     * Set the sendEvent property of the message, sendEvent is the event of the start point
     * of the message in the lifeline in the view.
     * </p>
     *
     * @param sendEvent  the sendEvent property  to set
     */
    public void setSendEvent(EventOccurrence sendEvent) {
        this.sendEvent = sendEvent;
    }
}
