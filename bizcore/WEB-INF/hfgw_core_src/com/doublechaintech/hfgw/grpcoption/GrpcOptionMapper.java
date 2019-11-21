
package com.doublechaintech.hfgw.grpcoption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.node.Node;

public class GrpcOptionMapper extends BaseRowMapper<GrpcOption>{
	
	protected GrpcOption internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		GrpcOption grpcOption = getGrpcOption();		
		 		
 		setId(grpcOption, rs, rowNumber); 		
 		setParameterName(grpcOption, rs, rowNumber); 		
 		setParameterValue(grpcOption, rs, rowNumber); 		
 		setNode(grpcOption, rs, rowNumber); 		
 		setVersion(grpcOption, rs, rowNumber);

		return grpcOption;
	}
	
	protected GrpcOption getGrpcOption(){
		return new GrpcOption();
	}		
		
	protected void setId(GrpcOption grpcOption, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(GrpcOptionTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		grpcOption.setId(id);
	}
		
	protected void setParameterName(GrpcOption grpcOption, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String parameterName = rs.getString(GrpcOptionTable.COLUMN_PARAMETER_NAME);
		if(parameterName == null){
			//do nothing when nothing found in database
			return;
		}
		
		grpcOption.setParameterName(parameterName);
	}
		
	protected void setParameterValue(GrpcOption grpcOption, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String parameterValue = rs.getString(GrpcOptionTable.COLUMN_PARAMETER_VALUE);
		if(parameterValue == null){
			//do nothing when nothing found in database
			return;
		}
		
		grpcOption.setParameterValue(parameterValue);
	}
		 		
 	protected void setNode(GrpcOption grpcOption, ResultSet rs, int rowNumber) throws SQLException{
 		String nodeId = rs.getString(GrpcOptionTable.COLUMN_NODE);
 		if( nodeId == null){
 			return;
 		}
 		if( nodeId.isEmpty()){
 			return;
 		}
 		Node node = grpcOption.getNode();
 		if( node != null ){
 			//if the root object 'grpcOption' already have the property, just set the id for it;
 			node.setId(nodeId);
 			
 			return;
 		}
 		grpcOption.setNode(createEmptyNode(nodeId));
 	}
 	
	protected void setVersion(GrpcOption grpcOption, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(GrpcOptionTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		grpcOption.setVersion(version);
	}
		
		

 	protected Node  createEmptyNode(String nodeId){
 		Node node = new Node();
 		node.setId(nodeId);
 		node.setVersion(Integer.MAX_VALUE);
 		return node;
 	}
 	
}


