
package com.cbfteam.daoInterface;

import com.cbfteam.beans.ArticleCards;
import java.util.List;


public interface ArticleCardsDaoInterface {

    List<ArticleCards> getAllPublishedCards();

    List<ArticleCards> getAllPublishedCardsByCategory(String category);
    
}
