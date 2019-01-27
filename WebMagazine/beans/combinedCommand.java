package com.cbfteam.beans;

/**
 *
 *  This class is created for future modifications in our code
 */
public class combinedCommand {
    
    private User user;
    private ArticleCards card;
    
    public User getUser(){
        return this.user;
    }
    public ArticleCards getCard(){
        return this.card;
    }
    
    public void setUser(int id, String username, String password, String email, String fname, String lname, String birthdate, 
                        String gender, String reg_date, String is_active, Boolean is_admin){
        this.user.setId(id);
        this.user.setUsername(username);
        this.user.setPassword(password);
        this.user.setEmail(email);
        this.user.setFname(fname);
        this.user.setLname(lname);
        this.user.setBirthdate(birthdate);
        this.user.setGender(gender);
        this.user.setReg_date(reg_date);
        this.user.setIs_active(is_active);
        this.user.setIs_admin(is_admin);
    }

    public void setCard(int id, String category, String title, String article_img, String username, String pub_date){
        this.card.setId(id);
        this.card.setCategory(category);
        this.card.setTitle(title);
        this.card.setArticle_img(article_img);
        this.card.setUsername(username);
        this.card.setPub_date(pub_date);
    }
    

}
