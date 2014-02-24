/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.links;

import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.core.ModelElement;


/**
 * <p>This interface extends ModelElement interface. The ModelElement interface comes form the
 * Core Requirements component. A link end is an end point of a link. In the metamodel, LinkEnd
 * is the part of a Link that connects to an Instance. It corresponds to an AssociationEnd of
 * the Link's Association.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public interface LinkEnd extends ModelElement {
    /**
     * Gets the instance field value. Could be null.
     *
     *
     * @return instance field value
     */
    Instance getInstance();

    /**
     * Sets the instance field value. Null is allowed.
     *
     *
     * @param instance instance field value
     */
    void setInstance(Instance instance);

    /**
     * Gets the link field value. Could be null.
     *
     *
     * @return link field value
     */
    Link getLink();

    /**
     * Sets the link field value. Null is allowed.
     *
     *
     * @param link link field value
     */
    void setLink(Link link);
}
