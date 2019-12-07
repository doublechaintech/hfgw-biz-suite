import { get, put, postForm, PREFIX, joinParameters, joinPostParameters } from '../../axios/tools';

const view = targetObjectId => {
  return get({
    url: `${PREFIX}changeRequestManager/view/${targetObjectId}/`,
  });
};

const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters);
  return get({
    url: `${PREFIX}changeRequestManager/loadChangeRequest/${targetObjectId}/${parametersExpr}/`,
  });
};

const requestCandidateRequestType = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}changeRequestManager/requestCandidateRequestType/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherRequestType = (id, parameters) => {
  const url = `${PREFIX}changeRequestManager/transferToAnotherRequestType/id/anotherRequestTypeId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

const requestCandidateNetwork = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}changeRequestManager/requestCandidateNetwork/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherNetwork = (id, parameters) => {
  const url = `${PREFIX}changeRequestManager/transferToAnotherNetwork/id/anotherNetworkId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

const addChainCodeInvoker = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestManager/addChainCodeInvoker/changeRequestId/appClientId/chainCodeId/parameters/tokensExpr/`;
  const changeRequestId = targetObjectId;
  const requestParameters = { ...parameters, changeRequestId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateChainCodeInvoker = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestManager/updateChainCodeInvokerProperties/changeRequestId/id/parameters/tokensExpr/`;
  const changeRequestId = targetObjectId;
  const requestParameters = { ...parameters, changeRequestId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeChainCodeInvokerList = (targetObjectId, parameters) => {
  const url = `${PREFIX}changeRequestManager/removeChainCodeInvokerList/changeRequestId/chainCodeInvokerIds/tokensExpr/`;
  const requestParameters = { ...parameters, changeRequestId: targetObjectId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

// Filter this out when no functions

const listFunctions = () => {
  return get({
    url: `${PREFIX}changeRequestService/listFunctions/`,
  });
};

const saveRequest = data => {
  return put({
    url: `${PREFIX}changeRequestService/save/`,
    data,
  });
};

const processRequest = data => {
  return put({
    url: `${PREFIX}changeRequestService/process/`,
    data,
  });
};

const ChangeRequestService = {
  view,
  load,
  addChainCodeInvoker,
  updateChainCodeInvoker,
  removeChainCodeInvokerList,
  requestCandidateRequestType,
  requestCandidateNetwork,
  transferToAnotherRequestType,
  transferToAnotherNetwork,
  listFunctions,
  saveRequest,
  processRequest,
};
export default ChangeRequestService;
