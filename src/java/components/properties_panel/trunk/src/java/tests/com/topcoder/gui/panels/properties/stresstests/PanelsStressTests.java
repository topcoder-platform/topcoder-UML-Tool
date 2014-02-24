/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties.stresstests;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.topcoder.gui.panels.properties.PropertiesPanel;
import com.topcoder.gui.panels.properties.PropertyKind;
import com.topcoder.gui.panels.properties.PropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.AggregationPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.AssociationEndsPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.ChangeabilityPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.ConcurrencyPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.GuardPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.IncomingTransitionPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.InitialValuePropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.KindPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.ActionLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.AdditionLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.AssociationLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.BaseLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.ChildLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.ClientLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.ExtensionLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.NamespaceLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.OwnerLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.ParentLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.SourceLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.StimulusLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.SupplierLinkPropertyPanel;
import com.topcoder.gui.panels.properties.propertypanel.links.TargetLinkPropertyPanel;
import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.actions.objectactions.CreateObjectActionImpl;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;
import com.topcoder.uml.model.statemachines.PseudostateImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;

/**
 * Stress tests for the classes which extends the AbstratLinkPropertyPanel,
 * such as ActionLinkPropertyPanel, AdditionLinkPropertyPanel, etc.
 *
 * @author kinfkong
 * @version 1.0
 */
public class PanelsStressTests extends StressBase {

    /**
     * Represents the property panel for stress tests.
     */
    private PropertyPanel panel = null;

    /**
     * Represents the properties panel.
     */
    private PropertiesPanel panels = null;

    /**
     * Represents the list elements.
     */
    private List<ModelElement> elements = null;

    private Map<PropertyKind, java.lang.Class[]> map = null;

    /**
     * Sets up the test environment.
     */
    public void setUp() throws Exception {
        super.setUp();
        elements = new ArrayList<ModelElement>();
        PackageImpl packageImpl = new PackageImpl();
        elements.add(packageImpl);
        InterfaceImpl interfaceImpl = new InterfaceImpl();
        elements.add(interfaceImpl);
        ClassImpl classImpl = new ClassImpl();
        elements.add(classImpl);
        EnumerationImpl enumerationImpl = new EnumerationImpl();
        elements.add(enumerationImpl);
        ActorImpl actorImpl = new ActorImpl();
        elements.add(actorImpl);
        UseCaseImpl useCaseImpl = new UseCaseImpl();
        elements.add(useCaseImpl);
        SubsystemImpl subsystemImpl = new SubsystemImpl();
        elements.add(subsystemImpl);
        OperationImpl operationImpl = new OperationImpl();
        elements.add(operationImpl);
        AttributeImpl attributeImpl = new AttributeImpl();
        elements.add(attributeImpl);
        ParameterImpl parameterImpl = new ParameterImpl();
        elements.add(parameterImpl);
        AssociationEndImpl associationEndImpl = new AssociationEndImpl();
        elements.add(associationEndImpl);
        ObjectImpl objectImpl = new ObjectImpl();
        elements.add(objectImpl);
        TransitionImpl transitionImpl = new TransitionImpl();
        elements.add(transitionImpl);
        DependencyImpl dependencyImpl = new DependencyImpl();
        elements.add(dependencyImpl);
        GeneralizationImpl generalizationImpl = new GeneralizationImpl();
        elements.add(generalizationImpl);
        AbstractionImpl abstractionImpl = new AbstractionImpl();
        elements.add(abstractionImpl);
        ExtendImpl extendImpl = new ExtendImpl();
        elements.add(extendImpl);
        IncludeImpl includeImpl = new IncludeImpl();
        elements.add(includeImpl);
        PseudostateImpl pseudostateImpl = new PseudostateImpl();
        elements.add(pseudostateImpl);
        AssociationImpl associationImpl = new AssociationImpl();
        elements.add(associationImpl);
        StimulusImpl stimulusImpl = new StimulusImpl();
        elements.add(stimulusImpl);
        CreateObjectActionImpl createObjectActionImpl = new CreateObjectActionImpl();
        elements.add(createObjectActionImpl);



        UMLModelManager manager = new UMLModelManager();
        Model root = manager.getModel();
        root.setName("test");

        Namespace ns = new PackageImpl();
        ns.setName("com.topcoder.util");
        root.addOwnedElement(ns);

        ClassImpl type = new ClassImpl();
        type.setName("test");
        type.setNamespace(ns);
        ns.addOwnedElement(type);

        ProjectConfigurationManager configManager = new ProjectConfigurationManager(manager);

        manager.setProjectConfigurationManager(configManager);
        manager.setProjectLanguage("Java");

        // create the panel

        panels = new PropertiesPanel("com.topcoder.gui.panels.properties", manager);

        // The key of the mapping is PropertyKind while the value is all the supported model element types

        map = new HashMap();
        map.put(PropertyKind.NAME, new Class[0]);
        map.put(PropertyKind.NAMESPACE, new java.lang.Class[] {Package.class, Interface.class,
            com.topcoder.uml.model.core.classifiers.Class.class, Enumeration.class, Actor.class, UseCase.class,
            Subsystem.class});
        map.put(PropertyKind.OWNER, new Class[] {Operation.class});
        map.put(PropertyKind.TYPE, new Class[] {Attribute.class, Parameter.class,
            AssociationEnd.class, Object.class});
        map.put(PropertyKind.VISIBILITY, new Class[] {Interface.class,
            com.topcoder.uml.model.core.classifiers.Class.class, Enumeration.class, Attribute.class, Operation.class,
            AssociationEnd.class, Actor.class, UseCase.class, Subsystem.class, Object.class});
        map.put(PropertyKind.CHANGEABILITY, new Class[] {Attribute.class, AssociationEnd.class});
        map.put(PropertyKind.INITIAL_VALUE, new Class[] {Attribute.class, AssociationEnd.class});
        map.put(PropertyKind.GUARD, new Class[] {Transition.class});
        map.put(PropertyKind.AGGREGATION, new Class[] {AssociationEnd.class});
        map.put(PropertyKind.MULTIPLICITY, new Class[] {Attribute.class, AssociationEnd.class});
        map.put(PropertyKind.KIND, new Class[] {Parameter.class});
        map.put(PropertyKind.CONCURRENCY, new Class[] {Operation.class});
        map.put(PropertyKind.ORDERING, new Class[] {AssociationEnd.class});
        map.put(PropertyKind.PARAMETERS, new Class[] {Operation.class});
        map.put(PropertyKind.STEREOTYPES, new Class[0]);
        map.put(PropertyKind.OWNER_LINK, new Class[] {Parameter.class});
        map.put(PropertyKind.SUPPLIER_LINK, new Class[] {Dependency.class});
        map.put(PropertyKind.CLIENT_LINK, new Class[] {Dependency.class});
        map.put(PropertyKind.PARENT_LINK, new Class[] {Generalization.class, Abstraction.class});
        map.put(PropertyKind.CHILD_LINK, new Class[] {Generalization.class, Abstraction.class});
        map.put(PropertyKind.ASSOCIATION_LINK, new Class[] {AssociationEnd.class});
        map.put(PropertyKind.BASE_LINK, new Class[] {Extend.class, Include.class});
        map.put(PropertyKind.EXTENSION_LINK, new Class[] {Extend.class});
        map.put(PropertyKind.ADDITION_LINK, new Class[] {Include.class});
        map.put(PropertyKind.SOURCE_LINK, new Class[] {Transition.class});
        map.put(PropertyKind.TARGET_LINK, new Class[] {Transition.class});
        map.put(PropertyKind.INCOMING_TRANSITIONS, new Class[] {StateVertex.class});
        map.put(PropertyKind.OUTGOING_TRANSITIONS, new Class[] {StateVertex.class});
        map.put(PropertyKind.ASSOCIATION_ENDS_LINK, new Class[] {Association.class});
        map.put(PropertyKind.ACTION_LINK, new Class[] {Stimulus.class});
        map.put(PropertyKind.STIMULUS_LINK, new Class[] {Action.class});
        map.put(PropertyKind.NAMESPACE_LINK, new Class[] {Dependency.class, Generalization.class,
            Abstraction.class, Association.class, Include.class, Extend.class, Object.class});
        map.put(PropertyKind.ABSTRACT, new Class[] {Package.class,
            com.topcoder.uml.model.core.classifiers.Class.class, Interface.class, Enumeration.class, Operation.class,
            Actor.class, UseCase.class, Subsystem.class});
        map.put(PropertyKind.FINAL, new Class[] {Package.class,
            com.topcoder.uml.model.core.classifiers.Class.class, Interface.class, Enumeration.class, Operation.class,
            Actor.class, UseCase.class, Subsystem.class, Parameter.class});
        map.put(PropertyKind.ROOT, new Class[] {Package.class,
            com.topcoder.uml.model.core.classifiers.Class.class, Interface.class, Enumeration.class, Actor.class,
            UseCase.class, Subsystem.class});
        map.put(PropertyKind.STATIC, new Class[] {com.topcoder.uml.model.core.classifiers.Class.class,
            Interface.class, Enumeration.class, Operation.class, Attribute.class, AssociationEnd.class});
        map.put(PropertyKind.ACTIVE, new Class[] {
            com.topcoder.uml.model.core.classifiers.Class.class});
        map.put(PropertyKind.TRANSIENT, new Class[] {Attribute.class, AssociationEnd.class});
        map.put(PropertyKind.NAVIGABLE, new Class[] {AssociationEnd.class});
        map.put(PropertyKind.ASYNCHRONOUS, new Class[] {Stimulus.class});
    }

    /**
     * Tests the method: execute, in class: ActionLinkPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testActionLinkPropertyPanelExecute() throws Exception {
        // create the ActionLinkPropertyPanel panel
        panel = new ActionLinkPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("ActionLinkPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: AdditionLinkPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testAdditionLinkPropertyPanelExecute() throws Exception {
        // create the AdditionLinkPropertyPanel panel
        panel = new AdditionLinkPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("AdditionLinkPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: AssociationLinkPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testAssociationLinkPropertyPanelExecute() throws Exception {
        // create the AssociationLinkPropertyPanel panel
        panel = new AssociationLinkPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("AssociationLinkPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: BaseLinkPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testBaseLinkPropertyPanelExecute() throws Exception {
        // create the BaseLinkPropertyPanel panel
        panel = new BaseLinkPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("BaseLinkPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: ChildLinkPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testChildLinkPropertyPanelExecute() throws Exception {
        // create the ChildLinkPropertyPanel panel
        panel = new ChildLinkPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("ChildLinkPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: ClientLinkPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testClientLinkPropertyPanelExecute() throws Exception {
        // create the ClientLinkPropertyPanel panel
        panel = new ClientLinkPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("ClientLinkPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: ExtensionLinkPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testExtensionLinkPropertyPanelExecute() throws Exception {
        // create the ExtensionLinkPropertyPanel panel
        panel = new ExtensionLinkPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("ExtensionLinkPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: NamespaceLinkPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testNamespaceLinkPropertyPanelExecute() throws Exception {
        // create the NamespaceLinkPropertyPanel panel
        panel = new NamespaceLinkPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("NamespaceLinkPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: OwnerLinkPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testOwnerLinkPropertyPanelExecute() throws Exception {
        // create the OwnerLinkPropertyPanel panel
        panel = new OwnerLinkPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("OwnerLinkPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: ParentLinkPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testParentLinkPropertyPanelExecute() throws Exception {
        // create the ParentLinkPropertyPanel panel
        panel = new ParentLinkPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("ParentLinkPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: SourceLinkPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testSourceLinkPropertyPanelExecute() throws Exception {
        // create the SourceLinkPropertyPanel panel
        panel = new SourceLinkPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("SourceLinkPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: StimulusLinkPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testStimulusLinkPropertyPanelExecute() throws Exception {
        // create the StimulusLinkPropertyPanel panel
        panel = new StimulusLinkPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("StimulusLinkPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: SupplierLinkPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testSupplierLinkPropertyPanelExecute() throws Exception {
        // create the SupplierLinkPropertyPanel panel
        panel = new SupplierLinkPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("SupplierLinkPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: TargetLinkPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testTargetLinkPropertyPanelExecute() throws Exception {
        // create the TargetLinkPropertyPanel panel
        panel = new TargetLinkPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("TargetLinkPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: AggregationPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testAggregationPropertyPanelExecute() throws Exception {
        // create the AggregationPropertyPanel panel
        panel = new AggregationPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("AggregationPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: AssociationEndsPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testAssociationEndsPropertyPanelExecute() throws Exception {
        // create the AssociationEndsPropertyPanel panel
        panel = new AssociationEndsPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("AssociationEndsPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: ChangeabilityPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testChangeabilityPropertyPanelExecute() throws Exception {
        // create the ChangeabilityPropertyPanel panel
        panel = new ChangeabilityPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("ChangeabilityPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: ConcurrencyPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testConcurrencyPropertyPanelExecute() throws Exception {
        // create the ConcurrencyPropertyPanel panel
        panel = new ConcurrencyPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("ConcurrencyPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: GuardPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testGuardPropertyPanelExecute() throws Exception {
        // create the GuardPropertyPanel panel
        panel = new GuardPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("GuardPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: IncomingTransitionPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testIncomingTransitionPropertyPanelExecute() throws Exception {
        // create the IncomingTransitionPropertyPanel panel
        panel = new IncomingTransitionPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("IncomingTransitionPropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: InitialValuePropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testInitialValuePropertyPanelExecute() throws Exception {
        // create the InitialValuePropertyPanel panel
        panel = new InitialValuePropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("InitialValuePropertyPanel#execute");
    }

    /**
     * Tests the method: execute, in class: KindPropertyPanel.
     *
     * @throws Exception to JUnit
     *
     */
    public void testKindPropertyPanelExecute() throws Exception {
        // create the KindPropertyPanel panel
        panel = new KindPropertyPanel(panels);

        // config the panel
        panel.configurePanel(elements);
        // use reflection to make it visible
        Field f = panel.getClass().getSuperclass().getDeclaredField("visible");
        f.setAccessible(true);
        f.setBoolean(panel, true);
        assertTrue(panel.isVisible());

        startIt();
        for (int i = 0; i < STRESS_TEST_NUM; i++) {
            panel.execute();
        }
        stopIt("KindPropertyPanel#execute");
    }


}
