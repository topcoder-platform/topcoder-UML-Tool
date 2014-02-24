/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.datatypes.expressions.TypeExpression;


/**
 * <p>This interface extends DataType interface. A data type is a type whose values have no
 * identity (i.e., they are pure values). A programming language data type is a data type
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
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public interface ProgrammingLanguageDataType extends DataType {
    /**
     * Gets the expression field value. Could be null.
     *
     *
     * @return expression field value
     */
    TypeExpression getExpression();

    /**
     * Sets the expression field value. Null is allowed.
     *
     *
     * @param expression expression field value
     */
    void setExpression(TypeExpression expression);
}
