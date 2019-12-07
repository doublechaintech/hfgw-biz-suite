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
import styles from './ChainCodeInvoker.dashboard.less';
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

const imageList = chainCodeInvoker => {
  return [];
};

const internalImageListOf = chainCodeInvoker => defaultImageListOf(chainCodeInvoker, imageList);

const optionList = chainCodeInvoker => {
  return [];
};

const buildTransferModal = defaultBuildTransferModal;
const showTransferModel = defaultShowTransferModel;
const internalRenderSubjectList = defaultRenderSubjectList;
const internalSettingListOf = chainCodeInvoker =>
  defaultSettingListOf(chainCodeInvoker, optionList);
const internalLargeTextOf = chainCodeInvoker => {
  return (
    <div>
      <Card title={`参数`}>
        <pre>{chainCodeInvoker.parameters}</pre>
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
        to={`/chainCodeInvoker/${targetComponent.props.chainCodeInvoker.id}/list/${item.name}/${
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
        <Link to={`/chainCodeInvoker/${targetComponent.props.chainCodeInvoker.id}/permission`}>
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

const internalSummaryOf = (chainCodeInvoker, targetComponent) => {
  const { ChainCodeInvokerService } = GlobalComponents;
  const userContext = null;
  return (
    <DescriptionList className={styles.headerList} size="small" col="4">
      <Description term="ID" style={{ wordBreak: 'break-all' }}>
        {chainCodeInvoker.id}
      </Description>
      <Description term="应用客户端">
        {chainCodeInvoker.appClient == null
          ? appLocaleName(userContext, 'NotAssigned')
          : `${chainCodeInvoker.appClient.displayName}(${chainCodeInvoker.appClient.id})`}
        <Icon
          type="swap"
          onClick={() =>
            showTransferModel(
              targetComponent,
              '应用客户端',
              'application',
              ChainCodeInvokerService.requestCandidateAppClient,
              ChainCodeInvokerService.transferToAnotherAppClient,
              'anotherAppClientId',
              chainCodeInvoker.appClient ? chainCodeInvoker.appClient.id : ''
            )
          }
          style={{ fontSize: 20, color: 'red' }}
        />
      </Description>
      <Description term="链码">
        {chainCodeInvoker.chainCode == null
          ? appLocaleName(userContext, 'NotAssigned')
          : `${chainCodeInvoker.chainCode.displayName}(${chainCodeInvoker.chainCode.id})`}
        <Icon
          type="swap"
          onClick={() =>
            showTransferModel(
              targetComponent,
              '链码',
              'chainCode',
              ChainCodeInvokerService.requestCandidateChainCode,
              ChainCodeInvokerService.transferToAnotherChainCode,
              'anotherChainCodeId',
              chainCodeInvoker.chainCode ? chainCodeInvoker.chainCode.id : ''
            )
          }
          style={{ fontSize: 20, color: 'red' }}
        />
      </Description>
      <Description term="变更请求">
        {chainCodeInvoker.changeRequest == null
          ? appLocaleName(userContext, 'NotAssigned')
          : `${chainCodeInvoker.changeRequest.displayName}(${chainCodeInvoker.changeRequest.id})`}
        <Icon
          type="swap"
          onClick={() =>
            showTransferModel(
              targetComponent,
              '变更请求',
              'changeRequest',
              ChainCodeInvokerService.requestCandidateChangeRequest,
              ChainCodeInvokerService.transferToAnotherChangeRequest,
              'anotherChangeRequestId',
              chainCodeInvoker.changeRequest ? chainCodeInvoker.changeRequest.id : ''
            )
          }
          style={{ fontSize: 20, color: 'red' }}
        />
      </Description>

      {buildTransferModal(chainCodeInvoker, targetComponent)}
    </DescriptionList>
  );
};

const internalQuickFunctions = defaultQuickFunctions;

class ChainCodeInvokerDashboard extends Component {
  state = {
    transferModalVisiable: false,
    candidateReferenceList: {},
    candidateServiceName: '',
    candidateObjectType: 'city',
    targetLocalName: '',
    transferServiceName: '',
    currentValue: '',
    transferTargetParameterName: '',
    defaultType: 'chainCodeInvoker',
  };
  componentDidMount() {}

  render() {
    // eslint-disable-next-line max-len
    const { id, displayName } = this.props.chainCodeInvoker;
    if (!this.props.chainCodeInvoker.class) {
      return null;
    }
    const returnURL = this.props.returnURL;

    const cardsData = {
      cardsName: '链代码调用程序',
      cardsFor: 'chainCodeInvoker',
      cardsSource: this.props.chainCodeInvoker,
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
  chainCodeInvoker: state._chainCodeInvoker,
  returnURL: state.breadcrumb.returnURL,
}))(Form.create()(ChainCodeInvokerDashboard));
