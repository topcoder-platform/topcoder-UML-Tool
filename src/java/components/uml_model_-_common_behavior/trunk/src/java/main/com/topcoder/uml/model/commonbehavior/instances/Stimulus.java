/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.instances;

import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.core.ModelElement;


/**
 * <p>This interface extends ModelElement interface. The ModelElement interface comes form the
 * Core Requirements component. A stimulus reifies a communication between two instances. In the
 * metamodel, Stimulus is a communication (i.e., a Signal sent to an Instance, or an invocation of an
 * Operation). It can also be a request to create an Instance, or to destroy an Instance. It has
 * a sender, a receiver, and may have a set of actual arguments, all being Instances.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public interface Stimulus extends ModelElement {
    /**
     * Gets the Instance sender field value. Could be null.
     *
     *
     * @return sender field value
     */
    public Instance getSender();

    /**
     * Sets the Instance sender field value. Null is allowed.
     *
     *
     * @param sender sender field value
     */
    public void setSender(Instance sender);

    /**
     * Gets the Instance receiver field value. Could be null.
     *
     *
     * @return receiver field value
     */
    public Instance getReceiver();

    /**
     * Sets the Instance receiver field value. Null is allowed.
     *
     *
     * @param receiver receiver field value
     */
    public void setReceiver(Instance receiver);

    /**
     * Gets the Link communicationLink field value. Could be null.
     *
     *
     * @return communicationLink field value
     */
    public Link getCommunicationLink();

    /**
     * Sets the Link communicationLink field value. Null is allowed.
     *
     *
     * @param communicationLink communicationLink field value
     */
    public void setCommunicationLink(Link communicationLink);

    /**
     * Gets the Procedure dispatchAction field value. Could be null.
     *
     *
     * @return dispatchAction field value
     */
    public Procedure getDispatchAction();

    /**
     * Sets the Procedure dispatchAction field value. Null is allowed.
     *
     *
     * @param dispatchAction dispatchAction field value
     */
    public void setDispatchAction(Procedure dispatchAction);
}
