package io.application;

import java.util.HashMap;
import java.util.Map;

import io.gui.console.Console;
import io.gui.console.DisplayConsole;
import io.gui.console.Emoji;
import io.gui.console.ReadConsole;
import io.util.EasterEggFileException;

public class ChocolateApplication {
	
		//TODO refacto: use an HashMap or something else ?
		
		Console console;
		DisplayConsole display;
		ReadConsole read;
		Map<String, String> chocolateMenu;


		public ChocolateApplication() {
			this.console = new Console();
			this.display = new DisplayConsole();
			createChocolateMenu();
		
			this.read = new ReadConsole();

			
		}

		public void aboutYourFavoriteChocolate() {

			console.title("Welcome ! What is your favourite chocolate ?");
			console.message(display.menu(chocolateMenu));
			
			console.message(" Your choice: ");
			console.lineBreak();
			int option = read.ensureIntegerBetween(display.exitKey(), chocolateMenu.size());
			
			answerChocolateMenuFor(option);

		}

		private void answerChocolateMenuFor(int option) {
			switch (option) {
			case 1:
				console.message(Emoji.EMOJI_CHOCOLATE_BAR.code() + " Healthy chocolate !" + Emoji.EMOJI_OK_HAND.code()+Emoji.EMOJI_THUMBS_UP.code());
				break;
			case 2:
				try {
					console.message(display.showContentFile("src/main/resources/easter.txt"));
				}catch (EasterEggFileException e){
					console.message(Emoji.EMOJI_PRESENT.code());
				}
				console.message(Emoji.EMOJI_CHOCOLATE_BAR.code() + " My favourite chocolate !" + Emoji.EMOJI_SMILING_FACE.code());
				break;
			case 3:
				console.message(Emoji.EMOJI_CHOCOLATE_BAR.code() +" Sugar and fat : unhealthy !"+ Emoji.EMOJI_THUMBS_DOWN.code()+Emoji.EMOJI_GRINNING_FACE.code());
				break;
			default:
				console.message(Emoji.EMOJI_FACE_WITH_ROLLING_EYES.code()+" Maybe you dislike chocolate...");
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

			ChocolateApplication chocolateApplication= new ChocolateApplication();
			chocolateApplication.aboutYourFavoriteChocolate();
		}

	}


