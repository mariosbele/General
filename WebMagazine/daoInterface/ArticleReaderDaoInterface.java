
package com.cbfteam.daoInterface;

import com.cbfteam.beans.ArticleComment;
import java.util.List;


public interface ArticleReaderDaoInterface {

    int delete(int article_id, int reader_id);

    Integer getArticleAnwsers(int article_id, String answer);

    List<ArticleComment> getArticleComments(int article_id);

    Integer getArticleLikes(int article_id, String like);

    Integer getArticleReaderByArticleIdReaderId(int article_id, int reader_id);

    Integer getArticleReaderByIsLikeArticleIdReaderId(int article_id, int reader_id);

    Integer getHasAnswer(int article_id, int reader_id);

    int saveArticleReader(int article_id, int reader_id);

    int saveComment(int article_id, int reader_id, String comment);

    int saveLike(int article_id, int reader_id, String is_like);

    int saveQuestion(int article_id, int reader_id, String question_answer);

    int updateNullComment(int article_id, int reader_id, String comment);

    int updateNullLike(int article_id, int reader_id, String is_like);

    int updateNullQuestion(int article_id, int reader_id, String question_answer);
    
}
