package freeloader.robot.actions.keyboard;

import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.values.FLInt;

public class FLActionKeyHold extends FLKeyboardKey {
	
		// Length of the hold (ms)
	private FLInt length;
	

	public FLActionKeyHold() {
		super();
		
		descriptionSuffix = " held";
		length = new FLInt(0);
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		rc.getRobot().keyPress(keyboardKey);
		sleep(length, rc);
	}
	
	
		// Returns a reference to the length FLInt
	public FLInt getHoldLength() {
		return length;
	}
}
