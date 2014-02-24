/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_UML_Use_Case Elements Version 1.0 StressTest.
 *
 * @ StressTestHelper.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.stresstests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.modelmanagement.SubsystemImpl;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.uml.model.usecases.UseCaseImpl;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>Helper class to simplify the stress testing.</p>
 *
 * @author zmg
 * @version 1.0
 */
final class StressTestHelper {
    /**
     * <p>
     * The int number represents the Subsystem type.</p>
     */
    private static final int SUBSYSTEM = 1;

    /**
     * <p>
     * The int number represents the UseCase type.</p>
     */
    private static final int USECASE = 2;

    /**
     * <p>
     * The int number represents the Actor type.</p>
     */
    private static final int ACTOR = 3;

    /**
         * <p>
         * The private constructor to avoid creating instance of this class.
         * </p>
         */
    private StressTestHelper() {
    }

    /**
     * <p>
     * Gets an instance of <code>Uml1SemanticModelBridge</code> with the given element.
     * </p>
     *
     * @param element the Element used to set the <code>Uml1SemanticModelBridge</code>.
     *
     * @return an instance of <code>Uml1SemanticModelBridge</code> that contains the
     *         given element.
     */
    static Uml1SemanticModelBridge getBridge(Element element) {
        // creat the Uml1SemanticModelBridge.
        Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        bridge.setElement(element);

        return bridge;
    }

    /**
     * <p>
     * Gets an instance of <code>Element</code> with the given type.
     * </p>
     *
     * @param type the type used to tell what <code>Element</code> instance
     *             should be created.
     *
     * @return an instance of <code>Element</code>.
     */
    static Element getElement(int type) {
        Classifier element;

        switch (type) {
        case SUBSYSTEM:
            element = new SubsystemImpl();

            break;

        case USECASE:
            element = new UseCaseImpl();

            break;

        case ACTOR:
            element = new ActorImpl();

            break;

        default:
            element = null;
        }

        element.setName("topcoderSoft");

        Namespace namesapce = new NamespaceImpl();
        namesapce.setName("com.topcoder.soft");
        element.setNamespace(namesapce);

        Stereotype stereotype1 = new StereotypeImpl();
        stereotype1.setName("type1");

        Stereotype stereotype2 = new StereotypeImpl();
        stereotype2.setName("type2");

        element.addStereotype(stereotype1);
        element.addStereotype(stereotype2);

        return element;
    }

    /**
     * <p>
     * Gets an instance of <code>Element</code> with the given type.
     * </p>
     *
     * @param element the Element used to set the <code>Uml1SemanticModelBridge</code>.
     *
     * @return an instance of <code>Element</code>.
     */
    static Element getEdgeElement() {
        Include element = new IncludeImpl();
        element.setName("topcoderSoft");

        Namespace namesapce = new NamespaceImpl();
        namesapce.setName("com.topcoder.soft");
        element.setNamespace(namesapce);

        Stereotype stereotype1 = new StereotypeImpl();
        stereotype1.setName("type1");

        Stereotype stereotype2 = new StereotypeImpl();
        stereotype2.setName("type2");

        element.addStereotype(stereotype1);
        element.addStereotype(stereotype2);

        return element;
    }

    /**
     * <p>Create the instance of <code>Property</code>.</p>
     *
     * @param key the key of the <code>Property</code>.
     * @param value the value of the <code>Property</code>.
     *
     * @return the created instance of the <code>Property</code>.
     */
    static Property createProperty(String key, String value) {
        Property property = new Property();

        // set the key and value here.
        property.setKey(key);
        property.setValue(value);

        return property;
    }

    /**
     * <p>
     * Gets an instance of <code>GraphNode</code> that represents the
     * base node for accuracy tests.
     * </p>
     *
     * @param type the type used to tell what <code>Element</code> instance
     *             should be created.
     *
     * @return an instance of <code>GraphNode</code> that represents the
     *         base node.
     */
    static GraphNode getGraphNode(int type) {
        //  set the properties of graphNode here.
        GraphNode graphNode = new GraphNode();
        graphNode.addProperty(StressTestHelper.createProperty("font_color",
                "FF0000"));
        graphNode.addProperty(StressTestHelper.createProperty("font_family",
                "Arial Black"));
        graphNode.addProperty(StressTestHelper.createProperty("font_size", "9"));

        // set the position and size of graphNode.
        graphNode.setSize(createDimension(40, 80));
        graphNode.setPosition(createPoint(10, 20));

        Element element = getElement(type);
        graphNode.setSemanticModel(getBridge(element));

        return graphNode;
    }

    /**
     * <p>Create the instance of <code>Dimension</code>.</p>
     *
     * @param width the width of the<code>Dimension</code>.
     * @param height the height of the<code>Dimension</code>.
     *
     * @return the created instance of the <code>Dimension</code>.
     */
    static Dimension createDimension(double width, double height) {
        Dimension dimension = new Dimension();

        // set the width and height here.
        dimension.setWidth(width);
        dimension.setHeight(height);

        return dimension;
    }

    /**
     * <p>Create the instance of <code>Point</code>.</p>
     *
     * @param x the width of the<code>Point</code>.
     * @param y the height of the<code>Point</code>.
     *
     * @return the created instance of the <code>Point</code>.
     */
    static Point createPoint(double x, double y) {
        Point point = new Point();

        // set the x and y here.
        point.setX(x);
        point.setY(y);

        return point;
    }

    /**
     * <p>
     * Gets an instance of <code>Map</code> that contains the
     * required properties for accuracy tests.
     * </p>
     *
     * @return an instance of <code>Map</code> that contains the
     *         required properties.
     */
    static Map<String, String> getProperties() {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("StrokeColor", "stroke_color");
        properties.put("FillColor", "fill_color");
        properties.put("FontColor", "font_color");
        properties.put("FontSize", "font_size");
        properties.put("FontFamily", "font_family");

        return properties;
    }
}


/**
 * <p>
 * This is a mock class extends of <code>NamespaceAbstractImpl</code> class.
 * It is used for stress test only.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
@SuppressWarnings("serial")
class NamespaceImpl extends NamespaceAbstractImpl {
    /**
     * <p>
     * Creats an instance of <code>NamespaceImpl</code>.
     * </p>
     */
    public NamespaceImpl() {
    }
}
