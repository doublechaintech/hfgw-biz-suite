import { get, put, postForm, PREFIX, joinParameters, joinPostParameters } from '../../axios/tools';

const view = targetObjectId => {
  return get({
    url: `${PREFIX}chainCodeManager/view/${targetObjectId}/`,
  });
};

const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters);
  return get({
    url: `${PREFIX}chainCodeManager/loadChainCode/${targetObjectId}/${parametersExpr}/`,
  });
};

const requestCandidateChannel = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}chainCodeManager/requestCandidateChannel/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherChannel = (id, parameters) => {
  const url = `${PREFIX}chainCodeManager/transferToAnotherChannel/id/anotherChannelId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

const addServiceRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}chainCodeManager/addServiceRecord/chainCodeId/transactionId/name/payload/channelId/chainCodeFunction/blockId/appClientId/networkId/response/statusId/tokensExpr/`;
  const chainCodeId = targetObjectId;
  const requestParameters = { ...parameters, chainCodeId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateServiceRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}chainCodeManager/updateServiceRecordProperties/chainCodeId/id/transactionId/name/payload/chainCodeFunction/blockId/response/tokensExpr/`;
  const chainCodeId = targetObjectId;
  const requestParameters = { ...parameters, chainCodeId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeServiceRecordList = (targetObjectId, parameters) => {
  const url = `${PREFIX}chainCodeManager/removeServiceRecordList/chainCodeId/serviceRecordIds/tokensExpr/`;
  const requestParameters = { ...parameters, chainCodeId: targetObjectId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const addChainCodeInvoker = (targetObjectId, parameters) => {
  const url = `${PREFIX}chainCodeManager/addChainCodeInvoker/chainCodeId/appClientId/parameters/changeRequestId/tokensExpr/`;
  const chainCodeId = targetObjectId;
  const requestParameters = { ...parameters, chainCodeId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateChainCodeInvoker = (targetObjectId, parameters) => {
  const url = `${PREFIX}chainCodeManager/updateChainCodeInvokerProperties/chainCodeId/id/parameters/tokensExpr/`;
  const chainCodeId = targetObjectId;
  const requestParameters = { ...parameters, chainCodeId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeChainCodeInvokerList = (targetObjectId, parameters) => {
  const url = `${PREFIX}chainCodeManager/removeChainCodeInvokerList/chainCodeId/chainCodeInvokerIds/tokensExpr/`;
  const requestParameters = { ...parameters, chainCodeId: targetObjectId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

// Filter this out when no functions

const listFunctions = () => {
  return get({
    url: `${PREFIX}chainCodeService/listFunctions/`,
  });
};

const saveRequest = data => {
  return put({
    url: `${PREFIX}chainCodeService/save/`,
    data,
  });
};

const processRequest = data => {
  return put({
    url: `${PREFIX}chainCodeService/process/`,
    data,
  });
};

const ChainCodeService = {
  view,
  load,
  addServiceRecord,
  addChainCodeInvoker,
  updateServiceRecord,
  updateChainCodeInvoker,
  removeServiceRecordList,
  removeChainCodeInvokerList,
  requestCandidateChannel,
  transferToAnotherChannel,
  listFunctions,
  saveRequest,
  processRequest,
};
export default ChainCodeService;
