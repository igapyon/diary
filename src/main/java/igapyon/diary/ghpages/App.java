package igapyon.diary.ghpages;

import java.io.IOException;

/**
 *
 * java -jar target/IgapyonDiaryGhPages-jar-with-dependencies.jar
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Convert .src.md to .md");

		try {
			new ConvertSrcMd2Md().process();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
