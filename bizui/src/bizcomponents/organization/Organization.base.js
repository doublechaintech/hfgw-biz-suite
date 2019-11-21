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



const menuData = {menuName:"组织", menuFor: "organization",
  		subItems: [
  {name: 'nodeList', displayName:'节点', icon:'node',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"组织", menuFor: "organization",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  mspid: 'Mspid',
  network: '网络',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'organization') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '19',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mspid, debugtype: 'string', dataIndex: 'mspid', width: '19',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.network, dataIndex: 'network', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(organization,targetComponent)=>{

  const userContext = null
  return (
    <div key={organization.id}>
	
      <DescriptionList  key={organization.id} size="small" col="4">
        <Description term="ID">{organization.id}</Description> 
        <Description term="名称">{organization.name}</Description> 
        <Description term="Mspid">{organization.mspid}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, mspid, networkId} = formValuesToPack
	const network = {id: networkId, version: 2^31}
	const data = {name, mspid, network}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, mspid, network} = objectToUnpack
	const networkId = network ? network.id : null
	const data = {name, mspid, networkId}
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
const OrganizationBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default OrganizationBase



