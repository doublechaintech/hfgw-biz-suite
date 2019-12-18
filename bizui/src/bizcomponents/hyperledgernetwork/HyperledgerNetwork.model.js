import React from 'react';
import pathToRegexp from 'path-to-regexp';
import { routerRedux } from 'dva/router';
import { notification } from 'antd';
import GlobalComponents from '../../custcomponents';
import appLocaleName from '../../common/Locale.tool';
import modeltool from '../../utils/modeltool';
const {
  setupModel,
  hasError,
  handleClientError,
  handleServerError,
  keepValueWithKeySuffix,
} = modeltool;

const notifySuccess = userContext => {
  notification.success({
    message: appLocaleName(userContext, 'Success'),
    description: appLocaleName(userContext, 'Success'),
  });
};

export default {
  namespace: '_hyperledgerNetwork',

  state: {},

  subscriptions: {
    setup({ dispatch, history }) {
      history.listen(location => {
        const modelName = 'hyperledgerNetwork';
        const parameter = { dispatch, history, location, modelName };
        //console.log("setupModel",setupModel,typeof(setupModel))
        setupModel(parameter);
      });
    },
  },
  effects: {
    *view({ payload }, { call, put, select }) {
      const cachedData = yield select(state => state._hyperledgerNetwork);
      //if the data in the cache, just show it, there is no delay
      const link = payload.pathname;
      //if the data in the cache, just show it, there is no delay
      if (cachedData.class) {
        //yield put({ type: 'breadcrumb/gotoLink', payload: { displayName:cachedData.displayName,link }} )
        yield put({ type: 'updateState', payload: cachedData });

        if (payload.useCache) {
          return; //use cache for returning page
        }
      } else {
        yield put({ type: 'showLoading', payload });
      }

      const { HyperledgerNetworkService } = GlobalComponents;
      const data = yield call(HyperledgerNetworkService.view, payload.id);

      const displayName = payload.displayName || data.displayName;

      yield put({ type: 'breadcrumb/gotoLink', payload: { displayName, link } });

      yield put({ type: 'updateState', payload: data });
    },
    *load({ payload }, { call, put }) {
      const { HyperledgerNetworkService } = GlobalComponents;
      //yield put({ type: 'showLoading', payload })
      const data = yield call(HyperledgerNetworkService.load, payload.id, payload.parameters);
      const newPlayload = { ...payload, ...data };

      console.log('this is the data id: ', data.id);
      yield put({ type: 'updateState', payload: newPlayload });
    },

    *doJob({ payload }, { call, put }) {
      const userContext = null;
      const { TaskService } = GlobalComponents;
      //yield put({ type: 'showLoading', payload })
      const { serviceNameToCall, id, parameters } = payload;
      if (!serviceNameToCall) {
        handleClientError(appLocaleName(userContext, 'ServiceNotRegistered'));
        return;
      }
      ('react/dva_object_model.jsp');

      const data = yield call(serviceNameToCall, id, parameters);
      if (handleServerError(data)) {
        return;
      }
      const newPlayload = { ...payload, ...data };

      console.log('this is the data id: ', data.id);
      yield put({ type: 'updateState', payload: newPlayload });
    },

    *gotoCreateForm({ payload }, { put }) {
      const { id, role } = payload;
      yield put(routerRedux.push(`/hyperledgerNetwork/${id}/list/${role}CreateForm`));
    },
    *gotoUpdateForm({ payload }, { put }) {
      const { id, role, selectedRows, currentUpdateIndex } = payload;
      const state = { id, role, selectedRows, currentUpdateIndex };
      const location = { pathname: `/hyperledgerNetwork/${id}/list/${role}UpdateForm`, state };
      yield put(routerRedux.push(location));
    },
    *goback({ payload }, { put }) {
      const { id, type, listName } = payload;
      yield put(routerRedux.push(`/hyperledgerNetwork/${id}/list/${type}List/${listName}`));
    },

    *addOrganization({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.addOrganization, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hyperledgerNetwork/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/OrganizationList/组织+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
    },
    *updateOrganization({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.updateOrganization, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/OrganizationList/组织列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
    },
    *gotoNextOrganizationUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeOrganizationList({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.removeOrganizationList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addNodeType({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.addNodeType, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hyperledgerNetwork/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/NodeTypeList/节点类型+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
    },
    *updateNodeType({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.updateNodeType, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/NodeTypeList/节点类型列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
    },
    *gotoNextNodeTypeUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeNodeTypeList({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.removeNodeTypeList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addNode({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.addNode, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hyperledgerNetwork/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/NodeList/节点+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
    },
    *updateNode({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.updateNode, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/NodeList/节点列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
    },
    *gotoNextNodeUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeNodeList({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.removeNodeList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addChannel({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.addChannel, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hyperledgerNetwork/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/ChannelList/频道+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
    },
    *updateChannel({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.updateChannel, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/ChannelList/频道列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
    },
    *gotoNextChannelUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeChannelList({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.removeChannelList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addPeerRole({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.addPeerRole, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hyperledgerNetwork/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/PeerRoleList/对等的角色+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
    },
    *updatePeerRole({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.updatePeerRole, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/PeerRoleList/对等的角色列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
    },
    *gotoNextPeerRoleUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removePeerRoleList({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.removePeerRoleList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addApplication({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.addApplication, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hyperledgerNetwork/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/ApplicationList/应用程序+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
    },
    *updateApplication({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.updateApplication, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/ApplicationList/应用程序列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
    },
    *gotoNextApplicationUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeApplicationList({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.removeApplicationList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addServiceRecord({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.addServiceRecord, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hyperledgerNetwork/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/ServiceRecordList/服务记录+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
    },
    *updateServiceRecord({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.updateServiceRecord, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/ServiceRecordList/服务记录列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
    },
    *gotoNextServiceRecordUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeServiceRecordList({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.removeServiceRecordList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addTransactionStatus({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.addTransactionStatus, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hyperledgerNetwork/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/TransactionStatusList/交易状态+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
    },
    *updateTransactionStatus({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.updateTransactionStatus, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/TransactionStatusList/交易状态列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
    },
    *gotoNextTransactionStatusUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeTransactionStatusList({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(
        HyperledgerNetworkService.removeTransactionStatusList,
        id,
        parameters
      );
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addChangeRequestType({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.addChangeRequestType, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hyperledgerNetwork/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/ChangeRequestTypeList/变更请求类型+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
    },
    *updateChangeRequestType({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.updateChangeRequestType, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/ChangeRequestTypeList/变更请求类型列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
    },
    *gotoNextChangeRequestTypeUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeChangeRequestTypeList({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(
        HyperledgerNetworkService.removeChangeRequestTypeList,
        id,
        parameters
      );
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addChangeRequest({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.addChangeRequest, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/hyperledgerNetwork/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/ChangeRequestList/变更请求+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
    },
    *updateChangeRequest({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.updateChangeRequest, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const partialList = true;

      const newPlayload = { ...payload, ...data, selectedRows, currentUpdateIndex, partialList };
      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);

      if (continueNext) {
        return;
      }
      const location = {
        pathname: `/hyperledgerNetwork/${id}/list/ChangeRequestList/变更请求列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
    },
    *gotoNextChangeRequestUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeChangeRequestList({ payload }, { call, put }) {
      const userContext = null;
      const { HyperledgerNetworkService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(HyperledgerNetworkService.removeChangeRequestList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },
  },

  reducers: {
    updateState(state, action) {
      const payload = { ...action.payload, loading: true };
      const valueToKeep = keepValueWithKeySuffix(state, 'Parameters');
      return { ...valueToKeep, ...payload };
    },
    showLoading(state, action) {
      // const loading=true
      const payload = { ...action.payload, loading: true };
      const valueToKeep = keepValueWithKeySuffix(state, 'Parameters');
      return { ...valueToKeep, ...payload };
    },
  },
};
