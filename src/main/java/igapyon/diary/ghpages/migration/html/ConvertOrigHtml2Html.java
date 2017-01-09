
package igapyon.diary.ghpages.migration.html;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import jp.igapyon.diary.v3.item.DiaryItemInfo;

/**
 * エンコーディングを変更するだけのクラス。
 */
public class ConvertOrigHtml2Html {
	private List<DiaryItemInfo> diaryItemInfoList = new ArrayList<DiaryItemInfo>();

	public static void main(final String[] args) throws IOException {
		final List<DiaryItemInfo> diaryItemInfoList = new ConvertOrigHtml2Html().process();
		for (DiaryItemInfo diaryItemInfo : diaryItemInfoList) {
			System.out.println(diaryItemInfo.getUri() + ":" + diaryItemInfo.getTitle());
		}
	}

	public List<DiaryItemInfo> process() throws IOException {
		File dir = new File(".");
		dir = dir.getCanonicalFile();
		System.out.println(dir.getPath());

		if (dir.getName().equals("diary")) {
			System.out.println("期待通りディレクトリ");
			processDir(dir, "");
		} else {
			System.out.println("期待とは違うディレクトリ:" + dir.getName());
		}

		return diaryItemInfoList;
	}

	void processDir(final File dir, String path) throws IOException {
		final File[] files = dir.listFiles();
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (file.isDirectory()) {
				processDir(file, path + "/" + file.getName());
			} else if (file.isFile()) {
				if (file.getName().startsWith("ig") && file.getName().endsWith(".html.orig")) {
					System.out.println(file.getName());
					processFile(file, path);
				}
			}
		}
	}

	void processFile(final File file, final String path) throws IOException {
		String data = FileUtils.readFileToString(file, "Windows-31J");

		data = StringUtils.replace(data, "charset=Shift_JIS", "charset=UTF-8");

		data = StringUtils.replace(data, "../../image/", "../images/");

		File newFile = new File(file.getParent(), file.getName().substring(0, file.getName().length() - 5));
		FileUtils.write(newFile, data, "UTF-8");
	}
}
