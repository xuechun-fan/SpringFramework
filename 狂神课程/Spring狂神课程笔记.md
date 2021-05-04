# Spring狂神课程笔记

## 1、Spring

## 2、IOC理论推导

## 3、HelloSpring

## 4、IOC创建对象的方式

## 5、Spring配置

## 6、依赖注入

### 6.1、构造器注入

第五章已叙述

### 6.2、Set方式注入【重点】

- 依赖注入：Set注入！
  1. 依赖：bean对象的创建依赖于容器
  2. 注入：bean对象中的所有属性，由容器来注入

【环境搭建】

1. 复杂类型

   ```java
   public class Address {
       private String address;
   
       public String getAddress() {
           return address;
       }
   
       public void setAddress(String address) {
           this.address = address;
       }
   }
   ```

   

2. 真实测试对象

   ```java
   public class Student {
       private String name;
       private Address address;
       private String[] books;
       private List<String> hobby;
       private Map<String, String> card;
       private Set<String> games;
       private String wife;
       private Properties info;
       // 此处省略了getter 和 setter 方法
   }
   ```

3. beans.xml

```xml
<!-- 第一种，普通值注入，直接使用property标签中的value字段 -->
<bean id="student" class="com.fxc.pojo.Student">
    <property name="name" value="张三"/>
</bean>
```

4. 测试类

```java
public class Test1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student)context.getBean("student");
        System.out.println(student.toString());
    }
}
//	输出
//Student{name='张三', address=null, books=null, hobby=null, card=null, games=null, wife='null', info=null}
```

**完善后**

1. xml配置文件

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:p="http://www.springframework.org/schema/p"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd">
   
   
       <bean id="addr" class="com.fxc.pojo.Address">
           <property name="address" value="大连海事大学"/>
       </bean>
   
       <bean id="student" class="com.fxc.pojo.Student">
           <!-- 第一种，普通值注入，直接使用property标签中的value字段 -->
           <property name="name" value="张三"/>
   
           <!--第二种，Bean注入，使用ref字段-->
           <property name="address" ref="addr"/>
   
           <!--第三种，数组注入-->
           <property name="books">
               <array>
                   <value>红楼梦</value>
                   <value>西游记</value>
                   <value>水浒传</value>
                   <value>三国演义</value>
               </array>
           </property>
   
           <!--第四种，List注入-->
           <property name="hobby">
               <list>
                   <value>听音乐</value>
                   <value>打篮球</value>
                   <value>看电影</value>
               </list>
           </property>
   
           <!--第五种，Map注入-->
           <property name="card">
               <map>
                   <entry key="身份证" value="121212111111111111"/>
                   <entry key="银行卡" value="43577853478973946892"/>
               </map>
           </property>
   
           <!--第五种，Set注入-->
           <property name="games">
               <set>
                   <value>LOL</value>
                   <value>PUBG</value>
               </set>
           </property>
   
           <!--第六种：null值注入-->
           <property name="wife" value=""/>
           
           <!--第六种：Properties注入-->
           <property name="info">
               <props>
                   <prop key="学号">2220141093</prop>
                   <prop key="语文">99</prop>
                   <prop key="数学">103</prop>
               </props>
           </property>
   
       </bean>
   </beans>
   ```

2. 测试类和输出

   ```java
   public class Test1 {
       public static void main(String[] args) {
           ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
           Student student = (Student)context.getBean("student");
           System.out.println(student.toString());
       }
   }
   ```

   输出：

   ```tex
   Student{
       name='张三', 
       address=Address{
           address='大连海事大学'
           }, 
       books=[红楼梦, 西游记, 水浒传, 三国演义], 
       hobby=[听音乐, 打篮球, 看电影], 
       card={
           身份证=121212111111111111, 
           银行卡=43577853478973946892
           }, 
       games=[LOL, PUBG], 
       wife='', 
       info={
           学号=2220141093, 
           语文=99, 
           数学=103
           }
   }
   ```

### 6.3、命名空间注入

- p命名空间注入

  在<beans>标签中添加，p即property缩写

  ```xml
  xmlns:p="http://www.springframework.org/schema/p"
  ```

  使用：

  ```xml
  <!--p命名空间直接注入属性-->
  <bean id="user" class="com.fxc.pojo.User" p:name="李四" p:age="23"/>
  ```

  

- c命名空间注入

  在<beans>标签中添加，c即构造器的缩写

  ```xml
  xmlns:c="http://www.springframework.org/schema/c"
  ```

  使用：

  ```xml
  <!--p命名空间直接注入属性-->
  <bean id="user2" class="com.fxc.pojo.User" c:name="王五" c:age="65"/>
  ```

这里需要注意的是，使用p和c空间需要注意bean类的构造方法的定义，需要将无参显示定义，有参也是如此，否则会出错

### 6.4、bean的作用域

| Scope                                                        | Description                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [singleton](https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/core.html#beans-factory-scopes-singleton) | (默认)将每个 Spring IoC 容器的单个 bean 定义范围限定为单个对象实例。 |
| [prototype](https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/core.html#beans-factory-scopes-prototype) | 将单个 bean 定义的作用域限定为任意数量的对象实例。           |
| [request](https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/core.html#beans-factory-scopes-request) | 将单个 bean 定义的范围限定为单个 HTTP 请求的生命周期。也就是说，每个 HTTP 请求都有一个在单个 bean 定义后面创建的 bean 实例。仅在可感知网络的 Spring `ApplicationContext`中有效。 |
| [session](https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/core.html#beans-factory-scopes-session) | 将单个 bean 定义的范围限定为 HTTP `Session`的生命周期。仅在可感知网络的 Spring `ApplicationContext`上下文中有效。 |
| [application](https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/core.html#beans-factory-scopes-application) | 将单个 bean 定义的范围限定为`ServletContext`的生命周期。仅在可感知网络的 Spring `ApplicationContext`上下文中有效。 |
| [websocket](https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/web.html#websocket-stomp-websocket-scope) | 将单个 bean 定义的范围限定为`WebSocket`的生命周期。仅在可感知网络的 Spring `ApplicationContext`上下文中有效。 |

1. 单例模式（Spring默认机制）

   ```xml
   <!--在bean标签中，使用scope字段显式声明为单例模式(默认就是单例模式）-->
   <bean id="instanceSingleton" class="com.fxc.pojo.User" scope="singleton">
       <property name="name" value="莉莉"/>
       <property name="age" value="18"/>
   </bean>
   ```

2. ProtoType原型模式：每次从容器中get的时候，都会产生一个新的对象

   ```xml
   <!--在bean标签中，使用scope字段显式声明为prototype模式，则创建出的对象都是独立的-->
   <bean id="instancePrototype" class="com.fxc.pojo.User" scope="prototype">
       <property name="name" value="莉莉"/>
       <property name="age" value="18"/>
   </bean>
   ```

3. 其余的request、session、application、websocket只能在web开发中使用到！

## 7、Bean的自动装配

- 自动装配是Spring满足bean依赖的一种方式
- Spring会在上下文中自动寻找，并自动给bean装配属性

在Spring中有三种装配的方式

1. 在xml中显示的配置
2. 在java中显示配置
3. **隐式：spring的自动装配【重要】**

### 7.1 、测试

环境搭建：一个人由两个宠物

```java
//	file:People.class
public class People {
    private Dog dog;
    private Cat cat;
    private String name;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "dog=" + dog +
                ", cat=" + cat +
                ", name='" + name + '\'' +
                '}';
    }
}
```

```java
public class Dog {
    public void shout(){
        System.out.println("wang---");
    }
}

public class Cat {
    public void shout(){
        System.out.println("miao---");
    }
}
```

xml显示配置装配

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    <bean id="cat" class="com.fxc.pojo.Cat"/>
    <bean id="dog" class="com.fxc.pojo.Dog"/>

    <bean id="people" class="com.fxc.pojo.People">
        <property name="name" value="张三"/>
        <property name="cat" ref="cat"/>
        <property name="dog" ref="dog"/>
    </bean>
</beans>
```

### 7.2、ByName、ByType自动装配

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">
    
    <bean id="cat" class="com.fxc.pojo.Cat"/>
    <bean id="dog" class="com.fxc.pojo.Dog"/>
    
    <!--使用bean标签中的 autowired 字段设置自动装配方式-->
    <!--
        byName：会自动在容器上下文中查找，和自己对象set方法后面的值对应的beanId
    -->
    <bean id="peopleAutowiredByName" class="com.fxc.pojo.People" autowire="byName">
        <property name="name" value="张三"/>
    </bean>

    <!--
        byType：会自动在容器上下文中查找，和自己对象属性类型相同的bean
    -->
    <bean id="peopleAutowiredByType" class="com.fxc.pojo.People" autowire="byType">
        <property name="name" value="张三"/>
    </bean>
</beans>
```

**小结：**

- byName：需要保证所有bean的id唯一，并且这个bean需要和自动注入的属性的set方法的值一致！
- byType：需要保证所有bean的class唯一，并且这个bean需要和自动注入的属性的类型一致！

### 7.3、使用注解实现自动装配

jdk1.5支持的注解，Spring2.5就支持注解了！

要使用注解须知：

1. 导入约束

2. 配置注解的支持：\<context:annotation-config/> 【重要】

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context
           http://www.springframework.org/schema/context/spring-context.xsd">
   
       <context:annotation-config/>
   
   </beans>
   ```

**@Autowired**

直接在属性上使用即可！也可以在set方法上使用

使用 Autowired 我们可以不用编写Set方法了，前提是自动装配的属性在 IOC (Spring) 容器中存在，且复合名字byNmae。

科普：

```java
@Nullable	该注解标记的字段，说明这个字段可以为null
```

Autowired注解源码：

```java
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

	/**
	 * Declares whether the annotated dependency is required.
	 * <p>Defaults to {@code true}.
	 */
	boolean required() default true;

}
```

测试代码：

```java
public class People {
    //  如果显示定义了该注解的required属性未false，说明这个对象可以为null，否则不允许为空
    @Autowired(required = false)
    private Dog dog;
    @Autowired
    private Cat cat;
    private String name;
}
```



如果 @Autowired 自动装配的环境比较复杂，自动装配无法通过一个注解【@Autowired】完成的时候，
我们可以使用【@Qualifier(value = "beanId")】去配合【@Autowired】，指定一个唯一的bean对象。

```java
@Autowired
@Qualifier(value = "cat111")
private Cat cat;
```



**@Resource注解**

```java
public class People{
    @Resource(name="cat2")
    private Cat cat;
    
    @Resource
    private Dog dog;
}
```

**小结：** **@Autowired** 和 **@Resource注解** 的区别：

- 都是用来自动装配的，都可以放在属性字段上
- **@Autowired** 通过 byType 方式实现，而且必须要求这个对象存在！【常用】，如果bean对象不唯一，则需要 @Qualifier(value = "beanId") 注解去配合 @Autowired 可以确定唯一的注入的 bean 对象
-  **@Resource注解** 默认通过 byName 的方式实现，如果找不到名字，则通过 byType 实现！如果两个都找不到的情况下，就报错！【常用】
- 执行顺序不同：**@Autowired** 通过 byType 方式实现； **@Resource注解** 默认通过 byName 的方式实现

## 8、使用注解开发

在Spring4之后，要使用注解开发，必须要保证AOP的包导入了

使用注解需要导入 context 约束，增加注解的支持！

1. bean

   ```java
   @Component  //  等价于配置文件中配置了bean标签
   public class User {
       public String name = "张三";
   }
   ```

2. 属性如何注入

   ```java
   //	方式1
   @Data
   @Component  
   public class User {
       @Value("周董")	//	@value注解就是给属性注入值
       public String name;
   }
   
   //	方式2
   @Component
   public class User {
       public String name;
   
       @Value("周董")	//	@Value注解放在setter方法上也能实现属性值注入
       public void setName(String name) {
           this.name = name;
       }
   }
   ```

   

3. 衍生的注解

   @Component 有几个衍生注解，我们在 web 开发中，会按照 mvc 三层架构分层！

   - dao 【@Repository】

   - service 【@Service】

   - controller 【@Controller】

     **这四个注解功能都是一样的，都是代表将某个类注册到Spring中，装配Bean**

4. 自动装配

   @Autowired		@Qualifier(value="xxx")	    @Resource(name="xxx")

5. 作用域

   @Scope("singleton")

6. 小结

   - xml 更加万能，适用于任何场合！维护更加方便
   - 注解 不是自己类是用不了，维护相对复杂！

   **xml 与 注解最佳实践：**

   - xml 用来管理bean

   - 注解只负责完成属性的注入

   - 我们在使用的过程中，只需要注意一个问题：必须要让注解生效，就需要开启注解的支持和扫描包的配置

     ```xml
     <!--开启注解的支持-->
     <context:annotation-config/>
     
     <!--开启扫描包-->
     <context:component-scan base-package="com.fxc.pojo"/>
     ```

     

## 9、使用Java的方式配置Spring

实体类：

```java
@Component  //  这里这个注解的意思就是说明这个类被spring接管了，注册到了容器中
public class User {
    private String name;

    public String getName() {
        return name;
    }

    @Value("张三")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
```

配置类：

```java
@Configuration  //这个也会被Spring容器托管，注册到容器中，因为他内部也是一个@Component
                //@Configuration代表这是一个配置类，就和我们之前看的beans.xml一样
@ComponentScan("com.fxc.pojo")
@Import(UserConfig2.class)      //  对应于 import 标签
public class UserConfig {
    //  注册一个bean，就相当于xml配置文件中的<bean>标签
    //  方法名---》id
    //  返回值---》标签class
    @Bean
    public User user(){
        return new User();
    }
}
```

测试：

```java
@Test
public void test1(){
    //如果完全使用了配置类的方式，我们就只能使用AnnotationConfigApplicationContext上下文来获取容器，通过
    //配置类的class对象来加载
    ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
    User user = (User)context.getBean("user");
    System.out.println(user.getName());
}
```

这种纯Java的配置方式，在Springboot中随处可见

## 10、代理模式

### 10.1、静态代理

角色分析：

- 抽象角色：一般会使用接口或者抽象类来解决
- 真实角色：被代理的角色
- 代理角色：代理真实角色，代理真实角色后，我们一般会做一些扩展操作
- 客户：访问代理对象的角色

代理模式好处：

- 可以使真实角色的操作更加纯粹！不用去关注一些公共的业务
- 公共业务交给了代理角色！实现了业务的分工！
- 公共业务发生扩展的时候，方便集中管理！

缺点：

- 一个真实的角色就会产生一个代理角色；代码量会翻倍，开发效率会变低。

**代码示例：**

```java
//	抽象角色
public interface Rent {
    public void rent();
}

//	真实角色
public class Host implements Rent{
    public void rent() {
        System.out.println("房东要出租房子");
    }
}

//	代理角色
public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    public void rent() {
        fare();
        seeHouse();
        heTong();
        host.rent();
    }

    //  看房
    public void seeHouse(){
        System.out.println("中介带你看房子");
    }

    //  收中介费
    public void fare(){
        System.out.println("收中介费");
    }

    //  签合同
    public void heTong(){
        System.out.println("签租赁合同");
    }
}

//	客户
public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
```

### 10.2、动态代理

- 动态代理和静态代理角色一样
- 动态代理的代理类是动态生成的，不是我们直接写好的！
- 动态代理分为两大类：基于接口的动态代理，基于类的动态代理
  1. 基于接口---JDK动态代理【重要】
  2. 基于类：Cglib类库
  3. java字节码实现：javasist

JDK动态代理需要实现InvocationHandler接口和使用Proxy代理类。

动态代理的优点：

- 可以使真实角色的操作更加纯粹！不用去关注一些公共的业务
- 公共业务交给了代理角色！实现了业务的分工！
- 公共业务发生扩展的时候，方便集中管理！
- 一个动态代理类代理的是一个接口，一般就是对应的一类业务
- 一个动态代理类可以代理多个类，只要实现了同一个接口即可

```java
public class ProxyInvocationHandler implements InvocationHandler {
    //  被代理的接口
    private Object target;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public void setTarget(Object target) {
        this.target = target;
    }

    //  生成得到代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    //  处理代理实例，并返回代理实例
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        log(method.getName());	//	对被代理类方法的扩展
        //  动态代理的本质就是使用反射机制实现
        Object invoke = method.invoke(target, args);

        return invoke;
    }

    //  日志方法
    public void log(String msg){
        SimpleDateFormat format = new SimpleDateFormat();
        System.out.println("【Debug】:" + sdf.format(new Date()) + " 执行了" + msg + "方法");
    }

}
```

```java
public class Client {
    public static void main(String[] args) {
        //  真实角色
        UserService userService = new UserServiceImpl();

        //  代理角色
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        //  设置要代理的对象
        handler.setTarget(userService);
        //  动态生成代理类
        UserService proxy = (UserService) handler.getProxy();
        proxy.delete();
        proxy.add();
    }
}
```

## 11、AOP

### 11.1、什么是AOP

AOP（Aspect Oriented Programming）意为：面向切面编程，通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术。AOP是OOP的延续，是软件开发中的一个热点，也是Spring框架中的一个重要内容，是函数式编程的一种衍生范型。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。

![image-20210421171357801](E:\Github\Spring框架\狂神课程\typro\image-20210421171357801.png)

### 11.2、AOP在Spring中的作用

### 11.3、使用Spring实现AOP

【重点】使用AOP，需要导入一个依赖包

```xml
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.4</version>
</dependency>
```

**方式一：使用Spring的API接口【主要SpringAPI接口实现】**

```java
public class Log implements MethodBeforeAdvice {
    /**
     * @param method:要执行的目标对象的方法
     * @param objects：method方法的参数
     * @param o：目标对象
     * @throws Throwable
     */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName() + " 的 " + method.getName() + " 方法被执行了 ");
    }
}

public class AfterLog implements AfterReturningAdvice {
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了方法" +
                method.getName() +
                "，并返回了：" + returnValue);
    }
}
```



```xml
<!--方式一：使用y原生Spring API接口-->
<!--配置aop:需要导入aop的约束-->
<aop:config>
    <!--切入点：expression：表达式， execution（要执行的位置!****）-->
    <aop:pointcut id="pointCut" expression="execution(* com.fxc.service.UserServiceImpl.*(..))"/>

    <!--执行环绕增加！-->
    <aop:advisor advice-ref="log" pointcut-ref="pointCut"/>
    <aop:advisor advice-ref="afterLog" pointcut-ref="pointCut"/>
</aop:config>
```

**方式二：自定义来实现AOP【主要是切面定义】**

```java
public class DiyPoint {
    public void before(){
        System.out.println("============方法执行前============");
    }

    public void after(){
        System.out.println("************方法执行前************");
    }
}
```

```xml
<!--方式二：自定义类-->
<bean id="diy" class="com.fxc.diy.DiyPoint"/>
<aop:config>
    <!--自定义切面，ref 要引用的类-->
    <aop:aspect ref="diy">
        <!--切入点-->
        <aop:pointcut id="point" expression="execution(* com.fxc.service.UserService.*(..))"/>
        <!--通知-->
        <aop:before method="before" pointcut-ref="point"/>
        <aop:after method="after" pointcut-ref="point"/>
    </aop:aspect>
</aop:config>
```

**方式三：使用注解实现**

```java
/**
 * 使用注解实现AOP
 */
@Aspect //标注这个类是一个切面
public class AnnotationPointCut {
    @Before("execution(* com.fxc.service.UserService.*(..))")
    public void before(){
        System.out.println("============方法执行前============");
    }

    @After("execution(* com.fxc.service.UserService.*(..))")
    public void after(){
        System.out.println("************方法执行后************");
    }
    //  在环绕增强中，我们可以给定一个参数，代表我们获取处理切入的点
    @Around("execution(* com.fxc.service.UserService.*(..))")
    public void around(ProceedingJoinPoint point){
        System.out.println("-------环绕前-------");
        try {
            //  执行方法
            Object proceed = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("***********环绕后***********");
    }
}
```

```xml
<!--方式三：使用注解方式实现AOP-->
<bean id="annotationPointCut" class="com.fxc.diy.AnnotationPointCut"/>
<!--开启注解支持！！！  JDK：(默认  proxy-target-class="false")  cglib：(proxy-target-class="true")-->
<aop:aspectj-autoproxy />
```



12、整合Mybatis

步骤：

1. 导入相关jar包
   - junit
   - mybatis
   - mysql数据库
   - spring相关的
   - aop织入
   - **mybatis-spring【新知识点】**
2. 编写配置文件
3. 测试

### 12.1、回忆mybatis

1. 编写实体类

   

2. 编写核心配置文件

   

3. 编写接口

   ```java
   public interface EmpMapper {
       public List<Emp> selectEmp();
   }
   ```

4. 编写Mapper.xml文件

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <mapper namespace="com.fxc.mapper.EmpMapper">
       <select id="selectEmp" resultType="com.fxc.pojo.Emp">
           select * from mydb.t_emp;
       </select>
   </mapper>
   ```

5. 测试

### 12.2、整合Mybatis

1. 编写数据源配置

   ```xml
   <!-- DataSource:使用Spring的数据源替换Mybatis的配置 c3p0 dbcp druid -->
   <bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
       <property name="driverClassName" value="com.mysql.jdbc.Driver"/>
       <property name="url" value="jdbc:mysql://172.27.100.96:3306/mydb?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
       <property name="username" value="root"/>
       <property name="password" value="333"/>
   </bean>
   ```

2. sqlSessionFactory

   ```xml
   <!-- sqlSessionFactory-->
   <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
       <property name="dataSource" ref="dataSource"/>
       <!--绑定Mybatis配置-->
       <property name="configLocation" value="classpath:mybatis-config.xml"/>
       <property name="mapperLocations" value="classpath*:com/fxc/mapper/*.xml"/>
   </bean>
   ```

3. sqlSessionTemplate

   ```xml
   <bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
       <!--只能用构造器注入sqlSessionFactory，因为他没有setter方法-->
       <constructor-arg  ref="sqlSessionFactory"/>
   </bean>
   ```

   

4. 需要给接口加实现类

   ```java
   public class EmpMapperImpl implements EmpMapper{
       //  我们的所有操作，都是sqlSession来执行，在原来，现在都是用SqlSessionTemplate;
       private SqlSessionTemplate sqlSession;
   
       public void setSqlSession(SqlSessionTemplate sqlSession) {
           this.sqlSession = sqlSession;
       }
   
       public List<Emp> selectEmp() {
           EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
           return mapper.selectEmp();
       }
   }
   ```

5. 将自己写的实现类，注入到Spring容器中

   ```xml
   <bean id="empMapper" class="com.fxc.mapper.EmpMapperImpl">
       <property name="sqlSession" ref="sqlSession"/>
   </bean>
   ```

   

6. 测试使用即可

Note：还可以通过编写Mapper实现类继承自SqlSessionDaoSupport类来方便获取sqlSession对象

```java
public class EmpMapperImpl2 extends SqlSessionDaoSupport implements EmpMapper {
    public List<Emp> selectEmp() {
        return getSqlSession().getMapper(EmpMapper.class).selectEmp();
    }
}
```

```xml
<bean id="empMapper2" class="com.fxc.mapper.EmpMapperImpl2">
    <property name="sqlSessionFactory" ref="sqlSessionFactory"/>
</bean>
```

## 13、声明式事务

### 13.1、回顾事务

1. 把一组业务当成一个业务来做，要么都成功，要么都失败
2. 事务在项目开发中，十分重要，涉及到数据的一致性问题，不能马虎
3. 确保完整性和一致性

**事务ACID原则：**

- A：Atomic 原子性
- C：Consistent 一致性
- I：Isolation 隔离性
  - 多个业务可能操作同一个资源，防止数据损坏
- D：Duration 持久性
  - 事务一旦提交，无论系统发生什么问题，结果都不会再被影响，被持久化地写到存储器中

### 13.2、Spring中事务管理

- 声明式事务：AOP
- 编程式事务：需要在代码中进行事务地管理

```xml
<!--配置声明式事务-->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>

<!--结合AOP实现事务地织入-->
<!--配置事务地类-->
<tx:advice id="txAdvice" transaction-manager="transactionManager">
    <!--给哪些方法配置事务-->
    <tx:attributes>
        <!-- <tx:method name="addEmp" propagation="REQUIRED"/> -->
        <!-- <tx:method name="deleteEmp"/> -->
        <tx:method name="*"/>
    </tx:attributes>
</tx:advice>

<!--配置事务切入-->
<aop:config>
    <!--配置事务切入点-->
    <aop:pointcut id="txPointCut" expression="execution(* com.fxc.mapper.*.*(..))"/>
    <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut"/>
</aop:config>
```

