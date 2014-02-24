package com.topcoder.uml.importer.jarimporter.impl;

import java.net.URL;
import java.util.List;
import java.util.Map;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.importer.jarimporter.JarImporterException;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.relationships.Relationship;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.modelmanager.UMLModelManager;

public class MockDefaultJarImporter extends DefaultJarImporter {

    /**
     * Create a new DefaultJarImporter instance with given UMLModelManager and classpath.
     * 
     * @param classpath the extra classpath to help importing the JARs, can be null.
     * @param modelManager the UMLModelManager instance.
     * @throws IllegalArgumentException - if modelManager is null or the classpath contains
     * null/empty string or the classpathLoader can't be initialized according the given classpath.
     */
    public MockDefaultJarImporter(UMLModelManager modelManager, String[] classpath) {
        super(modelManager, classpath);
    }
    
    /**
     * <p>
     * Create a new MockDefaultJarImporter instance with given UMLModelManager and classpath.
     * </p>
     * 
     * @param classpath the extra classpath to help importing the JARs, can be null.
     * @param modelManager the UMLModelManager instance.
     * @throws IllegalArgumentException - if modelManager is null or the classpathLoader can't be
     * initialized according the given classpath.
     */
    public MockDefaultJarImporter(UMLModelManager modelManager, URL[] classpath) {
        super(modelManager, classpath);
    }
    
    /**
     * Extracts the external classes for the classes retrieved from JARs.
     * 
     * @throws JarImporterException - if any error occurred when extracting the external classes.
     */
    public void extractExternalClasses() throws JarImporterException {
        super.extractExternalClasses();
        
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
    public void importPackagesAndClassesToModel() throws JarImporterException {
        super.importPackagesAndClassesToModel();
    }

    /**
     * Import all the entites populated in the previous step to a specific diagram. Param: diagram -
     * the Diagram instance which accept the entities Exceptions(Note the parameters are already
     * validated):
     * 
     * @throws JarImporterException - if any error occurred when importing entities to diagram.
     * @param diagram the Diagram instance which accept the entities.s
     */
    public void importToDiagram(Diagram diagram) throws JarImporterException {
        super.importToDiagram(diagram);
    }

    /**
     * Pull the packages and classes defined in the given JARs, and store the result in packages and
     * classes variable.s
     * 
     * @param jarURLs the URLs of the JARS to be imported.
     * @throws JarImporterException - if any error occurred when processing the JARs.
     */
    public void retrievePackagesAndClassesFromJars(URL[] jarURLs) throws JarImporterException {
        super.retrievePackagesAndClassesFromJars(jarURLs);
    }
    
    
    
    /**
     * Protected getter for the 'modelManager' field.
     * 
     * @return the value of the 'modelManager' field
     */
    public UMLModelManager getModelManager() {
        return super.getModelManager();
    }

    /**
     * Protected getter for the 'packages' field.
     * 
     * @return the value of the 'packages' field
     */
    public Map<String, java.lang.Package> getPackages() {
        return super.getPackages();
    }

    /**
     * Protected getter for the 'classes' field.
     * 
     * @return the value of the 'classes' field
     */
    public Map<String, Class<?>> getClasses() {
        return super.getClasses();
    }

    /**
     * Protected getter for the 'externalClasses' field.
     * 
     * @return the value of the 'externalClasses' field
     */
    public Map<String, Class<?>> getExternalClasses() {
        return super.getExternalClasses();
    }

    /**
     * Protected getter for the 'modelPackages' field.
     * 
     * @return the value of the 'modelPackages' field
     */
    public Map<String, Package> getModelPackages() {
        return super.getModelPackages();
    }

    /**
     * Protected getter for the 'modelClasses' field.
     * 
     * @return the value of the 'modelClasses' field
     */
    public Map<String, Classifier> getModelClasses() {
        return super.getModelClasses();
    }

    /**
     * Protected getter for the 'relationships' field.
     * 
     * @return the value of the 'relationships' field
     */
    public List<Relationship> getRelationships() {
        return super.getRelationships();
    }

    /**
     * Protected getter for the 'classesToRelationships' field.
     * 
     * @return the value of the 'classesToRelationships' field
     */
    public Map<Classifier, List<Relationship>> getClassesToRelationships() {
        return super.getClassesToRelationships();
    }

}
