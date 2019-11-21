package com.doublechaintech.hfgw.channelpeerrole;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.hfgw.HfgwObjectPlainCustomSerializer;
public class ChannelPeerRoleSerializer extends HfgwObjectPlainCustomSerializer<ChannelPeerRole>{

	@Override
	public void serialize(ChannelPeerRole channelPeerRole, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, channelPeerRole, provider);
		
	}
}


