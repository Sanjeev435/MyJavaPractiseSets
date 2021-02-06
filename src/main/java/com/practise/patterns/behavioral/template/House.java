package com.practise.patterns.behavioral.template;

import java.util.ArrayList;
import java.util.List;

/**
 * abstract class House containing template method buildHouse and implementation
 * of steps which is same for all types of houses. Those implementations have
 * been marked as final.
 */

public abstract class House {
	/**
	 * This is the template method we are discussing. This method should be final so
	 * that other class can't re-implement and change the order of the steps.
	 * 
	 * Please note that return is only meant for test. The actual signature will be
	 * void for this method.
	 */
	public final List<String> buildhouse() {
		List<String> processes = new ArrayList<>();

		processes.add(constructBase());
		processes.add(constructRoof());
		processes.add(constructWalls());
		processes.add(constructWindows());
		processes.add(constructDoors());
		processes.add(paintHouse());
		processes.add(decorateHouse());

		return processes;
	}

	public abstract String decorateHouse();

	public abstract String paintHouse();

	public abstract String constructDoors();

	public abstract String constructWindows();

	public abstract String constructWalls();

	/**
	 * final implementation of constructing roof - final as all type of house Should
	 * build roof in same manner.
	 */
	private String constructRoof() {
		return "Roof has been constructed.";
	}

	/**
	 * final implementation of constructing base - final as all type of house Should
	 * build base/foundation in same manner.
	 */
	private String constructBase() {
		return "Base has been constructed.";
	}
}