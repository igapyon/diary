package igapyon.diary.ghpages;

import java.io.File;
import java.io.IOException;

import jp.igapyon.diary.v3.gendiary.TodayDiaryGenerator;
import jp.igapyon.diary.v3.indexing.DiaryIndexAtomGenerator;
import jp.igapyon.diary.v3.mdconv.DiarySrcMd2MdConverter;
import jp.igapyon.diary.v3.migration.hatena2md.HatenaText2SrcMdConverter;
import jp.igapyon.diary.v3.migration.html2md.IgapyonV2Html2MdConverter;
import jp.igapyon.diary.v3.util.IgapyonV3Settings;

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

		final IgapyonV3Settings settings = new IgapyonV3Settings();

		{
			final String[][] ADDING_DOUBLE_KEYWORDS = new String[][] { //
					{ "艦これ", "http://www.dmm.com/netgame/feature/kancolle.html" }, //
			};

			for (String[] lookup : ADDING_DOUBLE_KEYWORDS) {
				settings.getDoubleKeywordList().add(lookup);
			}
		}

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
			new TodayDiaryGenerator(settings).processDir();

			// index用のatomファイルを生成および更新します。
			new DiaryIndexAtomGenerator(settings).process(rootdir);

			// .html.src.md ファイルから .md ファイルを生成します。
			System.err.println("Convert .html.src.md to .html.md file.");
			new DiarySrcMd2MdConverter(settings).processDir(rootdir);

			if (false) {
				// 移行シリーズ。

				// v2 システムから v3 に html -> md 変換を実施します。
				// ただし、このスクリプトは、日記移行時には活躍したものの、その後役目を終えて、通常は使われません。
				new IgapyonV2Html2MdConverter().processDir(rootdir);

				// 分割されたはてなテキストから .src.md ファイルを生成します。
				// ただし、このスクリプトは、日記移行時には活躍したものの、その後役目を終えて、通常は使われません。
				System.err.println("Hatena text to .html.src.md file.");
				new HatenaText2SrcMdConverter(settings).processDir(rootdir);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
