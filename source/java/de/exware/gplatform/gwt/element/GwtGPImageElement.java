package de.exware.gplatform.gwt.element;

import com.google.gwt.dom.client.ImageElement;

import de.exware.gplatform.element.GPImageElement;
import de.exware.gplatform.gwt.GwtGPElement;

public class GwtGPImageElement extends GwtGPElement implements GPImageElement
{
    public GwtGPImageElement(ImageElement el)
    {
        super(el);
    }

    @Override
    public void setSrc(String url)
    {
        ((ImageElement)getElement()).setSrc(url);
    }

    @Override
    public void setWidth(int iconWidth)
    {
        ((ImageElement)getElement()).setWidth(iconWidth);
    }

    @Override
    public void setHeight(int iconHeight)
    {
        ((ImageElement)getElement()).setHeight(iconHeight);
    }
}
