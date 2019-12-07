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
  menuName: window.trans('login_history'),
  menuFor: 'loginHistory',
  subItems: [],
};

const settingMenuData = {
  menuName: window.trans('login_history'),
  menuFor: 'loginHistory',
  subItems: [],
};

const fieldLabels = {
  id: window.trans('login_history.id'),
  loginTime: window.trans('login_history.login_time'),
  fromIp: window.trans('login_history.from_ip'),
  description: window.trans('login_history.description'),
  secUser: window.trans('login_history.sec_user'),
};

const displayColumns = [
  {
    title: fieldLabels.id,
    debugtype: 'string',
    dataIndex: 'id',
    width: '8',
    render: (text, record) => renderTextCell(text, record, 'loginHistory'),
    sorter: true,
  },
  {
    title: fieldLabels.loginTime,
    dataIndex: 'loginTime',
    render: (text, record) => renderDateTimeCell(text, record),
    sorter: true,
  },
  {
    title: fieldLabels.fromIp,
    debugtype: 'string',
    dataIndex: 'fromIp',
    width: '15',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.description,
    debugtype: 'string',
    dataIndex: 'description',
    width: '8',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: fieldLabels.secUser,
    dataIndex: 'secUser',
    render: (text, record) => renderReferenceCell(text, record),
    sorter: true,
  },
];

const searchLocalData = (targetObject, searchTerm) =>
  defaultSearchLocalData(menuData, targetObject, searchTerm);

const renderItemOfList = (loginHistory, targetComponent) => {
  const userContext = null;
  return (
    <div key={loginHistory.id}>
      <DescriptionList key={loginHistory.id} size="small" col="2">
        <Description term={fieldLabels.id} style={{ wordBreak: 'break-all' }}>
          {loginHistory.id}
        </Description>
        <Description term={fieldLabels.loginTime}>
          <div>{moment(loginHistory.loginTime).format('YYYY-MM-DD HH:mm')}</div>
        </Description>
        <Description term={fieldLabels.fromIp} style={{ wordBreak: 'break-all' }}>
          {loginHistory.fromIp}
        </Description>
        <Description term={fieldLabels.description} style={{ wordBreak: 'break-all' }}>
          {loginHistory.description}
        </Description>
        <Description term={fieldLabels.secUser}>
          <div>
            {loginHistory.secUser == null
              ? appLocaleName(userContext, 'NotAssigned')
              : `${loginHistory.secUser.displayName}(${loginHistory.secUser.id})`}
          </div>
        </Description>
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
  );
};

const packFormValuesToObject = formValuesToPack => {
  const { fromIp, description, secUserId } = formValuesToPack;
  const secUser = { id: secUserId, version: 2 ^ 31 };
  const data = { fromIp, description, secUser };
  return data;
};
const unpackObjectToFormValues = objectToUnpack => {
  const { fromIp, description, secUser } = objectToUnpack;
  const secUserId = secUser ? secUser.id : null;
  const data = { fromIp, description, secUserId };
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
const LoginHistoryBase = {
  menuData,
  displayColumns,
  fieldLabels,
  renderItemOfList,
  stepOf,
  searchLocalData,
};
export default LoginHistoryBase;
