package scripts.category_scenarios;

import endpoints.CategoryEndpoints;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import entity.Category;

public class CategoryScenarios {

    private final String superadminToken = "your-superadmin-jwt-token-here"; // Replace with dynamic token later
    private final String testCategoryId = "sample-category-id"; // Replace with dynamic ID for real test

    @Test(priority = 1)
    public void addCategoryTest() {
        Category category = new Category();
        category.setCategoryName("Laptops");

        Response response = CategoryEndpoints.addCategory(superadminToken, category);
        response.then().log().all();
        System.out.println("Status Code: " + response.getStatusCode());
    }

    @Test(priority = 2)
    public void getAllCategoriesTest() {
        Response response = CategoryEndpoints.getAllCategories();
        response.then().log().all();
        System.out.println("Total Categories Fetched.");
    }

    @Test(priority = 3)
    public void getCategoryCountTest() {
        Response response = CategoryEndpoints.getCategoryCount();
        response.then().log().all();
        System.out.println("Category Count Retrieved.");
    }

    @Test(priority = 4)
    public void getProductCountPerCategoryTest() {
        Response response = CategoryEndpoints.getProductCountPerCategory();
        response.then().log().all();
        System.out.println("Product Count Per Category Retrieved.");
    }

    @Test(priority = 5)
    public void getCategoryByIdTest() {
        Response response = CategoryEndpoints.getCategoryById(testCategoryId);
        response.then().log().all();
        System.out.println("Category Data Retrieved.");
    }

    @Test(priority = 6)
    public void updateCategoryByIdTest() {
        Category updatedCategory = new Category();
        updatedCategory.setCategoryName("Updated Laptops");

        Response response = CategoryEndpoints.updateCategoryById(superadminToken, testCategoryId, updatedCategory);
        response.then().log().all();
        System.out.println("Update Status Code: " + response.getStatusCode());
    }

    @Test(priority = 7)
    public void deleteCategoryByIdTest() {
        Response response = CategoryEndpoints.deleteCategoryById(superadminToken, testCategoryId);
        response.then().log().all();
        System.out.println("Delete Status Code: " + response.getStatusCode());
    }
}
