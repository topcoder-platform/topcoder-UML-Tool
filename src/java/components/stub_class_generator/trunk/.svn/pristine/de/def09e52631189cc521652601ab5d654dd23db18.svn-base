/*
 * Copyright (C) 2010 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.apache.commons.digester.RuleSetBase;
import org.xml.sax.Attributes;

/**
 * Represents rule set of Eclipse Formatter configuration.
 * 
 * @author enefem21
 */
class RuleSet extends RuleSetBase {

    /**
     * The dummy object.
     */
    private final Object DUMMY = new Dummy();

    /**
     * Adding a rule instances.
     * 
     * @see org.apache.commons.digester.RuleSetBase#addRuleInstances(org.apache.commons.digester.Digester)
     */
    public void addRuleInstances(Digester digester) {
        digester.addFactoryCreate("profiles", new ProfilesObjectFactory());
        digester.addFactoryCreate("profiles/profile", new ProfileObjectFactory());
        digester.addSetNext("profiles/profile", "add");

        digester.addCallMethod("profiles/profile/setting", "put", 2);
        digester.addCallParam("profiles/profile/setting", 0, "id");
        digester.addCallParam("profiles/profile/setting", 1, "value");
    }

    /**
     * Factory class to create profiles object.
     * 
     * @author enefem21
     */
    private class ProfilesObjectFactory extends AbstractObjectCreationFactory {

        /**
         * Creates object with the given attributes.
         * 
         * @param attrs
         *            the given attributes
         */
        public Object createObject(Attributes attrs) throws Exception {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            InvocationHandler handler = new InvocationHandler() {
                private List list = new ArrayList();

                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                    if ("add".equals(method.getName()) && args.length == 1 && DUMMY.equals(args[0])) {
                        return Boolean.FALSE;
                    }

                    return method.invoke(list, args);
                }
            };
            Object proxy = Proxy.newProxyInstance(cl, new Class[] {List.class}, handler);
            return proxy;
        }
    }

    /**
     * Factory class to create profile object.
     * 
     * @author enefem21
     */
    private class ProfileObjectFactory extends AbstractObjectCreationFactory {

        /**
         * Creates object with the given attributes.
         * 
         * @param attrs
         *            the given attributes
         */
        public Object createObject(Attributes attrs) throws Exception {
            String kind = attrs.getValue("kind");
            if ("CodeFormatterProfile".equals(kind)) {
                return new HashMap();
            }
            return DUMMY;
        }
    }

    /**
     * Dummy class.
     * 
     * @author enefem21
     */
    private class Dummy {

        /**
         * Dummy method.
         * 
         * @param o1
         *            first object
         * @param o2
         *            second object
         */
        public void put(Object o1, Object o2) {
            // do nothing
        }
    }
}
