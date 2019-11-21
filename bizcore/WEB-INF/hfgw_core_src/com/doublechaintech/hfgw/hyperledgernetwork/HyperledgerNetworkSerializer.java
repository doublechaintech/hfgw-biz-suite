package com.doublechaintech.hfgw.hyperledgernetwork;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.hfgw.HfgwObjectPlainCustomSerializer;
public class HyperledgerNetworkSerializer extends HfgwObjectPlainCustomSerializer<HyperledgerNetwork>{

	@Override
	public void serialize(HyperledgerNetwork hyperledgerNetwork, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, hyperledgerNetwork, provider);
		
	}
}


