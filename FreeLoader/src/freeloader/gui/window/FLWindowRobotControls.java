package freeloader.gui.window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import freeloader.gui.FLGUIComponent;
import freeloader.gui.FLGUIContext;
import freeloader.gui.FLGUIUtilities;
import freeloader.gui.robotmanager.FLRobotManager;
import freeloader.robot.FLRobot;

public class FLWindowRobotControls extends FLGUIComponent {

	public FLWindowRobotControls(FLGUIContext c) {
		super(c);
	}
	
	
	@Override
	public JPanel draw() {
		FLRobot bot = (FLRobot) context.get("robot");
		
		if( bot == null ) return new JPanel();
		
		JPanel container = FLGUIUtilities.createBorderedContainer();
		
		JPanel pane = FLGUIUtilities.createSettingsPane("Robot controls");
		
		JPanel line_ctrl = FLGUIUtilities.createLineContainer();
		
		JButton btn_run;
		
			// Run/resume robot
		if( bot.checkTerminated() )
		btn_run = createButton("Run", () -> { onRun(); });
		else
		btn_run = createButton("Resume", () -> { onResume(); });
		
			// Run robot starting from selected action
		JButton btn_run_sel = createButton(
			"Run from selected action",
			() -> {
				onRunFromAction(((FLWindowActionList) context.get("action-list")).getActionIndex());
			}
		);
		
			// Pause robot
		JButton btn_pause = createButton("Pause", () -> { onPause(); });
		
			// Stop robot
		JButton btn_stop = createButton("STOP", () -> { onStop(); });
		
		
		line_ctrl.add(btn_run);
		FLGUIUtilities.addEmptySpace(line_ctrl, 12);
		
		if( bot.checkTerminated() )
		{
			line_ctrl.add(btn_run_sel);
			FLGUIUtilities.addEmptySpace(line_ctrl, 12);
		}
		
		line_ctrl.add(btn_pause);
		FLGUIUtilities.addEmptySpace(line_ctrl, 12);
		line_ctrl.add(btn_stop);
		
		pane.add(line_ctrl);
		
		container.add(pane);
		return container;
	}
	
		// Creates a button that executes a given lambda function upon click
	private JButton createButton(String caption, Runnable click) {
		if( caption == null || click == null ) return null;
		
		JButton btn = new JButton(caption);
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				click.run();
			}
		});
		
		return btn;
	}
	
		// Called upon running a robot
	public void onRun() {
		FLRobot robot = (FLRobot) context.get("robot");
		
		if( robot == null ) return;
		
		FLRobotManager.startRobot(robot.getName(), robot);
		render();
	}
	
		// Called upon running a robot from selected action
	public void onRunFromAction(int line) {
		FLRobot robot = (FLRobot) context.get("robot");
		
		if( robot == null ) return;
		if( line < 0 || line >= robot.getRobotContext().actions.size() ) return;
		
		FLRobotManager.startRobotFromLine(robot.getName(), robot, line);
		render();
	}
	
		// Called upon resuming a robot that was paused
	public void onResume() {
		FLRobot robot = (FLRobot) context.get("robot");
		
		if( robot == null ) return;
		
		FLRobotManager.resumeRobot(robot.getName());
		render();
	}
	
		// Called upon pausing a robot
	public void onPause() {
		FLRobot robot = (FLRobot) context.get("robot");
		
		if( robot == null ) return;
		
		FLRobotManager.pauseRobot(robot.getName());
		render();
	}
	
		// Called upon stopping a robot
	public void onStop() {
		FLRobot robot = (FLRobot) context.get("robot");
		
		if( robot == null ) return;
		
		FLRobotManager.stopRobot(robot.getName());
		render();
	}
}
