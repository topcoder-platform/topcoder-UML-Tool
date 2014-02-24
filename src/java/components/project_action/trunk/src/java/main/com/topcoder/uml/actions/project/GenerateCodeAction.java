/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.stubclassgenerator.CodeGenerator;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * <code>GenerateCodeAction</code> generates code for the given packages or classifiers. It uses the Stub
 * Class Generator component to perform the actual logic.
 * </p>
 * <p>
 * <b>Thread-safety: </b>This class is immutable, and its thread-safety depends on the Stub Class Generator
 * component.
 * </p>
 *
 * @author standlove, TCSDEVELOPER
 * @version 1.0
 */
public class GenerateCodeAction implements TransientAction {

    /**
     * <p>
     * Represents the language used to generate the code in the execute method. It will be non-null, non-empty
     * string.
     * </p>
     */
    private final String language;

    /**
     * <p>
     * Represents the location (path) to store the generated code files in the execute method. It will be
     * non-null, non-empty string.
     * </p>
     */
    private final String location;

    /**
     * <p>
     * Represents a list of <code>Classifier</code> object used to specify the classes to generate in
     * execute method. It could be empty if it is not used.
     * </p>
     */
    private final List<Classifier> classifiers = new ArrayList<Classifier>();

    /**
     * <p>
     * Represents a list of <code>Package</code> object used to specify the classes to generate in execute
     * method. It could be empty if it is not used.
     * </p>
     */
    private final List<Package> packages = new ArrayList<Package>();

    /**
     * <p>
     * Represents the <code>CodeGenerator</code> object used to generate the code in the execute method. It will be
     * non-null.
     * </p>
     */
    private final CodeGenerator codeGenerator;

    /**
     * <p>
     * Constructs this instance with the project language, location, classifier and the code generator
     * instance.
     * </p>
     *
     * @param language
     *            the language used to generate the code
     * @param location
     *            the location (path) to store the generated code files
     * @param classifier
     *            the Classifier object.
     * @param codeGenerator
     *            the CodeGenerator object.
     * @throws IllegalArgumentException
     *             if any argument is null, or language or location is empty string.
     */
    public GenerateCodeAction(String language, String location, Classifier classifier, CodeGenerator codeGenerator) {
        this(language, location, codeGenerator);
        // check if classifier is null
        Helper.checkObjectNotNull(classifier, "classifier in GenerateCodeAction#GenerateCodeAction");
        this.classifiers.add(classifier);
    }

    /**
     * <p>
     * Constructs this instance with the project language, location, package and the code generator instance.
     * </p>
     *
     * @param language
     *            the language used to generate the code
     * @param location
     *            the location (path) to store the generated code files
     * @param packageObj
     *            the Package object.
     * @param codeGenerator
     *            the CodeGenerator object.
     * @throws IllegalArgumentException
     *             if any argument is null, or language or location is empty string.
     */
    public GenerateCodeAction(String language, String location, Package packageObj, CodeGenerator codeGenerator) {
        this(language, location, codeGenerator);
        // check if packageObj is null
        Helper.checkObjectNotNull(packageObj, "packageObj in GenerateCodeAction#GenerateCodeAction");
        this.packages.add(packageObj);
    }

    /**
     * <p>
     * Constructs this instance with the project language, location, list of classifiers and the code
     * generator instance.
     * </p>
     *
     * @param language
     *            the language used to generate the code
     * @param location
     *            the location (path) to store the generated code files
     * @param classifiers
     *            a list of Classifier object.
     * @param codeGenerator
     *            the CodeGenerator object.
     * @throws IllegalArgumentException
     *             if any argument is null, or language or location is empty string, or classifiers list is
     *             empty or contains null element.
     */
    public GenerateCodeAction(String language, String location, List<Classifier> classifiers,
            CodeGenerator codeGenerator) {
        this(language, location, codeGenerator);
        // check if the classifiers list is null/empty or contains any null element
        Helper.checkObjectListNotNull(classifiers, "classifiers in GenerateCodeAction#GenerateCodeAction");
        this.classifiers.addAll(classifiers);
    }

    /**
     * <p>
     * Constructs this instance with the project language, location, list of classifiers and the code
     * generator instance.
     * </p>
     *
     * @param language
     *            the language used to generate the code
     * @param location
     *            the location (path) to store the generated code files
     * @param codeGenerator
     *            the CodeGenerator object.
     * @throws IllegalArgumentException
     *             if any argument is null, or language or location is empty string, or classifiers list is
     *             empty or contains null element.
     */
    private GenerateCodeAction(String language, String location, CodeGenerator codeGenerator) {
        // check if the language string is null or empty
        Helper.checkStringNotNullOrEmpty(language, "language in GenerateCodeAction#GenerateCodeAction");
        // check if the location string is null or empty
        Helper.checkStringNotNullOrEmpty(location, "location in GenerateCodeAction#GenerateCodeAction");
        // check if codeGenerator is null
        Helper.checkObjectNotNull(codeGenerator, "codeGenerator in GenerateCodeAction#GenerateCodeAction");
        this.language = language;
        this.location = location;
        this.codeGenerator = codeGenerator;
    }

    /**
     * <p>
     * Constructs this instance with the project language, location, list of packages and the code generator
     * instance.
     * </p>
     *
     * @param language
     *            the language used to generate the code
     * @param location
     *            the location (path) to store the generated code files
     * @param packages
     *            a list of Package object.
     * @param codeGenerator
     *            the CodeGenerator object.
     * @throws IllegalArgumentException
     *             if any argument is null, or language or location is empty string, or packages list is empty
     *             or contains null element.
     */
    public GenerateCodeAction(String language, String location, CodeGenerator codeGenerator, List<Package> packages) {
        this(language, location, codeGenerator);
        // check if the packages list is null/empty or contains any null element
        Helper.checkObjectListNotNull(packages, "packages in GenerateCodeAction#GenerateCodeAction");
        this.packages.addAll(packages);
    }

    /**
     * <p>
     * Generates code for the given packages or classifiers. It uses the Stub Class Generator component to
     * perform the actual logic.
     * </p>
     *
     * @throws ActionExecutionException
     *             if any exception occurs during the execution, it is mainly used to wrap the all possible
     *             underlying exceptions.
     */
    public void execute() throws ActionExecutionException {
        try {
            if (!classifiers.isEmpty()) {
                codeGenerator.generateCodeForClassifiers(language, location, classifiers);
            } else {
                codeGenerator.generateCodeForPackages(language, location, packages);
            }
        } catch (Exception e) {
            throw new ActionExecutionException("Occurred while generating the code", e);
        }
    }
}
