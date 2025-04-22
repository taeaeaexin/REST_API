package com.mycom.myapp.lombok;

public class Test {

	public static void main(String[] args) {
		// Builder 패턴 적용
		EmpDto2 empDto2 = EmpDto2.builder()
							.employeeId(1)
							.firstName("태신")
							.lastName("문")
							.email("test@naver,com")
							.hireDate("2024-02-06")
							.departmentId("123")
							.build();
		
		System.out.println(empDto2);
		
		empDto2.getEmployeeId();
	}
}

// Emp <- Entity, EmpDto를 Emp와 별개로 만들어야 하는가?
// Entity와 별개의 Entity를 표현하는 Dto를 만드는게 일반적