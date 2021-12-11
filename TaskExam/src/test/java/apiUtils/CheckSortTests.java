package apiUtils;


import apiModels.TestObj;
import com.google.gson.Gson;
import kong.unirest.json.JSONArray;
import utils.ParsDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckSortTests {
    private final Gson g = new Gson();
    private final ParsDate parsDate = new ParsDate();

    public List<LocalDateTime> sortListDate(JSONArray jsonResponse) {
        List<LocalDateTime> arrayListDate = new ArrayList<>();
        for (int i = 0; i <= jsonResponse.length() - 1; i++) {
            LocalDateTime localDateTime = parsDate.getDate(g.fromJson(String.valueOf(jsonResponse.get(i)),
                    TestObj.class).getStartTime());
            arrayListDate.add(localDateTime);
        }
        arrayListDate.sort(Collections.reverseOrder());
        return arrayListDate;
    }

    public boolean sortingCheckUi(List<LocalDateTime> setListDate1, List<LocalDateTime> setListDate2, int listLength) {
        int resultCompareTo;
        for (int i = 0; i <= listLength; i++) {
            resultCompareTo = setListDate1.get(i).compareTo(setListDate2.get(i));
            if (resultCompareTo != 0) {
                return false;
            }
        }
        return true;
    }
}
