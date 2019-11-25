import React, { Component } from 'react';
import { connect } from 'dva';
import moment from 'moment';
import GlobalComponents from '../../custcomponents';
import { Form } from 'antd';
import { Link } from 'dva/router';

import PageHeaderLayout from '../../layouts/PageHeaderLayout';
import styles from './HyperledgerNetwork.profile.less';
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
  return GlobalComponents.HyperledgerNetworkBase.renderItemOfList(item, targetComponents);
};

class HyperledgerNetworkProfile extends Component {
  componentDidMount() {}

  render() {
    // eslint-disable-next-line max-len
    const hyperledgerNetwork = this.props.hyperledgerNetwork;
    const {
      id,
      displayName,
      organizationCount,
      nodeTypeCount,
      nodeCount,
      channelCount,
      peerRoleCount,
      applicationCount,
      serviceRecordCount,
      transactionStatusCount,
      changeRequestTypeCount,
      changeRequestCount,
    } = hyperledgerNetwork;
    const returnURL = `/hyperledgerNetwork/${id}/dashboard`;
    const cardsData = {
      cardsName: 'Hyperledger网络',
      cardsFor: 'hyperledgerNetwork',
      cardsSource: hyperledgerNetwork,
      displayName,
      returnURL,
      subItems: [
        {
          name: 'nodeTypeList',
          displayName: '节点类型',
          type: 'nodeType',
          count: nodeTypeCount,
          addFunction: false,
          role: 'nodeType',
          renderItem: GlobalComponents.NodeTypeBase.renderItemOfList,
        },
        {
          name: 'peerRoleList',
          displayName: '对等的角色',
          type: 'peerRole',
          count: peerRoleCount,
          addFunction: false,
          role: 'peerRole',
          renderItem: GlobalComponents.PeerRoleBase.renderItemOfList,
        },
        {
          name: 'transactionStatusList',
          displayName: '交易状态',
          type: 'transactionStatus',
          count: transactionStatusCount,
          addFunction: false,
          role: 'transactionStatus',
          renderItem: GlobalComponents.TransactionStatusBase.renderItemOfList,
        },
        {
          name: 'changeRequestTypeList',
          displayName: '变更请求类型',
          type: 'changeRequestType',
          count: changeRequestTypeCount,
          addFunction: false,
          role: 'changeRequestType',
          renderItem: GlobalComponents.ChangeRequestTypeBase.renderItemOfList,
        },
      ],
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
  hyperledgerNetwork: state._hyperledgerNetwork,
}))(Form.create()(HyperledgerNetworkProfile));
