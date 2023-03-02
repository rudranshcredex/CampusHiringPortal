package org.credex.hiring.portal.repository;


import org.credex.hiring.portal.model.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginInfo, Long> {
    LoginInfo findByEmailAndPassword(String email, String password);
}
