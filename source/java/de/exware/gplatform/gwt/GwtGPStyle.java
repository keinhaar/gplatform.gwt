package de.exware.gplatform.gwt;

import com.google.gwt.dom.client.Style;

import de.exware.gplatform.GPStyle;

class GwtGPStyle implements GPStyle
{
    private Style style;

    protected GwtGPStyle(Style style)
    {
        this.style = style;
    }

    @Override
    public void setProperty(String name, String value)
    {
        style.setProperty(name, value);
    }

    @Override
    public String getProperty(String name)
    {
        return style.getProperty(name);
    }

    @Override
    public void clearProperty(String name)
    {
        style.clearProperty(name);
    }
}
