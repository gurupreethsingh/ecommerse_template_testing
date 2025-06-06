package endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import entity.Category; // Make sure this matches your POJO
import static io.restassured.RestAssured.given;
import routes.CategoryRoutes;

public class CategoryEndpoints {

    // 1. POST - Add new category (Requires superadmin token)
    public static Response addCategory(String token, Category category) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(category)
                .when()
                .post(CategoryRoutes.POST_CREATE_CATEGORY_URL);
    }

    // 2. GET - Get all categories
    public static Response getAllCategories() {
        return given()
                .accept(ContentType.JSON)
                .when()
                .get(CategoryRoutes.GET_ALL_CATEGORIES_URL);
    }

    // 3. GET - Get total number of categories
    public static Response getCategoryCount() {
        return given()
                .accept(ContentType.JSON)
                .when()
                .get(CategoryRoutes.GET_CATEGORY_COUNT_URL);
    }

    // 4. GET - Get product count per category
    public static Response getProductCountPerCategory() {
        return given()
                .accept(ContentType.JSON)
                .when()
                .get(CategoryRoutes.GET_CATEGORY_PRODUCT_COUNTS_URL);
    }

    // 5. GET - Get category by ID
    public static Response getCategoryById(String categoryId) {
        String url = CategoryRoutes.GET_CATEGORY_BY_ID_URL.replace(":id", categoryId);
        return given()
                .accept(ContentType.JSON)
                .when()
                .get(url);
    }

    // 6. PUT - Update category by ID (Requires superadmin token)
    public static Response updateCategoryById(String token, String categoryId, Category updatedCategory) {
        String url = CategoryRoutes.PUT_UPDATE_CATEGORY_URL.replace(":id", categoryId);
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(updatedCategory)
                .when()
                .put(url);
    }

    // 7. DELETE - Delete category by ID (Requires superadmin token)
    public static Response deleteCategoryById(String token, String categoryId) {
        String url = CategoryRoutes.DELETE_CATEGORY_URL.replace(":id", categoryId);
        return given()
                .header("Authorization", "Bearer " + token)
                .accept(ContentType.JSON)
                .when()
                .delete(url);
    }
}
