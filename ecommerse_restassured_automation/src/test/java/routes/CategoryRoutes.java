package routes;

public class CategoryRoutes {

    public static final String BASE_URL = "http://localhost:3010/api";

    // POST - Add a new category with image
    public static final String POST_CREATE_CATEGORY_URL = BASE_URL + "/add-category";

    // GET - Get all categories
    public static final String GET_ALL_CATEGORIES_URL = BASE_URL + "/all-categories";

    // GET - Get total number of categories
    public static final String GET_CATEGORY_COUNT_URL = BASE_URL + "/category-count";

    // GET - Get product count per category
    public static final String GET_CATEGORY_PRODUCT_COUNTS_URL = BASE_URL + "/category-product-counts";

    // GET - Get category by ID (append /:id dynamically)
    public static final String GET_CATEGORY_BY_ID_URL = BASE_URL + "/single-category/:id";

    // PUT - Update category by ID (append /:id dynamically)
    public static final String PUT_UPDATE_CATEGORY_URL = BASE_URL + "/update-category/:id";

    // DELETE - Delete category by ID (append /:id dynamically)
    public static final String DELETE_CATEGORY_URL = BASE_URL + "/delete-category/:id";
}

