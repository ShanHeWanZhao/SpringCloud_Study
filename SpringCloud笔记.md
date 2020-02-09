# SpringCloud

### 1.springcloud架构和常用网站

![springcloud架构图](img/springcloud.png)

> 1.官网：https://spring.io/projects/spring-cloud
>
> 2.参考书：
>
> ​	2.1、https://www.springcloud.cc/spring-cloud-netflix.html
>
> ​	2.2、API：https://www.springcloud.cc/spring-cloud-dalston.html
>
> 3.springcloud中文网：https://www.springcloud.cc/

### 2.项目版本

**spring cloud版本：Dalston.SR1**

**spring boot版本：1.5.19.RELEASE**

### 3.环境搭建

#### 	3.1父工程（microservicecloud）

​	pom文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.trd.springcloud</groupId>
    <artifactId>microservicecloud</artifactId>
    <version>1.0</version>
    <packaging>pom</packaging>

    <!--工具包和源码的版本管理-->
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <junit.version>4.12</junit.version>
        <log4j.version>1.2.17</log4j.version>
        <spring-boot.version>1.5.19.RELEASE</spring-boot.version>
        <spring-cloud.version>Dalston.SR1</spring-cloud.version>
        <logback.version>1.2.3</logback.version>
        <lombok.version>1.18.6</lombok.version>
        <mybatis-spring-boot-starter.version>1.3.0</mybatis-spring-boot-starter.version>
        <!--一定要注意MySQL-Connector和Druid的版本问题，
                否则容易出现MySqlValidConnectionChecker错误-->
        <druid.version>1.0.6</druid.version>
        <mysql-connector.version>5.1.25</mysql-connector.version>
    </properties>

    <!--对子模块依赖的版本管理，不负责引进-->
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql-connector.version}</version>
            </dependency>
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>${druid.version}</version>
            </dependency>
            <dependency>
                <groupId>org.mybatis.spring.boot</groupId>
                <artifactId>mybatis-spring-boot-starter</artifactId>
                <version>${mybatis-spring-boot-starter.version}</version>
            </dependency>
            <dependency>
                <groupId>log4j</groupId>
                <artifactId>log4j</artifactId>
                <version>${log4j.version}</version>
            </dependency>
            <dependency>
                <groupId>ch.qos.logback</groupId>
                <artifactId>logback-core</artifactId>
                <version>${logback.version}</version>
            </dependency>
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>${junit.version}</version>
                <scope>test</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>
</project>
```

#### 	3.2通用工程（microservicecloud-api）

​	pom文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <artifactId>microservicecloud</artifactId>
        <groupId>com.trd.springcloud</groupId>
        <version>1.0</version>
        <!--采用相对路径，改动测试起来更方便-->
        <relativePath>../microservicecloud/pom.xml</relativePath>
    </parent>

    <artifactId>microservicecloud-api</artifactId>
    <dependencies>
        <!--lombok的jar包-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>

    </dependencies>
</project>
```

#### 	3.3服务的提供者（microservicecloud-provider-dept-8001）

​	pom文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <!--父模块-->
    <parent>
        <artifactId>microservicecloud</artifactId>
        <groupId>com.trd.springcloud</groupId>
        <version>1.0</version>
        <relativePath>../microservicecloud/pom.xml</relativePath>
    </parent>

    <artifactId>microservicecloud-provider-dept-8001</artifactId>

    <dependencies>
        <!--引入自己编写的api模块的jar包,版本跟着项目走-->
        <dependency>
            <groupId>com.trd.springcloud</groupId>
            <artifactId>microservicecloud-api</artifactId>
            <version>${project.version}</version>
        </dependency>

        <!--junit-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
        </dependency>
        <!--mysql-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!--druid连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
        </dependency>
        <!--日志logback-->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-core</artifactId>
        </dependency>
        <!--mybatis整合springboot的starter-->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
        </dependency>
        <!--springboot的web的starter-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <!--排除Tomcat-->
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <!--嵌入式jetty服务器，不用tomcat-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jetty</artifactId>
        </dependency>
        <!--springboot的test的starter-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
        </dependency>

        <!--热部署 修改后立即生效-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>springloaded</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
    </dependencies>

</project>
```

​	application.yml文件

```yaml
server:
  port: 8001
mybatis:
#  config-location: classpath:mybatis/mybatis.cfg.xml       mybatis配置文件的路径
  type-aliases-package: com.trd.springcloud.entities      #  mybatis别名包位置
  mapper-locations:                                       #  mybatis的mapper.xml文件路径
    - classpath:mybatis/mapper/*.xml
  configuration:
    cache-enabled: true
spring:
  application:
    name: microservicecloud-dept                          #该application的名称
  datasource:
    type: com.alibaba.druid.pool.DruidDataSource          # DataSource类型
    driver-class-name: com.mysql.jdbc.Driver              # MySQL驱动器
    username: root
    password: 123456
    url: jdbc:mysql://localhost:3306/clouddb01
    dbcp2:
      min-idle: 5                                         # 最小空闲数
      initial-size: 5                                     # DataSource初始化大小
      max-total: 5                                        # 最大连接数
      max-wait-millis: 200                                # 连接超时时间（毫秒）

```

启动类

```java
package com.trd.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Trd
 * @date 2020-02-09 14:57
 */
// mapper的接口包扫描
@MapperScan("com.trd.springcloud.dao")
@SpringBootApplication
public class DeptProvider8001_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001_App.class,args);
	}
}

```

#### 	3.4服务的消费者（microservice-cloud-consumer-dept-80）

​	pom文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>microservicecloud</artifactId>
        <groupId>com.trd.springcloud</groupId>
        <version>1.0</version>
        <relativePath>../microservicecloud/pom.xml</relativePath>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>microservicecloud-consumer-dept-80</artifactId>
    <dependencies>
        <!--引入自己编写的api模块的jar包,版本跟着项目走-->
        <dependency>
            <groupId>com.trd.springcloud</groupId>
            <artifactId>microservicecloud-api</artifactId>
            <version>${project.version}</version>
        </dependency>
        <!--springboot的web的starter-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!--热部署 修改后立即生效-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>springloaded</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
    </dependencies>

</project>
```

​	yml文件

```yaml
server:
  port: 80             # 只更改服务的端口
```

### 4.Eureka

#### 4.1Eureka是什么？

​		Eureka是一个**基于REST**的服务，用于定位服务，以实现云端中间层**服务发现和故障转移**。**只使用服务的标识符，就可以访问到服务**，而**不需要修改服务调用的配置文件**。类似于dubbo的注册中心，比如Zookeeper。

![Eureka的架构](img/Eureka.png)







