package freeloader.robot.actions.mouse;

import java.awt.Robot;

import freeloader.robot.FLRobotContext;

public class FLActionMouseRelease extends FLMouseButton {

	public FLActionMouseRelease() {
		super();
		
		descriptionSuffix = "mouse released";
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		Robot bot = rc.getRobot();
		
		bot.mouseRelease(mouseButton);
	}
}
