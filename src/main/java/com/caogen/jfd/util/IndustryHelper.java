package com.caogen.jfd.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.caogen.jfd.model.Industry;

/**
 * 行业列表工具类
 * 
 * @author Spuiln
 *
 */
public class IndustryHelper {

	private static List<Industry> list = new ArrayList<Industry>();

	public static List<Industry> getIndustry() {
		return list;
	}

	@SuppressWarnings("unchecked")
	public static void init() throws DocumentException {
		SAXReader reader = new SAXReader();
		File file = new File(IndustryHelper.class.getClassLoader().getResource("industry.xml").getFile());
		Document document = reader.read(file);
		Element root = document.getRootElement();
		Iterator<Element> rootIter = root.elementIterator();
		while (rootIter.hasNext()) {
			Element item = rootIter.next();
			Industry itemIn = new Industry(item.attributeValue("Code"), item.attributeValue("Name"));
			Iterator<Element> itemIter = item.elementIterator();
			while (itemIter.hasNext()) {
				Element detail = itemIter.next();
				itemIn.getChildren().add(new Industry(detail.attributeValue("Code"), detail.attributeValue("Name")));
			}
			list.add(itemIn);
		}
	}

}
