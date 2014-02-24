/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.Arrays;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;

/**
 * <P>
 * <code>CopiedElement</code> is a class that wraps
 * <code>DiagramElement</code> into <code>Transferable</code>. Each object
 * of <code>CopiedElement</code> represent a <code>DiagramElement</code>
 * which is copied into clipboard. <code>DiagramElement</code> will be bound
 * with a <code>DataFlavor</code>. And the <code>DiagramElement</code> can
 * be get back by give the right <code>DataFlavor</code>.
 * <code>CopyDiagramElementAction</code> and
 * <code>PasteDiagramElementAction</code> will use instance of this class to
 * transfer data in the clipboard.
 * </p>
 * <p>
 * <code>CopiedElement</code> is immutable so it is thread safe.
 * </p>
 *
 * @author pindut, TCSDEVELOPER
 * @version 1.0
 *
 */
public class CopiedElement implements Transferable {

	/**
	 * <p>
	 * The <code>DiagramElement</code> to be copied.
	 * </p>
	 */
	private final DiagramElement element;

	/**
	 * <p>
	 * The <code>DataFlavor</code>s that are supported by the element.
	 * </p>
	 */
	private final DataFlavor[] flavors;

	/**
	 * <p>
	 * Creates an instance of <code>CopiedElement</code> with the given
	 * <code>DiagramElement</code> and <code>DataFlavor</code> array.
	 * </p>
	 *
	 * @param element
	 *            the <code>DiagramElement</code> to be wrapped
	 * @param flavors
	 *            the supported <code>DataFlavor</code>s that are suitable
	 *            for the wrapped <code>DiagramElement</code>
	 * @throws IllegalArgumentException
	 *             if any argument is <code>null</code> or the flavors is an
	 *             empty array or the flavors contains <code>null</code>
	 * @throws ElementCloneException
	 *             if clone operation failed
	 */
	public CopiedElement(DiagramElement element, DataFlavor[] flavors)
			throws ElementCloneException {
		ArgumentCheckHelper.checkNotNull("element", element);
		this.flavors = (DataFlavor[]) ArgumentCheckHelper.checkArrayValidity(
				"flavors", flavors);

		if (element instanceof GraphNode) {
			this.element = Util.cloneGraphNode((GraphNode) element);
		} else if (element instanceof GraphEdge) {
			this.element = Util.cloneGraphEdge((GraphEdge) element);
		} else {
			throw new ElementCloneException("Not supported type to clone.");
		}
	}

	/**
	 * <P>
	 * Gets the <code>DiagramElement</code> object to be copied with the given
	 * <code>DataFlavor</code>. If the <code>DataFlavor</code> matches the
	 * <code>DiagramElement</code> object the <code>DiagramElement</code>
	 * object will be returned. Otherwise, <code>null</code> will be returned.
	 * </P>
	 *
	 * @param flavor
	 *            <code>DataFlavor</code> of content that to be extracted
	 * @return the object wrapped inside this <code>Transferable</code> if the
	 *         flavor matches the <code>DiagramElement</code> to be
	 *         transferred. Otherwise, return <code>null</code>
	 *
	 * @throws IllegalArgumentException
	 *             if the flavor is <code>null</code>
	 */
	public Object getTransferData(DataFlavor flavor) {
		return isDataFlavorSupported(flavor) ? element : null;
	}

	/**
	 * <p>
	 * Returns all supported <code>DataFlavor</code>s. As this class is
	 * immutable the array returned is just a shallow copy. So changes on the
	 * returned array will not effect the <code>CopiedElement</code>.
	 * </p>
	 *
	 * @return DataFlavors that are supported for the <code>Transferable</code>
	 *         content
	 */
	public DataFlavor[] getTransferDataFlavors() {

		return flavors.clone();
	}

	/**
	 * <p>
	 * Checks if flavor is among the <code>DataFlavor</code>s which are bound
	 * with the diagram element to be copied. This will return true if the
	 * flavor equals any in the supported flavors.
	 * </p>
	 *
	 * @param flavor
	 *            the <code>DataFlavor</code> to be checked
	 * @return true when the DataFlavor is supported, false otherwise
	 * @throws IllegalArgumentException
	 *             if the flavor is <code>null</code>
	 */
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		ArgumentCheckHelper.checkNotNull("flavor", flavor);

		return Arrays.asList(flavors).contains(flavor);
	}
}
