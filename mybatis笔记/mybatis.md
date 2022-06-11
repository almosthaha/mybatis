# mybatis



## 1.基于springboot的mybatis环境搭建

### 1.1引入mybatis依赖

由于现在主流的mybatis-plus是mybatis的加强版

所以我们引入的是mybatis-plus依赖

```xml
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus</artifactId>
    <version>3.4.3</version>
</dependency>
```

引入mysql

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

由于springboot中是自带junit测试的，所以这里是不用引入的

### 1.2映射文件配置

由于在springboot简化了一些数据库连接等配置、这里只需要配置mapper映射

这里可以去mybatis官网中复制

```xml
<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="org.apache.ibatis.submitted.rounding.Mapper">
	
</mapper>
```

### 1.3 mapper接口书写

在mapper接口中只要定义返回值跟方法名（有些需要参数）

```java
User check();
```

书写完接口后就要配置映射文件（配置文件书写在resources文件里面，文件地址要对应）

这里要注意配置文件的名称

错误释放：com.lyg.mybatisdemo.dao.mapper

正确释放：com/lyg/mybatisdemo/dao/mapper

xml中的一些属性说明：

命名空间对应的是mapper的地址

id对应的是方法名

查找语句有两个重要的属性:

resultType: 适用于表中的对象跟属性名一致的(表中的字段为tb_username 属性名为tbUsername)

resultMap：适用于字段跟属性名不一致，且表中的关系是一对1或者是多对多（多表查询）

mapper中快速创建映射文件的方式：

利用mybatis-x插件：![image-20220605214126420](C:\Users\almost\AppData\Roaming\Typora\typora-user-images\image-20220605214126420.png)

mybatis插件不仅可以快速生成映射文件，也可以快速生成@Pqram参数

### 1.4 书写sql语句

这里新手建议在数据库中先测试 写完后可以在test中测试数据的正确性

### 1.5 适用junit进行测试

```java
 //查找测试
    @Test
    public void  checkLogin(){
        //System.out.println(userMapper.checkLogin("张三","123"));
    }

    
    @Test
    public void  checkLoginMap(){
        Map<String,Object> map=new HashMap<>();
        map.put("username","张三");
        map.put("password","123");
        User user = userMapper.checkLoginMap(map);
        System.out.println(user);
    }
    //增加测试
    @Test
    public void add2(){
        System.out.println( userMapper.add(new User(null, "晴天", "130", 17, "男", "131")));
    }
}
```

### 1.6  log4j日志

控制日志信息的输出，方便开发人员清楚数据的输出

在配置文件中加入：

```java
mybatis:
  configuration:
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

![image-20220606144652813](C:\Users\almost\AppData\Roaming\Typora\typora-user-images\image-20220606144652813.png)

## 2.mybatis的增删改查

### 2.1 查找功能

查找功能：

mapper接口:

```java
User check();
```

映射文件：

```xml
<select id="check" resultType="com.lyg.mybatisdemo.dao.pojo.User">
    select * from user where id=#{id}
</select>
```

根据id查找一个对象：

参数:id  返回值: user对象

### 2.2 增加功能

增加功能：

mapper接口：

```
int insert();
```



参数：无  返回值：int

映射文件

```xml
 <insert id="add">
        insert into user values (null,#{username},#{password},#{age},#{sex},#{email})
    </insert>
```

 

### 2.3 删除功能：

maper接口:

```java
int delete();
```

参数:无    返回值 : int

映射文件：

```xml
<delete id="delete" >
    delete from user where id=#{id}
</delete>
```

### 2.4 修改功能:

mapper接口：

```java
int update();
```

参数:无  返回值: int

映射文件:

```
<insert id="update" >
    update user set username="hi" where id=3
</insert>
```

## 3.mybatis获取参数值的两种方式

### 3.1${}和#{}

特点：${} 方式要进行字符串拼接 #{} 则不用

### 3.2 单个字面量的参数

若mapper接口中的参数为单个的字面量的参数可以用#{} 获取任何参数的名称

```java
User getUserByUsername(String username);
```

映射文件：

```xml
<select id="getUserByUsername" resultType="com.lyg.mybatisdemo.dao.pojo.User">
    select * from user where username=#{username}
</select>
```

### 3.3多个字面量类型的参数 使用@param标识参数

mapper接口:

```java
User checkLogin(@Param("username") String username,@Param("password")
        String password);
```

只需要通过键值#{}的方式访问map的键就可以获相应的值

映射文件：

```xml
<select id="checkLogin" resultType="com.lyg.mybatisdemo.dao.pojo.User">
    select * from user where username=#{username} and password=#{password}
</select>
```

### 3.4 实体类类型的参数

mapper接口：

```java
int add(User user);
```

通过类.属性名来访问 注意：要加有参构造器的注解:@AllArgsConstructor

映射文件:

```xml
<insert id="add">
    insert into user values (null,#{username},#{password},#{age},#{sex},#{email})
</insert>
```

### 3.5 mapper集合类型的参数

当有多个字面量时，可以手动设置mapper,通过#{}访问放在mapper里面的值

多个字面量的mapper接口跟映射文件可以参考上面的@parem参数

测试用例：

```java
Map<String,Object> map=new HashMap<>();
map.put("username","张三");
map.put("password","123");
User user = userMapper.checkLoginMap(map);
System.out.println(user);
```

### 3.6总结

分成两种类型的参数进行处理（开发用到比较多的）

1.实体类类型的参数（参数比较多时，直接用类.属性值访问）

2.@Param参数 (2~3个)

@param快捷键（先写完参数后再执行）

![image-20220606155119764](C:\Users\almost\AppData\Roaming\Typora\typora-user-images\image-20220606155119764.png)

## 4.mybatis的各种查询功能

### 4.1查询单行数据

mapper接口:

```java
User getUserById(@Param("id") Integer id);
```

映射文件:

```xml
<select id="getUserById" resultType="com.lyg.demo2.dao.pojo.User">
    select * from user where id=#{id}
</select>
```

### 4.2 查询多行数据

mapper接口：

```java
List<User> getUserAll();
```

映射文件:

```xml
 <select id="getAllUserToMap" resultType="java.util.Map">
        select * from user
 </select>
```

### 4.3 通过map查询单行数据

mapper接口:

```java
Map<String,Object> getUserByIdMap(Integer id);
```

映射文件：

```xml
<select id="getUserByIdMap" resultType="java.util.Map">
    select * from user where id=#{id}
</select>
```

### 4.4通过map查询多行数据

mapper接口:

第一种方式：通过list集合嵌套map

```
list <Map<String,Object>> getAllUserToMap();
```

第二种方式:   通过@MapKey("")注解 @Map

```java
 @MapKey("id")
 Map<String,Object> getAllUserToMap();
```

映射文件:

```xml
<select id="getAllUserToMap" resultType="java.util.Map">
    select * from user
</select>
```

### 4.5 总结

map适用于字段名跟属性名不一致的情况  且表中关系为一对一，或一对多

map的泛型为<String,Object> 因为键值对中键为字段名,值为对象中的属性名,有多种属性类型

所以为Object

@MapKey的使用，为map确定键的名称

这是一个适用在map上的注解:它能将存放对象的list准换为key值为对象的某一属性值的map

## 5.特殊的sql语句

### 5.1模糊查询

mapper接口:

```java
User getUserByLike(@Param("username") String username);
```

映射文件

```xml
<select id="getUserByLike" resultType="com.lyg.demo2.dao.pojo.User">
    select * from user where username like "%"#{username}"%"
</select>
```

### 5.2 批量删除

只能使用\${}，如果使用#{}，则解析后的sql语句为`delete from t_user where id in ('1,2,3')`，这样是将`1,2,3`看做是一个整体，只有id为`1,2,3`的数据会被删除。正确的语句应该是`delete from t_user where id in (1,2,3)`

mapepr接口:

```java
int deleteMore(@Param("ids") String ids);
```

映射文件:

```xml
<delete id="deleteMore">
    delete from user where id in (${ids})
</delete>
```



## 6.自定义映射resultMap

### 6.1多对一映射关系

查询员工及所对应的部门关系

将部门对象作为user类的属性

```java
private Integer id;
private String username;
private String password;
private Integer age;
private String sex;
private String email;

/**
 * 多对一关系
 */

private Department department;
```

根据员工id查询所在部门的信息（使用联级查询）

mapper接口:

```java
User getUserAndDepartment(@Param("id") Integer id);
```

映射文件:

这里要注意类作为的属性访问方式为类.属性，后面的列跟上面写法不变

联级查询中多对一的一字段会爆红，不知道什么原因

```xml
<resultMap id="userResultType2" type="com.lyg.demo3.dao.pojo.User">
    <id property="id" column="id"></id>
    <result property="username" column="username"></result>
    <result property="password" column="password"></result>
    <result property="age" column="age"></result>
    <result property="sex" column="sex"></result>
    <result property="email" column="email"></result>
    <result property="department.departmentid" column="departmentid"></result>
    <result property="department.departmentname" column="departmentname"></result>
    
</resultMap>
<select id="getUserAndDepartment" resultMap="userResultType2">
    select * from user left join department on user.id = department.departmentid
    where id=#{id}
</select>
```

还有association跟分布查询两种方式

asscociasion在springboot框架中会报错

### 6.2一对多

#### 6.2.1collection

用来处理一对多的关系

实体类关系:

由于用来描述多个对象，所以返回值用List<User>表示

```java
private Integer departmentid;
private String departmentname;

private List<User> users;
```

mapper接口:

根据部门id查询所对应的员工信息

```java
Department getDepartmentByStepOne(@Param("departmentid") Integer departmentid);
```

映射文件:

```xml
<select id="getDepartmentByStepOne" resultMap="depResultMap">
    select * from department left join user on department.departmentid=user.id
    where departmentId=#{departmentid}
</select>
```

#### 6.2.2 分布查询

#### 6.3延迟加载



## 7.动态sql

mybatis动态sql的存在主要是为了解决拼接字符串的痛点，主要用于多条件查询中

在动态sql中一般where与if连用

### 7.1 if跟where语句的使用

if语句会通过test标签对表达式尽心判断，若表达式的结果为真，则执行，反之，不执行

使用if语句需要注意的问题

```xml
select * from user 
<if test="username != null and username!=''">
    username=#{username}
</if>
<if test="age != null and age!=''">
    and age=#{age}
</if>
<if test="sex != null and sex!=''">
    and sex=#{sex}
</if>
<if test="email != null and email!=''">
    and email=#{email}
</if>
```

 在上面的一条sql语句中如果第一个if条件判断失败，没有执行，但是第二个条件执行成功，执行的话

会报错，此时可以加where条件(认为and)

 动态sql查询对象:

mapper接口:

```java
List<User> selectByUser(User user);
```

xml文件:

```xml
<select id="selectByUser" resultType="com.lyg.demo3.dao.pojo.User">
    select * from user where
    <if test="username != null and username!=''">
        username=#{username}
    </if>
    <if test="age != null and age!=''">
        and age=#{age}
    </if>
    <if test="sex != null and sex!=''">
        and sex=#{sex}
    </if>
    <if test="email != null and email!=''">
        and email=#{email}
    </if>
</select>
```

### 7.2 foreach语句

foreach常用做批量删除，跟批量添加

根据id批量删除用户:

mapper接口:

```java
int deleteMoreByArray(@Param("ids") Integer[] ids);
```

xml映射:

```xml
<delete id="deleteMoreByArray">
    delete from user where id in
    <foreach collection="ids" item="id" separator="," open="(" close= ")">
        #{id}
    </foreach>
</delete>
```

test测试:

```java
@Test
public void deleteMoreByArray(){
    System.out.println(sqlMapper.deleteMoreByArray(new Integer[]{5,6}));
}
```

批量添加用户:

mapper接口:

```java
int addMoreByArray(@Param("users") List<User> users);
```

映射文件:

```xml
<insert id="addMoreByArray">
    insert into user values
    <foreach collection="users" item="user" separator=",">
      (null,#{user.username},null,#{user.age},#{user.sex},#{user.email})
    </foreach>
</insert>
```

test测试:

```
@Test
public void addMoreByArray(){
    User user1=new User(null,"晴天",null,36,"男","555");
    User user2=new User(null,"白云",null,35,"女","666");
    User user3=new User(null,"风",null,33,"女","777");
    List<User> userList= Arrays.asList(user1,user2,user3);
    System.out.println(sqlMapper.addMoreByArray(userList));
}
```

这里在测试的时候要注意一些问题

如果在实体类中使用这两个注解要注意:

相当于在实体类中把全部的属性都创建了有参跟无参构造器

因此在sql语句拼写时创建对象时如果不包含对应的数据记得使用null

```java
@NoArgsConstructor
@AllArgsConstructor
```

