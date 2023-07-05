package de.exware.gplatform.gwt.io;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import de.exware.gplatform.io.GPFile;
import de.exware.gplatform.io.GPFileSystemAsync;

public class GwtFileSystemWrapper implements GPFileSystemAsync
{
    GwtGPFileSystemAsync filesystem;
    
    public GwtFileSystemWrapper(GwtGPFileSystemAsync async)
    {
        filesystem = async;
    }
    
    public GwtFileSystemWrapper()
    {
        filesystem = GWT.create(GwtGPFileSystem.class);
    }

    @Override
    public void getRoots(Callback callback)
    {
        filesystem.getRoots(new AsyncCallback<GPFile[]>()
        {
            
            @Override
            public void onSuccess(GPFile[] result)
            {
                callback.onSuccess(result);
            }
            
            @Override
            public void onFailure(Throwable caught)
            {
                callback.onError(caught);
            }
        });
    }

    @Override
    public void listFiles(GPFile parent, Callback callback)
    {
        filesystem.listFiles(parent, new AsyncCallback<GPFile[]>()
        {
            
            @Override
            public void onSuccess(GPFile[] result)
            {
                callback.onSuccess(result);
            }
            
            @Override
            public void onFailure(Throwable caught)
            {
                callback.onError(caught);
            }
        });
    }
    
}
