package com.zda.feignClient.agentHttpClient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zda.feignClient.dtos.ApiResult;
import com.zda.feignClient.dtos.Person;
import com.zda.feignClient.dtos.son;

@RestController
public class AllrequestController {

@Autowired
private UserHttpClient userHttpClient;
	
	@GetMapping(value="person")
	public  List  getPerson( ) {
		System.out.println("coming============>");
		son son=new son();
		son.setAge(12);
		son.setName("内部");
		Person person=new Person(1, "张三", "44");
		person.setSon(son);
		ApiResult<List<Person>> list = userHttpClient.getApiList(person,"附件名");
		list.getResulT().forEach(a -> {
			System.out.println(a.getId() + "===" + a.getAge() + "===" + a.getName());
		});
		return list.getResulT();
	}

	@GetMapping(value="personA")
	public  List  getApiresultList2( ) {
		System.out.println("coming============>");
	
		ApiResult<List<Person>> list = userHttpClient.getApiList("张三","李四");
		list.getResulT().forEach(a -> {
			System.out.println(a.getId() + "===" + a.getAge() + "===" + a.getName());
		});
		return list.getResulT();
	}
	@GetMapping(value="personc")
	public  Person  postBackPerson( ) {
		System.out.println("coming============>");
		son son=new son();
		son.setAge(12);
		son.setName("内部");
		Person person=new Person(1, "张三", "44");
		person.setSon(son);
		ApiResult<Person> list = userHttpClient.postBackApiresult(person,"李四");

		return list.getResulT();
	}
	@GetMapping(value="persond")
	public  List<Person>  postBackApiresultList( ) {
		System.out.println("coming============>");
		son son=new son();
		son.setAge(12);
		son.setName("内部");
		Person person=new Person(1, "张三", "44");
		person.setSon(son);
		ApiResult<List<Person>> list = userHttpClient.postBackApiresultList(person,"李四");

		return list.getResulT();
	}
	@GetMapping(value="persone")
	public  List<Person>  putApiPersonList( ) {
		System.out.println("coming============>");
	
		List<Person > list=new ArrayList<Person>();
		for (int i = 0; i < 3; i++) {
			Person person = new Person(i, "putApiPersonList", "年龄");
			son son=new son();
			son.setAge(12+i);
			son.setName("内部"+i);
			person.setSon(son);
			list.add(person);
		}
		ApiResult<List<Person >> apr=new ApiResult<List<Person >>(list, "putApiPersonList", true);
		
		ApiResult<List<Person>> lista = userHttpClient.putApiPersonList(apr,"李四");

		return lista.getResulT();
	}
}
