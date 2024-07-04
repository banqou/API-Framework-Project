package Tests.WeatherAPI;

import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.*;
import static Common.RequestBuilder.*;
import static org.hamcrest.Matchers.*;


@Test
@Feature("OpenWeatherMap")
@Story("Register new Weather Station")
public class WeatherStationTests {
    @Description("As an api user i want to Register a new Weather Station")
    @Severity(SeverityLevel.CRITICAL)
    public void registerNewWeatherStationTests() {
        registerNewWeatherStationResponse().
                then().
                assertThat().
                statusCode(Create_Success_Status_Code).
                body("ID", notNullValue()).
                body("updated_at", notNullValue()).
                body("created_at", notNullValue()).
                body("external_id", containsStringIgnoringCase("MD_Testing01")).
                body("name", containsStringIgnoringCase("Midrand Test Station")).
                body("latitude", notNullValue()).
                body("longitude", notNullValue()).
                body("altitude", notNullValue()).
                body("rank", notNullValue()).
                body("source_type", notNullValue());


    }
    @Test(dependsOnMethods = "registerNewWeatherStationTests")
    @Description("This is to get information of the newly created Weather Station")
    @Severity(SeverityLevel.CRITICAL)
    public void getNewWeatherStationInfoTests(){
        getNewWeatherStationInfoResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("id",notNullValue()).
                body("created_at",notNullValue()).
                body("updated_at", notNullValue()).
                body("external_id",notNullValue()).
                body("name", notNullValue()).
                body("longitude", notNullValue()).
                body("latitude", notNullValue()).
                body("altitude", notNullValue()).
                body("rank", notNullValue());
    }

    @Test(dependsOnMethods = "registerNewWeatherStationTests")
    @Description("As an api user I want to update the newly created weather station")
    @Severity(SeverityLevel.CRITICAL)
    public void updateWeatherStationInfoTests() {
        updateWeatherStationInfoResponse().
                then ().
                assertThat ().
                statusCode (Success_Status_Code).
                body ("created_at", notNullValue ()).
                body ("updated_at", notNullValue ()).
                body ("external_id", containsStringIgnoringCase ("MD_UpdTesting01")).
                body ("name", containsStringIgnoringCase ("Midrand Test Updated Station")).
                body ("latitude", notNullValue ()).
                body ("longitude", notNullValue ()).
                body ("altitude", notNullValue ()).
                body ("rank", notNullValue ());
    }


    //*** NEGATIVE TEST HERE***
    @Description("As an api user I want to validate that the response status code is 400")
    @Severity(SeverityLevel.CRITICAL)
    public void updateWeatherStationWithInvalidLongitudeValuesTests() {
        updateWeatherStationWithInvalidLongitudeValuesResponse ().
                then ().
                assertThat ().
                statusCode (Bad_Request_Status_Code);
    }

    @Description("As an api user I want register a Longitute as a String")
    @Severity(SeverityLevel.CRITICAL)
    public void registerWeatherStationWithLongitudeAsStringTests() {
        registerNewWeatherStationWithLongitudeAsStringResponse().
                then ().
                assertThat ().
                statusCode (Bad_Request_Status_Code);
    }

    @Description("As an api user i want to Register Weather Station With Name Empty")
    @Severity(SeverityLevel.CRITICAL)
    public void postWeatherStationWithNameEmptyTests() {
        postWeatherStationWithNameEmptyResponse().
                then().
                assertThat().
                statusCode (Bad_Request_Status_Code).
                body("code", notNullValue()).
                body("message", containsStringIgnoringCase ("Bad or zero length station name"));
    }

    @Description("As an api user I want Get Weather Station Info with Invalid Station ID")
    @Severity(SeverityLevel.CRITICAL)
    public void getWeatherStationInfowithInvalidStationIDTests() {
        getWeatherStationInfowithInvalidStationIDResponse().
                then ().
                assertThat ().
                statusCode (Bad_Request_Status_Code).
                body ("code", notNullValue ()).
                body ("message", containsStringIgnoringCase ("Station id not valid"));
    }

    @Test(dependsOnMethods = "registerNewWeatherStationTests")
    @Description("As an api user I want to validate that the response status code is 400")
    @Severity(SeverityLevel.CRITICAL)
    public void getNewWeatherStationWithNonExistingStationIDTests() {
        getNewWeatherStationWithNonExistingStationIDResponse().
                then().
                assertThat().
                statusCode(Bad_Request_Status_Code);
    }
    @Test(dependsOnMethods = "registerNewWeatherStationTests")
    @Description("As an api user I want to validate that the response status code is 400")
    @Severity(SeverityLevel.CRITICAL)
    public void updateWeatherStationWithLongitudeAsStringTests() {
        updateWeatherStationWithLongitudeAsStringResponse().
                then ().
                assertThat ().
                statusCode (Bad_Request_Status_Code);
    }

    @Description("As an api user i want to delete a Weather Station")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dependsOnMethods = {"registerNewWeatherStationTests","updateWeatherStationInfoTests","getNewWeatherStationInfoTests"})
    public void DeleteWeatherStationTest() {
        DeleteWeatherStationResponse().
                then().
                assertThat().
                statusCode(delete_Success_Status_Code);

    }

}

