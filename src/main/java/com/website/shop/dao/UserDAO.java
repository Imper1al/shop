package com.website.shop.dao;

import com.website.shop.constants.StoreConstant;
import com.website.shop.entity.User;
import com.website.shop.localization.Localizer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDAO {

    //temp

    private User getTestUser() {
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setPhoneNumber("0990099969");

        User.PersonalInfo personalInfo = new User.PersonalInfo();
        personalInfo.setFirstName("Vladyslav");
        personalInfo.setLastName("Yanytskyi");

        User.PersonalInfo.Address address = new User.PersonalInfo.Address();
        address.setCountry("Ukraine");
        address.setCity("Kharkov");
        address.setStreet("Electroinstrumental 6A");

        personalInfo.setAddress(address);

        User.PersonalInfo.PaymentCard paymentCard = new User.PersonalInfo.PaymentCard();

        personalInfo.setPaymentCard(paymentCard);
        user.setPersonalInfo(personalInfo);

        return user;
    }
    public User createUser(User user) {
        return getTestUser();
    }

    public User updateUser(long userId, User user) {
        User test = getTestUser();
        test.setId(userId);
        System.out.println("userId: " + userId + "\sUser: " + user.getEmail());
        return test;
    }

    public void deleteUsers(List<Integer> userIds) {
        Localizer localizer = Localizer.getBrowserLocalizer();
        System.out.println("userIds: " + userIds + "\s" + localizer.getLocalizedText(StoreConstant.USER_DELETE_SUCCESSFULLY));
    }

    public User getUser(long userId) {
        User user = getTestUser();
        user.setId(userId);
        return user;
    }
}
