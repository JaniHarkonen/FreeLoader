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
import freeloader.gui2.sub.FLSubInputField;
import freeloader.gui2.sub.FLSubTogglerCheckBox;
import freeloader.robot.actions.mouse.FLActionMouseClick;
import freeloader.robot.actions.values.FLInt;

public class FLSettingsMouseClick extends FLSettingsMouse {
	
		// Default click length (MS)
	public static final int DEFAULT_CLICK_LENGTH = 16;
	
		// Default click length when randomized (MS)
	public static final int DEFAULT_CLICK_LENGTH_RANDOMIZED = 100;
	
		// Default click length variance (MS)
	public static final int DEFAULT_CLICK_LENGTH_VARIANCE = 90;
	
	
		// (swing) SPINNER - Number of clicks
	private JSpinner sNumberOfClicks;
	
		// INPUT FIELD - Click interval
	private FLSubInputField ifClickInterval;
	
		// TOGGLER CHECK BOX - Randomize clicks
	private FLSubTogglerCheckBox tglRandomizeClicks;
	
		// INPUT FIELD - Click variance
	private FLSubInputField ifClickVariance;
	
		// (swing) CHECK BOX - Randomize click length
	private JCheckBox cbRandomizeClickLength;
	
	
	public FLSettingsMouseClick(FLGUIContext c) {
		super(c);
	}
	

	@Override
	public JPanel draw() {
		
			// Get values
		FLActionMouseClick act = (FLActionMouseClick) context.get("action");
		int v_rep = act.getRepeat().getUnmoddedValue();
		
		FLInt intr_f = act.getInterval();
		int v_intr = intr_f.getUnmoddedValue();
		int v_intr_var = intr_f.getErrorMargin();
		
		boolean v_intr_isrnd = intr_f.getRandomized();
		boolean v_len_isrnd = act.getClickLength().getRandomized();
		
		JPanel container = createSettingsContainer();
		
			// Mouse button selection
		createMouseButtonMenu();
		
			// Click behavior
		JPanel pane_bhv = FLGUIUtilities.createSettingsPane("Behavior");
		
			// Number of clicks
		JPanel line_repeat = FLGUIUtilities.createLineContainer();
		sNumberOfClicks = new JSpinner();
		sNumberOfClicks.setModel(new SpinnerNumberModel(Math.max(1, v_rep), 1, Integer.MAX_VALUE, 1));
		sNumberOfClicks.setMaximumSize(new Dimension(64, sNumberOfClicks.getPreferredSize().height));
		
		line_repeat.add(new JLabel("Clicks in a row: "));
		line_repeat.add(sNumberOfClicks);
		line_repeat.setMaximumSize(new Dimension(Integer.MAX_VALUE, line_repeat.getPreferredSize().height));
		
			// Click interval
		JPanel line_intr_click = FLGUIUtilities.createLineContainer();
		ifClickInterval = new FLSubInputField(this, "Click interval (MS):  ");
		ifClickInterval.textField.setText(Integer.toString(v_intr));
		line_intr_click.add(ifClickInterval.render());
		
			// Click interval variance
		ifClickVariance = new FLSubInputField(this, "  VARIANCE:  ");
		ifClickVariance.textField.setEnabled(v_intr_isrnd);
		ifClickVariance.textField.setText(Integer.toString(v_intr_var));
		
			// Randomize click interval
		tglRandomizeClicks = new FLSubTogglerCheckBox(this, "Randomize", ifClickVariance.textField, false);
		line_intr_click.add(ifClickVariance.render());
		line_intr_click.add(tglRandomizeClicks.render());
		
			// Randomize click length
		JPanel line_randlen = FLGUIUtilities.createLineContainer();
		cbRandomizeClickLength = new JCheckBox("Randomize click length");
		cbRandomizeClickLength.setSelected(v_len_isrnd);
		line_randlen.add(cbRandomizeClickLength);
		
		pane_bhv.add(line_repeat);
		FLGUIUtilities.addEmptySpace(pane_bhv);
		pane_bhv.add(line_intr_click);
		pane_bhv.add(line_randlen);
		FLGUIUtilities.addEmptySpace(pane_bhv);
		
		container.add(ddMouseButton.render());
		FLGUIUtilities.addEmptySpace(container);
		container.add(pane_bhv);
		
		return container;
	}
	
	@Override
	public void updateAction() {
		super.updateAction();
		
		FLActionMouseClick act = (FLActionMouseClick) context.get("action");
		
		int rep  = (int) sNumberOfClicks.getValue();
		int intr = Integer.parseInt(ifClickInterval.textField.getText());
		int var  = Integer.parseInt(ifClickVariance.textField.getText());
		
		boolean is_rnd_intr = tglRandomizeClicks.toggler.isSelected();
		boolean is_rnd_len = cbRandomizeClickLength.isSelected();
		
			// Set repeat
		act.getRepeat().setValue(rep);
		
			// Set interval
		FLInt intr_f = act.getInterval();
		intr_f.setValue(intr);
		intr_f.setErrorMargin(var);
		intr_f.setRandomized(is_rnd_intr);
		
			// Set randomized click lengths
		FLInt len_f = act.getClickLength();
		len_f.setRandomized(is_rnd_len);
		
		if( is_rnd_len == true )
		{
			len_f.setValue(DEFAULT_CLICK_LENGTH_RANDOMIZED);
			len_f.setErrorMargin(DEFAULT_CLICK_LENGTH_VARIANCE);
		}
		else len_f.setValue(DEFAULT_CLICK_LENGTH);
	}
}
