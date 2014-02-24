/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.links;

import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;


/**
 * <p>This is a simple concrete implementation of LinkEnd interface and extends ModelElementAbstractImpl
 * from the Core Requirements component. A link end is an end point of a link. In the metamodel, LinkEnd
 * is the part of a Link that connects to an Instance. It corresponds to an AssociationEnd of
 * the Link's Association. As such, all methods in LinkEnd are supported.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public class LinkEndImpl extends ModelElementAbstractImpl implements LinkEnd {
    /**
     * <p>Represents The Instance connected to the LinkEnd.</p>
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private Instance instance = null;

    /**
     * <p>Represents the Link this end is part of.</p>
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private Link link = null;

    /**
     * <p>Empty constructor.</p>
     *
     */
    public LinkEndImpl() {
        // empty
    }

    /**
     * Gets the instance field value. Could be null.
     *
     *
     * @return instance field value
     */
    public Instance getInstance() {
        return instance;
    }

    /**
     * Sets the instance field value. Null is allowed.
     *
     *
     * @param instance instance field value
     */
    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    /**
     * Gets the link field value. Could be null.
     *
     *
     * @return link field value
     */
    public Link getLink() {
        return link;
    }

    /**
     * Sets the link field value. Null is allowed.
     *
     *
     * @param link link field value
     */
    public void setLink(Link link) {
        this.link = link;
    }
}
