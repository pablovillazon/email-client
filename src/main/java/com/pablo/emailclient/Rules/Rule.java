package com.pablo.emailclient.Rules;

public class Rule {

    private String ruleName;
    private Boolean isRunning;

    private IAction action;
    private ICondition condition;

    public Rule()
    {
        isRunning  = false;
    }

    public void ApplyRule()
    {
        try {
            if(condition.Evaluate())
            {
                isRunning = true;
                action.ExecuteAction();
            }
        }catch (Exception ex)
        {
            System.out.println("Error on applying rule");
        }

        isRunning = false;
    }

}
