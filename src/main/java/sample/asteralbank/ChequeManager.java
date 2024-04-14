package sample.asteralbank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ChequeManager {
    @JsonProperty
    private ArrayList<Cheque> cheques;
    private File data;
    private ObjectMapper mapper;
    
    public ChequeManager(File data) {
        cheques = new ArrayList<>();
        this.data = data;
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        if (!data.isFile()) {
            try {
                data.createNewFile();
                deload();
            }  catch (IOException e) {
                load();
            }
        }
    }

    public ChequeManager(String dataPath)
    {
        this(new File(dataPath));
    }

    public void load()
    {
        try {
            mapper.readerForUpdating(this).readValue(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deload()
    {
        try {
            mapper.writeValue(data, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Cheque cheque) {
        cheques.add(cheque);
        deload();
    }
}
