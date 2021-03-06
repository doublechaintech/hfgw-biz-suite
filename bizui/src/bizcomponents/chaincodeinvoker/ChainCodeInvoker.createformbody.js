import React, { Component } from 'react';
import {
  Card,
  Button,
  Form,
  Icon,
  Col,
  Row,
  DatePicker,
  TimePicker,
  Input,
  Select,
  Popover,
  Switch,
} from 'antd';
import { connect } from 'dva';
import PageHeaderLayout from '../../layouts/PageHeaderLayout';
import SelectObject from '../../components/SelectObject';
import { ImageComponent } from '../../axios/tools';
import FooterToolbar from '../../components/FooterToolbar';
import styles from './ChainCodeInvoker.createform.less';
import { mapBackToImageValues, mapFromImageValues } from '../../axios/tools';
import GlobalComponents from '../../custcomponents';
import ChainCodeInvokerBase from './ChainCodeInvoker.base';
import appLocaleName from '../../common/Locale.tool';
const { Option } = Select;
const { RangePicker } = DatePicker;
const { TextArea } = Input;
const { fieldLabels } = ChainCodeInvokerBase;
const testValues = {};
/*
const testValues = {
  appClientId: 'A000001',
  chainCodeId: 'CC000001',
  changeRequestId: 'CR000001',
  parameters: '    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n',
}
*/

const imageKeys = [];

class ChainCodeInvokerCreateFormBody extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  };

  componentDidMount() {}

  handlePreview = file => {
    console.log('preview file', file);
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    });
  };

  handleChange = (event, source) => {
    console.log('get file list from change in update change:', source);

    const { fileList } = event;
    const { convertedImagesValues } = this.state;

    convertedImagesValues[source] = fileList;
    this.setState({ convertedImagesValues });
    console.log('/get file list from change in update change:', source);
  };

  render() {
    const { form, dispatch, submitting, role } = this.props;
    const { convertedImagesValues } = this.state;
    const userContext = null;
    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form;

    const { ChainCodeInvokerService } = GlobalComponents;

    const capFirstChar = value => {
      //const upper = value.replace(/^\w/, c => c.toUpperCase());
      const upper = value.charAt(0).toUpperCase() + value.substr(1);
      return upper;
    };

    const tryinit = fieldName => {
      const { owner } = this.props;
      if (!owner) {
        return null;
      }
      const { referenceName } = owner;
      if (referenceName != fieldName) {
        return null;
      }
      return owner.id;
    };

    const availableForEdit = fieldName => {
      const { owner } = this.props;
      if (!owner) {
        return true;
      }
      const { referenceName } = owner;
      if (referenceName != fieldName) {
        return true;
      }
      return false;
    };
    const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    };
    const switchFormItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    };

    const internalRenderTitle = () => {
      const linkComp = (
        <a onClick={goback}>
          {' '}
          <Icon type="double-left" style={{ marginRight: '10px' }} />{' '}
        </a>
      );
      return (
        <div>
          {linkComp}
          {appLocaleName(userContext, 'CreateNew')}
          {window.trans('chain_code_invoker')}
        </div>
      );
    };

    return (
      <div>
        <Card
          title={!this.props.hideTitle && appLocaleName(userContext, 'BasicInfo')}
          className={styles.card}
          bordered={false}
        >
          <Form>
            <Row gutter={16}>
              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.appClient} {...formItemLayout}>
                  {getFieldDecorator('appClientId', {
                    initialValue: tryinit('appClient'),
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(
                    <SelectObject
                      disabled={!availableForEdit('appClient')}
                      targetType={'appClient'}
                      requestFunction={ChainCodeInvokerService.requestCandidateAppClient}
                    />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.chainCode} {...formItemLayout}>
                  {getFieldDecorator('chainCodeId', {
                    initialValue: tryinit('chainCode'),
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(
                    <SelectObject
                      disabled={!availableForEdit('chainCode')}
                      targetType={'chainCode'}
                      requestFunction={ChainCodeInvokerService.requestCandidateChainCode}
                    />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.changeRequest} {...formItemLayout}>
                  {getFieldDecorator('changeRequestId', {
                    initialValue: tryinit('changeRequest'),
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(
                    <SelectObject
                      disabled={!availableForEdit('changeRequest')}
                      targetType={'changeRequest'}
                      requestFunction={ChainCodeInvokerService.requestCandidateChangeRequest}
                    />
                  )}
                </Form.Item>
              </Col>
            </Row>
          </Form>
        </Card>

        <Card title={fieldLabels.parameters} className={styles.card} bordered={false}>
          <Form>
            <Row gutter={16}>
              <Col lg={24} md={24} sm={24}>
                <Form.Item>
                  {getFieldDecorator('parameters', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<TextArea rows={4} placeholder={appLocaleName(userContext, 'PleaseInput')} />)}
                </Form.Item>
              </Col>
            </Row>
          </Form>
        </Card>
      </div>
    );
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(ChainCodeInvokerCreateFormBody));
