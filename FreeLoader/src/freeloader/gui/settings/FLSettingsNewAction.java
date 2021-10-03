package freeloader.gui.settings;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import freeloader.gui.FLGUIContext;
import freeloader.gui.FLGUIUtilities;
import freeloader.gui.sub.FLSubDropDownMenu;
import freeloader.robot.actions.FLActionExec;
import freeloader.robot.actions.FLActionWait;
import freeloader.robot.actions.FLRobotAction;
import freeloader.robot.actions.keyboard.FLActionKeyHold;
import freeloader.robot.actions.keyboard.FLActionKeyPress;
import freeloader.robot.actions.keyboard.FLActionKeyRelease;
import freeloader.robot.actions.mouse.FLActionMouseClick;
import freeloader.robot.actions.mouse.FLActionMouseHold;
import freeloader.robot.actions.mouse.FLActionMouseMove;
import freeloader.robot.actions.mouse.FLActionMouseRelease;
import freeloader.robot.actions.mouse.FLActionMouseScroll;

public class FLSettingsNewAction extends FLSettings {

		// DROP-DOWN MENU - Robot action
	private FLSubDropDownMenu ddRobotAction;
	
		// Index of the selected robot action
	private int robotActionIndex;
	
		// List of available actions
	private FLSettingActionBundle[] bundles = {
			new FLSettingActionBundle(new FLActionMouseMove()),
			new FLSettingActionBundle(new FLActionMouseClick()),
			new FLSettingActionBundle(new FLActionMouseHold()),
			new FLSettingActionBundle(new FLActionMouseRelease()),
			new FLSettingActionBundle(new FLActionMouseScroll()),
			
			new FLSettingActionBundle(new FLActionKeyPress()),
			new FLSettingActionBundle(new FLActionKeyHold()),
			new FLSettingActionBundle(new FLActionKeyRelease()),
			
			new FLSettingActionBundle(new FLActionExec()),
			new FLSettingActionBundle(new FLActionWait())
	};
	
	
	public FLSettingsNewAction(FLGUIContext c) {
		super(c);
		
		robotActionIndex = 0;
	}
	
	
	@Override
	protected JPanel draw() {
		
			// Actions available for selection
		
		
		JPanel container = createSettingsContainer();
		
			// Robot action selection
		JPanel line_act = FLGUIUtilities.createLineContainer();
		
		String[] ch = buildTitleArray(bundles);
		ddRobotAction = new FLSubDropDownMenu(this, "Robot action:  ", ch);
		ddRobotAction.dropDownMenu.setSelectedIndex(robotActionIndex);
		ddRobotAction.dropDownMenu.setMaximumSize(new Dimension(128, ddRobotAction.dropDownMenu.getPreferredSize().height));
		
		ddRobotAction.dropDownMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//System.out.println(ddRobotAction.dropDownMenu.getSelectedIndex());
				onActionChange(ddRobotAction.dropDownMenu.getSelectedIndex());
			}
		});
		line_act.add(ddRobotAction.render());
		
		
			// Settings panel for the action
		JPanel box_sets = FLGUIUtilities.createBoxContainer(BoxLayout.PAGE_AXIS);
		
		
		box_sets.add(bundles[robotActionIndex].setting.render());
		
		
		container.add(line_act);
		FLGUIUtilities.addEmptySpace(container, 3);
		container.add(box_sets);
		
		return container;
	}
	
	@Override
	public void updateAction() {
		bundles[robotActionIndex].setting.updateAction();
	}
	
	@Override
	public FLRobotAction getUnderlyingAction() {
		return bundles[robotActionIndex].action;
	}
	
	
		// Called upon changing the robot action
	public void onActionChange(int index) {
		robotActionIndex = index;
		
		render();
	}
	
		// Creates an array of the titles of available robot actions
	private String[] buildTitleArray(FLSettingActionBundle[] bundles) {
		String[] arr = new String[bundles.length];
		
		for( int i = 0; i < bundles.length; i++ )
		arr[i] = bundles[i].action.getTitle();
		
		return arr;
	}
}
