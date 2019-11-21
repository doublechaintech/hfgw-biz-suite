

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './HyperledgerNetwork.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (hyperledgerNetwork,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{hyperledgerNetwork.id}</Description> 
<Description term="名称">{hyperledgerNetwork.name}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = hyperledgerNetwork => {
  const {HyperledgerNetworkBase} = GlobalComponents
  return <PermissionSetting targetObject={hyperledgerNetwork}  targetObjectMeta={HyperledgerNetworkBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class HyperledgerNetworkPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  hyperledgerNetwork = this.props.hyperledgerNetwork
    const { id,displayName, organizationCount, nodeTypeCount, channelCount, applicationCount, serviceRecordCount, changeRequestTypeCount, changeRequestCount } = hyperledgerNetwork
    const  returnURL = `/hyperledgerNetwork/${id}/dashboard`
    const cardsData = {cardsName:"Hyperledger网络",cardsFor: "hyperledgerNetwork",cardsSource: hyperledgerNetwork,displayName,returnURL,
  		subItems: [
{name: 'nodeTypeList', displayName:'节点类型',type:'nodeType',count:nodeTypeCount,addFunction: false, role: 'nodeType', data: hyperledgerNetwork.nodeTypeList},
{name: 'changeRequestTypeList', displayName:'变更请求类型',type:'changeRequestType',count:changeRequestTypeCount,addFunction: false, role: 'changeRequestType', data: hyperledgerNetwork.changeRequestTypeList},
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  hyperledgerNetwork: state._hyperledgerNetwork,
}))(Form.create()(HyperledgerNetworkPermission))

