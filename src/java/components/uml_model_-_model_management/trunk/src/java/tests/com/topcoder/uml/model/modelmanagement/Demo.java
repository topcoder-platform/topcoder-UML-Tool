/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * The demo will demonstrate the usage of these beans. It will show them being
 * instantiated, then used via their interface. This will be the typical usage
 * of such simple entities under any scenario. This demo will focus on showing
 * how a simple and collection attribute is managed, with the understanding that
 * all other attributes are managed in exactly the same manner, and therefore
 * not shown here.
 * @author vilain
 * @version 1.0
 */
public class Demo extends TestCase {

    /**
     * Create an instance of sample entity: ElementImport. All other concrete
     * entities are instantiated in this manner and are not shown here.
     */
    public final void testInstantiation() {
        // Create an instance of sample entity
        new ElementImportImpl();
    }

    /**
     * Manage a simple attribute: ElementImport.package. All other simple
     * attributes are managed in this manner and are not shown here.
     */
    public final void testSimpleAttributeManagement() {
        // Create sample entity with a simple attribute to manage
        ElementImport elementImport = new ElementImportImpl();
        // Use setter
        Package aPackage = new PackageImpl();
        elementImport.setPackage(aPackage);
        // Use getter
        elementImport.getPackage();
    }

    /**
     * Manage a collection attribute: Package.elementImports. All other
     * collection attributes are managed in this manner and are not shown here.
     */
    public final void testCollectionAttributeManagement() {
        // Create sample entity with a collection attribute to manage
        Package aPackage = new PackageImpl();
        // Use single-entity add method
        ElementImport imp1 = new ElementImportImpl();
        aPackage.addElementImport(imp1);
        // There is now one elementImport in the collection
        // Use multiple-entity add method
        Collection<ElementImport> col1 = new ArrayList<ElementImport>();
        for (int i = 0; i < 5; i++) {
            col1.add(new ElementImportImpl());
        }
        aPackage.addElementImports(col1);
        // There will now be 6 elementImports in the collection
        // Use contains method to check for elementImport presence
        System.out.println(aPackage.containsElementImport(imp1));
        // This will be true
        // Use count method to get the number of elementImports
        System.out.println(aPackage.countElementImports());
        // The count will be 6
        // Use single-entity remove method
        System.out.println(aPackage.removeElementImport(imp1));
        // This will be true, and the collection size is 5, regardless
        // if imp1 has duplicates in this collection.
        // Use multiple-entity remove method
        Collection<ElementImport> col2 = new ArrayList<ElementImport>();
        System.out.println(aPackage.removeElementImports(col2));
        // This will be true, and the collection size is 2
        // Use clear method
        aPackage.clearElementImports();
        // The collection size is 0 and contains no elementImports
    }
}