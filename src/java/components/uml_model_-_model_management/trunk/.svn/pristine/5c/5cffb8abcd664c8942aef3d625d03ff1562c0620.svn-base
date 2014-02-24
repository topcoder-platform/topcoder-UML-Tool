/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.datatypes.VisibilityKind;

/**
 * <p>
 * This is a simple, concrete implementation of ElementImport interface.
 * </p>
 * <p>
 * <strong>Thread Safety</strong>
 * </p>
 * <p>
 * This class is mutable and not thread-safe.
 * </p>
 * @author argolite, vilain
 * @version 1.0
 */
public class ElementImportImpl implements ElementImport {

    /**
     * <p>
     * Represents the package that includes this import.
     * </p>
     * <p>
     * This value is set in the setter, and accessed with the getter. Null
     * values are acceptable. There is no validation performed on the setter.
     * </p>
     */
    private Package aPackage;

    /**
     * <p>
     * An imported ModelElement is either public, protected, or private relative
     * to the importing Package.
     * </p>
     * <p>
     * This value is set in the setter, and accessed with the getter. Null
     * values are acceptable. There is no validation performed on the setter.
     * </p>
     */
    private VisibilityKind visibility;

    /**
     * <p>
     * Represents the alias defining a local name of the imported ModelElement,
     * to be used within the Package.
     * </p>
     * <p>
     * This value is set in the setter, and accessed with the getter. Null and
     * empty values are acceptable. There is no validation performed on the
     * setter.
     * </p>
     */
    private String alias;

    /**
     * <p>
     * Specifies whether the ownedElement is part of the specification for the
     * containing namespace (in cases where specification is distinguished from
     * the realization). Otherwise the ownedElement is part of the realization.
     * In cases in which the distinction is not made, the value is false by
     * default.
     * </p>
     * <p>
     * This value is set in the setter, and accessed with the getter.
     * </p>
     */
    private boolean specification;

    /**
     * <p>
     * Represents The namespace defined by a package is extended by model
     * elements in other, imported packages.
     * </p>
     * <p>
     * This value is set in the setter, and accessed with the getter. Null
     * values are acceptable. There is no validation performed on the setter.
     * </p>
     */
    private ModelElement importedElement;

    /**
     * Empty constructor.
     */
    public ElementImportImpl() {
    }

    /**
     * Gets the Package package field value. Could be null.
     * @return package field value
     */
    public Package getPackage() {
        return aPackage;
    }

    /**
     * Sets the Package package field value. Null is allowed.
     * @param aPackage package field value
     */
    public void setPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    /**
     * Gets the VisibilityKind visibility field value. Could be null.
     * @return visibility field value
     */
    public VisibilityKind getVisibility() {
        return visibility;
    }

    /**
     * Sets the VisibilityKind visibility field value. Null is allowed.
     * @param visibility visibility field value
     */
    public void setVisibility(VisibilityKind visibility) {
        this.visibility = visibility;
    }

    /**
     * Gets the String alias field value. Could be null/empty.
     * @return alias field value
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the String alias field value. Null/empty is allowed.
     * @param alias alias field value
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Gets the boolean specification field value.
     * @return specification field value
     */
    public boolean isSpecification() {
        return specification;
    }

    /**
     * Sets the boolean specification field value.
     * @param specification specification field value
     */
    public void setSpecification(boolean specification) {
        this.specification = specification;
    }

    /**
     * Gets the ModelElement importedElement field value. Could be null.
     * @return importedElement field value
     */
    public ModelElement getImportedElement() {
        return importedElement;
    }

    /**
     * Sets the ModelElement importedElement field value. Null is allowed.
     * @param importedElement importedElement field value
     */
    public void setImportedElement(ModelElement importedElement) {
        this.importedElement = importedElement;
    }
}