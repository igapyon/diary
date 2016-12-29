package igapyon.diary.ghpages.hatena;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import igapyon.diary.ghpages.DiaryItemInfo;

public class HatenaXmlParser {
	public static final void main(final String[] args) throws IOException {
		new HatenaXmlParser().processFile(new File("./test/data/src/hatena/diary/001/test901.xml"),
				new File("./test/data/output/hatena/diary/001/"));
	}

	public void processFile(final File sourceXml, final File targetMdDir) throws IOException {

		final String inputXmlString = FileUtils.readFileToString(sourceXml, "UTF-8");
		final Element rootElement = SimpleXmlUtil.stringToElement(inputXmlString);

		final List<DiaryItemInfo> diaryItemList = parseRoot(rootElement);
		for (DiaryItemInfo item : diaryItemList) {
			System.out.println(item.getTitle() + ":" + item.getBody());
		}

	}

	public static List<DiaryItemInfo> parseRoot(final Element rootElement) throws IOException {
		final List<DiaryItemInfo> result = new ArrayList<DiaryItemInfo>();
		final NodeList nodeList = rootElement.getElementsByTagName("day");
		for (int index = 0; index < nodeList.getLength(); index++) {
			final Element look = (Element) nodeList.item(index);
			result.add(parseDay(look));
		}
		return result;
	}

	public static DiaryItemInfo parseDay(final Element dayElement) throws IOException {
		final DiaryItemInfo item = new DiaryItemInfo();

		String dateString = dayElement.getAttribute("date");
		System.out.println(dateString);
		item.setTitle(dayElement.getAttribute("title"));

		final NodeList nodeList = dayElement.getElementsByTagName("body");
		for (int index = 0; index < nodeList.getLength(); index++) {
			final Element look = (Element) nodeList.item(index);
			item.setBody((item.getBody() == null ? "" : item.getBody()) + look.getTextContent());
		}

		// Drop comments.

		return item;
	}

}
