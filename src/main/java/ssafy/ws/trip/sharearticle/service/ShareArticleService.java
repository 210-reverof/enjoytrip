package ssafy.ws.trip.sharearticle.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import ssafy.ws.trip.config.PageNavigation;
import ssafy.ws.trip.sharearticle.dto.ShareArticleDto;

public interface ShareArticleService {
	void writeArticle(ShareArticleDto shareArticleDto) throws SQLException;
	List<ShareArticleDto> listArticle(Map<String, String> map) throws SQLException;
	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	ShareArticleDto getArticle(int articleNo) throws SQLException;
	void updateHit(int articleNo) throws SQLException;
	
	void modifyArticle(ShareArticleDto shareArticleDto) throws SQLException;
	void deleteArticle(int articleNo) throws SQLException;
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
}
