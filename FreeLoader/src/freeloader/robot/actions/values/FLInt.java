package freeloader.robot.actions.values;

import java.util.Random;

import freeloader.robot.FLRobotContext;

public class FLInt extends FLValue<Integer> {
	
		// Whether the value is to be randomized
	private boolean isRandomized;
	
		// Whether the value is relative to some other value
	private boolean isRelative;
	
		// Margin of error if the value is randomized
	private int errorMargin;
	
	
	public FLInt(int v, int err) {
		super(v);
		
		errorMargin = err;
		isRandomized = true;
		isRelative = false;
	}
	
	public FLInt() {
		super();
		
		value = 0;
		errorMargin = 0;
		isRandomized = false;
		isRelative = false;
	}
	
	public FLInt(int v) {
		this();
		
		value = v;
	}
	

		// Returns the (randomized) value
	@Override
	public Integer getValue(FLRobotContext rc) {
		int v = value;
		
		if( isRelative ) v = (int) rc.memoryGet("temp") + v;
		
		if( isRandomized )
		{
			Random rand = new Random();
			return v + ((int)(errorMargin * 2 * rand.nextDouble())) - errorMargin;
		}
		else return v;
	}
	
		// Sets the value
	public void setValue(int v) {
		value = v;
	}
	
		// Sets whether the value should be randomized
	public void setRandomized(boolean is) {
		isRandomized = is;
	}
	
		// Sets whether the value is relative to some other value
	public void setRelative(boolean is) {
		isRelative = is;
	}
	
		// Sets the margin of error if randomized
	public void setErrorMargin(int err) {
		errorMargin = err;
	}
	
		// Returns whether the value is randomized
	public boolean getRandomized() {
		return isRandomized;
	}
	
		// Returns whether the value is relative to some other value
	public boolean getRelative() {
		return isRelative;
	}
	
		// Returns the margin of error if randomized
	public int getErrorMargin() {
		return errorMargin;
	}
}
