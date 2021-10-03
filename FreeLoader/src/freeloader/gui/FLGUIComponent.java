package freeloader.gui;

import javax.swing.JPanel;

public abstract class FLGUIComponent {

		// The context provided for this component
	protected FLGUIContext context;
	
		// Whether the component should only be rendered once
	protected boolean renderOnce;
	
		// Whether the component has been rendered
	protected boolean hasRendered;
	
		// JPanel containing the GUI-element
	protected JPanel element;
	
	
	protected FLGUIComponent(FLGUIContext c) {
		context = c;
		renderOnce = false;
		hasRendered = false;
		element = FLGUIUtilities.createBorderedContainer();
	}
	
	protected FLGUIComponent(FLGUIContext c, boolean re) {
		this(c);
		renderOnce = re;
	}
	
	
		// Renders the component and returns the resulting JPanel
	public JPanel render() {
		if( renderOnce == true && hasRendered == true ) return element;
		
		element.removeAll();
		element.add(draw());
		element.revalidate();
		element.repaint();
		hasRendered = true;
		
		return element;
	}
	
		// Draws the component and returns the resulting JPanel
		// (TO BE OVERRIDDEN)
	protected JPanel draw() {
		return null;
	}
}
