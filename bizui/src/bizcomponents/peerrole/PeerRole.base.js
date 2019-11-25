import React from 'react';
import { Icon, Divider, Avatar } from 'antd';

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
  menuName: '对等的角色',
  menuFor: 'peerRole',
  subItems: [
    {
      name: 'channelPeerRoleList',
      displayName: '通道对等的角色',
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
  menuName: '对等的角色',
  menuFor: 'peerRole',
  subItems: [],
};

const fieldLabels = {
  id: 'ID',
  name: '名称',
  code: '代码',
  network: '网络',
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
// refernce to https://ant.design/components/list-cn/
const renderItemOfList = (peerRole, targetComponent) => {
  const userContext = null;
  return (
    <div key={peerRole.id}>
      <DescriptionList key={peerRole.id} size="small" col="4">
        <Description term="ID">{peerRole.id}</Description>
        <Description term="名称">{peerRole.name}</Description>
        <Description term="代码">{peerRole.code}</Description>
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
const PeerRoleBase = { menuData, displayColumns, fieldLabels, renderItemOfList, stepOf };
export default PeerRoleBase;
