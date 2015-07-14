[![JDK](http://img.shields.io/badge/JDK-v8.0-yellow.svg)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![Build](http://img.shields.io/badge/Build-Maven_2-green.svg)](https://maven.apache.org/)
[![License](http://img.shields.io/badge/License-Apache_2-red.svg)](http://www.apache.org/licenses/LICENSE-2.0)

# spring-playgroud
这是一个基于spring-boot的空白项目，你可以使用`git`克隆到本地，稍作修改，从而达到提高开发效率的目的。

你可以通过以下方式的任意一种启动这个项目

```bash
git clone git@github.com:yingzhuo/spring-playground.git
cd spring-playground
mvn clean spring-boot:run
```

```bash
git clone git@github.com:yingzhuo/spring-playground.git
cd spring-playground
mvn clean package
java -jar target/spring-boot-1.0.0.jar --spring.profiles.active=dev
```

或者，你可以可以直接下载[源代码](https://github.com/yingzhuo/spring-playground/archive/master.zip)，之后导入到你喜爱的IDE中。

Profiles
---------------------------
* dev:  测试环境
* prod: 生产环境

Q &amp; A
---------------------------

#### 这个是开源的吗？
是的，请看本文档最后贴出的许可证。

#### 如何使用spring-mvc生成web页面?
请参考`playground.controller.HtmlController`

#### 如何如使用spring-mvc生成json应答?
请参考`playground.controller.JsonController`

#### 如何配置数据源?
请参考`playground.ApplicationConfigDataSource`。<br>
这里配置了两种数据源，一种是嵌入式数据库HSQLDB，一种使用的是`alibaba-druid`。

#### 这个项目使用了ORM框架吗？
本项目使用的是mybatis。<br>
请参考`playground.ApplicationConfigMyBatis`和`playground.service.impl.UserServiceImpl`
其他ORM框架如 hibernate, spring-data-jpa等本项目没有支持，如果需要请自行添加。

#### 怎么发送邮件?
对`JavaMailSender`进行了一层简单的封装。请参考`playground.tool.MailService` <br>
`playground.tool.MailService`的实例可注入到任何你需要的bean中。

#### 我需要JMS服务，我应该怎么做?
`JmsTemplate`可以注入到你任意一个需要的bean中。你可以直接使用。当然，你可能需要修改配置。

#### 我需要任务调度怎么办？
请参考`playground.scheduler.HeartbeatSecheduler`

#### Spring AOP有参考例子吗?
请参考`playground.aop.ServiceLoggingAdvice`

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