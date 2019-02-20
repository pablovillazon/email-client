package com.pablo.emailclient.Adapter;

import com.pablo.emailclient.Components.EmailMessage;

public class ServerMessageToEmailMessageAdapter {

    private String To;
    private String From;
    private String Sent;
    private String Subject;
    private String Body;

    private final ServerMessage  serverMessage;
    private EmailMessage emailMessage;

    public ServerMessageToEmailMessageAdapter(ServerMessage serverMessage, EmailMessage emailMessage)
    {
        this.serverMessage = serverMessage;
        this.emailMessage = emailMessage;
        setProp();
    }


    private void setProp(){
        emailMessage.setTo(serverMessage.getTo());
        emailMessage.setFrom(serverMessage.getFrom());
        emailMessage.setSent(serverMessage.getSent());
        emailMessage.setSubject(serverMessage.getSubject());
        emailMessage.setBody(serverMessage.getBody());
    }

    public EmailMessage getEmailMessage()
    {
        return emailMessage;
    }

}
