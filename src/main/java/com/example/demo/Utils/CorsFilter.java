package com.example.demo.Utils;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


@Component
@WebFilter(urlPatterns = "/*")
public class CorsFilter implements javax.servlet.Filter {

    private String token = null;

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    @ResponseBody
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        //解决跨域
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Methods", "*");
        httpResponse.setHeader("Access-Control-Allow-Headers", "token");
        httpResponse.setHeader("Access-Control-Expose-Headers", "Authentication,Origin, X-Requested-With, Content-Type, token");
        //httpResponse.setHeader("Access-Control-Expose-Headers", "*");


        chain.doFilter(request, response);


    }

    public static void main(String[] args) {
        String[] s = {"a", "b", "c"};
        for (int i = 0; i < s.length; i++) {
            String a = "<tr>"+s[i]+"<tr>";
            System.out.println(a);
            String x = "当前"+s[i];
        }
        HashMap<Object, Object> map = new HashMap<>();
        map.put("a","b");
        map.get("");


    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}
