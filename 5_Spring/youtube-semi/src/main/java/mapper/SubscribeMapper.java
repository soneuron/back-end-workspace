package mapper;

import org.apache.ibatis.annotations.Mapper;

import com.semi.youtube.model.vo.Subscribe;

@Mapper
public interface SubscribeMapper {

	Subscribe check(Subscribe vo); // 구독
	int count (int code); // 구독한 수
	void subs(Subscribe vo); 
	void cancel(int code); // 구독 취소
}
