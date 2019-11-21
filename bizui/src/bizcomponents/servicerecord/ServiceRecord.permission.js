

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './ServiceRecord.profile.less'
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
const internalSummaryOf = (serviceRecord,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{serviceRecord.id}</Description> 
<Description term="名称">{serviceRecord.name}</Description> 
<Description term="链码功能">{serviceRecord.chainCodeFunction}</Description> 
<Description term="事务Id">{serviceRecord.transactionId}</Description> 
<Description term="块Id">{serviceRecord.blockId}</Description> 
<Description term="创建时间">{ moment(serviceRecord.createTime).format('YYYY-MM-DD')}</Description> 
<Description term="当前状态">{serviceRecord.currentStatus}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = serviceRecord => {
  const {ServiceRecordBase} = GlobalComponents
  return <PermissionSetting targetObject={serviceRecord}  targetObjectMeta={ServiceRecordBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class ServiceRecordPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  serviceRecord = this.props.serviceRecord
    const { id,displayName,  } = serviceRecord
    const  returnURL = `/serviceRecord/${id}/dashboard`
    const cardsData = {cardsName:"服务记录",cardsFor: "serviceRecord",cardsSource: serviceRecord,displayName,returnURL,
  		subItems: [
    
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
  serviceRecord: state._serviceRecord,
}))(Form.create()(ServiceRecordPermission))

