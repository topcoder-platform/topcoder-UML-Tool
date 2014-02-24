package com.topcoder.service.studio.contest;
import com.topcoder.util.errorhandling.*;
/**
This exception extends the ContestManagementException, and it is thrown when it's not allowed to update contest from one status to another.
*/
public class ContestStatusTransitionException extends ContestManagementException{
/**
<p>Constructor with the error message. simply call super(message). </p>

#Param
message - the error message.
@param message 
*/
public ContestStatusTransitionException(String message) {
}
/**
<p>Constructor with the error message and the inner cause. simply call super(message, cause). </p>

#Param
message - the error message.
cause - the inner exception.
@param message 
@param cause 
*/
public ContestStatusTransitionException(String message, Throwable cause) {
}
/**
<p>
Constructs the exception taking both a <code>message</code>
and the additional <code>data</code> to attach to the critical exception. Simply call super(message, data)</p>

#Param
message - the error message.
data - The additional data to attach to the exception
@param data 
@param message 
*/
public ContestStatusTransitionException(String message, ExceptionData data) {
}
/**
<p>Constructs the exception taking both a <code>message</code>
and a <code>cause</code>, as well as the additional <code>data</code>
to attach to the critical exception. Simply call super(message, cause, data). </p>

#Param
message - the error message.
cause - the inner exception.
data - The additional data to attach to the exception
@param data 
@param message 
@param cause 
*/
public ContestStatusTransitionException(String message, Throwable cause, ExceptionData data) {
}
}

