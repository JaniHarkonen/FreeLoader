package freeloader.gui;

import java.util.HashMap;
import java.util.Map;

/**
 * Wrapper class for a Map of Key-Object pairs that is passed as
 * a context to FreeLoader GUI-components.
 * @author Jani Härkönen
 *
 */
public class FLGUIContext {

	/**
	 * Key-Object map that represents the context.
	 */
	private Map<String, Object> context;
	
	/**
	 * The context MUST have a Key-Object map.
	 */
	public FLGUIContext() {
		context = new HashMap<String, Object>();
	}
	
	/**
	 * Copy constructor.
	 */
	public FLGUIContext(FLGUIContext guic) {
		this();
		
		if( guic != null )
		{
			for( Map.Entry<String, Object> pair : guic.context.entrySet() )
			context.put(pair.getKey(), pair.getValue());
		}
	}
	
	/**
	 * Puts an object with a given key into the context.
	 * @param key - Key referencing the object.
	 * @param o - Object to be inserted.
	 */
	public void put(String key, Object o) {
		context.put(key, o);
	}
	
	/**
	 * Removes an object with a given key from the context.
	 * @param key
	 */
	public void remove(String key) {
		context.remove(key);
	}
	
	/**
	 * Returns an object from the context given its key.
	 * @param key - Key referencing the object.
	 * @return Object referenced by the key or NULL if the object was
	 * not found.
	 */
	public Object get(String key) {
		return context.get(key);
	}
}
