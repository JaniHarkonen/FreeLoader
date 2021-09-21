package freeloader.robot.actions.mouse;

import java.awt.Robot;

import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.values.FLInt;

public class FLActionMouseHold extends FLMouseButton {
	
		// Hold length
	private FLInt length;
	

	public FLActionMouseHold() {
		super();
		
		descriptionSuffix = "mouse held";
		length = new FLInt(0);
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		Robot bot = rc.getRobot();
		
		bot.mousePress(mouseButton);
		
			// Hold interval
		try
		{
			Thread.sleep(length.getValue(rc));
			
		} catch (InterruptedException e) { e.printStackTrace(); }
	}
	

		// Returns a reference to the hold length FLInt
	public FLInt getHoldLength() {
		return length;
	}
}
