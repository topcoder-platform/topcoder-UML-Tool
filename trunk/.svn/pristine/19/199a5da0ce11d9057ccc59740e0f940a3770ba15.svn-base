package com.topcoder.service.studio.contest;
/**
This interface will be used in ContestManager implementation to provide operations to save document content, get document content content and check document content existence. 
The document content will be identified by a path.  

Implementations need to be thread-safe.

NOTE: Implementations must have a ctor like:  ctor-name(Map<String, Object> attributes) in order to be used by ContestManagerBean class.
*/
public interface DocumentContentManager{
/**
Save document content into persistence.

#Param
path - the path of the document content. 
documentContent - the document content. 

#exception
throw IllegalArgumentException if any arg is null, or path argument is empty string, or documentContent arg is empty array. 
throw IOException if any i/o error occurs when saving the document content.
throw DocumentContentManagementException if any other error occurs when managing the document content.
@param documentContent 
@param path 
@param Return 
*/
public void saveDocumentContent(String path, byte[] documentContent) {
}
/**
Get content of document given by path.  Return null if the document content doesn't exist.
It can also return empty array if the document content is empty.

#Param 
path - the document content path. 

#Return - the document content. 

#exception
throw IllegalArgumentException if the arg is null or empty string. 
throw IOException if any i/o error occurs when getting document content.
throw DocumentContentManagementException if any other error occurs when managing the document content.
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
throw DocumentContentManagementException if any other error occurs when managing the document content.
@param path 
@param Return 
@return 
*/
public boolean existDocumentContent(String path) {
    return false;
}
}

