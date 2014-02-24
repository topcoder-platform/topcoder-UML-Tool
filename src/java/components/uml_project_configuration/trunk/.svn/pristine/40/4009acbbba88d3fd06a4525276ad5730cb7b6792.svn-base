/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.stresstests;

import java.util.ArrayList;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.TextElement;
import com.topcoder.uml.projectconfiguration.diagramelementformatters.PropertyTemplateDiagramElementFormatter;

import junit.framework.TestCase;

/**
 * Stress test for <code>PropertyTemplateDiagramElementFormatter</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class PropertyTemplateDiagramElementFormatterStressTests extends TestCase {

    /**
     * The <code>PropertyTemplateDiagramElementFormatter</code> instance used to test against.
     */
    private PropertyTemplateDiagramElementFormatter formatter = null;

    /**
     * Set up the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.setUpConfigManager();
        formatter = new PropertyTemplateDiagramElementFormatter();
    }

    /**
     * Tear down the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.tearDownConfigManager();
    }

    /**
     * Stress test for the method <code>PropertyTemplateDiagramElementFormatter#format(DiagramElement)</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testFormat() throws Exception {
        TestHelper.startTimer();
        for (int i = 0; i < TestHelper.NUMBER; i++) {
            DiagramElement element = new TextElement();
            assertTrue("True should be returned.", formatter.format(element));

            if (i == 0) {
                assertTrue("Ten properties have been added.", element.getProperties().size() == 10);
                ArrayList<Property> properties = (ArrayList<Property>) element.getProperties();
                for (int j = 1; j <= 10; j++) {
                    Property property = properties.get(j - 1);
                    assertTrue("Property key is not correct.", property.getKey().equals("property" + j));
                    assertTrue("Property value is not correct.", property.getValue().equals("value" + j));
                }
            }
        }
        TestHelper.printResultMulTimes("PropertyTemplateDiagramElementFormatter#format(DiagramElement)");
    }
}
