/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.UnsupportedFlavorException;

import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.modelmanagement.PackageImpl;

/**
 * <p>
 * Unit test cases for class ClassElementsTransfer.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClassElementsTransferTest extends HelpTestCase {

    /**
     * Setup routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
    }

    /**
     * Teardown routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test that DataFlavor CLASS_FLAVOR defined corretly.
     */
    public void testDataFlavorClass() {
        assertEquals("CLASS_FLAVOR is not correctly set.",
                "application/x-java-serialized-object; class=com.topcoder.uml.model.core.classifiers.Class",
                ClassElementsTransfer.CLASS_FLAVOR.getMimeType());
        assertEquals("CLASS_FLAVOR is not correctly set.", "Class", ClassElementsTransfer.CLASS_FLAVOR
                .getHumanPresentableName());
    }

    /**
     * Test that DataFlavor INTERFACE_FLAVOR defined corretly.
     */
    public void testDataFlavorInterface() {
        assertEquals("INTERFACE_FLAVOR is not correctly set.",
                "application/x-java-serialized-object; class=com.topcoder.uml.model.core.classifiers.Interface",
                ClassElementsTransfer.INTERFACE_FLAVOR.getMimeType());
        assertEquals("INTERFACE_FLAVOR is not correctly set.", "Interface", ClassElementsTransfer.INTERFACE_FLAVOR
                .getHumanPresentableName());
    }

    /**
     * Test that DataFlavor ENUMERATION_FLAVOR defined corretly.
     */
    public void testDataFlavorEnumeration() {
        assertEquals("ENUMERATION_FLAVOR is not correctly set.",
                "application/x-java-serialized-object; class=com.topcoder.uml.model.core.classifiers.Enumeration",
                ClassElementsTransfer.ENUMERATION_FLAVOR.getMimeType());
        assertEquals("ENUMERATION_FLAVOR is not correctly set.", "Enumeration",
                ClassElementsTransfer.ENUMERATION_FLAVOR.getHumanPresentableName());
    }

    /**
     * Test that DataFlavor PACKAGE_FLAVOR defined corretly.
     */
    public void testDataFlavorPackage() {
        assertEquals("PACKAGE_FLAVOR is not correctly set.",
                "application/x-java-serialized-object; class=com.topcoder.uml.model.modelmanagement.Package",
                ClassElementsTransfer.PACKAGE_FLAVOR.getMimeType());
        assertEquals("PACKAGE_FLAVOR is not correctly set.", "Package", ClassElementsTransfer.PACKAGE_FLAVOR
                .getHumanPresentableName());
    }

    /**
     * Test that DataFlavor ABSTRACTION_FLAVOR defined corretly.
     */
    public void testDataFlavorAbstraction() {
        assertEquals("ABSTRACTION_FLAVOR is not correctly set.",
                "application/x-java-serialized-object; class=com.topcoder.uml.model.core.dependencies.Abstraction",
                ClassElementsTransfer.ABSTRACTION_FLAVOR.getMimeType());
        assertEquals("ABSTRACTION_FLAVOR is not correctly set.", "Abstraction",
                ClassElementsTransfer.ABSTRACTION_FLAVOR.getHumanPresentableName());
    }

    /**
     * Test that DataFlavor ASSOCIATION_FLAVOR defined corretly.
     */
    public void testDataFlavorAssociation() {
        assertEquals("ASSOCIATION_FLAVOR is not correctly set.",
                "application/x-java-serialized-object; class=com.topcoder.uml.model.core.relationships.Association",
                ClassElementsTransfer.ASSOCIATION_FLAVOR.getMimeType());
        assertEquals("ASSOCIATION_FLAVOR is not correctly set.", "Association",
                ClassElementsTransfer.ASSOCIATION_FLAVOR.getHumanPresentableName());
    }

    /**
     * Test that DataFlavor DEPENDENCY_FLAVOR defined corretly.
     */
    public void testDataFlavorDependency() {
        assertEquals("DEPENDENCY_FLAVOR is not correctly set.",
                "application/x-java-serialized-object; class=com.topcoder.uml.model.core.dependencies.Dependency",
                ClassElementsTransfer.DEPENDENCY_FLAVOR.getMimeType());
        assertEquals("DEPENDENCY_FLAVOR is not correctly set.", "Dependency", ClassElementsTransfer.DEPENDENCY_FLAVOR
                .getHumanPresentableName());
    }

    /**
     * Test that DataFlavor GENERALIZATION_FLAVOR defined corretly.
     */
    public void testDataFlavorGeneralization() {
        assertEquals("GENERALIZATION_FLAVOR is not correctly set.",
                "application/x-java-serialized-object; class=com.topcoder.uml.model.core.relationships.Generalization",
                ClassElementsTransfer.GENERALIZATION_FLAVOR.getMimeType());
        assertEquals("GENERALIZATION_FLAVOR is not correctly set.", "Generalization",
                ClassElementsTransfer.GENERALIZATION_FLAVOR.getHumanPresentableName());
    }

    /**
     * Test that DataFlavor EXCEPTION_FLAVOR defined corretly.
     */
    public void testDataFlavorException() {
        assertEquals("EXCEPTION_FLAVOR is not correctly set.",
                "application/x-java-serialized-object; class=com.topcoder.uml.model.core.classifiers.Class",
                ClassElementsTransfer.EXCEPTION_FLAVOR.getMimeType());
        assertEquals("EXCEPTION_FLAVOR is not correctly set.", "Exception", ClassElementsTransfer.EXCEPTION_FLAVOR
                .getHumanPresentableName());
    }

    /**
     * Test constructor ClassElementsTransfer(Class), with correct Class
     * instance.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorClass() throws Exception {
        com.topcoder.uml.model.core.classifiers.Class classElement = new ClassImpl();
        ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(classElement);

        assertEquals("Constructor failed, supportedFlavor is not correctly set.", ClassElementsTransfer.CLASS_FLAVOR,
                classElementsTransfer.getTransferDataFlavors()[0]);
        assertEquals("Constructor failed, element is not correctly set.", classElement, classElementsTransfer
                .getTransferData(ClassElementsTransfer.CLASS_FLAVOR));
    }

    /**
     * Test constructor ClassElementsTransfer(Class), with correct Excpetion
     * instance.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorException() throws Exception {
        // create a Exception
        com.topcoder.uml.model.core.classifiers.Class classElement = new ClassImpl();
        Stereotype stereoType = new StereotypeImpl();
        stereoType.setName("Exception");
        classElement.addStereotype(stereoType);

        ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(classElement);

        assertEquals("Constructor failed, supportedFlavor is not correctly set.",
                ClassElementsTransfer.EXCEPTION_FLAVOR, classElementsTransfer.getTransferDataFlavors()[0]);
        assertEquals("Constructor failed, element is not correctly set.", classElement, classElementsTransfer
                .getTransferData(ClassElementsTransfer.EXCEPTION_FLAVOR));
    }

    /**
     * Test constructor ClassElementsTransfer(Class), with null Class instance.
     * IllegalArgumentException is expected.
     */
    public void testCtorClassWithNull() {
        try {
            com.topcoder.uml.model.core.classifiers.Class classElement = null;
            new ClassElementsTransfer(classElement);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor ClassElementsTransfer(Interface), with correct Interface
     * instance.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorInterface() throws Exception {
        Interface interfaceElement = new InterfaceImpl();
        ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(interfaceElement);

        assertEquals("Constructor failed, supportedFlavor is not correctly set.",
                ClassElementsTransfer.INTERFACE_FLAVOR, classElementsTransfer.getTransferDataFlavors()[0]);
        assertEquals("Constructor failed, element is not correctly set.", interfaceElement, classElementsTransfer
                .getTransferData(ClassElementsTransfer.INTERFACE_FLAVOR));
    }

    /**
     * Test constructor ClassElementsTransfer(Interface), with null Interface
     * instance. IllegalArgumentException is expected.
     */
    public void testCtorInterfaceWithNull() {
        try {
            Interface interfaceElement = null;
            new ClassElementsTransfer(interfaceElement);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor ClassElementsTransfer(Enumeration), with correct
     * Enumeration instance.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorEnumeration() throws Exception {
        Enumeration enumerationElement = new EnumerationImpl();
        ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(enumerationElement);

        assertEquals("Constructor failed, supportedFlavor is not correctly set.",
                ClassElementsTransfer.ENUMERATION_FLAVOR, classElementsTransfer.getTransferDataFlavors()[0]);
        assertEquals("Constructor failed, element is not correctly set.", enumerationElement, classElementsTransfer
                .getTransferData(ClassElementsTransfer.ENUMERATION_FLAVOR));
    }

    /**
     * Test constructor ClassElementsTransfer(Enumeration), with null
     * Enumeration instance. IllegalArgumentException is expected.
     */
    public void testCtorEnumerationWithNull() {
        try {
            Enumeration enumerationElement = null;
            new ClassElementsTransfer(enumerationElement);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor ClassElementsTransfer(Package), with correct Package
     * instance.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorPackage() throws Exception {
        com.topcoder.uml.model.modelmanagement.Package packageElement = new PackageImpl();
        ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(packageElement);

        assertEquals("Constructor failed, supportedFlavor is not correctly set.", ClassElementsTransfer.PACKAGE_FLAVOR,
                classElementsTransfer.getTransferDataFlavors()[0]);
        assertEquals("Constructor failed, element is not correctly set.", packageElement, classElementsTransfer
                .getTransferData(ClassElementsTransfer.PACKAGE_FLAVOR));
    }

    /**
     * Test constructor ClassElementsTransfer(Package), with null Package
     * instance. IllegalArgumentException is expected.
     */
    public void testCtorPackageWithNull() {
        try {
            com.topcoder.uml.model.modelmanagement.Package packageElement = null;
            new ClassElementsTransfer(packageElement);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor ClassElementsTransfer(Abstraction), with correct
     * Abstraction instance.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorAbstraction() throws Exception {
        Abstraction abstractionElement = new AbstractionImpl();
        ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(abstractionElement);

        assertEquals("Constructor failed, supportedFlavor is not correctly set.",
                ClassElementsTransfer.ABSTRACTION_FLAVOR, classElementsTransfer.getTransferDataFlavors()[0]);
        assertEquals("Constructor failed, element is not correctly set.", abstractionElement, classElementsTransfer
                .getTransferData(ClassElementsTransfer.ABSTRACTION_FLAVOR));
    }

    /**
     * Test constructor ClassElementsTransfer(Abstraction), with null
     * Abstraction instance. IllegalArgumentException is expected.
     */
    public void testCtorAbstractionWithNull() {
        try {
            Abstraction abstractionElement = null;
            new ClassElementsTransfer(abstractionElement);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor ClassElementsTransfer(Association), with correct
     * Association instance.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorAssociation() throws Exception {
        Association associationElement = new AssociationImpl();
        ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(associationElement);

        assertEquals("Constructor failed, supportedFlavor is not correctly set.",
                ClassElementsTransfer.ASSOCIATION_FLAVOR, classElementsTransfer.getTransferDataFlavors()[0]);
        assertEquals("Constructor failed, element is not correctly set.", associationElement, classElementsTransfer
                .getTransferData(ClassElementsTransfer.ASSOCIATION_FLAVOR));
    }

    /**
     * Test constructor ClassElementsTransfer(Association), with null
     * Association instance. IllegalArgumentException is expected.
     */
    public void testCtorAssociationWithNull() {
        try {
            Association associationElement = null;
            new ClassElementsTransfer(associationElement);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor ClassElementsTransfer(Dependency), with correct
     * Dependency instance.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorDependency() throws Exception {
        Dependency dependencyElement = new DependencyImpl();
        ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(dependencyElement);

        assertEquals("Constructor failed, supportedFlavor is not correctly set.",
                ClassElementsTransfer.DEPENDENCY_FLAVOR, classElementsTransfer.getTransferDataFlavors()[0]);
        assertEquals("Constructor failed, element is not correctly set.", dependencyElement, classElementsTransfer
                .getTransferData(ClassElementsTransfer.DEPENDENCY_FLAVOR));
    }

    /**
     * Test constructor ClassElementsTransfer(Dependency), with null Dependency
     * instance. IllegalArgumentException is expected.
     */
    public void testCtorDependencyWithNull() {
        try {
            Dependency dependencyElement = null;
            new ClassElementsTransfer(dependencyElement);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test constructor ClassElementsTransfer(Generalization), with correct
     * Generalization instance.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCtorGeneralization() throws Exception {
        Generalization generalizationElement = new GeneralizationImpl();
        ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(generalizationElement);

        assertEquals("Constructor failed, supportedFlavor is not correctly set.",
                ClassElementsTransfer.GENERALIZATION_FLAVOR, classElementsTransfer.getTransferDataFlavors()[0]);
        assertEquals("Constructor failed, element is not correctly set.", generalizationElement, classElementsTransfer
                .getTransferData(ClassElementsTransfer.GENERALIZATION_FLAVOR));
    }

    /**
     * Test constructor ClassElementsTransfer(Generalization), with null
     * Generalization instance. IllegalArgumentException is expected.
     */
    public void testCtorGeneralizationWithNull() {
        try {
            Generalization generalizationElement = null;
            new ClassElementsTransfer(generalizationElement);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test lostOwnership, with correct clipboard and transferable.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testLostOwnership() throws Exception {
        Dependency dependencyElement = new DependencyImpl();
        ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(dependencyElement);

        Clipboard clipboard = new Clipboard("test clipboard");
        classElementsTransfer.lostOwnership(clipboard, classElementsTransfer);

        // confirm the contents of the outputFile
        assertTrue(confirmFileContents("Clipboard test clipboard contains Dependency"));
    }

    /**
     * Test lostOwnership, with correct clipboard and transferable.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testLostOwnership2() throws Exception {
        Generalization generalizationElement = new GeneralizationImpl();
        ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(generalizationElement);

        Clipboard clipboard = new Clipboard("test clipboard");
        classElementsTransfer.lostOwnership(clipboard, classElementsTransfer);

        // confirm the contents of the outputFile
        assertTrue(confirmFileContents("Clipboard test clipboard contains Generalization"));
    }

    /**
     * Test lostOwnership, with null clipboard. IllegalArgumentException is
     * expected.
     */
    public void testLostOwnershipWithNullClipboard() {
        try {
            Generalization generalizationElement = new GeneralizationImpl();
            ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(generalizationElement);

            classElementsTransfer.lostOwnership(null, classElementsTransfer);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test lostOwnership, with null transferable. IllegalArgumentException is
     * expected.
     */
    public void testLostOwnershipWithNullTransferable() {
        try {
            Generalization generalizationElement = new GeneralizationImpl();
            ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(generalizationElement);

            Clipboard clipboard = new Clipboard("test clipboard");
            classElementsTransfer.lostOwnership(clipboard, null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getTransferDataFlavors.
     */
    public void testGetTransferDataFlavors() {
        Generalization generalizationElement = new GeneralizationImpl();
        ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(generalizationElement);

        assertEquals("Should only contain GENERALIZATION_FLAVOR", 1,
                classElementsTransfer.getTransferDataFlavors().length);
        assertEquals("Should contain GENERALIZATION_FLAVOR", ClassElementsTransfer.GENERALIZATION_FLAVOR,
                classElementsTransfer.getTransferDataFlavors()[0]);
    }

    /**
     * Test isDataFlavorSupported, with correct dataFlavor.
     */
    public void testIsDataFlavorSupported() {
        Generalization generalizationElement = new GeneralizationImpl();
        ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(generalizationElement);

        assertTrue("Should be GENERALIZATION_FLAVOR", classElementsTransfer
                .isDataFlavorSupported(ClassElementsTransfer.GENERALIZATION_FLAVOR));
        assertFalse("Should not be DEPENDENCY_FLAVOR", classElementsTransfer
                .isDataFlavorSupported(ClassElementsTransfer.DEPENDENCY_FLAVOR));
    }

    /**
     * Test lostOwnership, with null dataFlavor. IllegalArgumentException is
     * expected.
     */
    public void testIsDataFlavorSupportedWithNull() {
        try {
            Generalization generalizationElement = new GeneralizationImpl();
            ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(generalizationElement);

            classElementsTransfer.isDataFlavorSupported(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getTransferData, with correct dataFlavor.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testGetTransferData() throws Exception {
        Generalization generalizationElement = new GeneralizationImpl();
        ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(generalizationElement);

        assertEquals("Element is not correctly get.", generalizationElement, classElementsTransfer
                .getTransferData(ClassElementsTransfer.GENERALIZATION_FLAVOR));
    }

    /**
     * Test getTransferData, with null dataFlavor. IllegalArgumentException is
     * expected.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testGetTransferDataWithNull() throws Exception {
        try {
            Generalization generalizationElement = new GeneralizationImpl();
            ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(generalizationElement);

            classElementsTransfer.getTransferData(null);

            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getTransferData, with wrong dataFlavor. UnsupportedFlavorException
     * is expected.
     */
    public void testGetTransferDataWithWrong() {
        try {
            Generalization generalizationElement = new GeneralizationImpl();
            ClassElementsTransfer classElementsTransfer = new ClassElementsTransfer(generalizationElement);

            classElementsTransfer.getTransferData(ClassElementsTransfer.DEPENDENCY_FLAVOR);

            fail("UnsupportedFlavorException is expected.");
        } catch (UnsupportedFlavorException usfe) {
            // pass
        }
    }
}