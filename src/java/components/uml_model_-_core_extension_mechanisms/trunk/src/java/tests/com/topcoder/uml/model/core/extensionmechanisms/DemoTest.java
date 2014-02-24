/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms;

import java.util.Collection;

import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.MultiplicityRange;
import com.topcoder.uml.model.datatypes.MultiplicityRangeImpl;

import junit.framework.TestCase;

/**
 * <p>
 * This demo illustrates how to use this component.
 * </p>
 *
 * @author BLE
 * @version 1.0
 */
public class DemoTest extends TestCase {
    /**
     * <p>
     * <strong>Section 1 of demo: Create Stereotype and manage its attributes</strong>
     * </p>
     * <p>
     * It illustrates how to create Stereotype and manage its attributes.
     * </p>
     */
    public void testSection1() {
        // create object
        Stereotype stereotype = new StereotypeImpl();

        // set and get baseClass attribute
        stereotype.setBaseClass("Method");
        String baseClass = stereotype.getBaseClass();

        // manage defined tags
        TagDefinition tag1 = new TagDefinitionImpl();
        TagDefinition tag2 = new TagDefinitionImpl();

        // add defined tag
        stereotype.addDefinedTag(tag1);
        stereotype.addDefinedTag(tag2);

        // get all defined tags
        Collection<TagDefinition> tagDefs = stereotype.getDefinedTags();

        // check the existence of tag1, the result should be true
        boolean existent = stereotype.containsDefinedTag(tag1);

        // count the number of defined tags, the result should be 2
        int ret = stereotype.countDefinedTags();

        // remove defined tag
        stereotype.removeDefinedTag(tag1);

        // clear all defined tags
        stereotype.clearDefinedTags();

        // manage extended elements, MethodImpl class is from the UML Model Core
        // Requirement component.
        ModelElement element1 = new MethodImpl();
        ModelElement element2 = new MethodImpl();

        // add extended element
        stereotype.addExtendedElement(element1);
        stereotype.addExtendedElement(element2);

        // get all extended elements
        Collection<ModelElement> elements = stereotype.getExtendedElements();

        // check the existence of element1, the result should be true
        existent = stereotype.containsExtendedElement(element1);

        // count the number of extended elements, the result should be 2
        ret = stereotype.countExtendedElements();

        // remove extended elements
        stereotype.removeExtendedElement(element1);

        // clear all extended elements
        stereotype.clearExtendedElements();

        // create the object with another constructor
        stereotype = new StereotypeImpl("Method", tagDefs, elements);

    }

    /**
     * <p>
     * <strong>Section 2 of demo: Create TagDefinition and manage its attributes</strong>
     * </p>
     * <p>
     * It illustrates how to create TagDefinition and manage its attributes.
     * </p>
     */
    public void testSection2() {
        // create the object
        TagDefinition tagDef = new TagDefinitionImpl();

        // get/set tagType attribute
        tagDef.setTagType("UML:Datatypes:String");
        String tagType = tagDef.getTagType();

        // get/set multiplicity attribute,
        // MultiplicityImpl class is from the UML Data Types component
        tagDef.setMultiplicity(new MultiplicityImpl());
        Multiplicity multiplicity = tagDef.getMultiplicity();

        // get/set its owner attribute
        tagDef.setOwner(new StereotypeImpl());
        Stereotype stereotype = tagDef.getOwner();

        // manage its typedValues attribute
        TaggedValue value1 = new TaggedValueImpl();
        TaggedValue value2 = new TaggedValueImpl();

        // add typed value
        tagDef.addTypedValue(value1);
        tagDef.addTypedValue(value2);

        // get all typed values
        Collection<TaggedValue> taggedValues = tagDef.getTypedValues();

        // check the existence of value1, the result should be true
        boolean existence = tagDef.containsTypedValue(value1);

        // count the number of typed values, the result should be 2
        int ret = tagDef.countTypedValues();

        // remove the typed value
        tagDef.removeTypedValue(value1);

        // clear all typed values
        tagDef.clearTypedValues();

        // create the object with another constructor
        tagDef = new TagDefinitionImpl(tagType, multiplicity, stereotype, taggedValues);

    }

    /**
     * <p>
     * <strong>Section 3 of demo: Create TaggedValue and manage its attributes</strong>
     * </p>
     * <p>
     * It illustrates how to create TaggedValue and manage its attributes.
     * </p>
     */
    public void testSection3() {
        // create the object
        TaggedValue taggedValue = new TaggedValueImpl();

        // get/set dataValue attribute
        taggedValue.setDataValue("true");
        String dataValue = taggedValue.getDataValue();

        // get/set type attribute
        taggedValue.setType(new TagDefinitionImpl());
        TagDefinition type = taggedValue.getType();

        // get/set modelElement attribute. MethodImpl class is from the UML
        // Model Core Requirement component.
        taggedValue.setModelElement(new MethodImpl());
        ModelElement element = taggedValue.getModelElement();

        // manage reference values, MethodImpl class is from the UML Model Core
        // Requirement component.
        ModelElement refValue1 = new MethodImpl();
        ModelElement refValue2 = new MethodImpl();

        // add reference value
        taggedValue.addReferenceValue(refValue1);
        taggedValue.addReferenceValue(refValue2);

        // get all reference values
        Collection<ModelElement> refValues = taggedValue.getReferenceValues();

        // check the existence of refValue1, the result is true
        boolean existence = taggedValue.containsReferenceValue(refValue1);

        // count the number of reference values, the result should be 2
        int ret = taggedValue.countReferenceValues();

        // remove reference value
        taggedValue.removeReferenceValue(refValue1);

        // clear all reference values
        taggedValue.clearReferenceValues();
    }

    /**
     * <p>
     * <strong>Section 4 of demo: A simple customer scenario</strong>
     * </p>
     * <p>
     * More information about the scenario is included in section 4.3.4 of CS.
     * </p>
     */
    public void testSection4() {
        Stereotype stereotype = new StereotypeImpl();
        // this method is from its base-class
        stereotype.setName("ersistent");
        stereotype.setBaseClass("Class");

        TagDefinition tagDef = new TagDefinitionImpl();

        // this method is from its base-class
        tagDef.setName("isPersistent");
        tagDef.setTagType("UML::Datatypes::Boolean");

        // Multiplicity, MultiplicityRange and its implementation classes
        // are all from the UML Model Data Types component.
        Multiplicity multiplicity = new MultiplicityImpl();
        MultiplicityRange range = new MultiplicityRangeImpl();
        range.setLower(1);
        range.setUpper(1);
        multiplicity.addRange(range);

        tagDef.setMultiplicity(multiplicity);

        // add tagged value to this tagDef
        TaggedValue value = new TaggedValueImpl();
        value.setDataValue("true");
        tagDef.addTypedValue(value);

        // add this tagDef to the stereotype finally
        stereotype.addDefinedTag(tagDef);
    }
}
