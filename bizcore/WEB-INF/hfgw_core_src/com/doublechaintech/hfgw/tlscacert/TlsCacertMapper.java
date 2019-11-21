
package com.doublechaintech.hfgw.tlscacert;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.hfgw.BaseRowMapper;
import com.doublechaintech.hfgw.node.Node;

public class TlsCacertMapper extends BaseRowMapper<TlsCacert>{
	
	protected TlsCacert internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		TlsCacert tlsCacert = getTlsCacert();		
		 		
 		setId(tlsCacert, rs, rowNumber); 		
 		setPath(tlsCacert, rs, rowNumber); 		
 		setCert(tlsCacert, rs, rowNumber); 		
 		setNode(tlsCacert, rs, rowNumber); 		
 		setVersion(tlsCacert, rs, rowNumber);

		return tlsCacert;
	}
	
	protected TlsCacert getTlsCacert(){
		return new TlsCacert();
	}		
		
	protected void setId(TlsCacert tlsCacert, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(TlsCacertTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		tlsCacert.setId(id);
	}
		
	protected void setPath(TlsCacert tlsCacert, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String path = rs.getString(TlsCacertTable.COLUMN_PATH);
		if(path == null){
			//do nothing when nothing found in database
			return;
		}
		
		tlsCacert.setPath(path);
	}
		
	protected void setCert(TlsCacert tlsCacert, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String cert = rs.getString(TlsCacertTable.COLUMN_CERT);
		if(cert == null){
			//do nothing when nothing found in database
			return;
		}
		
		tlsCacert.setCert(cert);
	}
		 		
 	protected void setNode(TlsCacert tlsCacert, ResultSet rs, int rowNumber) throws SQLException{
 		String nodeId = rs.getString(TlsCacertTable.COLUMN_NODE);
 		if( nodeId == null){
 			return;
 		}
 		if( nodeId.isEmpty()){
 			return;
 		}
 		Node node = tlsCacert.getNode();
 		if( node != null ){
 			//if the root object 'tlsCacert' already have the property, just set the id for it;
 			node.setId(nodeId);
 			
 			return;
 		}
 		tlsCacert.setNode(createEmptyNode(nodeId));
 	}
 	
	protected void setVersion(TlsCacert tlsCacert, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(TlsCacertTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		tlsCacert.setVersion(version);
	}
		
		

 	protected Node  createEmptyNode(String nodeId){
 		Node node = new Node();
 		node.setId(nodeId);
 		node.setVersion(Integer.MAX_VALUE);
 		return node;
 	}
 	
}


