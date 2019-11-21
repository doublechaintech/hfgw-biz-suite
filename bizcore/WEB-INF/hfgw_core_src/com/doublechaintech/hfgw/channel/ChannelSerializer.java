package com.doublechaintech.hfgw.channel;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.hfgw.HfgwObjectPlainCustomSerializer;
public class ChannelSerializer extends HfgwObjectPlainCustomSerializer<Channel>{

	@Override
	public void serialize(Channel channel, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, channel, provider);
		
	}
}


