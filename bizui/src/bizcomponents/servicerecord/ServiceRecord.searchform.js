import React, { PureComponent } from 'react';
import { connect } from 'dva';
import {
  Row,
  Col,
  Card,
  Form,
  Input,
  Select,
  Icon,
  Button,
  Dropdown,
  Menu,
  InputNumber,
  DatePicker,
  Modal,
  message,
} from 'antd';

import styles from './ServiceRecord.search.less';
import GlobalComponents from '../../custcomponents';
import SelectObject from '../../components/SelectObject';
import appLocaleName from '../../common/Locale.tool';
const FormItem = Form.Item;
const { Option } = Select;
const getValue = obj =>
  Object.keys(obj)
    .map(key => obj[key])
    .join(',');

const pushIfNotNull = (holder, value) => {
  if (value == null) {
    return;
  }
  holder.push(value);
};

const overrideValue = (values, defaultValue) => {
  const result = _.findLast(values, it => !_.isUndefined(it) && !_.isNull(it));
  if (_.isUndefined(result)) {
    return defaultValue;
  }
  return result;
};

const filterObjectKeys = targetObject => {
  const filteredValues = {};
  for (var key in targetObject) {
    const value = targetObject[key];
    if (!value) {
      continue;
    }
    filteredValues[key] = value;
  }
  return filteredValues;
};

class ServiceRecordSearchForm extends PureComponent {
  state = {
    // addInputValue: '',
    // modalVisible: false,
    expandForm: false,
    // selectedRows: [],
    // formValues: {},
  };
  componentDidMount() {
    // const { dispatch } = this.props
    // console.log(this.props)
    // const { getFieldDecorator, setFieldsValue } = this.props.form
    const { setFieldsValue, setFieldValue } = this.props.form;
    const { expandForm } = this.props;

    const { searchFormParameters } = this.props;
    if (!searchFormParameters) {
      return;
    }
    console.log('searchFormParameters', searchFormParameters);

    setFieldsValue(searchFormParameters);
    if (_.isUndefined(expandForm)) {
      this.setState({ searchParams: searchFormParameters, expandForm: false });
      return;
    }
    this.setState({ searchParams: searchFormParameters, expandForm });
  }
  toggleForm = () => {
    this.setState({
      expandForm: !this.state.expandForm,
    });
  };
  handleFormReset = () => {
    const { form, dispatch } = this.props;
    form.resetFields();
    dispatch({
      type: 'rule/fetch',
      payload: {},
    });
  };
  /*
  buildStringSearchParameters = (formValues, fieldName) => {
    const fieldValue = formValues[fieldName]
    if (!fieldValue) {
      console.log('NO VALUE')
      return {}
    }
    return {
      serviceRecordList: 1,
      'serviceRecordList.searchField': fieldName,
      'serviceRecordList.searchVerb': 'startsWith',
      'serviceRecordList.searchValue': fieldValue,
    }
  }
  */
  buildStringSearchParameters = (listName, formValues, searchVerb, fieldName) => {
    const fieldValue = formValues[fieldName];
    if (!fieldValue) {
      return null;
    }

    //paramHolder.length
    const value = {};

    value[`${listName}.searchField`] = fieldName;
    value[`${listName}.searchVerb`] = searchVerb;
    value[`${listName}.searchValue`] = fieldValue;

    return value;
  };

  handleSearch = e => {
    e.preventDefault();
    const { dispatch, form } = this.props;
    form.validateFields((err, fieldsValue) => {
      if (err) return;
      const paramList = [];
      const { owner } = this.props;
      const { listName } = owner;

      pushIfNotNull(
        paramList,
        this.buildStringSearchParameters(listName, fieldsValue, 'contains', 'id')
      );
      pushIfNotNull(
        paramList,
        this.buildStringSearchParameters(listName, fieldsValue, 'contains', 'name')
      );
      pushIfNotNull(
        paramList,
        this.buildStringSearchParameters(listName, fieldsValue, 'contains', 'payload')
      );
      pushIfNotNull(
        paramList,
        this.buildStringSearchParameters(listName, fieldsValue, 'eq', 'channel')
      );
      pushIfNotNull(
        paramList,
        this.buildStringSearchParameters(listName, fieldsValue, 'eq', 'chainCode')
      );
      pushIfNotNull(
        paramList,
        this.buildStringSearchParameters(listName, fieldsValue, 'contains', 'chainCodeFunction')
      );
      pushIfNotNull(
        paramList,
        this.buildStringSearchParameters(listName, fieldsValue, 'contains', 'transactionId')
      );
      pushIfNotNull(
        paramList,
        this.buildStringSearchParameters(listName, fieldsValue, 'contains', 'blockId')
      );
      pushIfNotNull(
        paramList,
        this.buildStringSearchParameters(listName, fieldsValue, 'eq', 'appClient')
      );
      pushIfNotNull(
        paramList,
        this.buildStringSearchParameters(listName, fieldsValue, 'eq', 'network')
      );
      pushIfNotNull(
        paramList,
        this.buildStringSearchParameters(listName, fieldsValue, 'contains', 'response')
      );
      pushIfNotNull(
        paramList,
        this.buildStringSearchParameters(listName, fieldsValue, 'eq', 'status')
      );

      console.log('the final parameter', paramList);

      const params = {};

      for (var i = 0; i < paramList.length; i++) {
        const element = paramList[i];
        for (var key in element) {
          params[key + '.' + i] = element[key];
        }
      }

      params[`${listName}`] = 1;
      params[`${listName}.orderBy.0`] = 'id';
      params[`${listName}.descOrAsc.0`] = 'desc';

      const expandForm = overrideValue([this.state.expandForm], false);
      dispatch({
        type: `${owner.type}/load`,
        payload: {
          id: owner.id,
          parameters: params,
          serviceRecordSearchFormParameters: filterObjectKeys(fieldsValue),
          searchParameters: params,
          expandForm,
        },
      });
    });
  };

  renderSimpleForm() {
    const { getFieldDecorator } = this.props.form;
    const userContext = null;
    const { ServiceRecordService } = GlobalComponents;
    const tryinit = fieldName => {
      const { owner } = this.props;
      const { referenceName } = owner;
      if (referenceName != fieldName) {
        return null;
      }
      return owner.id;
    };
    const availableForEdit = fieldName => {
      const { owner } = this.props;
      const { referenceName } = owner;
      if (referenceName != fieldName) {
        return true;
      }
      return false;
    };

    return (
      <Form onSubmit={this.handleSearch} layout="inline">
        <Row gutter={{ md: 8, lg: 24, xl: 48 }}>
          <Col md={8} sm={24}>
            <Form.Item label="状态">
              {getFieldDecorator('status', { initialValue: tryinit('status') })(
                <SelectObject
                  disabled={!availableForEdit('status')}
                  targetType={'status'}
                  requestFunction={ServiceRecordService.requestCandidateStatus}
                  useForSearch
                />
              )}
            </Form.Item>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="ID">
              {getFieldDecorator('id')(
                <Input size="default" placeholder={appLocaleName(userContext, 'PleaseInput')} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <span className={styles.submitButtons}>
              <Button icon="search" type="primary" htmlType="submit">
                {appLocaleName(userContext, 'Search')}
              </Button>
              <Button icon="undo" style={{ marginLeft: 8 }} onClick={this.handleFormReset}>
                {appLocaleName(userContext, 'Reset')}
              </Button>
              <a style={{ marginLeft: 8 }} onClick={this.toggleForm}>
                {' '}
                {appLocaleName(userContext, 'Expand')} <Icon type="down" />{' '}
              </a>
            </span>
          </Col>
        </Row>
      </Form>
    );
  }
  renderAdvancedForm() {
    const { ServiceRecordService } = GlobalComponents;
    const { getFieldDecorator } = this.props.form;
    const userContext = null;
    const tryinit = fieldName => {
      const { owner } = this.props;
      const { referenceName } = owner;
      if (referenceName != fieldName) {
        return null;
      }
      return owner.id;
    };

    const availableForEdit = fieldName => {
      const { owner } = this.props;
      const { referenceName } = owner;
      if (referenceName != fieldName) {
        return true;
      }
      return false;
    };

    return (
      <Form onSubmit={this.handleSearch} layout="inline">
        <Row gutter={{ md: 8, lg: 24, xl: 48 }}>
          <Col md={8} sm={24}>
            <FormItem label="ID">
              {getFieldDecorator('id')(
                <Input placeholder={appLocaleName(userContext, 'PleaseInput')} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="名称">
              {getFieldDecorator('name')(
                <Input placeholder={appLocaleName(userContext, 'PleaseInput')} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="有效载荷">
              {getFieldDecorator('payload')(
                <Input placeholder={appLocaleName(userContext, 'PleaseInput')} />
              )}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <Form.Item label="频道">
              {getFieldDecorator('channel', { initialValue: tryinit('channel') })(
                <SelectObject
                  disabled={!availableForEdit('channel')}
                  targetType={'channel'}
                  requestFunction={ServiceRecordService.requestCandidateChannel}
                  useForSearch
                />
              )}
            </Form.Item>
          </Col>
          <Col md={8} sm={24}>
            <Form.Item label="链码">
              {getFieldDecorator('chainCode', { initialValue: tryinit('chainCode') })(
                <SelectObject
                  disabled={!availableForEdit('chainCode')}
                  targetType={'chainCode'}
                  requestFunction={ServiceRecordService.requestCandidateChainCode}
                  useForSearch
                />
              )}
            </Form.Item>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="链码功能">
              {getFieldDecorator('chainCodeFunction')(
                <Input placeholder={appLocaleName(userContext, 'PleaseInput')} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="事务Id">
              {getFieldDecorator('transactionId')(
                <Input placeholder={appLocaleName(userContext, 'PleaseInput')} />
              )}
            </FormItem>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="块Id">
              {getFieldDecorator('blockId')(
                <Input placeholder={appLocaleName(userContext, 'PleaseInput')} />
              )}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <Form.Item label="应用客户端">
              {getFieldDecorator('appClient', { initialValue: tryinit('appClient') })(
                <SelectObject
                  disabled={!availableForEdit('appClient')}
                  targetType={'appClient'}
                  requestFunction={ServiceRecordService.requestCandidateAppClient}
                  useForSearch
                />
              )}
            </Form.Item>
          </Col>
          <Col md={8} sm={24}>
            <Form.Item label="网络">
              {getFieldDecorator('network', { initialValue: tryinit('network') })(
                <SelectObject
                  disabled={!availableForEdit('network')}
                  targetType={'network'}
                  requestFunction={ServiceRecordService.requestCandidateNetwork}
                  useForSearch
                />
              )}
            </Form.Item>
          </Col>

          <Col md={8} sm={24}>
            <FormItem label="响应">
              {getFieldDecorator('response')(
                <Input placeholder={appLocaleName(userContext, 'PleaseInput')} />
              )}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <Form.Item label="状态">
              {getFieldDecorator('status', { initialValue: tryinit('status') })(
                <SelectObject
                  disabled={!availableForEdit('status')}
                  targetType={'status'}
                  requestFunction={ServiceRecordService.requestCandidateStatus}
                  useForSearch
                />
              )}
            </Form.Item>
          </Col>
        </Row>
        <div style={{ overflow: 'hidden' }}>
          <span style={{ float: 'right', marginBottom: 24 }}>
            <Button type="primary" icon="search" htmlType="submit">
              {appLocaleName(userContext, 'Search')}
            </Button>
            <Button icon="undo" style={{ marginLeft: 8 }} onClick={this.handleFormReset}>
              {appLocaleName(userContext, 'Reset')}
            </Button>
            <a style={{ marginLeft: 8 }} onClick={this.toggleForm}>
              {appLocaleName(userContext, 'Collapse')} <Icon type="up" />
            </a>
          </span>
        </div>
      </Form>
    );
  }

  render() {
    const expandForm = overrideValue([this.state.expandForm], false);
    return expandForm ? this.renderAdvancedForm() : this.renderSimpleForm();
  }
}

export default Form.create()(ServiceRecordSearchForm);
