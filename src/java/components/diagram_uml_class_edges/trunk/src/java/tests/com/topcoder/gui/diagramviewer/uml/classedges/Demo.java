/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextChangeEvent;
import com.topcoder.gui.diagramviewer.uml.classedges.event.TextChangeListener;
import com.topcoder.uml.model.core.relationships.Association;

import junit.framework.TestCase;

/**
 * <p>
 * Demonstrates the usage of this component.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class Demo extends TestCase {

    /**
     * <p>
     * Demonstrates the usage of <code>AssociationEdge</code>.
     * Other kinds of edges can be used in the same way.
     * </p>
     *
     * @throws Exception
     */
    public void testDemo() throws Exception {
        //Create an instance of edge
        AssociationEdge assocEdge = new AssociationEdge(UnitTestsHelper.createGraphEdgeForAssociationEdge());

        //Register text change listener to name compartment
        assocEdge.getNameCompartment().addTextChangeListener(new NameChangeListener());

        //Retrieve compartments
        TextField nameCompartments = assocEdge.getNameCompartment();
        TextField stereotypeCompartments = assocEdge.getStereotypeCompartment();

        //Set up popup menu
        assocEdge.setComponentPopupMenu(UnitTestsHelper.createPopupMenu());

        //Work with edge endings
        ActiveEdgeEnding edgeEnding = (ActiveEdgeEnding) assocEdge.getLeftEnding();
        TextField name = edgeEnding.getNameCompartment();
        TextField multiplicity = edgeEnding.getMultiplicityCompartment();
        edgeEnding.nameVisibleWhenSelected(true);
        edgeEnding.multiplicityVisibleWhenSelected(false);
        edgeEnding.setHideNameText("");

        //Hiding compartments
        edgeEnding.nameVisible(false);
        assocEdge.notifyNameVisibilityChanged();
    }

    /**
     * <p>
     * This is a mock implementation of TextChangeListener interface. It is only used for testing.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    private class NameChangeListener implements TextChangeListener {
        /**
         * <p>
         * Constructs this listener with the given event.
         * </p>
         *
         * @param e The instance of the TextChangeEvent class.
         */
        public void textChange(TextChangeEvent e) {
            //Retrieve the text field and edge
            TextField textField = (TextField) e.getSource();
            AssociationEdge ascEdge = (AssociationEdge) textField.getParent();

            //Get model element
            Uml1SemanticModelBridge semanticModelBridge = (Uml1SemanticModelBridge)
                ascEdge.getGraphEdge().getSemanticModel();
            Association modelElement = (Association) semanticModelBridge.getElement();

            //Change the name
            modelElement.setName(e.getNewText());

            try {
                //Notify
                ascEdge.notifyGraphEdgeChange("element name changed");
            } catch (Exception exc) {
                //ignore
            }
        }
    }
}
