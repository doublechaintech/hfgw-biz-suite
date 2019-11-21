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



const menuData = {menuName:"Tls Cacert", menuFor: "tlsCacert",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"Tls Cacert", menuFor: "tlsCacert",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  path: '路径',
  cert: 'Cert',
  node: '节点',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'tlsCacert') , sorter: true },
  { title: fieldLabels.path, debugtype: 'string', dataIndex: 'path', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.cert, debugtype: 'string_longtext', dataIndex: 'cert', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.node, dataIndex: 'node', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(tlsCacert,targetComponent)=>{

  const userContext = null
  return (
    <div key={tlsCacert.id}>
	
      <DescriptionList  key={tlsCacert.id} size="small" col="4">
        <Description term="ID">{tlsCacert.id}</Description> 
        <Description term="路径">{tlsCacert.path}</Description> 
        <Description term={fieldLabels.node}><div>{tlsCacert.node==null?appLocaleName(userContext,"NotAssigned"):`${tlsCacert.node.displayName}(${tlsCacert.node.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {path, nodeId, cert} = formValuesToPack
	const node = {id: nodeId, version: 2^31}
	const data = {path, node, cert}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {path, node, cert} = objectToUnpack
	const nodeId = node ? node.id : null
	const data = {path, nodeId, cert}
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
const TlsCacertBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default TlsCacertBase



