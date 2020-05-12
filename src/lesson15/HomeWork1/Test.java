package lesson15.HomeWork1;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
        User[] users=new User[10] ;

        UserRepository userRepository = new UserRepository(users);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user = new User(1001, "Ann", "1w21211");
        userRepository.save(user);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository.save(user);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //сохранение юзера +
        //сохранение того же юзера +
        //когда нет места в массиве +
        //когда сохранеям null +

        int n = 15;
        while (n > 0) {
            User user1 = new User(n, "Ann", "1w21211");
            System.out.println(userRepository.save(user1));
            n--;
        }
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository.save(null);


        //test update
        user = new User(1001,"Ann","ertrerer");
        userRepository.update(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));


        //обновление юзера +
        //когда нет юзера на объявление +
        //когда обнавляем null +

        user = new User(9999,"Ann","ertrerer");
        System.out.println( userRepository.update(user));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        System.out.println( userRepository.update(null));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

       userRepository.delete(1001);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
    }
}
