
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}grpcOptionManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}grpcOptionManager/loadGrpcOption/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateNode = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}grpcOptionManager/requestCandidateNode/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherNode = (id, parameters) => {
  const url = `${PREFIX}grpcOptionManager/transferToAnotherNode/id/anotherNodeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}grpcOptionService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}grpcOptionService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}grpcOptionService/process/`,
    data,
  })
}

const GrpcOptionService = { view,
  load,
  requestCandidateNode,
  transferToAnotherNode, listFunctions, saveRequest, processRequest}
export default GrpcOptionService

