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
  namespace: '_application',

  state: {},

  subscriptions: {
    setup({ dispatch, history }) {
      history.listen(location => {
        const modelName = 'application';
        const parameter = { dispatch, history, location, modelName };
        //console.log("setupModel",setupModel,typeof(setupModel))
        setupModel(parameter);
      });
    },
  },
  effects: {
    *view({ payload }, { call, put, select }) {
      const cachedData = yield select(state => state._application);
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

      const { ApplicationService } = GlobalComponents;
      const data = yield call(ApplicationService.view, payload.id);

      const displayName = payload.displayName || data.displayName;

      yield put({ type: 'breadcrumb/gotoLink', payload: { displayName, link } });

      yield put({ type: 'updateState', payload: data });
    },
    *load({ payload }, { call, put }) {
      const { ApplicationService } = GlobalComponents;
      //yield put({ type: 'showLoading', payload })
      const data = yield call(ApplicationService.load, payload.id, payload.parameters);
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
      yield put(routerRedux.push(`/application/${id}/list/${role}CreateForm`));
    },
    *gotoUpdateForm({ payload }, { put }) {
      const { id, role, selectedRows, currentUpdateIndex } = payload;
      const state = { id, role, selectedRows, currentUpdateIndex };
      const location = { pathname: `/application/${id}/list/${role}UpdateForm`, state };
      yield put(routerRedux.push(location));
    },
    *goback({ payload }, { put }) {
      const { id, type, listName } = payload;
      yield put(routerRedux.push(`/application/${id}/list/${type}List/${listName}`));
    },

    *addServiceRecord({ payload }, { call, put }) {
      const userContext = null;
      const { ApplicationService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(ApplicationService.addServiceRecord, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/application/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/application/${id}/list/ServiceRecordList/服务记录+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
    },
    *updateServiceRecord({ payload }, { call, put }) {
      const userContext = null;
      const { ApplicationService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(ApplicationService.updateServiceRecord, id, parameters);
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
        pathname: `/application/${id}/list/ServiceRecordList/服务记录列表`,
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
      const { ApplicationService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(ApplicationService.removeServiceRecordList, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };

      yield put({ type: 'updateState', payload: newPlayload });
      notifySuccess(userContext);
    },

    *addChainCodeInvoker({ payload }, { call, put }) {
      const userContext = null;
      const { ApplicationService } = GlobalComponents;

      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(ApplicationService.addChainCodeInvoker, id, parameters);
      if (hasError(data)) {
        handleServerError(data);
        return;
      }
      const newPlayload = { ...payload, ...data };
      yield put({ type: 'updateState', payload: newPlayload });
      // yield put(routerRedux.push(`/application/${id}/list/${role}CreateForm'))
      notifySuccess(userContext);
      if (continueNext) {
        return;
      }
      const partialList = true;
      const newState = { ...data, partialList };
      const location = {
        pathname: `/application/${id}/list/ChainCodeInvokerList/链代码调用程序+${appLocaleName(
          userContext,
          'List'
        )}`,
        state: newState,
      };
      yield put(routerRedux.push(location));
    },
    *updateChainCodeInvoker({ payload }, { call, put }) {
      const userContext = null;
      const { ApplicationService } = GlobalComponents;
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(ApplicationService.updateChainCodeInvoker, id, parameters);
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
        pathname: `/application/${id}/list/ChainCodeInvokerList/链代码调用程序列表`,
        state: newPlayload,
      };
      yield put(routerRedux.push(location));
    },
    *gotoNextChainCodeInvokerUpdateRow({ payload }, { call, put }) {
      const { id, type, parameters, continueNext, selectedRows, currentUpdateIndex } = payload;
      const newPlayload = { ...payload, selectedRows, currentUpdateIndex };
      yield put({ type: 'updateState', payload: newPlayload });
    },
    *removeChainCodeInvokerList({ payload }, { call, put }) {
      const userContext = null;
      const { ApplicationService } = GlobalComponents;
      const { id, role, parameters, continueNext } = payload;
      console.log('get form parameters', parameters);
      const data = yield call(ApplicationService.removeChainCodeInvokerList, id, parameters);
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
