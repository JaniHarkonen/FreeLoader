package freeloader.gui.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import freeloader.gui.FLGUIComponent;
import freeloader.gui.FLGUIContext;
import freeloader.gui.FLGUIUtilities;
import freeloader.robot.FLRobot;

public class FLWindowRobotControls extends FLGUIComponent {

	public FLWindowRobotControls(FLGUIContext c) {
		super(c);
	}
	
	
	@Override
	public JPanel draw() {
		JPanel container = FLGUIUtilities.createBorderedContainer();
		
		JPanel pane = FLGUIUtilities.createSettingsPane("Robot controls");
		
		JPanel line_ctrl = FLGUIUtilities.createLineContainer();
		
			// Run robot
		JButton btn_run = new JButton("Run");
		btn_run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRun();
			}
		});
		
			// Run robot starting from selected action
		JButton btn_run_sel = new JButton("Run from selected action");
		btn_run_sel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRunFromAction(((FLWindowActionList) context.get("action-list")).getActionIndex());
			}
		});
		
			// Pause robot
		JButton btn_pause = new JButton("Pause");
		btn_pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onPause();
			}
		});
		
			// Stop robot
		JButton btn_stop = new JButton("STOP");
		btn_stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onStop();
			}
		});
		
		line_ctrl.add(btn_run);
		FLGUIUtilities.addEmptySpace(line_ctrl, 12);
		line_ctrl.add(btn_run_sel);
		FLGUIUtilities.addEmptySpace(line_ctrl, 12);
		line_ctrl.add(btn_pause);
		FLGUIUtilities.addEmptySpace(line_ctrl, 12);
		line_ctrl.add(btn_stop);
		
		pane.add(line_ctrl);
		
		container.add(pane);
		return container;
	}
	
		// Called upon running a robot
	public void onRun() {
		FLRobot robot = (FLRobot) context.get("robot");
		
		if( robot == null ) return;
		
		robot.runFromStart();
	}
	
		// Called upon running a robot from selected action
	public void onRunFromAction(int line) {
		FLRobot robot = (FLRobot) context.get("robot");
		
		if( robot == null ) return;
		if( line < 0 || line >= robot.getRobotContext().actions.size() ) return;
		
		robot.gotoLine(line);
		robot.run();
	}
	
		// Called upon pausing a robot
	public void onPause() {
		FLRobot robot = (FLRobot) context.get("robot");
		
		if( robot == null ) return;
	}
	
		// Called upon stopping a robot
	public void onStop() {
		FLRobot robot = (FLRobot) context.get("robot");
		
		if( robot == null ) return;
	}
}
