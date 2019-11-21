
package com.doublechaintech.hfgw.channelpeerrole;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.hfgw.BaseEntity;
import com.doublechaintech.hfgw.SmartList;
import com.doublechaintech.hfgw.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.hfgw.peerrole.PeerRole;
import com.doublechaintech.hfgw.node.Node;
import com.doublechaintech.hfgw.channel.Channel;

@JsonSerialize(using = ChannelPeerRoleSerializer.class)
public class ChannelPeerRole extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CHANNEL_PROPERTY               = "channel"           ;
	public static final String NODE_PROPERTY                  = "node"              ;
	public static final String PEER_ROLE_PROPERTY             = "peerRole"          ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ChannelPeerRole";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getId();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Channel             	mChannel            ;
	protected		Node                	mNode               ;
	protected		PeerRole            	mPeerRole           ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	ChannelPeerRole(){
		// lazy load for all the properties
	}
	public 	static ChannelPeerRole withId(String id){
		ChannelPeerRole channelPeerRole = new ChannelPeerRole();
		channelPeerRole.setId(id);
		channelPeerRole.setVersion(Integer.MAX_VALUE);
		return channelPeerRole;
	}
	public 	static ChannelPeerRole refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setChannel( null );
		setNode( null );
		setPeerRole( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	

      
	}
    
    


	
	public Object propertyOf(String property) {
     	
		if(CHANNEL_PROPERTY.equals(property)){
			return getChannel();
		}
		if(NODE_PROPERTY.equals(property)){
			return getNode();
		}
		if(PEER_ROLE_PROPERTY.equals(property)){
			return getPeerRole();
		}

    		//other property not include here
		return super.propertyOf(property);
	}
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public ChannelPeerRole updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setChannel(Channel channel){
		this.mChannel = channel;;
	}
	public Channel getChannel(){
		return this.mChannel;
	}
	public ChannelPeerRole updateChannel(Channel channel){
		this.mChannel = channel;;
		this.changed = true;
		return this;
	}
	public void mergeChannel(Channel channel){
		if(channel != null) { setChannel(channel);}
	}
	
	
	public void clearChannel(){
		setChannel ( null );
		this.changed = true;
	}
	
	public void setNode(Node node){
		this.mNode = node;;
	}
	public Node getNode(){
		return this.mNode;
	}
	public ChannelPeerRole updateNode(Node node){
		this.mNode = node;;
		this.changed = true;
		return this;
	}
	public void mergeNode(Node node){
		if(node != null) { setNode(node);}
	}
	
	
	public void clearNode(){
		setNode ( null );
		this.changed = true;
	}
	
	public void setPeerRole(PeerRole peerRole){
		this.mPeerRole = peerRole;;
	}
	public PeerRole getPeerRole(){
		return this.mPeerRole;
	}
	public ChannelPeerRole updatePeerRole(PeerRole peerRole){
		this.mPeerRole = peerRole;;
		this.changed = true;
		return this;
	}
	public void mergePeerRole(PeerRole peerRole){
		if(peerRole != null) { setPeerRole(peerRole);}
	}
	
	
	public void clearPeerRole(){
		setPeerRole ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public ChannelPeerRole updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getChannel(), internalType);
		addToEntityList(this, entityList, getNode(), internalType);
		addToEntityList(this, entityList, getPeerRole(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, CHANNEL_PROPERTY, getChannel());
		appendKeyValuePair(result, NODE_PROPERTY, getNode());
		appendKeyValuePair(result, PEER_ROLE_PROPERTY, getPeerRole());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChannelPeerRole){
		
		
			ChannelPeerRole dest =(ChannelPeerRole)baseDest;
		
			dest.setId(getId());
			dest.setChannel(getChannel());
			dest.setNode(getNode());
			dest.setPeerRole(getPeerRole());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChannelPeerRole){
		
			
			ChannelPeerRole dest =(ChannelPeerRole)baseDest;
		
			dest.mergeId(getId());
			dest.mergeChannel(getChannel());
			dest.mergeNode(getNode());
			dest.mergePeerRole(getPeerRole());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ChannelPeerRole){
		
			
			ChannelPeerRole dest =(ChannelPeerRole)baseDest;
		
			dest.mergeId(getId());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ChannelPeerRole{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getChannel() != null ){
 			stringBuilder.append("\tchannel='Channel("+getChannel().getId()+")';");
 		}
		if(getNode() != null ){
 			stringBuilder.append("\tnode='Node("+getNode().getId()+")';");
 		}
		if(getPeerRole() != null ){
 			stringBuilder.append("\tpeerRole='PeerRole("+getPeerRole().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

