/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project.accuracytests;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.uml.actions.project.GenerateCodeAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.stubclassgenerator.CodeGenerator;
import com.topcoder.uml.stubclassgenerator.GeneratorConfigurationException;

/**
 * <p>
 * Accuracy test for <code>{@link GenerateCodeAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class GenerateCodeActionAccuracyTests extends BaseTestCase {
    /**
     * <p>
     * Represents the language used in tests.
     * </p>
     */
    private static final String LANGUAGE = "Java";

    /**
     * <p>
     * Represents the location used in tests.
     * </p>
     */
    private static final String LOCATION = "test_files/";

    /**
     * <p>
     * Represents the code generator used in tests.
     * </p>
     */
    private static CodeGenerator CODE_GENERATOR;

    /**
     * <p>
     * Represents the size to create the list.
     * </p>
     */
    private static final int SIZE = 10;

    /**
     * <p>
     * Represents the <code>{@link GenerateCodeAction}</code> instance used in tests.
     * </p>
     */
    private GenerateCodeAction generateCodeAction;

    static
    {
        try {
            CODE_GENERATOR = new CodeGenerator();
        } catch (GeneratorConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link GenerateCodeAction#GenerateCodeAction(String, String, Classifier, CodeGenerator)}</code> class.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_1_Accuracy() throws Exception {
        Classifier classifier = new ClassImpl();
        generateCodeAction = new GenerateCodeAction(LANGUAGE, LOCATION, classifier, CODE_GENERATOR);
        // verify
        assertEquals("language field not set.", LANGUAGE, AccuracyTestHelper.getFieldValue(generateCodeAction,
            "language"));
        assertEquals("location field not set.", LOCATION, AccuracyTestHelper.getFieldValue(generateCodeAction,
            "location"));
        assertSame("codeGenerator field not set.", CODE_GENERATOR, AccuracyTestHelper.getFieldValue(generateCodeAction,
            "codeGenerator"));
        assertListEquals((List) AccuracyTestHelper.getFieldValue(generateCodeAction, "packages"), new ArrayList());
        List<Classifier> classifiers = new ArrayList<Classifier>();
        classifiers.add(classifier);
        assertListEquals((List) AccuracyTestHelper.getFieldValue(generateCodeAction, "classifiers"), classifiers);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link GenerateCodeAction#GenerateCodeAction(String, String, Package, CodeGenerator)}</code> class.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_2_Accuracy() throws Exception {
        Package pack = new PackageImpl();
        generateCodeAction = new GenerateCodeAction(LANGUAGE, LOCATION, pack, CODE_GENERATOR);
        // verify
        assertEquals("language field not set.", LANGUAGE, AccuracyTestHelper.getFieldValue(generateCodeAction,
            "language"));
        assertEquals("location field not set.", LOCATION, AccuracyTestHelper.getFieldValue(generateCodeAction,
            "location"));
        assertSame("codeGenerator field not set.", CODE_GENERATOR, AccuracyTestHelper.getFieldValue(generateCodeAction,
            "codeGenerator"));
        assertListEquals((List) AccuracyTestHelper.getFieldValue(generateCodeAction, "classifiers"), new ArrayList());
        List<Package> packages = new ArrayList<Package>();
        packages.add(pack);
        assertListEquals((List) AccuracyTestHelper.getFieldValue(generateCodeAction, "packages"), packages);
    }

    /**
     * <p>
     * Accuracy test for <code>{@link GenerateCodeAction#GenerateCodeAction(String, String, List, CodeGenerator)}</code>
     * class.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_3_Accuracy() throws Exception {
        List<Classifier> classifiers = new ArrayList<Classifier>();
        for (int i = 0; i < SIZE; i++) {
            classifiers.add(new ClassImpl());
        }
        generateCodeAction = new GenerateCodeAction(LANGUAGE, LOCATION, classifiers, CODE_GENERATOR);
        // verify
        assertEquals("language field not set.", LANGUAGE, AccuracyTestHelper.getFieldValue(generateCodeAction,
            "language"));
        assertEquals("location field not set.", LOCATION, AccuracyTestHelper.getFieldValue(generateCodeAction,
            "location"));
        assertSame("codeGenerator field not set.", CODE_GENERATOR, AccuracyTestHelper.getFieldValue(generateCodeAction,
            "codeGenerator"));
        assertListEquals((List) AccuracyTestHelper.getFieldValue(generateCodeAction, "packages"), new ArrayList());
        assertListEquals((List) AccuracyTestHelper.getFieldValue(generateCodeAction, "classifiers"), classifiers);
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link GenerateCodeAction#GenerateCodeAction(String, String, CodeGenerator, List))}</code> class.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    public void testCtor_4_Accuracy() throws Exception {
        List<Package> packages = new ArrayList<Package>();
        for (int i = 0; i < SIZE; i++) {
            packages.add(new PackageImpl());
        }
        generateCodeAction = new GenerateCodeAction(LANGUAGE, LOCATION, CODE_GENERATOR, packages);
        // verify
        assertEquals("language field not set.", LANGUAGE, AccuracyTestHelper.getFieldValue(generateCodeAction,
            "language"));
        assertEquals("location field not set.", LOCATION, AccuracyTestHelper.getFieldValue(generateCodeAction,
            "location"));
        assertSame("codeGenerator field not set.", CODE_GENERATOR, AccuracyTestHelper.getFieldValue(generateCodeAction,
            "codeGenerator"));
        assertListEquals((List) AccuracyTestHelper.getFieldValue(generateCodeAction, "classifiers"), new ArrayList());
        assertListEquals((List) AccuracyTestHelper.getFieldValue(generateCodeAction, "packages"), packages);
    }

}
