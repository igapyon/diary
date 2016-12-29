package igapyon.diary.ghpages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import igapyon.diary.ghpages.html.GenerateIndexDiaryHtml;

/**
 * mvn install exec:java
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Convert .src.md to .md");

		try {
			new ConvertDiarySrcMd2Md().process();

			final List<DiaryItemInfo> diaryItemInfoList = new GenerateIndexDiaryMd().process();
			final List<DiaryItemInfo> diaryItemInfoHtmlList = new GenerateIndexDiaryHtml().process();
			diaryItemInfoList.addAll(diaryItemInfoHtmlList);

			new ProcessIndexListing().process(new File("README.src.md"), diaryItemInfoList);
			new ProcessIndexListing().process(new File("idxall.html.src.md"), diaryItemInfoList);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
