
package com.cbfteam.daoInterface;

import com.cbfteam.beans.Article;
import com.cbfteam.beans.ArticleImage;
import java.util.List;


public interface ArticleImageDaoInterface {

    String defaultImageByCategory(Article ar, String img);

    int deleteArticleImage(int id);

    
    public List<ArticleImage> getArticleImagesByArticleID(int artclID);

    ArticleImage getArticleImageById(int id);

    List<ArticleImage> getImagesByPublishedArticleID(int id);

    List<ArticleImage> getPublishedArticleImagesByArticleID(int artclID);

    List<String> getPublishedImagesByCategory(String category);

    List<ArticleImage> getSAVEDArticleImagesByArticleID(int artclID);

    List<ArticleImage> getSAVEDArticleImagesByArticleIDCreatorID(int artclID, int usrID);

    List<String> getUnPublishedArticlesImg();

    List<ArticleImage> getUnpublishedArticleImagesByArticleID(int artclID);

    Integer getZEROimages(int article_id);

    int saveArticleImage(Article ar, ArticleImage im);

    int saveArticleImageDEFAULT(Article ar, String caption, String img);
    
}
