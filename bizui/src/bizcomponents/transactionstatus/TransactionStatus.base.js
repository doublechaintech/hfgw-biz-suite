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
  menuName: window.trans('transaction_status'),
  menuFor: 'transactionStatus',
  subItems: [
    {
      name: 'serviceRecordList',
      displayName: window.mtrans('service_record', 'transaction_status.service_record_list', false),
      type: 'serviceRecord',
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
  menuName: window.trans('transaction_status'),
  menuFor: 'transactionStatus',
  subItems: [],
};

const fieldLabels = {
  id: window.trans('transaction_status.id'),
  name: window.trans('transaction_status.name'),
  code: window.trans('transaction_status.code'),
  network: window.trans('transaction_status.network'),
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

const searchLocalData = (targetObject, searchTerm) =>
  defaultSearchLocalData(menuData, targetObject, searchTerm);

const renderItemOfList = (transactionStatus, targetComponent) => {
  const userContext = null;
  return (
    <div key={transactionStatus.id}>
      <DescriptionList key={transactionStatus.id} size="small" col="2">
        <Description term={fieldLabels.id} style={{ wordBreak: 'break-all' }}>
          {transactionStatus.id}
        </Description>
        <Description term={fieldLabels.name} style={{ wordBreak: 'break-all' }}>
          {transactionStatus.name}
        </Description>
        <Description term={fieldLabels.code} style={{ wordBreak: 'break-all' }}>
          {transactionStatus.code}
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
const TransactionStatusBase = {
  menuData,
  displayColumns,
  fieldLabels,
  renderItemOfList,
  stepOf,
  searchLocalData,
};
export default TransactionStatusBase;
