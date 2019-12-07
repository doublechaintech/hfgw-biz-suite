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
  menuName: window.trans('peer_role'),
  menuFor: 'peerRole',
  subItems: [
    {
      name: 'channelPeerRoleList',
      displayName: window.mtrans('channel_peer_role', 'peer_role.channel_peer_role_list', false),
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
  menuName: window.trans('peer_role'),
  menuFor: 'peerRole',
  subItems: [],
};

const fieldLabels = {
  id: window.trans('peer_role.id'),
  name: window.trans('peer_role.name'),
  code: window.trans('peer_role.code'),
  network: window.trans('peer_role.network'),
};

const displayColumns = [
  {
    title: fieldLabels.id,
    debugtype: 'string',
    dataIndex: 'id',
    width: '8',
    render: (text, record) => renderTextCell(text, record, 'peerRole'),
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
    title: fieldLabels.code,
    debugtype: 'string',
    dataIndex: 'code',
    width: '18',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.network,
    dataIndex: 'network',
    render: (text, record) => renderReferenceCell(text, record),
    sorter: true,
  },
];

const searchLocalData = (targetObject, searchTerm) =>
  defaultSearchLocalData(menuData, targetObject, searchTerm);

const renderItemOfList = (peerRole, targetComponent) => {
  const userContext = null;
  return (
    <div key={peerRole.id}>
      <DescriptionList key={peerRole.id} size="small" col="2">
        <Description term={fieldLabels.id} style={{ wordBreak: 'break-all' }}>
          {peerRole.id}
        </Description>
        <Description term={fieldLabels.name} style={{ wordBreak: 'break-all' }}>
          {peerRole.name}
        </Description>
        <Description term={fieldLabels.code} style={{ wordBreak: 'break-all' }}>
          {peerRole.code}
        </Description>
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
  );
};

const packFormValuesToObject = formValuesToPack => {
  const { name, code, networkId } = formValuesToPack;
  const network = { id: networkId, version: 2 ^ 31 };
  const data = { name, code, network };
  return data;
};
const unpackObjectToFormValues = objectToUnpack => {
  const { name, code, network } = objectToUnpack;
  const networkId = network ? network.id : null;
  const data = { name, code, networkId };
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
const PeerRoleBase = {
  menuData,
  displayColumns,
  fieldLabels,
  renderItemOfList,
  stepOf,
  searchLocalData,
};
export default PeerRoleBase;
