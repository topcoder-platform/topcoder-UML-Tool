/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.Ellipse;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Image;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.TextElement;

/**
 * <P>
 * <code>DiagramElementDataFlavorManager</code> will keep all suitable
 * <code>DataFlavors</code> for <code>DiagramElement</code>. Application
 * can refer to <code>DiagramElementDataFlavorManager</code> to check whether
 * a certain <code>Transferable</code> object (gotten from clipboard) or a
 * certain <code>DataFlavor</code> is a DiagramElement or not.
 * </P>
 * <p>
 * This class is thread safe because all of its attributes are made final.
 * Furthermore, this class is to be used by single thread, other thread should
 * create its own.
 * </p>
 *
 * @author pindut, TCSDEVELOPER
 * @version 1.0
 *
 */
public class DiagramElementDataFlavorManager {

    /**
     * <P>
     * Arrays of suitable <code>DataFlavors</code> for
     * <code>DiagramElement</code> actions.
     * </P>
     * <P>
     * For now all suitable <code>DataFlavors</code> are:
     * <ol>
     * <li>GraphNode</li>
     * <li>GraphEdge</li>
     * <li>TextElement</li>
     * <li>Polyline</li>
     * <li>Image</li>
     * <li>Ellipse</li>
     * <li>DiagramElement</li>
     * </ol>
     * </P>
     */
    private final ArrayList < DataFlavor > diagramElementFlavors;


    /**
     * <p>
     * Creates an instance of <code>DiagramElementDataFlavorManager</code>.
     * <code>DataFlavor</code>s which is suitable for
     * <code>DiagramElement</code> is initialized and stored in the instance
     * of <code>DiagramElementDataFlavorManager</code>.
     * </p>
     */
    public DiagramElementDataFlavorManager() {
        diagramElementFlavors = new ArrayList < DataFlavor >();
        diagramElementFlavors.add(new DataFlavor(DiagramElement.class,
                "DiagramElement"));
        diagramElementFlavors.add(new DataFlavor(GraphNode.class,
                GraphNode.class.getSimpleName()));
        diagramElementFlavors.add(new DataFlavor(GraphEdge.class,
                GraphEdge.class.getSimpleName()));
        diagramElementFlavors.add(new DataFlavor(TextElement.class,
                TextElement.class.getSimpleName()));
        diagramElementFlavors.add(new DataFlavor(Polyline.class, Polyline.class
                .getSimpleName()));
        diagramElementFlavors.add(new DataFlavor(Image.class, Image.class
                .getSimpleName()));
        diagramElementFlavors.add(new DataFlavor(Ellipse.class, Ellipse.class
                .getSimpleName()));
    }

    /**
     * <p>
     * Checks if a given <code>DataFlavor</code> is one of the
     * <code>DataFlavor</code> in the diagramElement flavors.
     * </p>
     *
     * @param flavor
     *            the <code>DataFlavor</code> to be checked
     * @return true if the <code>DataFlavor</code> is suitable for the
     *         <code>DiagramElement</code>, false otherwise
     * @throws IllegalArgumentException
     *             if flavor is <code>null</code>
     */
    public boolean isSuitableForDiagramElement(DataFlavor flavor) {
        ArgumentCheckHelper.checkNotNull("flavor", flavor);
        return diagramElementFlavors.contains(flavor);
    }

    /**
     * <p>
     * Checks if the <code>DataFlavor</code>s of a given <code>Transferable</code> is
     * suitable for <code>DiagramElement</code>. Any one in the <code>DataFlavor</code>s
     * of the <code>Transferable</code> is suitable this method will return
     * true.
     * </p>
     *
     * @param transferable
     *            the <code>Transferable</code> to be checked
     * @return true at least if one of the supported <code>DataFlavor</code>
     *         of the <code>Transferable</code> is suitable for
     *         <code>DiagramElement</code>, false otherwise
     * @throws IllegalArgumentException
     *             if the transferable is <code>null</code>
     */
    public boolean isSuitableForDiagramElement(Transferable transferable) {
        ArgumentCheckHelper.checkNotNull("transferable", transferable);
        DataFlavor[] flavors = transferable.getTransferDataFlavors();

        if (flavors != null) {
            for (DataFlavor flavorItem : flavors) {
                if (diagramElementFlavors.contains(flavorItem)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * <p>
     * Gets a clone of a suitable <code>DataFlavor</code> for the given
     * <code>DiagramElement</code>. If there is no <code>DataFlavor</code>
     * for the <code>DiagramElement</code> in this manager a generic one will
     * be returned. The generic one is suitable for all subclasses of <code>DiagramElement</code>.
     * </p>
     *
     * @param element
     *            the <code>DiagramElement</code> to get the
     *            <code>DataFlavor</code> for
     * @return DataFlavor an instance suitable for the given
     *         <code>DiagramElement</code>
     * @throws IllegalArgumentException
     *             if element is <code>null</code>
     */
    public DataFlavor getDataFlavor(DiagramElement element) {
        ArgumentCheckHelper.checkNotNull("element", element);

        Class elementClass = element.getClass();
        DataFlavor result = null;
        do {
            result = getFlavorForClass(elementClass);
            elementClass = elementClass.getSuperclass();
        } while (result == null);
        return result;
    }

    /**
     * <p>
     * Adds a <code>DataFlavor</code> into the data flavors for
     * <code>DiagramElement</code>.
     * </p>
     *
     * @param dataFlavor
     *            the <code>DataFlavor</code> to be added
     * @throws IllegalArgumentException
     *             if the dataFlavor is <code>null</code>
     */
    public void addDataFlavor(DataFlavor dataFlavor) {
        if (!isSuitableForDiagramElement(dataFlavor)) {
            diagramElementFlavors.add(dataFlavor);
        }
    }

    /**
     * <P>
     * Gets the flavor for the specified class. If there is a <code>DataFlavor</code>'s representation
     * type is the elementClass in the manager the clone of the <code>DataFlavor</code> would be returned.
     * Otherwise <code>null</code> would be returned.
     * </P>
     *
     * @param elementClass the class to get the flavor for
     *
     * @return the <code>DataFlavor</code> represent the elementClass type, <code>null</code> if no suitable one
     */
    private DataFlavor getFlavorForClass(Class elementClass) {
        for (DataFlavor flavorItem : diagramElementFlavors) {
            Class flavorClass = flavorItem.getRepresentationClass();
            if (elementClass.equals(flavorClass)) {
                try {
                    return (DataFlavor) flavorItem.clone();
                } catch (CloneNotSupportedException e) {
                    // Do nothing.
                }
            }
        }

        return null;
    }
}
