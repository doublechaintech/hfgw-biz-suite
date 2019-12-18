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
  menuName: window.trans('node'),
  menuFor: 'node',
  subItems: [
    {
      name: 'grpcOptionList',
      displayName: window.mtrans('grpc_option', 'node.grpc_option_list', false),
      type: 'grpcOption',
      icon: '500px',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
      viewGroup: '__no_group',
    },
    {
      name: 'channelPeerRoleList',
      displayName: window.mtrans('channel_peer_role', 'node.channel_peer_role_list', false),
      type: 'channelPeerRole',
      icon: '500px',
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
  menuName: window.trans('node'),
  menuFor: 'node',
  subItems: [],
};

const fieldLabels = {
  id: window.trans('node.id'),
  name: window.trans('node.name'),
  url: window.trans('node.url'),
  organization: window.trans('node.organization'),
  channel: window.trans('node.channel'),
  network: window.trans('node.network'),
  tlsCacert: window.trans('node.tls_cacert'),
  type: window.trans('node.type'),
  address: window.trans('node.address'),
  contactPerson: window.trans('node.contact_person'),
  contactTelephone: window.trans('node.contact_telephone'),
};

const displayColumns = [
  {
    title: fieldLabels.id,
    debugtype: 'string',
    dataIndex: 'id',
    width: '8',
    render: (text, record) => renderTextCell(text, record, 'node'),
    sorter: true,
  },
  {
    title: fieldLabels.name,
    debugtype: 'string',
    dataIndex: 'name',
    width: '18',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.url,
    debugtype: 'string',
    dataIndex: 'url',
    width: '46',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.organization,
    dataIndex: 'organization',
    render: (text, record) => renderReferenceCell(text, record),
    sorter: true,
  },
  {
    title: fieldLabels.channel,
    dataIndex: 'channel',
    render: (text, record) => renderReferenceCell(text, record),
    sorter: true,
  },
  {
    title: fieldLabels.network,
    dataIndex: 'network',
    render: (text, record) => renderReferenceCell(text, record),
    sorter: true,
  },
  {
    title: fieldLabels.tlsCacert,
    debugtype: 'string_longtext',
    dataIndex: 'tlsCacert',
    width: '10',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.type,
    dataIndex: 'type',
    render: (text, record) => renderReferenceCell(text, record),
    sorter: true,
  },
  {
    title: fieldLabels.address,
    debugtype: 'string',
    dataIndex: 'address',
    width: '17',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.contactPerson,
    debugtype: 'string',
    dataIndex: 'contactPerson',
    width: '6',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.contactTelephone,
    debugtype: 'string',
    dataIndex: 'contactTelephone',
    width: '15',
    render: (text, record) => renderTextCell(text, record),
  },
];

const searchLocalData = (targetObject, searchTerm) =>
  defaultSearchLocalData(menuData, targetObject, searchTerm);

const renderItemOfList = (node, targetComponent) => {
  const userContext = null;
  return (
    <div key={node.id}>
      <DescriptionList key={node.id} size="small" col="2">
        <Description term={fieldLabels.id} style={{ wordBreak: 'break-all' }}>
          {node.id}
        </Description>
        <Description term={fieldLabels.name} style={{ wordBreak: 'break-all' }}>
          {node.name}
        </Description>
        <Description term={fieldLabels.url} style={{ wordBreak: 'break-all' }}>
          {node.url}
        </Description>
        <Description term={fieldLabels.organization}>
          <div>
            {node.organization == null
              ? appLocaleName(userContext, 'NotAssigned')
              : `${node.organization.displayName}(${node.organization.id})`}
          </div>
        </Description>
        <Description term={fieldLabels.channel}>
          <div>
            {node.channel == null
              ? appLocaleName(userContext, 'NotAssigned')
              : `${node.channel.displayName}(${node.channel.id})`}
          </div>
        </Description>
        <Description term={fieldLabels.type}>
          <div>
            {node.type == null
              ? appLocaleName(userContext, 'NotAssigned')
              : `${node.type.displayName}(${node.type.id})`}
          </div>
        </Description>
        <Description term={fieldLabels.address} style={{ wordBreak: 'break-all' }}>
          {node.address}
        </Description>
        <Description term={fieldLabels.contactPerson} style={{ wordBreak: 'break-all' }}>
          {node.contactPerson}
        </Description>
        <Description term={fieldLabels.contactTelephone} style={{ wordBreak: 'break-all' }}>
          {node.contactTelephone}
        </Description>
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
  );
};

const packFormValuesToObject = formValuesToPack => {
  const {
    name,
    url,
    address,
    contactPerson,
    contactTelephone,
    organizationId,
    channelId,
    networkId,
    typeId,
    tlsCacert,
  } = formValuesToPack;
  const organization = { id: organizationId, version: 2 ^ 31 };
  const channel = { id: channelId, version: 2 ^ 31 };
  const network = { id: networkId, version: 2 ^ 31 };
  const type = { id: typeId, version: 2 ^ 31 };
  const data = {
    name,
    url,
    address,
    contactPerson,
    contactTelephone,
    organization,
    channel,
    network,
    type,
    tlsCacert,
  };
  return data;
};
const unpackObjectToFormValues = objectToUnpack => {
  const {
    name,
    url,
    address,
    contactPerson,
    contactTelephone,
    organization,
    channel,
    network,
    type,
    tlsCacert,
  } = objectToUnpack;
  const organizationId = organization ? organization.id : null;
  const channelId = channel ? channel.id : null;
  const networkId = network ? network.id : null;
  const typeId = type ? type.id : null;
  const data = {
    name,
    url,
    address,
    contactPerson,
    contactTelephone,
    organizationId,
    channelId,
    networkId,
    typeId,
    tlsCacert,
  };
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
const NodeBase = {
  menuData,
  displayColumns,
  fieldLabels,
  renderItemOfList,
  stepOf,
  searchLocalData,
};
export default NodeBase;
