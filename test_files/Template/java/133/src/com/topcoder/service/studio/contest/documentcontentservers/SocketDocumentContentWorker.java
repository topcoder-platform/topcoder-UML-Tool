package com.topcoder.service.studio.contest.documentcontentservers;
/**
It's a private inner class (non-static) of SocketDocumentContentServer class. 
It implements the Runnable interface, and it is used to process clients' requests, and send back proper responses to client. 

Thread-safety: It's used thread-safely by SocketDocumentContentServer as all methods in SocketDocumentContentServer are synchronized.
*/
private class SocketDocumentContentWorker implements Runnable{
/**
Empty constructor.
*/
public SocketDocumentContentWorker() {
}
/**
Process the clients' requests, and write proper responses to client. 

#impl
while  (!stopped) {
     // waiting for events with timeout value
      if (selector.select(1000) <= 0) {
               continue;
      }
      // get selected keys 
      Iterator it = selector.selectedKeys().iterator();

      // process every selectionKey
      while (it.hasNext()) {
            SelectionKey key = (SelectionKey) it.next();

            // a client required a connection
            if (key.isAcceptable()) {
                   it.remove();                // get client socket channel
                   SocketChannel client = server.accept();
                    // Set Non-Blocking mode for select operation
                    client.configureBlocking(false);
                    // recording to the selector (reading)
                    client.register(selector, SelectionKey.OP_READ);
            } else if (key.isReadable()) {       // if isReadable = true then the server is ready to read
                    it.remove();
                    SocketChannel client = (SocketChannel) key.channel();
                    read request data by calling client.read. 
                    if it's a saveDocumentContent request
                          extract the path and document content data, 
                          then write the document content to the File identified by the path.         (create a new file if it doesn't exist, overwrite the old file if it exists.)
                          write a response to client to indicate the file is saved correctly.                 
                    else if it's a getDocumentContent request.
                          extract the path from request data.
                          read the content of the file identified by the path. 
                          write the content to the client. 
                    else if it's a existDocumentContent request
                          extract the path from request data.
                          verify the file identified by the path exists or not.
                          write the verification result to client. 
                    else       
                          throw InvalidRequestException indicating the request is invalid. 
                    end if
                    close the client finally.
            }
      }
}

Failure Response: 
common for all 3 requests: 
1) the path is in invalid format on current file system. 
2) any i/o error occurs when operating on the corresponding file. 


NOTE: InvalidRequestException can also be thrown above if the request cannot be parsed. 

The code above should be put into a try-catch-finally block,  all exceptions thrown should be caught, and set to lastException field.  And in the finally-block, it should close the selector & server, and set them to null (Such operations should be synchronized on *SocketDocumentContentServer.this* to ensure thread-safe.).

LOGGING: 
The exception thrown should be logged before it's set to the lastException.
@param Return 
*/
public void run() {
}
}

