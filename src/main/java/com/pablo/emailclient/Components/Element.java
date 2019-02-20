package com.pablo.emailclient.Components;

import java.util.UUID;

public abstract class Element {

    public enum ElementType{Folder, Message};
    private ElementType type;

    public void AddChildElement(Element childElement){
        throw new UnsupportedOperationException("Operation is not supported");
    }

    public boolean RemoveChild(Element element)
    {
        throw new UnsupportedOperationException("Operation is not supported");
    }

    public abstract void DisplayContent();
    public abstract ElementType getType();


}
