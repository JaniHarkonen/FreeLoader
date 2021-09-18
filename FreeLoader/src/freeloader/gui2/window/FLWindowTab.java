package freeloader.gui2.window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import freeloader.gui.window.FLElementActionList;
import freeloader.gui2.FLGUIComponent;
import freeloader.gui2.FLGUIContext;
import freeloader.gui2.FLGUIUtilities;
import freeloader.robot.FLRobot;

public class FLWindowTab extends FLGUIComponent {
	
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
		FLWindowSettingsWrapper sets = new FLWindowSettingsWrapper(null);
		
			// Action list
		FLGUIContext ctxt_al = new FLGUIContext();
		ctxt_al.put("actions", bot.getRobotContext().actions);
		ctxt_al.put("settings-panel", sets);
		FLWindowActionList al = new FLWindowActionList(ctxt_al);
		
		/*JPanel jp_sets = new JPanel();
		jp_sets.setLayout(new BorderLayout());
		JButton btn_save = new JButton("Save");
		btn_save.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				saveSettings();
			}
		});*/
		
		//hostContext.guiContext.put("open-settings-panel__" + ownerRobot.getName(), jp_sets);
		
		sp.add(al.render(), JSplitPane.LEFT);
		sp.add(sets.render(), JSplitPane.RIGHT);
		sp.setContinuousLayout(true);
		sp.setDividerLocation(250);
		
		container.add(sp);
		//hostContext.guiContext.put("open-tab-panel", sp);
		return container;
	}
	
		// Upon clicking "Save" in the settings panel
	private void saveSettings() {
		System.out.println("save");
	}
}
