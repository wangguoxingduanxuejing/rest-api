package com.wgx.restapi.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wgx.restapi.demo.user.User;

@RestController
@RequestMapping("/demo")
public class DemoApi {
	
	private static final Log log = LogFactory.getLog(DemoApi.class);

	/**
	 * get请求 获取列表
	 * @return
	 */
	@GetMapping
	public List<User> getAllUsers(){
		List <User>list = new ArrayList();
		
		User user1 = new User(1,"张山",19,"男",getDate(1987,12,12));
		User user2 = new User(2,"李四",21,"男",getDate(1989,11,11));
		User user3 = new User(3,"小红",17,"女",getDate(1991,5,20));
		list.add(user1);
		list.add(user2);
		list.add(user3);
		log.info("getAllUsers 接口请求成功");
		return list;
	}
	
	/**
	 * get请求 获取单个对象
	 * @PathVariable解析参数注解
	 * @param id
	 * @return
	 */
	@GetMapping(value="/{id}")
	public User getUserById(@PathVariable int id){
		User user1 = new User(1,"张山",19,"男",getDate(1987,12,12));
		User user2 = new User(2,"李四",21,"男",getDate(1989,11,11));
		User user3 = new User(3,"小红",17,"女",getDate(1991,5,20));
		log.info("getUserById 单数据接口请求成功");
		switch (id) {
		case 1:
			return user1;
		case 2:
			return user2;
		case 3:
			return user3;

		default:
			return null;
		}
		
		
	}
	/**
	 * post 请求 添加接口RequestBody只能接受json数据
	 * @param user
	 */
	@PostMapping
	public User addUser(@RequestBody User user){
		user.setId(999);
		log.info("addUser 添加接口请求成功");
		log.info(user.toString());
		return user;
	}
		
	/**
	 * 修改文件
	 * @param id
	 * @return
	 */
	@PutMapping(value="/{id}")
	public User editUser(@PathVariable int id){
		User user = new User(1,"张山",19,"男",getDate(1987,12,12));
		if(id==1){
			user.setAge(100);
		}
		log.info("修改方法 执行正常");
		return user;
	}
	
	/**
	 * 单个 删除
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delUser(@PathVariable int id){
		if(id==2){
			log.info("删除方法执行正常");
		}
	}
	/**
	 * 
	 * 单个文件上传
	 * @throws IOException 
	 */
	@PostMapping(value="/{id}/photo",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public void upData(@PathVariable int id,@RequestParam("photo") MultipartFile photo) throws IOException{
		FileOutputStream fs = new FileOutputStream("target/"+photo.getOriginalFilename());
		IOUtils.copy(photo.getInputStream(), fs);
		fs.close();
		log.info("单个文件上传 完毕");
	}
	/**
	 * 带其他数据的form表单提交
	 * @param id
	 * @param user
	 * @throws IOException
	 */
	@PostMapping(value="/{id}/form")
	public User commitForm(@PathVariable int id,@ModelAttribute User user) throws IOException{
		FileOutputStream fs = new FileOutputStream("target/"+user.getIdPhoto().getOriginalFilename());
		IOUtils.copy(user.getIdPhoto().getInputStream(), fs);
		fs.close();
		log.info("多个个文件上传 完毕");
		log.info(user.toString());
		user.setBirthday(getDate(1987,12,12));
		user.setIdPhoto(null);//不能返回带文件的json数据 注意
		return user;
	}
	/**
	 * 下载单个文件
	 * @param id
	 * @return
	 * @throws IOException
	 */
	@GetMapping(value="/{id}/idphoto",produces=MediaType.IMAGE_PNG_VALUE)
	public byte[] downFile(@PathVariable int id) throws IOException{
		String url = "target/wgx2.png";
		InputStream is = new FileInputStream(url);
		log.info("downFile 下载文件方法正常执行");
		return IOUtils.toByteArray(is);
	}
	/**
	 * get普通参数传递测试
	 * @param id
	 * @param user
	 * @return
	 */
	@GetMapping(value="/{id}/gettest")
	public String getTest(@PathVariable int id,@ModelAttribute User user){
		log.info(user.getName());
		log.info("至少能进来");
		return "没事写着玩";
	}
	
	/**
	 * post原生传递测试
	 * @param id
	 * @param user
	 * @return
	 */
	@PostMapping(value="/{id}/posttest")
	public String postTest(@PathVariable int id,@ModelAttribute User user){
		log.info(user.getName());
		log.info("至少能进来");
		return "没事写着玩";
	}
	/**
	 * 私有方法 获取制定时间
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	private static Date getDate(int year,int month,int day){
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		
		return calendar.getTime();
		
	}

}
