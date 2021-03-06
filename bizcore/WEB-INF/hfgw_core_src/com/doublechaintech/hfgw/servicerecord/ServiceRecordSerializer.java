package com.doublechaintech.hfgw.servicerecord;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.hfgw.HfgwObjectPlainCustomSerializer;
public class ServiceRecordSerializer extends HfgwObjectPlainCustomSerializer<ServiceRecord>{

	@Override
	public void serialize(ServiceRecord serviceRecord, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, serviceRecord, provider);
		
	}
}


