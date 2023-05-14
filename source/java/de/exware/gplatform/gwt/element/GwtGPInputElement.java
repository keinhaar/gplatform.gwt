package de.exware.gplatform.gwt.element;

import com.google.gwt.dom.client.InputElement;

import de.exware.gplatform.element.GPInputElement;
import de.exware.gplatform.gwt.GwtGPElement;

public class GwtGPInputElement extends GwtGPElement implements GPInputElement
{
    public GwtGPInputElement(InputElement el)
    {
        super(el);
    }

    @Override
    public String getValue()
    {
        return ((InputElement)getElement()).getValue();
    }

    @Override
    public void setValue(String text)
    {
        ((InputElement)getElement()).setValue(text);
    }

    @Override
    public boolean isChecked()
    {
        return ((InputElement)getElement()).isChecked();
    }

    @Override
    public void setChecked(boolean sel)
    {
        ((InputElement)getElement()).setChecked(sel);
    }

    @Override
    public void setDisabled(boolean b)
    {
        ((InputElement)getElement()).setDisabled(b);
    }

    @Override
    public void setDefaultChecked(boolean sel)
    {
        ((InputElement)getElement()).setDefaultChecked(sel);
    }

    @Override
    public void setSize(int length)
    {
        ((InputElement)getElement()).setSize(length);
    }

    @Override
    public int getSize()
    {
        return ((InputElement)getElement()).getSize();
    }
}
