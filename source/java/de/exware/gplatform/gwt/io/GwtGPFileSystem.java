package de.exware.gplatform.gwt.io;

import java.io.IOException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import de.exware.gplatform.io.GPFile;

/**
 * Interface to be used on Server Side.
 * @author martin
 */
@RemoteServiceRelativePath(GwtGPFileSystem.RELATIVE_SERVICE_PATH)
public interface GwtGPFileSystem extends RemoteService
{
    public static final String RELATIVE_SERVICE_PATH = "GwtGPFileSystem";

    /**
     * Get an Array of GPFileSystem Roots. Implementation must make sure, that no files outside of this roots 
     * are accessible.
     * @return
     */
    public GPFile[] getRoots();
    
    /**
     * Provides a List of Files in the given Directory.
     * @param parent
     * @return
     * @throws IOException 
     */
    public GPFile[] listFiles(GPFile parent) throws IOException;
}
