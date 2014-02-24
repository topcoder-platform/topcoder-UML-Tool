/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.importer.jarimporter.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.importer.jarimporter.JarImporter;
import com.topcoder.uml.importer.jarimporter.JarImporterException;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.EnumerationImpl;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.classifiers.PrimitiveImpl;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.core.relationships.Relationship;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.modelmanagement.Model;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.errorhandling.ExceptionUtils;

/**
 * <p>
 * This class is the default implementation of the <code>JarImporter</code> abstract class.
 * </p>
 * <p>
 * It uses <code>URLClassLoader</code> and <code>JarFile</code> to pull the packages and classes
 * from the JARs, it uses reflection to get the external classes, related relationships, attributes,
 * operations, etc. And then import them into TC UML Model.
 * </p>
 * <p>
 * At last, it just put all the classes and relationships into the specific diagram, the positions
 * in the diagram are not specified.
 * </p>
 * <p>
 * It also allows the user specify an extra classpath so that the target JARs can be imported
 * successfully. Otherwise, some external classes may be unable to be loaded by reflection.
 * </p>
 *
 * <p>
 * Main usage of this component :
 * </p>
 *
 * <pre>
 * // Create UMLModelManager and add Diagram to it.
 * UMLModelManager umlMgr = UMLModelManager.getInstance();
 * diagram = new Diagram();
 * diagram.setName(&quot;Main Class Diagram&quot;);
 * umlMgr.addDiagram(diagram);
 *
 * // Create DefaultJarImporter instance.
 * JarImporter importer = new DefaultJarImporter(umlMgr, new String[] { &quot;test_files/base1.jar&quot; });
 *
 * importer = new DefaultJarImporter(umlMgr, new URL[] { new File(&quot;test_files/base1.jar&quot;).toURI()
 *     .toURL() });
 *
 * // only import the JARs to Model
 * importer.importJars(new String[] { &quot;test_files/base1.jar&quot;, &quot;test_files/base2.jar&quot; });
 *
 * // import JARs with specified URLs to Model
 * importer.importJars(new URL[] { new File(&quot;test_files/base1.jar&quot;).toURI().toURL() });
 *
 * // import the JARs to model, and then import all the entities into specified
 * // diagram. Here assume there is a class diagram named with &quot;Main Class Diagram&quot;
 * importer.importJarsToDiagram(new String[] { &quot;test_files/base1.jar&quot;, &quot;test_files/base2.jar&quot; },
 *     &quot;Main Class Diagram&quot;);
 *
 * // use URLs instead.
 * importer.importJarsToDiagram(new URL[] { new File(&quot;test_files/base1.jar&quot;).toURI().toURL() },
 *     &quot;Main Class Diagram&quot;);
 * </pre>
 *
 * <p>
 * Thread-safety: This class is not thread-safe as the base class is not thread-safe.
 * </p>
 *
 * @author dmks, TCSDEVELOPER
 * @version 1.0
 */
public class DefaultJarImporter extends JarImporter {
    /**
     * Represents the 'java.' const string, which is the starting of built type.
     */
    private static final String JAVAPREF = "java.";

    /**
     * Represents the '.class' const string, which is the end of the class name.
     */
    private static final String CLASS = ".class";

    /**
     * Represents the 'inner' const string.
     */
    private static final String INNER = "inner";

    /**
     * Represents the 'Return' const string.
     */
    private static final String RETURN = "Return";

    /**
     * Represents the 'void' const string.
     */
    private static final String VOID = "void";

    /**
     * <p>
     * Represents the extra classpath which is used to import the JARs.
     * </p>
     * <p>
     * Initialized in the constructor, not change after that. Can't be null.
     * </p>
     * <p>
     * Used in <code>retrievePackagesAndClassesFromJars</code> method.
     * </p>
     */
    private final URLClassLoader classpathLoader;

    /**
     * <p>
     * Create a new <code>DefaultJarImporter</code> instance with given
     * <code>UMLModelManager</code> and classpath.
     * </p>
     *
     * @param classpath the extra classpath to help importing the JARs, can be null.
     * @param modelManager the <code>UMLModelManager</code> instance.
     * @throws IllegalArgumentException - if modelManager is null or the classpathLoader can't be
     * initialized according the given classpath, or classpath contains null element.
     */
    public DefaultJarImporter(UMLModelManager modelManager, URL[] classpath) {
        super(modelManager);
        if (classpath != null && classpath.length > 0) {
            for (URL url : classpath) {
                if (url == null) {
                    throw new IllegalArgumentException("classpath#element can not be null.");
                }
            }
        }
        if (classpath == null) {
            this.classpathLoader = createURLClassLoader(new URL[0], null);
        } else {
            this.classpathLoader = createURLClassLoader(classpath, null);
        }
    }

    /**
     * Create a new <code>DefaultJarImporter</code> instance with given
     * <code>UMLModelManager</code> and classpath.
     *
     * @param classpath the extra classpath to help importing the JARs, can be null.
     * @param modelManager the <code>UMLModelManager</code> instance.
     * @throws IllegalArgumentException - if modelManager is null or the classpath contains
     * null/empty string or the classpathLoader can't be initialized according the given classpath.
     */
    public DefaultJarImporter(UMLModelManager modelManager, String[] classpath) {
        super(modelManager);
        if (classpath == null) {
            this.classpathLoader = createURLClassLoader(new URL[0], null);
        } else {
            URL[] urls = new URL[classpath.length];
            for (int i = 0; i < classpath.length; i++) {
                ExceptionUtils.checkNullOrEmpty(classpath[i], null, null,
                    "classpath#element can not be null or empty.");
                try {
                    File file = new File(classpath[i]);
                    if (!file.exists()) {
                        throw new IllegalArgumentException("the file in classpath does not exist.");
                    }
                    urls[i] = file.toURI().toURL();
                } catch (MalformedURLException e) {
                    throw new IllegalArgumentException("Error when accessing the url with path '"
                        + classpath[i] + "' for " + e.getMessage(), e);
                } catch (SecurityException se) {
                    throw new IllegalArgumentException("Error when accessing the path '"
                        + classpath[i] + "' for " + se.getMessage(), se);
                }
            }

            // Create an URLClassLoader by the given URLs.
            this.classpathLoader = createURLClassLoader(urls, null);
        }
    }

    /**
     * Create <code>URLClassLoader</code> instance with array of <code>URL</code> instances and
     * the parent <code>URLClassLoader</code> class. The parent <code>URLClassLoader</code>
     * class can be null.
     *
     * @param jarURLs the <code>URL</code> instances.
     * @param loader the parent <code>URLClassLoader</code> class
     * @return the new created <code>URLClassLoader</code> instance.
     */
    private URLClassLoader createURLClassLoader(URL[] jarURLs, URLClassLoader loader) {
        try {
            // Create an URLClassLoader by the given URLs.
            if (loader == null) {
                return new URLClassLoader(jarURLs);
            } else {
                return new URLClassLoader(jarURLs, loader);
            }
        } catch (SecurityException se) {
            throw new IllegalArgumentException("Error when creating URLClassLoader for "
                + se.getMessage(), se);
        }
    }

    /**
     * <p>
     * Pull the packages and classes defined in the given JARs, and store the result in packages and
     * classes variable.
     * </p>
     * <p>
     * If the class does not have package name, it will be added to classes variable and packages
     * with empty string key with <code>null</code>.
     * </p>
     *
     * @param jarURLs the URLs of the JARS to be imported.
     * @throws JarImporterException - if any error occurred when processing the JARs.
     * @throws IllegalArgumentException if error creating loader or error when creating jar file.
     */
    protected void retrievePackagesAndClassesFromJars(URL[] jarURLs) throws JarImporterException {
        // Create an URLClassLoader by the given URL and parent classpathLoader.
        URLClassLoader loader = createURLClassLoader(jarURLs, classpathLoader);

        // for each jar
        for (URL jarURL : jarURLs) {
            // Create JarFile instance
            JarFile jar = createJarFile(jarURL);

            // for each jar entry
            for (Enumeration<JarEntry> e = jar.entries(); e.hasMoreElements();) {
                // Get the name of class, the format will like : 'com/topcoder/pack/MyEnum.class'
                String name = e.nextElement().toString();

                // Filter the .MF file and directory etc.
                if (name.endsWith(CLASS)) {
                    // it is a class entry, get the class binary name
                    name = name.substring(0, name.length() - 6).replace('/', '.');
                    Class<?> clazz;
                    try {
                        clazz = loader.loadClass(name);
                    } catch (ClassNotFoundException cnfe) {
                        // Error should not be catch.
                        throw new JarImporterException("Error when loading class with name'" + name
                            + "' for " + cnfe.getMessage(), cnfe);
                    }

                    addClassAndPackage(getClasses(), clazz, name);
                }
            }
        }
    }

    /**
     * Create <code>JarFile</code> instance from the given <code>URL</code> instance.
     *
     * @param jarURL the <code>URL</code> instance used to create <code>JarFile</code> instance.
     * @return the new <code>JarFile</code> instance.
     * @throws IllegalArgumentException if error when creating <code>JarFile</code> instance.
     * @throws JarImporterException - if any error occurred when creating jar file.
     */
    private static final JarFile createJarFile(URL jarURL) throws JarImporterException {
        try {
            return new JarFile(new File(jarURL.toURI()));
        } catch (FileNotFoundException fnfe) {
            throw new IllegalArgumentException("Error when creating jar file for "
                + fnfe.getMessage(), fnfe);
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Error when creating jar file for "
                + ioe.getMessage(), ioe);
        } catch (URISyntaxException use) {
            throw new IllegalArgumentException("Error when creating jar file for "
                + use.getMessage(), use);
        } catch (SecurityException se) {
            throw new IllegalArgumentException("Error when creating jar file for "
                + se.getMessage(), se);
        }
    }

    /**
     * <p>
     * Extracts the external classes for the classes retrieved from JARs.
     * </p>
     * <p>
     * The 'void' class will be ignored. If the package is null, it will not be added to packages
     * variables. And primitive class will be added to externalClasses variable.
     * </p>
     * <p>
     * The name in classes and packages is not duplicated.
     * </p>
     *
     * @throws JarImporterException - if any error occurred when extracting the external classes.
     */
    protected void extractExternalClasses() throws JarImporterException {
        // For each class in classes, get the external classes
        for (Class<?> clazz : getClasses().values()) {
            // Add all the interfaces implemented by this class and its package to mappings.
            for (Class<?> inter : clazz.getInterfaces()) {
                addClassAndPackage(getExternalClasses(), inter, inter.getName());
            }

            // Add the super class and package to mappings.
            Class<?> superclass = clazz.getSuperclass();
            if (superclass != null) {
                addClassAndPackage(getExternalClasses(), superclass, superclass.getName());
            }

            // Add all the fields type class and package to mappings.
            for (Field field : clazz.getDeclaredFields()) {
                Class<?> arrayField = field.getType();
                if (arrayField.isArray()) {
                    Class<?> cls = arrayField.getComponentType();
                    addClassAndPackage(getExternalClasses(), cls, cls.getName());
                } else {
                    addClassAndPackage(getExternalClasses(), field.getType(), field.getType().getName());
                }
            }

            // Add all the methods, return type class and package to mappings.
            for (Method m : clazz.getDeclaredMethods()) {
                // Add each method parameter type and package to mappings.
                for (Class<?> paramClass : m.getParameterTypes()) {
                    addClassAndPackage(getExternalClasses(), paramClass, paramClass.getName());
                }

                // Add the return type class and package to mappings.
                addClassAndPackage(getExternalClasses(), m.getReturnType(), m.getReturnType()
                    .getName());
            }
        }
    }

    /**
     * <p>
     * Add the given class to externalClasses, if the class name does not exist in externalClasses
     * variable; add its package to packages variable, if package is null, add empty string for key, null for value.
     * </p>
     * <p>
     * 'void' type should be ignored.
     * </p>
     * @param classes the mapping of inner classes.
     * @param clazz the given class to add.
     * @param clazzName the class name for the key to add.
     */
    private void addClassAndPackage(Map<String, Class<?>> classes, Class<?> clazz, String clazzName) {

        // http://forums.topcoder.com/?module=Thread&threadID=620923&start=0
        // the 'void' type should be removed.
        if (VOID.equals(clazzName)) {
            return;
        }

        if (!this.getClasses().containsKey(clazzName)) {
            // Add the classes containing 'int', 'double' etc to external classes mapping.
            classes.put(clazzName, clazz);

            java.lang.Package pkg = clazz.getPackage();

            if (pkg == null) {
                getPackages().put("", null);
            } else {
                if (!getPackages().containsKey(pkg.getName())) {
                    getPackages().put(pkg.getName(), pkg);
                }
            }
        }
    }

    /**
     * <p>
     * Import the packages and classes into the TC UML Model.
     * </p>
     * <p>
     * All the external classes and relationships referenced by the classes are also imported into
     * Model.
     * </p>
     * <p>
     * After imported, the externalClasses, modelPackages, modelClasses, relationships and
     * classesToRelationships will be populated.
     * </p>
     *
     * @throws JarImporterException - if any error occurred when importing to Model.
     */
    protected void importPackagesAndClassesToModel() throws JarImporterException {

        Model model = this.getModelManager().getModel();

        // Part1 Add packages to model
        // For each package, add it to model, the 'java.*' package should not filter since
        // these packages can be in model.
        for (String packageName : getPackages().keySet()) {
            // The package name can not be whitespaces.
            // http://forums.topcoder.com/?module=Thread&threadID=620926&start=0
            if (packageName.trim().length() > 0) {
                Package p = new PackageImpl();
                p.setName(packageName);
                p.setNamespace(model);
                model.addOwnedElement(p);
                getModelPackages().put(packageName, p);
            } else {
                // default package, add model as the package and trim the package name is needed.
                getModelPackages().put(packageName.trim(), model);
            }
        }

        // Part2 Add external classes/interfaces/datatypes to model (getModelClasses()).
        for (Class<?> clazz : getExternalClasses().values()) {
            importClassesToModule(clazz, model);
        }

        // Part3 Add classes/interfaces from the jar to model (getModelClasses())
        for (Class<?> clazz : getClasses().values()) {
            importClassesToModule(clazz, model);
        }

        // Part4 Add features (attributes and methods) and relationships (association,
        // dependency, abstraction, generalization) of classes to model
        importClassAttributesToModule(model);
    }

    /**
     * <p>
     * Import the inner or external classes into the TC UML Model.
     * </p>
     *
     * @param clazz the Class to import to model.
     * @param model the <code>Model</code> instance to accept the class.
     * @throws JarImporterException if any error occurred when importing to Model.
     */
    private void importClassesToModule(Class<?> clazz, Model model) throws JarImporterException {
        // Create corresponding Classifier instance for the class.
        // The class can be interface or enum or primitive or class.
        // Note : http://forums.topcoder.com/?module=Thread&threadID=620926&start=0
        Classifier classifier = null;
        if (clazz.isInterface()) {
            classifier = new InterfaceImpl();
        } else if (clazz.isEnum()) {
            classifier = new EnumerationImpl();
        } else if (clazz.isPrimitive()) {
            // for inner class, it never happens.
            classifier = new PrimitiveImpl();
        } else if (clazz.isArray()) {
            classifier = new ClassImpl();
            classifier.setName(clazz.getCanonicalName());
        } else {
            classifier = new ClassImpl();
        }

        // set the namespace of it, if package is null, set model as its namespace.
        java.lang.Package javaPackage = clazz.getPackage();
        if (javaPackage == null) {
            classifier.setNamespace(model);

            // model will be the owned element for classifier.
            model.addOwnedElement(classifier);
        } else {
            Package p = getModelPackages().get(javaPackage.getName());
            classifier.setNamespace(p);

            // add it to the namespace
            p.addOwnedElement(classifier);
        }

        classifier.setName(clazz.getSimpleName());

        // set 'final', 'static', and 'abstract' modifiers properties to classifier
        int mod = clazz.getModifiers();
        classifier.setAbstract(Modifier.isAbstract(mod));
        classifier.setLeaf(Modifier.isFinal(mod));
        classifier.setRoot(Modifier.isStatic(mod));

        // Set the visibility of classifier. Only private, protected and public are supported.
        setVisibility(classifier, mod);

        // add all the classes and external classes to model classes.
        // Note: getModelClasses() will contain these class : java.*
        getModelClasses().put(clazz.getName(), classifier);
    }

    /**
     * Add attributes, methods and relationships (association, dependency, abstraction,
     * generalization) of classes into the TC UML Model.
     *
     * @param model the <code>Model</code> instance to accept the class attributes.
     */
    private void importClassAttributesToModule(Model model) {
        for (Class<?> cls : getClasses().values()) {
            Classifier classifier = getModelClasses().get(cls.getName());

            java.lang.Package pkg = cls.getPackage();
            String packageName = pkg == null ? "" : pkg.getName();

            // if package name is empty string, model will be retrieved from getModelPackages().
            Package p = getModelPackages().get(packageName);

            List<Relationship> relationships = new ArrayList<Relationship>();

            // add the relationship to relations list.
            addRelationWithInterfaces(model, cls, classifier, packageName, p, relationships);
            addRelationWithSuperClass(model, cls, classifier, packageName, p, relationships);
            addRelationWithFields(model, cls, classifier, packageName, p, relationships);
            addRelationWithMethods(model, cls, classifier, packageName, p, relationships);
            addRelationWithInnerClass(model, cls, classifier, packageName, p, relationships);

            this.getClassesToRelationships().put(classifier, relationships);
        }
    }

    /**
     * Add the relationships between the given class and its interfaces implemented by that class.
     *
     * @param model the <code>Model</code> instance.
     * @param cls the given class.
     * @param classifier the Classifier instance.
     * @param packageName the package name.
     * @param p the <code>Package</code> instance to set as namespace.
     * @param relationships the list of <code>Relationship</code> to accept the new created
     * relationship.
     */
    private void addRelationWithInterfaces(Model model, Class<?> cls, Classifier classifier,
        String packageName, Package p, List<Relationship> relationships) {
        for (Class<?> inter : cls.getInterfaces()) {
            // Create an Abstraction
            Abstraction abstraction = new AbstractionImpl();

            // add supplier of this abstraction
            abstraction.addSupplier(getModelClasses().get(inter.getName()));

            // add client of this abstraction
            abstraction.addClient(classifier);

            // set the namespace to.
            setNamespace(inter, model, abstraction, packageName, p);

            classifier.addClientDependency(abstraction);

            getRelationships().add(abstraction);

            // add all the relationship with cls to list.
            relationships.add(abstraction);
        }
    }

    /**
     * Set the namespace to <code>ModelElement</code>. If the package of class is null, set model
     * to; if the package name equals to the given package name, set the given Package to,
     * otherwise, set model to.
     *
     * @param clazz the given class.
     * @param model the <code>Model</code> instance.
     * @param ele the <code>ModelElement</code> to set its namespace.
     * @param packageName the package name.
     * @param p the <code>Package</code> instance to set as namespace.
     */
    private static void setNamespace(Class<?> clazz, Model model, ModelElement ele, String packageName,
        Package p) {
        if (clazz.getPackage() == null) {
            ele.setNamespace(model);
        } else {
            ele.setNamespace(packageName.equals(clazz.getPackage().getName()) ? p : model);
        }
    }

    /**
     * Set the visibility to the given <code>ModelElement</code> instance according to the given
     * mod value.
     *
     * @param ele the given <code>ModelElement</code> instance to set.
     * @param mod the identifier of visibility to set.
     */
    private static void setVisibility(ModelElement ele, int mod) {
        if (Modifier.isPrivate(mod)) {
            ele.setVisibility(VisibilityKind.PRIVATE);
        } else if (Modifier.isProtected(mod)) {
            ele.setVisibility(VisibilityKind.PROTECTED);
        } else if (Modifier.isPublic(mod)) {
            ele.setVisibility(VisibilityKind.PUBLIC);
        }
    }

    /**
     * Add the relationships between the given class and its super class (Only one super class) of
     * that class, if super class is null, do nothing.
     *
     * @param model the <code>Model</code> instance.
     * @param cls the given class.
     * @param classifier the Classifier instance.
     * @param packageName the package name.
     * @param p the <code>Package</code> instance to set as namespace.
     * @param relationships the list of <code>Relationship</code> to accept the new created
     * relationship.
     */
    private void addRelationWithSuperClass(Model model, Class<?> cls, Classifier classifier,
        String packageName, Package p, List<Relationship> relationships) {
        Class<?> superclass = cls.getSuperclass();
        if (superclass != null) {
            // Create a Generalization
            Generalization generalization = new GeneralizationImpl();
            // set parent of the Generalization
            generalization.setParent(getModelClasses().get(superclass.getName()));
            // set child of the Generalization
            generalization.setChild(classifier);

            // set the namespace to.
            setNamespace(superclass, model, generalization, packageName, p);

            classifier.addGeneralization(generalization);
            getRelationships().add(generalization);

            // also add it to the classesToRelationships map
            relationships.add(generalization);
        }
    }

    /**
     * Add the relationships between the given class and its fields owned by that class.
     *
     * @param model the <code>Model</code> instance.
     * @param cls the given class.
     * @param classifier the Classifier instance.
     * @param packageName the package name.
     * @param p the <code>Package</code> instance to set as namespace.
     * @param relationships the list of <code>Relationship</code> to accept the new created
     * relationship.
     */
    private void addRelationWithFields(Model model, Class<?> cls, Classifier classifier,
        String packageName, Package p, List<Relationship> relationships) {
        for (Field field : cls.getDeclaredFields()) {
            // Here should be the type of field, not using getDeclaringClass.
            Class<?> fieldClass = field.getType();

            // add the field as the attribute in the classifer
            Attribute attribute = new AttributeImpl();
            attribute.setType(getModelClasses().get(fieldClass.getName()));
            attribute.setOwner(classifier);
            attribute.setName(field.getName());

            // If the field is final, set to frozen.
            int fieldMod = field.getModifiers();
            if (Modifier.isFinal(fieldMod)) {
                attribute.setChangeability(ChangeableKind.FROZEN);
            }

            // Note : the static attribute is added during final fix.
            if (Modifier.isStatic(fieldMod)) {
                ((Feature) attribute).setOwnerScope(ScopeKind.CLASSIFIER);
            }

            // Set the visibility of classifier. Only private, protected and public are supported.
            setVisibility(attribute, fieldMod);

            classifier.addFeature(attribute);

            // the relationship to primitive and system classes should be ignored.
            if (!fieldClass.isPrimitive() && !fieldClass.getName().startsWith(JAVAPREF)) {
                // create AssociationEnd instances
                AssociationEnd end1 = new AssociationEndImpl();
                end1.setParticipant(classifier);
                AssociationEnd end2 = new AssociationEndImpl();
                end2.setParticipant(getModelClasses().get(fieldClass.getName()));
                end2.setName(field.getName());

                // also set visibility to end2.
                setVisibility(end2, fieldMod);

                // create Association instances
                Association association = new AssociationImpl();
                association.addConnection(end1);
                association.addConnection(end2);
                end1.setAssociation(association);
                end2.setAssociation(association);

                // set the namespace to.
                setNamespace(fieldClass, model, association, packageName, p);

                getRelationships().add(association);

                // also add it to the classesToRelationships map
                relationships.add(association);
            }
        }

    }

    /**
     * Add the relationships between the given class and its methods owned by that class.
     *
     * @param model the <code>Model</code> instance.
     * @param cls the given class.
     * @param classifier the Classifier instance.
     * @param packageName the package name.
     * @param p the <code>Package</code> instance to set as namespace.
     * @param relationships the list of <code>Relationship</code> to accept the new created
     * relationship.
     */
    private void addRelationWithMethods(Model model, Class<?> cls, Classifier classifier,
        String packageName, Package p, List<Relationship> relationships) {
        for (Method m : cls.getDeclaredMethods()) {
            Operation operation = new OperationImpl();
            operation.setName(m.getName());
            operation.setOwner(classifier);
            classifier.addFeature(operation);

            // set final, static, and abstract modifiers properties
            int mod = m.getModifiers();

            operation.setAbstract(Modifier.isAbstract(mod));
            operation.setLeaf(Modifier.isFinal(mod));
            operation.setRoot(Modifier.isStatic(mod));

            // Set the visibility of operation. Only private, protected and public are supported.
            setVisibility(operation, mod);

            // add parameters to this operation
            for (Class<?> paramClass : m.getParameterTypes()) {
                Parameter parameter = new ParameterImpl();
                // Note that we can't get parameter name from compiled
                // class by reflection. So we use the paramClass's name as
                // the name.
                String name = paramClass.getSimpleName();
                // if the class is only one letter.
                if (name.trim().length() == 1) {
                    name = name.toLowerCase();
                } else {
                    name = name.substring(0, 1).toLowerCase() + name.substring(1);
                }

                parameter.setName(name);
                parameter.setType(getModelClasses().get(paramClass.getName()));

                operation.addParameter(parameter);
            }

            // also add Return as the parameter with the name "Return" to operation.
            Class<?> retType = m.getReturnType();
            Parameter ret = new ParameterImpl();
            ret.setName(RETURN);
            ret.setType(getModelClasses().get(retType.getName()));
            operation.addParameter(ret);

            // Iterate the parameter of the method
            for (Class<?> paramClass : m.getParameterTypes()) {
                createDependency(model, paramClass, classifier, packageName, p, relationships);
            }

            // set the dependency for return type.
            createDependency(model, retType, classifier, packageName, p, relationships);
        }
    }

    /**
     * Create the <code>Dependency</code> for the given <code>Classifier</code>.
     *
     * @param model the <code>Model</code> instance.
     * @param cls the given class.
     * @param classifier the Classifier instance.
     * @param packageName the package name.
     * @param p the <code>Package</code> instance to set as namespace.
     * @param relationships the list of <code>Relationship</code> to accept the new created
     * relationship.
     */
    private void createDependency(Model model, Class<?> cls, Classifier classifier,
        String packageName, Package p, List<Relationship> relationships) {
        if (!cls.isPrimitive() && !cls.getName().startsWith(JAVAPREF)) {
            Dependency dependency = new DependencyImpl();
            Classifier c = getModelClasses().get(cls.getName());
            if (c != null) {
                // add supplier of this dependency
                dependency.addSupplier(c);
            }

            // add client of this dependency
            dependency.addClient(classifier);

            // set the namespace to.
            setNamespace(cls, model, dependency, packageName, p);

            classifier.addClientDependency(dependency);
            getRelationships().add(dependency);

            // also add it to the classesToRelationships map
            relationships.add(dependency);
        }
    }

    /**
     * Add the relationships between the given class and its inner classes owned by that class.
     *
     * @param model the <code>Model</code> instance.
     * @param cls the given class.
     * @param classifier the Classifier instance.
     * @param packageName the package name.
     * @param p the <code>Package</code> instance to set as namespace.
     * @param relationships the list of <code>Relationship</code> to accept the new created
     * relationship.
     */
    private void addRelationWithInnerClass(Model model, Class<?> cls, Classifier classifier,
        String packageName, Package p, List<Relationship> relationships) {

        // getClasses method can not get the inner class.
        // getDeclaredClasses is the correct method.
        for (Class<?> inner : cls.getDeclaredClasses()) {
            Dependency dependency = new DependencyImpl();

            Classifier c = getModelClasses().get(inner.getName());
            if (c != null) {
                // add supplier of this dependency
                dependency.addSupplier(c);
            }

            // add client of this abstraction
            dependency.addClient(classifier);

            Stereotype stereotype = new StereotypeImpl();
            stereotype.setName(INNER);

            // Add it to model first.
            if (!model.containsOwnedElement(stereotype)) {
                model.addOwnedElement(stereotype);
            }

            dependency.addStereotype(stereotype);

            // set the namespace to.
            setNamespace(inner, model, dependency, packageName, p);

            classifier.addClientDependency(dependency);
            getRelationships().add(dependency);

            // also add it to the classesToRelationships map
            relationships.add(dependency);
        }
    }

    /**
     * <p>
     * Import all the entities populated in the previous step to a specific diagram.
     * </p>
     * <p>
     * The system inner package starting with "java." should be not in diagram.
     * </p>
     * <p>
     * The primitive classes should not be in diagram.
     * </p>
     *
     * @throws JarImporterException - if any error occurred when importing entities to diagram.
     * @param diagram the Diagram instance which accept the entities.s
     */
    protected void importToDiagram(Diagram diagram) throws JarImporterException {
        // add the relationships to the diagram first
        // define the Relationship to GraphEdge map.
        Map<Relationship, GraphEdge> edges = new HashMap<Relationship, GraphEdge>();
        for (Relationship ship : getRelationships()) {
            GraphEdge edge = new GraphEdge();
            Uml1SemanticModelBridge brige = new Uml1SemanticModelBridge();
            brige.setElement(ship);
            edge.setSemanticModel(brige);
            edge.setPosition(new Point());

            diagram.addContained(edge);
            edges.put(ship, edge);
        }

        // add the classifiers to the diagram
        for (Classifier classifier : getModelClasses().values()) {

            // the primitive class and system classes should not be imported.
            String name = classifier.getNamespace().getName();
            if (name == null || name.startsWith(JAVAPREF)) {
                continue;
            }

            // Create the node for each classifier.
            GraphNode node = new GraphNode();
            node.setPosition(new Point());
            Uml1SemanticModelBridge brige = new Uml1SemanticModelBridge();
            brige.setElement(classifier);
            node.setSemanticModel(brige);

            // get related Relationships for this classifier
            List<Relationship> rs = getClassesToRelationships().get(classifier);

            // the relationships may be null. For example, A connect to B, the relationship
            // is owned by B, and when passing A, the return relationship is null.
            if (rs != null) {
                for (Relationship r : rs) {
                    GraphConnector connector = new GraphConnector();
                    GraphEdge edge = edges.get(r);
                    connector.addGraphEdge(edge);
                    node.addAnchorage(connector);
                    edge.addAnchor(connector);
                }
            }

            // add it to diagram
            diagram.addContained(node);
        }
    }
}
