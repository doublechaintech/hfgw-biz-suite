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



const menuData = {menuName:"节点类型", menuFor: "nodeType",
  		subItems: [
  {name: 'nodeList', displayName:'节点', icon:'node',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"节点类型", menuFor: "nodeType",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  code: '代码',
  network: '网络',
  address: '地址',
  contactPerson: '联系人',
  contactTelephone: '联系电话',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'nodeType') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.network, dataIndex: 'network', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.address, debugtype: 'string', dataIndex: 'address', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactPerson, debugtype: 'string', dataIndex: 'contactPerson', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactTelephone, debugtype: 'string', dataIndex: 'contactTelephone', width: '15',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(nodeType,targetComponent)=>{

  const userContext = null
  return (
    <div key={nodeType.id}>
	
      <DescriptionList  key={nodeType.id} size="small" col="4">
        <Description term="ID">{nodeType.id}</Description> 
        <Description term="名称">{nodeType.name}</Description> 
        <Description term="代码">{nodeType.code}</Description> 
        <Description term="地址">{nodeType.address}</Description> 
        <Description term="联系人">{nodeType.contactPerson}</Description> 
        <Description term="联系电话">{nodeType.contactTelephone}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, code, address, contactPerson, contactTelephone, networkId} = formValuesToPack
	const network = {id: networkId, version: 2^31}
	const data = {name, code, address, contactPerson, contactTelephone, network}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, code, address, contactPerson, contactTelephone, network} = objectToUnpack
	const networkId = network ? network.id : null
	const data = {name, code, address, contactPerson, contactTelephone, networkId}
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
const NodeTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default NodeTypeBase



