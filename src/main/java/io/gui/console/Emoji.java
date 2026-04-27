package io.gui.console;

public enum Emoji {
	
	EMOJI_THUMBS_UP("\uD83D\uDC4D"),
	EMOJI_THUMBS_DOWN("\uD83D\uDC4E"),
	EMOJI_OK_HAND("\uD83D\uDC4C"),
	EMOJI_CHOCOLATE_BAR("\uD83C\uDF6B"),
	EMOJI_SMILING_FACE("\u263A"),
	EMOJI_GRINNING_FACE("\uD83E\uDD2A"),
	EMOJI_FACE_WITH_ROLLING_EYES("\uD83D\uDE44"),
	EMOJI_PRESENT("\uD83C\uDF81");
	
	
	private String code;
	
	private Emoji(String code) {
		this.code = code;
	}


	public String code() {
		return code;
	
	}
}
