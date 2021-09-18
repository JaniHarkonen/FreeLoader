package freeloader.gui2.window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import freeloader.gui2.FLGUIComponent;
import freeloader.gui2.FLGUIContext;
import freeloader.gui2.FLGUIUtilities;
import freeloader.gui2.settings.FLSettings;
import freeloader.robot.actions.FLRobotAction;

public class FLWindowSettingsWrapper extends FLGUIComponent {

		// Currently open robot action
	private FLRobotAction action;
	
		// Reference to the settings pane of the currently open action
	private FLSettings settingsPane;
	
	
	public FLWindowSettingsWrapper(FLGUIContext c) {
		super(c, false);
		action = null;
	}
	
	
	@Override
	public JPanel draw() {
		JPanel container = FLGUIUtilities.createBorderedContainer();
		if( action == null ) return container;
		
		JButton btn_save = new JButton("Save changes");
		btn_save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveChanges();
			}
		});
		
		settingsPane = FLGUIUtilities.buildSettings(action);
		container.add(settingsPane.render());
		container.add(btn_save, BorderLayout.PAGE_END);
		return container;
	}
	
	
		// Sets currently open action
	public void openAction(FLRobotAction act) {
		action = act;
		render();
	}
	
		// Saves changes to the currently open action
	public void saveChanges() {
		settingsPane.updateAction();
	}
}
