package igapyon.diary.ghpages;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import jp.igapyon.diary.v3.gendiary.GenerateTodayDiary;
import jp.igapyon.diary.v3.hatena.ConvertHatenaSeparatedText2SrcMd;
import jp.igapyon.diary.v3.html.GenerateIndexDiaryHtml;
import jp.igapyon.diary.v3.item.DiaryItemInfo;
import jp.igapyon.diary.v3.item.DiaryItemInfoComparator;
import jp.igapyon.diary.v3.mdconv.ConvertDiarySrcMd2Md;
import jp.igapyon.diary.v3.mdconv.GenerateIndexDiaryMd;
import jp.igapyon.diary.v3.mdconv.ProcessIndexListing;

/**
 * mvn install exec:java
 */
public class App {
	/**
	 * 現時点の、このプロジェクトのエントリポイント。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Convert .src.md to .md");

		try {
			// カレントディレクトリを取得のうえ正規化します。
			final File rootdir = new File(".").getCanonicalFile();
			if (rootdir.getName().equals("diary") == false) {
				System.err.println(
						"安全装置：処理停止。期待とは違うディレクトリで実行されました。このプログラムは diary ディレクトリでの実行を前提とします。:" + rootdir.getName());
				return;
			}

			// 今日の日記について、存在しなければ作成します。
			new GenerateTodayDiary().processDir(rootdir);

			// 分割されたはてなテキストから .src.md ファイルを生成します。
			new ConvertHatenaSeparatedText2SrcMd().processDir(rootdir);

			// .src.md ファイルから .md ファイルを生成します。
			new ConvertDiarySrcMd2Md().process();

			// ファイルからファイル一覧情報を作成します。
			final List<DiaryItemInfo> diaryItemInfoList = new GenerateIndexDiaryMd().processDir(rootdir, "");
			final List<DiaryItemInfo> diaryItemInfoHtmlList = new GenerateIndexDiaryHtml().processDir(rootdir, "");
			diaryItemInfoList.addAll(diaryItemInfoHtmlList);
			Collections.sort(diaryItemInfoList, new DiaryItemInfoComparator());

			new ProcessIndexListing().process(new File("README.src.md"), diaryItemInfoList);
			new ProcessIndexListing().process(new File("idxall.html.src.md"), diaryItemInfoList);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
