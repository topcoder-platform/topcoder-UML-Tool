package com.topcoder.gui.diagramviewer.uml.classelements.failuretests;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.DataType;
import com.topcoder.uml.model.core.classifiers.DataTypeImpl;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteral;
import com.topcoder.uml.model.core.classifiers.EnumerationLiteralImpl;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

/**
 * Defines utilities used in failure test cases.
 *
 * @author Yeung
 *
 */
public class FailureTestHelper {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private FailureTestHelper() {
    }

    /**
     * <p>
     * Creates a property with given key and value.
     * </p>
     *
     * @param key
     *            the property key
     * @param value
     *            the property value
     * @return a new property created
     */
    static Property createProperty(String key, String value) {
        Property p = new Property();
        p.setKey(key);
        p.setValue(value);
        return p;
    }

    /**
     * <p>
     * Creates a point for diagram element.
     * </p>
     *
     * @param x
     *            x coordinate
     * @param y
     *            y coordinate
     * @return a point for diagram element
     */
    static com.topcoder.diagraminterchange.Point createPoint(double x, double y) {
        com.topcoder.diagraminterchange.Point pos = new com.topcoder.diagraminterchange.Point();
        pos.setX(x);
        pos.setY(y);
        return pos;
    }

    /**
     * <p>
     * Creates a dimension for diagram element.
     * </p>
     *
     * @param width
     *            dimension width
     * @param height
     *            dimension height
     * @return a dimension for diagram element
     */
    static com.topcoder.diagraminterchange.Dimension createDimension(double width, double height) {
        com.topcoder.diagraminterchange.Dimension size = new com.topcoder.diagraminterchange.Dimension();
        size.setWidth(width);
        size.setHeight(height);
        return size;
    }

    /**
     * Gets the value of a private field in the given class. The field has the given name. The value is retrieved from
     * the given instance. If the instance is null, the field is a static field. If any error occurs, null is returned.
     *
     * @param type
     *            the class which the private field belongs to
     * @param instance
     *            the instance which the private field belongs to
     * @param name
     *            the name of the private field to be retrieved
     * @return the value of the private field
     */
    static Object getPrivateField(Class<?> type, Object instance, String name) {
        Field field = null;
        Object obj = null;
        try {
            // Get the reflection of the field
            field = type.getDeclaredField(name);
            // Set the field accessible.
            field.setAccessible(true);
            // Get the value
            obj = field.get(instance);
        } catch (NoSuchFieldException e) {
            // Ignore
        } catch (IllegalAccessException e) {
            // Ignore
        } finally {
            if (field != null) {
                // Reset the accessibility
                field.setAccessible(false);
            }
        }

        return obj;
    }

    /**
     * <p>
     * Sets the typeInfo of the <code>graphElement</code> to <code>typeInfo</code>.
     * </p>
     *
     * @param graphElement
     *            the <code>GraphElement</code> which typeInfo should be set.
     * @param typeInfo
     *            the typeInfo which should be set to the <code>graphElement</code>.
     */
    private static void setTypeInfo(GraphElement graphElement, String typeInfo) {
        SimpleSemanticModelElement simpleElement = new SimpleSemanticModelElement();
        simpleElement.setTypeInfo(typeInfo);
        graphElement.setSemanticModel(simpleElement);
    }

    /**
     * <p>
     * Sets the element of the <code>graphElement</code> to <code>element</code>.
     * </p>
     *
     * @param graphElement
     *            the <code>GraphElement</code> which element should be set.
     * @param element
     *            the element which should be set to the <code>graphElement</code>.
     */
    private static void setElement(GraphElement graphElement, Element element) {
        Uml1SemanticModelBridge uml1ModelBridge = new Uml1SemanticModelBridge();
        uml1ModelBridge.setElement(element);
        graphElement.setSemanticModel(uml1ModelBridge);
    }

    /**
     * <p>
     * Adds child to parent, and sets its container.
     * </p>
     *
     * @param parent
     *            parent graph element
     * @param child
     *            child graph element
     */
    private static void addContained(GraphElement parent, GraphElement child) {
        parent.addContained(child);
        child.setContainer(parent);
    }

    /**
     * <p>
     * Creates a valid stereotype compartment <code>GraphElement</code>.
     * </p>
     *
     * @param stereotypeName
     *            stereotype name
     * @param isInterface
     *            for InterfaceNode
     * @return a valid stereotype compartment <code>GraphElement</code>
     */
    private static GraphElement createStereotypeCompartment(String stereotypeName, boolean isInterface) {
        GraphNode node = new GraphNode();

        String[] stereotypes = stereotypeName.split(",");
        // create SimpleSemanticmodelElement.typeinfo = "StereotypeCompartment"
        setTypeInfo(node, "StereotypeCompartment");

        if (isInterface) {
            // create SimpleSemanticModelElement.typeInfo = "KeywordMetaclass"
            GraphElement keywordMetaclass = new GraphNode();
            setTypeInfo(keywordMetaclass, "KeywordMetaclass");
            addContained(node, keywordMetaclass);
        }

        // create SimpleSemanticModelElement.typeInfo = "StereotypeStart"
        GraphElement stereotypeStart = new GraphNode();
        setTypeInfo(stereotypeStart, "StereotypeStart");

        GraphNode[] elements = new GraphNode[stereotypes.length];
        for (int i = 0; i < stereotypes.length; i++) {
            String stereotype = stereotypes[i];
            // create SimpleSemanticModelElement.typeInfo = "Name"
            GraphElement name = new GraphNode();
            setTypeInfo(name, "Name");
            // create Uml1SemanticModelBridgeElement.element = <UML:Package>
            elements[i] = new GraphNode();
            ModelElement element = new StereotypeImpl();
            element.setName(stereotype);
            setElement(elements[i], element);
            addContained(elements[i], name);
        }

        // create SimpleSemanticModelElement.typeInfo = "StereotypeSeparator"
        GraphElement stereotypeSeparator = new GraphNode();
        setTypeInfo(stereotypeSeparator, "StereotypeSeparator");

        // create SimpleSemanticModelElement.typeInfo = "StereotypeEnd"
        GraphElement stereotypeEnd = new GraphNode();
        setTypeInfo(stereotypeEnd, "StereotypeEnd");

        // build correct structure
        addContained(node, stereotypeStart);
        if (stereotypes.length > 0) {
            addContained(node, elements[0]);
            for (int i = 1; i < stereotypes.length; i++) {
                addContained(node, stereotypeSeparator);
                addContained(node, elements[i]);
            }
        }
        addContained(node, stereotypeEnd);

        return node;
    }

    /**
     * <p>
     * Creates a valid namespace compartment <code>GraphElement</code>.
     * </p>
     *
     * @param namespace
     *            the namespace text to display
     * @return a valid namespace compartment <code>GraphElement</code>
     */
    private static GraphElement createNamespaceCompartment(String namespace) {
        GraphNode node = new GraphNode();

        String[] packageNames = namespace.split("\\.");

        // create SimpleSemanticmodelElement.typeinfo = "NamespaceCompartment"
        setTypeInfo(node, "NamespaceCompartment");

        // create SimpleSemanticModelElement.typeInfo = "NamespaceStart"
        GraphElement namespaceStart = new GraphNode();
        setTypeInfo(namespaceStart, "NamespaceStart");

        GraphNode[] packages = new GraphNode[packageNames.length];
        for (int i = 0; i < packageNames.length; i++) {
            String packageName = packageNames[i];
            // create SimpleSemanticModelElement.typeInfo = "Name"
            GraphElement name = new GraphNode();
            setTypeInfo(name, "Name");
            // create Uml1SemanticModelBridgeElement.element = <UML:Package>
            packages[i] = new GraphNode();
            ModelElement element = new PackageImpl();
            element.setName(packageName);
            setElement(packages[i], element);
            addContained(packages[i], name);
        }

        // create SimpleSemanticModelElement.typeInfo = "NamespaceSeparator"
        GraphElement namespaceSeparator = new GraphNode();
        setTypeInfo(namespaceSeparator, "NamespaceSeparator");

        // create SimpleSemanticModelElement.typeInfo = "NamespaceEnd"
        GraphElement namespaceEnd = new GraphNode();
        setTypeInfo(namespaceEnd, "NamespaceEnd");

        // build correct structure
        addContained(node, namespaceStart);
        if (packageNames.length > 0) {
            addContained(node, packages[0]);
            for (int i = 1; i < packageNames.length; i++) {
                addContained(node, namespaceSeparator);
                addContained(node, packages[i]);
            }
        }
        addContained(node, namespaceEnd);

        return node;
    }

    /**
     * <p>
     * Creates a valid name compartment <code>GraphElement</code> structure.
     * </p>
     *
     * @param stereotypeName
     *            stereotype name
     * @param namespace
     *            namespace
     * @param isInterface
     *            for InterfaceNode
     * @return a valid name compartment <code>GraphElement</code> structure
     */
    private static GraphElement createNameCompartment(String stereotypeName, String namespace, boolean isInterface) {
        GraphElement nameCompartment = new GraphNode();
        setTypeInfo(nameCompartment, "NameCompartment");

        // create SimpleSemanticmodelElement.typeinfo = "StereotypeCompartment"
        GraphElement stereotypeCompartment = createStereotypeCompartment(stereotypeName, isInterface);
        addContained(nameCompartment, stereotypeCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");
        addContained(nameCompartment, name);

        // create SimpleSemanticmodelElement.typeinfo = "NamespaceCompartment"
        GraphElement namespaceCompartment = createNamespaceCompartment(namespace);
        addContained(nameCompartment, namespaceCompartment);
        return nameCompartment;
    }

    /**
     * <p>
     * Creates a valid <code>GraphElement</code> for given element.
     * </p>
     *
     * @param element
     *            the ModelElement to create a container graph element
     * @return a valid <code>GraphElement</code> for given element
     */
    private static GraphElement createGraphElement(ModelElement element) {
        GraphElement graphElement = new GraphNode();
        setElement(graphElement, element);

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");
        addContained(graphElement, name);

        return graphElement;
    }

    /**
     * <p>
     * Creates an attribute.
     * </p>
     *
     * @param attributeName
     *            attribute name
     * @param typeName
     *            attribute type name
     * @return an attribute
     */
    private static Attribute createAttribute(String attributeName, String typeName) {
        Attribute attribute = new AttributeImpl();
        DataTypeImpl dataType = new DataTypeImpl();
        dataType.setName(typeName);
        attribute.setName(attributeName);
        attribute.setType(dataType);
        attribute.setVisibility(VisibilityKind.PRIVATE);
        return attribute;
    }

    /**
     * <p>
     * Creates a valid attribute <code>GraphElement</code>.
     * </p>
     *
     * @param attributeName
     *            attribute name
     * @param typeName
     *            attribute type
     * @return a valid attribute <code>GraphElement</code>
     */
    private static GraphElement createAttributeGraphElement(String attributeName, String typeName) {
        GraphElement attribute = new GraphNode();
        ModelElement element = new AttributeImpl();
        element.setName(attributeName);
        setElement(attribute, element);

        // create SimpleSemanticmodelElement.typeinfo = "StereotypeCompartment"
        GraphElement stereotypeCompartment = createStereotypeCompartment("", false);
        addContained(attribute, stereotypeCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "Visibility"
        GraphElement visibility = new GraphNode();
        setTypeInfo(visibility, "Visibility");
        addContained(attribute, visibility);

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");
        addContained(attribute, name);

        // create SimpleSemanticmodelElement.typeinfo = "TypeSeparator"
        GraphElement typeSeparator = new GraphNode();
        setTypeInfo(typeSeparator, "TypeSeparator");
        addContained(attribute, typeSeparator);

        // create SimpleSemanticmodelElement.typeinfo = "StructuralFeatureType"
        GraphElement structuralFeatureType = new GraphNode();
        setTypeInfo(structuralFeatureType, "StructuralFeatureType");
        addContained(attribute, structuralFeatureType);

        // create Uml1SemanticModelBridge.element = <UML:DataType>
        DataType type = new DataTypeImpl();
        type.setName(typeName);
        GraphElement dataType = createGraphElement(type);
        addContained(structuralFeatureType, dataType);

        // create SimpleSemanticmodelElement.typeinfo = "MultiplicityStart"
        GraphElement multiplicityStart = new GraphNode();
        setTypeInfo(multiplicityStart, "MultiplicityStart");
        addContained(attribute, multiplicityStart);

        // create SimpleSemanticmodelElement.typeinfo = "Multiplicity"
        GraphElement multiplicity = new GraphNode();
        setTypeInfo(multiplicity, "Multiplicity");
        addContained(attribute, multiplicity);

        // create SimpleSemanticmodelElement.typeinfo = "Ordering"
        GraphElement ordering = new GraphNode();
        setTypeInfo(ordering, "Ordering");
        addContained(attribute, ordering);

        // create SimpleSemanticmodelElement.typeinfo = "MultiplicityEnd"
        GraphElement multiplicityEnd = new GraphNode();
        setTypeInfo(multiplicityEnd, "MultiplicityEnd");
        addContained(attribute, multiplicityEnd);

        // create SimpleSemanticmodelElement.typeinfo = "InitialValueSeparator"
        GraphElement initialValueSeparator = new GraphNode();
        setTypeInfo(initialValueSeparator, "InitialValueSeparator");
        addContained(attribute, initialValueSeparator);

        // create SimpleSemanticmodelElement.typeinfo = "InitialValue"
        GraphElement initialValue = new GraphNode();
        setTypeInfo(initialValue, "InitialValue");
        addContained(attribute, initialValue);

        return attribute;
    }

    /**
     * <p>
     * Creates a valid attribute compartment <code>GraphNode</code> structure.
     * </p>
     *
     * @param element
     *            model element to add attributes
     * @param isInterface
     *            for InterfaceNode
     * @return a valid attribute compartment <code>GraphNode</code> structure
     */
    private static GraphElement createAttributeCompartment(Classifier element, boolean isInterface) {
        GraphElement attributeCompartment = new GraphNode();
        setTypeInfo(attributeCompartment, "AttributeCompartment");

        // create SimpleSemanticmodelElement.typeinfo = "DelimitedSection"
        GraphElement delimitedSection = new GraphNode();
        setTypeInfo(delimitedSection, "DelimitedSection");
        addContained(attributeCompartment, delimitedSection);

        if (!isInterface) {
            element.addFeature(createAttribute("attribute_1", "int"));
            addContained(delimitedSection, createAttributeGraphElement("attribute_1", "int"));
            element.addFeature(createAttribute("attribute_2", "float"));
            addContained(delimitedSection, createAttributeGraphElement("attribute_2", "float"));
            element.addFeature(createAttribute("attribute_3", "String"));
            addContained(delimitedSection, createAttributeGraphElement("attribute_3", "String"));
        }
        return attributeCompartment;
    }

    /**
     * <p>
     * Creates a valid <code>GraphElement</code> for Parameter.
     * </p>
     *
     * @param parameterName
     *            parameter name
     * @param typeName
     *            data type name
     * @param isReturn
     *            whether this is a return parameter
     * @return a valid <code>GraphElement</code> for Parameter
     */
    private static GraphElement createParameterGraphElement(String parameterName, String typeName, boolean isReturn) {
        GraphElement graphElement = new GraphNode();
        Parameter parameter = new ParameterImpl();
        parameter.setName(parameterName);
        setElement(graphElement, parameter);

        if (!isReturn) {
            // create SimpleSemanticmodelElement.typeinfo = "Name"
            GraphElement name = new GraphNode();
            setTypeInfo(name, "Name");
            addContained(graphElement, name);

            // create SimpleSemanticmodelElement.typeinfo = "TypeSeparator"
            GraphElement typeSeparator = new GraphNode();
            setTypeInfo(typeSeparator, "TypeSeparator");
            addContained(graphElement, typeSeparator);
        }

        ModelElement type = new DataTypeImpl();
        type.setName(typeName);
        addContained(graphElement, createGraphElement(type));

        return graphElement;
    }

    /**
     * <p>
     * Creates a valid operation <code>GraphElement</code>.
     * </p>
     *
     * @param operationName
     *            operation name
     * @param returnType
     *            return type
     * @param parameterName
     *            parameter name
     * @param parameterType
     *            parameter type
     * @return a valid operation <code>GraphElement</code>
     */
    static GraphElement createOperationGraphElement(String operationName, String returnType, String parameterName,
            String parameterType) {
        GraphElement operationGraphElement = new GraphNode();
        ModelElement element = new OperationImpl();
        element.setName(operationName);
        setElement(operationGraphElement, element);

        // create SimpleSemanticmodelElement.typeinfo = "StereotypeCompartment"
        GraphElement stereotypeCompartment = createStereotypeCompartment("", false);
        addContained(operationGraphElement, stereotypeCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "Visibility"
        GraphElement visibility = new GraphNode();
        setTypeInfo(visibility, "Visibility");
        addContained(operationGraphElement, visibility);

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");
        addContained(operationGraphElement, name);

        // create SimpleSemanticmodelElement.typeinfo = "ParameterStart"
        GraphElement parameterStart = new GraphNode();
        setTypeInfo(parameterStart, "ParameterStart");
        addContained(operationGraphElement, parameterStart);

        // create Uml1SemanticModelBridge.element = <UML:Parameter>
        GraphElement parameter = createParameterGraphElement(parameterName, parameterType, false);
        addContained(parameterStart, parameter);

        // create SimpleSemanticmodelElement.typeinfo = "ParameterEnd"
        GraphElement parameterEnd = new GraphNode();
        setTypeInfo(parameterEnd, "ParameterEnd");
        addContained(operationGraphElement, parameterEnd);

        // create SimpleSemanticmodelElement.typeinfo = "TypeSeparator"
        GraphElement typeSeparator = new GraphNode();
        setTypeInfo(typeSeparator, "TypeSeparator");
        addContained(operationGraphElement, typeSeparator);

        // create Uml1SemanticModelBridge.element = <UML:Parameter>
        GraphElement returnParameter = createParameterGraphElement("", returnType, true);
        addContained(operationGraphElement, returnParameter);

        return operationGraphElement;
    }

    /**
     * <p>
     * Creates an operation.
     * </p>
     *
     * @param name
     *            operation name
     * @param returnType
     *            return type
     * @param parameterName
     *            parameter name
     * @param parameterType
     *            parameter type
     * @return an operation
     */
    static Operation createOperation(String name, String returnType, String parameterName, String parameterType) {
        Operation operation = new OperationImpl();
        operation.setName(name);

        Parameter parameter = new ParameterImpl();
        parameter.setName(parameterName);
        DataType dataType = new DataTypeImpl();
        dataType.setName(parameterType);
        parameter.setType(dataType);
        parameter.setKind(ParameterDirectionKind.IN);
        operation.addParameter(parameter);

        parameter = new ParameterImpl();
        dataType = new DataTypeImpl();
        dataType.setName(returnType);
        parameter.setType(dataType);
        parameter.setKind(ParameterDirectionKind.RETURN);
        operation.addParameter(parameter);

        operation.setVisibility(VisibilityKind.PUBLIC);

        return operation;
    }

    /**
     * <p>
     * Creates a valid operation compartment <code>GraphNode</code> structure.
     * </p>
     *
     * @param element
     *            model element to add operations
     * @return a valid operation compartment <code>GraphNode</code> structure
     */
    private static GraphElement createOperationCompartment(Classifier element) {
        GraphElement operationCompartment = new GraphNode();
        setTypeInfo(operationCompartment, "OperationCompartment");

        // create SimpleSemanticmodelElement.typeinfo = "DelimitedSection"
        GraphElement delimitedSection = new GraphNode();
        setTypeInfo(delimitedSection, "DelimitedSection");
        addContained(operationCompartment, delimitedSection);

        element.addFeature(createOperation("operation_1", "int", "parameter_1", "int"));
        addContained(delimitedSection, createOperationGraphElement("operation_1", "int", "parameter_1", "int"));
        element.addFeature(createOperation("operation_2", "float", "parameter_2", "double"));
        addContained(delimitedSection, createOperationGraphElement("operation_2", "float", "parameter_2", "double"));
        element.addFeature(createOperation("operation_3", "String", "parameter_3", "float"));
        addContained(delimitedSection, createOperationGraphElement("operation_3", "String", "parameter_3", "float"));
        return operationCompartment;
    }

    /**
     * <p>
     * Creates an enumeration literal.
     * </p>
     *
     * @param literalName
     *            enumeration literal name
     * @return an enumeration literal
     */
    private static EnumerationLiteral createEnumerationLiteral(String literalName) {
        EnumerationLiteral literal = new EnumerationLiteralImpl();
        literal.setName(literalName);
        literal.setVisibility(VisibilityKind.PUBLIC);
        return literal;
    }

    /**
     * <p>
     * Creates a valid enumeration literal <code>GraphElement</code>.
     * </p>
     *
     * @param literalName
     *            enumeration literal name
     * @return a valid enumeration literal <code>GraphElement</code>
     */
    private static GraphElement createLiteralGraphElement(String literalName) {
        GraphElement literalGraphElement = new GraphNode();
        ModelElement element = new EnumerationLiteralImpl();
        element.setName(literalName);
        setElement(literalGraphElement, element);

        // create SimpleSemanticmodelElement.typeinfo = "StereotypeCompartment"
        GraphElement stereotypeCompartment = createStereotypeCompartment("", false);
        addContained(literalGraphElement, stereotypeCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");
        addContained(literalGraphElement, name);

        return literalGraphElement;
    }

    /**
     * <p>
     * Creates a valid enumeration literal compartment <code>GraphNode</code> structure.
     * </p>
     *
     * @param element
     *            model element to add literals
     * @return a valid enumeration literal compartment <code>GraphNode</code> structure
     */
    private static GraphElement createEnumerationLiteralCompartment(Enumeration element) {
        GraphElement literalCompartment = new GraphNode();
        setTypeInfo(literalCompartment, "EnumerationLiteralCompartment");

        // create SimpleSemanticmodelElement.typeinfo = "DelimitedSection"
        GraphElement delimitedSection = new GraphNode();
        setTypeInfo(delimitedSection, "DelimitedSection");
        addContained(literalCompartment, delimitedSection);

        element.addLiteral(createEnumerationLiteral("TYPE_1"));
        addContained(delimitedSection, createLiteralGraphElement("TYPE_1"));
        element.addLiteral(createEnumerationLiteral("TYPE_2"));
        addContained(delimitedSection, createLiteralGraphElement("TYPE_2"));
        element.addLiteral(createEnumerationLiteral("TYPE_3"));
        addContained(delimitedSection, createLiteralGraphElement("TYPE_3"));
        return literalCompartment;
    }

    /**
     * <p>
     * Creates a valid <code>GraphNode</code> for PackageNode.
     * </p>
     *
     * @param position
     *            the absolute position of the node
     * @param size
     *            the size of the node
     * @return a valid <code>GraphNode</code> for PackageNode
     */
    static GraphNode createPackageGraphNode(Point position, Dimension size) {

        GraphNode node = new GraphNode();

        com.topcoder.diagraminterchange.Dimension sizeTC = new com.topcoder.diagraminterchange.Dimension();
        sizeTC.setHeight(size.height);
        sizeTC.setWidth(size.width);

        com.topcoder.diagraminterchange.Point positionTC = new com.topcoder.diagraminterchange.Point();
        positionTC.setX(position.x);
        positionTC.setY(position.y);

        // set size and position
        node.setSize(sizeTC);
        node.setPosition(positionTC);

        Package element = new PackageImpl();
        // set nameCompartment text
        element.setName("Name");

        // set stereotypeCompartment text
        Stereotype stereotypeOne = new StereotypeImpl();
        stereotypeOne.setName("stereotype");
        element.addStereotype(stereotypeOne);

        // set namespaceCompartment text
        addNamespace(element, "com.topcoder.gui.diagramviewer.uml.classelements");

        // Uml1SemanticModelBridge.element = <UML:Package>
        setElement(node, element);

        // create SimpleSemanticmodelElement.typeinfo = "NameCompartment"
        GraphElement nameCompartment = createNameCompartment("Stereotype",
                "com.topcoder.gui.diagramviewer.uml.classelements", false);
        addContained(node, nameCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "BodyCompartment"
        GraphElement bodyCompartment = new GraphNode();
        setTypeInfo(bodyCompartment, "BodyCompartment");
        addContained(node, bodyCompartment);

        // create properties
        node.addProperty(createProperty("STROKE_COLOR", "000000"));
        node.addProperty(createProperty("FILL_COLOR", "FFFF00"));
        node.addProperty(createProperty("FONT_COLOR", "000000"));
        node.addProperty(createProperty("FONT_FAMILY", "Arial"));
        node.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        node.addProperty(createProperty("FONT_SIZE", "10"));

        return node;
    }

    /**
     * <p>
     * Creates a valid <code>GraphNode</code> for ClassNode.
     * </p>
     *
     * @param position
     *            the absolute position of the node
     * @param size
     *            the size of the node
     * @param isInterface
     *            for InterfaceNode
     * @param isException
     *            for ExeceptionNode
     * @return a valid <code>GraphNode</code> for ClassNode
     */
    public static GraphNode createClassGraphNode(Point position, Dimension size, boolean isInterface,
            boolean isException) {

        GraphNode node = new GraphNode();

        com.topcoder.diagraminterchange.Dimension sizeTC = new com.topcoder.diagraminterchange.Dimension();
        sizeTC.setHeight(size.height);
        sizeTC.setWidth(size.width);

        com.topcoder.diagraminterchange.Point positionTC = new com.topcoder.diagraminterchange.Point();
        positionTC.setX(position.x);
        positionTC.setY(position.y);

        // set size and position
        node.setSize(sizeTC);
        node.setPosition(positionTC);

        Classifier element;
        if (isInterface) {
            element = new InterfaceImpl();
        } else {
            element = new ClassImpl();
        }

        // set stereotypeCompartment text
        String stereotypeName;
        if (isInterface) {
            stereotypeName = "interface";
        } else if (isException) {
            stereotypeName = "exception";
        } else {
            stereotypeName = "stereotype";
        }
        Stereotype stereotypeOne = new StereotypeImpl();
        stereotypeOne.setName(stereotypeName);
        element.addStereotype(stereotypeOne);

        // set nameCompartment text
        element.setName("Name");

        // set namespaceCompartment text
        addNamespace(element, "com.topcoder.gui.diagramviewer.uml.classelements");

        // create SimpleSemanticmodelElement.typeinfo = "NameCompartment"
        GraphElement nameCompartment = createNameCompartment(stereotypeName,
                "com.topcoder.gui.diagramviewer.uml.classelements", isInterface);
        addContained(node, nameCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "CompartmentSeparator"
        GraphElement compartmentSeparator = new GraphNode();
        setTypeInfo(compartmentSeparator, "CompartmentSeparator");
        addContained(node, compartmentSeparator);

        // create SimpleSemanticmodelElement.typeinfo = "AttributeCompartment"
        GraphElement attributeCompartment = createAttributeCompartment(element, isInterface);
        addContained(node, attributeCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "CompartmentSeparator"
        addContained(node, compartmentSeparator);

        // create SimpleSemanticmodelElement.typeinfo = "OperationCompartment"
        GraphElement operationCompartment = createOperationCompartment(element);
        addContained(node, operationCompartment);

        // Uml1SemanticModelBridge.element = <UML:Interface> or <UML:Class>
        setElement(node, element);

        // create properties
        node.addProperty(createProperty("STROKE_COLOR", "000000"));
        if (isInterface) {
            node.addProperty(createProperty("FILL_COLOR", "0000FF"));
        } else if (isException) {
            node.addProperty(createProperty("FILL_COLOR", "FF0000"));
        } else {
            node.addProperty(createProperty("FILL_COLOR", "00FF00"));
        }
        node.addProperty(createProperty("FONT_COLOR", "000000"));
        node.addProperty(createProperty("FONT_FAMILY", "Arial"));
        node.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        node.addProperty(createProperty("FONT_SIZE", "10"));

        return node;
    }

    /**
     * <p>
     * Creates a valid <code>GraphNode</code> for EnumerationNode.
     * </p>
     *
     * @param position
     *            the absolute position of the node
     * @param size
     *            the size of the node
     * @return a valid <code>GraphNode</code> for EnumerationNode
     */
    static GraphNode createEnumerationGraphNode(Point position, Dimension size) {

        GraphNode node = new GraphNode();

        com.topcoder.diagraminterchange.Dimension sizeTC = new com.topcoder.diagraminterchange.Dimension();
        sizeTC.setHeight(size.height);
        sizeTC.setWidth(size.width);

        com.topcoder.diagraminterchange.Point positionTC = new com.topcoder.diagraminterchange.Point();
        positionTC.setX(position.x);
        positionTC.setY(position.y);

        // set size and position
        node.setSize(sizeTC);
        node.setPosition(positionTC);

        Enumeration element = new EnumerationImpl();

        // set stereotypeCompartment text
        Stereotype stereotypeOne = new StereotypeImpl();
        stereotypeOne.setName("Enum");
        element.addStereotype(stereotypeOne);

        // set nameCompartment text
        element.setName("Name");

        // set namespaceCompartment text
        addNamespace(element, "com.topcoder.gui.diagramviewer.uml.classelements");

        // create SimpleSemanticmodelElement.typeinfo = "NameCompartment"
        GraphElement nameCompartment = createNameCompartment("Enumeration",
                "com.topcoder.gui.diagramviewer.uml.classelements", false);
        addContained(node, nameCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "CompartmentSeparator"
        GraphElement compartmentSeparator = new GraphNode();
        setTypeInfo(compartmentSeparator, "CompartmentSeparator");
        addContained(node, compartmentSeparator);

        // create SimpleSemanticmodelElement.typeinfo = "EnumerationLiteralCompartment"
        GraphElement literalCompartment = createEnumerationLiteralCompartment(element);
        addContained(node, literalCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "CompartmentSeparator"
        addContained(node, compartmentSeparator);

        // create SimpleSemanticmodelElement.typeinfo = "AttributeCompartment"
        GraphElement attributeCompartment = createAttributeCompartment(element, false);
        addContained(node, attributeCompartment);

        // create SimpleSemanticmodelElement.typeinfo = "CompartmentSeparator"
        addContained(node, compartmentSeparator);

        // create SimpleSemanticmodelElement.typeinfo = "OperationCompartment"
        GraphElement operationCompartment = createOperationCompartment(element);
        addContained(node, operationCompartment);

        // Uml1SemanticModelBridge.element = <UML:Enumeration>
        setElement(node, element);

        // create properties
        node.addProperty(createProperty("STROKE_COLOR", "000000"));
        node.addProperty(createProperty("FILL_COLOR", "9932CD"));
        node.addProperty(createProperty("FONT_COLOR", "000000"));
        node.addProperty(createProperty("FONT_FAMILY", "Arial"));
        node.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        node.addProperty(createProperty("FONT_SIZE", "10"));

        return node;
    }

    /**
     * <p>
     * Creates a valid property mapping.
     * </p>
     *
     * @return a <code>Map</code> of properties key, value pairs.
     */
    public static Map<String, String> createProperties() {

        Map<String, String> properties = new HashMap<String, String>();

        properties.put("FillColor", "FILL_COLOR");
        properties.put("StrokeColor", "STROKE_COLOR");
        properties.put("FontColor", "FONT_COLOR");
        properties.put("FontFamily", "FONT_FAMILY");
        properties.put("FontStyle", "FONT_STYLE");
        properties.put("FontSize", "FONT_SIZE");

        return properties;
    }

    /**
     * <p>
     * Adds namespace to the model element.
     * </p>
     *
     * @param modelElement
     *            the <code>ModelElement</code> where the namespace is added to
     * @param namespaceText
     *            the text of the added namespace
     */
    private static void addNamespace(ModelElement modelElement, String namespaceText) {
        String[] packageNames = namespaceText.split("\\.");
        Namespace namespace = new MockedNamespaceImpl();
        for (String packageName : packageNames) {
            Package element = new PackageImpl();
            element.setName(packageName);
            namespace.addOwnedElement(element);
        }
        modelElement.setNamespace(namespace);
    }

    /**
     * This class extends NamespaceAbstractImpl. It is used for testing.
     *
     * @author Yeung
     * @version 1.0
     */
    private static class MockedNamespaceImpl extends NamespaceAbstractImpl {

        /**
         * <p>
         * Empty constructor.
         * </p>
         */
        public MockedNamespaceImpl() {
        }
    }
}


