package freeloader.gui.settings;

import freeloader.robot.actions.FLRobotAction;

/**
 * A null RobotAction class designed to differentiate between
 * 'null' object and undefined action.
 * @author Joe
 *
 */
public class FLNullAction extends FLRobotAction {

	/**
	 * Constructs a null robot action.
	 */
	public FLNullAction() {
		super();
	}
}
