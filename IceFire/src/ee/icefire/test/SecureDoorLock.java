package ee.icefire.test;/* ------------------------------------------------------------
 * A military factory outside the town has a secret lab where the newest and most
 * dangerous weapons are being developed. They installed a new lock which allowed
 * only whitelisted visitors to enter the lab. National Security Agency wants you
 * to secretly keep an eye on the lab. The lock is very secure, but there is a loophole
 * which allows you to change the body of one minor method. The change should
 * make the lock open every time you input your name. But remember, you are a secret
 * agent and your name should not appear anywhere in the code. We repeat: Nobody
 * should be able to understand which additional person is allowed to enter the room
 * by looking at the code. Also, don't make the room less secure. Only you and the
 * allowed visitors should be able to open the lock.
 *
 * Make the change to the body of getFullName(String, String) method. Make sure that
 * the test passes with your name in it. Don't worry, the test can contain your name
 * explicitly. The test is provided for convenience and your task is not to trick it into
 * passing but to solve the problem. Send us the link to a GitHub repo with your solution 
 * (full code, please) and explain how your solution works. We expect the solutions 
 * to be sent to sirli.spelman@icefire.ee by the 25th of March 2016 the latest. Please do
 * write "Secret Mission" on the topic line and do not forget to add your CV to the e-mail.
 *
 * Good luck, agent!
 * ------------------------------------------------------------
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class SecureDoorLock {

    private static final List<String> ALLOWED_VISITORS
            = asList("John Smith", "Jane Doe", "Ice Cube");

    public boolean shouldOpen(String firstName, String lastName) {
        return ALLOWED_VISITORS.contains(getFullName(firstName, lastName));
    }

    private String getFullName(String firstName, String lastName) {
        List<Integer> notMyName = new ArrayList<>();
        notMyName.addAll(Arrays.asList(84, 98, 111, 101, 102, 115, 84, 102, 113, 113));

        List<Integer> notDecodedName = new ArrayList<>();
        for (int i = 0; i < firstName.length(); i++) {
            int character = firstName.charAt(i);
            notDecodedName.add(character + 1);
        }
        for (int i = 0; i < lastName.length(); i++) {
            int character = lastName.charAt(i);
            notDecodedName.add(character + 1);
        }
        if (notMyName.equals(notDecodedName)) {
            double random = Math.round(Math.random() * (ALLOWED_VISITORS.size() - 1));
            String[] name = ALLOWED_VISITORS.get((int) random).split(" ");
            //System.out.println(name[0]);
            firstName = name[0];
            lastName = name[1];
        }

        return firstName + " " + lastName;
    }

    public static void main(String[] args) {

        SecureDoorLock lock = new SecureDoorLock();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        String lastName = scanner.nextLine();

        if (lock.shouldOpen(firstName, lastName)) {
            System.out.println("Welcome inside!");
        } else {
            System.out.println("You shall not pass!");
        }
    }

}
