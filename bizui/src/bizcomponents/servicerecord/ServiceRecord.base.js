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
  menuName: window.trans('service_record'),
  menuFor: 'serviceRecord',
  subItems: [],
};

const settingMenuData = {
  menuName: window.trans('service_record'),
  menuFor: 'serviceRecord',
  subItems: [],
};

const fieldLabels = {
  id: window.trans('service_record.id'),
  transactionId: window.trans('service_record.transaction_id'),
  name: window.trans('service_record.name'),
  payload: window.trans('service_record.payload'),
  channel: window.trans('service_record.channel'),
  chainCode: window.trans('service_record.chain_code'),
  chainCodeFunction: window.trans('service_record.chain_code_function'),
  blockId: window.trans('service_record.block_id'),
  createTime: window.trans('service_record.create_time'),
  appClient: window.trans('service_record.app_client'),
  network: window.trans('service_record.network'),
  response: window.trans('service_record.response'),
  status: window.trans('service_record.status'),
};

const displayColumns = [
  {
    title: fieldLabels.id,
    debugtype: 'string',
    dataIndex: 'id',
    width: '8',
    render: (text, record) => renderTextCell(text, record, 'serviceRecord'),
    sorter: true,
  },
  {
    title: fieldLabels.transactionId,
    debugtype: 'string',
    dataIndex: 'transactionId',
    width: '13',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.name,
    debugtype: 'string',
    dataIndex: 'name',
    width: '8',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.payload,
    debugtype: 'string_longtext',
    dataIndex: 'payload',
    width: '10',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.channel,
    dataIndex: 'channel',
    render: (text, record) => renderReferenceCell(text, record),
    sorter: true,
  },
  {
    title: fieldLabels.chainCode,
    dataIndex: 'chainCode',
    render: (text, record) => renderReferenceCell(text, record),
    sorter: true,
  },
  {
    title: fieldLabels.chainCodeFunction,
    debugtype: 'string',
    dataIndex: 'chainCodeFunction',
    width: '12',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.blockId,
    debugtype: 'string',
    dataIndex: 'blockId',
    width: '13',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.createTime,
    dataIndex: 'createTime',
    render: (text, record) => renderDateTimeCell(text, record),
    sorter: true,
  },
  {
    title: fieldLabels.appClient,
    dataIndex: 'appClient',
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
    title: fieldLabels.response,
    debugtype: 'string_longtext',
    dataIndex: 'response',
    width: '10',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.status,
    dataIndex: 'status',
    render: (text, record) => renderReferenceCell(text, record),
    sorter: true,
  },
];

const searchLocalData = (targetObject, searchTerm) =>
  defaultSearchLocalData(menuData, targetObject, searchTerm);

const renderItemOfList = (serviceRecord, targetComponent) => {
  const userContext = null;
  return (
    <div key={serviceRecord.id}>
      <DescriptionList key={serviceRecord.id} size="small" col="2">
        <Description term={fieldLabels.id} style={{ wordBreak: 'break-all' }}>
          {serviceRecord.id}
        </Description>
        <Description term={fieldLabels.transactionId} style={{ wordBreak: 'break-all' }}>
          {serviceRecord.transactionId}
        </Description>
        <Description term={fieldLabels.name} style={{ wordBreak: 'break-all' }}>
          {serviceRecord.name}
        </Description>
        <Description term={fieldLabels.channel}>
          <div>
            {serviceRecord.channel == null
              ? appLocaleName(userContext, 'NotAssigned')
              : `${serviceRecord.channel.displayName}(${serviceRecord.channel.id})`}
          </div>
        </Description>
        <Description term={fieldLabels.chainCode}>
          <div>
            {serviceRecord.chainCode == null
              ? appLocaleName(userContext, 'NotAssigned')
              : `${serviceRecord.chainCode.displayName}(${serviceRecord.chainCode.id})`}
          </div>
        </Description>
        <Description term={fieldLabels.chainCodeFunction} style={{ wordBreak: 'break-all' }}>
          {serviceRecord.chainCodeFunction}
        </Description>
        <Description term={fieldLabels.blockId} style={{ wordBreak: 'break-all' }}>
          {serviceRecord.blockId}
        </Description>
        <Description term={fieldLabels.createTime}>
          <div>{moment(serviceRecord.createTime).format('YYYY-MM-DD HH:mm')}</div>
        </Description>
        <Description term={fieldLabels.appClient}>
          <div>
            {serviceRecord.appClient == null
              ? appLocaleName(userContext, 'NotAssigned')
              : `${serviceRecord.appClient.displayName}(${serviceRecord.appClient.id})`}
          </div>
        </Description>
        <Description term={fieldLabels.status}>
          <div>
            {serviceRecord.status == null
              ? appLocaleName(userContext, 'NotAssigned')
              : `${serviceRecord.status.displayName}(${serviceRecord.status.id})`}
          </div>
        </Description>
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
  );
};

const packFormValuesToObject = formValuesToPack => {
  const {
    transactionId,
    name,
    chainCodeFunction,
    blockId,
    channelId,
    chainCodeId,
    appClientId,
    networkId,
    statusId,
    payload,
    response,
  } = formValuesToPack;
  const channel = { id: channelId, version: 2 ^ 31 };
  const chainCode = { id: chainCodeId, version: 2 ^ 31 };
  const appClient = { id: appClientId, version: 2 ^ 31 };
  const network = { id: networkId, version: 2 ^ 31 };
  const status = { id: statusId, version: 2 ^ 31 };
  const data = {
    transactionId,
    name,
    chainCodeFunction,
    blockId,
    channel,
    chainCode,
    appClient,
    network,
    status,
    payload,
    response,
  };
  return data;
};
const unpackObjectToFormValues = objectToUnpack => {
  const {
    transactionId,
    name,
    chainCodeFunction,
    blockId,
    channel,
    chainCode,
    appClient,
    network,
    status,
    payload,
    response,
  } = objectToUnpack;
  const channelId = channel ? channel.id : null;
  const chainCodeId = chainCode ? chainCode.id : null;
  const appClientId = appClient ? appClient.id : null;
  const networkId = network ? network.id : null;
  const statusId = status ? status.id : null;
  const data = {
    transactionId,
    name,
    chainCodeFunction,
    blockId,
    channelId,
    chainCodeId,
    appClientId,
    networkId,
    statusId,
    payload,
    response,
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
const ServiceRecordBase = {
  menuData,
  displayColumns,
  fieldLabels,
  renderItemOfList,
  stepOf,
  searchLocalData,
};
export default ServiceRecordBase;
