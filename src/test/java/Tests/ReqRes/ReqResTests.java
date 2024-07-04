package Tests.ReqRes;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static Common.CommonTestData.*;
import static Common.RequestBuilder.*;
import static org.hamcrest.Matchers.*;

@Test
@Feature("Req Res")
@Story("Create new user")
public class ReqResTests {

    @Description("As an api user i want to create a new user")
    @Severity(SeverityLevel.CRITICAL)
    public void createUserTests(){
        createUserResponse().
                then().
                assertThat().
                statusCode(Create_Success_Status_Code).
                body("name",containsStringIgnoringCase("Nkosi")).
                body("job",containsStringIgnoringCase("Tester")).
                body("id", notNullValue()).
                body("createdAt", notNullValue());
    }

@Description("As an api user i want to get List of Users ")
@Severity(SeverityLevel.CRITICAL)
    public void getListUsersTest(){
        getListUsersResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("page",is(2)).
                body("per_page",is(6)).
                body("total", is(12)).
                body("total_pages", is(2)).
                body("data", hasSize(6)).
                body("support", notNullValue());
    }
    public void updateUserTests() {
        updateUserResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("name", containsStringIgnoringCase("Letho")).
                body("surname", containsStringIgnoringCase("Mjoli")).
                body("job", containsStringIgnoringCase("Tester")).
                body("updatedAt", notNullValue());
    }

    @Description("As an api user i want to update User")
    @Severity(SeverityLevel.CRITICAL)
    public void patchUpdateUserTests() {
        patchUpdateUserResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("name", containsStringIgnoringCase("Que")).
                body("job", containsStringIgnoringCase("Tester")).
                body("updatedAt", notNullValue());
    }

    @Description("This is to display a list of resources")
    @Severity(SeverityLevel.CRITICAL)
    public void getListResourceTests(){
        getListResourceResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("page",is(1)).
                body("per_page",is(6)).
                body("total", is(12)).
                body("total_pages", is(2)).
                body("data", hasSize(6)).
                body("support", notNullValue());
    }

    @Description("This is to log in successfully")
    @Severity(SeverityLevel.CRITICAL)
    public void loginSuccessfullyTests() {
        loginSuccessfullyResponse().
                then().
                assertThat().
                statusCode(Success_Status_Code).
                body("token", containsStringIgnoringCase("QpwL5tke4Pnpja7X4"));
    }
    @Description("This is to log in unsuccessfully")
    @Severity(SeverityLevel.CRITICAL)
    public void loginUnSuccessfullyTests() {
        loginUnSuccessfullyResponse().
                then().
                assertThat().
                statusCode(Bad_Request_Status_Code).
                body("error", containsStringIgnoringCase ("Missing password"));
    }

    @Description("As an api user i want to get 'Not Found' error for single user ")
    @Severity(SeverityLevel.CRITICAL)
    public void getSingleUserNotFoundTest(){
        getSingleUserNotFoundResponse().
                then().
                assertThat().
                statusCode(Not_Found_Status_Code);
    }

}
