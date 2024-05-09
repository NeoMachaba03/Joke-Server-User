package JokeServer.User.Service;

import JokeServer.User.Dao.UserDaoImpl;
import JokeServer.User.Model.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserServiceImpl implements UserService{

    private UserDaoImpl userDao = new UserDaoImpl();
    private Scanner input = new Scanner(System.in);

    public void login(){
        while (true){
            try {
                System.out.print("\nEnter your username: ");
                String username = input.nextLine();

                System.out.print("\nEnter you password: ");
                String password = input.nextLine();

                boolean login = userDao.login(username,password);
                if (login == true){
                    System.out.println("\nYou have successfully logged in!!!");
                    break;
                }else {
                    System.out.println("\nUsername or password is incorrect!!! Please try again!!!");
                }
            }catch (InputMismatchException e){
                System.out.println("\nInvalid entry!!! Please try again");
            }
        }

    }

    @Override
    public void addUser() {
        while (true){
            try{
                System.out.print("\nEnter your name: ");
                String name = input.nextLine();

                System.out.print("\nEnter your surname: ");
                String surname = input.nextLine();

                System.out.print("\nEnter a username: ");
                String username = input.nextLine();

                System.out.print("\nEnter a password: ");
                String password = input.nextLine();

                User user = new User(0,name,surname,username,password);
                userDao.addUser(user);
                break;
            }catch (InputMismatchException e){
                System.out.println("\nInvalid entry!!! Please try again");
            }
        }
    }

    @Override
    public void retrieveUser() {
        while (true){
            try{
                System.out.print("\nEnter the user's ID: ");
                int id = Integer.parseInt(input.nextLine());

                userDao.retrieveUser(id);
                break;
            }catch (InputMismatchException e){
                System.out.println("\nInvalid entry!!! Please try again");
            }
        }
    }

    @Override
    public void updateUser() {
        while (true){
            try {
                System.out.print("\nEnter the user you want to update's ID: ");
                int id = Integer.parseInt(input.nextLine());

                System.out.print("\nEnter your name: ");
                String name = input.nextLine();

                System.out.print("\nEnter your surname: ");
                String surname = input.nextLine();

                System.out.print("\nEnter a username: ");
                String username = input.nextLine();

                System.out.print("\nEnter a password: ");
                String password = input.nextLine();

                userDao.updateUser(id,name,surname,username,password);
                break;
            }catch (InputMismatchException e){
                System.out.println("\nInvalid entry!!! Please try again");
            }
        }
    }

    @Override
    public void deleteUser() {
        while (true){
            try {
                System.out.print("\nEnter the user's ID: ");
                int id = Integer.parseInt(input.nextLine());

                userDao.deleteUser(id);
                break;
            }catch (InputMismatchException e){
                System.out.println("\nInvalid entry!!! Please try again");
            }
        }
    }
}
