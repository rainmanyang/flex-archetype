package com.oasis.tmsv5.util.tools;


import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XStreamUtil {
    public static <T> String toXml(T obj) {
        XStream xs = new XStream();
        String xml = xs.toXML(obj);
        return xml;
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromXml(String xml, Class<T> cls) {
        if (cls == null)
            return null;
        XStream xs = new XStream(new DomDriver());
        return (T) xs.fromXML(xml);
    }

    public static <T> List<String> toXmlList(List<T> list) {
        List<String> xmlList = new ArrayList<String>();
        XStream xs = new XStream();
        for (T t : list) {
            xmlList.add(xs.toXML(t));
        }
        return xmlList;
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> fromXmlList(List<String> xmlList, Class<T> cls) {
        List<T> objList = new ArrayList<T>();
        XStream xs = new XStream(new DomDriver());
        for (String xml : xmlList) {
            objList.add((T) xs.fromXML(xml));
        }
        return objList;
    }   

}
