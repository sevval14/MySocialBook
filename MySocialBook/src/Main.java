import agee.agee;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Object> userList = new ArrayList<Object>();
    public static ArrayList<Object> friendsusername = new ArrayList<Object>();
    public static ArrayList<Object> nowUseranme = new ArrayList<Object>();
    public static String onlineUsername = null;
    public static String onlinePassword = null;


    public static void main(String[] args) throws FileNotFoundException {


//USERS DOSYASI OKUMA
        File files = new File("src/users.txt");//öyle olmayacak ama
        Scanner sc = new Scanner(files);
        int k = 1;
        while (sc.hasNextLine()) {
            String lines = sc.nextLine();
            String[] strdz = lines.split("\t");

            users usr = new users(k, strdz[0], strdz[1], strdz[2], strdz[3], strdz[4]);
            nowUseranme.add(strdz[1]);


            userList.add(usr);
            k++;

        }

        //System.out.println(userList);


        //COMMAND DOSYASI OKUMA

        File cfiles = new File("src/commands.txt");//öyle olmayacak ama
        Scanner csc = new Scanner(cfiles);
        while (csc.hasNextLine()) {
            String lines = csc.nextLine();
            String[] cstrdz = lines.split("\t");
            System.out.println("COMMAND: " + lines);

            //IFLER BURAYA tamamdır çok teşşek
            if (cstrdz[0].equals("ADDUSER")) {
                users usr = new users(userList.size(), cstrdz[1], cstrdz[2], cstrdz[3], cstrdz[4], cstrdz[5]);
                userList.add(usr);
                nowUseranme.add(cstrdz[2]);
                System.out.println(cstrdz[1] + " has been successfully added.");
            }

            if (cstrdz[0].equals("REMOVEUSER")) {
                int dx = Integer.parseInt(cstrdz[1]); //strıngı ınt yapıyor.
                userList.remove(dx - 1);
                nowUseranme.remove(dx - 1);
                System.out.println("User has been successfully removed.");
            }

            if (cstrdz[0].equals("SIGNIN")) {
                String username = cstrdz[1];
                String password = cstrdz[2];
                for (int i = 0; i < userList.size(); i++) {
                    users cusr = (users) userList.get(i);
                    if (username.equals(cusr.getUsername()) && password.equals(cusr.getPassword())) {
                        System.out.println("You have successfully signed in.");


                    }
                }

            }

            if (cstrdz[0].equals("LISTUSERS")) {
                for (int i = 0; i < userList.size(); i++) {
                    System.out.println(userList.get(i));
                    System.out.println("----------------");
                }
            }

            if (cstrdz[0].equals("UPDATEPROFILE")) {
                String name = cstrdz[1];
                String age = cstrdz[2];
                String school = cstrdz[3];
                for (int i = 0; i < userList.size(); i++) {
                    users cusr = (users) userList.get(i);
                    if (name.equals(cusr.getName())) {
                        cusr.setName(cstrdz[1]);
                        String[] cage = cstrdz[2].split("/");
                        agee aage = new agee(Integer.parseInt(cage[0]), Integer.parseInt(cage[1]), Integer.parseInt(cage[2]));
                        cusr.setAge(cstrdz[2]);
                        cusr.setSchool(cstrdz[3]);
                        System.out.println("You have successfully signed in.");

                    }

                }
            }


            if (cstrdz[0].equals("CHPASS")) {
                String password = cstrdz[1];
                for (int i = 0; i < userList.size(); i++) {
                    users cusr = (users) userList.get(i);
                    if (password.equals(cusr.getPassword())) {
                        cusr.setPassword(cstrdz[2]);
                        System.out.println("Password mismatch!");

                    }
                }
            }

            if (cstrdz[0].equals("ADDFRIEND")) {
                for (int i = 0; i < nowUseranme.size(); i++) {
                    if (cstrdz[1].equals(nowUseranme.get(i))) {
                        System.out.println(nowUseranme.get(i) + " has been successfully added to your friend list.");
                        friendsusername.add(nowUseranme.get(i));
                        System.out.println(friendsusername.equals(nowUseranme.get(i)));


                    }

                    if (friendsusername.equals(nowUseranme.get(i)) == true) {
                        System.out.println("This user is already in your friend list!");

                    }
                }


            }

            if (cstrdz[0].equals("REMOVEFRIEND")) {
                System.out.println("deneme");
            }


            System.out.println("------------------------");

        }
        System.out.println(userList.get(5));
        System.out.println(nowUseranme.get(0));


    }
}