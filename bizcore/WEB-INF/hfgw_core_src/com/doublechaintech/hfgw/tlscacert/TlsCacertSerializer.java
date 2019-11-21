package com.doublechaintech.hfgw.tlscacert;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.hfgw.HfgwObjectPlainCustomSerializer;
public class TlsCacertSerializer extends HfgwObjectPlainCustomSerializer<TlsCacert>{

	@Override
	public void serialize(TlsCacert tlsCacert, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, tlsCacert, provider);
		
	}
}


