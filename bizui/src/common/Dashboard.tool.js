/* eslint-disable react/react-in-jsx-scope */
/* eslint-disable react/jsx-indent */
import FontAwesome from 'react-fontawesome';
import PermissionSettingService from '../permission/PermissionSetting.service';
import {List,
  Row,
  Col,
  Icon,
  Card,
  Tooltip,
  Switch,
  Select,
  Form,
  AutoComplete,
  Modal,Divider,Collapse,Tabs,
} from 'antd';
import styles from './Dashboard.tool.less';
import ImagePreview from '../components/ImagePreview';
import Trend from '../components/Trend';
import numeral from 'numeral';
import { Link, Route, Redirect } from 'dva/router';
import ReactEcharts from 'echarts-for-react';
import moment from 'moment';
import appLocaleName from './Locale.tool';
import {
  ChartCard,
  MiniArea,
  MiniBar,

} from 'components/Charts';

import { PREFIX } from '../axios/tools'

import echarts from 'echarts';
import Themes from './Dashboard.echartstheme';

const {Panel} = Collapse;
//get more style from https://echarts.baidu.com/theme-builder/
echarts.registerTheme('bizTheme2', Themes.bizTheme);
//please do not use defaultTheme, this is a big trap for developers

const { hasItemCreatePermission, hasItemReadPermission } = PermissionSettingService;
const { Option } = Select;

const topColResponsiveProps = {
  xs: 8,
  sm: 6,
  md: 6,
  lg: 6,
  xl: 6,
  style: { marginBottom: 24, marginTop: 24 },
};

const wholeLineColProps = {
  xs: 24,
  sm: 24,
  md: 24,
  lg: 24,
  xl: 24,
  style: {  marginBottom: 24, marginTop: 24},
};



const quckFunctionProps = {
  xs: 24,
  sm: 24,
  md: 12,
  lg: 6,
  xl: 6,
  
};

const renderForNumbers = aggregatedData => {
  if (!aggregatedData) {
    return null;
  }
  //scan all property ends with stats info

  const data = aggregatedData;
  if (!data.dataArray) {
    return null;
  }
  if (data.dataArray.length == 0) {
    return null;
  }
  // <MiniArea color="#975FE4" data={visitData} />

  const colors = [
    '#e6194b',
    '#3cb44b',
    '#ffe119',
    '#4363d8',
    '#f58231',
    '#911eb4',
    '#46f0f0',
    '#f032e6',
    '#bcf60c',
    '#fabebe',
    '#008080',
    '#e6beff',
    '#9a6324',
    '#fffac8',
    '#800000',
    '#aaffc3',
    '#808000',
    '#ffd8b1',
    '#000075',
    '#808080',
    '#ffffff',
    '#000000',
  ];
  let colorIndex = 0
  return (
    <Row gutter={24}>
      {data.dimensions.map((item) => {
        const visitData = [];
        let itemTotal = 0;
        const weekData = { lastWeek: 0, thisWeek: 0, lastWeekCount: 7, change: 0 };

        data.dataArray
          .filter(dateItem => dateItem.date !== '未分配')
          .filter(dateItem => dateItem[item] > 0)
          .map(dateItem => {
            visitData.push({ x: dateItem.date, y: dateItem[item] });
            const weeknumber = moment(dateItem.date, 'YYYY/MM/DD').week();
            const thisweeknumber = moment().week();
            if (thisweeknumber - weeknumber === 1) {
              // last week
              weekData.lastWeek += dateItem[item];
            }
            if (thisweeknumber - weeknumber === 0) {
              // this week
              weekData.thisWeek += dateItem[item];
            }

            // console.log("week of the year for ", dateItem.date, " week number",weeknumber)
            itemTotal += dateItem[item];
          });

        if (itemTotal < 5) {
          return null;
        }

        if (visitData.length < 10) {
          return null;
        }
        let ChartComp = MiniArea;

        if (visitData.length < 10) {
          ChartComp = MiniBar;
        }
        colorIndex +=1
        console.log('index: ', colorIndex, colors[colorIndex % colors.length]);

        const chartColor = colors[colorIndex % colors.length];

        const trend=(target)=>{

          return target.lastWeek> target.thisWeek?"down":"up";

        }
        const change=(target)=>{
          if(target.thisWeek===0){
            return `${numeral(0).format('0.00')}%`
          }
          if(target.lastWeek===0){
            return "NA"
          }
          const percent=(target.thisWeek-target.lastWeek)/target.lastWeek*100
          return `${numeral(Math.abs(percent)).format('0.00')}%`
        }
        


        return (
          <Col key={item} {...topColResponsiveProps}>
            <ChartCard
              bordered={false}
              title={item}
              action={
                <Tooltip title="指标说明">
                  <Icon type="info-circle-o" />
                </Tooltip>
              }
              total={numeral(itemTotal).format('0,0')}
              footer={
                <div>
                  <Trend flag={trend(weekData)} style={{ marginRight: 16 }}>
                    上周: {numeral(weekData.lastWeek).format('0,0')}/本周: {numeral(
                      weekData.thisWeek
                    ).format('0,0')}
                    <span className={styles.trendText}>环比{change(weekData)}</span>
                  </Trend>
                </div>
              }
              contentHeight={46}
            >
              <ChartComp color={chartColor} data={visitData} />
            </ChartCard>
          </Col>
        );
      })}
    </Row>
  );
};

const renderForTimeLine = aggregatedData => {
  if (!aggregatedData) {
    return null;
  }
  // scan all property ends with stats info
  console.log('aggregatedData', aggregatedData);

  const data = aggregatedData;
  if (!data.dataArray) {
    return null;
  }
  if (data.dataArray.length < 10) {
    return null;
  }
  const option = {
    legend: {},
    toolbox: {
      show: true,
      orient: 'vertical',
      feature: {
        dataZoom: {
          yAxisIndex: 'none',
        },
        dataView: { readOnly: false },
        magicType: { type: ['line', 'bar'] },
        restore: {},
        saveAsImage: {},
      },
    },
    tooltip: {
      trigger: 'axis',
    },
    dataset: {
      dimensions: data.dimensions,
      source: data.dataArray,
    },

    xAxis: { type: 'category' },
    yAxis: {},
    dataZoom: [
      {
        type: 'slider',
        show: true,
        xAxisIndex: [0],
        start: 0,
        end: 100,
      },
    ],

    series: data.series,
  };

  const click = event => {
    console.log('clicked', event);
  };
  const datazoom = event => {
    console.log('datazoomed', event);
  };
  const legend = event => {
    console.log('legend', event);
  };
  const onEvents = { click: click, legendselectchanged: legend, datazoom: datazoom };

  return (
    <Card>
      <ReactEcharts
        option={option}
        height={600}
        theme="bizTheme2"
        style={{ height: '400px' }}
        onEvents={onEvents}
      />
    </Card>
  );
};

Set.prototype.toArray = function() {
  const result = [];

  this.forEach((value, v, set) => {
    result.push(value);
  });
  return result;
};

const calcKey = item => {
  if (!item) {
    return '未知';
  }
  if (!item.key) {
    return '没有标题';
  }
  if (item.key.id == null) {
    return '未分配';
  }
  if (item.key.displayName) {
    return item.key.displayName;
  }
  if (item.key.id) {
    return item.key.id;
  }
  return '未分配';
};

const aggregateDataset = mainObject => {
  const dataMap = {};
  const dimensionSet = new Set(['date']);
  for (const key in mainObject) {
    if (!key.endsWith('StatsInfo')) {
      continue;
    }
    const statsInfo = mainObject[key];
    if (!statsInfo) {
      continue;
    }
    const series = statsInfo.itemList.find(item => item.internalName.endsWith('OfDateline'));
    if (!series) {
      continue;
    }
    series.result.map(item => {
      const itemkey = calcKey(item);
      const existedValue = dataMap[itemkey];
      const itemValue = {};
      const {displayName} = series
      itemValue[displayName] = item.count;
      dimensionSet.add(displayName);
      if (!existedValue) {
        dataMap[itemkey] = { date: itemkey, ...itemValue };
        return;
      }
      dataMap[itemkey] = { ...existedValue, ...itemValue };
    });
  }

  const dimensions = dimensionSet.toArray();
  const defaultEntry = {};
  const filteredDimensions = dimensions.filter(item => item != 'date').map(item => {
    defaultEntry[item] = 0;
  });
  console.log('default entry', defaultEntry);
  console.log('default dimensions', dimensions);
  const dataArray = Object.entries(dataMap)
    .map(([key, value]) => ({ ...defaultEntry, ...value }))
    .sort((a, b) => a.date.localeCompare(b.date, 'zh-CN'));
  console.log('default dataArray', dataArray);
  // I want to add it in the theme file, but failed to do that
  const itemStyle = {
    normal: {
      lineStyle: {
        width: 3, // 0.1的线条是非常细的了
      },
    },
  };

  const markPoint = {
    data: [{ type: 'max', name: '最大值' }],
  };

  const series = filteredDimensions.map(item => ({
    type: 'line',
    stack: '总量',
    symbolSize: '2',
    symbol: 'circle',
    smooth: true,
    areaStyle: {},
    markPoint,
    itemStyle,
  }));
  return { dimensions, series, dataArray };
};

const defaultImageListOf = (mainObject, imageList) => {
  const filteredList = imageList(mainObject).filter(item => item.imageLocation != null);
  if (filteredList.length === 0) {
    return null;
  }

  return (
    <Card title="图片列表" className={styles.card}>
      <Row type="flex" justify="start" align="bottom">
        {filteredList.map((item, index) => (
          <Col span={6} key={index}>
            <ImagePreview
              imageTitle={item.title}
              imageStyle={{width:400}}
              showTitleUnderImage={true}
              imageLocation={item.imageLocation}
            >
              {item.title}
            </ImagePreview>
          </Col>
        ))}
      </Row>
    </Card>
  );
};

const defaultSettingListOf = (mainObject, optionList) => {
  const resultList = optionList(mainObject);
  if (resultList.length === 0) {
    return null;
  }
  return (
    <Card title="状态集合" className={styles.card}>
      {resultList.map(item => (
        <Col key={item.parameterName} span={6} style={{ height: '60px' }}>
          <Switch
            title={item.title}
            checked={item.value}
            type={item.value ? 'success' : 'error'}
            checkedChildren="是"
            unCheckedChildren="否"
          />
          <span style={{ margin: '10px' }}>{item.title}</span>
        </Col>
      ))}
    </Card>
  );
};

const defaultLargeTextOf = mainObject => {
  return null;
};

/////////////////////////////////////// BUILD FOR TRANSFERRING TO ANOTHER OBJECT////////////////////////////////////////////////
//TODO: repalce with service
const defaultHandleTransferSearch = (targetComponent, filterKey, newRequest) => {
  const parameters = newRequest || targetComponent.state;
  
  const {
    candidateServiceFunc,
    candidateObjectType,
    targetLocalName,
    transferServiceFunc,
  } = parameters;

  

  const id = ''; //not used for now
  const pageNo = 1;
  const candidateReferenceService = candidateServiceFunc;
  if (!candidateReferenceService) {
    console.log('candidateReferenceService current state, not working', parameters);
    return;
  }
  // get a function for fetching the candidate reference list
  const future = candidateReferenceService(candidateObjectType, id, filterKey, pageNo);

  future.then(candidateReferenceList => {
    targetComponent.setState({
      ...parameters,
      candidateReferenceList,
      transferModalVisiable: true,
      transferModalTitle: '重新分配<' + targetLocalName + '>',
    });
  });
};
//  onClick={()=>showTransferModel(targetComponent,"城市","city","requestCandidateDistrict","transferToAnotherDistrict")}

const defaultExecuteTrans = (mainObject, targetComponent) => {
  const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = targetComponent.props.form;
  const {
    candidateServiceFunc,
    candidateObjectType,
    targetLocalName,
    transferServiceFunc,
    defaultType,
  } = targetComponent.state;

  const { dispatch } = targetComponent.props;

  validateFieldsAndScroll((error, values) => {
    console.log('error', values);

    const parameters = { ...values };
    const id = mainObject.id;
    const serviceNameToCall = transferServiceFunc;
    console.log('service to call ', serviceNameToCall);
    const payload = { parameters, id, serviceNameToCall };

    //targetComponent.setState({transferModalVisiable:false})
    dispatch({ type: `_${defaultType}/doJob`, payload: payload });

    targetComponent.setState({ transferModalVisiable: false });
  });
};

const defaultShowTransferModel = (
  targetComponent,
  targetLocalName,
  candidateObjectType,
  candidateServiceFunc,
  transferServiceFunc,
  transferTargetParameterName,
  currentValue
) => {
  const filterKey = '';

  const newRequest = {
    targetLocalName,
    candidateObjectType,
    candidateServiceFunc,
    transferServiceFunc,
    transferTargetParameterName,
    currentValue,
  };
  console.log('showTransferModel  new state', newRequest);
  //targetComponent.setState(newState);
  defaultHandleTransferSearch(targetComponent, filterKey, newRequest);
};

const defaultBuildTransferModal = (mainObject, targetComponent) => {
  const {
    transferModalVisiable,
    targetLocalName,
    transferModalTitle,
    candidateReferenceList,
    transferTargetParameterName,
    currentValue,
  } = targetComponent.state;
  const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = targetComponent.props.form;

  if (!candidateReferenceList || !candidateReferenceList.candidates) {
    return null;
  }

  const formItemLayout = {
    labelCol: { span: 8 },
    wrapperCol: { span: 16 },
  };

  const list = candidateReferenceList.candidates;
  console.log('the list is ', list);

  return (
    <Modal
      title={transferModalTitle}
      visible={transferModalVisiable}
      onOk={() => defaultExecuteTrans(mainObject, targetComponent)}
      onCancel={() => defaultHideCloseTrans(targetComponent)}
    >
      <Form>
        <Row gutter={16}>
          <Col lg={24} md={24} sm={24}>
            <Form.Item label={`请选择新的${targetLocalName}`} {...formItemLayout}>
              {getFieldDecorator(transferTargetParameterName, {
                rules: [{ required: true, message: '请搜索' }],
                initialValue: currentValue,
              })(
                <AutoComplete
                  dataSource={list}
                  onSearch={value => defaultHandleTransferSearch(targetComponent, value)}
                >
                  {list.map((item, index) => {
                    return <Option key={item.id}>{`${item.displayName}(${item.id})`}</Option>;
                  })}
                </AutoComplete>
              )}
            </Form.Item>
          </Col>
        </Row>
      </Form>
    </Modal>
  );
};


const renderFunctions = (mainObject) => {
  const actionList = mainObject.actionList.filter(item=>item.actionGroup==='changerequesttype')
  // const actionList = platform.actionList


  if(!actionList){
    return null
  }
  if(actionList.length === 0){
    return null
  }

  return (

    <List
    grid={{ gutter: 16, xs: 4, sm: 4, md: 4, lg: 6, xl: 6, xxl: 6 }}
    dataSource={actionList}
    renderItem={item => (
      <List.Item>
        <Card title={item.actionName}  style={{ textAlign: "center" }}><Link to={item.actionPath}>
        
        <Icon type={item.actionIcon} style={{ fontSize: 50, color: 'orange' }}/>

       </Link></Card>
      </List.Item>
    )}
  />



   
  )
};

const defaultRenderExtraHeader = mainObject => {
  
  return renderFunctions(mainObject)


};


const defaultRenderAnalytics= mainObject => {
  const data = aggregateDataset(mainObject);
  if (!data.dataArray) {
    return null;
  }
  if (data.dataArray.length === 0) {
    return null;
  }
  return (
    <div>
      {renderForNumbers(data)}
      {renderForTimeLine(data)}
    </div>
  );
};

const legalListForDisplay=(targetObject, listItem)=>{

  if(!targetObject){
    return false
  }
  if(!listItem){
    return false
  }
  if(!listItem.name){
    return false
  }
  if(!targetObject[listItem.name]){
    return false
  }

  return true

}
const defaultRenderSubjectList2 = cardsData => {
  
  // listItem.renderItem(item)
  const targetObject = cardsData.cardsSource
  return (
    <Row gutter={16}>
      
      {cardsData.subItems
        
        .filter(listItem=>legalListForDisplay(targetObject,listItem))
        .map(listItem => (
         
          <Col key={listItem.displayName} span={24} {...wholeLineColProps}>
            
             <Card title={listItem.displayName} style={{ marginBottom: 24 }} >

            {
             
              targetObject[listItem.name].map(item=>(listItem.renderItem(item)))
            }
           
             </Card>
          </Col>
         
        ))}
    </Row>
    
  );
};
const defaultRenderSubjectList = cardsData => {
  
  // listItem.renderItem(item)
  const targetObject = cardsData.cardsSource
  const { TabPane } = Tabs;
  function callback(key) {
    console.log(key);
  }
  return (
    <Row gutter={16}>
      <Tabs  onChange={callback}>
      {cardsData.subItems
        
        .filter(listItem=>legalListForDisplay(targetObject,listItem))
        .map(listItem => (
          <TabPane tab={listItem.displayName} key={listItem.displayName}>
          <Col key={listItem.displayName} span={24} {...wholeLineColProps}>
            
             <Card title={listItem.displayName} style={{ marginBottom: 24 }} >

            {
             
              targetObject[listItem.name].map(item=>(listItem.renderItem(item)))
            }
           
             </Card>
          </Col>
          </TabPane>
        ))}
        </Tabs>
    </Row>
    
  );
};

const defaultRenderExtraFooter = mainObject => {
  return null;
};
const defaultSubListsOf = cardsData => {
  const userContext = null;
  const { id } = cardsData.cardsSource;
  return (
    <Row gutter={24}>
      {cardsData.subItems
        .sort((x, y) => x.displayName.localeCompare(y.displayName, 'zh-CN'))
        .filter(item => hasItemReadPermission(item))
        .map(item => (
          <Col {...topColResponsiveProps} key={item.name}>
            <Card
              title={
                <span>
                <Link to={`/${cardsData.cardsFor}/${id}/list/${item.name}/${item.displayName}列表`}>
                {item.displayName}({numeral(item.count).format('0,0')})
                
                </Link>
                {hasItemCreatePermission(item) && (
                  <Link to={`/${cardsData.cardsFor}/${id}/list/${item.role}CreateForm`}>
                    <span className={styles.splitLine} />
                    <FontAwesome name="plus" />
                    {appLocaleName(userContext, 'Add')}
                </Link>)}</span>}
         
            >
              <p>
               
              </p>
            </Card>
          </Col>
        ))}
    </Row>
  );
};


const defaultQuickFunctions = cardsData => {
  
  const { id, actionList } = cardsData.cardsSource;
  return (
    <Row gutter={16}>
      {
       actionList&&actionList.filter(item => item.actionGroup==="custom")
        .map(item=>(

          
          <Col {...quckFunctionProps}  key={`${item.actionPath}`}>
          <Card style={{fontSize:"20px"}}>
          <a href={`${PREFIX}${item.managerBeanName}/${item.actionPath}`} target="_blank">
          <Icon type={item.actionIcon} /> {item.actionName}
          </a>
          </Card>
          </Col>
        ))


      }
      {cardsData&&cardsData.subItems&&cardsData.subItems
        
        .filter(item => hasItemReadPermission(item))
        .map(item => (
          <Col key={item.displayName} {...quckFunctionProps} ><Card span={6} style={{fontSize:"20px"}}>
           <Row gutter={16}>
           {hasItemCreatePermission(item) && (
          <Col span={3}>
          <Tooltip title={`增加一个${item.displayName}`} placement="bottom">  
           <Link to={`/${cardsData.cardsFor}/${id}/list/${item.role}CreateForm`} >
           
         <Icon type="plus" />
         </Link></Tooltip>
         </Col>)}
         
         <Col span={21}>

         <Tooltip title={`进入${item.displayName}列表`} placement="bottom">  
         <Link  to={`/${cardsData.cardsFor}/${id}/list/${item.name}/${item.displayName}列表`}>
         {item.displayName} </Link><span style={{fontSize:"10px"}}> 共{item.count}条</span>
         </Tooltip>
         
         </Col>
         
         
         
         </Row>
     
    </Card></Col>
         
        ))}
    </Row>
    
  );
};


const defaultHideCloseTrans = targetComponent => {
  targetComponent.setState({ transferModalVisiable: false });
};

const renderTitle=(listItem,cardsData)=>{
  const {id} = cardsData.cardsSource
  return <div>{listItem.displayName}({listItem.count})
   <Link to={`/${cardsData.cardsFor}/${id}/list/${listItem.name}/${listItem.displayName}列表`}>
   <Icon type="double-right" />
   </Link>
   </div>

}

const renderListContent=(targetObject, listItem)=>{

  const listContent = targetObject[listItem.name];
  if(!listContent){
    return (<div>稍等...</div>)
  }
  return listContent.map(item=>(listItem.renderItem(item)))

}
const defaultRenderSettingList = cardsData => {
  
  // listItem.renderItem(item)
  const targetObject = cardsData.cardsSource
  
  return (
    <Collapse bordered={false} defaultActiveKey={['1']}>
      
      {cardsData.subItems
        
        
        .map((listItem) => (
    
          <Panel header={renderTitle(listItem,cardsData)} key={listItem.name}>
            {
             renderListContent(targetObject,listItem,cardsData)
            }
           
          </Panel>
        ))}
    </Collapse>
    
  );
};



const DashboardTool = {
  aggregateDataset,
  calcKey,
  defaultHideCloseTrans,
  defaultImageListOf,
  defaultSettingListOf,
  defaultBuildTransferModal,
  defaultExecuteTrans,
  defaultHandleTransferSearch,
  defaultShowTransferModel,
  defaultRenderExtraHeader,
  defaultRenderAnalytics,
  defaultSubListsOf,
  defaultRenderExtraFooter,
  renderForTimeLine,
  renderForNumbers,defaultQuickFunctions,defaultRenderSubjectList,defaultRenderSettingList,
};

export default DashboardTool;



