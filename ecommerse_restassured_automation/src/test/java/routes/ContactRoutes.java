package routes;

public class ContactRoutes {

    public static final String BASE_URL = "http://localhost:3010/api";

    // POST - Add a contact message
    public static final String POST_ADD_CONTACT_MESSAGE_URL = BASE_URL + "/add-contact-message";

    // GET - Get all contact messages
    public static final String GET_ALL_MESSAGES_URL = BASE_URL + "/all-messages";

    // GET - Get a single message by ID (append /:id dynamically)
    public static final String GET_SINGLE_MESSAGE_BY_ID_URL = BASE_URL + "/reply-message/:id";

    // POST - Add a reply to a specific message (append /:id/reply dynamically)
    public static final String POST_REPLY_TO_MESSAGE_URL = BASE_URL + "/give-message-reply/:id/reply";

    // GET - Get the count of unread messages
    public static final String GET_UNREAD_MESSAGES_COUNT_URL = BASE_URL + "/messages/unread-count";

    // POST - Mark a message as read
    public static final String POST_MARK_MESSAGE_AS_READ_URL = BASE_URL + "/messages/mark-as-read";

    // GET - Get the total count of messages
    public static final String GET_MESSAGES_COUNT_URL = BASE_URL + "/messages/get-messages-count";
}
