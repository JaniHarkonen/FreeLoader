package freeloader.robot.actions.mouse;

import java.awt.MouseInfo;
import java.awt.Point;

import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.FLRobotAction;
import freeloader.robot.actions.values.FLInt;

public class FLActionMouseMove extends FLRobotAction {

		// X-coordinate of the location
	private FLInt locationX;
	
		// Y-coordinate of the location
	private FLInt locationY;
	
		// Enable path plotting
	private boolean enablePathing;
	
	
	public FLActionMouseMove() {
		super();
		
		locationX = new FLInt(0);
		locationY = new FLInt(0);
		enablePathing = false;
		description = "Mouse move";
	}
	
	
		// Moves the mouse to a given location
	@Override
	public void perform(FLRobotContext rc) {
		int lx, ly;
		Point mpos = MouseInfo.getPointerInfo().getLocation();
		
		rc.memoryPut("temp", mpos.x);
		lx = locationX.getValue(rc);
		rc.memoryPut("temp", mpos.y);
		ly = locationY.getValue(rc);
		
		rc.getRobot().mouseMove(lx, ly);
		rc.memoryDelete("temp");
	}
}
