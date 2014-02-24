/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import com.topcoder.gui.panels.documentation.event.DocumentationEventTestAcc;
import com.topcoder.gui.panels.documentation.event.DocumentationEventTestExp;
import com.topcoder.gui.panels.documentation.event.TagEventTestAcc;
import com.topcoder.gui.panels.documentation.event.TagEventTestExp;
import com.topcoder.gui.panels.documentation.plugins.DefaultDocumentationEditorTestAcc;
import com.topcoder.gui.panels.documentation.plugins.DefaultDocumentationEditorTestExp;
import com.topcoder.gui.panels.documentation.plugins.DefaultTagEditorTestAcc;
import com.topcoder.gui.panels.documentation.plugins.DefaultTagEditorTestExp;
import com.topcoder.gui.panels.documentation.plugins.DefaultTagTableModelTestAcc;
import com.topcoder.gui.panels.documentation.plugins.DefaultTagTableModelTestExp;
import com.topcoder.gui.panels.documentation.plugins.TagOptionManagerTestAcc;
import com.topcoder.gui.panels.documentation.plugins.TagOptionManagerTestExp;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * Aggregates all unit test cases and returns a testSuite.
     *
     * @return the test suite.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        //Customized Exception
        suite.addTestSuite(DocumentationPanelConfigurationExceptionTestAcc.class);
        suite.addTestSuite(UnknownElementTypeExceptionTestAcc.class);

        //Helper
        suite.addTestSuite(DocumentPanelHelperTestAcc.class);

        //TagEventTest
        suite.addTestSuite(TagEventTestAcc.class);
        suite.addTestSuite(TagEventTestExp.class);

        //DocumentationEvent
        suite.addTestSuite(DocumentationEventTestAcc.class);
        suite.addTestSuite(DocumentationEventTestExp.class);

        //TagEditor
        suite.addTestSuite(TagEditorTestAcc.class);
        suite.addTestSuite(TagEditorTestExp.class);

        //DocumentationEditor
        suite.addTestSuite(DocumentationEditorTestAcc.class);
        suite.addTestSuite(DocumentationEditorTestExp.class);

        //DefaultDocumentationEditor
        suite.addTestSuite(DefaultDocumentationEditorTestAcc.class);
        suite.addTestSuite(DefaultDocumentationEditorTestExp.class);

        //TagOptionManager
        suite.addTestSuite(TagOptionManagerTestAcc.class);
        suite.addTestSuite(TagOptionManagerTestExp.class);

        //DefaultTagTableModel
        suite.addTestSuite(DefaultTagTableModelTestAcc.class);
        suite.addTestSuite(DefaultTagTableModelTestExp.class);

        //DefaultTagEditor
        suite.addTestSuite(DefaultTagEditorTestAcc.class);
        suite.addTestSuite(DefaultTagEditorTestExp.class);

        //DocumentationPanel
        suite.addTestSuite(DocumentationPanelTestAcc.class);
        suite.addTestSuite(DocumentationPanelTestExp.class);
        return suite;
    }
}
