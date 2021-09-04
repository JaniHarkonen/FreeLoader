package freeloader.gui.window;

import java.awt.Component;

import freeloader.gui.FLWindow;

public abstract class FLElement {

		// Reference to the host window
	private FLWindow hostWindow;
	
	
	public FLElement(FLWindow host) {
		hostWindow = host;
	}
	
	
		// Returns the element component
		// (TO BE OVERRIDDEN)
	public Component getElement() {
		return null;
	}
	
		// Returns the host window
	public FLWindow getHostWindow() {
		return hostWindow;
	}
}
