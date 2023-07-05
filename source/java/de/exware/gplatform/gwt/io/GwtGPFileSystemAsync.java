package de.exware.gplatform.gwt.io;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.exware.gplatform.io.GPFile;

/**
 * Client Side Interface.
 * @author martin
 */
public interface GwtGPFileSystemAsync
{
    void getRoots(AsyncCallback<GPFile[]> callback);

    void listFiles(GPFile parent, AsyncCallback<GPFile[]> callback);
}
