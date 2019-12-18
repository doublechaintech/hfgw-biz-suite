
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}channelPeerRoleManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}channelPeerRoleManager/loadChannelPeerRole/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateChannel = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}channelPeerRoleManager/requestCandidateChannel/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherChannel = (id, parameters) => {
  const url = `${PREFIX}channelPeerRoleManager/transferToAnotherChannel/id/anotherChannelId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateNode = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}channelPeerRoleManager/requestCandidateNode/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherNode = (id, parameters) => {
  const url = `${PREFIX}channelPeerRoleManager/transferToAnotherNode/id/anotherNodeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePeerRole = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}channelPeerRoleManager/requestCandidatePeerRole/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPeerRole = (id, parameters) => {
  const url = `${PREFIX}channelPeerRoleManager/transferToAnotherPeerRole/id/anotherPeerRoleId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}channelPeerRoleService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}channelPeerRoleService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}channelPeerRoleService/process/`,
    data,
  })
}

const ChannelPeerRoleService = { view,
  load,
  requestCandidateChannel,
  requestCandidateNode,
  requestCandidatePeerRole,
  transferToAnotherChannel,
  transferToAnotherNode,
  transferToAnotherPeerRole, listFunctions, saveRequest, processRequest}
export default ChannelPeerRoleService

