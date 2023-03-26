package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonReader {
    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());;

    public static List<Order> readOrders(String filePath) throws IOException {
        return mapper.readValue(new File(filePath), new TypeReference<List<Order>>(){});
    }

    public static Store readStore(String filePath) throws IOException {
        return mapper.readValue(new File(filePath), Store.class);
    }
}
