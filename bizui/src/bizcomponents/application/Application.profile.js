import React, { Component } from 'react';
import { connect } from 'dva';
import moment from 'moment';
import GlobalComponents from '../../custcomponents';
import { Form } from 'antd';
import { Link } from 'dva/router';

import PageHeaderLayout from '../../layouts/PageHeaderLayout';
import styles from './Application.profile.less';
import DescriptionList from '../../components/DescriptionList';

import DashboardTool from '../../common/Dashboard.tool';
import appLocaleName from '../../common/Locale.tool';

const { defaultRenderExtraHeader, defaultSubListsOf, defaultRenderSettingList } = DashboardTool;

const { Description } = DescriptionList;

const internalRenderExtraHeader = defaultRenderExtraHeader;

const internalSubListsOf = defaultSubListsOf;

const internalRenderSettingList = defaultRenderSettingList;

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

const internalSummaryOf = (item, targetComponents) => {
  return GlobalComponents.ApplicationBase.renderItemOfList(item, targetComponents);
};

class ApplicationProfile extends Component {
  componentDidMount() {}

  render() {
    // eslint-disable-next-line max-len
    const application = this.props.application;
    const { id, displayName, serviceRecordCount, chainCodeInvokerCount } = application;
    const returnURL = `/application/${id}/dashboard`;
    const cardsData = {
      cardsName: '应用程序',
      cardsFor: 'application',
      cardsSource: application,
      displayName,
      returnURL,
      subItems: [],
    };

    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader;

    const summaryOf = this.props.summaryOf || internalSummaryOf;
    const renderSettingList = this.props.renderSettingList || internalRenderSettingList;

    return (
      <PageHeaderLayout
        title={internalRenderTitle(cardsData, this)}
        content={summaryOf(cardsData.cardsSource, this)}
        wrapperClassName={styles.advancedForm}
      >
        {renderExtraHeader(cardsData.cardsSource)}
        {renderSettingList(cardsData)}
      </PageHeaderLayout>
    );
  }
}

export default connect(state => ({
  application: state._application,
}))(Form.create()(ApplicationProfile));
