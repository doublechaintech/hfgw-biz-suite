import React, { Component } from 'react';
import { connect } from 'dva';
import moment from 'moment';
import BooleanOption from '../../components/BooleanOption';
import {
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

import DashboardTool from '../../common/Dashboard.tool';
import PageHeaderLayout from '../../layouts/PageHeaderLayout';
import styles from './TransactionStatus.profile.less';
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting';
import appLocaleName from '../../common/Locale.tool';
const { Description } = DescriptionList;
const { defaultRenderExtraHeader } = DashboardTool;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
      {cardsData.cardsName}: {cardsData.displayName}
    </div>
  );
};
const internalSummaryOf = (transactionStatus, targetComponent) => {
  const userContext = null;
  return (
    <DescriptionList className={styles.headerList} size="small" col="4">
      <Description term="ID">{transactionStatus.id}</Description>
      <Description term="名称">{transactionStatus.name}</Description>
      <Description term="代码">{transactionStatus.code}</Description>
    </DescriptionList>
  );
};

const renderPermissionSetting = transactionStatus => {
  const { TransactionStatusBase } = GlobalComponents;
  return (
    <PermissionSetting targetObject={transactionStatus} targetObjectMeta={TransactionStatusBase} />
  );
};

const internalRenderExtraHeader = defaultRenderExtraHeader;

class TransactionStatusPermission extends Component {
  componentDidMount() {}

  render() {
    // eslint-disable-next-line max-len
    const transactionStatus = this.props.transactionStatus;
    const { id, displayName, serviceRecordCount } = transactionStatus;
    const returnURL = `/transactionStatus/${id}/dashboard`;
    const cardsData = {
      cardsName: '交易状态',
      cardsFor: 'transactionStatus',
      cardsSource: transactionStatus,
      displayName,
      returnURL,
      subItems: [],
    };
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader;
    const summaryOf = this.props.summaryOf || internalSummaryOf;

    return (
      <PageHeaderLayout
        title={internalRenderTitle(cardsData, this)}
        content={summaryOf(cardsData.cardsSource, this)}
        wrapperClassName={styles.advancedForm}
      >
        {renderExtraHeader(cardsData.cardsSource)}
        {renderPermissionSetting(cardsData.cardsSource)}
      </PageHeaderLayout>
    );
  }
}

export default connect(state => ({
  transactionStatus: state._transactionStatus,
}))(Form.create()(TransactionStatusPermission));
