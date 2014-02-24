/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.model.stresstests;

import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.datatypes.AggregationKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.OrderingKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;
import com.topcoder.xmi.reader.handlers.uml.model.XMI2ModelHandler;
import junit.framework.TestCase;
import java.io.File;
import java.util.Iterator;

/**
 * Stress test for XMI2ModelHandler and ModelElementFactory.
 *
 * @author crackme
 * @version 1.0
 *
 */
public class XMI2ModelHandlerStressTest extends TestCase {
	/**
	 * A ModelElementFactory used to test.
	 */
    private ModelElementFactory fac;
    
	/**
	 * A ConfigManager used to test.
	 */
    private ConfigManager cm = ConfigManager.getInstance();
    
	/**
	 * A XMI2ModelHandler used to test.
	 */
    private XMI2ModelHandler handler;
    
	/**
	 * A XMIReader used to test.
	 */
    private XMIReader read;
    
	/**
	 * A test operation number used to test.
	 */
    private static final int TEST_OPERATIONS = 25000;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        clearNamespaces();
        cm.add(new File("test_files/stress/stress.xml").getAbsolutePath());

        fac = new ModelElementFactory(
                "com.topcoder.xmi.reader.handlers.uml.model.ModelElementFactory");
        read = new XMIReader();
        handler = (XMI2ModelHandler) read.getHandler("UML:Model");
        handler.setModelElementFactory(fac);
    }

    /**
     * Clear all the namespaces used in this class.
     *
     */
    private void clearNamespaces() {
        for (Iterator iter = cm.getAllNamespaces(); iter.hasNext();) {
            String ns = (String) iter.next();

            if (cm.existsNamespace(ns)) {
                try {
                    cm.removeNamespace(ns);
                } catch (UnknownNamespaceException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        clearNamespaces();
        handler = null;
    }

    /**
     * Stress test for parsing xmi file.
     * @throws Exception to JUnit.
     */
    public void testModelHandlerStressTest() throws Exception {
        for (int i = 0; i < 100; ++i) {
            read.parse(new File("test_files/stress/stress.xmi"));
        }

        // Valid the result of parsing.
        Object obj1 = read.getElement("I1aa8eb7m10f6dbd4de0mm7f24");
        Multiplicity multiplicity = (Multiplicity) obj1;
        assertEquals("Failed to parse Multiplicity.", 1,
            multiplicity.getRanges().size());

        Object obj2 = read.getElement("I1aa8eb7m10f6dbd4de0mm7f25");
        MultiplicityRange multiplicityRange = (MultiplicityRange) obj2;
        assertEquals("Failed to parse MultiplicityRange.", 1,
            multiplicityRange.getLower());
        assertEquals("Failed to parse MultiplicityRange.", 1,
            multiplicityRange.getUpper());

        Object obj3 = read.getElement("I1aa8eb7m10f6dbd4de0mm7f23");
        AssociationEnd associationEnd = (AssociationEnd) obj3;
        assertEquals("Failed to parse AssociationEnd.", VisibilityKind.PUBLIC,
            associationEnd.getVisibility());
        assertFalse("Failed to parse AssociationEnd.",
            associationEnd.isSpecification());
        assertTrue("Failed to parse AssociationEnd.",
            associationEnd.isNavigable());
        assertEquals("Failed to parse AssociationEnd.", OrderingKind.UNORDERED,
            associationEnd.getOrdering());
        assertEquals("Failed to parse AssociationEnd", AggregationKind.NONE,
            associationEnd.getAggregation());
        assertEquals("Failed to parse AssociationEnd", ScopeKind.INSTANCE,
            associationEnd.getTargetKind());
        assertEquals("Failed to parse AssociationEnd",
            ChangeableKind.CHANGEABLE, associationEnd.getChangeability());
    }
    
    /**
     * verifies the factory works against numerous threads
     */
    public void testConcurrency() throws Throwable {
        // no exceptions should be thrown

        int numThreads = 16;
        // Kick off some threads... some read, some write.
        TestThread[] threads = new TestThread[numThreads];
        for (int i = 0; i < numThreads/2; i++) {
            threads[i] = new TestThread(i % 4, "UML:Model", "com.topcoder.uml.model.modelmanagement.ModelImpl");
            threads[i].start();
        }
        for (int i = numThreads/2; i < numThreads; i++) {
            threads[i] = new TestThread(i % 4, "UML:Actor", "com.topcoder.uml.model.usecases.ActorImpl");
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }

        for (int i = 0; i < numThreads; i++) {
            Throwable t = threads[i].getThrowable();
            if (t != null) {
                fail("Exception was thrown: " + t.getMessage());
            }
        }
    }
    
    /**
     * test thread used to help with currently.
     */
    private class TestThread extends Thread {

    	/**
    	 * A operation identifier used to test.
    	 */
        private int operation;
        
        /**
         * A key of mapping adding to factory.
         */
        private String key;
        
        /**
         * A value of mapping adding to factory.
         */
        private String value;
        
        /**
         * The exception throws in multiply threads.
         */
        private Throwable throwable;

        /**
         * Create TestThread.
         * @param operation the operation.
         * @param key the key.
         * @param value the value.
         */
        public TestThread(int operation, String key, String value) {
            this.operation = operation;
            this.key = key;
            this.value = value;
        }

        /**
         * Override the run method.
         */
        public void run() {
            try {
                for (int i = 0; i < TEST_OPERATIONS; i++) {
                    switch(operation){
                    case(0):
                        fac.getMapping(key);
                        break;
                    case(1):
                        fac.addMapping(key, value);
                        break;
                    case(2):
                        fac.removeMapping(key);
                        break;
                    case(3):
                        fac.getAllMappings();
                        break;
                    }
                }
            } catch (Throwable t) {
                throwable = t;
            }
        }

        /**
         * Get the exception.
         * @return the exception.
         */
        public Throwable getThrowable() {
            return this.throwable;
        }
    }
}
