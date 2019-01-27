package com.cbfteam.controllers;   
import com.cbfteam.beans.Article;
import com.cbfteam.beans.ArticleImage;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import com.cbfteam.dao.ArticleImageDao;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMethod;

  

@Controller  
public class ArticleImageController {
    
   
    
    @Autowired
    ArticleImageDao articleimagedao;
    

    
  
    
    @RequestMapping("addimg")
    public String addimages(Model m, HttpSession session){
        Article article = (Article) session.getAttribute("artFORimg");
        List<ArticleImage> artimglist = articleimagedao.getSAVEDArticleImagesByArticleID(article.getId());
        m.addAttribute("artimglist", artimglist);
        m.addAttribute("article", article);
        m.addAttribute("command", new ArticleImage());
        return "addimg";
    }
    
    @RequestMapping(value="/saveimg",method = RequestMethod.POST)  
    public String saveimg(@ModelAttribute("command") ArticleImage articleimg, HttpSession session){
        Article ar = (Article)session.getAttribute("artFORimg");
        articleimagedao.saveArticleImage(ar, articleimg);
        
        return "redirect:/addimg";
    }
    
    @RequestMapping(value="/deleteimage/{id}")  
    public String deleteImg(@PathVariable int id){  
        articleimagedao.deleteArticleImage(id);
        return "redirect:/addimg";  
    } 
    
    
}  