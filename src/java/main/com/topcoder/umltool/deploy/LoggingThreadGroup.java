/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;


public class LoggingThreadGroup extends ThreadGroup {
    public LoggingThreadGroup(String name) {
        super(name);
      }
      public void uncaughtException(Thread t, Throwable e) {
        DeployHelper.logException(e);
      }
}
