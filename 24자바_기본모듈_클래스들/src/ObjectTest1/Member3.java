package ObjectTest1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Member3 {// 회원 한 명의 정보가 저장되는 DTO 역할을 하는 클래스

	private int memberNo; // 회원 번호 -> getMemberNo(), setMemberNo(int)
	private String memberEmail; // 회원 이메일 -> getMemberEmail(), setMemberEmail(String)
	private String memberPw; // 회원 비밀번호
	private String memberNickName; // 회원 별명
	private String memberTel; // 회원 전화번호
	private String memberAddress; // 회원 주소
	private String profileImage; // 프로필 사진 파일 이름
	
}


