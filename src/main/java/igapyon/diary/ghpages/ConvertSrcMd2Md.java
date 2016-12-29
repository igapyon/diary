package igapyon.diary.ghpages;

import java.io.File;
import java.io.IOException;

public class ConvertSrcMd2Md {
	public void process() throws IOException {
		File dir = new File(".");
		System.out.println(dir.getCanonicalPath());
	}
}
