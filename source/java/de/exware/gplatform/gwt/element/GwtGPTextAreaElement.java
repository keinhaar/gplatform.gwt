package de.exware.gplatform.gwt.element;

import com.google.gwt.dom.client.TextAreaElement;

import de.exware.gplatform.element.GPTextAreaElement;
import de.exware.gplatform.gwt.GwtGPElement;

public class GwtGPTextAreaElement extends GwtGPElement implements GPTextAreaElement
{
    public GwtGPTextAreaElement(TextAreaElement el)
    {
        super(el);
    }

    @Override
    public void setCols(int columns)
    {
        ((TextAreaElement)getElement()).setCols(columns);
    }

    @Override
    public void setRows(int rows)
    {
        ((TextAreaElement)getElement()).setRows(rows);
    }

    @Override
    public void setDisabled(boolean b)
    {
        ((TextAreaElement)getElement()).setDisabled(b);
    }

    @Override
    public String getValue()
    {
        return ((TextAreaElement)getElement()).getValue();
    }

    @Override
    public void setValue(String text)
    {
        ((TextAreaElement)getElement()).setValue(text);
    }

    @Override
    public int getCols()
    {
        return ((TextAreaElement)getElement()).getCols();
    }

    @Override
    public int getRows()
    {
        return ((TextAreaElement)getElement()).getRows();
    }
}
