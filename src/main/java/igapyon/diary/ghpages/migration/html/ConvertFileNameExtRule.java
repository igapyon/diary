package igapyon.diary.ghpages.migration.html;

import java.io.File;
import java.io.IOException;

public class ConvertFileNameExtRule {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("run");
		process(new File("."), new File(".").getCanonicalPath());
	}

	public static void process(File dir, final String basedir) throws IOException {
		System.err.println("basedir:" + basedir);
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				process(file, basedir);
			} else if (file.isFile()) {
				// System.err.println("lookup:"+file.getName());
				if (file.getName().endsWith(".html.src.md")) {
					final String source = file.getCanonicalPath().substring(basedir.length() + 1);
					System.err.println("git mv " + source + " "
							+ source.substring(0, source.length() - ".html.src.md".length()) + ".src.md");
				}
			}
		}
	}
}
