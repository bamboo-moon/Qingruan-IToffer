# 青软 IToffer 招聘网站

基于 MVC 模式的 JavaWeb 招聘网站，通过 JDBC 连接 MySQL 数据库，提供用户端与管理员端双页面，具备职位展览、求职投递、招聘管理等核心功能。

---

## 项目简介

本项目是一个使用原生 Servlet + JSP 技术栈实现的招聘平台，分为**用户端**和**管理员端**两套页面：

- **用户端**：求职者可注册登录、完善个人简历（教育经历、工作经历、语言能力），浏览职位与公司信息，并在线投递简历。
- **管理员端**：管理员可对职位、公司、用户简历及管理员账号进行增删改查，并审核处理求职申请。

---

## 技术栈

| 层次 | 技术 |
|------|------|
| 语言 | Java |
| 架构模式 | MVC（Servlet 作为 Controller，JSP 作为 View，JavaBean 作为 Model） |
| Web 容器 | Apache Tomcat |
| 数据库 | MySQL 8.0 |
| 数据访问 | JDBC（`mysql-connector-java-8.0.30`） |
| 前端视图 | JSP、HTML、CSS、JavaScript |
| 标签库 | JSTL |
| 文件上传 | Apache Commons FileUpload |
| 验证码 | ValidateCode |
| 开发工具 | IntelliJ IDEA |

---

## 项目结构

```
Qingruan-IToffer/
├── src/
│   ├── bean/        # 实体类（User、Admin、Company、Job、Apply、Edu、Exjob、Languege）
│   ├── dao/         # 数据访问层（各实体对应的 DAO 类）
│   ├── servlet/     # 控制层
│   │   ├── admin/   # 管理员相关 Servlet
│   │   ├── user/    # 用户相关 Servlet
│   │   ├── company/ # 公司相关 Servlet
│   │   └── job/     # 职位相关 Servlet
│   └── util/        # 工具类（DBUtil 数据库连接工具）
└── webapp/
    ├── WEB-INF/
    │   ├── web.xml
    │   └── lib/     # 项目依赖 JAR 包
    ├── user/        # 用户端页面（登录、注册、简历、职位浏览等）
    ├── admin/       # 管理员端页面（仪表盘、职位/公司/简历/账号管理）
    └── upload/      # 文件上传目录
```

---

## 主要功能

### 用户端
- 用户注册 / 登录 / 退出（含验证码校验）
- 个人简历管理：基本信息、教育经历、工作经历、语言能力的增删改查
- 职位浏览与搜索
- 公司信息查看
- 在线投递简历 / 查看投递记录 / 撤回申请

### 管理员端
- 管理员登录 / 退出
- 职位管理：发布、修改、删除、审核求职申请
- 公司管理：新增、修改公司信息
- 简历管理：查看求职者简历详情
- 管理员账号管理：新增、修改、启用/禁用账号

---

## 数据库配置

数据库连接配置位于 `src/util/DBUtil.java`，默认配置如下：

```java
// 数据库驱动
String driver = "com.mysql.cj.jdbc.Driver";
// 连接 URL
String url = "jdbc:mysql://localhost:3306/itoffer";
```

运行前请确保本地已安装 MySQL，并创建名为 `itoffer` 的数据库，同时在 `DBUtil.java` 中填写正确的用户名和密码。

---

## 快速开始

1. **克隆项目**
   ```bash
   git clone https://github.com/bamboo-moon/Qingruan-IToffer.git
   ```

2. **导入数据库**：在 MySQL 中创建 `itoffer` 数据库，并导入相应的建表 SQL。

3. **修改数据库配置**：编辑 `src/util/DBUtil.java`，填写正确的数据库用户名和密码。

4. **部署到 Tomcat**：使用 IntelliJ IDEA 将项目部署到本地 Tomcat 服务器，启动后访问：
   - 用户端：`http://localhost:8080/itoffer/user/login.jsp`
   - 管理员端：`http://localhost:8080/itoffer/admin/login.jsp`
