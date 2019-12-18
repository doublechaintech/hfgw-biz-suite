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
import styles from './Application.createform.less';
import { mapBackToImageValues, mapFromImageValues } from '../../axios/tools';
import GlobalComponents from '../../custcomponents';
import ApplicationBase from './Application.base';
import appLocaleName from '../../common/Locale.tool';
const { Option } = Select;
const { RangePicker } = DatePicker;
const { TextArea } = Input;
const { fieldLabels } = ApplicationBase;
const testValues = {};
/*
const testValues = {
  name: '生态环境处应用2',
  mspid: 'skynet',
  channelId: 'C000001',
  networkId: 'HN000001',
  publicKey: '    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n',
  privateKey: '    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n',
}
*/

const imageKeys = [];

class ApplicationCreateFormBody extends Component {
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

    const { ApplicationService } = GlobalComponents;

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
          {window.trans('application')}
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
                <Form.Item label={fieldLabels.name} {...formItemLayout}>
                  {getFieldDecorator('name', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<Input size="large" placeHolder={fieldLabels.name} />)}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.mspid} {...formItemLayout}>
                  {getFieldDecorator('mspid', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<Input size="large" placeHolder={fieldLabels.mspid} />)}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.channel} {...formItemLayout}>
                  {getFieldDecorator('channelId', {
                    initialValue: tryinit('channel'),
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(
                    <SelectObject
                      disabled={!availableForEdit('channel')}
                      targetType={'channel'}
                      requestFunction={ApplicationService.requestCandidateChannel}
                    />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.network} {...formItemLayout}>
                  {getFieldDecorator('networkId', {
                    initialValue: tryinit('network'),
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(
                    <SelectObject
                      disabled={!availableForEdit('network')}
                      targetType={'network'}
                      requestFunction={ApplicationService.requestCandidateNetwork}
                    />
                  )}
                </Form.Item>
              </Col>
            </Row>
          </Form>
        </Card>

        <Card title={fieldLabels.publicKey} className={styles.card} bordered={false}>
          <Form>
            <Row gutter={16}>
              <Col lg={24} md={24} sm={24}>
                <Form.Item>
                  {getFieldDecorator('publicKey', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<TextArea rows={4} placeholder={appLocaleName(userContext, 'PleaseInput')} />)}
                </Form.Item>
              </Col>
            </Row>
          </Form>
        </Card>

        <Card title={fieldLabels.privateKey} className={styles.card} bordered={false}>
          <Form>
            <Row gutter={16}>
              <Col lg={24} md={24} sm={24}>
                <Form.Item>
                  {getFieldDecorator('privateKey', {
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
}))(Form.create()(ApplicationCreateFormBody));
