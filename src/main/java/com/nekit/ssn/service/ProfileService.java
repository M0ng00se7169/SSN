package com.nekit.ssn.service;

import com.nekit.ssn.domains.User;
import com.nekit.ssn.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProfileService {
    private final UserRepo userRepo;

    @Autowired
    public ProfileService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User changeSubscription(User channel, User subscriber) {
        Set<User> subscribers = channel.getSubscribers();

        if (subscribers.contains(subscriber)) {
            subscribers.remove(subscriber);
        } else {
            subscribers.add(subscriber);
        }

        return userRepo.save(channel);
    }
}
