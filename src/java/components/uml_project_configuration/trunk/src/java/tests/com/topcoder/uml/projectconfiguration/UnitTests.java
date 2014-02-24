/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.projectconfiguration;

import com.topcoder.uml.projectconfiguration.diagramelementformatters.PropertyTemplateDiagramElementFormatterTests;
import com.topcoder.uml.projectconfiguration.modelelementformatters.AbstractElementFormatterTests;
import com.topcoder.uml.projectconfiguration.modelelementformatters.CSharpExceptionElementFormatterTests;
import com.topcoder.uml.projectconfiguration.modelelementformatters.Java14EnumElementFormatterTests;
import com.topcoder.uml.projectconfiguration.modelelementformatters.JavaExceptionElementFormatterTests;
import com.topcoder.uml.projectconfiguration.stereotypeloader.XMLStereotypeLoaderTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * <p>
     * This test case aggregates all Unit test cases.
     * </p>
     *
     * @return all Unit test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTest(ProjectConfigurationManagerTests.suite());
        suite.addTest(UtilTests.suite());
        suite.addTest(ProjectConfigurationExceptionTests.suite());
        suite.addTest(PropertyTemplateDiagramElementFormatterTests.suite());
        suite.addTest(AbstractElementFormatterTests.suite());
        suite.addTest(JavaExceptionElementFormatterTests.suite());
        suite.addTest(CSharpExceptionElementFormatterTests.suite());
        suite.addTest(Java14EnumElementFormatterTests.suite());
        suite.addTest(XMLStereotypeLoaderTests.suite());

        suite.addTest(DemoTests.suite());

        return suite;
    }

}
