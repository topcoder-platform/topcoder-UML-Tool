/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.model.core.auxiliaryelements.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
* <p>This test case aggregates all failure test cases.</p>
*
* @author TopCoder
* @version 1.0
*/
public class FailureTests extends TestCase {
   public static Test suite() {
       final TestSuite suite = new TestSuite();
       suite.addTestSuite(TestCommentImpl.class);
       
       return suite;
   }
}
