
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}organizationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}organizationManager/loadOrganization/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateNetwork = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}organizationManager/requestCandidateNetwork/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherNetwork = (id, parameters) => {
  const url = `${PREFIX}organizationManager/transferToAnotherNetwork/id/anotherNetworkId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addNode = (targetObjectId, parameters) => {
  const url = `${PREFIX}organizationManager/addNode/organizationId/name/url/channelId/typeId/tokensExpr/`
  const organizationId = targetObjectId
  const requestParameters = { ...parameters, organizationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateNode = (targetObjectId, parameters) => {
  const url = `${PREFIX}organizationManager/updateNodeProperties/organizationId/id/name/url/tokensExpr/`
  const organizationId = targetObjectId
  const requestParameters = { ...parameters, organizationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeNodeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}organizationManager/removeNodeList/organizationId/nodeIds/tokensExpr/`
  const requestParameters = { ...parameters, organizationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}organizationService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}organizationService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}organizationService/process/`,
    data,
  })
}

const OrganizationService = { view,
  load,
  addNode,
  updateNode,
  removeNodeList,
  requestCandidateNetwork,
  transferToAnotherNetwork, listFunctions, saveRequest, processRequest}
export default OrganizationService

