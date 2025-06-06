package scripts.category_scenarios;

import endpoints.CategoryEndpoints;
import io.restassured.response.Response;
import entity.Category;

public class CategoryScenarios {

    // ✅ Add a new category (requires superadmin token)
    public static void addCategory(String token, Category category) {
        Response response = CategoryEndpoints.addCategory(token, category);
        response.then().log().all();
        System.out.println("Status Code: " + response.getStatusCode());
    }

    // ✅ Get all categories (no token required)
    public static void getAllCategories() {
        Response response = CategoryEndpoints.getAllCategories();
        response.then().log().all();
        System.out.println("Total Categories Fetched.");
    }

    // ✅ Get total category count
    public static void getCategoryCount() {
        Response response = CategoryEndpoints.getCategoryCount();
        response.then().log().all();
        System.out.println("Category Count Retrieved.");
    }

    // ✅ Get product count per category
    public static void getProductCountPerCategory() {
        Response response = CategoryEndpoints.getProductCountPerCategory();
        response.then().log().all();
        System.out.println("Product Count Per Category Retrieved.");
    }

    // ✅ Get a single category by ID
    public static void getCategoryById(String categoryId) {
        Response response = CategoryEndpoints.getCategoryById(categoryId);
        response.then().log().all();
        System.out.println("Category Data Retrieved.");
    }

    // ✅ Update a category by ID (requires superadmin token)
    public static void updateCategoryById(String token, String categoryId, Category updatedCategory) {
        Response response = CategoryEndpoints.updateCategoryById(token, categoryId, updatedCategory);
        response.then().log().all();
        System.out.println("Update Status Code: " + response.getStatusCode());
    }

    // ✅ Delete a category by ID (requires superadmin token)
    public static void deleteCategoryById(String token, String categoryId) {
        Response response = CategoryEndpoints.deleteCategoryById(token, categoryId);
        response.then().log().all();
        System.out.println("Delete Status Code: " + response.getStatusCode());
    }
}
