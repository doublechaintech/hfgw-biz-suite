package com.doublechaintech.hfgw;

import com.doublechaintech.hfgw.genericform.GenericForm;
import com.doublechaintech.hfgw.formfield.FormField;
import com.doublechaintech.hfgw.formaction.FormAction;
import com.doublechaintech.hfgw.formmessage.FormMessage;
import com.doublechaintech.hfgw.formfieldmessage.FormFieldMessage;




public class BaseForm extends GenericForm{

	public FormField getFieldByParamterName(String parameterName){
        
        for(FormField field: this.getFormFieldList()){
            if(parameterName.equals(field.getParameterName())){
                return field;
            }
            
        }
        return null;
    }
	public BaseForm hideByParamterName(String parameterName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setType("hidden");
				break;
			}
			
		}
		return this;
	}
	public BaseForm disableByParamterName(String parameterName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setDisabled(true);
				break;
			}
			
		}
		return this;
	}
	public BaseForm setAllGroupNameTo(String groupName){
		
		for(FormField field: this.getFormFieldList()){
			field.setFieldGroup(groupName);
		}
		return this;
		
	}
	
	public BaseForm disableByGroup(String groupName){
		
		for(FormField field: this.getFormFieldList()){
			if(groupName.equals(field.getFieldGroup())){
				field.setDisabled(true);
				continue;
			}
			
		}
		return this;
		
	}
	
	public BaseForm setGroupNameByParamterName(String parameterName, String groupName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setFieldGroup(groupName);
				break;
			}
			
		}
		return this;
		
	}


	protected FormField idFromHyperledgerNetwork(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("hyperledger_network.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromHyperledgerNetwork(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("hyperledger_network.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField descriptionFromHyperledgerNetwork(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("hyperledger_network.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("longtext");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField idFromOrganization(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("organization.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromOrganization(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("organization.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField mspidFromOrganization(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Mspid");
		field.setLocaleKey("organization.mspid");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Mspid");
		return field;
	}

	protected FormField networkIdFromOrganization(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("网络");
		field.setLocaleKey("organization.network");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("HyperledgerNetwork");
		field.setRequired(true);
		field.setPlaceholder("请填写网络");
		return field;
	}

	protected FormField idFromNodeType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("node_type.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromNodeType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("node_type.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField codeFromNodeType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代码");
		field.setLocaleKey("node_type.code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代码");
		return field;
	}

	protected FormField networkIdFromNodeType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("网络");
		field.setLocaleKey("node_type.network");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("HyperledgerNetwork");
		field.setRequired(true);
		field.setPlaceholder("请填写网络");
		return field;
	}

	protected FormField addressFromNodeType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("地址");
		field.setLocaleKey("node_type.address");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写地址");
		return field;
	}

	protected FormField contactPersonFromNodeType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("联系人");
		field.setLocaleKey("node_type.contact_person");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写联系人");
		return field;
	}

	protected FormField contactTelephoneFromNodeType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("联系电话");
		field.setLocaleKey("node_type.contact_telephone");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写联系电话");
		return field;
	}

	protected FormField idFromNode(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("node.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromNode(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("node.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField urlFromNode(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("url");
		field.setLocaleKey("node.url");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写url");
		return field;
	}

	protected FormField organizationIdFromNode(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("组织");
		field.setLocaleKey("node.organization");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Organization");
		field.setRequired(true);
		field.setPlaceholder("请填写组织");
		return field;
	}

	protected FormField channelIdFromNode(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("频道");
		field.setLocaleKey("node.channel");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Channel");
		field.setRequired(true);
		field.setPlaceholder("请填写频道");
		return field;
	}

	protected FormField typeIdFromNode(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("类型");
		field.setLocaleKey("node.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("NodeType");
		field.setRequired(true);
		field.setPlaceholder("请填写类型");
		return field;
	}

	protected FormField idFromGrpcOption(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("grpc_option.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField parameterNameFromGrpcOption(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("参数名称");
		field.setLocaleKey("grpc_option.parameter_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写参数名称");
		return field;
	}

	protected FormField parameterValueFromGrpcOption(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("参数值");
		field.setLocaleKey("grpc_option.parameter_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写参数值");
		return field;
	}

	protected FormField nodeIdFromGrpcOption(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("节点");
		field.setLocaleKey("grpc_option.node");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Node");
		field.setRequired(true);
		field.setPlaceholder("请填写节点");
		return field;
	}

	protected FormField idFromTlsCacert(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("tls_cacert.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField pathFromTlsCacert(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("路径");
		field.setLocaleKey("tls_cacert.path");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写路径");
		return field;
	}

	protected FormField certFromTlsCacert(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Cert");
		field.setLocaleKey("tls_cacert.cert");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("longtext");
		field.setRequired(true);
		field.setPlaceholder("请填写Cert");
		return field;
	}

	protected FormField nodeIdFromTlsCacert(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("节点");
		field.setLocaleKey("tls_cacert.node");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Node");
		field.setRequired(true);
		field.setPlaceholder("请填写节点");
		return field;
	}

	protected FormField idFromChannel(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("channel.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromChannel(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("channel.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField networkIdFromChannel(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("网络");
		field.setLocaleKey("channel.network");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("HyperledgerNetwork");
		field.setRequired(true);
		field.setPlaceholder("请填写网络");
		return field;
	}

	protected FormField idFromChainCode(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("chain_code.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromChainCode(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("chain_code.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField codeNameFromChainCode(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代号");
		field.setLocaleKey("chain_code.code_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代号");
		return field;
	}

	protected FormField codeVersionFromChainCode(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代码版本");
		field.setLocaleKey("chain_code.code_version");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代码版本");
		return field;
	}

	protected FormField channelIdFromChainCode(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("频道");
		field.setLocaleKey("chain_code.channel");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Channel");
		field.setRequired(true);
		field.setPlaceholder("请填写频道");
		return field;
	}

	protected FormField idFromApplication(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("application.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromApplication(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("application.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField createTimeFromApplication(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("创建时间");
		field.setLocaleKey("application.create_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写创建时间");
		return field;
	}

	protected FormField mspidFromApplication(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Mspid");
		field.setLocaleKey("application.mspid");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Mspid");
		return field;
	}

	protected FormField publicKeyFromApplication(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公钥");
		field.setLocaleKey("application.public_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("longtext");
		field.setRequired(true);
		field.setPlaceholder("请填写公钥");
		return field;
	}

	protected FormField privateKeyFromApplication(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("私钥");
		field.setLocaleKey("application.private_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("longtext");
		field.setRequired(true);
		field.setPlaceholder("请填写私钥");
		return field;
	}

	protected FormField channelIdFromApplication(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("频道");
		field.setLocaleKey("application.channel");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Channel");
		field.setRequired(true);
		field.setPlaceholder("请填写频道");
		return field;
	}

	protected FormField networkIdFromApplication(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("网络");
		field.setLocaleKey("application.network");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("HyperledgerNetwork");
		field.setRequired(true);
		field.setPlaceholder("请填写网络");
		return field;
	}

	protected FormField idFromServiceRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("service_record.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromServiceRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("service_record.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField payLoadFromServiceRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("支付负载");
		field.setLocaleKey("service_record.pay_load");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("longtext");
		field.setRequired(true);
		field.setPlaceholder("请填写支付负载");
		return field;
	}

	protected FormField channelIdFromServiceRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("频道");
		field.setLocaleKey("service_record.channel");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Channel");
		field.setRequired(true);
		field.setPlaceholder("请填写频道");
		return field;
	}

	protected FormField chainCodeIdFromServiceRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("链码");
		field.setLocaleKey("service_record.chain_code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ChainCode");
		field.setRequired(true);
		field.setPlaceholder("请填写链码");
		return field;
	}

	protected FormField transactionIdFromServiceRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("事务Id");
		field.setLocaleKey("service_record.transaction_id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写事务Id");
		return field;
	}

	protected FormField blockIdFromServiceRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("块Id");
		field.setLocaleKey("service_record.block_id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写块Id");
		return field;
	}

	protected FormField createTimeFromServiceRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("创建时间");
		field.setLocaleKey("service_record.create_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写创建时间");
		return field;
	}

	protected FormField applicationIdFromServiceRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("应用程序");
		field.setLocaleKey("service_record.application");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Application");
		field.setRequired(true);
		field.setPlaceholder("请填写应用程序");
		return field;
	}

	protected FormField networkIdFromServiceRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("网络");
		field.setLocaleKey("service_record.network");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("HyperledgerNetwork");
		field.setRequired(true);
		field.setPlaceholder("请填写网络");
		return field;
	}

	protected FormField currentStatusFromServiceRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("当前状态");
		field.setLocaleKey("service_record.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写当前状态");
		return field;
	}

	protected FormField idFromChangeRequestType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("change_request_type.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromChangeRequestType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("change_request_type.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField codeFromChangeRequestType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代码");
		field.setLocaleKey("change_request_type.code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代码");
		return field;
	}

	protected FormField iconFromChangeRequestType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("图标");
		field.setLocaleKey("change_request_type.icon");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写图标");
		return field;
	}

	protected FormField displayOrderFromChangeRequestType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("显示顺序");
		field.setLocaleKey("change_request_type.display_order");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写显示顺序");
		return field;
	}

	protected FormField bindTypesFromChangeRequestType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("绑定类型");
		field.setLocaleKey("change_request_type.bind_types");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("longtext");
		field.setRequired(true);
		field.setPlaceholder("请填写绑定类型");
		return field;
	}

	protected FormField stepConfigurationFromChangeRequestType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("步配置");
		field.setLocaleKey("change_request_type.step_configuration");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("longtext");
		field.setRequired(true);
		field.setPlaceholder("请填写步配置");
		return field;
	}

	protected FormField networkIdFromChangeRequestType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("网络");
		field.setLocaleKey("change_request_type.network");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("HyperledgerNetwork");
		field.setRequired(true);
		field.setPlaceholder("请填写网络");
		return field;
	}

	protected FormField idFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("change_request.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("change_request.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField createTimeFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("创建时间");
		field.setLocaleKey("change_request.create_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写创建时间");
		return field;
	}

	protected FormField remoteIpFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("远程Ip");
		field.setLocaleKey("change_request.remote_ip");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写远程Ip");
		return field;
	}

	protected FormField requestTypeIdFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("请求类型");
		field.setLocaleKey("change_request.request_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ChangeRequestType");
		field.setRequired(true);
		field.setPlaceholder("请填写请求类型");
		return field;
	}

	protected FormField networkIdFromChangeRequest(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("网络");
		field.setLocaleKey("change_request.network");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("HyperledgerNetwork");
		field.setRequired(true);
		field.setPlaceholder("请填写网络");
		return field;
	}

	protected FormField idFromUserDomain(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("user_domain.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromUserDomain(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("user_domain.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField idFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("user_white_list.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField userIdentityFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("用户身份");
		field.setLocaleKey("user_white_list.user_identity");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写用户身份");
		return field;
	}

	protected FormField userSpecialFunctionsFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("用户特殊功能");
		field.setLocaleKey("user_white_list.user_special_functions");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写用户特殊功能");
		return field;
	}

	protected FormField domainIdFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("域");
		field.setLocaleKey("user_white_list.domain");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserDomain");
		field.setRequired(true);
		field.setPlaceholder("请填写域");
		return field;
	}

	protected FormField idFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("sec_user.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField loginFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("登录");
		field.setLocaleKey("sec_user.login");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写登录");
		return field;
	}

	protected FormField mobileFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("手机号码");
		field.setLocaleKey("sec_user.mobile");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写手机号码");
		return field;
	}

	protected FormField emailFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("电子邮件");
		field.setLocaleKey("sec_user.email");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写电子邮件");
		return field;
	}

	protected FormField pwdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("密码");
		field.setLocaleKey("sec_user.pwd");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("password");
		field.setRequired(true);
		field.setPlaceholder("请填写密码");
		return field;
	}

	protected FormField weixinOpenidFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("微信openid");
		field.setLocaleKey("sec_user.weixin_openid");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写微信openid");
		return field;
	}

	protected FormField weixinAppidFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("微信Appid");
		field.setLocaleKey("sec_user.weixin_appid");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写微信Appid");
		return field;
	}

	protected FormField accessTokenFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("访问令牌");
		field.setLocaleKey("sec_user.access_token");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写访问令牌");
		return field;
	}

	protected FormField verificationCodeFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("验证码");
		field.setLocaleKey("sec_user.verification_code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写验证码");
		return field;
	}

	protected FormField verificationCodeExpireFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("验证码过期");
		field.setLocaleKey("sec_user.verification_code_expire");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写验证码过期");
		return field;
	}

	protected FormField lastLoginTimeFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("最后登录时间");
		field.setLocaleKey("sec_user.last_login_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写最后登录时间");
		return field;
	}

	protected FormField domainIdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("域");
		field.setLocaleKey("sec_user.domain");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserDomain");
		field.setRequired(true);
		field.setPlaceholder("请填写域");
		return field;
	}

	protected FormField blockingIdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("屏蔽");
		field.setLocaleKey("sec_user.blocking");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUserBlocking");
		field.setRequired(true);
		field.setPlaceholder("请填写屏蔽");
		return field;
	}

	protected FormField currentStatusFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("当前状态");
		field.setLocaleKey("sec_user.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写当前状态");
		return field;
	}

	protected FormField idFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("sec_user_blocking.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField whoFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("sec_user_blocking.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField blockTimeFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("块时间");
		field.setLocaleKey("sec_user_blocking.block_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写块时间");
		return field;
	}

	protected FormField commentsFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("sec_user_blocking.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("user_app.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField titleFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("标题");
		field.setLocaleKey("user_app.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写标题");
		return field;
	}

	protected FormField secUserIdFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("安全用户");
		field.setLocaleKey("user_app.sec_user");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUser");
		field.setRequired(true);
		field.setPlaceholder("请填写安全用户");
		return field;
	}

	protected FormField appIconFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("应用程序图标");
		field.setLocaleKey("user_app.app_icon");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写应用程序图标");
		return field;
	}

	protected FormField fullAccessFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("完全访问");
		field.setLocaleKey("user_app.full_access");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写完全访问");
		return field;
	}

	protected FormField permissionFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("许可");
		field.setLocaleKey("user_app.permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写许可");
		return field;
	}

	protected FormField objectTypeFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("访问对象类型");
		field.setLocaleKey("user_app.object_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写访问对象类型");
		return field;
	}

	protected FormField objectIdFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("对象ID");
		field.setLocaleKey("user_app.object_id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写对象ID");
		return field;
	}

	protected FormField locationFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("位置");
		field.setLocaleKey("user_app.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写位置");
		return field;
	}

	protected FormField idFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("quick_link.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("quick_link.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField iconFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("图标");
		field.setLocaleKey("quick_link.icon");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写图标");
		return field;
	}

	protected FormField imagePathFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("图片路径");
		field.setLocaleKey("quick_link.image_path");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("image");
		field.setRequired(true);
		field.setPlaceholder("请填写图片路径");
		return field;
	}

	protected FormField linkTargetFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("链接的目标");
		field.setLocaleKey("quick_link.link_target");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写链接的目标");
		return field;
	}

	protected FormField createTimeFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("创建时间");
		field.setLocaleKey("quick_link.create_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写创建时间");
		return field;
	}

	protected FormField appIdFromQuickLink(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("应用程序");
		field.setLocaleKey("quick_link.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("请填写应用程序");
		return field;
	}

	protected FormField idFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("list_access.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("list_access.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField internalNameFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("内部名称");
		field.setLocaleKey("list_access.internal_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写内部名称");
		return field;
	}

	protected FormField readPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("读权限");
		field.setLocaleKey("list_access.read_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写读权限");
		return field;
	}

	protected FormField createPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("创建权限");
		field.setLocaleKey("list_access.create_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写创建权限");
		return field;
	}

	protected FormField deletePermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("删除权限");
		field.setLocaleKey("list_access.delete_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写删除权限");
		return field;
	}

	protected FormField updatePermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("更新权限");
		field.setLocaleKey("list_access.update_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写更新权限");
		return field;
	}

	protected FormField executionPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("执行权限");
		field.setLocaleKey("list_access.execution_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写执行权限");
		return field;
	}

	protected FormField appIdFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("应用程序");
		field.setLocaleKey("list_access.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("请填写应用程序");
		return field;
	}

	protected FormField idFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("object_access.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("object_access.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField objectTypeFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("访问对象类型");
		field.setLocaleKey("object_access.object_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写访问对象类型");
		return field;
	}

	protected FormField list1FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("列表1");
		field.setLocaleKey("object_access.list1");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写列表1");
		return field;
	}

	protected FormField list2FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("列表2");
		field.setLocaleKey("object_access.list2");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写列表2");
		return field;
	}

	protected FormField list3FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("列表3");
		field.setLocaleKey("object_access.list3");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写列表3");
		return field;
	}

	protected FormField list4FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("列表4");
		field.setLocaleKey("object_access.list4");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写列表4");
		return field;
	}

	protected FormField list5FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("列表5");
		field.setLocaleKey("object_access.list5");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写列表5");
		return field;
	}

	protected FormField list6FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("列表6");
		field.setLocaleKey("object_access.list6");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写列表6");
		return field;
	}

	protected FormField list7FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("列表7");
		field.setLocaleKey("object_access.list7");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写列表7");
		return field;
	}

	protected FormField list8FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("列表8");
		field.setLocaleKey("object_access.list8");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写列表8");
		return field;
	}

	protected FormField list9FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("列表9");
		field.setLocaleKey("object_access.list9");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写列表9");
		return field;
	}

	protected FormField appIdFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("应用程序");
		field.setLocaleKey("object_access.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("请填写应用程序");
		return field;
	}

	protected FormField idFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("login_history.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField loginTimeFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("登录时间");
		field.setLocaleKey("login_history.login_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写登录时间");
		return field;
	}

	protected FormField fromIpFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("来自IP");
		field.setLocaleKey("login_history.from_ip");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写来自IP");
		return field;
	}

	protected FormField descriptionFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("login_history.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField secUserIdFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("安全用户");
		field.setLocaleKey("login_history.sec_user");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUser");
		field.setRequired(true);
		field.setPlaceholder("请填写安全用户");
		return field;
	}

	protected FormField idFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("generic_form.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField titleFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("标题");
		field.setLocaleKey("generic_form.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写标题");
		return field;
	}

	protected FormField descriptionFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("generic_form.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField idFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("form_message.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField titleFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("标题");
		field.setLocaleKey("form_message.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写标题");
		return field;
	}

	protected FormField formIdFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("形式");
		field.setLocaleKey("form_message.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写形式");
		return field;
	}

	protected FormField levelFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("水平");
		field.setLocaleKey("form_message.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写水平");
		return field;
	}

	protected FormField idFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("form_field_message.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField titleFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("标题");
		field.setLocaleKey("form_field_message.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写标题");
		return field;
	}

	protected FormField parameterNameFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("参数名称");
		field.setLocaleKey("form_field_message.parameter_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写参数名称");
		return field;
	}

	protected FormField formIdFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("形式");
		field.setLocaleKey("form_field_message.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写形式");
		return field;
	}

	protected FormField levelFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("水平");
		field.setLocaleKey("form_field_message.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写水平");
		return field;
	}

	protected FormField idFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("form_field.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField labelFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("标签");
		field.setLocaleKey("form_field.label");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写标签");
		return field;
	}

	protected FormField localeKeyFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("语言环境的关键");
		field.setLocaleKey("form_field.locale_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写语言环境的关键");
		return field;
	}

	protected FormField parameterNameFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("参数名称");
		field.setLocaleKey("form_field.parameter_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写参数名称");
		return field;
	}

	protected FormField typeFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("类型");
		field.setLocaleKey("form_field.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写类型");
		return field;
	}

	protected FormField formIdFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("形式");
		field.setLocaleKey("form_field.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写形式");
		return field;
	}

	protected FormField placeholderFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("占位符");
		field.setLocaleKey("form_field.placeholder");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写占位符");
		return field;
	}

	protected FormField defaultValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("默认值");
		field.setLocaleKey("form_field.default_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写默认值");
		return field;
	}

	protected FormField descriptionFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("form_field.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField fieldGroupFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("字段组");
		field.setLocaleKey("form_field.field_group");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写字段组");
		return field;
	}

	protected FormField minimumValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("最小值");
		field.setLocaleKey("form_field.minimum_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写最小值");
		return field;
	}

	protected FormField maximumValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("最大值");
		field.setLocaleKey("form_field.maximum_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写最大值");
		return field;
	}

	protected FormField requiredFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("要求");
		field.setLocaleKey("form_field.required");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写要求");
		return field;
	}

	protected FormField disabledFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("禁用");
		field.setLocaleKey("form_field.disabled");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写禁用");
		return field;
	}

	protected FormField customRenderingFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("自定义渲染");
		field.setLocaleKey("form_field.custom_rendering");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写自定义渲染");
		return field;
	}

	protected FormField candidateValuesFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("候选人的价值观");
		field.setLocaleKey("form_field.candidate_values");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写候选人的价值观");
		return field;
	}

	protected FormField suggestValuesFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("建议值");
		field.setLocaleKey("form_field.suggest_values");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写建议值");
		return field;
	}

	protected FormField idFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("form_action.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField labelFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("标签");
		field.setLocaleKey("form_action.label");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写标签");
		return field;
	}

	protected FormField localeKeyFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("语言环境的关键");
		field.setLocaleKey("form_action.locale_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写语言环境的关键");
		return field;
	}

	protected FormField actionKeyFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("行动的关键");
		field.setLocaleKey("form_action.action_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写行动的关键");
		return field;
	}

	protected FormField levelFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("水平");
		field.setLocaleKey("form_action.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写水平");
		return field;
	}

	protected FormField urlFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("url");
		field.setLocaleKey("form_action.url");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写url");
		return field;
	}

	protected FormField formIdFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("形式");
		field.setLocaleKey("form_action.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写形式");
		return field;
	}

	protected FormField idFromCandidateContainer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("candidate_container.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromCandidateContainer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("candidate_container.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField idFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("ID");
		field.setLocaleKey("candidate_element.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写ID");
		return field;
	}

	protected FormField nameFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("candidate_element.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField typeFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("类型");
		field.setLocaleKey("candidate_element.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写类型");
		return field;
	}

	protected FormField imageFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("图片");
		field.setLocaleKey("candidate_element.image");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("image");
		field.setRequired(true);
		field.setPlaceholder("请填写图片");
		return field;
	}

	protected FormField containerIdFromCandidateElement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("容器");
		field.setLocaleKey("candidate_element.container");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("CandidateContainer");
		field.setRequired(true);
		field.setPlaceholder("请填写容器");
		return field;
	}

}









