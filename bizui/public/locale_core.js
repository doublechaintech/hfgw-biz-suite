var coreLocaleMessage = [
  { key: 'hyperledger_network', chinese: 'hyperledger网络', english: 'hyperledger network' },
  { key: 'hyperledger_network.id', chinese: 'id', english: 'id' },
  { key: 'hyperledger_network.name', chinese: '名称', english: 'name' },
  { key: 'hyperledger_network.description', chinese: '描述', english: 'description' },
  { key: 'hyperledger_network.version', chinese: '版本', english: 'version' },
  {
    key: 'hyperledger_network.organization_list',
    chinese: '组织列表',
    english: 'organization list',
  },
  { key: 'hyperledger_network.node_type_list', chinese: '节点类型列表', english: 'node type list' },
  { key: 'hyperledger_network.node_list', chinese: '节点列表', english: 'node list' },
  { key: 'hyperledger_network.channel_list', chinese: '频道列表', english: 'channel list' },
  { key: 'hyperledger_network.peer_role_list', chinese: '同伴角色列表', english: 'peer role list' },
  {
    key: 'hyperledger_network.application_list',
    chinese: '应用程序列表',
    english: 'application list',
  },
  {
    key: 'hyperledger_network.service_record_list',
    chinese: '服务记录列表',
    english: 'service record list',
  },
  {
    key: 'hyperledger_network.transaction_status_list',
    chinese: '交易状态列表',
    english: 'transaction status list',
  },
  {
    key: 'hyperledger_network.change_request_type_list',
    chinese: '更改请求类型列表',
    english: 'change request type list',
  },
  {
    key: 'hyperledger_network.change_request_list',
    chinese: '变更请求列表',
    english: 'change request list',
  },
  { key: 'organization', chinese: '组织', english: 'organization' },
  { key: 'organization.id', chinese: 'id', english: 'id' },
  { key: 'organization.name', chinese: '名称', english: 'name' },
  { key: 'organization.mspid', chinese: 'mspid', english: 'mspid' },
  { key: 'organization.network', chinese: '网络', english: 'network' },
  { key: 'organization.version', chinese: '版本', english: 'version' },
  { key: 'organization.node_list', chinese: '节点列表', english: 'node list' },
  { key: 'node_type', chinese: '节点类型', english: 'node type' },
  { key: 'node_type.id', chinese: 'id', english: 'id' },
  { key: 'node_type.name', chinese: '名称', english: 'name' },
  { key: 'node_type.code', chinese: '代码', english: 'code' },
  { key: 'node_type.network', chinese: '网络', english: 'network' },
  { key: 'node_type.version', chinese: '版本', english: 'version' },
  { key: 'node_type.node_list', chinese: '节点列表', english: 'node list' },
  { key: 'node', chinese: '节点', english: 'node' },
  { key: 'node.id', chinese: 'id', english: 'id' },
  { key: 'node.name', chinese: '名称', english: 'name' },
  { key: 'node.url', chinese: 'url', english: 'url' },
  { key: 'node.organization', chinese: '组织', english: 'organization' },
  { key: 'node.channel', chinese: '频道', english: 'channel' },
  { key: 'node.network', chinese: '网络', english: 'network' },
  { key: 'node.tls_cacert', chinese: 'tls cacert', english: 'tls cacert' },
  { key: 'node.type', chinese: '类型', english: 'type' },
  { key: 'node.address', chinese: '地址', english: 'address' },
  { key: 'node.contact_person', chinese: '联系人', english: 'contact person' },
  { key: 'node.contact_telephone', chinese: '联系电话', english: 'contact telephone' },
  { key: 'node.version', chinese: '版本', english: 'version' },
  { key: 'node.grpc_option_list', chinese: 'grpc选项列表', english: 'grpc option list' },
  {
    key: 'node.channel_peer_role_list',
    chinese: '通道对等角色列表',
    english: 'channel peer role list',
  },
  { key: 'grpc_option', chinese: 'grpc选项', english: 'grpc option' },
  { key: 'grpc_option.id', chinese: 'id', english: 'id' },
  { key: 'grpc_option.parameter_name', chinese: '参数名称', english: 'parameter name' },
  { key: 'grpc_option.parameter_value', chinese: '参数值', english: 'parameter value' },
  { key: 'grpc_option.node', chinese: '节点', english: 'node' },
  { key: 'grpc_option.version', chinese: '版本', english: 'version' },
  { key: 'channel', chinese: '频道', english: 'channel' },
  { key: 'channel.id', chinese: 'id', english: 'id' },
  { key: 'channel.name', chinese: '名称', english: 'name' },
  { key: 'channel.network', chinese: '网络', english: 'network' },
  { key: 'channel.version', chinese: '版本', english: 'version' },
  { key: 'channel.node_list', chinese: '节点列表', english: 'node list' },
  {
    key: 'channel.channel_peer_role_list',
    chinese: '通道对等角色列表',
    english: 'channel peer role list',
  },
  { key: 'channel.chain_code_list', chinese: '链代码列表', english: 'chain code list' },
  { key: 'channel.application_list', chinese: '应用程序列表', english: 'application list' },
  { key: 'channel.service_record_list', chinese: '服务记录列表', english: 'service record list' },
  { key: 'peer_role', chinese: '对等的角色', english: 'peer role' },
  { key: 'peer_role.id', chinese: 'id', english: 'id' },
  { key: 'peer_role.name', chinese: '名称', english: 'name' },
  { key: 'peer_role.code', chinese: '代码', english: 'code' },
  { key: 'peer_role.network', chinese: '网络', english: 'network' },
  { key: 'peer_role.version', chinese: '版本', english: 'version' },
  {
    key: 'peer_role.channel_peer_role_list',
    chinese: '通道对等角色列表',
    english: 'channel peer role list',
  },
  { key: 'channel_peer_role', chinese: '通道对等的角色', english: 'channel peer role' },
  { key: 'channel_peer_role.id', chinese: 'id', english: 'id' },
  { key: 'channel_peer_role.channel', chinese: '频道', english: 'channel' },
  { key: 'channel_peer_role.node', chinese: '节点', english: 'node' },
  { key: 'channel_peer_role.peer_role', chinese: '对等的角色', english: 'peer role' },
  { key: 'channel_peer_role.version', chinese: '版本', english: 'version' },
  { key: 'chain_code', chinese: '链码', english: 'chain code' },
  { key: 'chain_code.id', chinese: 'id', english: 'id' },
  { key: 'chain_code.name', chinese: '名称', english: 'name' },
  { key: 'chain_code.code_name', chinese: '代号', english: 'code name' },
  { key: 'chain_code.code_version', chinese: '代码版本', english: 'code version' },
  { key: 'chain_code.channel', chinese: '频道', english: 'channel' },
  { key: 'chain_code.version', chinese: '版本', english: 'version' },
  {
    key: 'chain_code.service_record_list',
    chinese: '服务记录列表',
    english: 'service record list',
  },
  {
    key: 'chain_code.chain_code_invoker_list',
    chinese: '链代码调用程序列表',
    english: 'chain code invoker list',
  },
  { key: 'application', chinese: '应用程序', english: 'application' },
  { key: 'application.id', chinese: 'id', english: 'id' },
  { key: 'application.name', chinese: '名称', english: 'name' },
  { key: 'application.create_time', chinese: '创建时间', english: 'create time' },
  { key: 'application.mspid', chinese: 'mspid', english: 'mspid' },
  { key: 'application.public_key', chinese: '公钥', english: 'public key' },
  { key: 'application.private_key', chinese: '私钥', english: 'private key' },
  { key: 'application.channel', chinese: '频道', english: 'channel' },
  { key: 'application.network', chinese: '网络', english: 'network' },
  { key: 'application.version', chinese: '版本', english: 'version' },
  {
    key: 'application.service_record_list',
    chinese: '服务记录列表',
    english: 'service record list',
  },
  {
    key: 'application.chain_code_invoker_list',
    chinese: '链代码调用程序列表',
    english: 'chain code invoker list',
  },
  { key: 'service_record', chinese: '服务记录', english: 'service record' },
  { key: 'service_record.id', chinese: 'id', english: 'id' },
  { key: 'service_record.transaction_id', chinese: '事务id', english: 'transaction id' },
  { key: 'service_record.name', chinese: '名称', english: 'name' },
  { key: 'service_record.payload', chinese: '有效载荷', english: 'payload' },
  { key: 'service_record.channel', chinese: '频道', english: 'channel' },
  { key: 'service_record.chain_code', chinese: '链码', english: 'chain code' },
  {
    key: 'service_record.chain_code_function',
    chinese: '链码功能',
    english: 'chain code function',
  },
  { key: 'service_record.block_id', chinese: '块id', english: 'block id' },
  { key: 'service_record.create_time', chinese: '创建时间', english: 'create time' },
  { key: 'service_record.app_client', chinese: '应用客户端', english: 'app client' },
  { key: 'service_record.network', chinese: '网络', english: 'network' },
  { key: 'service_record.response', chinese: '响应', english: 'response' },
  { key: 'service_record.status', chinese: '状态', english: 'status' },
  { key: 'service_record.version', chinese: '版本', english: 'version' },
  { key: 'transaction_status', chinese: '交易状态', english: 'transaction status' },
  { key: 'transaction_status.id', chinese: 'id', english: 'id' },
  { key: 'transaction_status.name', chinese: '名称', english: 'name' },
  { key: 'transaction_status.code', chinese: '代码', english: 'code' },
  { key: 'transaction_status.network', chinese: '网络', english: 'network' },
  { key: 'transaction_status.version', chinese: '版本', english: 'version' },
  {
    key: 'transaction_status.service_record_list',
    chinese: '服务记录列表',
    english: 'service record list',
  },
  { key: 'change_request_type', chinese: '变更请求类型', english: 'change request type' },
  { key: 'change_request_type.id', chinese: 'id', english: 'id' },
  { key: 'change_request_type.name', chinese: '名称', english: 'name' },
  { key: 'change_request_type.code', chinese: '代码', english: 'code' },
  { key: 'change_request_type.icon', chinese: '图标', english: 'icon' },
  { key: 'change_request_type.display_order', chinese: '显示顺序', english: 'display order' },
  { key: 'change_request_type.bind_types', chinese: '绑定类型', english: 'bind types' },
  {
    key: 'change_request_type.step_configuration',
    chinese: '步配置',
    english: 'step configuration',
  },
  { key: 'change_request_type.network', chinese: '网络', english: 'network' },
  { key: 'change_request_type.version', chinese: '版本', english: 'version' },
  {
    key: 'change_request_type.change_request_list',
    chinese: '变更请求列表',
    english: 'change request list',
  },
  { key: 'change_request', chinese: '变更请求', english: 'change request' },
  { key: 'change_request.id', chinese: 'id', english: 'id' },
  { key: 'change_request.name', chinese: '名称', english: 'name' },
  { key: 'change_request.create_time', chinese: '创建时间', english: 'create time' },
  { key: 'change_request.remote_ip', chinese: '远程ip', english: 'remote ip' },
  { key: 'change_request.request_type', chinese: '请求类型', english: 'request type' },
  { key: 'change_request.network', chinese: '网络', english: 'network' },
  { key: 'change_request.version', chinese: '版本', english: 'version' },
  {
    key: 'change_request.chain_code_invoker_list',
    chinese: '链代码调用程序列表',
    english: 'chain code invoker list',
  },
  { key: 'chain_code_invoker', chinese: '链代码调用程序', english: 'chain code invoker' },
  { key: 'chain_code_invoker.id', chinese: 'id', english: 'id' },
  { key: 'chain_code_invoker.app_client', chinese: '应用客户端', english: 'app client' },
  { key: 'chain_code_invoker.chain_code', chinese: '链码', english: 'chain code' },
  { key: 'chain_code_invoker.parameters', chinese: '参数', english: 'parameters' },
  { key: 'chain_code_invoker.change_request', chinese: '变更请求', english: 'change request' },
  { key: 'chain_code_invoker.version', chinese: '版本', english: 'version' },
  { key: 'user_domain', chinese: '用户域', english: 'user domain' },
  { key: 'user_domain.id', chinese: 'id', english: 'id' },
  { key: 'user_domain.name', chinese: '名称', english: 'name' },
  { key: 'user_domain.version', chinese: '版本', english: 'version' },
  {
    key: 'user_domain.user_white_list_list',
    chinese: '用户白名单',
    english: 'user white list list',
  },
  { key: 'user_domain.sec_user_list', chinese: 'sec的用户列表', english: 'sec user list' },
  { key: 'user_white_list', chinese: '用户白名单', english: 'user white list' },
  { key: 'user_white_list.id', chinese: 'id', english: 'id' },
  { key: 'user_white_list.user_identity', chinese: '用户身份', english: 'user identity' },
  {
    key: 'user_white_list.user_special_functions',
    chinese: '用户特殊功能',
    english: 'user special functions',
  },
  { key: 'user_white_list.domain', chinese: '域', english: 'domain' },
  { key: 'user_white_list.version', chinese: '版本', english: 'version' },
  { key: 'sec_user', chinese: '安全用户', english: 'sec user' },
  { key: 'sec_user.id', chinese: 'id', english: 'id' },
  { key: 'sec_user.login', chinese: '登录', english: 'login' },
  { key: 'sec_user.mobile', chinese: '手机号码', english: 'mobile' },
  { key: 'sec_user.email', chinese: '电子邮件', english: 'email' },
  { key: 'sec_user.pwd', chinese: '密码', english: 'pwd' },
  { key: 'sec_user.weixin_openid', chinese: '微信openid', english: 'weixin openid' },
  { key: 'sec_user.weixin_appid', chinese: '微信appid', english: 'weixin appid' },
  { key: 'sec_user.access_token', chinese: '访问令牌', english: 'access token' },
  { key: 'sec_user.verification_code', chinese: '验证码', english: 'verification code' },
  {
    key: 'sec_user.verification_code_expire',
    chinese: '验证码过期',
    english: 'verification code expire',
  },
  { key: 'sec_user.last_login_time', chinese: '最后登录时间', english: 'last login time' },
  { key: 'sec_user.domain', chinese: '域', english: 'domain' },
  { key: 'sec_user.blocking', chinese: '屏蔽', english: 'blocking' },
  { key: 'sec_user.version', chinese: '版本', english: 'version' },
  { key: 'sec_user.user_app_list', chinese: '用户应用程序列表', english: 'user app list' },
  { key: 'sec_user.login_history_list', chinese: '登录历史列表', english: 'login history list' },
  { key: 'sec_user_blocking', chinese: '用户屏蔽', english: 'sec user blocking' },
  { key: 'sec_user_blocking.id', chinese: 'id', english: 'id' },
  { key: 'sec_user_blocking.who', chinese: '谁', english: 'who' },
  { key: 'sec_user_blocking.block_time', chinese: '块时间', english: 'block time' },
  { key: 'sec_user_blocking.comments', chinese: '评论', english: 'comments' },
  { key: 'sec_user_blocking.version', chinese: '版本', english: 'version' },
  { key: 'sec_user_blocking.sec_user_list', chinese: 'sec的用户列表', english: 'sec user list' },
  { key: 'user_app', chinese: '用户应用程序', english: 'user app' },
  { key: 'user_app.id', chinese: 'id', english: 'id' },
  { key: 'user_app.title', chinese: '标题', english: 'title' },
  { key: 'user_app.sec_user', chinese: '安全用户', english: 'sec user' },
  { key: 'user_app.app_icon', chinese: '应用程序图标', english: 'app icon' },
  { key: 'user_app.full_access', chinese: '完全访问', english: 'full access' },
  { key: 'user_app.permission', chinese: '许可', english: 'permission' },
  { key: 'user_app.object_type', chinese: '访问对象类型', english: 'object type' },
  { key: 'user_app.object_id', chinese: '对象id', english: 'object id' },
  { key: 'user_app.location', chinese: '位置', english: 'location' },
  { key: 'user_app.version', chinese: '版本', english: 'version' },
  { key: 'user_app.quick_link_list', chinese: '快速链接列表', english: 'quick link list' },
  { key: 'user_app.list_access_list', chinese: '访问列表', english: 'list access list' },
  { key: 'user_app.object_access_list', chinese: '对象访问列表', english: 'object access list' },
  { key: 'quick_link', chinese: '快速链接', english: 'quick link' },
  { key: 'quick_link.id', chinese: 'id', english: 'id' },
  { key: 'quick_link.name', chinese: '名称', english: 'name' },
  { key: 'quick_link.icon', chinese: '图标', english: 'icon' },
  { key: 'quick_link.image_path', chinese: '图片路径', english: 'image path' },
  { key: 'quick_link.link_target', chinese: '链接的目标', english: 'link target' },
  { key: 'quick_link.create_time', chinese: '创建时间', english: 'create time' },
  { key: 'quick_link.app', chinese: '应用程序', english: 'app' },
  { key: 'quick_link.version', chinese: '版本', english: 'version' },
  { key: 'list_access', chinese: '访问列表', english: 'list access' },
  { key: 'list_access.id', chinese: 'id', english: 'id' },
  { key: 'list_access.name', chinese: '名称', english: 'name' },
  { key: 'list_access.internal_name', chinese: '内部名称', english: 'internal name' },
  { key: 'list_access.read_permission', chinese: '读权限', english: 'read permission' },
  { key: 'list_access.create_permission', chinese: '创建权限', english: 'create permission' },
  { key: 'list_access.delete_permission', chinese: '删除权限', english: 'delete permission' },
  { key: 'list_access.update_permission', chinese: '更新权限', english: 'update permission' },
  { key: 'list_access.execution_permission', chinese: '执行权限', english: 'execution permission' },
  { key: 'list_access.app', chinese: '应用程序', english: 'app' },
  { key: 'list_access.version', chinese: '版本', english: 'version' },
  { key: 'object_access', chinese: '对象访问', english: 'object access' },
  { key: 'object_access.id', chinese: 'id', english: 'id' },
  { key: 'object_access.name', chinese: '名称', english: 'name' },
  { key: 'object_access.object_type', chinese: '访问对象类型', english: 'object type' },
  { key: 'object_access.list1', chinese: '列表1', english: 'list1' },
  { key: 'object_access.list2', chinese: '列表2', english: 'list2' },
  { key: 'object_access.list3', chinese: '列表3', english: 'list3' },
  { key: 'object_access.list4', chinese: '列表4', english: 'list4' },
  { key: 'object_access.list5', chinese: '列表5', english: 'list5' },
  { key: 'object_access.list6', chinese: '列表6', english: 'list6' },
  { key: 'object_access.list7', chinese: '列表7', english: 'list7' },
  { key: 'object_access.list8', chinese: '列表8', english: 'list8' },
  { key: 'object_access.list9', chinese: '列表9', english: 'list9' },
  { key: 'object_access.app', chinese: '应用程序', english: 'app' },
  { key: 'object_access.version', chinese: '版本', english: 'version' },
  { key: 'login_history', chinese: '登录历史', english: 'login history' },
  { key: 'login_history.id', chinese: 'id', english: 'id' },
  { key: 'login_history.login_time', chinese: '登录时间', english: 'login time' },
  { key: 'login_history.from_ip', chinese: '来自ip', english: 'from ip' },
  { key: 'login_history.description', chinese: '描述', english: 'description' },
  { key: 'login_history.sec_user', chinese: '安全用户', english: 'sec user' },
  { key: 'login_history.version', chinese: '版本', english: 'version' },
  { key: 'generic_form', chinese: '通用的形式', english: 'generic form' },
  { key: 'generic_form.id', chinese: 'id', english: 'id' },
  { key: 'generic_form.title', chinese: '标题', english: 'title' },
  { key: 'generic_form.description', chinese: '描述', english: 'description' },
  { key: 'generic_form.version', chinese: '版本', english: 'version' },
  { key: 'generic_form.form_message_list', chinese: '消息列表形式', english: 'form message list' },
  {
    key: 'generic_form.form_field_message_list',
    chinese: '表单字段消息列表',
    english: 'form field message list',
  },
  { key: 'generic_form.form_field_list', chinese: '表单字段列表', english: 'form field list' },
  { key: 'generic_form.form_action_list', chinese: '表单动作列表', english: 'form action list' },
  { key: 'form_message', chinese: '表单信息', english: 'form message' },
  { key: 'form_message.id', chinese: 'id', english: 'id' },
  { key: 'form_message.title', chinese: '标题', english: 'title' },
  { key: 'form_message.form', chinese: '形式', english: 'form' },
  { key: 'form_message.level', chinese: '水平', english: 'level' },
  { key: 'form_message.version', chinese: '版本', english: 'version' },
  { key: 'form_field_message', chinese: '表单字段的信息', english: 'form field message' },
  { key: 'form_field_message.id', chinese: 'id', english: 'id' },
  { key: 'form_field_message.title', chinese: '标题', english: 'title' },
  { key: 'form_field_message.parameter_name', chinese: '参数名称', english: 'parameter name' },
  { key: 'form_field_message.form', chinese: '形式', english: 'form' },
  { key: 'form_field_message.level', chinese: '水平', english: 'level' },
  { key: 'form_field_message.version', chinese: '版本', english: 'version' },
  { key: 'form_field', chinese: '表单字段', english: 'form field' },
  { key: 'form_field.id', chinese: 'id', english: 'id' },
  { key: 'form_field.label', chinese: '标签', english: 'label' },
  { key: 'form_field.locale_key', chinese: '语言环境的关键', english: 'locale key' },
  { key: 'form_field.parameter_name', chinese: '参数名称', english: 'parameter name' },
  { key: 'form_field.type', chinese: '类型', english: 'type' },
  { key: 'form_field.form', chinese: '形式', english: 'form' },
  { key: 'form_field.placeholder', chinese: '占位符', english: 'placeholder' },
  { key: 'form_field.default_value', chinese: '默认值', english: 'default value' },
  { key: 'form_field.description', chinese: '描述', english: 'description' },
  { key: 'form_field.field_group', chinese: '字段组', english: 'field group' },
  { key: 'form_field.minimum_value', chinese: '最小值', english: 'minimum value' },
  { key: 'form_field.maximum_value', chinese: '最大值', english: 'maximum value' },
  { key: 'form_field.required', chinese: '要求', english: 'required' },
  { key: 'form_field.disabled', chinese: '禁用', english: 'disabled' },
  { key: 'form_field.custom_rendering', chinese: '自定义渲染', english: 'custom rendering' },
  { key: 'form_field.candidate_values', chinese: '候选人的价值观', english: 'candidate values' },
  { key: 'form_field.suggest_values', chinese: '建议值', english: 'suggest values' },
  { key: 'form_field.version', chinese: '版本', english: 'version' },
  { key: 'form_action', chinese: '表单动作', english: 'form action' },
  { key: 'form_action.id', chinese: 'id', english: 'id' },
  { key: 'form_action.label', chinese: '标签', english: 'label' },
  { key: 'form_action.locale_key', chinese: '语言环境的关键', english: 'locale key' },
  { key: 'form_action.action_key', chinese: '行动的关键', english: 'action key' },
  { key: 'form_action.level', chinese: '水平', english: 'level' },
  { key: 'form_action.url', chinese: 'url', english: 'url' },
  { key: 'form_action.form', chinese: '形式', english: 'form' },
  { key: 'form_action.version', chinese: '版本', english: 'version' },
  { key: 'candidate_container', chinese: '候选人容器', english: 'candidate container' },
  { key: 'candidate_container.id', chinese: 'id', english: 'id' },
  { key: 'candidate_container.name', chinese: '名称', english: 'name' },
  { key: 'candidate_container.version', chinese: '版本', english: 'version' },
  {
    key: 'candidate_container.candidate_element_list',
    chinese: '候选人元素列表',
    english: 'candidate element list',
  },
  { key: 'candidate_element', chinese: '候选人元素', english: 'candidate element' },
  { key: 'candidate_element.id', chinese: 'id', english: 'id' },
  { key: 'candidate_element.name', chinese: '名称', english: 'name' },
  { key: 'candidate_element.type', chinese: '类型', english: 'type' },
  { key: 'candidate_element.image', chinese: '图片', english: 'image' },
  { key: 'candidate_element.container', chinese: '容器', english: 'container' },
  { key: 'candidate_element.version', chinese: '版本', english: 'version' },
];
