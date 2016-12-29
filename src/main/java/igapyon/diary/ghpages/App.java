package igapyon.diary.ghpages;

import java.io.IOException;
import java.util.List;

/**
 *
 * java -jar target/IgapyonDiaryGhPages-jar-with-dependencies.jar
 * 
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Convert .src.md to .md");

		try {
			new ConvertDiarySrcMd2Md().process();

			final List<DiaryItemInfo> diaryItemInfoList = new GenerateIndexDiaryMd().process();
			for (DiaryItemInfo info : diaryItemInfoList) {
				System.out.println(info.getUri() + " : " + info.getTitle());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
