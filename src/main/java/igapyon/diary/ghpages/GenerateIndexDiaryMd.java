package igapyon.diary.ghpages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class GenerateIndexDiaryMd {
	public void process() throws IOException {
		File dir = new File(".");
		dir = dir.getCanonicalFile();
		System.out.println(dir.getPath());

		if (dir.getName().equals("diary")) {
			System.out.println("期待通りディレクトリ");
			processDir(dir, "");
		} else {
			System.out.println("期待とは違うディレクトリ:" + dir.getName());
			return;
		}
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
				if (file.getName().startsWith("ig") && file.getName().endsWith(".md")
						&& false == file.getName().endsWith(".src.md")) {
					System.out.println(file.getName());
					processFile(file, path);
				}
			}
		}
	}

	void processFile(final File file, final String path) throws IOException {
		final List<String> lines = FileUtils.readLines(file, "UTF-8");

		final String url = "https://igapyon.github.io/diary" + path + "/"
				+ file.getName().substring(0, file.getName().length() - 3);
System.out.println(url);
		System.out.println(lines.get(0));
	}
}
