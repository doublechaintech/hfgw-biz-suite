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
  menuName: '服务记录',
  menuFor: 'serviceRecord',
  subItems: [],
};

const settingMenuData = {
  menuName: '服务记录',
  menuFor: 'serviceRecord',
  subItems: [],
};

const fieldLabels = {
  id: 'ID',
  name: '名称',
  payload: '有效载荷',
  channel: '频道',
  chainCode: '链码',
  chainCodeFunction: '链码功能',
  transactionId: '事务Id',
  blockId: '块Id',
  createTime: '创建时间',
  appClient: '应用客户端',
  network: '网络',
  response: '响应',
  status: '状态',
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
    title: fieldLabels.transactionId,
    debugtype: 'string',
    dataIndex: 'transactionId',
    width: '13',
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
// refernce to https://ant.design/components/list-cn/
const renderItemOfList = (serviceRecord, targetComponent) => {
  const userContext = null;
  return (
    <div key={serviceRecord.id}>
      <DescriptionList key={serviceRecord.id} size="small" col="4">
        <Description term="ID">{serviceRecord.id}</Description>
        <Description term="名称">{serviceRecord.name}</Description>
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
        <Description term="链码功能">{serviceRecord.chainCodeFunction}</Description>
        <Description term="事务Id">{serviceRecord.transactionId}</Description>
        <Description term="块Id">{serviceRecord.blockId}</Description>
        <Description term="创建时间">
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
    name,
    chainCodeFunction,
    transactionId,
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
    name,
    chainCodeFunction,
    transactionId,
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
    name,
    chainCodeFunction,
    transactionId,
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
    name,
    chainCodeFunction,
    transactionId,
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
const ServiceRecordBase = { menuData, displayColumns, fieldLabels, renderItemOfList, stepOf };
export default ServiceRecordBase;
