package freeloader.robot.actions.keyboard;

import freeloader.robot.FLRobotContext;

public class FLActionKeyRelease extends FLKeyboardKey {
	
	public FLActionKeyRelease() {
		super();
		
		title = "Release key";
		descriptionSuffix = " released";
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		rc.getRobot().keyRelease(keyboardKey);
	}
}
