package freeloader.gui.window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import freeloader.gui.FLGUIComponent;
import freeloader.gui.FLGUIContext;
import freeloader.gui.FLGUIUtilities;
import freeloader.gui.settings.FLNullAction;
import freeloader.gui.settings.FLSettings;
import freeloader.robot.FLRobot;
import freeloader.robot.actions.FLRobotAction;

public class FLWindowSettingsWrapper extends FLGUIComponent {
	
		// Underlying action is being modified
	public static final int STATE_EDITING = 1;
	
		// Underlying action is being added to the action list
	public static final int STATE_ADDING  = 2;
	

		// Currently open robot action
	private FLRobotAction action;
	
		// Reference to the settings pane of the currently open action
	private FLSettings settingsPane;
	
		// Reference to the "saving" button
	private JButton btnSave;
	
		// Operation being performed on the underlying action
	private int state;
	
	
	public FLWindowSettingsWrapper(FLGUIContext c) {
		super(c, false);
		action = null;
		
		state = STATE_EDITING;
	}
	
	
	@Override
	protected JPanel draw() {
		JPanel container = FLGUIUtilities.createBorderedContainer();
		if( action == null ) return container;
		
			// Saving changes
		btnSave = new JButton((state == STATE_EDITING) ? "Save changes" : "Add");
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveChanges();
			}
		});
		
			// Settings pane
		settingsPane = FLGUIUtilities.buildSettings(action);
		container.add(settingsPane.render());
		container.add(btnSave, BorderLayout.PAGE_END);
		return container;
	}
	
	
		// Sets currently open action
	public void openAction(FLRobotAction act) {
		action = act;
		
			// Change button title when adding a new action
		if( act instanceof FLNullAction ) state = STATE_ADDING;
		else 							  state = STATE_EDITING;
		
		render();
	}
	
		// Saves changes to the currently open action
	public void saveChanges() {
		settingsPane.updateAction();
		
			// If adding -> add to robot
		if( state == STATE_ADDING )
		{
			FLWindowTab host = (FLWindowTab) context.get("host");
			FLRobot		bot  = (FLRobot)	 context.get("robot");
			
			int ind = host.getActionList().getActionIndex();
			int max = bot.getRobotContext().actions.size();
			
			if( ind == -1 ) ind = max;
			else ind++;
			
			bot.getRobotContext().actions.add(Math.min(max, ind), settingsPane.getUnderlyingAction());
			host.getActionList().render();
			
			action = null;
			render();
		}
	}
}
