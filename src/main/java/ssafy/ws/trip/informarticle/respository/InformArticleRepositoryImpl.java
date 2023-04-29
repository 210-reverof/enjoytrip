package ssafy.ws.trip.informarticle.respository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ssafy.ws.trip.informarticle.dto.InformArticleDto;

@Repository
public class InformArticleRepositoryImpl implements InformArticleRepository {

	@Override
	public void writeArticle(InformArticleDto informArticleDto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<InformArticleDto> listArticle() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalArticleCount(Map<String, Object> param) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public InformArticleDto getArticle(int articleNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyArticle(InformArticleDto InformArticleDto) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(int articleNo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
