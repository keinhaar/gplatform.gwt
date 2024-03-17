package de.exware.gplatform.gwt.log;

import java.io.OutputStream;
import java.io.PrintStream;

import com.google.gwt.core.client.GWT;

import de.exware.gplatform.log.LogFactory;

public class GwtLogFactory extends LogFactory
{
    public GwtLogFactory()
    {
        System.setOut(new LogStream());
    }
}

/**
 * Diese Klasse wird als ersatz für System.out und System.err gesetzt und sorgt so dafür, dass jedes System.out.println
 * über die LogKlasse läuft. Es wird weiterhin zwischen Error und Out unterschieden.
 */
class LogStream extends PrintStream
{
    public LogStream()
    {
        super((OutputStream)null);
    }

    @Override
    public void print(String str)
    {
        log(str);
    }

    @Override
    public void println(String str)
    {
        log(str);
    }

    void log( String message)
    {
        GWT.log(message);
    }
    
    @Override
    public void print(boolean b)
    {
        log(b ? "true" : "false");
    }
    
    @Override
    public void print(int v)
    {
        log(String.valueOf(v));
    }

    @Override
    public void print(double v)
    {
        log(String.valueOf(v));
    }

    @Override
    public void print(char v)
    {
        log(String.valueOf(v));
    }

    @Override
    public void print(float v)
    {
        log(String.valueOf(v));
    }

    @Override
    public void print(long v)
    {
        log(String.valueOf(v));
    }

    @Override
    public void print(Object object)
    {
        log("" + object);
    }

    @Override
    public void print(char[] ch)
    {
        log(String.valueOf(ch));
    }
    
    @Override
    public void close()
    {}
}