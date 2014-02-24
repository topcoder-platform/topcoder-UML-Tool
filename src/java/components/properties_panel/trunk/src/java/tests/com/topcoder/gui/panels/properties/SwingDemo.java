/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.topcoder.uml.model.actions.messagingactions.SendSignalAction;
import com.topcoder.uml.model.actions.messagingactions.SendSignalActionImpl;
import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;
import com.topcoder.uml.model.statemachines.FinalStateImpl;
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
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.procedure.Procedure;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.model.datatypes.ParameterDirectionKind;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * This is a demo frame for using the functionalities provided by this swing component.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class SwingDemo extends JFrame {
    /**
     * <p>
     * The content panel of this frame.
     * </p>
     */
    private JPanel jContentPane;

    /**
     * <p>
     * The <b>configure</b> used to configure the properties panel.
     * </p>
     */
    private final JButton configureBtn;

    /**
     * <p>
     * The properties panel of this frame.
     * </p>
     */
    private final PropertiesPanel propertiesPanel;

    /**
     * <p>
     * Represents the names for all the check boxes.
     * </p>
     */
    private final String[] checkBoxNames;

    /**
     * <p>
     * Represents all the check boxes used in this demo.
     * </p>
     */
    private final JCheckBox[] checkBoxes;

    /**
     * <p>
     * Represents the mapping from the check box name to its ModelElement instance.
     * </p>
     */
    private final Map<String, ModelElement> mapping = new HashMap<String, ModelElement>();

    /**
     * <p>
     * This is the default constructor.
     * </p>
     *
     * @throws Exception if any exception occurs
     */
    public SwingDemo() throws Exception {
        checkBoxNames = new String[] {"Package", "Interface", "Class", "Enumeration", "Object", "Attribute",
            "Operation", "Parameter", "Dependency", "Generalization", "Abstraction", "Association", "AssociationEnd",
            "Actor", "UseCase", "Subsystem", "Extend", "Include", "ObjectFlowState", "ActionState", "SendSignalAction",
            "Stimulus", "Transition"};

        checkBoxes = new JCheckBox[checkBoxNames.length];
        for (int i = 0; i < checkBoxNames.length; i++) {
            checkBoxes[i] = new JCheckBox(checkBoxNames[i]);
        }

        UMLModelManager manager = TestHelper.createUMLModelManager();
        Model model = manager.getModel();

        // The Package ModelElement
        Package packageObject = new PackageImpl();
        model.addOwnedElement(packageObject);
        packageObject.setName("Properties Panel Package");
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("final");
        packageObject.addStereotype(stereotype);

        mapping.put("Package", packageObject);

        // The Interface ModelElement
        Interface interfaceObject = new InterfaceImpl();
        interfaceObject.setName("Properties Panel Interface");
        interfaceObject.setNamespace(packageObject);
        packageObject.addOwnedElement(interfaceObject);
        mapping.put("Interface", interfaceObject);

        // The Class ModelElement
        Class classObject = new ClassImpl();
        classObject.setName("Properties Panel Class");
        mapping.put("Class", classObject);

        // The Enumeration ModelElement
        Enumeration enumeration = new EnumerationImpl();
        enumeration.setName("Properties Panel Enumeration");
        mapping.put("Enumeration", enumeration);

        // The Object ModelElement
        Object object = new ObjectImpl();
        object.setName("Properties Panel Object");

        object.setNamespace(packageObject);
        packageObject.addOwnedElement(object);

        mapping.put("Object", object);

        // The Attribute ModelElement
        Attribute attribute = new AttributeImpl();
        attribute.setName("Properties Panel Attribute");
        attribute.setOwner(classObject);
        mapping.put("Attribute", attribute);

        // The Parameter ModelElement
        Parameter parameter = new ParameterImpl();
        parameter.setName("Properties Panel Parameter");
        mapping.put("Parameter", parameter);

        // The return Parameter ModelElement
        Parameter returnParameter = new ParameterImpl();
        parameter.setName("Properties Panel Parameter Return");
        parameter.setKind(ParameterDirectionKind.RETURN);

        // The Operation ModelElement
        Operation operation = new OperationImpl();
        operation.setName("Properties Panel Operation");
        operation.addParameter(parameter);
        operation.addParameter(returnParameter);
        parameter.setBehavioralFeature(operation);
        mapping.put("Operation", operation);

        // The Dependency ModelElement
        Dependency dependency = new DependencyImpl();
        dependency.setName("Properties Panel Dependency");
        dependency.addSupplier(parameter);
        dependency.addClient(attribute);
        dependency.setNamespace(packageObject);
        mapping.put("Dependency", dependency);

        // The Generalization ModelElement
        Generalization generalization = new GeneralizationImpl();
        generalization.setName("Properties Panel Generalization");
        mapping.put("Generalization", generalization);

        // The Abstraction ModelElement
        Abstraction abstraction = new AbstractionImpl();
        abstraction.setName("Properties Panel Abstraction");
        mapping.put("Abstraction", abstraction);

        // The Association ModelElement
        Association association = new AssociationImpl();
        association.setName("Properties Panel Association");

        AssociationEnd firstEnd = new AssociationEndImpl();
        firstEnd.setName("First Association End");
        association.addConnection(firstEnd);
        firstEnd.setAssociation(association);

        mapping.put("Association", association);

        // The AssociationEnd ModelElement
        AssociationEnd end = new AssociationEndImpl();
        end.setName("Properties Panel AssociationEnd");

        association.addConnection(end);
        end.setAssociation(association);

        mapping.put("AssociationEnd", end);

        // The Actor ModelElement
        Actor actor = new ActorImpl();
        actor.setName("Properties Panel Actor");
        mapping.put("Actor", actor);

        // The UseCase ModelElement
        UseCase useCase = new UseCaseImpl();
        useCase.setName("Properties Panel UseCase");
        mapping.put("UseCase", useCase);

        // The Subsystem ModelElement
        Subsystem subSystem = new SubsystemImpl();
        subSystem.setName("Properties Panel Subsystem");
        mapping.put("Subsystem", subSystem);

        // The Extend ModelElement
        Extend extend = new ExtendImpl();
        extend.setName("Properties Panel Extend");

        extend.setNamespace(packageObject);
        packageObject.addOwnedElement(extend);

        extend.setExtension(useCase);
        extend.setBase(useCase);
        useCase.addExtend(extend);
        useCase.addExtender(extend);

        mapping.put("Extend", extend);

        // The Include ModelElement
        Include include = new IncludeImpl();
        include.setName("Properties Panel Include");
        mapping.put("Include", include);

        // The ObjectFlowState ModelElement
        ObjectFlowState objectFlowState = new ObjectFlowStateImpl();
        objectFlowState.setName("Properties Panel ObjectFlowState");
        mapping.put("ObjectFlowState", objectFlowState);

        // The ActionState ModelElement
        ActionState actionState = new ActionStateImpl();
        actionState.setName("Properties Panel ActionState");
        mapping.put("ActionState", actionState);

        // The SendSignalAction ModelElement
        SendSignalAction sendSignalAction = new SendSignalActionImpl();
        sendSignalAction.setName("Properties Panel SendSignalAction");
        mapping.put("SendSignalAction", sendSignalAction);

        // The Stimulus ModelElement
        Stimulus stimlus = new StimulusImpl();
        stimlus.setName("Properties Panel Stimulus");

        Procedure procedure = new ProcedureImpl();
        procedure.setAction(sendSignalAction);
        stimlus.setDispatchAction(procedure);
        procedure.addStimulus(stimlus);

        mapping.put("Stimulus", stimlus);

        // The Transition ModelElement
        Transition transition = new TransitionImpl();
        transition.setName("Properties Panel Transition");
        StateVertex source = new FinalStateImpl();
        source.setName("A");
        transition.setSource(source);
        StateVertex target = new FinalStateImpl();
        target.setName("B");
        transition.setTarget(target);

        actionState.addIncomingTransition(transition);
        actionState.addOutgoingTransition(transition);

        mapping.put("Transition", transition);

        propertiesPanel = new PropertiesPanel(TestHelper.NAMESPACE, manager);

        configureBtn = new JButton("Configure");

        initialize();
    }

    /**
     * <p>
     * This method initializes the widgets in this frame.
     * </p>
     *
     * @throws Exception if any exception occurs
     */
    public void initialize() throws Exception {
        this.setContentPane(getJContentPane());
        this.setTitle("Frame Demo");
    }

    /**
     * <p>
     * This method initializes jContentPane.
     * </p>
     *
     * @return the content panel for this frame.
     *
     * @throws Exception if any exception occurs
     */
    public JPanel getJContentPane() throws Exception {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(new BorderLayout());

            JPanel centerPanel = new JPanel();
            centerPanel.setLayout(new GridLayout(6, 4));

            for (JCheckBox checkBox : checkBoxes) {
                centerPanel.add(checkBox);
            }

            jContentPane.add(centerPanel, BorderLayout.NORTH);

            propertiesPanel.addModelElementChangeListener(new ModelElementChangeLogger());
            propertiesPanel.addModelElementSelectionListener(new ModelElementSelectionLogger());

            jContentPane.add(propertiesPanel, BorderLayout.CENTER);

            JPanel southPanel = new JPanel();
            configureBtn.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    configurePropertiesPanel();
                }
            });
            southPanel.add(configureBtn);
            jContentPane.add(southPanel, BorderLayout.SOUTH);
        }

        return jContentPane;
    }

    /**
     * <p>
     * This method will configure the properties panel based on the model elemented selected by the user.
     * </p>
     */
    private void configurePropertiesPanel() {
        List<ModelElement> modelElements = new ArrayList<ModelElement>();

        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                modelElements.add(mapping.get(checkBox.getText()));
            }
        }

        if (modelElements.size() > 0) {
            propertiesPanel.configurePanel(modelElements);
        }
    }

    /**
     * <p>
     * Return the configure button in this demo.
     * </p>
     *
     * @return the configure button in this demo.
     */
    public JButton getConfigureButton() {
        return configureBtn;
    }

    /**
     * <p>
     * Return all the check boxes in this demo.
     * </p>
     *
     * @return all the check boxes in this demo.
     */
    public JCheckBox[] getCheckBoxes() {
        return checkBoxes;
    }

    /**
     * <p>
     * Return the properties panel in this demo.
     * </p>
     *
     * @return the properties panel in this demo.
     */
    public PropertiesPanel getPropertiesPanel() {
        return propertiesPanel;
    }

    /**
     * <p>
     * This class implements ModelElementChangeListener interface and is used to receive the state change
     * and log the event.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    private class ModelElementChangeLogger implements ModelElementChangeListener {
        /**
         * <p>
         * Logs the event when a property value corresponding to this property panel is changed.
         * </p>
         *
         * @param modelElement the ModelElement whose properties were asked to be modified
         * @param property the modified property name
         * @param op the kind of operation to be done on the property
         * @param o the Object that will be added/removed or modify the property (depending on
         * PropertyOperation type)
         */
        public void stateChanged(ModelElement modelElement, PropertyKind property, PropertyOperation op,
            java.lang.Object o) {
            System.out.println("Receive State Changed Event : ModelElement is of ["
                + modelElement.getClass().getSimpleName() + "] type, Property kind is [" + property
                + "], property operation is [" + op + "], the object is of ["
                + (o == null ? null : o.getClass().getSimpleName()) + "] type, value is ["
                + (o == null ? null : o.toString()) + "]");
        }
    }

    /**
     * <p>
     * This class implements ModelElementSelectionListener interface and is used to receive the selection
     * change and log the event.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    private class ModelElementSelectionLogger implements ModelElementSelectionListener {
        /**
         * <p>
         * Logs the event when a different <code>ModelElement</code> is selected due to action
         * within the Properties Panel component.
         * </p>
         *
         * @param modelElement the newly selected ModelElement
         */
        public void selectionChanged(ModelElement modelElement) {
            System.out.println("Receive Selection Changed Event : ModelElement is of ["
                + modelElement.getClass().getSimpleName() + "] type");
        }
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     *
     * @throws Exception to JUnit
     */
    public static void main(String[] args) throws Exception {
        TestHelper.loadConfigurations();

        SwingDemo frameDemo = new SwingDemo();

        frameDemo.addWindowListener(new WindowAdapter() {
            /**
             * <p>
             * This method handles the situation when the frame is closing.
             * </p>
             *
             * <p>
             * The namespaces are cleared in this method.
             * </p>
             *
             * @param event a window event instance
             */
            public void windowClosing(WindowEvent event) {
                super.windowClosing(event);

                try {
                    TestHelper.clearConfig();
                } catch (UnknownNamespaceException e) {
                    // ignore
                }
            }
        });

        frameDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameDemo.setSize(new Dimension(900, 400));
        frameDemo.setVisible(true);
    }
}
