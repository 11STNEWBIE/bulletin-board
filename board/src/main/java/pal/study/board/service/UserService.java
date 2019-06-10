package pal.study.board.service;

import org.springframework.stereotype.Service;
import pal.study.board.domain.User;
import pal.study.board.domain.UserRepository;
import pal.study.board.exception.UnAuthenticationException;
import pal.study.board.exception.UnAuthorizedException;
import pal.study.board.utils.SessionUtils;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user, HttpSession session) {
        SessionUtils.setSession(user, session);
        userRepository.save(user);
    }

    public User login(String userId, String password) throws UnAuthenticationException {
        return userRepository.findByUserId(userId)
                             .filter(user -> user.isCorrectPassword(password))
                             .orElseThrow(UnAuthenticationException::new);
    }

    @Transactional
    public void updateUser(User modifiedUser, Long id) {
        User user = userRepository.findById(id)
                                  .orElseThrow(EntityNotFoundException::new);
        user.modify(modifiedUser);
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.delete(userRepository.findById(id)
                                            .orElseThrow(EntityNotFoundException::new));
    }
}
