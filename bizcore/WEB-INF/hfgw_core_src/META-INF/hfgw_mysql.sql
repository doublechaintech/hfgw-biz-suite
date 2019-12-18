
-- BUILD WITH MODEL TIME 700101T0800
-- Turn off safe mode
SET SQL_SAFE_UPDATES = 0;


drop database  if exists hfgw;
create database hfgw;
-- alter  database hfgw  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use hfgw;
set SESSION sql_mode='';

drop table  if exists hyperledger_network_data;
create table hyperledger_network_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	description                   	longtext                                 comment '描述',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Hyperledger网络";
-- primary key will be created later for better import performance

drop table  if exists organization_data;
create table organization_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(50)                              comment '名称',
	mspid                         	varchar(20)                              comment 'Mspid',
	network                       	varchar(48)                              comment '网络',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "组织";
-- primary key will be created later for better import performance

drop table  if exists node_type_data;
create table node_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '名称',
	code                          	varchar(28)                              comment '代码',
	network                       	varchar(48)                              comment '网络',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "节点类型";
-- primary key will be created later for better import performance

drop table  if exists node_data;
create table node_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(50)                              comment '名称',
	url                           	varchar(200)                             comment 'url',
	organization                  	varchar(48)                              comment '组织',
	channel                       	varchar(48)                              comment '频道',
	network                       	varchar(48)                              comment '网络',
	tls_cacert                    	longtext                                 comment 'Tls Cacert',
	type                          	varchar(48)                              comment '类型',
	address                       	varchar(52)                              comment '地址',
	contact_person                	varchar(8)                               comment '联系人',
	contact_telephone             	varchar(44)                              comment '联系电话',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "节点";
-- primary key will be created later for better import performance

drop table  if exists grpc_option_data;
create table grpc_option_data (
	id                            	varchar(48)          not null            comment 'ID',
	parameter_name                	varchar(200)                             comment '参数名称',
	parameter_value               	varchar(200)                             comment '参数值',
	node                          	varchar(48)                              comment '节点',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Grpc选项";
-- primary key will be created later for better import performance

drop table  if exists channel_data;
create table channel_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(20)                              comment '名称',
	network                       	varchar(48)                              comment '网络',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "频道";
-- primary key will be created later for better import performance

drop table  if exists peer_role_data;
create table peer_role_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(56)                              comment '名称',
	code                          	varchar(56)                              comment '代码',
	network                       	varchar(48)                              comment '网络',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "对等的角色";
-- primary key will be created later for better import performance

drop table  if exists channel_peer_role_data;
create table channel_peer_role_data (
	id                            	varchar(48)          not null            comment 'ID',
	channel                       	varchar(48)                              comment '频道',
	node                          	varchar(48)                              comment '节点',
	peer_role                     	varchar(48)                              comment '对等的角色',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "通道对等的角色";
-- primary key will be created later for better import performance

drop table  if exists chain_code_data;
create table chain_code_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(24)                              comment '名称',
	code_name                     	varchar(50)                              comment '代号',
	code_version                  	varchar(50)                              comment '代码版本',
	channel                       	varchar(48)                              comment '频道',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "链码";
-- primary key will be created later for better import performance

drop table  if exists application_data;
create table application_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	create_time                   	datetime                                 comment '创建时间',
	mspid                         	varchar(200)                             comment 'Mspid',
	public_key                    	longtext                                 comment '公钥',
	private_key                   	longtext                                 comment '私钥',
	channel                       	varchar(48)                              comment '频道',
	network                       	varchar(48)                              comment '网络',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "应用程序";
-- primary key will be created later for better import performance

drop table  if exists service_record_data;
create table service_record_data (
	id                            	varchar(48)          not null            comment 'ID',
	transaction_id                	varchar(200)                             comment '事务Id',
	name                          	varchar(200)                             comment '名称',
	payload                       	longtext                                 comment '有效载荷',
	channel                       	varchar(48)                              comment '频道',
	chain_code                    	varchar(48)                              comment '链码',
	chain_code_function           	varchar(20)                              comment '链码功能',
	block_id                      	varchar(200)                             comment '块Id',
	create_time                   	datetime                                 comment '创建时间',
	app_client                    	varchar(48)                              comment '应用客户端',
	network                       	varchar(48)                              comment '网络',
	response                      	longtext                                 comment '响应',
	status                        	varchar(48)                              comment '状态',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "服务记录";
-- primary key will be created later for better import performance

drop table  if exists transaction_status_data;
create table transaction_status_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(36)                              comment '名称',
	code                          	varchar(36)                              comment '代码',
	network                       	varchar(48)                              comment '网络',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "交易状态";
-- primary key will be created later for better import performance

drop table  if exists change_request_type_data;
create table change_request_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(32)                              comment '名称',
	code                          	varchar(68)                              comment '代码',
	icon                          	varchar(24)                              comment '图标',
	display_order                 	int                                      comment '显示顺序',
	bind_types                    	longtext                                 comment '绑定类型',
	step_configuration            	longtext                                 comment '步配置',
	network                       	varchar(48)                              comment '网络',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "变更请求类型";
-- primary key will be created later for better import performance

drop table  if exists change_request_data;
create table change_request_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(50)                              comment '名称',
	create_time                   	datetime                                 comment '创建时间',
	remote_ip                     	varchar(40)                              comment '远程Ip',
	request_type                  	varchar(48)                              comment '请求类型',
	network                       	varchar(48)                              comment '网络',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "变更请求";
-- primary key will be created later for better import performance

drop table  if exists chain_code_invoker_data;
create table chain_code_invoker_data (
	id                            	varchar(48)          not null            comment 'ID',
	app_client                    	varchar(48)                              comment '应用客户端',
	chain_code                    	varchar(48)                              comment '链码',
	parameters                    	longtext                                 comment '参数',
	change_request                	varchar(48)                              comment '变更请求',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "链代码调用程序";
-- primary key will be created later for better import performance

drop table  if exists user_domain_data;
create table user_domain_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户域";
-- primary key will be created later for better import performance

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                            	varchar(48)          not null            comment 'ID',
	user_identity                 	varchar(40)                              comment '用户身份',
	user_special_functions        	varchar(200)                             comment '用户特殊功能',
	domain                        	varchar(48)                              comment '域',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户白名单";
-- primary key will be created later for better import performance

drop table  if exists sec_user_data;
create table sec_user_data (
	id                            	varchar(48)          not null            comment 'ID',
	login                         	varchar(256)                             comment '登录',
	mobile                        	varchar(11)                              comment '手机号码',
	email                         	varchar(256)                             comment '电子邮件',
	pwd                           	varchar(64)                              comment '密码',
	weixin_openid                 	varchar(128)                             comment '微信openid',
	weixin_appid                  	varchar(128)                             comment '微信Appid',
	access_token                  	varchar(128)                             comment '访问令牌',
	verification_code             	int                                      comment '验证码',
	verification_code_expire      	datetime                                 comment '验证码过期',
	last_login_time               	datetime                                 comment '最后登录时间',
	domain                        	varchar(48)                              comment '域',
	blocking                      	varchar(48)                              comment '屏蔽',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "安全用户";
-- primary key will be created later for better import performance

drop table  if exists sec_user_blocking_data;
create table sec_user_blocking_data (
	id                            	varchar(48)          not null            comment 'ID',
	who                           	varchar(52)                              comment '谁',
	block_time                    	datetime                                 comment '块时间',
	comments                      	varchar(96)                              comment '评论',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户屏蔽";
-- primary key will be created later for better import performance

drop table  if exists user_app_data;
create table user_app_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(300)                             comment '标题',
	sec_user                      	varchar(48)                              comment '安全用户',
	app_icon                      	varchar(36)                              comment '应用程序图标',
	full_access                   	tinyint                                  comment '完全访问',
	permission                    	varchar(16)                              comment '许可',
	object_type                   	varchar(100)                             comment '访问对象类型',
	object_id                     	varchar(40)                              comment '对象ID',
	location                      	varchar(48)                              comment '位置',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "用户应用程序";
-- primary key will be created later for better import performance

drop table  if exists quick_link_data;
create table quick_link_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	icon                          	varchar(200)                             comment '图标',
	image_path                    	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '图片路径',
	link_target                   	varchar(200)                             comment '链接的目标',
	create_time                   	datetime                                 comment '创建时间',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "快速链接";
-- primary key will be created later for better import performance

drop table  if exists list_access_data;
create table list_access_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	internal_name                 	varchar(200)                             comment '内部名称',
	read_permission               	tinyint                                  comment '读权限',
	create_permission             	tinyint                                  comment '创建权限',
	delete_permission             	tinyint                                  comment '删除权限',
	update_permission             	tinyint                                  comment '更新权限',
	execution_permission          	tinyint                                  comment '执行权限',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "访问列表";
-- primary key will be created later for better import performance

drop table  if exists object_access_data;
create table object_access_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '名称',
	object_type                   	varchar(112)                             comment '访问对象类型',
	list1                         	varchar(80)                              comment '列表1',
	list2                         	varchar(80)                              comment '列表2',
	list3                         	varchar(80)                              comment '列表3',
	list4                         	varchar(80)                              comment '列表4',
	list5                         	varchar(80)                              comment '列表5',
	list6                         	varchar(80)                              comment '列表6',
	list7                         	varchar(80)                              comment '列表7',
	list8                         	varchar(80)                              comment '列表8',
	list9                         	varchar(80)                              comment '列表9',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "对象访问";
-- primary key will be created later for better import performance

drop table  if exists login_history_data;
create table login_history_data (
	id                            	varchar(48)          not null            comment 'ID',
	login_time                    	datetime                                 comment '登录时间',
	from_ip                       	varchar(44)                              comment '来自IP',
	description                   	varchar(16)                              comment '描述',
	sec_user                      	varchar(48)                              comment '安全用户',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "登录历史";
-- primary key will be created later for better import performance

drop table  if exists generic_form_data;
create table generic_form_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(20)                              comment '标题',
	description                   	varchar(48)                              comment '描述',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "通用的形式";
-- primary key will be created later for better import performance

drop table  if exists form_message_data;
create table form_message_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(24)                              comment '标题',
	form                          	varchar(48)                              comment '形式',
	level                         	varchar(28)                              comment '水平',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单信息";
-- primary key will be created later for better import performance

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(16)                              comment '标题',
	parameter_name                	varchar(16)                              comment '参数名称',
	form                          	varchar(48)                              comment '形式',
	level                         	varchar(28)                              comment '水平',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单字段的信息";
-- primary key will be created later for better import performance

drop table  if exists form_field_data;
create table form_field_data (
	id                            	varchar(48)          not null            comment 'ID',
	label                         	varchar(12)                              comment '标签',
	locale_key                    	varchar(44)                              comment '语言环境的关键',
	parameter_name                	varchar(16)                              comment '参数名称',
	type                          	varchar(36)                              comment '类型',
	form                          	varchar(48)                              comment '形式',
	placeholder                   	varchar(48)                              comment '占位符',
	default_value                 	varchar(12)                              comment '默认值',
	description                   	varchar(48)                              comment '描述',
	field_group                   	varchar(16)                              comment '字段组',
	minimum_value                 	varchar(60)                              comment '最小值',
	maximum_value                 	varchar(72)                              comment '最大值',
	required                      	tinyint                                  comment '要求',
	disabled                      	tinyint                                  comment '禁用',
	custom_rendering              	tinyint                                  comment '自定义渲染',
	candidate_values              	varchar(12)                              comment '候选人的价值观',
	suggest_values                	varchar(12)                              comment '建议值',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单字段";
-- primary key will be created later for better import performance

drop table  if exists form_action_data;
create table form_action_data (
	id                            	varchar(48)          not null            comment 'ID',
	label                         	varchar(8)                               comment '标签',
	locale_key                    	varchar(16)                              comment '语言环境的关键',
	action_key                    	varchar(24)                              comment '行动的关键',
	level                         	varchar(28)                              comment '水平',
	url                           	varchar(168)                             comment 'url',
	form                          	varchar(48)                              comment '形式',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "表单动作";
-- primary key will be created later for better import performance

drop table  if exists candidate_container_data;
create table candidate_container_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "候选人容器";
-- primary key will be created later for better import performance

drop table  if exists candidate_element_data;
create table candidate_element_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	type                          	varchar(200)                             comment '类型',
	image                         	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment '图片',
	container                     	varchar(48)                              comment '容器',
	version                       	int                                      comment '版本'
	
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "候选人元素";
-- primary key will be created later for better import performance




insert into hyperledger_network_data values
	('HN000001','Hyperledger Fabric 应用网关','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','1');

insert into organization_data values
	('O000001','doublechaintech','doublechaintech','HN000001','1'),
	('O000002','doublechaintech0002','doublechaintech0002','HN000001','1');

insert into node_type_data values
	('peer','peer','peer','HN000001','1'),
	('orderer','orderer','orderer','HN000001','1');

insert into node_data values
	('N000001','skynet-peer','grpcs://www.skynet-peer.skynet.com:7051','O000001','C000001','HN000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','peer','北京市建国门内大街100号','张三','010-9998880','1'),
	('N000002','skynet-orderer','grpcs://www.skynet-orderer.skynet.com:7050','O000001','C000001','HN000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','peer','北京市建国门内大街100号0002','张三0002','010-99988800002','1'),
	('N000003','skynet-peer','grpcs://www.skynet-peer.skynet.com:7051','O000002','C000002','HN000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','orderer','北京市建国门内大街100号0003','张三0003','010-99988800003','1'),
	('N000004','skynet-orderer','grpcs://www.skynet-orderer.skynet.com:7050','O000002','C000002','HN000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','orderer','北京市建国门内大街100号0004','张三0004','010-99988800004','1');

insert into grpc_option_data values
	('GO000001','optionkey','optionValue','N000001','1'),
	('GO000002','optionkey0002','optionValue0002','N000001','1'),
	('GO000003','optionkey0003','optionValue0003','N000002','1'),
	('GO000004','optionkey0004','optionValue0004','N000002','1'),
	('GO000005','optionkey0005','optionValue0005','N000003','1'),
	('GO000006','optionkey0006','optionValue0006','N000003','1'),
	('GO000007','optionkey0007','optionValue0007','N000004','1'),
	('GO000008','optionkey0008','optionValue0008','N000004','1');

insert into channel_data values
	('C000001','channelname','HN000001','1'),
	('C000002','channelname0002','HN000001','1');

insert into peer_role_data values
	('endorsingPeer','endorsingPeer','endorsingPeer','HN000001','1'),
	('chaincodeQuery','chaincodeQuery','chaincodeQuery','HN000001','1'),
	('ledgerQuery','ledgerQuery','ledgerQuery','HN000001','1'),
	('eventSource','eventSource','eventSource','HN000001','1'),
	('discover','discover','discover','HN000001','1');

insert into channel_peer_role_data values
	('CPR000001','C000001','N000001','endorsingPeer','1'),
	('CPR000002','C000001','N000001','endorsingPeer','1'),
	('CPR000003','C000001','N000002','chaincodeQuery','1'),
	('CPR000004','C000001','N000002','chaincodeQuery','1'),
	('CPR000005','C000002','N000003','ledgerQuery','1'),
	('CPR000006','C000002','N000003','eventSource','1'),
	('CPR000007','C000002','N000004','eventSource','1'),
	('CPR000008','C000002','N000004','discover','1');

insert into chain_code_data values
	('CC000001','sacc:1','sacc','1','C000001','1'),
	('CC000002','sacc:10002','sacc0002','v1','C000001','1'),
	('CC000003','sacc:10003','sacc0003','1','C000002','1'),
	('CC000004','sacc:10004','sacc0004','v1','C000002','1');

insert into application_data values
	('A000001','生态环境处应用2','2019-11-18 15:26:24','skynet','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','C000001','HN000001','1'),
	('A000002','水环境管理处节点应用3','2019-11-29 09:50:23','doublechaintech','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','C000001','HN000001','1'),
	('A000003','科技与国际合作处应用4','2019-11-18 10:42:01','skynet','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','C000002','HN000001','1'),
	('A000004','生态环境处应用2','2019-11-21 11:47:13','doublechaintech','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','C000002','HN000001','1');

insert into service_record_data values
	('SR000001','a21fe3srw','调用链码','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','C000001','CC000001','transact','a21fe3srw','2019-11-25 15:00:42','A000001','HN000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','new','1'),
	('SR000002','a21fe3srw0002','网络管理','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','C000001','CC000001','transact0002','a21fe3srw0002','2019-11-20 20:37:31','A000001','HN000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','new','1'),
	('SR000003','a21fe3srw0003','调用链码','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','C000001','CC000002','transact0003','a21fe3srw0003','2019-11-23 10:23:54','A000002','HN000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','endorsed','1'),
	('SR000004','a21fe3srw0004','网络管理','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','C000001','CC000002','transact0004','a21fe3srw0004','2019-11-30 04:30:08','A000002','HN000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','endorsed','1'),
	('SR000005','a21fe3srw0005','调用链码','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','C000002','CC000003','transact0005','a21fe3srw0005','2019-11-22 09:59:21','A000003','HN000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','committed','1'),
	('SR000006','a21fe3srw0006','网络管理','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','C000002','CC000003','transact0006','a21fe3srw0006','2019-11-26 06:24:46','A000003','HN000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','committed','1'),
	('SR000007','a21fe3srw0007','调用链码','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','C000002','CC000004','transact0007','a21fe3srw0007','2019-11-23 04:09:32','A000004','HN000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','rejected','1'),
	('SR000008','a21fe3srw0008','网络管理','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','C000002','CC000004','transact0008','a21fe3srw0008','2019-12-01 15:14:10','A000004','HN000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','rejected','1');

insert into transaction_status_data values
	('new','new','new','HN000001','1'),
	('endorsed','endorsed','endorsed','HN000001','1'),
	('committed','committed','committed','HN000001','1'),
	('rejected','rejected','rejected','HN000001','1');

insert into change_request_type_data values
	('CERT_CHECKER','证书健康状况检测','CERT_CHECKER','upload','1','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','HN000001','1'),
	('NODE_CHECKER','节点健康状况检测','NODE_CHECKER','edit','2','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','HN000001','1'),
	('CERT_UPDATER','证书更新','CERT_UPDATER','edit','3','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','HN000001','1'),
	('NODE_ROLE_MANAGER','节点角色管理','NODE_ROLE_MANAGER','edit','4','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','HN000001','1'),
	('CC_INVOKER','调用链码发起交易','CC_INVOKER','edit','5','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','HN000001','1'),
	('CC_QUERIER','调用链码查询账本','CC_QUERIER','edit','6','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','HN000001','1'),
	('LEDGER_QUERIER','查看账本交易','LEDGER_QUERIER','edit','7','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','HN000001','1');

insert into change_request_data values
	('CR000001','存款','2019-12-01 00:56:10','8.8.8.8','CERT_CHECKER','HN000001','1'),
	('CR000002','转账','2019-11-20 00:47:31','8.8.8.8','NODE_CHECKER','HN000001','1'),
	('CR000003','取款','2019-11-15 01:44:26','8.8.8.8','NODE_ROLE_MANAGER','HN000001','1'),
	('CR000004','存款','2019-11-27 13:42:03','8.8.8.8','CC_QUERIER','HN000001','1');

insert into chain_code_invoker_data values
	('CCI000001','A000001','CC000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','CR000001','1'),
	('CCI000002','A000001','CC000001','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','CR000001','1'),
	('CCI000003','A000002','CC000002','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','CR000002','1'),
	('CCI000004','A000002','CC000002','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','CR000002','1'),
	('CCI000005','A000003','CC000003','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','CR000003','1'),
	('CCI000006','A000003','CC000003','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','CR000003','1'),
	('CCI000007','A000004','CC000004','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','CR000004','1'),
	('CCI000008','A000004','CC000004','    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n','CR000004','1');



-- Mysql innodb's foreign key has index automatically 
create unique index idx4id_ver_of_hyperledger_network on hyperledger_network_data (id, version);

create unique index idx4id_ver_of_organization on organization_data (id, version);

create unique index idx4id_ver_of_node_type on node_type_data (id, version);
create unique index idx4code_of_node_type on node_type_data (code);

create unique index idx4id_ver_of_node on node_data (id, version);

create unique index idx4id_ver_of_grpc_option on grpc_option_data (id, version);

create unique index idx4id_ver_of_channel on channel_data (id, version);

create unique index idx4id_ver_of_peer_role on peer_role_data (id, version);
create unique index idx4code_of_peer_role on peer_role_data (code);

create unique index idx4id_ver_of_channel_peer_role on channel_peer_role_data (id, version);

create unique index idx4id_ver_of_chain_code on chain_code_data (id, version);

create unique index idx4id_ver_of_application on application_data (id, version);
create  index idx4create_time_of_application on application_data (create_time);

create unique index idx4id_ver_of_service_record on service_record_data (id, version);
create  index idx4transaction_id_of_service_record on service_record_data (transaction_id);
create  index idx4block_id_of_service_record on service_record_data (block_id);
create  index idx4create_time_of_service_record on service_record_data (create_time);

create unique index idx4id_ver_of_transaction_status on transaction_status_data (id, version);
create unique index idx4code_of_transaction_status on transaction_status_data (code);

create unique index idx4id_ver_of_change_request_type on change_request_type_data (id, version);
create unique index idx4code_of_change_request_type on change_request_type_data (code);
create  index idx4display_order_of_change_request_type on change_request_type_data (display_order);

create unique index idx4id_ver_of_change_request on change_request_data (id, version);
create  index idx4create_time_of_change_request on change_request_data (create_time);

create unique index idx4id_ver_of_chain_code_invoker on chain_code_invoker_data (id, version);

create unique index idx4id_ver_of_user_domain on user_domain_data (id, version);

create unique index idx4id_ver_of_user_white_list on user_white_list_data (id, version);

create unique index idx4id_ver_of_sec_user on sec_user_data (id, version);
create unique index idx4login_of_sec_user on sec_user_data (login);
create unique index idx4email_of_sec_user on sec_user_data (email);
create unique index idx4mobile_of_sec_user on sec_user_data (mobile);
create  index idx4verification_code_of_sec_user on sec_user_data (verification_code);
create  index idx4verification_code_expire_of_sec_user on sec_user_data (verification_code_expire);
create  index idx4last_login_time_of_sec_user on sec_user_data (last_login_time);

create unique index idx4id_ver_of_sec_user_blocking on sec_user_blocking_data (id, version);
create  index idx4block_time_of_sec_user_blocking on sec_user_blocking_data (block_time);

create unique index idx4id_ver_of_user_app on user_app_data (id, version);
create  index idx4object_id_of_user_app on user_app_data (object_id);

create unique index idx4id_ver_of_quick_link on quick_link_data (id, version);
create  index idx4create_time_of_quick_link on quick_link_data (create_time);

create unique index idx4id_ver_of_list_access on list_access_data (id, version);

create unique index idx4id_ver_of_object_access on object_access_data (id, version);

create unique index idx4id_ver_of_login_history on login_history_data (id, version);
create  index idx4login_time_of_login_history on login_history_data (login_time);

create unique index idx4id_ver_of_generic_form on generic_form_data (id, version);

create unique index idx4id_ver_of_form_message on form_message_data (id, version);

create unique index idx4id_ver_of_form_field_message on form_field_message_data (id, version);

create unique index idx4id_ver_of_form_field on form_field_data (id, version);

create unique index idx4id_ver_of_form_action on form_action_data (id, version);

create unique index idx4id_ver_of_candidate_container on candidate_container_data (id, version);

create unique index idx4id_ver_of_candidate_element on candidate_element_data (id, version);
alter table hyperledger_network_data add constraint pk4id_of_hyperledger_network_data primary key (id);

alter table organization_data add constraint pk4id_of_organization_data primary key (id);
alter table organization_data add constraint 
	fk4network_of_organization_data foreign key (network) references hyperledger_network_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table node_type_data add constraint pk4id_of_node_type_data primary key (id);
alter table node_type_data add constraint 
	fk4network_of_node_type_data foreign key (network) references hyperledger_network_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table node_data add constraint pk4id_of_node_data primary key (id);
alter table node_data add constraint 
	fk4organization_of_node_data foreign key (organization) references organization_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table node_data add constraint 
	fk4channel_of_node_data foreign key (channel) references channel_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table node_data add constraint 
	fk4network_of_node_data foreign key (network) references hyperledger_network_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table node_data add constraint 
	fk4type_of_node_data foreign key (type) references node_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table grpc_option_data add constraint pk4id_of_grpc_option_data primary key (id);
alter table grpc_option_data add constraint 
	fk4node_of_grpc_option_data foreign key (node) references node_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table channel_data add constraint pk4id_of_channel_data primary key (id);
alter table channel_data add constraint 
	fk4network_of_channel_data foreign key (network) references hyperledger_network_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table peer_role_data add constraint pk4id_of_peer_role_data primary key (id);
alter table peer_role_data add constraint 
	fk4network_of_peer_role_data foreign key (network) references hyperledger_network_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table channel_peer_role_data add constraint pk4id_of_channel_peer_role_data primary key (id);
alter table channel_peer_role_data add constraint 
	fk4channel_of_channel_peer_role_data foreign key (channel) references channel_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table channel_peer_role_data add constraint 
	fk4node_of_channel_peer_role_data foreign key (node) references node_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table channel_peer_role_data add constraint 
	fk4peer_role_of_channel_peer_role_data foreign key (peer_role) references peer_role_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table chain_code_data add constraint pk4id_of_chain_code_data primary key (id);
alter table chain_code_data add constraint 
	fk4channel_of_chain_code_data foreign key (channel) references channel_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table application_data add constraint pk4id_of_application_data primary key (id);
alter table application_data add constraint 
	fk4channel_of_application_data foreign key (channel) references channel_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table application_data add constraint 
	fk4network_of_application_data foreign key (network) references hyperledger_network_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table service_record_data add constraint pk4id_of_service_record_data primary key (id);
alter table service_record_data add constraint 
	fk4channel_of_service_record_data foreign key (channel) references channel_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table service_record_data add constraint 
	fk4chain_code_of_service_record_data foreign key (chain_code) references chain_code_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table service_record_data add constraint 
	fk4app_client_of_service_record_data foreign key (app_client) references application_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table service_record_data add constraint 
	fk4network_of_service_record_data foreign key (network) references hyperledger_network_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table service_record_data add constraint 
	fk4status_of_service_record_data foreign key (status) references transaction_status_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table transaction_status_data add constraint pk4id_of_transaction_status_data primary key (id);
alter table transaction_status_data add constraint 
	fk4network_of_transaction_status_data foreign key (network) references hyperledger_network_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table change_request_type_data add constraint pk4id_of_change_request_type_data primary key (id);
alter table change_request_type_data add constraint 
	fk4network_of_change_request_type_data foreign key (network) references hyperledger_network_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table change_request_data add constraint pk4id_of_change_request_data primary key (id);
alter table change_request_data add constraint 
	fk4request_type_of_change_request_data foreign key (request_type) references change_request_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table change_request_data add constraint 
	fk4network_of_change_request_data foreign key (network) references hyperledger_network_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table chain_code_invoker_data add constraint pk4id_of_chain_code_invoker_data primary key (id);
alter table chain_code_invoker_data add constraint 
	fk4app_client_of_chain_code_invoker_data foreign key (app_client) references application_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table chain_code_invoker_data add constraint 
	fk4chain_code_of_chain_code_invoker_data foreign key (chain_code) references chain_code_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table chain_code_invoker_data add constraint 
	fk4change_request_of_chain_code_invoker_data foreign key (change_request) references change_request_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table user_domain_data add constraint pk4id_of_user_domain_data primary key (id);

alter table user_white_list_data add constraint pk4id_of_user_white_list_data primary key (id);
alter table user_white_list_data add constraint 
	fk4domain_of_user_white_list_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table sec_user_data add constraint pk4id_of_sec_user_data primary key (id);
alter table sec_user_data add constraint 
	fk4domain_of_sec_user_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table sec_user_data add constraint 
	fk4blocking_of_sec_user_data foreign key (blocking) references sec_user_blocking_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table sec_user_blocking_data add constraint pk4id_of_sec_user_blocking_data primary key (id);

alter table user_app_data add constraint pk4id_of_user_app_data primary key (id);
alter table user_app_data add constraint 
	fk4sec_user_of_user_app_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table quick_link_data add constraint pk4id_of_quick_link_data primary key (id);
alter table quick_link_data add constraint 
	fk4app_of_quick_link_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table list_access_data add constraint pk4id_of_list_access_data primary key (id);
alter table list_access_data add constraint 
	fk4app_of_list_access_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table object_access_data add constraint pk4id_of_object_access_data primary key (id);
alter table object_access_data add constraint 
	fk4app_of_object_access_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table login_history_data add constraint pk4id_of_login_history_data primary key (id);
alter table login_history_data add constraint 
	fk4sec_user_of_login_history_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table generic_form_data add constraint pk4id_of_generic_form_data primary key (id);

alter table form_message_data add constraint pk4id_of_form_message_data primary key (id);
alter table form_message_data add constraint 
	fk4form_of_form_message_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table form_field_message_data add constraint pk4id_of_form_field_message_data primary key (id);
alter table form_field_message_data add constraint 
	fk4form_of_form_field_message_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table form_field_data add constraint pk4id_of_form_field_data primary key (id);
alter table form_field_data add constraint 
	fk4form_of_form_field_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table form_action_data add constraint pk4id_of_form_action_data primary key (id);
alter table form_action_data add constraint 
	fk4form_of_form_action_data foreign key (form) references generic_form_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table candidate_container_data add constraint pk4id_of_candidate_container_data primary key (id);

alter table candidate_element_data add constraint pk4id_of_candidate_element_data primary key (id);
alter table candidate_element_data add constraint 
	fk4container_of_candidate_element_data foreign key (container) references candidate_container_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
-- create extra index for time, number and mobile phone







delete from list_access_data ;
delete from object_access_data ;
delete from user_app_data ;
delete from login_history_data ;
delete from sec_user_data ;
delete from user_domain_data ;
insert into user_domain_data values ('UD000001','用户区域','1');



insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','24327F1C00D22210298A18D0DB9AA6C4C22DEAC4BEAE7C02E616442CA7764246', 'weixin_openid_000001', 'weixin_appid_000001', 'jwt_token_000001' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,1);
insert into user_app_data values('UA000001','Hyperledger Fabric 应用网关','SU000001','university',1,'MXWR','HyperledgerNetwork','HN000001','/link/to/app','1');
insert into user_app_data values('UA000002','我的账户','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1');
insert into user_app_data values('UA000003','用户管理','SU000001','users',1,'MXWR','UserDomain','UD000001','/link/to/app','1');

/* ------------------------------ generate users for all target od marked as user4all ------------------------------------------ */


select mobile as `可用于登录的账号`, 'admin123' as `密码` from sec_user_data;

/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|


*/


create table info_lines(line varchar(400));

insert into info_lines values( '   SSSSSSSSSSSSSSS                                                                                                                  !!! ');
insert into info_lines values( ' SS:::::::::::::::S                                                                                                                !!:!!');
insert into info_lines values( 'S:::::SSSSSS::::::S                                                                                                                !:::!');
insert into info_lines values( 'S:::::S     SSSSSSS                                                                                                                !:::!');
insert into info_lines values( 'S:::::S            uuuuuu    uuuuuu      cccccccccccccccc    cccccccccccccccc    eeeeeeeeeeee        ssssssssss       ssssssssss   !:::!');
insert into info_lines values( 'S:::::S            u::::u    u::::u    cc:::::::::::::::c  cc:::::::::::::::c  ee::::::::::::ee    ss::::::::::s    ss::::::::::s  !:::!');
insert into info_lines values( ' S::::SSSS         u::::u    u::::u   c:::::::::::::::::c c:::::::::::::::::c e::::::eeeee:::::eess:::::::::::::s ss:::::::::::::s !:::!');
insert into info_lines values( '  SS::::::SSSSS    u::::u    u::::u  c:::::::cccccc:::::cc:::::::cccccc:::::ce::::::e     e:::::es::::::ssss:::::ss::::::ssss:::::s!:::!');
insert into info_lines values( '    SSS::::::::SS  u::::u    u::::u  c::::::c     cccccccc::::::c     ccccccce:::::::eeeee::::::e s:::::s  ssssss  s:::::s  ssssss !:::!');
insert into info_lines values( '       SSSSSS::::S u::::u    u::::u  c:::::c             c:::::c             e:::::::::::::::::e    s::::::s         s::::::s      !:::!');
insert into info_lines values( '            S:::::Su::::u    u::::u  c:::::c             c:::::c             e::::::eeeeeeeeeee        s::::::s         s::::::s   !!:!!');
insert into info_lines values( '            S:::::Su:::::uuuu:::::u  c::::::c     cccccccc::::::c     ccccccce:::::::e           ssssss   s:::::s ssssss   s:::::s  !!! ');
insert into info_lines values( 'SSSSSSS     S:::::Su:::::::::::::::uuc:::::::cccccc:::::cc:::::::cccccc:::::ce::::::::e          s:::::ssss::::::ss:::::ssss::::::s     ');
insert into info_lines values( 'S::::::SSSSSS:::::S u:::::::::::::::u c:::::::::::::::::c c:::::::::::::::::c e::::::::eeeeeeee  s::::::::::::::s s::::::::::::::s  !!! ');
insert into info_lines values( 'S:::::::::::::::SS   uu::::::::uu:::u  cc:::::::::::::::c  cc:::::::::::::::c  ee:::::::::::::e   s:::::::::::ss   s:::::::::::ss  !!:!!');
insert into info_lines values( ' SSSSSSSSSSSSSSS       uuuuuuuu  uuuu    cccccccccccccccc    cccccccccccccccc    eeeeeeeeeeeeee    sssssssssss      sssssssssss     !!! ');

select * from info_lines;
/* start with data patch */
/* The sql file is not found from: /home/philip/resin-3.1.12/webapps/sky/data-patch/hfgw.sql */
update change_request_type_data set bind_types='HyperledgerNetwork';
-- turn on safe mode
SET SQL_SAFE_UPDATES = 1;
-- change request type

/*
http://patorjk.com/software/taag/#p=testall&h=0&v=0&f=Graceful&t=Success!
   _____                                            _ 
  / ____|                                          | |
 | (___    _   _    ___    ___    ___   ___   ___  | |
  \\___   | | | |  / __|  / __|  / _  / __| / __| | |
  ____) | | |_| | | (__  | (__  |  __/ \\__  \\__  |_|
 |_____/   \\__,_|  \\___|  \\___|  \\___| |___/ |___/ (_)  
+----------+---------------------------------+---------------------+--------+
| Charset  | Description                     | Default collation   | Maxlen |
+----------+---------------------------------+---------------------+--------+
| gb2312   | GB2312 Simplified Chinese       | gb2312_chinese_ci   |      2 |
| gbk      | GBK Simplified Chinese          | gbk_chinese_ci      |      2 |
| utf8mb4  | UTF-8 Unicode                   | utf8mb4_general_ci  |      4 |
| utf32    | UTF-32 Unicode                  | utf32_general_ci    |      4 |
| gb18030  | China National Standard GB18030 | gb18030_chinese_ci  |      4 |
+----------+---------------------------------+---------------------+--------+

*/




