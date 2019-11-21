import React from 'react'
import { Icon,Divider, Avatar} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderAvatarCell=defaultRenderAvatarCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell



const menuData = {menuName:"Hyperledger网络", menuFor: "hyperledgerNetwork",
  		subItems: [
  {name: 'organizationList', displayName:'组织', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'nodeList', displayName:'节点', icon:'node',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'channelList', displayName:'频道', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'applicationList', displayName:'应用程序', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'serviceRecordList', displayName:'服务记录', icon:'servicestack',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'changeRequestList', displayName:'变更请求', icon:'exchange-alt',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"Hyperledger网络", menuFor: "hyperledgerNetwork",
  		subItems: [
  {name: 'changeRequestTypeList', displayName:'变更请求类型', icon:'exchange-alt',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  description: '描述',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'hyperledgerNetwork') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '27',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string_longtext', dataIndex: 'description', width: '10',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(hyperledgerNetwork,targetComponent)=>{

  const userContext = null
  return (
    <div key={hyperledgerNetwork.id}>
	
      <DescriptionList  key={hyperledgerNetwork.id} size="small" col="4">
        <Description term="ID">{hyperledgerNetwork.id}</Description> 
        <Description term="名称">{hyperledgerNetwork.name}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, description} = formValuesToPack

	const data = {name, description}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, description} = objectToUnpack

	const data = {name, description}
	return data
}
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const HyperledgerNetworkBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default HyperledgerNetworkBase



