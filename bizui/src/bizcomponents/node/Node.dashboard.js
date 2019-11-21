

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Button, Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'
import {
  ChartCard, yuan, MiniArea, MiniBar, MiniProgress, Field, Bar, Pie, TimelineChart,
} from '../../components/Charts'
import Trend from '../../components/Trend'
import NumberInfo from '../../components/NumberInfo'
import { getTimeDistance } from '../../utils/utils'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Node.dashboard.less'
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool'
import appLocaleName from '../../common/Locale.tool'

const {aggregateDataset,calcKey, defaultHideCloseTrans,
  defaultImageListOf,defaultSettingListOf,defaultBuildTransferModal,
  defaultExecuteTrans,defaultHandleTransferSearch,defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,defaultRenderAnalytics,
  defaultRenderExtraFooter,renderForTimeLine,renderForNumbers,
  defaultQuickFunctions, defaultRenderSubjectList,
}= DashboardTool



const { Description } = DescriptionList;
const { TabPane } = Tabs
const { RangePicker } = DatePicker
const { Option } = Select


const imageList =(node)=>{return [
	 ]}

const internalImageListOf = (node) =>defaultImageListOf(node,imageList)

const optionList =(node)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (node) =>defaultSettingListOf(node, optionList)
const internalLargeTextOf = (node) =>{

	return null
	

}


const internalRenderExtraHeader = defaultRenderExtraHeader

const internalRenderExtraFooter = defaultRenderExtraFooter
const internalSubListsOf = defaultSubListsOf


const renderSettingDropDown = (cardsData,targetComponent)=>{

  return (<div style={{float: 'right'}} >
        <Dropdown overlay={renderSettingMenu(cardsData,targetComponent)} placement="bottomRight" >
       
        <Button>
        <Icon type="setting" theme="filled" twoToneColor="#00b" style={{color:'#3333b0'}}/> 设置  <Icon type="down"/>
      </Button>
      </Dropdown></div>)

}

const renderSettingMenuItem = (item,cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu.Item key={item.name}>
      <Link to={`/node/${targetComponent.props.node.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/node/${targetComponent.props.node.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (node,targetComponent) =>{
	
	
	const {NodeService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{node.id}</Description> 
<Description term="名称">{node.name}</Description> 
<Description term="url">{node.url}</Description> 
<Description term="组织">{node.organization==null?appLocaleName(userContext,"NotAssigned"):`${node.organization.displayName}(${node.organization.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"组织","organization",NodeService.requestCandidateOrganization,
	      NodeService.transferToAnotherOrganization,"anotherOrganizationId",node.organization?node.organization.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="频道">{node.channel==null?appLocaleName(userContext,"NotAssigned"):`${node.channel.displayName}(${node.channel.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"频道","channel",NodeService.requestCandidateChannel,
	      NodeService.transferToAnotherChannel,"anotherChannelId",node.channel?node.channel.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="类型">{node.type==null?appLocaleName(userContext,"NotAssigned"):`${node.type.displayName}(${node.type.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"类型","nodeType",NodeService.requestCandidateType,
	      NodeService.transferToAnotherType,"anotherTypeId",node.type?node.type.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
	
        {buildTransferModal(node,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class NodeDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'node'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, grpcOptionListMetaInfo, tlsCacertListMetaInfo, grpcOptionCount, tlsCacertCount } = this.props.node
    if(!this.props.node.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"节点",cardsFor: "node",
    	cardsSource: this.props.node,returnURL,displayName,
  		subItems: [
{name: 'grpcOptionList', displayName:'Grpc选项',type:'grpcOption',count:grpcOptionCount,addFunction: true, role: 'grpcOption', metaInfo: grpcOptionListMetaInfo, renderItem: GlobalComponents.GrpcOptionBase.renderItemOfList},
{name: 'tlsCacertList', displayName:'Tls Cacert',type:'tlsCacert',count:tlsCacertCount,addFunction: true, role: 'tlsCacert', metaInfo: tlsCacertListMetaInfo, renderItem: GlobalComponents.TlsCacertBase.renderItemOfList},
    
      	],
   		subSettingItems: [
    
      	],     	
      	
  	};
    
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const settingListOf = this.props.settingListOf || internalSettingListOf
    const imageListOf = this.props.imageListOf || internalImageListOf
    const subListsOf = this.props.subListsOf || internalSubListsOf
    const largeTextOf = this.props.largeTextOf ||internalLargeTextOf
    const summaryOf = this.props.summaryOf || internalSummaryOf
    const renderTitle = this.props.renderTitle || internalRenderTitle
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter
    const renderAnalytics = this.props.renderAnalytics || defaultRenderAnalytics
    const quickFunctions = this.props.quickFunctions || internalQuickFunctions
    const renderSubjectList = this.props.renderSubjectList || internalRenderSubjectList
    
    return (

      <PageHeaderLayout
        title={renderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
       
        {renderExtraHeader(cardsData.cardsSource)}
        {imageListOf(cardsData.cardsSource)}  
        {quickFunctions(cardsData)} 
        {renderAnalytics(cardsData.cardsSource)}
        {settingListOf(cardsData.cardsSource)}
        {renderSubjectList(cardsData)}       
        {largeTextOf(cardsData.cardsSource)}
        {renderExtraFooter(cardsData.cardsSource)}
  		
      </PageHeaderLayout>
    
    )
  }
}

export default connect(state => ({
  node: state._node,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(NodeDashboard))

