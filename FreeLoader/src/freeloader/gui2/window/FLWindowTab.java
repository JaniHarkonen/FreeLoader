package freeloader.gui2.window;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import freeloader.gui2.FLGUIComponent;
import freeloader.gui2.FLGUIContext;
import freeloader.gui2.FLGUIUtilities;
import freeloader.gui2.settings.FLNullAction;
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
		
		container.add(sp);
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
