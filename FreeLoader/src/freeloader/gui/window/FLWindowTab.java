package freeloader.gui.window;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import freeloader.gui.FLGUIComponent;
import freeloader.gui.FLGUIContext;
import freeloader.gui.FLGUIUtilities;
import freeloader.gui.settings.FLNullAction;
import freeloader.robot.FLRobot;

public class FLWindowTab extends FLGUIComponent {
	
		// Reference to the action list of the robot whose tab this is
	private FLWindowActionList actionList;
	
		// Reference to the settings panel
	private FLWindowSettingsWrapper settingsPanel;
	
	
	public FLWindowTab(FLGUIContext c) {
		super(c, false);
	}
	

	@Override
	public JPanel draw() {
		FLRobot bot = (FLRobot) context.get("selected-robot");
		JPanel container = FLGUIUtilities.createBorderedContainer();
		
			// Return an empty container if no robot has been selected
		if( bot == null ) return container;
		
			// Create a split pane with action list on the left and currently
			// open action on the right
		JSplitPane sp = new JSplitPane(SwingConstants.VERTICAL);
		
			// Settings panel
		FLGUIContext ctxt_spanel = new FLGUIContext();
		ctxt_spanel.put("host", this);
		ctxt_spanel.put("robot", bot);
		settingsPanel = new FLWindowSettingsWrapper(ctxt_spanel);
		
			// Action list
		FLGUIContext ctxt_al = new FLGUIContext();
		ctxt_al.put("actions", bot.getRobotContext().actions);
		ctxt_al.put("host", this);
		actionList = new FLWindowActionList(ctxt_al);
		
		sp.add(actionList.render(), JSplitPane.LEFT);
		sp.add(settingsPanel.render(), JSplitPane.RIGHT);
		sp.setContinuousLayout(true);
		sp.setDividerLocation(250);
		
			// Robot controls
		FLGUIContext ctxt_ctrl = new FLGUIContext();
		ctxt_ctrl.put("robot", bot);
		ctxt_ctrl.put("action-list", actionList);
		FLWindowRobotControls ctrl = new FLWindowRobotControls(ctxt_ctrl);
		
		container.add(sp);
		container.add(ctrl.render(), BorderLayout.PAGE_END);
		return container;
	}
	
		// Opens the action addition panel
	public void addAction() {
		settingsPanel.openAction(new FLNullAction());
	}
	
		// Removes selected robot action from the currently open robot
	public void removeAction() {
		actionList.removeAction();
	}
	
		// Returns a reference to the settings panel
	public FLWindowSettingsWrapper getSettingsPanel() {
		return settingsPanel;
	}
	
		// Returns a reference to the action list
	public FLWindowActionList getActionList() {
		return actionList;
	}
}
