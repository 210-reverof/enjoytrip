package ssafy.ws.trip.user.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssafy.ws.trip.user.dto.UserDto;
import ssafy.ws.trip.user.repository.UserRepository;

@Service
public class UserServiceMapperImpl implements UserService  {
	
	@Autowired
	private SqlSession session;

	@Override
	public void joinUser(UserDto userDto) throws Exception {
	}

	@Override
	public UserDto loginUser(String userId, String userPwd) throws Exception {
		return session.getMapper(UserRepository.class).selectOne(new UserDto(userId, userPwd)); 
	}

	@Override
	public UserDto getUserInfo(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDto modifyUserInfo(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
