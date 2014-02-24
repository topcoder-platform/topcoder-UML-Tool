/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.DataTypeImpl;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

import com.topcoder.util.config.ConfigManager;

import java.util.List;
import java.util.Map;


/**
 * Unit tests for the class {@link AbstractGenerator}.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestAbstractGenerator extends AbstractGeneratorTestCase {
    /**
     * Name space.
     */
    private static final String NAMESPACE = "stub_class_generator";

    /**
     * The unit under test.
     */
    private AbstractGenerator uut;

    /**
     * Set up the fixture.
     *
     * @throws Exception
     *             to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.clearConfigManager();
        ConfigManager.getInstance().add("config.xml");
        this.uut = new MyAbstractGenerator(NAMESPACE);
    }

    /**
     * Clears the config manager.
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        TestHelper.clearConfigManager();
    }

    /**
     * <b>Failure test</b> for method AbstractGenerator(String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  namespace = null
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAbstractGeneratorStringFailureNullNS()
        throws Exception {
        try {
            new MyAbstractGenerator(null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method AbstractGenerator(String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  namespace = &quot;  &quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAbstractGeneratorStringFailureEmptyNS()
        throws Exception {
        try {
            new MyAbstractGenerator("  ");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method AbstractGenerator(String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  namespace = &quot;unkown&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * GeneratorConfigurationException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAbstractGeneratorStringFailureUnkownNS()
        throws Exception {
        try {
            new MyAbstractGenerator("unknown");
            fail("GeneratorConfigurationException expected");
        } catch (GeneratorConfigurationException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method AbstractGenerator(String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  namespace = &quot;empty_config&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * GeneratorConfigurationException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testAbstractGeneratorStringFailureMissingDocumentation()
        throws Exception {
        try {
            new MyAbstractGenerator("empty_config");
            fail("GeneratorConfigurationException expected");
        } catch (GeneratorConfigurationException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method getPackage(Package).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  pack = null
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetPackagePackageFailureNullPackage()
        throws Exception {
        Package pack = null;

        try {
            this.uut.getPackage(pack);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method getPackage(Package).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  pack = a root package with no name
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  &quot;&quot;
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetPackagePackageAccuracyRootPackageNoName()
        throws Exception {
        Model model = new ModelImpl();
        Package pack = new PackageImpl();
        model.addOwnedElement(pack);
        pack.setNamespace(model);

        String res = this.uut.getPackage(pack);

        assertEquals("package name", "", res);
    }

    /**
     * <b>Accuracy test</b> for method getPackage(Package).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  pack = a root package
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  &quot;com&quot;
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetPackagePackageAccuracyRootPackage()
        throws Exception {
        Model model = new ModelImpl();
        Package pack = new PackageImpl();
        model.addOwnedElement(pack);
        pack.setNamespace(model);
        pack.setName("com");

        String res = this.uut.getPackage(pack);

        assertEquals("package name", "com", res);
    }

    /**
     * <b>Accuracy test</b> for method getPackage(Package).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  pack = a package
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  &quot;com.topcoder&quot;
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetPackagePackageAccuracyTwoPackages()
        throws Exception {
        Model model = new ModelImpl();
        Package packCom = new PackageImpl();
        model.addOwnedElement(packCom);
        packCom.setNamespace(model);
        packCom.setName("com");

        Package packTc = new PackageImpl();
        packTc.setNamespace(packCom);
        packTc.setName("topcoder");

        String res = this.uut.getPackage(packTc);

        assertEquals("package name", "com.topcoder", res);
    }

    /**
     * <b>Accuracy test</b> for method getPackage(Package).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  pack = a package, one package has no name
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  &quot;com.topcoder&quot;
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetPackagePackageAccuracyThreePackagesOneNoName()
        throws Exception {
        Model model = new ModelImpl();
        model.setName("model");

        Package packCom = new PackageImpl();
        model.addOwnedElement(packCom);
        packCom.setNamespace(model);
        packCom.setName("com");

        Package packNoName = new PackageImpl();
        packNoName.setNamespace(packCom);

        Package packTc = new PackageImpl();
        packTc.setNamespace(packNoName);
        packTc.setName("topcoder");

        String res = this.uut.getPackage(packTc);

        assertEquals("package name", "com.topcoder", res);
    }

    /**
     * <b>Failure test</b> for method getPackage(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  classifier = null
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetPackageClassifierFailure() throws Exception {
        Classifier classifier = null;

        try {
            this.uut.getPackage(classifier);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method getPackage(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  classifier in root package
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  &quot;&quot;
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetPackageClassifierAccuracyInRoot()
        throws Exception {
        Classifier classifier = this.createClass("Foo", "");
        String res = this.uut.getPackage(classifier);

        assertEquals("package name", "", res);
    }

    /**
     * <b>Accuracy test</b> for method getPackage(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  classifier in com package
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  &quot;com&quot;
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetPackageClassifierAccuracyInCom()
        throws Exception {
        Classifier classifier = this.createClass("Foo", "com");
        String res = this.uut.getPackage(classifier);

        assertEquals("package name", "com", res);
    }

    /**
     * <b>Accuracy test</b> for method getPackage(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  classifier of inner class
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  &quot;com&quot;
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetPackageClassifierAccuracyInnerClass()
        throws Exception {
        Classifier outterClass = this.createClass("OutterFoo", "com.topcoder.test");

        Classifier classifier = new ClassImpl();
        classifier.setName("Foo");
        classifier.setNamespace(outterClass);
        outterClass.addOwnedElement(classifier);

        String res = this.uut.getPackage(classifier);

        assertEquals("package name", "", res);
    }

    /**
     * <b>Failure test</b> for method checkClassifier(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  classifier = null
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcheckClassifierClassifierFailure()
        throws Exception {
        Classifier classifier = null;

        try {
            this.uut.checkClassifier(classifier);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method checkClassifier(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  classifier = a Class instance
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  true
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcheckClassifierClassifierAccuracyClass()
        throws Exception {
        Classifier classifier = new ClassImpl();
        assertTrue("check", this.uut.checkClassifier(classifier));
    }

    /**
     * <b>Accuracy test</b> for method checkClassifier(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  classifier = an Enumeration instance
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  true
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcheckClassifierClassifierAccuracyEnum()
        throws Exception {
        Classifier classifier = new EnumerationImpl();
        assertTrue("check", this.uut.checkClassifier(classifier));
    }

    /**
     * <b>Accuracy test</b> for method checkClassifier(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  classifier = a Interface instance
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  true
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcheckClassifierClassifierAccuracyInterface()
        throws Exception {
        Classifier classifier = new InterfaceImpl();
        assertTrue("check", this.uut.checkClassifier(classifier));
    }

    /**
     * <b>Accuracy test</b> for method checkClassifier(Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  classifier = a Datatype instance
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  false
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcheckClassifierClassifierAccuracyDataType()
        throws Exception {
        Classifier classifier = new DataTypeImpl();
        assertFalse("check", this.uut.checkClassifier(classifier));
    }

    /**
     * <b>Failure test</b> for method getGeneralDocumentation(ModelElement).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  modelElement = null
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetGeneralDocumentationModelElementFailureNullModelElement()
        throws Exception {
        ModelElement modelElement = null;

        try {
            this.uut.getGeneralDocumentation(modelElement);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method getGeneralDocumentation(ModelElement).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  modelElement = a model element
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  &quot;data&quot;
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetGeneralDocumentationModelElementAccuracyWithDoc()
        throws Exception {
        ModelElement modelElement = new ClassImpl();
        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue("data");

        TagDefinition type = new TagDefinitionImpl();
        type.setTagType("doc");

        taggedValue.setType(type);
        modelElement.addTaggedValue(taggedValue);

        assertEquals("data", "data", this.uut.getGeneralDocumentation(modelElement));
    }

    /**
     * <b>Accuracy test</b> for method getGeneralDocumentation(ModelElement).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  modelElement = a model element
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  null
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetGeneralDocumentationModelElementAccuracyWithoutDoc()
        throws Exception {
        ModelElement modelElement = new ClassImpl();
        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue("data");

        TagDefinition type = new TagDefinitionImpl();
        type.setName("no documentation");
        taggedValue.setType(type);

        modelElement.addTaggedValue(taggedValue);

        assertNull("data", this.uut.getGeneralDocumentation(modelElement));
    }

    /**
     * <b>Failure test</b> for method getTagDocumentation(ModelElement).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  modelElement = null
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetTagDocumentationModelElementFailure()
        throws Exception {
        ModelElement modelElement = null;

        try {
            this.uut.getTagDocumentation(modelElement);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method getTagDocumentation(ModelElement).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  modelElement with one tag &quot;myTag&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  the tag
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetTagDocumentationModelElementAccuracyOneTag()
        throws Exception {
        ModelElement modelElement = new ClassImpl();
        TaggedValue taggedValue1 = new TaggedValueImpl();
        taggedValue1.setDataValue("data 1");

        TagDefinition type = new TagDefinitionImpl();
        type.setTagType("doc#myTag");
        taggedValue1.setType(type);

        modelElement.addTaggedValue(taggedValue1);

        Map<String, List<String>> res = this.uut.getTagDocumentation(modelElement);

        assertEquals("number of tags", 1, res.size());

        List<String> tagList = res.get("myTag");

        assertEquals("number of tags", 1, tagList.size());
        assertEquals("tag", "data 1", tagList.get(0));
    }

    /**
     * <b>Accuracy test</b> for method getTagDocumentation(ModelElement).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  modelElement with one tag &quot;myTag&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  the tag
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetTagDocumentationModelElementAccuracyOneTagTwoValues()
        throws Exception {
        ModelElement modelElement = new ClassImpl();
        TaggedValue taggedValue1 = new TaggedValueImpl();
        taggedValue1.setDataValue("data 1");

        TagDefinition type1 = new TagDefinitionImpl();
        type1.setTagType("doc#myTag");
        taggedValue1.setType(type1);
        modelElement.addTaggedValue(taggedValue1);

        TaggedValue taggedValue2 = new TaggedValueImpl();
        taggedValue2.setDataValue("data 2");

        TagDefinition type2 = new TagDefinitionImpl();
        type2.setTagType("doc#myTag");
        taggedValue2.setType(type2);
        modelElement.addTaggedValue(taggedValue2);

        Map<String, List<String>> res = this.uut.getTagDocumentation(modelElement);

        assertEquals("number of tags", 1, res.size());

        List<String> tagList = res.get("myTag");

        assertEquals("number of tags", 2, tagList.size());
        assertEquals("tag", "data 1", tagList.get(0));
        assertEquals("tag", "data 2", tagList.get(1));
    }

    /**
     * <b>Accuracy test</b> for method getTagDocumentation(ModelElement).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  modelElement with two tags &quot;myTag1&quot; and &quot;myTag2&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  the tags
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetTagDocumentationModelElementAccuracyTwoTags()
        throws Exception {
        ModelElement modelElement = new ClassImpl();
        TaggedValue taggedValue1 = new TaggedValueImpl();
        taggedValue1.setDataValue("data 1");

        TagDefinition type1 = new TagDefinitionImpl();
        type1.setTagType("doc#myTag1");
        taggedValue1.setType(type1);
        modelElement.addTaggedValue(taggedValue1);

        TaggedValue taggedValue2 = new TaggedValueImpl();
        taggedValue2.setDataValue("data 2");

        TagDefinition type2 = new TagDefinitionImpl();
        type2.setTagType("doc#myTag2");
        taggedValue2.setType(type2);
        modelElement.addTaggedValue(taggedValue2);

        Map<String, List<String>> res = this.uut.getTagDocumentation(modelElement);

        assertEquals("number of tags", 2, res.size());

        List<String> tagList = res.get("myTag1");
        assertEquals("number of tags", 1, tagList.size());
        assertEquals("tag", "data 1", tagList.get(0));

        tagList = res.get("myTag2");
        assertEquals("number of tags", 1, tagList.size());
        assertEquals("tag", "data 2", tagList.get(0));
    }

    /**
     * <b>Failure test</b> for method getParametersDocumentation(Operation).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  operation = null
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetParametersDocumentationOperationFailure()
        throws Exception {
        Operation operation = null;

        try {
            this.uut.getParametersDocumentation(operation);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method getParametersDocumentation(Operation).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  operation with one parameter
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  the parameter's documentation
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetParametersDocumentationOperationAccuracy()
        throws Exception {
        Operation operation = new OperationImpl();
        Parameter param = new ParameterImpl();
        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue("data");

        TagDefinition type = new TagDefinitionImpl();
        type.setTagType("doc");
        taggedValue.setType(type);
        param.addTaggedValue(taggedValue);
        param.setName("param1");
        operation.addParameter(param);

        Map<String, List<String>> result = this.uut.getParametersDocumentation(operation);

        assertEquals("result size", 1, result.size());

        List<String> list = result.get("param1");

        assertEquals("docs number", 1, list.size());
        assertEquals("data", "data", list.get(0));
    }

    /**
     * <b>Accuracy test</b> for method getStereotypes().<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  the uut's stereotypes
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetStereotypesAccuracy() throws Exception {
        assertEquals("number of stereotypes", 15, this.uut.getStereotypes().size());
    }

    /**
     * <b>Accuracy test</b> for method getDocumentation().<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  the uut's documentation configuration
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetDocumentationAccuracy() throws Exception {
        assertEquals("documentation", "doc", this.uut.getDocumentation());
    }

    /**
     * <b>Accuracy test</b> for method getTagsDocumentation().<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  the uut's dtagsDcumentation configuration
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetTagsDocumentationAccuracy() throws Exception {
        assertEquals("documentation", "doc#", this.uut.getTagsDocumentation());
    }

    /**
     * <b>Accuracy test</b> for method getLog().<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  the uut's dtagsDcumentation configuration
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetLogAccuracy() throws Exception {
        assertNotNull("log", this.uut.getLog());
    }

    /**
     * <b>Accuracy test</b> for method getImports().<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  the uut's imports
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetImportsAccuracy() throws Exception {
        assertNotNull("log", this.uut.getImports());
    }
}
