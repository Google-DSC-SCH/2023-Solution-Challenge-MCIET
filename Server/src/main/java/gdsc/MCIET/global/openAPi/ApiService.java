package gdsc.MCIET.global.openAPi;

import gdsc.MCIET.domain.cuisine.presentation.dto.request.SaveCuisineDto;
import gdsc.MCIET.domain.cuisine.service.CuisineService;
import gdsc.MCIET.domain.recipe.presentation.dto.request.SaveRecipeDto;
import gdsc.MCIET.domain.recipe.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Service
@RequiredArgsConstructor
public class ApiService {

    private final CuisineService cuisineService;
    private final RecipeService recipeService;

    //api연결
    private String loadFromApi(){
        String result = "";
        try{
            URL url = new URL("http://openapi.foodsafetykorea.go.kr/api/05ab6eb2f8424a4a89a5/COOKRCP01/json/1/20");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("Content-type", "application/json");


            BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            result = bf.readLine();

            return result.toString();
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //JSON 파싱
    private JSONObject parseJSON(String result){
        try{
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result.toString());

            return jsonObject;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    //DB 저장
    public void saveWithPoint() {
        String result = loadFromApi();
        JSONObject jsonObject = parseJSON(result);

        JSONObject cookrcp01 = (JSONObject) jsonObject.get("COOKRCP01");
        JSONArray jsonArray = (JSONArray) cookrcp01.get("row");

        for (int i = 01; i < jsonArray.size(); i++) {
            JSONObject object = (JSONObject) jsonArray.get(i);
            String name = (String) object.get("RCP_NM");
            String ingredients = (String) object.get("RCP_PARTS_DTLS");
            SaveCuisineDto saveCuisineDto = new SaveCuisineDto(name, ingredients);
            Long cuisineId = cuisineService.saveCuisine(saveCuisineDto);
            for (int j = 1; j < 10; j++) {
                String sequence = String.format("%1$02d", j);
                String exposition = (String) object.get("MANUAL" + sequence);
                if (!exposition.equals("")) {
                    String pictureUrl = (String) object.get("MANUAL_IMG"+sequence);
                    SaveRecipeDto saveRecipeDto = new SaveRecipeDto(cuisineId, exposition, pictureUrl);
                    recipeService.saveRecipe(saveRecipeDto);
                }
            }
        }
    }
}
