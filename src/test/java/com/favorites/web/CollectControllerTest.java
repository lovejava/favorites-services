package com.favorites.web;

import com.favorites.comm.utils.SimpleHttpUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CollectControllerTest {
	
//	private String baseUrl="http://localhost:9090";
//	private String baseUrl="http://192.168.0.59:9090/collect";
	private String baseUrl="http://localhost:9090/collect";

	/**
	 * 获取文章列表
	 * myself+home=首页
	 * myself+favorites=收藏夹
	 * myself+garbage=回收站
	 * myself+explore=发现
	 * myself+centerpage=个人中心页面
	 * others+centerpage=别人个人中心页面
	 * others+favorites=别人公开收藏夹
	 */
	@Test
	public void getCollectList(){
		String res = "";
		String url = baseUrl + "/getCollectList";
		Map<String, String> contents = new HashMap<String, String>();
		contents.put("userId", "10");
		contents.put("page", "0");
		contents.put("myself", "myself");
		contents.put("type", "explore");
		//contents.put("favoritesId", "62");
		res = SimpleHttpUtils.httpPost(url,contents); 
		System.out.println(res);
	}
	
	/**
	 * 文章编辑（新增或者修改）
	 */
	@Test
	public void editCollect(){
		String res = "";
		String url = baseUrl + "/editCollect";
		Map<String, String> contents = new HashMap<String, String>();
		contents.put("userId", "10");
		contents.put("type", "save");
		contents.put("title", "博客园 - 开发者的网上家园");
		contents.put("url", "http://www.cnblogs.com/");
		contents.put("description", "博客园是一个面向开发者的知识分享社区。自创建以来，博客园一直致力并专注于为开发者打造一个纯净的技术交流社区，推动并帮助开发者通过互联网分享知识，从而让更多开发者从中受益。博客园的使命是帮助开发者用代码改变世界。");
		contents.put("logoUrl", "http://www.cnblogs.com/images/logo_small.gif");
		contents.put("charset", "UTF-8");
		contents.put("collectType", "private");
		contents.put("newFavorites", "");
		contents.put("remark", "修改操作");
		contents.put("favoritesId", "42");
		//contents.put("id", "94");
		res = SimpleHttpUtils.httpPost(url,contents); 
		System.out.println(res);
	}
	
	@Test
	public void getCollectById(){
		String res = "";
		String url = baseUrl + "/getCollectById";
		Map<String, String> contents = new HashMap<String, String>();
		contents.put("id", "94");
		contents.put("authorization","1_42e8e9693ddd15617cc2dc1e1107665d");
		res = SimpleHttpUtils.httpPost(url,contents); 
		System.out.println(res);
	}
	
	@Test
	public void delCollect(){
		String res = "";
		String url = baseUrl + "/delCollect";
		Map<String, String> contents = new HashMap<String, String>();
		contents.put("id", "94");
		contents.put("userId", "1");
		res = SimpleHttpUtils.httpPost(url,contents); 
		System.out.println(res);
	}
	
	@Test
	public void likeAndUnlike(){
		String res = "";
		String url = baseUrl + "/likeAndUnlike";
		Map<String, String> contents = new HashMap<String, String>();
		contents.put("collectId", "93");
		contents.put("userId", "3");
		res = SimpleHttpUtils.httpPost(url,contents); 
		System.out.println(res);
	}
	
	@Test
	public void changePrivacy() {
		String res = "";
		String url = baseUrl + "/changePrivacy";
		Map<String, String> contents = new HashMap<String, String>();
		contents.put("collectId", "93");
		contents.put("userId", "1");
		res = SimpleHttpUtils.httpPost(url, contents);
		System.out.println(res);
	}
	
	@Test
	public void searchByKey() {
		String res = "";
		String url = baseUrl + "/search";
		Map<String, String> contents = new HashMap<String, String>();
		contents.put("authorization", "1_5825b3ce0f9c7585bc04866d12b92348");
		contents.put("userId", "1");
		contents.put("myself", "other");
		contents.put("key", "电影");
		res = SimpleHttpUtils.httpPost(url, contents);
		System.out.println(res);
	}
	
}
