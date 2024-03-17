package de.exware.gplatform.gwt;

import com.google.gwt.core.client.EntryPoint;

import de.exware.gplatform.gwt.log.GwtLogFactory;

public class ModuleInitializer implements EntryPoint
{
    @Override
    public void onModuleLoad()
    {
        new GwtLogFactory();
        GwtGPlatform.init();
    }
}
