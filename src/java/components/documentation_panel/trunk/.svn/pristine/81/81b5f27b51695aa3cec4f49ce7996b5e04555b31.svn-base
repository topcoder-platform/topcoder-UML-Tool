/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * @ TestHelper.java
 */
package com.topcoder.gui.panels.documentation.accuracytests;

import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.util.config.ConfigManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Test Helper for the component.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class TestHelper {
    /**
     * Private test helper.
     */
    private TestHelper() {
    }
    /**
     * <p>
     * Get <code>TaggedValue</code> with desired tag type and tagValue.
     * </p>
     *
     * @param tagType desired tag type.
     * @param tagValue desired tag value.
     *
     * @return TaggedValue with the given type and value.
     */
    public static TaggedValue getTaggedValueWithTagType(String tagType, String tagValue) {
        TaggedValue tv = new TaggedValueImpl();
        TagDefinition tg = new TagDefinitionImpl();
        tv.setType(tg);
        tv.getType().setTagType(tagType);
        tv.setDataValue(tagValue);
        return tv;
    }

    /**
     * Clear all the configs.
     *
     * @throws Exception exception to the caller.
     */
    @SuppressWarnings("unchecked")
    public static void clearConfig() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        Iterator it = cm.getAllNamespaces();
        List nameSpaces = new ArrayList();

        while (it.hasNext()) {
            nameSpaces.add(it.next());
        }

        for (int i = 0; i < nameSpaces.size(); i++) {
            cm.removeNamespace((String) nameSpaces.get(i));
        }
    }
}
