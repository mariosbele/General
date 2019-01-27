
package com.cbfteam.daoInterface;

import com.cbfteam.beans.Article;
import com.cbfteam.beans.User;
import java.util.List;


public interface ArticleDaoInterface {

    int deleteArticle(int id);

    Article getArticleById(int id);

    List<Article> getPublishedArticles();

    List<Article> getPublishedArticlesByCategory(String category);

    List<Article> getPublishedArticlesByCreatoryId(int id);

    List<Article> getSavedArticlesByCreatorId(int id);

    List<Article> getUnPublishedArticles();

    String getUsernameByArticleID(int id, int art_id);

    int publishArticle(int id);

    int saveArticle(Article pa, User user);

    int submitSavedArticle(Article a);
    
}
