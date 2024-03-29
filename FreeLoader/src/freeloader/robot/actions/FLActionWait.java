package freeloader.robot.actions;

import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.values.FLInt;

public class FLActionWait extends FLRobotAction {

		// Number of milliseconds to wait
	private FLInt time;
	
		// Description prefix
	private String descriptionPrefix;
	
	
	public FLActionWait() {
		super();
		
		title = "Wait";
		time = new FLInt(0);
		descriptionPrefix = "Wait ";
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		try
		{
			Thread.sleep(time.getValue(rc));
			
		} catch (InterruptedException e) { e.printStackTrace(); }
	}
	
	
		// Updates the description text
	public void updateDescription() {
		setDescription(descriptionPrefix + time.getUnmoddedValue() + " MS");
	}
	
		// Returns the number of milliseconds that should be waited for
	public FLInt getWaitTime() {
		return time;
	}
}
