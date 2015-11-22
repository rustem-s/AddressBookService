package me.pio.addressbook.service.web.provider;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
//@Produces({MediaType.APPLICATION_JSON})
//@Consumes(MediaType.APPLICATION_JSON)
//@Singleton
public class JacksonJsonProvider implements ContextResolver<ObjectMapper> {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
      MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
      MAPPER.disable(MapperFeature.USE_GETTERS_AS_SETTERS);
      //MAPPER.disable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    }

//    public JacksonJsonProvider() {
//        System.out.println("Instantiate MyJacksonJsonProvider");
//    }
     
//    @Override
    public ObjectMapper getContext(Class<?> type) {
        return MAPPER;
    } 
}