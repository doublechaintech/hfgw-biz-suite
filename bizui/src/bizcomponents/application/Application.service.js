import { get, put, postForm, PREFIX, joinParameters, joinPostParameters } from '../../axios/tools';

const view = targetObjectId => {
  return get({
    url: `${PREFIX}applicationManager/view/${targetObjectId}/`,
  });
};

const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters);
  return get({
    url: `${PREFIX}applicationManager/loadApplication/${targetObjectId}/${parametersExpr}/`,
  });
};

const requestCandidateChannel = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}applicationManager/requestCandidateChannel/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherChannel = (id, parameters) => {
  const url = `${PREFIX}applicationManager/transferToAnotherChannel/id/anotherChannelId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

const requestCandidateNetwork = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}applicationManager/requestCandidateNetwork/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherNetwork = (id, parameters) => {
  const url = `${PREFIX}applicationManager/transferToAnotherNetwork/id/anotherNetworkId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

const addServiceRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}applicationManager/addServiceRecord/applicationId/transactionId/name/payload/channelId/chainCodeId/chainCodeFunction/blockId/networkId/response/statusId/tokensExpr/`;
  const applicationId = targetObjectId;
  const requestParameters = { ...parameters, applicationId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateServiceRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}applicationManager/updateServiceRecordProperties/applicationId/id/transactionId/name/payload/chainCodeFunction/blockId/response/tokensExpr/`;
  const applicationId = targetObjectId;
  const requestParameters = { ...parameters, applicationId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeServiceRecordList = (targetObjectId, parameters) => {
  const url = `${PREFIX}applicationManager/removeServiceRecordList/applicationId/serviceRecordIds/tokensExpr/`;
  const requestParameters = { ...parameters, applicationId: targetObjectId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const addChainCodeInvoker = (targetObjectId, parameters) => {
  const url = `${PREFIX}applicationManager/addChainCodeInvoker/applicationId/chainCodeId/parameters/changeRequestId/tokensExpr/`;
  const applicationId = targetObjectId;
  const requestParameters = { ...parameters, applicationId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateChainCodeInvoker = (targetObjectId, parameters) => {
  const url = `${PREFIX}applicationManager/updateChainCodeInvokerProperties/applicationId/id/parameters/tokensExpr/`;
  const applicationId = targetObjectId;
  const requestParameters = { ...parameters, applicationId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeChainCodeInvokerList = (targetObjectId, parameters) => {
  const url = `${PREFIX}applicationManager/removeChainCodeInvokerList/applicationId/chainCodeInvokerIds/tokensExpr/`;
  const requestParameters = { ...parameters, applicationId: targetObjectId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

// Filter this out when no functions

const listFunctions = () => {
  return get({
    url: `${PREFIX}applicationService/listFunctions/`,
  });
};

const saveRequest = data => {
  return put({
    url: `${PREFIX}applicationService/save/`,
    data,
  });
};

const processRequest = data => {
  return put({
    url: `${PREFIX}applicationService/process/`,
    data,
  });
};

const ApplicationService = {
  view,
  load,
  addServiceRecord,
  addChainCodeInvoker,
  updateServiceRecord,
  updateChainCodeInvoker,
  removeServiceRecordList,
  removeChainCodeInvokerList,
  requestCandidateChannel,
  requestCandidateNetwork,
  transferToAnotherChannel,
  transferToAnotherNetwork,
  listFunctions,
  saveRequest,
  processRequest,
};
export default ApplicationService;
