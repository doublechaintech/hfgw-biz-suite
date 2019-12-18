import React from 'react';
import { Icon, Divider, Avata, Card, Col } from 'antd';

import { Link } from 'dva/router';
import moment from 'moment';
import ImagePreview from '../../components/ImagePreview';
import appLocaleName from '../../common/Locale.tool';
import BaseTool from '../../common/Base.tool';
import GlobalComponents from '../../custcomponents';
import DescriptionList from '../../components/DescriptionList';
const { Description } = DescriptionList;

const {
  defaultRenderReferenceCell,
  defaultRenderBooleanCell,
  defaultRenderMoneyCell,
  defaultRenderDateTimeCell,
  defaultRenderImageCell,
  defaultRenderAvatarCell,
  defaultRenderDateCell,
  defaultRenderIdentifier,
  defaultRenderTextCell,
  defaultSearchLocalData,
} = BaseTool;

const renderTextCell = defaultRenderTextCell;
const renderIdentifier = defaultRenderIdentifier;
const renderDateCell = defaultRenderDateCell;
const renderDateTimeCell = defaultRenderDateTimeCell;
const renderImageCell = defaultRenderImageCell;
const renderAvatarCell = defaultRenderAvatarCell;
const renderMoneyCell = defaultRenderMoneyCell;
const renderBooleanCell = defaultRenderBooleanCell;
const renderReferenceCell = defaultRenderReferenceCell;

const menuData = {
  menuName: window.trans('hyperledger_network'),
  menuFor: 'hyperledgerNetwork',
  subItems: [
    {
      name: 'organizationList',
      displayName: window.mtrans('organization', 'hyperledger_network.organization_list', false),
      type: 'organization',
      icon: 'at',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
      viewGroup: '__no_group',
    },
    {
      name: 'nodeList',
      displayName: window.mtrans('node', 'hyperledger_network.node_list', false),
      type: 'node',
      icon: 'node',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
      viewGroup: '__no_group',
    },
    {
      name: 'channelList',
      displayName: window.mtrans('channel', 'hyperledger_network.channel_list', false),
      type: 'channel',
      icon: '500px',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
      viewGroup: '__no_group',
    },
    {
      name: 'applicationList',
      displayName: window.mtrans('application', 'hyperledger_network.application_list', false),
      type: 'application',
      icon: 'at',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
      viewGroup: '__no_group',
    },
    {
      name: 'serviceRecordList',
      displayName: window.mtrans(
        'service_record',
        'hyperledger_network.service_record_list',
        false
      ),
      type: 'serviceRecord',
      icon: 'servicestack',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
      viewGroup: '__no_group',
    },
    {
      name: 'changeRequestList',
      displayName: window.mtrans(
        'change_request',
        'hyperledger_network.change_request_list',
        false
      ),
      type: 'changeRequest',
      icon: 'exchange-alt',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
      viewGroup: '__no_group',
    },
  ],
};

const settingMenuData = {
  menuName: window.trans('hyperledger_network'),
  menuFor: 'hyperledgerNetwork',
  subItems: [
    {
      name: 'nodeTypeList',
      displayName: window.mtrans('node_type', 'hyperledger_network.node_type_list', false),
      type: 'nodeType',
      icon: 'node',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
      viewGroup: '__no_group',
    },
    {
      name: 'peerRoleList',
      displayName: window.mtrans('peer_role', 'hyperledger_network.peer_role_list', false),
      type: 'peerRole',
      icon: '500px',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
      viewGroup: '__no_group',
    },
    {
      name: 'transactionStatusList',
      displayName: window.mtrans(
        'transaction_status',
        'hyperledger_network.transaction_status_list',
        false
      ),
      type: 'transactionStatus',
      icon: 'at',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
      viewGroup: '__no_group',
    },
    {
      name: 'changeRequestTypeList',
      displayName: window.mtrans(
        'change_request_type',
        'hyperledger_network.change_request_type_list',
        false
      ),
      type: 'changeRequestType',
      icon: 'exchange-alt',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
      viewGroup: '__no_group',
    },
  ],
};

const fieldLabels = {
  id: window.trans('hyperledger_network.id'),
  name: window.trans('hyperledger_network.name'),
  description: window.trans('hyperledger_network.description'),
};

const displayColumns = [
  {
    title: fieldLabels.id,
    debugtype: 'string',
    dataIndex: 'id',
    width: '8',
    render: (text, record) => renderTextCell(text, record, 'hyperledgerNetwork'),
    sorter: true,
  },
  {
    title: fieldLabels.name,
    debugtype: 'string',
    dataIndex: 'name',
    width: '27',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.description,
    debugtype: 'string_longtext',
    dataIndex: 'description',
    width: '10',
    render: (text, record) => renderTextCell(text, record),
  },
];

const searchLocalData = (targetObject, searchTerm) =>
  defaultSearchLocalData(menuData, targetObject, searchTerm);

const renderItemOfList = (hyperledgerNetwork, targetComponent) => {
  const userContext = null;
  return (
    <div key={hyperledgerNetwork.id}>
      <DescriptionList key={hyperledgerNetwork.id} size="small" col="2">
        <Description term={fieldLabels.id} style={{ wordBreak: 'break-all' }}>
          {hyperledgerNetwork.id}
        </Description>
        <Description term={fieldLabels.name} style={{ wordBreak: 'break-all' }}>
          {hyperledgerNetwork.name}
        </Description>
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
  );
};

const packFormValuesToObject = formValuesToPack => {
  const { name, description } = formValuesToPack;

  const data = { name, description };
  return data;
};
const unpackObjectToFormValues = objectToUnpack => {
  const { name, description } = objectToUnpack;

  const data = { name, description };
  return data;
};
const stepOf = (targetComponent, title, content, position, index) => {
  return {
    title,
    content,
    position,
    packFunction: packFormValuesToObject,
    unpackFunction: unpackObjectToFormValues,
    index,
  };
};
const HyperledgerNetworkBase = {
  menuData,
  displayColumns,
  fieldLabels,
  renderItemOfList,
  stepOf,
  searchLocalData,
};
export default HyperledgerNetworkBase;
