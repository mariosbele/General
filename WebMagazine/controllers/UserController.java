package com.cbfteam.controllers;   
import com.cbfteam.beans.Article;
import com.cbfteam.beans.ArticleCards;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;     
import com.cbfteam.beans.User;  
import com.cbfteam.dao.ArticleCardsDao;
import com.cbfteam.dao.ArticleDao;
import com.cbfteam.dao.UserDao;

import javax.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.web.bind.annotation.RequestParam;

@Controller  
public class UserController {  
    @Autowired  
    UserDao userdao;//will inject dao from xml file  
    

  
    @Autowired
    ArticleDao articledao;

    @Autowired
    ArticleCardsDao articlecardsdao;
    
    @RequestMapping("/HomePage")  
    public String showIndexFull(Model m, HttpSession session){
        String cat = "ALL";
            List<ArticleCards> lista = articlecardsdao.getAllPublishedCards();  
            session.setAttribute("cat", cat);
            m.addAttribute("lista",lista);
            m.addAttribute("command", new User());
        if (session.getAttribute("counter") == "1" && session.getAttribute("error")== "Invalid Credentials, Please Try Again"){
                session.setAttribute("counter", "0");
            }else {
                session.removeAttribute("error");
            }             
    	return "HomePage"; 
    }
        
    @RequestMapping("/userview")  
    public String userview(){  
    	
    	return "userview"; 
    }

    @RequestMapping("/aboutus")
    public String aboutus(Model m){
        m.addAttribute("command", new User());
        return "aboutus";
    }
    
    @RequestMapping("/userform")  
    public String showform(Model m){  
    	m.addAttribute("command", new User());
    	return "userform"; 
    }
    @RequestMapping("/loginuser")  
    public String showlogin(Model m) throws InterruptedException{  
    	m.addAttribute("command", new User());
    	return "loginuser"; 
    }
        
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("user") User userr, HttpSession session){
        BCryptPasswordEncoder cr = new BCryptPasswordEncoder();
        String password = userr.getPassword();
        User first = userdao.getUserById(1);
        if(first == null){
            userr.setPassword(cr.encode(password));
            userdao.save(userr, true);
            return "redirect:/HomePage";
        }
        boolean ur = userdao.validateUsername(userr.getUsername(), userr.getEmail());
        if(ur){
        userr.setPassword(cr.encode(password));
        userdao.save(userr,false);
        session.setAttribute("welcome", "Registration Succesfull");
        return "redirect:/HomePage";
        }
        else{
            userr.setUsername("wrong username");
            session.setAttribute("error3", "This user already exists, try again");
            return "redirect:/userform";
        }
    }
    
    @RequestMapping(value="/login",method = RequestMethod.POST)  
    public String login(@RequestParam("username") String username,@RequestParam("password") String password, HttpSession session, Model m){
    
        session.setAttribute("username", null);
        User user = userdao.validateUser(username);
        BCryptPasswordEncoder cr = new BCryptPasswordEncoder();
        if(user != null && cr.matches(password, user.getPassword()) && user.getIs_admin()){
        session.setAttribute("username", "ADMIN");
        session.setAttribute("user", user);
        session.setMaxInactiveInterval(300);
        return "redirect:/HomePage"; 
        }
        else if(user != null && cr.matches(password, user.getPassword()) && user.getIs_active().equals("Active") && !user.getIs_admin()){
            session.setAttribute("username", user.getUsername());
            session.setAttribute("user", user);
            return "redirect:/HomePage";
        }
        else{
            
            session.setAttribute("error", "Invalid Credentials, Please Try Again");
            session.setAttribute("counter", "1");
            
            return "redirect:/HomePage";
        }
    }
    @RequestMapping("/logout")  
    public String logout(HttpSession session){
        
        session.setMaxInactiveInterval(0);
        
    	session.removeAttribute("user");
        session.removeAttribute("username");
        session.removeAttribute("command");
    	return "redirect:/HomePage"; 
    }    
    
    @RequestMapping("/viewusers")  
    public String viewusers(Model m){ 
        List<User> list=userdao.getUsers();
        List<Article> lista=articledao.getUnPublishedArticles();
        List<String> unames=userdao.getUsernames();
        m.addAttribute("list",list);
        m.addAttribute("lista",lista);
        m.addAttribute("unames",unames);
        return "viewusers";  
    }
    @RequestMapping("/viewuser")  
    public String viewuser(Model m, User user){      
        m.addAttribute("user",user);
        return "viewuser";  
    }
    
     
    
    
@RequestMapping(value="/usereditform/{id}")
    public String edit(@PathVariable int id, Model m, HttpSession session){
       
        User user=userdao.getUserById(id);
        session.setAttribute("user", user);
        session.setAttribute("userId", user.getId());
        m.addAttribute("command",user);
       
        return "usereditform";
    } 
    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("user") User user,Model m, HttpSession session){
        if(!user.getIs_active().equals("Inactive"))user.setIs_active("Active");    
        userdao.update(user);
        session.setAttribute("userr", user);  
        return "redirect:/HomePage";       
    }  
   
    
 
    @RequestMapping(value="/deleteuser/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id, HttpSession session){  
        userdao.delete(id);
        session.removeAttribute("errorUsername");
        return "redirect:/viewusers";  
    }   
}  