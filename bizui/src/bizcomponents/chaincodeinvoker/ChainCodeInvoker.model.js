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
  namespace: '_chainCodeInvoker',

  state: {},

  subscriptions: {
    setup({ dispatch, history }) {
      history.listen(location => {
        const modelName = 'chainCodeInvoker';
        const parameter = { dispatch, history, location, modelName };
        //console.log("setupModel",setupModel,typeof(setupModel))
        setupModel(parameter);
      });
    },
  },
  effects: {
    *view({ payload }, { call, put, select }) {
      const cachedData = yield select(state => state._chainCodeInvoker);
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

      const { ChainCodeInvokerService } = GlobalComponents;
      const data = yield call(ChainCodeInvokerService.view, payload.id);

      const displayName = payload.displayName || data.displayName;

      yield put({ type: 'breadcrumb/gotoLink', payload: { displayName, link } });

      yield put({ type: 'updateState', payload: data });
    },
    *load({ payload }, { call, put }) {
      const { ChainCodeInvokerService } = GlobalComponents;
      //yield put({ type: 'showLoading', payload })
      const data = yield call(ChainCodeInvokerService.load, payload.id, payload.parameters);
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
      yield put(routerRedux.push(`/chainCodeInvoker/${id}/list/${role}CreateForm`));
    },
    *gotoUpdateForm({ payload }, { put }) {
      const { id, role, selectedRows, currentUpdateIndex } = payload;
      const state = { id, role, selectedRows, currentUpdateIndex };
      const location = { pathname: `/chainCodeInvoker/${id}/list/${role}UpdateForm`, state };
      yield put(routerRedux.push(location));
    },
    *goback({ payload }, { put }) {
      const { id, type, listName } = payload;
      yield put(routerRedux.push(`/chainCodeInvoker/${id}/list/${type}List/${listName}`));
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
