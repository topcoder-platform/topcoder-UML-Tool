/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.compartmentextraction;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.Util;

/**
 * <p>
 * This class provides a factory method to create different type of concrete implementation of
 * CompartmentExtractor.
 * </p>
 *
 * <p>
 * This is provided for convenience for clients as the client only needs to specify the object type
 * and the associated compartment extractor will be created and returned.
 * </p>
 *
 * <p>
 * Thread Safety : This class is immutable and so is thread safe.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public class CompartmentExtractorFactory {
    /**
     * <p>
     * Represents the mapping from a object type to its corresponding CompartmentExtractor class.
     * </p>
     *
     * <p>
     * The key of the mapping is of ObjectType type and the value is of Class type.
     * </p>
     *
     * <p>
     * This variable is created in declaration and initialized in constructor and will never changed afterwards.
     * </p>
     */
    private final Map<ObjectType, Class> classMapping = new HashMap<ObjectType, Class>();

    /**
     * <p>
     * Represents the mapping from a CompartmentExtractor class to its parameter class in constructor.
     * </p>
     *
     * <p>
     * The key of the mapping is of Class type and the value is of Class type.
     * </p>
     *
     * <p>
     * This variable is created in declaration and initialized in constructor and will never changed afterwards.
     * </p>
     */
    private final Map<Class, Class<?>> parameterMapping = new HashMap<Class, Class<?>>();

    /**
     * <p>
     * Create a CompartmentExtractorFactory object.
     * </p>
     */
    public CompartmentExtractorFactory() {
        parameterMapping.put(ActivityNodeCompartmentExtractor.class, GraphNode.class);
        parameterMapping.put(ActivityStateCompartmentExtractor.class, GraphNode.class);
        parameterMapping.put(AssociationCompartmentExtractor.class, GraphEdge.class);
        parameterMapping.put(ClassifierCompartmentExtractor.class, GraphNode.class);
        parameterMapping.put(DefaultEdgeCompartmentExtractor.class, GraphEdge.class);
        parameterMapping.put(DefaultNodeCompartmentExtractor.class, GraphNode.class);
        parameterMapping.put(GeneralizationCompartmentExtractor.class, GraphEdge.class);
        parameterMapping.put(MessageCompartmentExtractor.class, GraphNode.class);
        parameterMapping.put(ObjectCompartmentExtractor.class, GraphNode.class);

        classMapping.put(ObjectType.Package, DefaultNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.Interface, ClassifierCompartmentExtractor.class);
        classMapping.put(ObjectType.Class, ClassifierCompartmentExtractor.class);
        classMapping.put(ObjectType.Exception, ClassifierCompartmentExtractor.class);
        classMapping.put(ObjectType.Enumeration, ClassifierCompartmentExtractor.class);
        classMapping.put(ObjectType.Association, AssociationCompartmentExtractor.class);

        classMapping.put(ObjectType.Generalization, GeneralizationCompartmentExtractor.class);
        classMapping.put(ObjectType.Abstraction, GeneralizationCompartmentExtractor.class);
        classMapping.put(ObjectType.Dependency, GeneralizationCompartmentExtractor.class);
        classMapping.put(ObjectType.Subsystem, DefaultNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.Actor, DefaultNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.UseCase, DefaultNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.Include, DefaultEdgeCompartmentExtractor.class);
        classMapping.put(ObjectType.Extend, DefaultEdgeCompartmentExtractor.class);
        classMapping.put(ObjectType.Object, ObjectCompartmentExtractor.class);
        classMapping.put(ObjectType.SynchronousMessage, MessageCompartmentExtractor.class);
        classMapping.put(ObjectType.AsynchronousMessage, MessageCompartmentExtractor.class);
        classMapping.put(ObjectType.CreateMessage, MessageCompartmentExtractor.class);
        classMapping.put(ObjectType.SendSignalMessage, MessageCompartmentExtractor.class);
        classMapping.put(ObjectType.DestroyMessage, MessageCompartmentExtractor.class);
        classMapping.put(ObjectType.ReturnMessage, MessageCompartmentExtractor.class);
        classMapping.put(ObjectType.InitialNode, ActivityNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.ForkNode, ActivityNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.JoinNode, ActivityNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.DecisionNode, ActivityNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.MergeNode, ActivityNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.FlowFinalNode, ActivityNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.FinalNode, ActivityNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.ObjectFlowNode, ActivityNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.ActionState, ActivityNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.SendSignalAction, ActivityNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.AcceptEventAction, ActivityNodeCompartmentExtractor.class);
        classMapping.put(ObjectType.Transition, DefaultEdgeCompartmentExtractor.class);
    }

    /**
     * <p>
     * This method is a parameterized factory method.
     * </p>
     *
     * <p>
     * It creates a concrete implementation of CompartmentExtractor to handle the object
     * specified by the type argument.
     * </p>
     *
     * @param type type of the object represented by element
     * @param element the element to be processed by the compartment extractor
     * @return compartment extractor to process the given element
     *
     * @throws IllegalArgumentException if type or element is null, or fails to create a
     * CompartmentExtractor instance due the type of the given element
     */
    public CompartmentExtractor createCompartmentExtractor(ObjectType type, DiagramElement element) {
        Util.checkNull(type, "type");
        Util.checkNull(element, "element");

        Class compartmentExtractorClass = classMapping.get(type);

        // This should not occurs
        if (compartmentExtractorClass == null) {
            throw new IllegalArgumentException("The given object type is not valid, the type is " + type);
        }

        Class<?> parameterClass = parameterMapping.get(compartmentExtractorClass);

        // This should not occurs
        if (parameterClass == null) {
            throw new IllegalArgumentException("The given compartment extractor is unknown, its name is "
                + compartmentExtractorClass.getName());
        }

        // The type of the element is not correct
        if (!parameterClass.isAssignableFrom(element.getClass())) {
            throw new IllegalArgumentException("The type of the given element is not right, it is "
                + element.getClass().getName() + " but " + parameterClass.getName() + " is expected.");
        }

        return createObject(element, compartmentExtractorClass, parameterClass);
    }

    /**
     * <p>
     * Create a CompartmentExtractor instance via reflection.
     * </p>
     *
     * @param element the element to be processed by the compartment extractor
     * @param compartmentExtractorClass the concrete CompartmentExtractor class
     * @param parameterClass the parameter class in the constructor
     *
     * @return the newly created CompartmentExtractor instance via reflection
     *
     * @throws IllegalArgumentException if error occurs during the reflection
     */
    private CompartmentExtractor createObject(DiagramElement element, Class compartmentExtractorClass,
        Class parameterClass) {
        try {
            return (CompartmentExtractor) compartmentExtractorClass.getConstructor(parameterClass).newInstance(element);
        } catch (SecurityException e) {
            // Should not occurs
            throw new IllegalArgumentException(
                "SecurityException occurs when creating the CompartmentExtractor instance via reflection.", e);
        } catch (InstantiationException e) {
            // Should not occurs
            throw new IllegalArgumentException(
                "InstantiationException occurs when creating the CompartmentExtractor instance via reflection.", e);
        } catch (IllegalAccessException e) {
            // Should not occurs
            throw new IllegalArgumentException(
                "IllegalAccessException occurs when creating the CompartmentExtractor instance via reflection.", e);
        } catch (InvocationTargetException e) {
            // Should not occurs
            throw new IllegalArgumentException(
                "InvocationTargetException occurs when creating the CompartmentExtractor instance via reflection.", e);
        } catch (NoSuchMethodException e) {
            // Should not occurs
            throw new IllegalArgumentException(
                "NoSuchMethodException occurs when creating the CompartmentExtractor instance via reflection.", e);
        }
    }
}
