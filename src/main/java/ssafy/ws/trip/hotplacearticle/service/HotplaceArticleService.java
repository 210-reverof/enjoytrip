package ssafy.ws.trip.hotplacearticle.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import ssafy.ws.trip.config.PageNavigation;
import ssafy.ws.trip.hotplacearticle.dto.HotplaceArticleDto;

public interface HotplaceArticleService {
	void writeArticle(HotplaceArticleDto hotplaceArticleDto) throws SQLException;
	List<HotplaceArticleDto> listArticle(Map<String, String> map) throws SQLException;
	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	HotplaceArticleDto getArticle(int articleNo) throws SQLException;
	void updateHit(int articleNo) throws SQLException;
	
	void modifyArticle(HotplaceArticleDto hotplaceArticleDto) throws SQLException;
	void deleteArticle(int articleNo) throws SQLException;
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
}
