package com.doublechaintech.hfgw.changerequest;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.hfgw.HfgwObjectPlainCustomSerializer;
public class ChangeRequestSerializer extends HfgwObjectPlainCustomSerializer<ChangeRequest>{

	@Override
	public void serialize(ChangeRequest changeRequest, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, changeRequest, provider);
		
	}
}


