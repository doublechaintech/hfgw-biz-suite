import { get, put, postForm, PREFIX, joinParameters, joinPostParameters } from '../../axios/tools';

const view = targetObjectId => {
  return get({
    url: `${PREFIX}transactionStatusManager/view/${targetObjectId}/`,
  });
};

const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters);
  return get({
    url: `${PREFIX}transactionStatusManager/loadTransactionStatus/${targetObjectId}/${parametersExpr}/`,
  });
};

const requestCandidateNetwork = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}transactionStatusManager/requestCandidateNetwork/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherNetwork = (id, parameters) => {
  const url = `${PREFIX}transactionStatusManager/transferToAnotherNetwork/id/anotherNetworkId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

const addServiceRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}transactionStatusManager/addServiceRecord/transactionStatusId/transactionId/name/payload/channelId/chainCodeId/chainCodeFunction/blockId/appClientId/networkId/response/tokensExpr/`;
  const transactionStatusId = targetObjectId;
  const requestParameters = { ...parameters, transactionStatusId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateServiceRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}transactionStatusManager/updateServiceRecordProperties/transactionStatusId/id/transactionId/name/payload/chainCodeFunction/blockId/response/tokensExpr/`;
  const transactionStatusId = targetObjectId;
  const requestParameters = { ...parameters, transactionStatusId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeServiceRecordList = (targetObjectId, parameters) => {
  const url = `${PREFIX}transactionStatusManager/removeServiceRecordList/transactionStatusId/serviceRecordIds/tokensExpr/`;
  const requestParameters = {
    ...parameters,
    transactionStatusId: targetObjectId,
    tokensExpr: 'none',
  };
  return postForm({ url, requestParameters });
};

// Filter this out when no functions

const listFunctions = () => {
  return get({
    url: `${PREFIX}transactionStatusService/listFunctions/`,
  });
};

const saveRequest = data => {
  return put({
    url: `${PREFIX}transactionStatusService/save/`,
    data,
  });
};

const processRequest = data => {
  return put({
    url: `${PREFIX}transactionStatusService/process/`,
    data,
  });
};

const TransactionStatusService = {
  view,
  load,
  addServiceRecord,
  updateServiceRecord,
  removeServiceRecordList,
  requestCandidateNetwork,
  transferToAnotherNetwork,
  listFunctions,
  saveRequest,
  processRequest,
};
export default TransactionStatusService;
