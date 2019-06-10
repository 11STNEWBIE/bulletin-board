package pal.study.board.utils;

import pal.study.board.domain.User;

import javax.servlet.http.HttpSession;
import java.util.Objects;

public class SessionUtils {

    public static final String SESSION_KEY = "DEFAULT_USER";

    public static void setSession(User user, HttpSession session) {
        if (Objects.isNull(session.getAttribute(SESSION_KEY))) {
            session.setAttribute(SESSION_KEY, user);
        }
    }
}
