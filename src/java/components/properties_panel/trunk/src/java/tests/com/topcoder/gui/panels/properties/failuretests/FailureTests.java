/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.panels.properties.failuretests;

import com.topcoder.gui.panels.properties.failuretests.propertypanel.AbstractPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.AggregationPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.AssociationEndsPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.ChangeabilityPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.ConcurrencyPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.GuardPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.IncomingTransitionPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.InitialValuePropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.KindPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.ModifiersPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.MultiplicityPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.NamePropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.NamespacePropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.OrderingPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.OutgoingTransitionPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.OwnerPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.ParameterListPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.StereotypeListPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.TypePropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.VisibilityPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.AbstractLinkPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.ActionLinkPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.AdditionLinkPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.AssociationLinkPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.BaseLinkPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.ChildLinkPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.ClientLinkPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.ExtensionLinkPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.NamespaceLinkPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.OwnerLinkPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.ParentLinkPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.SourceLinkPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.StimulusLinkPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.SupplierLinkPropertyPanelFailureTests;
import com.topcoder.gui.panels.properties.failuretests.propertypanel.links.TargetLinkPropertyPanelFailureTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 * 
 * @author TopCoder
 * @version 1.0
 */
public class FailureTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(PropertiesPanelFailureTests.class);

        suite.addTestSuite(AbstractPropertyPanelFailureTests.class);
        suite.addTestSuite(AggregationPropertyPanelFailureTests.class);
        suite.addTestSuite(AssociationEndsPropertyPanelFailureTests.class);
        suite.addTestSuite(ChangeabilityPropertyPanelFailureTests.class);
        suite.addTestSuite(ConcurrencyPropertyPanelFailureTests.class);
        suite.addTestSuite(GuardPropertyPanelFailureTests.class);
        suite.addTestSuite(IncomingTransitionPropertyPanelFailureTests.class);
        suite.addTestSuite(InitialValuePropertyPanelFailureTests.class);
        suite.addTestSuite(KindPropertyPanelFailureTests.class);
        suite.addTestSuite(ModifiersPropertyPanelFailureTests.class);
        suite.addTestSuite(MultiplicityPropertyPanelFailureTests.class);
        suite.addTestSuite(NamePropertyPanelFailureTests.class);
        suite.addTestSuite(NamespacePropertyPanelFailureTests.class);
        suite.addTestSuite(OrderingPropertyPanelFailureTests.class);
        suite.addTestSuite(OutgoingTransitionPropertyPanelFailureTests.class);
        suite.addTestSuite(OwnerPropertyPanelFailureTests.class);
        suite.addTestSuite(ParameterListPropertyPanelFailureTests.class);
        suite.addTestSuite(TypePropertyPanelFailureTests.class);
        suite.addTestSuite(VisibilityPropertyPanelFailureTests.class);
        suite.addTestSuite(StereotypeListPropertyPanelFailureTests.class);

        suite.addTestSuite(AbstractLinkPropertyPanelFailureTests.class);
        suite.addTestSuite(ActionLinkPropertyPanelFailureTests.class);
        suite.addTestSuite(AdditionLinkPropertyPanelFailureTests.class);
        suite.addTestSuite(AssociationLinkPropertyPanelFailureTests.class);
        suite.addTestSuite(BaseLinkPropertyPanelFailureTests.class);
        suite.addTestSuite(ChildLinkPropertyPanelFailureTests.class);
        suite.addTestSuite(ClientLinkPropertyPanelFailureTests.class);
        suite.addTestSuite(ExtensionLinkPropertyPanelFailureTests.class);
        suite.addTestSuite(NamespaceLinkPropertyPanelFailureTests.class);
        suite.addTestSuite(OwnerLinkPropertyPanelFailureTests.class);
        suite.addTestSuite(ParentLinkPropertyPanelFailureTests.class);
        suite.addTestSuite(SourceLinkPropertyPanelFailureTests.class);
        suite.addTestSuite(StimulusLinkPropertyPanelFailureTests.class);
        suite.addTestSuite(SupplierLinkPropertyPanelFailureTests.class);
        suite.addTestSuite(TargetLinkPropertyPanelFailureTests.class);

        return suite;
    }

}
