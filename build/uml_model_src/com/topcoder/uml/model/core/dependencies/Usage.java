/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Core Dependencies Version 1.0
 *
 * @ Usage.java
 */
package com.topcoder.uml.model.core.dependencies;
/**
 * <p>This interface extends Dependency interface. A usage is a relationship in which one element
 * requires another element (or set of elements) for its full implementation or operation. The
 * relationship is not a mere historical artifact, but an ongoing need; therefore, two elements
 * related by usage must be in the same model. In the metamodel, a Usage is a Dependency in which
 * the client requires the presence of the supplier. How the client uses the supplier, such as a
 * class calling an operation of another class, a method having an argument of another class, and
 * a method from a class instantiating another class, is defined in the description of the particular
 * Usage stereotype.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 *
 * @author argolite, yinzi
 * @version 1.0
 */
public interface Usage extends Dependency {
}


