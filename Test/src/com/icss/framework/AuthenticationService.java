package com.icss.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.icss.framework.dao.BaseDAO;
import com.icss.framework.service.IBaseService;

@Service(value="authService")
public class AuthenticationService implements UserDetailsService{

	@Autowired
	private BaseDAO baseDao;
	
	@Autowired
	private IBaseService baseService;
	
	@SuppressWarnings("rawtypes")
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println(baseDao.find("test.mapper.selectAll", 1).size());
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		com.icss.framework.model.User ad = (com.icss.framework.model.User)baseDao.find("test.mapper.selectAll", null).get(0);
		System.out.println(ad.getUsername());
		List userList = new ArrayList();
		// 事务测试
		for(int i = 0; i < 3; i++) {
			Map user = new HashMap();
			user.put("username", "name" + i);
			userList.add(user);
		}
		baseService.insertList("test.mapper.insertUser", userList);
		System.out.println(username);
		List authList = new ArrayList();
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		// 按照现象来说，返回用户对象之后，spring security会比较用户输入的密码与用户对象中的密码（此行中的"1234"）,如果不相等则登录失败
		return new User("123", "1234", true, true, true, true, authList);
	}
}
