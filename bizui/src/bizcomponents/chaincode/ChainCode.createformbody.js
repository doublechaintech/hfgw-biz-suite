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
import styles from './ChainCode.createform.less';
import { mapBackToImageValues, mapFromImageValues } from '../../axios/tools';
import GlobalComponents from '../../custcomponents';
import ChainCodeBase from './ChainCode.base';
import appLocaleName from '../../common/Locale.tool';
const { Option } = Select;
const { RangePicker } = DatePicker;
const { TextArea } = Input;
const { fieldLabels } = ChainCodeBase;
const testValues = {};
/*
const testValues = {
  name: 'sacc:1',
  codeName: 'sacc',
  codeVersion: '1',
  channelId: 'C000001',
}
*/

const imageKeys = [];

class ChainCodeCreateFormBody extends Component {
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

    const { ChainCodeService } = GlobalComponents;

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
          {window.trans('chain_code')}
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
                <Form.Item label={fieldLabels.codeName} {...formItemLayout}>
                  {getFieldDecorator('codeName', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<Input size="large" placeHolder={fieldLabels.codeName} />)}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.codeVersion} {...formItemLayout}>
                  {getFieldDecorator('codeVersion', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<Input size="large" placeHolder={fieldLabels.codeVersion} />)}
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
                      requestFunction={ChainCodeService.requestCandidateChannel}
                    />
                  )}
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
}))(Form.create()(ChainCodeCreateFormBody));
