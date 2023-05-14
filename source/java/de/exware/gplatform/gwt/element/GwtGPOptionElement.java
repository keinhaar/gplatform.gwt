package de.exware.gplatform.gwt.element;

import com.google.gwt.dom.client.OptionElement;

import de.exware.gplatform.element.GPOptionElement;
import de.exware.gplatform.gwt.GwtGPElement;

public class GwtGPOptionElement extends GwtGPElement implements GPOptionElement
{
    public GwtGPOptionElement(OptionElement el)
    {
        super(el);
    }

    @Override
    public void setValue(String t)
    {
    }
}
