/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.accuracytests;

import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.InstanceAbstractImpl;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkEndImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;

import junit.framework.TestCase;

/**
 * AccuracyTest for LinkEndImpl class.
 *
 * @author iamajia
 * @version 1.0
 */
public class LinkEndImplAccuracyTest extends TestCase {
    /**
     * This instance is used in the test.
     */
    private LinkEndImpl linkEnd = new LinkEndImpl();

    /**
     * Accuracy test of <code>LinkEndImpl()</code> constructor.
     *
     * @throws Exception
     *             to junit.
     */
    public void testLinkEndImplAccuracy() throws Exception {
        assertNotNull("linkEnd should not be null.", linkEnd);
        assertNull("initial value should be null.", linkEnd.getInstance());
        assertNull("initial value should be null.", linkEnd.getLink());
    }

    /**
     * Accuracy test of <code>getInstance()</code> and
     * <code>setInstance(Instance instance)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetSetInstanceAccuracy() throws Exception {
        Instance instance = new InstanceAbstractImpl() {
        };
        linkEnd.setInstance(instance);
        assertEquals("instance is incorrect.", instance, linkEnd.getInstance());
        linkEnd.setInstance(null);
        assertNull("instance should be null.", linkEnd.getInstance());
    }

    /**
     * Accuracy test of <code>getLink()</code> and
     * <code>setLink(Link link)</code> method.
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetSetLinkAccuracy() throws Exception {
        Link link = new LinkImpl();
        linkEnd.setLink(link);
        assertEquals("link is incorrect.", link, linkEnd.getLink());
        linkEnd.setLink(null);
        assertNull("link should be null.", linkEnd.getLink());
    }
}
