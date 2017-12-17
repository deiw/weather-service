package pl.majorczyk.weatherapp.parser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Component
@Parser(type = Parser.ParserType.CITY)
public class JsonCityParser implements DataParser<String> {
    @Override
    public String parse(String response) {
        String city=null;
        if(response!=null){
            JSONParser parser=new JSONParser();
            try {
                JSONObject obj=(JSONObject)parser.parse(response);
                city=obj.get("city").toString();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return city;
    }
}