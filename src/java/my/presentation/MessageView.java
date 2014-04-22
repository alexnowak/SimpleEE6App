/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package my.presentation;

import boudary.MessageFacade;
import entities.Message;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Alex
 */
@ManagedBean(name = "MessageView")
@RequestScoped
public class MessageView {
    @EJB
    private MessageFacade messageFacade;
    private Message message;

    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
	this.message = new Message();
    }
    
    /**
     * Calls getMessage() to retrieve the message.
     * @return 
     */
    public Message getMessage() {
	return message;
    }
    
    /**
     * Returns the total number of messages
     * @return 
     */
    public int getNumberOfMessages() {
	System.out.println("MessageFacade.cout()="+messageFacade.count() + " .findAll().size()=" + messageFacade.findAll().size());
	return messageFacade.findAll().size();
    }
    
    public String postMessage(){
	this.messageFacade.create(message);
	return "theend";
    }
    
}
