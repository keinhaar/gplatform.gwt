package de.exware.gplatform.gwt.element;

import com.google.gwt.dom.client.InputElement;

import de.exware.gplatform.element.GPRangeElement;

public class GwtGPRangeElement extends GwtGPInputElement implements GPRangeElement
{
    public GwtGPRangeElement(InputElement el)
    {
        super(el);
        setAttribute("type", "range");
    }
}
