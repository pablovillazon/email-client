package com.pablo.emailclient.Rules;


public class MoveMessageAction implements IAction {

    private MoveMessage moveMessage;

    public void setMoveMessage(MoveMessage moveMessage){
        this.moveMessage = moveMessage;
    }

    @Override
    public void ExecuteAction() {
        System.out.println("Action Id: " + Thread.currentThread().getId() + " executing Move action.");
        if(moveMessage != null)
        {
            moveMessage.executeMove();
        }
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
