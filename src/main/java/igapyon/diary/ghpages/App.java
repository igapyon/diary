package igapyon.diary.ghpages;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import igapyon.diary.ghpages.html.GenerateIndexDiaryHtml;
import igapyon.diary.ghpages.todaydiary.GenerateTodayDiary;
import jp.igapyon.diary.v3.hatena.ConvertHatenaSeparatedText2SrcMd;
import jp.igapyon.diary.v3.item.DiaryItemInfo;
import jp.igapyon.diary.v3.item.DiaryItemInfoComparator;

/**
 * mvn install exec:java
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Convert .src.md to .md");

		try {
			// 今日の日記について、存在しなければ作成します。
			new GenerateTodayDiary().process();

			// 分割されたはてなテキストから .src.md ファイルを生成します。
			new ConvertHatenaSeparatedText2SrcMd().process();

			// .src.md ファイルから .md ファイルを生成します。
			new ConvertDiarySrcMd2Md().process();

			// ファイルからファイル一覧情報を作成します。
			final List<DiaryItemInfo> diaryItemInfoList = new GenerateIndexDiaryMd().process();
			final List<DiaryItemInfo> diaryItemInfoHtmlList = new GenerateIndexDiaryHtml().process();
			diaryItemInfoList.addAll(diaryItemInfoHtmlList);
			Collections.sort(diaryItemInfoList, new DiaryItemInfoComparator());

			new ProcessIndexListing().process(new File("README.src.md"), diaryItemInfoList);
			new ProcessIndexListing().process(new File("idxall.html.src.md"), diaryItemInfoList);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
