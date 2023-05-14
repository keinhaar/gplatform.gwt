package de.exware.gplatform.gwt;

import com.google.gwt.core.client.EntryPoint;

public class ModuleInitializer implements EntryPoint
{
    @Override
    public void onModuleLoad()
    {
        GwtGPlatform.init();
    }
}
