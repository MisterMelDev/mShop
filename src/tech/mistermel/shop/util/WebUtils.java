package tech.mistermel.shop.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WebUtils {
	
	private WebUtils() {}
	
	public static String fillPlaceholders(String txt, String... placeholders) {
		String result = txt;
		for(int i = 0; i < placeholders.length; i += 2) {
			result = result.replace("{{%" + placeholders[i] + "%}}", placeholders[i + 1]);
		}
		return result;
	}

	public static String readFile(String name) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(WebUtils.class.getResourceAsStream("/pages/" + name)));
			StringBuilder str = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
				str.append(line);
			}
			return str.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String readExternal(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuilder str = new StringBuilder();
			String line;
			while((line = reader.readLine()) != null) {
				str.append(line);
			}
			reader.close();
			return str.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
