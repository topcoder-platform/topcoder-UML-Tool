/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.instances;

import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;


/**
 * <p>This is a simple concrete implementation of Stimulus interface and extends ModelElementAbstractImpl
 * from the Core Requirements component. As such, all methods in Stimulus are supported.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public class StimulusImpl extends ModelElementAbstractImpl implements Stimulus {
    /**
     * <p>Represents The Instance that sends the Stimulus.</p>
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private Instance sender;

    /**
     * <p>Represents The Instance that receives the Stimulus.</p>
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private Instance receiver;

    /**
     * <p>Represents The Link, which is used for communication.</p>
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private Link communicationLink;

    /**
     * <p>Represents The procedure that caused the Stimulus to be dispatched when it was executed.</p>
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private Procedure dispatchAction;

    /**
     * <p>Empty constructor.</p>
     *
     */
    public StimulusImpl() {
    }

    /**
     * Gets the Instance sender field value. Could be null.
     *
     *
     * @return sender field value
     */
    public Instance getSender() {
        return sender;
    }

    /**
     * Sets the Instance sender field value. Null is allowed.
     *
     *
     * @param sender sender field value
     */
    public void setSender(Instance sender) {
        this.sender = sender;
    }

    /**
     * Gets the Instance receiver field value. Could be null.
     *
     *
     * @return receiver field value
     */
    public Instance getReceiver() {
        return receiver;
    }

    /**
     * Sets the Instance receiver field value. Null is allowed.
     *
     *
     * @param receiver receiver field value
     */
    public void setReceiver(Instance receiver) {
        this.receiver = receiver;
    }

    /**
     * Gets the Link communicationLink field value. Could be null.
     *
     *
     * @return communicationLink field value
     */
    public Link getCommunicationLink() {
        return communicationLink;
    }

    /**
     * Sets the Link communicationLink field value. Null is allowed.
     *
     *
     * @param communicationLink communicationLink field value
     */
    public void setCommunicationLink(Link communicationLink) {
        this.communicationLink = communicationLink;
    }

    /**
     * Gets the Procedure dispatchAction field value. Could be null.
     *
     *
     * @return dispatchAction field value
     */
    public Procedure getDispatchAction() {
        return dispatchAction;
    }

    /**
     * Sets the Procedure dispatchAction field value. Null is allowed.
     *
     *
     * @param dispatchAction dispatchAction field value
     */
    public void setDispatchAction(Procedure dispatchAction) {
        this.dispatchAction = dispatchAction;
    }
}
