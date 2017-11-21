package com.lushunde.springboot.junit.controllerTest;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.lushunde.springboot.junit.StartBootstarp;
import com.lushunde.springboot.junit.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StartBootstarp.class)
@WebAppConfiguration
public class UserControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setupMockMvc() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	/***
	 * 测试根据用户id获取用户信息接口
	 * 
	 * @throws Exception
	 */
	@Test
	public void getUserTest() throws Exception {
		String responce = mockMvc
				.perform(get("/user/getUser").contentType(MediaType.APPLICATION_FORM_URLENCODED) // 请求数据的格式
						.param("token", "zhangsan") // 相当于直接写在url上的参数
						.param("id", "2"))
				.andExpect(status().isOk()) // 比较结果
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$.id", is(2)))
				.andExpect(jsonPath("$.username", is("lisi"))).andExpect(jsonPath("$.age", is(21)))
				// .andDo(System.out.println()) //打印出请求和相应的内容
				.andReturn().getResponse().getContentAsString();

		System.out.println(responce);
	}

	/***
	 * 测试添加用户接口
	 * 
	 * @throws Exception
	 */
	@Test
	public void saveUserTest() throws Exception {
		// 构造添加的用户信息
		User user = new User();
		user.setAddress("上海市");
		user.setAge(69);
		user.setUsername("xiao7");
		user.setPassword("xiao7");
		System.out.println(JSON.toJSONString(user));
		// 调用接口，传入添加的用户参数
		String response = mockMvc
				.perform(post("/user/saveUser").contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(user))
						.header("SESSIONNO", "EA60F3C2C7384DBA8A7B8B114474DC12"))
				.andReturn().getResponse().getContentAsString();
		System.out.println(response);

	}

	/***
	 * 测试更新用户信息接口
	 * 
	 * @throws Exception
	 */
	@Test
	public void updateUserTest() throws Exception {
		User user = new User();
		user.setId(6l);
		user.setAddress("上海市");
		user.setAge(69);
		user.setUsername("xiao9");
		user.setPassword("xiao9");
		// 调用接口，传入添加的用户参数
		String response = mockMvc
				.perform(post("/user/updateUser").contentType(MediaType.APPLICATION_JSON)
						.content(JSON.toJSONString(user)).header("SESSIONNO", "EA60F3C2C7384DBA8A7B8B114474DC12"))
				.andReturn().getResponse().getContentAsString();
		System.out.println(response);
		System.out.println(response);
	}

	/***
	 * 测试获取用户列表接口
	 * 
	 * @throws Exception
	 */
	@Test
	public void deleteUser() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/user/deleteUser?id=2");

		String perform = mockMvc.perform(request).andReturn().toString();
		System.out.println(perform);
	}

}
