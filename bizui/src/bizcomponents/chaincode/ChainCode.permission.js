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
import styles from './ChainCode.profile.less';
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
const internalSummaryOf = (chainCode, targetComponent) => {
  const userContext = null;
  return (
    <DescriptionList className={styles.headerList} size="small" col="4">
      <Description term="ID">{chainCode.id}</Description>
      <Description term="名称">{chainCode.name}</Description>
      <Description term="代号">{chainCode.codeName}</Description>
      <Description term="代码版本">{chainCode.codeVersion}</Description>
    </DescriptionList>
  );
};

const renderPermissionSetting = chainCode => {
  const { ChainCodeBase } = GlobalComponents;
  return <PermissionSetting targetObject={chainCode} targetObjectMeta={ChainCodeBase} />;
};

const internalRenderExtraHeader = defaultRenderExtraHeader;

class ChainCodePermission extends Component {
  componentDidMount() {}

  render() {
    // eslint-disable-next-line max-len
    const chainCode = this.props.chainCode;
    const { id, displayName, serviceRecordCount, chainCodeInvokerCount } = chainCode;
    const returnURL = `/chainCode/${id}/dashboard`;
    const cardsData = {
      cardsName: '链码',
      cardsFor: 'chainCode',
      cardsSource: chainCode,
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
  chainCode: state._chainCode,
}))(Form.create()(ChainCodePermission));
