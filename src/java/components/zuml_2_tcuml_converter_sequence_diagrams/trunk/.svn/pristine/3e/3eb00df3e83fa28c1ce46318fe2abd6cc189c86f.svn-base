/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.core.Classifier;

import java.util.Collection;


/**
 * <p>
 * This interface represents &lt;UML2:Interaction&gt; element. It is the model class for
 * Sequence Diagram in ZUML file (UML2). It extends Classifier interface. It also extends
 * ZUML2TCUMLTransformer&lt;Collaboration&gt; interface so that it will be transformed to
 * Collaboration. This interface is not a complete model for UML2, it is just used to
 * transform to TCUML Collaboration. So the &lt;UML2:Interaction.fragment&gt; and
 * &lt;UML2:Interaction.feature&gt; are ignored.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * The implementation is not required to be thread-safe.
 * </p>
 *
 * @author telly12, zhengjuyu
 * @version 1.0
 */
public interface Interaction extends ZUML2TCUMLTransformer<Collaboration>,
    Classifier {
    /**
     * <p>
     * Add a messge (&lt;UML2:Message&gt;) to this Interaction instance. Duplicate messages are acceptable.
     * </p>
     *
     * @param message the message to be added
     * @throws IllegalArgumentException if the message is null
     */
    public void addMessage(Message message);

    /**
     * <p>
     * Remove a messge (&lt;UML2:Message&gt;) from this Interaction instance. If no message is found, do
     * nothing, if duplicate messages are found, which one will be removed is undefined.
     * </p>
     *
     * @param message the message to be removed
     * @throws IllegalArgumentException if the message is null
     */
    public void removeMessage(Message message);

    /**
     * <p>Clear all the messages in this Interaction instance.</p>
     *
     */
    public void clearMessages();

    /**
     * <p>Return all the messages, a shallow copy of messages will be returned.</p>
     *
     *
     * @return all the message in this interaction
     */
    public Collection<Message> getMessages();

    /**
     * <p>
     * Add a lifeline (&lt;UML2:Lifeline&gt;) to this Interaction instance. Duplicate lifelines are acceptable.
     * </p>
     *
     * @param lifeline the lifeline to be added
     * @throws IllegalArgumentException if the lifeline is null
     */
    public void addLifeline(Lifeline lifeline);

    /**
     * <p>
     * Remove a lifeline (&lt;UML2:Lifeline&gt;) from this Interaction instance. If no lifeline is found,
     * do nothing, if duplicate lifelines are found, which one will be removed is undefined.
     * </p>
     *
     * @param lifeline the lifeline to be removed
     * @throws IllegalArgumentException if the lifeline is null
     */
    public void removeLifeline(Lifeline lifeline);

    /**
     * <p>Clear all the lifelines in this Interaction instance.</p>
     *
     */
    public void clearLifelines();

    /**
     * <p>
     * Return all the lifelines in this interaction, a shallow copy of messages will be returned.
     * </p>
     *
     * @return all the lifelines in this interaction
     */
    public Collection<Lifeline> getLifelines();
}
