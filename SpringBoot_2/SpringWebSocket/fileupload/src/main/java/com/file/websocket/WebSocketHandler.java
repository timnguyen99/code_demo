package com.file.websocket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

public class WebSocketHandler extends BinaryWebSocketHandler {

    @Autowired
    private ApplicationContext applicationContext;

   // @Autowired
    //private CallScopeStore callScopeStore;

    private static Logger logger = LogManager.getLogger("WebSocketHandler");
    
    private static final String STOP_MESSAGE = "stop";

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
        try {
         //do something....
        	
        	System.out.println("handleBinaryMessage");
        	
        } catch (Exception e) {
            logger.error(e, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void handleTextMessage(final WebSocketSession session, TextMessage message) {
        try {
            //do something....
        	
        	System.out.println("handleTextMessage");
            
        } catch (Exception e) {
            logger.error(e, e);
            throw new RuntimeException(e);

        }
    }
}


