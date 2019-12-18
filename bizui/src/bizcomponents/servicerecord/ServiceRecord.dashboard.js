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
import styles from './ServiceRecord.dashboard.less';
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

const imageList = serviceRecord => {
  return [];
};

const internalImageListOf = serviceRecord => defaultImageListOf(serviceRecord, imageList);

const optionList = serviceRecord => {
  return [];
};

const buildTransferModal = defaultBuildTransferModal;
const showTransferModel = defaultShowTransferModel;
const internalRenderSubjectList = defaultRenderSubjectList;
const internalSettingListOf = serviceRecord => defaultSettingListOf(serviceRecord, optionList);
const internalLargeTextOf = serviceRecord => {
  return (
    <div>
      <Card title={`有效载荷`}>
        <pre>{serviceRecord.payload}</pre>
      </Card>
      <Card title={`响应`}>
        <pre>{serviceRecord.response}</pre>
      </Card>
    </div>
  );
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
        to={`/serviceRecord/${targetComponent.props.serviceRecord.id}/list/${item.name}/${
          item.displayName
        }/`}
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
        <Link to={`/serviceRecord/${targetComponent.props.serviceRecord.id}/permission`}>
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

const internalSummaryOf = (serviceRecord, targetComponent) => {
  const { ServiceRecordService } = GlobalComponents;
  const userContext = null;
  return (
    <DescriptionList className={styles.headerList} size="small" col="4">
      <Description term="ID" style={{ wordBreak: 'break-all' }}>
        {serviceRecord.id}
      </Description>
      <Description term="事务Id" style={{ wordBreak: 'break-all' }}>
        {serviceRecord.transactionId}
      </Description>
      <Description term="名称" style={{ wordBreak: 'break-all' }}>
        {serviceRecord.name}
      </Description>
      <Description term="频道">
        {serviceRecord.channel == null
          ? appLocaleName(userContext, 'NotAssigned')
          : `${serviceRecord.channel.displayName}(${serviceRecord.channel.id})`}
        <Icon
          type="swap"
          onClick={() =>
            showTransferModel(
              targetComponent,
              '频道',
              'channel',
              ServiceRecordService.requestCandidateChannel,
              ServiceRecordService.transferToAnotherChannel,
              'anotherChannelId',
              serviceRecord.channel ? serviceRecord.channel.id : ''
            )
          }
          style={{ fontSize: 20, color: 'red' }}
        />
      </Description>
      <Description term="链码">
        {serviceRecord.chainCode == null
          ? appLocaleName(userContext, 'NotAssigned')
          : `${serviceRecord.chainCode.displayName}(${serviceRecord.chainCode.id})`}
        <Icon
          type="swap"
          onClick={() =>
            showTransferModel(
              targetComponent,
              '链码',
              'chainCode',
              ServiceRecordService.requestCandidateChainCode,
              ServiceRecordService.transferToAnotherChainCode,
              'anotherChainCodeId',
              serviceRecord.chainCode ? serviceRecord.chainCode.id : ''
            )
          }
          style={{ fontSize: 20, color: 'red' }}
        />
      </Description>
      <Description term="链码功能" style={{ wordBreak: 'break-all' }}>
        {serviceRecord.chainCodeFunction}
      </Description>
      <Description term="块Id" style={{ wordBreak: 'break-all' }}>
        {serviceRecord.blockId}
      </Description>
      <Description term="创建时间">
        {moment(serviceRecord.createTime).format('YYYY-MM-DD HH:mm')}
      </Description>
      <Description term="应用客户端">
        {serviceRecord.appClient == null
          ? appLocaleName(userContext, 'NotAssigned')
          : `${serviceRecord.appClient.displayName}(${serviceRecord.appClient.id})`}
        <Icon
          type="swap"
          onClick={() =>
            showTransferModel(
              targetComponent,
              '应用客户端',
              'application',
              ServiceRecordService.requestCandidateAppClient,
              ServiceRecordService.transferToAnotherAppClient,
              'anotherAppClientId',
              serviceRecord.appClient ? serviceRecord.appClient.id : ''
            )
          }
          style={{ fontSize: 20, color: 'red' }}
        />
      </Description>
      <Description term="状态">
        {serviceRecord.status == null
          ? appLocaleName(userContext, 'NotAssigned')
          : `${serviceRecord.status.displayName}(${serviceRecord.status.id})`}
        <Icon
          type="swap"
          onClick={() =>
            showTransferModel(
              targetComponent,
              '状态',
              'transactionStatus',
              ServiceRecordService.requestCandidateStatus,
              ServiceRecordService.transferToAnotherStatus,
              'anotherStatusId',
              serviceRecord.status ? serviceRecord.status.id : ''
            )
          }
          style={{ fontSize: 20, color: 'red' }}
        />
      </Description>

      {buildTransferModal(serviceRecord, targetComponent)}
    </DescriptionList>
  );
};

const internalQuickFunctions = defaultQuickFunctions;

class ServiceRecordDashboard extends Component {
  state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName: '',
    candidateObjectType: 'city',
    targetLocalName: '',
    transferServiceName: '',
    currentValue: '',
    transferTargetParameterName: '',
    defaultType: 'serviceRecord',
  };
  componentDidMount() {}

  render() {
    // eslint-disable-next-line max-len
    const { id, displayName } = this.props.serviceRecord;
    if (!this.props.serviceRecord.class) {
      return null;
    }
    const returnURL = this.props.returnURL;

    const cardsData = {
      cardsName: '服务记录',
      cardsFor: 'serviceRecord',
      cardsSource: this.props.serviceRecord,
      returnURL,
      displayName,
      subItems: [],
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
  serviceRecord: state._serviceRecord,
  returnURL: state.breadcrumb.returnURL,
}))(Form.create()(ServiceRecordDashboard));
