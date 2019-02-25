package com.pablo.emailclient.Rules;

import com.pablo.emailclient.Components.Element;
import com.pablo.emailclient.Components.EmailMessage;

import java.util.List;
import java.util.UUID;

public class MoveMessageAction implements IAction {
    private List<Element> messagesToMove;
    private Element newDestination;

    public void setNewDestination(Element newDestination) {
        this.newDestination = newDestination;
    }

    public void setMessagesToMove(List<Element> messages){
        this.messagesToMove = messages;
    }

    @Override
    public void ExecuteAction() {

        for(Element element : messagesToMove)
        {
            newDestination.AddChildElement(element);
            /*
            if(element.getType() == Element.ElementType.Message)
            {
                newDestination.AddChildElement(element);
            }
            */
        }


    }
}
