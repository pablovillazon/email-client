package com.pablo.emailclient.Rules;

import com.pablo.emailclient.Components.Element;
import com.pablo.emailclient.Controllers.FileController;

public class DeleteMessage {
    private Element container;
    private Element remove;
    private FileController.DeletionType type;

    public DeleteMessage(Element containerElement, Element deletedElement, FileController.DeletionType deletionType){
        container = containerElement;
        remove = deletedElement;
        type = deletionType;
    }

    public void executeDelete(){
        System.out.println("Deleting messages..." + type.toString());

        container.RemoveChild(remove);
    }
}
