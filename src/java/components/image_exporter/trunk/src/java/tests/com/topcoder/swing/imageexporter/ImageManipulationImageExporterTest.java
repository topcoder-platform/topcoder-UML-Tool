/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * Test case for {@link ImageManipulationImageExporter}. This test will mainly test the constructor and
 * getSupportedFormats().
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ImageManipulationImageExporterTest extends TestCase {
    /** Default config file used in this test. */
    private static final String CONFIG = "ImageManipulationImageExporter.xml";

    /** Default namespace for exporter. */
    private static final String DEFAULT_NAMESPACE = "ImageManipulationImageExporterProperties";

    /** Default exporter used in this test. */
    private ImageManipulationImageExporter exporter;

    /**
     * Test {@link ImageManipulationImageExporter#getSupportedFormats()}. All default formats and an extra
     * custom format are expected.
     */
    public void testGetSupportedFormats() {
        String[] supportedFormats = {"jpeg", "bmp", "png", "pnm", "tiff", "gif", "custom_format_2" };

        String[] result = exporter.getSupportedFormats();
        Set<String> set = new HashSet<String>();
        set.addAll(Arrays.asList(result));

        for (int i = 0; i < supportedFormats.length; i++) {
            assertTrue(supportedFormats[i] + " should be supported", set.contains(supportedFormats[i]));
        }
    }

    /**
     * Test default constructor. ImageManipulationImageExporter should be created.
     */
    public void testImageManipulationImageExporter() {
        assertNotNull("ImageManipulationImageExporter should be created successfully", exporter);
    }

    /**
     * Test constructor with invalid encodersMap property config, ImageExporterConfigurationException is
     * expected.
     *
     * @throws Exception to junit
     */
    public void testImageManipulationImageExporter_Invalid_encodersMap()
        throws Exception {
        String[] values = {"", " ", "custom_format_2", "custom_format2,", "custom_format2,not_existent_encoder" };

        for (int i = 0; i < values.length; i++) {
            TestHelper.setProperty(DEFAULT_NAMESPACE, "renderingHints", values[i]);

            try {
                new ImageManipulationImageExporter();
                fail("encodersMap:" + values[i] + " is invalid, ImageExporterConfigurationException will be thrown");
            } catch (ImageExporterConfigurationException e) {
                // success
            }
        }
    }

    /**
     * Test constructor with invalid imageType property config, ImageExporterConfigurationException is
     * expected.
     *
     * @throws Exception to junit
     */
    public void testImageManipulationImageExporter_Invalid_imageType()
        throws Exception {
        String[] invalidImageTypes = {"invalid_type", "TYPE_CUSTOM", " ", "TYPE_INT_RGB1" };

        for (int i = 0; i < invalidImageTypes.length; i++) {
            TestHelper.setProperty(DEFAULT_NAMESPACE, "imageType", invalidImageTypes[i]);

            try {
                new ImageManipulationImageExporter();
                fail("image type:" + invalidImageTypes[i]
                    + " is invalid, ImageExporterConfigurationException will be thrown");
            } catch (ImageExporterConfigurationException e) {
                // success
            }
        }
    }

    /**
     * Test constructor with invalid objectFactoryNamespace property config,
     * ImageExporterConfigurationException is expected.
     *
     * @throws Exception to junit
     */
    public void testImageManipulationImageExporter_Invalid_objectFactoryNamespace()
        throws Exception {
        TestHelper.removeProperty(DEFAULT_NAMESPACE, "objectFactoryNamespace");

        try {
            new ImageManipulationImageExporter();
            fail("encoders exist but missing objectFactoryNamespace, ImageExporterConfigurationException"
                + "will be thrown");
        } catch (ImageExporterConfigurationException e) {
            // success
        }
    }

    /**
     * Test constructor with invalid objectFactoryNamespace property config, given encoder key is invalid.
     * ImageExporterConfigurationException is expected.
     *
     * @throws Exception to junit
     */
    public void testImageManipulationImageExporter_Invalid_objectFactoryNamespace_2()
        throws Exception {
        TestHelper.setProperty(DEFAULT_NAMESPACE, "encodersMap", "not_existent_encoder_key");

        try {
            new ImageManipulationImageExporter();
            fail("encoder's key not exists in object factory namespace, ImageExporterConfigurationException"
                + "will be thrown");
        } catch (ImageExporterConfigurationException e) {
            // success
        }
    }

    /**
     * Test constructor with invalid objectFactoryNamespace property config, given encoder is not type of
     * JComponentImageExporter. ImageExporterConfigurationException is expected.
     *
     * @throws Exception to junit
     */
    public void testImageManipulationImageExporter_Invalid_objectFactoryNamespace_3()
        throws Exception {
        TestHelper.setProperty("ObjectFactory_Encoders", "custom_encoder.type", "java.lang.String");

        try {
            new ImageManipulationImageExporter();
            fail("encoder is not type of JComponentImageExporter, ImageExporterConfigurationException will be thrown");
        } catch (ImageExporterConfigurationException e) {
            // success
        }
    }

    /**
     * Test constructor with invalid renderingHints property config, ImageExporterConfigurationException is
     * expected.
     *
     * @throws Exception to junit
     */
    public void testImageManipulationImageExporter_Invalid_renderingHints()
        throws Exception {
        String[] invalidHints = {"KEY_FRACTIONALMETRICS,KEY_STROKE_CONTROL", "KEY_FRACTIONALMETRICS,",
            ",KEY_STROKE_CONTROL", "", " " };

        for (int i = 0; i < invalidHints.length; i++) {
            TestHelper.setProperty(DEFAULT_NAMESPACE, "renderingHints", invalidHints[i]);

            try {
                new ImageManipulationImageExporter();
                fail("renderingHints:" + invalidHints[i]
                    + " is invalid, ImageExporterConfigurationException will be thrown");
            } catch (ImageExporterConfigurationException e) {
                // success
            }
        }
    }

    /**
     * Test constructor with empty config, all value will be used by default and exporter will be created
     * successfully.
     *
     * @throws Exception to junit
     */
    public void testImageManipulationImageExporter_empty_config()
        throws Exception {
        TestHelper.removeProperty(DEFAULT_NAMESPACE, "imageType");
        TestHelper.removeProperty(DEFAULT_NAMESPACE, "renderingHints");
        TestHelper.removeProperty(DEFAULT_NAMESPACE, "encodersMap");
        TestHelper.removeProperty(DEFAULT_NAMESPACE, "objectFactoryNamespace");
        assertNotNull("ImageManipulationImageExporter should be created successfully",
            new ImageManipulationImageExporter());
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

        exporter = new ImageManipulationImageExporter();
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
