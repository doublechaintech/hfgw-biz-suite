
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}applicationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}applicationManager/loadApplication/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateChannel = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}applicationManager/requestCandidateChannel/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherChannel = (id, parameters) => {
  const url = `${PREFIX}applicationManager/transferToAnotherChannel/id/anotherChannelId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateNetwork = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}applicationManager/requestCandidateNetwork/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherNetwork = (id, parameters) => {
  const url = `${PREFIX}applicationManager/transferToAnotherNetwork/id/anotherNetworkId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addServiceRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}applicationManager/addServiceRecord/applicationId/name/payLoad/channelId/chainCodeId/chainCodeFunction/transactionId/blockId/networkId/tokensExpr/`
  const applicationId = targetObjectId
  const requestParameters = { ...parameters, applicationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateServiceRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}applicationManager/updateServiceRecordProperties/applicationId/id/name/payLoad/chainCodeFunction/transactionId/blockId/tokensExpr/`
  const applicationId = targetObjectId
  const requestParameters = { ...parameters, applicationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeServiceRecordList = (targetObjectId, parameters) => {
  const url = `${PREFIX}applicationManager/removeServiceRecordList/applicationId/serviceRecordIds/tokensExpr/`
  const requestParameters = { ...parameters, applicationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}applicationService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}applicationService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}applicationService/process/`,
    data,
  })
}

const ApplicationService = { view,
  load,
  addServiceRecord,
  updateServiceRecord,
  removeServiceRecordList,
  requestCandidateChannel,
  requestCandidateNetwork,
  transferToAnotherChannel,
  transferToAnotherNetwork, listFunctions, saveRequest, processRequest}
export default ApplicationService

