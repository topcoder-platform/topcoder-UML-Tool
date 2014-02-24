/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import java.util.List;

import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.State;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode;


/**
 * <p>
 * This class represents an UML2:Activity element. It will be used by the XMI Reader and its
 * plugins to create an object representation of the read zuml data. It implements the
 * convertToTCUML() method returning the converted tcuml object that can be used in the internal
 * uml tool model.
 * </p>
 *
 * <p>
 * In order to prevent there are many converted instances of one element, the convertTCUML()
 * will always return the same instance.
 * </p>
 *
 * <p>
 * <strong>Change Note:</strong> In version 1.0, the activity diagram is transformed to a <code>
 * StateMachineImpl</code> instance. In version 1.1, it is transformed to <code>ActivityGraphImpl</code>
 * instance instead.
 * <p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is mutable and not thread safe.
 * </p>
 *
 * @author Rica, zhengjuyu
 * @version 1.0
 * @author flytoj2ee, TCSDEVELOPER
 * @version 1.1
 */
public class ZUMLActivityDiagramImpl extends AbstractZUMLActivityDiagram {
    /**
     * <p>Serial version uid for the Serializable class.</p>
     */
    private static final long serialVersionUID = -2554937928946024137L;

    /**
     * <p>
     * This field represents the converted instance of this element. If it
     * is not null, it will be returned directly in the convertToTCUML(). This
     * will prevents one element being converted many times.
     * </p>
     */
    private StateMachine transformed;

    /**
     * <p>Empty constructor. Call super() default constructor.</p>
     */
    public ZUMLActivityDiagramImpl() {
    }

    /**
     * <p>
     * This method converts the current <code>ZUMLActivityDiagramImpl</code> representation of an
     * UML2:Activity zuml element into the equivalent tcuml instance.
     * </p>
     *
     * <p>
     * This method will always return the same instance of converted element. This will
     * prevent there are many converted elements in the diagram of one original element.
     * </p>
     *
     * <p>
     * <strong>Change Note:</strong> In version 1.0, the activity diagram is transformed
     * to a <code>StateMachineImpl</code> instance. In version 1.1, it is transformed to
     * <code>ActivityGraphImpl</code> instance instead.
     * </p>
     *
     * @since 1.0
     *
     * @return the equivalent tcuml ModelElement
     */
    public ModelElement convertToTCUML() {
        if (transformed == null) {
            transformed = new ActivityGraphImpl();

            //Copy base common ModelElement attributes from representation to the converted instance
            Helper.copyAttribute(this, transformed);

            CompositeState state = new CompositeStateImpl();
            state.setStateMachine(transformed);

            //Add the CompositeState the StateMachine
            transformed.setTop(state);

            List<ZUMLActivityNode> nodes = getNodes();

            //Convert each edge and its source and target node.
            for (ZUMLActivityEdge edge : getEdges()) {
                Transition transition = (Transition) edge.convertToTCUML();

                transition.setStateMachine(transformed);

                transformed.addTransition(transition);

                ZUMLActivityNode source = edge.getSource();

                //Each node should only be converted once
                //In real Activity Diagram, there will be only one identical node in the nodes.
                //And each node should be added to CompositeState once.
                if (nodes.contains(source)) {
                    state.addSubVertex((StateVertex) source.convertToTCUML());
                    nodes.remove(source);
                }

                ZUMLActivityNode target = edge.getTarget();

                //Each node should only be converted one
                //In real Activity Diagram, there will be only one identical node in the nodes.
                //And each node should be added to CompositeState once.
                if (nodes.contains(target)) {
                    StateVertex stateVertex = (StateVertex) target.convertToTCUML();
                    state.addSubVertex(stateVertex);
                    stateVertex.setContainer(state);
                    nodes.remove(target);
                }
            }

            //Convert the isolated node.
            for (ZUMLActivityNode node : nodes) {
                StateVertex s = (StateVertex) node.convertToTCUML();
                state.addSubVertex(s);
                s.setContainer(state);
            }
        }

        return transformed;
    }
}
