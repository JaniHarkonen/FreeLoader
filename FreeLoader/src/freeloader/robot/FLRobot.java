package freeloader.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import freeloader.robot.actions.FLRobotAction;

public class FLRobot {
	
		// Container for members that can be passed onto actions
	private FLRobotContext context;
	
		// Action line currently being executed
	private int actionLine;
	
		// Whether the robot is currently running
	private AtomicBoolean isRunning;
	
		// Whether the endless loop should be stopped (multi-threading only)
	private AtomicBoolean isTerminated;
	
		// Name of the robot
	private String name;

	
	public FLRobot() {
		try
		{
			context = new FLRobotContext(this, new Robot());
		} 
		catch (AWTException e) { e.printStackTrace(); }
		
		actionLine = -1;
		name = "Robot";
		
		isRunning = new AtomicBoolean(false);
		isTerminated = new AtomicBoolean(true);
	}
	
		// Runs the robot executing all actions starting from current
		// action line
	public void run() {
		int end = context.actions.size();
		
		while( isRunning.get() == true && actionLine < end )
		tick();
	}
	
		// Runs the robot in an endless loop (useful when multi-threading)
	public void loop() {
		while( isTerminated.get() == false )
		run();
	}
	
		// Advances to the next action and executes it
	public void tick() {
		actionLine++;
		context.actions.get(actionLine).perform(context);
	}
	
		// Runs the robot starting from the first action
	public void start() {
		gotoLine(-1);
		isRunning.set(true);
		isTerminated.set(false);
		run();
	}
	
		// Resumes the robot
	public void resume() {
		isRunning.set(true);
		isTerminated.set(false);
	}
	
		// Stops the execution of the robot
	public void stop() {
		isRunning.set(false);
	}
	
		// Terminates the endless loop (useful when multi-threading)
	public void terminate() {
		isTerminated.set(true);
	}
	
		// Jumps to a given action
	public void gotoLine(int line) {
		actionLine = line;
	}
	
		// Returns the line of the current action
	public int getLine() {
		return actionLine;
	}
	
		// Returns this robot's RobotContext
	public FLRobotContext getRobotContext() {
		return context;
	}
	
		// Sets the name of the robot
	public void setName(String n) {
		name = n;
	}
	
		// Returns the name of the robot
	public String getName() {
		return name;
	}
	
		// Sets the action set of the robot
	public void setActions(ArrayList<FLRobotAction> act) {
		context.actions = act;
	}
	
		// Returns whether the robot is running
	public boolean checkRunning() {
		return isRunning.get();
	}
	
		// Returns whether the robot has been terminated
	public boolean checkTerminated() {
		return isTerminated.get();
	}
}
