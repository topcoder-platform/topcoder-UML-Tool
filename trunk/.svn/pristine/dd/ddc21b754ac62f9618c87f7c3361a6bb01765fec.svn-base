package com.topcoder.service.studio.contest.documentcontentmanagers;
/**
This class implements the DocumentContentManager interface, and it acts as a socket client to save document content to a file server or get document content information from a file server.

Thread-safety:  Immutable and thread-safe.
*/
public class SocketDocumentContentManager implements DocumentContentManager{
/**
Represents the server ip address.  Initialized in ctor, and never changed afterwards 
Must be non-null, non-empty string.
*/
private final String serverAddress;
/**
Represents the server port.  Initialized in ctor, and never changed afterwards 
Must be int value in range [0, 65535].
*/
private final int serverPort;
/**
Constructor taking a map of attributes. 

#Param 
attributes - a map of attributes

#impl
the attributes map should contain the following key-value pairs:"serverAddress"  - the value must be a non-null, non-empty String. "serverPort" - the value must be non-null java.lang.Integer object, whose value should be in range [0, 65535]. 

Extract these values and assign the corresponding instance variables. 

#exception
throw IllegalArgumentException if the arg is null, or it doesn't contain any attribute mentioned above, or the attribute value is invalid, or it contains additional attributes.
@param attributes 
*/
public SocketDocumentContentManager(Map<String, Object> attributes) {
}
/**
Constructor.  Assign arguments to namesake instance variables. 

#Param
serverAddress - the server ip addresss. 
serverPort - the server port. 

#exception
throw IllegalArgumentException if serverAddress is null / empty string, or serverPort is not in range [0, 65535].
@param serverPort 
@param serverAddress 
*/
public SocketDocumentContentManager(String serverAddress, int serverPort) {
}
/**
Save document content into persistence.

#Param
path - the path of the document content. 
documentContent - the document content. 

#exception
throw IllegalArgumentException if any arg is null, or path argument is empty string, or documentContent arg is empty array. 
throw IOException if any i/o error occurs when saving the document content.
throw DocumentContentManagementException if any other error occurs when managing the document content.  (e.g. if the received response is invalid, or failure response is received. )

#impl
call channel = SocketChannel.open() to open a channel
call channel.configureBlocking(true) to use blocking mode. 
call channel.connect(new InetSocketAddress(serverAddress, serverPort))  to connect to server. 
call channel.write to write the path & documetnContent data to server. 
call channel.read to read response from server. 
verify the response to see if the document is saved correctly. 
throw DocumentContentManagementException if not.
finally close the channel. 

Refer to the cs to see the request / response formats.
@param documentContent 
@param path 
@param Return 
*/
public void saveDocumentContent(String path, byte[] documentContent) {
}
/**
Get content of document given by path.  Return null if the document content doesn't exist.
It can also return empty array if the document content is empty.#Param 
path - the document content path. 

#Return - the document content. 

#exception
throw IllegalArgumentException if the arg is null or empty string. 
throw IOException if any i/o error occurs when getting document content.
throw DocumentContentManagementException if any other error occurs when managing the document content.  (e.g. if the received response is invalid. or failure response is received. )

#impl
call channel = SocketChannel.open() to open a channel
call channel.configureBlocking(true) to use blocking mode. 
call channel.connect(new InetSocketAddress(serverAddress, serverPort))  to connect to server. 
call channel.write to write the path & documetnContent data to server. 
call channel.read to read response from server. 
if the document-content's length is 0, return an empty byte array, 
else if the response is successful and only have the first byte, return null indicating the document content doesn't exist. 
otherwise extract document content from the response to return. 
finally close the channel. 

Refer to the cs to see the request / response formats.
@param path 
@param Return 
@return 
*/
public byte[] getDocumentContent(String path) {
    return 0;
}
/**
Return true if the document content identified by the path exists, return false otherwise. 

#Param
path - the document content path. 

#Return - true if the document content identified by the path exists, return false otherwise.

#exception
throw IllegalArgumentException if the arg is null or empty string. 
throw IOException if any i/o error occurs when getting document content.
throw DocumentContentManagementException if any other error occurs when managing the document content.  (e.g. if the received response is invalid. or failure response is received.  )

#impl
call channel = SocketChannel.open() to open a channel
call channel.configureBlocking(true) to use blocking mode. 
call channel.connect(new InetSocketAddress(serverAddress, serverPort))  to connect to server. 
call channel.write to write the path & documetnContent data to server. 
call channel.read to read response from server. 
verify the response to see if the document exists, return true if it exists, otherwise return false. 
finally close the channel. 

Refer to the cs to see the request / response formats.
@param path 
@param Return 
@return 
*/
public boolean existDocumentContent(String path) {
    return false;
}
}

