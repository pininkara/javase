// 2022/2/18 13:39

package nnk.boot.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro的内置过滤器
        //anno：无需认证即可访问
        //authc：必须认证
        //user：必须拥有记住我
        //perms：拥有某个资源的权限才能访问
        //role：必须拥有某个角色权限才能访问

        /*Map<String,String> map=new LinkedHashMap<>();
        map.put("/level1/*","authc");
        map.put("/level2/*","authc");
        map.put("/level3/*","authc");
        map.put("/index","anno");
        map.put("/","anno");

        bean.setFilterChainDefinitionMap(map);*/
        return bean;
    }

    //DefaultWebSecurityManager
    @Bean()
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("myRealm") MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);//关联Realm
        return securityManager;
    }


    //创建realm对象，需要自定义类
    @Bean
    public MyRealm myRealm() {
        return new MyRealm();
    }
}
