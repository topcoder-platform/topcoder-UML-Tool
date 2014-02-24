package com.topcoder.xmi.reader.failuretests;

import com.topcoder.xmi.reader.XMIReader;

/**
 * Mock object only destined to
 * produce XMIReader.DelegatingHandler objects
 */
public class MockXMIReader extends XMIReader
{
    /**
     * Simple constructor
     * calls back implicitly to XMIReader()
      * @throws Exception
     */
    public MockXMIReader() throws Exception
    {
    }

    /**
     * Factory method for a XMIReader.DelegatingHandler
     * @return a default constructed XMIReader.DelegatingHandler
     */
    public XMIReader.DelegatingHandler factoryDelegatingHandler()
    {
        return new XMIReader.DelegatingHandler();
    }
}
