package igapyon.diary.ghpages.migration.html;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ConvertFileNameExtRule {
	private static String result = "";

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("run");
		process(new File("."), new File(".").getCanonicalPath());

		FileUtils.writeStringToFile(new File("./test.txt"), result, "UTF-8");
	}

	public static void process(File dir, final String basedir) throws IOException {
		// System.err.println("basedir:" + basedir);
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				process(file, basedir);
			} else if (file.isFile()) {
				if (file.getName().endsWith(".html.src.md")) {
					final String source = file.getCanonicalPath().substring(basedir.length() + 1);
					result += ("git mv " + source + " " + source.substring(0, source.length() - ".html.src.md".length())
							+ ".src.md\n");
				}
			}
		}
	}
}
