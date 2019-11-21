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



const menuData = {menuName:"节点", menuFor: "node",
  		subItems: [
  {name: 'grpcOptionList', displayName:'Grpc选项', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'tlsCacertList', displayName:'Tls Cacert', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"节点", menuFor: "node",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  url: 'url',
  organization: '组织',
  channel: '频道',
  type: '类型',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'node') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '18',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.url, debugtype: 'string', dataIndex: 'url', width: '46',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.organization, dataIndex: 'organization', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.channel, dataIndex: 'channel', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.type, dataIndex: 'type', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(node,targetComponent)=>{

  const userContext = null
  return (
    <div key={node.id}>
	
      <DescriptionList  key={node.id} size="small" col="4">
        <Description term="ID">{node.id}</Description> 
        <Description term="名称">{node.name}</Description> 
        <Description term="url">{node.url}</Description> 
        <Description term={fieldLabels.organization}><div>{node.organization==null?appLocaleName(userContext,"NotAssigned"):`${node.organization.displayName}(${node.organization.id})`}
        </div></Description>
        <Description term={fieldLabels.channel}><div>{node.channel==null?appLocaleName(userContext,"NotAssigned"):`${node.channel.displayName}(${node.channel.id})`}
        </div></Description>
        <Description term={fieldLabels.type}><div>{node.type==null?appLocaleName(userContext,"NotAssigned"):`${node.type.displayName}(${node.type.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, url, organizationId, channelId, typeId} = formValuesToPack
	const organization = {id: organizationId, version: 2^31}
	const channel = {id: channelId, version: 2^31}
	const type = {id: typeId, version: 2^31}
	const data = {name, url, organization, channel, type}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, url, organization, channel, type} = objectToUnpack
	const organizationId = organization ? organization.id : null
	const channelId = channel ? channel.id : null
	const typeId = type ? type.id : null
	const data = {name, url, organizationId, channelId, typeId}
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
const NodeBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default NodeBase



