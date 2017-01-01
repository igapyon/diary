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
			final String[][] ADDING_DOUBLE_KEYWORDS = new String[][] {
					{ "blanco Framework", "https://ja.osdn.net/projects/blancofw/wiki/blancofw" },
					{ "Ubuntu", "https://www.ubuntu.com/" }, { "InterBase", "https://ja.wikipedia.org/wiki/InterBase" },
					{ "Chrome", "https://www.google.co.jp/chrome/browser/" },
					{ "Selenium", "http://www.seleniumhq.org/" }, { "Groovy", "http://www.groovy-lang.org/" },
					{ "Java", "http://www.oracle.com/technetwork/java/index.html" },
					{ "Force.com", "https://www.salesforce.com/products/platform/products/force/" },
					{ "blancoDb", "http://www.igapyon.jp/blanco/blancodb.html" },
					{ "Blanco2g", "https://ja.osdn.net/projects/blancofw/wiki/Blanco2g" },
					{ "blancoResourceBundle", "http://www.igapyon.jp/blanco/blancoresourcebundle.html" },
					{ "blancoDbDotNet", "http://www.igapyon.jp/blanco/blancodbdotnet.html" },
					{ "OpenDocument", "https://ja.wikipedia.org/wiki/OpenDocument" },
					{ "JExcelApi", "http://jexcelapi.sourceforge.net/" },
					{ "ネコバス", "http://nlab.itmedia.co.jp/nl/articles/1607/15/news147.html" },
					{ "C++Builder", "https://www.embarcadero.com/jp/products/cbuilder" }, 
					{"Object Pascal","https://ja.wikipedia.org/wiki/Object_Pascal"},
					{"LLVM","http://llvm.org/"},
					{"IoT","https://ja.wikipedia.org/wiki/%E3%83%A2%E3%83%8E%E3%81%AE%E3%82%A4%E3%83%B3%E3%82%BF%E3%83%BC%E3%83%8D%E3%83%83%E3%83%88"},
					{"OmegaT","http://www.omegat.org/ja/omegat.html"},
					{"FireUI","https://www.embarcadero.com/jp/products/rad-studio/fireui"},
					{"VCL","https://ja.wikipedia.org/wiki/Visual_Component_Library"},
					{"AirPrint","https://support.apple.com/ja-jp/HT201311"},
					{"blancoMailCore","http://www.igapyon.jp/blanco/blancomailcore.html"},
					{"Jersey","https://jersey.java.net/"},
					{"Apache","https://www.apache.org/"},
					{"Cordova","https://cordova.apache.org/"},
					{"VMware","http://www.vmware.com/jp.html"},
					{"iOS","http://www.apple.com/jp/ios/ios-10/"},
					{"艦これ","http://www.dmm.com/netgame/feature/kancolle.html"},
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

			{
				// 2016ディレクトリ用

				// ファイルからファイル一覧情報を作成します。
				System.err.println("Listing md files.");
				final List<DiaryItemInfo> diaryItemInfoList = new IndexDiaryMdParser(settings)
						.processDir(new File(rootdir, "2016"), "/2016");

				// no html in 2016

				// sort them
				Collections.sort(diaryItemInfoList, new DiaryItemInfoComparator());

				System.err.println("Update index files.");
				new ProcessIndexListing(settings).process(new File("./2016/index.html.src.md"), diaryItemInfoList);
			}

			{
				// 2015ディレクトリ用

				// ファイルからファイル一覧情報を作成します。
				System.err.println("Listing md files.");
				final List<DiaryItemInfo> diaryItemInfoList = new IndexDiaryMdParser(settings)
						.processDir(new File(rootdir, "2015"), "/2015");

				// no html in 2016

				// sort them
				Collections.sort(diaryItemInfoList, new DiaryItemInfoComparator());

				System.err.println("Update index files.");
				new ProcessIndexListing(settings).process(new File("./2015/index.html.src.md"), diaryItemInfoList);
			}

			{
				// 2016ディレクトリ用

				// ファイルからファイル一覧情報を作成します。
				System.err.println("Listing md files.");
				final List<DiaryItemInfo> diaryItemInfoList = new IndexDiaryMdParser(settings)
						.processDir(new File(rootdir, "2014"), "/2014");

				// no html in 2016

				// sort them
				Collections.sort(diaryItemInfoList, new DiaryItemInfoComparator());

				System.err.println("Update index files.");
				new ProcessIndexListing(settings).process(new File("./2014/index.html.src.md"), diaryItemInfoList);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
