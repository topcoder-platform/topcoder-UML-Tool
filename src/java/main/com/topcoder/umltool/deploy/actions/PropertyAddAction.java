/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.uml.actions.model.classifiers.feature.AddAttributeAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.StructuralFeatureAbstractImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.FeatureAddAction;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;


/**
 * <p>
 * This class is the base class add properties for attribute.
 * </p>
 * @author sempiq
 * @version 1.0
 */
public class PropertyAddAction extends FeatureAddAction {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    private Attribute attribute;

	private String stereotype;

    /**
     * <p>
     * Creates an instance of <code>AttributeAddAction</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @param attribute
     *            target attribute
     * @param stereotype
     *            name of stereotype added for property
     *
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public PropertyAddAction(MainFrame mainframe, Attribute attribute, String stereotype) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        DeployHelper.checkNotNull(attribute, "attribute");
        DeployHelper.checkNotNull(stereotype, "stereotype");
        this.mainFrame = mainframe;
        this.attribute = attribute;
        this.stereotype = stereotype;
    }

    /**
     * <p>
     * Adds a property for attribute to node.
     * </p>
     * @param e
     *            action event
     */
    public void actionPerformed(ActionEvent e) {
        ClassNode classNode = getClassNode();
        GraphNode graphNode = classNode.getGraphNode();
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(classNode, "Attribute added");

        // Fix BUGR-490, replace the default int type with the attribute type
        Attribute propAttribute = DeployHelper.createAttribute(DeployHelper.firstToUpperCase(attribute.getName()),
                attribute.getType().getName());
        StructuralFeatureAbstractImpl.setType(attribute, attribute.getType());
        Stereotype s = DeployHelper.getStereotype(mainFrame, stereotype, AttributeImpl.class);
        // Fix BUGR-548, add the stereotype to the model with the PropertiesPanel.addStereotypes method
        Set<Stereotype> stereotypes = new HashSet<Stereotype>();
        stereotypes.add(s);
        mainFrame.getPropertiesPanel().addStereotypes(stereotypes, attribute.getClass());

        propAttribute.addStereotype(s);
		propAttribute.setVisibility(VisibilityKind.PUBLIC);
        Classifier classifier = (Classifier) DeployHelper.getElement(graphNode);

        // FIXME remove this code after AddAttributeAction is fixed
        propAttribute.setOwner(classifier);

        AddAttributeAction addAttributeAction = new AddAttributeAction(classifier, propAttribute);
        compositeAction.put(addAttributeAction, classNode);

        mainFrame.handleActionEvent(compositeAction, classNode, "Attribute added");
    }

}
