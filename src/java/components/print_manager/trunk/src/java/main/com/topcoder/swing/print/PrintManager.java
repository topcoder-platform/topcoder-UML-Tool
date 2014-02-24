/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import com.topcoder.swing.print.impl.DefaultComponentVisibleMaker;
import com.topcoder.swing.print.impl.DefaultPrintFormatRetriever;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;
import com.topcoder.util.objectfactory.InvalidClassSpecificationException;
import com.topcoder.util.objectfactory.ObjectFactory;
import com.topcoder.util.objectfactory.impl.ConfigManagerSpecificationFactory;
import com.topcoder.util.objectfactory.impl.IllegalReferenceException;
import com.topcoder.util.objectfactory.impl.SpecificationConfigurationException;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.RepaintManager;


/**
 * <p>This is the main class of Print Manager component. It has four main methods which accept java.awt.Component
 * instance(s) and java.awt.Rectangle instance(s) (optional). Before calling these request methods, user need call
 * specifyPrintFormat() method to retrieve user's preference for Page Format, Print Choice (fitting given component to
 * single page or scaling given component and splitting it into simple grids) and print given component within given
 * Rectangle range if it is provided.</p>
 *  <p>This class is not thread safe since it is mutable.</p>
 *
 * @author Xuchen, TCSDEVELOPER
 * @version 1.0
 */
public class PrintManager {
    /** Represents the property name for hasPrintDialog in config. */
    private static final String PROP_HAS_PRINT_DIALOG = "hasPrintDialog";

    /** Represents the property name of ObjectFactory's key for creating PrintFormatRetriever in config. */
    private static final String PROP_PRINT_FORMAT_RETRIEVER = "printFormatRetriever";

    /** Represents the property name of ObjectFactory's key for creating ComponentVisibleMaker in config. */
    private static final String PROP_COMPONENT_VISIBLE_MAKER = "componentVisibleMaker";

    /** Represents the property name of ObjectFactory's namespace in config. */
    private static final String PROP_OBJECT_FACTORY_NAMESPACE = "objectFactoryNamespace";

    /**
     * <p>Represents ComponentVisibleMaker instance which will make invisible component to be visible before
     * printing and make it invisible again to its original state after printing.</p>
     */
    private ComponentVisibleMaker componentVisibleMaker;

    /**
     * <p>Represents PrintFormatRetriever instance which will retrieve user's preference for print page format
     * and print scaling type.</p>
     */
    private PrintFormatRetriever printFormatRetriever;

    /**
     * <p>Represents whether prompt user a print dialog when print method is called. It will provide user an
     * option to choose printer or cancel print.</p>
     */
    private boolean hasPrintDialog = true;

    // Bugfix: UML-8426
    /**
     * <p>Represents the name of the document to be printed Default document name is used when this is null.</p>
     */
    private String documentName = null;

    /**
     * <p>
     * Create a PrintManager instance.
     * </p>
     */
    public PrintManager() {
        this.componentVisibleMaker = new DefaultComponentVisibleMaker();
        this.printFormatRetriever = new DefaultPrintFormatRetriever();
    }

    /**
     * <p>Create PrintManager instance given with a namespace.</p>
     * <p>The config is defined as follow:<p>
     *
     * <table width="80%" border="1">
     * <tr>
     *   <td width="154"> <strong>Parameter </strong> </td>
     *   <td width="98"> <strong>Description </strong> </td>
     *   <td width="265"> <strong>Values </strong> </td>
     * </tr>
     * <tr>
     *   <td>objectFactoryNamespace</td>
     *   <td>Used to create the ObjectFactory object, required</td>
     *   <td>Must be non-empty string</td>
     * </tr>
     * <tr>
     *   <td>componentVisibleMaker</td>
     *   <td>Represent the key used to create the ComponentVisibleMaker object from ObjectFactory, required</td>
     *   <td>Must be non-empty string</td>
     * </tr>
     * <tr>
     *   <td>printFormatRetriever</td>
     *   <td>Represents the key used to create the PrintFormatRetriever object from ObjectFactory, required</td>
     *   <td>Must be non-empty string</td>
     * </tr>
     * <tr>
     *   <td>hasPrintDialog</td>
     *   <td>Represents whether to prompt user with the print dialog when calling print method, required</td>
     *   <td>true or false (case insensitive)</td>
     * </tr>
     *</table>
     *
     * @param namespace namespace of the config.
     * @throws IllegalArgumentException if given namespace is null or empty string
     * @throws ConfigurationException if given namespace does not exist or the config is incorrect
     */
    public PrintManager(String namespace) throws ConfigurationException {
        ParameterCheck.checkNullEmpty("namespace", namespace);

        //creates ObjectFactory according to the given config
        String objectFactoryNamespace = getStringProperty(namespace, PROP_OBJECT_FACTORY_NAMESPACE);
        ObjectFactory objectFactory;

        try {
            objectFactory = new ObjectFactory(new ConfigManagerSpecificationFactory(objectFactoryNamespace));
        } catch (SpecificationConfigurationException e) {
            throw new ConfigurationException("error occurred while creating ObjectFactory:"
                    + objectFactoryNamespace, e);
        } catch (IllegalReferenceException e) {
            throw new ConfigurationException("error occurred while creating ObjectFactory:"
                    + objectFactoryNamespace, e);
        }

        //creates ComponentVisibleMaker according to the given config
        String visibleMakerKey = getStringProperty(namespace, PROP_COMPONENT_VISIBLE_MAKER);

        try {
            this.componentVisibleMaker = (ComponentVisibleMaker) objectFactory.createObject(visibleMakerKey);
        } catch (InvalidClassSpecificationException e) {
            throw new ConfigurationException("error occurred while creating ComponentVisibleMaker:"
                    + visibleMakerKey, e);
        } catch (ClassCastException e){
            throw new ConfigurationException("error occurred while creating ComponentVisibleMaker:"
                    + visibleMakerKey, e);
        }

        //creates PrintFormatRetriever according to the given config
        String retrieverKey = getStringProperty(namespace, PROP_PRINT_FORMAT_RETRIEVER);

        try {
            this.printFormatRetriever = (PrintFormatRetriever) objectFactory.createObject(retrieverKey);
        } catch (InvalidClassSpecificationException e) {
            throw new ConfigurationException("error occurred while creating PrintFormatRetriever:" + retrieverKey, e);
        } catch (ClassCastException e) {
            throw new ConfigurationException("error occurred while creating PrintFormatRetriever:" + retrieverKey, e);
        }

        Boolean hasPrintDialog = getBooleanProperty(namespace, PROP_HAS_PRINT_DIALOG);
        if (hasPrintDialog != null) {
            this.hasPrintDialog = hasPrintDialog;
        }
    }

    /**
     * <p>Print the given component. Before calling this method, user should call specifyPrintFormat() method
     * first to specify Page Format, Print Choice (fitting given component to single page or scaling given component
     * and splitting it into simple grids), otherwise IllegalStateException will be thrown.</p>
     *  <p>If given component is invisible, it will make the component visible by using visibleMaker before
     * printing it .</p>
     *
     * @param component the component to be printed
     *
     * @throws IllegalArgumentException if component is null
     */
    public void print(Component component) {
        ParameterCheck.checkNull("component", component);

        printComponent(component, null);
        componentVisibleMaker.clear();
    }

    /**
     * <p>Print the given component within given Rectangle area.</p>
     *  <p>Print the given component. Before calling this method, user should call specifyPrintFormat() method
     * first to specify Page Format, Print Choice (fitting given component to single page or scaling given component
     * and splitting it into simple grids), otherwise IllegalStateException will be thrown.</p>
     *  <p>If given component is invisible, it will make the component visible by using visibleMaker before
     * printing it .</p>
     *
     * @param component the component to be printed
     * @param rectangle the area range of component to be printed
     *
     * @throws IllegalArgumentException if any of the argument is null
     */
    public void print(Component component, Rectangle rectangle) {
        ParameterCheck.checkNull("component", component);
        ParameterCheck.checkNull("rectangle", rectangle);

        printComponent(component, rectangle);
        componentVisibleMaker.clear();
    }

    /**
     * <p>Print the given component list. Before calling this method, user should call specifyPrintFormat()
     * method first to specify Page Format, Print Choice (fitting given component to single page or scaling given
     * component and splitting it into simple grids), otherwise IllegalStateException will be thrown.</p>
     *  <p>If given component is invisible, it will make the component visible by using visibleMaker before
     * printing it .</p>
     *
     * @param components the component list to be printed
     *
     * @throws IllegalArgumentException if components is null or empty or contains null element
     */
    public void print(List <Component> components) {
        ParameterCheck.checkEmptyList("components", components);

        for (int i = 0; i < components.size(); i++) {
            printComponent(components.get(i), null);
        }

        componentVisibleMaker.clear();
    }

    /**
     * <p>Print the given component list within given coresponding rectangle area. Before calling this method,
     * user should call specifyPrintFormat() method first to specify Page Format, Print Choice (fitting given
     * component to single page or scaling given component and splitting it into simple grids), otherwise
     * IllegalStateException will be thrown.</p>
     *  <p>If given component is invisible, it will make the component visible by using visibleMaker before
     * printing it .</p>
     *
     * @param components the component list to be printed
     * @param rectangles the rectangle list within which the component is printed. The size of rectangle list should be
     *        equal to components list
     *
     * @throws IllegalArgumentException if given component or rectangle list are null or empty or containing null
     *         element or their sizes are not equal
     */
    public void print(List<Component> components, List<Rectangle> rectangles) {
        ParameterCheck.checkEmptyList("components", components);
        ParameterCheck.checkEmptyList("rectangles", rectangles);

        if (components.size() != rectangles.size()) {
            throw new IllegalArgumentException("the numbers of components and rectangles are not equal");
        }

        for (int i = 0; i < components.size(); i++) {
            printComponent(components.get(i), rectangles.get(i));
        }

        componentVisibleMaker.clear();
    }

    /**
     * <p>Sets ComponentVisibleMaker to this PrintManager.</p>
     *
     * @param componentVisibleMaker the visibleMaker to set
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void setComponentVisibleMaker(ComponentVisibleMaker componentVisibleMaker) {
        ParameterCheck.checkNull("componentVisibleMaker", componentVisibleMaker);
        this.componentVisibleMaker = componentVisibleMaker;
    }

    /**
     * <p>Sets hasPrintDialog to this PrintManager.</p>
     *
     * @param hasPrintDialog the value to set
     */
    public void setHasPrintDialog(boolean hasPrintDialog) {
        this.hasPrintDialog = hasPrintDialog;
    }

    /**
     * <p>Sets PrintFormatRetriever to this PrintManager.</p>
     *
     * @param printFormatRetriever the printFormatRetriver to set
     *
     * @throws IllegalArgumentException if argument is null
     */
    public void setPrintFormatRetriever(PrintFormatRetriever printFormatRetriever) {
        ParameterCheck.checkNull("printFormatRetriever", printFormatRetriever);
        this.printFormatRetriever = printFormatRetriever;
    }

    /**
     * <p>Use printFormatRetriever to retriever user's preference for print format and scaling type.</p>
     * @throws PrintFormatRetrieveException if any error occurs when retrieving user's preference for print
     * format and scaling style
     */
    public void specifyPrintFormat() throws PrintFormatRetrieveException {
        printFormatRetriever.retrievePrintFormat();
    }

    /**
     * Obtains a property's value as boolean according to the namespace and its name. If it does not exist, null
     * will be returned. If the string value is neither 'true' nor 'false', ConfigurationException will be thrown.
     *
     * @param namespace namespace from where the property is obtained
     * @param propertyName the name of the property in config
     *
     * @return a Boolean value of the property, may be null
     *
     * @throws ConfigurationException if the string value exists and it is neither 'true' nor 'false'
     */
    private static Boolean getBooleanProperty(String namespace, String propertyName)
        throws ConfigurationException {
        String strValue;
        try {
            strValue = ConfigManager.getInstance().getString(namespace, propertyName);
        } catch (UnknownNamespaceException e) {
            throw new ConfigurationException("namespace:" + namespace + " property:" + propertyName
                    + " value should not be empty");
        }

        //this property is optional
        if (strValue == null || strValue.trim().length() == 0) {
            return null;
        }

        strValue = strValue.toLowerCase();
        if ("true".equals(strValue)) {
            return Boolean.TRUE;
        } else if ("false".equals(strValue)) {
            return Boolean.FALSE;
        } else {
            throw new ConfigurationException("namespace:" + namespace + " property:" + propertyName
                    + " value should be either 'true' or 'false'");
        }
    }

    /**
     * Obtains a property's value according to the namespace and its name. If it does not exist,
     * ConfigurationException will be thrown.
     *
     * @param namespace namespace from where the property is obtained
     * @param propertyName the name of the property in config
     *
     * @return a string value of the property
     *
     * @throws ConfigurationException if the property does not exist
     */
    private static String getStringProperty(String namespace, String propertyName)
        throws ConfigurationException {
        String value;

        try {
            value = ConfigManager.getInstance().getString(namespace, propertyName);

            if ((value == null) || (value.trim().length() == 0)) {
                throw new ConfigurationException("namespace:" + namespace + " property:" + propertyName
                        + " value should not be empty");
            }
        } catch (UnknownNamespaceException e) {
            throw new ConfigurationException("namespace:" + namespace + " does not found", e);
        }

        return value;
    }

    /**
     * Creates a proper Printable for the component and rectangle. Printing format is specified with
     * printFormatRetriever.
     *
     * @param component component to be printed
     * @param rectangle the rectangle specifies the printing area, can be null
     *
     * @return Printable FitInPagePrint or ScalingPrint
     */
    private Printable createPrintable(Component component, Rectangle rectangle) {
        Printable printable;

        if (printFormatRetriever.isFitSinglePage()) {
            if (rectangle == null) {
                printable = new FitInPagePrint(component);
            } else {
                printable = new FitInPagePrint(component, rectangle);
            }
        } else {
            double scalingFactor = printFormatRetriever.getScaleFactor();

            if (rectangle == null) {
                printable = new ScalingPrint(component, scalingFactor);
            } else {
                printable = new ScalingPrint(component, rectangle, scalingFactor);
            }
        }

        return printable;
    }

    /**
     * Disable double buffer of a component.
     *
     * @param c the component of which double buffer will be disable
     */
    private static void disableDoubleBuffering(Component c) {
        RepaintManager currentManager = RepaintManager.currentManager(c);
        currentManager.setDoubleBufferingEnabled(false);
    }

    /**
     * Enable double buffer of a component.
     *
     * @param c the component of which double buffer will be disable
     */
    private static void enableDoubleBuffering(Component c) {
        RepaintManager currentManager = RepaintManager.currentManager(c);
        currentManager.setDoubleBufferingEnabled(true);
    }

    /**
     * Prints the component. If rectangle specified, print the component within the rectangle. Otherwise, take
     * the whole component as printing area.
     *
     * @param component the component to be print
     * @param rectangle the rectangle specifies the printing area, can be null
     */
    private void printComponent(Component component, Rectangle rectangle) {
        //if component is JComponent and double buffer is on, then disable it
        boolean isDoubleBuffered = component instanceof JComponent && ((JComponent) component).isDoubleBuffered();

        if (isDoubleBuffered) {
            //Turn the global double bufferring off;
            disableDoubleBuffering(component);
        }

        //if component is invisible, set the flag and make it visible
        boolean isInvisible = component.getGraphics() == null;

        if (isInvisible) {
            this.componentVisibleMaker.makeVisible(component);
        }

        Printable printable = createPrintable(component, rectangle);

        printPrintable(printable);

        //check the flag to see whether the component is original invisible, if it is,
        //call componentVisibleMaker.makeInvisible(components.get(i));
        if (isInvisible) {
            this.componentVisibleMaker.makeInvisible(component);
        }

        if (isDoubleBuffered) {
            //Turn the global double bufferring on;
            enableDoubleBuffering(component);
        }
    }

    /**
     * Print the printable.
     *
     * @param printable the Printable to be printed
     *
     * @throws PrintingException if error occurred while printing
     */
    private void printPrintable(Printable printable) {
        PrinterJob job = PrinterJob.getPrinterJob();
        // Bugfix: UML-8426
        if (documentName != null) {
            job.setJobName(documentName);
        }
        job.setPrintable(printable, printFormatRetriever.getPageFormat());

        boolean rt = true;

        if (hasPrintDialog) {
            rt = job.printDialog();
        }

        if (rt) {
            try {
                job.print();
            } catch (PrinterException e) {
                throw new PrintingException("error occurred while printing component", e);
            }
        }
    }

    // Bugfix: UML-8426
    /**
     * <p>Gets the document name.</p>
     * @return the name of the document to be printed
     */
    public String getDocumentName() {
        return documentName;
    }

    // Bugfix: UML-8426
    /**
     * <p>Sets the document name.</p>
     * @param documentName the name of the document to be printed
     */
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    // UML-9861
    /**
     * <p>Gets PrintFormatRetriever to this PrintManager.</p>
     * return the PrintFormatRetriever to this PrintManager
     */
    public PrintFormatRetriever getPrintFormatRetriever() {
        return printFormatRetriever;
    }
}
