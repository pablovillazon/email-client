package com.pablo.emailclient.Controllers;


import com.pablo.emailclient.Adapter.ServerMessage;
import com.pablo.emailclient.Adapter.ServerMessageToEmailMessageAdapter;
import com.pablo.emailclient.Components.EmailMessage;
import com.pablo.emailclient.Components.Folder;
import com.pablo.emailclient.Components.Element;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@RestController
public class MainController {

    //Root folder with no permissions
    private Element rootFolder = new Folder("[Root]", new ArrayList<>());
    FileController fileController = new FileController();

    @RequestMapping("/start")
    public Element start(){

        //Create messages
        Element message1 = new EmailMessage("p.villazon@gmail.com", "leonardo@gmail.com", "2019-02-17 05:30", "Email Test","Email message content");
        Element message2 = new EmailMessage("p.villazon@gmail.com", "roberto@gmail.com", "2019-02-17 07:30", "Email Test 3","Email 3 message content");


        ServerMessage serverMessage = new ServerMessage();
        serverMessage.setBody("sadasd");
        serverMessage.setTo("sdsad");
        serverMessage.setFrom("sdasd");
        serverMessage.setSent("sdsadasd");
        serverMessage.setSubject("sadasdas");
        serverMessage.setBody("asdasdasdasd");

        ServerMessageToEmailMessageAdapter messageParsed = new ServerMessageToEmailMessageAdapter(serverMessage, new EmailMessage());
        EmailMessage messageFromServer = messageParsed.getEmailMessage();




        //Create folder structure [Inbox, Sent, Trash, CustomFolder...]
        List<Folder.ElementPermission> inboxPermission = new ArrayList<>();

        Element inboxFolder = new Folder("Inbox", inboxPermission);
        Element sentFolder = new Folder("Sent", inboxPermission);
        Element trashFolder = new Folder("Trash", inboxPermission);

        rootFolder.AddChildElement(inboxFolder);
        rootFolder.AddChildElement(sentFolder);
        rootFolder.AddChildElement(trashFolder);

        //Put messages in Inbox
        inboxFolder.AddChildElement(message1);
        inboxFolder.AddChildElement(message2);

        //Move message from Sent to CustomFolder
        List<Folder.ElementPermission> customFolderPermission = new ArrayList<>();
        customFolderPermission.add(Folder.ElementPermission.CanDelete);
        customFolderPermission.add(Folder.ElementPermission.CanRename);
        customFolderPermission.add(Folder.ElementPermission.CanCreateSubFolder);
        //customFolderPermission.add(Folder.ElementPermission.CanDelete);

        Element customFolder = new Folder("OldMessages", customFolderPermission);


        rootFolder.AddChildElement(customFolder);

        //Display Folder structure (subfolders and message headers)

        rootFolder.DisplayContent();

        return  rootFolder;
    }

    @RequestMapping("/move-message")
    public Folder mover(@RequestParam(value="msgId") String msgId,
                        @RequestParam(value="folderDestination") String folderDestination){



        return new Folder("custom", new ArrayList<>());
    }

}
