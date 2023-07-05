package de.exware.gplatform.gwt;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.TextMetrics;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;

import de.exware.gplatform.GPDocument;
import de.exware.gplatform.GPStorage;
import de.exware.gplatform.GPWindow;
import de.exware.gplatform.gwt.style.GwtGPStyleSheet;
import de.exware.gplatform.gwt.timer.GwtGPTimer;
import de.exware.gplatform.style.GPStyleSheet;
import de.exware.gplatform.timer.GPTimer;

public class GwtGPlatform extends de.exware.gplatform.GPlatform
{
    private static GPWindow window = new GwtGPWindow();
    private static GPDocument document = new GwtGPDocument(Document.get());
    private static CanvasElement measureCanvas = Document.get().createCanvasElement();
    private static Browser browser = null;
    
    private GwtGPlatform()
    {
        browser = determineBrowser();
    }
    
    private Browser determineBrowser()
    {
        Browser browser = Browser.UNDEFINED;
        String browsername = Window.Navigator.getUserAgent();
        if(browsername.indexOf("Firefox") >= 0)
        {
            browser = Browser.FIREFOX;
        }
        else if(browsername.indexOf("Chrome") >= 0)
        {
            browser = Browser.CHROME;
        }
        else if(browsername.indexOf("Edg") >= 0)
        {
            browser = Browser.EDGE;
        }
        else if(browsername.indexOf("Safari") >= 0)
        {
            browser = Browser.SAFARI;
        }
        else if(browsername.indexOf("Opera") >= 0 || browsername.indexOf("OPR") >= 0)
        {
            browser = Browser.OPERA;
        }
        return browser;
    }

    @Override
    public GPDocument getDocument()
    {
        return document;
    }

    @Override
    public GPWindow getWindow()
    {
        return window;
    }

    protected static void init()
    {
        new GwtGPlatform();
    }
    
    @Override
    public double stringWidth(String font, String text)
    {
        double width = 0;
        Context2d g2d = measureCanvas.getContext2d();
        g2d.setFont(font);
        TextMetrics tm = g2d.measureText(text);
        width = tm.getWidth();
        return width;
    }

    @Override
    public native double getDevicePixelRatio()
    /*-{
        return window.devicePixelRatio;
    }-*/;

    @Override
    public String getModuleBaseForStaticFiles()
    {
        return GWT.getModuleBaseForStaticFiles();
    }

    @Override
    public String getModuleBaseURL()
    {
        return GWT.getModuleBaseURL();
    }

    @Override
    public GPStyleSheet getStyleSheet(int index)
    {
        return GwtGPStyleSheet.get(index);
    }

    @Override
    public int getStyleSheetCount()
    {
        return GwtGPStyleSheet.count();
    }
    
    @Override
    public GPTimer createTimer()
    {
        return new GwtGPTimer();
    }

	@Override
	public void alert(String text) 
	{
		Window.alert(text);
	}

	@Override
	public void loadData(String url, Callback callback) 
	{
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		try 
		{
			builder.sendRequest(null, new RequestCallback() 
			{
				@Override
				public void onResponseReceived(Request request, Response response) 
				{
					callback.onSuccess(response.getStatusCode(), response.getText());
				}
				
				@Override
				public void onError(Request request, Throwable exception) 
				{
					callback.onError(exception);
				}
			});
		} 
		catch (RequestException e) 
		{
			callback.onError(e);
		}
	}
	
	@Override
	public GPStorage getLocalStorage() 
	{
		return new GwtGPStorage();
	}

    @Override
    public native void clearSelection() 
    /*-{
        $wnd.getSelection().removeAllRanges();
    }-*/;

    @Override
    public Browser getBrowser()
    {
        return browser;
    }

    @Override
    public VirtualMachineProvider getVirtualMachineProvider()
    {
        return VirtualMachineProvider.GWT;
    }        

}

