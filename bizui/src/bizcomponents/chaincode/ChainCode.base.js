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
  menuName: window.trans('chain_code'),
  menuFor: 'chainCode',
  subItems: [
    {
      name: 'serviceRecordList',
      displayName: window.mtrans('service_record', 'chain_code.service_record_list', false),
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
      displayName: window.mtrans('chain_code_invoker', 'chain_code.chain_code_invoker_list', false),
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
  menuName: window.trans('chain_code'),
  menuFor: 'chainCode',
  subItems: [],
};

const fieldLabels = {
  id: window.trans('chain_code.id'),
  name: window.trans('chain_code.name'),
  codeName: window.trans('chain_code.code_name'),
  codeVersion: window.trans('chain_code.code_version'),
  channel: window.trans('chain_code.channel'),
};

const displayColumns = [
  {
    title: fieldLabels.id,
    debugtype: 'string',
    dataIndex: 'id',
    width: '8',
    render: (text, record) => renderTextCell(text, record, 'chainCode'),
    sorter: true,
  },
  {
    title: fieldLabels.name,
    debugtype: 'string',
    dataIndex: 'name',
    width: '10',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.codeName,
    debugtype: 'string',
    dataIndex: 'codeName',
    width: '8',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.codeVersion,
    debugtype: 'string',
    dataIndex: 'codeVersion',
    width: '6',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.channel,
    dataIndex: 'channel',
    render: (text, record) => renderReferenceCell(text, record),
    sorter: true,
  },
];

const searchLocalData = (targetObject, searchTerm) =>
  defaultSearchLocalData(menuData, targetObject, searchTerm);

const renderItemOfList = (chainCode, targetComponent) => {
  const userContext = null;
  return (
    <div key={chainCode.id}>
      <DescriptionList key={chainCode.id} size="small" col="2">
        <Description term={fieldLabels.id} style={{ wordBreak: 'break-all' }}>
          {chainCode.id}
        </Description>
        <Description term={fieldLabels.name} style={{ wordBreak: 'break-all' }}>
          {chainCode.name}
        </Description>
        <Description term={fieldLabels.codeName} style={{ wordBreak: 'break-all' }}>
          {chainCode.codeName}
        </Description>
        <Description term={fieldLabels.codeVersion} style={{ wordBreak: 'break-all' }}>
          {chainCode.codeVersion}
        </Description>
        <Description term={fieldLabels.channel}>
          <div>
            {chainCode.channel == null
              ? appLocaleName(userContext, 'NotAssigned')
              : `${chainCode.channel.displayName}(${chainCode.channel.id})`}
          </div>
        </Description>
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
  );
};

const packFormValuesToObject = formValuesToPack => {
  const { name, codeName, codeVersion, channelId } = formValuesToPack;
  const channel = { id: channelId, version: 2 ^ 31 };
  const data = { name, codeName, codeVersion, channel };
  return data;
};
const unpackObjectToFormValues = objectToUnpack => {
  const { name, codeName, codeVersion, channel } = objectToUnpack;
  const channelId = channel ? channel.id : null;
  const data = { name, codeName, codeVersion, channelId };
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
const ChainCodeBase = {
  menuData,
  displayColumns,
  fieldLabels,
  renderItemOfList,
  stepOf,
  searchLocalData,
};
export default ChainCodeBase;
