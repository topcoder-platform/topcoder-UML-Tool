/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.writer.transformers.model.failuretests;

import java.io.File;
import java.util.Iterator;

import com.topcoder.util.config.ConfigManager;

/**
 * Failure tests utitlies.
 * <p>
 * It defines some constants which represents configuration file names.
 * And it also defines methods to load and clear configurations.
 * </p>
 *
 * @author maone
 * @version 1.0
 */
public final class FailureTestUtil {

  /**
   * Represents a file name which contains valid configurations.
   */
  public static final String VALID_CONFIG = "test_files/failure/valid.xml";

  /**
   * Represents the configuration file which contains invalid description name.
   */
  public static final String INVALID_DESCRIPTION_CONFIG =
    "test_files/failure/invalid_description.xml";

  /**
   * Represents the configuration file which contains invalid objectfactory namespace.
   */
  public static final String INVALID_OBJECTFACTORY_CONFIG =
    "test_files/failure/invalid_objectfactory.xml";

  /**
   * Represents the configuration file which misses ignoreUnknownElementType flag.
   */
  public static final String MISS_IGNOREUNKNOWNELEMENTTYPE_CONFIG =
    "test_files/failure/miss_ignoreUknownElementType.xml";

  /**
   * Represents the configuration file which misses objectfactory namespace.
   */
  public static final String MISS_OBJECTFACTORY_CONFIG =
    "test_files/failure/miss_objectfactory.xml";

  /**
   * Represents the configuration file which misses description name.
   */
  public static final String MISS_DESCRIPTION_CONFIG =
    "test_files/failure/miss_description.xml";

  /**
   * Clear all the configurations in ConfigManager.
   *
   * @throws Exception to JUnit.
   */
  public static void clearAllConfigurations() throws Exception {
    ConfigManager cm = ConfigManager.getInstance();
    for (Iterator itr = cm.getAllNamespaces(); itr.hasNext(); ) {
      cm.removeNamespace((String) itr.next());
    }
  }

  /**
   * Load configuration from the specific file.
   *
   * @param file the configuration file.
   * @throws Exception to JUnit.
   */
  public static void loadConfig(String file) throws Exception {
    ConfigManager.getInstance().add(new File(file).getAbsolutePath());
  }
}
