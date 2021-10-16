package freeloader.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.atomic.AtomicInteger;

public class FLRobot {
	
		// Constants for managing robot state
	public static final int STATE_TERMINATED 	= 1;	// The robot loop has been terminated
	public static final int STATE_PAUSED		= 2;	// Execution of actions has been paused, loop on-going
	public static final int STATE_RUNNING		= 3;	// Actions are being executed
	public static final int STATE_FINISHED		= 4;	// Execution of actions has concluded, loop on-going
	

		// Container for members that can be passed onto actions
	private FLRobotContext context;
	
		// Name of the robot
	private String name;
	
		// State of the robot
	private AtomicInteger state;
	
		// Line of the action currently being executed
	private int actionLine;
	
	
	public FLRobot() {
		try
		{
			context = new FLRobotContext(this, new Robot());
		} 
		catch (AWTException e) { e.printStackTrace(); }
		
		actionLine = -1;
		name = "Robot";
		
		state.set(FLRobot.STATE_TERMINATED);
	}
	
		// Continuous loop that will execute the robot actions and
		// idle when done
	private void loop() {
		while( getState() != STATE_TERMINATED )
		{
			int end = context.actions.size();
			while( getState() == STATE_RUNNING && actionLine < end )
			{
				context.actions.get(actionLine).perform(context);
				actionLine ++;
			}
			
			setState(STATE_FINISHED);
		}
	}
	
		// Sets the current robot state thread-safely
	private void setState(int state) {
		this.state.set(state);
	}
	
		// Returns the current robot state thread-safely
	public int getState() {
		return state.get();
	}
	
		// Returns the robot's context
	public FLRobotContext getRobotContext() {
		return context;
	}
	
		// Sets the name of the robot
	public void setName(String name) {
		if( name == null ) return;
		
		this.name = name;
	}
	
		// Returns the name of the robot
	public String getName() {
		return name;
	}
	
		// Moves the execution to a given line
	public void gotoLine(int line) {
		if( line < 0 || line > context.actions.size() - 1 ) return;
		
		actionLine = line;
	}
	
		// Returns the index of the line currently being executed
	public int getLine() {
		return actionLine;
	}
	
	/************************ ROBOT CONTROLS ***************************/
	
		// Resumes the execution loop, returns whether successful
	public boolean resume() {
		if( getState() == STATE_TERMINATED ) return false;
		
		setState(STATE_RUNNING);
		return true;
	}
	
		// Pauses the execution of actions, returns whether successful
	public boolean pause() {
		int state = getState();
		
		if( state == STATE_TERMINATED ) return false;
		if( state == STATE_PAUSED )		return false;
		
		setState(STATE_PAUSED);
		return true;
	}
	
		// Begins running the execution loop from a given line, returns whether successful
	public boolean start(int line) {
		if( getState() != STATE_TERMINATED ) return false;
		
		setState(STATE_RUNNING);
		gotoLine(line);
		loop();
		
		return true;
	}
	
		// Begins running the execution loop from the first line, returns whether successful
	public boolean start() {
		return start(0);
	}
	
		// Stops the execution loop, returns whether successful
	public boolean stop() {
		if( getState() == STATE_TERMINATED ) return false;
		
		setState(STATE_TERMINATED);
		return true;
	}
}
