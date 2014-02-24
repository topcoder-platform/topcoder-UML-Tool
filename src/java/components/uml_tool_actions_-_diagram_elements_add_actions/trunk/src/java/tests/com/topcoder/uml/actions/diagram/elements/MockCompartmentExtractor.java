/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentMalformedException;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentNotFoundException;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentNotSupportedException;

/**
 * <p>
 * This is a mock implementation of CompartmentExtractor interface.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockCompartmentExtractor implements CompartmentExtractor {
    /**
     * <p>
     * The graph element instance used as the return value in the extractXXX() method.
     * </p>
     */
    private GraphElement element = new GraphNode();

    /**
     * <p>
     * Implements the extractName() method.
     * </p>
     *
     * @return a graph element instance
     *
     * @throws CompartmentNotSupportedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotSupportedException&quot;
     * @throws CompartmentNotFoundException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotFoundException&quot;
     * @throws CompartmentMalformedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentMalformedException&quot;
     */
    public GraphElement extractName() throws CompartmentNotSupportedException, CompartmentNotFoundException,
        CompartmentMalformedException {
        if ("CompartmentNotSupportedException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotSupportedException("exception.");
        }
        if ("CompartmentNotFoundException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotFoundException("exception.");
        }
        if ("CompartmentMalformedException".equals(System.getProperty("exception"))) {
            throw new CompartmentMalformedException("exception.");
        }

        return element;
    }

    /**
     * <p>
     * Implements the updateName(GraphElement) method.
     * </p>
     *
     * @param newElement a new graph element instance
     *
     * @throws CompartmentNotSupportedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotSupportedException&quot;
     * @throws CompartmentNotFoundException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotFoundException&quot;
     * @throws CompartmentMalformedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentMalformedException&quot;
     */
    public void updateName(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException {
        if ("CompartmentNotSupportedException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotSupportedException("exception.");
        }
        if ("CompartmentNotFoundException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotFoundException("exception.");
        }
        if ("CompartmentMalformedException".equals(System.getProperty("exception"))) {
            throw new CompartmentMalformedException("exception.");
        }

        // Modify the GraphElment in order for testing.
        Diagram diagram = new Diagram();
        diagram.setName("updateName");

        element.setContainer(diagram);
    }

    /**
     * <p>
     * Implements the extractNamespace() method.
     * </p>
     *
     * @return a graph element instance
     *
     * @throws CompartmentNotSupportedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotSupportedException&quot;
     * @throws CompartmentNotFoundException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotFoundException&quot;
     * @throws CompartmentMalformedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentMalformedException&quot;
     */
    public GraphElement extractNamespace() throws CompartmentNotSupportedException, CompartmentNotFoundException,
        CompartmentMalformedException {
        if ("CompartmentNotSupportedException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotSupportedException("exception.");
        }
        if ("CompartmentNotFoundException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotFoundException("exception.");
        }
        if ("CompartmentMalformedException".equals(System.getProperty("exception"))) {
            throw new CompartmentMalformedException("exception.");
        }

        return element;
    }

    /**
     * <p>
     * Implements the updateNamespace(GraphElement) method.
     * </p>
     *
     * @param newElement a new graph element instance
     *
     * @throws CompartmentNotSupportedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotSupportedException&quot;
     * @throws CompartmentNotFoundException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotFoundException&quot;
     * @throws CompartmentMalformedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentMalformedException&quot;
     */
    public void updateNamespace(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException {
        if ("CompartmentNotSupportedException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotSupportedException("exception.");
        }
        if ("CompartmentNotFoundException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotFoundException("exception.");
        }
        if ("CompartmentMalformedException".equals(System.getProperty("exception"))) {
            throw new CompartmentMalformedException("exception.");
        }

        // Modify the GraphElment in order for testing.
        Diagram diagram = new Diagram();
        diagram.setName("updateNamespace");

        element.setContainer(diagram);
    }

    /**
     * <p>
     * Implements the extractStereotype() method.
     * </p>
     *
     * @return a graph element instance
     *
     * @throws CompartmentNotSupportedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotSupportedException&quot;
     * @throws CompartmentNotFoundException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotFoundException&quot;
     * @throws CompartmentMalformedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentMalformedException&quot;
     */
    public GraphElement extractStereotype() throws CompartmentNotSupportedException, CompartmentNotFoundException,
        CompartmentMalformedException {
        if ("CompartmentNotSupportedException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotSupportedException("exception.");
        }
        if ("CompartmentNotFoundException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotFoundException("exception.");
        }
        if ("CompartmentMalformedException".equals(System.getProperty("exception"))) {
            throw new CompartmentMalformedException("exception.");
        }

        return element;
    }

    /**
     * <p>
     * Implements the updateStereotype(GraphElement) method.
     * </p>
     *
     * @param newElement a new graph element instance
     *
     * @throws CompartmentNotSupportedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotSupportedException&quot;
     * @throws CompartmentNotFoundException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotFoundException&quot;
     * @throws CompartmentMalformedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentMalformedException&quot;
     */
    public void updateStereotype(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException {
        if ("CompartmentNotSupportedException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotSupportedException("exception.");
        }
        if ("CompartmentNotFoundException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotFoundException("exception.");
        }
        if ("CompartmentMalformedException".equals(System.getProperty("exception"))) {
            throw new CompartmentMalformedException("exception.");
        }

        // Modify the GraphElment in order for testing.
        Diagram diagram = new Diagram();
        diagram.setName("updateStereotype");

        element.setContainer(diagram);
    }

    /**
     * <p>
     * Implements the extractFirstAssociationEnd() method.
     * </p>
     *
     * @return a graph element instance
     *
     * @throws CompartmentNotSupportedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotSupportedException&quot;
     * @throws CompartmentNotFoundException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotFoundException&quot;
     * @throws CompartmentMalformedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentMalformedException&quot;
     */
    public GraphElement extractFirstAssociationEnd() throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException {
        if ("CompartmentNotSupportedException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotSupportedException("exception.");
        }
        if ("CompartmentNotFoundException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotFoundException("exception.");
        }
        if ("CompartmentMalformedException".equals(System.getProperty("exception"))) {
            throw new CompartmentMalformedException("exception.");
        }

        return element;
    }

    /**
     * <p>
     * Implements the updateFirstAssociationEnd(GraphElement) method.
     * </p>
     *
     * @param newElement a new graph element instance
     *
     * @throws CompartmentNotSupportedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotSupportedException&quot;
     * @throws CompartmentNotFoundException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotFoundException&quot;
     * @throws CompartmentMalformedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentMalformedException&quot;
     */
    public void updateFirstAssociationEnd(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException {
        if ("CompartmentNotSupportedException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotSupportedException("exception.");
        }
        if ("CompartmentNotFoundException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotFoundException("exception.");
        }
        if ("CompartmentMalformedException".equals(System.getProperty("exception"))) {
            throw new CompartmentMalformedException("exception.");
        }

        // Modify the GraphElment in order for testing.
        Diagram diagram = new Diagram();
        diagram.setName("updateFirstAssociationEnd");

        element.setContainer(diagram);
    }

    /**
     * <p>
     * Implements the extractSecondAssociationEnd() method.
     * </p>
     *
     * @return a graph element instance
     *
     * @throws CompartmentNotSupportedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotSupportedException&quot;
     * @throws CompartmentNotFoundException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotFoundException&quot;
     * @throws CompartmentMalformedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentMalformedException&quot;
     */
    public GraphElement extractSecondAssociationEnd() throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException {
        if ("CompartmentNotSupportedException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotSupportedException("exception.");
        }
        if ("CompartmentNotFoundException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotFoundException("exception.");
        }
        if ("CompartmentMalformedException".equals(System.getProperty("exception"))) {
            throw new CompartmentMalformedException("exception.");
        }

        return element;
    }

    /**
     * <p>
     * Implements the updateSecondAssociationEnd(GraphElement) method.
     * </p>
     *
     * @param newElement a new graph element instance
     *
     * @throws CompartmentNotSupportedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotSupportedException&quot;
     * @throws CompartmentNotFoundException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotFoundException&quot;
     * @throws CompartmentMalformedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentMalformedException&quot;
     */
    public void updateSecondAssociationEnd(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException {
        if ("CompartmentNotSupportedException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotSupportedException("exception.");
        }
        if ("CompartmentNotFoundException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotFoundException("exception.");
        }
        if ("CompartmentMalformedException".equals(System.getProperty("exception"))) {
            throw new CompartmentMalformedException("exception.");
        }

        // Modify the GraphElment in order for testing.
        Diagram diagram = new Diagram();
        diagram.setName("updateSecondAssociationEnd");

        element.setContainer(diagram);
    }

    /**
     * <p>
     * Implements the extractAttribute() method.
     * </p>
     *
     * @return a graph element instance
     *
     * @throws CompartmentNotSupportedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotSupportedException&quot;
     * @throws CompartmentNotFoundException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotFoundException&quot;
     * @throws CompartmentMalformedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentMalformedException&quot;
     */
    public GraphElement extractAttribute() throws CompartmentNotSupportedException, CompartmentNotFoundException,
        CompartmentMalformedException {
        if ("CompartmentNotSupportedException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotSupportedException("exception.");
        }
        if ("CompartmentNotFoundException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotFoundException("exception.");
        }
        if ("CompartmentMalformedException".equals(System.getProperty("exception"))) {
            throw new CompartmentMalformedException("exception.");
        }

        return element;
    }

    /**
     * <p>
     * Implements the updateAttribute(GraphElement) method.
     * </p>
     *
     * @param newElement a new graph element instance
     *
     * @throws CompartmentNotSupportedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotSupportedException&quot;
     * @throws CompartmentNotFoundException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotFoundException&quot;
     * @throws CompartmentMalformedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentMalformedException&quot;
     */
    public void updateAttribute(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException {
        if ("CompartmentNotSupportedException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotSupportedException("exception.");
        }
        if ("CompartmentNotFoundException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotFoundException("exception.");
        }
        if ("CompartmentMalformedException".equals(System.getProperty("exception"))) {
            throw new CompartmentMalformedException("exception.");
        }

        // Modify the GraphElment in order for testing.
        Diagram diagram = new Diagram();
        diagram.setName("updateAttribute");

        element.setContainer(diagram);
    }

    /**
     * <p>
     * Implements the extractOperation() method.
     * </p>
     *
     * @return a graph element instance
     *
     * @throws CompartmentNotSupportedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotSupportedException&quot;
     * @throws CompartmentNotFoundException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotFoundException&quot;
     * @throws CompartmentMalformedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentMalformedException&quot;
     */
    public GraphElement extractOperation() throws CompartmentNotSupportedException, CompartmentNotFoundException,
        CompartmentMalformedException {
        if ("CompartmentNotSupportedException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotSupportedException("exception.");
        }
        if ("CompartmentNotFoundException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotFoundException("exception.");
        }
        if ("CompartmentMalformedException".equals(System.getProperty("exception"))) {
            throw new CompartmentMalformedException("exception.");
        }

        return element;
    }

    /**
     * <p>
     * Implements the updateOperation(GraphElement) method.
     * </p>
     *
     * @param newElement a new graph element instance
     *
     * @throws CompartmentNotSupportedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotSupportedException&quot;
     * @throws CompartmentNotFoundException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentNotFoundException&quot;
     * @throws CompartmentMalformedException if the value of system property
     * &quot;exception&quot; is &quot;CompartmentMalformedException&quot;
     */
    public void updateOperation(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException {
        if ("CompartmentNotSupportedException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotSupportedException("exception.");
        }
        if ("CompartmentNotFoundException".equals(System.getProperty("exception"))) {
            throw new CompartmentNotFoundException("exception.");
        }
        if ("CompartmentMalformedException".equals(System.getProperty("exception"))) {
            throw new CompartmentMalformedException("exception.");
        }

        // Modify the GraphElment in order for testing.
        Diagram diagram = new Diagram();
        diagram.setName("updateOperation");

        element.setContainer(diagram);
    }

    /**
     * <p>
     * Return the graph element that is returned in the extractXXX() methods.
     * </p>
     *
     * @return the graph element that is returned in the extractXXX() methods.
     */
    public GraphElement getGraphElement() {
        return element;
    }

    /**
     * <p>
     * Set the graph element that will be returned in the extractXXX() methods.
     * </p>
     *
     * @param element the graph element that will be returned in the extractXXX()
     * methods
     */
    public void setGraphElement(GraphElement element) {
        this.element = element;
    }

}
