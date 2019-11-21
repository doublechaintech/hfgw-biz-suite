import React from 'react'
import PropTypes from 'prop-types'
import {
  Layout,
  Menu,
  Icon,
  Avatar,
  Dropdown,
  Tag,
  message,
  Spin,
  Breadcrumb,
  AutoComplete,Row, Col,
  Input,Button
} from 'antd'
import TopMenu from '../../launcher/TopMenu'
import DocumentTitle from 'react-document-title'
import { connect } from 'dva'
import { Link, Route, Redirect, Switch } from 'dva/router'
import moment from 'moment'
import groupBy from 'lodash/groupBy'
import { ContainerQuery } from 'react-container-query'
import classNames from 'classnames'
import styles from './Channel.app.less'
import {sessionObject} from '../../utils/utils'

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';


import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service'
import appLocaleName from '../../common/Locale.tool'
import BizAppTool from '../../common/BizApp.tool'

const { Header, Sider, Content } = Layout
const { SubMenu } = Menu
const {
  defaultFilteredNoGroupMenuItems,
  defaultFilteredMenuItemsGroup,
  defaultRenderMenuItem,

} = BizAppTool


const filteredNoGroupMenuItems = defaultFilteredNoGroupMenuItems
const filteredMenuItemsGroup = defaultFilteredMenuItemsGroup
const renderMenuItem=defaultRenderMenuItem



const userBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 6,
  xl: 6,
  
};


const searchBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 12,
  xl: 12,
  
};


const naviBarResponsiveStyle = {
  xs: 8,
  sm: 8,
  md: 8,
  lg: 6,
  xl: 6,
  
};


const query = {
  'screen-xs': {
    maxWidth: 575,
  },
  'screen-sm': {
    minWidth: 576,
    maxWidth: 767,
  },
  'screen-md': {
    minWidth: 768,
    maxWidth: 991,
  },
  'screen-lg': {
    minWidth: 992,
    maxWidth: 1199,
  },
  'screen-xl': {
    minWidth: 1200,
  },
}




class ChannelBizApp extends React.PureComponent {
  constructor(props) {
    super(props)
     this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    }
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout)
  }
  onCollapse = (collapsed) => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    })
  }

  getDefaultCollapsedSubMenus = (props) => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)]
    currentMenuSelectedKeys.splice(-1, 1)
    if (currentMenuSelectedKeys.length === 0) {
      return ['/channel/']
    }
    return currentMenuSelectedKeys
  }
  getCurrentMenuSelectedKeys = (props) => {
    const { location: { pathname } } = props || this.props
    const keys = pathname.split('/').slice(1)
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key]
    }
    return keys
  }
  
  getNavMenuItems = (targetObject) => {
  

    const menuData = sessionObject('menuData')
    const targetApp = sessionObject('targetApp')
	const {objectId}=targetApp;
  	const userContext = null
    return (
	  <Menu
        theme="dark"
        mode="inline"
        
        onOpenChange={this.handleOpenChange}
        defaultOpenKeys={['firstOne']}
        style={{ width: '256px' }}
       >
           

             <Menu.Item key="dashboard">
               <Link to={`/channel/${this.props.channel.id}/dashboard`}><Icon type="dashboard" style={{marginRight:"20px"}}/><span>{appLocaleName(userContext,"Dashboard")}</span></Link>
             </Menu.Item>
           
        {filteredNoGroupMenuItems(targetObject,this).map((item)=>(renderMenuItem(item)))}  
        {filteredMenuItemsGroup(targetObject,this).map((groupedMenuItem,index)=>{
          return(
    <SubMenu key={`vg${index}`} title={<span><Icon type="folder" style={{marginRight:"20px"}} /><span>{`${groupedMenuItem.viewGroup}`}</span></span>} >
      {groupedMenuItem.subItems.map((item)=>(renderMenuItem(item)))}  
    </SubMenu>

        )}
        )}

       		
        
           </Menu>
    )
  }
  



  getNodeSearch = () => {
    const {NodeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "节点",
      role: "node",
      data: state._channel.nodeList,
      metaInfo: state._channel.nodeListMetaInfo,
      count: state._channel.nodeCount,
      returnURL: `/channel/${state._channel.id}/dashboard`,
      currentPage: state._channel.nodeCurrentPageNumber,
      searchFormParameters: state._channel.nodeSearchFormParameters,
      searchParameters: {...state._channel.searchParameters},
      expandForm: state._channel.expandForm,
      loading: state._channel.loading,
      partialList: state._channel.partialList,
      owner: { type: '_channel', id: state._channel.id, 
      referenceName: 'channel', 
      listName: 'nodeList', ref:state._channel, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(NodeSearch)
  }
  getNodeCreateForm = () => {
   	const {NodeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "node",
      data: state._channel.nodeList,
      metaInfo: state._channel.nodeListMetaInfo,
      count: state._channel.nodeCount,
      returnURL: `/channel/${state._channel.id}/list`,
      currentPage: state._channel.nodeCurrentPageNumber,
      searchFormParameters: state._channel.nodeSearchFormParameters,
      loading: state._channel.loading,
      owner: { type: '_channel', id: state._channel.id, referenceName: 'channel', listName: 'nodeList', ref:state._channel, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(NodeCreateForm)
  }
  
  getNodeUpdateForm = () => {
    const userContext = null
  	const {NodeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._channel.selectedRows,
      role: "node",
      currentUpdateIndex: state._channel.currentUpdateIndex,
      owner: { type: '_channel', id: state._channel.id, listName: 'nodeList', ref:state._channel, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(NodeUpdateForm)
  }

  getChannelPeerRoleSearch = () => {
    const {ChannelPeerRoleSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "通道对等的角色",
      role: "channelPeerRole",
      data: state._channel.channelPeerRoleList,
      metaInfo: state._channel.channelPeerRoleListMetaInfo,
      count: state._channel.channelPeerRoleCount,
      returnURL: `/channel/${state._channel.id}/dashboard`,
      currentPage: state._channel.channelPeerRoleCurrentPageNumber,
      searchFormParameters: state._channel.channelPeerRoleSearchFormParameters,
      searchParameters: {...state._channel.searchParameters},
      expandForm: state._channel.expandForm,
      loading: state._channel.loading,
      partialList: state._channel.partialList,
      owner: { type: '_channel', id: state._channel.id, 
      referenceName: 'channel', 
      listName: 'channelPeerRoleList', ref:state._channel, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChannelPeerRoleSearch)
  }
  getChannelPeerRoleCreateForm = () => {
   	const {ChannelPeerRoleCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "channelPeerRole",
      data: state._channel.channelPeerRoleList,
      metaInfo: state._channel.channelPeerRoleListMetaInfo,
      count: state._channel.channelPeerRoleCount,
      returnURL: `/channel/${state._channel.id}/list`,
      currentPage: state._channel.channelPeerRoleCurrentPageNumber,
      searchFormParameters: state._channel.channelPeerRoleSearchFormParameters,
      loading: state._channel.loading,
      owner: { type: '_channel', id: state._channel.id, referenceName: 'channel', listName: 'channelPeerRoleList', ref:state._channel, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ChannelPeerRoleCreateForm)
  }
  
  getChannelPeerRoleUpdateForm = () => {
    const userContext = null
  	const {ChannelPeerRoleUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._channel.selectedRows,
      role: "channelPeerRole",
      currentUpdateIndex: state._channel.currentUpdateIndex,
      owner: { type: '_channel', id: state._channel.id, listName: 'channelPeerRoleList', ref:state._channel, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChannelPeerRoleUpdateForm)
  }

  getChainCodeSearch = () => {
    const {ChainCodeSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "链码",
      role: "chainCode",
      data: state._channel.chainCodeList,
      metaInfo: state._channel.chainCodeListMetaInfo,
      count: state._channel.chainCodeCount,
      returnURL: `/channel/${state._channel.id}/dashboard`,
      currentPage: state._channel.chainCodeCurrentPageNumber,
      searchFormParameters: state._channel.chainCodeSearchFormParameters,
      searchParameters: {...state._channel.searchParameters},
      expandForm: state._channel.expandForm,
      loading: state._channel.loading,
      partialList: state._channel.partialList,
      owner: { type: '_channel', id: state._channel.id, 
      referenceName: 'channel', 
      listName: 'chainCodeList', ref:state._channel, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChainCodeSearch)
  }
  getChainCodeCreateForm = () => {
   	const {ChainCodeCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "chainCode",
      data: state._channel.chainCodeList,
      metaInfo: state._channel.chainCodeListMetaInfo,
      count: state._channel.chainCodeCount,
      returnURL: `/channel/${state._channel.id}/list`,
      currentPage: state._channel.chainCodeCurrentPageNumber,
      searchFormParameters: state._channel.chainCodeSearchFormParameters,
      loading: state._channel.loading,
      owner: { type: '_channel', id: state._channel.id, referenceName: 'channel', listName: 'chainCodeList', ref:state._channel, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ChainCodeCreateForm)
  }
  
  getChainCodeUpdateForm = () => {
    const userContext = null
  	const {ChainCodeUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._channel.selectedRows,
      role: "chainCode",
      currentUpdateIndex: state._channel.currentUpdateIndex,
      owner: { type: '_channel', id: state._channel.id, listName: 'chainCodeList', ref:state._channel, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ChainCodeUpdateForm)
  }

  getApplicationSearch = () => {
    const {ApplicationSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "应用程序",
      role: "application",
      data: state._channel.applicationList,
      metaInfo: state._channel.applicationListMetaInfo,
      count: state._channel.applicationCount,
      returnURL: `/channel/${state._channel.id}/dashboard`,
      currentPage: state._channel.applicationCurrentPageNumber,
      searchFormParameters: state._channel.applicationSearchFormParameters,
      searchParameters: {...state._channel.searchParameters},
      expandForm: state._channel.expandForm,
      loading: state._channel.loading,
      partialList: state._channel.partialList,
      owner: { type: '_channel', id: state._channel.id, 
      referenceName: 'channel', 
      listName: 'applicationList', ref:state._channel, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ApplicationSearch)
  }
  getApplicationCreateForm = () => {
   	const {ApplicationCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "application",
      data: state._channel.applicationList,
      metaInfo: state._channel.applicationListMetaInfo,
      count: state._channel.applicationCount,
      returnURL: `/channel/${state._channel.id}/list`,
      currentPage: state._channel.applicationCurrentPageNumber,
      searchFormParameters: state._channel.applicationSearchFormParameters,
      loading: state._channel.loading,
      owner: { type: '_channel', id: state._channel.id, referenceName: 'channel', listName: 'applicationList', ref:state._channel, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ApplicationCreateForm)
  }
  
  getApplicationUpdateForm = () => {
    const userContext = null
  	const {ApplicationUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._channel.selectedRows,
      role: "application",
      currentUpdateIndex: state._channel.currentUpdateIndex,
      owner: { type: '_channel', id: state._channel.id, listName: 'applicationList', ref:state._channel, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ApplicationUpdateForm)
  }

  getServiceRecordSearch = () => {
    const {ServiceRecordSearch} = GlobalComponents;
    const userContext = null
    return connect(state => ({
      rule: state.rule,
      name: "服务记录",
      role: "serviceRecord",
      data: state._channel.serviceRecordList,
      metaInfo: state._channel.serviceRecordListMetaInfo,
      count: state._channel.serviceRecordCount,
      returnURL: `/channel/${state._channel.id}/dashboard`,
      currentPage: state._channel.serviceRecordCurrentPageNumber,
      searchFormParameters: state._channel.serviceRecordSearchFormParameters,
      searchParameters: {...state._channel.searchParameters},
      expandForm: state._channel.expandForm,
      loading: state._channel.loading,
      partialList: state._channel.partialList,
      owner: { type: '_channel', id: state._channel.id, 
      referenceName: 'channel', 
      listName: 'serviceRecordList', ref:state._channel, 
      listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ServiceRecordSearch)
  }
  getServiceRecordCreateForm = () => {
   	const {ServiceRecordCreateForm} = GlobalComponents;
   	const userContext = null
    return connect(state => ({
      rule: state.rule,
      role: "serviceRecord",
      data: state._channel.serviceRecordList,
      metaInfo: state._channel.serviceRecordListMetaInfo,
      count: state._channel.serviceRecordCount,
      returnURL: `/channel/${state._channel.id}/list`,
      currentPage: state._channel.serviceRecordCurrentPageNumber,
      searchFormParameters: state._channel.serviceRecordSearchFormParameters,
      loading: state._channel.loading,
      owner: { type: '_channel', id: state._channel.id, referenceName: 'channel', listName: 'serviceRecordList', ref:state._channel, listDisplayName: appLocaleName(userContext,"List")}, // this is for model namespace and
    }))(ServiceRecordCreateForm)
  }
  
  getServiceRecordUpdateForm = () => {
    const userContext = null
  	const {ServiceRecordUpdateForm} = GlobalComponents;
    return connect(state => ({
      selectedRows: state._channel.selectedRows,
      role: "serviceRecord",
      currentUpdateIndex: state._channel.currentUpdateIndex,
      owner: { type: '_channel', id: state._channel.id, listName: 'serviceRecordList', ref:state._channel, listDisplayName: appLocaleName(userContext,"List") }, // this is for model namespace and
    }))(ServiceRecordUpdateForm)
  }


  

 

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = 'Hyperledger Fabric 应用网关'
    return title
  }
 
  buildRouters = () =>{
  	const {ChannelDashboard} = GlobalComponents
  	const {ChannelPermission} = GlobalComponents
  	const {ChannelProfile} = GlobalComponents
  	
  	
  	const routers=[
  	{path:"/channel/:id/dashboard", component: ChannelDashboard},
  	{path:"/channel/:id/profile", component: ChannelProfile},
  	{path:"/channel/:id/permission", component: ChannelPermission},
  	
  	
  	
  	{path:"/channel/:id/list/nodeList", component: this.getNodeSearch()},
  	{path:"/channel/:id/list/nodeCreateForm", component: this.getNodeCreateForm()},
  	{path:"/channel/:id/list/nodeUpdateForm", component: this.getNodeUpdateForm()},
   	
  	{path:"/channel/:id/list/channelPeerRoleList", component: this.getChannelPeerRoleSearch()},
  	{path:"/channel/:id/list/channelPeerRoleCreateForm", component: this.getChannelPeerRoleCreateForm()},
  	{path:"/channel/:id/list/channelPeerRoleUpdateForm", component: this.getChannelPeerRoleUpdateForm()},
   	
  	{path:"/channel/:id/list/chainCodeList", component: this.getChainCodeSearch()},
  	{path:"/channel/:id/list/chainCodeCreateForm", component: this.getChainCodeCreateForm()},
  	{path:"/channel/:id/list/chainCodeUpdateForm", component: this.getChainCodeUpdateForm()},
   	
  	{path:"/channel/:id/list/applicationList", component: this.getApplicationSearch()},
  	{path:"/channel/:id/list/applicationCreateForm", component: this.getApplicationCreateForm()},
  	{path:"/channel/:id/list/applicationUpdateForm", component: this.getApplicationUpdateForm()},
   	
  	{path:"/channel/:id/list/serviceRecordList", component: this.getServiceRecordSearch()},
  	{path:"/channel/:id/list/serviceRecordCreateForm", component: this.getServiceRecordCreateForm()},
  	{path:"/channel/:id/list/serviceRecordUpdateForm", component: this.getServiceRecordUpdateForm()},
   	{path:"/channel/:id/ChangeRequestType/:code", component: GlobalComponents.ChangeRequestStepForm},
    	
 	 
  	]
  	
  	const {extraRoutesFunc} = this.props;
  	const extraRoutes = extraRoutesFunc?extraRoutesFunc():[]
  	const finalRoutes = routers.concat(extraRoutes)
    
  	return (<Switch>
             {finalRoutes.map((item)=>(<Route key={item.path} path={item.path} component={item.component} />))}    
  	  	</Switch>)
  	
  
  }
 
 
  handleOpenChange = (openKeys) => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1)
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    })
  }
   toggle = () => {
     const { collapsed } = this.props
     this.props.dispatch({
       type: 'global/changeLayoutCollapsed',
       payload: !collapsed,
     })
   }
    logout = () => {
   
    console.log("log out called")
    this.props.dispatch({ type: 'launcher/signOut' })
  }
   render() {
     // const { collapsed, fetchingNotices,loading } = this.props
     const { collapsed } = this.props
     
  
     const targetApp = sessionObject('targetApp')
     const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
     const userContext = null
     const renderBreadcrumbText=(value)=>{
     	if(value==null){
     		return "..."
     	}
     	if(value.length < 10){
     		return value
     	}
     
     	return value.substring(0,10)+"..."
     	
     	
     }
     const menuProps = collapsed ? {} : {
       openKeys: this.state.openKeys,
     }
     const renderBreadcrumbMenuItem=(breadcrumbMenuItem)=>{

      return (
      <Menu.Item key={breadcrumbMenuItem.link}>
      <Link key={breadcrumbMenuItem.link} to={`${breadcrumbMenuItem.link}`} className={styles.breadcrumbLink}>
        <Icon type="heart" style={{marginRight:"10px",color:"red"}} />
        {renderBreadcrumbText(breadcrumbMenuItem.name)}
      </Link></Menu.Item>)

     }
     const breadcrumbMenu=()=>{
      const currentBreadcrumb =targetApp?sessionObject(targetApp.id):[];
      return ( <Menu mode="vertical"> 
      {currentBreadcrumb.map(item => renderBreadcrumbMenuItem(item))}
      </Menu>)
  

     }
     const { Search } = Input;
     const layout = (
     <Layout>
 <Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
          
        <Row type="flex" justify="start" align="bottom">
        
        <Col {...naviBarResponsiveStyle} >
            <Dropdown overlay= {this.getNavMenuItems(this.props.channel)}>
              <a  className={styles.menuLink}>
                <Icon type="unordered-list" style={{fontSize:"20px", marginRight:"10px"}}/> 菜单
              </a>
            </Dropdown>            
            <Dropdown overlay={breadcrumbMenu()}>
              <a  className={styles.menuLink}>
                <Icon type="down" style={{fontSize:"20px", marginRight:"10px"}}/> 快速转到
              </a>
            </Dropdown>
        </Col>
        <Col  className={styles.searchBox} {...searchBarResponsiveStyle}  > 
          
          <Search size="default" placeholder="请输入搜索条件, 查找功能，数据和词汇解释" enterButton 
            style={{ marginLeft:"10px",marginTop:"7px",width:"100%"}} />
          </Col>
          <Col  {...userBarResponsiveStyle}  > 
            <Dropdown overlay= { <TopMenu {...this.props} />} className={styles.right}>
                <a  className={styles.menuLink}>
                  <Icon type="user" style={{fontSize:"20px",marginRight:"10px"}}/> 账户
                </a>
            </Dropdown>
            
           </Col>  
         
         </Row>
        </Header>
       <Layout style={{  marginTop: 44 }}>
       
         
         <Layout>
         
            
           <Content style={{ margin: '24px 24px 0', height: '100%' }}>
           
           {this.buildRouters()}
 
             
             
           </Content>
          </Layout>
        </Layout>
      </Layout>
     )
     return (
       <DocumentTitle title={this.getPageTitle()}>
         <ContainerQuery query={query}>
           {params => <div className={classNames(params)}>{layout}</div>}
         </ContainerQuery>
       </DocumentTitle>
     )
   }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  channel: state._channel,
  ...state,
}))(ChannelBizApp)



