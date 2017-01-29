/*
 * これは伊賀の個人的なコンテンツです。
 * 
 * igapyonv3 の利用サンプルにも当たります。
 */

package igapyon.diary.ghpages;

import java.io.File;
import java.io.IOException;

import jp.igapyon.diary.v3.IgDiaryProcessor;
import jp.igapyon.diary.v3.migration.html2md.IgapyonV2Html2MdConverter;

/**
 * usage: mvn install exec:java
 */
public class App {
	/**
	 * 現時点の、このプロジェクトのエントリポイント。
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException {
		System.out.println("Convert .src.md to .md");

		{
			// カレントディレクトリを取得のうえ正規化します。
			final File rootdir = new File(".").getCanonicalFile();
			if (rootdir.getName().equals("diary") == false) {
				System.err.println(
						"安全装置：処理停止。期待とは違うディレクトリで実行されました。このプログラムは diary ディレクトリでの実行を前提とします。:" + rootdir.getName());
				return;
			}

			// 基本処理。
			new IgDiaryProcessor().process(rootdir);

			if (false) {
				// 移行シリーズ。

				// v2 システムから v3 に html -> md 変換を実施します。
				// ただし、このスクリプトは、日記移行時には活躍したものの、その後役目を終えて、通常は使われません。
				new IgapyonV2Html2MdConverter().processDir(rootdir);

				// 分割されたはてなテキストから .src.md ファイルを生成します。
				// ただし、このスクリプトは、日記移行時には活躍したものの、その後役目を終えて、通常は使われません。
				System.err.println("Hatena text to .html.src.md file.");
				// new HatenaText2SrcMdConverter(settings).processDir(rootdir);
			}
		}
	}
}
