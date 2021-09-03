package freeloader.robot.actions;

import java.io.IOException;

import freeloader.robot.FLRobotContext;

public class FLActionExec extends FLRobotAction {

		// Path of the program that should be ran
	private String path;
	
	
	public FLActionExec() {
		super();
		
		description = "Run program";
		path = "";
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		if( path.equals("") ) return;
		
		try
		{
			Process p = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", path});
		}
		catch (IOException e) { e.printStackTrace(); }
	}
}
