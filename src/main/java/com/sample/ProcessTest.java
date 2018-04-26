package com.sample;

import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.facts.Message;

/**
 * This is a sample file to launch a process.
 */
public class ProcessTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    		KieContainer kContainer = ks.getKieClasspathContainer();
    	    		KieSession kSession = kContainer.newKieSession("ksession-process");
    	    		
    	    		KieRuntimeLogger logger = ks.getLoggers().newFileLogger(kSession, "audit77");

            // start a new process instance
    	        Message message = new Message();
    	        message.setMessage("Hello World");
    	        message.setStatus(Message.HELLO);
    	        kSession.insert(message);
    	            
    	        kSession.startProcess("com.sample.bpmn.hello");
    	        //kSession.fireAllRules();
    	        
    	        logger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        } 
    }

}
