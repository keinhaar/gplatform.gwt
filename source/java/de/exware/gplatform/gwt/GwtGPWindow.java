package de.exware.gplatform.gwt;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Window;

import de.exware.gplatform.GPElement;
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

    @Override
    public String getComputedStyleProperty(GPElement element, String propName)
    {
        String prop = null;
        GwtGPElement gwtelement = (GwtGPElement) element;
        prop = getComputedStyleProperty(gwtelement.getElement(), propName);
        return prop;
    }

    private static native String getComputedStyleProperty(Element element, String propName) 
    /*-{
		return window.getComputedStyle(element, null)
		    .getPropertyValue(propName);
    }-*/;
}
