package dao;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface LogInDao {

    public String NextPage(String name, String password,Model model, HttpSession httpSession);

	public String loginPage(HttpSession httpSession);
}
