package br.com.cesar.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class GenderSerializer  extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {
        String formattedSexo = "Masculino".equalsIgnoreCase(value) ? "M" : "F";
        gen.writeString(formattedSexo);

    }
}
