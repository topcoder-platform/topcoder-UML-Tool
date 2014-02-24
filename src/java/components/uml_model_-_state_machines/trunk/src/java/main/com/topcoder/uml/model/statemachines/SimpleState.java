/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

/**
 * <p>
 * A simple state is a state that does not have substates, i.e. it has no regions and it has no submachine state
 * machine.(OMG Unified Modeling Lanauge Specification - UML 2.0 Superstructure Specification, p. 600) We could state
 * that a simple state is the opposite of a Composite state.
 * </p>
 * <p>
 * <b>Thread Safety</b>: There is no requirement to make implementations of this interface thread-safe
 * </p>
 *
 * @author AleaActaEst, catcher
 * @version 1.0
 */
public interface SimpleState extends State {
}
