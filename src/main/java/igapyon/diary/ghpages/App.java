package igapyon.diary.ghpages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedOutput;

import jp.igapyon.diary.v3.gendiary.TodayDiaryGenerator;
import jp.igapyon.diary.v3.hatena.HatenaText2SrcMdConverter;
import jp.igapyon.diary.v3.html.IndexDiaryHtmlParser;
import jp.igapyon.diary.v3.html2md.IgapyonV2Html2MdConverter;
import jp.igapyon.diary.v3.item.DiaryItemInfo;
import jp.igapyon.diary.v3.item.DiaryItemInfoComparator;
import jp.igapyon.diary.v3.mdconv.DiarySrcMd2MdConverter;
import jp.igapyon.diary.v3.mdconv.IndexDiaryMdParser;
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

			if (false) {
				// v2 システムから v3 に html -> md 変換を実施します。
				// ただし、このスクリプトは、日記移行時には活躍したものの、その後役目を終えて、通常は使われません。
				new IgapyonV2Html2MdConverter().processDir(rootdir);
			}

			// 今日の日記について、存在しなければ作成します。
			System.err.println("Generate today's diary file if not exists.");
			new TodayDiaryGenerator(settings).processDir(rootdir);

			if (false) {
				// 分割されたはてなテキストから .src.md ファイルを生成します。
				// ただし、このスクリプトは、日記移行時には活躍したものの、その後役目を終えて、通常は使われません。
				System.err.println("Hatena text to .html.src.md file.");
				new HatenaText2SrcMdConverter(settings).processDir(rootdir);
			}

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
				Collections.sort(diaryItemInfoList, new DiaryItemInfoComparator(true));

				writeAtom(diaryItemInfoList, new File(rootdir, "atom.xml"), "Igapyon Diary v3 all");

				{
					int diaryListupCount = 15;

					final List<DiaryItemInfo> recentItemInfoList = new ArrayList<DiaryItemInfo>();

					for (DiaryItemInfo itemInfo : diaryItemInfoList) {
						diaryListupCount--;
						recentItemInfoList.add(itemInfo);
						if (diaryListupCount <= 0) {
							break;
						}
					}

					writeAtom(recentItemInfoList, new File(rootdir, "atomRecent.xml"), "Igapyon Diary v3 recent");
				}

				// new ProcessIndexListing(settings).process(new
				// File("README.src.md"), diaryItemInfoList);
				// new ProcessIndexListing(settings).process(new
				// File("idxall.html.src.md"), diaryItemInfoList);
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
				Collections.sort(diaryItemInfoList, new DiaryItemInfoComparator(false));

				writeAtom(diaryItemInfoList, new File(rootdir, year + "/atom.xml"), "Igapyon Diary v3 year " + year);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeAtom(final List<DiaryItemInfo> diaryItemInfoList, final File targetAtomFile,
			final String title) throws IOException {
		final SyndFeed feed = new SyndFeedImpl();
		feed.setTitle(title);
		// FIXME should be variable.
		feed.setAuthor("Toshiki Iga");
		feed.setEncoding("UTF-8");
		feed.setGenerator("https://github.com/igapyon/igapyonv3");
		feed.setLanguage("ja_JP");
		feed.setFeedType("atom_1.0");

		// sort desc order
		Collections.sort(diaryItemInfoList, new DiaryItemInfoComparator(true));

		for (DiaryItemInfo diaryItemInfo : diaryItemInfoList) {
			final SyndEntry entry = new SyndEntryImpl();
			entry.setTitle(diaryItemInfo.getTitle());
			entry.setUri(diaryItemInfo.getUri());
			entry.setLink(diaryItemInfo.getUri());
			entry.setAuthor("Toshiki Iga");
			feed.getEntries().add(entry);
		}

		try {
			new SyndFeedOutput().output(feed, targetAtomFile);
		} catch (FeedException e) {
			throw new IOException(e);
		}
	}
}
