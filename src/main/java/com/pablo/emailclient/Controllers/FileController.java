package com.pablo.emailclient.Controllers;

import com.pablo.emailclient.Components.Element;
import com.pablo.emailclient.Components.EmailMessage;
import com.pablo.emailclient.Components.Folder;

import javax.xml.bind.JAXB;


import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

public class FileController {

    private String appPath;
    private Element rootFolder;

    public enum OperationResult{SUCCESS, FAIL, INVALIDMESSAGE};

    public FileController(){

        appPath = "c:\\Temp";
        rootFolder = new Folder("[Root]", new ArrayList<>());
    }


    //Methods

    public void CreateFolder(String folderName, String parentFolder)
    {
        if(parentFolder.isEmpty())
        {
            boolean  folderCreated = new File(appPath+"folderName").mkdirs();
        }

    }

    public void DeleteFolder(String folderName)
    {
        boolean  folderCreated = new File(appPath+"folderName").delete();

    }

    public OperationResult SaveEmailMessageToFolder(String destination, EmailMessage message)
    {
        if(!message.isValidMessage())
        {
            return OperationResult.INVALIDMESSAGE;
        }
        if(!isValidateFolder(destination))
        {
            return OperationResult.FAIL;
        }

        String xmlFile = ParseMessageToXML(message);

        if(!xmlFile.isEmpty())
        {

        }

        return OperationResult.FAIL;
    }

    private String ParseMessageToXML(EmailMessage message)
    {
        StringWriter sw = new StringWriter();
        JAXB.marshal(message, sw);

        String xmlString = sw.toString();

        return xmlString;
    }

    private boolean isValidateFolder(String folderName)
    {
        return true;
    }
    private void WriteMessageToDisk()
    {

    }


}
