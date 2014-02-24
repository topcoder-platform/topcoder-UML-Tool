/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.stresstests;

import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import com.topcoder.util.config.ConfigManager;

import java.util.Iterator;


/**
 * <p>Helper class to simplify the stress testing.</p>
 *
 * @author icyriver
 * @version 1.0
 */
final class StressTestHelper {
/**
     * <p>
     * The private constructor to avoid creating instance of this class.
     * </p>
     */
    private StressTestHelper() {
    }

    /**
     * <p>Clear all namespaces in ConfigManager.</p>
     *
     * @throws Exception if configuration could not be clear.
     */
    public static void clearNamespace() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator it = cm.getAllNamespaces();

        while (it.hasNext()) {
            cm.removeNamespace((String) it.next());
        }
    }

    /**
     * <p>Get the <code>TaggedValue</code> instance with the given tag type and data value.</p>
     *
     * @param tagType the given tag type.
     * @param dataValue the given data value.
     *
     * @return the created <code>TaggedValue</code> instance.
     */
    public static TaggedValue getTaggedValue(String tagType, String dataValue) {
        // create the tag type.
        TagDefinition tagDef = new TagDefinitionImpl();
        tagDef.setTagType(tagType);

        // create the tag value and set the tag type.
        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setType(tagDef);
        taggedValue.setDataValue(dataValue);

        return taggedValue;
    }

    /**
     * <p>Get the <code>Parameter</code> instance with the given tag type, tag
     * documentation and parameter name.</p>
     *
     * @param tagType the given tag type.
     * @param tagDoc the given tag documentation.
     * @param paramName the given parameter name.
     *
     * @return the created <code>Parameter</code> instance.
     */
    public static Parameter getParameter(String tagType, String tagDoc, String paramName) {
        // create the tag value and set the tag type.
        TaggedValue taggedValue = getTaggedValue(tagType, tagDoc);

        ParameterImpl param = new ParameterImpl();
        param.addTaggedValue(taggedValue);
        param.setName(paramName);

        return param;
    }
}
