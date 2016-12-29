package igapyon.diary.ghpages;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * mvn install exec:java
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Convert .src.md to .md");

		try {
			new ConvertDiarySrcMd2Md().process();

			final List<DiaryItemInfo> diaryItemInfoList = new GenerateIndexDiaryMd().process();

			new ProcessIndexListing().process(new File("README.src.md"), diaryItemInfoList);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
