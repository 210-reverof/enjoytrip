package ssafy.ws.trip.user.repository;

import java.sql.SQLException;
import java.util.List;

import ssafy.ws.trip.user.dto.UserDto;

public interface UserRepository {
	void joinUser(UserDto userDto) throws SQLException;
	UserDto loginUser(String userId, String userPwd) throws SQLException;
	UserDto getUserInfo(String userId) throws SQLException;
	UserDto modifyUserInfo(UserDto userDto) throws SQLException;
	void addRoute(String userid, int contentid, double latitude, double longitude) throws SQLException;
	void deleteRoute(String userid, int contentid) throws SQLException;
}
