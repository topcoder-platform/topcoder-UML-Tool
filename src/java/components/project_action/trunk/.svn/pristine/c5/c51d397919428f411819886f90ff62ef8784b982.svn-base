/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.stubclassgenerator.CodeGenerator;
import com.topcoder.uml.stubclassgenerator.GeneratorConfigurationException;

/**
 * <p>
 * This is a mock extension of CodeGenerator.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockCodeGenerator extends CodeGenerator {
    
    public MockCodeGenerator() throws GeneratorConfigurationException {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * <p>
     * Represents the language.
     * </p>
     */
    private String language;

    /**
     * <p>
     * Represents the location (path).
     * </p>
     */
    private String location;

    /**
     * <p>
     * Represents a list of Classifier.
     * </p>
     */
    private final List<Classifier> classifiers = new ArrayList<Classifier>();

    /**
     * <p>
     * Represents a list of Package.
     * </p>
     */
    private final List<Package> packages = new ArrayList<Package>();

    /**
     * <p>
     * Mock Stub implementation. Just assigns the values to the class variables for testing.
     * </p>
     * @param language
     *            the language used to generate the code
     * @param location
     *            the location (path) to store the generated code files
     * @param packages
     *            the packages list.
     * @throws IllegalArgumentException
     *          when the location equals exception, used for exception testing.
     */
    public void generateCode(String language, List<Package> packages, String location) {
        // for checking the exception testing.
        if (location.equals("exception")) {
            throw new IllegalArgumentException();
        }
        this.language = language;
        this.packages.addAll(packages);
        this.location = location;
    }

    /**
     * <p>
     * Mock Stub implementation. Just assigns the values to the class variables for testing.
     * </p>
     * @param language
     *            the language used to generate the code
     * @param location
     *            the location (path) to store the generated code files
     * @param classifiers
     *            the Classifiers list.
     */
    public void generateCode(String language, String location, List<Classifier> classifiers) {
        this.language = language;
        this.location = location;
        this.classifiers.addAll(classifiers);
    }

    /**
     * <p>
     * Mock Stub implementation. Returns the classifiers list.
     * </p>
     *
     * @return the classifiers list.
     */
    public List<Classifier> getclassifiers() {
        return classifiers;
    }

    /**
     * <p>
     * Mock Stub implementation. Returns the location.
     * </p>
     *
     * @return the location.
     */
    public String getlocation() {
        return location;
    }

    /**
     * <p>
     * Mock Stub implementation. Returns the packages list.
     * </p>
     *
     * @return the packages list.
     */
    public List<Package> getpackages() {
        return packages;
    }

    /**
     * <p>
     * Mock Stub implementation. Returns the language.
     * </p>
     *
     * @return the language.
     */
    public String getlanguage() {
        return language;
    }
}
