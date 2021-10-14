package freeloader.robot.actions;

import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.values.FLInt;

public class FLActionJump extends FLRobotAction {

		// Action line to jump to
	private FLInt line;
	
		// String to be added in front of the description
	private String descriptionPrefix;
	
	
	public FLActionJump() {
		super();
		
		title = "Jump to line";
		descriptionPrefix = "Jump to line";
		line = new FLInt(0);
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		rc.getOwner().gotoLine(line.getValue(rc) - 1);
	}
	
	
		// Returns a reference to the line FLInt
	public FLInt getLine() {
		return line;
	}
	
		// Updates the action description
	public void updateDescription() {
		setDescription(descriptionPrefix + " " + (line.getUnmoddedValue() + 1));
	}
}