package com.doublechaintech.hfgw.transactionstatus;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.hfgw.HfgwObjectPlainCustomSerializer;
public class TransactionStatusSerializer extends HfgwObjectPlainCustomSerializer<TransactionStatus>{

	@Override
	public void serialize(TransactionStatus transactionStatus, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, transactionStatus, provider);
		
	}
}


