import { get, put, postForm, PREFIX, joinParameters, joinPostParameters } from '../../axios/tools';

const view = targetObjectId => {
  return get({
    url: `${PREFIX}hyperledgerNetworkManager/view/${targetObjectId}/`,
  });
};

const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters);
  return get({
    url: `${PREFIX}hyperledgerNetworkManager/loadHyperledgerNetwork/${targetObjectId}/${parametersExpr}/`,
  });
};

const addOrganization = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/addOrganization/hyperledgerNetworkId/name/mspid/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateOrganization = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/updateOrganizationProperties/hyperledgerNetworkId/id/name/mspid/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeOrganizationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/removeOrganizationList/hyperledgerNetworkId/organizationIds/tokensExpr/`;
  const requestParameters = {
    ...parameters,
    hyperledgerNetworkId: targetObjectId,
    tokensExpr: 'none',
  };
  return postForm({ url, requestParameters });
};

const addNodeType = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/addNodeType/hyperledgerNetworkId/name/code/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateNodeType = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/updateNodeTypeProperties/hyperledgerNetworkId/id/name/code/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeNodeTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/removeNodeTypeList/hyperledgerNetworkId/nodeTypeIds/tokensExpr/`;
  const requestParameters = {
    ...parameters,
    hyperledgerNetworkId: targetObjectId,
    tokensExpr: 'none',
  };
  return postForm({ url, requestParameters });
};

const addNode = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/addNode/hyperledgerNetworkId/name/url/organizationId/channelId/tlsCacert/typeId/address/contactPerson/contactTelephone/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateNode = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/updateNodeProperties/hyperledgerNetworkId/id/name/url/tlsCacert/address/contactPerson/contactTelephone/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeNodeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/removeNodeList/hyperledgerNetworkId/nodeIds/tokensExpr/`;
  const requestParameters = {
    ...parameters,
    hyperledgerNetworkId: targetObjectId,
    tokensExpr: 'none',
  };
  return postForm({ url, requestParameters });
};

const addChannel = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/addChannel/hyperledgerNetworkId/name/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateChannel = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/updateChannelProperties/hyperledgerNetworkId/id/name/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeChannelList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/removeChannelList/hyperledgerNetworkId/channelIds/tokensExpr/`;
  const requestParameters = {
    ...parameters,
    hyperledgerNetworkId: targetObjectId,
    tokensExpr: 'none',
  };
  return postForm({ url, requestParameters });
};

const addPeerRole = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/addPeerRole/hyperledgerNetworkId/name/code/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updatePeerRole = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/updatePeerRoleProperties/hyperledgerNetworkId/id/name/code/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removePeerRoleList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/removePeerRoleList/hyperledgerNetworkId/peerRoleIds/tokensExpr/`;
  const requestParameters = {
    ...parameters,
    hyperledgerNetworkId: targetObjectId,
    tokensExpr: 'none',
  };
  return postForm({ url, requestParameters });
};

const addApplication = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/addApplication/hyperledgerNetworkId/name/mspid/publicKey/privateKey/channelId/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateApplication = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/updateApplicationProperties/hyperledgerNetworkId/id/name/mspid/publicKey/privateKey/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeApplicationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/removeApplicationList/hyperledgerNetworkId/applicationIds/tokensExpr/`;
  const requestParameters = {
    ...parameters,
    hyperledgerNetworkId: targetObjectId,
    tokensExpr: 'none',
  };
  return postForm({ url, requestParameters });
};

const addServiceRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/addServiceRecord/hyperledgerNetworkId/name/payload/channelId/chainCodeId/chainCodeFunction/transactionId/blockId/appClientId/response/statusId/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateServiceRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/updateServiceRecordProperties/hyperledgerNetworkId/id/name/payload/chainCodeFunction/transactionId/blockId/response/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeServiceRecordList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/removeServiceRecordList/hyperledgerNetworkId/serviceRecordIds/tokensExpr/`;
  const requestParameters = {
    ...parameters,
    hyperledgerNetworkId: targetObjectId,
    tokensExpr: 'none',
  };
  return postForm({ url, requestParameters });
};

const addTransactionStatus = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/addTransactionStatus/hyperledgerNetworkId/name/code/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateTransactionStatus = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/updateTransactionStatusProperties/hyperledgerNetworkId/id/name/code/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeTransactionStatusList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/removeTransactionStatusList/hyperledgerNetworkId/transactionStatusIds/tokensExpr/`;
  const requestParameters = {
    ...parameters,
    hyperledgerNetworkId: targetObjectId,
    tokensExpr: 'none',
  };
  return postForm({ url, requestParameters });
};

const addChangeRequestType = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/addChangeRequestType/hyperledgerNetworkId/name/code/icon/displayOrder/bindTypes/stepConfiguration/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateChangeRequestType = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/updateChangeRequestTypeProperties/hyperledgerNetworkId/id/name/code/icon/displayOrder/bindTypes/stepConfiguration/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeChangeRequestTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/removeChangeRequestTypeList/hyperledgerNetworkId/changeRequestTypeIds/tokensExpr/`;
  const requestParameters = {
    ...parameters,
    hyperledgerNetworkId: targetObjectId,
    tokensExpr: 'none',
  };
  return postForm({ url, requestParameters });
};

const addChangeRequest = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/addChangeRequest/hyperledgerNetworkId/name/requestTypeId/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateChangeRequest = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/updateChangeRequestProperties/hyperledgerNetworkId/id/name/tokensExpr/`;
  const hyperledgerNetworkId = targetObjectId;
  const requestParameters = { ...parameters, hyperledgerNetworkId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeChangeRequestList = (targetObjectId, parameters) => {
  const url = `${PREFIX}hyperledgerNetworkManager/removeChangeRequestList/hyperledgerNetworkId/changeRequestIds/tokensExpr/`;
  const requestParameters = {
    ...parameters,
    hyperledgerNetworkId: targetObjectId,
    tokensExpr: 'none',
  };
  return postForm({ url, requestParameters });
};

// Filter this out when no functions

const listFunctions = () => {
  return get({
    url: `${PREFIX}hyperledgerNetworkService/listFunctions/`,
  });
};

const saveRequest = data => {
  return put({
    url: `${PREFIX}hyperledgerNetworkService/save/`,
    data,
  });
};

const processRequest = data => {
  return put({
    url: `${PREFIX}hyperledgerNetworkService/process/`,
    data,
  });
};

const HyperledgerNetworkService = {
  view,
  load,
  addOrganization,
  addNodeType,
  addNode,
  addChannel,
  addPeerRole,
  addApplication,
  addServiceRecord,
  addTransactionStatus,
  addChangeRequestType,
  addChangeRequest,
  updateOrganization,
  updateNodeType,
  updateNode,
  updateChannel,
  updatePeerRole,
  updateApplication,
  updateServiceRecord,
  updateTransactionStatus,
  updateChangeRequestType,
  updateChangeRequest,
  removeOrganizationList,
  removeNodeTypeList,
  removeNodeList,
  removeChannelList,
  removePeerRoleList,
  removeApplicationList,
  removeServiceRecordList,
  removeTransactionStatusList,
  removeChangeRequestTypeList,
  removeChangeRequestList,
  listFunctions,
  saveRequest,
  processRequest,
};
export default HyperledgerNetworkService;
