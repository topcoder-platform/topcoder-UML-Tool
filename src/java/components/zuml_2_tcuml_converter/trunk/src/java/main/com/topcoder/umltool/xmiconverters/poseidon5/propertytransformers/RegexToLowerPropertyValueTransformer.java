/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.propertytransformers;

import com.topcoder.umltool.xmiconverters.poseidon5.Helper;
import com.topcoder.umltool.xmiconverters.poseidon5.PropertyValueTransformer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * <p>
 * The default property value transformer implementation in this component. This class uses
 * regular expression to match the key of property, and transform the value of matched property
 * to Lower case(use toLowerCase in String).
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * It is stateless and immutable, it is thread-safe.
 * </p>
 *
 * @author TCSDESIGNER, TCSDEVELOPER
 * @version 1.0
 */
public class RegexToLowerPropertyValueTransformer
    implements PropertyValueTransformer {
    /**
     * <p>
     * The regular pattern to match the properties. It is initialized in the constructor and
     * never be changed. It can not be null. It can be retrieved by its getter.
     * </p>
     */
    private final Pattern keyPattern;

    /**
     * <p>
     * Construct this class with the given regular expression to match the property.
     * </p>
     *
     * @param regularExpression the regular expression of this transformer
     * @throws IllegalArgumentException if the regularExpression is null or empty
     * @throws PatternSyntaxException if the regularExpression is invalid
     */
    public RegexToLowerPropertyValueTransformer(String regularExpression) {
        Helper.checkString(regularExpression, "regularExpression");

        this.keyPattern = Pattern.compile(regularExpression);
    }

    /**
     * <p>
     * Transform the value to lower case if the value is not null. If the value is null,
     * do nothing.
     * </p>
     *
     * @param value the old value of property
     * @return the new value of property
     */
    public String transform(String value) {
        if (value == null) {
            return value;
        }

        return value.toLowerCase();
    }

    /**
     * <p>
     * Check whether the key of property is matched by the key pattern. Return true if
     * matched, otherwise, return false.
     * </p>
     *
     * @param key the key of property to match
     * @return  whether the key of property is matched
     */
    public boolean match(String key) {
        if (key == null) {
            //key is null and pattern is .* return true
            return keyPattern.toString().equals(".*");
        }

        Matcher m = keyPattern.matcher(key);

        return m.matches();
    }

    /**
     * <p>
     * Get the regular expression pattern of the transformer.
     * </p>
     *
     * @return the keyPattern variable
     */
    public Pattern getKeyPattern() {
        return keyPattern;
    }
}
