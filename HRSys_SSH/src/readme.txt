企业人事管理系统：
	1.对员工信息进行维护
	2.后台系统先登陆，才能操作员工：增、删、改
	3.没有登陆只能查看列表，不能操作
	4.功能分类：
		4.1管理员模块：
			注册、登陆
		4.2员工模块
			4.2.1添加一个员工，指定添加的部门
			4.2.2修改指定员工的信息
			4.2.3删除选择的员工
			4.2.4列表显示

一、环境搭建
	1.1 导入jar包
		1.1.1 hibernate相关jar包
		1.1.2 Spring相关jar包
		1.1.3 Struts2相关jar包
		1.1.4 mysql数据库驱动
		1.1.6 c3p0数据源
		1.1.6 struts2支持springjar包:struts2-spring-plugin-2.1.8.1.jar
		
	1.2 组织包的结构
		cn.nyt.bean
		cn.nyt.dao
		cn.nyt.dao.impl
		cn.nyt.service
		cn.nyt.service.impl
		cn.nyt.web.action
		cn.nyt.config
		cn.nyt.utils
		cn.nyt.junit
		cn.nyt.exception
	
	1.3 实体的设计
		1.3.1 管理员：
			Administrator
			private int id;
			private String adminName;
			private String pwd;
		1.3.2 员工：
			Employee 
			private int id;
			private String empName;
			private double salary;
			private Department dept;
		1.3.3 部门：	
			Department
			private int id;
			private String name;
			
	1.4 数据库的设计
		1.4.1 管理员表：t_admin
		1.4.2 员工表： t_employee (与部门多对一关系)
		1.4.3 部门表：t_dept
	
	1.5 创建spring的配置文件
		
	1.6 struts2框架的配置
		1.6.1 创建struts2的配置文件
			默认的文件名为struts.xml，存放在WEB-INF/classes目录下，开始时应在src目录下创建
			
	1.7  在web.xml文件中
			1.7.1 加入struts2MVC框架的启动（通过filter启动）
			1.7.2 上下文载入器监听器,确保web服务器启动时,直接完成spring容器的初始化,
					将ApplictionContext放到application范围中
			1.7.3 通过上下文参数指定spring配置文件的位置
			
			
二、写bean

三、给实体bean创建并编写.hbm.xml映射文件
	Department.hbm.xml
	Employee.hbm.xml
	Administrator.hbm.xml

四、写dao层
	提供注入LocalSessionFactory的属性和set方法
	
	4.1 员工接口：
		   保存
		、更新
		、根据主键删除
		、根据id查询一个员工
		、查询所有员工
		、根据提供的姓名对员工进行模糊查询
	4.2 部门接口：根据id查询一个部门、获取所有部门
	
	4.3 管理员接口：保存、根据管理员名称和密码查询一个管理员
	
五、写service层
	提供注入dao的属性和set方法
	
	5.1 员工接口：
		   保存
		、更新
		、根据主键删除
		、根据id查询一个员工
		、查询所有员工
		、根据提供的姓名对员工进行模糊查询
		## 根据提供的id数组删除多个员工
		
	5.2 部门接口：根据id查询一个部门、获取所有部门
	
	4.3 管理员接口：## 提供注册方法  ##提供登陆方法
	
六、写action 继承ActionSupport
	提供注入service的属性和set方法
	
七、写spring的配置文件（使用分散配置）
	7.1 主配置文件（存放到src目录下）：beans.xml
			使用import标签导入以下分散的4个配置文件
			
	7.2 分散配置文件（存放到单独的包中）：
		7.2.1 bean_base.xml
			7.2.1.1 数据库基本信息资源文件位置的指定
				这里使用分散配置，在相同包下创建并编写该资源文件（这里命名为：jdbc.properties）
					资源文件信息包括：		
						a.驱动类：jdbc.driverClass=com.mysql.jdbc.Driver
						b.数据库url：jdbc.jdbcUrl=jdbc:mysql:///{数据库名称}
						c.用户名：jdbc.username=root
						d.密码：jdbc.password=root
						
						e.创建c3p0数据源（连接池）必要的信息：
							maxPoolSize
							minPoolSize
							initialPoolSize
							acquireIncrement
							
			7.2.1.2 配置c3p0数据源
			
			7.2.1.3 配置本地会话工厂bean（spring和hibernate的核心关联入口）
					a. 给会话工厂bean注入C3P0数据源
					b. 配置hibernate的属性集
						这里同样将该属性集信息分散写入jdbc.properties资源文件中，然后在这里调用
						属性集信息包括：
							hibernate.dialect
								hibernate方言
							hibernate.show_sql
								是否在控制台显示hibernate执行sql语句（方便测试，可以不配置）：
							hibernate.hbm2ddl.auto
								设置自动建表的值，值建议是“none”或“validate”。“validate”应该是最好的选择：这样 spring在加载之初，如果model层和数据库表结构不同，就会报错，这样有助于技术运维预先发现问题。
								网站发布正式版本的时候，对数据库现有的数据或表结构进行自动的更新是很危险的。此时此刻应该由DBA同志通过手工的方式进行后台的数据库操作。
					c.指定映射资源文件（.hbm.xml）所在的目录集
						这里使用spring的属性配置 ：mappingDirectoryLocations
						
			
			7.2.1.4 配置hibernate事务管理器（由spring提供的平台事务管理器）
					说明：该事务管理器实现了在service层上进行事务管理，达到平台无关性（dao层的事务管理与平台相关）
							真正具备事务管理的事持久化技术，其实这个管理器依托的还是底层的事务管理
					平台：具体的资源api，如：hibernate、jdbc、jdo、ojb等持久化技术		
					a.给事务管理器注入会话工厂
			
			7.2.1.5 事务通知配置（事务如何管理）
					a.导入scheme：tx名字空间："http://www.springframework.org/schema/tx"
					b.指定事务管理器	
					c.设置事务属性集tx:attributes
						属性集包括：传播行为、数据库隔离级别、只读、回滚规则
						
			7.2.1.6 切入点的配置（aop配置），这里使用pojo+xml的配置方式
					a.切入点表达式的配置（拦截的目标对象，生成代理对象）
					b.包装通知,给通知设置切入点（事务增强应用）
				
		7.2.2 bean_dao.xml
			配置所有dao类bean，并注入localSessionFactoryBean（本地会话工厂）
			
		7.2.3 bean_service.xml
			7.2.3.1 配置所有service类bean，并注入dao类bean
			7.2.3.2 这里因为使用了平台事务管理器，只需要和spring的事务打交道，
					实现了在service层进行事务管理，因此service类为目标对象
					
		7.2.4 bean_action.xml			
			配置所有action类，并注入相对应的service
			

八、写struts2的配置文件
	8.1 配置action,以及转发到的视图
	把action的class改成bean的id.
		<!-- class:指定action在spring容器的id -->
		<action name="HelloWorldAction_*" class="helloWorldAction" method="{1}">
	
九、视图添加及其完善
	9.1 员工的增删改
	9.2 写BaseDao.java
	9.3 完成用户的注册和登陆
	9.4 写权限拦截器


