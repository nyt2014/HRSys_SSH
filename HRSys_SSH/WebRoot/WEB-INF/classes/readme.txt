��ҵ���¹���ϵͳ��
	1.��Ա����Ϣ����ά��
	2.��̨ϵͳ�ȵ�½�����ܲ���Ա��������ɾ����
	3.û�е�½ֻ�ܲ鿴�б����ܲ���
	4.���ܷ��ࣺ
		4.1����Աģ�飺
			ע�ᡢ��½
		4.2Ա��ģ��
			4.2.1���һ��Ա����ָ����ӵĲ���
			4.2.2�޸�ָ��Ա������Ϣ
			4.2.3ɾ��ѡ���Ա��
			4.2.4�б���ʾ

һ�������
	1.1 ����jar��
		1.1.1 hibernate���jar��
		1.1.2 Spring���jar��
		1.1.3 Struts2���jar��
		1.1.4 mysql���ݿ�����
		1.1.6 c3p0����Դ
		1.1.6 struts2֧��springjar��:struts2-spring-plugin-2.1.8.1.jar
		
	1.2 ��֯���Ľṹ
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
	
	1.3 ʵ������
		1.3.1 ����Ա��
			Administrator
			private int id;
			private String adminName;
			private String pwd;
		1.3.2 Ա����
			Employee 
			private int id;
			private String empName;
			private double salary;
			private Department dept;
		1.3.3 ���ţ�	
			Department
			private int id;
			private String name;
			
	1.4 ���ݿ�����
		1.4.1 ����Ա��t_admin
		1.4.2 Ա���� t_employee (�벿�Ŷ��һ��ϵ)
		1.4.3 ���ű�t_dept
	
	1.5 ����spring�������ļ�
		
	1.6 struts2��ܵ�����
		1.6.1 ����struts2�������ļ�
			Ĭ�ϵ��ļ���Ϊstruts.xml�������WEB-INF/classesĿ¼�£���ʼʱӦ��srcĿ¼�´���
			
	1.7  ��web.xml�ļ���
			1.7.1 ����struts2MVC��ܵ�������ͨ��filter������
			1.7.2 ������������������,ȷ��web����������ʱ,ֱ�����spring�����ĳ�ʼ��,
					��ApplictionContext�ŵ�application��Χ��
			1.7.3 ͨ�������Ĳ���ָ��spring�����ļ���λ��
			
			
����дbean

������ʵ��bean��������д.hbm.xmlӳ���ļ�
	Department.hbm.xml
	Employee.hbm.xml
	Administrator.hbm.xml

�ġ�дdao��
	�ṩע��LocalSessionFactory�����Ժ�set����
	
	4.1 Ա���ӿڣ�
		   ����
		������
		����������ɾ��
		������id��ѯһ��Ա��
		����ѯ����Ա��
		�������ṩ��������Ա������ģ����ѯ
	4.2 ���Žӿڣ�����id��ѯһ�����š���ȡ���в���
	
	4.3 ����Ա�ӿڣ����桢���ݹ���Ա���ƺ������ѯһ������Ա
	
�塢дservice��
	�ṩע��dao�����Ժ�set����
	
	5.1 Ա���ӿڣ�
		   ����
		������
		����������ɾ��
		������id��ѯһ��Ա��
		����ѯ����Ա��
		�������ṩ��������Ա������ģ����ѯ
		## �����ṩ��id����ɾ�����Ա��
		
	5.2 ���Žӿڣ�����id��ѯһ�����š���ȡ���в���
	
	4.3 ����Ա�ӿڣ�## �ṩע�᷽��  ##�ṩ��½����
	
����дaction �̳�ActionSupport
	�ṩע��service�����Ժ�set����
	
�ߡ�дspring�������ļ���ʹ�÷�ɢ���ã�
	7.1 �������ļ�����ŵ�srcĿ¼�£���beans.xml
			ʹ��import��ǩ�������·�ɢ��4�������ļ�
			
	7.2 ��ɢ�����ļ�����ŵ������İ��У���
		7.2.1 bean_base.xml
			7.2.1.1 ���ݿ������Ϣ��Դ�ļ�λ�õ�ָ��
				����ʹ�÷�ɢ���ã�����ͬ���´�������д����Դ�ļ�����������Ϊ��jdbc.properties��
					��Դ�ļ���Ϣ������		
						a.�����ࣺjdbc.driverClass=com.mysql.jdbc.Driver
						b.���ݿ�url��jdbc.jdbcUrl=jdbc:mysql:///{���ݿ�����}
						c.�û�����jdbc.username=root
						d.���룺jdbc.password=root
						
						e.����c3p0����Դ�����ӳأ���Ҫ����Ϣ��
							maxPoolSize
							minPoolSize
							initialPoolSize
							acquireIncrement
							
			7.2.1.2 ����c3p0����Դ
			
			7.2.1.3 ���ñ��ػỰ����bean��spring��hibernate�ĺ��Ĺ�����ڣ�
					a. ���Ự����beanע��C3P0����Դ
					b. ����hibernate�����Լ�
						����ͬ���������Լ���Ϣ��ɢд��jdbc.properties��Դ�ļ��У�Ȼ�����������
						���Լ���Ϣ������
							hibernate.dialect
								hibernate����
							hibernate.show_sql
								�Ƿ��ڿ���̨��ʾhibernateִ��sql��䣨������ԣ����Բ����ã���
							hibernate.hbm2ddl.auto
								�����Զ������ֵ��ֵ�����ǡ�none����validate������validate��Ӧ������õ�ѡ������ spring�ڼ���֮�������model������ݿ��ṹ��ͬ���ͻᱨ�����������ڼ�����άԤ�ȷ������⡣
								��վ������ʽ�汾��ʱ�򣬶����ݿ����е����ݻ��ṹ�����Զ��ĸ����Ǻ�Σ�յġ���ʱ�˿�Ӧ����DBAͬ־ͨ���ֹ��ķ�ʽ���к�̨�����ݿ������
					c.ָ��ӳ����Դ�ļ���.hbm.xml�����ڵ�Ŀ¼��
						����ʹ��spring���������� ��mappingDirectoryLocations
						
			
			7.2.1.4 ����hibernate�������������spring�ṩ��ƽ̨�����������
					˵���������������ʵ������service���Ͻ�����������ﵽƽ̨�޹��ԣ�dao������������ƽ̨��أ�
							�����߱����������³־û���������ʵ������������еĻ��ǵײ���������
					ƽ̨���������Դapi���磺hibernate��jdbc��jdo��ojb�ȳ־û�����		
					a.�����������ע��Ự����
			
			7.2.1.5 ����֪ͨ���ã�������ι���
					a.����scheme��tx���ֿռ䣺"http://www.springframework.org/schema/tx"
					b.ָ�����������	
					c.�����������Լ�tx:attributes
						���Լ�������������Ϊ�����ݿ���뼶��ֻ�����ع�����
						
			7.2.1.6 ���������ã�aop���ã�������ʹ��pojo+xml�����÷�ʽ
					a.�������ʽ�����ã����ص�Ŀ��������ɴ������
					b.��װ֪ͨ,��֪ͨ��������㣨������ǿӦ�ã�
				
		7.2.2 bean_dao.xml
			��������dao��bean����ע��localSessionFactoryBean�����ػỰ������
			
		7.2.3 bean_service.xml
			7.2.3.1 ��������service��bean����ע��dao��bean
			7.2.3.2 ������Ϊʹ����ƽ̨�����������ֻ��Ҫ��spring������򽻵���
					ʵ������service���������������service��ΪĿ�����
					
		7.2.4 bean_action.xml			
			��������action�࣬��ע�����Ӧ��service
			

�ˡ�дstruts2�������ļ�
	8.1 ����action,�Լ�ת��������ͼ
	��action��class�ĳ�bean��id.
		<!-- class:ָ��action��spring������id -->
		<action name="HelloWorldAction_*" class="helloWorldAction" method="{1}">
	
�š���ͼ��Ӽ�������
	9.1 Ա������ɾ��
	9.2 дBaseDao.java
	9.3 ����û���ע��͵�½
	9.4 дȨ��������


