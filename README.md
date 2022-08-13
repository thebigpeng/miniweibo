## 迷你微博

[TOC]

### 1. 项目介绍

​	突然就想做一个项目，可能是因为我目前太闲了，也可能是对自己工作涉及的项目比较失望吧，我就想把自己学过的东西自己再实现一遍，想了想自己要做个啥项目，刚好看到书里有介绍新浪微博的系统架构，那就做个类似微博的东西吧，ok就这么定下来了。既然是要做类似微博的东西，那暂时就先抄作业吧，直接先照着新浪微博来做。

### 2. TODO:

- [x] 确定后端基础项目架构（2022.8.12~2022.8.12）确定使用[pig](https://gitee.com/log4j/pig)项目进行开发，同时学习记录详细的开发流程
- [ ] 确定前端基本项目架构
- [ ] 实现用户系统：
  1. 用户注册页面
  2. 用户注册接口
  3. 用户登录界面
  4. 用户单点登录
  5. 用户注销
  6. 用户签到
- [ ] 实现博文系统：
  1. 博文发布
  2. 博文编辑界面
  3. 博文点赞
  4. 博文转发
  5. 博文评论
  6. 博文删除
  7. 博文收藏
- [ ] 实现热搜系统：
  1. 实现热搜页面
  2. 实现热搜接口

### 3. 项目整体架构

**项目采用前后端分离**进行设计。

- [ ] 前端：
  - [ ] WEB端(优先vue组件库，怎么快怎么来吧先)
  - [ ] 微信小程序端（后期计划）

- [ ] 后端：
  - [ ] 以Spring开源项目为基础进行实现，采用微服务形式进行开发，降低系统耦合，提高扩展性。

### 4. 系统功能划分

业务功能划分初期按照微博功能进行学习，现简单划分如下：

1. 用户系统：包括新用户的注册、登录、注销，对用户的登录使用SSO设计
2. 博文系统：包括用户对博文的发布、删除、点赞、转发、评论（互动），博文的内容包含文字以及图片，
3. 热搜系统：参考新浪微博的热搜实现进行简单复现，由用户博文的受欢迎程度进行排名展现

### 5.配置环境

| 环境名  |  版本  |         描述         |
| :-----: | :----: | :------------------: |
|   jdk   |  1.8   |     java项目必备     |
|  redis  | 4.0.14 |         缓存         |
|  MySQL  |  8.0   |     关系型数据库     |
|  node   |   12   |      建议版本14      |
| navicat |   15   | 数据库可视化管理工具 |
|   RDM   |  2021  |   redis管理客户端    |

### 6. 如何使用

​	首先将项目整个`clone`到个人本地，会得到两个项目文件夹，`miniweibo-ui`和 `miniweibo`两个文件夹，分别是项目的后台管理前端代码和后台代码。

- 后台管理前端代码启动：

  > 1. 首先安装好node
  >
  > 2. 进入到前端代码根目录执行 `npm install  --registry=https://registry.npmmirror.com`指令安装依赖
  > 3. 在根目录执行 `npm run dev`在dev环境启动项目

- 后端代码启动：

  > 1.修改本地host文件（widows系统下目录一般在C:\Windows\System32\drivers\etc），对请求作本地域名解析，修改内容如下：
  >
  > 127.0.0.1   miniweibo-mysql
  > 127.0.0.1   miniweibo-redis
  > 127.0.0.1   miniweibo-gateway
  > 127.0.0.1   miniweibo-register
  > 127.0.0.1   miniweibo-sentinel
  > 127.0.0.1   miniweibo-monitor
  >
  > 2.执行项目`db`目录的下的sql语句，建立基础数据库表
  >
  > 3.首先启动`MiniweiboNacosApplication`服务，然后登录到Nacos注册配置管理中心(默认账号密码nacos/nacos)，nacos负责管理整个项目的配置，直接将上面所有配置文件的数据库的账号密码修改为自己数据库、redis的账号密码。之后再依次启动GatewayApplication服务、AuthApplication服务、AdminApplication服务，其他的为代码生成以及监控的服务，按需求启动。

  

  [项目搭建文档](#doc1)

### 7. 详细设计

#### 7.1用户系统

​	用户系统是最基本的功能需求，不用多说，直接先设计用户表吧

