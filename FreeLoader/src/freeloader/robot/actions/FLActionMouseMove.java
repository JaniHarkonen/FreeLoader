package freeloader.robot.actions;

import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.values.FLInt;

public class FLActionMouseMove extends FLRobotAction {

		// X-coordinate of the location
	private FLInt locationX;
	
		// Y-coordinate of the location
	private FLInt locationY;
	
	
	public FLActionMouseMove() {
		super();
		
		locationX = new FLInt(0);
		locationY = new FLInt(0);
	}
	
	
		// Moves the mouse to a given location
	@Override
	public void perform(FLRobotContext rc) {
		rc.getRobot().mouseMove(locationX.getValue(rc), locationY.getValue(rc));
	}
}
