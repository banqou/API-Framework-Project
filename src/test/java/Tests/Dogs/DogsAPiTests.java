package Tests.Dogs;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.Success_Status_Code;
import static Common.RequestBuilder.*;
import static org.hamcrest.Matchers.*;

@Test
@Feature("Dogs API")
@Story("Get list of all breeds")
public class DogsAPiTests {

    @Description("As an api user i want to get the list of all breeds")
    @Severity(SeverityLevel.CRITICAL)
    public void getListOfAllBreedsTests(){
        getListOfAllBreedsResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body(containsString("borzoi")).
                body(containsString("mountain")).
                body(containsString("wolfhound"));
    }

    @Description("As an api user i want to display single random image from all dogs collection")
    @Severity(SeverityLevel.CRITICAL)
    public void getDisplaySingleRandomImageFromAllDogsCollectionTests(){
        getDisplaySingleRandomImageFromAllDogsCollectionResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("message", notNullValue()).
                body("status",containsStringIgnoringCase("success"));
    }

    @Description("As an api user i want to get a dog by breed")
    @Severity(SeverityLevel.CRITICAL)
    public void getByBreed(){
        getDogsByBreedResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("message", notNullValue()).
                body("status",containsStringIgnoringCase("success"));
    }

    @Description("As an api user i want to get Breeds List")
    @Severity(SeverityLevel.CRITICAL)
    public void getByBreedsListTest(){
        getBreedsListResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("message", notNullValue()).
                body("status",containsStringIgnoringCase("success"));
    }

}
