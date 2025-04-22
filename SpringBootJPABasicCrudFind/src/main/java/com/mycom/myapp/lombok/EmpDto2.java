package com.mycom.myapp.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//@NoArgsConstructor
//@AllArgsConstructor
// 생성자는 롬복 어노테이션과 실제 코드 중복되면 오류 발생
//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
// 생성자를 통해서 초기화되어야하는 final field를 위한 생성자
//@RequiredArgsConstructor
// 필요한 기본 어노테이션을 한꺼번에 합쳐서 사용하는 효과
@Data // @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor

// 생성자 대신 Builder 패턴을 사용하자는 흐름 + Lombok 자체가 생성자코드 눈에 보이지 않음
// builder 패턴을 이용하여 객체를 생성하는 방법 추천
@Builder
@Slf4j
public class EmpDto2 {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String hireDate;

	final String departmentId;
	
	public int getEmployeeId() {
		log.info("test log");
		return employeeId;
	}
	
//	public EmpDto2() {}
//	public EmpDto2(int employeeId, String firstName, String email, String hireDate) {
//		super();
//		this.employeeId = employeeId;
//		this.firstName = firstName;
//		this.email = email;
//		this.hireDate = hireDate;
//	}
}