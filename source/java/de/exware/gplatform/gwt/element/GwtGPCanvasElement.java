package de.exware.gplatform.gwt.element;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.CanvasElement;

import de.exware.gplatform.element.GPCanvasElement;
import de.exware.gplatform.element.GPContext2d;
import de.exware.gplatform.gwt.GwtGPElement;

public class GwtGPCanvasElement extends GwtGPElement implements GPCanvasElement
{
    public GwtGPCanvasElement(CanvasElement el)
    {
        super(el);
    }

    @Override
    public void setWidth(int width)
    {
        ((CanvasElement)getElement()).setWidth(width);
    }

    @Override
    public void setHeight(int height)
    {
        ((CanvasElement)getElement()).setHeight(height);
    }

    @Override
    public GPContext2d getContext2d()
    {
        Context2d c2d = ((CanvasElement)getElement()).getContext2d();
        return new GwtGPContext2d(c2d);
    }
}
