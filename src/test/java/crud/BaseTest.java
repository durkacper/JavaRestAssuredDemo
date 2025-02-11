package crud;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BaseTest {

    protected RequestSpecification reqSpec;
    protected ResponseSpecification respSpec;

    @BeforeClass
    public void setup() {
        reqSpec = new RequestSpecBuilder()
                .setBaseUri("http://localhost:3000")
                .setBasePath("/posts")
                .setContentType(ContentType.JSON)
                .build();

        respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        RequestLoggingFilter reqLog = new RequestLoggingFilter();
        ResponseLoggingFilter respLog = new ResponseLoggingFilter();
        RestAssured.filters(reqLog, respLog);
    }

    @AfterClass
    public void tearDown() throws IOException {
        // Delete the file after all tests are executed
        File dbFile = new File(System.getProperty("user.home") + "/postsDb.json");
        Files.deleteIfExists(dbFile.toPath());

        // Copy the original file back to the user's home directory
        File dbFileCopy = new File("src/test/resources/postsDbCopy.json");
        Files.copy(dbFileCopy.toPath(), Path.of(System.getProperty("user.home") + "/postsDb.json"));
    }
}
