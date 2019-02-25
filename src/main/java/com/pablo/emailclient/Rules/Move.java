package com.pablo.emailclient.Rules;

import java.util.UUID;

public class Move implements IAction {

    private UUID msgId;
    private String destinationFolder;

    public Move( UUID msgId, String destination)
    {
        this.msgId = msgId;
        this.destinationFolder = destination;

    }

    @Override
    public void ExecuteAction() {
        System.out.println("moving: " + msgId + " To: "+ destinationFolder);

    }
}
