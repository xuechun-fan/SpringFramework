## 常规依赖
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.9.RELEASE</version>
</dependency>

<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.6</version>
</dependency>
```
## 注解说明
- @Autowired ： 通过类型自动装配，名字。
    如果Autowired不能唯一自动装配上属性，则需要通过 @Qualifier(value="xxx") 注解来确定唯一的装配的bean对象
- @Nullable ： 字段标记了这个注解，则该字段可以为 null
- @Resource ： 自动装配通过名字。类型
- @Component ：组件，修饰类，说明这个类被Spring管理，放入了IOC容器中
- @Value ： 该注解作用是给属性值注入