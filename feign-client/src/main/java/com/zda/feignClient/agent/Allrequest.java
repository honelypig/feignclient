package com.zda.feignClient.agent;

import java.util.ArrayList;
import java.util.List;

import com.zda.feignClient.dtos.ApiResult;
import com.zda.feignClient.dtos.Person;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

public class Allrequest {
	public static AllRequestClient getClient() {
		return Feign.builder()// feign客户端
				.decoder(new GsonDecoder())// 解码器
				.encoder(new GsonEncoder())// 编码器
				.target(AllRequestClient.class, // 接口类
						"http://localhost:8082");
	}

	public static void main(String[] args) {
		deletePersonList(getClient());
	}

	// get
	public static void getList(AllRequestClient client) {
		List<Person> list = client.getList("哈尼豬豬");
		list.forEach(a -> {
			System.out.println(a.getId() + "===" + a.getAge() + "===" + a.getName());
		});
	}

	public static void getApiresultList(AllRequestClient client) {
		ApiResult<List<Person>> list = client.getApiList("哈尼豬豬", "20");
		list.getResulT().forEach(a -> {
			System.out.println(a.getId() + "===" + a.getAge() + "===" + a.getName());
		});
	}
	// post
	public static void getPost(AllRequestClient client) {
		Person person = new Person(1, "getPost", "年龄");
		Person a = client.postBackPerson(person, "20");
		System.out.println(a.getId() + "===" + a.getAge() + "===" + a.getName());

	}

	public static void getApiresultPost(AllRequestClient client) {
		Person person = new Person(1, "getApiresultPost", "年龄");
		ApiResult<Person> apiResult = client.postBackApiresult(person, "20");
		System.out.println(apiResult.getMsg() + "===" + apiResult.getSuccessful() + "===" + apiResult.getResulT());
		Person a = apiResult.getResulT();
		System.out.println(a.getId() + "===" + a.getAge() + "===" + a.getName());

	}
	
	
	//put
	
	public static void  putPerson(AllRequestClient client) {
		Person person = new Person(1, "putPerson", "年龄");
		Person a = client.putPerson(person, "20");
		System.out.println(a.getId() + "===" + a.getAge() + "===" + a.getName());

	};


	public static void  putPersonList(AllRequestClient client) {
		List<Person > list=new ArrayList<Person>();
		for (int i = 0; i < 3; i++) {
			Person person = new Person(i, "putPersonList", "年龄");
			list.add(person);
		}
		List<Person> list2 = client.putPersonList(list, "20");
		list2.forEach(a->{
			System.out.println(a.getId() + "===" + a.getAge() + "===" + a.getName());
		});
	
	};
	
	public static void  putApiPersonList(AllRequestClient client) {
		List<Person > list=new ArrayList<Person>();
		for (int i = 0; i < 3; i++) {
			Person person = new Person(i, "putApiPersonList", "年龄");
			list.add(person);
		}
		ApiResult<List<Person >> apr=new ApiResult<List<Person >>(list, "putApiPersonList", true);
		ApiResult<List<Person >> result= client.putApiPersonList(apr, "20");
		List<Person> list2 = result.getResulT();
		list2.forEach(a->{
			System.out.println(a.getId() + "===" + a.getAge() + "===" + a.getName());
		});
	};

	//delete
	public static void  deletePersonList(AllRequestClient client){
		List<Person > list=new ArrayList<Person>();
		for (int i = 0; i < 3; i++) {
			Person person = new Person(i, "putApiPersonList", "年龄");
			list.add(person);
		}
		client.deletePersonList(list, "张三李四");
	};
	
}
