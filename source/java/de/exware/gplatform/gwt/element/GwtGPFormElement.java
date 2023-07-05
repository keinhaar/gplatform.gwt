package de.exware.gplatform.gwt.element;

import com.google.gwt.dom.client.FormElement;

import de.exware.gplatform.element.GPFormElement;
import de.exware.gplatform.gwt.GwtGPElement;

public class GwtGPFormElement extends GwtGPElement implements GPFormElement
{
    public GwtGPFormElement(FormElement el)
    {
        super(el);
    }
}
