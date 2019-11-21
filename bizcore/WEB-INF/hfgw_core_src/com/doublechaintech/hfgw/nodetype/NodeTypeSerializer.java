package com.doublechaintech.hfgw.nodetype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.hfgw.HfgwObjectPlainCustomSerializer;
public class NodeTypeSerializer extends HfgwObjectPlainCustomSerializer<NodeType>{

	@Override
	public void serialize(NodeType nodeType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, nodeType, provider);
		
	}
}


