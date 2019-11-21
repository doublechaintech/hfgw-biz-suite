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



const menuData = {menuName:"变更请求类型", menuFor: "changeRequestType",
  		subItems: [
  {name: 'changeRequestList', displayName:'变更请求', icon:'exchange-alt',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"变更请求类型", menuFor: "changeRequestType",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  code: '代码',
  icon: '图标',
  displayOrder: '显示顺序',
  bindTypes: '绑定类型',
  stepConfiguration: '步配置',
  network: '网络',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'changeRequestType') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.icon, debugtype: 'string', dataIndex: 'icon', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.displayOrder, debugtype: 'int', dataIndex: 'displayOrder', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.bindTypes, debugtype: 'string_longtext', dataIndex: 'bindTypes', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.stepConfiguration, debugtype: 'string_longtext', dataIndex: 'stepConfiguration', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.network, dataIndex: 'network', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(changeRequestType,targetComponent)=>{

  const userContext = null
  return (
    <div key={changeRequestType.id}>
	
      <DescriptionList  key={changeRequestType.id} size="small" col="4">
        <Description term="ID">{changeRequestType.id}</Description> 
        <Description term="名称">{changeRequestType.name}</Description> 
        <Description term="代码">{changeRequestType.code}</Description> 
        <Description term="图标">{changeRequestType.icon}</Description> 
        <Description term="显示顺序"><div style={{"color":"red"}}>{changeRequestType.displayOrder}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, code, icon, displayOrder, networkId, bindTypes, stepConfiguration} = formValuesToPack
	const network = {id: networkId, version: 2^31}
	const data = {name, code, icon, displayOrder, network, bindTypes, stepConfiguration}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, code, icon, displayOrder, network, bindTypes, stepConfiguration} = objectToUnpack
	const networkId = network ? network.id : null
	const data = {name, code, icon, displayOrder, networkId, bindTypes, stepConfiguration}
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
const ChangeRequestTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default ChangeRequestTypeBase



