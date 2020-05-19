package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.ErrorPageFilter;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class ServletInit extends SpringBootServletInitializer {
    @Bean
    public FilterRegistrationBean siteMeshFilterRegistrationBean(){
        FilterRegistrationBean registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setOrder(1);
        registrationBean.setFilter(new SiteMeshFilter());
        registrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean  strutsPrepareAndExecuteFilterRegistrationBean(){
        FilterRegistrationBean registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(new StrutsPrepareAndExecuteFilter());
        registrationBean.setOrder(2);
        registrationBean.addUrlPatterns("/");
        registrationBean.addUrlPatterns("/addUserForm.action");
        registrationBean.addUrlPatterns("/addUser.action");
        registrationBean.addUrlPatterns("/findUserForm.action");
        registrationBean.addUrlPatterns("/findUser.action");
        registrationBean.addUrlPatterns("/listAllUsers.action");
        registrationBean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.FORWARD);
        return registrationBean;
    }
}


//        urlPattern.add("/");
//        urlPattern.add("/addUserForm.action");
//        urlPattern.add("/addUser.action");
//        urlPattern.add("/findUserForm.action");
//        urlPattern.add("/findUser.action");
//        urlPattern.add("/listAllUsers.action");
