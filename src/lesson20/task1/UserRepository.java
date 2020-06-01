package lesson20.task1;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServerException;
import lesson20.task1.exception.UserNotFoundException;

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

    public User findById(long id) throws Exception {
        for (User user : users) {
            if (user != null && user.getId() == id) {
                return user;
            }
        }
        throw new UserNotFoundException("User with id: " + id + " not found");
    }

    public User save(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't save null user");
        try {
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        } catch (UserNotFoundException e) {
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return users[i];
            }
        }
       throw new InternalServerException("Not enough space to save user with id: "+user.getId());
    }

    public User update(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't update null user");

        findById(user.getId());

        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == user.getId()) {
                users[i] = user;
                return users[i];
            }
        }
     throw new InternalServerException("Unexpected error");
    }

    public void delete(long id) throws Exception{
        findById(id);
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id) {
                users[i] = null;
                break;
            }
        }
    }

}
