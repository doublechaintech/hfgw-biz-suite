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



const menuData = {menuName:"应用程序", menuFor: "application",
  		subItems: [
  {name: 'serviceRecordList', displayName:'服务记录', icon:'servicestack',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"应用程序", menuFor: "application",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  createTime: '创建时间',
  mspid: 'Mspid',
  publicKey: '公钥',
  privateKey: '私钥',
  channel: '频道',
  network: '网络',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'application') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.createTime, dataIndex: 'createTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.mspid, debugtype: 'string', dataIndex: 'mspid', width: '19',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.publicKey, debugtype: 'string_longtext', dataIndex: 'publicKey', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.privateKey, debugtype: 'string_longtext', dataIndex: 'privateKey', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.channel, dataIndex: 'channel', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.network, dataIndex: 'network', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(application,targetComponent)=>{

  const userContext = null
  return (
    <div key={application.id}>
	
      <DescriptionList  key={application.id} size="small" col="4">
        <Description term="ID">{application.id}</Description> 
        <Description term="名称">{application.name}</Description> 
        <Description term="创建时间"><div>{ moment(application.createTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="Mspid">{application.mspid}</Description> 
        <Description term={fieldLabels.channel}><div>{application.channel==null?appLocaleName(userContext,"NotAssigned"):`${application.channel.displayName}(${application.channel.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, mspid, channelId, networkId, publicKey, privateKey} = formValuesToPack
	const channel = {id: channelId, version: 2^31}
	const network = {id: networkId, version: 2^31}
	const data = {name, mspid, channel, network, publicKey, privateKey}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, mspid, channel, network, publicKey, privateKey} = objectToUnpack
	const channelId = channel ? channel.id : null
	const networkId = network ? network.id : null
	const data = {name, mspid, channelId, networkId, publicKey, privateKey}
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
const ApplicationBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default ApplicationBase



