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

### 5. 详细设计

#### 5.1用户系统

​	用户系统是最基本的功能需求，不用多说，直接先设计用户表吧

