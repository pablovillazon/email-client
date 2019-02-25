package com.pablo.emailclient.Rules;
import com.pablo.emailclient.Components.Element;
import java.util.List;

public class CopyMessage {

    //private Element source;
    private Element destination;
    private Element message;

    public CopyMessage(Element destination, Element message){
        //this.source = source;
        this.destination = destination;
        this.message = message;
    }

    public void executeCopy(){
        System.out.println("Copying messages...");

        destination.AddChildElement(message);

    }
}
