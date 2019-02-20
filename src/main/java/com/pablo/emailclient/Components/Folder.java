package com.pablo.emailclient.Components;

import com.pablo.emailclient.Rules.IAction;
import com.pablo.emailclient.Rules.Move;
import sun.plugin2.message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Folder extends Element {

    public enum ElementPermission{CanDelete, CanCreateSubFolder, CanRename, CanMoveTo}

    private String folderName;
    private ElementType elementType;
    private List<Element> folderContent;
    private List<ElementPermission> permissions;


    //private String path;
    public Folder(String folderName, List<ElementPermission> permission){
        this.folderName = folderName;
        this.folderContent = new ArrayList<>();
        this.permissions = permission;
        this.elementType = ElementType.Folder;
    }

    @Override
    public void AddChildElement(Element element)
    {
        this.folderContent.add(element);
    }

    @Override
    public void DisplayContent() {
        System.out.println("-" + this.folderName);

        for (Element element : folderContent) {
            if (element.getType() == ElementType.Message)
                System.out.println("\t");

            element.DisplayContent();
        }
    }

    public boolean MoveMessage(String msgId, String destination)
    {
        Element message = GetMessage(msgId);

        if(message != null)
        {
            Element folder = GetMessage(destination);


            if(folder == null)
                folder = new Folder(destination, new ArrayList<>());

            //TODO implements return new folder to be added to the Root

            if(folderContent.remove(message))
            {
                folder.AddChildElement(message);
                return true;
            }

        }
        return false;
    }

    private Element GetMessage(String msgId)
    {
        Element message = null;

        for(Element element : folderContent)
        {
            if(element.getType() == ElementType.Message)
            {
                UUID id = UUID.fromString(msgId);

                if(id.equals( ((EmailMessage) element).getMsgId()))
                {
                    return message;
                }
            }

            if(element.getType() == ElementType.Folder)
            {
                if(msgId.equals( ((Folder) element).folderName ))
                {
                    return  element;
                }
            }
        }

        return message;
    }

    private boolean MoveMessage(String destination, Element message)
    {
        IAction move = new Move( ((EmailMessage) message).getMsgId(), destination);
        return move.ExecuteAction();
    }

    @Override
    public ElementType getType() {
        return this.elementType;
    }


}
