package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriend {
    private static String firstName;
    private static String lastName;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();

    public static ArrayList<Friend> createAllFriends(String fileName) throws IOException {
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String friendString = "";
        while ((line = br.readLine()) != null) {
            if (!line.equals("; ")) {
                friendString += line;
                friendString += " ";
            } else {
                parseFriend(friendString);
                friendString = "";
            }
        }
        return friends;
    }
    private static void parseFriend(String string){
        int pos = 0;
        String firstName = "";
        String lastName = "";

        for(int i = 0; i< string.length(); i++){
            if(string.substring(i,i+1).equals(" ")) {
                pos = i;
                firstName = string.substring(0,pos);
                lastName = string.substring(pos+1);
                break;
            }
        }

        friends.add(new Friend(firstName,lastName));

        //Friend t = new Friend(firstName,lastName);
        //if(friends.compareFriends(t)){
        //    friends.add(t);
        }
    }

//}