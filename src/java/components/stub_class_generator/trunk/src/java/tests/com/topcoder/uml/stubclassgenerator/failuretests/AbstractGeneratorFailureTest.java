/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator.failuretests;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.stubclassgenerator.AbstractGenerator;
import com.topcoder.uml.stubclassgenerator.GeneratorConfigurationException;
import com.topcoder.util.config.ConfigManager;

import junit.framework.TestCase;

/**
 * Failure test for the <code>AbstractGenerator</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class AbstractGeneratorFailureTest extends TestCase {

    /**
     * Represents the <code>AbstractGenerator</code> instance used to test against.
     */
    private MockGenerator generator = null;

    /**
     * Sets up the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    protected void setUp() throws Exception {
        ConfigManager.getInstance().add("failure/config.xml");
        generator = new MockGenerator("com.topcoder.uml.stubclassgenerator");
    }

    /**
     * Tears down the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    protected void tearDown() throws Exception {
        ConfigManager manager = ConfigManager.getInstance();
        for (Iterator iter = manager.getAllNamespaces(); iter.hasNext();) {
            manager.removeNamespace((String) iter.next());
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with null namespace. IllegalArgumentException
     * should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testConstructorWithNullNamespace() throws Exception {
        try {
            new MockGenerator(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with empty namespace. IllegalArgumentException
     * should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testConstructorWithEmptyNamespace() throws Exception {
        try {
            new MockGenerator("  ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with unknown namespace.
     * GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithUnknownNamespace() {
        try {
            new MockGenerator("unknown");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses documentation
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissDocumentation() {
        try {
            new MockGenerator("MissDocumentation");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty
     * documentation property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyDocumentation() {
        try {
            new MockGenerator("EmptyDocumentation");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses
     * tagsDocumentation property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissTagsDocumentation() {
        try {
            new MockGenerator("MissTagsDocumentation");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty
     * tagsDocumentation property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyTagsDocumentation() {
        try {
            new MockGenerator("EmptyTagsDocumentation");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses new property.
     * GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissNew() {
        try {
            new MockGenerator("MissNew");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty new
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyNew() {
        try {
            new MockGenerator("EmptyNew");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses readonly
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissReadonly() {
        try {
            new MockGenerator("MissReadonly");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty readonly
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyReadonly() {
        try {
            new MockGenerator("EmptyReadonly");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses virtual
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissVirtual() {
        try {
            new MockGenerator("MissVirtual");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty virtual
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyVirtual() {
        try {
            new MockGenerator("EmptyVirtual");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses override
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissOverride() {
        try {
            new MockGenerator("MissOverride");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty override
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyOverride() {
        try {
            new MockGenerator("EmptyOverride");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses sealed
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissSealed() {
        try {
            new MockGenerator("MissSealed");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty sealed
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptySealed() {
        try {
            new MockGenerator("EmptySealed");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses extern
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissExtern() {
        try {
            new MockGenerator("MissExtern");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty extern
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyExtern() {
        try {
            new MockGenerator("EmptyExtern");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses delegate
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissDelegate() {
        try {
            new MockGenerator("MissDelegate");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty delegate
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyDelegate() {
        try {
            new MockGenerator("EmptyDelegate");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses explicit
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissExplicit() {
        try {
            new MockGenerator("MissExplicit");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty explicit
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyExplicit() {
        try {
            new MockGenerator("EmptyExplicit");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses implicit
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissImplicit() {
        try {
            new MockGenerator("MissImplicit");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty implicit
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyImplicit() {
        try {
            new MockGenerator("EmptyImplicit");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses struct
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissStruct() {
        try {
            new MockGenerator("MissStruct");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty struct
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyStruct() {
        try {
            new MockGenerator("EmptyStruct");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses property_get
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissPropertyGet() {
        try {
            new MockGenerator("MissPropertyGet");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty
     * property_get property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyPropertyGet() {
        try {
            new MockGenerator("EmptyPropertyGet");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses property_set
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissPropertySet() {
        try {
            new MockGenerator("MissPropertySet");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty
     * property_set property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyPropertySet() {
        try {
            new MockGenerator("EmptyPropertySet");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses property
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissProperty() {
        try {
            new MockGenerator("MissProperty");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty
     * property property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyProperty() {
        try {
            new MockGenerator("EmptyProperty");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses destructor
     * property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissDestructor() {
        try {
            new MockGenerator("MissDestructor");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty
     * destructor property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyDestructor() {
        try {
            new MockGenerator("EmptyDestructor");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which misses protected
     * internal property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceMissProtectedInternal() {
        try {
            new MockGenerator("MissProtectedInternal");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }

    /**
     * Test the constructor <code>AbstractGenerator(String)</code> with invalid namespace which contains empty
     * protected internal property. GeneratorConfigurationException should be thrown.
     */
    public void testConstructorWithInvalidNamespaceEmptyProtectedInternal() {
        try {
            new MockGenerator("EmptyProtectedInternal");
            fail("GeneratorConfigurationException should be thrown.");
        } catch (GeneratorConfigurationException e) {
            // success
        }
    }


    /**
     * Test the method <code>getPackage(Package)</code> with null pack. IllegalArgumentException should be thrown.
     */
    public void testGetPackagePackageWithNullPack() {
        try {
            generator.getPackage((Package) null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>getPackage(Classifier)</code> with null classifier. IllegalArgumentException should be
     * thrown.
     */
    public void testGetPackageWithNullClassifier() {
        try {
            generator.getPackage((Classifier) null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>checkClassifier(Classifier)</code> with null classifier. IllegalArgumentException should
     * be thrown.
     */
    public void testCheckClassifierWithNullClassifier() {
        try {
            generator.checkClassifier(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>getGeneralDocumentation(ModelElement)</code> with null modelElement.
     * IllegalArgumentException should be thrown.
     */
    public void testGetGeneralDocumentationWithNullModelElement() {
        try {
            generator.getGeneralDocumentation(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>getTagDocumentation(ModelElement)</code> with null modelElement. IllegalArgumentException
     * should be thrown.
     */
    public void testGetTagDocumentationWithNullModelElement() {
        try {
            generator.getTagDocumentation(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>getParametersDocumentation(Operation)</code> with null operation. IllegalArgumentException
     * should be thrown.
     */
    public void testGetParametersDocumentationWithNullOperation() {
        try {
            generator.getParametersDocumentation(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * This is a mock implementation of <code>AbstractGenerator</code> class, it is only used in the test.
     */
    private class MockGenerator extends AbstractGenerator {

        /**
         * This constructor simply call the constructor of super class.
         *
         * @param namespace
         *            the namespace passed to super constructor
         * @throws GeneratorConfigurationException
         *             thrown from super class
         */
        public MockGenerator(String namespace) throws GeneratorConfigurationException {
            super(namespace);
        }

        /**
         * Wrapper of getGeneralDocumentation.
         *
         * @param modelElement
         *            passed to super class
         * @return the string from super class
         */
        public String getGeneralDocumentation(ModelElement modelElement) {
            return super.getGeneralDocumentation(modelElement);
        }

        /**
         * Wrapper of getTagDocumentation.
         *
         * @param modelElement
         *            passed to super class
         * @return the map from super class
         */
        public Map<String, List<String>> getTagDocumentation(ModelElement modelElement) {
            return super.getTagDocumentation(modelElement);
        }

        /**
         * Wrapper of getParametersDocumentation.
         *
         * @param operation
         *            passed to super class
         * @return the map from super class
         */
        public Map<String, List<String>> getParametersDocumentation(Operation operation) {
            return super.getParametersDocumentation(operation);
        }

        /**
         * Simply returns empty string.
         *
         * @param classifier
         *            ignored
         * @return always empty string
         */
        public String createClassifierCode(Classifier classifier) {
            return "";
        }
    }
}
