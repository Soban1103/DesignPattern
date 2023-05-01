import java.util.Date;
class User {
    private String name;

    public String getName() {
        return this.name;
    }

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}


class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date() + "[" + user.getName() + "]: " + message);
    }
}


public class Mediator {
    public static void main(String[] args) {
        User user1 = new User("ABC");
        User user2 = new User("DEF");

        user1.sendMessage("Hello");
        user2.sendMessage("Hey");
    }
}

