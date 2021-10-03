package freeloader.gui.settings;

import freeloader.gui.FLGUIUtilities;
import freeloader.robot.actions.FLRobotAction;

/**
 * Container class for a RobotAction and its settings panel.
 * @author User
 *
 */
public class FLSettingActionBundle {

	/**
	 * Settings panel for the robot action.
	 */
	public FLSettings setting;
	
	/**
	 * Action represented by the settings panel.
	 */
	public FLRobotAction action;
	
	
	/**
	 * Constructs a blank setting-action bundle.
	 */
	public FLSettingActionBundle() {
		this.setting = null;
		this.action = null;
	}
	
	/**
	 * Constructs a setting-action bundle containing a given
	 * settings panel and RobotAction.
	 * @param setting Settings panel for the action.
	 * @param action Action represented by the settings panel.
	 */
	public FLSettingActionBundle(FLSettings setting, FLRobotAction action) {
		this.setting = setting;
		this.action = action;
	}
	
	/**
	 * Constructs a setting-action bundle using only a RobotAction. The settings
	 * panel will then be generated with FLGUIUtilities.buildSettings(FLRobotAction).
	 * @param action Action from which to derive the settings panel.
	 */
	public FLSettingActionBundle(FLRobotAction action) {
		this.action = action;
		this.setting = FLGUIUtilities.buildSettings(action);
	}
}
