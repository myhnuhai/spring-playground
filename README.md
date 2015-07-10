[![JDK](http://img.shields.io/badge/JDK-v8.0-yellow.svg)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![Build](http://img.shields.io/badge/Build-Maven_2-green.svg)](https://maven.apache.org/)
[![License](http://img.shields.io/badge/License-Apache_2-red.svg)](http://www.apache.org/licenses/LICENSE-2.0)

# spring-playgroud
这是一个基于spring-boot的空白项目，你可以使用`git`克隆到本地，稍作修改，从而达到加快开发效率的目的。

你可以通过以下方式启动这个项目

```bash
git clone git@github.com:yingzhuo/spring-playground.git
cd spring-playground
mvn clean spring-boot:run
```

或者，你可以可以直接[下载](https://github.com/yingzhuo/spring-playground/archive/master.zip)源代码。

Profiles
---------------------------
* (未指定): 开发机环境
* dev: 测试环境
* prod: 生产环境

MVC
---------------------------
* 配置类
    * `playground.ApplicationConfigMvc`
    * `playground.ApplicationConfigWeb`
* example
    * 生成html视图: `playground.controller.HtmlController`
    * 生成json视图: `playground.controller.JsonCOntroller`
    * 生成xml视图: (暂无)
    * upload: (暂无)
* 视图渲染技术
    * application/json -> jackson2
    * application/xml -> (待定)
    * text/html -> jmustache
    
数据存储 (关系型数据库)
---------------------------
* 数据源
    * mysql
    * apache-dbcp2
* ORM
    * mybatis
    
数据存储 (KeyValue数据库)
---------------------------
* (暂无)

认证与授权
---------------------------
* (暂无)

任务调度
---------------------------
* (暂无)

JMS
---------------------------
* (暂无)

Q &amp; A
---------------------------
(暂无)

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