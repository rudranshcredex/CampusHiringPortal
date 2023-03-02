package org.credex.hiring.portal.serviceImpl;

import org.credex.hiring.portal.model.LoginInfo;
import org.credex.hiring.portal.repository.LoginRepository;
import org.credex.hiring.portal.service.LoginAndRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginAndRegistrationImpl implements LoginAndRegistration {

    private LoginRepository loginRepository;

    @Autowired
    public LoginAndRegistrationImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public boolean validateUser(LoginInfo loginInfo) {
        LoginInfo user = loginRepository.findByEmailAndPassword(loginInfo.getEmail(), loginInfo.getPassword());
        return user != null;
    }

    @Override
    public boolean registerUser(LoginInfo loginInfo) {
        LoginInfo savedUser = loginRepository.save(loginInfo);
        return savedUser != null;
    }
}
