
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}chainCodeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}chainCodeManager/loadChainCode/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateChannel = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}chainCodeManager/requestCandidateChannel/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherChannel = (id, parameters) => {
  const url = `${PREFIX}chainCodeManager/transferToAnotherChannel/id/anotherChannelId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addServiceRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}chainCodeManager/addServiceRecord/chainCodeId/name/payLoad/channelId/chainCodeFunction/transactionId/blockId/networkId/tokensExpr/`
  const chainCodeId = targetObjectId
  const requestParameters = { ...parameters, chainCodeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateServiceRecord = (targetObjectId, parameters) => {
  const url = `${PREFIX}chainCodeManager/updateServiceRecordProperties/chainCodeId/id/name/payLoad/chainCodeFunction/transactionId/blockId/tokensExpr/`
  const chainCodeId = targetObjectId
  const requestParameters = { ...parameters, chainCodeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeServiceRecordList = (targetObjectId, parameters) => {
  const url = `${PREFIX}chainCodeManager/removeServiceRecordList/chainCodeId/serviceRecordIds/tokensExpr/`
  const requestParameters = { ...parameters, chainCodeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}chainCodeService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}chainCodeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}chainCodeService/process/`,
    data,
  })
}

const ChainCodeService = { view,
  load,
  addServiceRecord,
  updateServiceRecord,
  removeServiceRecordList,
  requestCandidateChannel,
  transferToAnotherChannel, listFunctions, saveRequest, processRequest}
export default ChainCodeService

