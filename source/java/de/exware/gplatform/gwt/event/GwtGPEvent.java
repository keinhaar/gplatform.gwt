package de.exware.gplatform.gwt.event;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.Touch;
import com.google.gwt.user.client.Event;

import de.exware.gplatform.DoubleMap;
import de.exware.gplatform.event.GPEvent;
import de.exware.gplatform.event.GPTouch;
import de.exware.gplatform.gwt.GwtGPTouch;

public class GwtGPEvent
    implements GPEvent
{
    private Event event;
    private Type type;
    private static final DoubleMap<Type, Integer> typeMap = new DoubleMap<>();
    
    static
    {
        typeMap.put(Type.ONCHANGE, Event.ONCHANGE);
        typeMap.put(Type.ONCLICK, Event.ONCLICK);
        typeMap.put(Type.ONCONTEXTMENU, Event.ONCONTEXTMENU);
        typeMap.put(Type.ONDBLCLICK, Event.ONDBLCLICK);
        typeMap.put(Type.ONFOCUS, Event.ONFOCUS);
        typeMap.put(Type.ONKEYDOWN, Event.ONKEYDOWN);
        typeMap.put(Type.ONKEYPRESS, Event.ONKEYPRESS);
        typeMap.put(Type.ONKEYUP, Event.ONKEYUP);
        typeMap.put(Type.ONMOUSEDOWN, Event.ONMOUSEDOWN);
        typeMap.put(Type.ONMOUSEMOVE, Event.ONMOUSEMOVE);
        typeMap.put(Type.ONMOUSEOUT, Event.ONMOUSEOUT);
        typeMap.put(Type.ONMOUSEOVER, Event.ONMOUSEOVER);
        typeMap.put(Type.ONMOUSEUP, Event.ONMOUSEUP);
        typeMap.put(Type.ONMOUSEWHEEL, Event.ONMOUSEWHEEL);
        typeMap.put(Type.ONTOUCHEND, Event.ONTOUCHEND);
        typeMap.put(Type.ONTOUCHMOVE, Event.ONTOUCHMOVE);
        typeMap.put(Type.ONTOUCHSTART, Event.ONTOUCHSTART);
        typeMap.put(Type.ONLOAD, Event.ONLOAD);
        typeMap.put(Type.ONERROR, Event.ONERROR);
    }
    
    public GwtGPEvent(Event event)
    {
        this.event = event;
        this.type = typeMap.reverseGet(event.getTypeInt());
    }

    @Override
    public Type getType()
    {
        return type;
    }

    @Override
    public void preventDefault()
    {
        event.preventDefault();
    }

    @Override
    public void stopPropagation()
    {
        event.stopPropagation();
    }

    @Override
    public boolean getShiftKey()
    {
        return event.getShiftKey();
    }

    @Override
    public boolean getAltKey()
    {
        return event.getAltKey();
    }

    @Override
    public boolean getCtrlKey()
    {
        return event.getCtrlKey();
    }

    @Override
    public int getClientX()
    {
        return event.getClientX();
    }

    @Override
    public int getClientY()
    {
        return event.getClientY();
    }

    @Override
    public Button getButton()
    {
        Button button = null;
        int bt = event.getButton();
        switch(bt)
        {
            case Event.BUTTON_LEFT:
                button = Button.BUTTON_LEFT;
            break;
            case Event.BUTTON_MIDDLE:
                button = Button.BUTTON_MIDDLE;
            break;
            case Event.BUTTON_RIGHT:
                button = Button.BUTTON_RIGHT;
            break;
        }
        return button;
    }

    @Override
    public int getKeyCode()
    {
        return event.getKeyCode();
    }

    @Override
    public int getCharCode()
    {
        return event.getCharCode();
    }

    @Override
    public int getMouseWheelVelocityY()
    {
        return event.getMouseWheelVelocityY();
    }

    @Override
    public List<GPTouch> getTouches()
    {
        JsArray<Touch> array = event.getTouches();
        return getGPTouches(array);
    }

    @Override
    public List<GPTouch> getChangedTouches()
    {
        JsArray<Touch> array = event.getChangedTouches();
        return getGPTouches(array);
    }

    private List<GPTouch> getGPTouches(JsArray<Touch> array)
    {
        List<GPTouch> touches = new ArrayList<>();
        for(int i=0; i<array.length(); i++)
        {
            Touch t = array.get(i);
            GPTouch gpt = new GwtGPTouch(t);
            touches.add(gpt);
        }
        return touches;
    }
    
    /**
     * Converts GWT eventMask to Event Types.
     * @param eventMask
     */
    public static List<Type> getEventTypes(int eventMask)
    {
        List<Type> types = new ArrayList<>();
        for(int i=1; i<0x1000000; i = i<<1)
        {
            Type t = typeMap.reverseGet(i);
            if(t != null)
            {
                types.add(t);
            }
        }
        return types;
    }

    public static int createEventMask(Type[] eventTypes)
    {
        int mask = 0;
        for(Type t : eventTypes)
        {
            mask = mask | typeMap.get(t); 
        }
        return mask;
    }
}
