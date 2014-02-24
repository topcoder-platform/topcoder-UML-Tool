/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.xmiheader;

import java.io.PrintStream;

import com.topcoder.xmi.writer.AbstractXMITransformer;
import com.topcoder.xmi.writer.Helper;

/**
 * <p>
 * This class is a concrete implementation of <code>{@link com.topcoder.xmi.writer.XMITransformer}</code> interface,
 * it extends <code>{@link AbstractXMITransformer}</code> abstract class, and it is registered into the
 * <code>{@link com.topcoder.xmi.writer.XMIWriter}</code> with the <code>TransformerType.Header</code>, and it is
 * able to write the xmi header data to the output stream.
 * </p>
 * <p>
 * Basically, it will write something like:
 *
 * <pre>
 *   &lt;XMI.header&gt;
 *       &lt;XMI.documentation&gt;
 *           &lt;XMI.exporter&gt;TCUML&lt;/XMI.exporter&gt;
 *           &lt;XMI.exporterVersion&gt;1.0&lt;/XMI.exporterVersion&gt;
 *           &lt;XMI.metaModelVersion&gt;1.2&lt;/XMI.metaModelVersion&gt;
 *       &lt;/XMI.documentation&gt;
 *   &lt;/XMI.header&gt;
 * </pre>
 *
 * as the child of the &lt;XMI&gt; root node.
 * <p>
 * <strong>Thread-safety</strong>: this class is immutable, but as its base-class is not thread-safe, this class is not
 * thread-safe too.
 * </p>
 *
 * @author Standlove, FireIce
 * @version 1.0
 */
public class XMIHeaderTransformer extends AbstractXMITransformer {
    /**
     * <p>
     * Represents the exporter written into the header in the transform method.
     * </p>
     * <p>
     * Initialized in constructor, never change afterwards. Must be non-null, non-empty string.
     * </p>
     */
    private final String exporter;

    /**
     * <p>
     * Represents the exporter version written into the header in the transform method.
     * </p>
     * <p>
     * Initialized in constructor, never change afterwards. Must be non-null, non-empty string.
     * </p>
     */
    private final String exporterVersion;

    /**
     * <p>
     * Represents the meta model version written into the header in the transform method.
     * </p>
     * <p>
     * Initialized in constructor, never change afterwards. Must be non-null, non-empty string.
     * </p>
     */
    private final String metaModelVersion;

    /**
     * <p>
     * Constructs an instance of <code>XMIHeaderTransformer</code> with exporter, exporter version, and meta model
     * version value set.
     * </p>
     *
     * @param exporter
     *            the exporter written into the header in the transform method.
     * @param exporterVersion
     *            the exporter version written into the header in the transform method.
     * @param metaModelVersion
     *            the meta model version written into the header in the transform method.
     * @throws IllegalArgumentException
     *             if any argument is <code>null</code> or <code>empty</code> string.
     */
    public XMIHeaderTransformer(String exporter, String exporterVersion, String metaModelVersion) {
        Helper.validateString(exporter, "exporter");
        Helper.validateString(exporterVersion, "exporterVersion");
        Helper.validateString(metaModelVersion, "metaModelVersion");

        this.exporter = exporter;
        this.exporterVersion = exporterVersion;
        this.metaModelVersion = metaModelVersion;
    }

    /**
     * <p>
     * Writes the header info to the output stream. It will write data like following:
     *
     * <pre>
     *   &lt;XMI.header&gt;
     *       &lt;XMI.documentation&gt;
     *           &lt;XMI.exporter&gt;TCUML&lt;/XMI.exporter&gt;
     *           &lt;XMI.exporterVersion&gt;1.0&lt;/XMI.exporterVersion&gt;
     *           &lt;XMI.metaModelVersion&gt;1.2&lt;/XMI.metaModelVersion&gt;
     *       &lt;/XMI.documentation&gt;
     *   &lt;/XMI.header&gt;
     * </pre>
     * </p>
     *
     * @param element
     *            the element to transform. ignored by this transformer, can be null.
     * @param out
     *            the <code>{@link PrintStream}</code> object to write the transformation data.
     * @throws IllegalArgumentException
     *             if the out argument is <code>null</code>.
     */
    public void transform(Object element, PrintStream out) {
        Helper.validateObject(out, "out");

        // construct the header info string.
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<XMI.header>\n<XMI.documentation>\n<XMI.exporter>");
        stringBuffer.append(exporter);
        stringBuffer.append("</XMI.exporter>\n<XMI.exporterVersion>");
        stringBuffer.append(exporterVersion);
        stringBuffer.append("</XMI.exporterVersion>\n<XMI.metaModelVersion>");
        stringBuffer.append(metaModelVersion);
        stringBuffer.append("</XMI.metaModelVersion>\n</XMI.documentation>\n</XMI.header>\n");

        // print out the header info.
        out.print(stringBuffer.toString());
    }
}
