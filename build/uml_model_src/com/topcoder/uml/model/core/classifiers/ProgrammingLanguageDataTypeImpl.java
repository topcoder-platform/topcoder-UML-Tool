/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.datatypes.expressions.TypeExpression;


/**
 * <p>This is a simple concrete implementation of ProgrammingLanguageDataType interface and extends
 * DataTypeImpl. A programming language data type is a data type
 * specified according to the semantics of a particular programming language, using constructs
 * available in that language. There are a wide variety of programming languages and many
 * of them include type constructs not included as UML classifiers. In some cases, it is
 * important to represent those constructs such that their exact form in the programming
 * language is available. The ProgrammingLanguagedData type captures such programming language
 * types in a language-dependent fashion. They are represented by the name of the language and
 * a string characterizing them, subject to interpretation by the particular language. Because
 * they are dependent on particular languages, they are not portable among languages (except by
 * agreement among the languages) and they do not map into other UML classifiers. Their
 * semantics is therefore opaque within UML except by special interpretation by a profile
 * intended for the particular language.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 *
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public class ProgrammingLanguageDataTypeImpl extends DataTypeImpl implements ProgrammingLanguageDataType {
    /**
     * <p>Represents An expression for the ProgrammingLanguageDataType expressed in its particular programming
     * language.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private TypeExpression expression;

    /**
     * <p>Empty constructor.</p>
     * <p>Initializes member variable as default value.</p>
     *
     */
    public ProgrammingLanguageDataTypeImpl() {
    }

    /**
     * Gets the expression field value. Could be null.
     *
     *
     * @return expression field value
     */
    public TypeExpression getExpression() {
        return expression;
    }

    /**
     * Sets the expression field value. Null is allowed.
     *
     *
     * @param expression expression field value
     */
    public void setExpression(TypeExpression expression) {
        this.expression = expression;
    }
}
