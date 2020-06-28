# 项目需求

## 登录

*  注册

> 邀请码
> 邮箱
> 密码

* 登录

> 邮箱
> 密码

## 发表

1. 小说名
2. 标签（可自定）
3. 图片（可选） 
4. 简介
5. 推荐原因

## 查看

1. 用户查看自己发布的推荐小说
2. 随机查找小说
3. 根据标签搜索小说

# 项目设计

## 所用技术
数据库：MySQL

后端：Spring Boot 

DAO：MyBatis

渲染：Thymeleaf

## 架构设计

### 数据库

* 用户表 User

| userId | userEmail |userName | UserPassword | invitationCode |
| :----: | :-------: |:------: | :----------: | :------------: |
|        |           |         |              |                |

* 邀请码表 InvitationCode

| invitationCode | isUsed |
| :------------: | :----: |
|                |        |

* 文章表 Book

| bookId | bookName | bookDescription | bookImg | bookRecommendReason | bookTag | bookPublish |
| :----: | :------: | :-------------: | :-----: | :-----------------: | :-----: | :---------: |
|        |          |                 |         |                     |         |             |

