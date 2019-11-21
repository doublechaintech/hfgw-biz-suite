

import React from 'react'
import { Router, Route, Switch } from 'dva/router'
import { LocaleProvider } from 'antd'
import zhCN from 'antd/lib/locale-provider/zh_CN'
// import enUS from 'antd/lib/locale-provider/en_US'
import Launcher from '../launcher/Launcher'
import ForgetPasswordForm from '../launcher/ForgetPasswordForm'

import GlobalComponents from './'


function RouterConfig({ history }) {

	const {HyperledgerNetworkBizApp} = GlobalComponents
	const {OrganizationBizApp} = GlobalComponents
	const {NodeTypeBizApp} = GlobalComponents
	const {NodeBizApp} = GlobalComponents
	const {GrpcOptionBizApp} = GlobalComponents
	const {TlsCacertBizApp} = GlobalComponents
	const {ChannelBizApp} = GlobalComponents
	const {ChainCodeBizApp} = GlobalComponents
	const {ApplicationBizApp} = GlobalComponents
	const {ServiceRecordBizApp} = GlobalComponents
	const {ChangeRequestTypeBizApp} = GlobalComponents
	const {ChangeRequestBizApp} = GlobalComponents
	const {UserDomainBizApp} = GlobalComponents
	const {UserWhiteListBizApp} = GlobalComponents
	const {SecUserBizApp} = GlobalComponents
	const {SecUserBlockingBizApp} = GlobalComponents
	const {UserAppBizApp} = GlobalComponents
	const {QuickLinkBizApp} = GlobalComponents
	const {ListAccessBizApp} = GlobalComponents
	const {ObjectAccessBizApp} = GlobalComponents
	const {LoginHistoryBizApp} = GlobalComponents
	const {GenericFormBizApp} = GlobalComponents
	const {FormMessageBizApp} = GlobalComponents
	const {FormFieldMessageBizApp} = GlobalComponents
	const {FormFieldBizApp} = GlobalComponents
	const {FormActionBizApp} = GlobalComponents
	const {CandidateContainerBizApp} = GlobalComponents
	const {CandidateElementBizApp} = GlobalComponents



  return (
    <LocaleProvider locale={zhCN}>
      <Router history={history}>
        <Switch>
          <Route path="/home" component={Launcher} />
          <Route path="/forgetpass" component={ForgetPasswordForm} />
          <Route path="/hyperledgerNetwork/" component={HyperledgerNetworkBizApp} />
          <Route path="/organization/" component={OrganizationBizApp} />
          <Route path="/nodeType/" component={NodeTypeBizApp} />
          <Route path="/node/" component={NodeBizApp} />
          <Route path="/grpcOption/" component={GrpcOptionBizApp} />
          <Route path="/tlsCacert/" component={TlsCacertBizApp} />
          <Route path="/channel/" component={ChannelBizApp} />
          <Route path="/chainCode/" component={ChainCodeBizApp} />
          <Route path="/application/" component={ApplicationBizApp} />
          <Route path="/serviceRecord/" component={ServiceRecordBizApp} />
          <Route path="/changeRequestType/" component={ChangeRequestTypeBizApp} />
          <Route path="/changeRequest/" component={ChangeRequestBizApp} />
          <Route path="/userDomain/" component={UserDomainBizApp} />
          <Route path="/userWhiteList/" component={UserWhiteListBizApp} />
          <Route path="/secUser/" component={SecUserBizApp} />
          <Route path="/secUserBlocking/" component={SecUserBlockingBizApp} />
          <Route path="/userApp/" component={UserAppBizApp} />
          <Route path="/quickLink/" component={QuickLinkBizApp} />
          <Route path="/listAccess/" component={ListAccessBizApp} />
          <Route path="/objectAccess/" component={ObjectAccessBizApp} />
          <Route path="/loginHistory/" component={LoginHistoryBizApp} />
          <Route path="/genericForm/" component={GenericFormBizApp} />
          <Route path="/formMessage/" component={FormMessageBizApp} />
          <Route path="/formFieldMessage/" component={FormFieldMessageBizApp} />
          <Route path="/formField/" component={FormFieldBizApp} />
          <Route path="/formAction/" component={FormActionBizApp} />
          <Route path="/candidateContainer/" component={CandidateContainerBizApp} />
          <Route path="/candidateElement/" component={CandidateElementBizApp} />
          <Route path="/" component={Launcher} />
        </Switch>
      </Router>
    </LocaleProvider>
  )
}

export default RouterConfig










