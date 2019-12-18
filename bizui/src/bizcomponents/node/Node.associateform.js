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
import styles from './Node.createform.less';
import { mapBackToImageValues, mapFromImageValues } from '../../axios/tools';
import GlobalComponents from '../../custcomponents';
import NodeBase from './Node.base';
import SelectObject from '../../components/SelectObject';
import appLocaleName from '../../common/Locale.tool';

const { Option } = Select;
const { RangePicker } = DatePicker;
const { TextArea } = Input;

const testValues = {};
/*
const testValues = {
  name: 'skynet-peer',
  url: 'grpcs://www.skynet-peer.skynet.com:7051',
  address: '北京市建国门内大街100号',
  contactPerson: '张三',
  contactTelephone: '010-9998880',
  organizationId: 'O000001',
  channelId: 'C000001',
  networkId: 'HN000001',
  typeId: 'peer',
  tlsCacert: '    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n',
}
*/

const imageKeys = [];

class NodeAssociateForm extends Component {
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
    const { NodeService } = GlobalComponents;
    const userContext = null;

    const { GrpcOptionModalTable } = GlobalComponents;
    const { ChannelPeerRoleModalTable } = GlobalComponents;

    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form;
    const { fieldLabels } = NodeBase;

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
                <Form.Item label={fieldLabels.name} {...formItemLayout}>
                  {getFieldDecorator('name', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<Input size="large" placeHolder={fieldLabels.name} />)}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.url} {...formItemLayout}>
                  {getFieldDecorator('url', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<Input size="large" placeHolder={fieldLabels.url} />)}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.address} {...formItemLayout}>
                  {getFieldDecorator('address', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<Input size="large" placeHolder={fieldLabels.address} />)}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.contactPerson} {...formItemLayout}>
                  {getFieldDecorator('contactPerson', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<Input size="large" placeHolder={fieldLabels.contactPerson} />)}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={12}>
                <Form.Item label={fieldLabels.contactTelephone} {...formItemLayout}>
                  {getFieldDecorator('contactTelephone', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<Input size="large" placeHolder={fieldLabels.contactTelephone} />)}
                </Form.Item>
              </Col>
            </Row>

            <Row gutter={16}>
              <Col lg={24} md={24} sm={24}>
                <Form.Item>
                  {getFieldDecorator('tlsCacert', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<TextArea rows={4} placeholder={appLocaleName(userContext, 'PleaseInput')} />)}
                </Form.Item>
              </Col>
            </Row>

            <Row gutter={16}>
              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.organization} {...formItemLayout}>
                  {getFieldDecorator('organizationId', {
                    initialValue: tryinit('organization'),
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(
                    <SelectObject
                      disabled={!availableForEdit('organization')}
                      targetType={'organization'}
                      requestFunction={NodeService.requestCandidateOrganization}
                    />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.channel} {...formItemLayout}>
                  {getFieldDecorator('channelId', {
                    initialValue: tryinit('channel'),
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(
                    <SelectObject
                      disabled={!availableForEdit('channel')}
                      targetType={'channel'}
                      requestFunction={NodeService.requestCandidateChannel}
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
                      requestFunction={NodeService.requestCandidateNetwork}
                    />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.type} {...formItemLayout}>
                  {getFieldDecorator('typeId', {
                    initialValue: tryinit('type'),
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(
                    <SelectObject
                      disabled={!availableForEdit('type')}
                      targetType={'type'}
                      requestFunction={NodeService.requestCandidateType}
                    />
                  )}
                </Form.Item>
              </Col>
            </Row>
          </Form>
        </Card>

        <GrpcOptionModalTable data={data.grpcOptionList} owner={owner} />
        <ChannelPeerRoleModalTable data={data.channelPeerRoleList} owner={owner} />
      </Modal>
    );
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(NodeAssociateForm));
