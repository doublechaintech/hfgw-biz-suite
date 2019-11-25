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
  menuName: '交易状态',
  menuFor: 'transactionStatus',
  subItems: [
    {
      name: 'serviceRecordList',
      displayName: '服务记录',
      icon: 'servicestack',
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
  menuName: '交易状态',
  menuFor: 'transactionStatus',
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
    render: (text, record) => renderTextCell(text, record, 'transactionStatus'),
    sorter: true,
  },
  {
    title: fieldLabels.name,
    debugtype: 'string',
    dataIndex: 'name',
    width: '13',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.code,
    debugtype: 'string',
    dataIndex: 'code',
    width: '13',
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
const renderItemOfList = (transactionStatus, targetComponent) => {
  const userContext = null;
  return (
    <div key={transactionStatus.id}>
      <DescriptionList key={transactionStatus.id} size="small" col="4">
        <Description term="ID">{transactionStatus.id}</Description>
        <Description term="名称">{transactionStatus.name}</Description>
        <Description term="代码">{transactionStatus.code}</Description>
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
const TransactionStatusBase = { menuData, displayColumns, fieldLabels, renderItemOfList, stepOf };
export default TransactionStatusBase;
