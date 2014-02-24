/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * /*
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for GenerateCodeAction class.
 * The accuracy test cases gives all valid inputs to the methods/constructors and checks for
 * inconsistencies The failure test cases gives all invalid inputs to the methods/constructors and
 * checks for expected exceptions /*
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GenerateCodeActionUnitTest extends TestCase {
    /**
     * <p>
     * List of viewPorts to be used.
     * </p>
     */
    private List<Package> packages;

    /**
     * <p>
     * List of classifiers to be used.
     * </p>
     */
    private List<Classifier> classifiers;

    /**
     * <p>
     * codeGenerator to be used.
     * </p>
     */
    private MockCodeGenerator codeGenerator;

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        packages = new ArrayList<Package>();
        classifiers = new ArrayList<Classifier>();
        // load the initial settings
        packages.add(new MockPackage());
        packages.add(new MockPackage());
        classifiers.add(new MockClassifier());
        classifiers.add(new MockClassifier());
        codeGenerator = new MockCodeGenerator();
    }

    /**
     * <p>
     * Tears down the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        packages = null;
        classifiers = null;
        codeGenerator = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(GenerateCodeActionUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, Classifier classifier,
     * CodeGenerator codeGenerator)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_GenerateCodeAction() throws Exception {
        assertNotNull("GenerateCodeAction creation failed", new GenerateCodeAction("lang", "loc", classifiers.get(0),
                codeGenerator));
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, Classifier classifier,
     * CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : null Value
     *                String location : Valid Value
     *                Classifier classifier : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction01() throws Exception {
        try {
            new GenerateCodeAction(null, "loc", classifiers.get(0), codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location,
     * Classifier classifier, CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Empty Value
     *                String location : Valid Value
     *                Classifier classifier : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction02() throws Exception {
        try {
            new GenerateCodeAction("", "loc", classifiers.get(0), codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location,
     * Classifier classifier, CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Empty spaces Value
     *                String location : Valid Value
     *                Classifier classifier : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction03() throws Exception {
        try {
            new GenerateCodeAction("   ", "loc", classifiers.get(0), codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location,
     * Classifier classifier, CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : null Value
     *                Classifier classifier : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction04() throws Exception {
        try {
            new GenerateCodeAction("lang", null, classifiers.get(0), codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location,
     * Classifier classifier, CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Empty Value
     *                Classifier classifier : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction05() throws Exception {
        try {
            new GenerateCodeAction("lang", "", classifiers.get(0), codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location,
     * Classifier classifier, CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Empty spaces Value
     *                Classifier classifier : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction06() throws Exception {
        try {
            new GenerateCodeAction("lang", "  ", classifiers.get(0), codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location,
     * Classifier classifier, CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Valid Value
     *                Classifier classifier : null Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction07() throws Exception {
        try {
            new GenerateCodeAction("lang", "loc", (Classifier) null, codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location,
     * Classifier classifier, CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Valid Value
     *                Classifier classifier : Valid Value
     *                CodeGenerator codeGenerator : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction08() throws Exception {
        try {
            new GenerateCodeAction("lang", "loc", classifiers.get(0), null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Accuracy test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, Package packageObj,
     * CodeGenerator codeGenerator)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_GenerateCodeAction1() throws Exception {
        assertNotNull("GenerateCodeAction creation failed", new GenerateCodeAction("lan", "loc", packages.get(0),
                codeGenerator));
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, Package packageObj,
     * CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : null Value
     *                String location : Valid Value
     *                Package packageObj : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction10() throws Exception {
        try {
            new GenerateCodeAction(null, "loc", packages.get(0), codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, Package packageObj,
     * CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Empty Value
     *                String location : Valid Value
     *                Package packageObj : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction11() throws Exception {
        try {
            new GenerateCodeAction("", "loc", packages.get(0), codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, Package packageObj,
     * CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Empty spaces Value
     *                String location : Valid Value
     *                Package packageObj : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction12() throws Exception {
        try {
            new GenerateCodeAction("  ", "loc", packages.get(0), codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, Package packageObj,
     * CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : null Value
     *                Package packageObj : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction13() throws Exception {
        try {
            new GenerateCodeAction("lan", null, packages.get(0), codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, Package packageObj,
     * CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Empty Value
     *                Package packageObj : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction14() throws Exception {
        try {
            new GenerateCodeAction("lan", "", packages.get(0), codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, Package packageObj,
     * CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Empty spaces Value
     *                Package packageObj : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction15() throws Exception {
        try {
            new GenerateCodeAction("lan", "  ", packages.get(0), codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, Package packageObj,
     * CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Valid Value
     *                Package packageObj : null Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction16() throws Exception {
        try {
            new GenerateCodeAction("lan", "loc", (Package) null, codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, Package packageObj,
     * CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Valid Value
     *                Package packageObj : Valid Value
     *                CodeGenerator codeGenerator : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction17() throws Exception {
        try {
            new GenerateCodeAction("lan", "loc", packages.get(0), null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Accuracy test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, List<Classifier> classifiers,
     *  CodeGenerator codeGenerator)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_GenerateCodeAction30() throws Exception {
        assertNotNull("GenerateCodeAction creation failed", new GenerateCodeAction("lang", "loc", classifiers,
                codeGenerator));
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, List<Classifier> classifiers,
     *  CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : null Value
     *                String location : Valid Value
     *                List &lt; Classifier &gt; classifiers : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction20() throws Exception {
        try {
            new GenerateCodeAction(null, "loc", classifiers, codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, List<Classifier> classifiers,
     *  CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Empty Value
     *                String location : Valid Value
     *                List &lt; Classifier &gt; classifiers : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction21() throws Exception {
        try {
            new GenerateCodeAction("", "loc", classifiers, codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, List<Classifier> classifiers,
     *  CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Empty Spaces Value
     *                String location : Valid Value
     *                List &lt; Classifier &gt; classifiers : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction22() throws Exception {
        try {
            new GenerateCodeAction("  ", "loc", classifiers, codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, List<Classifier> classifiers,
     *  CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : null Value
     *                List &lt; Classifier &gt; classifiers : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction23() throws Exception {
        try {
            new GenerateCodeAction("lang", null, classifiers, codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, List<Classifier> classifiers,
     *  CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Empty Value
     *                List &lt; Classifier &gt; classifiers : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction24() throws Exception {
        try {
            new GenerateCodeAction("lang", "", classifiers, codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, List<Classifier> classifiers,
     *  CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Empty spaces Value
     *                List &lt; Classifier &gt; classifiers : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction25() throws Exception {
        try {
            new GenerateCodeAction("lang", "  ", classifiers, codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, List<Classifier> classifiers,
     *  CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Valid Value
     *                List &lt; Classifier &gt; classifiers : null Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction26() throws Exception {
        try {
            new GenerateCodeAction("lang", "loc", (List<Classifier>) null, codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, List<Classifier> classifiers,
     *  CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Valid Value
     *                List &lt; Classifier &gt; classifiers : Contains null Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction27() throws Exception {
        try {
            classifiers.add(null);
            new GenerateCodeAction("lang", "loc", classifiers, codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, List<Classifier> classifiers,
     *  CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Valid Value
     *                List &lt; Classifier &gt; classifiers : Empty list Value
     *                CodeGenerator codeGenerator : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction28() throws Exception {
        try {
            classifiers.clear();
            new GenerateCodeAction("lang", "loc", classifiers, codeGenerator);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, List<Classifier> classifiers,
     *  CodeGenerator codeGenerator)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Valid Value
     *                List &lt; Classifier &gt; classifiers : Valid Value
     *                CodeGenerator codeGenerator : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction29() throws Exception {
        try {
            new GenerateCodeAction("lang", "loc", classifiers, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Accuracy test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, CodeGenerator codeGenerator,
     * List < Package > packages)</code>
     * constructor.
     * </p>
     * <p>
     * Creates a new instance checks for the instance creation.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_GenerateCodeAction2() throws Exception {
        assertNotNull("GenerateCodeAction creation failed", new GenerateCodeAction("lang", "loc", codeGenerator,
                packages));
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, CodeGenerator codeGenerator,
     * List < Package > packages)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : null Value
     *                String location : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     *                List &lt; Package &gt; packages : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction30() throws Exception {
        try {
            new GenerateCodeAction(null, "loc", codeGenerator, packages);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, CodeGenerator codeGenerator,
     * List < Package > packages)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Empty Value
     *                String location : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     *                List &lt; Package &gt; packages : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction31() throws Exception {
        try {
            new GenerateCodeAction("", "loc", codeGenerator, packages);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, CodeGenerator codeGenerator,
     * List < Package > packages)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Empty spaces Value
     *                String location : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     *                List &lt; Package &gt; packages : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction32() throws Exception {
        try {
            new GenerateCodeAction("  ", "loc", codeGenerator, packages);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, CodeGenerator codeGenerator,
     * List < Package > packages)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : null Value
     *                CodeGenerator codeGenerator : Valid Value
     *                List &lt; Package &gt; packages : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction33() throws Exception {
        try {
            new GenerateCodeAction("lang", null, codeGenerator, packages);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, CodeGenerator codeGenerator,
     * List < Package > packages)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Empty Value
     *                CodeGenerator codeGenerator : Valid Value
     *                List &lt; Package &gt; packages : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction34() throws Exception {
        try {
            new GenerateCodeAction("lang", "", codeGenerator, packages);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, CodeGenerator codeGenerator,
     * List < Package > packages)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Empty spaces Value
     *                CodeGenerator codeGenerator : Valid Value
     *                List &lt; Package &gt; packages : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction35() throws Exception {
        try {
            new GenerateCodeAction("lang", "  ", codeGenerator, packages);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, CodeGenerator codeGenerator,
     * List < Package > packages)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Valid Value
     *                CodeGenerator codeGenerator : null Value
     *                List &lt; Package &gt; packages : Valid Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction36() throws Exception {
        try {
            new GenerateCodeAction("lang", "loc", null, packages);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, CodeGenerator codeGenerator,
     * List < Package > packages)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     *                List &lt; Package &gt; packages : null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction37() throws Exception {
        try {
            new GenerateCodeAction("lang", "loc", codeGenerator, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, CodeGenerator codeGenerator,
     * List < Package > packages)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     *                List &lt; Package &gt; packages : Contains null Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction38() throws Exception {
        try {
            packages.add(null);
            new GenerateCodeAction("lang", "loc", codeGenerator, packages);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, CodeGenerator codeGenerator,
     * List < Package > packages)</code>
     * constructor. For the following inputs:
     * </p>
     *
     * <pre>
     *           Input
     *                String language : Valid Value
     *                String location : Valid Value
     *                CodeGenerator codeGenerator : Valid Value
     *                List &lt; Package &gt; packages : Empty list Value
     * </pre>
     *
     * <p>
     * Expected IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_GenerateCodeAction39() throws Exception {
        try {
            packages.clear();
            new GenerateCodeAction("lang", "loc", codeGenerator, packages);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // as expected
        }
    }

    /**
     * <p>
     * Accuracy test of <code>GenerateCodeAction.execute()</code> method. detail
     * </p>
     * <p>
     * Calling the execute using the following constructor and checking whether the values are
     * passed correctly.
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, Classifier classifier,
     * CodeGenerator codeGenerator)</code>
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute() throws Exception {
        new GenerateCodeAction("lang", "loc", classifiers.get(0), codeGenerator).execute();
        // check whether all the values are passed correctly.
        assertEquals("execute failed", classifiers.get(0), codeGenerator.getclassifiers().get(0));
        assertEquals("execute failed", "loc", codeGenerator.getlocation());
        assertEquals("execute failed", "lang", codeGenerator.getlanguage());
    }

    /**
     * <p>
     * Accuracy test of <code>GenerateCodeAction.execute()</code> method. detail
     * </p>
     * <p>
     * Calling the execute using the following constructor and checking whether the values are
     * passed correctly.
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, Package packageObj,
     * CodeGenerator codeGenerator)</code>
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute1() throws Exception {
        new GenerateCodeAction("lang", "loc", packages.get(0), codeGenerator).execute();
        // check whether all the values are passed correctly.
        assertEquals("execute failed", packages.get(0), codeGenerator.getpackages().get(0));
        assertEquals("execute failed", "loc", codeGenerator.getlocation());
        assertEquals("execute failed", "lang", codeGenerator.getlanguage());
    }
    /**
     * <p>
     * Accuracy test of <code>GenerateCodeAction.execute()</code> method. detail
     * </p>
     * <p>
     * Calling the execute using the following constructor and checking whether the values are
     * passed correctly.
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, List<Classifier> classifiers,
     * CodeGenerator codeGenerator)</code>
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute2() throws Exception {
        new GenerateCodeAction("lang", "loc", classifiers, codeGenerator).execute();
        // check whether all the values are passed correctly.
        assertEquals("execute failed", classifiers, codeGenerator.getclassifiers());
        assertEquals("execute failed", "loc", codeGenerator.getlocation());
        assertEquals("execute failed", "lang", codeGenerator.getlanguage());
    }
    /**
     * <p>
     * Accuracy test of <code>GenerateCodeAction.execute()</code> method. detail
     * </p>
     * <p>
     * Calling the execute using the following constructor and checking whether the values are
     * passed correctly.
     * <code>GenerateCodeAction.GenerateCodeAction(String language, String location, CodeGenerator codeGenerator,
     * List<Package> packages)</code>
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_execute3() throws Exception {
        new GenerateCodeAction("lang", "loc", codeGenerator, packages).execute();
        // check whether all the values are passed correctly.
        assertEquals("execute failed", packages, codeGenerator.getpackages());
        assertEquals("execute failed", "loc", codeGenerator.getlocation());
        assertEquals("execute failed", "lang", codeGenerator.getlanguage());
    }

    /**
     * <p>
     * Failure test of <code>GenerateCodeAction.execute()</code> method. For the following inputs:
     * </p>
     * <p>
     * Expected ActionExecutionException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_execute() throws Exception {
        try {
            new GenerateCodeAction("lang", "exception", codeGenerator, packages).execute();
            fail("ActionExecutionException Expected.");
        } catch (ActionExecutionException e) {
            // As Expected
        }
    }
}
