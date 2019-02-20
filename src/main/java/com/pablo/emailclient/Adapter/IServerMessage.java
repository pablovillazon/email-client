package com.pablo.emailclient.Adapter;

public interface IServerMessage {

    public String getTo();
    public String getFrom();
    public String getSent();
    //public String getCC();
    public String getSubject();
    public String getBody();

    public void setTo(String to);
    public void setFrom(String from);
    public void setSent(String sent);
    //public void setCC(String cc);
    public void setSubject(String subject);
    public void setBody(String body);

}
