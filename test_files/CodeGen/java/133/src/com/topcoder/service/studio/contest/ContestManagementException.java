package com.topcoder.service.studio.contest;
import com.topcoder.util.errorhandling.*;
/**
 * This exception extends the BaseCriticalException, and it is used to cover all general errors (except generic ones and that for the file system server) thrown from this component.  It is also used as the super class for all custom exceptions in this component.
*/
public class ContestManagementException extends BaseCriticalException{
/**
 * <p>Constructor with the error message. simply call super(message). </p>
 * 
 * #Param
 * message - the error message.
 * @param message 
*/
public ContestManagementException(String message) {
}
/**
 * <p>Constructor with the error message and the inner cause. simply call super(message, cause). </p>
 * 
 * #Param
 * message - the error message.
 * cause - the inner exception.
 * @param message 
 * @param cause 
*/
public ContestManagementException(String message, Throwable cause) {
}
/**
 * <p>
 * Constructs the exception taking both a <code>message</code>
 * and the additional <code>data</code> to attach to the critical exception. Simply call super(message, data)</p>
 * 
 * #Param
 * message - the error message.
 * data - The additional data to attach to the exception
 * @param data 
 * @param message 
*/
public ContestManagementException(String message, ExceptionData data) {
}
/**
 * <p>Constructs the exception taking both a <code>message</code>
 * and a <code>cause</code>, as well as the additional <code>data</code>
 * to attach to the critical exception. Simply call super(message, cause, data). </p>
 * 
 * #Param
 * message - the error message.
 * cause - the inner exception.
 * data - The additional data to attach to the exception
 * @param data 
 * @param message 
 * @param cause 
*/
public ContestManagementException(String message, Throwable cause, ExceptionData data) {
}
}

