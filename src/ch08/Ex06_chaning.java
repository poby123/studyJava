package ch08;

@SuppressWarnings("serial")
class InstallException extends Exception {
	InstallException(String msg) {
		super(msg);
	}
}

@SuppressWarnings("serial")
class SpaceException extends Exception {
	SpaceException(String msg) {
		super(msg);
	}
}

@SuppressWarnings("serial")
class MemoryException extends Exception {
	MemoryException(String msg) {
		super(msg);
	}
}

class Ex06_chaning {
	public static void main(String[] args) {
		try {
			install();
		} catch (InstallException e) {
			e.printStackTrace();
		}
	}

	static void install() throws InstallException {
		try {
			startInstall();
			copyFiles();
		} catch (SpaceException e) {
			InstallException ie = new InstallException("The error is occured during install.");
			ie.initCause(e); // SpaceException을 InstallException의 원인 예외로 등록한다.
			throw ie;
		} catch (MemoryException e) {
			InstallException ie = new InstallException("The error is occured during install.");
			ie.initCause(e); // MemoryException을 InstallException의 원인 예외로 등록한다.
			throw ie;
		} finally {
			deleteTempFiles();
		}
	}

	static void startInstall() throws SpaceException, MemoryException {
		if (!enoughSpace()) {
			throw new SpaceException("There is not enough space to install.");
		}

		if (!enoughMemory()) {
			throw new MemoryException("There is not enough memory to install.");
		}
	}

	static void copyFiles() {
		/* some work */
	}

	static void deleteTempFiles() {
		/* some work */
	}

	static boolean enoughSpace() {
		/* some work to check space */
		return true;
	}

	static boolean enoughMemory() {
		/* some work to check memory */
		return false;
	}
}
