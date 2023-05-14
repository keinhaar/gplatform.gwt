package de.exware.gplatform.gwt;

import com.google.gwt.storage.client.Storage;

import de.exware.gplatform.GPStorage;

public class GwtGPStorage implements GPStorage 
{
	public GwtGPStorage() 
	{
	}
	
	@Override
	public void setItem(String key, String value)
	{
		Storage storage = Storage.getLocalStorageIfSupported();
		storage.setItem(key, value);
	}

	@Override
	public String getItem(String key) 
	{
		Storage storage = Storage.getLocalStorageIfSupported();
		return storage.getItem(key);
	}
}
