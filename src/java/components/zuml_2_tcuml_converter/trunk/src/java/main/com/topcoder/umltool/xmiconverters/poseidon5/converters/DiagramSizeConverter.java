/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.converters;

import com.topcoder.diagraminterchange.Diagram;

import com.topcoder.umltool.xmiconverters.poseidon5.DefaultXMIConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.Helper;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConverterChain;
import com.topcoder.umltool.xmiconverters.poseidon5.XMIConvertersUtil;

import com.topcoder.xmi.reader.XMIHandler;
import com.topcoder.xmi.reader.XMIReader;

import org.xml.sax.SAXException;


/**
 * <p>
 * This converter is used to adjust the size of Diagram when the &lt;UML:Diagram&gt; element ended,
 * it will use the util method adjustGraphNodeSize in XMIConverterUtil class to adjust diagram size.
 * When the diagram doesn't contain any diagram element, the size should be configured empty size,
 * otherwise, the size will be calculated by the sub elements and the configured margin. To adjust
 * the size of diagram correctly, this converter should be added to the chains after the
 * DiagramTitleConverter, because the title of diagram may be removed.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is stateless and immutable.
 * </p>
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class DiagramSizeConverter extends DefaultXMIConverter {
    /**
     * <P>The qname of diagram element.</p>
     */
    private static final String DIAGRAM_QNAME = "UML:Diagram";

    /**
     * <p>
     * The default empty size's width, it is used when the diagram has no sub-graph elements.
     * It is initialized in the constructor and never be changed. It is not negative. It is
     * used by endElement methods.
     * </p>
     */
    private final double emptyWidth;

    /**
     * <p>
     * The default empty size's height, it is used when the diagram has no sub-graph elements.
     * It is initialized in the constructor and never be changed. It is not negative. It is
     * used by endElement methods.
     * </p>
     */
    private final double emptyHeight;

    /**
     * <p>
     * The default margin to add to the diagram size when the diagram has at least sub-graph element.
     * It is initialized in the constructor and never be changed. It is not negative. It is used by
     * endElement methods.
     * </p>
     */
    private final double margin;

    /**
     * <p>
     * Construct this converter with the default empty size and margin.
     * </p>
     *
     * @param emptyWidth
     *        the default empty width,  it is used when the diagram has no sub-graph elements.
     * @param emptyHeight
     *        the default empty height,  it is used when the diagram has no sub-graph elements.
     * @param margin
     *        the default margin  to add to the diagram size when the diagram has at least sub-graph element.
     * @throws IllegalArgumentException if any double is negative or Double.NaN
     */
    public DiagramSizeConverter(double emptyWidth, double emptyHeight,
        double margin) {
        Helper.checkNegativeAndNaN(emptyWidth, "emptyWidth");
        Helper.checkNegativeAndNaN(emptyHeight, "emptyHeight");
        Helper.checkNegativeAndNaN(margin, "margin");

        this.emptyWidth = emptyWidth;
        this.emptyHeight = emptyHeight;
        this.margin = margin;
    }

    /**
     * <p>
     * This method is used to adjust the size of Diagram when the &lt;UML:Diagram&gt; element ended,
     * it will use the util method adjustGraphNodeSize in XMIConverterUtil class to adjust diagram size.
     * When the diagram doesn't contain any diagram element, the size should be configured empty size,
     * otherwise, the size will be calculated by the sub elements and the configured margin.
     * </p>
     *
     * @param uri
     *        the Namespace URI, or the empty string if the element has no Namespace URI
     *        or if Namespace processing is not being performed
     * @param localName
     *        the local name (without prefix), or the empty string if Namespace processing is not being performed
     * @param qName
     *        the qualified XML name (with prefix), or the empty string if qualified names are not available
     * @param chain the next chain of the chains of converters
     * @param reader the XMIReader instance firing this callback
     * @param handler the XMIHandler instance this converter added to
     * @throws SAXException if any error occurs in this method
     */
    public void endElement(String uri, String localName, String qName,
        XMIConverterChain chain, XMIReader reader, XMIHandler handler)
        throws SAXException {
        //Save the last ref object first, it maybe changed in later chain
        Object obj = handler.getLastRefObject();

        chain.endElement(uri, localName, qName, reader, handler);

        String elementName = ((qName != null) && (qName.trim().length() > 0))
            ? qName : localName;

        if (DIAGRAM_QNAME.equals(elementName)) {
            Diagram diagram = (Diagram) obj;

            XMIConvertersUtil.adjustGraphNodeSize(diagram, emptyWidth,
                emptyHeight, margin);
        }
    }
}
