import { get, put, postForm, PREFIX, joinParameters, joinPostParameters } from '../../axios/tools';

const view = targetObjectId => {
  return get({
    url: `${PREFIX}peerRoleManager/view/${targetObjectId}/`,
  });
};

const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters);
  return get({
    url: `${PREFIX}peerRoleManager/loadPeerRole/${targetObjectId}/${parametersExpr}/`,
  });
};

const requestCandidateNetwork = (ownerClass, id, filterKey, pageNo) => {
  const url = `${PREFIX}peerRoleManager/requestCandidateNetwork/ownerClass/id/filterKey/pageNo/`;
  const requestParameters = { id, ownerClass, filterKey, pageNo };
  return postForm({ url, requestParameters });
};

const transferToAnotherNetwork = (id, parameters) => {
  const url = `${PREFIX}peerRoleManager/transferToAnotherNetwork/id/anotherNetworkId/`;
  const requestParameters = { id, ...parameters };
  return postForm({ url, requestParameters });
};

const addChannelPeerRole = (targetObjectId, parameters) => {
  const url = `${PREFIX}peerRoleManager/addChannelPeerRole/peerRoleId/channelId/nodeId/tokensExpr/`;
  const peerRoleId = targetObjectId;
  const requestParameters = { ...parameters, peerRoleId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const updateChannelPeerRole = (targetObjectId, parameters) => {
  const url = `${PREFIX}peerRoleManager/updateChannelPeerRoleProperties/peerRoleId/id/tokensExpr/`;
  const peerRoleId = targetObjectId;
  const requestParameters = { ...parameters, peerRoleId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

const removeChannelPeerRoleList = (targetObjectId, parameters) => {
  const url = `${PREFIX}peerRoleManager/removeChannelPeerRoleList/peerRoleId/channelPeerRoleIds/tokensExpr/`;
  const requestParameters = { ...parameters, peerRoleId: targetObjectId, tokensExpr: 'none' };
  return postForm({ url, requestParameters });
};

// Filter this out when no functions

const listFunctions = () => {
  return get({
    url: `${PREFIX}peerRoleService/listFunctions/`,
  });
};

const saveRequest = data => {
  return put({
    url: `${PREFIX}peerRoleService/save/`,
    data,
  });
};

const processRequest = data => {
  return put({
    url: `${PREFIX}peerRoleService/process/`,
    data,
  });
};

const PeerRoleService = {
  view,
  load,
  addChannelPeerRole,
  updateChannelPeerRole,
  removeChannelPeerRoleList,
  requestCandidateNetwork,
  transferToAnotherNetwork,
  listFunctions,
  saveRequest,
  processRequest,
};
export default PeerRoleService;
