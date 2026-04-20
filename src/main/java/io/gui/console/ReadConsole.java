package io.gui.console;

public class ReadConsole extends Console {
	
	public int ensureInteger() {
		//TODO bugfix: only an integer catch the exception
		//A specific exception must be handled here when something else written
		boolean notAnInteger = true;
		Integer input = -1;
		while (notAnInteger){
			try {
				input = Integer.parseInt(keyboard.nextLine());
				notAnInteger = false;
			} catch (NumberFormatException e){
				this.message("It must be an integer");
			}
		}
		return input;
	}
	
	public int ensureIntegerBetween(int minimum, int maximum) {
		while (true) {
			int value = ensureInteger();
			if (minimum <= value && value <= maximum)
				return value;
			else {
				this.message("The value must be between " + minimum + " and " + maximum);
			}
		}
	}
}
