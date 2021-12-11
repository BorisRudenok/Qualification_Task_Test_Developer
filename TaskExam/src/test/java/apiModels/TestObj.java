package apiModels;

import lombok.Data;

@Data
public class TestObj {
    String duration;
    String method;
    String name;
    String startTime;
    String endTime;
    String status;

    public String getStartTime() {
    }
}
