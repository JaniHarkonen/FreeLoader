package freeloader.robot.actions;

import java.io.File;
import java.io.IOException;

import freeloader.robot.FLRobotContext;

public class FLActionExec extends FLRobotAction {

		// Path of the program that should be ran
	private String path;
	
		// Description prefix
	private String descriptionPrefix;
	
	
	public FLActionExec() {
		super();
		
		title = "Run program";
		descriptionPrefix = "Run program";
		path = "";
	}
	
	
	@SuppressWarnings("unused")
	@Override
	public void perform(FLRobotContext rc) {
		if( path.equals("") ) return;
		
		try
		{
			Process p = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", path});
		}
		catch (IOException e) { e.printStackTrace(); }
	}
	
	
		// Sets the path of the program to be run
	public void setPath(String p) {
		path = p;
	}
	
		// Returns the path of the program to be run
	public String getPath() {
		return path;
	}
	
		// Updates the action description
	public void updateDescription() {
		File f = new File(path);
		System.out.println("here: " + f.getName());
		setDescription(descriptionPrefix + " " + f.getName());
	}
}
