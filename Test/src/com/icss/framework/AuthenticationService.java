package com.icss.framework;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.icss.framework.service.IDefaultLoginService;

@Service(value="authService")
public class AuthenticationService implements UserDetailsService{

	
	@Autowired
	private IDefaultLoginService defaultLoginService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		boolean userExist = defaultLoginService.isUserExist(username);
        if (!userExist) { 
            throw new UsernameNotFoundException(username);  
        }
		List authList = new ArrayList();
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		
		boolean enables = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
		
		// 按照现象来说，返回用户对象之后，spring security会比较用户输入的密码与用户对象中的密码（此行中的"1234"）,如果不相等则登录失败
		return new User(username, defaultLoginService.findUserpassword(username), enables, accountNonExpired, credentialsNonExpired, accountNonLocked, authList);
	}
}
