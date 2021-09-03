package freeloader.robot.actions.keyboard;

import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.values.FLInt;

public abstract class FLActionKeyHold extends FLKeyboardKey {
	
		// Length of the hold (ms)
	private FLInt length;
	

	protected FLActionKeyHold() {
		super();
		
		descriptionSuffix = " held";
		length = new FLInt(0);
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		rc.getRobot().keyPress(keyboardKey);
		sleep(length, rc);
	}
}
