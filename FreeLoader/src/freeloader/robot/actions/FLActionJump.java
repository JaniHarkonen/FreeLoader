package freeloader.robot.actions;

import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.values.FLInt;

public class FLActionJump extends FLRobotAction {

		// Action line to jump to
	private FLInt line;
	
	
	public FLActionJump() {
		super();
		
		description = "Jump to line";
		line = new FLInt(0);
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		rc.getOwner().gotoLine(line.getValue(rc));
	}
}
