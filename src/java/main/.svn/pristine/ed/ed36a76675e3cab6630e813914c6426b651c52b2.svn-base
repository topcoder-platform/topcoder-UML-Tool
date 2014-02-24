/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.converters;

import org.xml.sax.SAXException;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.xmiconverters.poseidon5.DefaultXMIConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterChain;
import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;

/**
 * <p>
 * This converter is used to convert the waypoints in graph edge. Zero coordinates waypoints are removed.
 * </p>
 * <p>
 * <strong>Thread safety:</strong> This class is stateless and immutable.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class WayPointsConverter extends DefaultXMIConverter {

    /**
     * <p>
     * The qname of Diagram element.
     * </p>
     */
    private static final String GRAPHEDGE_QNAME = "UML:GraphEdge";

    /**
     * <p>
     * The qname of Diagram element.
     * </p>
     */
    private static final String POLYLINE_QNAME = "UML:Polyline";

    /**
     * <p>
     * Construct this converter with default namespace.
     * </p>
     */
    public WayPointsConverter() {
    }

    /**
     * <p>
     * This converter is used to convert the waypoints in graph edge. Zero coordinates waypoints are removed.
     * </p>
     * @param uri
     *            the Namespace URI, or the empty string if the element has no Namespace URI or if Namespace processing
     *            is not being performed
     * @param localName
     *            the local name (without prefix), or the empty string if Namespace processing is not being performed
     * @param qName
     *            the qualified XML name (with prefix), or the empty string if qualified names are not available
     * @param chain
     *            the next chain of the chains of converters
     * @param reader
     *            the XMIReader instance firing this callback
     * @param handler
     *            the XMIHandler instance this converter added to
     * @throws SAXException
     *             if any error occurs in this method
     */
    public void endElement(String uri, String localName, String qName, XMIConverterChain chain, XMIReader reader,
            XMIHandler handler) throws SAXException {
        // Save the diagram object, as the last ref object maybe set to null in
        // the later chain
        Object obj = handler.getLastRefObject();

        chain.endElement(uri, localName, qName, reader, handler);

        String elementName = ((qName != null) && (qName.trim().length() > 0)) ? qName : localName;

        if (GRAPHEDGE_QNAME.equals(elementName) && obj != null) {
            GraphEdge graphEdge = (GraphEdge) obj;
            int i, c = graphEdge.getWaypoints().size();
            for (i = 0;; ++i) {
                if (i + 2 < c && graphEdge.getWaypoints().get(i + 1).getX() == 0.0
                        && graphEdge.getWaypoints().get(i + 1).getY() == 0.0
                        && graphEdge.getWaypoints().get(i + 2).getX() == 0.0
                        && graphEdge.getWaypoints().get(i + 2).getY() == 0.0) {
                    graphEdge.removeWaypoint(i + 1);
                    graphEdge.removeWaypoint(i + 1);
                }
                if (i == graphEdge.getWaypoints().size() - 1) {
                    break;
                }
            }
        } else if (POLYLINE_QNAME.equals(elementName) && obj != null) {
            Polyline polyline = (Polyline) obj;
            int toRemove = 1;
            while (polyline.getWaypoints().size() > toRemove) {
                polyline.removeWaypoint(toRemove);
                polyline.removeWaypoint(toRemove);
                toRemove++;
            }
            if (polyline.isClosed()) {
                polyline.addWaypoint(DeployHelper.createPoint(polyline.getWaypoints().get(0).getX(), polyline
                        .getWaypoints().get(0).getY()));
            }
        }
    }
}
