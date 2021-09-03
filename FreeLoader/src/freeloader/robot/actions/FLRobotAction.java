package freeloader.robot.actions;

import freeloader.robot.FLRobotContext;

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
}
