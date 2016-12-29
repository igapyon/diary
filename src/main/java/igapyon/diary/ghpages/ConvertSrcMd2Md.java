package igapyon.diary.ghpages;

import java.io.File;
import java.io.IOException;

/**
 * java -jar target/IgapyonDiaryGhPages-jar-with-dependencies.jar
 * 
 */
public class ConvertSrcMd2Md {
	public void process() throws IOException {
		File dir = new File(".");
		dir = dir.getCanonicalFile();
		System.out.println(dir.getPath());

		if (dir.getName().equals("diary")) {
			System.out.println("期待通りディレクトリ");
			processDir(dir);
		} else {
			System.out.println("期待とは違うディレクトリ:" + dir.getName());
			return;
		}
	}

	void processDir(final File dir) {
		final File[] files = dir.listFiles();
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (file.isDirectory()) {
				processDir(file);
			} else if (file.isFile()) {
				if (file.getName().endsWith(".src.md")) {
					System.out.println(file.getName());
				}
			}
		}
	}
}
