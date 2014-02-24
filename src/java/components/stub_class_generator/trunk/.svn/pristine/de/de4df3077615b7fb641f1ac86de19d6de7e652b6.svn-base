/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import com.topcoder.uml.stubclassgenerator.csharp.CSharpGenerator;
import com.topcoder.uml.stubclassgenerator.java.JavaGenerator;


/**
 * <p>
 * This class represents realization of the factory pattern for this component.
 * It returns different instances of {@link Generator} depend on a language
 * parameter.
 * </p>
 * <p>
 * <b>Thread safety:</b> Class is thread safety because it is immutable.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
abstract class GeneratorFactory {
    /**
     * The java language.
     */
    private static final String JAVA = "java";

    /**
     * The c# language.
     */
    private static final String CS = "cs";

    /**
     * <p>
     * Returns a new {@link Generator} instance dependent on the given language
     * parameter. Currently it may be one of the following:
     * <ul>
     * <li> JavaGenerator (Java)
     * <li> CSharpGenerator (C#)
     * </ul>
     * </p>
     *
     * @param language
     *            language of the {@link Generator} to be created
     * @param codeGenerator
     *            {@link CodeGenerator} instance used to create the
     *            {@link Generator}
     * @param namespace
     *            String with name-space in configuration file
     * @return a new {@link Generator} instance.
     * @throws GeneratorConfigurationException
     *             if there are problems with the configuration
     * @throws CodeGenerationException
     *             if the language format is not correct
     * @throws IllegalArgumentException
     *             if any parameter is <code>null</code>
     * @throws IllegalArgumentException
     *             if language or name-space are empty
     */
    public static Generator getGeneratorInstance(String language, CodeGenerator codeGenerator, String namespace)
        throws CodeGenerationException {
        if (language == null) {
            throw new IllegalArgumentException("Language must not be null");
        }

        if (language.trim().length() == 0) {
            throw new IllegalArgumentException("Language must not be empty");
        }

        if (codeGenerator == null) {
            throw new IllegalArgumentException("Code generator must not be null");
        }

        if (namespace == null) {
            throw new IllegalArgumentException("Name space must not be null");
        }

        if (namespace.trim().length() == 0) {
            throw new IllegalArgumentException("Name space must not be empty");
        }

        if (language.equals(codeGenerator.getLanguageJava())) {
            return new JavaGenerator(namespace);
        }

        if (language.equals(codeGenerator.getLanguageCSharp())) {
            return new CSharpGenerator(namespace);
        }

        throw new CodeGenerationException("Unknown language: " + language);
    }

    /**
     * <p>
     * Returns the file extension depending on the given language. Possible
     * values are:
     * <ul>
     * <li> &quot;java&quot;
     * <li> &quot;cs&quot;
     * </ul>
     * </p>
     *
     * @param language
     *            used language
     * @param codeGenerator
     *            {@link CodeGenerator} instance used
     * @return {@link String} containing the file extension
     * @throws CodeGenerationException
     *             if the language format is not correct
     * @throws IllegalArgumentException
     *             if any parameter is <code>null</code>
     * @throws IllegalArgumentException
     *             if language is empty
     */
    public static String getExtension(String language, CodeGenerator codeGenerator)
        throws CodeGenerationException {
        if (language == null) {
            throw new IllegalArgumentException("Language must not be null");
        }

        if (language.trim().length() == 0) {
            throw new IllegalArgumentException("Language must not be empty");
        }

        if (codeGenerator == null) {
            throw new IllegalArgumentException("Code generator must not be null");
        }

        if (language.equals(codeGenerator.getLanguageJava())) {
            return JAVA;
        }

        if (language.equals(codeGenerator.getLanguageCSharp())) {
            return CS;
        }

        throw new CodeGenerationException("Unknown language: " + language);
    }
}
