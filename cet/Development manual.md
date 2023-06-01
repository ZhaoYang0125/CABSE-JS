**application.properties**

根据实体类自动创建数据库表: 每次启动删除原有的表，创建新的表并执行import.sql（resources目录下）
```
spring.jpa.hibernate.ddl-auto=create
```
控制台显示执行的sql语句
```
spring.jpa.show-sql=true
```

**pom.xml**

热部署，默认false，通过optional打开
```
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <optional>true</optional>
        </dependency>
```

**testpaper**

实体类注解
``` 
    @Id     // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // 自动增长
    @Column(length = 50)    // 长度
    @NotNull    // 非空
```

**UserDao**
自定义数据访问接口
```
    /* 自定义查询 */
    @Query("select u from user u where username like CONCAT('%', ?1, '%') or uid like ?1") // ?1: 表示第一个参数, CONCAT字符串拼接
    public Page<User> findByKeyword(String keyword, Pageable pageable);

    @Query("update User u set u.password = ?2 where u.uid = ?1")    //  ?2: 表示第二个参数, ?1: 表示第一个参数
    public void modifyPassword(Integer uid, String pwd);
```