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
import styles from './Application.app.less';
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

class ApplicationBizApp extends React.PureComponent {
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
      return ['/application/'];
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
          <Link to={`/application/${this.props.application.id}/dashboard`}>
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

  getServiceRecordSearch = () => {
    const { ServiceRecordSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      name: '服务记录',
      role: 'serviceRecord',
      data: state._application.serviceRecordList,
      metaInfo: state._application.serviceRecordListMetaInfo,
      count: state._application.serviceRecordCount,
      returnURL: `/application/${state._application.id}/dashboard`,
      currentPage: state._application.serviceRecordCurrentPageNumber,
      searchFormParameters: state._application.serviceRecordSearchFormParameters,
      searchParameters: { ...state._application.searchParameters },
      expandForm: state._application.expandForm,
      loading: state._application.loading,
      partialList: state._application.partialList,
      owner: {
        type: '_application',
        id: state._application.id,
        referenceName: 'appClient',
        listName: 'serviceRecordList',
        ref: state._application,
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
      data: state._application.serviceRecordList,
      metaInfo: state._application.serviceRecordListMetaInfo,
      count: state._application.serviceRecordCount,
      returnURL: `/application/${state._application.id}/list`,
      currentPage: state._application.serviceRecordCurrentPageNumber,
      searchFormParameters: state._application.serviceRecordSearchFormParameters,
      loading: state._application.loading,
      owner: {
        type: '_application',
        id: state._application.id,
        referenceName: 'appClient',
        listName: 'serviceRecordList',
        ref: state._application,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ServiceRecordCreateForm);
  };

  getServiceRecordUpdateForm = () => {
    const userContext = null;
    const { ServiceRecordUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._application.selectedRows,
      role: 'serviceRecord',
      currentUpdateIndex: state._application.currentUpdateIndex,
      owner: {
        type: '_application',
        id: state._application.id,
        listName: 'serviceRecordList',
        ref: state._application,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ServiceRecordUpdateForm);
  };

  getChainCodeInvokerSearch = () => {
    const { ChainCodeInvokerSearch } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      name: '链代码调用程序',
      role: 'chainCodeInvoker',
      data: state._application.chainCodeInvokerList,
      metaInfo: state._application.chainCodeInvokerListMetaInfo,
      count: state._application.chainCodeInvokerCount,
      returnURL: `/application/${state._application.id}/dashboard`,
      currentPage: state._application.chainCodeInvokerCurrentPageNumber,
      searchFormParameters: state._application.chainCodeInvokerSearchFormParameters,
      searchParameters: { ...state._application.searchParameters },
      expandForm: state._application.expandForm,
      loading: state._application.loading,
      partialList: state._application.partialList,
      owner: {
        type: '_application',
        id: state._application.id,
        referenceName: 'appClient',
        listName: 'chainCodeInvokerList',
        ref: state._application,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChainCodeInvokerSearch);
  };
  getChainCodeInvokerCreateForm = () => {
    const { ChainCodeInvokerCreateForm } = GlobalComponents;
    const userContext = null;
    return connect(state => ({
      rule: state.rule,
      role: 'chainCodeInvoker',
      data: state._application.chainCodeInvokerList,
      metaInfo: state._application.chainCodeInvokerListMetaInfo,
      count: state._application.chainCodeInvokerCount,
      returnURL: `/application/${state._application.id}/list`,
      currentPage: state._application.chainCodeInvokerCurrentPageNumber,
      searchFormParameters: state._application.chainCodeInvokerSearchFormParameters,
      loading: state._application.loading,
      owner: {
        type: '_application',
        id: state._application.id,
        referenceName: 'appClient',
        listName: 'chainCodeInvokerList',
        ref: state._application,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChainCodeInvokerCreateForm);
  };

  getChainCodeInvokerUpdateForm = () => {
    const userContext = null;
    const { ChainCodeInvokerUpdateForm } = GlobalComponents;
    return connect(state => ({
      selectedRows: state._application.selectedRows,
      role: 'chainCodeInvoker',
      currentUpdateIndex: state._application.currentUpdateIndex,
      owner: {
        type: '_application',
        id: state._application.id,
        listName: 'chainCodeInvokerList',
        ref: state._application,
        listDisplayName: appLocaleName(userContext, 'List'),
      }, // this is for model namespace and
    }))(ChainCodeInvokerUpdateForm);
  };

  getPageTitle = () => {
    // const { location } = this.props
    // const { pathname } = location
    const title = 'Hyperledger Fabric 应用网关';
    return title;
  };

  buildRouters = () => {
    const { ApplicationDashboard } = GlobalComponents;
    const { ApplicationPermission } = GlobalComponents;
    const { ApplicationProfile } = GlobalComponents;

    const routers = [
      { path: '/application/:id/dashboard', component: ApplicationDashboard },
      { path: '/application/:id/profile', component: ApplicationProfile },
      { path: '/application/:id/permission', component: ApplicationPermission },

      { path: '/application/:id/list/serviceRecordList', component: this.getServiceRecordSearch() },
      {
        path: '/application/:id/list/serviceRecordCreateForm',
        component: this.getServiceRecordCreateForm(),
      },
      {
        path: '/application/:id/list/serviceRecordUpdateForm',
        component: this.getServiceRecordUpdateForm(),
      },

      {
        path: '/application/:id/list/chainCodeInvokerList',
        component: this.getChainCodeInvokerSearch(),
      },
      {
        path: '/application/:id/list/chainCodeInvokerCreateForm',
        component: this.getChainCodeInvokerCreateForm(),
      },
      {
        path: '/application/:id/list/chainCodeInvokerUpdateForm',
        component: this.getChainCodeInvokerUpdateForm(),
      },
      {
        path: '/application/:id/ChangeRequestType/:code',
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

    const { searchLocalData } = GlobalComponents.ApplicationBase;

    const layout = (
      <Layout>
        <Header style={{ position: 'fixed', zIndex: 1, width: '100%' }}>
          <Row type="flex" justify="start" align="bottom">
            <Col {...naviBarResponsiveStyle}>
              <Dropdown overlay={this.getNavMenuItems(this.props.application)}>
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
              {searchLocalData(this.props.application, this.state.searchKeyword)}
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
  application: state._application,
  ...state,
}))(ApplicationBizApp);
