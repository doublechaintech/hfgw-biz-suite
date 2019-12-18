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
  menuName: window.trans('chain_code_invoker'),
  menuFor: 'chainCodeInvoker',
  subItems: [],
};

const settingMenuData = {
  menuName: window.trans('chain_code_invoker'),
  menuFor: 'chainCodeInvoker',
  subItems: [],
};

const fieldLabels = {
  id: window.trans('chain_code_invoker.id'),
  appClient: window.trans('chain_code_invoker.app_client'),
  chainCode: window.trans('chain_code_invoker.chain_code'),
  parameters: window.trans('chain_code_invoker.parameters'),
  changeRequest: window.trans('chain_code_invoker.change_request'),
};

const displayColumns = [
  {
    title: fieldLabels.id,
    debugtype: 'string',
    dataIndex: 'id',
    width: '8',
    render: (text, record) => renderTextCell(text, record, 'chainCodeInvoker'),
    sorter: true,
  },
  {
    title: fieldLabels.appClient,
    dataIndex: 'appClient',
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
    title: fieldLabels.parameters,
    debugtype: 'string_longtext',
    dataIndex: 'parameters',
    width: '10',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.changeRequest,
    dataIndex: 'changeRequest',
    render: (text, record) => renderReferenceCell(text, record),
    sorter: true,
  },
];

const searchLocalData = (targetObject, searchTerm) =>
  defaultSearchLocalData(menuData, targetObject, searchTerm);

const renderItemOfList = (chainCodeInvoker, targetComponent) => {
  const userContext = null;
  return (
    <div key={chainCodeInvoker.id}>
      <DescriptionList key={chainCodeInvoker.id} size="small" col="2">
        <Description term={fieldLabels.id} style={{ wordBreak: 'break-all' }}>
          {chainCodeInvoker.id}
        </Description>
        <Description term={fieldLabels.appClient}>
          <div>
            {chainCodeInvoker.appClient == null
              ? appLocaleName(userContext, 'NotAssigned')
              : `${chainCodeInvoker.appClient.displayName}(${chainCodeInvoker.appClient.id})`}
          </div>
        </Description>
        <Description term={fieldLabels.chainCode}>
          <div>
            {chainCodeInvoker.chainCode == null
              ? appLocaleName(userContext, 'NotAssigned')
              : `${chainCodeInvoker.chainCode.displayName}(${chainCodeInvoker.chainCode.id})`}
          </div>
        </Description>
        <Description term={fieldLabels.changeRequest}>
          <div>
            {chainCodeInvoker.changeRequest == null
              ? appLocaleName(userContext, 'NotAssigned')
              : `${chainCodeInvoker.changeRequest.displayName}(${
                  chainCodeInvoker.changeRequest.id
                })`}
          </div>
        </Description>
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
  );
};

const packFormValuesToObject = formValuesToPack => {
  const { appClientId, chainCodeId, changeRequestId, parameters } = formValuesToPack;
  const appClient = { id: appClientId, version: 2 ^ 31 };
  const chainCode = { id: chainCodeId, version: 2 ^ 31 };
  const changeRequest = { id: changeRequestId, version: 2 ^ 31 };
  const data = { appClient, chainCode, changeRequest, parameters };
  return data;
};
const unpackObjectToFormValues = objectToUnpack => {
  const { appClient, chainCode, changeRequest, parameters } = objectToUnpack;
  const appClientId = appClient ? appClient.id : null;
  const chainCodeId = chainCode ? chainCode.id : null;
  const changeRequestId = changeRequest ? changeRequest.id : null;
  const data = { appClientId, chainCodeId, changeRequestId, parameters };
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
const ChainCodeInvokerBase = {
  menuData,
  displayColumns,
  fieldLabels,
  renderItemOfList,
  stepOf,
  searchLocalData,
};
export default ChainCodeInvokerBase;
