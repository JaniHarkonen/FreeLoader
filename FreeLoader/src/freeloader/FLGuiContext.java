package freeloader;

import java.util.HashMap;
import java.util.Map;

public class FLGuiContext {

		// Map of the available GUI items
	private Map<String, Object> items;
	
	
	public FLGuiContext() {
		items = new HashMap<String, Object>();
	}
	
	
		// Puts an item into the GUI item map
	public void put(String id, Object item) {
		items.put(id, item);
	}
	
		// Returns an item from the GUI item map
	public Object get(String id) {
		return items.get(id);
	}
}
