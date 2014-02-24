/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Tool_Actions_-_Diagram_Actions Version 1.0 Accuracytests.
 *
 * @ CreateDiagramActionAccuracyTests.java
 */
package com.topcoder.uml.actions.diagram.accuracytests;

import com.topcoder.uml.actions.diagram.CreateDiagramAction;
import com.topcoder.uml.model.core.Element;


/**
 * <p>
 * A inner class which extends the <code>CreateDiagramAction</code> class, used for
 * accuracy test only.
 * Here it make the protected method visiable.
 * </p>
 *
 * @author icyriver
 * @version 1.0
 */
class MockCreateDiagramAction extends CreateDiagramAction {
    /**
    * <p>
    * Creates an instance of <code>MockCreateDiagramAction</code>.
    * </p>
    *
    * <p>
    * <strong>Note</strong>: It simply call <code>super</code> to make
    * the protected method visiable.
    * </p>
    *
    * @param type the type of the diagram.
    * @param owner the owner of the diagram.
    * @param name the name of the diagram.
    */
    public MockCreateDiagramAction(String type, Element owner, String name) {
        super(type, owner, name);
    }

    /**
     * <p>
     * Simply call <code>super</code> to make the protected method visiable.
     * </p>
     */
    public void executeAction() {
        super.executeAction();
    }

    /**
     * <p>
     * Simply call <code>super</code> to make the protected method visiable.
     * </p>
     */
    public void redoAction() {
        super.redoAction();
    }

    /**
     * <p>
     * Simply call <code>super</code> to make the protected method visiable.
     * </p>
     */
    public void undoAction() {
        super.undoAction();
    }
}
