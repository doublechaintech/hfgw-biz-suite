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



const menuData = {menuName:"通道对等的角色", menuFor: "channelPeerRole",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"通道对等的角色", menuFor: "channelPeerRole",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  channel: '频道',
  node: '节点',
  peerRole: '对等的角色',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'channelPeerRole') , sorter: true },
  { title: fieldLabels.channel, dataIndex: 'channel', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.node, dataIndex: 'node', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.peerRole, dataIndex: 'peerRole', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(channelPeerRole,targetComponent)=>{

  const userContext = null
  return (
    <div key={channelPeerRole.id}>
	
      <DescriptionList  key={channelPeerRole.id} size="small" col="4">
        <Description term="ID">{channelPeerRole.id}</Description> 
        <Description term={fieldLabels.channel}><div>{channelPeerRole.channel==null?appLocaleName(userContext,"NotAssigned"):`${channelPeerRole.channel.displayName}(${channelPeerRole.channel.id})`}
        </div></Description>
        <Description term={fieldLabels.node}><div>{channelPeerRole.node==null?appLocaleName(userContext,"NotAssigned"):`${channelPeerRole.node.displayName}(${channelPeerRole.node.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {channelId, nodeId, peerRoleId} = formValuesToPack
	const channel = {id: channelId, version: 2^31}
	const node = {id: nodeId, version: 2^31}
	const peerRole = {id: peerRoleId, version: 2^31}
	const data = {channel, node, peerRole}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {channel, node, peerRole} = objectToUnpack
	const channelId = channel ? channel.id : null
	const nodeId = node ? node.id : null
	const peerRoleId = peerRole ? peerRole.id : null
	const data = {channelId, nodeId, peerRoleId}
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
const ChannelPeerRoleBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default ChannelPeerRoleBase



