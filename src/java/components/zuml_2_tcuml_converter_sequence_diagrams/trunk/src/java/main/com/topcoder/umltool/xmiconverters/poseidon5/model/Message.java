/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.core.ModelElement;


/**
 * <p>
 * This interface represents &lt;UML2:Message&gt; element. It is the model class for a message
 * in Sequence Diagram in ZUML file (UML2). It extends ModelElement interface. It also extends
 * ZUML2TCUMLTransformer&lt;Link&gt; interface so that it will be transformed to Link. It also
 * can be transformed to Stimulus instance because Link doesn't contain the call operation action.
 * This interface is not a complete model for UML2, it is just used to transform to TCUML Object.
 * So the &lt;UML2:Message.argument&gt; is ignored.
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
public interface Message extends ZUML2TCUMLTransformer<Link>, ModelElement {
    /**
     * <p>
     * Set the messageSort property of message. The messargeSort of asynchronous message is "asynchCall",
     * for other messages, the messageSort is "synchCall".
     * </p>
     *
     * @param messageSort the messageSort property to set
     * @throws IllegalArgumentException if the messageSort is null or not "asynchCall" and not "synchCall"
     */
    public void setMessageSort(String messageSort);

    /**
     * <p>
     * Get the messageSort property of this message. The messargeSort of asynchronous message is "asynchCall",
     * for other messages, the messageSort is "synchCall".
     * </p>
     *
     * @return the messageSort property
     */
    public String getMessageSort();

    /**
     * <p>
     * Set the receiveEvent property of the message. receiveEvent is the event of the end
     * point of the message in the lifeline in the view.
     * </p>
     *
     * @param receiveEvent the receiveEvent property to set
     */
    public void setReceiveEvent(EventOccurrence receiveEvent);

    /**
     * <p>
     * Get the receiveEvent property of the message, receiveEvent is the event of the end
     * point of the message in the lifeline in the view.
     * </p>
     *
     * @return the receiveEvent property of the message
     */
    public EventOccurrence getReceiveEvent();

    /**
     * <p>
     * Set the sendEvent property of the message. sendEvent is the event of the start point
     * of the message in the lifeline in the view.
     * </p>
     *
     * @param sendEvent  the sendEvent property  to set
     */
    public void setSendEvent(EventOccurrence sendEvent);

    /**
     * <p>
     * Get the sendEvent property of the message, sendEvent is the event of the start point
     * of the message in the lifeline in the view.
     * </p>
     *
     * @return  the sendEvent property of message
     */
    public EventOccurrence getSendEvent();

    /**
     * <p>
     * Transform this message to TCUML Stimulus instance.The returned Stimulus instance must
     * be same for every call of this method. For example:
     * </p>
     * <p>Stimulus stimulus1 = this.toTCUMLStimulus();</p>
     * <p>Stimulus stimulus2 = this.toTCUMLStimulus();</p>
     * <p>stimulus1 == stimulus2 is true.</p>
     *
     * @return the transformed Stimulus instance
     */
    public Stimulus toTCUMLStimulus();
}
