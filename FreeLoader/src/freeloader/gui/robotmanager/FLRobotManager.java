package freeloader.gui.robotmanager;

import java.util.HashMap;
import java.util.Map;

import freeloader.robot.FLRobot;

/**
 * This class is NOT to be instantiated as it is the class used to
 * control all the robots present in FreeLoader. Each project utilizing
 * the JOHNBots should have its own robot manager class though no
 * parent class has been created due to potentially widely different
 * implementations.
 * 
 * @author Johnny
 *
 */
public class FLRobotManager {
	
		/**
		 * Map managed robots coupled with their handle identifiers.
		 */
	private static final Map<String, FLRobotManagerEntry> robots = new HashMap<String, FLRobotManagerEntry>();

		// DO NOT instantiate
	private FLRobotManager() {
	}
	
	
		/**
		 * Starts running a robot and assigns it a handle identifier that
		 * can be used to later reference it. The execution is started from the
		 * first line.
		 * @param id Handle identifier used to access the robot and its thread.
		 * @param robot Robot that is to be ran.
		 */
	public static void startRobot(String id, FLRobot robot) {
		startRobotFromLine(id, robot, -1);
	}
	
		/**
		 * Starts running a robot and assigns it a handle identifier that
		 * can be used to later reference it. The execution is started from a
		 * given line
		 * @param id Handle identifier used to access the robot and its thread.
		 * @param robot Robot that is to be ran.
		 * @param line Line to start the execution from.
		 */
	public static void startRobotFromLine(String id, FLRobot robot, int line) {
		FLRobotManagerEntry me = robots.get(id);
		
		if( robot.checkRunning() ) return;
		
		if( me == null )
		{
			robot.gotoLine(line);
			robot.resume();
			
			Thread t = new Thread() {
				
				@Override
				public void run() {
					robot.loop();
				}
			};
			
			me = new FLRobotManagerEntry(t, robot);
			robots.put(id, me);
			t.start();
		}
		else
		{
			me.robot.gotoLine(line);
			me.robot.resume();
			me.thread.start();
		}
	}
	
	/**
	 * Pauses the execution of a robot given its handle identifier.
	 * @param id Handle identifier to access the robot.
	 */
	public static void pauseRobot(String id) {
		FLRobotManagerEntry me = robots.get(id);
		
		if( me == null ) return;
		
		me.robot.stop();
	}
	
		/**
		 * Resumes the execution of a robot given its handle identifier.
		 * @param id Handle identifier to access the robot.
		 */
	public static void resumeRobot(String id) {
		FLRobotManagerEntry me = robots.get(id);
		
		if( me == null ) return;
		if( me.thread == null ) return;
		
		me.robot.resume();
	}
	
	/**
	 * Stops the execution of a robot given its handle identifier and
	 * resets the execution line to the beginning. The handle identifier as
	 * well as the manager entry object will be removed from the 'robots'
	 * map.
	 * @param id Handle identifier to access the robot.
	 */
	public static void stopRobot(String id) {
		FLRobotManagerEntry me = robots.get(id);
		
		if( me == null ) return;
		
		me.robot.gotoLine(-1);
		me.robot.stop();
		me.robot.terminate();
		
		robots.remove(id);
	}
}
