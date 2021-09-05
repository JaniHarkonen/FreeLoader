package freeloader.robot.actions;

import freeloader.gui.settings.FLSettings;
import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.values.FLInt;

public abstract class FLRobotAction {
	
		// Title of the action
	protected String title;
	
		// Description of the action
	protected String description;
	
	
	protected FLRobotAction() {
		title = "<Unnamed action>";
		description = "<None>";
	}
	

		// Performs the action in a given context
		// (TO BE OVERRIDDEN)
	public void perform(FLRobotContext rc) {
		
	}
	
		// Sets the title of the action
	public void setTitle(String t) {
		title = t;
	}
	
		// Sets the description of the action
	public void setDescription(String d) {
		description = d;
	}
	
		// Returns the title of the action
	public String getTitle() {
		return title;
	}
	
		// Returns the description of the action
	public String getDescription() {
		return description;
	}
	
		// UTILITY: Thread sleeping (separated to avoid multiple try-catch)
		// via FLInts
	public static void sleep(FLInt ms, FLRobotContext rc) {
		try
		{
			Thread.sleep(ms.getValue(rc));
			
		} catch (InterruptedException e) { e.printStackTrace(); }
	}
}
