/*
 * Copyright (C) 2010 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator.java;

import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.digester.Digester;
import org.xml.sax.SAXException;

/**
 * This config reader read Eclipse's config file for eclipse formatter.
 *
 * @author enefem21
 */
@SuppressWarnings({"unchecked","rawtypes"})
public class ConfigReader {

    /**
     * Read from the <code>reader</code> and return it's configuration settings as a {@link Map}.
     *
     * @param reader
     * @return return unmodifiable {@link Map} with all the configurations read from the config file, or empty
     *         {@link Map} if there's an exception occured while reading the reader, e.g.: invalid XML.
     */
    public Map read(Reader reader) {
        Digester digester = new Digester();
        digester.addRuleSet(new RuleSet());

        Map config = Collections.emptyMap();
        try {
            Object result = digester.parse(reader);

            if (result == null && !(result instanceof List)) {
                return config;
            }

            List list = (List) result;
            if (list.size() == 0) {
                return config;
            }

            config = Collections.unmodifiableMap((Map) list.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return config;
    }
}
