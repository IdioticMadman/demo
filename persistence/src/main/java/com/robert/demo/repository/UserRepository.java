package com.robert.demo.repository;


import com.robert.demo.repository.domain.UserInfo;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;


@Repository
public class UserRepository {

    private ConcurrentMap<Integer, UserInfo> userCache = new ConcurrentHashMap<>();

    private AtomicInteger idGenerator = new AtomicInteger();

    public boolean saveUser(UserInfo userInfo) {
        int userId = idGenerator.getAndIncrement();
        userInfo.setUserId(userId);
        return userCache.put(userId, userInfo) != null;
    }

    public List<UserInfo> getUser() {
        return IteratorUtils.toList(userCache.values().iterator());
    }
}
