package com.pablo.emailclient.Rules;
import com.pablo.emailclient.Components.Element;
import java.util.List;

public class MoveMessage {
    private List<Element> messages;
    private Element folderDestination;

    public MoveMessage(List<Element> messages, Element folderDestination){
        this.messages = messages;
        this.folderDestination = folderDestination;
    }
    public void executeMove(){
        System.out.println("Moving messages...");

        for(Element element : messages) {
                folderDestination.AddChildElement(element);
        }
    }
}
