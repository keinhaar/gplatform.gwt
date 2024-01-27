package de.exware.gplatform.gwt;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;

import de.exware.gplatform.GPElement;
import de.exware.gplatform.GPStyle;
import de.exware.gplatform.event.GPEvent.Type;
import de.exware.gplatform.event.GPEventListener;
import de.exware.gplatform.gwt.event.GwtGPEvent;

public class GwtGPElement implements GPElement
{
    private Element element;
    
    protected GwtGPElement(Element el)
    {
        this.element = el;
    }

    @Override
    public List<GPElement> getChildElements()
    {
        NodeList<Node> nlist = element.getChildNodes();
        List<GPElement> list = new ArrayList<>();
        for(int i=0;i<nlist.getLength();i++)
        {
            Node n = nlist.getItem(i);
            if(n instanceof Element)
            {
                list.add(new GwtGPElement((Element) n));
            }
        }
        return list;
    }
    
    @Override
    public void setClassName(String className)
    {
        element.setClassName(className);
    }

    @Override
    public void addClassName(String className)
    {
        element.addClassName(className);
    }

    @Override
    public GPStyle getStyle()
    {
        return new GwtGPStyle(element.getStyle());
    }

    @Override
    public GPElement cloneNode(boolean deep)
    {
        return new GwtGPElement((Element)element.cloneNode(deep));
    }

    @Override
    public int getOffsetWidth()
    {
        return element.getOffsetWidth();
    }

    @Override
    public int getOffsetHeight()
    {
        return element.getOffsetHeight();
    }

    @Override
    public void removeChild(GPElement child)
    {
        element.removeChild(((GwtGPElement)child).element);
    }

    @Override
    public void appendChild(GPElement child)
    {
        element.appendChild(((GwtGPElement)child).element);
    }

    @Override
    public int getAbsoluteLeft()
    {
        return element.getAbsoluteLeft();
    }

    @Override
    public int getAbsoluteTop()
    {
        return element.getAbsoluteTop();
    }

    @Override
    public void removeFromParent()
    {
        element.removeFromParent();
    }

    public Element getElement()
    {
        return element;
    }

    @Override
    public void setEventListener(GPEventListener eventListener)
    {
        Event.setEventListener(element, new EventListener()
        {
            @Override
            public void onBrowserEvent(Event event)
            {
                eventListener.onBrowserEvent(new GwtGPEvent(event));
            }
        });
    }

    @Override
    public void removeClassName(String classname)
    {
        element.removeClassName(classname);
    }

    @Override
    public void enabledEvents( Type... eventTypes )
    {
        int mask = Event.getEventsSunk( element );
        mask = mask | GwtGPEvent.createEventMask( eventTypes );
        Event.sinkEvents(element, mask);
    }

    @Override
    public Type[] getEnabledEvents()
    {
        int eventMask = Event.getEventsSunk(element);
        GwtGPEvent.getEventTypes(eventMask);
        return null;
    }

    @Override
    public GPElement getParentElement()
    {
        return new GwtGPElement(element.getParentElement());
    }

    @Override
    public String getClassName()
    {
        return element.getClassName();
    }

    @Override
    public void removeAllChildren()
    {
        element.removeAllChildren();
    }

    @Override
    public String getInnerText()
    {
        return element.getInnerText();
    }

    @Override
    public void setInnerHTML(String text)
    {
        element.setInnerHTML(text);
    }

    @Override
    public void insertFirst(GPElement element)
    {
        GwtGPElement gel = (GwtGPElement) element;
        this.element.insertFirst(gel.getElement());
    }

    @Override
    public String getInnerHTML()
    {
        return element.getInnerHTML();
    }

    @Override
    public void insertAfter(GPElement newChild, GPElement after)
    {
        GwtGPElement gnewChild = (GwtGPElement) newChild;
        GwtGPElement gafter = (GwtGPElement) after;
        Element el = null;
        if(gafter != null)
        {
            el = gafter.getElement();
        }
        element.insertAfter(gnewChild.getElement(), el);
    }

    @Override
    public void setTabIndex(int i)
    {
        element.setTabIndex(i);
    }

    @Override
    public void replaceChild(GPElement newChild, GPElement oldChild)
    {
        GwtGPElement gnewChild = (GwtGPElement) newChild;
        GwtGPElement goldChild = (GwtGPElement) oldChild;
        element.replaceChild(gnewChild.getElement(), goldChild.getElement());
    }

    @Override
    public GPElement getChild(int i)
    {
        return new GwtGPElement((Element) element.getChild(i));
    }

    @Override
    public void setInnerText(String str)
    {
        element.setInnerText(str);
    }

    @Override
    public void setAttribute(String name, String value)
    {
        element.setAttribute(name, value);
    }

    @Override
    public String getAttribute(String name)
    {
        return element.getAttribute(name);
    }

    @Override
    public boolean hasAttribute(String name)
    {
        return element.hasAttribute(name);
    }

    @Override
    public void removeAttribute(String name)
    {
        element.removeAttribute(name);
    }
    
    @Override
    public String getPropertyString(String name)
    {
        return element.getPropertyString(name);
    }

    @Override
    public int getPropertyInt(String name)
    {
        return element.getPropertyInt(name);
    }

    @Override
    public Object getPropertyObject(String name)
    {
        return element.getPropertyObject(name);
    }

    @Override
    public void setPropertyInt(String name, int value)
    {
        element.setPropertyInt(name, value);
    }

    @Override
    public void focus()
    {
        element.focus();
    }
    
    @Override
    public int getClientWidth()
    {
        return element.getClientWidth();
    }

    @Override
    public boolean hasClassName(String classname)
    {
        return element.hasClassName(classname);
    }

    @Override
    native public boolean hasFocus() 
    /*-{
        var equal = $doc.activeElement == this.@de.exware.gplatform.gwt.GwtGPElement::element;
        $wnd.alert("" + equal);
        return $doc.hasFocus() && equal;
    }-*/;

}
