package lesson9.homework;

public class UserRepository {
    private User[] users;

    public static void main(String[] args) {

    }


    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    private int countUsers() {
        int countUsers = 0;
        for (User user : users) {
            if (user != null)
                countUsers++;
        }
        return countUsers;
    }

    public String[] getUserNames() {
        String[] names = new String[countUsers()];
        int index = 0;
        for (User user : users) {
            if (user != null) {
                names[index] = user.getName();
                index++;
            }
        }
        return names;
    }

    public long[] getUserIds() {
        long[] ids = new long[countUsers()];
        int index = 0;
        for (User user : users) {
            if (user != null) {
                ids[index] = user.getId();
                index++;
            }
        }
        return ids;
    }

    public String getUserNameById(long id) {
        for (User user : users) {
            int index = 0;
            if (user != null) {
                if (user.getId() == id)
                    return user.getName();
            }
        }
        return null;
    }

    public User getUserByName(String name) {
        for (User user : users) {
            int index = 0;
            if (user != null) {
                if (user.getName() == name)
                    return users[index];
            }
            index++;
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        for (User user : users) {
            int index = 0;
            if (user != null) {
                if (user.getSessionId() == sessionId)
                    return users[index];
            }
            index++;
        }
        return null;
    }

    public User findById(long id) {
        for (User user : users) {
            int index = 0;
            if (user != null) {
                if (user.getId() == id)
                    return users[index];
            }
            index++;
        }
        return null;
    }

    public User save(User user) {

        if (findById(user.getId()) != null)
            return null;

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return user;
            }

        }
        return null;

    }

    public User update(User user) {
        if (findById(user.getId()) == null)
            return null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == user.getId()) {
                users[i] = user;
                return user;
            }
        }
        return null;
    }

    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == findById(id)){
                users[i] = null;

            }
        }
    }

}
