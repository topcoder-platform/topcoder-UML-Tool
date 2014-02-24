/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This is a helper class, which has all the Object declarations that can be used across.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class TestHelper {
    /**
     * <p>
     * UMLModelManager instance.
     * </p>
     */
    public static final UMLModelManager MODELMANAGER = new UMLModelManager();

    /**
     * <p>
     * Creates a new instance of TestHelper.
     * </p>
     */
    private TestHelper() {
        // hiding the default constructor.
    }

    /**
     * <p>
     * Creates a model with a tagged value consisting of ProjectLanguage as tag definition.
     * </p>
     *
     * @return the created model.
     */
    public static Model getModel() {
        MockModel model = new MockModel();
        // create a new tag definition with ProjectLanguage as type
        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType("ProjectLanguage");
        // create a tagged value with the project language as data and type as tag definition.
        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue("c++");
        taggedValue.setType(tagDefinition);
        // add the tagged value to the model
        model.addTaggedValue(taggedValue);
        return model;
    }
}
