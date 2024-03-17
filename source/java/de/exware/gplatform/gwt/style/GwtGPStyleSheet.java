package de.exware.gplatform.gwt.style;

import com.google.gwt.core.client.JavaScriptObject;

import de.exware.gplatform.style.CSSRule;
import de.exware.gplatform.style.GPStyleSheet;

public final class GwtGPStyleSheet extends JavaScriptObject implements GPStyleSheet
{
    protected GwtGPStyleSheet()
    {
    }

    @Override
    public native void setEnabled(boolean enabled)
    /*-{
        this.disabled = ! enabled;
    }-*/;
    
    
    @Override
    public CSSRule getCSSRule(String selector)
    {
        CSSRule rule = null;
//        String href = getHref();
        int c = getRuleCount();
        for(int i=0;i<c;i++)
        {
            CSSRule r = getCSSRule(i);
            String sel = r.getSelector();
            if(sel.equals(selector))
            {
                rule = r;
                break;
            }
        }
        return rule;
    }
    
    protected native CSSRule getCSSRule(int i) 
    /*-{
        return this.cssRules[i];
    }-*/;
    
    protected native int getRuleCount() 
    /*-{
        return this.cssRules.length;
    }-*/;
    
    public static native GPStyleSheet get(int index) 
    /*-{
        var st = $doc.styleSheets[index];
        return st;                
    }-*/;

    @Override
    public native String getHref() 
    /*-{
        var st = this.href;
        return st;                
    }-*/;

    public native static int count()
    /*-{
        var st = $doc.styleSheets.length;
        return st;            
    }-*/;
    
}
