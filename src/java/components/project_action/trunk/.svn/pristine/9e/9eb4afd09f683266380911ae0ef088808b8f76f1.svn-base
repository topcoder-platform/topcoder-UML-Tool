/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.project;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.TransformerConfigurationException;

import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.XMIReaderConfigException;
import com.topcoder.xmi.reader.handlers.diagraminterchange.DiagramInterchangeXMIHandler;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;
import com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler;
import com.topcoder.xmi.reader.handlers.uml.model.XMI2ModelHandler;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.Diagram2XMITransformer;
import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.BezierPointTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.CoreSemanticModelBridgeTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramLinkTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DiagramTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.DimensionTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.EllipseTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphConnectorTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphEdgeTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphNodeTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.GraphicPrimitiveTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.ImageTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.LeafElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PointTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PolylineTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PropertyTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.ReferenceTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.SemanticModelBridgeTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.SimpleSemanticModelElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.TextElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.Uml1SemanticModelBridgeTransformer;
import com.topcoder.xmi.writer.transformers.model.ConfigurationException;
import com.topcoder.xmi.writer.transformers.model.Model2XMITransformer;

/**
 * This class has all the static variables and repeated codes that can be used across.
 * <p>
 * <Strong>Thread Safety :</Strong> This class has all final variables hence immutable.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class Helper {

    /**
     * Represents the "ProjectLanguage" value to be used.
     */
    public static final String PROJECT_LANGUAGE = "ProjectLanguage";

    /**
     * Private empty constructor.
     */
    private Helper() {
    }

    /**
     * Check if the object is <code>null</code>.
     *
     * @param obj
     *            the object to check.
     * @param name
     *            the object name
     * @throws IllegalArgumentException
     *             if the object is <code>null</code>.
     */
    public static void checkObjectNotNull(Object obj, String name) {
        if (obj == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * <p>
     * Check if the object list is <code>null</code>, empty or any element inside the object list is
     * <code>null</code>.
     * </p>
     * <p>
     * If the given list contains <code>String</code>, then it also check whether the string is empty.
     * </p>
     *
     * @param obj
     *            the object list to check.
     * @param name
     *            the object name
     * @throws IllegalArgumentException
     *             if the object list is <code>null</code> or any element inside is.
     */
    public static void checkObjectListNotNull(List obj, String name) {
        checkObjectNotNull(obj, name);
        if (obj.isEmpty()) {
            throw new IllegalArgumentException(name + " should not be empty");
        }
        for (Object object : obj) {
            if (object instanceof String) {
                checkStringNotNullOrEmpty((String) object, "Element inside list " + name);
            } else {
                checkObjectNotNull(object, "Element inside list " + name);
            }
        }
    }

    /**
     * Check if the string is <code>null</code> or empty.
     *
     * @param str
     *            the string to check.
     * @param name
     *            the parameter name.
     * @return String which is valid, same as input
     * @throws IllegalArgumentException
     *             if the string is <code>null</code> or empty.
     */
    public static String checkStringNotNullOrEmpty(String str, String name) {
        checkObjectNotNull(str, name);

        if (str.trim().length() == 0) {
            throw new IllegalArgumentException(name + " should not be empty.");
        }
        return str;
    }

    /**
     * <p>
     * Loads the XMI file present in the stream into the model manager using the XMI reader.
     * </p>
     *
     * @param modelManager
     *            which will hold the parsed XMI file.
     * @param stream
     *            which contains the XMI file in the form of stream
     * @param configManager
     *            to get the default language
     * @throws ActionExecutionException
     *             any exception while parsing the file
     */
    public static void loadXMIFile(UMLModelManager modelManager, InputStream stream,
            ProjectConfigurationManager configManager) throws ActionExecutionException {
        try {
            // create a XMI reader
            XMIReader reader = new XMIReader();
            // // create handlers with the given model manager
            // XMI2ModelHandler modelHandler = new XMI2ModelHandler(reader, new ModelElementFactory(
            // "com.topcoder.xmi.reader.XMIReader_activityGraph"), modelManager);
            // ActivityGraphXMIHandler graphHandler = new ActivityGraphXMIHandler(reader, new ModelElementFactory(
            // "com.topcoder.xmi.reader.XMIReader_diagramInterchange"), modelManager);
            // DiagramInterchangeXMIHandler diagramHandler = new DiagramInterchangeXMIHandler(reader,
            // new ModelElementFactory("com.topcoder.xmi.reader.XMIReader_model"), modelManager);

            // create handlers with the given model manager
            XMI2ModelHandler modelHandler = new XMI2ModelHandler(reader, new ModelElementFactory(
                    "com.topcoder.xmi.reader.XMIReader_model"), modelManager);
            ActivityGraphXMIHandler graphHandler = new ActivityGraphXMIHandler(reader, new ModelElementFactory(
                    "com.topcoder.xmi.reader.XMIReader_activityGraph"), modelManager);
            DiagramInterchangeXMIHandler diagramHandler = new DiagramInterchangeXMIHandler(reader,
                    new ModelElementFactory("com.topcoder.xmi.reader.XMIReader_diagramInterchange"), modelManager);

            // add all the created handlers to the reader
            reader.addHandler(modelHandler.getClass().getName(), modelHandler);
            reader.addHandler(graphHandler.getClass().getName(), graphHandler);
            reader.addHandler(diagramHandler.getClass().getName(), diagramHandler);

            // parse the stream and populate the model manager
            reader.parse(stream);

            // get the created model
            Model model = modelManager.getModel();
            Collection<TaggedValue> list = model.getTaggedValues();
            // run through the list of tagged values
            for (TaggedValue element : list) {
                // if there is a value with tag type ProjectLanguage
                if (element.getType() != null && element.getType().getTagType().equals(PROJECT_LANGUAGE)
                        && element.getDataValue() != null) {
                    // set the language to the model manager
                    modelManager.setProjectLanguage(element.getDataValue());
                    return;
                }
            }
            // if there is no project language present
            // get the default language from the config manager
            String projectLanguage = configManager.getDefaultProjectLanguage();
            // create a new tag definition with ProjectLanguage as type
            TagDefinition tagDefinition = new TagDefinitionImpl();
            tagDefinition.setTagType(PROJECT_LANGUAGE);
            // create a tagged value with the project language as data and type as tag definition.
            TaggedValue taggedValue = new TaggedValueImpl();
            taggedValue.setDataValue(projectLanguage);
            taggedValue.setType(tagDefinition);
            // add the tagged value to the model manager
            model.addTaggedValue(taggedValue);
            // set the project language
            modelManager.setProjectLanguage(projectLanguage);
        } catch (XMIReaderConfigException e) {
            throw new ActionExecutionException("Occurred while parsing the .xmi file", e);
        } catch (Exception e) {
            throw new ActionExecutionException("Occurred while loading the data from the XMI file", e);
        }
    }

    /**
     * <p>
     * This method returns a map with all the transformer types and the corresponding object. This is used to
     * instantiate the XMI writer instance.
     * </p>
     *
     * @return the transformers containing all the required transformer types.
     */
    public static Map<TransformerType, XMITransformer> xmiTransformers() {
        Map<TransformerType, XMITransformer> transformers = new HashMap<TransformerType, XMITransformer>();

        // put all the required transformers
        // FIXED
        Model2XMITransformer model2XMITransformer = null;
        try {
            model2XMITransformer = new Model2XMITransformer(Model2XMITransformer.class.getName());
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        transformers.put(TransformerType.ActivityGraph, model2XMITransformer);
        transformers.put(TransformerType.Model, model2XMITransformer);

        // added
        // Element Transformer setup:
        Map<String, DiagramInterchangeElementTransformer> transMap = new HashMap<String, DiagramInterchangeElementTransformer>();
        String base = "com.topcoder.diagraminterchange.";
        transMap.put(base + "Property", new PropertyTransformer());
        transMap.put(base + "DiagramElement", new DiagramElementTransformer());
        transMap.put(base + "Reference", new ReferenceTransformer());
        transMap.put(base + "DiagramLink", new DiagramLinkTransformer());
        transMap.put(base + "GraphNode", new GraphNodeTransformer());
        transMap.put(base + "GraphElement", new GraphElementTransformer());
        transMap.put(base + "GraphEdge", new GraphEdgeTransformer());
        transMap.put(base + "GraphConnector", new GraphConnectorTransformer());
        transMap.put(base + "Diagram", new DiagramTransformer());
        transMap.put(base + "SemanticModelBridge", new SemanticModelBridgeTransformer());
        transMap.put(base + "SimpleSemanticModelElement", new SimpleSemanticModelElementTransformer());
        transMap.put(base + "Uml1SemanticModelBridge", new Uml1SemanticModelBridgeTransformer());
        transMap.put(base + "CoreSemanticModelBridge", new CoreSemanticModelBridgeTransformer());
        transMap.put(base + "LeafElement", new LeafElementTransformer());
        transMap.put(base + "Image", new ImageTransformer());
        transMap.put(base + "BezierPoint", new BezierPointTransformer());
        transMap.put(base + "GraphicPrimitive", new GraphicPrimitiveTransformer());
        transMap.put(base + "Polyline", new PolylineTransformer());
        transMap.put(base + "Ellipse", new EllipseTransformer());
        transMap.put(base + "Point", new PointTransformer());
        transMap.put(base + "Dimension", new DimensionTransformer());
        transMap.put(base + "TextElement", new TextElementTransformer());

        Map<String, String> tagNameMappings = createTagNameMappings();

        try {
            transformers.put(TransformerType.Diagram, new Diagram2XMITransformer(transMap, tagNameMappings));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        return transformers;
    }

    /**
     * <p>
     * Creates the Map of tag name mappings.
     * </p>
     *
     * @return the map of tag name mappings.
     */
    private static Map<String, String> createTagNameMappings() {
        Map<String, String> tagNameMappings = new HashMap<String, String>();
        tagNameMappings.put("com.topcoder.uml.model.modelmanagement.ModelImpl", "UML:Model");
        tagNameMappings.put("com.topcoder.uml.model.modelmanagement.SubsystemImpl", "UML:Subsystem");
        tagNameMappings.put("com.topcoder.uml.model.modelmanagement.PackageImpl", "UML:Package");
        tagNameMappings.put("ccom.topcoder.uml.model.modelmanagement.ElementImportImpl", "UML:ElementImport");
        // Use case
        tagNameMappings.put("com.topcoder.uml.model.usecases.ActorImpl", "UML:Actor");
        tagNameMappings.put("com.topcoder.uml.model.usecases.UseCaseImpl", "UML:UseCase");
        tagNameMappings.put("com.topcoder.uml.model.usecases.IncludeImpl", "UML:Include");
        tagNameMappings.put("com.topcoder.uml.model.usecases.ExtendImpl", "UML:Extend");

        tagNameMappings.put("com.topcoder.uml.model.datatypes.MultiplicityImpl", "UML:Multiplicity");
        tagNameMappings.put("com.topcoder.uml.model.datatypes.MultiplicityRangeImpl", "UML:MultiplicityRange");
        tagNameMappings.put("com.topcoder.uml.model.datatypes.expressions.ExpressionImpl", "UML:Expression");
        tagNameMappings.put("com.topcoder.uml.model.datatypes.expressions.BooleanExpressionImpl",
                "UML:BooleanExpression");
        tagNameMappings.put("com.topcoder.uml.model.datatypes.expressions.MappingExpressionImpl",
                "UML:MappingExpression");
        tagNameMappings.put("com.topcoder.uml.model.datatypes.expressions.ProcedureExpressionImpl",
                "UML:ProcedureExpression");
        tagNameMappings.put("com.topcoder.uml.model.datatypes.expressions.TypeExpressionImpl", "UML:TypeExpression");

        tagNameMappings.put("com.topcoder.uml.model.core.dependencies.AbstractionImpl", "UML:Abstraction");
        tagNameMappings.put("com.topcoder.uml.model.core.dependencies.BindingImpl", "UML:Binding");
        tagNameMappings.put("com.topcoder.uml.model.core.dependencies.DependencyImpl", "UML:Dependency");
        tagNameMappings.put("com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl", "UML:Stereotype");
        tagNameMappings.put("com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl", "UML:TagDefinition");
        tagNameMappings.put("com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl", "UML:TaggedValue");
        tagNameMappings.put("com.topcoder.uml.model.core.dependencies.UsageImpl", "UML:Usage");

        tagNameMappings.put("com.topcoder.uml.model.core.relationships.AssociationImpl", "UML:Association");
        tagNameMappings.put("com.topcoder.uml.model.core.relationships.AssociationClassImpl", "UML:AssociationClass");
        tagNameMappings.put("com.topcoder.uml.model.core.relationships.AssociationEndImpl", "UML:AssociationEnd");
        tagNameMappings.put("com.topcoder.uml.model.core.relationships.GeneralizationImpl", "UML:Generalization");

        tagNameMappings.put("com.topcoder.uml.model.core.auxiliaryelements.CommentImpl", "UML:Comment");
        tagNameMappings.put("com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl",
                "UML:TemplateParameter");
        tagNameMappings.put("com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl",
                "UML:TemplateArgument");

        tagNameMappings.put("com.topcoder.uml.model.core.classifiers.ClassImpl", "UML:Class");
        tagNameMappings.put("com.topcoder.uml.model.core.classifiers.DataTypeImpl", "UML:DataType");
        tagNameMappings.put("com.topcoder.uml.model.core.classifiers.EnumerationImpl", "UML:Enumeration");
        tagNameMappings.put("com.topcoder.uml.model.core.classifiers.EnumerationLiteralImpl", "UML:EnumerationLiteral");
        tagNameMappings.put("com.topcoder.uml.model.core.classifiers.InterfaceImpl", "UML:Interface");
        tagNameMappings.put("com.topcoder.uml.model.core.classifiers.PrimitiveImpl", "UML:Primitive");
        tagNameMappings.put("com.topcoder.uml.model.core.classifiers.ProgrammingLanguageDataTypeImpl",
                "UML:ProgrammingLanguageDataType");

        tagNameMappings.put("com.topcoder.uml.model.core.AttributeImpl", "UML:Attribute");
        tagNameMappings.put("com.topcoder.uml.model.core.OperationImpl", "UML:Operation");
        tagNameMappings.put("com.topcoder.uml.model.core.ParameterImpl", "UML:Parameter");
        tagNameMappings.put("com.topcoder.uml.model.core.MethodImpl", "UML:Method");

        tagNameMappings.put("com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl", "UML:Procedure");
        tagNameMappings.put("com.topcoder.uml.model.commonbehavior.instances.ObjectImpl", "UML:Object");
        tagNameMappings.put("com.topcoder.uml.model.commonbehavior.instances.StimulusImpl", "UML:Stimulus");
        tagNameMappings.put("com.topcoder.uml.model.commonbehavior.links.LinkImpl", "UML:Link");
        tagNameMappings.put("com.topcoder.uml.model.commonbehavior.links.LinkEndImpl", "UML:LinkEnd");

        tagNameMappings.put("com.topcoder.uml.model.collaborations.collaborationroles.MessageImpl", "UML:Message");
        tagNameMappings.put(
                "com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl",
                "UML:CollaborationInstanceSet");
        tagNameMappings.put("com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl",
                "UML:Collaboration");

        tagNameMappings.put("com.topcoder.uml.model.actions.messagingactions.CallOperationActionImpl",
                "UML:CallOperationAction");
        tagNameMappings.put("com.topcoder.uml.model.actions.messagingactions.SendSignalActionImpl",
                "UML:SendSignalAction");
        tagNameMappings.put("com.topcoder.uml.model.actions.objectactions.CreateObjectActionImpl",
                "UML:CreateObjectAction");
        tagNameMappings.put("com.topcoder.uml.model.actions.objectactions.DestroyObjectActionImpl",
                "UML:DestroyObjectAction");

        // Diagram Interchange
        tagNameMappings.put("com.topcoder.diagraminterchange.Property", "UML:Property");
        tagNameMappings.put("com.topcoder.diagraminterchange.Reference", "UML:Reference");
        tagNameMappings.put("com.topcoder.diagraminterchange.DiagramLink", "UML:DiagramLink");
        tagNameMappings.put("com.topcoder.diagraminterchange.GraphConnector", "UML:GraphConnector");
        tagNameMappings.put("com.topcoder.diagraminterchange.GraphEdge", "UML:GraphEdge");
        tagNameMappings.put("com.topcoder.diagraminterchange.Point", "UML:Point");
        tagNameMappings.put("com.topcoder.diagraminterchange.BezierPoint", "UML:BezierPoint");
        tagNameMappings.put("com.topcoder.diagraminterchange.Dimension", "UML:Dimension");
        tagNameMappings.put("com.topcoder.diagraminterchange.Polyline", "UML:Polyline");
        tagNameMappings.put("com.topcoder.diagraminterchange.TextElement", "UML:TextElement");
        tagNameMappings.put("com.topcoder.diagraminterchange.Image", "UML:Image");
        tagNameMappings.put("com.topcoder.diagraminterchange.Uml1SemanticModelBridge", "UML:Uml1SemanticModelBridge");
        tagNameMappings.put("com.topcoder.diagraminterchange.CoreSemanticModelBridge", "UML:CoreSemanticModelBridge");
        tagNameMappings.put("com.topcoder.diagraminterchange.SimpleSemanticModelElement",
                "UML:SimpleSemanticModelElement");
        tagNameMappings.put("com.topcoder.diagraminterchange.GraphNode", "UML:GraphNode");
        tagNameMappings.put("com.topcoder.diagraminterchange.Diagram", "UML:Diagram");
        tagNameMappings.put("com.topcoder.diagraminterchange.Ellipse", "UML:Ellipse");

        // Activity Diagram
        tagNameMappings.put("com.topcoder.uml.model.statemachines.StateMachineImpl", "UML:StateMachine");
        tagNameMappings.put("com.topcoder.uml.model.statemachines.TransitionImpl", "UML:Transition");
        tagNameMappings.put("com.topcoder.uml.model.statemachines.GuardImpl", "UML:Guard");
        tagNameMappings.put("com.topcoder.uml.model.statemachines.PseudostateImpl", "UML:Pseudostate");
        tagNameMappings.put("com.topcoder.uml.model.statemachines.CompositeStateImpl", "UML:CompositeState");
        tagNameMappings.put("com.topcoder.uml.model.statemachines.SimpleStateImpl", "UML:SimpleState");
        tagNameMappings.put("com.topcoder.uml.model.statemachines.FinalStateImpl", "UML:FinalState");
        tagNameMappings.put("com.topcoder.uml.model.activitygraphs.ActivityGraphImpl", "UML:ActivityGraph");
        tagNameMappings.put("com.topcoder.uml.model.activitygraphs.ActionStateImpl", "UML:ActionState");
        tagNameMappings.put("com.topcoder.uml.model.activitygraphs.CallStateImpl", "UML:CallState");
        tagNameMappings.put("com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl", "UML:ObjectFlowState");

        return tagNameMappings;
    }
}
