package com.example.spring.json.jsoncomponent.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

@JsonComponent
public class InstantSerializer
{
    // ============================== [Inner Classes] ==============================

    // -------------------- [Public Inner Classes] --------------------

    public static class MyJsonSerializer extends JsonSerializer<Instant>
    {
        // ============================== [Methods] ==============================

        // -------------------- [Public Methods] --------------------

        @Override
        public void serialize(Instant instant, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException
        {
            String instantStr = DateTimeFormatter.ISO_INSTANT.format(instant);

            jsonGenerator.writeString(instantStr);
        }
    }

    public static class MyJsonDeserializer extends JsonDeserializer<Instant>
    {
        // ============================== [Methods] ==============================

        // -------------------- [Public Methods] --------------------

        @Override
        public Instant deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException
        {
            String instantStr = jsonParser.getText();
            Instant instant = DateTimeFormatter.ISO_INSTANT.parse(instantStr, Instant::from);

            return instant;
        }
    }
}
