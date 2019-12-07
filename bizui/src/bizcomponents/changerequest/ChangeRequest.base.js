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
  menuName: window.trans('change_request'),
  menuFor: 'changeRequest',
  subItems: [
    {
      name: 'chainCodeInvokerList',
      displayName: window.mtrans(
        'chain_code_invoker',
        'change_request.chain_code_invoker_list',
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
  menuName: window.trans('change_request'),
  menuFor: 'changeRequest',
  subItems: [],
};

const fieldLabels = {
  id: window.trans('change_request.id'),
  name: window.trans('change_request.name'),
  createTime: window.trans('change_request.create_time'),
  remoteIp: window.trans('change_request.remote_ip'),
  requestType: window.trans('change_request.request_type'),
  network: window.trans('change_request.network'),
};

const displayColumns = [
  {
    title: fieldLabels.id,
    debugtype: 'string',
    dataIndex: 'id',
    width: '8',
    render: (text, record) => renderTextCell(text, record, 'changeRequest'),
    sorter: true,
  },
  {
    title: fieldLabels.name,
    debugtype: 'string',
    dataIndex: 'name',
    width: '6',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.createTime,
    dataIndex: 'createTime',
    render: (text, record) => renderDateTimeCell(text, record),
    sorter: true,
  },
  {
    title: fieldLabels.remoteIp,
    debugtype: 'string_client_ip',
    dataIndex: 'remoteIp',
    width: '14',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.requestType,
    dataIndex: 'requestType',
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

const renderItemOfList = (changeRequest, targetComponent) => {
  const userContext = null;
  return (
    <div key={changeRequest.id}>
      <DescriptionList key={changeRequest.id} size="small" col="2">
        <Description term={fieldLabels.id} style={{ wordBreak: 'break-all' }}>
          {changeRequest.id}
        </Description>
        <Description term={fieldLabels.name} style={{ wordBreak: 'break-all' }}>
          {changeRequest.name}
        </Description>
        <Description term={fieldLabels.createTime}>
          <div>{moment(changeRequest.createTime).format('YYYY-MM-DD HH:mm')}</div>
        </Description>
        <Description term={fieldLabels.remoteIp} style={{ wordBreak: 'break-all' }}>
          {changeRequest.remoteIp}
        </Description>
        <Description term={fieldLabels.requestType}>
          <div>
            {changeRequest.requestType == null
              ? appLocaleName(userContext, 'NotAssigned')
              : `${changeRequest.requestType.displayName}(${changeRequest.requestType.id})`}
          </div>
        </Description>
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
  );
};

const packFormValuesToObject = formValuesToPack => {
  const { name, requestTypeId, networkId } = formValuesToPack;
  const requestType = { id: requestTypeId, version: 2 ^ 31 };
  const network = { id: networkId, version: 2 ^ 31 };
  const data = { name, requestType, network };
  return data;
};
const unpackObjectToFormValues = objectToUnpack => {
  const { name, requestType, network } = objectToUnpack;
  const requestTypeId = requestType ? requestType.id : null;
  const networkId = network ? network.id : null;
  const data = { name, requestTypeId, networkId };
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
const ChangeRequestBase = {
  menuData,
  displayColumns,
  fieldLabels,
  renderItemOfList,
  stepOf,
  searchLocalData,
};
export default ChangeRequestBase;
