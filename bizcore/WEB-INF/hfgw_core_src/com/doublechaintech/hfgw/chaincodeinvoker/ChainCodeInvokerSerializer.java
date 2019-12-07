package com.doublechaintech.hfgw.chaincodeinvoker;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.hfgw.HfgwObjectPlainCustomSerializer;
public class ChainCodeInvokerSerializer extends HfgwObjectPlainCustomSerializer<ChainCodeInvoker>{

	@Override
	public void serialize(ChainCodeInvoker chainCodeInvoker, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, chainCodeInvoker, provider);
		
	}
}


