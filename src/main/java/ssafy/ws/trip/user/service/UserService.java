package ssafy.ws.trip.user.service;

import ssafy.ws.trip.user.dto.UserDto;

public interface UserService {
	void joinUser(UserDto userDto) throws Exception;
	UserDto loginUser(String userId, String userPwd) throws Exception;
	UserDto getUserInfo(String userId) throws Exception;
	UserDto modifyUserInfo(UserDto userDto) throws Exception;
	void deleteUser(String userId) throws Exception;
}
