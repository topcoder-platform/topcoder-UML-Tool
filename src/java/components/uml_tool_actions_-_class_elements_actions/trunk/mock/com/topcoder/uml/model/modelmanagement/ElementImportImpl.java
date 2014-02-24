/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement;

import com.topcoder.uml.model.core.*;
import com.topcoder.uml.model.datatypes.*;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class ElementImportImpl implements ElementImport {

    /**
     * <p>
     * Represents the package that inlcudes this import.
     * </p>
     */
    private com.topcoder.uml.model.modelmanagement.Package aPackage;

    /**
     * <p>
     * An imported ModelElement is either public, protected, or private relative
     * to the importing Package.
     * </p>
     */
    private com.topcoder.uml.model.datatypes.VisibilityKind visibility;

    /**
     * <p>
     * Represents The alias defines a local name of the imported ModelElement,
     * to be used within the Package..
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
     */
    private boolean specification;

    /**
     * <p>
     * Represents The namespace defined by a package is extended by model
     * elements in other, imported packages.
     * </p>
     */
    private com.topcoder.uml.model.core.ModelElement importedElement;

    /**
     * Gets the Package package field value. Could be null.
     *
     * @return package field value
     */
    public Package getPackage() {
        return this.aPackage;
    }

    /**
     * Sets the Package package field value. Null is allowed.
     *
     * @param aPackage
     *            package field value
     */
    public void setPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    /**
     * Gets the VisibilityKind visibility field value. Could be null.
     *
     * @return visibility field value
     */
    public VisibilityKind getVisibility() {
        return this.visibility;
    }

    /**
     * Sets the VisibilityKind visibility field value. Null is allowed.
     *
     * @param visibility
     *            visibility field value
     */
    public void setVisibility(VisibilityKind visibility) {
        this.visibility = visibility;
    }

    /**
     * Gets the String alias field value. Could be null/empty.
     *
     * @return alias field value
     */
    public String getAlias() {
        return this.alias;
    }

    /**
     * Sets the String alias field value. Null/empty is allowed.
     *
     * @param alias
     *            alias field value
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Gets the boolean specification field value.
     *
     * @return specification field value
     */
    public boolean isSpecification() {
        return this.specification;
    }

    /**
     * Sets the boolean specification field value.
     *
     * @param specification
     *            specification field value
     */
    public void setSpecification(boolean specification) {
        this.specification = specification;
    }

    /**
     * Gets the ModelElement importedElement field value. Could be null.
     *
     * @return importedElement field value
     */
    public ModelElement getImportedElement() {
        return this.importedElement;
    }

    /**
     * Sets the ModelElement importedElement field value. Null is allowed.
     *
     * @param importedElement
     *            importedElement field value
     */
    public void setImportedElement(ModelElement importedElement) {
        this.importedElement = importedElement;
    }
}