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
import styles from './Application.dashboard.less';
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

const imageList = application => {
  return [];
};

const internalImageListOf = application => defaultImageListOf(application, imageList);

const optionList = application => {
  return [];
};

const buildTransferModal = defaultBuildTransferModal;
const showTransferModel = defaultShowTransferModel;
const internalRenderSubjectList = defaultRenderSubjectList;
const internalSettingListOf = application => defaultSettingListOf(application, optionList);
const internalLargeTextOf = application => {
  return (
    <div>
      <Card title={`公钥`}>
        <pre>{application.publicKey}</pre>
      </Card>
      <Card title={`私钥`}>
        <pre>{application.privateKey}</pre>
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
        to={`/application/${targetComponent.props.application.id}/list/${item.name}/${
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
        <Link to={`/application/${targetComponent.props.application.id}/permission`}>
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

const internalSummaryOf = (application, targetComponent) => {
  const { ApplicationService } = GlobalComponents;
  const userContext = null;
  return (
    <DescriptionList className={styles.headerList} size="small" col="4">
      <Description term="ID" style={{ wordBreak: 'break-all' }}>
        {application.id}
      </Description>
      <Description term="名称" style={{ wordBreak: 'break-all' }}>
        {application.name}
      </Description>
      <Description term="创建时间">
        {moment(application.createTime).format('YYYY-MM-DD HH:mm')}
      </Description>
      <Description term="Mspid" style={{ wordBreak: 'break-all' }}>
        {application.mspid}
      </Description>
      <Description term="频道">
        {application.channel == null
          ? appLocaleName(userContext, 'NotAssigned')
          : `${application.channel.displayName}(${application.channel.id})`}
        <Icon
          type="swap"
          onClick={() =>
            showTransferModel(
              targetComponent,
              '频道',
              'channel',
              ApplicationService.requestCandidateChannel,
              ApplicationService.transferToAnotherChannel,
              'anotherChannelId',
              application.channel ? application.channel.id : ''
            )
          }
          style={{ fontSize: 20, color: 'red' }}
        />
      </Description>

      {buildTransferModal(application, targetComponent)}
    </DescriptionList>
  );
};

const internalQuickFunctions = defaultQuickFunctions;

class ApplicationDashboard extends Component {
  state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName: '',
    candidateObjectType: 'city',
    targetLocalName: '',
    transferServiceName: '',
    currentValue: '',
    transferTargetParameterName: '',
    defaultType: 'application',
  };
  componentDidMount() {}

  render() {
    // eslint-disable-next-line max-len
    const {
      id,
      displayName,
      serviceRecordListMetaInfo,
      chainCodeInvokerListMetaInfo,
      serviceRecordCount,
      chainCodeInvokerCount,
    } = this.props.application;
    if (!this.props.application.class) {
      return null;
    }
    const returnURL = this.props.returnURL;

    const cardsData = {
      cardsName: '应用程序',
      cardsFor: 'application',
      cardsSource: this.props.application,
      returnURL,
      displayName,
      subItems: [
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
        {
          name: 'chainCodeInvokerList',
          displayName: '链代码调用程序',
          viewGroup: '__no_group',
          type: 'chainCodeInvoker',
          count: chainCodeInvokerCount,
          addFunction: true,
          role: 'chainCodeInvoker',
          metaInfo: chainCodeInvokerListMetaInfo,
          renderItem: GlobalComponents.ChainCodeInvokerBase.renderItemOfList,
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
  application: state._application,
  returnURL: state.breadcrumb.returnURL,
}))(Form.create()(ApplicationDashboard));
