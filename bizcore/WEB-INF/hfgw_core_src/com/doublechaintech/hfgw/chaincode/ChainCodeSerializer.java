package com.doublechaintech.hfgw.chaincode;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.hfgw.HfgwObjectPlainCustomSerializer;
public class ChainCodeSerializer extends HfgwObjectPlainCustomSerializer<ChainCode>{

	@Override
	public void serialize(ChainCode chainCode, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, chainCode, provider);
		
	}
}


