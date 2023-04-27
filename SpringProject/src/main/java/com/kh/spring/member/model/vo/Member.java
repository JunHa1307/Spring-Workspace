package com.kh.spring.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * - 자동 코드 생성 라이브러리
 * - 반복되는 getter, setter , toString 생성자 메소드 작성 등을 줄여주는 역할의 코드 라이브러리
 * 
 * lombok 설치 방법
 * 1. 라이브러리 다운 후 pom.xml 추가
 * 2. 다운로드된 jar 파일 찾아서 실행 (IDE 실행 중일 시 오류)
 * 3. IDE 재실행
 * 
 * lombok 사용 시 주의사항
 * - uName, bTitle과 같이 앞글자가 소문자외자인 필드명은 만들면 안된다
 * - 필드명 작성시 소문자 두들자 이상으로 시작해야함
 * - el 표기법 사용시 내부적으로 getter 메소드를 찾게 되는데 이 때 getuName(), getbTitle()이라는 이름으로 메소드를 호출하기 때문
 * 다른 프로젝트를 컴퓨터에 옮길 때 컴퓨터에서 먼저 lombok을 실행 시키자.
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드를 매개변수로 갖는 생성자
@Setter // setter 메서드 자동 생성
@Getter // getter 메서드 자동 생성
@ToString // ToString 자동생성
@EqualsAndHashCode // equals, hashcode 자동생성
@Data // 저기서부터 여기까지 다주세요
*/
@Setter // setter 메서드 자동 생성
@Getter // getter 메서드 자동 생성
@ToString // ToString 자동생성
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드를 매개변수로 갖는 생성자
@Builder // Member m = new Member.builder().address("추가할 값").userId("추가할 값").build();
public class Member {
	private int userNo;
	private String userId;
	private String userPwd;
	private String nickName;
	private String phone;
	private String address;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	private String profileImage;
}
