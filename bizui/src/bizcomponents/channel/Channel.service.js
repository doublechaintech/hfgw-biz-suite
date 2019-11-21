
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}channelManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}channelManager/loadChannel/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateNetwork = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}channelManager/requestCandidateNetwork/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherNetwork = (id, parameters) => {
  const url = `${PREFIX}channelManager/transferToAnotherNetwork/id/anotherNetworkId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addNode = (targetObjectId, parameters) => {
  const url = `${PREFIX}channelManager/addNode/channelId/name/url/organizationId/typeId/tokensExpr/`
  const channelId = targetObjectId
  const requestParameters = { ...parameters, channelId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateNode = (targetObjectId, parameters) => {
  const url = `${PREFIX}channelManager/updateNodeProperties/channelId/id/name/url/tokensExpr/`
  const channelId = targetObjectId
  const requestParameters = { ...parameters, channelId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeNodeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}channelManager/removeNodeList/channelId/nodeIds/tokensExpr/`
  const requestParameters = { ...parameters, channelId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addChainCode = (targetObjectId, parameters) => {
  const url = `${PREFIX}channelManager/addChainCode/channelId/name/codeName/codeVersion/tokensExpr/`
  const channelId = targetObjectId
  const requestParameters = { ...parameters, channelId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateChainCode = (targetObjectId, parameters) => {
  const url = `${PREFIX}channelManager/updateChainCodeProperties/channelId/id/name/codeName/codeVersion/tokensExpr/`
  const channelId = targetObjectId
  const requestParameters = { ...parameters, channelId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeChainCodeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}channelManager/removeChainCodeList/channelId/chainCodeIds/tokensExpr/`
  const requestParameters = { ...parameters, channelId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addApplication = (targetObjectId, parameters) => {
  const url = `${PREFIX}channelManager/addApplication/channelId/name/mspid/publicKey/privateKey/networkId/tokensExpr/`
  const channelId = targetObjectId
  const requestParameters = { ...parameters, channelId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateApplication = (targetObjectId, parameters) => {
  const url = `${PREFIX}channelManager/updateApplicationProperties/channelId/id/name/mspid/publicKey/privateKey/tokensExpr/`
  const channelId = targetObjectId
  const requestParameters = { ...parameters, channelId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeApplicationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}channelManager/removeApplicationList/channelId/applicationIds/tokensExpr/`
  const requestParameters = { ...parameters, channelId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addServiceRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}channelManager/addServiceRecord/channelId/name/payLoad/chainCodeId/transactionId/blockId/networkId/tokensExpr/`
  const channelId = targetObjectId
  const requestParameters = { ...parameters, channelId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateServiceRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}channelManager/updateServiceRecordProperties/channelId/id/name/payLoad/transactionId/blockId/tokensExpr/`
  const channelId = targetObjectId
  const requestParameters = { ...parameters, channelId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeServiceRecordList = (targetObjectId, parameters) => {
  const url = `${PREFIX}channelManager/removeServiceRecordList/channelId/serviceRecordIds/tokensExpr/`
  const requestParameters = { ...parameters, channelId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}channelService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}channelService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}channelService/process/`,
    data,
  })
}

const ChannelService = { view,
  load,
  addNode,
  addChainCode,
  addApplication,
  addServiceRecord,
  updateNode,
  updateChainCode,
  updateApplication,
  updateServiceRecord,
  removeNodeList,
  removeChainCodeList,
  removeApplicationList,
  removeServiceRecordList,
  requestCandidateNetwork,
  transferToAnotherNetwork, listFunctions, saveRequest, processRequest}
export default ChannelService

