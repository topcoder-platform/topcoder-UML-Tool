/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import junit.framework.TestCase;


/**
 * Test case for ImageExporter. This test mainly test the ImageExporter's constructors with different configs.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ImageExporterConfigTest extends TestCase {
    /** Default config file used in this test. */
    private static final String CONFIG = "ImageExporter.xml";

    /** Default namespace for exporter. */
    private static final String DEFAULT_NAMESPACE = "com.topcoder.swing.imageexporter";

    /** Default ImageExporter instance used in this test. */
    private ImageExporter exporter;

    /**
     * Test {@link ImageExporter#ImageExporter()}. ImageExporter should be created.
     */
    public void testImageExporter() {
        assertNotNull("ImageExporter should be created", exporter);
    }

    /**
     * Test {@link ImageExporter#ImageExporter(String)()}. ImageExporter should be created with default
     * namespace.
     *
     * @throws Exception to junit
     */
    public void testImageExporterString() throws Exception {
        assertNotNull("ImageExporter should be created", new ImageExporter(DEFAULT_NAMESPACE));
    }

    /**
     * Test {@link ImageExporter#ImageExporter(String)()} with custom exporters and visible maker.
     * ImageExporter should be created with default namespace.
     *
     * @throws Exception to junit
     */
    public void testImageExporterStringCustom() throws Exception {
        TestHelper.setProperty(DEFAULT_NAMESPACE, "exportersMap", "custom_exporter");
        TestHelper.setProperty(DEFAULT_NAMESPACE, "jComponentVisibleMaker", "custom_visible_maker");
        assertNotNull("ImageExporter should be created", new ImageExporter(DEFAULT_NAMESPACE));
    }

    /**
     * Test {@link ImageExporter#ImageExporter(String)()}, given invalid config with malformed exportersMap ,
     * ImageExporterConfigurationException is expected.
     *
     * @throws Exception to junit
     */
    public void testImageExporterStringInvalidexportersMap()
        throws Exception {
        TestHelper.setProperty(DEFAULT_NAMESPACE, "exportersMap", " ");

        try {
            new ImageExporter(DEFAULT_NAMESPACE);
            fail("property exportersMap invalid, ImageExporterConfigurationException is expected");
        } catch (ImageExporterConfigurationException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#ImageExporter(String)()}, given invalid config with malformed
     * jComponentVisibleMaker , ImageExporterConfigurationException is expected.
     *
     * @throws Exception to junit
     */
    public void testImageExporterStringInvalidjComponentVisibleMaker()
        throws Exception {
        TestHelper.setProperty(DEFAULT_NAMESPACE, "jComponentVisibleMaker", " ");

        try {
            new ImageExporter(DEFAULT_NAMESPACE);
            fail("property jComponentVisibleMaker invalid, ImageExporterConfigurationException is expected");
        } catch (ImageExporterConfigurationException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#ImageExporter(String)()}, given invalid config with exportersMap exists but
     * objectFactoryNamespace missing, ImageExporterConfigurationException is expected.
     *
     * @throws Exception to junit
     */
    public void testImageExporterStringObjectFactoryRequired_1()
        throws Exception {
        TestHelper.setProperty(DEFAULT_NAMESPACE, "exportersMap", "custom_exporter");
        TestHelper.removeProperty(DEFAULT_NAMESPACE, "objectFactoryNamespace");

        try {
            new ImageExporter(DEFAULT_NAMESPACE);
            fail("property exportersMap missing, ImageExporterConfigurationException is expected");
        } catch (ImageExporterConfigurationException e) {
            //success
        }
    }

    /**
     * Test {@link ImageExporter#ImageExporter(String)()}, given invalid config with jComponentVisibleMaker
     * exists but objectFactoryNamespace missing, ImageExporterConfigurationException is expected.
     *
     * @throws Exception to junit
     */
    public void testImageExporterStringObjectFactoryRequired_2()
        throws Exception {
        TestHelper.setProperty(DEFAULT_NAMESPACE, "jComponentVisibleMaker", "custom_visible_maker");
        TestHelper.removeProperty(DEFAULT_NAMESPACE, "objectFactoryNamespace");

        try {
            new ImageExporter(DEFAULT_NAMESPACE);
            fail("property exportersMap missing, ImageExporterConfigurationException is expected");
        } catch (ImageExporterConfigurationException e) {
            //success
        }
    }

    /**
     * Sets up test environment.
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.loadConfig(CONFIG); // load config file
        TestHelper.backupConfig(CONFIG); // back config file preventing it from being modified during the test

        exporter = new ImageExporter();
    }

    /**
     * Clears test environment.
     *
     * @throws Exception to junit
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        TestHelper.clearConfig(); // clear all config
        TestHelper.restoreConfig(CONFIG); // restore the backup config file
    }
}
