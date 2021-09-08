package freeloader.gui.window;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import freeloader.FLAppContext;
import freeloader.FLGuiContext;

public class FLElementToolbar extends FLElement {
	
	public FLElementToolbar(FLAppContext host) {
		super(host);
	}
	

	@Override
	public Component getElement() {
		JPanel container = new JPanel();
		FlowLayout fl = new FlowLayout();
		fl.setVgap(0);
		container.setLayout(fl);
		
		addOption(container, "Add action", () -> { OPTIONaddAction(); });
		addOption(container, "Remove action", () -> { OPTIONremoveAction(); });
		addOption(container, "Add robot", () -> { OPTIONaddRobot(); });
		addOption(container, "Delete robot", () -> { OPTIONdeleteRobot(); });
		
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
		
	}
	
		// OPTION: Remove action
	private void OPTIONremoveAction() {
		FLGuiContext guic = hostContext.guiContext;
		
			// Remove action from the host robot
		int index = (int) guic.get("selected-action-index");
		hostContext.getSelectedRobot().getRobotContext().actions.remove(index);
		
			// Remove action from the action list
		JPanel jp = (JPanel) guic.get("action-list-panel");
		jp.removeAll();
		jp.add(((FLElementActionList) guic.get("action-list")).getElement());
		jp.revalidate();
		jp.repaint();
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