package freeloader.robot.actions.mouse;

import java.awt.Robot;

import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.values.FLInt;

public class FLActionMouseScroll extends FLMouseButton {
	
		// Direction of the scroll (-1 up, 1 down)
	private int direction;
	
		// Number of notches to scroll for
	private FLInt notches;
	
		// Number of times the scroll should be repeated
	private FLInt repeat;
	
		// Interval between scrolls (ms)
	private FLInt interval;
	

	public FLActionMouseScroll() {
		super();
		
		descriptionSuffix = "mouse wheel";
		direction = 0;
		notches = new FLInt(0);
		repeat = new FLInt(0);
		interval = new FLInt(0);
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		Robot bot = rc.getRobot();
		
			// Repeat a given number of times
		int s = repeat.getValue(rc);
		for( int i = 0; i < s; i++ )
		{
			bot.mouseWheel(direction * notches.getValue(rc));
			sleep(interval, rc);
		}
	}
}
