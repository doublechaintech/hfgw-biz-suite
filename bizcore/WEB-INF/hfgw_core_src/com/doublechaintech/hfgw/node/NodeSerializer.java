package com.doublechaintech.hfgw.node;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.hfgw.HfgwObjectPlainCustomSerializer;
public class NodeSerializer extends HfgwObjectPlainCustomSerializer<Node>{

	@Override
	public void serialize(Node node, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, node, provider);
		
	}
}


