/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.failuretests;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.uml.actions.project.GenerateCodeAction;
import com.topcoder.uml.actions.project.failuretests.mock.MockClassifier;
import com.topcoder.uml.actions.project.failuretests.mock.MockCodeGenerator;
import com.topcoder.uml.actions.project.failuretests.mock.MockPackage;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.stubclassgenerator.CodeGenerator;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>GenerateCodeAction</code> class.
 * </p>
 * 
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GenerateCodeActionFailureTest extends TestCase {
    /**
     * The language used to construct GenerateCodeAction.
     */
    private String language;
    
    /**
     * The location used to construct GenerateCodeAction.
     */
    private String location;
    
    /**
     * The classifier used to construct GenerateCodeAction.
     */
    private Classifier classifier;
    
    /**
     * The codeGenerator used to construct GenerateCodeAction.
     */
    private CodeGenerator codeGenerator;
    
    /**
     * The packageObj used to construct GenerateCodeAction.
     */
    private Package packageObj;
    
    /**
     * Set up for each test.
     * 
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        
        language = "java";
        location = "./test_files/failure/location";
        classifier = new MockClassifier();
        codeGenerator = new MockCodeGenerator();
        packageObj = new MockPackage();
    }
    
    /**
     * Test ctor GenerateCodeAction(String language, String location, Classifier
     * classifier, CodeGenerator codeGenerator),
     * when language is null, IllegalArgumentException is expected.
     */
    public void testCtor1_LanguageIsNull() {
        try {
            new GenerateCodeAction(null, location, classifier, codeGenerator);
            fail("when language is null, IllegalArgumentExceptin is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor GenerateCodeAction(String language, String location, Classifier
     * classifier, CodeGenerator codeGenerator),
     * when language is empty, IllegalArgumentException is expected.
     */
    public void testCtor1_LanguageIsEmpty() {
        try {
            new GenerateCodeAction(" \r\t\n ", location, classifier, codeGenerator);
            fail("when language is empty, IllegalArgumentExceptin is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor GenerateCodeAction(String language, String location, Classifier
     * classifier, CodeGenerator codeGenerator),
     * when location is null, IllegalArgumentException is expected.
     */
    public void testCtor1_LocationIsNull() {
        try {
            new GenerateCodeAction(language, null, classifier, codeGenerator);
            fail("when location is null, IllegalArgumentExceptin is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor GenerateCodeAction(String language, String location, Classifier
     * classifier, CodeGenerator codeGenerator),
     * when location is empty, IllegalArgumentException is expected.
     */
    public void testCtor1_LocationIsEmpty() {
        try {
            new GenerateCodeAction(language, " \r \t \n ", classifier, codeGenerator);
            fail("when location is empty, IllegalArgumentExceptin is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor GenerateCodeAction(String language, String location, Classifier
     * classifier, CodeGenerator codeGenerator),
     * when classifier is null, IllegalArgumentException is expected.
     */
    public void testCtor1_ClassifierIsNull() {
        try {
            new GenerateCodeAction(language, location, (Classifier) null, codeGenerator);
            fail("when classifier is null, IllegalArgumentExceptin is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor GenerateCodeAction(String language, String location, Classifier
     * classifier, CodeGenerator codeGenerator),
     * when codeGenerator is null, IllegalArgumentException is expected.
     */
    public void testCtor1_CodeGeneratorIsNull() {
        try {
            new GenerateCodeAction(language, location, classifier, null);
            fail("when codeGenerator is null, IllegalArgumentExceptin is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test cotr GenerateCodeAction(String language, String location, Package
     * packageObj, CodeGenerator codeGenerator), when language is null,
     * IllegalArgumentException is expected.
     */
    public void testCtor2_LanguageIsNull() {
        try {
            new GenerateCodeAction(null, location, packageObj, codeGenerator);
            fail("when language is null, IllegalArgumentExceptin is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test cotr GenerateCodeAction(String language, String location, Package
     * packageObj, CodeGenerator codeGenerator), when language is empty,
     * IllegalArgumentException is expected.
     */
    public void testCtor2_LanguageIsEmpty() {
        try {
            new GenerateCodeAction(" \r\t\n ", location, packageObj, codeGenerator);
            fail("when language is empty, IllegalArgumentExceptin is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test cotr GenerateCodeAction(String language, String location, Package
     * packageObj, CodeGenerator codeGenerator), when location is null,
     * IllegalArgumentException is expected.
     */
    public void testCtor2_LocationIsNull() {
        try {
            new GenerateCodeAction(language, null, packageObj, codeGenerator);
            fail("when location is null, IllegalArgumentExceptin is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test cotr GenerateCodeAction(String language, String location, Package
     * packageObj, CodeGenerator codeGenerator), when location is empty,
     * IllegalArgumentException is expected.
     */
    public void testCtor2_LocationIsEmpty() {
        try {
            new GenerateCodeAction(language, " \r\t\n ", packageObj, codeGenerator);
            fail("when location is empty, IllegalArgumentExceptin is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test cotr GenerateCodeAction(String language, String location, Package
     * packageObj, CodeGenerator codeGenerator), when packageObj is null,
     * IllegalArgumentException is expected.
     */
    public void testCtor2_PackageObjIsNull() {
        try {
            new GenerateCodeAction(language, location, (Package) null, codeGenerator);
            fail("when packageObj is null, IllegalArgumentExceptin is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test cotr GenerateCodeAction(String language, String location, Package
     * packageObj, CodeGenerator codeGenerator), when codeGenerator is null,
     * IllegalArgumentException is expected.
     */
    public void testCtor2_CodeGeneratorIsNull() {
        try {
            new GenerateCodeAction(language, location, packageObj, null);
            fail("when codeGenerator is null, IllegalArgumentExceptin is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor GenerateCodeAction(String language, String location, List&lt;Classifier&gt;
     * classifiers, CodeGenerator codeGenerator),
     * when language is null, IllegalArgumentException is expected.
     */
    public void testCtor3_LanguageIsNull() {
        List<Classifier> classifiers = new ArrayList<Classifier>();
        classifiers.add(classifier);
        
        try {
            new GenerateCodeAction(null, location, classifiers, codeGenerator);
            fail("when language is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor GenerateCodeAction(String language, String location, List&lt;Classifier&gt;
     * classifiers, CodeGenerator codeGenerator),
     * when language is empty, IllegalArgumentException is expected.
     */
    public void testCtor3_LanguageIsEmpty() {
        List<Classifier> classifiers = new ArrayList<Classifier>();
        classifiers.add(classifier);
        
        try {
            new GenerateCodeAction(" \r\t\n ", location, classifiers, codeGenerator);
            fail("when language is Empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor GenerateCodeAction(String language, String location, List&lt;Classifier&gt;
     * classifiers, CodeGenerator codeGenerator),
     * when location is null, IllegalArgumentException is expected.
     */
    public void testCtor3_LocationIsNull() {
        List<Classifier> classifiers = new ArrayList<Classifier>();
        classifiers.add(classifier);
        
        try {
            new GenerateCodeAction(language, null, classifiers, codeGenerator);
            fail("when location is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor GenerateCodeAction(String language, String location, List&lt;Classifier&gt;
     * classifiers, CodeGenerator codeGenerator),
     * when location is empty, IllegalArgumentException is expected.
     */
    public void testCtor3_LocationIsEmpty() {
        List<Classifier> classifiers = new ArrayList<Classifier>();
        classifiers.add(classifier);
        
        try {
            new GenerateCodeAction(language, " \r\t\n ", classifiers, codeGenerator);
            fail("when location is Empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor GenerateCodeAction(String language, String location, List&lt;Classifier&gt;
     * classifiers, CodeGenerator codeGenerator),
     * when classifiers is null, IllegalArgumentException is expected.
     */
    public void testCtor3_ClassifiersIsNull() {
        try {
            new GenerateCodeAction(language, location, (List<Classifier>) null, codeGenerator);
            fail("when classifiers is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor GenerateCodeAction(String language, String location, List&lt;Classifier&gt;
     * classifiers, CodeGenerator codeGenerator),
     * when classifiers is empty, IllegalArgumentException is expected.
     */
    public void testCtor3_ClassifiersIsEmpty() {
        List<Classifier> classifiers = new ArrayList<Classifier>();
        try {
            new GenerateCodeAction(language, location, classifiers, codeGenerator);
            fail("when classifiers is Empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor GenerateCodeAction(String language, String location, List&lt;Classifier&gt;
     * classifiers, CodeGenerator codeGenerator),
     * when classifiers contains null, IllegalArgumentException is expected.
     */
    public void testCtor3_ClassifiersContainsNull() {
        List<Classifier> classifiers = new ArrayList<Classifier>();
        classifiers.add(null);
        try {
            new GenerateCodeAction(language, location, classifiers, codeGenerator);
            fail("when classifiers contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test ctor GenerateCodeAction(String language, String location, List&lt;Classifier&gt;
     * classifiers, CodeGenerator codeGenerator),
     * when codeGenerator is null, IllegalArgumentException is expected.
     */
    public void testCtor3_CodeGeneratorIsNull() {
        List<Classifier> classifiers = new ArrayList<Classifier>();
        classifiers.add(classifier);
        try {
            new GenerateCodeAction(language, location, classifiers, null);
            fail("when codeGenerator is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test GenerateCodeAction(String language, String location, CodeGenerator
     * codeGenerator, List&lt;Package&gt; packages),
     * when language is null, IllegalArgumentException is expected.
     */
    public void testCtor4_LanguageIsNull() {
        List<Package> packages = new ArrayList<Package>();
        packages.add(packageObj);
        try {
            new GenerateCodeAction(null, location, codeGenerator, packages);
            fail("when language is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test GenerateCodeAction(String language, String location, CodeGenerator
     * codeGenerator, List&lt;Package&gt; packages),
     * when language is empty, IllegalArgumentException is expected.
     */
    public void testCtor4_LanguageIsEmpty() {
        List<Package> packages = new ArrayList<Package>();
        packages.add(packageObj);
        try {
            new GenerateCodeAction(" \r\t\n ", location, codeGenerator, packages);
            fail("when language is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test GenerateCodeAction(String language, String location, CodeGenerator
     * codeGenerator, List&lt;Package&gt; packages),
     * when location is null, IllegalArgumentException is expected.
     */
    public void testCtor4_LocationIsNull() {
        List<Package> packages = new ArrayList<Package>();
        packages.add(packageObj);
        try {
            new GenerateCodeAction(language, null, codeGenerator, packages);
            fail("when location is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test GenerateCodeAction(String language, String location, CodeGenerator
     * codeGenerator, List&lt;Package&gt; packages),
     * when location is empty, IllegalArgumentException is expected.
     */
    public void testCtor4_LocationIsEmpty() {
        List<Package> packages = new ArrayList<Package>();
        packages.add(packageObj);
        try {
            new GenerateCodeAction(language, " \r\t\n ", codeGenerator, packages);
            fail("when location is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test GenerateCodeAction(String language, String location, CodeGenerator
     * codeGenerator, List&lt;Package&gt; packages),
     * when codeGenerator is null, IllegalArgumentException is expected.
     */
    public void testCtor4_CodeGeneratorIsNull() {
        List<Package> packages = new ArrayList<Package>();
        packages.add(packageObj);
        try {
            new GenerateCodeAction(language, location, null, packages);
            fail("when codeGenerator is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test GenerateCodeAction(String language, String location, CodeGenerator
     * codeGenerator, List&lt;Package&gt; packages),
     * when packages is null, IllegalArgumentException is expected.
     */
    public void testCtor4_PackagesIsNull() {
        try {
            new GenerateCodeAction(language, location, codeGenerator, null);
            fail("when packages is null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test GenerateCodeAction(String language, String location, CodeGenerator
     * codeGenerator, List&lt;Package&gt; packages),
     * when packages is empty, IllegalArgumentException is expected.
     */
    public void testCtor4_PackagesIsEmpty() {
        List<Package> packages = new ArrayList<Package>();
        try {
            new GenerateCodeAction(language, location, codeGenerator, packages);
            fail("when packages is empty, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }

    /**
     * Test GenerateCodeAction(String language, String location, CodeGenerator
     * codeGenerator, List&lt;Package&gt; packages),
     * when packages contains null, IllegalArgumentException is expected.
     */
    public void testCtor4_PackagesContainsNull() {
        List<Package> packages = new ArrayList<Package>();
        packages.add(null);
        try {
            new GenerateCodeAction(language, location, codeGenerator, packages);
            fail("when packages contains null, IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok
        }
    }
    
    /**
     * Test execute(),
     * failed to generate code, ActionExecutionException is expected.
     */
    public void testExecute_Failed1() {
        List<Package> packages = new ArrayList<Package>();
        packages.add(packageObj);
        try {
            new GenerateCodeAction(language, location, codeGenerator, packages).execute();
            fail("failed to generate code, ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            // ok
        }
    }
    
    /**
     * Test execute(),
     * failed to generate code, ActionExecutionException is expected.
     */
    public void testExecute_Failed2() {
        try {
            new GenerateCodeAction(language, location, classifier, codeGenerator).execute();
            fail("failed to generate code, ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            // ok
        }
    }
}