package sec08.exam02;

//-----------------------------------------------
// 바깥(외부) 클래스: LoginController
// 실무에서 로그인 요청을 받아 처리하는 자리를 컨트롤러라고 부른다.
//-----------------------------------------------
class LoginController {
	
	//===================================================================
	// 정적 중첩 인터페이스: 로그인 결과 규칙 추상 메소드 제공
	//-------------------------------------------------------------------
	// "로그인 성공하면 onSuccess() 를, 실패하면 onFail() 을 실행한다" 는 규칙만 정한다.
	// 실제 구현 내용은 이 인터페이스를 구현하는 쪽(main 메소드의 익명 구현 객체)이 정한다.
	//===================================================================
	public static interface LoginListener {
		
		// 추상 메소드 1: 로그인 성공 시 실행할 동작. 매개변수로 성공한 아이디 전달받는다.
		void onSuccess(String userId);
			
		// 추상 메소드 2: 로그인 실패 시 실행할 동작. 매개변수로 실패 이유를 메세지로 전달받는다.
		void onFail(String reason);
	}
	
	//===========================================
	// 회원 정보(검사 기준값 정하자)
	//-------------------------------------------
	// 이 예제에서 가입된 회원이 1명이라고 가정하고 상수로 둔다.
	// 실무에서는 이 값을 데이터베이스에서 조회한다.
	//===========================================
	private static final String SAVED_ID = "hong";
	private static final String SAVED_PASSWORD = "1234";
	
	//======================================================
	// 인스턴스 변수: 등록된 로그인 결과 처리 객체의 주소를 저장
	//------------------------------------------------------
	// 자료형이 인터페이스(LoginListener)이므로,
	// 이 인터페이스를 구현한 어떤 객체든(익명 구현 객체 포함) 저장할 수 있다.
	//======================================================
	private LoginListener loginListener;
	
	//=========================
	// setter: 로그인 결과 처리 등록
	//=========================
	public void setLoginListener(LoginListener loginListener) {
		
		this.loginListener = loginListener;
	}
	
	//==================================================================================
	// Login() 메소드: 로그인 요청 처리
	//----------------------------------------------------------------------------------
	// 아이디와 비밀번호를 검사하고, 결과에 따라 등록된 익명 구현 객체의 onSuccess() 또는 onFail() 을 실행한다.
	//==================================================================================
	public void login(String id, String password) {// <- "hong", "1234"
												   // <- "hong", "9999"
												   // <- "park", "1234"
		
		// 웹 브라우저가 로그인 폼을 전송하면 서버에 이런 요청이 도착합니다.
		// "POST 는 데이터를 담아 보내는 요청 방식의 이름이다."
		System.out.println("[요청] POST / login id = " + id);
		
		// 검사1: 아이디가 가입된 회원의 아이디인지 확인
		// 문자열 비교는 == 이 아니라 equals() 를 사용한다.
		// 상수를 앞에 두면(SAVED_ID.equals(id)) id 가 null 이어도 오류가 나지 않는다.
		if(SAVED_ID.equals(id) == false) {
			
			// 실패 이유를 담아 onFail() 실행 -> 실제 내용은 등록된 익명 구현 객체가 결정
			this.loginListener.onFail("존재하지 않는 아이디입니다.");
			return; // 아래 검사를 하지 않고 즉시 login 메소드 종료
		}
		// 검사2: 비밀번호가 일치하는지 확인
		// -> 비밀번호를 제대로 입력하지 않았다면?
		if(SAVED_PASSWORD.equals(password) == false) {
			
			this.loginListener.onFail("존재하지 않는 비밀번호입니다.");
			return;
		}
		
		// 두 검사 모두 통과(DB 의 아이디, 비밀번호와 로그인 요청 시 입력한 아이디, 비밀번호가 모두 일치하면)
		// -> 로그인 입력한 아이디를 onSuccess() 메소드 호출할 때 매개변수로 전달
		this.loginListener.onSuccess(id);
	}// === login 메소드
}// --- LoginController 클래스


public class LoginExample {

	public static void main(String[] args) {
		
		//-------------------------
		// 순서1. 로그인 컨트롤러 객체 생성
		//-------------------------
		LoginController controller = new LoginController();
		
		//---------------------------------------
		// 순서2. 로그인 결과 처리를 하는 익명 구현 객체 등록
		//---------------------------------------
		controller.setLoginListener(new LoginController.LoginListener() {
			
			@Override
			public void onSuccess(String userId) {
				
				// 성공 응답: 실무에서는 메인 페이지로 이동시키는 응답을 보낸다.
				// 200 은 "요청 성고" 을 뜻하는 HTTP 상태 코드이다.
				System.out.println("[응답 200] 로그인 성공! " + userId + "님, 메인 페이지로 이동합니다.");
			}
			
			@Override
			public void onFail(String reason) {
				
				// 실패 응답: 실패 이유를 붙여 로그인 요청하는 페이지를 다시 보여준다.
				// 401 은 "인증 실패" 를 뜻하는 HTTP 상태 코드이다.
				System.out.println("[응답 401] 로그인 실패 - " + reason + "로그인 요청하는 페이지를 다시 표시합니다.");
			}
		});
		
		//----------------------
		// 순서3. 로그인 요청 3건 처리
		//----------------------
		// 로그인 요청1. 아이디와 비밀번호가 모두 DB(상수 2개의 값) 와 일치 -> onSuccess() 실행
		controller.login("hong", "1234");
		
		// 로그인 요청2. 아이디는 맞지만 비밀번호 틀림 -> onFail() 실행
		controller.login("hong", "9999");
		
		// 로그인 요청3. 가입되지 않은 아이디, 비밀번호 맞음 -> onFail() 실행
		controller.login("park", "1234");
		
	}// === main 메소드

}// --- LoginExample 클래스


