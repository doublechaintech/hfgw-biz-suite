package com.doublechaintech.hfgw.grpcoption;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.hfgw.HfgwObjectPlainCustomSerializer;
public class GrpcOptionSerializer extends HfgwObjectPlainCustomSerializer<GrpcOption>{

	@Override
	public void serialize(GrpcOption grpcOption, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, grpcOption, provider);
		
	}
}


