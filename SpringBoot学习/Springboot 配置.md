## Springboot 配置

### 1、yaml可以直接给实体类赋值



## Springboot Web开发

jar：webapp！

自动装配

springboot 到底帮我们配置了什么？能否修改？能修改哪些？能不能扩展？

- xxxAutoConfiguration.. 向容器中自动配置组件
- xxxx.properties：自动配置类，装配配置文件中自定义的一些内容



要解决的问题：

- 导入静态资源。。。
- 首页
- jsp，模板引擎 Thymeleaf
- 装配扩展 SpringMVC
- 增删改查
- 拦截器
- 国际化

### 1、静态资源

```java
@Override
protected void addResourceHandlers(ResourceHandlerRegistry registry) {
    super.addResourceHandlers(registry);
    if (!this.resourceProperties.isAddMappings()) {
        logger.debug("Default resource handling disabled");
        return;
    }
    ServletContext servletContext = getServletContext();
    addResourceHandler(registry, "/webjars/**", "classpath:/META-INF/resources/webjars/");
    addResourceHandler(registry, this.mvcProperties.getStaticPathPattern(), (registration) -> {
        registration.addResourceLocations(this.resourceProperties.getStaticLocations());
        if (servletContext != null) {
            registration.addResourceLocations(new ServletContextResource(servletContext, SERVLET_LOCATION));
        }
    });
}
```



**总结：**

1. 在springboot，我们可以使用以下方式处理静态资源
   - webjars	localhost:8080/webjars/
   - resources、static、public、/**        localhost:8080/
2. 优先级： resources > static(默认) > public



### 2、首页如何定制



### 3、模板引擎

**结论：**只要需要使用 thymleaf ，只需要导入对应的依赖就可以了！我们将html放在我们的 templates 目录下即可。

```java
public static final String DEFAULT_PREFIX = "classpath:/templates/";

public static final String DEFAULT_SUFFIX = ".html";
```



### 4、

在springboot中，有非常多的 xxx Configuration类帮助我们进行扩展配置，只要看见了这个东西，我们就要注意了！

### 5、页面国际化：

1. 我们需要配置i18n配置文件

2. 我们如果需要在项目中进行按钮自动切换，我们需要自定义一个组件 LocaleResolver ，即写一个自定义类实现LocaleResolver接口，并重写`public Locale resolveLocale(HttpServletRequest request)`方法，根据请求参数，封装成 `Locale` 实例，并返回。

3. 最后在我们自定义的 `MyMvcConfig` 中使用 `@Bean` 注解将自定义`LocaleResolver `组件注册到spring容器中。

4. 原理是我们在 html 页面文件中 使用 `#{}` 运算符动态获取内容。

   `th:href="@{/index.html?(l=zh_CN)}"` `th:placeholder="#{login.password}"`

### 6、登陆 + 拦截器

### 7、员工列表展示

1. 提取公共页面
    - `th:fragment='sidebar'`
    - `th:replace="~{commons/commons::sidebar}"`
    - 如果需要传递参数，可以直接使用`()`传参，接收判断即可。判断多用三元表达式。`th:replace="~{commons/commons::sidebar(param='value')}"`
2. 列表循环展示
    1. 按钮提交
    2. 跳转到添加页面
    3. 添加员工成功
    4. 返回员工信息页面

**CRUD搞定了**

### 8、404处理

