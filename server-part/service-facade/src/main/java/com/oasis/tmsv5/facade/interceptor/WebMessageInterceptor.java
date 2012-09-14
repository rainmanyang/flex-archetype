package com.oasis.tmsv5.facade.interceptor;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.flex.core.MessageProcessingContext;
import org.springframework.flex.core.ResourceHandlingMessageInterceptor;

import com.oasis.tmsv5.common.ClientContext;

import flex.messaging.io.ArrayCollection;
import flex.messaging.messages.Message;
import flex.messaging.messages.RemotingMessage;

public class WebMessageInterceptor implements
		ResourceHandlingMessageInterceptor {

	@Override
	public Message postProcess(MessageProcessingContext context, Message msg1,
			Message msg2) {
		return msg2;
	}

	@Override
	public Message preProcess(MessageProcessingContext context, Message message) {
		if (message instanceof RemotingMessage) {
			@SuppressWarnings("unchecked")
			List<Object> list = ((RemotingMessage) message).getParameters();
			for (int k = 0; k < list.size(); k++) {
				Object obj = list.get(k);
				if (obj == null) {
					continue;
				}
				if (obj instanceof ArrayCollection) {
					@SuppressWarnings("unchecked")
					List aclist = new ArrayList((List) obj);

					list.set(k, aclist);
				} else if (!(obj instanceof ClientContext)) {
					deal(obj);
				}
			}
		}
		return message;
	}

	private static boolean isBaseType(Class<?> clazz) {
		Class<?>[] clazzs = new Class<?>[] { String.class, Date.class,
				Integer.class, Long.class, int.class, long.class, Double.class,
				double.class, Float.class, float.class, BigDecimal.class,
				boolean.class, Boolean.class, Class.class };
		for (Class<?> cla : clazzs) {
			if (cla == clazz) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private void deal(Object obj) {
		if (obj == null) {
			return;
		}
		try {
			PropertyDescriptor[] pds = Introspector.getBeanInfo(obj.getClass())
					.getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				Class<?> clazz = pd.getPropertyType();
				if (!isBaseType(clazz)) {
					Object fieldValue = getFieldValue(obj, pd);
					if (List.class.isAssignableFrom(clazz)) {
						List list = (List) fieldValue;
						if(list != null){
							pd.getWriteMethod().invoke(obj, new ArrayList(list));

							/**
							 * 对List中的对象做处理
							 */
							for (Object o : list) {
								deal(o);
							}
						}
					} else {
						deal(fieldValue);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Object getFieldValue(Object obj, PropertyDescriptor pd)
			throws Exception {
		Method readMethod = pd.getReadMethod();
		if (readMethod == null) {
			return null;
		} else {
			try {
				return readMethod.invoke(obj, (Object[]) null);
			} catch (InvocationTargetException e) {
				// 有属性,无SET方法
				return null;
			}
		}
	}

	@Override
	public void afterCompletion(MessageProcessingContext context, Message msg1,
			Message msg2, Exception ex) {
		// System.out.println("msg1:" + XStreamUtil.toXml(msg1));
		// System.out.println("msg2:" + XStreamUtil.toXml(msg2));

	}
}
