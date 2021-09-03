package freeloader.robot.actions.mouse;

import java.awt.Robot;

import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.values.FLInt;

public class FLActionMouseClick extends FLMouseButton {
	
		// Number of times the click should be repeated
	private FLInt repeat;
	
		// Interval between clicks (ms)
	private FLInt interval;
	
		// Length of a click (ms)
	private FLInt length;
	

	public FLActionMouseClick() {
		super();
		
		descriptionSuffix = "mouse clicked";
		repeat = new FLInt(0);
		interval = new FLInt(0);
		length = new FLInt(0);
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		Robot bot = rc.getRobot();
		
			// Repeat a given number of times
		int s = repeat.getValue(rc);
		for( int i = 0; i < s; i++ )
		{
			bot.mousePress(mouseButton);
			sleep(length, rc);
			bot.mouseRelease(mouseButton);
			sleep(interval, rc);
		}
	}
}
