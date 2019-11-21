
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}nodeTypeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}nodeTypeManager/loadNodeType/${targetObjectId}/${parametersExpr}/`,
  })
}







const addNode = (targetObjectId, parameters) => {
  const url = `${PREFIX}nodeTypeManager/addNode/nodeTypeId/name/url/organizationId/channelId/networkId/tlsCacert/address/contactPerson/contactTelephone/tokensExpr/`
  const nodeTypeId = targetObjectId
  const requestParameters = { ...parameters, nodeTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateNode = (targetObjectId, parameters) => {
  const url = `${PREFIX}nodeTypeManager/updateNodeProperties/nodeTypeId/id/name/url/tlsCacert/address/contactPerson/contactTelephone/tokensExpr/`
  const nodeTypeId = targetObjectId
  const requestParameters = { ...parameters, nodeTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeNodeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}nodeTypeManager/removeNodeList/nodeTypeId/nodeIds/tokensExpr/`
  const requestParameters = { ...parameters, nodeTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}nodeTypeService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}nodeTypeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}nodeTypeService/process/`,
    data,
  })
}

const NodeTypeService = { view,
  load,
  addNode,
  updateNode,
  removeNodeList, listFunctions, saveRequest, processRequest}
export default NodeTypeService

