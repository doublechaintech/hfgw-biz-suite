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
  menuName: window.trans('application'),
  menuFor: 'application',
  subItems: [
    {
      name: 'serviceRecordList',
      displayName: window.mtrans('service_record', 'application.service_record_list', false),
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
      name: 'chainCodeInvokerList',
      displayName: window.mtrans(
        'chain_code_invoker',
        'application.chain_code_invoker_list',
        false
      ),
      type: 'chainCodeInvoker',
      icon: 'code',
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
  menuName: window.trans('application'),
  menuFor: 'application',
  subItems: [],
};

const fieldLabels = {
  id: window.trans('application.id'),
  name: window.trans('application.name'),
  createTime: window.trans('application.create_time'),
  mspid: window.trans('application.mspid'),
  publicKey: window.trans('application.public_key'),
  privateKey: window.trans('application.private_key'),
  channel: window.trans('application.channel'),
  network: window.trans('application.network'),
};

const displayColumns = [
  {
    title: fieldLabels.id,
    debugtype: 'string',
    dataIndex: 'id',
    width: '8',
    render: (text, record) => renderTextCell(text, record, 'application'),
    sorter: true,
  },
  {
    title: fieldLabels.name,
    debugtype: 'string',
    dataIndex: 'name',
    width: '15',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.createTime,
    dataIndex: 'createTime',
    render: (text, record) => renderDateTimeCell(text, record),
    sorter: true,
  },
  {
    title: fieldLabels.mspid,
    debugtype: 'string',
    dataIndex: 'mspid',
    width: '19',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.publicKey,
    debugtype: 'string_longtext',
    dataIndex: 'publicKey',
    width: '10',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.privateKey,
    debugtype: 'string_longtext',
    dataIndex: 'privateKey',
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
    title: fieldLabels.network,
    dataIndex: 'network',
    render: (text, record) => renderReferenceCell(text, record),
    sorter: true,
  },
];

const searchLocalData = (targetObject, searchTerm) =>
  defaultSearchLocalData(menuData, targetObject, searchTerm);

const renderItemOfList = (application, targetComponent) => {
  const userContext = null;
  return (
    <div key={application.id}>
      <DescriptionList key={application.id} size="small" col="2">
        <Description term={fieldLabels.id} style={{ wordBreak: 'break-all' }}>
          {application.id}
        </Description>
        <Description term={fieldLabels.name} style={{ wordBreak: 'break-all' }}>
          {application.name}
        </Description>
        <Description term={fieldLabels.createTime}>
          <div>{moment(application.createTime).format('YYYY-MM-DD HH:mm')}</div>
        </Description>
        <Description term={fieldLabels.mspid} style={{ wordBreak: 'break-all' }}>
          {application.mspid}
        </Description>
        <Description term={fieldLabels.channel}>
          <div>
            {application.channel == null
              ? appLocaleName(userContext, 'NotAssigned')
              : `${application.channel.displayName}(${application.channel.id})`}
          </div>
        </Description>
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
  );
};

const packFormValuesToObject = formValuesToPack => {
  const { name, mspid, channelId, networkId, publicKey, privateKey } = formValuesToPack;
  const channel = { id: channelId, version: 2 ^ 31 };
  const network = { id: networkId, version: 2 ^ 31 };
  const data = { name, mspid, channel, network, publicKey, privateKey };
  return data;
};
const unpackObjectToFormValues = objectToUnpack => {
  const { name, mspid, channel, network, publicKey, privateKey } = objectToUnpack;
  const channelId = channel ? channel.id : null;
  const networkId = network ? network.id : null;
  const data = { name, mspid, channelId, networkId, publicKey, privateKey };
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
const ApplicationBase = {
  menuData,
  displayColumns,
  fieldLabels,
  renderItemOfList,
  stepOf,
  searchLocalData,
};
export default ApplicationBase;
