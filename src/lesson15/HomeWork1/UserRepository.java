package lesson15.HomeWork1;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }


    public User save(User user) {
        if (user == null)
            return null;

        if (findUser(user) != null)
            return null;

        int countPlaced = 0;
        for (User us : users) {
            if (us != null)
                countPlaced++;
        }

        if (countPlaced > 9)
            return null;

        int index = 0;
        for (User us : users) {
            if (us == null) {
                users[index] = user;
                break;
            }
            index++;
        }
        return user;
    }

    public User update(User user) {
        if (user == null)
            return null;
        User curUser = findById(user.getId());
        if (curUser == null)
            return null;
        int index = 0;
        for (User us : users) {
            if (us != null && us.getId()==curUser.getId()) {
                users[index] = user;
                break;
            }
            index++;
        }
        return user;
    }

    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == findById(id)) {
                users[i] = null;
            }
        }
    }

    public User findById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }
        return null;
    }

    public User findUser(User user) {
        for (User user1 : users) {
            if (user1 != null && user1.equals(user))
                return user1;
        }
        return null;
    }

    public User[] getUsers() {
        return users;
    }
}
