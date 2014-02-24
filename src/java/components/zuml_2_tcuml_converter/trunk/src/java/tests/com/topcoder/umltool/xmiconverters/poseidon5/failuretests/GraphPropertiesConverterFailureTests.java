/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import junit.framework.TestCase;

import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterConfigurationException;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.GraphPropertiesConverter;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * Failure test fixture for <code>GraphPropertiesConverter</code> class.
 * </p>
 * @author Thinfox
 * @version 1.0
 */
public class GraphPropertiesConverterFailureTests extends TestCase {
    /**
     * <p>
     * Set up the environment.
     * </p>
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        FailureTestHelper.clearConfig();
        ConfigManager.getInstance().add("failure/GraphPropertiesConverter.xml");
    }

    /**
     * <p>
     * Tear down the environment.
     * </p>
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        FailureTestHelper.clearConfig();
    }

    /**
     * <p>
     * Tests the ctor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     * <p>
     * When the nameSpace is null, IllegalArgumentException is expected.
     * </p>
     * @throws XMIConverterConfigurationException to JUnit
     */
    public void testCtor_Null() throws XMIConverterConfigurationException {
        try {
            new GraphPropertiesConverter(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     * <p>
     * When the namespace is unknown, XMIConverterConfigurationException is expected.
     * </p>
     */
    public void testCtor_UnknownNamespace() {
        try {
            new GraphPropertiesConverter("unknown");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     * <p>
     * When the property ObjectFactoryNamespace is missing, XMIConverterConfigurationException is
     * expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_ObjectFactoryNamespaceMissing() throws Exception {
        try {
            new GraphPropertiesConverter("ObjectFactoryNamespaceMissing");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     * <p>
     * When the property ObjectFactoryNamespace is unknown, XMIConverterConfigurationException is
     * expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_ObjectFactoryNamespaceUnknown() throws Exception {
        try {
            new GraphPropertiesConverter("ObjectFactoryNamespaceUnknown");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     * <p>
     * When the property PropertyValueTransformers contains an empty sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_EmptyTransformerKey() throws Exception {
        try {
            new GraphPropertiesConverter("EmptyTransformerKey");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     * <p>
     * When the property PropertyValueTransformers contains an invalid sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_InvalidTransformerKey1() throws Exception {
        try {
            new GraphPropertiesConverter("InvalidTransformerKey1");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     * <p>
     * When the property PropertyValueTransformers contains an invalid sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_InvalidTransformerKey2() throws Exception {
        try {
            new GraphPropertiesConverter("InvalidTransformerKey2");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     * <p>
     * When the property PropertyValueTransformers contains an invalid sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_InvalidTransformerKey3() throws Exception {
        try {
            new GraphPropertiesConverter("InvalidTransformerKey3");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     * <p>
     * When the property PropertyValueTransformers contains an invalid sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_InvalidTransformerKey4() throws Exception {
        try {
            new GraphPropertiesConverter("InvalidTransformerKey4");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     * <p>
     * When the property PropertyValueTransformers contains an invalid sub-property,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_InvalidTransformerDefinition() throws Exception {
        try {
            new GraphPropertiesConverter("InvalidTransformerDefinition");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }

    /**
     * <p>
     * Tests the ctor <code>GraphPropertiesConverter(String)</code>.
     * </p>
     * <p>
     * When the property ToReplacePropertyKeys contains a sub-property with multi-values,
     * XMIConverterConfigurationException is expected.
     * </p>
     * @throws Exception to JUnit
     */
    public void testCtor_ToReplacePropertyKeysMultiValues() throws Exception {
        try {
            new GraphPropertiesConverter("ToReplacePropertyKeysMultiValues");
            fail("XMIConverterConfigurationException is expected.");
        } catch (XMIConverterConfigurationException e) {
            // success
        }
    }
}
