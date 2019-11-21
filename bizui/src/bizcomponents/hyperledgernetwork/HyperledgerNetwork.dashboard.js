

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
import styles from './HyperledgerNetwork.dashboard.less'
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


const imageList =(hyperledgerNetwork)=>{return [
	 ]}

const internalImageListOf = (hyperledgerNetwork) =>defaultImageListOf(hyperledgerNetwork,imageList)

const optionList =(hyperledgerNetwork)=>{return [ 
	]}

const buildTransferModal = defaultBuildTransferModal
const showTransferModel = defaultShowTransferModel
const internalRenderSubjectList = defaultRenderSubjectList
const internalSettingListOf = (hyperledgerNetwork) =>defaultSettingListOf(hyperledgerNetwork, optionList)
const internalLargeTextOf = (hyperledgerNetwork) =>{

	return(<div> 
   <Card title={`描述`} ><pre>{hyperledgerNetwork.description}</pre></Card>
</div>)

	

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
      <Link to={`/hyperledgerNetwork/${targetComponent.props.hyperledgerNetwork.id}/list/${item.name}/${item.displayName}/`}>
        <span>{item.displayName}</span>
        </Link>
        </Menu.Item>
  )

}
const renderSettingMenu = (cardsData,targetComponent) =>{

  const userContext = null
  return (<Menu>
    	<Menu.Item key="profile">
  			<Link to={`/hyperledgerNetwork/${targetComponent.props.hyperledgerNetwork.id}/permission`}><Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a"/><span>{appLocaleName(userContext,"Permission")}</span></Link>
		</Menu.Item>
		<Menu.Divider />
		{cardsData.subSettingItems.map(item=>renderSettingMenuItem(item,cardsData,targetComponent))}
		</Menu>)

}

const internalRenderTitle = (cardsData,targetComponent) =>{
  
  
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName} {renderSettingDropDown(cardsData,targetComponent)}</div>)

}


const internalSummaryOf = (hyperledgerNetwork,targetComponent) =>{
	
	
	const {HyperledgerNetworkService} = GlobalComponents
	const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{hyperledgerNetwork.id}</Description> 
<Description term="名称">{hyperledgerNetwork.name}</Description> 
	
        {buildTransferModal(hyperledgerNetwork,targetComponent)}
      </DescriptionList>
	)

}

const internalQuickFunctions = defaultQuickFunctions

class HyperledgerNetworkDashboard extends Component {

 state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName:"",
    candidateObjectType:"city",
    targetLocalName:"",
    transferServiceName:"",
    currentValue:"",
    transferTargetParameterName:"",  
    defaultType: 'hyperledgerNetwork'


  }
  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const { id,displayName, organizationListMetaInfo, nodeListMetaInfo, channelListMetaInfo, applicationListMetaInfo, serviceRecordListMetaInfo, changeRequestTypeListMetaInfo, changeRequestListMetaInfo, organizationCount, nodeCount, channelCount, applicationCount, serviceRecordCount, changeRequestTypeCount, changeRequestCount } = this.props.hyperledgerNetwork
    if(!this.props.hyperledgerNetwork.class){
      return null
    }
    const returnURL = this.props.returnURL
    
    const cardsData = {cardsName:"Hyperledger网络",cardsFor: "hyperledgerNetwork",
    	cardsSource: this.props.hyperledgerNetwork,returnURL,displayName,
  		subItems: [
{name: 'organizationList', displayName:'组织',type:'organization',count:organizationCount,addFunction: true, role: 'organization', metaInfo: organizationListMetaInfo, renderItem: GlobalComponents.OrganizationBase.renderItemOfList},
{name: 'nodeList', displayName:'节点',type:'node',count:nodeCount,addFunction: true, role: 'node', metaInfo: nodeListMetaInfo, renderItem: GlobalComponents.NodeBase.renderItemOfList},
{name: 'channelList', displayName:'频道',type:'channel',count:channelCount,addFunction: true, role: 'channel', metaInfo: channelListMetaInfo, renderItem: GlobalComponents.ChannelBase.renderItemOfList},
{name: 'applicationList', displayName:'应用程序',type:'application',count:applicationCount,addFunction: true, role: 'application', metaInfo: applicationListMetaInfo, renderItem: GlobalComponents.ApplicationBase.renderItemOfList},
{name: 'serviceRecordList', displayName:'服务记录',type:'serviceRecord',count:serviceRecordCount,addFunction: true, role: 'serviceRecord', metaInfo: serviceRecordListMetaInfo, renderItem: GlobalComponents.ServiceRecordBase.renderItemOfList},
{name: 'changeRequestList', displayName:'变更请求',type:'changeRequest',count:changeRequestCount,addFunction: true, role: 'changeRequest', metaInfo: changeRequestListMetaInfo, renderItem: GlobalComponents.ChangeRequestBase.renderItemOfList},
    
      	],
   		subSettingItems: [
{name: 'changeRequestTypeList', displayName:'变更请求类型',type:'changeRequestType',count:changeRequestTypeCount,addFunction: false, role: 'changeRequestType', metaInfo: changeRequestTypeListMetaInfo, renderItem: GlobalComponents.ChangeRequestTypeBase.renderItemOfList},
    
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
  hyperledgerNetwork: state._hyperledgerNetwork,
  returnURL: state.breadcrumb.returnURL,
  
}))(Form.create()(HyperledgerNetworkDashboard))

