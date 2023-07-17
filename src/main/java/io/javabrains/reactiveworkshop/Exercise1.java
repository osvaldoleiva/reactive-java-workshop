package io.javabrains.reactiveworkshop;

import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        //StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(number -> number < 5).forEach(number -> System.out.println(number));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        StreamSources.intNumbersStream().filter(number -> number > 5)
            .skip(1)
            .limit(2)
            .forEach(number -> System.out.println(number));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        //System.out.println(StreamSources.intNumbersStream().filter(number -> number < 5).findFirst().orElse(-1));

        // Print first names of all users in userStream
        //StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        var ids = StreamSources.intNumbersStream().collect(Collectors.toList());
        StreamSources.userStream().filter(user -> ids.contains(user.getId())).forEach(user -> System.out.println(user.getFirstName()));

    }

}
