package igapyon.diary.ghpages.hatena;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 分割されたはてなテキストからMDファイルを生成。
 */
public class ConvertHatenaSeparatedText2SrcMd {
	public static void main(String[] args) throws IOException {
		new ConvertHatenaSeparatedText2SrcMd().process();
	}

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

	void processDir(final File dir) throws IOException {
		final File[] files = dir.listFiles();
		if (files == null) {
			return;
		}
		for (File file : files) {
			if (file.isDirectory()) {
				processDir(file);
			} else if (file.isFile()) {
				if (file.getName().startsWith("ig") && file.getName().endsWith(".src.hatenadiary")) {
					System.out.println(file.getName());
					processFile(file);
				}
			}
		}
	}

	void processFile(final File file) throws IOException {
		final List<String> lines = FileUtils.readLines(file, "UTF-8");

		// 本体
		// タイトル行は別の仕組みで生成されるので、とりあえずとってしまう。
		lines.remove(0);

		for (int index = lines.size() - 1; index >= 0; index--) {
			String line = lines.get(index);
			if (line.startsWith("*p1*") || line.startsWith("*p2*") || line.startsWith("*p3*") || line.startsWith("*p4*")
					|| line.startsWith("*p5*")) {
				String newLine = line;
				newLine = StringUtils.replace(newLine, "*p1*", "## ");
				newLine = StringUtils.replace(newLine, "*p2*", "## ");
				newLine = StringUtils.replace(newLine, "*p3*", "## ");
				newLine = StringUtils.replace(newLine, "*p4*", "## ");
				newLine = StringUtils.replace(newLine, "*p5*", "## ");

				lines.set(index, "");
				lines.add(index + 1, newLine);
				lines.add(index + 2, "");
			}
		}

		for (int index = lines.size() - 1; index >= 0; index--) {
			String line = lines.get(index);
			if (line.startsWith("**") || line.startsWith("***") || line.startsWith("****") || line.startsWith("*****")
					|| line.startsWith("******")) {
				String newLine = line;
				newLine = StringUtils.replace(newLine, "******", "####### ");
				newLine = StringUtils.replace(newLine, "*****", "###### ");
				newLine = StringUtils.replace(newLine, "****", "##### ");
				newLine = StringUtils.replace(newLine, "***", "#### ");
				newLine = StringUtils.replace(newLine, "**", "### ");

				lines.set(index, "");
				lines.add(index + 1, newLine);
				lines.add(index + 2, "");
			}
		}

		for (int index = 0; index < lines.size(); index++) {
			String line = lines.get(index);
			if (line.trim().length() == 0) {
				lines.remove(index);
				index--;
			} else {
				break;
			}
		}

		for (int index = 0; index < lines.size(); index++) {
			String line = lines.get(index);
			if (line.trim().equals(">|xml|")) {
				lines.set(index, "```xml");
			}
			if (line.trim().equals(">|java|")) {
				lines.set(index, "```java");
			}
		}

		String newName = file.getName().substring(0, file.getName().length() - (".src.hatenadiary".length()))
				+ ".html.src.md";
		FileUtils.writeLines(new File(file.getParentFile(), newName), lines);
	}
}