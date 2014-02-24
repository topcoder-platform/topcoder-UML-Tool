/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator.java;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.Primitive;
import com.topcoder.uml.model.core.classifiers.PrimitiveImpl;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.CallConcurrencyKind;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.stubclassgenerator.AbstractGenerator;
import com.topcoder.uml.stubclassgenerator.GeneratorConfigurationException;

import com.topcoder.util.log.Level;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;

/**
 * <p>
 * A Generator implementation for the Java language.
 * </p>
 * <p>
 * <b>Thread safety:</b>This class is not thread safe because its base class
 * {@link AbstractGenerator} is not thread safe.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class JavaGenerator extends AbstractGenerator {
    /**
     * System dependent line separator.
     */
    private static final String LINE_SEPARATOR = java.lang.System
            .getProperty("line.separator");

    /**
     * The warning level used for logging.
     */
    private static final Level LEVEL = Level.WARN;

    /**
     * Space character.
     */
    private static final char SPACE = ' ';

    /**
     * Four spaces.
     */
    private static final String INDENT = "    ";

    /**
     * Semi colon.
     */
    private static final String SEMI_COLON = ';' + LINE_SEPARATOR;

    /**
     * Colon.
     */
    private static final char COMMA = ',';

    /**
     * Equality sign.
     */
    private static final char EQUALS = '=';

    /**
     * 'import' keyword.
     */
    private static final String IMPORT = "import";

    /**
     * 'package' keyword.
     */
    private static final String PACKAGE = "package";

    /**
     * 'public' keyword.
     */
    private static final String PUBLIC = "public";

    /**
     * 'private' keyword.
     */
    private static final String PRIVATE = "private";

    /**
     * 'protected' keyword.
     */
    private static final String PROTECTED = "protected";

    /**
     * 'static' keyword.
     */
    private static final String STATIC = "static";

    /**
     * 'final' keyword.
     */
    private static final String FINAL = "final";

    /**
     * 'abstract' keyword.
     */
    private static final String ABSTRACT = "abstract";

    /**
     * 'synchronized' keyword.
     */
    private static final String SYNCHRONIZED = "synchronized";

    /**
     * 'class' keyword.
     */
    private static final String CLASS = "class";

    /**
     * 'extends' keyword.
     */
    private static final String EXTENDS = "extends";

    /**
     * 'implements' keyword.
     */
    private static final String IMPLEMENTS = "implements";

    /**
     * 'interface' keyword.
     */
    private static final String INTERFACE = "interface";

    /**
     * 'enum' keyword.
     */
    private static final String ENUM = "enum";

    /**
     * 'return' keyword.
     */
    private static final String RETURN = "return";

    /**
     * 'null' keyword.
     */
    private static final String NULL = "null";

    /**
     * 'void' keyword.
     */
    private static final String VOID = "void";

    /**
     * 'false' keyword.
     */
    private static final String FALSE = "false";

    /**
     * 'boolean' keyword.
     */
    private static final String BOOLEAN = "boolean";

    /**
     * '*'.
     */
    private static final String JAVADOC_STAR = SPACE + "*" + SPACE;

    /**
     * '.*'.
     */
    private static final String DOT_STAR = ".*;" + LINE_SEPARATOR;

    /**
     * Start of comment.
     */
    private static final String START_COMMENT = "/**" + LINE_SEPARATOR;

    /**
     * End of comment.
     */
    private static final String END_COMMENT = "*/" + LINE_SEPARATOR;

    /**
     * Zero.
     */
    private static final char ZERO = '0';

    /**
     * 'at' sign.
     */
    private static final char AT = '@';

    /**
     * 'at' param.
     */
    private static final String AT_PARAM = "@param ";

    /**
     * 'at' return.
     */
    private static final String AT_RETURN = "@return ";

    /**
     * Left parenthesis.
     */
    private static final char LEFT_PARENTHESIS = '(';

    /**
     * Right parenthesis.
     */
    private static final char RIGHT_PARENTHESIS = ')';

    /**
     * Left brace.
     */
    private static final String LEFT_BRACE = '{' + LINE_SEPARATOR;

    /**
     * Right brace.
     */
    private static final String RIGHT_BRACE = '}' + LINE_SEPARATOR;

    /**
     * <p>
     * Creates a new {@link JavaGenerator} instance from the configuration in
     * the given name space.
     * </p>
     *
     * @param namespace
     *            The name space to get the configuration from
     * @throws IllegalArgumentException
     *             if namespace is <code>null</code> or empty
     * @throws GeneratorConfigurationException
     *             if an error occurs while reading configuration
     */
    public JavaGenerator(String namespace)
            throws GeneratorConfigurationException {
        super(namespace);
    }

    /**
     * <p>
     * Creates the full code for the given {@link Classifier}.
     * </p>
     *
     * @param classifier
     *            the {@link Classifier} instance to create the code for
     * @return the full code for the given {@link Classifier}.
     * @throws IllegalArgumentException
     *             if classifier is <code>null</code>
     */
    public String createClassifierCode(Classifier classifier) {
        if (classifier == null) {
            throw new IllegalArgumentException("Classifier must not be null");
        }

        // clear all imports
        this.getImports().clear();

        // get the class structure
        StringBuilder structure = new StringBuilder();
        this.buildClassifierStructure(classifier, structure);

        StringBuilder code = new StringBuilder();
        String pack = this.getPackage(classifier);

        if (pack.length() != 0) {
            // class has a package
            code.append(PACKAGE).append(SPACE).append(pack).append(SEMI_COLON);
        }

        // append all imports
        for (String s : this.getImports()) {
            code.append(IMPORT).append(SPACE).append(s).append(DOT_STAR);
        }

        for (String s : this.getImportTypes()) {
            code.append(IMPORT).append(SPACE).append(s).append(SEMI_COLON);
        }

        // append the code for the class
        code.append(structure);

        // UML-564: Code generation: Ensure indentation matches TopCoder requirements
        String codeString = code.toString();
        TextEdit te = createCodeFormatter().format(
                CodeFormatter.K_COMPILATION_UNIT, codeString, 0,
                codeString.length(), 0, null);

        if (te == null) {
            return codeString;
        }

        IDocument doc = new Document(codeString);
        try {
            te.apply(doc);

            String formattedCode = doc.get();

            return formattedCode;
        } catch (MalformedTreeException e) {
        } catch (BadLocationException e) {
        }

        return codeString;

    }

    /**
     * Create a {@link CodeFormatter} instance to be used by this mojo.
     */
    @SuppressWarnings({"rawtypes"})
    private CodeFormatter createCodeFormatter() {
        Map options = getFormattingOptions();
        return ToolFactory.createCodeFormatter(options);
    }

    /**
     * Return the options to be passed when creating {@link CodeFormatter}
     * instance.
     *
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private Map getFormattingOptions() {
        Map options = new HashMap();
        options.put(JavaCore.COMPILER_SOURCE, "1.5");
        options.put(JavaCore.COMPILER_COMPLIANCE, "1.5");
        options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, "1.5");

        Map config = getOptionsFromConfigFile();
        options.putAll(config);

        return options;
    }

    /**
     * Read config file and return the config as {@link Map}.
     *
     * @return
     */
    @SuppressWarnings({"rawtypes"})
    private Map getOptionsFromConfigFile() {
        FileReader reader;
        try {
            reader = new FileReader("conf/TopCoder.xml");
            ConfigReader configReader = new ConfigReader();
            return configReader.read(reader);
        } catch (FileNotFoundException e) {
        }
        return Collections.emptyMap();
    }

    /**
     * <p>
     * Creates code for the structure of a class and its sub classes.
     * </p>
     *
     * @param classifier
     *            {@link Classifier} to generate the code for
     * @param builder
     *            {@link StringBuilder} to aggregate the generated code
     */
    private void buildClassifierStructure(Classifier classifier,
            StringBuilder builder) {
        // write class comment
        builder.append(START_COMMENT);
        this.buildDocumentation(classifier, builder);
        builder.append(END_COMMENT);
        this.buildClassifierHeader(classifier, builder);
        builder.append(SPACE).append(LEFT_BRACE);

        // write all attributes
        for (Feature feature : classifier.getFeatures()) {
            if (feature instanceof Attribute) {
                builder.append(START_COMMENT);
                this.buildDocumentation(feature, builder);
                builder.append(END_COMMENT);
                this.buildAttribute((Attribute) feature, builder);
            }
        }

        // write all methods
        for (Feature feature : classifier.getFeatures()) {
            if (feature instanceof Operation) {
                builder.append(START_COMMENT);
                this.buildDocumentation(feature, builder);
                builder.append(END_COMMENT);
                this.buildOperation((Operation) feature, builder);
            }
        }

        // write inner classes
        for (ModelElement element : classifier.getOwnedElements()) {
            if (element instanceof Classifier
                    && this.checkClassifier((Classifier) element)) {
                this.buildClassifierStructure((Classifier) element, builder);
            }
        }

        builder.append(RIGHT_BRACE);
    }

    /**
     * <p>
     * Creates the code for the general and the tags documentation.
     * </p>
     *
     * @param modelElement
     *            {@link ModelElement} to get the documentation for
     * @param builder
     *            {@link StringBuilder} to aggregate the generated code
     */
    private void buildDocumentation(ModelElement modelElement,
            StringBuilder builder) {
        String generalDocs = this.getGeneralDocumentation(modelElement);

        if (generalDocs != null) {
            // put (*) for well format javadoc into every line
            writeDocumentation(generalDocs, builder);
        }

        // write the documentation tags
        Map<String, List<String>> tagDocs = this
                .getTagDocumentation(modelElement);

        for (String tag : tagDocs.keySet()) {
            for (String doc : tagDocs.get(tag)) {
                builder.append(JAVADOC_STAR).append(tag).append(SPACE)
                        .append(doc).append(LINE_SEPARATOR);
            }
        }

        // write parameter tags
        if (modelElement instanceof Operation) {
            Map<String, List<String>> paramDocs = this
                    .getParametersDocumentation((Operation) modelElement);

            for (String param : paramDocs.keySet()) {
                for (String doc : paramDocs.get(param)) {
                    builder.append(JAVADOC_STAR).append(AT_PARAM).append(param)
                            .append(SPACE).append(doc).append(LINE_SEPARATOR);
                }
            }

            // write the return parameter
            Parameter returnParameter = this
                    .getReturnParameter((Operation) modelElement);

            boolean isVoid = (returnParameter != null)
                    && (returnParameter.getType() instanceof PrimitiveImpl)
                    && VOID.equals(returnParameter.getType().getName());

            if ((returnParameter != null) && !isVoid) {
                builder.append(JAVADOC_STAR).append(AT_RETURN);

                String doc = this.getGeneralDocumentation(returnParameter);

                if (doc != null) {
                    builder.append(doc);
                }

                builder.append(LINE_SEPARATOR);
            }
        }
    }

    /**
     * Writes the given documentation to builder.
     *
     * @param doc
     *            documentation to be written
     * @param builder
     *            {@link StringBuilder} to aggregate the generated code
     */
    private void writeDocumentation(String doc, StringBuilder builder) {
        Scanner scanner = new Scanner(doc);

        while (scanner.hasNext()) {
            builder.append(JAVADOC_STAR).append(scanner.nextLine())
                    .append(LINE_SEPARATOR);
        }
    }

    /**
     * <p>
     * Creates the code for the header of a {@link Class}, {@link Interface} or
     * {@link Enumeration}.
     * <p>
     *
     * @param classifier
     *            {@link Classifier} to generate the code for
     * @param builder
     *            {@link StringBuilder} to aggregate the generated code
     */
    private void buildClassifierHeader(Classifier classifier,
            StringBuilder builder) {
        // write the visibility modifier if available
        this.buildVisibilityKind(classifier.getVisibility(), builder);

        boolean isClass = classifier instanceof Class;

        if (classifier instanceof Interface) {
            // write the abstract modifier
            if (classifier.isAbstract()) {
                builder.append(ABSTRACT).append(SPACE);
            }

            builder.append(INTERFACE);
        } else if (classifier instanceof Enumeration) {
            builder.append(ENUM);
        } else if (isClass) {
            // write the abstract modifier
            if (classifier.isAbstract()) {
                builder.append(ABSTRACT).append(SPACE);
            }

            // write the final modifier
            if (classifier.isLeaf()) {
                builder.append(FINAL).append(SPACE);
            }

            builder.append(CLASS);
        } else {
            this.getLog().log(LEVEL, "Unknown Classifier type encountered");
        }

        builder.append(SPACE);

        this.buildName(classifier, builder);

        List<ModelElement> classExtends = new ArrayList<ModelElement>();
        List<ModelElement> interfaceImplements = new ArrayList<ModelElement>();

        for (Generalization generalization : classifier.getGeneralizations()) {
            ModelElement parent = generalization.getParent();

            if (parent instanceof Class) {
                classExtends.add(parent);
            }
            /*
             * BugFix: UML-9994 Realization information is stored in
             * clientDependency list.
             */
            // old code
            else if (parent instanceof Interface) {
                interfaceImplements.add(parent);
            }
        }

        /*
         * BugFix: UML-9994 Realization information is stored in
         * clientDependency list.
         */
        for (Dependency dependency : classifier.getClientDependencies()) {
            if (dependency instanceof Abstraction) {
                for (ModelElement supplier : dependency.getSuppliers()) {
                    interfaceImplements.add(supplier);
                }
            }
        }

        if ((classExtends.size() != 0) && isClass) {
            if (classExtends.size() > 1) {
                this.getLog().log(
                        LEVEL,
                        "Found multiple inheritance in class "
                                + classifier.getName());
            }

            builder.append(SPACE).append(EXTENDS).append(SPACE);
            this.buildCSV(classExtends, builder);
        }

        if (interfaceImplements.size() != 0) {
            builder.append(SPACE);

            if (isClass) {
                builder.append(IMPLEMENTS);
            } else {
                builder.append(EXTENDS);
            }

            builder.append(SPACE);
            this.buildCSV(interfaceImplements, builder);
        }
    }

    /**
     * <p>
     * Creates a comma separated list of the given list element's names.
     * </p>
     *
     * @param list
     *            list containing elements
     * @param builder
     *            {@link StringBuilder} to aggregate the generated code
     */
    private void buildCSV(List<ModelElement> list, StringBuilder builder) {
        boolean isFirst = true;

        for (ModelElement element : list) {
            if (isFirst) {
                isFirst = false;
            } else {
                builder.append(COMMA).append(SPACE);
            }

            this.buildName(element, builder);
        }
    }

    /**
     * <p>
     * Creates the code for an {@link Attribute} instance.
     * </p>
     *
     * @param attribute
     *            the {@link Attribute} instance to get the code for
     * @param builder
     *            {@link StringBuilder} to aggregate the generated code
     */
    private void buildAttribute(Attribute attribute, StringBuilder builder) {
        // write the visibility modifier if available
        this.buildVisibilityKind(attribute.getVisibility(), builder);

        // write the owner scope if available
        if (attribute.getOwnerScope() == ScopeKind.CLASSIFIER) {
            builder.append(STATIC).append(SPACE);
        }

        if (attribute.getChangeability() == ChangeableKind.FROZEN) {
            builder.append(FINAL).append(SPACE);
        }

        this.buildType(attribute.getType(), builder);

        // write the attribute's name if available, if not log error
        String attributeName = attribute.getName();

        if ((attributeName != null) && (attributeName.length() != 0)) {
            builder.append(attributeName);
        } else {
            this.getLog().log(LEVEL, "Missing attribute name");
        }

        // write the attribute's initial value if available
        Expression initialValue = attribute.getInitialValue();

        if (initialValue != null) {
            String body = initialValue.getBody();

            if ((body != null) && (body.length() != 0)) {
                builder.append(SPACE).append(EQUALS).append(SPACE);
                builder.append(body);
            }
        }

        builder.append(SEMI_COLON);
    }

    /**
     * Creates the code for the given type {@link Classifier}. The package of
     * the given {@link Classifier} is also adds to the list of imports.
     *
     * @param type
     *            {@link Classifier} to create the code for
     * @param builder
     *            {@link StringBuilder} the result is written to.
     */
    private void buildType(Classifier type, StringBuilder builder) {
        if (type != null) {
            // add the type's package to the list of imports
            Namespace namespace = type.getNamespace();
            if (namespace != null && !(namespace instanceof Model)) {
                this.getImports().add(this.getPackage(type));
            }

            if (type.getName().contains(".")) {
                String importNew = "";
                if (namespace != null && !(namespace instanceof Model)) {
                    importNew = this.getPackage(type) + ".";
                }
                this.getImportTypes().add(importNew + type.getName());
            }

            if (this.buildName(type, builder)) {
                builder.append(SPACE);
            }
        } else {
            this.getLog().log(LEVEL, "Missing type information for attribute");
        }
    }

    /**
     * Creates the code for the name of the given {@link ModelElement}.
     *
     * @param modelElement
     *            {@link ModelElement} to get the name from
     * @param builder
     *            {@link StringBuilder} the result is written to.
     * @return <code>true</code> if the name was found and written,
     *         <code>false</code> otherwise
     */
    private boolean buildName(ModelElement modelElement, StringBuilder builder) {
        String name = modelElement.getName();

        boolean isWritten = false;

        if ((name != null) && (name.trim().length() != 0)) {
            if (name.contains(".")) {
                builder.append(name.substring(name.lastIndexOf(".") + 1));
            } else {
                builder.append(name);
            }
            isWritten = true;
        } else {
            this.getLog().log(LEVEL, "Missing name");
        }

        return isWritten;
    }

    /**
     * Creates the code for the given {@link VisibilityKind} into a
     * {@link StringBuilder}.
     *
     * @param kind
     *            {@link VisibilityKind} to be written.
     * @param builder
     *            {@link StringBuilder} the result is written to.
     */
    private void buildVisibilityKind(VisibilityKind kind, StringBuilder builder) {
        if (kind == null) {
            return;
        }

        switch (kind) {
        case PUBLIC:
            builder.append(PUBLIC).append(SPACE);

            return;

        case PROTECTED:
            builder.append(PROTECTED).append(SPACE);

            return;

        case PRIVATE:
            builder.append(PRIVATE).append(SPACE);

            return;

        default:

            // unknown type, nothing to do
            return;
        }
    }

    /**
     * <p>
     * Creates the code for an {@link Operation} instance.
     * </p>
     *
     * @param operation
     *            the {@link Operation} instance to get the code for
     * @param builder
     *            {@link StringBuilder} to aggregate the generated code
     */
    private void buildOperation(Operation operation, StringBuilder builder) {
        // write the visibility modifier if available
        this.buildVisibilityKind(operation.getVisibility(), builder);

        // write the abstract modifier
        if (operation.isAbstract()) {
            builder.append(ABSTRACT).append(SPACE);
        }

        // write the final modifier
        if (operation.isLeaf()) {
            builder.append(FINAL).append(SPACE);
        }

        // write the static modifier
        if (operation.getOwnerScope() == ScopeKind.CLASSIFIER) {
            builder.append(STATIC).append(SPACE);
        }

        // write the synchronized modifier
        if (operation.getConcurrency() == CallConcurrencyKind.GUARDED) {
            builder.append(SYNCHRONIZED).append(SPACE);
        }

        // get the return parameter
        Parameter returnParameter = this.getReturnParameter(operation);

        // write return parameter
        if (returnParameter != null) {
            this.buildType(returnParameter.getType(), builder);
        }

        // write the operation's name
        this.buildName(operation, builder);

        this.buildParameterList(operation, builder);
        if (operation.getOwner() instanceof Interface || operation.isAbstract()) {
            builder.append(SEMI_COLON);
        } else {
            builder.append(SPACE).append(LEFT_BRACE);
            this.buildReturnStatement(returnParameter, builder);
            builder.append(RIGHT_BRACE);
        }
    }

    /**
     * Returns the return parameter for the given {@link Operation}. If no
     * return parameter is found <code>null</code> is returned.
     *
     * @param op
     *            the {@link Operation} to get the parameter for
     * @return the return parameter for the given {@link Operation}.
     */
    private Parameter getReturnParameter(Operation op) {
        for (Parameter parameter : op.getParameters()) {
            if (parameter.getKind() == ParameterDirectionKind.RETURN) {
                return parameter;
            }
        }

        return null;
    }

    /**
     * Creates the code for parameter list for the given {@link Operation} in
     * the form <code>(Type1 name1, Type2 name2)</code>.
     *
     * @param operation
     *            {@link Operation} to build the parameter list for
     * @param builder
     *            {@link StringBuilder} to write the result to
     */
    private void buildParameterList(Operation operation, StringBuilder builder) {
        builder.append(LEFT_PARENTHESIS);

        boolean isFirst = true;

        // write all parameter
        for (Parameter parameter : operation.getParameters()) {
            if (parameter.getKind() == ParameterDirectionKind.RETURN) {
                continue;
            }

            // write the parameter's type
            Classifier type = parameter.getType();

            if (type != null) {
                String pack = this.getPackage(type);
                if (!pack.equals("")) {
                    // add the type's package to the list of imports
                    this.getImports().add(pack);
                }

                String typeName = type.getName();

                if ((typeName != null) && (typeName.trim().length() != 0)) {
                    if (isFirst) {
                        isFirst = false;
                    } else {
                        builder.append(COMMA).append(SPACE);
                    }

                    builder.append(typeName).append(SPACE);
                } else {
                    this.getLog().log(LEVEL, "Missing type name for parameter");
                }
            } else {
                this.getLog().log(LEVEL, "Missing type for parameter");
            }

            // write the parameter's name
            String parameterName = parameter.getName();

            if ((parameterName != null) && (parameterName.trim().length() != 0)) {
                builder.append(parameterName);
            } else {
                this.getLog().log(LEVEL, "Missing name for parameter");
            }
        }

        builder.append(RIGHT_PARENTHESIS);
    }

    /**
     * Creates the code for the return statement which represents the body
     * content of the generated method. The return has the form
     * <code>    return type_default_value;</code>. If the given return
     * parameter is <code>null</code> or of type <code>void</code> no return
     * statement is built.
     *
     * @param returnParameter
     *            The return parameter.
     * @param builder
     *            {@link StringBuilder} to write the result to
     */
    private void buildReturnStatement(Parameter returnParameter,
            StringBuilder builder) {
        if (returnParameter != null) {
            Classifier type = returnParameter.getType();

            if (type != null) {
                String typeName = type.getName();

                if (!VOID.equals(typeName)) {
                    builder.append(INDENT).append(RETURN).append(SPACE);

                    if (type instanceof Primitive) {
                        if (BOOLEAN.equals(typeName)) {
                            builder.append(FALSE);
                        } else {
                            builder.append(ZERO);
                        }
                    } else {
                        builder.append(NULL);
                    }

                    builder.append(SEMI_COLON);
                }
            }
        }
    }
}
