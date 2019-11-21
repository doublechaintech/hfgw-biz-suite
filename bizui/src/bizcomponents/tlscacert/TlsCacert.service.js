
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}tlsCacertManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}tlsCacertManager/loadTlsCacert/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateNode = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}tlsCacertManager/requestCandidateNode/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherNode = (id, parameters) => {
  const url = `${PREFIX}tlsCacertManager/transferToAnotherNode/id/anotherNodeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}tlsCacertService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}tlsCacertService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}tlsCacertService/process/`,
    data,
  })
}

const TlsCacertService = { view,
  load,
  requestCandidateNode,
  transferToAnotherNode, listFunctions, saveRequest, processRequest}
export default TlsCacertService

