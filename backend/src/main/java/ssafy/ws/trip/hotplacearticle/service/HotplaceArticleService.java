package ssafy.ws.trip.hotplacearticle.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import ssafy.ws.trip.config.PageNavigation;
import ssafy.ws.trip.hotplacearticle.dto.HotplaceArticleDto;

public interface HotplaceArticleService {
	void writeArticle(HotplaceArticleDto hotplaceArticleDto, MultipartFile file) throws Exception;
	List<HotplaceArticleDto> listArticle(Map<String, String> map) throws SQLException;
	int getTotalArticleCount(Map<String, Object> param) throws SQLException;
	HotplaceArticleDto getArticle(int articleNo) throws SQLException;
	void updateHit(int articleNo) throws SQLException;
	
	void modifyArticle(HotplaceArticleDto hotplaceArticleDto, MultipartFile file) throws Exception;
	void deleteArticle(int articleNo) throws SQLException;
	PageNavigation makePageNavigation(Map<String, String> map) throws Exception;
}
