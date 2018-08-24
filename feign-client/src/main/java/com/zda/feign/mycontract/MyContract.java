package com.zda.feign.mycontract;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.springframework.cloud.netflix.feign.support.SpringMvcContract;

import feign.MethodMetadata;

public class MyContract extends SpringMvcContract {

	@Override
	protected void processAnnotationOnMethod(MethodMetadata data,
			Annotation annotation, Method method) {
		super.processAnnotationOnMethod(data, annotation, method);
		// 注解是MyUrl类型的，才处理
		if(MyUrl.class.isInstance(annotation)) {
			System.out.println("==========>  这是自定义翻译器");
			MyUrl myUrl = method.getAnnotation(MyUrl.class);
			String url = myUrl.url();
			String httpMethod = myUrl.method();
			data.template().method(httpMethod);
			data.template().append(url);
		}
	}

}
