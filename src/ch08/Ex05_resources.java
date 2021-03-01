package ch08;

/*
 * ����� ���� ���ܸ� ����� �� ���� ���.
 * checked ���ܸ� ����� ������ Exception�� ��ӹް�,
 * unchecked ���ܸ� ����� ������ RuntimeException�� ��ӹ����� �ȴ�.
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
 * try-with-resource���� ���� �ڵ����� ��ü�� close�� ȣ��Ƿ���, Ŭ������ AutoCloseable �������̽���
 * �����ؾ��Ѵ�.
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
			cr.exceptionWork(false); // ���� �߻�x
		} catch (WorkException e) {
			e.printStackTrace();
		} catch (CloseException e) {
			e.printStackTrace();
		}
		System.out.println();

		try (CloseableResource cr = new CloseableResource()) {
			cr.exceptionWork(true); // ���� �߻� o
		} catch (WorkException e) {
			e.printStackTrace();
		} catch (CloseException e) {
			e.printStackTrace();
		}
	}

}
