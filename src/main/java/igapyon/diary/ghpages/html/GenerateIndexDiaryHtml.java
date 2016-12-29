package igapyon.diary.ghpages.html;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import igapyon.diary.ghpages.DiaryItemInfo;

public class GenerateIndexDiaryHtml {
	private List<DiaryItemInfo> diaryItemInfoList = new ArrayList<DiaryItemInfo>();

	public static void main(String[] args) throws IOException {
		final List<DiaryItemInfo> diaryItemInfoList = new GenerateIndexDiaryHtml().process();
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

		java.util.Collections.sort(diaryItemInfoList, new java.util.Comparator<DiaryItemInfo>() {
			public int compare(DiaryItemInfo obj1, DiaryItemInfo obj2) {
				return obj1.getUri().compareTo(obj2.getUri());
			}
		});

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
				if (file.getName().startsWith("ig") && file.getName().endsWith(".html")
						&& false == file.getName().endsWith(".src.html")) {
					System.out.println(file.getName());
					processFile(file, path);
				}
			}
		}
	}

	void processFile(final File file, final String path) throws IOException {
		final String source = FileUtils.readFileToString(file, "Windows-31J");

		final String url = "https://igapyon.github.io/diary" + path + "/" + file.getName();

		final DiaryItemInfo diaryItemInfo = new DiaryItemInfo();
		diaryItemInfo.setUri(url);
		diaryItemInfo.setTitle("NOT IMPLEMENTED");

		diaryItemInfoList.add(diaryItemInfo);
	}
}
