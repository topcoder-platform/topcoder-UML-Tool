/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import java.util.Collection;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.umltool.xmiconverters.poseidon5.model.Interaction;
import com.topcoder.umltool.xmiconverters.poseidon5.model.Message;
import com.topcoder.umltool.xmiconverters.poseidon5.model.ZUML2TCUMLTransformer;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.Helper;


/**
 * <p>
 * This utility class is the main class in this component. It provides two post reading
 * tasks the application can call:
 * </p>
 * <p>
 * 1.Converting the Collaboration in Model for sequence diagram from ZUML to TCUML.
 * ZUML uses UML2 standard and TCUML uses UML1.4, in UML2, the model for sequence
 * diagram is &lt;UML2:Interaction&gt;, which is contained by Collaboration instance.
 * but in UML1.4, the model for sequence diagram is &lt;UML:Collaboration&gt; directly.
 * </p>
 * <p>
 * 2. Converting the sequence diagram instances from ZUML to TCUML. Common diagram
 * differences will be converted by ZUML 2 TCUML Converter component, this component
 * is used to convert the differences only for sequence diagram. Usually, the application
 * will call the convertCollaborationInModel method first after the XMI Reader parsed
 * the whole ZUML file, then it will call the convertSequenceDiagrams method to convert
 * sequence diagram instances. But it is not forced, the calling order can be changed.
 * </p>
 *
 * <p>
 * Usually, the application will call the <code>convertCollaborationInModel</code> method first after the XMI
 * Reader parsed the whole ZUML file. Then it will call the <code>convertSequenceDiagrams</code> method to convert
 * sequence diagram instances. But this calling order is not forced, it can freely be changed.
 * </p>
 * <p>For this component to function properly several actions need to be made:</p>
 * <ol>
 *   <li>You need to configure the XMI Reader UML Model Plugin 1.0 component correctly.<br>
 *       In the XMI Reader &quot;handlers&quot; configuration property, add the following handlers:<br>
 *       <pre>
 *       &lt;Property name=&quot;UML2:Interaction&quot;&gt;
 *           &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.model.XMI2ModelHandler&lt;/Value&gt;
 *       &lt;/Property&gt;
 *       &lt;Property name=&quot;UML2:EventOccurrence&quot;&gt;
 *           &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.model.XMI2ModelHandler&lt;/Value&gt;
 *       &lt;/Property&gt;
 *       &lt;Property name=&quot;UML2:ExecutionOccurrence&quot;&gt;
 *           &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.model.XMI2ModelHandler&lt;/Value&gt;
 *       &lt;/Property&gt;
 *       &lt;Property name=&quot;UML2:Message&quot;&gt;
 *           &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.model.XMI2ModelHandler&lt;/Value&gt;
 *       &lt;/Property&gt;
 *       &lt;Property name=&quot;UML2:Lifeline&quot;&gt;
 *           &lt;Value&gt;com.topcoder.xmi.reader.handlers.uml.model.XMI2ModelHandler&lt;/Value&gt;
 *       &lt;/Property&gt;
 *       </pre>
 *       In the ModelElementFactory &quot;xml_to_element_mapping&quot;
 *       configuration property, add the following mappings (UML:Collaboration mapping should be replaced):<br>
 *       <blockquote><code><br>
 *       &lt;Value&gt;UML2:Interaction,
 *                    com.topcoder.umltool.xmiconverters.poseidon5.model.impl.InteractionImpl
 *                    &lt;/Value&gt;<br>
 *       &lt;Value&gt;UML2:EventOccurrence,
 *                    com.topcoder.umltool.xmiconverters.poseidon5.model.impl.InteractionImpl.EvnetOccurrenceImpl
 *                    &lt;/Value&gt;<br>
 *       &lt;Value&gt;UML2:ExecutionOccurrence,
 *                    com.topcoder.umltool.xmiconverters.poseidon5.model.impl.ExecutionOccurrenceImpl
 *                    &lt;/Value&gt;<br>
 *       &lt;Value&gt;UML2:Message,
 *                    com.topcoder.umltool.xmiconverters.poseidon5.model.impl.MessageImpl
 *                    &lt;/Value&gt;<br>
 *       &lt;Value&gt;UML2:Lifeline,
 *                    com.topcoder.umltool.xmiconverters.poseidon5.model.impl.LifelineImpl
 *                    &lt;/Value&gt;<br>
 *       <br></code></blockquote>
 *   </li>
 *   <li>You need to configure the ZUML 2 TCUML Converter 1.0 component correctly.<br>
 *       In the namespace for RenameConverter, add following to &quot;ToRenameNames&quot; property:<br>
 *       <pre>
 *       &lt;Property name=&quot;UML2:BehavioredClassifier.ownedBehavior&quot;&gt;
 *           &lt;Value&gt; UML:Namespace.ownedElement &lt;/Value&gt;
 *       &lt;/Property&gt;
 *       </pre>
 *       If we assume that the object name of RenameConverter instance in Object Factory is
 *       &quot;converters:renameownedbehavior&quot; then add following to &quot;Converters&quot; property in namespace
 *       of XMIConvertersUtil.config method:
 *       <pre>
 *       &lt;Property name=&quot;UML:Collaboration&quot;&gt;
 *           &lt;Value&gt;converters:renameownedbehavior&lt;/Value&gt;
 *       &lt;/Property&gt;
 *       &lt;Property name=&quot;UML:Class&quot;&gt;
 *           &lt;Value&gt;converters:renameownedbehavior&lt;/Value&gt;
 *       &lt;/Property&gt;
 *       &lt;Property name=&quot;UML:UseCase&quot;&gt;
 *           &lt;Value&gt;converters:renameownedbehavior&lt;/Value&gt;
 *       &lt;/Property&gt;
 *       </pre>
 *   </li>
 * </ol>
 *
 * After all these done you can use XMIReader to parse the ZUML file like this:<br>
 * <blockquote><code><br>
 * XMIReader reader; // initialization of the XMI Reader<br>
 * reader = XMIConvertersUtil.config(reader); // configure the RenameConverter converter<br>
 * reader.parseZipFile(&quot;sample.zuml&quot;);<br>
 * <br></code></blockquote>
 *
 * To convert the Collaboration in model code must look like this:<br>
 * <blockquote><code><br>
 * // get the Model instance from Model Manager<br>
 * Model model = modelManager.getModel();<br>
 * // convert the collaboration instances from ZUML to TCUML<br>
 * XMISequenceDiagramConverterUtil.convertCollaborationInModel(model);<br>
 * <br></code></blockquote>
 *
 * To convert the Sequence Diagram instances code must look like this:<br>
 * <blockquote><code><br>
 * // get the Diagram instances from Model Manager<br>
 * List&lt;Diagram&gt; diagrams = modelManager.getDiagrams();<br>
 * // convert the sequence diagrams contained in diagrams from ZUML to TCUML<br>
 * XMISequenceDiagramConverterUtil.convertSequenceDiagrams(diagrams);<br>
 * <br></code></blockquote>
 * <p>
 * <strong>Thread safety:</strong>
 * This class is stateless, immutable and thread-safe.
 * </p>
 *
 * @author telly12, zhengjuyu
 * @version 1.0
 */
public class XMISequenceDiagramConverterUtil {
    /**
     * <p>The value of typeInfo Name.</p>
     */
    private static final String TYPEINFO_NAME = "Name";

    /**
     * <p>The value of typeInfo StereotypeStart.</p>
     */
    private static final String TYPEINFO_STEREOTYPESTART = "StereotypeStart";

    /**
     * <p>The value of typeInfo StereotypeEnd.</p>
     */
    private static final String TYPEINFO_STEREOTYPEEND = "StereotypeEnd";

    /**
     * <p>The value of typeInfo StereotypeCompartment.</p>
     */
    private static final String TYPEINFO_STEREOTYPECOMPARTMENT = "StereotypeCompartment";

    /**
     * <p>Private constructor prevents initializing this class.</p>
     */
    private XMISequenceDiagramConverterUtil() {
    }

    /**
     * <p>
     * Converting the Collaboration in Model for sequence diagram from ZUML to TCUML.
     * ZUML uses UML2 standard and TCUML uses UML1.4, in UML2, the model for sequence diagram
     * is &lt;UML2:Interaction&gt;, which is contained by Collaboration instance. but in UML1.4,
     * the model for sequence diagram is &lt;UML:Collaboration&gt; directly. The differences
     * for collaboration between ZUML and TCUML is described in the requirements. The model
     * classes represents the ZUML's collaboration relative elements are defined in the model
     * sub-package in this component, and this method will convert these classes to TCUML model
     * classes.
     * </p>
     *
     * @param model the Model instance in which the collaboration instance for sequence diagram will be converted
     * @throws IllegalArgumentException is the model is null
     */
    public static void convertCollaborationInModel(Model model) {
        Helper.checkNull(model, "model");

        Collection<ModelElement> elements = model.getOwnedElements();

        for (ModelElement element : elements) {
            if (element instanceof Namespace) {
                convertNamespace((Namespace) element, model);
            }
        }
    }

    /**
     * <p>
     * Convert comments in zuml to tcuml. It will move the comment from the interactions
     * to the model directly, and then set the comment's namespace to the model.
     * </p>
     *
     * @param interaction the Interaction which contains the comment
     * @param model the root uml model instance
     */
    private static void convertComment(Interaction interaction, Model model) {
        Collection<ModelElement> ownedElements = interaction.getOwnedElements();

        for (ModelElement element : ownedElements) {
            if (element instanceof Comment) {
                interaction.removeOwnedElement(element);
                model.addOwnedElement(element);
                element.setNamespace(model);
            }
        }
    }

    /**
     * <p>
     * Convert the interaction in namespace, and then remove the interaction from the namespace.
     * Add the transformed collaboration directly to the uml model. Do recursively on the sub namespaces.
     * If there is comment instance in Interaction's ownedElement, move the comments to the model too.
     * </p>
     *
     * @param namespace the Namespace instance to convert
     * @param model the root uml model instance
     */
    private static void convertNamespace(Namespace namespace, Model model) {
        Collection<ModelElement> subElements = namespace.getOwnedElements();

        for (ModelElement subElement : subElements) {
            if (subElement instanceof Interaction) {
                Interaction interaction = (Interaction) subElement;

                namespace.removeOwnedElement(subElement);
                model.addOwnedElement(interaction.toTCUMLElement());

                // Move the comment from interaction to the model
                convertComment(interaction, model);
            } else if (subElement instanceof Namespace) {
                convertNamespace((Namespace) subElement, model);
            }
        }
    }

    /**
     * <p>
     * Converting the sequence diagram instances from ZUML to TCUML. Common diagram differences
     * will be converted by ZUML 2 TCUML Converter component, this component is used to convert
     * the differences only for sequence diagram. A sequence diagram in ZUML is the diagram has
     * the owner element Interaction instance. But the diagrams passed may contains other diagrams,
     * but only sequence diagram will be converted.
     * </p>
     *
     * @param diagrams the diagrams to be converted, only the sequence diagram will be converted
     * @throws IllegalArgumentException if the diagrams is null or empty or it contains null element
     */
    public static void convertSequenceDiagrams(Collection<Diagram> diagrams) {
        Helper.checkCollection(diagrams, "diagrams");

        for (Diagram diagram : diagrams) {
            convertSequenceDiagram(diagram);
        }
    }

    /**
     * <p>
     * Converting the sequence diagram instance from ZUML to TCUML. Common diagram differences
     * will be converted by ZUML 2 TCUML Converter component, this component is used to convert
     * the differences only for sequence diagram. A sequence diagram in ZUML is the diagram has
     * the owner element Interaction instance. But the diagrams passed may be other diagram,
     * but only sequence diagram will be converted, if it is not sequence diagram, do noting.
     * </p>
     *
     * @param diagram the diagram to be converted, only sequence diagram will be converted.
     * @throws IllegalArgumentException if the diagram is null
     */
    public static void convertSequenceDiagram(Diagram diagram) {
        Helper.checkNull(diagram, "diagram");

        SemanticModelBridge model = diagram.getOwner();

        //If it's not sequence diagram, do nothing.
        if (model instanceof Uml1SemanticModelBridge) {
            Uml1SemanticModelBridge umlModel = (Uml1SemanticModelBridge) model;

            Element element = umlModel.getElement();

            if (element instanceof Interaction) {
                //Transform the Interaction to Collaboration
                Collaboration collaboration = ((Interaction) element).toTCUMLElement();
                umlModel.setElement(collaboration);

                for (DiagramElement diagramElement : diagram.getContaineds()) {
                    if (diagramElement instanceof GraphNode) {
                        SemanticModelBridge smodel = ((GraphNode) diagramElement).getSemanticModel();

                        //Transform the GraphNode which has Uml1SemanticModelBridge
                        if (smodel instanceof Uml1SemanticModelBridge) {
                            Element e = ((Uml1SemanticModelBridge) smodel).getElement();

                            //Transform the TCUML Model bean
                            if (e instanceof ZUML2TCUMLTransformer) {
                                ModelElement me = ((ZUML2TCUMLTransformer<?>) e).toTCUMLElement();

                                if (me instanceof Object) {
                                    ((Uml1SemanticModelBridge) smodel).setElement(me);

                                    //Add all anchorage to the current node
                                    for (DiagramElement de : ((GraphNode) diagramElement).getContaineds()) {
                                        if (de instanceof GraphNode) {
                                            addAnchorage((GraphNode) de,
                                                (GraphNode) diagramElement);
                                        }
                                    }

                                    ((GraphNode) diagramElement).clearContaineds();
                                }
                            }
                        }
                    } else if (diagramElement instanceof GraphEdge) {
                        SemanticModelBridge smodel = ((GraphEdge) diagramElement).getSemanticModel();

                        if (smodel instanceof Uml1SemanticModelBridge) {
                            Element e = ((Uml1SemanticModelBridge) smodel).getElement();

                            if (e instanceof Message) {
                                Message message = (Message) e;
                                ((Uml1SemanticModelBridge) smodel).setElement(message.toTCUMLElement());
                                ((GraphEdge) diagramElement).clearContaineds();

                                //Add four static graph nodes
                                addGraphNodes((GraphEdge) diagramElement);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * <p>
     * Add four static GraphNodes to the GraphEdge.
     * </p>
     *
     * @param edge the GraphNode to add the 4 GraphNodes to
     */
    private static void addGraphNodes(GraphEdge edge) {
        edge.addContained(createGraphNodeA());
        edge.addContained(createGraphNodeB());
        //The third GraphNode is the same to the second one.
        edge.addContained(createGraphNodeB());
        //The fourth one is the same to the first one.
        edge.addContained(createGraphNodeA());
    }

    /**
     * <p>
     * Add the anchorages from fromNode and its subGraphNodes to toNode.
     * </p>
     *
     * @param fromNode the original GraphNode
     * @param toNode the destination GraphNode
     */
    private static void addAnchorage(GraphNode fromNode, GraphNode toNode) {
        for (GraphConnector anchorage : fromNode.getAnchorages()) {
            toNode.addAnchorage(anchorage);
        }

        for (DiagramElement element : fromNode.getContaineds()) {
            if (element instanceof GraphNode) {
                addAnchorage((GraphNode) element, toNode);
            }
        }
    }

    /**
     * <p>
     * Create one of the 4 static GraphNodes.
     * </p>
     *
     * @return one of the static GraphNode
     */
    private static GraphNode createGraphNodeA() {
        GraphNode root = new GraphNode();
        root.setVisible(true);

        GraphNode childNodeA = new GraphNode();
        childNodeA.setVisible(true);
        root.addContained(childNodeA);

        SimpleSemanticModelElement model = new SimpleSemanticModelElement();
        model.setTypeInfo(TYPEINFO_STEREOTYPESTART);
        childNodeA.setSemanticModel(model);

        GraphNode childNodeB = new GraphNode();
        childNodeB.setVisible(true);
        root.addContained(childNodeB);

        GraphNode childNodeBA = new GraphNode();
        childNodeBA.setVisible(true);
        model = new SimpleSemanticModelElement();
        model.setTypeInfo(TYPEINFO_NAME);
        childNodeBA.setSemanticModel(model);

        childNodeB.addContained(childNodeBA);

        GraphNode childNodeC = new GraphNode();
        childNodeC.setVisible(true);
        root.addContained(childNodeC);
        model = new SimpleSemanticModelElement();
        model.setTypeInfo(TYPEINFO_STEREOTYPEEND);
        childNodeC.setSemanticModel(model);

        model = new SimpleSemanticModelElement();
        model.setTypeInfo(TYPEINFO_STEREOTYPECOMPARTMENT);
        root.setSemanticModel(model);

        return root;
    }

    /**
     * <p>
     * Create a GraphNode which only contains a SimpleSemanticModelElement with
     * typeInfo = "Name".
     * </p>
     *
     * @return a GraphNode with SimpleSemanticModelElement and typeInfo equals Name
     */
    private static GraphNode createGraphNodeB() {
        GraphNode root = new GraphNode();
        root.setVisible(true);

        SimpleSemanticModelElement model = new SimpleSemanticModelElement();
        model.setTypeInfo(TYPEINFO_NAME);

        root.setSemanticModel(model);

        return root;
    }
}
