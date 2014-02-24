/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUML2TCUMLConvertible;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityDiagram;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.Helper;


/**
 * <p>
 * This class is a facade that hides the conversion system from the application. It is used
 * to convert uml2 zuml files to uml 1.4 tc internal model. The application will use it with
 * the convertModel() static method. It converts all Activity Diagrams contained in the
 * respective model.
 * </p>
 *
 * <p>
 * Usually, the application will call the <code>convertModel(Model)</code> method after the XMI
 * Reader parsed the whole ZUML file. So before using this component, the configuration of XMI
 * Reader and ModelElementFactory should be done correctly.
 * </p>
 * <p>Add the following handlers to XMI Reader's handler configuration:</p>
 * <p>
 *     <pre>
 *     &lt;Property name="UML2:InitialNode"&gt;
 *         &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="UML2:ActivityFinalNode"&gt;
 *         &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="UML2:FlowSignalNode"&gt;
 *         &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="UML2:ForkNode"&gt;
 *         &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="UML2:JoinNode"&gt;
 *         &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="UML2:DecisionNode"&gt;
 *         &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="UML2:MergeNode"&gt;
 *         &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="UML2:Pin"&gt;
 *         &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="UML2:ExceptionHandler"&gt;
 *         &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="UML2:ActivityEdge"&gt;
 *         &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="UML2:CallAction"&gt;
 *         &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="UML2:SendSignalAction"&gt;
 *         &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="UML2:AcceptEventAction"&gt;
 *         &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name="UML2:OpaqueExpression"&gt;
 *         &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     </pre>
 * </p>
 * <p>Add the following mappings to ModelElementFactory's xml_to_element mapping.</p>
 * <p>
 *     <pre>
 *     &lt;Value&gt;
 *         UML2:Activity, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityDiagramImpl
 *     &lt;/Value&gt;
 *     &lt;Value&gt;
 *         UML2:InitialNode, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLInitialNodeImpl
 *     &lt;/Value&gt;
 *     &lt;Value&gt;
 *         UML2:ActivityFinalNode, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityFinalNodeImpl
 *     &lt;/Value&gt;
 *     &lt;Value&gt;
 *         UML2:FlowFinalNode, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLFlowFinalNodeImpl
 *     &lt;/Value&gt;
 *     &lt;Value&gt;
 *         UML2:ForkNode, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLForkNodeImpl
 *     &lt;/Value&gt;
 *     &lt;Value&gt;
 *         UML2:JoinNode, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLJoinNodeImpl
 *     &lt;/Value&gt;
 *     &lt;Value&gt;
 *         UML2:DecisionNode, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLDecisionNodeImpl
 *     &lt;/Value&gt;
 *     &lt;Value&gt;
 *         UML2:MergeNode, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLMergeNodeImpl
 *     &lt;/Value&gt;
 *     &lt;Value&gt;
 *         UML2:Pin, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLPinNodeImpl
 *     &lt;/Value&gt;
 *     &lt;Value&gt;
 *         UML2:ExceptionHandler, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLExceptionHandlerImpl
 *     &lt;/Value&gt;
 *     &lt;Value&gt;
 *         UML2:ActivityEdge, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityEdgeImpl
 *     &lt;/Value&gt;
 *     &lt;Value&gt;
 *         UML2:CallAction, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLCallActionImpl
 *     &lt;/Value&gt;
 *     &lt;Value&gt;
 *         UML2:SendSignalAction, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLSendSignalActionImpl
 *     &lt;/Value&gt;
 *     &lt;Value&gt;
 *         UML2:AcceptEventAction, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLAcceptEventActionImpl
 *     &lt;/Value&gt;
 *     &lt;Value&gt;
 *         UML2:OpaqueExpression, com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLOpaqueExpressionImpl
 *     &lt;/Value&gt;
 *     </pre>
 * </p>
 *
 * <p>You need to configure the ZUML 2 TCUML Converter 1.0 component correctly.</p>
 * <p>In the namespace for RenameConverter, add following to &quot;ToRenameNames&quot; property:</p>
 * <p>
 *     <pre>
 *     &lt;Property name=&quot;UML2:BehavioredClassifier.ownedBehavior&quot;&gt;
 *         &lt;Value&gt; UML:Namespace.ownedElement &lt;/Value&gt;
 *     &lt;/Property&gt;
 *     </pre>
 * </p>
 * <p>
 * If we assume that the object name of RenameConverter instance in Object Factory is
 * &quot;converters:renameownedbehavior&quot; then add following to &quot;Converters&quot;
 * property in namespace of XMIConvertersUtil.config method:
 * </p>
 * <p>
 *     <pre>
 *     &lt;Property name=&quot;UML:Collaboration&quot;&gt;
 *         &lt;Value&gt;converters:renameownedbehavior&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name=&quot;UML:Class&quot;&gt;
 *         &lt;Value&gt;converters:renameownedbehavior&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     &lt;Property name=&quot;UML:UseCase&quot;&gt;
 *         &lt;Value&gt;converters:renameownedbehavior&lt;/Value&gt;
 *     &lt;/Property&gt;
 *     </pre>
 * </p>
 *
 * <p>
 * <strong>Change note: </strong>The return result of method <code>convertModel(Model)</code>
 * is changed from "void" to "List&lt;ActivityGraph&gt;". And a public method <code>convertDiagrams
 * </code> is added to convert diagrams to tcuml graph node structure.<br/>
 * You can use the new interfaces like this (assume the manager is instance of UMLModelManager:<br/>
 * <pre>
 *
 * //Use xmi reader to read models and diagrams into UMLModelManager.
 * //Get the built Model
 * Model model = manager.getModel();
 *
 * //Convert the Model
 * List&lt;ActivityGraph&gt; activityGraphs = ActivityDiagramConversionFacade.convertModel(model);
 *
 * List&lt;Diagram&gt; diagrams = manager.getDiagrams();
 * System.out.println("There are " + diagrams.size() + " diagrams.");
 *
 * //convert diagrams to tcuml graph node structure
 * ActivityDiagramConversionFacade.convertDiagrams(diagrams);
 * </pre>
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class holds no state but calling the static method from different threads with the
 * same model argument will lead to unpredictable results, so it is not thread safe.
 * </p>
 *
 * @author Rica, zhengjuyu
 * @version 1.0
 * @author flytoj2ee, TCSDEVELOPER
 * @version 1.1
 */
public class ActivityDiagramConversionFacade {
    /**
     * <p>Private constructor to restrict instantiation.</p>
     */
    private ActivityDiagramConversionFacade() {
    }

    /**
     * <p>
     * Converts the Activity Diagram instances found in the model argument. If no Activity
     * Diagram instance is found no conversion is done and the model remains unchanged. Because
     * the converters are broken down into individual types of diagrams, this component does
     * not do anything to the model's elements that are not Activity Digrams. It also adds
     * all used TagDefinitions to the Model. In the end, it will return all the converted
     * result as a <code>ActivityGraph</code> list.
     * </p>
     *
     * <p>
     * Note: The Activity Diagram can exist in any Namespace instance, so this component will
     * search through the Model to transform all Activity Diagrams to TCUML elements.
     * </p>
     *
     * <p>
     * <strong>Change note: </strong>In version 1.1, it will return the converted result as
     * a <code>ActivityGraph</code> list.
     * </p>
     *
     * @since 1.0
     *
     * @param model the model to be converted
     * @return all converted activity graphs
     * @throws IllegalArgumentException if the argument model is null
     */
    public static List<ActivityGraph> convertModel(Model model) {
        Helper.checkNull(model, "model");

        //Only clears the usedTags, the new used TagDefinitions in this converting
        //process will be added to the usedTags. It will share TagDefinition with
        //the original map.
        Helper.clearUsedTagDefinitions();

        //Converted results.
        List<ActivityGraph> activityGraphs = new ArrayList<ActivityGraph>();

        //The Activity Diagram can exist in any namespace, such as Model, Collaboration, UseCase.
        //This will search through the model, to convert any ActivityDiagram found.
        convertNamespace(model, model, activityGraphs);

        //Add new used TagDefinitions to the Model
        for (TagDefinition tagDefinition : Helper.getUsedTagDefinitions()) {
            model.addOwnedElement(tagDefinition);
        }

        return activityGraphs;
    }

    /**
     * <p>
     * Converts the given Diagrams from Poseidon 1.5 to TC UML Tool. It'll convert the contains,
     * owner and SemanticModel. The given List can not be null or contain null, but it can be empty.
     * </p>
     *
     * <p>
     * <strong>Change note:</strong> This method is added in version 1.1.
     * </p>
     *
     * @since 1.1
     *
     * @param diagrams the list of Diagrams to be converted.
     * @throws IllegalArgumentException if diagrams is null, or it contains null elements
     */
    public static void convertDiagrams(List<Diagram> diagrams) {
        Helper.checkNull(diagrams, "diagrams");

        //The diagrams should not contain null element.
        for (Diagram diagram : diagrams) {
            Helper.checkNull(diagram, "diagrams' element");
        }

        //Converts each diagram's contained element, owner, semanticModel.
        for (Diagram diagram : diagrams) {
            convertContainedElements(diagram.getContaineds());
            convertSemanticModelBridge(diagram.getOwner());
            convertSemanticModelBridge(diagram.getSemanticModel());
        }
    }

    /**
     * <p>
     * Converts all given <code>DiagramElement</code> from Poseidon 1.5 to TC UML Tool.
     * Checks all DiagramElements, if it's the <code>GraphElement</code> instance, converts
     * it. And it'll call <code>convertContainedElements()</code> recursively to convert
     * its contains.
     * </p>
     *
     * <p>
     * <strong>Change note:</strong> This method is added in version 1.1.
     * </p>
     *
     * @since 1.1
     *
     * @param diagramElements the list of diagram elements to be converted
     */
    protected static void convertContainedElements(List<DiagramElement> diagramElements) {
        //If diagramElements is null, do nothing.
        if (diagramElements == null) {
            return;
        }

        for (DiagramElement diagramElement : diagramElements) {
            if (diagramElement instanceof GraphElement) {
                GraphElement graphElement = (GraphElement) diagramElement;
                convertSemanticModelBridge(graphElement.getSemanticModel());
                convertContainedElements(graphElement.getContaineds());
            }
        }
    }

    /**
     * <p>
     * Converts the given <code>SemanticModelBridge</code> instance from Poseidon 1.5 to TC UML Tool.
     * If the given <code>SemanticModelBridge</code> is not an <code>Uml1SemanticModelBridge</code>
     * instance, do nothing. If it is and its element is instance of <code>ZUML2TCUMLConvertible</code>,
     * this method will convert the element to its corresponding tcuml element.
     * </p>
     *
     * <p>
     * <strong>Change note: </strong>This method is added in version 1.1.
     * </p>
     *
     * @since 1.1
     *
     * @param semanticModelBridge the SemanticModelBridge instance to be converted
     */
    protected static void convertSemanticModelBridge(SemanticModelBridge semanticModelBridge) {
        //If semanticModelBridge is null, this will return false, then do nothing.
        if (semanticModelBridge instanceof Uml1SemanticModelBridge) {
            Uml1SemanticModelBridge modelBridge = (Uml1SemanticModelBridge) semanticModelBridge;
            Element element = modelBridge.getElement();

            if (element instanceof ZUML2TCUMLConvertible) {
                modelBridge.setElement(((ZUML2TCUMLConvertible) element).convertToTCUML());
            }
        }
    }

    /**
     * <p>
     * Converts the Activity Diagram in the namespace to its corresponding TCUML element.
     * Removes the activity diagram from the namespace, and add the converted element to
     * the root Model. In the end, add the converted result to the activity graphs list.
     * </p>
     *
     * <p>
     * <strong>Change note: </strong>This method is changed from private to protected in
     * version. And add the third parameter to record the converted result.
     * </p>
     *
     * @since 1.1
     *
     * @param namespace the namespace to convert
     * @param model the root model
     * @param activityGraphs the converted activity graphs list
     * @throws IllegalArgumentException if activityGraphs is null
     */
    protected static void convertNamespace(Namespace namespace, Model model, List<ActivityGraph> activityGraphs) {
        Helper.checkNull(activityGraphs, "activityGraphs");

        //If namespace or model is null, do nothing.
        if (namespace == null || model == null) {
            return;
        }

        for (ModelElement element : namespace.getOwnedElements()) {
            if (element instanceof ZUMLActivityDiagram) {
                ModelElement transformed = ((ZUMLActivityDiagram) element).convertToTCUML();

                //Remove the element from current namespace
                namespace.removeOwnedElement(element);
                //Add the transformed element directly to the root model
                model.addOwnedElement(transformed);

                //All the ActivityDiagram should be returned
                activityGraphs.add((ActivityGraph) transformed);
            } else if (element instanceof Namespace) {
                convertNamespace((Namespace) element, model, activityGraphs);
            }
        }
    }
}
