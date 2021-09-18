package freeloader.gui2.settings.mouse;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import freeloader.gui2.FLGUIContext;
import freeloader.gui2.FLGUIUtilities;
import freeloader.gui2.settings.FLSettings;
import freeloader.gui2.sub.FLSubInputField;
import freeloader.robot.actions.mouse.FLActionMouseClick;

public class FLSettingsMouseClick extends FLSettings {
	
		// (swing) SPINNER - Number of clicks
	private JSpinner sNumberOfClicks;
	
		// INPUT FIELD - Click interval
	private FLSubInputField ifClickInterval;
	
		// (swing) CHECK BOX - Randomize clicks
	private JCheckBox cbRandomizeClicks;
	
		// INPUT FIELD - Click variance
	private FLSubInputField ifClickVariance;
	
		// (swing) CHECK BOX - Randomize click length
	private JCheckBox cbRandomizeClickLength;
	
	
	public FLSettingsMouseClick(FLGUIContext c) {
		super(c);
	}
	

	@Override
	public JPanel draw() {
		FLActionMouseClick act = (FLActionMouseClick) context.get("action");
		JPanel container = createSettingsContainer();
		
			// Click behavior
		JPanel pane_bhv = FLGUIUtilities.createSettingsPane("Behavior");
		
			// Number of clicks
		JPanel line_repeat = FLGUIUtilities.createLineContainer();
		sNumberOfClicks = new JSpinner();
		sNumberOfClicks.setModel(new SpinnerNumberModel(Math.max(1, act.getRepeat()), 1, Integer.MAX_VALUE, 1));
		sNumberOfClicks.setMaximumSize(new Dimension(64, sNumberOfClicks.getPreferredSize().height));
		
		line_repeat.add(new JLabel("Clicks in a row: "));
		line_repeat.add(sNumberOfClicks);
		line_repeat.setMaximumSize(new Dimension(Integer.MAX_VALUE, line_repeat.getPreferredSize().height));
		
			// Click interval
		JPanel line_intr_click = FLGUIUtilities.createLineContainer();
		ifClickInterval = new FLSubInputField(this, "Click interval (MS):  ");
		line_intr_click.add(ifClickInterval.render());
		
			// Click interval variance
		ifClickVariance = new FLSubInputField(this, "  VARIANCE:  ");
		ifClickVariance.textField.setEnabled(false);
		
			// Randomize click interval
		cbRandomizeClicks = new JCheckBox("Randomize");
		cbRandomizeClicks.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				ifClickVariance.textField.setEnabled(!ifClickVariance.textField.isEnabled());
			}
		});
		line_intr_click.add(ifClickVariance.render());
		line_intr_click.add(cbRandomizeClicks);
		
			// Randomize click length
		JPanel line_randlen = FLGUIUtilities.createLineContainer();
		cbRandomizeClickLength = new JCheckBox("Randomize click length");
		line_randlen.add(cbRandomizeClickLength);
		
		pane_bhv.add(line_repeat);
		FLGUIUtilities.addEmptySpace(pane_bhv);
		pane_bhv.add(line_intr_click);
		pane_bhv.add(line_randlen);
		FLGUIUtilities.addEmptySpace(pane_bhv);
		
		//container.add(createMouseButtonDropMenu());
		FLGUIUtilities.addEmptySpace(container);
		container.add(pane_bhv);
		return container;
	}
	
	@Override
	public void updateAction() {
		FLActionMouseClick act = (FLActionMouseClick) context.get("action");
		act.setRepeat((int) sNumberOfClicks.getValue());
	}
}
