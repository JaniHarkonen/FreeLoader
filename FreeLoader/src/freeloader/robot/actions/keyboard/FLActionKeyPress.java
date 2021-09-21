package freeloader.robot.actions.keyboard;

import java.awt.Robot;

import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.values.FLInt;

public class FLActionKeyPress extends FLKeyboardKey {
	
		// Number of times to repeat the press
	private FLInt repeat;
	
		// Interval between presses (ms)
	private FLInt interval;
	
		// Length of a press (ms)
	private FLInt length;
	

	public FLActionKeyPress() {
		super();
		
		descriptionSuffix = " pressed";
		repeat = new FLInt(0);
		interval = new FLInt(0);
		length = new FLInt(0);
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		Robot bot = rc.getRobot();
		
		int s = repeat.getValue(rc);
		for( int i = 0; i < s; i++ )
		{
			bot.keyPress(keyboardKey);
			sleep(length, rc);
			bot.keyRelease(keyboardKey);
			sleep(interval, rc);
		}
	}
	
	
		// Returns a reference to the repeat FLInt
	public FLInt getRepeat() {
		return repeat;
	}
	
		// Returns a reference to the interval FLInt
	public FLInt getInterval() {
		return repeat;
	}
	
		// Returns a reference to the press length FLInt
	public FLInt getPressLength() {
		return length;
	}
}
