package igapyon.diary.ghpages;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import jp.igapyon.diary.v3.gendiary.TodayDiaryGenerator;
import jp.igapyon.diary.v3.hatena.HatenaText2SrcMdConverter;
import jp.igapyon.diary.v3.html.IndexDiaryHtmlParser;
import jp.igapyon.diary.v3.item.DiaryItemInfo;
import jp.igapyon.diary.v3.item.DiaryItemInfoComparator;
import jp.igapyon.diary.v3.mdconv.DiarySrcMd2MdConverter;
import jp.igapyon.diary.v3.mdconv.IndexDiaryMdParser;
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
			System.err.println("Generate today's diary file if not exists.");
			new TodayDiaryGenerator().processDir(rootdir);

			// 分割されたはてなテキストから .src.md ファイルを生成します。
			System.err.println("Hatena text to .html.src.md file.");
			new HatenaText2SrcMdConverter().processDir(rootdir);

			// .html.src.md ファイルから .md ファイルを生成します。
			System.err.println("Convert .html.src.md to .html.md file.");
			new DiarySrcMd2MdConverter().processDir(rootdir);

			{
				// ルートディレクトリ用

				// ファイルからファイル一覧情報を作成します。
				System.err.println("Listing md files.");
				final List<DiaryItemInfo> diaryItemInfoList = new IndexDiaryMdParser().processDir(rootdir, "");
				System.err.println("Listing html files.");
				final List<DiaryItemInfo> diaryItemInfoHtmlList = new IndexDiaryHtmlParser().processDir(rootdir, "");
				diaryItemInfoList.addAll(diaryItemInfoHtmlList);

				// sort them
				Collections.sort(diaryItemInfoList, new DiaryItemInfoComparator());

				System.err.println("Update index files.");
				new ProcessIndexListing().process(new File("README.src.md"), diaryItemInfoList);
				new ProcessIndexListing().process(new File("idxall.html.src.md"), diaryItemInfoList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
