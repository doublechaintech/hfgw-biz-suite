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
import styles from './HyperledgerNetwork.createform.less';
import { mapBackToImageValues, mapFromImageValues } from '../../axios/tools';
import GlobalComponents from '../../custcomponents';
import HyperledgerNetworkBase from './HyperledgerNetwork.base';
import SelectObject from '../../components/SelectObject';
import appLocaleName from '../../common/Locale.tool';

const { Option } = Select;
const { RangePicker } = DatePicker;
const { TextArea } = Input;

const testValues = {};
/*
const testValues = {
  name: 'Hyperledger Fabric 应用网关',
  description: '    一段样例文字。    一段样例文字。\n可以分段。可以分段。\n\n可以空行。可以空行。\n\n',
}
*/

const imageKeys = [];

class HyperledgerNetworkAssociateForm extends Component {
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
    const { HyperledgerNetworkService } = GlobalComponents;
    const userContext = null;

    const { OrganizationModalTable } = GlobalComponents;
    const { NodeTypeModalTable } = GlobalComponents;
    const { NodeModalTable } = GlobalComponents;
    const { ChannelModalTable } = GlobalComponents;
    const { PeerRoleModalTable } = GlobalComponents;
    const { ApplicationModalTable } = GlobalComponents;
    const { ServiceRecordModalTable } = GlobalComponents;
    const { TransactionStatusModalTable } = GlobalComponents;
    const { ChangeRequestTypeModalTable } = GlobalComponents;
    const { ChangeRequestModalTable } = GlobalComponents;

    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form;
    const { fieldLabels } = HyperledgerNetworkBase;

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
            </Row>

            <Row gutter={16}>
              <Col lg={24} md={24} sm={24}>
                <Form.Item>
                  {getFieldDecorator('description', {
                    rules: [{ required: true, message: appLocaleName(userContext, 'PleaseInput') }],
                  })(<TextArea rows={4} placeholder={appLocaleName(userContext, 'PleaseInput')} />)}
                </Form.Item>
              </Col>
            </Row>
          </Form>
        </Card>

        <OrganizationModalTable data={data.organizationList} owner={owner} />
        <NodeTypeModalTable data={data.nodeTypeList} owner={owner} />
        <NodeModalTable data={data.nodeList} owner={owner} />
        <ChannelModalTable data={data.channelList} owner={owner} />
        <PeerRoleModalTable data={data.peerRoleList} owner={owner} />
        <ApplicationModalTable data={data.applicationList} owner={owner} />
        <ServiceRecordModalTable data={data.serviceRecordList} owner={owner} />
        <TransactionStatusModalTable data={data.transactionStatusList} owner={owner} />
        <ChangeRequestTypeModalTable data={data.changeRequestTypeList} owner={owner} />
        <ChangeRequestModalTable data={data.changeRequestList} owner={owner} />
      </Modal>
    );
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(HyperledgerNetworkAssociateForm));
