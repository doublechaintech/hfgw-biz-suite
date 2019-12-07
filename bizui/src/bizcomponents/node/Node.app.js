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
import styles from './Node.app.less';
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

class NodeBizApp extends React.PureComponent {
  constructor(props) {
    super(props);
    this.state = {
      openKeys: this.getDefaultCollapsedSubMenus(props),
      showSearch: false,
      searchKeyword: '',
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
      return ['/node/'];
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
        style={{ width: '456px' }}
      >
        <Menu.Item key="dashboard">
          <Link to={`/node/${this.props.node.id}/dashboard`}>
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

  getGrpcOptionSearch = () => {
    const { GrpcOptionSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      name: 'Grpc选项',
      role: 'grpcOption',
      data: state._node.grpcOptionList,
      metaInfo: state._node.grpcOptionListMetaInfo,
      count: state._node.grpcOptionCount,
      returnURL: `/node/${state._node.id}/dashboard`,
      currentPage: state._node.grpcOptionCurrentPageNumber,
      searchFormParameters: state._node.grpcOptionSearchFormParameters,
      searchParameters: { ...state._node.searchParameters },
      expandForm: state._node.expandForm,
      loading: state._node.loading,
      partialList: state._node.partialList,
      owner: {
        type: '_node',
        id: state._node.id,
        referenceName: 'node',
        listName: 'grpcOptionList',
        ref: state._node,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(GrpcOptionSearch);
  };
  getGrpcOptionCreateForm = () => {
    const { GrpcOptionCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'grpcOption',
      data: state._node.grpcOptionList,
      metaInfo: state._node.grpcOptionListMetaInfo,
      count: state._node.grpcOptionCount,
      returnURL: `/node/${state._node.id}/list`,
      currentPage: state._node.grpcOptionCurrentPageNumber,
      searchFormParameters: state._node.grpcOptionSearchFormParameters,
      loading: state._node.loading,
      owner: {
        type: '_node',
        id: state._node.id,
        referenceName: 'node',
        listName: 'grpcOptionList',
        ref: state._node,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(GrpcOptionCreateForm);
  };

  getGrpcOptionUpdateForm = () => {
    const userContext = null;
    const { GrpcOptionUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._node.selectedRows,
      role: 'grpcOption',
      currentUpdateIndex: state._node.currentUpdateIndex,
      owner: {
        type: '_node',
        id: state._node.id,
        listName: 'grpcOptionList',
        ref: state._node,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(GrpcOptionUpdateForm);
  };

  getChannelPeerRoleSearch = () => {
    const { ChannelPeerRoleSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      name: '通道对等的角色',
      role: 'channelPeerRole',
      data: state._node.channelPeerRoleList,
      metaInfo: state._node.channelPeerRoleListMetaInfo,
      count: state._node.channelPeerRoleCount,
      returnURL: `/node/${state._node.id}/dashboard`,
      currentPage: state._node.channelPeerRoleCurrentPageNumber,
      searchFormParameters: state._node.channelPeerRoleSearchFormParameters,
      searchParameters: { ...state._node.searchParameters },
      expandForm: state._node.expandForm,
      loading: state._node.loading,
      partialList: state._node.partialList,
      owner: {
        type: '_node',
        id: state._node.id,
        referenceName: 'node',
        listName: 'channelPeerRoleList',
        ref: state._node,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChannelPeerRoleSearch);
  };
  getChannelPeerRoleCreateForm = () => {
    const { ChannelPeerRoleCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'channelPeerRole',
      data: state._node.channelPeerRoleList,
      metaInfo: state._node.channelPeerRoleListMetaInfo,
      count: state._node.channelPeerRoleCount,
      returnURL: `/node/${state._node.id}/list`,
      currentPage: state._node.channelPeerRoleCurrentPageNumber,
      searchFormParameters: state._node.channelPeerRoleSearchFormParameters,
      loading: state._node.loading,
      owner: {
        type: '_node',
        id: state._node.id,
        referenceName: 'node',
        listName: 'channelPeerRoleList',
        ref: state._node,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChannelPeerRoleCreateForm);
  };

  getChannelPeerRoleUpdateForm = () => {
    const userContext = null;
    const { ChannelPeerRoleUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._node.selectedRows,
      role: 'channelPeerRole',
      currentUpdateIndex: state._node.currentUpdateIndex,
      owner: {
        type: '_node',
        id: state._node.id,
        listName: 'channelPeerRoleList',
        ref: state._node,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChannelPeerRoleUpdateForm);
  };

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = 'Hyperledger Fabric 应用网关';
    return title;
  };

  buildRouters = () => {
    const { NodeDashboard } = GlobalComponents;
    const { NodePermission } = GlobalComponents;
    const { NodeProfile } = GlobalComponents;

    const routers = [
      { path: '/node/:id/dashboard', component: NodeDashboard },
      { path: '/node/:id/profile', component: NodeProfile },
      { path: '/node/:id/permission', component: NodePermission },

      { path: '/node/:id/list/grpcOptionList', component: this.getGrpcOptionSearch() },
      { path: '/node/:id/list/grpcOptionCreateForm', component: this.getGrpcOptionCreateForm() },
      { path: '/node/:id/list/grpcOptionUpdateForm', component: this.getGrpcOptionUpdateForm() },

      { path: '/node/:id/list/channelPeerRoleList', component: this.getChannelPeerRoleSearch() },
      {
        path: '/node/:id/list/channelPeerRoleCreateForm',
        component: this.getChannelPeerRoleCreateForm(),
      },
      {
        path: '/node/:id/list/channelPeerRoleUpdateForm',
        component: this.getChannelPeerRoleUpdateForm(),
      },
      {
        path: '/node/:id/ChangeRequestType/:code',
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
    const showSearchResult = () => {
      this.setState({ showSearch: true });
    };
    const searchChange = evt => {
      this.setState({ searchKeyword: evt.target.value });
    };
    const hideSearchResult = () => {
      this.setState({ showSearch: false });
    };

    const { searchLocalData } = GlobalComponents.NodeBase;

    const layout = (
      <Layout>
        <Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
          <Row type="flex" justify="start" align="bottom">
            <Col {...naviBarResponsiveStyle}>
              <Dropdown overlay={this.getNavMenuItems(this.props.node)}>
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
                placeholder="请输入搜索条件, 查找功能，数据和词汇解释，关闭请点击搜索结果空白处"
                enterButton
                onFocus={() => showSearchResult()}
                onChange={evt => searchChange(evt)}
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
          {this.state.showSearch && (
            <div style={{ backgroundColor: 'black' }} onClick={() => hideSearchResult()}>
              {searchLocalData(this.props.node, this.state.searchKeyword)}
            </div>
          )}

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
  node: state._node,
  ...state,
}))(NodeBizApp);
