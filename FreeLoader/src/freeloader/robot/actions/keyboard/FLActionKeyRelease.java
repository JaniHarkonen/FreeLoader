package freeloader.robot.actions.keyboard;

import freeloader.robot.FLRobotContext;

public abstract class FLActionKeyRelease extends FLKeyboardKey {
	
	protected FLActionKeyRelease() {
		super();
		
		descriptionSuffix = " released";
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		rc.getRobot().keyRelease(keyboardKey);
	}
}
