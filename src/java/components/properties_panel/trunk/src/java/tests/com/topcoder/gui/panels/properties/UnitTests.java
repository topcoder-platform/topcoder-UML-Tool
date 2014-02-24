/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.properties;

import com.topcoder.gui.panels.properties.propertypanel.AbstractPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.AggregationPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.AssociationEndsPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.ChangeabilityPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.ConcurrencyPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.CustomTableModelTests;
import com.topcoder.gui.panels.properties.propertypanel.GuardPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.IncomingTransitionPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.InitialValuePropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.KindPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.ModifiersPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.MultiplicityPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.NamePropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.NamespaceItemTests;
import com.topcoder.gui.panels.properties.propertypanel.NamespacePropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.OrderingPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.OutgoingTransitionPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.OwnerPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.ParameterListPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.StereotypeItemTests;
import com.topcoder.gui.panels.properties.propertypanel.StereotypeListPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.TransitionListItemTests;
import com.topcoder.gui.panels.properties.propertypanel.TypePropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.UITests;
import com.topcoder.gui.panels.properties.propertypanel.VisibilityPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.AbstractLinkPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.ActionLinkPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.AdditionLinkPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.AssociationLinkPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.BaseLinkPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.ChildLinkPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.ClientLinkPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.ExtensionLinkPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.NamespaceLinkPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.OwnerLinkPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.ParentLinkPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.SourceLinkPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.StimulusLinkPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.SupplierLinkPropertyPanelTests;
import com.topcoder.gui.panels.properties.propertypanel.links.TargetLinkPropertyPanelTests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {
    /**
     * <p>
     * This test case aggregates all Unit test cases.
     * </p>
     *
     * @return all Unit test cases.
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        // tests for package com.topcoder.gui.panels.properties
        suite.addTest(PropertiesPanelConfigurationExceptionTests.suite());
        suite.addTest(PropertyOperationTests.suite());
        suite.addTest(PropertyKindTests.suite());
        suite.addTest(UtilTests.suite());
        suite.addTest(PropertiesPanelTests.suite());

        // tests for package com.topcoder.gui.panels.properties.propertypanel
        suite.addTest(StereotypeListPropertyPanelTests.suite());
        suite.addTest(OwnerPropertyPanelTests.suite());
        suite.addTest(CustomTableModelTests.suite());
        suite.addTest(VisibilityPropertyPanelTests.suite());
        suite.addTest(ModifiersPropertyPanelTests.suite());
        suite.addTest(GuardPropertyPanelTests.suite());
        suite.addTest(OrderingPropertyPanelTests.suite());
        suite.addTest(InitialValuePropertyPanelTests.suite());
        suite.addTest(ParameterListPropertyPanelTests.suite());
        suite.addTest(ChangeabilityPropertyPanelTests.suite());
        suite.addTest(TypePropertyPanelTests.suite());
        suite.addTest(AggregationPropertyPanelTests.suite());
        suite.addTest(KindPropertyPanelTests.suite());
        suite.addTest(IncomingTransitionPropertyPanelTests.suite());
        suite.addTest(MultiplicityPropertyPanelTests.suite());
        suite.addTest(StereotypeItemTests.suite());
        suite.addTest(NamePropertyPanelTests.suite());
        suite.addTest(OutgoingTransitionPropertyPanelTests.suite());
        suite.addTest(NamespaceItemTests.suite());
        suite.addTest(AssociationEndsPropertyPanelTests.suite());
        suite.addTest(TransitionListItemTests.suite());
        suite.addTest(NamespacePropertyPanelTests.suite());
        suite.addTest(AbstractPropertyPanelTests.suite());
        suite.addTest(ConcurrencyPropertyPanelTests.suite());
        suite.addTest(UITests.suite());

        // tests for package com.topcoder.gui.panels.properties.propertypanel.links
        suite.addTest(ActionLinkPropertyPanelTests.suite());
        suite.addTest(ExtensionLinkPropertyPanelTests.suite());
        suite.addTest(AbstractLinkPropertyPanelTests.suite());
        suite.addTest(ParentLinkPropertyPanelTests.suite());
        suite.addTest(AdditionLinkPropertyPanelTests.suite());
        suite.addTest(ClientLinkPropertyPanelTests.suite());
        suite.addTest(SourceLinkPropertyPanelTests.suite());
        suite.addTest(BaseLinkPropertyPanelTests.suite());
        suite.addTest(OwnerLinkPropertyPanelTests.suite());
        suite.addTest(NamespaceLinkPropertyPanelTests.suite());
        suite.addTest(StimulusLinkPropertyPanelTests.suite());
        suite.addTest(TargetLinkPropertyPanelTests.suite());
        suite.addTest(SupplierLinkPropertyPanelTests.suite());
        suite.addTest(ChildLinkPropertyPanelTests.suite());
        suite.addTest(AssociationLinkPropertyPanelTests.suite());

        // tests for demos
        suite.addTest(DemoTests.suite());

        return suite;
    }

}
