/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.stresstests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.ActivityDiagramConversionFacade;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLActivityNode;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityDiagramImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityEdgeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLInitialNodeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLOpaqueExpressionImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLPinNodeImpl;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * Stress tests for <code>ActivityDiagramConversionFacade</code> class.
 * </p>
 * @author Thinfox, WN
 * @version 1.1
 * @since 1.0
 */
public class ActivityDiagramConversionFacadeStressTests extends TestCase {
    /**
     * <p>
     * Create a Model for testing. It will contain 1 Namespace, 1 non-Namespace instance. And an
     * ActivityDiagram in the namespace.
     * </p>
     * @return the Model for testing
     */
    private Model createModel() {
        Model model = new ModelImpl();

        Namespace ns = new CollaborationImpl();
        model.addOwnedElement(ns);
        model.addOwnedElement(new AttributeImpl());

        ZUMLActivityDiagramImpl diagram = new ZUMLActivityDiagramImpl();
        ns.addOwnedElement(diagram);

        AbstractZUMLActivityNode source = new ZUMLInitialNodeImpl();
        source.setName("source");

        AbstractZUMLActivityNode target = new ZUMLPinNodeImpl();
        target.setName("target");

        ZUMLActivityEdgeImpl edge = new ZUMLActivityEdgeImpl();
        edge.setName("edge");

        edge.setSource(source);
        edge.setTarget(target);
        edge.setGuard(new ZUMLOpaqueExpressionImpl());

        diagram.addNode(source);
        diagram.addNode(target);
        diagram.addEdge(edge);

        diagram.addNode(new ZUMLPinNodeImpl());

        return model;
    }

    /**
     * <p>
     * Stress test for <code>convertModel(Model)</code>.
     * </p>
     */
    public void testConvertModel_10() {
        Model[] models = new Model[10];

        for (int i = 0; i < 10; i++) {
            models[i] = createModel();
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            ActivityDiagramConversionFacade.convertModel(models[i]);
        }

        System.out.println(
            "Calling ActivityDiagramConversionFacade.convertModel 10 times took "
            + (System.currentTimeMillis() - startTime) + " milliseconds");
    }

    /**
     * <p>
     * Stress test for <code>convertModel(Model)</code>.
     * </p>
     */
    public void testConvertModel_100() {
        Model[] models = new Model[100];

        for (int i = 0; i < 100; i++) {
            models[i] = createModel();
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            ActivityDiagramConversionFacade.convertModel(models[i]);
        }

        System.out.println(
            "Calling ActivityDiagramConversionFacade.convertModel 100 times took "
            + (System.currentTimeMillis() - startTime) + " milliseconds");
    }

    /**
     * <p>
     * Stress test for <code>convertModel(Model)</code>.
     * </p>
     */
    public void testConvertModel_1000() {
        Model[] models = new Model[1000];

        for (int i = 0; i < 1000; i++) {
            models[i] = createModel();
        }

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000; i++) {
            ActivityDiagramConversionFacade.convertModel(models[i]);
        }

        System.out.println(
            "Calling ActivityDiagramConversionFacade.convertModel 1000 times took "
            + (System.currentTimeMillis() - startTime) + " milliseconds");
    }

    /**
     * <p>
     * Stress tests for the method List convertModel(Model).
     * </p>
     *
     * @since 1.1
     */
    public void testConvertModel() {
        Model[] models = new ModelImpl[100];

        for (int i = 0; i < 100; i++) {
            models[i] = new ModelImpl();
            models[i].addOwnedElement(new ZUMLActivityDiagramImpl());
        }

        long time = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            assertEquals("The size of the return list should be matched.", 1,
                ActivityDiagramConversionFacade.convertModel(models[i]).size());
        }

        time = System.currentTimeMillis() - time;

        System.out.println(
            "Stress test for the method convertModel(Model) took " + time + "ms");
    }

    /**
     * <p>
     * Stress tests for the method convertDiagrams(List).
     * </p>
     *
     * @since 1.1
     */
    public void testConvertDiagrams() {
        List<Diagram> diagrams = new ArrayList<Diagram>();

        for (int i = 0; i < 100; i++) {
            Diagram diagram = new Diagram();
            Uml1SemanticModelBridge modelBridge = new Uml1SemanticModelBridge();
            modelBridge.setElement(new ZUMLActivityDiagramImpl());
            diagram.setOwner(modelBridge);
            diagram.setSemanticModel(modelBridge);
            diagrams.add(diagram);
        }

        long time = System.currentTimeMillis();

        ActivityDiagramConversionFacade.convertDiagrams(diagrams);

        time = System.currentTimeMillis() - time;

        for (Diagram dia : diagrams) {
            Uml1SemanticModelBridge instance = (Uml1SemanticModelBridge) dia.getOwner();
            assertTrue("The convert type should be matched.",
                instance.getElement() instanceof ActivityGraphImpl);
        }

        System.out.println(
            "Stress test for the method convertDiagrams(List<Diagram>) took " + time + "ms");
    }
}
