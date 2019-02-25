package com.pablo.emailclient.Rules;

public class CopyMessageAction implements IAction {

    private CopyMessage copyMessage;

    public void setCopyMessage(CopyMessage copyMessage) {
        this.copyMessage = copyMessage;
    }

    @Override
    public void ExecuteAction() {
        System.out.println("Action Id: " + Thread.currentThread().getId() + " executing Copy action.");

        if(copyMessage != null)
        {
            copyMessage.executeCopy();
        }

    }
}
