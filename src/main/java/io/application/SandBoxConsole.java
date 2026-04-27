package io.application;

import java.util.HashMap;
import java.util.Map;

import io.gui.console.Console;
import io.gui.console.DisplayConsole;
import io.gui.console.ReadConsole;

public class SandBoxConsole {

	// Search emoji on: https://unicode.org/emoji/charts/full-emoji-list.html
	// then go to https://www.fileformat.info/info/unicode/char/search.htm to
	// convert code for java source code
	private static final String EMOJI_THUMBS_UP = "\uD83D\uDC4D";
	private static final String EMOJI_THUMBS_DOWN = "\uD83D\uDC4E";
	private static final String EMOJI_OK_HAND = "\uD83D\uDC4C";
	private static final String EMOJI_CHOCOLATE_BAR = "\uD83C\uDF6B";
	private static final String EMOJI_SMILING_FACE = "\u263A";
	private static final String EMOJI_GRINNING_FACE = "\uD83E\uDD2A";
	private static final String EMOJI_FACE_WITH_ROLLING_EYES = "\uD83D\uDE44";

	Console console;
	DisplayConsole display;
	ReadConsole read;
	Map<String, String> chocolateMenu;

	public SandBoxConsole() {
		this.console = new Console();
		this.display = new DisplayConsole();
		createChocolateMenu();

		this.read = new ReadConsole();

	}

	public void test() {

		console.title("Welcome ! What is your favourite chocolate ?");

		console.title("Menu with directly text in method ");
		console.message(display.showChocolateMenu());

		console.title("Menu with varargs as input parameters");
		console.message(display.menu("Dark Chocolate", "Milk Chocolate", "White Chocolate"));

		console.title("Menu with hashmap as input parameter");
		console.message(display.menu(chocolateMenu));
		console.message(" Your choice: ");
		console.lineBreak();
		int option = read.ensureIntegerBetween(display.exitKey(), chocolateMenu.size());
		answerChocolateMenuFor(option);

	}

	private void answerChocolateMenuFor(int option) {
		switch (option) {
		case 1:
			console.message(EMOJI_CHOCOLATE_BAR + " Healthy chocolate !" + EMOJI_OK_HAND + EMOJI_THUMBS_UP);
			break;
		case 2:
			console.message(EMOJI_CHOCOLATE_BAR + " My favourite chocolate !" + EMOJI_SMILING_FACE);
			break;
		case 3:
			console.message(
					EMOJI_CHOCOLATE_BAR + " Sugar and fat : unhealthy !" + EMOJI_THUMBS_DOWN + EMOJI_GRINNING_FACE);
			break;
		default:
			console.message(EMOJI_FACE_WITH_ROLLING_EYES + " Maybe you dislike chocolate...");
			break;
		}
	}

	private void createChocolateMenu() {

		chocolateMenu = new HashMap<>();
		chocolateMenu.put("1", "Dark Chocolate");
		chocolateMenu.put("2", "Milk Chocolate");
		chocolateMenu.put("3", "White Chocolate");
	}

	public static void main(String[] args) {

		SandBoxConsole consoleApplication = new SandBoxConsole();
		consoleApplication.test();

	}

}
