package com.doublechaintech.hfgw.formmessage;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.hfgw.HfgwObjectPlainCustomSerializer;
public class FormMessageSerializer extends HfgwObjectPlainCustomSerializer<FormMessage>{

	@Override
	public void serialize(FormMessage formMessage, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, formMessage, provider);
		
	}
}


