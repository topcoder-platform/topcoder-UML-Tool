/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.stresstests;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Reference;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * <p>This class tests the <code>DiagramElement</code> class for stress. This stress tests
 * addresses the functionality provided by the <code>DiagramElement</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class DiagramElementStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The instance of <code>DiagramElement</code> for test.</p>
     */
    private DiagramElement element = null;

    /**
     * <p>Return test suite of <code>DiagramElementStressTest</code>.</p>
     *
     * @return Test suite of <code>DiagramElementStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(DiagramElementStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        element = new DiagramElement() { };
    }

    /**
     * <p>Basic stress test of <code>addProperty()</code>, <code>removeProperty()</code>,
     * <code>clearProperties()</code>, <code>getProperties()</code>,
     * <code>containsProperty()</code>, <code>countProperties()</code> methods.</p>
     */
    public void testMethod_Property() {
        List< Property > properties = new ArrayList< Property >();

        for (int i = 0; i < LOOPTIMES; i++) {
            Property property = new Property();
            element.addProperty(property);
            properties.add(property);

            // check the control.
            assertTrue("The containsProperty method is incorrect.",
                element.containsProperty(property));
            assertEquals("The countProperties method is incorrect.", i + 1,
                element.countProperties());

            Collection<Property> getProperties = element.getProperties();
            assertEquals("The getProperties method is incorrect.", i + 1, getProperties.size());
            assertTrue("The getProperties method is incorrect.",
                properties.containsAll(getProperties));
        }

        for (int i = 0; i < (LOOPTIMES / 2); i++) {
            assertTrue("The removeProperty method is incorrect.",
                element.removeProperty(properties.get(i)));
            assertEquals("The removeProperty method is incorrect.", LOOPTIMES - i - 1,
                element.countProperties());
            assertFalse("The removeProperty method is incorrect.",
                element.containsProperty(properties.get(i)));
        }

        // clear all properties and test it.
        element.clearProperties();
        assertEquals("The clearProperties method is incorrect.", 0, element.countProperties());
    }

    /**
     * <p>Basic stress test of <code>addReference()</code>, <code>removeReference()</code>,
     * <code>clearReferences()</code>, <code>getReferences()</code>,
     * <code>containsReference()</code>, <code>countReferences()</code> methods.</p>
     */
    public void testMethod_Reference() {
        List<Reference> references = new ArrayList<Reference>();

        for (int i = 0; i < LOOPTIMES; i++) {
            Reference reference = new Reference();
            element.addReference(reference);
            references.add(reference);

            // check the control.
            assertTrue("The containsReference method is incorrect.",
                element.containsReference(reference));
            assertEquals("The countReferences method is incorrect.", i + 1,
                element.countReferences());

            Collection<Reference> getReferences = element.getReferences();
            assertEquals("The getReferences method is incorrect.", i + 1, getReferences.size());
            assertTrue("The getReferences method is incorrect.",
                references.containsAll(getReferences));
        }

        for (int i = 0; i < (LOOPTIMES / 2); i++) {
            assertTrue("The removeReference method is incorrect.",
                element.removeReference(references.get(i)));
            assertEquals("The removeReference method is incorrect.", LOOPTIMES - i - 1,
                element.countReferences());
            assertFalse("The removeReference method is incorrect.",
                element.containsReference(references.get(i)));
        }

        // clear all references and test it.
        element.clearReferences();
        assertEquals("The clearReferences method is incorrect.", 0, element.countReferences());
    }
}
