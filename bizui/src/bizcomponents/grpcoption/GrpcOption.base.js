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



const menuData = {menuName:"Grpc选项", menuFor: "grpcOption",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"Grpc选项", menuFor: "grpcOption",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  parameterName: '参数名称',
  parameterValue: '参数值',
  node: '节点',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'grpcOption') , sorter: true },
  { title: fieldLabels.parameterName, debugtype: 'string', dataIndex: 'parameterName', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.parameterValue, debugtype: 'string', dataIndex: 'parameterValue', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.node, dataIndex: 'node', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(grpcOption,targetComponent)=>{

  const userContext = null
  return (
    <div key={grpcOption.id}>
	
      <DescriptionList  key={grpcOption.id} size="small" col="4">
        <Description term="ID">{grpcOption.id}</Description> 
        <Description term="参数名称">{grpcOption.parameterName}</Description> 
        <Description term="参数值">{grpcOption.parameterValue}</Description> 
        <Description term={fieldLabels.node}><div>{grpcOption.node==null?appLocaleName(userContext,"NotAssigned"):`${grpcOption.node.displayName}(${grpcOption.node.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {parameterName, parameterValue, nodeId} = formValuesToPack
	const node = {id: nodeId, version: 2^31}
	const data = {parameterName, parameterValue, node}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {parameterName, parameterValue, node} = objectToUnpack
	const nodeId = node ? node.id : null
	const data = {parameterName, parameterValue, nodeId}
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
const GrpcOptionBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf}
export default GrpcOptionBase



