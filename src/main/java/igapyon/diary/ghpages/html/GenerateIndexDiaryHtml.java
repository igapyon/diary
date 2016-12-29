package igapyon.diary.ghpages.html;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import igapyon.diary.ghpages.DiaryItemInfo;
import igapyon.diary.ghpages.tagsoup.SimpleTagSoupUtil;

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
		String source = FileUtils.readFileToString(file, "Windows-31J");
		try {
			source = SimpleTagSoupUtil.formatHtml(source);
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String title = "N/A";
		try {
			final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			final Document document = documentBuilder.parse(new InputSource(new StringReader(source)));

			final XPath xpath = XPathFactory.newInstance().newXPath();

			title = (String) xpath.evaluate("/html/head/title/text()", document, XPathConstants.STRING);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
			System.out.println("html:" + source);
			throw new IllegalArgumentException("BREAK!");
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final String url = "https://igapyon.github.io/diary" + path + "/" + file.getName();

		final DiaryItemInfo diaryItemInfo = new DiaryItemInfo();
		diaryItemInfo.setUri(url);
		diaryItemInfo.setTitle(title);

		diaryItemInfoList.add(diaryItemInfo);
	}
}
