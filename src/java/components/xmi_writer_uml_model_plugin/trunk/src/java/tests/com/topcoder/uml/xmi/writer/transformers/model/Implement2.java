/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.xmi.writer.transformers.model;
/**
 * The simple mock class used to test the component.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Implement2 implements Interface2 {

    /**
     * The inner bean.
     */
    private InnerBean bean = null;
    /**
     * Create a Implement2 instance.
     *
     * @param bean the Innerbean.
     */
    public Implement2(InnerBean bean) {
        this.bean = bean;
    }
    /**
     * Get a instance that is a mock class.
     *
     * @return a InnerBean instance.
     */
    public InnerBean getInnerBean1() {
        return bean;
    }

    /**
     * Get a instance that is a mock class.
     *
     * @return a InnerBean instance.
     */
    public InnerBean getInnerBean2() {
        return bean;
    }
}
