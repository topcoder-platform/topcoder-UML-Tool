/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import com.topcoder.uml.stubclassgenerator.csharp.CSharpGenerator;
import com.topcoder.uml.stubclassgenerator.java.JavaGenerator;

import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;


/**
 * Unit tests for the class {@link GeneratorFactory}.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestGeneratorFactory extends TestCase {
    /**
     * A name space.
     */
    private static final String NAMESPACE = "stub_class_generator";

    /**
     * A CodeGenerator.
     */
    private CodeGenerator codeGenerator;

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
        this.codeGenerator = new CodeGenerator(false, false, "stub_class_generator");
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
     * <b>Failure test</b> for method getGeneratorInstance(String,
     * CodeGenerator, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = null
     *  codeGenerator = this.codeGenerator
     *  namespace = NAMESPACE
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
    public void testgetGeneratorInstanceStringCodeGeneratorStringFailureNullLanguage()
        throws Exception {
        try {
            GeneratorFactory.getGeneratorInstance(null, this.codeGenerator, NAMESPACE);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method getGeneratorInstance(String,
     * CodeGenerator, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;   &quot;
     *  codeGenerator = this.codeGenerator
     *  namespace = NAMESPACE
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
    public void testgetGeneratorInstanceStringCodeGeneratorStringFailureEmptyLanguage()
        throws Exception {
        try {
            GeneratorFactory.getGeneratorInstance("   ", this.codeGenerator, NAMESPACE);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method getGeneratorInstance(String,
     * CodeGenerator, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  codeGenerator = null
     *  namespace = NAMESPACE
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
    public void testgetGeneratorInstanceStringCodeGeneratorStringFailureNullCodeGenerator()
        throws Exception {
        try {
            GeneratorFactory.getGeneratorInstance("Java", null, NAMESPACE);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method getGeneratorInstance(String,
     * CodeGenerator, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  codeGenerator = this.codeGenerator
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
    public void testgetGeneratorInstanceStringCodeGeneratorStringFailureNullNamespace()
        throws Exception {
        try {
            GeneratorFactory.getGeneratorInstance("Java", this.codeGenerator, null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method getGeneratorInstance(String,
     * CodeGenerator, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  codeGenerator = this.codeGenerator
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
    public void testgetGeneratorInstanceStringCodeGeneratorStringFailureEmptyNamespace()
        throws Exception {
        try {
            GeneratorFactory.getGeneratorInstance("Java", this.codeGenerator, "  ");
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method getGeneratorInstance(String,
     * CodeGenerator, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;not a language&quot;
     *  codeGenerator = this.codeGenerator
     *  namespace = NAMESPACE
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
    public void testgetGeneratorInstanceStringCodeGeneratorStringFailureUnknownLanguage()
        throws Exception {
        try {
            GeneratorFactory.getGeneratorInstance("not a language", this.codeGenerator, NAMESPACE);
            fail("CodeGenerationException expected");
        } catch (CodeGenerationException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method getGeneratorInstance(String,
     * CodeGenerator, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  codeGenerator = this.codeGenerator
     *  namespace = NAMESPACE
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  a {@link JavaGenerator}
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetGeneratorInstanceStringCodeGeneratorStringAccuracyJava()
        throws Exception {
        assertTrue("Not a java generator",
            GeneratorFactory.getGeneratorInstance("Java", this.codeGenerator, NAMESPACE) instanceof JavaGenerator);
    }

    /**
     * <b>Accuracy test</b> for method getGeneratorInstance(String,
     * CodeGenerator, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  language = &quot;c#&quot;
     *  codeGenerator = this.codeGenerator
     *  namespace = NAMESPACE
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  a {@link CSharpGenerator}
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetGeneratorInstanceStringCodeGeneratorStringAccuracyCSharp()
        throws Exception {
        assertTrue("Not a c# generator",
            GeneratorFactory.getGeneratorInstance("C#", this.codeGenerator, NAMESPACE) instanceof CSharpGenerator);
    }

    /**
     * <b>Failure test</b> for method getExtension(String, CodeGenerator).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = null
     *  codeGenerator = this.codeGenerator
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
    public void testgetExtensionStringCodeGeneratorFailureNullLanguage()
        throws Exception {
        try {
            GeneratorFactory.getExtension(null, this.codeGenerator);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method getExtension(String, CodeGenerator).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;  &quot;
     *  codeGenerator = this.codeGenerator
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
    public void testgetExtensionStringCodeGeneratorFailureEmptyLanguage()
        throws Exception {
        try {
            GeneratorFactory.getExtension("   ", this.codeGenerator);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method getExtension(String, CodeGenerator).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  codeGenerator = null
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
    public void testgetExtensionStringCodeGeneratorFailureNullCodeGenerator()
        throws Exception {
        try {
            GeneratorFactory.getExtension("Java", null);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method getExtension(String, CodeGenerator).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  language = &quot;not a language&quot;
     *  codeGenerator = null
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
    public void testgetExtensionStringCodeGeneratorFailureUnknownLanguage()
        throws Exception {
        try {
            GeneratorFactory.getExtension("not a language", this.codeGenerator);
            fail("CodeGenerationException expected");
        } catch (CodeGenerationException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method getExtension(String, CodeGenerator).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  language = &quot;Java&quot;
     *  codeGenerator = this.codeGenerator
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  java
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetExtensionStringCodeGeneratorAccuracyJava()
        throws Exception {
        assertEquals("java", "java", GeneratorFactory.getExtension("Java", this.codeGenerator));
    }

    /**
     * <b>Accuracy test</b> for method getExtension(String, CodeGenerator).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  language = &quot;C#&quot;
     *  codeGenerator = this.codeGenerator
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  cs
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testgetExtensionStringCodeGeneratorAccuracyCSharp()
        throws Exception {
        assertEquals("C#", "cs", GeneratorFactory.getExtension("C#", this.codeGenerator));
    }
}
