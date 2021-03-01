package ch08;

public class Ex02_Multicatch {

	public static void main(String[] args) {

		try {
			throw new IllegalArgumentException("This is IllegalArgument exception.");
//			throw new IllegalStateException("This is IllegalState exception.");
		}

		/* 
		 * IllegalArgumentException 또는 IllegalStateException를 모두 처리할 수 있다.
		 * catch 에 들어가는 예외는 조상-자손 관계가 아니어야한다.
		 * 조상-자손 관계면 그냥 조상 예외를 적으면 되기 때문이다.
		*/
		catch (IllegalArgumentException | IllegalStateException ile) {
			System.out.println(ile.getMessage());
		}

	}

}
