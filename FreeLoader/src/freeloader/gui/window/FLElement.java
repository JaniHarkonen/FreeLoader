package freeloader.gui.window;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JPanel;

import freeloader.FLAppContext;

public abstract class FLElement {

		// Reference to the application context this element is
		// operating in
	protected FLAppContext hostContext;
	
	
	public FLElement(FLAppContext host) {
		hostContext = host;
	}
	
	
		// Returns the element component
		// (TO BE OVERRIDDEN)
	public Component getElement() {
		return null;
	}
	
		// Returns the context this element is operating in
	public FLAppContext getHostWindow() {
		return hostContext;
	}
	
	
		// UTILITY: Creates a default wrapper (JPanel with BorderLayout)
	public static JPanel createWrapper() {
		JPanel wrapper = new JPanel();
		wrapper.setLayout(new BorderLayout());
		
		return wrapper;
	}
}
