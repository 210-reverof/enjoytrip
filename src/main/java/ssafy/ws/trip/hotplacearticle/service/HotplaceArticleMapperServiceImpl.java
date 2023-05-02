package ssafy.ws.trip.hotplacearticle.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ssafy.ws.trip.config.PageNavigation;
import ssafy.ws.trip.config.SizeConstant;
import ssafy.ws.trip.hotplacearticle.dto.HotplaceArticleDto;
import ssafy.ws.trip.hotplacearticle.repository.HotplaceArticleRepository;

@Service("HotplaceArticleMapperServiceImpl")
public class HotplaceArticleMapperServiceImpl implements HotplaceArticleService{

	@Autowired
	SqlSession session;
	
	@Override
	public void writeArticle(HotplaceArticleDto hotplaceArticleDto) throws SQLException {
		System.out.println("service writeArticle");
		session.getMapper(HotplaceArticleRepository.class).writeArticle(hotplaceArticleDto);
	}

	@Override
	public List<HotplaceArticleDto> listArticle(Map<String, String> map) throws SQLException {
		System.out.println("servivceImplTESt------------------");
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if("user_id".equals(key))
			key = "b.user_id";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int pgNo = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
		int start = pgNo * SizeConstant.LIST_SIZE - SizeConstant.LIST_SIZE;
		param.put("start", start);
		param.put("listsize", SizeConstant.LIST_SIZE);
		System.out.println("list paging :" + start + " , ");
		return session.getMapper(HotplaceArticleRepository.class).listArticle(param);
	}

	@Override
	public int getTotalArticleCount(Map<String, Object> param) throws SQLException {
		System.out.println("service getTotalArticleCount");
		return session.getMapper(HotplaceArticleRepository.class).getTotalArticleCount(param);
	}

	@Override
	public HotplaceArticleDto getArticle(int articleNo) throws SQLException {
		System.out.println("service getArticle");
		return session.getMapper(HotplaceArticleRepository.class).getArticle(articleNo);
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		System.out.println("service updateHit");
		session.getMapper(HotplaceArticleRepository.class).updateHit(articleNo);
	}

	@Override
	public void modifyArticle(HotplaceArticleDto hotplaceArticleDto) throws SQLException {
		System.out.println("service modifyArticle");
		session.getMapper(HotplaceArticleRepository.class).modifyArticle(hotplaceArticleDto);
	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		System.out.println("service deleteArticle");
		session.getMapper(HotplaceArticleRepository.class).deleteArticle(articleNo);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		System.out.println("service makePageNavigation");
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = SizeConstant.NAVIGATION_SIZE;
		int sizePerPage = SizeConstant.LIST_SIZE;
		int currentPage = Integer.parseInt(map.get("pgno"));

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		if ("user_id".equals(key))
			key = "user_id";
		param.put("key", key == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : map.get("word"));
		int totalCount = session.getMapper(HotplaceArticleRepository.class).getTotalArticleCount(param);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		
		return pageNavigation;
	}
	

}

