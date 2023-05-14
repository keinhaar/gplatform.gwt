package de.exware.gplatform.gwt.style;

import com.google.gwt.core.client.JavaScriptObject;

import de.exware.gplatform.style.CSSRule;

public final class GwtGPCSSRule extends JavaScriptObject implements CSSRule
{
    protected GwtGPCSSRule()
    {
        
    }
    
    @Override
    public final int getInt(String name)
    {
        int i = 0;
        String str = getProperty(name);
        if(str != null && str.length() > 0)
        {
            int index = str.indexOf("px",0);
            if(index >= 0)
            {
                str = str.substring(0,index);
            }
            i = Integer.parseInt(str);            
        }
        else
        {
            throw new IllegalArgumentException("");
        }
        return i;
    }
    
    @Override
    public final void setPixel(String name, int value)
    {
        setPropertyValue(name, value + "px");
    }
    
    @Override
    public final String getColor(String name)
    {
        String str = getProperty(name);
        return str;
    }
    
    @Override
    public final String getProperty(String name)
    {
        String value = getPropertyValue(name);
        if("".equals(value))
        {
            value = null;
        }
        return value;
    }
    
    @Override
    public native String getSelector() /*-{
        return this.selectorText;
    }-*/;
    
    protected native String getPropertyName(int i) /*-{
        return this.style.item(i);
    }-*/;

    protected native String getPropertyValue(String name) /*-{
        return this.style.getPropertyValue(name);
    }-*/;

    protected native void setPropertyValue(String name, String value) /*-{
        return this.style.setProperty(name, value);
    }-*/;

    protected native int getPropertyCount() /*-{
        return this.style.length;
    }-*/;

}
