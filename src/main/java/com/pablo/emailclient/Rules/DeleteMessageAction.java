package com.pablo.emailclient.Rules;

public class DeleteMessageAction implements IAction {
    private DeleteMessage deleteMessage;

    public void setDeleteMessage(DeleteMessage deleteMessage) {
        this.deleteMessage = deleteMessage;
    }

    @Override
    public void ExecuteAction() {

        System.out.println("Action Id: " + Thread.currentThread().getId() + " executing Delete action.");
        if(deleteMessage != null)
        {
            deleteMessage.executeDelete();
        }

    }
}
