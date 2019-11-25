import React from 'react';
import PropTypes from 'prop-types';
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
  AutoComplete,
  Row,
  Col,
  Input,
  Button,
} from 'antd';
import TopMenu from '../../launcher/TopMenu';
import DocumentTitle from 'react-document-title';
import { connect } from 'dva';
import { Link, Route, Redirect, Switch } from 'dva/router';
import moment from 'moment';
import groupBy from 'lodash/groupBy';
import { ContainerQuery } from 'react-container-query';
import classNames from 'classnames';
import styles from './HyperledgerNetwork.app.less';
import { sessionObject } from '../../utils/utils';

import HeaderSearch from '../../components/HeaderSearch';
import NoticeIcon from '../../components/NoticeIcon';
import GlobalFooter from '../../components/GlobalFooter';

import GlobalComponents from '../../custcomponents';

import PermissionSettingService from '../../permission/PermissionSetting.service';
import appLocaleName from '../../common/Locale.tool';
import BizAppTool from '../../common/BizApp.tool';

const { Header, Sider, Content } = Layout;
const { SubMenu } = Menu;
const {
  defaultFilteredNoGroupMenuItems,
  defaultFilteredMenuItemsGroup,
  defaultRenderMenuItem,
} = BizAppTool;

const filteredNoGroupMenuItems = defaultFilteredNoGroupMenuItems;
const filteredMenuItemsGroup = defaultFilteredMenuItemsGroup;
const renderMenuItem = defaultRenderMenuItem;

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
};

class HyperledgerNetworkBizApp extends React.PureComponent {
  constructor(props) {
    super(props);
    this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
    };
  }

  componentDidMount() {}
  componentWillUnmount() {
    clearTimeout(this.resizeTimeout);
  }
  onCollapse = collapsed => {
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: collapsed,
    });
  };

  getDefaultCollapsedSubMenus = props => {
    const currentMenuSelectedKeys = [...this.getCurrentMenuSelectedKeys(props)];
    currentMenuSelectedKeys.splice(-1, 1);
    if (currentMenuSelectedKeys.length === 0) {
      return ['/hyperledgerNetwork/'];
    }
    return currentMenuSelectedKeys;
  };
  getCurrentMenuSelectedKeys = props => {
    const {
      location: { pathname },
    } =
      props || this.props;
    const keys = pathname.split('/').slice(1);
    if (keys.length === 1 && keys[0] === '') {
      return [this.menus[0].key];
    }
    return keys;
  };

  getNavMenuItems = targetObject => {
    const menuData = sessionObject('menuData');
    const targetApp = sessionObject('targetApp');
    const { objectId } = targetApp;
    const userContext = null;
    return (
      <Menu
        theme="dark"
        mode="inline"
        onOpenChange={this.handleOpenChange}
        defaultOpenKeys={['firstOne']}
        style={{ width: '256px' }}
      >
        <Menu.Item key="dashboard">
          <Link to={`/hyperledgerNetwork/${this.props.hyperledgerNetwork.id}/dashboard`}>
            <Icon type="dashboard" style={{ marginRight: '20px' }} />
            <span>{appLocaleName(userContext, 'Dashboard')}</span>
          </Link>
        </Menu.Item>

        {filteredNoGroupMenuItems(targetObject, this).map(item => renderMenuItem(item))}
        {filteredMenuItemsGroup(targetObject, this).map((groupedMenuItem, index) => {
          return (
            <SubMenu
              key={`vg${index}`}
              title={
                <span>
                  <Icon type="folder" style={{ marginRight: '20px' }} />
                  <span>{`${groupedMenuItem.viewGroup}`}</span>
                </span>
              }
            >
              {groupedMenuItem.subItems.map(item => renderMenuItem(item))}
            </SubMenu>
          );
        })}
      </Menu>
    );
  };

  getOrganizationSearch = () => {
    const { OrganizationSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      name: '组织',
      role: 'organization',
      data: state._hyperledgerNetwork.organizationList,
      metaInfo: state._hyperledgerNetwork.organizationListMetaInfo,
      count: state._hyperledgerNetwork.organizationCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/dashboard`,
      currentPage: state._hyperledgerNetwork.organizationCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.organizationSearchFormParameters,
      searchParameters: { ...state._hyperledgerNetwork.searchParameters },
      expandForm: state._hyperledgerNetwork.expandForm,
      loading: state._hyperledgerNetwork.loading,
      partialList: state._hyperledgerNetwork.partialList,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'organizationList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(OrganizationSearch);
  };
  getOrganizationCreateForm = () => {
    const { OrganizationCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'organization',
      data: state._hyperledgerNetwork.organizationList,
      metaInfo: state._hyperledgerNetwork.organizationListMetaInfo,
      count: state._hyperledgerNetwork.organizationCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/list`,
      currentPage: state._hyperledgerNetwork.organizationCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.organizationSearchFormParameters,
      loading: state._hyperledgerNetwork.loading,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'organizationList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(OrganizationCreateForm);
  };

  getOrganizationUpdateForm = () => {
    const userContext = null;
    const { OrganizationUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hyperledgerNetwork.selectedRows,
      role: 'organization',
      currentUpdateIndex: state._hyperledgerNetwork.currentUpdateIndex,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        listName: 'organizationList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(OrganizationUpdateForm);
  };

  getNodeTypeSearch = () => {
    const { NodeTypeSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      name: '节点类型',
      role: 'nodeType',
      data: state._hyperledgerNetwork.nodeTypeList,
      metaInfo: state._hyperledgerNetwork.nodeTypeListMetaInfo,
      count: state._hyperledgerNetwork.nodeTypeCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/dashboard`,
      currentPage: state._hyperledgerNetwork.nodeTypeCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.nodeTypeSearchFormParameters,
      searchParameters: { ...state._hyperledgerNetwork.searchParameters },
      expandForm: state._hyperledgerNetwork.expandForm,
      loading: state._hyperledgerNetwork.loading,
      partialList: state._hyperledgerNetwork.partialList,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'nodeTypeList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(NodeTypeSearch);
  };
  getNodeTypeCreateForm = () => {
    const { NodeTypeCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'nodeType',
      data: state._hyperledgerNetwork.nodeTypeList,
      metaInfo: state._hyperledgerNetwork.nodeTypeListMetaInfo,
      count: state._hyperledgerNetwork.nodeTypeCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/list`,
      currentPage: state._hyperledgerNetwork.nodeTypeCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.nodeTypeSearchFormParameters,
      loading: state._hyperledgerNetwork.loading,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'nodeTypeList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(NodeTypeCreateForm);
  };

  getNodeTypeUpdateForm = () => {
    const userContext = null;
    const { NodeTypeUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hyperledgerNetwork.selectedRows,
      role: 'nodeType',
      currentUpdateIndex: state._hyperledgerNetwork.currentUpdateIndex,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        listName: 'nodeTypeList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(NodeTypeUpdateForm);
  };

  getNodeSearch = () => {
    const { NodeSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      name: '节点',
      role: 'node',
      data: state._hyperledgerNetwork.nodeList,
      metaInfo: state._hyperledgerNetwork.nodeListMetaInfo,
      count: state._hyperledgerNetwork.nodeCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/dashboard`,
      currentPage: state._hyperledgerNetwork.nodeCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.nodeSearchFormParameters,
      searchParameters: { ...state._hyperledgerNetwork.searchParameters },
      expandForm: state._hyperledgerNetwork.expandForm,
      loading: state._hyperledgerNetwork.loading,
      partialList: state._hyperledgerNetwork.partialList,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'nodeList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(NodeSearch);
  };
  getNodeCreateForm = () => {
    const { NodeCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'node',
      data: state._hyperledgerNetwork.nodeList,
      metaInfo: state._hyperledgerNetwork.nodeListMetaInfo,
      count: state._hyperledgerNetwork.nodeCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/list`,
      currentPage: state._hyperledgerNetwork.nodeCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.nodeSearchFormParameters,
      loading: state._hyperledgerNetwork.loading,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'nodeList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(NodeCreateForm);
  };

  getNodeUpdateForm = () => {
    const userContext = null;
    const { NodeUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hyperledgerNetwork.selectedRows,
      role: 'node',
      currentUpdateIndex: state._hyperledgerNetwork.currentUpdateIndex,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        listName: 'nodeList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(NodeUpdateForm);
  };

  getChannelSearch = () => {
    const { ChannelSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      name: '频道',
      role: 'channel',
      data: state._hyperledgerNetwork.channelList,
      metaInfo: state._hyperledgerNetwork.channelListMetaInfo,
      count: state._hyperledgerNetwork.channelCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/dashboard`,
      currentPage: state._hyperledgerNetwork.channelCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.channelSearchFormParameters,
      searchParameters: { ...state._hyperledgerNetwork.searchParameters },
      expandForm: state._hyperledgerNetwork.expandForm,
      loading: state._hyperledgerNetwork.loading,
      partialList: state._hyperledgerNetwork.partialList,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'channelList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChannelSearch);
  };
  getChannelCreateForm = () => {
    const { ChannelCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'channel',
      data: state._hyperledgerNetwork.channelList,
      metaInfo: state._hyperledgerNetwork.channelListMetaInfo,
      count: state._hyperledgerNetwork.channelCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/list`,
      currentPage: state._hyperledgerNetwork.channelCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.channelSearchFormParameters,
      loading: state._hyperledgerNetwork.loading,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'channelList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChannelCreateForm);
  };

  getChannelUpdateForm = () => {
    const userContext = null;
    const { ChannelUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hyperledgerNetwork.selectedRows,
      role: 'channel',
      currentUpdateIndex: state._hyperledgerNetwork.currentUpdateIndex,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        listName: 'channelList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChannelUpdateForm);
  };

  getPeerRoleSearch = () => {
    const { PeerRoleSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      name: '对等的角色',
      role: 'peerRole',
      data: state._hyperledgerNetwork.peerRoleList,
      metaInfo: state._hyperledgerNetwork.peerRoleListMetaInfo,
      count: state._hyperledgerNetwork.peerRoleCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/dashboard`,
      currentPage: state._hyperledgerNetwork.peerRoleCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.peerRoleSearchFormParameters,
      searchParameters: { ...state._hyperledgerNetwork.searchParameters },
      expandForm: state._hyperledgerNetwork.expandForm,
      loading: state._hyperledgerNetwork.loading,
      partialList: state._hyperledgerNetwork.partialList,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'peerRoleList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(PeerRoleSearch);
  };
  getPeerRoleCreateForm = () => {
    const { PeerRoleCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'peerRole',
      data: state._hyperledgerNetwork.peerRoleList,
      metaInfo: state._hyperledgerNetwork.peerRoleListMetaInfo,
      count: state._hyperledgerNetwork.peerRoleCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/list`,
      currentPage: state._hyperledgerNetwork.peerRoleCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.peerRoleSearchFormParameters,
      loading: state._hyperledgerNetwork.loading,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'peerRoleList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(PeerRoleCreateForm);
  };

  getPeerRoleUpdateForm = () => {
    const userContext = null;
    const { PeerRoleUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hyperledgerNetwork.selectedRows,
      role: 'peerRole',
      currentUpdateIndex: state._hyperledgerNetwork.currentUpdateIndex,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        listName: 'peerRoleList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(PeerRoleUpdateForm);
  };

  getApplicationSearch = () => {
    const { ApplicationSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      name: '应用程序',
      role: 'application',
      data: state._hyperledgerNetwork.applicationList,
      metaInfo: state._hyperledgerNetwork.applicationListMetaInfo,
      count: state._hyperledgerNetwork.applicationCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/dashboard`,
      currentPage: state._hyperledgerNetwork.applicationCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.applicationSearchFormParameters,
      searchParameters: { ...state._hyperledgerNetwork.searchParameters },
      expandForm: state._hyperledgerNetwork.expandForm,
      loading: state._hyperledgerNetwork.loading,
      partialList: state._hyperledgerNetwork.partialList,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'applicationList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ApplicationSearch);
  };
  getApplicationCreateForm = () => {
    const { ApplicationCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'application',
      data: state._hyperledgerNetwork.applicationList,
      metaInfo: state._hyperledgerNetwork.applicationListMetaInfo,
      count: state._hyperledgerNetwork.applicationCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/list`,
      currentPage: state._hyperledgerNetwork.applicationCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.applicationSearchFormParameters,
      loading: state._hyperledgerNetwork.loading,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'applicationList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ApplicationCreateForm);
  };

  getApplicationUpdateForm = () => {
    const userContext = null;
    const { ApplicationUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hyperledgerNetwork.selectedRows,
      role: 'application',
      currentUpdateIndex: state._hyperledgerNetwork.currentUpdateIndex,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        listName: 'applicationList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ApplicationUpdateForm);
  };

  getServiceRecordSearch = () => {
    const { ServiceRecordSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      name: '服务记录',
      role: 'serviceRecord',
      data: state._hyperledgerNetwork.serviceRecordList,
      metaInfo: state._hyperledgerNetwork.serviceRecordListMetaInfo,
      count: state._hyperledgerNetwork.serviceRecordCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/dashboard`,
      currentPage: state._hyperledgerNetwork.serviceRecordCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.serviceRecordSearchFormParameters,
      searchParameters: { ...state._hyperledgerNetwork.searchParameters },
      expandForm: state._hyperledgerNetwork.expandForm,
      loading: state._hyperledgerNetwork.loading,
      partialList: state._hyperledgerNetwork.partialList,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'serviceRecordList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ServiceRecordSearch);
  };
  getServiceRecordCreateForm = () => {
    const { ServiceRecordCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'serviceRecord',
      data: state._hyperledgerNetwork.serviceRecordList,
      metaInfo: state._hyperledgerNetwork.serviceRecordListMetaInfo,
      count: state._hyperledgerNetwork.serviceRecordCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/list`,
      currentPage: state._hyperledgerNetwork.serviceRecordCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.serviceRecordSearchFormParameters,
      loading: state._hyperledgerNetwork.loading,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'serviceRecordList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ServiceRecordCreateForm);
  };

  getServiceRecordUpdateForm = () => {
    const userContext = null;
    const { ServiceRecordUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hyperledgerNetwork.selectedRows,
      role: 'serviceRecord',
      currentUpdateIndex: state._hyperledgerNetwork.currentUpdateIndex,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        listName: 'serviceRecordList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ServiceRecordUpdateForm);
  };

  getTransactionStatusSearch = () => {
    const { TransactionStatusSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      name: '交易状态',
      role: 'transactionStatus',
      data: state._hyperledgerNetwork.transactionStatusList,
      metaInfo: state._hyperledgerNetwork.transactionStatusListMetaInfo,
      count: state._hyperledgerNetwork.transactionStatusCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/dashboard`,
      currentPage: state._hyperledgerNetwork.transactionStatusCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.transactionStatusSearchFormParameters,
      searchParameters: { ...state._hyperledgerNetwork.searchParameters },
      expandForm: state._hyperledgerNetwork.expandForm,
      loading: state._hyperledgerNetwork.loading,
      partialList: state._hyperledgerNetwork.partialList,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'transactionStatusList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(TransactionStatusSearch);
  };
  getTransactionStatusCreateForm = () => {
    const { TransactionStatusCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'transactionStatus',
      data: state._hyperledgerNetwork.transactionStatusList,
      metaInfo: state._hyperledgerNetwork.transactionStatusListMetaInfo,
      count: state._hyperledgerNetwork.transactionStatusCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/list`,
      currentPage: state._hyperledgerNetwork.transactionStatusCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.transactionStatusSearchFormParameters,
      loading: state._hyperledgerNetwork.loading,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'transactionStatusList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(TransactionStatusCreateForm);
  };

  getTransactionStatusUpdateForm = () => {
    const userContext = null;
    const { TransactionStatusUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hyperledgerNetwork.selectedRows,
      role: 'transactionStatus',
      currentUpdateIndex: state._hyperledgerNetwork.currentUpdateIndex,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        listName: 'transactionStatusList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(TransactionStatusUpdateForm);
  };

  getChangeRequestTypeSearch = () => {
    const { ChangeRequestTypeSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      name: '变更请求类型',
      role: 'changeRequestType',
      data: state._hyperledgerNetwork.changeRequestTypeList,
      metaInfo: state._hyperledgerNetwork.changeRequestTypeListMetaInfo,
      count: state._hyperledgerNetwork.changeRequestTypeCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/dashboard`,
      currentPage: state._hyperledgerNetwork.changeRequestTypeCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.changeRequestTypeSearchFormParameters,
      searchParameters: { ...state._hyperledgerNetwork.searchParameters },
      expandForm: state._hyperledgerNetwork.expandForm,
      loading: state._hyperledgerNetwork.loading,
      partialList: state._hyperledgerNetwork.partialList,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'changeRequestTypeList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChangeRequestTypeSearch);
  };
  getChangeRequestTypeCreateForm = () => {
    const { ChangeRequestTypeCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'changeRequestType',
      data: state._hyperledgerNetwork.changeRequestTypeList,
      metaInfo: state._hyperledgerNetwork.changeRequestTypeListMetaInfo,
      count: state._hyperledgerNetwork.changeRequestTypeCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/list`,
      currentPage: state._hyperledgerNetwork.changeRequestTypeCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.changeRequestTypeSearchFormParameters,
      loading: state._hyperledgerNetwork.loading,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'changeRequestTypeList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChangeRequestTypeCreateForm);
  };

  getChangeRequestTypeUpdateForm = () => {
    const userContext = null;
    const { ChangeRequestTypeUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hyperledgerNetwork.selectedRows,
      role: 'changeRequestType',
      currentUpdateIndex: state._hyperledgerNetwork.currentUpdateIndex,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        listName: 'changeRequestTypeList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChangeRequestTypeUpdateForm);
  };

  getChangeRequestSearch = () => {
    const { ChangeRequestSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      name: '变更请求',
      role: 'changeRequest',
      data: state._hyperledgerNetwork.changeRequestList,
      metaInfo: state._hyperledgerNetwork.changeRequestListMetaInfo,
      count: state._hyperledgerNetwork.changeRequestCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/dashboard`,
      currentPage: state._hyperledgerNetwork.changeRequestCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.changeRequestSearchFormParameters,
      searchParameters: { ...state._hyperledgerNetwork.searchParameters },
      expandForm: state._hyperledgerNetwork.expandForm,
      loading: state._hyperledgerNetwork.loading,
      partialList: state._hyperledgerNetwork.partialList,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'changeRequestList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChangeRequestSearch);
  };
  getChangeRequestCreateForm = () => {
    const { ChangeRequestCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'changeRequest',
      data: state._hyperledgerNetwork.changeRequestList,
      metaInfo: state._hyperledgerNetwork.changeRequestListMetaInfo,
      count: state._hyperledgerNetwork.changeRequestCount,
      returnURL: `/hyperledgerNetwork/${state._hyperledgerNetwork.id}/list`,
      currentPage: state._hyperledgerNetwork.changeRequestCurrentPageNumber,
      searchFormParameters: state._hyperledgerNetwork.changeRequestSearchFormParameters,
      loading: state._hyperledgerNetwork.loading,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        referenceName: 'network',
        listName: 'changeRequestList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChangeRequestCreateForm);
  };

  getChangeRequestUpdateForm = () => {
    const userContext = null;
    const { ChangeRequestUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._hyperledgerNetwork.selectedRows,
      role: 'changeRequest',
      currentUpdateIndex: state._hyperledgerNetwork.currentUpdateIndex,
      owner: {
        type: '_hyperledgerNetwork',
        id: state._hyperledgerNetwork.id,
        listName: 'changeRequestList',
        ref: state._hyperledgerNetwork,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChangeRequestUpdateForm);
  };

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = 'Hyperledger Fabric 应用网关';
    return title;
  };

  buildRouters = () => {
    const { HyperledgerNetworkDashboard } = GlobalComponents;
    const { HyperledgerNetworkPermission } = GlobalComponents;
    const { HyperledgerNetworkProfile } = GlobalComponents;

    const routers = [
      { path: '/hyperledgerNetwork/:id/dashboard', component: HyperledgerNetworkDashboard },
      { path: '/hyperledgerNetwork/:id/profile', component: HyperledgerNetworkProfile },
      { path: '/hyperledgerNetwork/:id/permission', component: HyperledgerNetworkPermission },

      {
        path: '/hyperledgerNetwork/:id/list/organizationList',
        component: this.getOrganizationSearch(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/organizationCreateForm',
        component: this.getOrganizationCreateForm(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/organizationUpdateForm',
        component: this.getOrganizationUpdateForm(),
      },

      { path: '/hyperledgerNetwork/:id/list/nodeTypeList', component: this.getNodeTypeSearch() },
      {
        path: '/hyperledgerNetwork/:id/list/nodeTypeCreateForm',
        component: this.getNodeTypeCreateForm(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/nodeTypeUpdateForm',
        component: this.getNodeTypeUpdateForm(),
      },

      { path: '/hyperledgerNetwork/:id/list/nodeList', component: this.getNodeSearch() },
      { path: '/hyperledgerNetwork/:id/list/nodeCreateForm', component: this.getNodeCreateForm() },
      { path: '/hyperledgerNetwork/:id/list/nodeUpdateForm', component: this.getNodeUpdateForm() },

      { path: '/hyperledgerNetwork/:id/list/channelList', component: this.getChannelSearch() },
      {
        path: '/hyperledgerNetwork/:id/list/channelCreateForm',
        component: this.getChannelCreateForm(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/channelUpdateForm',
        component: this.getChannelUpdateForm(),
      },

      { path: '/hyperledgerNetwork/:id/list/peerRoleList', component: this.getPeerRoleSearch() },
      {
        path: '/hyperledgerNetwork/:id/list/peerRoleCreateForm',
        component: this.getPeerRoleCreateForm(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/peerRoleUpdateForm',
        component: this.getPeerRoleUpdateForm(),
      },

      {
        path: '/hyperledgerNetwork/:id/list/applicationList',
        component: this.getApplicationSearch(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/applicationCreateForm',
        component: this.getApplicationCreateForm(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/applicationUpdateForm',
        component: this.getApplicationUpdateForm(),
      },

      {
        path: '/hyperledgerNetwork/:id/list/serviceRecordList',
        component: this.getServiceRecordSearch(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/serviceRecordCreateForm',
        component: this.getServiceRecordCreateForm(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/serviceRecordUpdateForm',
        component: this.getServiceRecordUpdateForm(),
      },

      {
        path: '/hyperledgerNetwork/:id/list/transactionStatusList',
        component: this.getTransactionStatusSearch(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/transactionStatusCreateForm',
        component: this.getTransactionStatusCreateForm(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/transactionStatusUpdateForm',
        component: this.getTransactionStatusUpdateForm(),
      },

      {
        path: '/hyperledgerNetwork/:id/list/changeRequestTypeList',
        component: this.getChangeRequestTypeSearch(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/changeRequestTypeCreateForm',
        component: this.getChangeRequestTypeCreateForm(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/changeRequestTypeUpdateForm',
        component: this.getChangeRequestTypeUpdateForm(),
      },

      {
        path: '/hyperledgerNetwork/:id/list/changeRequestList',
        component: this.getChangeRequestSearch(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/changeRequestCreateForm',
        component: this.getChangeRequestCreateForm(),
      },
      {
        path: '/hyperledgerNetwork/:id/list/changeRequestUpdateForm',
        component: this.getChangeRequestUpdateForm(),
      },
      {
        path: '/hyperledgerNetwork/:id/ChangeRequestType/:code',
        component: GlobalComponents.ChangeRequestStepForm,
      },
    ];

    const { extraRoutesFunc } = this.props;
    const extraRoutes = extraRoutesFunc ? extraRoutesFunc() : [];
    const finalRoutes = routers.concat(extraRoutes);

    return (
      <Switch>
        {finalRoutes.map(item => (
          <Route key={item.path} path={item.path} component={item.component} />
        ))}
      </Switch>
    );
  };

  handleOpenChange = openKeys => {
    const latestOpenKey = openKeys.find(key => this.state.openKeys.indexOf(key) === -1);
    this.setState({
      openKeys: latestOpenKey ? [latestOpenKey] : [],
    });
  };
  toggle = () => {
    const { collapsed } = this.props;
    this.props.dispatch({
      type: 'global/changeLayoutCollapsed',
      payload: !collapsed,
    });
  };
  logout = () => {
    console.log('log out called');
    this.props.dispatch({ type: 'launcher/signOut' });
  };
  render() {
    // const { collapsed, fetchingNotices,loading } = this.props
    const { collapsed } = this.props;

    const targetApp = sessionObject('targetApp');
    const currentBreadcrumb = targetApp ? sessionObject(targetApp.id) : [];
    const userContext = null;
    const renderBreadcrumbText = value => {
      if (value == null) {
        return '...';
      }
      if (value.length < 10) {
        return value;
      }

      return value.substring(0, 10) + '...';
    };
    const menuProps = collapsed
      ? {}
      : {
          openKeys: this.state.openKeys,
        };
    const renderBreadcrumbMenuItem = breadcrumbMenuItem => {
      return (
        <Menu.Item key={breadcrumbMenuItem.link}>
          <Link
            key={breadcrumbMenuItem.link}
            to={`${breadcrumbMenuItem.link}`}
            className={styles.breadcrumbLink}
          >
            <Icon type="heart" style={{ marginRight: '10px', color: 'red' }} />
            {renderBreadcrumbText(breadcrumbMenuItem.name)}
          </Link>
        </Menu.Item>
      );
    };
    const breadcrumbMenu = () => {
      const currentBreadcrumb = targetApp ? sessionObject(targetApp.id) : [];
      return (
        <Menu mode="vertical">{currentBreadcrumb.map(item => renderBreadcrumbMenuItem(item))}</Menu>
      );
    };
    const { Search } = Input;
    const layout = (
      <Layout>
        <Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
          <Row type="flex" justify="start" align="bottom">
            <Col {...naviBarResponsiveStyle}>
              <Dropdown overlay={this.getNavMenuItems(this.props.hyperledgerNetwork)}>
                <a className={styles.menuLink}>
                  <Icon type="unordered-list" style={{ fontSize: '20px', marginRight: '10px' }} />{' '}
                  菜单
                </a>
              </Dropdown>
              <Dropdown overlay={breadcrumbMenu()}>
                <a className={styles.menuLink}>
                  <Icon type="down" style={{ fontSize: '20px', marginRight: '10px' }} /> 快速转到
                </a>
              </Dropdown>
            </Col>
            <Col className={styles.searchBox} {...searchBarResponsiveStyle}>
              <Search
                size="default"
                placeholder="请输入搜索条件, 查找功能，数据和词汇解释"
                enterButton
                style={{ marginLeft: '10px', marginTop: '7px', width: '100%' }}
              />
            </Col>
            <Col {...userBarResponsiveStyle}>
              <Dropdown overlay={<TopMenu {...this.props} />} className={styles.right}>
                <a className={styles.menuLink}>
                  <Icon type="user" style={{ fontSize: '20px', marginRight: '10px' }} /> 账户
                </a>
              </Dropdown>
            </Col>
          </Row>
        </Header>
        <Layout style={{ marginTop: 44 }}>
          <Layout>
            <Content style={{ margin: '24px 24px 0', height: '100%' }}>
              {this.buildRouters()}
            </Content>
          </Layout>
        </Layout>
      </Layout>
    );
    return (
      <DocumentTitle title={this.getPageTitle()}>
        <ContainerQuery query={query}>
          {params => <div className={classNames(params)}>{layout}</div>}
        </ContainerQuery>
      </DocumentTitle>
    );
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
  fetchingNotices: state.global.fetchingNotices,
  notices: state.global.notices,
  hyperledgerNetwork: state._hyperledgerNetwork,
  ...state,
}))(HyperledgerNetworkBizApp);
