import { get, put, postForm, PREFIX, joinParameters, joinPostParameters } from '../../axios/tools';

const view = targetObjectId => {
  return get({
    url: `${PREFIX}serviceRecordManager/view/${targetObjectId}/`,
  });
};

const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters);
  return get({
    url: `${PREFIX}serviceRecordManager/loadServiceRecord/${targetObjectId}/${parametersExpr}/`,
  });
};

const requestCandidateChannel = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}serviceRecordManager/requestCandidateChannel/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherChannel = (id, parameters) => {
  const url = `${PREFIX}serviceRecordManager/transferToAnotherChannel/id/anotherChannelId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

const requestCandidateChainCode = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}serviceRecordManager/requestCandidateChainCode/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherChainCode = (id, parameters) => {
  const url = `${PREFIX}serviceRecordManager/transferToAnotherChainCode/id/anotherChainCodeId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

const requestCandidateAppClient = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}serviceRecordManager/requestCandidateAppClient/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherAppClient = (id, parameters) => {
  const url = `${PREFIX}serviceRecordManager/transferToAnotherAppClient/id/anotherAppClientId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

const requestCandidateNetwork = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}serviceRecordManager/requestCandidateNetwork/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherNetwork = (id, parameters) => {
  const url = `${PREFIX}serviceRecordManager/transferToAnotherNetwork/id/anotherNetworkId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

const requestCandidateStatus = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}serviceRecordManager/requestCandidateStatus/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherStatus = (id, parameters) => {
  const url = `${PREFIX}serviceRecordManager/transferToAnotherStatus/id/anotherStatusId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

// Filter this out when no functions

const listFunctions = () => {
  return get({
    url: `${PREFIX}serviceRecordService/listFunctions/`,
  });
};

const saveRequest = data => {
  return put({
    url: `${PREFIX}serviceRecordService/save/`,
    data,
  });
};

const processRequest = data => {
  return put({
    url: `${PREFIX}serviceRecordService/process/`,
    data,
  });
};

const ServiceRecordService = {
  view,
  load,
  requestCandidateChannel,
  requestCandidateChainCode,
  requestCandidateAppClient,
  requestCandidateNetwork,
  requestCandidateStatus,
  transferToAnotherChannel,
  transferToAnotherChainCode,
  transferToAnotherAppClient,
  transferToAnotherNetwork,
  transferToAnotherStatus,
  listFunctions,
  saveRequest,
  processRequest,
};
export default ServiceRecordService;
