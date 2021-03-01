package ch08;

/*
 * 사용자 정의 예외를 만드는 두 가지 방법.
 * checked 예외를 만들고 싶으면 Exception을 상속받고,
 * unchecked 예외를 만들고 싶으면 RuntimeException을 상속받으면 된다.
 * */
class WorkException extends Exception {
	private static final long serialVersionUID = 1L;

	WorkException(String msg) {
		super(msg);
	}
}

class CloseException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	CloseException(String msg) {
		super(msg);
	}
}

/*
 * try-with-resource문에 의해 자동으로 객체의 close가 호출되려면, 클래스가 AutoCloseable 인터페이스를
 * 구현해야한다.
 */
class CloseableResource implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("The close function is invoked.");
		throw new CloseException("CloseException is occured.");
	}

	public void exceptionWork(boolean exception) throws WorkException {
		System.out.println("exceptionWork(" + exception + ") is invoked.");
		if (exception) {
			throw new WorkException("WorkException is occured.");
		}
	}
}

class Ex05_resources {

	public static void main(String[] args) throws Exception {

		try (CloseableResource cr = new CloseableResource()) {
			cr.exceptionWork(false); // 예외 발생x
		} catch (WorkException e) {
			e.printStackTrace();
		} catch (CloseException e) {
			e.printStackTrace();
		}
		System.out.println();

		try (CloseableResource cr = new CloseableResource()) {
			cr.exceptionWork(true); // 예외 발생 o
		} catch (WorkException e) {
			e.printStackTrace();
		} catch (CloseException e) {
			e.printStackTrace();
		}
	}

}
