package freeloader.robot.actions.values;

import freeloader.robot.FLRobotContext;

public abstract class FLValue<T> {
	
		// Contained value
	protected T value;
	
	
	protected FLValue() {
		this.value = null;
	}
	
	protected FLValue(T value) {
		this.value = value;
	}
	
	
		// Returns the contained value with possible modifications
		// based on the robot context the calling action is being performed
		// in (TO BE OVERRIDDEN)
	public T getValue(FLRobotContext rtext) {
		return null;
	}
}
