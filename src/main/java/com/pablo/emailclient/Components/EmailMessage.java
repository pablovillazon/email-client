package com.pablo.emailclient.Components;

import com.pablo.emailclient.Adapter.IEmailMessage;

import java.util.UUID;

public class EmailMessage extends Element implements IEmailMessage {
    private UUID MsgId;

    public UUID getMsgId() {
        return MsgId;
    }

    private String To;
    private String From;
    private String Sent;
    private String Subject;
    private String Body;
    private ElementType elementType;

    public String getTo() {
        return To;
    }

    public String getFrom() {
        return From;
    }

    public String getSent() {
        return Sent;
    }

    @Override
    public String getCC() {
        return null;
    }

    public String getSubject() {
        return Subject;
    }

    public String getBody() {
        return Body;
    }

    @Override
    public void setTo(String to) {
        this.To = to;

    }

    @Override
    public void setFrom(String from) {
        this.From = from;
    }

    @Override
    public void setSent(String sent) {
        this.Sent = sent;
    }

    @Override
    public void setCC(String cc) {

    }

    @Override
    public void setSubject(String subject) {
        this.Subject = subject;
    }

    @Override
    public void setBody( String body) {
        this.Body = body;
    }


    public EmailMessage(String to, String from, String sent, String subject, String body) {
        this.To = to;
        this.From = from;
        this.Sent = sent;
        this.Subject = subject;
        this.Body = body;
        this.elementType = ElementType.Message;
        this.MsgId = UUID.randomUUID();
    }

    public EmailMessage(){};

    public boolean isValidMessage()
    {
        return !this.Subject.isEmpty();
    }

    @Override
    public void DisplayContent() {
        System.out.println("MsgID:" + this.MsgId);
        System.out.println("To:" + this.To);
        System.out.println("From:" + this.From);
        System.out.println("Sent:" + this.Sent);
        System.out.println("Subject:" + this.Subject);
        System.out.println("Message Body: \n" + this.Body);
    }

    @Override
    public ElementType getType() {
        return elementType;
    }

    //public boolean ParseToXML()

}
