package igapyon.diary.ghpages;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class ProcessIndexListing {
	public void process(final File fileTarget, final List<DiaryItemInfo> diaryItemInfoList) throws IOException {
		final String origin = FileUtils.readFileToString(fileTarget, "UTF-8");
		final String target = StringUtils.replace(origin, "{igapyon.diary.ghpages.dialylist}",
				"aaaaaaaaaaaaaaaaaaaa");
		FileUtils.writeStringToFile(new File("README.md"), target, "UTF-8");
	}
}
