package com.nekit.ssn.repos;

import com.nekit.ssn.domains.User;
import com.nekit.ssn.domains.UserSubscription;
import com.nekit.ssn.domains.UserSubscriptionId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSubscriptionRepo extends JpaRepository<UserSubscription, UserSubscriptionId> {
    List<UserSubscription> findBySubscriber(User user);
    List<UserSubscription> findByChannel(User user);
    UserSubscription findByChannelAndSubscriber(User channel, User subscriber);
}
