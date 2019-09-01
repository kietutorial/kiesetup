/**
 * Copyright (c) 2009 - 2012 hCentive Inc. All rights reserved.
 */
package com.hcentive.utils.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUtility {

	private static XPath xpath = XPathFactory.newInstance().newXPath();
	private static Logger logger = LoggerFactory.getLogger(XMLUtility.class);

	/**
	 * Gets the xML string.
	 * 
	 * @param filePath
	 *            the file path
	 * @return the xML string
	 * @throws Exception
	 *             the exception
	 */
	public static String getXMLString(String filePath) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		FileInputStream is = new FileInputStream(new File(filePath));
		Document doc = docBuilder.parse(is);
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = tFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			logger.error("Exception: ", e);
		}

		DOMSource source = new DOMSource(doc);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		try {
			if (transformer != null) {
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.transform(source, result);
			}
		} catch (TransformerException e) {
			logger.error("Exception: ", e);
		}
		return writer.toString();
	}

	/**
	 * Gets the doc as string.
	 * 
	 * @param doc
	 *            the doc
	 * @return the doc as string
	 */
	public static String getDocAsString(Document doc) {
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = tFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			logger.error("Exception: ", e);
		}
		DOMSource source = new DOMSource(doc);
		StringWriter writer = new StringWriter();
		StreamResult result = new StreamResult(writer);
		try {
			if (transformer != null) {
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.transform(source, result);
			}
		} catch (TransformerException e) {
			logger.error("Exception: ", e);
		}
		return writer.toString();
	}

	/**
	 * Gets the doc for xml.
	 * 
	 * @param xmls
	 *            the xmls
	 * @return the doc for xml
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             the sAX exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static Document getDocForXML(String... xmls) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbf.newDocumentBuilder();
		String xml = xmls[0];
		InputStream is = new ByteArrayInputStream(xml.getBytes("UTF-8"));
		Document doc = docBuilder.parse(is);
		Element root = doc.getDocumentElement();
		for (int i = 1, len = xmls.length; i < len; i++) {
			xml = xmls[i];
			InputStream inputStream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
			DocumentBuilderFactory dbf1 = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder1 = dbf1.newDocumentBuilder();
			Document doc1 = docBuilder1.parse(inputStream);
			Element root1 = doc1.getDocumentElement();
			root.appendChild(doc.importNode(root1, true));
		}
		return doc;
	}

	/**
	 * Gets the matching xpath.
	 * 
	 * @param originalXpath
	 *            the original xpath
	 * @param submittedKey
	 *            the submitted key
	 * @return the matching xpath
	 */
	public static Boolean getMatchingXpath(String originalXpath, String submittedKey) {
		String[] orginalPathvariables = originalXpath.split("/");
		String[] submittedKeyPathvariables = submittedKey.split("/");
		if (orginalPathvariables.length != submittedKeyPathvariables.length) {
			return false;
		}
		for (int i = 0; i < orginalPathvariables.length; i++) {
			if (!orginalPathvariables[i].equalsIgnoreCase(submittedKeyPathvariables[i])) {
				if (orginalPathvariables[i].indexOf("[") > -1 && submittedKeyPathvariables[i].indexOf("[") > -1) {
					String originalPartVariable = orginalPathvariables[i].substring(0, orginalPathvariables[i].indexOf("["));
					String submittedKeyPartvariable = submittedKeyPathvariables[i].substring(0,
							submittedKeyPathvariables[i].indexOf("["));
					if (originalPartVariable.equalsIgnoreCase(submittedKeyPartvariable)) {
						/* found matching element */
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static String getNodeValueForExpression(String string, String dataXML) throws Exception, SAXException, IOException {
		Document doc = getDocForDataXML(dataXML);
		return getNodeValueForExpression(string, doc);
	}

	public static Document getDocForDataXML(String dataXML) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbf.newDocumentBuilder();
		InputStream is = new ByteArrayInputStream(dataXML.getBytes("UTF-8"));
		return docBuilder.parse(is);
	}

	public static void setValueForNode(Node node, Document doc, String data) {
		if (data == null) {
			return;
		}
		NodeList children = node.getChildNodes();
		for (int j = 0; j < children.getLength(); j++) {
			Node value = children.item(j);
			NodeList valueChildren = value.getChildNodes();
			for (int x = 0; x < valueChildren.getLength(); x++) {
				Node cDataNode = valueChildren.item(x);
				if (cDataNode.getNodeName().equals("#cdata-section")) {
					value.removeChild(cDataNode);
				}
			}
		}
		CDATASection cdata = doc.createCDATASection(data);
		Node valueNode = node.appendChild(doc.createElement("value"));
		valueNode.appendChild(cdata);
	}

	// public static String getValueForNode(Node node) {
	// String data = "";
	// if (node == null) {
	// return "";
	// }
	// Node value = null;
	// NodeList children = node.getChildNodes();
	// for (int j = 0; j < children.getLength(); j++) {
	// value = children.item(j);
	// value.getNodeValue();
	// /*NodeList valueChildren = value.getChildNodes();
	// if (valueChildren != null) {
	// int len = valueChildren.getLength()+1;
	// for (int k = 0; k < len; k++) {
	// Node cDataNode = valueChildren.item(k);
	// //
	// data = cDataNode.getNodeValue();
	// }
	// }*/
	// }
	// if(value != null)
	// return value.getNodeValue();
	// else return null;
	//
	// }

	public static String getValueForNode(Node node) {
		String data = "";
		if (node == null) {
			return "";
		}
		NodeList children = node.getChildNodes();
		for (int j = 0; j < children.getLength(); j++) {
			Node value = children.item(j);
			NodeList valueChildren = value.getChildNodes();
			if (valueChildren != null) {
				for (int k = 0; k < valueChildren.getLength(); k++) {
					Node cDataNode = valueChildren.item(k);
					//
					data = cDataNode.getNodeValue();
				}
			}
		}
		return data;
	}

	/**
	 * Returns node for given XPath
	 * 
	 * @param expression
	 * @param doc
	 * @return
	 */
	public static Node getNodeForXPath(String expression, Document doc) {
		Node node = null;
		try {
			node = (Node) xpath.evaluate(expression, doc, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			logger.error("Exception: ", e);
		}
		return node;
	}

	/**
	 * returns value of value child CDATA
	 * 
	 * @param expression
	 * @param doc
	 * @return
	 */
	public static String getNodeValueForExpression(String expression, Document doc) {
		Node node = getNodeForXPath(expression, doc);
		if (node == null) {
			return "";
		}
		String value = getValueForNode(node);
		return value == null ? "" : value;
	}

	public static Element createXMLElement(String elementName, Document doc, Map<String, String> attributes) {
		Element c1 = doc.createElement(elementName);
		if (attributes != null) {
			Set<?> keySet = attributes.keySet();
			Iterator<?> itor = keySet.iterator();
			while (itor.hasNext()) {
				String key = (String) itor.next();
				String value = attributes.get(key);
				c1.setAttribute(key, value);
			}
		}
		return c1;
	}

	/**
	 * returs list of map attribute values for the given XPath expression
	 * 
	 * @param expression
	 * @param doc
	 * @return
	 * @throws XPathExpressionException
	 */
	public static List<String> getMapListForXPath(String expression, Document doc, String attribute)
			throws XPathExpressionException {
		NodeList nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
		List<String> mappersList = new ArrayList<String>();
		int len = nodeList.getLength();
		for (int i = 0; i < len; i++) {
			Node node = nodeList.item(i);
			NamedNodeMap attrs = node.getAttributes();
			Node mapNode = attrs.getNamedItem(attribute);
			mappersList.add(mapNode.getNodeValue());
		}
		return mappersList;
	}

	/**
	 * returns value of value attribute of node
	 * 
	 * @param expression
	 * @param doc
	 * @return
	 */
	public static String getNodeValueForXPath(String expression, Document doc) {
		Node node = null;
		try {
			node = (Node) xpath.evaluate(expression, doc, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			logger.error("Cannot evaluate XPath for expression:" + expression, e);
		}
		if (node == null) {
			return null;
		}
		return node.getNodeValue();
	}

	/**
	 * returs list of map attribute values for the given XPath expression
	 * 
	 * @param expression
	 * @param doc
	 * @return
	 * @throws XPathExpressionException
	 */
	public static void deleteNodes(String expression, Document doc) throws XPathExpressionException {
		NodeList nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
		// List<String> mappersList = new ArrayList<String>();
		int len = nodeList.getLength();
		for (int i = 0; i < len; i++) {
			Node node = nodeList.item(i);
			// NamedNodeMap attrs = node.getAttributes();
			// Node mapNode = attrs.getNamedItem("parent");
			// logger.debug("Removing node with parent::" +
			// mapNode.getNodeValue());
			node.getParentNode().removeChild(node);
		}
	}

	/**
	 * Latest - prefer to use this sets node value
	 * 
	 * @param expression
	 * @param doc
	 * @param value
	 */
	public static void setNodeValueForExpression(String expression, Document doc, String value) {
		Node node = getNodeForXPath(expression, doc);
		if (node == null) {
			return;
		}
		setValueForNodeRemove(node, doc, value);
	}

	public static void setValueForNodeRemove(Node node, Document doc, String data) {
		NodeList children = node.getChildNodes();
		for (int j = 0; j < children.getLength(); j++) {
			Node value = children.item(j);
			if (value != null && value.getNodeName().equals("value")) {
				NodeList valueChildren = value.getChildNodes();
				for (int x = 0; x < valueChildren.getLength(); x++) {
					Node cDataNode = valueChildren.item(x);
					if (cDataNode.getNodeName().equals("#cdata-section")) {
						value.removeChild(cDataNode);
					}
				}
				CDATASection cdata = doc.createCDATASection(data);
				value.appendChild(cdata);
			}
		}
		// CDATASection cdata = doc.createCDATASection(data);
	}

	public static NodeList getNodeListForExpression(String expression, String dataXML) throws Exception {
		Document doc = getDocForDataXML(dataXML);
		return (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
	}

	public static NodeList getNodeListForExpression(String expression, Document doc) throws XPathExpressionException {
		return (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);
	}

	public static String populateXMLinXMLData(String dataXML, Map<String, String> paramsMap) throws ParserConfigurationException,
			SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		paramsMap = replaceNullsWithBlankString(paramsMap);
		InputStream is = new ByteArrayInputStream(dataXML.getBytes());
		Document doc = docBuilder.parse(is);
		if (paramsMap != null && paramsMap.size() > 0) {
			searchXMLAndPopulateInMap(doc, paramsMap, true);
		}
		return XMLUtility.getDocAsString(doc);
	}

	private static Map<String, String> replaceNullsWithBlankString(Map<String, String> paramsMap) {
		for (String key : paramsMap.keySet()) {
			if (paramsMap.get(key) == null) {
				paramsMap.put(key, "");
			}
		}
		return paramsMap;
	}

	/**
	 * @param xmlDoc
	 * @param paramsMap
	 * @param reverse
	 */
	public static void searchXMLAndPopulateInMap(Document xmlDoc, Map<String, String> paramsMap, boolean reverse) {
		NodeList nodeList = xmlDoc.getChildNodes();
		traverseNodeAndSetFields(xmlDoc, nodeList, paramsMap, reverse);
	}

	/**
	 * if reverse then doc would be updated from map
	 * 
	 * @param nodeList
	 * @param paramsMap
	 * @param reverse
	 */
	private static void traverseNodeAndSetFields(Document xmlDoc, NodeList nodeList, Map<String, String> paramsMap, boolean reverse) {
		if (nodeList == null) {
			logger.debug("no child nodes now!!");
			return;
		}

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			NamedNodeMap attributes = node.getAttributes();
			if (attributes != null) {
				Node map = attributes.getNamedItem("map");
				NodeList children = node.getChildNodes();
				for (int j = 0; j < children.getLength(); j++) {
					Node value = children.item(j);
					if (value != null && value.getNodeName().equals("value")) {
						if (map != null && !map.getNodeValue().equals("")) {
							if (!reverse) {
								NodeList valueChildren = value.getChildNodes();
								if (valueChildren != null) {
									for (int k = 0; k < valueChildren.getLength(); k++) {
										Node cDataNode = valueChildren.item(k);
										if (cDataNode.getNodeName().equals("#cdata-section")) {
											paramsMap.put(attributes.getNamedItem("map").getNodeValue(), cDataNode.getNodeValue());
										}
									}
								}
							} else {
								String mapValue = attributes.getNamedItem("map").getNodeValue();
								// Node requiredParentNode = attributes
								// .getNamedItem(AppXMLConstants.requiredParent);
								// String requiredParentValue = "";
								// if (requiredParentNode != null) {
								// logger.debug("Obtained required parent node for map:"
								// + mapValue);
								// requiredParentValue =
								// requiredParentNode.getNodeValue();
								// }

								if (paramsMap.containsKey(mapValue)) {
									// if (!requiredParentValue.equals("")) {
									// String parentValue =
									// paramsMap.get(requiredParentValue);
									// if (parentValue == null
									// || (parentValue != null && parentValue
									// .equals(AppXMLConstants.checkBoxOff))) {
									// logger
									// .debug("Cleaning the value for required dependency for:"
									// + mapValue);
									// paramsMap.put(mapValue, "");
									// }
									// }

									NodeList valueChildren = value.getChildNodes();
									for (int x = 0; x < valueChildren.getLength(); x++) {
										Node cDataNode = valueChildren.item(x);
										if (cDataNode.getNodeName().equals("#cdata-section")) {
											value.removeChild(cDataNode);
										}
									}
									CDATASection cdata = xmlDoc.createCDATASection(paramsMap.get(mapValue));
									value.appendChild(cdata);
								}
							}
						}
					}
				}
			}
			traverseNodeAndSetFields(xmlDoc, node.getChildNodes(), paramsMap, reverse);
		}
	}

	public static HashMap<String, String> getMapFromXML(String dataXML) throws ParserConfigurationException, SAXException,
			IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();

		InputStream is = new ByteArrayInputStream(dataXML.getBytes("UTF-8"));
		Document xmlDoc = docBuilder.parse(is);
		Map<String, String> fieldsMap = new HashMap<String, String>();

		searchXMLAndPopulateInMap(xmlDoc, fieldsMap, false);
		return (HashMap<String, String>) fieldsMap;
	}

	public static HashMap<String, String> getMapFromXML(Document xmlDoc) {
		// DocumentBuilderFactory factory =
		// DocumentBuilderFactory.newInstance();
		// DocumentBuilder docBuilder = factory.newDocumentBuilder();
		//
		// InputStream is = new ByteArrayInputStream(dataXML.getBytes("UTF-8"));
		// Document xmlDoc = docBuilder.parse(is);
		Map<String, String> fieldsMap = new HashMap<String, String>();
		searchXMLAndPopulateInMap(xmlDoc, fieldsMap, false);
		return (HashMap<String, String>) fieldsMap;
	}
	
	public static String prettyFormat(String input, int indent) {
        try
        {
            Source xmlInput = new StreamSource(new StringReader(input));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            // This statement works with JDK 6
            transformerFactory.setAttribute("indent-number", indent);
             
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString();
        }
        catch (Throwable e)
        {
            // You'll come here if you are using JDK 1.5
            // you are getting an the following exeption
            // java.lang.IllegalArgumentException: Not supported: indent-number
            // Use this code (Set the output property in transformer.
            try
            {
                Source xmlInput = new StreamSource(new StringReader(input));
                StringWriter stringWriter = new StringWriter();
                StreamResult xmlOutput = new StreamResult(stringWriter);
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", String.valueOf(indent));
                transformer.transform(xmlInput, xmlOutput);
                return xmlOutput.getWriter().toString();
            }
            catch(Throwable t)
            {
                return input;
            }
        }
    }
}
