package de.exware.gplatform.gwt;

import com.google.gwt.user.client.Window;

import de.exware.gplatform.GPWindow;

public class GwtGPWindow implements GPWindow
{
    GwtGPWindow()
    {
    }

    @Override
    public int getClientWidth()
    {
        return Window.getClientWidth();
    }

    @Override
    public int getClientHeight()
    {
        return Window.getClientHeight();
    }
}
