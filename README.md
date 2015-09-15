[![JDK](http://img.shields.io/badge/jdk-v8.0-yellow.svg)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![build](http://img.shields.io/badge/build-maven_2-green.svg)](https://maven.apache.org/)
[![build](http://img.shields.io/badge/build-passing-blue.svg)](https://travis-ci.org/yingzhuo/spring-playground)
[![license](http://img.shields.io/badge/license-apache_2-red.svg)](http://www.apache.org/licenses/LICENSE-2.0)

# spring-playgroud
这是一个基于spring-boot的空白项目，你可以使用`git`克隆到本地，稍作修改，从而达到提高开发效率的目的。

你可以通过以下方式的任意一种启动这个项目

```
git clone git@github.com:yingzhuo/spring-playground.git
cd spring-playground
mvn clean spring-boot:run
```

```
git clone git@github.com:yingzhuo/spring-playground.git
cd spring-playground
mvn clean package
java -jar target/spring-boot-1.0.0.jar --spring.profiles.active=dev --debug
```

上面的`--debug`参数使项目启动时会详细地输出日志。


或者，你可以可以直接下载[源代码](https://github.com/yingzhuo/spring-playground/archive/master.zip)，之后导入到你喜爱的IDE中。
* eclipse: `mvn eclipse:eclipse`
* idea: `mvn idea:idea`

Profiles
---------------------------
* dev:  测试环境
* prod: 生产环境
* mongo: 此环境中包含mongodb的配置
* ssl: 使用`HTTPS`协议

Q &amp; A
---------------------------

#### 这个是开源的吗？
是的，请看本文档最后贴出的许可证。

#### 如何使用spring-mvc生成web页面?
请参考`playground.controller.HtmlController`

#### 对于web页面，用的是什么模板生成工具?
使用的是[jmustache](https://github.com/samskivert/jmustache)，根据spring[官方的建议](http://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-jsp-limitations)不采用`JSP`技术。

#### 如何如使用spring-mvc生成json应答?
请参考`playground.controller.JsonController`

#### 有上传文件的代码例子吗?
请参考`playground.controller.UploadController`

#### 有下载文件的代码例子吗?
请参考`playground.controller.DownloadController`

#### 有集成`hibernate-validator`的例子吗?
请参考`playground.controller.ValidatingController`

#### 如何配置数据源?
请参考`playground.ApplicationConfigDataSource`。<br>
这里配置了两种数据源，一种是嵌入式数据库HSQLDB，一种使用的是`alibaba-druid`。

#### 这个项目使用了ORM框架吗？
本项目使用的是`mybatis`。<br>
请参考`playground.ApplicationConfigMyBatis`和`playground.service.impl.UserServiceImpl` <br>
其他ORM框架如 hibernate, spring-data-jpa等本项目没有支持，如果需要请自行添加。

#### 我要使用mongodb我应该怎么做?
本项目集成了`spring-data-mongodb`，如果你需要使用的话，可以把`org.springframework.data.mongodb.core.MongoTemplate` or `org.springframework.data.mongodb.core.MongoOperations`注入到任何你需要的bean中去。<br>
请参考[spring-data-mongodb](http://docs.spring.io/spring-data/data-mongo/docs/1.7.1.RELEASE/reference/html/)的官方文档。<br>

#### 怎么发送邮件?
对`JavaMailSender`进行了一层简单的封装。请参考`playground.tool.MailService` <br>
`playground.tool.MailService`的实例可注入到任何你需要的bean中。

#### 我需要JMS服务，我应该怎么做?
`JmsTemplate`可以注入到你任意一个需要的bean中。你可以直接使用。当然，你可能需要修改配置。

#### 我需要任务调度怎么办？
请参考`playground.scheduler.HeartbeatSecheduler`

#### 我想使用本地缓存，我应该怎么做?
请参考`playground.ApplicationConfigCaching`和`playground.service.impl.UserServiceImpl`

#### Spring AOP有参考例子吗?
请参考`playground.aop.ServiceLoggingAdvice`

#### ~~可以集成认证与授权框架吗?~~
本项目集成了`apache-shiro`，请参考`playground.ApplicationConfigShiro` <br>
推荐使用标注管理访问URL

#### 我可以使用其他JVM语言编程吗?
本项目集成了`groovy`，事实上本项目中确实有一个类是用`groovy`语言编写的: `playground.controller.GroovyController` <br>
其他语言诸如`scala` `jruby`等暂时不支持。

#### 可以用webjars导入`css` `javascript`吗?
可以! 参考`playground.ApplicationConfigMvc`和`classpath:/templates/users.html`。<br>
这个页面使用了`bootstrap 3.0`

#### 我想使用https协议,我应该怎么做?
启动本项目时使用参数`--spring.profiles.active=dev,ssl`即可。<br>
启动后访问`https://127.0.0.1:8443`可看到效果。<br>
当然，证书是我自行签名的，在实际的生产环境应该去购买证书。

#### 你的banner是用什么工具生成的?
[figlet](http://www.figlet.org/)

许可证
---------------------------

```
Copyright 2013-2015 Zhuo Ying, Shanghai, China. All rights reserved.

  Author: 应卓
   Email: yingzhor@gmail.com
  WebURL: https://github.com/yingzhuo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

联系我
---------------------------
![QQ](http://img.shields.io/badge/QQ-23007067-blue.svg)
![WeChat](http://img.shields.io/badge/WeChat-yingzhor-blue.svg)
![Email](http://img.shields.io/badge/Email-yingzhor@gmail.com-blue.svg)
![Phone](http://img.shields.io/badge/Phone-+86_189_1694_4373-blue.svg)