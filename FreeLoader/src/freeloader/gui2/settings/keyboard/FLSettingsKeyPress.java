package freeloader.gui2.settings.keyboard;

import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import freeloader.gui2.FLGUIContext;
import freeloader.gui2.FLGUIUtilities;
import freeloader.gui2.sub.FLSubInputField;
import freeloader.gui2.sub.FLSubTogglerCheckBox;
import freeloader.robot.actions.keyboard.FLActionKeyPress;
import freeloader.robot.actions.values.FLInt;

public class FLSettingsKeyPress extends FLSettingsKeyboard {
	
		// Default click length (MS)
	public static final int DEFAULT_PRESS_LENGTH = 16;
	
		// Default click length when randomized (MS)
	public static final int DEFAULT_PRESS_LENGTH_RANDOMIZED = 100;
	
		// Default click length variance (MS)
	public static final int DEFAULT_PRESS_LENGTH_VARIANCE = 90;
	
	
		// (swing) SPINNER - Number of presses
	private JSpinner sNumberOfPresses;
	
		// INPUT FIELD - Press interval
	private FLSubInputField ifPressInterval;
	
		// TOGGLER CHECK BOX - Randomize Presses
	private FLSubTogglerCheckBox tglRandomizePresses;
	
		// INPUT FIELD - Press variance
	private FLSubInputField ifPressVariance;
	
		// (swing) CHECK BOX - Randomize press length
	private JCheckBox cbRandomizePressLength;
	
	
	public FLSettingsKeyPress(FLGUIContext c) {
		super(c);
	}
	

	@Override
	public JPanel draw() {
		
			// Get values
		FLActionKeyPress act = (FLActionKeyPress) context.get("action");
		int v_rep = act.getRepeat().getUnmoddedValue();
		
		FLInt intr_f = act.getInterval();
		int v_intr = intr_f.getUnmoddedValue();
		int v_intr_var = intr_f.getErrorMargin();
		
		boolean v_intr_isrnd = intr_f.getRandomized();
		boolean v_len_isrnd = act.getPressLength().getRandomized();
		
		JPanel container = createSettingsContainer();
		
			// Create button selection
		createKeyboardKeyMenu();
		
			// Press behavior
		JPanel pane_bhv = FLGUIUtilities.createSettingsPane("Behavior");
		
			// Number of presses
		JPanel line_repeat = FLGUIUtilities.createLineContainer();
		sNumberOfPresses = new JSpinner();
		sNumberOfPresses.setModel(new SpinnerNumberModel(Math.max(1, v_rep), 1, Integer.MAX_VALUE, 1));
		sNumberOfPresses.setMaximumSize(new Dimension(64, sNumberOfPresses.getPreferredSize().height));
		
		line_repeat.add(new JLabel("Presses in a row: "));
		line_repeat.add(sNumberOfPresses);
		line_repeat.setMaximumSize(new Dimension(Integer.MAX_VALUE, line_repeat.getPreferredSize().height));
		
			// Press interval
		JPanel line_intr_click = FLGUIUtilities.createLineContainer();
		ifPressInterval = new FLSubInputField(this, "Press interval (MS):  ");
		ifPressInterval.textField.setText(Integer.toString(v_intr));
		line_intr_click.add(ifPressInterval.render());
		
			// Press interval variance
		ifPressVariance = new FLSubInputField(this, "  VARIANCE:  ");
		ifPressVariance.textField.setEnabled(v_intr_isrnd);
		ifPressVariance.textField.setText(Integer.toString(v_intr_var));
		
			// Randomize press interval
		tglRandomizePresses = new FLSubTogglerCheckBox(this, "Randomize", ifPressVariance.textField, false);
		line_intr_click.add(ifPressVariance.render());
		line_intr_click.add(tglRandomizePresses.render());
		
			// Randomize press length
		JPanel line_randlen = FLGUIUtilities.createLineContainer();
		cbRandomizePressLength = new JCheckBox("Randomize press length");
		cbRandomizePressLength.setSelected(v_len_isrnd);
		line_randlen.add(cbRandomizePressLength);
		
		pane_bhv.add(line_repeat);
		FLGUIUtilities.addEmptySpace(pane_bhv);
		pane_bhv.add(line_intr_click);
		pane_bhv.add(line_randlen);
		FLGUIUtilities.addEmptySpace(pane_bhv);
		
		container.add(ddKeyboardKey.render());
		FLGUIUtilities.addEmptySpace(container);
		container.add(pane_bhv);
		
		return container;
	}
	
	@Override
	public void updateAction() {
		super.updateAction();
		
		FLActionKeyPress act = (FLActionKeyPress) context.get("action");
		
		int rep  = (int) sNumberOfPresses.getValue();
		int intr = Integer.parseInt(ifPressInterval.textField.getText());
		int var  = Integer.parseInt(ifPressVariance.textField.getText());
		
		boolean is_rnd_intr = tglRandomizePresses.toggler.isSelected();
		boolean is_rnd_len = cbRandomizePressLength.isSelected();
		
			// Set repeat
		act.getRepeat().setValue(rep);
		
			// Set interval
		FLInt intr_f = act.getInterval();
		intr_f.setValue(intr);
		intr_f.setErrorMargin(var);
		intr_f.setRandomized(is_rnd_intr);
		
			// Set randomized press lengths
		FLInt len_f = act.getPressLength();
		len_f.setRandomized(is_rnd_len);
		
		if( is_rnd_len == true )
		{
			len_f.setValue(DEFAULT_PRESS_LENGTH_RANDOMIZED);
			len_f.setErrorMargin(DEFAULT_PRESS_LENGTH_VARIANCE);
		}
		else len_f.setValue(DEFAULT_PRESS_LENGTH);
	}
}
