package de.exware.gplatform.gwt.element;

import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.dom.client.SelectElement;

import de.exware.gplatform.element.GPOptionElement;
import de.exware.gplatform.element.GPSelectElement;
import de.exware.gplatform.gwt.GwtGPElement;

public class GwtGPSelectElement extends GwtGPElement implements GPSelectElement
{
    public GwtGPSelectElement(SelectElement el)
    {
        super(el);
    }

    @Override
    public int getSelectedIndex()
    {
        return ((SelectElement)getElement()).getSelectedIndex();
    }

    @Override
    public void setSelectedIndex(int i)
    {
        ((SelectElement)getElement()).setSelectedIndex(i);
    }

    @Override
    public void clear()
    {
        ((SelectElement)getElement()).clear();
    }

    @Override
    public void add(GPOptionElement opt)
    {
        GwtGPOptionElement gwtopt = (GwtGPOptionElement) opt;
        ((SelectElement)getElement()).add((OptionElement) gwtopt.getElement(), null);
    }

    @Override
    public void setDisabled(boolean b)
    {
        ((SelectElement)getElement()).setDisabled(b);
    }
}
