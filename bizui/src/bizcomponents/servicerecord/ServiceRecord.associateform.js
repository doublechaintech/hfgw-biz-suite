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
  Modal,
} from 'antd';
import { connect } from 'dva';
import PageHeaderLayout from '../../layouts/PageHeaderLayout';
import { ImageComponent } from '../../axios/tools';
import FooterToolbar from '../../components/FooterToolbar';
import styles from './ServiceRecord.createform.less';
import { mapBackToImageValues, mapFromImageValues } from '../../axios/tools';
import GlobalComponents from '../../custcomponents';
import ServiceRecordBase from './ServiceRecord.base';
import SelectObject from '../../components/SelectObject';
import appLocaleName from '../../common/Locale.tool';

const { Option } = Select;
const { RangePicker } = DatePicker;
const { TextArea } = Input;

const testValues = {};
/*
const testValues = {
  transactionId: 'a21fe3srw',
  name: '调用链码',
  chainCodeFunction: 'transact',
  blockId: 'a21fe3srw',
  channelId: 'C000001',
  chainCodeId: 'CC000001',
  appClientId: 'A000001',
  networkId: 'HN000001',
  statusId: 'new',
  payload: '    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n',
  response: '    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n',
}
*/

const imageKeys = [];

class ServiceRecordAssociateForm extends Component {
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
    const {
      form,
      dispatch,
      submitting,
      role,
      data,
      owner,
      toggleAssociatePaymentVisible,
      visible,
      onCancel,
      onCreate,
    } = this.props;
    const { convertedImagesValues } = this.state;
    const { ServiceRecordService } = GlobalComponents;
    const userContext = null;

    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form;
    const { fieldLabels } = ServiceRecordBase;

    const capFirstChar = value => {
      //const upper = value.replace(/^\w/, c => c.toUpperCase());
      const upper = value.charAt(0).toUpperCase() + value.substr(1);
      return upper;
    };

    const tryinit = (fieldName, candidates) => {
      if (candidates && candidates.length == 1) {
        return candidates[0].id;
      }
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
    const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    };
    const switchFormItemLayout = {
      labelCol: { span: 14 },
      wrapperCol: { span: 4 },
    };

    return (
      <Modal
        title={appLocaleName(userContext, 'CreateNew')}
        visible={visible}
        onOk={onCancel}
        onCancel={onCancel}
        width={920}
        style={{ top: 40 }}
      >
        <Card
          title={appLocaleName(userContext, 'BasicInfo')}
          className={styles.card}
          style={{ backgroundColor: '#eee' }}
        >
          <Form>
            <Row gutter={16}>
              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.transactionId} {...formItemLayout}>
                  {getFieldDecorator('transactionId', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<Input size="large" placeHolder={fieldLabels.transactionId} />)}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.name} {...formItemLayout}>
                  {getFieldDecorator('name', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<Input size="large" placeHolder={fieldLabels.name} />)}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.chainCodeFunction} {...formItemLayout}>
                  {getFieldDecorator('chainCodeFunction', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<Input size="large" placeHolder={fieldLabels.chainCodeFunction} />)}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.blockId} {...formItemLayout}>
                  {getFieldDecorator('blockId', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<Input size="large" placeHolder={fieldLabels.blockId} />)}
                </Form.Item>
              </Col>
            </Row>

            <Row gutter={16}>
              <Col lg={24} md={24} sm={24}>
                <Form.Item>
                  {getFieldDecorator('payload', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<TextArea rows={4} placeholder={appLocaleName(userContext, 'PleaseInput')} />)}
                </Form.Item>
              </Col>
            </Row>

            <Row gutter={16}>
              <Col lg={24} md={24} sm={24}>
                <Form.Item>
                  {getFieldDecorator('response', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<TextArea rows={4} placeholder={appLocaleName(userContext, 'PleaseInput')} />)}
                </Form.Item>
              </Col>
            </Row>

            <Row gutter={16}>
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.channel} {...formItemLayout}>
                  {getFieldDecorator('channelId', {
                    initialValue: tryinit('channel'),
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(
                    <SelectObject
                      disabled={!availableForEdit('channel')}
                      targetType={'channel'}
                      requestFunction={ServiceRecordService.requestCandidateChannel}
                    />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.chainCode} {...formItemLayout}>
                  {getFieldDecorator('chainCodeId', {
                    initialValue: tryinit('chainCode'),
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(
                    <SelectObject
                      disabled={!availableForEdit('chainCode')}
                      targetType={'chainCode'}
                      requestFunction={ServiceRecordService.requestCandidateChainCode}
                    />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.appClient} {...formItemLayout}>
                  {getFieldDecorator('appClientId', {
                    initialValue: tryinit('appClient'),
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(
                    <SelectObject
                      disabled={!availableForEdit('appClient')}
                      targetType={'appClient'}
                      requestFunction={ServiceRecordService.requestCandidateAppClient}
                    />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.network} {...formItemLayout}>
                  {getFieldDecorator('networkId', {
                    initialValue: tryinit('network'),
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(
                    <SelectObject
                      disabled={!availableForEdit('network')}
                      targetType={'network'}
                      requestFunction={ServiceRecordService.requestCandidateNetwork}
                    />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.status} {...formItemLayout}>
                  {getFieldDecorator('statusId', {
                    initialValue: tryinit('status'),
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(
                    <SelectObject
                      disabled={!availableForEdit('status')}
                      targetType={'status'}
                      requestFunction={ServiceRecordService.requestCandidateStatus}
                    />
                  )}
                </Form.Item>
              </Col>
            </Row>
          </Form>
        </Card>
      </Modal>
    );
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(ServiceRecordAssociateForm));
