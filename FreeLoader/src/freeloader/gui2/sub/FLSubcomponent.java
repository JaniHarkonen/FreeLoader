package freeloader.gui2.sub;

import freeloader.gui2.FLGUIComponent;

public abstract class FLSubcomponent extends FLGUIComponent {

		// GUI-component that this subcomponent belongs to
	protected FLGUIComponent owner;
	
	
	protected FLSubcomponent(FLGUIComponent o) {
		super(null, false);
		owner = o;
	}
	
		// Returns the GUI-component that this subcomponent belongs to
	public FLGUIComponent getOwner() {
		return owner;
	}
}
