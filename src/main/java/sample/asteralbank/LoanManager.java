package sample.asteralbank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class LoanManager {
    @JsonProperty
    private ArrayList<Loan> loans;
    private File data;
    private ObjectMapper mapper;

    public LoanManager(File data) {
        loans = new ArrayList<>();
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

    public LoanManager(String dataPath) {
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

    public void add(Loan loan) {
        loans.add(loan);
        deload();
    }
}
