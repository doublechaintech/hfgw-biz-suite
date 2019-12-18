import { get, put, postForm, PREFIX, joinParameters, joinPostParameters } from '../../axios/tools';

const view = targetObjectId => {
  return get({
    url: `${PREFIX}chainCodeInvokerManager/view/${targetObjectId}/`,
  });
};

const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters);
  return get({
    url: `${PREFIX}chainCodeInvokerManager/loadChainCodeInvoker/${targetObjectId}/${parametersExpr}/`,
  });
};

const requestCandidateAppClient = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}chainCodeInvokerManager/requestCandidateAppClient/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherAppClient = (id, parameters) => {
  const url = `${PREFIX}chainCodeInvokerManager/transferToAnotherAppClient/id/anotherAppClientId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

const requestCandidateChainCode = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}chainCodeInvokerManager/requestCandidateChainCode/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherChainCode = (id, parameters) => {
  const url = `${PREFIX}chainCodeInvokerManager/transferToAnotherChainCode/id/anotherChainCodeId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

const requestCandidateChangeRequest = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}chainCodeInvokerManager/requestCandidateChangeRequest/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherChangeRequest = (id, parameters) => {
  const url = `${PREFIX}chainCodeInvokerManager/transferToAnotherChangeRequest/id/anotherChangeRequestId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

// Filter this out when no functions

const listFunctions = () => {
  return get({
    url: `${PREFIX}chainCodeInvokerService/listFunctions/`,
  });
};

const saveRequest = data => {
  return put({
    url: `${PREFIX}chainCodeInvokerService/save/`,
    data,
  });
};

const processRequest = data => {
  return put({
    url: `${PREFIX}chainCodeInvokerService/process/`,
    data,
  });
};

const ChainCodeInvokerService = {
  view,
  load,
  requestCandidateAppClient,
  requestCandidateChainCode,
  requestCandidateChangeRequest,
  transferToAnotherAppClient,
  transferToAnotherChainCode,
  transferToAnotherChangeRequest,
  listFunctions,
  saveRequest,
  processRequest,
};
export default ChainCodeInvokerService;
