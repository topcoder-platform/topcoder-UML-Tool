/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.ModelImpl;
import com.topcoder.uml.model.modelmanagement.Package;

import com.topcoder.util.config.ConfigManager;

import java.util.ArrayList;
import java.util.List;


/**
 * Usage demonstration for this component.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends AbstractGeneratorTestCase {
    /**
     * Name space.
     */
    private static final String NAMESPACE = "stub_class_generator";

    /**
     * A class.
     */
    private Classifier class1;

    /**
     * A second class.
     */
    private Classifier class2;

    /**
     * A package.
     */
    private Package package1;

    /**
     * A second package.
     */
    private Package package2;

    /**
     * The location string.
     */
    private String location;

    /**
     * Set up the fixture.
     *
     * @throws Exception
     *             to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.clearConfigManager();
        ConfigManager.getInstance().add("config.xml");

        Model model = new ModelImpl();
        this.package1 = this.createPackage("com.topcoder.uml.stubclassgenerator", model);
        this.package2 = this.createPackage("com.topcoder.uml.stubclassgenerator.java", model);

        this.class1 = this.createClass("Foo", this.package1);
        this.class2 = this.createClass("Bar", this.package2);

        this.package1 = this.getRootPackage(this.package1);
        this.package2 = this.getRootPackage(this.package2);

        this.location = TestHelper.createTempDir().getAbsolutePath();
    }

    /**
     * Clears the config manager.
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        TestHelper.clearConfigManager();
        new CodeWriter().deleteDirectory(this.location, false);
    }

    /**
     * Shows how to use {@link CodeGenerator} class.
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testDemo() throws Exception {
        // Create a new instance of CodeGenerator from a custom name space
        // + emptyLocationDirectory == true: location will be cleared
        // + createEmptyPackage == true: empty packages will be created
        CodeGenerator generator = new CodeGenerator(true, true, NAMESPACE);

        // Generate code for some classifier
        // the pacakge of class1 is com.topcoder.uml.stubclassgenerator
        // its name is Foo
        // therefore it will be written to:
        // location/com/topcoder/uml/stubclassgenerator/Foo.java
        generator.generateCode("Java", this.location, this.class1);

        // Generate code for a list of classifiers in C#
        List<Classifier> classList = new ArrayList<Classifier>();
        classList.add(this.class1);
        classList.add(this.class2);
        generator.generateCodeForClassifiers("C#", this.location, classList);

        // Generate code for a whole package
        generator.generateCode("Java", this.location, this.package1);

        // Generate code for list of packages
        List<Package> packageList = new ArrayList<Package>();
        packageList.add(this.package1);
        packageList.add(this.package2);
        generator.generateCodeForPackages("Java", this.location, packageList);

        // Generate combined code for package and for classifier which is not
        // part of given package.
        generator.generateCode("Java", this.location, this.class2);
        generator.generateCode("Java", this.location, this.package1);
    }
}
