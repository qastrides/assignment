package com.assignment;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
public class RestTest extends BaseClass {
    static boolean flag = false;
    String categoryName = null;

    // ###########################################################################################################################################
    // Test Name:  testResponse
    // Input Parameter: None
    // Output Parameter: None
    // Description:  To test below acceptance criteria
    // Acceptance criteria 1: Verification of "Carbon credits" value in "Name" property
    // Acceptance criteria 2: Verification of boolean value as 'true' in "CanRelist" property
    // Acceptance criteria 3 : The Promotions element with Name = "Gallery" has a Description that contains the text "Good position in category"
    // ##############################################################################################################################################
    @Test
    public void testResponse() {
        readPropFile();
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(BaseClass.baseURL);

        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Then simply query the JsonPath object to get a String value of the node
        // specified by JsonPath
        categoryName = jsonPathEvaluator.get("Name");

        //Acceptance criteria 1 : Verification of "Carbon credits" value in name property
        Assert.assertEquals(categoryName, "Carbon credits", "Correct name received in the Response");

        //Acceptance criteria 2 : Verification of boolean value as 'true' in CanRelist property
        Assert.assertTrue(jsonPathEvaluator.get("CanRelist"), "Boolean value is correctly returned as true for CanRelist property");

        // Acceptance criteria 3 : The Promotions element with Name = "Gallery" has a Description that contains the text "Good position in category"
        List<String> allPromotions = jsonPathEvaluator.getList("Promotions.Name");
        List<String> allDescriptions = jsonPathEvaluator.getList("Promotions.Description");

        for (String promotion : allPromotions) {
            System.out.println("Promotion: " + promotion);
            for (String desc : allDescriptions) {
                System.out.println("Descriptions: " + desc);
                if (promotion.equalsIgnoreCase("Gallery")) {
                    if (desc.equalsIgnoreCase("Good position in category")) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        Assert.assertTrue(flag, "Value matched");
    }
}
