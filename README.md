# DDrobotForBilibili
B站自动评论机器人低配版本，因为自己第一次写 Java 项目，所以很多功能还未完善，项目思路来源于奇响天外的DD机马甜甜儿，感谢作者分享的思路

DD机原型来源：https://space.bilibili.com/1106960777

本项目作者的B站空间 https://space.bilibili.com/104231462

目前仅支持文字动态下的评论，并且评论格式单一，为了应对B站对脚本的反检测，扫描速度很慢，并且每隔一段时间会被B站安排一次 412 宕机那么几小时，但是线程不会退出，挂在服务器上就可以了。

只放出了 JAVA 代码和 maven 的 pom.xml 文件，项目需要自己在IDEA上创建

## 关于 release 版本如何直接使用（写给和我一样的新手）

**最最最最重要的是本地配置了 JDK17 ，毕竟这可是个 JAVA 项目**

1. 首先需要一个 DDrobot.conf 文件，文件的模板已经在项目中放出，脚本会在运行时读取并配置相关设置，并且支持实时更改，更改后不需要重启脚本。
2. 然后需要服务器或者你的主机提供 MySQL 支持，在 MySQL 中创建数据库后按照如下指令创建数据表：
```
create table users
(
    uid  varchar(20) not null,
    name varchar(30) not null,
    dyId varchar(30) not null,
    date varchar(20) null
);

//将脚本评论的用户的 uid ，名字，最新动态的 dynamicId ，上传到数据表里就可以了
//这个名字是评论时替换 #name# 时用的，可以不是对方的B站名
//上传最新动态的 dynamicId 是为了防止脚本启动时评论了以前的最新动态，查看 dynamicId 的方法很简单，点开最新的动态，网址栏就能看到 dynamicId 

//示例
INSERT INTO users
(uid,name,dyId)
VALUES
('104231462','艾若','677384443716960278');

```

3. 最后，新建一个文件夹，将已经配置好的 DDrobot.comf 移动到这个文件夹下，然后在这个文件夹下新建一个 work 文件夹，将 release 版本的 jar 包移动到这个 work 文件夹下（这个 jar 包是胖包，自带依赖，可以直接运行，无需本地的 maven 库），然后 cmd 用 java -jar 运行这个包就可以了

关于 SESSDATA 和 csrf 如何获取，登录B站账号，然后浏览器 F12 检查，在 Network 下面谁便找一个点开，找到 Request Header 一栏，里面就有 cookie ，然后里面就有 SESSDATA 和 csrf（在B站的 cookie 里叫 bili_jct ）

---
相关B站 api 来自于 https://github.com/SocialSisterYi/bilibili-API-collect

> 为什么B站没有官方文档，好气啊

---

2022年7月2日12点53分更新：
- 修复了可能返回空 Json 导致的异常
- 线程休眠增加了随机数，希望能逃过B站的412
- 通过日志可知，B站的 412 封禁时长为 2 小时，为后面想做同样项目的朋友带来了血泪的经验
