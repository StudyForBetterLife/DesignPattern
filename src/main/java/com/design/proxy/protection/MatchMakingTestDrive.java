package com.design.proxy.protection;

import com.design.proxy.protection.invoke.NotOwnerInvocationHandler;
import com.design.proxy.protection.invoke.OwnerInvocationHandler;
import com.design.proxy.protection.person.Person;
import com.design.proxy.protection.person.MatchMakingUser;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
public class MatchMakingTestDrive {
    private static final Map<String, Person> localDb = new HashMap<>();

    public static void main(String[] args) {
        MatchMakingTestDrive matchMakingTestDrive = new MatchMakingTestDrive();
        matchMakingTestDrive.drive();
    }

    public MatchMakingTestDrive() {
        initDb();
    }

    private void drive() {
        Person person = getPerson("guswns");

        // owner proxy
        Person ownerProxy = getOwnerProxy(person);
        log.info("name is {}", ownerProxy.getName());
        ownerProxy.setInterests("coding and training");
        log.info("intersets set from owner proxy");
        try {
            ownerProxy.setGeekRating(10);
        } catch (Exception e) {
            log.error("can't set rating from owner proxy", e);
        }
        log.info("rating is {}", ownerProxy.getGeekRating());

        // not owner proxy
        Person notOwnerProxy = getNotOwnerProxy(person);
        log.info("name is {}", notOwnerProxy.getName());
        try {
            notOwnerProxy.setInterests("coding and training");
        } catch (Exception e) {
            log.error("can't set intersets from not-owner proxy", e);
        }
        log.info("rating set from owner proxy");
        notOwnerProxy.setGeekRating(100);
        log.info("rating is {}", notOwnerProxy.getGeekRating());
    }

    private void initDb() {
        MatchMakingUser user = MatchMakingUser.builder()
                .name("guswns")
                .interests("coding")
                .rating(7)
                .build();
        localDb.put(user.getName(), user);

        MatchMakingUser user1 = MatchMakingUser.builder()
                .name("kelly")
                .interests("guswns")
                .rating(10)
                .build();
        localDb.put(user1.getName(), user1);
    }

    private Person getPerson(String name) {
        return Optional.ofNullable(localDb.get(name)).orElseThrow(NoSuchElementException::new);
    }

    private Person getOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person)
        );
    }

    private Person getNotOwnerProxy(Person person) {
        return (Person) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NotOwnerInvocationHandler(person)
        );
    }
}
