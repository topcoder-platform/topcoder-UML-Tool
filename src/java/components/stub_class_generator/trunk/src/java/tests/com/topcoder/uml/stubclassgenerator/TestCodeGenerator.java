/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

import com.topcoder.util.config.ConfigManager;

import java.io.File;

import java.util.ArrayList;
import java.util.List;


/**
 * Unit tests for the class {@link CodeGenerator}.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestCodeGenerator extends AbstractGeneratorTestCase {
    /**
     * Name space.
     */
    private static final String NAMESPACE = "stub_class_generator";

    /**
     * The unit under test.
     */
    private CodeGenerator uut;

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
        this.uut = new CodeGenerator(false, false, NAMESPACE);
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
     * <b>Failure test</b> for method CodeGenerator(boolean, boolean, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  emptyLocation = true
     *  createEmptyPackage = true
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
    public void testCodeGeneratorBooleanBooleanStringFailureNullNameSpace()
        throws Exception {
        try {
            new CodeGenerator(true, true, null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method CodeGenerator(boolean, boolean, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  emptyLocation = true
     *  createEmptyPackage = true
     *  namespace = &quot;   &quot;
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
    public void testCodeGeneratorBooleanBooleanStringFailureEmptyNamespace()
        throws Exception {
        try {
            new CodeGenerator(true, true, "      ");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCode(String, String, Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = null
     *  location = &quot;some loc&quot;
     *  classifier = new ClassImpl()
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
    public void testgenerateCodeStringStringClassifierFailureNullLang()
        throws Exception {
        String language = null;
        String location = "some loc";
        Classifier classifier = new ClassImpl();

        try {
            this.uut.generateCode(language, location, classifier);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCode(String, String, Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;  &quot;
     *  location = &quot;some loc&quot;
     *  classifier = new ClassImpl()
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
    public void testgenerateCodeStringStringClassifierFailureEmptyLang()
        throws Exception {
        String language = "  ";
        String location = "some loc";
        Classifier classifier = new ClassImpl();

        try {
            this.uut.generateCode(language, location, classifier);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCode(String, String, Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java
     *  location = null
     *  classifier = new ClassImpl()
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
    public void testgenerateCodeStringStringClassifierFailureNullLocation()
        throws Exception {
        String language = "Java";
        String location = null;
        Classifier classifier = new ClassImpl();

        try {
            this.uut.generateCode(language, location, classifier);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCode(String, String, Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java
     *  location = &quot;  &quot;
     *  classifier = new ClassImpl()
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
    public void testgenerateCodeStringStringClassifierFailureEmptyLocation()
        throws Exception {
        String language = "Java";
        String location = "  ";
        Classifier classifier = new ClassImpl();

        try {
            this.uut.generateCode(language, location, classifier);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCode(String, String, Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java
     *  location = &quot;some loc&quot;
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
    public void testgenerateCodeStringStringClassifierFailureNullClassifier()
        throws Exception {
        String language = "Java";
        String location = "some loc";
        Classifier classifier = null;

        try {
            this.uut.generateCode(language, location, classifier);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method generateCode(String, String,
     * Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = temporary directory
     *  classifier = new ClassImpl()
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgenerateCodeStringStringClassifierAccuracyWithPackage()
        throws Exception {
        String language = "Java";
        File tmp = TestHelper.createTempDir();
        File f = TestHelper.createFileInDir(tmp, "some file");
        String location = tmp.getAbsolutePath();
        Classifier classifier = this.createClass("Foo", "com.topcoder");

        assertTrue("file should exist", f.exists());

        this.uut = new CodeGenerator(true, true, NAMESPACE);
        this.uut.generateCode(language, location, classifier);

        File classFile = new File(tmp, "com/topcoder/Foo.java");

        assertTrue("no class file", classFile.exists());
        assertFalse("file should not exist", f.exists());

        classFile.delete();
        classFile.getParentFile().delete();
        classFile.getParentFile().getParentFile().delete();
    }

    /**
     * <b>Accuracy test</b> for method generateCode(String, String,
     * Classifier).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = temporary directory
     *  classifier = new ClassImpl()
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgenerateCodeStringStringClassifierAccuracyWithoutPackage()
        throws Exception {
        String language = "Java";
        File tmp = TestHelper.createTempDir();
        File f = TestHelper.createFileInDir(tmp, "some file");
        String location = tmp.getAbsolutePath();
        Classifier classifier = this.createClass("Foo", "");

        assertTrue("file should exist", f.exists());

        this.uut = new CodeGenerator(false, true, NAMESPACE);
        this.uut.generateCode(language, location, classifier);

        File classFile = new File(tmp, "Foo.java");

        assertTrue("no class file", classFile.exists());
        assertTrue("file should exist", f.exists());

        classFile.delete();
        f.delete();
    }

    /**
     * <b>Failure test</b> for method generateCodeForClassifiers(String,
     * String, List_Classifier_).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = null
     *  location = &quot;tmp&quot;
     *  classifiers = new ArrayList
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
    public void testgenerateCodeForClassifiersStringStringList_Classifier_FailureNullLanguage()
        throws Exception {
        String language = null;
        String location = "tmp";
        List<Classifier> classifiers = new ArrayList<Classifier>();

        try {
            this.uut.generateCodeForClassifiers(language, location, classifiers);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCodeForClassifiers(String,
     * String, List_Classifier_).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;  &quot;
     *  location = &quot;tmp&quot;
     *  classifiers = new ArrayList&lt;Classifier&gt;
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
    public void testgenerateCodeForClassifiersStringStringList_Classifier_FailureEmptyLanguage()
        throws Exception {
        String language = "  ";
        String location = "tmp";
        List<Classifier> classifiers = new ArrayList<Classifier>();

        try {
            this.uut.generateCodeForClassifiers(language, location, classifiers);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCodeForClassifiers(String,
     * String, List_Classifier_).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = null
     *  classifiers = new ArrayList&lt;Classifier&gt;
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
    public void testgenerateCodeForClassifiersStringStringList_Classifier_FailureNullLocation()
        throws Exception {
        String language = "Java";
        String location = null;
        List<Classifier> classifiers = new ArrayList<Classifier>();

        try {
            this.uut.generateCodeForClassifiers(language, location, classifiers);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCodeForClassifiers(String,
     * String, List_Classifier_).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = &quot;   &quot;
     *  classifiers = new ArrayList&lt;Classifier&gt;
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
    public void testgenerateCodeForClassifiersStringStringList_Classifier_FailureEmptyLocation()
        throws Exception {
        String language = "Java";
        String location = "   ";
        List<Classifier> classifiers = new ArrayList<Classifier>();

        try {
            this.uut.generateCodeForClassifiers(language, location, classifiers);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCodeForClassifiers(String,
     * String, List_Classifier_).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = &quot;tmp&quot;
     *  classifiers = null
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
    public void testgenerateCodeForClassifiersStringStringList_Classifier_FailureNullClassifiers()
        throws Exception {
        String language = "Java";
        String location = "tmp";
        List<Classifier> classifiers = null;

        try {
            this.uut.generateCodeForClassifiers(language, location, classifiers);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCodeForClassifiers(String,
     * String, List_Classifier_).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = &quot;tmp&quot;
     *  classifiers = list with null
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
    public void testgenerateCodeForClassifiersStringStringList_Classifier_FailureClassifiersWithNull()
        throws Exception {
        String language = "Java";
        String location = "tmp";
        List<Classifier> classifiers = new ArrayList<Classifier>();
        classifiers.add(null);

        try {
            this.uut.generateCodeForClassifiers(language, location, classifiers);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCodeForClassifiers(String,
     * String, List_Classifier_).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = path to a file
     *  classifiers = list
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * CodeGenerationException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgenerateCodeForClassifiersStringStringList_Classifier_FailureLocationIsDir()
        throws Exception {
        String language = "Java";
        File d = TestHelper.createTempDir();
        File loc = TestHelper.createFileInDir(d, "locationDir");
        List<Classifier> classifiers = new ArrayList<Classifier>();
        classifiers.add(this.createClass("Foo", ""));

        try {
            this.uut.generateCodeForClassifiers(language, loc.getAbsolutePath(), classifiers);
            fail("CodeGenerationException expected");
        } catch (CodeGenerationException e) {
            // OK
        }

        loc.delete();
    }

    /**
     * <b>Failure test</b> for method generateCodeForClassifiers(String,
     * String, List_Classifier_).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = path to a file
     *  classifiers = list
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * CodeGenerationException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgenerateCodeForClassifiersStringStringList_Classifier_FailureNotEmptied()
        throws Exception {
        String language = "Java";
        File d = TestHelper.createTempDir();
        File loc = TestHelper.createFileInDir(d, "locationDir");
        List<Classifier> classifiers = new ArrayList<Classifier>();

        this.uut = new CodeGenerator(true, true, NAMESPACE);

        try {
            this.uut.generateCodeForClassifiers(language, loc.getAbsolutePath(), classifiers);
            fail("CodeGenerationException expected");
        } catch (CodeGenerationException e) {
            // OK
        }

        loc.delete();
    }

    /**
     * <b>Failure test</b> for method generateCodeForClassifiers(String,
     * String, List_Classifier_).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = path to a file
     *  classifiers = list with a class without name
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * CodeGenerationException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgenerateCodeForClassifiersStringStringList_Classifier_FailureMissingClassName()
        throws Exception {
        String language = "Java";
        File d = TestHelper.createTempDir();
        List<Classifier> classifiers = new ArrayList<Classifier>();
        classifiers.add(this.createClass("", "")); // no class name!
        this.uut = new CodeGenerator(true, true, NAMESPACE);

        try {
            this.uut.generateCodeForClassifiers(language, d.getAbsolutePath(), classifiers);
            fail("CodeGenerationException expected");
        } catch (CodeGenerationException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCode(String, String, Package).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = null
     *  location = &quot;tmp&quot;
     *  pack = new PackageImpl()
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
    public void testgenerateCodeStringStringPackageFailureNullLanguage()
        throws Exception {
        String language = null;
        String location = "tmp";
        Package pack = new PackageImpl();

        try {
            this.uut.generateCode(language, location, pack);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCode(String, String, Package).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;  &quot;
     *  location = &quot;tmp&quot;
     *  pack = new PackageImpl()
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
    public void testgenerateCodeStringStringPackageFailureEmptyLanguage()
        throws Exception {
        String language = "  ";
        String location = "tmp";
        Package pack = new PackageImpl();

        try {
            this.uut.generateCode(language, location, pack);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCode(String, String, Package).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = null
     *  pack = new PackageImpl()
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
    public void testgenerateCodeStringStringPackageFailureNullLocation()
        throws Exception {
        String language = "Java";
        String location = null;
        Package pack = new PackageImpl();

        try {
            this.uut.generateCode(language, location, pack);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCode(String, String, Package).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = &quot;   &quot;
     *  pack = new PackageImpl()
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
    public void testgenerateCodeStringStringPackageFailureEmptyLocation()
        throws Exception {
        String language = "Java";
        String location = "   ";
        Package pack = new PackageImpl();

        try {
            this.uut.generateCode(language, location, pack);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCode(String, String, Package).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = &quot;tmp&quot;
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
    public void testgenerateCodeStringStringPackageFailureNullPackage()
        throws Exception {
        String language = "Java";
        String location = "tmp";
        Package pack = null;

        try {
            this.uut.generateCode(language, location, pack);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method generateCode(String, String, Package).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location =  a temporary directory
     *  pack = package with no classes
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgenerateCodeStringStringPackageAccuracyDirsNotCreated()
        throws Exception {
        String language = "Java";
        Model model = new ModelImpl();
        Package pack = this.createPackage("com.topcoder", model);
        pack = (Package) pack.getNamespace();

        assertEquals("wrong package", "com", pack.getName());

        File d = TestHelper.createTempDir();

        this.uut.generateCode(language, d.getAbsolutePath(), pack);

        assertTrue("directories were created", d.list().length == 0);
    }

    /**
     * <b>Accuracy test</b> for method generateCode(String, String, Package).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location =  a temporary directory
     *  pack = package with no classes
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgenerateCodeStringStringPackageAccuracyDirsCreated()
        throws Exception {
        String language = "Java";
        Model model = new ModelImpl();
        Package pack = this.createPackage("com.topcoder", model);
        pack = (Package) pack.getNamespace();

        assertEquals("wrong package", "com", pack.getName());

        File d = TestHelper.createTempDir();

        this.uut = new CodeGenerator(true, true, NAMESPACE);
        this.uut.generateCode(language, d.getAbsolutePath(), pack);

        File com = new File(d, "com");
        File tc = new File(com, "topcoder");

        assertTrue("topcoder not created", tc.isDirectory());
        assertTrue("com not created", com.isDirectory());

        tc.delete();
        com.delete();
    }

    /**
     * <b>Accuracy test</b> for method generateCode(String, String, Package).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location =  a temporary directory
     *  pack = package with two classes
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgenerateCodeStringStringPackageAccuracyD()
        throws Exception {
        String language = "Java";
        Model model = new ModelImpl();
        Package pack = this.createPackage("com.topcoder", model);
        Classifier class1 = this.createClass("Class1", "");
        Classifier class2 = this.createClass("Class2", "");

        pack.addOwnedElement(class1);
        pack.addOwnedElement(class2);
        class1.setNamespace(pack);
        class2.setNamespace(pack);

        pack = (Package) pack.getNamespace();
        assertEquals("wrong package", "com", pack.getName());

        File d = TestHelper.createTempDir();

        this.uut.generateCode(language, d.getAbsolutePath(), pack);

        File com = new File(d, "com");
        File tc = new File(com, "topcoder");
        File c1 = new File(tc, "Class1.java");
        File c2 = new File(tc, "Class2.java");

        assertTrue("topcoder not created", tc.isDirectory());
        assertTrue("com not created", com.isDirectory());
        assertTrue("class 1", c1.exists());
        assertTrue("class 2", c2.exists());

        c1.delete();
        c2.delete();
        tc.delete();
        com.delete();
    }

    /**
     * <b>Failure test</b> for method generateCodeForPackages(String, String,
     * List_pack).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = null
     *  location = &quot;tmp&quot;
     *  packages = new ArrayList&lt;Package&gt;()
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
    public void testgenerateCodeForPackagesStringStringList_packFailureNullLanguage()
        throws Exception {
        String language = null;
        String location = "tmp";
        List<Package> packages = new ArrayList<Package>();

        try {
            this.uut.generateCodeForPackages(language, location, packages);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCodeForPackages(String, String,
     * List_pack).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = null
     *  packages = new ArrayList&lt;Package&gt;()
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
    public void testgenerateCodeForPackagesStringStringList_packFailureNullLocation()
        throws Exception {
        String language = "Java";
        String location = null;
        List<Package> packages = new ArrayList<Package>();

        try {
            this.uut.generateCodeForPackages(language, location, packages);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCodeForPackages(String, String,
     * List_pack).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = &quot;tmp&quot;
     *  packages = null
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
    public void testgenerateCodeForPackagesStringStringList_packFailureNullPackages()
        throws Exception {
        String language = "Java";
        String location = "tmp";
        List<Package> packages = null;

        try {
            this.uut.generateCodeForPackages(language, location, packages);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method generateCodeForPackages(String, String,
     * List_pack).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  location = &quot;tmp&quot;
     *  packages = list with null
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
    public void testgenerateCodeForPackagesStringStringList_packFailureListWithNull()
        throws Exception {
        String language = "Java";
        String location = "tmp";
        List<Package> packages = new ArrayList<Package>();
        packages.add(null);

        try {
            this.uut.generateCodeForPackages(language, location, packages);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method getLanguageJava().<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  Java
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetLanguageJavaAccuracy() throws Exception {
        assertEquals("java", "Java", this.uut.getLanguageJava());
    }

    /**
     * <b>Accuracy test</b> for method getLanguageCSharp().<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  Java
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetLanguageCSharpAccuracy() throws Exception {
        assertEquals("C#", "C#", this.uut.getLanguageCSharp());
    }
}
