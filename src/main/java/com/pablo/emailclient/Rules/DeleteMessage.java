package com.pablo.emailclient.Rules;

import com.pablo.emailclient.Components.Element;
import com.pablo.emailclient.Controllers.FileController;

import java.util.List;

public class DeleteMessage {

    public void executeDelete(List<Element> message, FileController.DeletionType deletionType){
        System.out.println("Deleting messages..." + deletionType.toString());
    }
}
