package chess;

import java.io.InputStream;

final public class Resourceloader {
	public static InputStream load(String path) {

		InputStream input = Resourceloader.class.getResourceAsStream(path);
		if (input==null) {
			input = Resourceloader.class.getResourceAsStream("/"+path);
			
		}
		return input;

	}
}
