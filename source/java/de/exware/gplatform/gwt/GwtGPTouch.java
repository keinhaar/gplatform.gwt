package de.exware.gplatform.gwt;

import com.google.gwt.dom.client.Touch;

import de.exware.gplatform.event.GPTouch;

public class GwtGPTouch implements GPTouch
{
    private Touch touch;
    
    public GwtGPTouch(Touch touch)
    {
        this.touch = touch;
    }

    @Override
    public int getClientX()
    {
        return touch.getClientX();
    }

    @Override
    public int getClientY()
    {
        return touch.getClientY();
    }

}
