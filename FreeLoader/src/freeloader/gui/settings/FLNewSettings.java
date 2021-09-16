package freeloader.gui.settings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import freeloader.FLAppContext;
import freeloader.gui.window.FLElementActionList;
import freeloader.robot.actions.FLActionExec;
import freeloader.robot.actions.FLActionWait;
import freeloader.robot.actions.FLRobotAction;
import freeloader.robot.actions.keyboard.FLActionKeyHold;
import freeloader.robot.actions.keyboard.FLActionKeyPress;
import freeloader.robot.actions.keyboard.FLActionKeyRelease;
import freeloader.robot.actions.keyboard.FLActionType;
import freeloader.robot.actions.mouse.FLActionMouseClick;
import freeloader.robot.actions.mouse.FLActionMouseHold;
import freeloader.robot.actions.mouse.FLActionMouseMove;
import freeloader.robot.actions.mouse.FLActionMouseRelease;
import freeloader.robot.actions.mouse.FLActionMouseScroll;

public class FLNewSettings extends FLSettings {
	
		// Names of all actions
	public static final String[] ACTION_NAMES = {
			"Execute program",
			"Key press",
			"Key hold",
			"Key release",
			"Mouse click",
			"Mouse hold",
			"Mouse move",
			"Mouse release",
			"Mouse scroll",
			"Type",
			"Wait"
	};
	
	public FLNewSettings(FLAppContext host) {
		super(host);
	}
	
	public FLNewSettings(FLAppContext host, FLRobotAction src) {
		super(host, src);
	}
	

	@Override
	public JPanel getElement() {
		JPanel wrapper = createSettingsPane("New action");
		
		JPanel line_act = createLineWrapper();
		JPanel menu_act = createDropMenu("Choose action:  ", ACTION_NAMES, 144);
		
		JComboBox cb_act = getComboBoxFromDropMenu(menu_act);
		Object ind_sel = hostContext.guiContext.get("action-new-selection");
		cb_act.setSelectedIndex((ind_sel != null) ? (int) ind_sel : 0);
		cb_act.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int ind_sel = cb_act.getSelectedIndex();
				selectAction((String) cb_act.getItemAt(ind_sel), wrapper, ind_sel);
			}
		});
		line_act.add(menu_act);
		
		JPanel pane_act_settings = createSettingsPane("Settings");
		if( underlyingAction != null )
		{
			addEmptySpace(pane_act_settings);
			underlyingAction.setDescription((String) cb_act.getItemAt(cb_act.getSelectedIndex()));
			pane_act_settings.add(buildSettings(underlyingAction, hostContext).getElement());
		}
		
		JPanel line_opt = createLineWrapper();
		
		JPanel btn_container = new JPanel();
		
		JButton btn_add = new JButton("Add");
		btn_add.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				addAction();
			}
		});
		
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				cancelNewAction();
			}
		});
		
		btn_container.add(btn_add);
		btn_container.add(new JLabel("   "));
		btn_container.add(btn_cancel);
		
		line_opt.add(btn_container);
		
		wrapper.add(line_act);
		addEmptySpace(wrapper, 2);
		wrapper.add(pane_act_settings);
		addEmptySpace(wrapper, 2);
		wrapper.add(line_opt);
		return wrapper;
	}
	
		// Selects a RobotAction from the drop menu
	private void selectAction(String name, JPanel jp, int index) {
		FLRobotAction newact = getActionByString(name);
		setAction(newact);
		hostContext.guiContext.put("selected-action-index", -1);
		hostContext.guiContext.put("action-new-selection", index);
		hostContext.setSelectedActionSettings(this);
	}
	
		// Adds the action to the current robot
	private void addAction() {
		hostContext.getSelectedRobot().getRobotContext().actions.add(underlyingAction);
		
		FLElementActionList actlist = (FLElementActionList) hostContext.guiContext.get("action-list");
		JPanel jp_actlist = (JPanel) hostContext.guiContext.get("action-list-panel");
		jp_actlist.removeAll();
		jp_actlist.add(actlist.getElement());
		jp_actlist.revalidate();
		jp_actlist.repaint();
		//JPanel tab = hostContext.guiContext.get("open-tab-panel");
		//hostContext.guiContext.get(id)
	}
	
		// Cancels the addition of a new action
	private void cancelNewAction() {
		
	}
	
		// Returns a RobotAction by name
	private FLRobotAction getActionByString(String name) {
		switch( name )
		{
			case "Execute program": return new FLActionExec();
			case "Key press": return new FLActionKeyPress();
			case "Key hold": return new FLActionKeyHold();
			case "Key release": return new FLActionKeyRelease();
			case "Mouse click": return new FLActionMouseClick();
			case "Mouse hold": return new FLActionMouseHold();
			case "Mouse move": return new FLActionMouseMove();
			case "Mouse release": return new FLActionMouseRelease();
			case "Mouse scroll": return new FLActionMouseScroll();
			case "Type": return new FLActionType();
			case "Wait": return new FLActionWait();
		}
		
		return null;
	}
}
