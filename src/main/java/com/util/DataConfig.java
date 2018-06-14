package com.util;

import com.contorller.HelloController;
import com.entity.User;
import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.template.Engine;

/**
 * Created by Vincent on 2018-06-14.
 */
public class DataConfig extends JFinalConfig {

    //配置JFinal常量值
    public void configConstant(Constants constants) {
        PropKit.use("config.properties");
    }

    //配置访问路由
    public void configRoute(Routes routes) {
        routes.add("/hello", HelloController.class);
    }

    //配置Template Engine
    public void configEngine(Engine engine) {

    }

    public void configPlugin(Plugins plugins) {
        C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"),PropKit.get("user"),PropKit.get("password").trim());
        plugins.add(c3p0Plugin);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
        plugins.add(arp);
        arp.addMapping("user",User.class);
    }

    public void configInterceptor(Interceptors interceptors) {

    }

    public void configHandler(Handlers handlers) {

    }

}
