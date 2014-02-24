/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator.csharp;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.Primitive;
import com.topcoder.uml.model.core.classifiers.PrimitiveImpl;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.stubclassgenerator.AbstractGenerator;
import com.topcoder.uml.stubclassgenerator.GeneratorConfigurationException;

import com.topcoder.util.log.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>
 * A Generator implementation for the C# language.
 * </p>
 * <p>
 * <b>Thread safety:</b>This class is not thread safe.
 * </p>
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class CSharpGenerator extends AbstractGenerator {
    /**
     * System dependent line separator.
     */
    private static final String LINE_SEPARATOR = java.lang.System.getProperty("line.separator");

    /**
     * The warning level used for logging.
     */
    private static final Level LEVEL = Level.WARN;

    /**
     * Space character.
     */
    private static final char SPACE = ' ';

    /**
     * Slash character.
     */
    private static final char SLASH = '/';

    /**
     * Semi colon.
     */
    private static final String SEMI_COLON = ';' + LINE_SEPARATOR;

    /**
     * Comma.
     */
    private static final char COMMA = ',';

    /**
     * Tilde.
     */
    private static final char TILDE = '~';

    /**
     * Colon.
     */
    private static final char COLON = ':';

    /**
     * Zero.
     */
    private static final char ZERO = '0';

    /**
     * Apostrophe.
     */
    private static final char APOSTROPHE = '"';

    /**
     * Tag open.
     */
    private static final char TAG_OPEN = '<';

    /**
     * Tag close.
     */
    private static final char TAG_CLOSE = '>';

    /**
     * Equality sign.
     */
    private static final char EQUALS = '=';

    /**
     * Start of documentation line.
     */
    private static final String DOC_START = "/// ";

    /**
     * Parameter.
     */
    private static final String PARAM = "param";

    /**
     * Parameter name.
     */
    private static final String PARAM_NAME = " name=\"";

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
     * 'protected internal' keyword.
     */
    private static final String PROTECTED_INTERNAL = "protected internal";

    /**
     * 'new' keyword.
     */
    private static final String NEW = "new";

    /**
     * 'readonly' keyword.
     */
    private static final String READONLY = "readonly";

    /**
     * 'static' keyword.
     */
    private static final String STATIC = "static";

    /**
     * 'final' keyword.
     */
    private static final String CONST = "const";

    /**
     * 'event' keyword.
     */
    private static final String EVENT = "event";

    /**
     * 'class' keyword.
     */
    private static final String CLASS = "class";

    /**
     * 'struct' keyword.
     */
    private static final String STRUCT = "struct";

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
    private static final String RETURN = "return ";

    /**
     * 'returns' tag.
     */
    private static final String RETURNS_START = "<returns>" + LINE_SEPARATOR;

    /**
     * 'returns' end tag.
     */
    private static final String RETURNS_END = "</returns>" + LINE_SEPARATOR;

    /**
     * 'null' keyword.
     */
    private static final String NULL = "null";

    /**
     * 'void' keyword.
     */
    private static final String VOID = "void";

    /**
     * 'abstract' keyword.
     */
    private static final String ABSTRACT = "abstract";

    /**
     * 'bool' keyword.
     */
    private static final String BOOL = "bool";

    /**
     * 'false' keyword.
     */
    private static final String FALSE = "false";

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
     * right brace.
     */
    private static final String RIGHT_BRACE = '}' + LINE_SEPARATOR;

    /**
     * 'virtual' keyword.
     */
    private static final String VIRTUAL = "virtual";

    /**
     * 'override' keyword.
     */
    private static final String OVERRIDE = "override";

    /**
     * 'sealed' keyword.
     */
    private static final String SEALED = "sealed";

    /**
     * 'explicit' keyword.
     */
    private static final String EXPLICIT = "explicit";

    /**
     * 'implicit' keyword.
     */
    private static final String IMPLICIT = "implicit";

    /**
     * 'extern' keyword.
     */
    private static final String EXTERN = "extern";

    /**
     * 'property' keyword.
     */
    private static final String PROPERTY = "property";

    /**
     * 'property_set' keyword.
     */
    private static final String PROPERTY_SET = "property_set";

    /**
     * 'property_get' keyword.
     */
    private static final String PROPERTY_GET = "property_get";

    /**
     * Pattern for a getter.
     */
    private static final String GETTER = "get {" + LINE_SEPARATOR;

    /**
     * Pattern for a getter.
     */
    private static final String SETTER = "set {}" + LINE_SEPARATOR;

    /**
     * Delegate.
     */
    private static final String DELEGATE = "delegate";

    /**
     * Destructor.
     */
    private static final String DESTRUCTOR = "destructor";

    /**
     * Delegate.
     */
    private static final String USING = "using ";

    /**
     * Namespace.
     */
    private static final String NAMESPACE = "namespace ";

    /**
     * <p>
     * Creates a new {@link CSharpGenerator} instance from the configuration in the given name space.
     * </p>
     *
     * @param namespace
     *            The name space to get the configuration from
     * @throws IllegalArgumentException
     *             if namespace is <code>null</code> or empty
     * @throws GeneratorConfigurationException
     *             if an error occurs while reading configuration
     */
    public CSharpGenerator(String namespace) throws GeneratorConfigurationException {
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

        StringBuilder code = new StringBuilder();
        // get the class structure
        StringBuilder structure = new StringBuilder();
        this.buildClassifierStructure(classifier, structure);

        // append all imports
        for (String s : this.getImports()) {
            code.append(USING).append(s).append(SEMI_COLON);
        }

        String pack = this.getPackage(classifier);

        if (pack.length() != 0) {
            // class has a package
            code.append(NAMESPACE).append(pack).append(SPACE).append(LEFT_BRACE);
        }

        this.buildDocumentation(classifier, code);

        // append the code for the class
        code.append(structure);

        if (pack.length() != 0) {
            code.append(RIGHT_BRACE);
        }

        return code.toString();
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
    private void buildClassifierStructure(Classifier classifier, StringBuilder builder) {
        if (this.hasStereoType(classifier, DELEGATE)) {
            this.buildDelegate(classifier, builder);

            return;
        }

        this.buildClassifierHeader(classifier, builder);
        builder.append(LEFT_BRACE);

        // write all attributes
        for (Feature feature : classifier.getFeatures()) {
            if (feature instanceof Attribute) {
                this.buildDocumentation(feature, builder);
                this.buildAttribute((Attribute) feature, builder);
            }
        }

        // write all methods
        for (Feature feature : classifier.getFeatures()) {
            if (feature instanceof Operation) {
                this.buildDocumentation(feature, builder);
                this.buildOperation((Operation) feature, builder);
            }
        }

        // write inner classes
        for (ModelElement element : classifier.getOwnedElements()) {
            if (element instanceof Classifier && this.checkClassifier((Classifier) element)) {
                this.buildDocumentation(classifier, builder);
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
    private void buildDocumentation(ModelElement modelElement, StringBuilder builder) {
        String generalDocs = this.getGeneralDocumentation(modelElement);

        if (generalDocs != null) {
            this.writeDocumentation(generalDocs, builder);
            builder.append(LINE_SEPARATOR);
        }

        // write the documentation tags
        Map<String, List<String>> tagDocs = this.getTagDocumentation(modelElement);

        for (String tag : tagDocs.keySet()) {
            for (String doc : tagDocs.get(tag)) {
                builder.append(DOC_START).append(TAG_OPEN).append(tag.replace("@", "")).append(TAG_CLOSE);

                if (!doc.contains(LINE_SEPARATOR)) {
                    builder.append(doc);
                } else {
                    writeDocumentation(doc, builder);
                    builder.append(DOC_START);
                }
                builder.append(TAG_OPEN).append(SLASH).append(tag.replace("@", "")).append(TAG_CLOSE).append(
                    LINE_SEPARATOR);
            }
        }

        // write parameter tags
        if (modelElement instanceof Operation) {
            Map<String, List<String>> paramDocs = this.getParametersDocumentation((Operation) modelElement);

            for (String param : paramDocs.keySet()) {
                for (String doc : paramDocs.get(param)) {
                    builder.append(DOC_START).append(TAG_OPEN).append(PARAM).append(PARAM_NAME).append(param);
                    builder.append(APOSTROPHE).append(TAG_CLOSE).append(LINE_SEPARATOR);
                    this.writeDocumentation(doc, builder);
                    builder.append(LINE_SEPARATOR).append(DOC_START).append(TAG_OPEN).append(SLASH).append(PARAM).append(TAG_CLOSE)
                        .append(LINE_SEPARATOR);
                }
            }

            Parameter returnParameter = this.getReturnParameter((Operation) modelElement);

            boolean isVoid =
                (returnParameter != null) && (returnParameter.getType() instanceof PrimitiveImpl)
                    && VOID.equals(returnParameter.getType().getName());

            if ((returnParameter != null) && !isVoid) {
                builder.append(DOC_START).append(RETURNS_START);

                String doc = this.getGeneralDocumentation(returnParameter);

                if (doc != null) {
                    builder.append(DOC_START).append(doc).append(LINE_SEPARATOR);
                }

                builder.append(DOC_START).append(RETURNS_END).append(LINE_SEPARATOR);
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
            builder.append(DOC_START).append(scanner.nextLine());
            if (scanner.hasNext()) {
                builder.append(LINE_SEPARATOR);
            }
        }
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
    private void buildClassifierHeader(Classifier classifier, StringBuilder builder) {
        // write the visibility modifier if available
        this.buildVisibilityKind(classifier.getVisibility(), builder);

        boolean isClass = classifier instanceof Class;

        if (classifier instanceof Interface) {
            if (this.hasStereoType(classifier, STRUCT)) {
                builder.append(STRUCT);
            } else {

                if (classifier.isAbstract()) {
                    builder.append(ABSTRACT).append(SPACE);
                }

                builder.append(INTERFACE);
            }
        } else if (classifier instanceof Enumeration) {
            builder.append(ENUM);
        } else if (isClass) {
            if (this.hasStereoType(classifier, STRUCT)) {
                builder.append(STRUCT);
            } else {
                // write the abstract modifier
                if (classifier.isAbstract()) {
                    builder.append(ABSTRACT).append(SPACE);
                }

                if (classifier.isLeaf()) {
                    builder.append(SEALED).append(SPACE);
                }

                builder.append(CLASS);
            }
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
            } else if (parent instanceof Interface) {
                interfaceImplements.add(parent);
            }
        }

        for (Dependency dependency : classifier.getClientDependencies()) {
            if (dependency instanceof Abstraction) {
                for (ModelElement supplier : dependency.getSuppliers()) {
                    interfaceImplements.add(supplier);
                }
            }
        }

        boolean isListStarted = false;

        if ((classExtends.size() != 0) && isClass) {
            if (classExtends.size() > 1) {
                this.getLog().log(LEVEL, "Found multiple inheritance in class " + classifier.getName());
            }

            builder.append(SPACE).append(COLON).append(SPACE);
            isListStarted = true;
            this.buildCSV(classExtends, builder);
        }

        if (interfaceImplements.size() != 0) {
            if (isListStarted) {
                builder.append(COMMA).append(SPACE);
            } else {
                builder.append(SPACE).append(COLON).append(SPACE);
            }

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

         if (!this.buildStereoType(attribute, PROTECTED_INTERNAL, builder)) {
             // write the visibility modifier
             this.buildVisibilityKind(attribute.getVisibility(), builder);
         }

        this.buildStereoType(attribute, NEW, builder);
        this.buildStereoType(attribute, READONLY, builder);
        this.buildStereoType(attribute, EVENT, builder);

        boolean isProperty = this.hasStereoType(attribute, PROPERTY);
        boolean isPropertySet = isProperty ? true : this.hasStereoType(attribute, PROPERTY_SET);
        boolean isPropertyGet = isProperty ? true : this.hasStereoType(attribute, PROPERTY_GET);
        isProperty = isPropertyGet || isPropertySet;

        // write the owner scope if available
        if (attribute.getOwnerScope() == ScopeKind.CLASSIFIER) {
            builder.append(STATIC).append(SPACE);
        }

        if (attribute.getChangeability() == ChangeableKind.FROZEN) {
            builder.append(CONST).append(SPACE);
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

        if (isProperty) {
            builder.append(LEFT_BRACE);
            this.buildProperty(attribute.getType(), isPropertySet, isPropertyGet,
                    builder);
            builder.append(RIGHT_BRACE);
        } else {
            builder.append(SEMI_COLON);
        }
    }

    /**
     * Checks if the given {@link ModelElement} has a {@link Stereotype} for the given keyword.
     *
     * @param modelElement
     *            {@link ModelElement} to be checked
     * @param keyWord
     *            a keyword
     * @return <code>true</code> if {@link ModelElement} has a {@link Stereotype} for the given keyword
     */
    private boolean hasStereoType(ModelElement modelElement, String keyWord) {
        System.out.println(keyWord);
        String typeName = this.getStereotypes().get(keyWord);
        System.out.println(typeName);
        for (Stereotype stereoType : modelElement.getStereotypes()) {
            if (typeName.equals(stereoType.getName())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Creates the code for the given {@link VisibilityKind} into a {@link StringBuilder}.
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

        this.buildStereoType(operation, NEW, builder);
        this.buildStereoType(operation, VIRTUAL, builder);
        this.buildStereoType(operation, OVERRIDE, builder);
        this.buildStereoType(operation, SEALED, builder);
        this.buildStereoType(operation, EXTERN, builder);
        this.buildStereoType(operation, EXPLICIT, builder);
        this.buildStereoType(operation, IMPLICIT, builder);

        boolean isProperty = this.hasStereoType(operation, PROPERTY);
        boolean isPropertySet = isProperty ? true : this.hasStereoType(operation, PROPERTY_SET);
        boolean isPropertyGet = isProperty ? true : this.hasStereoType(operation, PROPERTY_GET);
        isProperty = isPropertyGet || isPropertySet;



        if (!isProperty) {
            // write the abstract modifier
            if (operation.isAbstract()) {
                builder.append(ABSTRACT).append(SPACE);
            }

            // write the const modifier
            if (operation.isLeaf()) {
                builder.append(SEALED).append(SPACE);
            }
        }

        // write the static modifier
        if (operation.getOwnerScope() == ScopeKind.CLASSIFIER) {
            builder.append(STATIC).append(SPACE);
        }

        // get the return parameter
        Parameter returnParameter = this.getReturnParameter(operation);

        // write return parameter
        if (returnParameter != null) {
            this.buildType(returnParameter.getType(), builder);
        }

        if (this.hasStereoType(operation, DESTRUCTOR)) {
            builder.append(TILDE);
        }

        // write the operation's name
        this.buildName(operation, builder);

        if (!isProperty) {
            this.buildParameterList(operation, builder);
        }

        if (operation.getOwner() instanceof Interface || operation.isAbstract()) {
            builder.append(SEMI_COLON);
        } else {

            builder.append(SPACE).append(LEFT_BRACE);

            if (isProperty) {
                this.buildProperty(returnParameter.getType(), isPropertySet,
                        isPropertyGet, builder);
            } else {
                this.buildReturnStatement(returnParameter, builder);
            }

            builder.append(RIGHT_BRACE);
        }
    }

    /**
     * Returns the {@link Operation}'s return parameter.
     *
     * @param op
     *            the {@link Operation} to get the return parameter from
     * @return the {@link Operation}'s return parameter.
     */
    private Parameter getReturnParameter(Operation op) {
        if (op == null) {
            return null;
        }

        Parameter returnParameter = null;

        for (Parameter parameter : op.getParameters()) {
            if (parameter.getKind() == ParameterDirectionKind.RETURN) {
                returnParameter = parameter;

                break;
            }
        }

        return returnParameter;
    }

    /**
     * Creates the code for parameter list for the given {@link Operation} in the form
     * <code>(Type1 name1, Type2 name2)</code>.
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
                if (this.getPackage(type).trim().length() > 0) {
                    // add the type's package to the list of imports
                    this.getImports().add(this.getPackage(type));
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
     * <p>
     * Creates code for a property represented by the given {@link Operation}.
     * </p>
     *
     * @param returnParameter
     *            the return parameter
     * @param isSet
     *            flag to indicate if a setter should be built
     * @param isGet
     *            flag to indicate if a getter should be built
     * @param builder
     *            {@link StringBuilder} to aggregate the generated code
     */
    private void buildProperty(Classifier returnParameter, boolean isSet, boolean isGet, StringBuilder builder) {
        if (isSet) {
            builder.append(SETTER);
        }

        if (isGet) {
            builder.append(GETTER);

            if (returnParameter != null) {
                this.buildReturnStatement(returnParameter, builder);
            } else {
                this.getLog().log(LEVEL, "Missing return type for property-getter");
            }

            builder.append(RIGHT_BRACE);
        }
    }

    private void buildReturnStatement(Classifier type,
            StringBuilder builder) {
        if (type != null) {
            String typeName = type.getName();

            if (!VOID.equals(typeName)) {
                builder.append(RETURN);

                if (type instanceof Enumeration) {
                    builder.append(ZERO);
                } else if (type instanceof Primitive) {
                    if (BOOL.equals(typeName)) {
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

    /**
     * <p>
     * Creates code for a delegate represented by the given {@link Classifier}.
     * </p>
     *
     * @param classifier
     *            {@link Classifier} representing the delegate
     * @param builder
     *            {@link StringBuilder} to aggregate the generated code
     */
    private void buildDelegate(Classifier classifier, StringBuilder builder) {
        this.buildVisibilityKind(classifier.getVisibility(), builder);

        builder.append(DELEGATE).append(SPACE);

        if (classifier.getFeatures().size() == 0) {
            builder.append(SEMI_COLON);
            return;
        }

        Operation operation = (Operation) classifier.getFeatures().get(0);

        // get the return parameter
        Parameter returnParameter = this.getReturnParameter(operation);

        // write return parameter
        if (returnParameter != null) {
            this.buildType(returnParameter.getType(), builder);
        }

        // write the delegates name
        this.buildName(operation, builder);

        this.buildParameterList(operation, builder);
        builder.append(SEMI_COLON);
    }

    /**
     * Creates the code for the given type {@link Classifier}. The package of the given {@link Classifier} is also
     * adds to the list of imports.
     *
     * @param type
     *            {@link Classifier} to create the code for
     * @param builder
     *            {@link StringBuilder} the result is written to.
     */
    private void buildType(Classifier type, StringBuilder builder) {
        if (type != null) {
            // add the type's package to the list of imports
            this.getImports().add(this.getPackage(type));

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
     * @return <code>true</code> if the name was found and written, <code>false</code> otherwise
     */
    private boolean buildName(ModelElement modelElement, StringBuilder builder) {
        String name = modelElement.getName();

        boolean isWritten = false;

        if ((name != null) && (name.trim().length() != 0)) {
            builder.append(name);
            isWritten = true;
        } else {
            this.getLog().log(LEVEL, "Missing method name");
        }

        return isWritten;
    }

    /**
     * Writes the name of the {@link ModelElement}'s {@link Stereotype}.
     *
     * @param modelElement
     *            {@link ModelElement} to get {@link Stereotype} from
     * @param name
     *            name of the {@link Stereotype}
     * @param builder
     *            {@link StringBuilder} to write the result to
     * @return <code>true</code> if the {@link Stereotype} has been written
     */
    private boolean buildStereoType(ModelElement modelElement, String name, StringBuilder builder) {
        boolean hasStereoType = this.hasStereoType(modelElement, name);

        if (hasStereoType) {
            builder.append(name).append(SPACE);
        }

        return hasStereoType;
    }

    /**
     * Creates the code for the return statement which represents the body content of the generated method. The
     * return has the form <code>    return type_default_value;</code>. If the given return parameter is
     * <code>null</code> or of type <code>void</code> no return statement is built.
     *
     * @param returnParameter
     *            The return parameter.
     * @param builder
     *            {@link StringBuilder} to write the result to
     */
    private void buildReturnStatement(Parameter returnParameter, StringBuilder builder) {
        if (returnParameter != null) {
            buildReturnStatement(returnParameter.getType(), builder);
        }
    }
}
