/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.Document;

import com.topcoder.xmi.writer.transformers.diagram.DiagramInterchangeElementTransformer;
import com.topcoder.xmi.writer.transformers.diagram.elementtransformers.PropertyTransformer;

/**
 * Helper class for failure test.
 *
 * @author magicpig
 * @version 1.0
 */
final class FailureHelper {
    /**
     * private class to avoid being instantiated.
     */
    private FailureHelper() {
        // does nothing
    }

    /**
     * Creates a Transformer instance.
     *
     * @return the created Transformer
     * @throws Exception
     *             when error occurs
     */
    public static Transformer createTransformer() throws Exception {
        Transformer xmlTransformer = TransformerFactory.newInstance().newTransformer();
        xmlTransformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        xmlTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

        return xmlTransformer;
    }

    /**
     * Creates a Transformers Map. The created map contain 10 pairs. The key is from 0 to 9 (in
     * string form) while the value is different PropertyTransformer instance.
     *
     * @return the created Transformer Map
     */
    public static Map<String, DiagramInterchangeElementTransformer> createTransformersMap() {
        Map<String, DiagramInterchangeElementTransformer> transformers =
            new HashMap<String, DiagramInterchangeElementTransformer>();
        for (int i = 0; i < 10; i++) {
            transformers.put("" + i, new PropertyTransformer());
        }
        return transformers;
    }

    /**
     * Creates a tagName Map. The created map contain 10 pairs. The key and value are the same for
     * each pairs which are from 0 to 9 (in string form).
     *
     * @return the created Transformer Map
     */
    public static Map<String, String> createTagNameMap() {
        Map<String, String> tagNameMap = new HashMap<String, String>();
        for (int i = 0; i < 10; i++) {
            tagNameMap.put("" + i, "" + i);
        }
        return tagNameMap;
    }

    /**
     * Creates a Document instance.
     *
     * @return the created Document
     * @throws Exception
     *             when error occurs
     */
    public static Document createDocument() throws Exception {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    }
}
