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
  menuName: window.trans('node_type'),
  menuFor: 'nodeType',
  subItems: [
    {
      name: 'nodeList',
      displayName: window.mtrans('node', 'node_type.node_list', false),
      type: 'node',
      icon: 'node',
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
  menuName: window.trans('node_type'),
  menuFor: 'nodeType',
  subItems: [],
};

const fieldLabels = {
  id: window.trans('node_type.id'),
  name: window.trans('node_type.name'),
  code: window.trans('node_type.code'),
  network: window.trans('node_type.network'),
};

const displayColumns = [
  {
    title: fieldLabels.id,
    debugtype: 'string',
    dataIndex: 'id',
    width: '8',
    render: (text, record) => renderTextCell(text, record, 'nodeType'),
    sorter: true,
  },
  {
    title: fieldLabels.name,
    debugtype: 'string',
    dataIndex: 'name',
    width: '11',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.code,
    debugtype: 'string',
    dataIndex: 'code',
    width: '11',
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

const renderItemOfList = (nodeType, targetComponent) => {
  const userContext = null;
  return (
    <div key={nodeType.id}>
      <DescriptionList key={nodeType.id} size="small" col="2">
        <Description term={fieldLabels.id} style={{ wordBreak: 'break-all' }}>
          {nodeType.id}
        </Description>
        <Description term={fieldLabels.name} style={{ wordBreak: 'break-all' }}>
          {nodeType.name}
        </Description>
        <Description term={fieldLabels.code} style={{ wordBreak: 'break-all' }}>
          {nodeType.code}
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
const NodeTypeBase = {
  menuData,
  displayColumns,
  fieldLabels,
  renderItemOfList,
  stepOf,
  searchLocalData,
};
export default NodeTypeBase;
