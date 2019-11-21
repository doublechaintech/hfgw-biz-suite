
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}nodeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}nodeManager/loadNode/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateOrganization = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}nodeManager/requestCandidateOrganization/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOrganization = (id, parameters) => {
  const url = `${PREFIX}nodeManager/transferToAnotherOrganization/id/anotherOrganizationId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateChannel = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}nodeManager/requestCandidateChannel/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherChannel = (id, parameters) => {
  const url = `${PREFIX}nodeManager/transferToAnotherChannel/id/anotherChannelId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateType = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}nodeManager/requestCandidateType/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherType = (id, parameters) => {
  const url = `${PREFIX}nodeManager/transferToAnotherType/id/anotherTypeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addGrpcOption = (targetObjectId, parameters) => {
  const url = `${PREFIX}nodeManager/addGrpcOption/nodeId/parameterName/parameterValue/tokensExpr/`
  const nodeId = targetObjectId
  const requestParameters = { ...parameters, nodeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGrpcOption = (targetObjectId, parameters) => {
  const url = `${PREFIX}nodeManager/updateGrpcOptionProperties/nodeId/id/parameterName/parameterValue/tokensExpr/`
  const nodeId = targetObjectId
  const requestParameters = { ...parameters, nodeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGrpcOptionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}nodeManager/removeGrpcOptionList/nodeId/grpcOptionIds/tokensExpr/`
  const requestParameters = { ...parameters, nodeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addTlsCacert = (targetObjectId, parameters) => {
  const url = `${PREFIX}nodeManager/addTlsCacert/nodeId/path/cert/tokensExpr/`
  const nodeId = targetObjectId
  const requestParameters = { ...parameters, nodeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTlsCacert = (targetObjectId, parameters) => {
  const url = `${PREFIX}nodeManager/updateTlsCacertProperties/nodeId/id/path/cert/tokensExpr/`
  const nodeId = targetObjectId
  const requestParameters = { ...parameters, nodeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTlsCacertList = (targetObjectId, parameters) => {
  const url = `${PREFIX}nodeManager/removeTlsCacertList/nodeId/tlsCacertIds/tokensExpr/`
  const requestParameters = { ...parameters, nodeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}nodeService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}nodeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}nodeService/process/`,
    data,
  })
}

const NodeService = { view,
  load,
  addGrpcOption,
  addTlsCacert,
  updateGrpcOption,
  updateTlsCacert,
  removeGrpcOptionList,
  removeTlsCacertList,
  requestCandidateOrganization,
  requestCandidateChannel,
  requestCandidateType,
  transferToAnotherOrganization,
  transferToAnotherChannel,
  transferToAnotherType, listFunctions, saveRequest, processRequest}
export default NodeService

