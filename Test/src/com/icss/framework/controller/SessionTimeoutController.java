package com.icss.framework.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SessionTimeoutController {

	@RequestMapping(value = "/sessiontimeout")
	public void sessionTimeout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String requesturl = request.getRequestURI();
		if(request.getHeader("x-requested-with") != null &&
				request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
			response.setHeader("sessionstatus", "timeout");
			ObjectMapper objectMapper = new ObjectMapper();
			response.setHeader("Content-Type", "application/json;charset=UTF-8");
			JsonGenerator jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(),
					JsonEncoding.UTF8);
			try {
				Map re = new HashMap();
				re.put("timeout", "1");
				objectMapper.writeValue(jsonGenerator, re);
			} catch (JsonProcessingException ex) {
				throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}
}
