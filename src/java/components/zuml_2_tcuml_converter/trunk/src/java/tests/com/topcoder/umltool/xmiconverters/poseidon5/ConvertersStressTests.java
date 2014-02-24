/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5;

import java.io.File;

import com.topcoder.umltool.xmiconverters.poseidon5.converters.DiagramSizeConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.DiagramTitleConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.GraphPropertiesConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.IgnoreOperationInMethodConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.converters.RenameConverter;
import com.topcoder.umltool.xmiconverters.poseidon5.stresstests.BaseStressTests;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.diagraminterchange.DiagramInterchangeXMIHandler;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;

/**
 * <p>
 * Stress tests for class DiagramSizeConverter, DiagramTitleConverter,
 * GraphPropertiesConverter , IgnoreOperationInMethodConverter, RenameConverter.
 * </p>
 * 
 * @author extra
 * @version 1.0
 */
public class ConvertersStressTests extends BaseStressTests {

    /**
     * <p>
     * Represents instance of XMIReader for test.
     * </p>
     */
    private XMIReader reader;

    /**
     * <p>
     * Represents instance of DiagramInterchangeXMIHandler for test.
     * </p>
     */
    private DiagramInterchangeXMIHandler innerHandler;

    /**
     * <p>
     * Represents instance of XMIConverterHandler for test.
     * </p>
     */
    private XMIConverterHandler converterHandler;

    /**
     * <p>
     * Represents instance of File to parse by the reader.
     * </p>
     */
    private File file;

    /**
     * <p>
     * Represents instance of big File to parse by the reader.
     * </p>
     */
    private File bigFile;

    /**
     * <p>
     * Sets up the environment.
     * </p>
     * 
     * @throws Exception
     *             to JUnit.
     */
    protected void setUp() throws Exception {
        clearConfig();
        addConfig("factory_config.xml");
        addConfig("reader_config.xml");
        addConfig("Converters.xml");
        reader = new XMIReader();
        innerHandler = (DiagramInterchangeXMIHandler) reader.getHandler("UML:Diagram");
        innerHandler.setModelElementFactory(new ModelElementFactory(ModelElementFactory.class.getName()));
        converterHandler = new XMIConverterHandler(innerHandler, reader);

        reader.addHandler("UML:Diagram", converterHandler);
        file = getFile("Sample.xmi");
        bigFile = getFile("BigFile.xmi");
    }

    /**
     * <p>
     * Tears down the environment.
     * </p>
     * 
     * @throws Exception
     *             to JUnit.
     */
    protected void tearDown() throws Exception {
        clearConfig();
    }

    /**
     * <p>
     * Tests DiagramSizeConverter#endElement for stress, it will call 130 times.
     * </p>
     * 
     * @throws Exception
     *             to JUnit.
     */
    public void testDiagramSizeConverterEndElement() throws Exception {
        DiagramSizeConverter converter = new DiagramSizeConverter(100d, 200d, 10d);
        converterHandler.addConverter(converter);
        begin();
        for (int i = 0; i < 10; i++) {
            reader.parse(file);
        }
        printResult("DiagramSizeConverter#endElement", 13 * 10);
    }

    /**
     * <p>
     * Tests DiagramSizeConverter#endElement for stress, it will parse a big
     * file.
     * </p>
     * 
     * @throws Exception
     *             to JUnit.
     */
    public void testDiagramSizeConverterEndElement_BigFile() throws Exception {
        DiagramSizeConverter converter = new DiagramSizeConverter(100d, 200d, 10d);
        converterHandler.addConverter(converter);
        begin();
        reader.parse(bigFile);
        printResult("DiagramSizeConverter#endElement with big file", 1);
    }

    /**
     * <p>
     * Tests DiagramTitleConverter#endElement for stress, it will call 130
     * times.
     * </p>
     * 
     * @throws Exception
     *             to JUnit.
     */
    public void testDiagramTitleConverterEndElement() throws Exception {
        DiagramTitleConverter converter = new DiagramTitleConverter();
        converterHandler.addConverter(converter);

        begin();
        for (int i = 0; i < 10; i++) {
            reader.parse(file);
        }
        printResult("DiagramTitleConverter#endElement", 13 * 10);
    }

    /**
     * <p>
     * Tests DiagramTitleConverter#endElement for stress, it will parse big
     * file.
     * </p>
     * 
     * @throws Exception
     *             to JUnit.
     */
    public void testDiagramTitleConverterEndElement_BigFile() throws Exception {
        DiagramTitleConverter converter = new DiagramTitleConverter();
        converterHandler.addConverter(converter);

        begin();
        reader.parse(bigFile);
        printResult("DiagramTitleConverter#endElement with big file", 1);
    }

    /**
     * <p>
     * Tests GraphPropertiesConverter#endElement for stress, it will call 130
     * times.
     * </p>
     * 
     * @throws Exception
     *             to JUnit.
     */
    public void testGraphPropertiesConverterEndElement() throws Exception {
        GraphPropertiesConverter converter = new GraphPropertiesConverter();
        converterHandler.addConverter(converter);

        begin();
        for (int i = 0; i < 10; i++) {
            reader.parse(file);
        }
        printResult("GraphPropertiesConverter#endElement", 13 * 10);
    }

    /**
     * <p>
     * Tests GraphPropertiesConverter#endElement for stress, it will parse big
     * file.
     * </p>
     * 
     * @throws Exception
     *             to JUnit.
     */
    public void testGraphPropertiesConverterEndElement_BigFile() throws Exception {
        GraphPropertiesConverter converter = new GraphPropertiesConverter();
        converterHandler.addConverter(converter);

        begin();
        reader.parse(bigFile);
        printResult("GraphPropertiesConverter#endElement with big file", 1);
    }

    /**
     * <p>
     * Tests IgnoreOperationInMethodConverter#endElement for stress, it will
     * call 130 times.
     * </p>
     * 
     * @throws Exception
     *             to JUnit.
     */
    public void testIgnoreOperationInMethodConverterEndElement() throws Exception {
        IgnoreOperationInMethodConverter converter = new IgnoreOperationInMethodConverter();
        converterHandler.addConverter(converter);

        begin();
        for (int i = 0; i < 10; i++) {
            reader.parse(file);
        }
        printResult("IgnoreOperationInMethodConverter#endElement", 13 * 10);
    }

    /**
     * <p>
     * Tests IgnoreOperationInMethodConverter#endElement for stress, it will
     * parse big file.
     * </p>
     * 
     * @throws Exception
     *             to JUnit.
     */
    public void testIgnoreOperationInMethodConverterEndElement_BigFile() throws Exception {
        IgnoreOperationInMethodConverter converter = new IgnoreOperationInMethodConverter();
        converterHandler.addConverter(converter);

        begin();
        reader.parse(bigFile);
        printResult("IgnoreOperationInMethodConverter#endElement with big file", 1);
    }

    /**
     * <p>
     * Tests RenameConverter#endElement for stress, it will call 130 times.
     * </p>
     * 
     * @throws Exception
     *             to JUnit.
     */
    public void testRenameConverterEndElement() throws Exception {
        RenameConverter converter = new RenameConverter();
        converterHandler.addConverter(converter);

        begin();
        for (int i = 0; i < 10; i++) {
            reader.parse(file);
        }
        printResult("RenameConverter#endElement", 13 * 10);
    }

    /**
     * <p>
     * Tests RenameConverter#endElement for stress, it will parse big file.
     * </p>
     * 
     * @throws Exception
     *             to JUnit.
     */
    public void testRenameConverterEndElement_BigFile() throws Exception {
        RenameConverter converter = new RenameConverter();
        converterHandler.addConverter(converter);

        begin();
        reader.parse(bigFile);
        printResult("RenameConverter#endElement with big file", 1);
    }
}
