package food869.was.lib.container;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import food869.was.lib.enums.DeployDescriptorE;

public class DeployDescriptReader {
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document doc;

	public DeployDescriptReader() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, String> getAllUrlPatterns(File webApp) {
		try {
			HashMap<String, String> urlMap = new HashMap<>();
			doc = builder.parse(webApp.getCanonicalPath() + "/WEB-INF/web.xml");
			Element root = doc.getDocumentElement();

			NodeList url_patternTags = root.getElementsByTagName(DeployDescriptorE.URL_PATTERN.getValue());
			for (int i = 0; i < url_patternTags.getLength(); i++) {
				Node urlTag = url_patternTags.item(i);
				Element servletMapping = (Element) urlTag.getParentNode();
				Node servletName = servletMapping.getElementsByTagName(DeployDescriptorE.SERVLET_NAME.getValue())
						.item(0);

				String servletClassPath = findServletClassPath(root, servletName.getTextContent());

				if (servletClassPath != null && !(servletClassPath.equals(""))) {
					urlMap.put("/" + webApp.getName() + urlTag.getTextContent(), servletClassPath);
				}

			}
			return urlMap;
		} catch (SAXException | IOException e) {
			return null;
		}
	}

	private String findServletClassPath(Element root, String servletName) {
		NodeList servletTags = root.getElementsByTagName(DeployDescriptorE.SERVLET.getValue());
		for (int i = 0; i < servletTags.getLength(); i++) {
			Node servletTag = servletTags.item(i);
			Node servletNameTag = ((Element) servletTag).getElementsByTagName(DeployDescriptorE.SERVLET_NAME.getValue())
					.item(0);
			if (servletNameTag.getTextContent().equals(servletName)) {
				Node servletClassTag = ((Element) servletTag)
						.getElementsByTagName(DeployDescriptorE.SERVLET_CLASS.getValue()).item(0);
				return servletClassTag.getTextContent();
			}
		}
		return null;
	}

}
