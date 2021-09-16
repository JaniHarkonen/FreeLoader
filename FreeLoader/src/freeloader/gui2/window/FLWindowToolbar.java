package freeloader.gui2.window;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import freeloader.gui2.FLGUIComponent;
import freeloader.gui2.FLGUIContext;

public class FLWindowToolbar extends FLGUIComponent {
	
	public FLWindowToolbar(FLGUIContext c) {
		super(c, false);
	}
	

	@Override
	protected JPanel draw() {
		JPanel container = new JPanel();
		FlowLayout fl = new FlowLayout();
		fl.setVgap(0);
		container.setLayout(fl);
		
		addOption(container, "Add action"	,	() -> { OPTIONaddAction		(); });
		addOption(container, "Remove action", 	() -> { OPTIONremoveAction	(); });
		addOption(container, "Add robot"	, 	() -> { OPTIONaddRobot		(); });
		addOption(container, "Delete robot"	, 	() -> { OPTIONdeleteRobot	(); });
		
		return container;
	}
	
		// Adds a JButton representing an option to a given JPanel
	private void addOption(JPanel jp, String caption, Runnable action) {
		JButton btn = new JButton(caption);
		btn.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent evt) {
				action.run();
			}
		});
		
		jp.add(btn);
	}
	
		// OPTION: Add action
	private void OPTIONaddAction() {
		System.out.println("add action");
	}
	
		// OPTION: Remove action
	private void OPTIONremoveAction() {
		System.out.println("remove action");
	}
	
		// OPTION: Add robot
	private void OPTIONaddRobot() {
		System.out.println("add robot");
	}
	
		// OPTION: Delete robot
	private void OPTIONdeleteRobot() {
		System.out.println("delete robot");
	}
}