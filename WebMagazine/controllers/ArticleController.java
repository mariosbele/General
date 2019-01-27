package com.cbfteam.controllers;   
import com.cbfteam.beans.Article;
import com.cbfteam.beans.ArticleCards;
import com.cbfteam.beans.ArticleComment;
import com.cbfteam.beans.ArticleImage;
import com.cbfteam.beans.ArticleReader;
import com.cbfteam.beans.User;
import com.cbfteam.dao.ArticleCardsDao;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import com.cbfteam.dao.ArticleDao;
import com.cbfteam.dao.ArticleImageDao;
import com.cbfteam.dao.ArticleReaderDao;
import com.cbfteam.dao.UserDao;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
  

@Controller  
public class ArticleController {
    
    
    @Autowired  
    ArticleDao articledao;//will inject dao from xml file  
    
    @Autowired
    UserDao userdao;    
    
    @Autowired
    ArticleImageDao articleimagedao;
    
    @Autowired
    ArticleCardsDao articlecardsdao;
    
    @Autowired
    ArticleReaderDao articlereaderdao;
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */ 
    
    @RequestMapping("/createarticle")  
    public String showform(Model m){  
    	m.addAttribute("command", new Article());
    	return "createarticle"; 
    }


    @RequestMapping(value="/savearticle",method = RequestMethod.POST)  
    public String save(@ModelAttribute("article") Article articlee, HttpSession session){

        articledao.saveArticle(articlee, (User) session.getAttribute("user"));  
        return "redirect:/viewsavedarticles";
    }
    
    @RequestMapping(value="/editarticle/{id}")  
    public String edit(@PathVariable int id, Model m, HttpSession session){
        Article article = articledao.getArticleById(id);
        List<ArticleImage> artimglist = articleimagedao.getSAVEDArticleImagesByArticleID(article.getId());
        if(artimglist.size()>0){
            m.addAttribute("IMG", artimglist.get(0));
            m.addAttribute("artimglist", artimglist);
        }        
        session.setAttribute("artFORimg", article);
        m.addAttribute("command",article);
        
        return "editsavedarticle";  
    } 
    
    

    @RequestMapping(value="/submitsavedarticle",method = RequestMethod.POST)  
    public String submitarticle(@ModelAttribute("article") Article article, HttpSession session){
        articledao.submitSavedArticle(article);
        session.setAttribute("article", article);
        return "redirect:/viewsavedarticles";  
    }
        
    
    @RequestMapping("editsavedarticle")
    public String editsavedarticle(Model m, HttpSession session){

        return "editsavedarticle";
    }
    
  
    @RequestMapping("/viewsavedarticles")  
    public String viewusers(Model m, HttpSession session){
        if ((User) session.getAttribute("user") == null){return "error";
        }
        User ur = (User) session.getAttribute("user");
        List<Article> list=articledao.getSavedArticlesByCreatorId(ur.getId());  
        m.addAttribute("list",list);
        return "viewsavedarticles";  
    }
   
    @RequestMapping("/mypublishedarticles")  
    public String mypublishedarticles(Model m, HttpSession session){
        
    	User ur = (User) session.getAttribute("user");
        List<Article> artlist = articledao.getPublishedArticlesByCreatoryId(ur.getId());
        m.addAttribute("artlist", artlist);
    	return "mypublishedarticles"; 
    } 
    

    
    @RequestMapping("/viewArticlesBySCIENCE")  
    public String viewArticlesBySCIENCE(Model m, HttpSession session){  
        List<ArticleCards> lista=articlecardsdao.getAllPublishedCardsByCategory("SCIENCE");

        session.setAttribute("cat", "science");        
        m.addAttribute("lista",lista);

    	m.addAttribute("command", new User());
       
    	return "HomePage"; 
    }    
    @RequestMapping("/viewArticlesByENVIRONMENT")  
    public String viewArticlesByENVIRONMENT(Model m, HttpSession session){  
         List<ArticleCards> lista=articlecardsdao.getAllPublishedCardsByCategory("ENVIRONMENT");

        session.setAttribute("cat", "science");        
        m.addAttribute("lista",lista);

    	m.addAttribute("command", new User());
       
    	return "HomePage"; 
    }
    @RequestMapping("/viewArticlesByART")  
    public String viewArticlesByART(Model m, HttpSession session){  
         List<ArticleCards> lista=articlecardsdao.getAllPublishedCardsByCategory("ART");

        session.setAttribute("cat", "science");        
        m.addAttribute("lista",lista);

    	m.addAttribute("command", new User());
       
    	return "HomePage"; 
    }
    @RequestMapping("/viewArticlesByTECHNOLOGY")  
    public String viewArticlesByTECHNOLOGY(Model m, HttpSession session){  
        List<ArticleCards> lista=articlecardsdao.getAllPublishedCardsByCategory("TECHNOLOGY");

        session.setAttribute("cat", "science");        
        m.addAttribute("lista",lista);

    	m.addAttribute("command", new User());
       
    	return "HomePage"; 
    }    
    
    @RequestMapping("/viewArticlesByGENERAL")  
    public String viewArticlesByGENERAL(Model m, HttpSession session){  
        List<ArticleCards> lista=articlecardsdao.getAllPublishedCardsByCategory("GENERAL");

        session.setAttribute("cat", "science");        
        m.addAttribute("lista",lista);

    	m.addAttribute("command", new User());
       
    	return "HomePage"; 
    }    
    
    @RequestMapping("/viewunpublishedarticles")  
    public String viewunpublishedarticles(Model m){ 
        List<User> list=userdao.getUsers();
        List<Article> lista=articledao.getUnPublishedArticles();
        List<String> unames=userdao.getUsernames();
        m.addAttribute("list",list);
        m.addAttribute("lista",lista);
        m.addAttribute("unames",unames);
        return "viewunpublishedarticles";  
    }
    
     
    
  

    @RequestMapping(value="/publish/{id}",method = RequestMethod.GET)  
    public String publish(@PathVariable int id){
        Article art = articledao.getArticleById(id);
        String caption = art.getCategory();
        String categoryImage = articleimagedao.defaultImageByCategory(art, art.getCategory());
        if(articleimagedao.getZEROimages(id) >0){
            articleimagedao.saveArticleImageDEFAULT(art, caption, categoryImage);
        }
        articledao.publishArticle(id);
        return "redirect:/viewunpublishedarticles";  
    }    
    
 
    @RequestMapping(value="/deletearticle/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        articledao.deleteArticle(id);  
        return "redirect:/viewsavedarticles";  
    }
    
    @RequestMapping(value="/openarticle/{id}",method = RequestMethod.GET)  
    public String openarticle(@PathVariable int id,  Model m, HttpSession session){

        List<ArticleImage> artimglist = articleimagedao.getArticleImagesByArticleID(id);
        List<ArticleComment> artcomm = articlereaderdao.getArticleComments(id);
        Integer likes = articlereaderdao.getArticleLikes(id, "L");
        Integer dislikes = articlereaderdao.getArticleLikes(id, "D");
        session.setAttribute("readerArticle", articledao.getArticleById(id));
        if(artimglist.size()>0){
            m.addAttribute("IMG", artimglist.get(0));
            m.addAttribute("artimglist", artimglist);
        }
        m.addAttribute("article", articledao.getArticleById(id));
        m.addAttribute("creator", userdao.getUserById(articledao.getArticleById(id).getCreator_id()));         
        m.addAttribute("artcomm", artcomm);
        m.addAttribute("likes", likes);
        m.addAttribute("dislikes", dislikes);
 
        if(session.getAttribute("user")==null){
        m.addAttribute("command", new User());       
       return "articleview";}

        else{
                User creator = userdao.getUserById(articledao.getArticleById(id).getCreator_id());
                User reader = ((User)session.getAttribute("user"));
                Integer count=articlereaderdao.getArticleReaderByArticleIdReaderId(id, ((User)session.getAttribute("user")).getId());
                Integer arl= articlereaderdao.getArticleReaderByIsLikeArticleIdReaderId(id, ((User)session.getAttribute("user")).getId());
                Integer arq = articlereaderdao.getHasAnswer(id, ((User)session.getAttribute("user")).getId());
                Integer yes = articlereaderdao.getArticleAnwsers(id, "YES");    m.addAttribute("yes", yes);
                Integer no = articlereaderdao.getArticleAnwsers(id, "NO");      m.addAttribute("no", no);
                Integer dknow = articlereaderdao.getArticleAnwsers(id, "OTHER");    m.addAttribute("dknow", dknow);

                if(arl == 0 || count==0){m.addAttribute("LI", "L");}
                if(arq == 0 || count==0){m.addAttribute("QU", "Q");}
                if(arq == 1){m.addAttribute("res", "R");}
                m.addAttribute("command", new ArticleReader());
                if(creator.getId() == reader.getId()||reader.getIs_admin()){
                return "articleWriterView";}
                else{
            return "articleUSERview";
            }
        }
    }    
    
   
    @RequestMapping(value="/like",method = RequestMethod.POST)  
    public String saveLike(@RequestParam("is_like") String is_like , HttpSession session){
        int article_id = ((Article)session.getAttribute("readerArticle")).getId();
        int id = ((User) session.getAttribute("user")).getId();
        articlereaderdao.saveLike(article_id, id, is_like);
        
        return "redirect:/articleUSERview";
    }
    
    @RequestMapping(value="/comment",method = RequestMethod.POST)  
    public String saveComment(@RequestParam("comment") String comment , HttpSession session){
        int article_id = ((Article)session.getAttribute("readerArticle")).getId();
        int id = ((User) session.getAttribute("user")).getId();
        if(comment.length()>0){
        articlereaderdao.saveComment(article_id, id, comment);
        }
        return "redirect:/articleUSERview";
    }
    
    @RequestMapping(value="/question",method = RequestMethod.POST)  
    public String saveAnswer(@RequestParam("question_answer") String question_answer , HttpSession session){
        int article_id = ((Article)session.getAttribute("readerArticle")).getId();
        int id = ((User) session.getAttribute("user")).getId();
        articlereaderdao.saveQuestion(article_id, id, question_answer);
        session.setAttribute("answer", "GG");
        
        return "redirect:/articleUSERview";
    }    

    @RequestMapping("/articleUSERview")  
    public String articleview(Model m, HttpSession session){
        Article article =(Article)session.getAttribute("readerArticle");
        List<ArticleImage> artimglist = articleimagedao.getPublishedArticleImagesByArticleID(article.getId());
        List<ArticleComment> artcomm = articlereaderdao.getArticleComments(article.getId());
        Integer count=articlereaderdao.getArticleReaderByArticleIdReaderId(article.getId(), ((User)session.getAttribute("user")).getId());
        Integer arl= articlereaderdao.getArticleReaderByIsLikeArticleIdReaderId(article.getId(), ((User)session.getAttribute("user")).getId());
        Integer arq = articlereaderdao.getHasAnswer(article.getId(), ((User)session.getAttribute("user")).getId());
        Integer likes = articlereaderdao.getArticleLikes(article.getId(), "L");
        Integer dislikes = articlereaderdao.getArticleLikes(article.getId(), "D");
        Integer yes = articlereaderdao.getArticleAnwsers(article.getId(), "YES");    m.addAttribute("yes", yes);
        Integer no = articlereaderdao.getArticleAnwsers(article.getId(), "NO");      m.addAttribute("no", no);
        Integer dknow = articlereaderdao.getArticleAnwsers(article.getId(), "OTHER");    m.addAttribute("dknow", dknow);
        
        if(arl == 0 || count==0){m.addAttribute("LI", "L");}
        if(arq == 0 || count==0){m.addAttribute("QU", "Q");}
        if(arq == 1){m.addAttribute("res", "R");}
        if(artimglist.size()>0){m.addAttribute("IMG", artimglist.get(0));}
        m.addAttribute("artimglist", artimglist);
        m.addAttribute("likes", likes);
        m.addAttribute("dislikes", dislikes);
        m.addAttribute("command", new ArticleReader());
        m.addAttribute("artcomm", artcomm);
        m.addAttribute("article", article);
        m.addAttribute("creator", (User) session.getAttribute("user"));

    	return "articleUSERview"; 
    } 
    
    
    @RequestMapping("/adminArticleView")  
    public String adminArticleView(){  
    	
    	return "adminArticleView"; 
    } 
    
    
    
    @RequestMapping(value="/adminOpenUnpublished/{id}",method = RequestMethod.GET)  
    public String adminOpenArticle(@PathVariable int id,  Model m, HttpSession session){
        m.addAttribute("article", articledao.getArticleById(id));
        m.addAttribute("reader", userdao.getUserById(articledao.getArticleById(id).getCreator_id()));        
        m.addAttribute("reader", userdao.getUserById(articledao.getArticleById(id).getCreator_id()));
        List<ArticleImage> artimglist = articleimagedao.getUnpublishedArticleImagesByArticleID(id);
        if(artimglist.size()>0){
            m.addAttribute("artimglist", artimglist);
            m.addAttribute("IMG", artimglist.get(0));
        }
       return "adminArticleView";  
    }
     
    @RequestMapping(value="/deletearticleadmin/{id}",method = RequestMethod.GET)  
    public String adminArticledelete(@PathVariable int id){  
        articledao.deleteArticle(id);  
        return "redirect:/viewunpublishedarticles";  
    }    
}  