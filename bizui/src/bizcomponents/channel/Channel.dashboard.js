import React, { Component } from 'react';
import { connect } from 'dva';
import moment from 'moment';
import BooleanOption from '../../components/BooleanOption';
import {
  Button,
  Row,
  Col,
  Icon,
  Card,
  Tabs,
  Table,
  Radio,
  DatePicker,
  Tooltip,
  Menu,
  Dropdown,
  Badge,
  Switch,
  Select,
  Form,
  AutoComplete,
  Modal,
} from 'antd';
import { Link, Route, Redirect } from 'dva/router';
import numeral from 'numeral';
import {
  ChartCard,
  yuan,
  MiniArea,
  MiniBar,
  MiniProgress,
  Field,
  Bar,
  Pie,
  TimelineChart,
} from '../../components/Charts';
import Trend from '../../components/Trend';
import NumberInfo from '../../components/NumberInfo';
import { getTimeDistance } from '../../utils/utils';
import PageHeaderLayout from '../../layouts/PageHeaderLayout';
import styles from './Channel.dashboard.less';
import DescriptionList from '../../components/DescriptionList';
import ImagePreview from '../../components/ImagePreview';
import GlobalComponents from '../../custcomponents';
import DashboardTool from '../../common/Dashboard.tool';
import appLocaleName from '../../common/Locale.tool';

const {
  aggregateDataset,
  calcKey,
  defaultHideCloseTrans,
  defaultImageListOf,
  defaultSettingListOf,
  defaultBuildTransferModal,
  defaultExecuteTrans,
  defaultHandleTransferSearch,
  defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultSubListsOf,
  defaultRenderAnalytics,
  defaultRenderExtraFooter,
  renderForTimeLine,
  renderForNumbers,
  defaultQuickFunctions,
  defaultRenderSubjectList,
} = DashboardTool;

const { Description } = DescriptionList;
const { TabPane } = Tabs;
const { RangePicker } = DatePicker;
const { Option } = Select;

const imageList = channel => {
  return [];
};

const internalImageListOf = channel => defaultImageListOf(channel, imageList);

const optionList = channel => {
  return [];
};

const buildTransferModal = defaultBuildTransferModal;
const showTransferModel = defaultShowTransferModel;
const internalRenderSubjectList = defaultRenderSubjectList;
const internalSettingListOf = channel => defaultSettingListOf(channel, optionList);
const internalLargeTextOf = channel => {
  return null;
};

const internalRenderExtraHeader = defaultRenderExtraHeader;

const internalRenderExtraFooter = defaultRenderExtraFooter;
const internalSubListsOf = defaultSubListsOf;

const renderSettingDropDown = (cardsData, targetComponent) => {
  return (
    <div style={{ float: 'right' }}>
      <Dropdown overlay={renderSettingMenu(cardsData, targetComponent)} placement="bottomRight">
        <Button>
          <Icon type="setting" theme="filled" twoToneColor="#00b" style={{ color: '#3333b0' }} />{' '}
          设置 <Icon type="down" />
        </Button>
      </Dropdown>
    </div>
  );
};

const renderSettingMenuItem = (item, cardsData, targetComponent) => {
  const userContext = null;
  return (
    <Menu.Item key={item.name}>
      <Link
        to={`/channel/${targetComponent.props.channel.id}/list/${item.name}/${item.displayName}/`}
      >
        <span>{item.displayName}</span>
      </Link>
    </Menu.Item>
  );
};
const renderSettingMenu = (cardsData, targetComponent) => {
  const userContext = null;
  return (
    <Menu>
      <Menu.Item key="profile">
        <Link to={`/channel/${targetComponent.props.channel.id}/permission`}>
          <Icon type="safety-certificate" theme="twoTone" twoToneColor="#52c41a" />
          <span>{appLocaleName(userContext, 'Permission')}</span>
        </Link>
      </Menu.Item>
      <Menu.Divider />
      {cardsData.subSettingItems.map(item =>
        renderSettingMenuItem(item, cardsData, targetComponent)
      )}
    </Menu>
  );
};

const internalRenderTitle = (cardsData, targetComponent) => {
  const linkComp = cardsData.returnURL ? (
    <Link to={cardsData.returnURL}>
      {' '}
      <Icon type="double-left" style={{ marginRight: '10px' }} />{' '}
    </Link>
  ) : null;
  return (
    <div>
      {linkComp}
      {cardsData.cardsName}: {cardsData.displayName}{' '}
      {renderSettingDropDown(cardsData, targetComponent)}
    </div>
  );
};

const internalSummaryOf = (channel, targetComponent) => {
  const { ChannelService } = GlobalComponents;
  const userContext = null;
  return (
    <DescriptionList className={styles.headerList} size="small" col="4">
      <Description term="ID" style={{ wordBreak: 'break-all' }}>
        {channel.id}
      </Description>
      <Description term="名称" style={{ wordBreak: 'break-all' }}>
        {channel.name}
      </Description>

      {buildTransferModal(channel, targetComponent)}
    </DescriptionList>
  );
};

const internalQuickFunctions = defaultQuickFunctions;

class ChannelDashboard extends Component {
  state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName: '',
    candidateObjectType: 'city',
    targetLocalName: '',
    transferServiceName: '',
    currentValue: '',
    transferTargetParameterName: '',
    defaultType: 'channel',
  };
  componentDidMount() {}

  render() {
    // eslint-disable-next-line max-len
    const {
      id,
      displayName,
      nodeListMetaInfo,
      channelPeerRoleListMetaInfo,
      chainCodeListMetaInfo,
      applicationListMetaInfo,
      serviceRecordListMetaInfo,
      nodeCount,
      channelPeerRoleCount,
      chainCodeCount,
      applicationCount,
      serviceRecordCount,
    } = this.props.channel;
    if (!this.props.channel.class) {
      return null;
    }
    const returnURL = this.props.returnURL;

    const cardsData = {
      cardsName: '频道',
      cardsFor: 'channel',
      cardsSource: this.props.channel,
      returnURL,
      displayName,
      subItems: [
        {
          name: 'nodeList',
          displayName: '节点',
          viewGroup: '__no_group',
          type: 'node',
          count: nodeCount,
          addFunction: true,
          role: 'node',
          metaInfo: nodeListMetaInfo,
          renderItem: GlobalComponents.NodeBase.renderItemOfList,
        },
        {
          name: 'channelPeerRoleList',
          displayName: '通道对等的角色',
          viewGroup: '__no_group',
          type: 'channelPeerRole',
          count: channelPeerRoleCount,
          addFunction: true,
          role: 'channelPeerRole',
          metaInfo: channelPeerRoleListMetaInfo,
          renderItem: GlobalComponents.ChannelPeerRoleBase.renderItemOfList,
        },
        {
          name: 'chainCodeList',
          displayName: '链码',
          viewGroup: '__no_group',
          type: 'chainCode',
          count: chainCodeCount,
          addFunction: true,
          role: 'chainCode',
          metaInfo: chainCodeListMetaInfo,
          renderItem: GlobalComponents.ChainCodeBase.renderItemOfList,
        },
        {
          name: 'applicationList',
          displayName: '应用程序',
          viewGroup: '__no_group',
          type: 'application',
          count: applicationCount,
          addFunction: true,
          role: 'application',
          metaInfo: applicationListMetaInfo,
          renderItem: GlobalComponents.ApplicationBase.renderItemOfList,
        },
        {
          name: 'serviceRecordList',
          displayName: '服务记录',
          viewGroup: '__no_group',
          type: 'serviceRecord',
          count: serviceRecordCount,
          addFunction: true,
          role: 'serviceRecord',
          metaInfo: serviceRecordListMetaInfo,
          renderItem: GlobalComponents.ServiceRecordBase.renderItemOfList,
        },
      ],
      subSettingItems: [],
    };

    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader;
    const settingListOf = this.props.settingListOf || internalSettingListOf;
    const imageListOf = this.props.imageListOf || internalImageListOf;
    const subListsOf = this.props.subListsOf || internalSubListsOf;
    const largeTextOf = this.props.largeTextOf || internalLargeTextOf;
    const summaryOf = this.props.summaryOf || internalSummaryOf;
    const renderTitle = this.props.renderTitle || internalRenderTitle;
    const renderExtraFooter = this.props.renderExtraFooter || internalRenderExtraFooter;
    const renderAnalytics = this.props.renderAnalytics || defaultRenderAnalytics;
    const quickFunctions = this.props.quickFunctions || internalQuickFunctions;
    const renderSubjectList = this.props.renderSubjectList || internalRenderSubjectList;

    return (
      <PageHeaderLayout
        title={renderTitle(cardsData, this)}
        content={summaryOf(cardsData.cardsSource, this)}
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
    );
  }
}

export default connect(state => ({
  channel: state._channel,
  returnURL: state.breadcrumb.returnURL,
}))(Form.create()(ChannelDashboard));
