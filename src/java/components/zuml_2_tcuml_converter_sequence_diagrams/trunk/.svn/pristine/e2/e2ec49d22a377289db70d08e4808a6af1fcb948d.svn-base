/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model.impl;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.core.ClassifierAbstractImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.model.Interaction;
import com.topcoder.umltool.xmiconverters.poseidon5.model.Lifeline;
import com.topcoder.umltool.xmiconverters.poseidon5.model.Message;

import java.util.ArrayList;
import java.util.Collection;


/**
 * <p>
 * This class extends ClassifierImpl and implements Interaction interface, it represents
 * &lt;UML2:Interaction&gt; element in ZUML file. It also provides the functionality to
 * transform it to the Collaboration instance. the transformed instance will be stored
 * to transformedCollaboration variable, so that if that variable is not null, the variable
 * is returned directly in toTCUMLElement method. This class will be configured to XMI
 * Reader Model Plugin component so that the XML2ModelHandler can read the element from
 * file into the model.
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
public class InteractionImpl extends ClassifierAbstractImpl
    implements Interaction {
    /**
     * <p>Serial version uid for the Serializable class.</p>
     */
    private static final long serialVersionUID = 8846642436429975120L;

    /**
     * <p>
     * The messages collection in this interaction. It is initially to empty Message array
     * list, and never changed later. It can't be null, can be empty, can't contain null
     * message instance. It is used in addMessage, removeMessage, clearMessages and
     * getMessages methods.
     * </p>
     */
    private final Collection<Message> messages = new ArrayList<Message>();

    /**
     * <p>
     * The lifelines collection in this interaction. It is initially to empty Lifeline
     * array list, and never changed later. It can't be null, can be empty, can't contain
     * null lifeline instance. It is used in addLifeline, removeLifline, clearLifelines
     * and getLifelines methods.
     * </p>
     */
    private final Collection<Lifeline> lifelines = new ArrayList<Lifeline>();

    /**
     * <p>
     * The transformed collaboration instance, if this interaction is never transformed,
     * this variable is null, if it is not null, it will be returned directly in toTCUMLElement
     * method. It is initially null, is used in toTCUMLElement method. It can be null.
     * </p>
     */
    private Collaboration transformedCollaboration;

    /**
     * <p>Empty constructor as a placeholder for future use.</p>
     */
    public InteractionImpl() {
    }

    /**
     * <p>
     * Transform this interaction to TCUML Collaboration instance. The lifelines will be
     * transformed to objects and messages will be transformed to links and stimuluses.
     * </p>
     *
     * @return the transformed collaboration instance
     */
    public Collaboration toTCUMLElement() {
        if (transformedCollaboration == null) {
            transformedCollaboration = new CollaborationImpl();

            CollaborationInstanceSet cis = new CollaborationInstanceSetImpl();

            transformedCollaboration.addCollaborationInstanceSet(cis);
            cis.setCollaboration(transformedCollaboration);

            for (Lifeline lifeline : lifelines) {
                Object obj = lifeline.toTCUMLElement();

                transformedCollaboration.addOwnedElement(obj);
                cis.addParticipatingInstance(obj);
            }

            for (Message message : messages) {
                transformedCollaboration.addOwnedElement(message.toTCUMLStimulus());
                cis.addParticipatingLink(message.toTCUMLElement());
            }
        }

        return transformedCollaboration;
    }

    /**
     * <p>Clear all the lifelines in this Interaction instance.</p>
     */
    public void clearLifelines() {
        lifelines.clear();
    }

    /**
     * <p>
     * Remove a lifeline (&lt;UML2:Lifeline&gt;) from this Interaction instance. If no
     * lifeline is found, do nothing, if duplicate lifelines are found, which one will
     * be removed is undefined.
     * </p>
     *
     * @param lifeline the lifeline to be removed
     * @throws IllegalArgumentException if lifeline is null
     */
    public void removeLifeline(Lifeline lifeline) {
        Helper.checkNull(lifeline, "lifeline");

        lifelines.remove(lifeline);
    }

    /**
     * <p>
     * Add a lifeline (&lt;UML2:Lifeline&gt;) to this Interaction instance. Duplicate
     * lifelines are acceptable.
     * </p>
     *
     * @param lifeline the lifeline to be added
     * @throws IllegalArgumentException if lifeline is null
     */
    public void addLifeline(Lifeline lifeline) {
        Helper.checkNull(lifeline, "lifeline");

        lifelines.add(lifeline);
    }

    /**
     * <p>
     * Return all the lifelines in this interaction, a shallow copy of messages will be returned.
     * </p>
     *
     * @return all the lifelines in this interaction
     */
    public Collection<Lifeline> getLifelines() {
        return new ArrayList<Lifeline>(lifelines);
    }

    /**
     * <p>
     * Add a messge (&lt;UML2:Message&gt;) to this Interaction instance. Duplicate messages are
     * acceptable.
     * </p>
     *
     * @param message the message to be added
     * @throws IllegalArgumentException if the argument is null
     */
    public void addMessage(Message message) {
        Helper.checkNull(message, "message");

        messages.add(message);
    }

    /**
     * <p>
     * Return all the messages, a shallow copy of messages will be returned.
     * </p>
     *
     * @return all the message in this interaction
     */
    public Collection<Message> getMessages() {
        return new ArrayList<Message>(messages);
    }

    /**
     * <p>Clear all the messages in this Interaction instance.</p>
     */
    public void clearMessages() {
        messages.clear();
    }

    /**
     * <p>
     * Remove a message (&lt;UML2:Message&gt;) from this Interaction instance. If no message is
     * found, do nothing, if duplicate messages are found, which one will be removed is undefined.
     * </p>
     *
     * @param message the message to be removed
     * @throws IllegalArgumentException if the argument is null
     */
    public void removeMessage(Message message) {
        Helper.checkNull(message, "message");

        messages.remove(message);
    }
}
