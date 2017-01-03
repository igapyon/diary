package igapyon.diary.ghpages;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import jp.igapyon.diary.v3.gendiary.TodayDiaryGenerator;
import jp.igapyon.diary.v3.hatena.HatenaText2SrcMdConverter;
import jp.igapyon.diary.v3.html.IndexDiaryHtmlParser;
import jp.igapyon.diary.v3.html2md.IgapyonV2Html2MdConverter;
import jp.igapyon.diary.v3.item.DiaryItemInfo;
import jp.igapyon.diary.v3.item.DiaryItemInfoComparator;
import jp.igapyon.diary.v3.mdconv.DiarySrcMd2MdConverter;
import jp.igapyon.diary.v3.mdconv.IndexDiaryMdParser;
import jp.igapyon.diary.v3.mdconv.ProcessIndexListing;
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

		{
			try {
				new IgapyonV2Html2MdConverter().processDir(new File("."));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// EXIT
			if (true)
				return;
		}

		final IgapyonV3Settings settings = new IgapyonV3Settings();

		{
			final String[][] ADDING_DOUBLE_KEYWORDS = new String[][] { //
					{ "Maven", "https://igapyon.github.io/diary/keyword/Maven.html" }, //
					{ "FreeMarker", "http://freemarker.org/" }, //
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
			new TodayDiaryGenerator(settings).processDir(rootdir);

			// 分割されたはてなテキストから .src.md ファイルを生成します。
			System.err.println("Hatena text to .html.src.md file.");
			new HatenaText2SrcMdConverter(settings).processDir(rootdir);

			// .html.src.md ファイルから .md ファイルを生成します。
			System.err.println("Convert .html.src.md to .html.md file.");
			new DiarySrcMd2MdConverter(settings).processDir(rootdir);

			{
				// ルートディレクトリ用

				// ファイルからファイル一覧情報を作成します。
				System.err.println("Listing md files.");
				final List<DiaryItemInfo> diaryItemInfoList = new IndexDiaryMdParser(settings).processDir(rootdir, "");
				System.err.println("Listing html files.");
				final List<DiaryItemInfo> diaryItemInfoHtmlList = new IndexDiaryHtmlParser(settings).processDir(rootdir,
						"");
				diaryItemInfoList.addAll(diaryItemInfoHtmlList);

				// sort them
				Collections.sort(diaryItemInfoList, new DiaryItemInfoComparator());

				System.err.println("Update index files.");
				new ProcessIndexListing(settings).process(new File("README.src.md"), diaryItemInfoList);
				new ProcessIndexListing(settings).process(new File("idxall.html.src.md"), diaryItemInfoList);
			}

			final String[] YEARS = new String[] { "1996", "1997", "1998", "2000", "2001", "2002", "2003", "2004",
					"2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016",
					"2017" };

			for (String year : YEARS) {
				// 各年ディレクトリ用

				// ファイルからファイル一覧情報を作成します。
				System.err.println("Listing md files for :" + year);
				final List<DiaryItemInfo> diaryItemInfoList = new IndexDiaryMdParser(settings)
						.processDir(new File(rootdir, year), "/" + year);

				System.err.println("Listing html files for :" + year);
				final List<DiaryItemInfo> diaryItemInfoHtmlList = new IndexDiaryHtmlParser(settings)
						.processDir(new File(rootdir, year), "/" + year);
				diaryItemInfoList.addAll(diaryItemInfoHtmlList);

				// sort them
				Collections.sort(diaryItemInfoList, new DiaryItemInfoComparator());

				System.err.println("Update index files.");
				new ProcessIndexListing(settings).process(new File("./" + year + "/index.html.src.md"),
						diaryItemInfoList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
