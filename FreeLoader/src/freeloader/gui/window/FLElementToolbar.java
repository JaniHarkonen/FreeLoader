package freeloader.gui.window;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import freeloader.gui.FLWindow;

public class FLElementToolbar extends FLElement {
	
	public FLElementToolbar(FLWindow host) {
		super(host);
	}
	

	@Override
	public Component getElement() {
		JPanel container = new JPanel();
		FlowLayout fl = new FlowLayout();
		fl.setVgap(0);
		container.setLayout(fl);
		
		addOption(container, "Add action", () -> { System.out.println("add action"); });
		addOption(container, "Remove action", () -> { System.out.println("remove action"); });
		addOption(container, "Add robot", () -> { System.out.println("add robot"); });
		
		return container;
	}
	
		// Adds a JButton representing an option to a given JPanel
	private void addOption(JPanel jp, String caption, Runnable action) {
		JButton btn = new JButton(caption);
		btn.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent evt) {
				action.run();
			}
		});
		
		jp.add(btn);
	}
}